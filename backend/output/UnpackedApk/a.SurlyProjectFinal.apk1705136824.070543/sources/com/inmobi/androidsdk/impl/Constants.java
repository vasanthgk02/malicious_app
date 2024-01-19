package com.inmobi.androidsdk.impl;

public final class Constants {
    public static final String AD_SERVER_CACHED_LIFE = "inmobicachedlife";
    public static final String AD_SERVER_CACHED_URL = "inmobicachedserver";
    public static final String AD_SERVER_URL = "http://i.w.inmobi.com/showad.asm";
    public static final String AD_TEST_SERVER_URL = "http://i.w.sandbox.inmobi.com/showad.asm";
    public static final String APP_TRACKER_URL = "http://ma.inmobi.com/downloads/trackerV1";
    public static final String BASE_URL = "http://www.inmobi.com";
    public static final long CACHED_AD_SERVER_LIFE = 43200000;
    public static final String CACHED_AD_SERVER_TIMESTAMP = "inmobi_cached_timestamp";
    public static boolean DEBUG = false;
    public static final int HTTP_SUCCESS_CODE = 200;
    public static final String LOGGING_TAG = "InMobiAndroidSDK_3.5.0";
    public static final boolean QA_MODE = false;
    public static final String QA_SERVER_URL = "";
    public static final String SDK_VERSION = "3.5.0";

    public enum playerState {
        INIT,
        PLAYING,
        PAUSED,
        HIDDEN,
        SHOWING,
        COMPLETED,
        RELEASED
    }
}
