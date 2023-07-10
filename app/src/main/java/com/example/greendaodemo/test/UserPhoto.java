package com.example.greendaodemo.test;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Property;

import com.example.greendaodemo.dao.DaoSession;

import com.example.greendaodemo.dao.UserPhotoDao;

/**
 *
 */
@Entity(active = true,
        nameInDb = "user_photo")
public class UserPhoto {

    @Id
    @Property(nameInDb = "pid")
    private long pid;

    private long uid;

    private int type; // 类型 0是图片 , 1 是视频
    private String photoUrl;    //图片地址

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;

/** Used for active entity operations. */
@Generated(hash = 53675852)
private transient UserPhotoDao myDao;
@Generated(hash = 757456656)
public UserPhoto(long pid, long uid, int type, String photoUrl) {
    this.pid = pid;
    this.uid = uid;
    this.type = type;
    this.photoUrl = photoUrl;
}
@Generated(hash = 2131037409)
public UserPhoto() {
}
public long getPid() {
    return this.pid;
}
public void setPid(long pid) {
    this.pid = pid;
}
public long getUid() {
    return this.uid;
}
public void setUid(long uid) {
    this.uid = uid;
}
public int getType() {
    return this.type;
}
public void setType(int type) {
    this.type = type;
}
public String getPhotoUrl() {
    return this.photoUrl;
}
public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
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
@Generated(hash = 221239469)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getUserPhotoDao() : null;
}



}
