package com.paypal.android.sdk.onetouch.core.fpti;

import io.sentry.protocol.Browser;

public enum TrackingPoint {
    SwitchToBrowser("switchaway", Browser.TYPE),
    SwitchToWallet("switchaway", "wallet"),
    Cancel("switchback", "cancel"),
    Return("switchback", "return"),
    Error("switchback", "cancel", true);
    
    public final String mC;
    public final String mD;
    public final boolean mHasError;

    /* access modifiers changed from: public */
    TrackingPoint(String str, String str2, boolean z) {
        this.mC = str;
        this.mD = str2;
        this.mHasError = z;
    }

    public String getCd() {
        return this.mC + ":" + this.mD;
    }

    public boolean hasError() {
        return this.mHasError;
    }

    /* access modifiers changed from: public */
    TrackingPoint(String str, String str2) {
        this(r7, r8, str, str2, false);
    }
}
