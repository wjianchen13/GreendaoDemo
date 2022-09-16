package com.example.greendaodemo.table;

import com.example.greendaodemo.bean.HangupBean;
import com.example.greendaodemo.dao.EventBeanDao;
import com.example.greendaodemo.dao.HangupBeanDao;
import com.example.greendaodemo.manager.DaoManager;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class HangupBeanTable {

    private static volatile HangupBeanTable table = null;

    public static HangupBeanTable getInstance() {
        if(table == null) {
            synchronized (HangupBeanTable.class) {
                if (table == null) {
                    table = new HangupBeanTable();
                }
            }
        }
        return table;
    }

    private HangupBeanDao hangupDao;
    
    public boolean isExit(int uid, String eventId) {
        if(hangupDao != null) {
            QueryBuilder<HangupBean> builder = hangupDao
                    .queryBuilder()
                    .where(EventBeanDao.Properties.UId.eq(uid), EventBeanDao.Properties.EventId.eq(eventId));
            List<HangupBean> result = builder.list();
            return result != null && result.size() > 0;
        }
        return false;
    }

    public boolean isExit(String imei, String eventId) {
        if(hangupDao != null) {
            QueryBuilder<HangupBean> builder = hangupDao
                    .queryBuilder()
                    .where(EventBeanDao.Properties.Imei.eq(imei), EventBeanDao.Properties.EventId.eq(eventId));
            List<HangupBean> result = builder.list();
            return result != null && result.size() > 0;
        }
        return false;
    }

    public void save(HangupBean entity) {
        hangupDao.save(entity);
    }
    
    public HangupBeanTable() {
        hangupDao = DaoManager.getInstance().getDaoSession().getHangupBeanDao();
    }

    public void insert(HangupBean event) {
        hangupDao.insert(event);
    }
    
    public void insertOrReplace(HangupBean event) {
        hangupDao.insertOrReplace(event);
    }

    public List<HangupBean> queryAll() {
        return hangupDao.loadAll();
    }

//    public EventBeanDao load(EventBeanDao event) {
//        EventBeanDao students2 = eventDao.load(Void);
//        return students2;
//    }
    
    public HangupBean query() {
        HangupBean events = hangupDao.loadByRowId(0L);
        return events;
    }


    public void update(HangupBean event) {
           hangupDao.update(event);
    }

    public void updateInTx(HangupBean event) {
        hangupDao.updateInTx(event);
    }

    public void delete(HangupBean event) {
        hangupDao.delete(event);
    }










}
