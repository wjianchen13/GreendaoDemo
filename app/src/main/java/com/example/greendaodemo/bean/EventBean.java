package com.example.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.example.greendaodemo.dao.DaoSession;
import com.example.greendaodemo.dao.EventBeanDao;

@Entity(active = true, nameInDb = "db_event_table")
public class EventBean {

    /**
     * 用户id
     */
    private int uId;

    /**
     * 事件id
     */
    private int eventId;

    /**
     * 设备号
     */
    private String imei;

    /**
     * 事件发生时间
     */
    private long ctime;

    /**
     * 事件描述
     */
    private String eventDesc;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 519173234)
    private transient EventBeanDao myDao;

    @Generated(hash = 1734550170)
    public EventBean(int uId, int eventId, String imei, long ctime,
            String eventDesc) {
        this.uId = uId;
        this.eventId = eventId;
        this.imei = imei;
        this.ctime = ctime;
        this.eventDesc = eventDesc;
    }

    @Generated(hash = 1783294599)
    public EventBean() {
    }

    public int getUId() {
        return this.uId;
    }

    public void setUId(int uId) {
        this.uId = uId;
    }

    public int getEventId() {
        return this.eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public long getCtime() {
        return this.ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }

    public String getEventDesc() {
        return this.eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1741896799)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEventBeanDao() : null;
    }


    
}
