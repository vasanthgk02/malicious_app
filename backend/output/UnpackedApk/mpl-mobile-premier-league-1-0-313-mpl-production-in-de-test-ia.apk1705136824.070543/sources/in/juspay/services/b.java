package in.juspay.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.core.app.NotificationCompatJellybean;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import in.juspay.hypersdk.core.Labels.SafeModeSDK;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.PaymentConstants.ENVIRONMENT;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.JuspayResponseHandlerDummyImpl;
import in.juspay.hypersdk.services.SdkConfigService;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.utils.IntegrationUtils;
import in.juspay.hypersdk.utils.Utils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 2
            r2 = 1
            switch(r0) {
                case -1711456453: goto L_0x0032;
                case -1125000185: goto L_0x0028;
                case -734907481: goto L_0x001e;
                case -484456411: goto L_0x0014;
                case 1654558699: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x003c
        L_0x000a:
            java.lang.String r0 = "PENDING_ORDER_STATUS"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x003c
            r3 = 2
            goto L_0x003d
        L_0x0014:
            java.lang.String r0 = "API_FAILURE"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x003c
            r3 = 3
            goto L_0x003d
        L_0x001e:
            java.lang.String r0 = "SOMETHING_WENT_WRONG"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x003c
            r3 = 4
            goto L_0x003d
        L_0x0028:
            java.lang.String r0 = "INVALID_REQUEST"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x003c
            r3 = 1
            goto L_0x003d
        L_0x0032:
            java.lang.String r0 = "USER_ABORTED"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x003c
            r3 = 0
            goto L_0x003d
        L_0x003c:
            r3 = -1
        L_0x003d:
            if (r3 == 0) goto L_0x004c
            if (r3 == r2) goto L_0x0049
            if (r3 == r1) goto L_0x0046
            java.lang.String r3 = "JP_011"
            return r3
        L_0x0046:
            java.lang.String r3 = "JP_006"
            return r3
        L_0x0049:
            java.lang.String r3 = "JP_003"
            return r3
        L_0x004c:
            java.lang.String r3 = "JP_002"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.services.b.a(java.lang.String):java.lang.String");
    }

    public static void a(final HyperPaymentsCallback hyperPaymentsCallback, FragmentActivity fragmentActivity, final JSONObject jSONObject) {
        final LocalBroadcastManager instance = LocalBroadcastManager.getInstance(fragmentActivity);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("PPSAFEMODE_RESULT");
        intentFilter.addAction("PPSAFEMODE_LOGEVENT");
        instance.registerReceiver(new BroadcastReceiver() {
            /* JADX INFO: finally extract failed */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
                if (r9.getAction().equals("PPSAFEMODE_RESULT") != false) goto L_0x005d;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x005d, code lost:
                r3.unregisterReceiver(r7);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x0083, code lost:
                if (r9.getAction().equals("PPSAFEMODE_RESULT") != false) goto L_0x005d;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onReceive(android.content.Context r8, android.content.Intent r9) {
                /*
                    r7 = this;
                    java.lang.String r8 = "PPSAFEMODE_RESULT"
                    if (r9 == 0) goto L_0x009d
                    java.lang.String r0 = r9.getAction()
                    if (r0 != 0) goto L_0x000c
                    goto L_0x009d
                L_0x000c:
                    java.lang.String r0 = r9.getAction()     // Catch:{ Exception -> 0x0065 }
                    r1 = -1
                    int r2 = r0.hashCode()     // Catch:{ Exception -> 0x0065 }
                    r3 = -1058718587(0xffffffffc0e53c85, float:-7.1636376)
                    r4 = 1
                    if (r2 == r3) goto L_0x0029
                    r3 = 930524812(0x3776ae8c, float:1.47033825E-5)
                    if (r2 == r3) goto L_0x0021
                    goto L_0x0032
                L_0x0021:
                    boolean r0 = r0.equals(r8)     // Catch:{ Exception -> 0x0065 }
                    if (r0 == 0) goto L_0x0032
                    r1 = 0
                    goto L_0x0032
                L_0x0029:
                    java.lang.String r2 = "PPSAFEMODE_LOGEVENT"
                    boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0065 }
                    if (r0 == 0) goto L_0x0032
                    r1 = 1
                L_0x0032:
                    if (r1 == 0) goto L_0x003b
                    if (r1 == r4) goto L_0x0037
                    goto L_0x004d
                L_0x0037:
                    in.juspay.services.b.b(r9)     // Catch:{ Exception -> 0x0065 }
                    goto L_0x004d
                L_0x003b:
                    java.lang.String r0 = "response"
                    java.lang.String r0 = r9.getStringExtra(r0)     // Catch:{ Exception -> 0x0065 }
                    androidx.localbroadcastmanager.content.LocalBroadcastManager r1 = androidx.localbroadcastmanager.content.LocalBroadcastManager.this     // Catch:{ Exception -> 0x0065 }
                    r1.unregisterReceiver(r7)     // Catch:{ Exception -> 0x0065 }
                    in.juspay.hypersdk.ui.HyperPaymentsCallback r1 = r2     // Catch:{ Exception -> 0x0065 }
                    org.json.JSONObject r2 = r4     // Catch:{ Exception -> 0x0065 }
                    in.juspay.services.b.b(r1, r2, r0)     // Catch:{ Exception -> 0x0065 }
                L_0x004d:
                    java.lang.String r0 = r9.getAction()
                    if (r0 == 0) goto L_0x0086
                    java.lang.String r9 = r9.getAction()
                    boolean r8 = r9.equals(r8)
                    if (r8 == 0) goto L_0x0086
                L_0x005d:
                    androidx.localbroadcastmanager.content.LocalBroadcastManager r8 = androidx.localbroadcastmanager.content.LocalBroadcastManager.this
                    r8.unregisterReceiver(r7)
                    goto L_0x0086
                L_0x0063:
                    r0 = move-exception
                    goto L_0x0087
                L_0x0065:
                    r0 = move-exception
                    r6 = r0
                    java.lang.String r1 = "SafeModeSDK"
                    java.lang.String r2 = "action"
                    java.lang.String r3 = "system"
                    java.lang.String r4 = "broadcast_receiving_error"
                    java.lang.String r5 = "Error on receiving a local broadcast"
                    in.juspay.hypersdk.core.SdkTracker.trackAndLogBootException(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0063 }
                    java.lang.String r0 = r9.getAction()
                    if (r0 == 0) goto L_0x0086
                    java.lang.String r9 = r9.getAction()
                    boolean r8 = r9.equals(r8)
                    if (r8 == 0) goto L_0x0086
                    goto L_0x005d
                L_0x0086:
                    return
                L_0x0087:
                    java.lang.String r1 = r9.getAction()
                    if (r1 == 0) goto L_0x009c
                    java.lang.String r9 = r9.getAction()
                    boolean r8 = r9.equals(r8)
                    if (r8 == 0) goto L_0x009c
                    androidx.localbroadcastmanager.content.LocalBroadcastManager r8 = androidx.localbroadcastmanager.content.LocalBroadcastManager.this
                    r8.unregisterReceiver(r7)
                L_0x009c:
                    throw r0
                L_0x009d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: in.juspay.services.b.AnonymousClass1.onReceive(android.content.Context, android.content.Intent):void");
            }
        }, intentFilter);
    }

    public static void a(HyperPaymentsCallback hyperPaymentsCallback, FragmentActivity fragmentActivity, JSONObject jSONObject, String str, String str2) {
        FragmentActivity fragmentActivity2 = fragmentActivity;
        JSONObject jSONObject2 = jSONObject;
        if (!a(fragmentActivity.getApplicationContext(), jSONObject2)) {
            HyperServices.exitSDK(hyperPaymentsCallback, true, str, str2, jSONObject, null);
            return;
        }
        a(hyperPaymentsCallback, (String) "hide_loader");
        a(hyperPaymentsCallback, fragmentActivity, jSONObject);
        try {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("payload");
            Bundle bundle = new Bundle();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("merchantKeyId", jSONObject3.getString("merchantKeyId"));
            jSONObject4.put("orderDetails", jSONObject3.getString("orderDetails"));
            jSONObject4.put("signature", jSONObject3.getString("signature"));
            jSONObject4.put(PaymentConstants.ENV, jSONObject3.optString(PaymentConstants.ENV, ENVIRONMENT.PRODUCTION));
            bundle.putString("payload", jSONObject4.toString());
            Intent intent = new Intent(fragmentActivity2, Class.forName("in.juspay.juspayppsafemode.JuspaySafeModeActivity"));
            intent.putExtras(bundle);
            fragmentActivity2.startActivity(intent);
        } catch (Exception e2) {
            SdkTracker.trackAndLogBootException("SafeModeSDK", "action", "system", SafeModeSDK.START_ERROR, "Error while starting the safe mode SDK", e2);
            HyperServices.exitSDK(hyperPaymentsCallback, true, str, str2, jSONObject, null);
        }
    }

    public static void a(HyperPaymentsCallback hyperPaymentsCallback, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", str);
            hyperPaymentsCallback.onEvent(jSONObject, new JuspayResponseHandlerDummyImpl());
        } catch (JSONException unused) {
        }
    }

    public static boolean a() {
        try {
            Class.forName("in.juspay.juspayppsafemode.JuspaySafeModeActivity");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context, JSONObject jSONObject) {
        JSONObject defaultNonNull = Utils.defaultNonNull(Utils.defaultNonNull(SdkConfigService.getCachedSdkConfig()).optJSONObject("safemode"));
        String optString = jSONObject.optString("service", "");
        boolean z = false;
        if (a() && defaultNonNull.optBoolean(RNGestureHandlerModule.KEY_ENABLED, true) && optString.trim().equalsIgnoreCase("in.juspay.hyperpay")) {
            JSONObject optJSONObject = defaultNonNull.optJSONObject("blacklist");
            if (optJSONObject == null) {
                return true;
            }
            JSONObject defaultNonNull2 = Utils.defaultNonNull(jSONObject.optJSONObject("payload"));
            JSONArray defaultNonNull3 = Utils.defaultNonNull(optJSONObject.optJSONArray("clientIds"));
            JSONArray defaultNonNull4 = Utils.defaultNonNull(optJSONObject.optJSONArray("sdkVersions"));
            JSONArray defaultNonNull5 = Utils.defaultNonNull(optJSONObject.optJSONArray("osVersions"));
            String optString2 = defaultNonNull2.optString(PaymentConstants.CLIENT_ID_CAMEL);
            String sdkVersion = IntegrationUtils.getSdkInfo(context).getSdkVersion();
            String format = String.format(Locale.ROOT, "androidos_%d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            if (!Utils.contains(defaultNonNull3, optString2) && !Utils.contains(defaultNonNull4, sdkVersion) && !Utils.contains(defaultNonNull5, format)) {
                z = true;
            }
        }
        return z;
    }

    public static void b(Intent intent) {
        try {
            SdkTracker.trackBootAction(Action.USER, "info", intent.getStringExtra(NotificationCompatJellybean.KEY_LABEL), intent.getStringExtra("key"), new JSONObject((String) Objects.requireNonNull(intent.getStringExtra(HSLCriteriaBuilder.VALUE))));
        } catch (Exception e2) {
            SdkTracker.trackAndLogBootException("SafeModeSDK", "action", "system", SafeModeSDK.LOG_EVENT_RECEIVING_ERROR, "Error on receiving a local broadcast for log", e2);
        }
    }

    public static void b(HyperPaymentsCallback hyperPaymentsCallback, JSONObject jSONObject, String str) {
        String str2;
        if (str != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                boolean optBoolean = jSONObject2.optBoolean("error", false);
                if (optBoolean) {
                    HyperServices.exitSDK(hyperPaymentsCallback, true, a(jSONObject2.optString("errorCode", "SOMETHING_WENT_WRONG")), jSONObject2.getString("errorMessage"), jSONObject, jSONObject2.optJSONObject("payload"));
                    return;
                }
                JSONObject optJSONObject = jSONObject2.optJSONObject("payload");
                String str3 = "";
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("status", str3);
                    if (!optString.equalsIgnoreCase("CHARGED")) {
                        optBoolean = true;
                        str3 = optString;
                        str2 = "JP_012";
                        HyperServices.exitSDK(hyperPaymentsCallback, optBoolean, str2, str3, jSONObject, jSONObject2.getJSONObject("payload"));
                    }
                }
                str2 = str3;
                HyperServices.exitSDK(hyperPaymentsCallback, optBoolean, str2, str3, jSONObject, jSONObject2.getJSONObject("payload"));
            } catch (Exception e2) {
                SdkTracker.trackAndLogBootException("SafeModeSDK", "action", "system", SafeModeSDK.RESULT_RECEIVING_ERROR, "Error on receiving a local broadcast for safe mode sdk result", e2);
            }
        }
    }
}
