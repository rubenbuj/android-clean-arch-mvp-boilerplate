package com.altv.dugoutapp.trending_list;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.altv.dugout_domain.model.News;
import com.altv.dugout_domain.use_cases.GetNewsDetailUseCase;
import com.altv.dugout_domain.use_cases.GetNewsListUseCase;
import com.altv.dugoutapp.AndroidApplication;
import com.altv.dugoutapp.Params;
import com.altv.dugoutapp.di.components.ApplicationComponent;
import com.altv.dugoutapp.mvp.BasePresenter;
import com.altv.dugoutapp.mvp.BaseView;
import com.altv.dugoutapp.state_machines.StateMachine;

import java.util.List;

import javax.inject.Inject;

import au.com.ds.ef.err.LogicViolationError;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by rubenbujalance on 01/02/2018.
 */

public class TrendingListPresenter extends BasePresenter<ITrendingListView> implements ITrendingListPresenter<ITrendingListView> {

    @Inject GetNewsListUseCase getNewsListUseCase;
    @Inject GetNewsDetailUseCase getNewsDetailUseCase;

    enum State {
        INIT, LIST, ERROR
    }

    State state = State.INIT;
    List<News> data;

    /*
    Contructors
     */

    public TrendingListPresenter(StateMachine stateMachineHandler, Bundle args) {
        super(stateMachineHandler, args);
    }

    /*
    BasePresenter methods
     */

    @Override
    public void itemClicked(int position) {
        navigateToDetail(position);
    }

    @Override
    public void attachView(ITrendingListView view) {
        super.attachView(view);

        // Initialise injection
        ifViewAttached(new ViewAction<ITrendingListView>() {
            @Override
            public void run(@NonNull ITrendingListView view) {
                ApplicationComponent applicationComponent =
                        ((AndroidApplication)((BaseView)view).getActivity().getApplication()).getApplicationComponent();

                applicationComponent.inject(TrendingListPresenter.this);
            }
        });
    }

    @Override
    public void destroy() {
        super.destroy();
        getNewsListUseCase.dispose();
    }

    /*
    Others
     */

    @Override
    public void initialiseData() {
        getNewsListUseCase.execute(new DisposableObserver<List<News>>() {
            @Override
            public void onNext(final List<News> newsList) {
                ifViewAttached(new ViewAction<ITrendingListView>() {
                    @Override
                    public void run(@NonNull ITrendingListView view) {
                        view.setListData(newsList);
                        data = newsList;
                        state = State.LIST;
                    }
                });
            }

            @Override
            public void onError(final Throwable e) {
                state = State.ERROR;
                ifViewAttached(new ViewAction<ITrendingListView>() {
                    @Override
                    public void run(@NonNull ITrendingListView view) {
                        view.showError(TAG, "Error getting 'Latest' playlist", e);
                    }
                });
            }

            @Override
            public void onComplete() {}
        }, null);
    }

    private void navigateToDetail(int position) {
        if(state != State.LIST) {
            ifViewAttached(new ViewAction<ITrendingListView>() {
                @Override
                public void run(@NonNull ITrendingListView view) {
                    view.showError(TAG, "News list not loaded yet", null);
                }
            });
            return;
        }

        try {
            getStateMachine().getContext().args().putSerializable(Params.TOP_TRENDING_SELECTED_NEWS, data.get(position));
            getStateMachine().fireEvent(StateMachine.Events.listItemClick);
        } catch (final LogicViolationError ex) {
            ifViewAttached(new ViewAction<ITrendingListView>() {
                @Override
                public void run(@NonNull ITrendingListView view) {
                    view.showError(TAG, "Error loading detail screen: "+ex.getMessage(), ex);
                }
            });
        }
    }
}
