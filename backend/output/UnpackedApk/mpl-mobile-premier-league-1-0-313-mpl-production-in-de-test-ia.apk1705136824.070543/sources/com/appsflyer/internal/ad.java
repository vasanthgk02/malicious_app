package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.an.c;
import com.mpl.androidapp.login.LoginReactModule;
import com.netcore.android.SMTEventParamKeys;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;
import org.json.JSONObject;

public final class ad implements Runnable {
    public static String AFInAppEventType = null;
    public static String valueOf = "https://%ssdk-services.%s/validate-android-signature";
    public String AFInAppEventParameterName;
    public WeakReference<Context> AFKeystoreWrapper;
    public String AFLogger$LogLevel;
    public String AFVersionDeclaration;
    public Map<String, String> AppsFlyer2dXConversionCallback;
    public String getLevel;
    public String init;
    public String values;

    static {
        StringBuilder sb = new StringBuilder("https://%svalidate.%s/api/v");
        sb.append(ac.AFInAppEventType);
        sb.append("/androidevent?buildnumber=6.5.4&app_id=");
        AFInAppEventType = sb.toString();
    }

    public ad(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map) {
        this.AFKeystoreWrapper = new WeakReference<>(context);
        this.AFInAppEventParameterName = str;
        this.values = str2;
        this.init = str4;
        this.AFVersionDeclaration = str5;
        this.AFLogger$LogLevel = str6;
        this.AppsFlyer2dXConversionCallback = map;
        this.getLevel = str3;
    }

    public static /* synthetic */ void valueOf(ad adVar, Map map, Map map2, WeakReference weakReference) {
        if (weakReference.get() != null) {
            w.AFKeystoreWrapper((Context) weakReference.get()).AFInAppEventType();
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(AFInAppEventType, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ac.AFInAppEventParameterName().getHostName()}));
            sb.append(((Context) weakReference.get()).getPackageName());
            String obj = sb.toString();
            String string = ac.AFInAppEventType((Context) weakReference.get()).getString("referrer", "");
            cu cuVar = new cu((Context) weakReference.get());
            cuVar.AFVersionDeclaration = adVar.AFInAppEventParameterName;
            cuVar.AppsFlyer2dXConversionCallback = string;
            ac AFInAppEventParameterName2 = ac.AFInAppEventParameterName();
            Map<String, Object> AFInAppEventType2 = AFInAppEventParameterName2.AFInAppEventType((i) cuVar);
            AFInAppEventType2.put(ECommerceParamNames.PRICE, adVar.AFVersionDeclaration);
            AFInAppEventType2.put("currency", adVar.AFLogger$LogLevel);
            AFInAppEventType2.put("receipt_data", map);
            if (map2 != null) {
                AFInAppEventType2.put("extra_prms", map2);
            }
            AFInAppEventType2.putAll(AFInAppEventParameterName2.values().init().AFInAppEventParameterName());
            ak.AFInAppEventType().AFInAppEventType(obj, new JSONObject(AFInAppEventType2).toString());
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection AFKeystoreWrapper2 = AFKeystoreWrapper((ct) cuVar.AFInAppEventParameterName(AFInAppEventType2).AFInAppEventType(obj));
                int i = -1;
                if (AFKeystoreWrapper2 != null) {
                    i = AFKeystoreWrapper2.getResponseCode();
                }
                String AFInAppEventParameterName3 = ac.AFInAppEventParameterName(AFKeystoreWrapper2);
                ak.AFInAppEventType().values(obj, i, AFInAppEventParameterName3);
                StringBuilder sb2 = new StringBuilder("Validate-WH response - ");
                sb2.append(i);
                sb2.append(": ");
                sb2.append(new JSONObject(AFInAppEventParameterName3).toString());
                AFLogger.values(sb2.toString());
                if (AFKeystoreWrapper2 != null) {
                    AFKeystoreWrapper2.disconnect();
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    public final void run() {
        String str = this.AFInAppEventParameterName;
        if (str != null && str.length() != 0 && !AppsFlyerLib.getInstance().isStopped()) {
            HttpURLConnection httpURLConnection = null;
            try {
                Context context = this.AFKeystoreWrapper.get();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("public-key", this.values);
                    hashMap.put("sig-data", this.init);
                    hashMap.put("signature", this.getLevel);
                    final HashMap hashMap2 = new HashMap(hashMap);
                    new Thread(new Runnable() {
                        public final void run() {
                            ad adVar = ad.this;
                            ad.valueOf(adVar, hashMap2, adVar.AppsFlyer2dXConversionCallback, ad.this.AFKeystoreWrapper);
                        }
                    }).start();
                    hashMap.put("dev_key", this.AFInAppEventParameterName);
                    hashMap.put("app_id", context.getPackageName());
                    hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
                    String string = AppsFlyerProperties.getInstance().getString(SMTEventParamKeys.SMT_AD_ID);
                    if (string != null) {
                        hashMap.put(SMTEventParamKeys.SMT_AD_ID, string);
                    }
                    String jSONObject = new JSONObject(hashMap).toString();
                    String format = String.format(valueOf, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ac.AFInAppEventParameterName().getHostName()});
                    ak.AFInAppEventType().AFInAppEventType(format, jSONObject);
                    HttpURLConnection AFKeystoreWrapper2 = AFKeystoreWrapper((ct) new cr().AFInAppEventParameterName(hashMap).AFInAppEventType(format));
                    int i = -1;
                    if (AFKeystoreWrapper2 != null) {
                        i = AFKeystoreWrapper2.getResponseCode();
                    }
                    ac.AFInAppEventParameterName();
                    String AFInAppEventParameterName2 = ac.AFInAppEventParameterName(AFKeystoreWrapper2);
                    ak.AFInAppEventType().values(format, i, AFInAppEventParameterName2);
                    JSONObject jSONObject2 = new JSONObject(AFInAppEventParameterName2);
                    jSONObject2.put("code", i);
                    if (i == 200) {
                        StringBuilder sb = new StringBuilder("Validate response 200 ok: ");
                        sb.append(jSONObject2.toString());
                        AFLogger.values(sb.toString());
                        AFKeystoreWrapper(jSONObject2.optBoolean(LoginReactModule.RESULT), this.init, this.AFVersionDeclaration, this.AFLogger$LogLevel, jSONObject2.toString());
                    } else {
                        AFLogger.values((String) "Failed Validate request");
                        AFKeystoreWrapper(false, this.init, this.AFVersionDeclaration, this.AFLogger$LogLevel, jSONObject2.toString());
                    }
                    if (AFKeystoreWrapper2 != null) {
                        AFKeystoreWrapper2.disconnect();
                    }
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    public static HttpURLConnection AFKeystoreWrapper(ct ctVar) {
        StringBuilder sb = new StringBuilder("Calling ");
        sb.append(ctVar.onDeepLinkingNative);
        AFLogger.AFInAppEventParameterName(sb.toString());
        ctVar.onConversionDataSuccess = AppsFlyerLib.getInstance().isStopped();
        return new c(ctVar).values();
    }

    public static void AFKeystoreWrapper(boolean z, String str, String str2, String str3, String str4) {
        if (ac.AFInAppEventParameterName != null) {
            StringBuilder sb = new StringBuilder("Validate callback parameters: ");
            sb.append(str);
            sb.append(CMap.SPACE);
            sb.append(str2);
            sb.append(CMap.SPACE);
            sb.append(str3);
            AFLogger.AFInAppEventParameterName(sb.toString());
            if (z) {
                AFLogger.AFInAppEventParameterName("Validate in app purchase success: ".concat(String.valueOf(str4)));
                ac.AFInAppEventParameterName.onValidateInApp();
                return;
            }
            AFLogger.AFInAppEventParameterName("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = ac.AFInAppEventParameterName;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }
}
