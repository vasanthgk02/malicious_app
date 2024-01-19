package com.xiaomi.clientreport.data;

import android.content.Context;

public class Config {
    public static final boolean DEFAULT_EVENT_ENCRYPTED = true;
    public static final long DEFAULT_EVENT_UPLOAD_FREQUENCY = 86400;
    public static final boolean DEFAULT_EVENT_UPLOAD_SWITCH_OPEN = false;
    public static final long DEFAULT_MAX_FILE_LENGTH = 1048576;
    public static final long DEFAULT_PERF_UPLOAD_FREQUENCY = 86400;
    public static final boolean DEFAULT_PERF_UPLOAD_SWITCH_OPEN = false;
    public String mAESKey;
    public boolean mEventEncrypted;
    public long mEventUploadFrequency;
    public boolean mEventUploadSwitchOpen;
    public long mMaxFileLength;
    public long mPerfUploadFrequency;
    public boolean mPerfUploadSwitchOpen;

    public static class Builder {
        public String mAESKey = null;
        public int mEventEncrypted = -1;
        public long mEventUploadFrequency = -1;
        public int mEventUploadSwitchOpen = -1;
        public long mMaxFileLength = -1;
        public long mPerfUploadFrequency = -1;
        public int mPerfUploadSwitchOpen = -1;

        public Config build(Context context) {
            return new Config(context, this);
        }

        public Builder setAESKey(String str) {
            this.mAESKey = str;
            return this;
        }

        public Builder setEventEncrypted(boolean z) {
            this.mEventEncrypted = z ? 1 : 0;
            return this;
        }

        public Builder setEventUploadFrequency(long j) {
            this.mEventUploadFrequency = j;
            return this;
        }

        public Builder setEventUploadSwitchOpen(boolean z) {
            this.mEventUploadSwitchOpen = z ? 1 : 0;
            return this;
        }

        public Builder setMaxFileLength(long j) {
            this.mMaxFileLength = j;
            return this;
        }

        public Builder setPerfUploadFrequency(long j) {
            this.mPerfUploadFrequency = j;
            return this;
        }

        public Builder setPerfUploadSwitchOpen(boolean z) {
            this.mPerfUploadSwitchOpen = z ? 1 : 0;
            return this;
        }
    }

    public Config() {
        this.mEventEncrypted = true;
        this.mEventUploadSwitchOpen = false;
        this.mPerfUploadSwitchOpen = false;
        this.mMaxFileLength = 1048576;
        this.mEventUploadFrequency = 86400;
        this.mPerfUploadFrequency = 86400;
    }

    public Config(Context context, Builder builder) {
        this.mEventEncrypted = true;
        this.mEventUploadSwitchOpen = false;
        this.mPerfUploadSwitchOpen = false;
        this.mMaxFileLength = 1048576;
        this.mEventUploadFrequency = 86400;
        this.mPerfUploadFrequency = 86400;
    }

    public static Config defaultConfig(Context context) {
        return getBuilder().build(context);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public long getEventUploadFrequency() {
        return this.mEventUploadFrequency;
    }

    public long getMaxFileLength() {
        return this.mMaxFileLength;
    }

    public long getPerfUploadFrequency() {
        return this.mPerfUploadFrequency;
    }

    public boolean isEventEncrypted() {
        return this.mEventEncrypted;
    }

    public boolean isEventUploadSwitchOpen() {
        return this.mEventUploadSwitchOpen;
    }

    public boolean isPerfUploadSwitchOpen() {
        return this.mPerfUploadSwitchOpen;
    }

    public String toString() {
        return "";
    }
}
