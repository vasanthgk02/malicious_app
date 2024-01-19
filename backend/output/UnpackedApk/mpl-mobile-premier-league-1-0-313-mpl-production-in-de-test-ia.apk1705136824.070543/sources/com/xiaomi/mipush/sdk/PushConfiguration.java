package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
import com.xiaomi.push.service.module.PushChannelRegion;

public class PushConfiguration {
    public String mFCMSenderId;
    public boolean mGeoEnable;
    public boolean mOpenCOSPush;
    public boolean mOpenFCMPush;
    public boolean mOpenFTOSPush;
    public boolean mOpenHmsPush;
    public PushChannelRegion mRegion;

    public static class PushConfigurationBuilder {
        public String mFCMSenderId;
        public boolean mGeoEnable;
        public boolean mOpenCOSPush;
        public boolean mOpenFCMPush;
        public boolean mOpenFTOSPush;
        public boolean mOpenHmsPush;
        public PushChannelRegion mRegion;

        public PushConfiguration build() {
            return new PushConfiguration(this);
        }

        public PushConfigurationBuilder openCOSPush(boolean z) {
            this.mOpenCOSPush = z;
            return this;
        }

        public PushConfigurationBuilder openFCMPush(boolean z, String str) {
            this.mOpenFCMPush = z;
            if (!z || !TextUtils.isEmpty(str)) {
                this.mFCMSenderId = str;
                return this;
            }
            throw new IllegalArgumentException("senderId can`t be empty if you open fcm!");
        }

        public PushConfigurationBuilder openFTOSPush(boolean z) {
            this.mOpenFTOSPush = z;
            return this;
        }

        public PushConfigurationBuilder openHmsPush(boolean z) {
            this.mOpenHmsPush = z;
            return this;
        }

        public PushConfigurationBuilder region(PushChannelRegion pushChannelRegion) {
            this.mRegion = pushChannelRegion;
            return this;
        }
    }

    public PushConfiguration() {
        this.mRegion = PushChannelRegion.Global;
        this.mOpenHmsPush = false;
        this.mOpenFCMPush = false;
        this.mOpenCOSPush = false;
        this.mOpenFTOSPush = false;
    }

    public PushConfiguration(PushConfigurationBuilder pushConfigurationBuilder) {
        this.mRegion = pushConfigurationBuilder.mRegion == null ? PushChannelRegion.Global : pushConfigurationBuilder.mRegion;
        this.mOpenHmsPush = pushConfigurationBuilder.mOpenHmsPush;
        this.mOpenFCMPush = pushConfigurationBuilder.mOpenFCMPush;
        this.mFCMSenderId = pushConfigurationBuilder.mFCMSenderId;
        this.mOpenCOSPush = pushConfigurationBuilder.mOpenCOSPush;
        this.mOpenFTOSPush = pushConfigurationBuilder.mOpenFTOSPush;
    }

    private void setOpenCOSPush(boolean z) {
        this.mOpenCOSPush = z;
    }

    private void setOpenFCMPush(boolean z) {
        this.mOpenFCMPush = z;
    }

    private void setOpenFTOSPush(boolean z) {
        this.mOpenFTOSPush = z;
    }

    private void setOpenHmsPush(boolean z) {
        this.mOpenHmsPush = z;
    }

    private void setRegion(PushChannelRegion pushChannelRegion) {
        this.mRegion = pushChannelRegion;
    }

    public String getFCMSenderId() {
        return this.mFCMSenderId;
    }

    public boolean getOpenCOSPush() {
        return this.mOpenCOSPush;
    }

    public boolean getOpenFCMPush() {
        return this.mOpenFCMPush;
    }

    public boolean getOpenFTOSPush() {
        return this.mOpenFTOSPush;
    }

    public boolean getOpenHmsPush() {
        return this.mOpenHmsPush;
    }

    public PushChannelRegion getRegion() {
        return this.mRegion;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PushConfiguration{");
        stringBuffer.append("Region:");
        PushChannelRegion pushChannelRegion = this.mRegion;
        stringBuffer.append(pushChannelRegion == null ? "null" : pushChannelRegion.name());
        stringBuffer.append(",mOpenHmsPush:" + this.mOpenHmsPush);
        stringBuffer.append(",mOpenFCMPush:" + this.mOpenFCMPush);
        stringBuffer.append(",mOpenCOSPush:" + this.mOpenCOSPush);
        stringBuffer.append(",mOpenFTOSPush:" + this.mOpenFTOSPush);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
