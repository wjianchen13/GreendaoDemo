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
        MigrationHelper.getInstance().migrate(db, StudentBeanDao.class);
    }
}