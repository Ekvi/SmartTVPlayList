package com.smarttv.dao;


import java.util.List;

public interface BasicCrudDao<E> {
    void save(E entity);
    List<E> getAll();
    E get(String property, Object value);
    E get(String property, Object value, String property2, Object value2);
    List<E> getList(String property, Object value);
}
