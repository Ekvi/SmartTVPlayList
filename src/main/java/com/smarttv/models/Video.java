package com.smarttv.models;


import com.smarttv.utils.parsers.VideoInfo;

import java.util.List;

public class Video {
    private String title;
    private String imageUrl;
    private List<VideoInfo> videos;
    private String description;

    public Video(String title, String imageUrl, List<VideoInfo>videos, String description) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.videos = videos;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<VideoInfo> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoInfo> videos) {
        this.videos = videos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
