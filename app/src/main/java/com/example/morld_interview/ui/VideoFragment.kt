package com.example.morld_interview.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.morld_interview.base.BaseFragment
import com.example.morld_interview.databinding.VideoViewBinding
import com.example.morld_interview.media.VideoDataSource
import com.google.android.exoplayer2.ExoPlayer

class VideoFragment(private val position: Int) :
    BaseFragment<VideoViewBinding>(VideoViewBinding::inflate) {
    private val player: ExoPlayer by lazy { ExoPlayer.Builder(requireContext()).build() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setPlayer()
        binding.pageTv.text = position.toString()
    }

    private fun setPlayer() {
        binding.videoView.player = player
        player.playWhenReady = true
        player.setMediaSource(VideoDataSource.getMediaRes())
        player.prepare()
    }

    override fun onResume() {
        super.onResume()
        Log.d("VideoView", "play video")
        player.play()
    }

    override fun onPause() {
        super.onPause()
        Log.d("VideoView", "stop video")
        player.pause()
    }
}