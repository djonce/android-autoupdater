package com.wangj.library;

import android.text.TextUtils;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

/**
 * xml解析器
 * Created by wangj on 2016/1/8
 */
public class UpdateXmlParser extends AbstractParser {

    @Override
    public UpdateInfo parse(String content) throws Exception {
        UpdateInfo info = null;
        if (TextUtils.isEmpty(content)) {
        }
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(content));
            info = parseUpdateInfo(xpp);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
            Log.e("XmlPullParserException", e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("IOException", e.toString());
        }
        return info;
    }

    /**
     * Parse UpdateInfo
     *
     * @param xpp
     * @return
     * @throws XmlPullParserException
     * @throws IOException
     */
    private UpdateInfo parseUpdateInfo(XmlPullParser xpp) throws XmlPullParserException, IOException {
        UpdateInfo info = null;
        String currentTag;

        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    break;
                case XmlPullParser.START_TAG:
                    currentTag = xpp.getName();
                    if (currentTag.equals(TAG_UPDATE_INFO)) {
                        info = new UpdateInfo();
                    } else if (currentTag.equals(TAG_APP_NAME)) {
                        if (info != null) {
                            info.setAppName(xpp.nextText());
                        }
                    } else if (currentTag.equals(TAG_APP_DESCRIPTION)) {
                        if (info != null) {
                            info.setAppDescription(xpp.nextText());
                        }
                    } else if (currentTag.equals(TAG_PACKAGE_NAME)) {
                        if (info != null) {
                            info.setPackageName(xpp.nextText());
                        }
                    } else if (currentTag.equals(TAG_VERSION_CODE)) {
                        if (info != null) {
                            info.setVersionCode(xpp.nextText());
                        }
                    } else if (currentTag.equals(TAG_VERSION_NAME)) {
                        if (info != null) {
                            info.setVersionName(xpp.nextText());
                        }
                    } else if (currentTag.equals(TAG_FORCE_UPDATE)) {
                        if (info != null) {
                            info.setForceUpdate(xpp.nextText() == "true" ? true : false);
                        }
                    } else if (currentTag.equals(TAG_AUTO_UPDATE)) {
                        if (info != null) {
                            info.setAutoUpdate(xpp.nextText() == "true" ? true : false);
                        }
                    } else if (currentTag.equals(TAG_APK_URL)) {
                        if (info != null) {
                            info.setApkUrl(xpp.nextText());
                        }
                    } else if (currentTag.equals(TAG_UPDATE_TIPS)) {
                        if (info != null) {
                            info.setUpdateTips(xpp.nextText());
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    break;
                case XmlPullParser.TEXT:
                    break;
                default:
                    break;
            }
            eventType = xpp.next();
        }

        return info;
    }

}
