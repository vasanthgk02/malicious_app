package com.mpl.androidapp.notification;

import android.app.PendingIntent;
import android.os.Bundle;
import org.json.JSONObject;

public class MPLNotificationData {
    public JSONObject additionalData;
    public String bigPicture;
    public String body;
    public String featureIcon;
    public String largeIcon;
    public PendingIntent mContentIntent;
    public Bundle mData;
    public String smallIcon;
    public String title;

    public JSONObject getAdditionalData() {
        return this.additionalData;
    }

    public String getBigPicture() {
        return this.bigPicture;
    }

    public String getBody() {
        return this.body;
    }

    public PendingIntent getContentIntent() {
        return this.mContentIntent;
    }

    public Bundle getData() {
        return this.mData;
    }

    public String getFeatureIcon() {
        return this.featureIcon;
    }

    public String getLargeIcon() {
        return this.largeIcon;
    }

    public String getSmallIcon() {
        return this.smallIcon;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAdditionalData(JSONObject jSONObject) {
        this.additionalData = jSONObject;
    }

    public void setBigPicture(String str) {
        this.bigPicture = str;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setContentIntent(PendingIntent pendingIntent) {
        this.mContentIntent = pendingIntent;
    }

    public void setData(Bundle bundle) {
        this.mData = bundle;
    }

    public void setFeatureIcon(String str) {
        this.featureIcon = str;
    }

    public void setLargeIcon(String str) {
        this.largeIcon = str;
    }

    public void setSmallIcon(String str) {
        this.smallIcon = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
