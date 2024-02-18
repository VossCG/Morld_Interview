package com.example.morld_interview.media;

import android.util.Log;

import androidx.annotation.Nullable;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;

import java.io.IOException;

public class MyMediaSourceEventListener implements MediaSourceEventListener {
    private final String tag;

    public MyMediaSourceEventListener(String tag) {
        this.tag = tag;
    }

    @Override
    public void onLoadStarted(int windowIndex, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaSourceEventListener.super.onLoadStarted(windowIndex, mediaPeriodId, loadEventInfo, mediaLoadData);
    }

    @Override
    public void onLoadCompleted(int windowIndex, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaSourceEventListener.super.onLoadCompleted(windowIndex, mediaPeriodId, loadEventInfo, mediaLoadData);
        Log.d(tag, "onLoadCompleted");
    }

    @Override
    public void onLoadCanceled(int windowIndex, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        MediaSourceEventListener.super.onLoadCanceled(windowIndex, mediaPeriodId, loadEventInfo, mediaLoadData);
        Log.d(tag, "onLoadCanceled");
    }

    @Override
    public void onLoadError(int windowIndex, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException error, boolean wasCanceled) {
        MediaSourceEventListener.super.onLoadError(windowIndex, mediaPeriodId, loadEventInfo, mediaLoadData, error, wasCanceled);
        Log.d(tag, "onLoadError");
    }
}
