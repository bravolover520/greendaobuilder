package com.purityboy.greendaobuilder.helper;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by John on 2016/4/25.
 */
public interface IDbService<T, K> {

    void save(T t);

    void save(T... ts);

    void save(List<T> ts);

    void saveOrUpdate(T t);

    void saveOrUpdate(T... ts);

    void saveOrUpdate(List<T> ts);

    void deleteByKey(K key);

    void delete(T t);

    void delete(T... ts);

    void delete(List<T> ts);

    void deleteAll();

    void update(T t);

    void update(T... ts);

    void update(List<T> ts);

    T query(K key);

    List<T> queryAll();

    List<T> query(String where, String... params);

    QueryBuilder<T> queryBuilder();

    long count();

    void refresh(T t);

    void detach(T t);
}
