package androidx.work;

import android.os.Build.VERSION;

public final class Constraints {
    public static final Constraints NONE = new Constraints(new Builder());
    public ContentUriTriggers mContentUriTriggers = new ContentUriTriggers();
    public NetworkType mRequiredNetworkType = NetworkType.NOT_REQUIRED;
    public boolean mRequiresBatteryNotLow;
    public boolean mRequiresCharging;
    public boolean mRequiresDeviceIdle;
    public boolean mRequiresStorageNotLow;
    public long mTriggerContentUpdateDelay = -1;
    public long mTriggerMaxContentDelay = -1;

    public static final class Builder {
        public ContentUriTriggers mContentUriTriggers = new ContentUriTriggers();
        public NetworkType mRequiredNetworkType = NetworkType.NOT_REQUIRED;
        public boolean mRequiresBatteryNotLow = false;
        public boolean mRequiresCharging = false;
        public boolean mRequiresDeviceIdle = false;
        public boolean mRequiresStorageNotLow = false;
        public long mTriggerContentMaxDelay = -1;
        public long mTriggerContentUpdateDelay = -1;
    }

    public Constraints() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Constraints.class != obj.getClass()) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.mRequiresCharging == constraints.mRequiresCharging && this.mRequiresDeviceIdle == constraints.mRequiresDeviceIdle && this.mRequiresBatteryNotLow == constraints.mRequiresBatteryNotLow && this.mRequiresStorageNotLow == constraints.mRequiresStorageNotLow && this.mTriggerContentUpdateDelay == constraints.mTriggerContentUpdateDelay && this.mTriggerMaxContentDelay == constraints.mTriggerMaxContentDelay && this.mRequiredNetworkType == constraints.mRequiredNetworkType) {
            return this.mContentUriTriggers.equals(constraints.mContentUriTriggers);
        }
        return false;
    }

    public int hashCode() {
        long j = this.mTriggerContentUpdateDelay;
        long j2 = this.mTriggerMaxContentDelay;
        return this.mContentUriTriggers.hashCode() + (((((((((((((this.mRequiredNetworkType.hashCode() * 31) + (this.mRequiresCharging ? 1 : 0)) * 31) + (this.mRequiresDeviceIdle ? 1 : 0)) * 31) + (this.mRequiresBatteryNotLow ? 1 : 0)) * 31) + (this.mRequiresStorageNotLow ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public Constraints(Builder builder) {
        this.mRequiresCharging = builder.mRequiresCharging;
        this.mRequiresDeviceIdle = VERSION.SDK_INT >= 23 && builder.mRequiresDeviceIdle;
        this.mRequiredNetworkType = builder.mRequiredNetworkType;
        this.mRequiresBatteryNotLow = builder.mRequiresBatteryNotLow;
        this.mRequiresStorageNotLow = builder.mRequiresStorageNotLow;
        if (VERSION.SDK_INT >= 24) {
            this.mContentUriTriggers = builder.mContentUriTriggers;
            this.mTriggerContentUpdateDelay = builder.mTriggerContentUpdateDelay;
            this.mTriggerMaxContentDelay = builder.mTriggerContentMaxDelay;
        }
    }

    public Constraints(Constraints constraints) {
        this.mRequiresCharging = constraints.mRequiresCharging;
        this.mRequiresDeviceIdle = constraints.mRequiresDeviceIdle;
        this.mRequiredNetworkType = constraints.mRequiredNetworkType;
        this.mRequiresBatteryNotLow = constraints.mRequiresBatteryNotLow;
        this.mRequiresStorageNotLow = constraints.mRequiresStorageNotLow;
        this.mContentUriTriggers = constraints.mContentUriTriggers;
    }
}
