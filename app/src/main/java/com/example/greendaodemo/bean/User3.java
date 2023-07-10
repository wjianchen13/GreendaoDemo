package com.example.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.example.greendaodemo.dao.DaoSession;
import com.example.greendaodemo.dao.OrdersDao;
import com.example.greendaodemo.dao.Card1Dao;
import com.example.greendaodemo.dao.User3Dao;

@Entity(
        nameInDb = "USERS3",
        indexes = {
                @Index(value = "name DESC")
        }
)
public class User3 {
    @Id(autoincrement = true)
    private Long id;

    private Long cardId;

    //设置一对一关联，连接属性是cardId
    @ToOne(joinProperty ="cardId")   //注意参数的值
    private Card1 card;

    //设置一对多关联，连接属性是Orders类的外键userId
    @ToMany(referencedJoinProperty = "userId")   // 注意参数的值
    private List<Orders> orders;

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
@Generated(hash = 1561846876)
private transient User3Dao myDao;

@Generated(hash = 1789141483)
public User3(Long id, Long cardId, @NotNull String name, String userAddress) {
    this.id = id;
    this.cardId = cardId;
    this.name = name;
    this.userAddress = userAddress;
}

@Generated(hash = 346744247)
public User3() {
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
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 116010504)
public List<Orders> getOrders() {
    if (orders == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        OrdersDao targetDao = daoSession.getOrdersDao();
        List<Orders> ordersNew = targetDao._queryUser3_Orders(id);
        synchronized (this) {
            if (orders == null) {
                orders = ordersNew;
            }
        }
    }
    return orders;
}

/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1446109810)
public synchronized void resetOrders() {
    orders = null;
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
@Generated(hash = 610714029)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getUser3Dao() : null;
}


}