package com.smarttv.dao;

import com.smarttv.dto.VideoDto;

import java.util.List;


public interface VideoDao extends BasicCrudDao<VideoDto> {
    public List<VideoDto> getList(String property, Object value, String property2, Object value2);
    //public VideoDto get(String property, Object value, String property2, Object value2);
}
