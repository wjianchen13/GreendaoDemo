package com.example.greendaodemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greendaodemo.bean.EventBean;
import com.example.greendaodemo.bean.RemoteZipBean;
import com.example.greendaodemo.manager.EventUtils;
import com.example.greendaodemo.manager.ZipDb;
import com.example.greendaodemo.table.EventBeanTable;
import com.example.greendaodemo.util.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ZipActivity extends AppCompatActivity {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zip);
    }

    public void onTest1(View v) {
        new ZipDb().getZipBean(1, "测试1");
    }

    public void onTest2(View v) {
        new ZipDb().forceUpdateData(1, 100, 200, "url", "forceUpdateData", 2);
    }

    public void onTest3(View v) {
        new ZipDb().updateVersionAndUrl(1, 3, "url3");
    }

    public void onTest4(View v) {

    }

    public void onTest5(View v) {
        List<RemoteZipBean> list = new ZipDb().queryAll();
        if(list != null) {
            for(int i = 0; i < list.size(); i ++) {
                System.out.println("======================> " + i + ": " + list.get(i).toString());
            }
        }
    }

}