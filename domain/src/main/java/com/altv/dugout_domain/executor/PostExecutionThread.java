package com.altv.dugout_domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by rubenbujalance on 13/02/2018.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
