package com.altv.dugoutapp.di.components;

import android.os.Bundle;

import com.altv.dugoutapp.di.modules.ControllerModule;
import com.altv.dugoutapp.mvp.BaseView;
import com.hannesdorfmann.mosby3.conductor.viewstate.MvpViewStateController;

import dagger.Component;

/**
 * Created by rubenbujalance on 13/02/2018.
 */

@PerScreen
@Component(dependencies = ApplicationComponent.class, modules = ControllerModule.class)
public interface ControllerComponent {
    //Exposed to sub-graphs.
    MvpViewStateController view();
    Bundle args();
}
