package com.example.morld_interview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.morld_interview.databinding.ActivityMainBinding
import com.example.morld_interview.media.VideoDataSource
import com.google.android.exoplayer2.ExoPlayer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewPagerAdapter: ViewPagerAdapter by lazy { ViewPagerAdapter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewPager()
    }

    private fun setViewPager() {
        binding.viewPager.adapter = viewPagerAdapter
    }
}