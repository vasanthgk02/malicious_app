package com.facebook.applinks;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.razorpay.AnalyticsConstants;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLinkData {
    public Bundle argumentBundle;
    public JSONObject arguments;
    public Uri targetUri;

    public interface CompletionHandler {
        void onDeferredAppLinkDataFetched(AppLinkData appLinkData);
    }

    public static AppLinkData createFromJson(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("version");
            if (jSONObject.getJSONObject("bridge_args").getString(AnalyticsConstants.METHOD).equals("applink") && string.equals("2")) {
                AppLinkData appLinkData = new AppLinkData();
                JSONObject jSONObject2 = jSONObject.getJSONObject("method_args");
                appLinkData.arguments = jSONObject2;
                if (jSONObject2.has("ref")) {
                    appLinkData.arguments.getString("ref");
                } else if (appLinkData.arguments.has("referer_data")) {
                    JSONObject jSONObject3 = appLinkData.arguments.getJSONObject("referer_data");
                    if (jSONObject3.has("fb_ref")) {
                        jSONObject3.getString("fb_ref");
                    }
                }
                if (appLinkData.arguments.has("target_url")) {
                    Uri parse = Uri.parse(appLinkData.arguments.getString("target_url"));
                    appLinkData.targetUri = parse;
                    Class<AppLinkData> cls = AppLinkData.class;
                    if (!CrashShieldHandler.isObjectCrashing(cls) && parse != null) {
                        try {
                            String queryParameter = parse.getQueryParameter("al_applink_data");
                            if (queryParameter != null) {
                                try {
                                    new JSONObject(queryParameter);
                                } catch (JSONException unused) {
                                }
                            }
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, cls);
                        }
                    }
                }
                if (appLinkData.arguments.has("extras")) {
                    JSONObject jSONObject4 = appLinkData.arguments.getJSONObject("extras");
                    if (jSONObject4.has("deeplink_context")) {
                        JSONObject jSONObject5 = jSONObject4.getJSONObject("deeplink_context");
                        if (jSONObject5.has("promo_code")) {
                            jSONObject5.getString("promo_code");
                        }
                    }
                }
                appLinkData.argumentBundle = toBundle(appLinkData.arguments);
                return appLinkData;
            }
        } catch (JSONException e2) {
            Utility.logd("com.facebook.applinks.AppLinkData", "Unable to parse AppLink JSON", e2);
        } catch (FacebookException e3) {
            Utility.logd("com.facebook.applinks.AppLinkData", "Unable to parse AppLink JSON", e3);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0 = com.facebook.FacebookSdk.INSTANCE;
        r0 = com.facebook.FacebookSdk.isDebugEnabledField;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r0 = com.facebook.FacebookSdk.INSTANCE;
        r0 = com.facebook.FacebookSdk.isDebugEnabledField;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r10 = com.facebook.FacebookSdk.INSTANCE;
        r10 = com.facebook.FacebookSdk.isDebugEnabledField;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ce, code lost:
        r10 = com.facebook.FacebookSdk.INSTANCE;
        r10 = com.facebook.FacebookSdk.isDebugEnabledField;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0093 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00ae */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00c9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void fetchDeferredAppLinkFromServer(android.content.Context r9, java.lang.String r10, com.facebook.applinks.AppLinkData.CompletionHandler r11) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "event"
            java.lang.String r2 = "DEFERRED_APP_LINK"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00d6 }
            com.facebook.internal.AttributionIdentifiers r1 = com.facebook.internal.AttributionIdentifiers.Companion.getAttributionIdentifiers(r9)     // Catch:{ JSONException -> 0x00d6 }
            java.lang.String r2 = com.facebook.appevents.AppEventsLogger.Companion.getAnonymousAppDeviceGUID(r9)     // Catch:{ JSONException -> 0x00d6 }
            boolean r3 = com.facebook.FacebookSdk.getLimitEventAndDataUsage(r9)     // Catch:{ JSONException -> 0x00d6 }
            com.facebook.internal.Utility.setAppEventAttributionParameters(r0, r1, r2, r3)     // Catch:{ JSONException -> 0x00d6 }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ JSONException -> 0x00d6 }
            com.facebook.internal.Utility.setAppEventExtendedDeviceInfoParameters(r0, r1)     // Catch:{ JSONException -> 0x00d6 }
            java.lang.String r1 = "application_package_name"
            java.lang.String r9 = r9.getPackageName()     // Catch:{ JSONException -> 0x00d6 }
            r0.put(r1, r9)     // Catch:{ JSONException -> 0x00d6 }
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]
            r1 = 0
            r9[r1] = r10
            java.lang.String r10 = "%s/activities"
            java.lang.String r3 = java.lang.String.format(r10, r9)
            r9 = 0
            r2 = 0
            r6 = 0
            com.facebook.GraphRequest r10 = new com.facebook.GraphRequest     // Catch:{ Exception -> 0x00ce }
            com.facebook.HttpMethod r5 = com.facebook.HttpMethod.POST     // Catch:{ Exception -> 0x00ce }
            r4 = 0
            r7 = 0
            r8 = 32
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00ce }
            r10.graphObject = r0     // Catch:{ Exception -> 0x00ce }
            com.facebook.GraphResponse r10 = r10.executeAndWait()     // Catch:{ Exception -> 0x00ce }
            org.json.JSONObject r10 = r10.graphObject     // Catch:{ Exception -> 0x00ce }
            if (r10 == 0) goto L_0x00d2
            java.lang.String r0 = "applink_args"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x00ce }
            java.lang.String r1 = "click_time"
            r2 = -1
            long r4 = r10.optLong(r1, r2)     // Catch:{ Exception -> 0x00ce }
            java.lang.String r1 = "applink_class"
            java.lang.String r1 = r10.optString(r1)     // Catch:{ Exception -> 0x00ce }
            java.lang.String r6 = "applink_url"
            java.lang.String r10 = r10.optString(r6)     // Catch:{ Exception -> 0x00ce }
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00ce }
            if (r6 != 0) goto L_0x00d2
            com.facebook.applinks.AppLinkData r9 = createFromJson(r0)     // Catch:{ Exception -> 0x00ce }
            if (r9 == 0) goto L_0x00d2
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0097
            org.json.JSONObject r0 = r9.arguments     // Catch:{ JSONException -> 0x0093 }
            java.lang.String r2 = "com.facebook.platform.APPLINK_TAP_TIME_UTC"
            if (r0 == 0) goto L_0x0085
            org.json.JSONObject r0 = r9.arguments     // Catch:{ JSONException -> 0x0093 }
            r0.put(r2, r4)     // Catch:{ JSONException -> 0x0093 }
        L_0x0085:
            android.os.Bundle r0 = r9.argumentBundle     // Catch:{ JSONException -> 0x0093 }
            if (r0 == 0) goto L_0x0097
            android.os.Bundle r0 = r9.argumentBundle     // Catch:{ JSONException -> 0x0093 }
            java.lang.String r3 = java.lang.Long.toString(r4)     // Catch:{ JSONException -> 0x0093 }
            r0.putString(r2, r3)     // Catch:{ JSONException -> 0x0093 }
            goto L_0x0097
        L_0x0093:
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ Exception -> 0x00ce }
            boolean r0 = com.facebook.FacebookSdk.isDebugEnabledField     // Catch:{ Exception -> 0x00ce }
        L_0x0097:
            if (r1 == 0) goto L_0x00b2
            org.json.JSONObject r0 = r9.arguments     // Catch:{ JSONException -> 0x00ae }
            java.lang.String r2 = "com.facebook.platform.APPLINK_NATIVE_CLASS"
            if (r0 == 0) goto L_0x00a4
            org.json.JSONObject r0 = r9.arguments     // Catch:{ JSONException -> 0x00ae }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00ae }
        L_0x00a4:
            android.os.Bundle r0 = r9.argumentBundle     // Catch:{ JSONException -> 0x00ae }
            if (r0 == 0) goto L_0x00b2
            android.os.Bundle r0 = r9.argumentBundle     // Catch:{ JSONException -> 0x00ae }
            r0.putString(r2, r1)     // Catch:{ JSONException -> 0x00ae }
            goto L_0x00b2
        L_0x00ae:
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ Exception -> 0x00ce }
            boolean r0 = com.facebook.FacebookSdk.isDebugEnabledField     // Catch:{ Exception -> 0x00ce }
        L_0x00b2:
            if (r10 == 0) goto L_0x00d2
            org.json.JSONObject r0 = r9.arguments     // Catch:{ JSONException -> 0x00c9 }
            java.lang.String r1 = "com.facebook.platform.APPLINK_NATIVE_URL"
            if (r0 == 0) goto L_0x00bf
            org.json.JSONObject r0 = r9.arguments     // Catch:{ JSONException -> 0x00c9 }
            r0.put(r1, r10)     // Catch:{ JSONException -> 0x00c9 }
        L_0x00bf:
            android.os.Bundle r0 = r9.argumentBundle     // Catch:{ JSONException -> 0x00c9 }
            if (r0 == 0) goto L_0x00d2
            android.os.Bundle r0 = r9.argumentBundle     // Catch:{ JSONException -> 0x00c9 }
            r0.putString(r1, r10)     // Catch:{ JSONException -> 0x00c9 }
            goto L_0x00d2
        L_0x00c9:
            com.facebook.FacebookSdk r10 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ Exception -> 0x00ce }
            boolean r10 = com.facebook.FacebookSdk.isDebugEnabledField     // Catch:{ Exception -> 0x00ce }
            goto L_0x00d2
        L_0x00ce:
            com.facebook.FacebookSdk r10 = com.facebook.FacebookSdk.INSTANCE
            boolean r10 = com.facebook.FacebookSdk.isDebugEnabledField
        L_0x00d2:
            r11.onDeferredAppLinkDataFetched(r9)
            return
        L_0x00d6:
            r9 = move-exception
            com.facebook.FacebookException r10 = new com.facebook.FacebookException
            java.lang.String r11 = "An error occurred while preparing deferred app link"
            r10.<init>(r11, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.applinks.AppLinkData.fetchDeferredAppLinkFromServer(android.content.Context, java.lang.String, com.facebook.applinks.AppLinkData$CompletionHandler):void");
    }

    public static Bundle toBundle(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONObject) {
                bundle.putBundle(next, toBundle((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                int i = 0;
                if (jSONArray.length() == 0) {
                    bundle.putStringArray(next, new String[0]);
                } else {
                    Object obj2 = jSONArray.get(0);
                    if (obj2 instanceof JSONObject) {
                        Bundle[] bundleArr = new Bundle[jSONArray.length()];
                        while (i < jSONArray.length()) {
                            bundleArr[i] = toBundle(jSONArray.getJSONObject(i));
                            i++;
                        }
                        bundle.putParcelableArray(next, bundleArr);
                    } else if (!(obj2 instanceof JSONArray)) {
                        String[] strArr = new String[jSONArray.length()];
                        while (i < jSONArray.length()) {
                            strArr[i] = jSONArray.get(i).toString();
                            i++;
                        }
                        bundle.putStringArray(next, strArr);
                    } else {
                        throw new FacebookException((String) "Nested arrays are not supported.");
                    }
                }
            } else {
                bundle.putString(next, obj.toString());
            }
        }
        return bundle;
    }
}
