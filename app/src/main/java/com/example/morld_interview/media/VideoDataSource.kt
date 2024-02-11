package com.example.morld_interview.media

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class VideoDataSource {

    private val TAG = "VideoDataSource"
    private val url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    private val dataSourceFactory: DefaultHttpDataSource.Factory by lazy { DefaultHttpDataSource.Factory() }

    fun getMediaRes(): MediaSource {
        val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(url))
        mediaSource.addEventListener(
            Handler(Looper.getMainLooper()),
            MyMediaSourceEventListener(
                tag = TAG,
                loadingCallback = { Log.d(TAG, "loading callback") },
                errorCallback = { Log.d(TAG, "error callback") })
        )
        return mediaSource
    }
}