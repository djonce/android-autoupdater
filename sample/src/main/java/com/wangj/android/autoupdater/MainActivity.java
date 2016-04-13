package com.wangj.android.autoupdater;

import android.app.Activity;
import android.os.Bundle;

import com.wangj.library.DefaultUpdateListener;
import com.wangj.library.OnUpdateListener;
import com.wangj.library.UpdateInfo;
import com.wangj.library.UpdateManager;
import com.wangj.library.UpdateOption;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UpdateOption updateOption = new UpdateOption.Builder(this)
                                .isAutoInstall(true)
                                .checkUrl("http://test.19ba.cn/api/liwu.version.json")
                                .setApkDir("/UpdateManager/apk/")
                                .isHintNewVersion(false)
                                .build();
        UpdateManager updateManager = new UpdateManager(updateOption);
        updateManager.check(new OnUpdateListener() {
            @Override
            public void onStartCheck() {

            }

            @Override
            public void onFinishCheck(UpdateInfo updateInfo) {

            }

            @Override
            public void onStartDownload() {

            }

            @Override
            public void onDownloading(int progress) {

            }

            @Override
            public void onFinishDownload(String apkPath) {

            }
        });

        updateManager.check(new DefaultUpdateListener());
    }
}
