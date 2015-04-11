package com.smarttv.utils.parsers;


import com.smarttv.models.Video;


import java.util.Set;

public interface Parser {
    public Set<Video> getAllVideo(String url);
    public Set<Video> getNewVideo(String url);
}
