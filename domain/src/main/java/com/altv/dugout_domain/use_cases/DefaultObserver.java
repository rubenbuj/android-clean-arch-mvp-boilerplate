package com.altv.dugout_domain.use_cases;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by rubenbujalance on 13/02/2018.
 */

public class DefaultObserver extends DisposableObserver {
    @Override
    public void onNext(Object o) {
        //no default implementation
    }

    @Override
    public void onError(Throwable e) {
        //no default implementation
    }

    @Override
    public void onComplete() {
        //no default implementation
    }
}
