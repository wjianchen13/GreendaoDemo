package com.example.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.example.greendaodemo.dao.DaoSession;
import com.example.greendaodemo.dao.HangupBeanDao;

@Entity(active = true, nameInDb = "db_hangup_table")
public class HangupBean {

    /**
     * 用户id
     */
    @Unique
    private String anchorId;

    /**
     * 事件发生时间
     */
    private long ctime;

    /**
     * 插入时间字符描述
     */
    private String realTime;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 71668575)
    private transient HangupBeanDao myDao;

    @Generated(hash = 1607897334)
    public HangupBean(String anchorId, long ctime, String realTime) {
        this.anchorId = anchorId;
        this.ctime = ctime;
        this.realTime = realTime;
    }

    @Generated(hash = 956993764)
    public HangupBean() {
    }

    public String getAnchorId() {
        return this.anchorId;
    }

    public void setAnchorId(String anchorId) {
        this.anchorId = anchorId;
    }

    public long getCtime() {
        return this.ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }

    public String getRealTime() {
        return this.realTime;
    }

    public void setRealTime(String realTime) {
        this.realTime = realTime;
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
    @Generated(hash = 160395393)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getHangupBeanDao() : null;
    }

    @Override
    public String toString() {
        return "StudentBean{ " +
                "anchorId=" + anchorId +
                ", ctime=" + ctime +
                ", realTime='" + realTime  +
                " }";
    }
    
}
