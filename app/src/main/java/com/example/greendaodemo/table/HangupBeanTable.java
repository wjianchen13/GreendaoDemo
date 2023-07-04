package com.example.greendaodemo.table;

import com.example.greendaodemo.bean.HangupBean;
import com.example.greendaodemo.bean.StudentBean;
import com.example.greendaodemo.dao.HangupBeanDao;
import com.example.greendaodemo.dao.HangupBeanDao;
import com.example.greendaodemo.dao.StudentBeanDao;
import com.example.greendaodemo.manager.DaoManager;
import com.example.greendaodemo.util.Utils;

import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.QueryBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HangupBeanTable {

    private static volatile HangupBeanTable table = null;

    public static HangupBeanTable getInstance() {
        if(table == null) {
            synchronized (HangupBeanTable.class) {
                if (table == null) {
                    table = new HangupBeanTable();
                }
            }
        }
        return table;
    }

    private HangupBeanDao hangupDao;

    /**
     * 判断如果已经存在主播，当前时间和存在时间是否大于3分钟
     * @param ctime
     * @param anchorId
     * @return
     */
    public boolean isGreaterThan3min(long ctime, String anchorId) {
        Utils.log("isGreaterThan3min");
        if(hangupDao != null) {
            QueryBuilder<HangupBean> builder = hangupDao
                    .queryBuilder()
                    .where(HangupBeanDao.Properties.AnchorId.eq(anchorId));
            List<HangupBean> result = builder.list();
            if(result != null) {
                Utils.log("isGreaterThan3min 查找到数据数量:" + result.size());
                HangupBean bean = result.get(0);
                Date date = new Date(ctime);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Utils.log("isGreaterThan3min 当前时间:" + ctime + "    " + sdf.format(date));
                if (bean != null) {
                    Utils.log("isGreaterThan3min 保存时间:" + bean.getCtime() + "    " + bean.getRealTime());
                    return ctime - bean.getCtime() > 180000;
                }
            }
        }
        return true;
    }

    /**
     * 删除超过3分钟以上的数据
     */
    public void deleteGreaterThan3Min(long currentTime) {
        QueryBuilder<HangupBean> where = hangupDao.queryBuilder().where(HangupBeanDao.Properties.Ctime.lt(currentTime - 180000));
        DeleteQuery<HangupBean> deleteQuery = where.buildDelete();
        deleteQuery.executeDeleteWithoutDetachingEntities();
    }

    /**
     * 判断某个主播是否存在
     * @param anchorId
     * @return
     */
    public boolean isAnchorExit(String anchorId) {
        QueryBuilder<HangupBean> builder = hangupDao
                .queryBuilder()
                .where(HangupBeanDao.Properties.AnchorId.eq(anchorId));
        List<HangupBean> result = builder.list();
        return result != null && result.size() > 0;
    }

    public void save(HangupBean entity) {
        hangupDao.save(entity);
    }
    
    public HangupBeanTable() {
        hangupDao = DaoManager.getInstance().getDaoSession().getHangupBeanDao();
    }

    public void insert(HangupBean event) {
        hangupDao.insert(event);
    }
    
    public void insertOrReplace(HangupBean event) {
        hangupDao.insertOrReplace(event);
    }

    public List<HangupBean> queryAll() {
        return hangupDao.loadAll();
    }

//    public HangupBeanDao load(HangupBeanDao event) {
//        HangupBeanDao students2 = eventDao.load(Void);
//        return students2;
//    }
    
    public HangupBean query() {
        HangupBean events = hangupDao.loadByRowId(0L);
        return events;
    }


    public void update(HangupBean event) {
           hangupDao.update(event);
    }

    public void updateInTx(HangupBean event) {
        hangupDao.updateInTx(event);
    }

    public void delete(HangupBean event) {
        hangupDao.delete(event);
    }

}
