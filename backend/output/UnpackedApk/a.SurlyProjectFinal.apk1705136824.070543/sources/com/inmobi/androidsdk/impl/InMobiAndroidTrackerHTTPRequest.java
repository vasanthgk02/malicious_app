package com.inmobi.androidsdk.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.util.Log;
import com.inmobi.androidsdk.ai.controller.util.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class InMobiAndroidTrackerHTTPRequest {
    private static final String platform = "android";
    private final String advId;
    private String deviceId = Utils.createMessageDigest(getDeviceId(), "MD5");
    private String keyver;
    private final Context mContext;
    private Random randomObject;
    private String randomkey;
    private String uidmap;

    public InMobiAndroidTrackerHTTPRequest(Context ctx, String advId2) {
        this.mContext = ctx;
        this.advId = advId2;
        if (this.deviceId == null) {
            this.deviceId = Constants.QA_SERVER_URL;
        }
        this.randomObject = new Random();
        this.keyver = "1";
    }

    public boolean setupConnection() {
        boolean response = false;
        try {
            setRandomKey(this.randomObject.nextInt());
            this.uidmap = Utils.getUIDMap(null, Utils.getODIN1(getDeviceId()), this.randomkey, true);
            if (this.uidmap == null) {
                this.uidmap = Constants.QA_SERVER_URL;
            }
            String finalUrlString = "http://ma.inmobi.com/downloads/trackerV1?adv_id=" + this.advId + "&u-id-map=" + this.uidmap + "&u-id-key=" + this.randomkey + "&u-id-ver=" + this.keyver + "&app_id=" + getAppId() + "&platform=" + platform + "&timestamp=" + "'" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()).replace(" ", "%20") + "'";
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Url String: " + finalUrlString);
            }
            HttpURLConnection connection = (HttpURLConnection) new URL(finalUrlString).openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setConnectTimeout(30000);
            connection.setReadTimeout(30000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Ping HTTP response code: " + connection.getResponseCode());
            }
            if (connection.getResponseCode() == 200) {
                try {
                    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                    factory.setNamespaceAware(true);
                    XmlPullParser xpp = factory.newPullParser();
                    xpp.setInput(reader);
                    String startName = null;
                    for (int eventType = xpp.getEventType(); eventType != 1; eventType = xpp.next()) {
                        if (!(eventType == 0 || eventType == 1)) {
                            if (eventType == 2) {
                                startName = xpp.getName();
                            } else if (eventType != 3 && eventType == 4 && startName != null && startName.equalsIgnoreCase("Status")) {
                                response = Boolean.parseBoolean(xpp.getText());
                            }
                        }
                    }
                } catch (XmlPullParserException parseException) {
                    parseException.printStackTrace();
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return response;
    }

    private String getDeviceId() {
        String deviceId2 = null;
        try {
            deviceId2 = Secure.getString(this.mContext.getApplicationContext().getContentResolver(), "android_id");
        } catch (Exception e) {
        }
        if (deviceId2 != null) {
            return deviceId2;
        }
        try {
            return System.getString(this.mContext.getApplicationContext().getContentResolver(), "android_id");
        } catch (Exception e2) {
            return Constants.QA_SERVER_URL;
        }
    }

    private String getAppId() {
        try {
            ApplicationInfo info = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128);
            if (info != null) {
                return info.packageName;
            }
            return Constants.QA_SERVER_URL;
        } catch (Exception e) {
            return Constants.QA_SERVER_URL;
        }
    }

    private void setRandomKey(int randomk) {
        this.randomkey = Integer.toString(randomk);
    }
}
