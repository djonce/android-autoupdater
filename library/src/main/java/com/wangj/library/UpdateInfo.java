package com.wangj.library;

/**
 * Created by wangj on 16/1/7
 */
public class UpdateInfo {
    private String appName;
    private String appDescription;
    private String packageName;
    private String versionCode;
    private String versionName;
    private boolean forceUpdate;
    private boolean autoUpdate;
    private String apkUrl;
    private String updateTips;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public boolean isForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public boolean isAutoUpdate() {
        return autoUpdate;
    }

    public void setAutoUpdate(boolean autoUpdate) {
        this.autoUpdate = autoUpdate;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public String getUpdateTips() {
        return updateTips;
    }

    public void setUpdateTips(String updateTips) {
        this.updateTips = updateTips;
    }

    @Override
    public String toString() {
        return "UpdateInfo{" +
                "appName='" + appName + '\'' +
                ", appDescription='" + appDescription + '\'' +
                ", packageName='" + packageName + '\'' +
                ", versionCode='" + versionCode + '\'' +
                ", versionName='" + versionName + '\'' +
                ", forceUpdate=" + forceUpdate +
                ", autoUpdate=" + autoUpdate +
                ", apkUrl='" + apkUrl + '\'' +
                ", updateTips='" + updateTips + '\'' +
                '}';
    }
}
