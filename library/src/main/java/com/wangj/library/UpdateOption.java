package com.wangj.library;

import android.content.Context;

/**
 *
 * Created by wangj on 2016/1/11
 */
public final class UpdateOption {
    public  final   Context context;
    public final   String  checkUrl; //检查更新的接口地址
    private final   boolean autoInstall; //是否自动安装
    private boolean isHintNewVersion;
    private boolean forceUpdate;
    private String  apkDir;

    private UpdateFormat updateFormat;

    public UpdateOption(Builder builder) {
        this.context = builder.context;
        this.checkUrl = builder.checkUrl;
        this.autoInstall = builder.isAutoInstall;
    }

    public static class Builder {
        private Context context;
        private String  checkUrl; //检查更新的接口地址
        private boolean isAutoInstall; //是否自动安装
        private boolean isHintNewVersion;

        private String  apkDir;  // 下载的存放地址
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

        public Builder setApkDir(String apkDir) {
            this.apkDir = apkDir;
            return this;
        }

        public UpdateOption build(){
            return new UpdateOption(this);
        }
    }
}
