package com.example.greendaodemo.manager;

import com.example.greendaodemo.bean.EventBean;
import com.example.greendaodemo.bean.HangupBean;
import com.example.greendaodemo.table.EventBeanTable;
import com.example.greendaodemo.table.HangupBeanTable;

public class HangupUtils {

    /**
     * insertOrReplace 数据存在则替换，数据不存在则插入
     * @param bean
     */
    public static void insertOrReplace(HangupBean bean) {
        if(bean != null) {
            HangupBeanTable.getInstance().insertOrReplace(bean);
        }
    }


    /**
     * 查询数据库数据，排除UID一样的情况
     * 如果不存在UID，则插入，返回true
     * @return
     */
    public static boolean isUploadEventExcludeUid(int uid, String eventId, String desc) {
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
    public static boolean isUploadEventExcludeDevice(String imei, String eventId, String desc) {
        if(!isExit(imei, eventId)) {
            EventBean bean = new EventBean(0, eventId, imei, System.currentTimeMillis(), desc);
            EventBeanTable.getInstance().save(bean);
            return true;
        }
        return false;
    }
    
    public static boolean isExit(int uid, String eventId) {
        return EventBeanTable.getInstance().isExit(uid, eventId);   
    }

    public static boolean isExit(String imei, String eventId) {
        return EventBeanTable.getInstance().isExit(imei, eventId);
    }
    
}
