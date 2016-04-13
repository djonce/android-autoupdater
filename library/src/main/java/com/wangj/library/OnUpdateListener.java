package com.wangj.library;

/**
 *
 * Created by wangj on 16/1/7.
 */
public interface OnUpdateListener {

    void onStartCheck();

    void onFinishCheck(UpdateInfo updateInfo);

    void onStartDownload();

    void onDownloading(int progress);

    void onFinishDownload(String apkPath);
}
