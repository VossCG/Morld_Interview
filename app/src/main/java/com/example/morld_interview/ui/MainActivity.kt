package com.example.morld_interview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.morld_interview.databinding.ActivityMainBinding
import com.example.morld_interview.media.VideoDataSource
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.source.MediaSource

class MainActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var currentPlayer: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewPager()
    }

    private fun setViewPager() {
        val mediaRes = getMediaRes()
        val players = getPlayers(mediaRes.size)

        viewPagerAdapter = ViewPagerAdapter(mediaRes, players)
        binding.viewPager.adapter = viewPagerAdapter
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentPlayer = players[position]
            }
        })
    }

    private fun getMediaRes(): List<MediaSource> {
        return listOf(
            VideoDataSource.getMediaRes(),
            VideoDataSource.getMediaRes(),
            VideoDataSource.getMediaRes()
        )
    }

    private fun getPlayers(size: Int): List<ExoPlayer> {
        val players = mutableListOf<ExoPlayer>()
        repeat(size) {
            val player = ExoPlayer.Builder(this).build()
            players.add(player)
        }
        return players
    }

    override fun onStop() {
        super.onStop()
        currentPlayer.pause()
    }

    override fun onRestart() {
        super.onRestart()
        currentPlayer.play()
    }
}