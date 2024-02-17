package com.example.morld_interview.ui

import android.content.Context
import android.util.AttributeSet
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

    private lateinit var mExoPlayer: ExoPlayer

    fun setPlayer(mediaSource: MediaSource, exoPlayer: ExoPlayer) {
        mExoPlayer = exoPlayer
        player = mExoPlayer
        exoPlayer.setMediaSource(mediaSource)
        exoPlayer.prepare()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mExoPlayer.play()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mExoPlayer.pause()
    }

}
