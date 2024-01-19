package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.deeplink.DeepLinkResult.Error;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ao {
    public final String AFInAppEventParameterName;
    public final boolean AFInAppEventType;
    public final cs AFKeystoreWrapper;
    public final String valueOf;

    public ao() {
    }

    public static void AFInAppEventType(String str, Error error) {
        if (f.valueOf().values != null) {
            AFLogger.AFInAppEventParameterName("[DDL] Error occurred: ".concat(String.valueOf(str)));
            AFInAppEventType(new DeepLinkResult(null, error));
            return;
        }
        AFKeystoreWrapper(str);
    }

    public static void AFKeystoreWrapper(Map<String, String> map) {
        if (ac.AFKeystoreWrapper != null) {
            try {
                StringBuilder sb = new StringBuilder("Calling onAppOpenAttribution with:\n");
                sb.append(map.toString());
                AFLogger.AFInAppEventParameterName(sb.toString());
                ac.AFKeystoreWrapper.onAppOpenAttribution(map);
            } catch (Throwable th) {
                AFLogger.valueOf(th.getLocalizedMessage(), th);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ao.class != obj.getClass()) {
            return false;
        }
        ao aoVar = (ao) obj;
        if (this.AFInAppEventType == aoVar.AFInAppEventType && this.valueOf.equals(aoVar.valueOf)) {
            return this.AFInAppEventParameterName.equals(aoVar.AFInAppEventParameterName);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.valueOf.hashCode();
        return this.AFInAppEventParameterName.hashCode() + ((hashCode + ((this.AFInAppEventType ? 1 : 0) * true)) * 31);
    }

    public ao(String str) throws JSONException {
        cs csVar;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.valueOf = jSONObject.getString("ver");
                this.AFInAppEventType = jSONObject.optBoolean(PaymentConstants.TEST_MODE);
                this.AFInAppEventParameterName = str;
                if (this.valueOf.startsWith("default")) {
                    csVar = cs.DEFAULT;
                } else {
                    csVar = cs.CUSTOM;
                }
                this.AFKeystoreWrapper = csVar;
            } catch (JSONException unused) {
                throw new JSONException("Failed to parse remote configuration JSON");
            }
        } else {
            throw new JSONException("Failed to parse remote configuration JSON: originalJson is null");
        }
    }

    public static void AFInAppEventType(Map<String, String> map) {
        DeepLinkResult deepLinkResult;
        if (f.valueOf().values != null) {
            try {
                DeepLink valueOf2 = DeepLink.valueOf(map);
                valueOf2.valueOf.put("is_deferred", false);
                deepLinkResult = new DeepLinkResult(valueOf2, null);
            } catch (JSONException e2) {
                AFLogger.AFInAppEventParameterName((String) "[DDL] Error occurred", (Throwable) e2);
                deepLinkResult = new DeepLinkResult(null, Error.UNEXPECTED);
            } catch (Throwable th) {
                AFInAppEventType(new DeepLinkResult(null, null));
                throw th;
            }
            AFInAppEventType(deepLinkResult);
            return;
        }
        AFKeystoreWrapper(map);
    }

    public static void AFKeystoreWrapper(String str) {
        if (ac.AFKeystoreWrapper != null) {
            try {
                AFLogger.AFInAppEventParameterName("Calling onAppOpenAttributionFailure with: ".concat(String.valueOf(str)));
                ac.AFKeystoreWrapper.onAttributionFailure(str);
            } catch (Throwable th) {
                AFLogger.valueOf(th.getLocalizedMessage(), th);
            }
        }
    }

    public static void AFInAppEventType(DeepLinkResult deepLinkResult) {
        if (f.valueOf().values != null) {
            StringBuilder sb = new StringBuilder("[DDL] Calling onDeepLinking with:\n");
            sb.append(deepLinkResult.toString());
            AFLogger.AFInAppEventParameterName(sb.toString());
            try {
                f.valueOf().values.onDeepLinking(deepLinkResult);
            } catch (Throwable th) {
                AFLogger.valueOf(th.getLocalizedMessage(), th);
            }
        } else {
            AFLogger.AFInAppEventParameterName("[DDL] skipping, no callback registered");
        }
    }
}
