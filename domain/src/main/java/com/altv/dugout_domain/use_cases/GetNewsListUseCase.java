package com.altv.dugout_domain.use_cases;

import com.altv.dugout_domain.executor.PostExecutionThread;
import com.altv.dugout_domain.executor.ThreadExecutor;
import com.altv.dugout_domain.model.News;
import com.altv.dugout_domain.repositories.INewsRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by rubenbujalance on 12/02/2018.
 */

@Singleton
public class GetNewsListUseCase extends UseCase<List<News>, Void> {

    INewsRepository newsRepository;

    @Inject
    GetNewsListUseCase(INewsRepository newsRepository, ThreadExecutor threadExecutor,
                       PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.newsRepository = newsRepository;
    }

    @Override
    Observable<List<News>> buildUseCaseObservable(Void aVoid) {
        return this.newsRepository.newsList();
    }
}
