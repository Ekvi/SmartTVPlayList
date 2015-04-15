package com.smarttv.utils.parsers;


import com.smarttv.models.Category;
import com.smarttv.models.Video;


import java.util.Set;

public interface Parser {
    public Set<Video> getAllVideo(String url, String category, String siteName);
    public Set<Video> getNewVideo(String url);
}
