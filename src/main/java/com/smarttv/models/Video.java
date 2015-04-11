package com.smarttv.models;


public class Video {
    private String title;
    private String imageUrl;
    private String videoUrl;
    private String description;

    public Video(String title, String imageUrl, String videoUrl, String description) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
