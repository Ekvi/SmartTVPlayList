package com.smarttv.models;


import com.smarttv.utils.parsers.VideoInfo;

import java.util.List;

public class Video {
    private String title;
    private String imageUrl;
    private List<VideoInfo> videos;
    private String description;
    private String category;
    private String siteName;

    public Video(String title, String imageUrl,
                 List<VideoInfo>videos, String description, String category, String siteName) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.videos = videos;
        this.description = description;
        this.category = category;
        this.siteName = siteName;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
}
