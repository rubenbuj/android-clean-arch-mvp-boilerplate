package com.altv.dugoutapp.executor;

import com.altv.dugout_domain.executor.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by rubenbujalance on 13/02/2018.
 */

/**
 * Implementation of the PostExecutionThread defined in the domain module, for the UI thread
 */
@Singleton
public class UIThread implements PostExecutionThread {

    @Inject
    UIThread() {}

    @Override public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
