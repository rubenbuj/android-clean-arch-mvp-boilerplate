package com.altv.dugoutapp.di.components;

import com.altv.dugoutapp.di.modules.ControllerModule;
import com.altv.dugoutapp.di.modules.NewsModule;
import com.altv.dugoutapp.news_detail.NewsDetailView;
import com.altv.dugoutapp.trending_list.TrendingListView;

import dagger.Component;

/**
 * Created by rubenbujalance on 14/02/2018.
 */

@PerScreen
@Component(dependencies = ApplicationComponent.class, modules = {ControllerModule.class, NewsModule.class})
public interface NewsComponent extends ControllerComponent {
    void inject(TrendingListView trendingListView);
    void inject(NewsDetailView newsDetailView);
}
