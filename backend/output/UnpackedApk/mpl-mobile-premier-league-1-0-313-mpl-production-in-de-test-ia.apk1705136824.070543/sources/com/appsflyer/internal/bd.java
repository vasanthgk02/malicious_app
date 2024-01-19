package com.appsflyer.internal;

import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

public final class bd {
    public static String AFInAppEventParameterName = "https://%smonitorsdk.%s/remote-debug?app_id=";
    public static String AFKeystoreWrapper = "https://cdn-testsettings.appsflyersdk.com/android/v1/%s/settings";
    public static String values = "https://cdn-settings.appsflyersdk.com/android/v1/%s/settings";
    public final ab AFInAppEventType;
    public final AppsFlyerProperties AFLogger$LogLevel;
    public final aa valueOf;

    public bd(ab abVar, aa aaVar, AppsFlyerProperties appsFlyerProperties) {
        this.AFInAppEventType = abVar;
        this.valueOf = aaVar;
        this.AFLogger$LogLevel = appsFlyerProperties;
    }

    public final boolean AFInAppEventType() {
        return !this.AFLogger$LogLevel.getBoolean(AppsFlyerProperties.HTTP_CACHE, true);
    }

    public final bl<String> AFKeystoreWrapper(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(AFInAppEventParameterName, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ac.AFInAppEventParameterName().getHostName()}));
        sb.append(this.valueOf.AFInAppEventParameterName.getPackageName());
        z zVar = new z(sb.toString(), new JSONObject(map).toString().getBytes(), RNCWebViewManager.HTTP_METHOD_POST, Collections.emptyMap(), false);
        bj bjVar = new bj();
        zVar.AFInAppEventParameterName = AFInAppEventType();
        ab abVar = this.AFInAppEventType;
        return new bl<>(zVar, abVar.AFKeystoreWrapper, abVar.valueOf, bjVar);
    }
}
