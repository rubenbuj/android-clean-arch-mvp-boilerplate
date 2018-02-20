package com.altv.dugout_domain.use_cases;

import com.altv.dugout_domain.executor.PostExecutionThread;
import com.altv.dugout_domain.executor.ThreadExecutor;
import com.altv.dugout_domain.model.News;
import com.altv.dugout_domain.repositories.INewsRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by rubenbujalance on 12/02/2018.
 */

public class GetNewsDetailUseCase extends UseCase<News, GetNewsDetailUseCase.Params> {

    INewsRepository newsRepository;

    @Inject
    GetNewsDetailUseCase(INewsRepository newsRepository, ThreadExecutor threadExecutor,
                         PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.newsRepository = newsRepository;
    }

    @Override
    Observable<News> buildUseCaseObservable(Params params) {
        return newsRepository.newsDetail(params.newsId);
    }

    public static final class Params {
        private final String newsId;

        private Params(String newsId) {
            this.newsId = newsId;
        }

        public static Params forNewsId(String userId) {
            return new Params(userId);
        }
    }
}
