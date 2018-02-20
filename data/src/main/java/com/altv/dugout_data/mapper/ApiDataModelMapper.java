package com.altv.dugout_data.mapper;

import com.altv.dugout_data.model.PlaylistContainer;
import com.altv.dugout_data.model.Video;
import com.altv.dugout_domain.model.News;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by rubenbujalance on 19/02/2018.
 */

public class ApiDataModelMapper {

    @Inject
    ApiDataModelMapper(){}

    public Video fromModel(News news) {
        if(news==null) return null;

        Video video = new Video();
        video.setSlug(news.getKey());
        video.setName(news.getTitle());
        video.setDescription(news.getText());
        video.setTeamCode(news.getTeamCode());
        video.setTeamFullName(news.getTeamName());
        video.setPreviewImageH240(news.getImageUrl());

        return video;
    }

    public News toModel(Video video) {
        if(video==null) return null;

        News news = new News();
        news.setKey(video.getSlug());
        news.setTitle(video.getName());
        news.setText(video.getDescription());
        news.setTeamCode(video.getTeamCode());
        news.setTeamName(video.getTeamFullName());
        news.setImageUrl(video.getPreviewImageH240());

        return news;
    }

    public List<News> toModel(List<Video> videoList) {
        if(videoList==null) return null;

        List<News> list = new ArrayList<>();
        Iterator<Video> videoListIt = videoList.listIterator();
        while(videoListIt.hasNext()) {
            list.add(toModel(videoListIt.next()));
        }

        return list;
    }

    public List<Video> fromModel(List<News> newsList) {
        List<Video> list = new ArrayList<>();
        Iterator<News> newsListIt = newsList.listIterator();
        while(newsListIt.hasNext()) {
            list.add(fromModel(newsListIt.next()));
        }

        return list;
    }

    public List<News> toModel(PlaylistContainer playlistContainer) {
        if(playlistContainer==null || playlistContainer.getVideos()==null) return null;

        List<News> list = new ArrayList<>();
        Iterator<Video> videoListIt = playlistContainer.getVideos().listIterator();
        while(videoListIt.hasNext()) {
            list.add(toModel(videoListIt.next()));
        }

        return list;
    }
}
