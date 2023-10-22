package com.example.greendaodemo.bean;


import com.example.greendaodemo.dao.DaoSession;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import com.example.greendaodemo.dao.PayBeanDao;

/**
 * 支付数据库
 */
@Entity(active = true, nameInDb = "pay_info")
public class PayBean {

    /**
     * 主键，订单id c4b90c516b0c4e338adec01443ed7949
     */
    @Id
    @Property(nameInDb = "account_id")
    private String obfuscatedAccountId;

    /**
     * 谷歌订单 GPA.3353-4539-3463-61706
     */
    private String orderId;

    /**
     * 产品id 谷歌后台配置 group_gold_usd_3
     */
    private String productId;

    /**
     * 购买token
     */
    private String purchaseToken;

    /**
     * 购买交易是否已经过确认
     */
    private boolean acknowledged;

    /**
     * 购买数量
     */
    private int quantity;

    /**
     * 谷歌订单状态 0 未消费  1 已消费
     */
    private int googleConsume;

    /**
     * 服务器消费订单状态 0 未消费  1 已消费
     */
    private int consume;

    /**
     * 创建时间
     */
    private long createDate;

    /**
     * 重试次数 保留
     */
    private int tryCount;

    /**
     * 支付类型
     * BillingClient.ProductType.INAPP 内购 "inapp"
     * BillingClient.ProductType.SUBS 订阅 "subs"
     */
    private String productType;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 851282377)
    private transient PayBeanDao myDao;


    public PayBean() {

    }

    @Generated(hash = 780142164)
    public PayBean(String obfuscatedAccountId, String orderId, String productId,
            String purchaseToken, boolean acknowledged, int quantity,
            int googleConsume, int consume, long createDate, int tryCount,
            String productType) {
        this.obfuscatedAccountId = obfuscatedAccountId;
        this.orderId = orderId;
        this.productId = productId;
        this.purchaseToken = purchaseToken;
        this.acknowledged = acknowledged;
        this.quantity = quantity;
        this.googleConsume = googleConsume;
        this.consume = consume;
        this.createDate = createDate;
        this.tryCount = tryCount;
        this.productType = productType;
    }

    public String getObfuscatedAccountId() {
        return obfuscatedAccountId;
    }

    public void setObfuscatedAccountId(String obfuscatedAccountId) {
        this.obfuscatedAccountId = obfuscatedAccountId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPurchaseToken() {
        return purchaseToken;
    }

    public void setPurchaseToken(String purchaseToken) {
        this.purchaseToken = purchaseToken;
    }

    public boolean isAcknowledged() {
        return acknowledged;
    }

    public void setAcknowledged(boolean acknowledged) {
        this.acknowledged = acknowledged;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getConsume() {
        return consume;
    }

    public void setConsume(int consume) {
        this.consume = consume;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "PayBean {" +
                "obfuscatedAccountId=" + obfuscatedAccountId +
                ", googleConsume=" + googleConsume +
                ", consume=" + consume +
                ", createDate=" + createDate +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", tryCount=" + tryCount +
                ", acknowledged=" + acknowledged +
                ", quantity=" + quantity +
                ", productType=" + productType +
                ", purchaseToken=" + purchaseToken +
                " }";
    }

    public boolean getAcknowledged() {
        return this.acknowledged;
    }

    public int getGoogleConsume() {
        return this.googleConsume;
    }

    public void setGoogleConsume(int googleConsume) {
        this.googleConsume = googleConsume;
    }

    public long getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
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
    @Generated(hash = 1102970907)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPayBeanDao() : null;
    }

}
