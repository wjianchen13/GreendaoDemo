package com.example.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.example.greendaodemo.dao.DaoSession;
import com.example.greendaodemo.dao.User2Dao;
import com.example.greendaodemo.dao.Card2Dao;

@Entity
public class Card2 {
    @Id(autoincrement = true)
    private Long id;

    @Unique
    @NotNull
    private String cardCode;

    private Long userId;     // 新增的，外键
    //设置一对一关联
    @ToOne(joinProperty = "userId") // 注意该参数的值
    private User2 user;       // 新增的

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 16799051)
    private transient Card2Dao myDao;
    @Generated(hash = 1974087503)
    public Card2(Long id, @NotNull String cardCode, Long userId) {
        this.id = id;
        this.cardCode = cardCode;
        this.userId = userId;
    }
    @Generated(hash = 115105467)
    public Card2() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCardCode() {
        return this.cardCode;
    }
    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @Generated(hash = 251390918)
    private transient Long user__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1136825664)
    public User2 getUser() {
        Long __key = this.userId;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            User2Dao targetDao = daoSession.getUser2Dao();
            User2 userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
                user__resolvedKey = __key;
            }
        }
        return user;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 246052654)
    public void setUser(User2 user) {
        synchronized (this) {
            this.user = user;
            userId = user == null ? null : user.getId();
            user__resolvedKey = userId;
        }
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
    @Generated(hash = 378496649)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCard2Dao() : null;
    }
}
