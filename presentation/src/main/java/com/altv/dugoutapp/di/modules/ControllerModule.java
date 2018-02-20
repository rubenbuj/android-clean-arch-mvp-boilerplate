package com.altv.dugoutapp.di.modules;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.altv.dugoutapp.di.components.PerScreen;
import com.altv.dugoutapp.mvp.BaseView;
import com.hannesdorfmann.mosby3.conductor.viewstate.MvpViewStateController;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rubenbujalance on 13/02/2018.
 */

@Module
public class ControllerModule {
    private final MvpViewStateController view;

    public ControllerModule(MvpViewStateController view) {
        this.view = view;
    }

    @Provides
    @PerScreen
    MvpViewStateController view() {
        return this.view;
    }

    @Provides
    @PerScreen
    Bundle args() {
        return this.view.getArgs();
    }

    @Provides
    @PerScreen
    AppCompatActivity activity() {
        return (AppCompatActivity)this.view.getActivity();
    }
}
