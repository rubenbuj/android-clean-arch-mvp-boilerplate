package com.altv.dugoutapp.news_detail;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.altv.dugout_domain.model.News;
import com.altv.dugoutapp.Params;
import com.altv.dugoutapp.mvp.BasePresenter;
import com.altv.dugoutapp.state_machines.StateMachine;

/**
 * Created by rubenbujalance on 01/02/2018.
 */

public class NewsDetailPresenter extends BasePresenter<INewsDetailView> implements INewsDetailPresenter<INewsDetailView> {

    /*
    Contructors
     */

    public NewsDetailPresenter(StateMachine stateMachineHandler, Bundle args) {
        super(stateMachineHandler, args);
    }

    /*
    Presenter methods
     */

    @Override
    public void attachView(INewsDetailView view) {
        super.attachView(view);
        initialiseData();
    }

    /*
    Others
     */

    public void initialiseData() {
        if (!getArgs().containsKey(Params.TOP_TRENDING_SELECTED_NEWS)) {
            ifViewAttached(new ViewAction<INewsDetailView>() {
                @Override
                public void run(@NonNull INewsDetailView view) {
                    view.showError(TAG, "Error getting selected item", new IllegalStateException("Context args do not contain selected item"));
                }
            });
        }
        else {
            final News news = (News) getArgs().getSerializable(Params.TOP_TRENDING_SELECTED_NEWS);
            ifViewAttached(new ViewAction<INewsDetailView>() {
                @Override
                public void run(@NonNull INewsDetailView view) {
                    view.setFields(news);
                }
            });
        }
    }
}
