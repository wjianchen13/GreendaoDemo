package com.example.greendaodemo.table;

import com.example.greendaodemo.bean.RemoteZipBean;
import com.example.greendaodemo.dao.RemoteZipBeanDao;
import com.example.greendaodemo.manager.DaoManager;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * insert 插入一条数据  实体对象为参数
 * insertInTx 批量插入数据  List<>型参数
 * insertOrReplace 插入数据，传入的对象主键如果存在于数据库中，有则更新，否则插入  实体对象为参数
 * insertOrReplaceInTx 批量插入数据 List<>型参数
 * save 插入数据，判断对象是否有Key值，有则更新，否则插入  实体对象为参数
 */
public class RemoteZipBeanTable {

    private static volatile RemoteZipBeanTable table = null;
    private RemoteZipBeanDao remoteZipDao;

    public static RemoteZipBeanTable getInstance() {
        if(table == null) {
            synchronized (RemoteZipBeanTable.class) {
                if (table == null) {
                    table = new RemoteZipBeanTable();
                }
            }
        }
        return table;
    }

    public RemoteZipBeanTable() {
        remoteZipDao = DaoManager.getInstance().getDaoSession().getRemoteZipBeanDao();
    }

    public List<RemoteZipBean> loadAll() {
        return remoteZipDao.loadAll();
    }

    public void deleteAll() {
        remoteZipDao.deleteAll();
    }

    public void insert(RemoteZipBean student) {
        remoteZipDao.insert(student);
    }

    public void insertOrReplace(RemoteZipBean student) {
        remoteZipDao.insertOrReplace(student);
    }

    public void save(RemoteZipBean student) {
        remoteZipDao.save(student);
    }

    public void delete(RemoteZipBean student) {
        remoteZipDao.delete(student);
    }

    public void update(RemoteZipBean student) {
        remoteZipDao.update(student);
    }

    public List<RemoteZipBean> queryRaw(String where, String... selectionArg) {
        return remoteZipDao.queryRaw(where, selectionArg);
    }

    public QueryBuilder queryBuilder() {
        return remoteZipDao.queryBuilder();
    }

    public void insertOrReplaceInTx(List<RemoteZipBean> students) {
        remoteZipDao.insertOrReplaceInTx(students);
    }
    
    public RemoteZipBean query() {
        RemoteZipBean beans = remoteZipDao.loadByRowId(0L);
        return beans;
    }

}
