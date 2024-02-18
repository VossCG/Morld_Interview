package com.example.morld_interview.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.morld_interview.databinding.ActivityMainBinding;
import com.example.morld_interview.media.VideoDataSource;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ExoPlayer currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setViewPager();
    }

    private void setViewPager() {
        List<MediaSource> mediaRes = getMediaRes();
        List<ExoPlayer> players = getPlayers(mediaRes.size());

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(mediaRes, players);
        binding.viewPager.setAdapter(viewPagerAdapter);
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentPlayer = players.get(position);
            }
        });
    }

    private List<MediaSource> getMediaRes() {
        List<MediaSource> mediaSources = new ArrayList<>();
        mediaSources.add(VideoDataSource.getMediaRes());
        mediaSources.add(VideoDataSource.getMediaRes());
        mediaSources.add(VideoDataSource.getMediaRes());
        return mediaSources;
    }

    private List<ExoPlayer> getPlayers(int size) {
        List<ExoPlayer> players = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ExoPlayer player = new ExoPlayer.Builder(this).build();
            players.add(player);
        }
        return players;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (currentPlayer != null) {
            currentPlayer.pause();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (currentPlayer != null) {
            currentPlayer.play();
        }
    }
}
