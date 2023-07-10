 package com.example.greendaodemo.test;

 import android.os.Bundle;
 import android.util.Log;
 import android.view.View;

 import androidx.appcompat.app.AppCompatActivity;

 import com.example.greendaodemo.R;
 import com.example.greendaodemo.bean.Orders;
 import com.example.greendaodemo.bean.User3;
 import com.example.greendaodemo.dao.User3Dao;
 import com.example.greendaodemo.dao.UserInfoDao;
 import com.example.greendaodemo.dao.UserPhotoDao;
 import com.example.greendaodemo.manager.DaoManager;

 import java.util.ArrayList;
 import java.util.List;

 /**
 * 1对1关联
 */
public class TestActivity extends AppCompatActivity {

     private UserInfoDao userInfoDao;
     private UserPhotoDao userPhotoDao;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        userInfoDao = DaoManager.getInstance().getDaoSession().getUserInfoDao();
        userPhotoDao = DaoManager.getInstance().getDaoSession().getUserPhotoDao();
    }

    public void onTest1(View v) {
        List<UserPhoto> videoList = new ArrayList<>();

        UserInfo user1 = new UserInfo();
        List<Long> tests = new ArrayList();
        tests.add(3l);
        tests.add(4l);
        tests.add(5l);
        tests.add(6l);
        user1.setTestList(tests);
        user1.setUid(10001L);
        user1.setName("孙悟空");
        user1.setUserAddress("花果山水帘洞");
        userInfoDao.insertOrReplace(user1);

        UserInfo user2 = new UserInfo();
        user2.setUid(10002L);
        user2.setName("猪八戒");
        user2.setUserAddress("花果山水帘洞");
        userInfoDao.insertOrReplace(user2);

        UserPhoto userVideo1 = new UserPhoto();
        userVideo1.setPhotoUrl("test1");
        userVideo1.setPid(1);
        userVideo1.setUid(user1.getUid());

        UserPhoto userVideo2 = new UserPhoto();
        userVideo2.setPhotoUrl("test2");
        userVideo2.setPid(2);
        userVideo2.setUid(user1.getUid());

        UserPhoto userVideo3 = new UserPhoto();
        userVideo3.setPhotoUrl("test3");
        userVideo3.setPid(3);
        userVideo3.setUid(user1.getUid());

        UserPhoto userVideo4 = new UserPhoto();
        userVideo4.setPhotoUrl("test4");
        userVideo4.setPid(4);
        userVideo4.setUid(user2.getUid());

        videoList.add(userVideo1);
        videoList.add(userVideo2);
        videoList.add(userVideo3);
        videoList.add(userVideo4);

        userPhotoDao.insertOrReplaceInTx(videoList);

    }

     /**
      * 查询数据
      * @param v
      */
    public void onTest2(View v) {
        List<UserPhoto> photoList;
        UserInfo user1 = userInfoDao.queryBuilder().where(UserInfoDao.Properties.Name.eq("孙悟空")).build().unique();

        //直接通过User对象的getOrders()方法获得此用户的所有订单
        photoList = user1.getVideos();
        Log.d("TAG", user1.getName() + "的订单内容为：");

        int i = 0;
        if (photoList != null) {
            for (UserPhoto order : photoList) {
                i = i + 1;
                Log.d("TAG", "第" + i + "条订单的结果：" + ",id:" + order.getPid()
                        + ",商品名：" + order.getPhotoUrl()
                        + ",用户名：" + user1.getName());
            }
        }
    }

    /**
     *
     */
    public void onTest3(View v) {

    }

    public void onTest4(View v) {

    }

    /**
     *
     */
    public void onTest5(View v) {

    }

    public void onTest6(View v) {

    }


}




