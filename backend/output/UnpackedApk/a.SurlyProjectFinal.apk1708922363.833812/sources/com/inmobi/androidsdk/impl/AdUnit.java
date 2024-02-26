package com.inmobi.androidsdk.impl;

import java.io.Serializable;

public class AdUnit implements Serializable {
    private static final long serialVersionUID = 7987544297386338802L;
    String CDATABlock;
    AdActionNames adActionName = AdActionNames.AdActionName_Web;
    AdTypes adType = AdTypes.NONE;
    String defaultTargetUrl;
    String deviceInfoUploadUrl;
    int height;
    boolean sendDeviceInfo;
    String targetUrl;
    int width;

    public enum AdActionNames {
        AdActionName_None,
        AdActionName_Web,
        AdActionName_SMS,
        AdActionName_Search,
        AdActionName_Call,
        AdActionName_Android,
        AdActionName_Map,
        AdActionName_Audio,
        AdActionName_Video;

        public String toString() {
            return super.toString().replaceFirst("AdActionName_", Constants.QA_SERVER_URL).toLowerCase();
        }
    }

    public enum AdTypes {
        NONE,
        TEXT,
        BANNER,
        SEARCH,
        RICH_MEDIA;

        public String toString() {
            return super.toString().replaceFirst("AdType_", Constants.QA_SERVER_URL).toLowerCase();
        }
    }

    public static AdActionNames adActionNamefromString(String text) {
        AdActionNames aaname = AdActionNames.AdActionName_None;
        if (text == null) {
            return aaname;
        }
        if (text.equalsIgnoreCase("call")) {
            return AdActionNames.AdActionName_Call;
        }
        if (text.equalsIgnoreCase("sms")) {
            return AdActionNames.AdActionName_SMS;
        }
        if (text.equalsIgnoreCase("search")) {
            return AdActionNames.AdActionName_Search;
        }
        if (text.equalsIgnoreCase("android")) {
            return AdActionNames.AdActionName_Android;
        }
        if (text.equalsIgnoreCase("web")) {
            return AdActionNames.AdActionName_Web;
        }
        if (text.equalsIgnoreCase("map")) {
            return AdActionNames.AdActionName_Map;
        }
        if (text.equalsIgnoreCase("audio")) {
            return AdActionNames.AdActionName_Audio;
        }
        if (text.equalsIgnoreCase("video")) {
            return AdActionNames.AdActionName_Video;
        }
        return AdActionNames.AdActionName_None;
    }

    public static AdTypes adTypefromString(String text) {
        AdTypes aatype = AdTypes.NONE;
        if (text == null) {
            return aatype;
        }
        if (text.equalsIgnoreCase("banner")) {
            return AdTypes.BANNER;
        }
        if (text.equalsIgnoreCase("text")) {
            return AdTypes.TEXT;
        }
        if (text.equalsIgnoreCase("search")) {
            return AdTypes.SEARCH;
        }
        if (text.equalsIgnoreCase("rm")) {
            return AdTypes.RICH_MEDIA;
        }
        return aatype;
    }

    public AdActionNames getAdActionName() {
        return this.adActionName;
    }

    public void setAdActionName(AdActionNames adActionName2) {
        this.adActionName = adActionName2;
    }

    public AdTypes getAdType() {
        return this.adType;
    }

    public void setAdType(AdTypes adType2) {
        this.adType = adType2;
    }

    public String getTargetUrl() {
        return this.targetUrl;
    }

    public void setTargetUrl(String targetUrl2) {
        this.targetUrl = targetUrl2;
    }

    public boolean isSendDeviceInfo() {
        return this.sendDeviceInfo;
    }

    public void setSendDeviceInfo(boolean sendDeviceInfo2) {
        this.sendDeviceInfo = sendDeviceInfo2;
    }

    public String getDeviceInfoUploadUrl() {
        return this.deviceInfoUploadUrl;
    }

    public void setDeviceInfoUploadUrl(String deviceInfoUploadUrl2) {
        this.deviceInfoUploadUrl = deviceInfoUploadUrl2;
    }

    public String getCDATABlock() {
        return this.CDATABlock;
    }

    public void setCDATABlock(String cDATABlock) {
        this.CDATABlock = cDATABlock;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width2) {
        this.width = width2;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height2) {
        this.height = height2;
    }

    public String getDefaultTargetUrl() {
        return this.defaultTargetUrl;
    }

    public void setDefaultTargetUrl(String defaultTargetUrl2) {
        this.defaultTargetUrl = defaultTargetUrl2;
    }

    public String toString() {
        StringBuffer strBuff = new StringBuffer();
        strBuff.append("AdUnit: ");
        strBuff.append(" adActionName: " + this.adActionName);
        strBuff.append(" adType: " + this.adType);
        strBuff.append(" targetUrl: " + this.targetUrl);
        strBuff.append(" width: " + this.width);
        strBuff.append(" height: " + this.height);
        return strBuff.toString();
    }
}
