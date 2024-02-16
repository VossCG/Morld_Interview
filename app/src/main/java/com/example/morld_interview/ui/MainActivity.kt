package com.example.morld_interview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.morld_interview.databinding.ActivityMainBinding
import com.example.morld_interview.media.VideoDataSource
import com.google.android.exoplayer2.source.MediaSource

class MainActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewPager()
    }

    private fun setViewPager() {
        viewPagerAdapter = ViewPagerAdapter(getMediaRes())
        binding.viewPager.adapter = viewPagerAdapter
    }

    private fun getMediaRes(): List<MediaSource> {
        return listOf(
            VideoDataSource.getMediaRes(),
            VideoDataSource.getMediaRes(),
            VideoDataSource.getMediaRes()
        )
    }

}