package com.altv.dugoutapp.state_machines;

import android.util.Log;

import com.altv.dugout_domain.executor.ThreadExecutor;
import com.altv.dugoutapp.AndroidApplication;
import com.bluelinelabs.conductor.Router;

import javax.inject.Inject;

import au.com.ds.ef.FlowBuilder;
import au.com.ds.ef.StateEnum;
import au.com.ds.ef.call.ContextHandler;

import static au.com.ds.ef.FlowBuilder.on;

/**
 * Created by rubenbujalance on 29/01/2018.
 */

public class MainStateMachine extends StateMachine {

    public MainStateMachine(Router router) {
        super(router);
    }

    public enum States implements StateEnum {
        TOP_TRENDING_FLOW,
        LOGIN_FLOW,
    }

    /*
    Flow context
     */

    private class FlowContext extends AltvContext {
        //Add all desired attributes to be used by the State Machine
    }

    @Override
    AltvContext getContextInstance() {
        return new FlowContext();
    }

    /*
    Build flow
     */

    @Override
    void loadFlowDefinition() {
        flow = FlowBuilder
                .from(States.TOP_TRENDING_FLOW).transit(
                        on(Events.goToLogin).to(States.LOGIN_FLOW).transit(
                                on(Events.goBack).to(States.TOP_TRENDING_FLOW))
                );
    }

    @Override
    void loadFlowBehaviour() {
        flow.whenEnter(States.TOP_TRENDING_FLOW, new ContextHandler<AltvContext>() {
            @Override
            public void call(AltvContext context) throws Exception {
                // Control for avoiding to push a new controller, since it is already in the backstack
                if(flowContext.getLastEvent() == Events.goBack) {
                    return;
                }

                // Let's start the TopTrending flow
                try {
                    new TopTrendingStateMachine(router);
                } catch (Exception ex) {
                    Log.e(TAG, ex.getMessage());
                }
            }
        });
    }
}
