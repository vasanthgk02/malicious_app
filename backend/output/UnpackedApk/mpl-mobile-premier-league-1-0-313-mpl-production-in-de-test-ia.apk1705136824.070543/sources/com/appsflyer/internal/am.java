package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class am {
    public final String AFInAppEventType;
    public final long AFKeystoreWrapper;
    public final boolean values;

    public am() {
    }

    public static Map<String, String> AFKeystoreWrapper(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Entry next : map.entrySet()) {
            try {
                hashMap.put(URLEncoder.encode((String) next.getKey(), WebViewGamesContainer.ENCODING_NAME), URLEncoder.encode((String) next.getValue(), WebViewGamesContainer.ENCODING_NAME));
            } catch (UnsupportedEncodingException e2) {
                AFLogger.values((Throwable) e2);
            }
        }
        return hashMap;
    }

    public final boolean values() {
        return this.values;
    }

    public am(String str, long j, boolean z) {
        this.AFInAppEventType = str;
        this.AFKeystoreWrapper = j;
        this.values = z;
    }
}
