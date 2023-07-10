package com.example.greendaodemo.test;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.example.greendaodemo.dao.DaoSession;
import com.example.greendaodemo.dao.UserInfoDao;
import com.example.greendaodemo.dao.UserPhotoDao;

@Entity(active = true,
        nameInDb = "user_info")
public class UserInfo {

    @Id
    private Long uid;

    @ToMany(referencedJoinProperty = "uid")
    private List<UserPhoto> videos;

    @Property(nameInDb = "userName")
    @NotNull
    private String name;

    private String userAddress;

    @Transient
    private int tempUserSign;

    @Convert(columnType = String.class, converter = PhotoSrcBeanConverter.class)
    private List<Long> testList;

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;

/** Used for active entity operations. */
@Generated(hash = 437952339)
private transient UserInfoDao myDao;

@Generated(hash = 1965630839)
public UserInfo(Long uid, @NotNull String name, String userAddress, List<Long> testList) {
    this.uid = uid;
    this.name = name;
    this.userAddress = userAddress;
    this.testList = testList;
}

@Generated(hash = 1279772520)
public UserInfo() {
}

public Long getUid() {
    return this.uid;
}

public void setUid(Long uid) {
    this.uid = uid;
}

public String getName() {
    return this.name;
}

public void setName(String name) {
    this.name = name;
}

public String getUserAddress() {
    return this.userAddress;
}

public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
}

/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1169127073)
public List<UserPhoto> getVideos() {
    if (videos == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        UserPhotoDao targetDao = daoSession.getUserPhotoDao();
        List<UserPhoto> videosNew = targetDao._queryUserInfo_Videos(uid);
        synchronized (this) {
            if (videos == null) {
                videos = videosNew;
            }
        }
    }
    return videos;
}

/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1923228979)
public synchronized void resetVideos() {
    videos = null;
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
@Generated(hash = 821180768)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getUserInfoDao() : null;
}

public List<Long> getTestList() {
    return this.testList;
}

public void setTestList(List<Long> testList) {
    this.testList = testList;
}



}