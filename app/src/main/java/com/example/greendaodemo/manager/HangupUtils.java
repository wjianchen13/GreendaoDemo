package com.example.greendaodemo.manager;

import com.example.greendaodemo.bean.HangupBean;
import com.example.greendaodemo.table.HangupBeanTable;
import com.example.greendaodemo.util.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HangupUtils {

    /**
     * 挂断电话，插入挂断信息：主播id，挂断的当前时间，如果之前已经存在了挂断时间在3分钟内，就不会再插入
     * @param anchorId
     */
    public static void insertOrReplace(String anchorId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        long current = System.currentTimeMillis();
        Date date = new Date(current);
        Utils.log("current: " + current + "  date: " + sdf.format(date));
        HangupBeanTable.getInstance().deleteGreaterThan3Min(current);
        if(!HangupBeanTable.getInstance().isAnchorExit(anchorId)) { // 上面已经删除了大于3分钟的，如果还有存在的说明是小于3分钟的
            HangupBeanTable.getInstance().insertOrReplace(new HangupBean(anchorId, current, sdf.format(date)));
        }
    }

    /**
     * 判断当前主播间隔之间挂断是否大于3分钟
     */
    public static boolean isGreaterThan3min(long current, String anchorId) {
        return HangupBeanTable.getInstance().isGreaterThan3min(current, anchorId);
    }

    /**
     * 查找全部数据
     * @return
     */
    public static List<HangupBean> queryData() {
        return HangupBeanTable.getInstance().queryAll();
    }

    /**
     * 删除时间超过3分钟以上的数据
     * @param time
     */
    public static void deleteGreaterThan3Min(long time) {
        HangupBeanTable.getInstance().deleteGreaterThan3Min(time);
    }


}
