package com.appsflyer.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.mpl.androidapp.utils.Constant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class aq extends an {
    public a AFKeystoreWrapper;
    public String AFLogger$LogLevel;
    public String init;
    public boolean values = false;

    public interface a {
        void AFKeystoreWrapper(String str);

        void valueOf(Map<String, String> map);
    }

    public aq(Uri uri, ac acVar, Context context) {
        super(acVar, context, HttpGetRequest.METHOD_GET);
        if (!TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(uri.getPath())) {
            String[] strArr = {"onelink.me", "onelnk.com", "app.aflink.com"};
            boolean z = false;
            for (int i = 0; i < 3; i++) {
                if (uri.getHost().contains(strArr[i])) {
                    z = true;
                }
            }
            if (f.AFLogger$LogLevel != null) {
                StringBuilder sb = new StringBuilder("Validate if link ");
                sb.append(uri);
                sb.append(" belongs to custom domains: ");
                sb.append(Arrays.asList(f.AFLogger$LogLevel));
                AFLogger.AFKeystoreWrapper(sb.toString());
                for (String str : f.AFLogger$LogLevel) {
                    if (uri.getHost().contains(str) && !TextUtils.isEmpty(str)) {
                        AFLogger.AFInAppEventParameterName("Link matches custom domain: ".concat(String.valueOf(str)));
                        this.values = true;
                        z = true;
                    }
                }
            }
            String[] split = uri.getPath().split("/");
            if (z && split.length == 3) {
                this.AFInAppEventParameterName = split[1];
                this.AFLogger$LogLevel = split[2];
                this.init = uri.toString();
            }
        }
    }

    public final void AFInAppEventParameterName(HttpsURLConnection httpsURLConnection) {
        httpsURLConnection.setRequestProperty("Af-UUID", this.AppsFlyer2dXConversionCallback);
        String valueOf = String.valueOf(this.AFVersionDeclaration.get(Constant.BUILD_NUMBER));
        httpsURLConnection.setRequestProperty("Af-Meta-Sdk-Ver", valueOf);
        httpsURLConnection.setRequestProperty("Af-Meta-Counter", String.valueOf(this.AFVersionDeclaration.get("counter")));
        httpsURLConnection.setRequestProperty("Af-Meta-Model", String.valueOf(this.AFVersionDeclaration.get("model")));
        httpsURLConnection.setRequestProperty("Af-Meta-Platform", String.valueOf(this.AFVersionDeclaration.get("platformextension")));
        httpsURLConnection.setRequestProperty("Af-Meta-System-Version", String.valueOf(this.AFVersionDeclaration.get("sdk")));
        AFKeystoreWrapper(httpsURLConnection, this.valueOf, this.AppsFlyer2dXConversionCallback, this.AFInAppEventParameterName, this.AFLogger$LogLevel, valueOf);
    }

    public final boolean AFInAppEventType() {
        return !TextUtils.isEmpty(this.AFInAppEventParameterName) && !TextUtils.isEmpty(this.AFLogger$LogLevel) && !this.AFInAppEventParameterName.equals("app");
    }

    public final void valueOf(String str) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            this.AFKeystoreWrapper.valueOf(hashMap);
        } catch (JSONException e2) {
            this.AFKeystoreWrapper.AFKeystoreWrapper("Can't parse OneLink data");
            AFLogger.valueOf("Error while parsing to json ".concat(String.valueOf(str)), e2);
        }
    }

    public final String values() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(an.AFInAppEventType, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ac.AFInAppEventParameterName().getHostName()}));
        sb.append("/");
        sb.append(this.AFInAppEventParameterName);
        sb.append("?id=");
        sb.append(this.AFLogger$LogLevel);
        return sb.toString();
    }

    public final void valueOf() {
        String str = this.init;
        if (str == null) {
            str = "Can't get OneLink data";
        }
        this.AFKeystoreWrapper.AFKeystoreWrapper(str);
    }
}
