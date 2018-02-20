package com.altv.dugoutapp;

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

    public static MvpPresenter getPresenterInstance(MvpView view, StateMachine stateMachineHandler, Bundle args) {
        if(view instanceof ITrendingListView) {
            return new TrendingListPresenter(stateMachineHandler, args);
        }
        else if(view instanceof INewsDetailView) {
            return new NewsDetailPresenter(stateMachineHandler, args);
        }

        return null;
    }
}
