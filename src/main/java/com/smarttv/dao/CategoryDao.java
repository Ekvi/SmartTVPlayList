package com.smarttv.dao;


import com.smarttv.models.Category;

public interface CategoryDao extends BasicCrudDao<Category> {
    public Category get(String property, Object value, String property2, Object value2);
}
