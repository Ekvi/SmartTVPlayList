package com.smarttv;


import com.smarttv.dto.VideoDto;
import com.smarttv.models.Category;
import com.smarttv.models.Video;
import com.smarttv.services.CategoryService;
import com.smarttv.services.VideoService;
import com.smarttv.utils.Utils;
import com.smarttv.utils.parsers.ExUaParser;
import com.smarttv.utils.parsers.VideoInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTestConfiguration.class)
public class ExUa {
    @Autowired
    private VideoService videoService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private Utils utils;

    private ExUaParser parser = new ExUaParser();

    @Test
    public void addVideoToDB() {
        List<Category> categories = categoryService.getAllCategories();

        for(Category category : categories) {
            Set<Video> videos = parser.getAllVideo(category.getUri(), category.getName(), category.getSiteName());
            Set<VideoDto> videosDto = new HashSet<VideoDto>();


            for(Video video : videos) {
                videosDto.add(new VideoDto(video));
            }

            videoService.saveAll(videosDto);
        }
    }

    @Test
    public void addOurFilms() {
        Category category = categoryService.getCategory("Фильмы наши", "ex.ua");

        Set<Video> videos = parser.getAllVideo(category.getUri(), category.getName(), category.getSiteName());
        Set<VideoDto> videosDto = new HashSet<VideoDto>();
        System.out.println("video " + videos.size());
        for(Video video : videos) {
            videosDto.add(new VideoDto(video));
        }
        System.out.println("dto " + videosDto.size());
        videoService.saveAll(videosDto);

    }

    @Test
    public void addTrainings() {
        Category category = categoryService.getCategory("Уроки и Тренинги", "ex.ua");
        utils.addVideoToDB(category);
    }

    @Test
    public void testAddExUa() {
        Set<VideoDto> videosDto = new HashSet<VideoDto>();
        videosDto.add(new VideoDto(new Video("title5", "image2", new ArrayList<VideoInfo>(), "description2", "category", "ex.ua")));
        videosDto.add(new VideoDto(new Video("title4", "image3", new ArrayList<VideoInfo>(), "description3", "category", "ex.ua")));

        videoService.saveAll(videosDto);
    }



    @Test
    public void get() {
        List<VideoDto> list = videoService.getVideo("Уроки и Тренинги", "ex.ua");

        for(VideoDto exua : list) {
            System.out.println(exua.getTitle());
        }
    }
}

