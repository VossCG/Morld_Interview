package com.example.morld_interview.ui

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import com.example.morld_interview.media.VideoDataSource
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.ui.PlayerView

class CustomVideoView : PlayerView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val exoPlayer: ExoPlayer by lazy { ExoPlayer.Builder(context).build() }

    fun setPlayer(mediaSource: MediaSource) {
        player = exoPlayer
        exoPlayer.setMediaSource(mediaSource)
        exoPlayer.prepare()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        exoPlayer.play()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        exoPlayer.pause()
    }

}
