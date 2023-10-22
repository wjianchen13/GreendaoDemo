package com.example.greendaodemo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greendaodemo.bean.PayBean;
import com.example.greendaodemo.bean.RemoteZipBean;
import com.example.greendaodemo.dao.PayBeanDao;
import com.example.greendaodemo.manager.PayDbUtils;
import com.example.greendaodemo.manager.ZipDb;
import com.example.greendaodemo.table.PayTable;
import com.example.greendaodemo.util.Utils;

import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.QueryBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PayActivity extends AppCompatActivity {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
    }

    /**
     * 添加测试数据
     * @param v
     */
    public void onTest1(View v) {
        PayBean bean1 = createPayBean("1", 0, 0, 1697793177502l);
        PayBean bean2 = createPayBean("2", 1, 0, 1697340123532l);
        PayBean bean3 = createPayBean("3", 0, 0, 1697793177502l);
        PayBean bean4 = createPayBean("4", 0, 0, 1697340123532l);
        PayBean bean5 = createPayBean("5", 0, 1, 1697793177502l);
        PayBean bean6 = createPayBean("6", 0, 0, 1697793177502l);
        List<PayBean> beans = new ArrayList<>();
        beans.add(bean1);
        beans.add(bean2);
        beans.add(bean3);
        beans.add(bean4);
        beans.add(bean5);
        beans.add(bean6);
        PayDbUtils.insertOrReplaceInTx(beans);
    }

    /**
     * 查询所有测试数据
     * @param v
     */
    public void onTest2(View v) {
        List<PayBean> beans = PayDbUtils.queryAll();
        if(beans != null && beans.size() != 0) {
            for(int i = 0; i <beans.size(); i ++) {
                Utils.log("数据" + i + ": " + beans.get(i).toString());
            }
        } else {
            Utils.log("没有数据");
        }
    }

    private PayBean createPayBean(String idTag, int googleConsume, int consume, long date) {
        PayBean bean = new PayBean();
        bean.setObfuscatedAccountId("26588935877e4c6894db162c17e6a2a1" + idTag);
        bean.setOrderId("GPA.3333-3530-9919-15787");
        bean.setProductId("group_gold_usd_10");
        bean.setPurchaseToken("dgbgfhbngeibdcahlgiegiko.AO-J1OzdRKq40W_TdD8_SXX1X8CQEK0lfLa4LYVirV2hJhvUuzYaJBeJgfAlIHFEvktNbUy48mWScb-FrT44LPOLWvgcaN6JJw");
        bean.setAcknowledged(false);
        bean.setQuantity(1);
        bean.setGoogleConsume(googleConsume);
        bean.setConsume(consume);
        bean.setCreateDate(date);
        bean.setTryCount(0);
        bean.setProductType("inapp");
        return bean;
    }

    /**
     * 删除所有测试数据
     * @param v
     */
    public void onTest3(View v) {
        PayDbUtils.deleteAll();
    }

    /**
     * 删除7天前的数据
     * 1697944519558 2023/10/22 上午11:15:19
     * @param v
     */
    public void onTest4(View v) {
//        long time = System.currentTimeMillis();
//        int day = 7 * 24 * 60 * 60 * 1000; //  7 天前
//        long day1 = time - day;
//        Utils.log("time: " + time + "    day: " + day + "   day1: " + day1);

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


    public void onTest5(View v) {

    }

    public void onTest6(View v) {
        List<RemoteZipBean> list = new ZipDb().queryAll();
        if(list != null) {
            for(int i = 0; i < list.size(); i ++) {
                System.out.println("======================> " + i + ": " + list.get(i).toString());
            }
        }
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

}