package com.example.greendaodemo.table;

import com.example.greendaodemo.bean.EventBean;
import com.example.greendaodemo.dao.EventBeanDao;
import com.example.greendaodemo.manager.DaoManager;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class EventBeanTable {

    private static volatile EventBeanTable table = null;

    public static EventBeanTable getInstance() {
        if(table == null) {
            synchronized (EventBeanTable.class) {
                if (table == null) {
                    table = new EventBeanTable();
                }
            }
        }
        return table;
    }

    private EventBeanDao eventDao;
    
    public boolean isExit(int uid, String eventId) {
        if(eventDao != null) {
            QueryBuilder<EventBean> builder = eventDao
                    .queryBuilder()
                    .where(EventBeanDao.Properties.UId.eq(uid), EventBeanDao.Properties.EventId.eq(eventId));
            List<EventBean> result = builder.list();
            return result != null && result.size() > 0;
        }
        return false;
    }

    public boolean isExit(String imei, String eventId) {
        if(eventDao != null) {
            QueryBuilder<EventBean> builder = eventDao
                    .queryBuilder()
                    .where(EventBeanDao.Properties.Imei.eq(imei), EventBeanDao.Properties.EventId.eq(eventId));
            List<EventBean> result = builder.list();
            return result != null && result.size() > 0;
        }
        return false;
    }

    public void save(EventBean entity) {
        eventDao.save(entity);
    }
    
    public EventBeanTable() {
        eventDao = DaoManager.getInstance().getDaoSession().getEventBeanDao();
    }

    public void insert(EventBean event) {
        eventDao.insert(event);
    }
    
    public void insertOrReplace(EventBean event) {
        eventDao.insertOrReplace(event);
    }

    public List<EventBean> queryAll() {
        return eventDao.loadAll();
    }

//    public EventBeanDao load(EventBeanDao event) {
//        EventBeanDao students2 = eventDao.load(Void);
//        return students2;
//    }
    
    public EventBean query() {
        EventBean events = eventDao.loadByRowId(0L);
        return events;
    }


    public void update(EventBean event) {
           eventDao.update(event);
    }

    public void updateInTx(EventBean event) {
        eventDao.updateInTx(event);
    }

    public void delete(EventBean event) {
        eventDao.delete(event);
    }










}
