package com.example.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * 远程资源数据
 */
@Entity
public class RemoteZipBean {

    @Id
    private long zid; // 1
    private long zipDownloadSize;      // 已经下载大小
    private long zipAllSize;    // zip文件总大小
    private String zipUrl = "";// 文件下载路径
    private String zipName = "";    // zip文件标识
    private int zipVersion;   // 版本号
    private String gameVersion; // 百顺游戏需要用到这个作为版本号 例如：1.1.2

    @Generated(hash = 1192987848)
    public RemoteZipBean(long zid, long zipDownloadSize, long zipAllSize,
                         String zipUrl, String zipName, int zipVersion, String gameVersion) {
        this.zid = zid;
        this.zipDownloadSize = zipDownloadSize;
        this.zipAllSize = zipAllSize;
        this.zipUrl = zipUrl;
        this.zipName = zipName;
        this.zipVersion = zipVersion;
        this.gameVersion = gameVersion;
    }

    @Generated(hash = 203317565)
    public RemoteZipBean() {
    }

    @Override
    public String toString() {
        return "ZipBean{" +
                "zid=" + zid +
                ", zipDownloadSize=" + zipDownloadSize +
                ", zipAllSize=" + zipAllSize +
                ", zipUrl= " + zipUrl +
                ", zipName= " + zipName +
                ", zipVersion=" + zipVersion +
                ", gameVersion=" + gameVersion +
                '}';
    }


    public long getZid() {
        return this.zid;
    }

    public void setZid(long zid) {
        this.zid = zid;
    }

    public long getZipDownloadSize() {
        return this.zipDownloadSize;
    }

    public void setZipDownloadSize(long zipDownloadSize) {
        this.zipDownloadSize = zipDownloadSize;
    }

    public long getZipAllSize() {
        return this.zipAllSize;
    }

    public void setZipAllSize(long zipAllSize) {
        this.zipAllSize = zipAllSize;
    }

    public String getZipUrl() {
        return this.zipUrl;
    }

    public void setZipUrl(String zipUrl) {
        this.zipUrl = zipUrl;
    }

    public String getZipName() {
        return this.zipName;
    }

    public void setZipName(String zipName) {
        this.zipName = zipName;
    }

    public int getZipVersion() {
        return this.zipVersion;
    }

    public void setZipVersion(int zipVersion) {
        this.zipVersion = zipVersion;
    }

    public String getGameVersion() {
        return this.gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

}
