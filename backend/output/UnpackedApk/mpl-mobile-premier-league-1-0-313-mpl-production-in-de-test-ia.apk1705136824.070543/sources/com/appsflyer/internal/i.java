package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

public abstract class i {
    public AppsFlyerRequestListener AFInAppEventParameterName;
    public final Map<String, Object> AFInAppEventType;
    public Application AFKeystoreWrapper;
    public byte[] AFLogger$LogLevel;
    public String AFVersionDeclaration;
    public String AppsFlyer2dXConversionCallback;
    public String getLevel;
    public String init;
    public String onDeepLinkingNative;
    public final boolean onInstallConversionDataLoadedNative;
    public int onInstallConversionFailureNative;
    public String valueOf;
    public Map<String, Object> values;

    public i() {
        this(null, null, null, null);
    }

    public final i AFInAppEventParameterName(Map<String, ?> map) {
        synchronized (map) {
            try {
                this.AFInAppEventType.putAll(map);
            }
        }
        return this;
    }

    public i AFInAppEventType(String str) {
        this.onDeepLinkingNative = str;
        return this;
    }

    public final boolean valueOf() {
        return this.getLevel == null && this.init == null;
    }

    public final Map<String, Object> values() {
        return this.AFInAppEventType;
    }

    public i(String str, String str2, Boolean bool, Context context) {
        this.AFInAppEventType = new HashMap();
        this.getLevel = str;
        this.onDeepLinkingNative = str2;
        this.onInstallConversionDataLoadedNative = bool != null ? bool.booleanValue() : true;
        if (context != null) {
            this.AFKeystoreWrapper = (Application) context.getApplicationContext();
        }
    }

    public final boolean AFInAppEventType() {
        return this.onInstallConversionDataLoadedNative;
    }

    public final i valueOf(int i) {
        this.onInstallConversionFailureNative = i;
        synchronized (this.AFInAppEventType) {
            try {
                if (this.AFInAppEventType.containsKey("counter")) {
                    this.AFInAppEventType.put("counter", Integer.toString(i));
                }
                if (this.AFInAppEventType.containsKey("launch_counter")) {
                    this.AFInAppEventType.put("launch_counter", Integer.toString(i));
                }
            }
        }
        return this;
    }

    public final String values(String str) {
        String AFInAppEventParameterName2 = ac.AFInAppEventParameterName().AFInAppEventParameterName((Context) this.AFKeystoreWrapper);
        return AFInAppEventParameterName2 != null ? Uri.parse(str).buildUpon().appendQueryParameter("channel", AFInAppEventParameterName2).build().toString() : str;
    }

    public final byte[] AFInAppEventParameterName() {
        return this.AFLogger$LogLevel;
    }
}
