package com.smarttv.dao.impl;

import com.smarttv.dao.VideoDao;
import com.smarttv.dto.VideoDto;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VideoDaoImpl extends AbstractHibernateDAO<VideoDto> implements VideoDao {

    public VideoDaoImpl() {
        super(VideoDto.class);
    }

    @Override
    public List<VideoDto> getList(String property, Object value, String property2, Object value2) {
        Criteria criteria = criteria();
        criteria.add(Restrictions.eq(property, value));
        criteria.add(Restrictions.eq(property2, value2));

        return criteria.list();
    }
}
