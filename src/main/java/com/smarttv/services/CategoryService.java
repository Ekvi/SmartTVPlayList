package com.smarttv.services;


import com.smarttv.models.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getCategories(String siteName);
    public List<Category> getAllCategories();
    public Category getCategory(String categoryName, String siteName);
}
