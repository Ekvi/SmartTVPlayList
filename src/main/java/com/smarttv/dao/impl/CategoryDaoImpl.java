package com.smarttv.dao.impl;


import com.smarttv.dao.CategoryDao;
import com.smarttv.models.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl extends AbstractHibernateDAO<Category> implements CategoryDao {

    public CategoryDaoImpl() {
        super(Category.class);
    }
}
