package com.smarttv.services.impl;

import com.smarttv.dao.VideoDao;
import com.smarttv.dto.VideoDto;
import com.smarttv.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;

    @Transactional(readOnly = false)
    public void saveAll(Set<? extends VideoDto> videos) {
        for(VideoDto video : videos) {
            videoDao.save(video);
        }
    }

    @Override
    public List<VideoDto> getVideo(String category, String siteName) {
        return videoDao.getList("category", category, "siteName", siteName);
    }
}
