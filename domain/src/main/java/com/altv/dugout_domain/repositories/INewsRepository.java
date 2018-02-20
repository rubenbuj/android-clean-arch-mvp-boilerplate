package com.altv.dugout_domain.repositories;

import com.altv.dugout_domain.model.News;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by rubenbujalance on 12/02/2018.
 */

public interface INewsRepository {

    /**
     * Get an {@link io.reactivex.Observable} which will emit a list of News
     */
    Observable<List<News>> newsList();

//    /**
//     * Get an {@link io.reactivex.Observable} which will emit a single News object
//     */
//    Observable<News> newsDetail(String newsId);
}
