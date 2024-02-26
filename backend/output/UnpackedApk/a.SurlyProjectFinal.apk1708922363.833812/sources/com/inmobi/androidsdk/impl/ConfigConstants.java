package com.inmobi.androidsdk.impl;

public final class ConfigConstants {
    public static final String MSG_AD_ACTIVE = "Interstitial ad is in ACTIVE state. Try again after sometime.";
    public static final String MSG_AD_BUSY = "New ad will not be shown because the present ad is busy. Eg. Video/audio is playing, etc.";
    public static final String MSG_AD_CLICK = "Ad click in progress. Your request cannot be processed at this time. Try again later.";
    public static final String MSG_AD_DOWNLOAD = "Ad download in progress. Your request cannot be processed at this time. Try again later.";
    public static final String MSG_AD_FOCUS = "Activity is not in the foreground. New ad will not be loaded.";
    public static final String MSG_AD_INVENTORY = "Ad request successful, but no ad was returned due to lack of ad inventory.";
    public static final String MSG_AD_SLOT = "Please provide a valid 'adSlot' attribute in the 'com.inmobi.androidsdk.IMAdView' tag of layout XML. For example, adSlot=\"yourAddSlot\"";
    public static final String MSG_AD_SLOT_2 = "Cannot load ad because adSlot is negative. Please provide a valid adSlot.";
    public static final String MSG_AD_STATE = "Current Ad State is neither default nor loading. New ad will not be shown.";
    public static final String MSG_APP_ID = "Please provide a valid 'appId' attribute in the 'com.inmobi.androidsdk.IMAdView' tag of layout XML. For example, appId=\"yourAppId\"";
    public static final String MSG_APP_ID_2 = "Cannot load ad because appId is null. Please provide a valid appId.";
    public static final String MSG_CALL_BACK = "IMAdView not sending callback because the view is not added to any window.";
    public static final String MSG_REFRESH = "Ad cannot be refreshed now, as the minimum refresh interval is";
}
