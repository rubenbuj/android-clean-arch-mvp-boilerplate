package com.altv.dugoutapp.di.modules;

import android.content.Context;

import com.altv.dugout_data.data.NewsRepository;
import com.altv.dugout_domain.executor.PostExecutionThread;
import com.altv.dugout_domain.executor.ThreadExecutor;
import com.altv.dugout_domain.repositories.INewsRepository;
import com.altv.dugoutapp.AndroidApplication;
import com.altv.dugoutapp.executor.JobExecutor;
import com.altv.dugoutapp.executor.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rubenbujalance on 13/02/2018.
 */

@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

//    @Provides @Singleton
//    StateMachine provideStateMachine() {
//        return new StateMachine();
//    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

//    @Provides @Singleton
//    UserCache provideUserCache(UserCacheImpl userCache) {
//        return userCache;
//    }

    @Provides @Singleton
    INewsRepository provideNewsRepository(NewsRepository newsRepository) {
        return newsRepository;
    }
}
