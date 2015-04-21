package com.smarttv.services;


import com.smarttv.dto.VideoDto;

import java.util.List;
import java.util.Set;

public interface VideoService {
    public void saveAll(Set<? extends VideoDto> videos);
    public List<VideoDto> getVideoList(String category, String siteName);
    public VideoDto getVideo(String title, String siteName);
}
