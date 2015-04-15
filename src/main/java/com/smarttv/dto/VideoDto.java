package com.smarttv.dto;


import com.smarttv.models.Video;
import com.smarttv.utils.parsers.VideoInfo;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "video")
public class VideoDto {
    @Id
    @GeneratedValue
    @Column
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "video_links")
    private String videoLinks;
    @Column(name = "video_names")
    private String videoNames;
    @Column(name = "description")
    private String description;
    @Column(name = "category")
    private String category;
    @Column(name = "site_name")
    private String siteName;

    public VideoDto(){}

    public VideoDto(Video video) {
        this.title = video.getTitle();
        this.imageUrl = video.getImageUrl();
        this.description = video.getDescription();
        this.category = video.getCategory();
        this.siteName = video.getSiteName();

        setVideoLinksAndNames(video.getVideos());
    }

    private void setVideoLinksAndNames(List<VideoInfo> videos) {
        StringBuilder links = new StringBuilder();
        StringBuilder names = new StringBuilder();

        for(VideoInfo video : videos) {
            links.append(video.getLink()).append(" ");
            names.append(video.getName()).append(" ");
        }
        this.videoLinks = links.toString().trim();
        this.videoNames = names.toString().trim();
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

    public String getVideoLinks() {
        return videoLinks;
    }

    public void setVideoLinks(String videoLinks) {
        this.videoLinks = videoLinks;
    }

    public String getVideoNames() {
        return videoNames;
    }

    public void setVideoNames(String videoNames) {
        this.videoNames = videoNames;
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
