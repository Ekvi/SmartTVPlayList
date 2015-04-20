package com.smarttv.dao.impl;


import com.smarttv.dao.CategoryDao;
import com.smarttv.models.Category;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository
public class CategoryDaoImpl extends AbstractHibernateDAO<Category> implements CategoryDao {

    public CategoryDaoImpl() {
        super(Category.class);
    }

    @Override
    public Category get(String property, Object value, String property2, Object value2) {
        Criteria criteria = criteria();
        criteria.add(Restrictions.eq(property, value));
        criteria.add(Restrictions.eq(property2, value2));

        return (Category)criteria.uniqueResult();
    }
}
