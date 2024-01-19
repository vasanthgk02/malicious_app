package com.mpl.androidapp.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class AdsData {
    public static String DEFAULT_ADS_TYPE = "banner";
    public static boolean DEFAULT_AUTO_REFRESH = true;
    public static int DEFAULT_HEIGHT = 50;
    public static String DEFAULT_PLACEMENT_ID = "1592135647353";
    public static int DEFAULT_REFRESH_INTERVAL = 60;
    public static int DEFAULT_WIDTH = 320;
    public transient Activity activity;
    @SerializedName("autoRefresh")
    @Expose
    public Boolean autoRefresh = Boolean.valueOf(DEFAULT_AUTO_REFRESH);
    public transient RelativeLayout mAdsContainer;
    @SerializedName("type")
    @Expose
    public String mAdsType = DEFAULT_ADS_TYPE;
    @SerializedName("height")
    @Expose
    public Integer mHeight = Integer.valueOf(DEFAULT_HEIGHT);
    @SerializedName("placementId")
    @Expose
    public String mPlacementId = DEFAULT_PLACEMENT_ID;
    @SerializedName("width")
    @Expose
    public Integer mWidth = Integer.valueOf(DEFAULT_WIDTH);
    @SerializedName("refreshInterval")
    @Expose
    public Integer refreshInterval = Integer.valueOf(DEFAULT_REFRESH_INTERVAL);
    @SerializedName("xPosition")
    @Expose
    public String xPosition;
    @SerializedName("yPosition")
    @Expose
    public String yPosition;

    public static String getDefaultAdsType() {
        return DEFAULT_ADS_TYPE;
    }

    public static int getDefaultHeight() {
        return DEFAULT_HEIGHT;
    }

    public static String getDefaultPlacementId() {
        return DEFAULT_PLACEMENT_ID;
    }

    public static int getDefaultRefreshInterval() {
        return DEFAULT_REFRESH_INTERVAL;
    }

    public static int getDefaultWidth() {
        return DEFAULT_WIDTH;
    }

    public static boolean isDefaultAutoRefresh() {
        return DEFAULT_AUTO_REFRESH;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public RelativeLayout getAdsContainer() {
        return this.mAdsContainer;
    }

    public String getAdsType() {
        return this.mAdsType;
    }

    public Boolean getAutoRefresh() {
        return this.autoRefresh;
    }

    public Integer getHeight() {
        return this.mHeight;
    }

    public String getPlacementId() {
        return TextUtils.isEmpty(this.mPlacementId) ? DEFAULT_PLACEMENT_ID : this.mPlacementId;
    }

    public Integer getRefreshInterval() {
        return this.refreshInterval;
    }

    public Integer getWidth() {
        return this.mWidth;
    }

    public String getXPosition() {
        return this.xPosition;
    }

    public String getYPosition() {
        return this.yPosition;
    }

    public void setActivity(Activity activity2) {
        this.activity = activity2;
    }

    public void setAdsContainer(RelativeLayout relativeLayout) {
        this.mAdsContainer = relativeLayout;
    }

    public void setAdsType(String str) {
        this.mAdsType = str;
    }

    public void setAutoRefresh(Boolean bool) {
        this.autoRefresh = bool;
    }

    public void setHeight(Integer num) {
        this.mHeight = num;
    }

    public void setPlacementId(String str) {
        this.mPlacementId = str;
    }

    public void setRefreshInterval(Integer num) {
        this.refreshInterval = num;
    }

    public void setWidth(Integer num) {
        this.mWidth = num;
    }

    public void setXPosition(String str) {
        this.xPosition = str;
    }

    public void setYPosition(String str) {
        this.yPosition = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("AdsData{activity=");
        outline73.append(this.activity);
        outline73.append(", xPosition='");
        GeneratedOutlineSupport.outline99(outline73, this.xPosition, ExtendedMessageFormat.QUOTE, ", yPosition='");
        GeneratedOutlineSupport.outline99(outline73, this.yPosition, ExtendedMessageFormat.QUOTE, ", mWidth=");
        outline73.append(this.mWidth);
        outline73.append(", mHeight=");
        outline73.append(this.mHeight);
        outline73.append(", mPlacementId='");
        GeneratedOutlineSupport.outline99(outline73, this.mPlacementId, ExtendedMessageFormat.QUOTE, ", refreshInterval=");
        outline73.append(this.refreshInterval);
        outline73.append(", autoRefresh=");
        outline73.append(this.autoRefresh);
        outline73.append(", mAdsType='");
        return GeneratedOutlineSupport.outline60(outline73, this.mAdsType, ExtendedMessageFormat.QUOTE, '}');
    }
}
