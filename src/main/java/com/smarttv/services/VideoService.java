package com.smarttv.services;


import com.smarttv.dto.VideoDto;
import com.smarttv.models.Category;

import java.util.List;
import java.util.Set;

public interface VideoService {
    public List<Category> getCategories();
    public Category getCategory(String name);
    public void saveAll(Set<? extends VideoDto> videos);
    public List<VideoDto> getVideo(String category, String siteName);
}
