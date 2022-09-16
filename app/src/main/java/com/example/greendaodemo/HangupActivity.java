package com.example.greendaodemo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greendaodemo.bean.EventBean;
import com.example.greendaodemo.bean.HangupBean;
import com.example.greendaodemo.manager.EventUtils;
import com.example.greendaodemo.manager.HangupUtils;
import com.example.greendaodemo.table.EventBeanTable;

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
        long current = System.currentTimeMillis();
        Date date = new Date(current);
        log("current: " + current + "  date: " + sdf.format(date));
        HangupUtils.insertOrReplace(new HangupBean("1", current, sdf.format(date)));
    }

    public void onDelete(View v) {
        EventUtils.isUploadEventExcludeDevice("111", "2222", "测试1");
    }

    public void onUpdate(View v) {
        EventUtils.isUploadEventExcludeDevice("112", "2222", "测试1");
    }

    public void onQuery(View v) {
        EventUtils.isUploadEventExcludeDevice("111", "2223", "测试1");
    }

    public void onQueryAll(View v) {
        List<EventBean> events = EventBeanTable.getInstance().queryAll();
        log("events size: " + (events != null ? events.size() : 0));
        for(EventBean bean : events) {
            log("uid: " + bean.getUId() + "  eventId: " + bean.getEventId() + "  imei: " + bean.getImei() + "  eventDesc: " + bean.getEventDesc() + "  time: " + sdf.format(new Date(bean.getCtime())));  
        }
    }
    
    private void log(String str) {
        System.out.println("=====================> " + str);
    }

}