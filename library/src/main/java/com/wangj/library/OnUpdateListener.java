package com.wangj.library;

/**
 *
 * Created by wangj on 16/1/7.
 */
public interface OnUpdateListener {

    public void onStartCheck();

    public void onFinishCheck(UpdateInfo updateInfo);

    public void onStartDownload();

    public void onDownloading(int progress);

    public void onFinishDownload();
}
