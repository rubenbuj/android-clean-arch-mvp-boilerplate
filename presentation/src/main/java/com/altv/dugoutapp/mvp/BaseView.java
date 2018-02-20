package com.altv.dugoutapp.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.altv.dugoutapp.Utils;
import com.altv.dugoutapp.state_machines.StateMachine;
import com.hannesdorfmann.mosby3.conductor.viewstate.MvpViewStateController;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;

/**
 * Created by rubenbujalance on 30/01/2018.
 */

public abstract class BaseView<V extends IBaseView, P extends IBasePresenter<V>, S extends ViewState<V>> extends MvpViewStateController<V, P, S> implements IBaseView {

    public final String TAG = this.getClass().getSimpleName();

    private StateMachine stateMachine;

    /*
    Constructors
     */

    public BaseView() {
        throw new IllegalArgumentException("State machine parameter is mandatory");
    }

    public BaseView(StateMachine stateMachineHandler, Bundle args) {
        super(args);
        this.stateMachine = stateMachineHandler;
    }

    /*
    IBaseView methods
     */

    @Override
    public void showError(String TAG, String message, Throwable e) {
        Utils.print(getActivity(), TAG, message, e);
    }

    /*
    MvpViewStateController methods
     */

    @Override
    public boolean handleBack() {
        getPresenter().goBack();
        return true;
    }

    @NonNull
    @Override
    public P createPresenter() {
        return (P)MvpFactory.getInstance().getPresenter(this, this.stateMachine, getArgs());
    }

    @NonNull
    @Override
    public S createViewState() {
        return (S)new ViewState<V>() {
            @Override
            public void apply(V view, boolean retained) {}
        };
    }

    @Override
    public void onNewViewStateInstance() {}

    @Override
    public void onViewStateInstanceRestored(boolean instanceStateRetained) {}
}
