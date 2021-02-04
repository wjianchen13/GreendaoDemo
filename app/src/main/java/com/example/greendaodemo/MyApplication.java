package com.example.greendaodemo;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendaodemo.dao.DaoMaster;
import com.example.greendaodemo.dao.DaoSession;

public class MyApplication extends Application {
    
    private static Context mContext;
    private DaoSession daoSession;
    
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
//        initGreenDao();
    }
    
    public static Context app() {
        return mContext;
    }
    
    private void initGreenDao() {
        //先通过DaoMaster的DevOpenHelper方法来创建一个数据库
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"student.db");
        //获得一个db
        SQLiteDatabase db = helper.getWritableDatabase();
        //新建一个DaoMaster，获得master
        DaoMaster daoMaster = new DaoMaster(db);
        //通过master new一个Daosession
        daoSession = daoMaster.newSession();
    }
    
    public DaoSession getDaoSession() {
        return daoSession;
    }



}
