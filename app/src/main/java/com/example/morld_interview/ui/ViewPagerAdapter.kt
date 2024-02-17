package com.example.morld_interview.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.morld_interview.databinding.VideoViewBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.source.MediaSource

class ViewPagerAdapter(
    private val mediaSources: List<MediaSource>,
    private val players: List<ExoPlayer>,
) :
    RecyclerView.Adapter<ViewPagerAdapter.VideoViewHolder>() {

    inner class VideoViewHolder(binding: VideoViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val index = binding.indexTv
        val videoView = binding.videoView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            VideoViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.index.text = position.toString()
        holder.videoView.setPlayer(mediaSources[position], players[position])
    }

    override fun getItemCount(): Int {
        return mediaSources.size
    }
}