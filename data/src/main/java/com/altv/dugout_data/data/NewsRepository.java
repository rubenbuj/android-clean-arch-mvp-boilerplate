package com.altv.dugout_data.data;

import com.altv.dugout_data.mapper.ApiDataModelMapper;
import com.altv.dugout_data.model.PlaylistContainer;
import com.altv.dugout_data.network.NewsApiDataSource;
import com.altv.dugout_domain.model.News;
import com.altv.dugout_domain.repositories.INewsRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by rubenbujalance on 16/02/2018.
 */

@Singleton
public class NewsRepository implements INewsRepository {

    NewsApiDataSource newsApiDataSource;
    ApiDataModelMapper apiDataModelMapper;

    @Inject
    NewsRepository(NewsApiDataSource newsApiDataSource, ApiDataModelMapper apiDataModelMapper) {
        this.newsApiDataSource = newsApiDataSource;
        this.apiDataModelMapper = apiDataModelMapper;
    }

    @Override
    public Observable<List<News>> newsList() {
        return newsApiDataSource.getPlaylistLatest().map(new Function<PlaylistContainer, List<News>>() {
            @Override
            public List<News> apply(PlaylistContainer playlistContainer) throws Exception {
                return apiDataModelMapper.toModel(playlistContainer);
            }
        });
    }

//    @Override
//    public Observable<News> newsDetail(final String newsId) {
//        Observer<News> newsObserver = new DefaultObserver<News>();
//
//        if(dataCache==null) {
//            newsList().subscribeWith(new DefaultObserver<List<News>>() {
//                @Override
//                public void onNext(List<News> value) {
//                    return Observable.just(getNewsById(newsId));
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    return
//                }
//
//                @Override
//                public void onComplete() {
//
//                }
//            })
//        }
//        return newsApiDataSource.;
//    }
//
//    private News getNewsById(String newsId) {
//
//    }

}
