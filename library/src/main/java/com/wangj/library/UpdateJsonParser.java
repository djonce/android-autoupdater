package com.wangj.library;

import org.json.JSONObject;

/**
 * Created by wangj on 2016/1/8
 */
public class UpdateJsonParser extends AbstractParser {

    @Override
    public UpdateInfo parse(String content) throws UpdateException {
        if(content == null) {
            return null;
        }
        UpdateInfo updateInfo = new UpdateInfo();
//        JSONObject jsonObject = new JSONObject(content);
//        updateInfo.setApkUrl(jsonObject.getString(TAG_APK_URL));
//        updateInfo.setAppName(jsonObject.getString(TAG_APP_NAME));
//        updateInfo.setVersionCode(jsonObject.getString(TAG_VERSION_CODE));
//        updateInfo.setVersionName(jsonObject.getString(TAG_VERSION_NAME));
//        updateInfo.setUpdateTips(jsonObject.getString(TAG_UPDATE_TIPS));
        return updateInfo;
    }


}
