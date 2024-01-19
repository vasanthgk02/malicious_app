package com.reactnativecommunity.netinfo.types;

import com.razorpay.AnalyticsConstants;

public enum ConnectionType {
    BLUETOOTH(AnalyticsConstants.BLUETOOTH),
    CELLULAR(AnalyticsConstants.CELLULAR),
    ETHERNET("ethernet"),
    NONE("none"),
    UNKNOWN("unknown"),
    WIFI(AnalyticsConstants.WIFI),
    WIMAX("wimax"),
    VPN("vpn");
    
    public final String label;

    /* access modifiers changed from: public */
    ConnectionType(String str) {
        this.label = str;
    }
}
