package com.altv.dugoutapp.mvp;

import android.os.Bundle;

import com.altv.dugoutapp.news_detail.NewsDetailPresenter;
import com.altv.dugoutapp.trending_list.TrendingListPresenter;
import com.altv.dugoutapp.state_machines.StateMachine;
import com.altv.dugoutapp.news_detail.INewsDetailView;
import com.altv.dugoutapp.trending_list.ITrendingListView;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by rubenbujalance on 06/02/2018.
 */

public class MvpFactory {

    static MvpFactory instance;

    public static MvpFactory getInstance() {
        if(instance==null) instance = new MvpFactory();

        return instance;
    }

    private MvpFactory() {}

    public MvpPresenter getPresenter(MvpView view, StateMachine stateMachineHandler, Bundle args) {
        if(view instanceof ITrendingListView) {
            return new TrendingListPresenter(stateMachineHandler, args);
        }
        else if(view instanceof INewsDetailView) {
            return new NewsDetailPresenter(stateMachineHandler, args);
        }

        return null;
    }
}
