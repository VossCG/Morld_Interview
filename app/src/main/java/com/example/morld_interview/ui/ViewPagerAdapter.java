package com.example.morld_interview.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.morld_interview.databinding.VideoViewBinding;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.VideoViewHolder> {

    private final List<MediaSource> mediaSources;
    private final List<ExoPlayer> players;

    public ViewPagerAdapter(List<MediaSource> mediaSources, List<ExoPlayer> players) {
        this.mediaSources = mediaSources;
        this.players = players;
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder {
        public final TextView index;
        public final CustomVideoView videoView;

        public VideoViewHolder(VideoViewBinding binding) {
            super(binding.getRoot());
            this.index = binding.indexTv;
            this.videoView = binding.videoView;
        }
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        VideoViewBinding binding = VideoViewBinding.inflate(inflater, parent, false);
        return new VideoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.index.setText(String.valueOf(position));
        holder.videoView.setPlayer(mediaSources.get(position), players.get(position));
    }

    @Override
    public int getItemCount() {
        return mediaSources.size();
    }
}
