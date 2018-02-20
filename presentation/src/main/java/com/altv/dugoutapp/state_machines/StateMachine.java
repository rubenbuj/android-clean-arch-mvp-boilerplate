package com.altv.dugoutapp.state_machines;

import android.os.Bundle;

import com.altv.dugoutapp.AndroidApplication;
import com.altv.dugoutapp.Utils;
import com.altv.dugoutapp.di.components.DaggerApplicationComponent;
import com.altv.dugoutapp.di.modules.ApplicationModule;
import com.altv.dugoutapp.executor.UiThreadExecutor;
import com.bluelinelabs.conductor.Router;

import au.com.ds.ef.EasyFlow;
import au.com.ds.ef.EventEnum;
import au.com.ds.ef.StatefulContext;
import au.com.ds.ef.call.ContextHandler;
import au.com.ds.ef.call.ExecutionErrorHandler;
import au.com.ds.ef.err.ExecutionError;
import au.com.ds.ef.err.LogicViolationError;

/**
 * Created by rubenbujalance on 30/01/2018.
 */

public abstract class StateMachine {

    final String TAG = this.getClass().getSimpleName();

    Router router;
    EasyFlow<AltvContext> flow;
    AltvContext flowContext;

    public StateMachine(final Router router) {
        this.router = router;

        // Initialise dependency injection
        DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(AndroidApplication.getInstance()))
                .build()
                .inject(this);

        initFlow();
        bindFlow();
        flowContext = getContextInstance();

        flow.start(true, flowContext);
    }

    /*
    Altv Context
     */

    public class AltvContext extends StatefulContext {
        private Bundle args = new Bundle(); // Parameter to send arguments to through the flow

        public Bundle args() {
            return args;
        }
    }

    /*
    Abstract methods
     */

    abstract void loadFlowDefinition();
    abstract void loadFlowBehaviour();
    abstract AltvContext getContextInstance();

    /*
    Build flow
     */

    void initFlow() {
        if (flow != null) {
            return;
        }
        loadFlowDefinition();
        flow.executor(new UiThreadExecutor());
    }

    void bindFlow() {
        loadFlowBehaviour();

        flow.whenEvent(Events.goBack, new ContextHandler<AltvContext>() {
            @Override
            public void call(AltvContext context) throws Exception {
                // This pops the last controller from the backstack
                router.popCurrentController();
            }
        });

        flow.whenError(new ExecutionErrorHandler<AltvContext>() {
            @Override
            public void call(ExecutionError error, AltvContext context) {
                Utils.print(router.getActivity(), TAG, "Error during StateMachine flow: "+error.getMessage(), error);
            }
        });
    }

    /*
    Working methods
     */

    public void fireEvent(EventEnum event) throws LogicViolationError {
        flow.trigger(event, flowContext);
    }

    public AltvContext getContext() {
        return flowContext;
    }

    /*
    Events
     */

    public enum Events implements EventEnum {
        goToLogin,
        listItemClick,
        goBack,
    }
}
