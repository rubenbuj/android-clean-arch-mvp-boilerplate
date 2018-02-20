package com.altv.dugoutapp.mvp;

import android.os.Bundle;

import com.altv.dugoutapp.state_machines.StateMachine;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import au.com.ds.ef.err.LogicViolationError;

/**
 * Created by rubenbujalance on 01/02/2018.
 */

public abstract class BasePresenter<V extends IBaseView> extends MvpBasePresenter<V> implements IBasePresenter<V> {

    public final String TAG = this.getClass().getSimpleName();

    private StateMachine stateMachineHandler;
    private Bundle args;

    public BasePresenter(StateMachine stateMachineHandler, Bundle args) {
        this.stateMachineHandler = stateMachineHandler;
        this.args = args;
    }

    @Override
    public void goBack() {
        try {
            stateMachineHandler.fireEvent(StateMachine.Events.goBack);
        } catch (LogicViolationError ex) {

        }
    }

    protected StateMachine getStateMachine() {
        return stateMachineHandler;
    }

    protected Bundle getArgs() {
        return args;
    }
}
