package com.appsflyer.internal;

import android.content.Context;

public abstract class cm extends i {
    public final boolean onAttributionFailureNative;
    public boolean onConversionDataSuccess;
    public final boolean onInstallConversionDataLoadedNative;

    public cm() {
        this(null, null, null, null, null, null);
    }

    public final boolean AFLogger$LogLevel() {
        return this.onConversionDataSuccess;
    }

    public final boolean AppsFlyer2dXConversionCallback() {
        return this.onAttributionFailureNative;
    }

    public final boolean getLevel() {
        return this.onInstallConversionDataLoadedNative;
    }

    public cm(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, Context context) {
        super(str, str2, Boolean.valueOf(bool3 != null ? bool3.booleanValue() : false), context);
        boolean z = true;
        this.onAttributionFailureNative = bool != null ? bool.booleanValue() : true;
        this.onInstallConversionDataLoadedNative = bool2 != null ? bool2.booleanValue() : z;
    }
}
