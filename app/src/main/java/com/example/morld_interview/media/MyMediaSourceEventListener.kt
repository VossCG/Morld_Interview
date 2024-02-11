package com.example.morld_interview.media

import android.util.Log
import com.google.android.exoplayer2.source.LoadEventInfo
import com.google.android.exoplayer2.source.MediaLoadData
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MediaSourceEventListener
import java.io.IOException

class MyMediaSourceEventListener(
    private val tag: String,
) : MediaSourceEventListener {

    override fun onLoadCompleted(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData
    ) {
        super.onLoadCompleted(windowIndex, mediaPeriodId, loadEventInfo, mediaLoadData)
        Log.d(tag, "Load completed")
    }

    override fun onLoadStarted(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData
    ) {
        super.onLoadStarted(windowIndex, mediaPeriodId, loadEventInfo, mediaLoadData)
        Log.d(tag,"Load started")
    }

    override fun onLoadError(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData,
        error: IOException,
        wasCanceled: Boolean
    ) {
        super.onLoadError(
            windowIndex,
            mediaPeriodId,
            loadEventInfo,
            mediaLoadData,
            error,
            wasCanceled
        )
        Log.d(tag, "Load Error")
    }

    override fun onLoadCanceled(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData
    ) {
        super.onLoadCanceled(windowIndex, mediaPeriodId, loadEventInfo, mediaLoadData)
        Log.d(tag, "Load Canceled")
    }
}