package com.altv.dugoutapp;

import android.app.Activity;

import com.altv.dugoutapp.model.PlaylistContainer;
import com.altv.dugoutapp.model.Video;

import org.robolectric.Robolectric;

import java.util.ArrayList;

/**
 * Created by rubenbujalance on 06/02/2018.
 */

public class TestUtils {

    public static PlaylistContainer getPlaylistContainerSample() {
        PlaylistContainer playlistContainer = new PlaylistContainer();
        ArrayList<Video> videos =  new ArrayList<>();

        Video video = new Video();
        video.setName("Video name sample");
        video.setDescription("Video description sample");
        video.setOwnerFullName("Video teamCode full name");
        video.setPreviewImageH240("https://images.performgroup.com/di/library/GOAL/8d/14/lionel-messi-barcelona_1f3hjv68zrc3q1nbwqgc3kdo63.jpg?t=-989192264&quality=90&w=1280");
        videos.add(video);

        video = new Video();
        video.setName("Video name sample 2");
        video.setDescription("Video description sample 2");
        video.setOwnerFullName("Video teamCode full name 2");
        video.setPreviewImageH240("https://www.thesun.co.uk/wp-content/uploads/2017/05/nintchdbpict000327373302-e1495923278521.jpg?strip=all&w=960");
        videos.add(video);

        playlistContainer.setVideos(videos);

        return playlistContainer;
    }

    public static MainActivity initRobolectricMainActivity() {
        return initRobolectricActivity(MainActivity.class);
    }

    public static <A extends Activity> A initRobolectricActivity(Class<A> classType) {
        return Robolectric.buildActivity(classType)
                .create()
                .resume()
                .get();
    }
}
