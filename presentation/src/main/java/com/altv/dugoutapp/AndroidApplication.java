package com.altv.dugoutapp;

import android.app.Application;

import com.altv.dugoutapp.di.components.ApplicationComponent;
import com.altv.dugoutapp.di.components.DaggerApplicationComponent;
import com.altv.dugoutapp.di.modules.ApplicationModule;

/**
 * Created by rubenbujalance on 12/02/2018.
 */

public class AndroidApplication extends Application {

    private static AndroidApplication instance;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidApplication.instance = this;

        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent =  DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static AndroidApplication getInstance() {
        return instance;
    }
}
