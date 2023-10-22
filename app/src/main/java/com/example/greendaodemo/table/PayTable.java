package com.example.greendaodemo.table;

import com.example.greendaodemo.bean.PayBean;
import com.example.greendaodemo.dao.PayBeanDao;
import com.example.greendaodemo.manager.DaoManager;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * 谷歌支付相关操作类
 */
public class PayTable {

    private static volatile PayTable table = null;
    private PayBeanDao payBeanDao;

    public static PayTable getInstance() {
        if(table == null) {
            synchronized (PayTable.class) {
                if (table == null) {
                    table = new PayTable();
                }
            }
        }
        return table;
    }

    public PayTable() {
        payBeanDao = DaoManager.getInstance().getDaoSession().getPayBeanDao();
    }

    public List<PayBean> loadAll() {
        return payBeanDao != null ? payBeanDao.loadAll() : null;
    }

    public void deleteAll() {
        if(payBeanDao != null)
            payBeanDao.deleteAll();
    }

    public void insert(PayBean payBean) {
        if(payBeanDao != null)
            payBeanDao.insert(payBean);
    }

    public void insertOrReplace(PayBean payBean) {
        if(payBeanDao != null)
            payBeanDao.insertOrReplace(payBean);
    }

    public void save(PayBean payBean) {
        if(payBeanDao != null)
            payBeanDao.save(payBean);
    }

    public void delete(PayBean payBean) {
        if(payBeanDao != null)
            payBeanDao.delete(payBean);
    }

    public void update(PayBean payBean) {
        if(payBeanDao != null)
            payBeanDao.update(payBean);
    }

    public void deleteByKey(String key) {
        if(payBeanDao != null)
            payBeanDao.deleteByKey(key);
    }

    public List<PayBean> queryRaw(String where, String... selectionArg) {
        return payBeanDao != null ? payBeanDao.queryRaw(where, selectionArg) : null;
    }

    public QueryBuilder queryBuilder() {
        return payBeanDao != null ? payBeanDao.queryBuilder() : null;
    }

    public void insertOrReplaceInTx(List<PayBean> students) {
        if(payBeanDao != null)
            payBeanDao.insertOrReplaceInTx(students);
    }

    public PayBean load(String key) {
        return payBeanDao != null ? payBeanDao.load(key) : null;
    }

    public PayBean query() {
        return payBeanDao != null ? payBeanDao.loadByRowId(0L) : null;
    }

    public long count() {
        return payBeanDao != null ? payBeanDao.count() : 0;
    }

}
