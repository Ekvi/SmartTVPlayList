package com.smarttv.utils.parsers;

import org.springframework.stereotype.Component;

@Component
public class VideoInfo {
    private String name;
    private String link;

    public VideoInfo(){}

    public VideoInfo(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }
}
