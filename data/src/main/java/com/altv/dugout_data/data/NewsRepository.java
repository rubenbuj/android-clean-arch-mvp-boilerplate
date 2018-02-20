package com.altv.dugout_data.data;

import com.altv.dugout_data.mapper.ApiDataModelMapper;
import com.altv.dugout_data.model.PlaylistContainer;
import com.altv.dugout_data.network.NewsApiDataSource;
import com.altv.dugout_domain.model.News;
import com.altv.dugout_domain.repositories.INewsRepository;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by rubenbujalance on 16/02/2018.
 */

@Singleton
public class NewsRepository implements INewsRepository {

    NewsApiDataSource newsApiDataSource;
    ApiDataModelMapper apiDataModelMapper;
    List<News> data;

    @Inject
    NewsRepository(NewsApiDataSource newsApiDataSource, ApiDataModelMapper apiDataModelMapper) {
        this.newsApiDataSource = newsApiDataSource;
        this.apiDataModelMapper = apiDataModelMapper;
    }

    @Override
    public Observable<List<News>> newsList() {
        return newsApiDataSource.getPlaylistLatest()
                .map(new Function<PlaylistContainer, List<News>>() {
                    @Override
                    public List<News> apply(PlaylistContainer playlistContainer) throws Exception {
                        return apiDataModelMapper.toModel(playlistContainer);
                    }
                }).doOnNext(new Consumer<List<News>>() {
                    @Override
                    public void accept(List<News> newsList) throws Exception {
                        data = newsList;
                    }
                });
    }

    @Override
    public Observable<News> newsDetail(final String newsKey) {
        return Observable.fromArray(getNewsById(newsKey));
    }

    private News getNewsById(String newsKey) {
        if(data == null) return null;

        Iterator<News> newsIterator = data.iterator();
        News current;

        while(newsIterator.hasNext()) {
            current = newsIterator.next();
            if(current.getKey().equals(newsKey)) {
                return current;
            }
        }

        return null;
    }

}
