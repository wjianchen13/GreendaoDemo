package com.example.greendaodemo.manager;

import android.text.TextUtils;


import com.example.greendaodemo.bean.PayBean;
import com.example.greendaodemo.dao.PayBeanDao;
import com.example.greendaodemo.table.PayTable;

import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * 谷歌支付数据操作
 */
public class PayDbUtils {

    private static final String TAG = PayDbUtils.class.getSimpleName();

    /**
     * 根据传入的参数，生成数据库表类型
     * @return
     */
    public static PayBean getPayBean(String obfuscatedAccountId, String orderId, String productId, String purchaseToken,
                                     boolean acknowledged, int quantity, String productType) {
        PayBean payBean = new PayBean();
        payBean.setObfuscatedAccountId(obfuscatedAccountId);

        payBean.setOrderId(orderId);
        payBean.setProductId(productId);
        payBean.setPurchaseToken(purchaseToken);
        payBean.setAcknowledged(acknowledged);
        payBean.setQuantity(quantity);
        payBean.setConsume(0);
        payBean.setProductType(productType);
        payBean.setGoogleConsume(0);
        payBean.setCreateDate(System.currentTimeMillis());
        return payBean;
    }

    private static String getProductId(String productId) {
        return productId;
    }

    /**
     * 查找数据库里的全部数据，并把已经确认的订单删除掉
     * @return
     */
    public static List<PayBean> queryAll() {
        QueryBuilder qb = PayTable.getInstance().queryBuilder();
        List<PayBean> beans = qb.list();
//        if(CommonObjectUtils.isNotEmpty(beans)) {
//            for(int i = beans.size(); i >= 0; i --) {
//                PayBean payBean = beans.get(i);
//                if(payBean != null && payBean.getConsume() == 1) {
//                    delete(payBean);
//                    beans.remove(payBean);
//                }
//            }
//        }
        return beans;
    }

    /**
     * 删除一个数据
     * @param bean
     */
    public static void delete(PayBean bean) {
        if(bean != null) {
            PayTable.getInstance().delete(bean);
        }
    }

    public static void deleteAll() {
        PayTable.getInstance().deleteAll();
    }

    /**
     * 删除一个数据
     * @param key
     */
    public static void deleteByKey(String key) {
        if(!TextUtils.isEmpty(key)) {
            PayTable.getInstance().deleteByKey(key);
        }
//        if(GlobalConfig.isTest()) {
//            log("删除数据后数量 count: " + PayTable.getInstance().count());
//        }
    }

    /**
     * 删除 7天之前，并且googleConsume = 0 || consume == 1的数据
     * 删除条件
     * 1。如果是服务器已经确认了
     * 2 7天之前并且谷歌没有确认的
     */
    public static void delete7daysBefore() {
        try {
            int day = 7 * 24 * 60 * 60 * 1000;
            long currentTime = System.currentTimeMillis();
            QueryBuilder qb = PayTable.getInstance().queryBuilder();
            QueryBuilder<PayBean> where = qb.whereOr(PayBeanDao.Properties.Consume.eq(1),
                    qb.and(PayBeanDao.Properties.GoogleConsume.eq(0),
                             PayBeanDao.Properties.CreateDate.lt(currentTime - day)));
            DeleteQuery<PayBean> deleteQuery = where.buildDelete();
            deleteQuery.executeDeleteWithoutDetachingEntities();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void updateConsumeById(String id, int consume) {
        PayBean bean = PayTable.getInstance().load(id);
        if(bean != null) {
            bean.setGoogleConsume(consume);
            insertOrReplace(bean);
        }
    }

    public static void updateGoogleConsumeById(String id, int googleConsume) {
        PayBean bean = PayTable.getInstance().load(id);
        if (bean != null) {
            bean.setGoogleConsume(googleConsume);
            insertOrReplace(bean);
        }
    }

    /**
     * insertOrReplace 数据存在则替换，数据不存在则插入
     * @param bean
     */
    public static void insertOrReplace(PayBean bean) {
//        if(GlobalConfig.isTest()) {
//            log("插入数据前数量 count: " + PayTable.getInstance().count());
//        }
        if(bean != null) {
            PayTable.getInstance().insertOrReplace(bean);
        }
//        if(GlobalConfig.isTest()) {
//            log("插入数据后数量 count: " + PayTable.getInstance().count());
//        }
    }

    public static void insertOrReplaceInTx(List<PayBean> students) {
        if(students != null) {
            PayTable.getInstance().insertOrReplaceInTx(students);
        }
    }

    public static long count() {
        return PayTable.getInstance().count();
    }

    private static boolean isShowLog = true;

    private static void log(String msg) {
        if(isShowLog) {
            System.out.println("===================> " + msg);
        }
    }


}
