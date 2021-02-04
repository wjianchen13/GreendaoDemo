package com.example.greendaodemo.manager;

import com.example.greendaodemo.bean.EventBean;
import com.example.greendaodemo.table.EventBeanTable;

public class EventUtils {

    /**
     * 查询数据库数据，排除UID一样的情况
     * 如果不存在UID，则插入，返回true
     * @return
     */
    public static boolean isUploadEventExcludeUid(int uid, int eventId, String desc) {
        if(!isExit(uid, eventId)) {
            EventBean bean = new EventBean(uid, eventId, "", System.currentTimeMillis(), desc);
            EventBeanTable.getInstance().save(bean);
            return true;
        }
        return false;
    }

    /**
     * 查询数据库数据，排除imei一样的情况
     * 如果不存在imei，则插入，返回true
     * @return
     */
    public static boolean isUploadEventExcludeDevice(String imei, int eventId, String desc) {
        if(!isExit(imei, eventId)) {
            EventBean bean = new EventBean(0, eventId, imei, System.currentTimeMillis(), desc);
            EventBeanTable.getInstance().save(bean);
            return true;
        }
        return false;
    }
    
    public static boolean isExit(int uid, int eventId) {
        return EventBeanTable.getInstance().isExit(uid, eventId);   
    }

    public static boolean isExit(String imei, int eventId) {
        return EventBeanTable.getInstance().isExit(imei, eventId);
    }
    
}
