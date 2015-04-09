package com.smarttv.dao.impl;


import com.smarttv.dao.ExUaCategoryDao;
import com.smarttv.models.ExUaCategory;
import org.springframework.stereotype.Repository;

@Repository
public class ExUaCategoryDaoImpl extends AbstractHibernateDAO<ExUaCategory> implements ExUaCategoryDao {

    public ExUaCategoryDaoImpl() {
        super(ExUaCategory.class);
    }
}
