package com.smarttv.services.impl;

import com.smarttv.dao.CategoryDao;
import com.smarttv.models.Category;
import com.smarttv.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategories(String siteName) {
        return categoryDao.getList("siteName", siteName);
    }
}
