package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.appsflyer.AFLogger;
import com.netcore.android.preference.SMTPreferenceConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public final class cg {
    public static Map<String, Object> AFInAppEventParameterName(Context context) throws ce {
        String string = ac.AFInAppEventType(context).getString("attributionId", null);
        if (string != null && string.length() > 0) {
            return values(string);
        }
        throw new ce();
    }

    public static void AFInAppEventType(ac acVar, i iVar, String str, Context context, SharedPreferences sharedPreferences, Integer num, Throwable th) {
        ac acVar2 = acVar;
        Context context2 = context;
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (iVar.valueOf()) {
            if (ac.AFKeystoreWrapper == null) {
                AFLogger.AFInAppEventParameterName("[GCD-E01] AppsFlyerConversionListener is null - skip gcd");
                return;
            }
            StringBuilder sb = new StringBuilder("[GCD-A01] Loading conversion data. Counter: ");
            sb.append(iVar.onInstallConversionFailureNative);
            AFLogger.AFInAppEventParameterName(sb.toString());
            long j = sharedPreferences2.getLong("appsflyerConversionDataCacheExpiration", 0);
            if (j != 0 && System.currentTimeMillis() - j > 5184000000L) {
                AFLogger.AFInAppEventParameterName("[GCD-E02] Cached conversion data expired");
                ac.values(context2, (String) "sixtyDayConversionData");
                ac.valueOf(context2, (String) "attributionId", (String) null);
                acVar.AFInAppEventType(context2, (String) "appsflyerConversionDataCacheExpiration", 0);
            }
            if (sharedPreferences2.getString("attributionId", null) != null) {
                if (acVar.valueOf(sharedPreferences2, false) > 1) {
                    try {
                        Map<String, Object> AFInAppEventParameterName = AFInAppEventParameterName(context);
                        if (AFInAppEventParameterName != null) {
                            try {
                                if (!AFInAppEventParameterName.containsKey(SMTPreferenceConstants.SMT_IS_FIRST_LAUNCH)) {
                                    AFInAppEventParameterName.put(SMTPreferenceConstants.SMT_IS_FIRST_LAUNCH, Boolean.FALSE);
                                }
                                cc.values(AFInAppEventParameterName);
                            } catch (Throwable th2) {
                                AFLogger.valueOf(th2.getLocalizedMessage(), th2);
                            }
                        }
                    } catch (ce e2) {
                        AFLogger.valueOf(e2.getMessage(), e2);
                    }
                }
            } else if (th != null) {
                StringBuilder sb2 = new StringBuilder("Launch exception: ");
                sb2.append(th.getMessage());
                cc.AFInAppEventParameterName(sb2.toString());
            } else if (num.intValue() != 200) {
                cc.AFInAppEventParameterName("Launch status code: ".concat(String.valueOf(num)));
            } else {
                cc ccVar = new cc(acVar, (Application) context.getApplicationContext(), str);
                ac.valueOf(ccVar.AFInAppEventParameterName, ccVar, 10, TimeUnit.MILLISECONDS);
            }
        }
    }

    public static Map<String, Object> values(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!next.equals("is_cache")) {
                    hashMap.put(next, jSONObject.isNull(next) ? null : jSONObject.get(next));
                }
            }
            return hashMap;
        } catch (JSONException e2) {
            AFLogger.valueOf(e2.getMessage(), e2);
            return null;
        }
    }
}
