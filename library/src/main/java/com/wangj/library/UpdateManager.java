package com.wangj.library;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.webkit.URLUtil;

/**
 *
 * Created by wangj on 16/1/7.
 */
public class UpdateManager {

    private static final String TAG = UpdateManager.class.getSimpleName();
    private Context mContext;

    private NotificationManager notificationManager;
    private NotificationCompat.Builder ntfBuilder;

    private static final int UPDATE_NOTIFICATION_PROGRESS = 0x1;
    private static final int COMPLETE_DOWNLOAD_APK = 0x2;
    private static final int DOENLOAD_NOTIFICATION_ID = 0x3;

    private SharedPreferences sharedPreferences;
    private OnUpdateListener onUpdateListener;

    private static final String PATH = Environment.getExternalStorageDirectory().getPath();

    public UpdateManager(UpdateOption updateOption) {
        this.mContext = updateOption.context;
        this.sharedPreferences = mContext.getSharedPreferences("Updater", Context.MODE_PRIVATE);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case UPDATE_NOTIFICATION_PROGRESS: //下载进度
                    showDownloadNotificationUI((UpdateInfo) msg.obj, msg.arg1);
                    break;
                case COMPLETE_DOWNLOAD_APK:

                    break;
            }
        }
    };

    private void showDownloadNotificationUI(UpdateInfo updateInfo, final int progress) {
        if(mContext != null){
            String contentText = new StringBuffer()
                                    .append(progress)
                                    .append("%").toString();
            PendingIntent contentIntent = PendingIntent.getActivity(
                    mContext,
                    0,
                    new Intent(),
                    PendingIntent.FLAG_CANCEL_CURRENT);
            if(notificationManager == null){
                notificationManager = (NotificationManager) mContext
                        .getSystemService(Context.NOTIFICATION_SERVICE);
            }
            if(ntfBuilder == null) {
                ntfBuilder = new NotificationCompat.Builder(mContext)
                        .setSmallIcon(mContext.getApplicationInfo().icon)
                        .setTicker("开始下载...")
                        .setContentTitle(updateInfo.getAppName())
                        .setContentIntent(contentIntent);
            }
            ntfBuilder.setContentText(contentText);
            ntfBuilder.setProgress(100, progress, false);
            notificationManager.notify(DOENLOAD_NOTIFICATION_ID, ntfBuilder.build());
        }

    }

    public void check() {
        check(null);
    }

    public void check(OnUpdateListener listener){
        if(listener != null) {
            this.onUpdateListener = listener;
        }
        if(mContext == null) {
            Log.e(TAG, "The context must not be null");
            return;
        }
        AsyncCheck asyncCheck = new AsyncCheck();
        asyncCheck.execute();
    }


    private class AsyncCheck extends AsyncTask<String, Integer, UpdateInfo> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if(onUpdateListener != null){
                onUpdateListener.onStartCheck();
            }
        }

        @Override
        protected UpdateInfo doInBackground(String... params) {
            UpdateInfo updateInfo = null;
            if(params.length == 0) {
                Log.e(TAG, "NullPointerException  Url parameter must not be null.");
                return null;
            }
            String url = params[0];
            if (!URLUtil.isNetworkUrl(url)) {
                Log.e(TAG,"IllegalArgumentException The URL is invalid.");
                return null;
            }
            try {


            }catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return updateInfo;
        }

        @Override
        protected void onPostExecute(UpdateInfo updateInfo) {
            super.onPostExecute(updateInfo);
        }
    }

    private class AsyncDownLoad extends AsyncTask<UpdateInfo, Integer, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(UpdateInfo... params) {

            return null;
        }
    }


    private void showUpdateUi(final UpdateInfo updateInfo) {

    }



    /**
     * 获取当前App版本
     *
     * @return packageInfo
     */
    private PackageInfo getPackageInfo() {
        PackageInfo packageInfo = null;
        if(mContext != null){
            try {
                packageInfo = mContext.getPackageManager()
                        .getPackageInfo(mContext.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return packageInfo;
    }



}
