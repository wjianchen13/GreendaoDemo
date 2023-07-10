package com.example.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.example.greendaodemo.dao.DaoSession;
import com.example.greendaodemo.dao.Card1Dao;
import com.example.greendaodemo.dao.User1Dao;

@Entity(
        nameInDb = "USERS",
        indexes = {
                @Index(value = "name DESC")
        }
)
public class User1 {

    @Id(autoincrement = true)
    private Long id;

    private Long cardId;     // 新增的，外键

    //设置一对一关联，连接属性是cardId
    @ToOne(joinProperty ="cardId") // 注意该参数的值
    private Card1 card;       // 新增的

    @Index(name="usercode_index",unique = true)
    private String usercode;

    @Property(nameInDb = "userName")
    @NotNull
    private String name;

    private String userAddress;

    @Transient
    private int tempUserSign;

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;

/** Used for active entity operations. */
@Generated(hash = 699924472)
private transient User1Dao myDao;

@Generated(hash = 843842)
public User1(Long id, Long cardId, String usercode, @NotNull String name,
        String userAddress) {
    this.id = id;
    this.cardId = cardId;
    this.usercode = usercode;
    this.name = name;
    this.userAddress = userAddress;
}

@Generated(hash = 1224450628)
public User1() {
}

public Long getId() {
    return this.id;
}

public void setId(Long id) {
    this.id = id;
}

public Long getCardId() {
    return this.cardId;
}

public void setCardId(Long cardId) {
    this.cardId = cardId;
}

public String getUsercode() {
    return this.usercode;
}

public void setUsercode(String usercode) {
    this.usercode = usercode;
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

@Generated(hash = 10293163)
private transient Long card__resolvedKey;

/** To-one relationship, resolved on first access. */
@Generated(hash = 879856971)
public Card1 getCard() {
    Long __key = this.cardId;
    if (card__resolvedKey == null || !card__resolvedKey.equals(__key)) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        Card1Dao targetDao = daoSession.getCard1Dao();
        Card1 cardNew = targetDao.load(__key);
        synchronized (this) {
            card = cardNew;
            card__resolvedKey = __key;
        }
    }
    return card;
}

/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 219692880)
public void setCard(Card1 card) {
    synchronized (this) {
        this.card = card;
        cardId = card == null ? null : card.getId();
        card__resolvedKey = cardId;
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
@Generated(hash = 1096789670)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getUser1Dao() : null;
}
}
