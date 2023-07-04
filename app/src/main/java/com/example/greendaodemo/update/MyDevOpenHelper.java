package com.example.greendaodemo.update;

import android.content.Context;

import com.example.greendaodemo.dao.DaoMaster;
import com.example.greendaodemo.dao.StudentBeanDao;

import org.greenrobot.greendao.database.Database;

public class MyDevOpenHelper extends DaoMaster.DevOpenHelper {
    public MyDevOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
//        super.onUpgrade(db, oldVersion, newVersion);

//        MigrationHelper.getInstance().migrate(db, StudentBeanDao.class);
        System.out.println("===========================> MyDevOpenHelper onUpgrade oldVersion: " + oldVersion + "   newVersion: " + newVersion);
        //把需要管理的数据库表DAO作为最后一个参数传入到方法中
        MigrationHelper1.migrate(db, new MigrationHelper1.ReCreateAllTableListener() {

            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        },  StudentBeanDao.class);
    }
}