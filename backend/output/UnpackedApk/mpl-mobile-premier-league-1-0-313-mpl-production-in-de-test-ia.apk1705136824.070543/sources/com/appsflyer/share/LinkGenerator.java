package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.CreateOneLinkHttpTask.ResponseListener;
import com.appsflyer.internal.ac;
import com.appsflyer.internal.am;
import com.appsflyer.internal.db;
import com.appsflyer.internal.k;
import com.squareup.picasso.NetworkRequestHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LinkGenerator {
    public String AFInAppEventParameterName;
    public String AFInAppEventType;
    public String AFKeystoreWrapper;
    public String AFLogger$LogLevel;
    public String AFVersionDeclaration;
    public String AppsFlyer2dXConversionCallback;
    public String getLevel;
    public String init;
    public final Map<String, String> onAppOpenAttributionNative = new HashMap();
    public String onAttributionFailureNative;
    public String onInstallConversionFailureNative;
    public String valueOf;
    public final String values;

    public LinkGenerator(String str) {
        this.values = str;
    }

    public static String AFInAppEventParameterName(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Entry next : map.entrySet()) {
            if (sb.length() == 0) {
                sb.append('?');
            } else {
                sb.append('&');
            }
            sb.append((String) next.getKey());
            sb.append('=');
            sb.append((String) next.getValue());
        }
        return sb.toString();
    }

    private Map<String, String> values() {
        HashMap hashMap = new HashMap();
        hashMap.put("pid", this.values);
        String str = this.AppsFlyer2dXConversionCallback;
        if (str != null) {
            hashMap.put("af_referrer_uid", str);
        }
        String str2 = this.valueOf;
        if (str2 != null) {
            hashMap.put(AFInAppEventParameterName.AF_CHANNEL, str2);
        }
        String str3 = this.getLevel;
        if (str3 != null) {
            hashMap.put("af_referrer_customer_id", str3);
        }
        String str4 = this.AFInAppEventParameterName;
        if (str4 != null) {
            hashMap.put("c", str4);
        }
        String str5 = this.AFVersionDeclaration;
        if (str5 != null) {
            hashMap.put("af_referrer_name", str5);
        }
        String str6 = this.init;
        if (str6 != null) {
            hashMap.put("af_referrer_image_url", str6);
        }
        if (this.onAttributionFailureNative != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.onAttributionFailureNative);
            String str7 = this.AFLogger$LogLevel;
            if (str7 != null) {
                String str8 = "";
                this.AFLogger$LogLevel = str7.replaceFirst("^[/]", str8);
                if (!this.onAttributionFailureNative.endsWith("/")) {
                    str8 = "/";
                }
                sb.append(str8);
                sb.append(this.AFLogger$LogLevel);
            }
            hashMap.put("af_dp", sb.toString());
        }
        for (Entry next : this.onAppOpenAttributionNative.entrySet()) {
            hashMap.put(next.getKey(), next.getValue());
        }
        return am.AFKeystoreWrapper(hashMap);
    }

    public LinkGenerator addParameter(String str, String str2) {
        this.onAppOpenAttributionNative.put(str, str2);
        return this;
    }

    public LinkGenerator addParameters(Map<String, String> map) {
        if (map != null) {
            this.onAppOpenAttributionNative.putAll(map);
        }
        return this;
    }

    public String generateLink() {
        StringBuilder sb = new StringBuilder();
        String str = this.AFInAppEventType;
        if (str == null || !str.startsWith(NetworkRequestHandler.SCHEME_HTTP)) {
            sb.append(String.format(db.AFInAppEventParameterName, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ac.AFInAppEventParameterName().getHostName()}));
        } else {
            sb.append(this.AFInAppEventType);
        }
        if (this.AFKeystoreWrapper != null) {
            sb.append('/');
            sb.append(this.AFKeystoreWrapper);
        }
        sb.append(AFInAppEventParameterName(values()));
        return sb.toString();
    }

    public String getBrandDomain() {
        return this.onInstallConversionFailureNative;
    }

    public String getCampaign() {
        return this.AFInAppEventParameterName;
    }

    public String getChannel() {
        return this.valueOf;
    }

    public String getMediaSource() {
        return this.values;
    }

    public Map<String, String> getUserParams() {
        return new HashMap(this.onAppOpenAttributionNative);
    }

    public LinkGenerator setBaseDeeplink(String str) {
        this.onAttributionFailureNative = str;
        return this;
    }

    public LinkGenerator setBaseURL(String str, String str2, String str3) {
        if (str == null || str.length() <= 0) {
            this.AFInAppEventType = String.format("https://%s/%s", new Object[]{String.format("%sapp.%s", new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ac.AFInAppEventParameterName().getHostName()}), str3});
        } else {
            if (str2 == null || str2.length() < 5) {
                str2 = "go.onelink.me";
            }
            this.AFInAppEventType = String.format("https://%s/%s", new Object[]{str2, str});
        }
        return this;
    }

    public LinkGenerator setBrandDomain(String str) {
        this.onInstallConversionFailureNative = str;
        return this;
    }

    public LinkGenerator setCampaign(String str) {
        this.AFInAppEventParameterName = str;
        return this;
    }

    public LinkGenerator setChannel(String str) {
        this.valueOf = str;
        return this;
    }

    public LinkGenerator setDeeplinkPath(String str) {
        this.AFLogger$LogLevel = str;
        return this;
    }

    public LinkGenerator setReferrerCustomerId(String str) {
        this.getLevel = str;
        return this;
    }

    public LinkGenerator setReferrerImageURL(String str) {
        this.init = str;
        return this;
    }

    public LinkGenerator setReferrerName(String str) {
        this.AFVersionDeclaration = str;
        return this;
    }

    public LinkGenerator setReferrerUID(String str) {
        this.AppsFlyer2dXConversionCallback = str;
        return this;
    }

    public void generateLink(Context context, ResponseListener responseListener) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        String str = this.onInstallConversionFailureNative;
        Map<String, String> values2 = values();
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.values("CustomerUserId not set, generate User Invite Link is disabled", true);
            return;
        }
        CreateOneLinkHttpTask createOneLinkHttpTask = new CreateOneLinkHttpTask(string, values2, ac.AFInAppEventParameterName(), context);
        createOneLinkHttpTask.AFKeystoreWrapper = responseListener;
        createOneLinkHttpTask.values = str;
        if (k.values == null) {
            k.values = new k();
        }
        k.values.AFInAppEventType().execute(createOneLinkHttpTask);
    }
}
