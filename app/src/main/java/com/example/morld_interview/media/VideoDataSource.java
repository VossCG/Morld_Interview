package com.example.morld_interview.media;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;

public class VideoDataSource {
    private static final String TAG = "VideoDataSource";
    private static final String url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
    private static final DefaultHttpDataSource.Factory dataSourceFactory = new DefaultHttpDataSource.Factory();

    public static MediaSource getMediaRes() {
        ProgressiveMediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(url));

        mediaSource.addEventListener(new Handler(Looper.getMainLooper()), new MyMediaSourceEventListener(TAG));

        return mediaSource;
    }
}
