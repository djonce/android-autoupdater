package com.wangj.library;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 *
 * Created by wangj on 16/1/7.
 */
public class UpdateManager {

    private static final String TAG = UpdateManager.class.getSimpleName();
    private Context mContext;
    private String  checkUrl;
    private boolean isAutoInstall;
    private boolean isHitNewVersion;


    private NotificationManager notificationManager;
    private NotificationCompat.Builder ntfBuilder;

    private static final int UPDATE_NOTIFICATION_PROGRESS = 0x1;
    private static final int COMPLETE_DOWNLOAD_APK = 0x2;
    private static final int DOENLOAD_NOTIFICATION_ID = 0x3;

    private SharedPreferences sharedPreferences;
    private OnUpdateListener onUpdateListener;

    private static final String PATH = Environment.getExternalStorageDirectory().getPath();

    public UpdateManager(Builder builder) {
        this.mContext = builder.context;
        this.checkUrl = builder.checkUrl;
        this.isAutoInstall = builder.isAutoInstall;
        this.isHitNewVersion = builder.isHintNewVersion;

        this.sharedPreferences = mContext.getSharedPreferences("Updater", Context.MODE_PRIVATE);
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
    }


    private class AsyncCheck extends AsyncTask<String, Integer, UpdateInfo> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected UpdateInfo doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPostExecute(UpdateInfo updateInfo) {
            super.onPostExecute(updateInfo);
        }
    }

    private class AsyncDownLoad extends AsyncTask<UpdateInfo, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(UpdateInfo... params) {

            return null;
        }
    }

    public static class Builder {
        private Context context;
        private String  checkUrl; //检查更新的接口地址

        private boolean isAutoInstall; //是否自动安装
        private boolean isHintNewVersion;

        public Builder(Context ctx){
            this.context = ctx;
        }

        /**
         *
         * @param checkUrl
         * @return
         */
        public Builder checkUrl(String checkUrl) {
            this.checkUrl = checkUrl;
            return this;
        }

        /**
         *
         * @param isAuto
         * @return true下载完成后自动安装，false下载完成后需要点击通知栏安装
         */
        public Builder isAutoInstall(boolean isAuto) {
            this.isAutoInstall = isAuto;
            return this;
        }

        /**
         * 是否提示有更新
         *
         * @param isHint
         * @return true提示，false不提示
         */
        public Builder isHintNewVersion(boolean isHint) {
            this.isHintNewVersion = isHint;
            return this;
        }

        public UpdateManager build(){
            return new UpdateManager(this);
        }
    }


}
