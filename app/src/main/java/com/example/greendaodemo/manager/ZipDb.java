package com.example.greendaodemo.manager;

import android.text.TextUtils;

import com.example.greendaodemo.bean.RemoteZipBean;
import com.example.greendaodemo.dao.RemoteZipBeanDao;
import com.example.greendaodemo.table.RemoteZipBeanTable;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * 下载zip数据库
 */
public class ZipDb {

    public static final String TAG = ZipDb.class.getSimpleName();

    public ZipDb() {

    }

    public List<RemoteZipBean> queryAll() {
        return RemoteZipBeanTable.getInstance().loadAll();
    }

    /**
     * 获取表数据
     *
     * @return
     */
    public RemoteZipBean getZipBean(long zid, String zipName) {
        RemoteZipBean bean = null;
        QueryBuilder qb = RemoteZipBeanTable.getInstance().queryBuilder();
        List<RemoteZipBean> beans = qb.where(RemoteZipBeanDao.Properties.Zid.eq(zid)).list();
        if(beans != null && beans.size() > 0) {
            bean = beans.get(0);
        } else {
            bean = new RemoteZipBean();
            bean.setZid(zid);
            bean.setZipName(zipName);
            RemoteZipBeanTable.getInstance().insertOrReplace(bean);
        }
        return bean;
    }

    /**
     * 更新版本号和下载链接
     *
     * @param zid
     * @param zipVersion
     * @param zipUrl
     */
    public void updateVersionAndUrl(long zid, int zipVersion, String zipUrl) {
        updateData(zid, -1, -1, zipUrl, "", zipVersion);
    }

    /**
     * 强制更新数据
     */
    public void forceUpdateData(long zid, long zipDownloadSize, long zipAllSize, String zipUrl, String zipName, int zipVersion) {
        final RemoteZipBean zip = new RemoteZipBean();
        zip.setZid(zid);
        zip.setZipAllSize(zipAllSize);
        zip.setZipName(zipName);
        zip.setZipDownloadSize(zipDownloadSize);
        zip.setZipVersion(zipVersion);
        zip.setZipUrl(zipUrl);
        RemoteZipBeanTable.getInstance().insertOrReplace(zip);
    }

    /**
     * 更新满足条件数据
     *
     * @param zid
     * @param zipDownloadSize
     * @param zipAllSize
     * @param zipUrl
     * @param zipName
     * @param zipVersion
     */
    private void updateData(long zid, long zipDownloadSize, long zipAllSize, String zipUrl, String zipName, int zipVersion) {
        RemoteZipBean bean = null;
        QueryBuilder qb = RemoteZipBeanTable.getInstance().queryBuilder();
        List<RemoteZipBean> beans = qb.where(RemoteZipBeanDao.Properties.Zid.eq(zid)).list();
        if(beans != null && beans.size() > 0) {
            bean = beans.get(0);
            if(bean != null) {
                if (zipDownloadSize != -1) {
                    bean.setZipDownloadSize(zipDownloadSize);
                }
                if (zipAllSize != -1) {
                    bean.setZipAllSize(zipAllSize);
                }
                if (!TextUtils.isEmpty(zipUrl)) {
                    bean.setZipUrl(zipUrl);
                }
                if (!TextUtils.isEmpty(zipName)) {
                    bean.setZipName(zipName);
                }
                if (zipVersion != -1) {
                    bean.setZipVersion(zipVersion);
                }
                RemoteZipBeanTable.getInstance().insertOrReplace(bean);
            }
        } else {
            final RemoteZipBean zip = new RemoteZipBean();
            zip.setZid(zid);
            zip.setZipAllSize(zipAllSize);
            zip.setZipName(zipName);
            zip.setZipDownloadSize(zipDownloadSize);
            zip.setZipVersion(zipVersion);
            zip.setZipUrl(zipUrl);
            RemoteZipBeanTable.getInstance().insertOrReplace(zip);
        }
    }

}
