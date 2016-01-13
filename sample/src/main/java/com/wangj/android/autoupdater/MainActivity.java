package com.wangj.android.autoupdater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wangj.library.DefaultUpdateListener;
import com.wangj.library.OnUpdateListener;
import com.wangj.library.UpdateInfo;
import com.wangj.library.UpdateManager;
import com.wangj.library.UpdateOption;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UpdateOption updateOption = new UpdateOption.Builder(this)
                                .isAutoInstall(true)
                                .checkUrl("http://test.19ba.cn/app/version.json")
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
            public void onFinishDownload() {

            }
        });

        updateManager.check(new DefaultUpdateListener());
    }
}
