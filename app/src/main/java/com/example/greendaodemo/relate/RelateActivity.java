package com.example.greendaodemo.relate;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greendaodemo.R;
import com.example.greendaodemo.bean.Card1;
import com.example.greendaodemo.bean.Card2;
import com.example.greendaodemo.bean.Orders;
import com.example.greendaodemo.bean.User1;
import com.example.greendaodemo.bean.User2;
import com.example.greendaodemo.bean.User3;
import com.example.greendaodemo.dao.Card1Dao;
import com.example.greendaodemo.dao.Card2Dao;
import com.example.greendaodemo.dao.OrdersDao;
import com.example.greendaodemo.dao.User1Dao;
import com.example.greendaodemo.dao.User2Dao;
import com.example.greendaodemo.dao.User3Dao;
import com.example.greendaodemo.manager.DaoManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 1对1关联
 */
public class RelateActivity extends AppCompatActivity {

    private Card1Dao cardDao;
    private User1Dao userDao;
    private Card2Dao cardDao2;
    private User2Dao userDao2;
    private OrdersDao ordersDao;
    private User3Dao userDao3;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relate);
        cardDao = DaoManager.getInstance().getDaoSession().getCard1Dao();
        userDao = DaoManager.getInstance().getDaoSession().getUser1Dao();
        cardDao2 = DaoManager.getInstance().getDaoSession().getCard2Dao();
        userDao2 = DaoManager.getInstance().getDaoSession().getUser2Dao();
        ordersDao = DaoManager.getInstance().getDaoSession().getOrdersDao();
        userDao3 = DaoManager.getInstance().getDaoSession().getUser3Dao();
    }

    public void onTest1(View v) {
        insertOneToOne();
    }

    public void onTest2(View v) {
        queryOneToOne();
    }

    // 单向关联插入
    private void insertOneToOne(){
        // 先生成一条Card记录
        Card1 card1 = new Card1();
        card1.setCardCode("434377777");
        cardDao.insert(card1);

        User1 user1 = new User1();
        user1.setName("孙悟空");
        user1.setUserAddress("花果山水帘洞");
        user1.setUsercode("001");
        user1.setCard(card1);
        userDao.insert(user1);
    }

    // 单向关联查询
    private void queryOneToOne(){
        User1 user = userDao.queryBuilder().where(User1Dao.Properties.Name.eq("孙悟空")).build().unique();
        Card1 card = user.getCard();
        if(user != null && card != null){
            Log.d("TAG", "一对一添加记录，查询后的结果是：\n" + "姓名：" + user.getName()
                    + "\n身份证号" + card.getCardCode() + "\n"
                    + "Card表的id主键值为：" + card.getId()+ "\n"
                    + "User表的外键cardId的值为：" + user.getCardId());
        }
    }

    /**
     * 双向关联
     * @param v
     */
    public void onTest3(View v) {
        insertCardOneTOne2();
    }

    public void onTest4(View v) {
        queryCardOneToOne2();
    }

    private void insertCardOneTOne2(){
        User2 user1 = new User2();
        user1.setName("孙悟空");
        user1.setUserAddress("花果山水帘洞");
        user1.setUsercode("001");

        Card2 card1 = new Card2();
        card1.setCardCode("434377777");

        /* 注意以下代码的顺序 */
        userDao2.insert(user1);
        card1.setUser(user1);

        cardDao2.insert(card1);
        //补上之前没有设置的user1的外键值
        user1.setCard(card1);
        //更新user1对象
        userDao2.update(user1);

    }

    private void queryCardOneToOne2(){
        Card2 card1 = cardDao2.queryBuilder().where(Card2Dao.Properties.CardCode.eq("434377777")).build().unique();
        User2 user1 = card1.getUser();
        if(user1 != null && card1 != null){
            Log.d("TAG", "姓名："+user1.getName()+"\n"
                    +"Card表的id主键值："+card1.getId()+"\n"
                    +"User表的外键cardId的值为："+user1.getCardId());
        }
    }


    /**
     * 一对多关联
     * @param v
     */
    public void onTest5(View v) {
        insertOneToMany3();
    }

    public void onTest6(View v) {
        queryToManyUserToOrder3();
    }

    private void insertOneToMany3(){
        List<Orders> orderList = new ArrayList<Orders>();
        // 这些数据的来源请参考上一章所讲的内容，因为在上一章中有方法为测试提供数据源
        User3 user1 = new User3();
        user1.setName("孙悟空");
        user1.setUserAddress("花果山水帘洞");
        userDao3.insert(user1);

        User3 user2 = new User3();
        user2.setName("猪八戒");
        user2.setUserAddress("花果山水帘洞");
        userDao3.insert(user2);

        Orders order1 = new Orders();
        order1.setGoodsName("金箍棒");
        order1.setUser(user1); //设置外键值时，要用setUser()方法，以确保外键值不会出错

        Orders order2 = new Orders();
        order2.setGoodsName("黄金甲");
        order2.setUser(user1);

        Orders order3 = new Orders();
        order3.setGoodsName("紫金冠");
        order3.setUser(user1);

        Orders order4 = new Orders();
        order4.setGoodsName("紫金冠");
        order4.setUser(user2);

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);

        ordersDao.insertInTx(orderList);
    }

    private void queryToManyUserToOrder3() {
        List<Orders> ordersList;
        User3 user1 = userDao3.queryBuilder().where(User3Dao.Properties.Name.eq("孙悟空")).build().unique();

        //直接通过User对象的getOrders()方法获得此用户的所有订单
        ordersList = user1.getOrders();
        Log.d("TAG", user1.getName() + "的订单内容为：");

        int i = 0;
        if (ordersList != null) {
            for (Orders order : ordersList) {
                i = i + 1;
                Log.d("TAG", "第" + i + "条订单的结果：" + ",id:" + order.getId()
                        + ",商品名：" + order.getGoodsName()
                        + ",用户名：" + user1.getName());
            }
        }
    }





}




