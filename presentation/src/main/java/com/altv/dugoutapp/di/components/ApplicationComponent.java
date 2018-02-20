package com.altv.dugoutapp.di.components;

import android.app.Activity;
import android.content.Context;

import com.altv.dugout_domain.executor.PostExecutionThread;
import com.altv.dugout_domain.executor.ThreadExecutor;
import com.altv.dugout_domain.repositories.INewsRepository;
import com.altv.dugoutapp.di.modules.ApplicationModule;
import com.altv.dugoutapp.mvp.BasePresenter;
import com.altv.dugoutapp.mvp.BaseView;
import com.altv.dugoutapp.mvp.IBaseView;
import com.altv.dugoutapp.news_detail.NewsDetailView;
import com.altv.dugoutapp.state_machines.StateMachine;
import com.altv.dugoutapp.trending_list.TrendingListPresenter;
import com.altv.dugoutapp.trending_list.TrendingListView;
import com.hannesdorfmann.mosby3.conductor.viewstate.MvpViewStateController;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rubenbujalance on 13/02/2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(TrendingListPresenter presenter);
    void inject(StateMachine stateMachine);

    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    INewsRepository newsRepository();

}
