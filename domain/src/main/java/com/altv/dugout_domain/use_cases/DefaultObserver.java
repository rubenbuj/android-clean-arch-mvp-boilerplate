package com.altv.dugout_domain.use_cases;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by rubenbujalance on 13/02/2018.
 */

public class DefaultObserver<T> extends DisposableObserver<T> {
    @Override
    public void onNext(T o) {
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
