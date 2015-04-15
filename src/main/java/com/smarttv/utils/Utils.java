package com.smarttv.utils;


import com.smarttv.dto.VideoDto;
import com.smarttv.models.Category;
import com.smarttv.models.Video;
import com.smarttv.services.VideoService;
import com.smarttv.utils.parsers.FactoryParsers;
import com.smarttv.utils.parsers.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Utils {
    @Autowired
    private FactoryParsers factory;
    @Autowired
    private VideoService videoService;
    
    public void addVideoToDB(Category category) {
        Parser parser = factory.createParser(category.getSiteName());

        Set<Video> videos = parser.getAllVideo(category.getUri(), category.getName(), category.getSiteName());
        Set<VideoDto> exUaVideos = new HashSet<VideoDto>();

        System.out.println("video " + videos.size());
        for(Video video : videos) {
            exUaVideos.add(new VideoDto(video));
        }
        System.out.println("dto " + exUaVideos.size());
        videoService.saveAll(exUaVideos);
    }
}
