package com.altv.dugoutapp.mvp;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by rubenbujalance on 01/02/2018.
 */

public interface IBaseView extends MvpView {
    void showError(String tag, String message, Throwable e);
}
