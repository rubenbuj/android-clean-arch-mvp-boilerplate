package com.altv.dugoutapp.state_machines;

import com.altv.dugout_domain.executor.ThreadExecutor;
import com.altv.dugoutapp.AndroidApplication;
import com.altv.dugoutapp.di.components.ApplicationComponent;
import com.altv.dugoutapp.news_detail.NewsDetailView;
import com.altv.dugoutapp.trending_list.TrendingListView;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;

import javax.inject.Inject;

import au.com.ds.ef.FlowBuilder;
import au.com.ds.ef.StateEnum;
import au.com.ds.ef.call.ContextHandler;

import static au.com.ds.ef.FlowBuilder.on;

/**
 * Created by rubenbujalance on 29/01/2018.
 */

public class TopTrendingStateMachine extends StateMachine {

    public enum States implements StateEnum {
        NEWS_LIST_SCREEN,
        NEWS_DETAIL_SCREEN,
    }

    public TopTrendingStateMachine(Router router) {
        super(router);
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
                .from(States.NEWS_LIST_SCREEN).transit(
                        on(Events.listItemClick).to(States.NEWS_DETAIL_SCREEN).transit(
                                on(Events.goBack).to(States.NEWS_LIST_SCREEN)
                        )
                );
    }

    @Override
    void loadFlowBehaviour() {
        flow.whenEnter(States.NEWS_LIST_SCREEN, new ContextHandler<FlowContext>() {
            @Override
            public void call(FlowContext context) throws Exception {
                // Control for avoiding to push a new controller when going back
                //
                if(flowContext.getLastEvent()== Events.goBack) {
                    return;
                }

                // In case this is the first screen, let's put Trending List as the root controller
                if (!router.hasRootController()) {
                    router.setRoot(RouterTransaction.with(new TrendingListView(TopTrendingStateMachine.this, context.args())));
                }
                // Otherwise, let's push it
                else {
                    router.pushController(RouterTransaction.with(
                            new TrendingListView(TopTrendingStateMachine.this, context.args()))
                    );
                }
            }
        });

        flow.whenEnter(States.NEWS_DETAIL_SCREEN, new ContextHandler<FlowContext>() {
            @Override
            public void call(FlowContext context) throws Exception {
                router.pushController(RouterTransaction.with(
                        new NewsDetailView(TopTrendingStateMachine.this, context.args()))
                );
            }
        });
    }
}
