package com.example.morld_interview.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;

public class CustomVideoView extends PlayerView {
    private ExoPlayer mExoPlayer;

    public CustomVideoView(Context context) {
        super(context);
    }

    public CustomVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPlayer(MediaSource mediaSource, ExoPlayer exoPlayer) {
        mExoPlayer = exoPlayer;
        setPlayer(mExoPlayer);
        exoPlayer.setMediaSource(mediaSource);
        exoPlayer.prepare();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mExoPlayer != null) {
            mExoPlayer.setPlayWhenReady(true);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mExoPlayer != null) {
            mExoPlayer.setPlayWhenReady(false);
        }
    }
}
