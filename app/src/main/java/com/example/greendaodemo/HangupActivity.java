package com.example.greendaodemo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greendaodemo.bean.EventBean;
import com.example.greendaodemo.bean.HangupBean;
import com.example.greendaodemo.manager.EventUtils;
import com.example.greendaodemo.manager.HangupUtils;
import com.example.greendaodemo.table.EventBeanTable;
import com.example.greendaodemo.util.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HangupActivity extends AppCompatActivity {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangup);
    }

    public void onInsert(View v) {
        HangupUtils.insertOrReplace("123");
    }

    public void onInsert1(View v) {
        HangupUtils.insertOrReplace("456");
    }

    public void onInsert2(View v) {
        HangupUtils.insertOrReplace("789");
    }


    public void onDelete(View v) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        long current = System.currentTimeMillis();
        Utils.log("删除时间: " + sdf.format(new Date(current)));
        HangupUtils.deleteGreaterThan3Min(current);
    }

    public void onUpdate(View v) {
        long current = System.currentTimeMillis();
        boolean isGreaterThan3min = HangupUtils.isGreaterThan3min(current, "789");
        if(isGreaterThan3min) {
            Utils.log("大于3分钟插入");
        } else {
            Utils.log("小于3分钟插入");
        }
    }

    public void onQuery(View v) {

    }

    public void onQueryAll(View v) {
        List<HangupBean> beans = HangupUtils.queryData();
        if(beans != null) {
            Utils.log("查找数据数量: "  + beans.size());
            if(beans.size() > 0) {
                for (int i = 0; i < beans.size(); i ++) {
                    Utils.log("index " + i + ":  " + beans.get(i).toString());
                }
            }
        }
    }
    

}