package com.appsflyer;

import com.appsflyer.CreateOneLinkHttpTask.ResponseListener;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.razorpay.AnalyticsConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppsFlyer2dXConversionCallback implements AppsFlyerConversionListener, ResponseListener, DeepLinkListener {
    private void AFKeystoreWrapper(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", AnalyticsConstants.FAILURE);
            jSONObject.put("data", str2);
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1390007222) {
                if (hashCode == 1050716216) {
                    if (str.equals("onInstallConversionFailure")) {
                        c2 = 0;
                    }
                }
            } else if (str.equals("onAttributionFailure")) {
                c2 = 1;
            }
            if (c2 != 0) {
                if (c2 == 1) {
                    onAttributionFailureNative(jSONObject);
                }
                return;
            }
            onInstallConversionFailureNative(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        onAppOpenAttributionNative(map);
    }

    public native void onAppOpenAttributionNative(Object obj);

    public void onAttributionFailure(String str) {
        AFKeystoreWrapper("onInstallConversionFailure", str);
    }

    public native void onAttributionFailureNative(Object obj);

    public void onConversionDataFail(String str) {
        AFKeystoreWrapper("onAttributionFailure", str);
    }

    public void onConversionDataSuccess(Map<String, Object> map) {
        onInstallConversionDataLoadedNative(map);
    }

    public void onDeepLinking(DeepLinkResult deepLinkResult) {
        onDeepLinkingNative(deepLinkResult);
    }

    public native void onDeepLinkingNative(DeepLinkResult deepLinkResult);

    public native void onInstallConversionDataLoadedNative(Object obj);

    public native void onInstallConversionFailureNative(Object obj);

    public void onResponse(String str) {
        onResponseNative(str);
    }

    public void onResponseError(String str) {
        onResponseErrorNative(str);
    }

    public native void onResponseErrorNative(String str);

    public native void onResponseNative(String str);
}
