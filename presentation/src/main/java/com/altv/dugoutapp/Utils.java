package com.altv.dugoutapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Toast;

import java.lang.reflect.Method;


public class Utils {

    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static boolean isPhone(Context context) {
        return !isTablet(context);
    }

    public static boolean isTablet(Context context) {
        boolean isTablet = context != null && (context.getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
//        System.out.println("isTablet "+isTablet);
        return isTablet;
    }

    public static int getAspectRatioWidthFor90Height(Context context) {
        return  (int)(getAspectRatio(context)*90);
    }
    public static boolean aspectRatioGreaterThan16x9(Context context) {
        return getAspectRatio(context)>(16f/9f)+0.01f;
    }
    public static float getAspectRatio(Context context) {
        Point p = getScreenResolution(context);
        System.out.println("force temp screen resolution "+p.x+":"+p.y);
        return Math.max(p.x/(float)p.y, p.y/(float)p.x);
    }
    public int getScreenWidth(Context context) {
        return getScreenResolution(context).x;
    }
    public int getScreenHeight(Context context) {
        return getScreenResolution(context).y;
    }
    private static Point getScreenResolution(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        Display display = manager.getDefaultDisplay();
        Point point = new Point();
//        display.getSize(point);


        Display display = manager.getDefaultDisplay();
        int realWidth;
        int realHeight;

        if (Build.VERSION.SDK_INT >= 17){
            //new pleasant way to get real metrics
            DisplayMetrics realMetrics = new DisplayMetrics();
            display.getRealMetrics(realMetrics);
            realWidth = realMetrics.widthPixels;
            realHeight = realMetrics.heightPixels;

        } else if (Build.VERSION.SDK_INT >= 14) {
            //reflection for this weird in-between time
            try {
                Method mGetRawH = Display.class.getMethod("getRawHeight");
                Method mGetRawW = Display.class.getMethod("getRawWidth");
                realWidth = (Integer) mGetRawW.invoke(display);
                realHeight = (Integer) mGetRawH.invoke(display);
            } catch (Exception e) {
                //this may not be 100% accurate, but it's all we've got
                realWidth = display.getWidth();
                realHeight = display.getHeight();
//                Log.e("Display Info", "Couldn't use reflection to get the real display metrics.");
            }

        } else {
            //This should be close, as lower API devices should not have window navigation bars
            realWidth = display.getWidth();
            realHeight = display.getHeight();
        }
        point.set(realWidth, realHeight);
        return point;
    }
    public static int getScreenWithDp(Context context) {
        return (int)convertPixelsToDp(getScreenResolution(context).x, context);
    }
    private static float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
    public static float convertDpToPixels(float dp, Context context) {
        Resources r = context.getResources();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }

    public static void expandDP(final View v, int dp) {
        final int targetHeight = (int)convertDpToPixels(dp, v.getContext());

        if(v.getLayoutParams().height == targetHeight) {
            v.setVisibility(View.VISIBLE);
            return;
        }
        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? targetHeight
                        : (int)(targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration(80);
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        if(v.getVisibility() == View.GONE) {
            return;
        }
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(interpolatedTime == 1){
                    v.setVisibility(View.GONE);
                }else{
                    v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration(100);
        v.startAnimation(a);
    }

    public static void print(final Activity activity, String TAG, final String message, Throwable e) {
        if(e==null) {
            Log.e(TAG, message);
        }
        else {
            Log.e(TAG, message, e);
        }

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    public static void print(final Activity activity, String TAG, final String message) {
        print(activity, TAG, message, null);
    }
}
