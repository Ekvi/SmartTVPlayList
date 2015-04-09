package com.smarttv.utils.parsers;


import java.io.IOException;
import java.util.List;

public interface Parser {
    public List<String> getCategories(String url) throws IOException;
}
