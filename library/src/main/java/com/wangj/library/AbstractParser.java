package com.wangj.library;

/**
 * Created by wangj on 2016/1/8
 */
public abstract class AbstractParser {
    public final static String TAG_UPDATE_INFO = "updateInfo";
    public final static String TAG_APP_NAME = "appName";
    public final static String TAG_APP_DESCRIPTION = "appDescription";
    public final static String TAG_PACKAGE_NAME = "packageName";
    public final static String TAG_VERSION_CODE = "versionCode";
    public final static String TAG_VERSION_NAME = "versionName";
    public final static String TAG_FORCE_UPDATE = "forceUpdate";
    public final static String TAG_AUTO_UPDATE = "autoUpdate";
    public final static String TAG_APK_URL = "apkUrl";
    public final static String TAG_UPDATE_TIPS = "updateTips";

    public abstract UpdateInfo parse(String content) throws UpdateException;
}
