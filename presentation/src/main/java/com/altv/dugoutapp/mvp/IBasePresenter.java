package com.altv.dugoutapp.mvp;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

/**
 * Created by rubenbujalance on 01/02/2018.
 */

public interface IBasePresenter<V extends IBaseView> extends MvpPresenter<V> {
    void goBack();
}
