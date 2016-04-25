package com.purityboy.greendaobuilder.helper;

import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by John on 2016/4/25.
 */
public class DbService<T, K> implements IDbService<T, K> {

    private AbstractDao<T, K> dao;

    public DbService(AbstractDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(T t) {
        this.dao.insert(t);
    }

    @Override
    public void save(T... ts) {
        this.dao.insertInTx(ts);
    }

    @Override
    public void save(List<T> ts) {
        this.dao.insertInTx(ts);
    }

    @Override
    public void saveOrUpdate(T t) {
        this.dao.insertOrReplace(t);
    }

    @Override
    public void saveOrUpdate(T... ts) {
        this.dao.insertOrReplaceInTx(ts);
    }

    @Override
    public void saveOrUpdate(List<T> ts) {
        this.dao.insertOrReplaceInTx(ts);
    }

    @Override
    public void deleteByKey(K key) {
        this.dao.deleteByKey(key);
    }

    @Override
    public void delete(T t) {
        this.dao.delete(t);
    }

    @Override
    public void delete(T... ts) {
        this.dao.deleteInTx(ts);
    }

    @Override
    public void delete(List<T> ts) {
        this.dao.deleteInTx(ts);
    }

    @Override
    public void deleteAll() {
        this.dao.deleteAll();
    }

    @Override
    public void update(T t) {
        this.dao.update(t);
    }

    @Override
    public void update(T... ts) {
        this.dao.updateInTx(ts);
    }

    @Override
    public void update(List<T> ts) {
        this.dao.updateInTx(ts);
    }

    @Override
    public T query(K key) {
        return this.dao.load(key);
    }

    @Override
    public List<T> queryAll() {
        return this.dao.loadAll();
    }

    @Override
    public List<T> query(String where, String... params) {
        return this.dao.queryRaw(where, params);
    }

    @Override
    public QueryBuilder<T> queryBuilder() {
        return this.dao.queryBuilder();
    }

    @Override
    public long count() {
        return this.dao.count();
    }

    @Override
    public void refresh(T t) {
        this.dao.refresh(t);
    }

    @Override
    public void detach(T t) {
        this.dao.delete(t);
    }
}
