package com.android.installreferrer.api;

import android.os.Bundle;

public class ReferrerDetails {
    public static final String KEY_GOOGLE_PLAY_INSTANT = "google_play_instant";
    public static final String KEY_INSTALL_BEGIN_TIMESTAMP = "install_begin_timestamp_seconds";
    public static final String KEY_INSTALL_BEGIN_TIMESTAMP_SERVER = "install_begin_timestamp_server_seconds";
    public static final String KEY_INSTALL_REFERRER = "install_referrer";
    public static final String KEY_INSTALL_VERSION = "install_version";
    public static final String KEY_REFERRER_CLICK_TIMESTAMP = "referrer_click_timestamp_seconds";
    public static final String KEY_REFERRER_CLICK_TIMESTAMP_SERVER = "referrer_click_timestamp_server_seconds";
    public final Bundle mOriginalBundle;

    public ReferrerDetails(Bundle bundle) {
        this.mOriginalBundle = bundle;
    }

    public boolean getGooglePlayInstantParam() {
        return this.mOriginalBundle.getBoolean(KEY_GOOGLE_PLAY_INSTANT);
    }

    public long getInstallBeginTimestampSeconds() {
        return this.mOriginalBundle.getLong(KEY_INSTALL_BEGIN_TIMESTAMP);
    }

    public long getInstallBeginTimestampServerSeconds() {
        return this.mOriginalBundle.getLong(KEY_INSTALL_BEGIN_TIMESTAMP_SERVER);
    }

    public String getInstallReferrer() {
        return this.mOriginalBundle.getString(KEY_INSTALL_REFERRER);
    }

    public String getInstallVersion() {
        return this.mOriginalBundle.getString(KEY_INSTALL_VERSION);
    }

    public long getReferrerClickTimestampSeconds() {
        return this.mOriginalBundle.getLong(KEY_REFERRER_CLICK_TIMESTAMP);
    }

    public long getReferrerClickTimestampServerSeconds() {
        return this.mOriginalBundle.getLong(KEY_REFERRER_CLICK_TIMESTAMP_SERVER);
    }
}
