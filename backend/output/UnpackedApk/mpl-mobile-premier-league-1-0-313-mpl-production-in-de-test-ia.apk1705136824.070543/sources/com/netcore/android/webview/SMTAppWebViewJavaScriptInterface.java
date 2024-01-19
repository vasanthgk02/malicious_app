package com.netcore.android.webview;

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.Smartech;
import com.netcore.android.event.SMTEventType;
import com.netcore.android.event.e;
import com.netcore.android.inapp.g;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.notification.SMTNotificationConstants;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.utility.SMTCommonUtility;
import com.netcore.android.utility.d;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b'\u0010(BC\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010%\u001a\u00020$\u0012(\b\u0002\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\f¢\u0006\u0004\b'\u0010)J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006JQ\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\f2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J?\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\t2&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR6\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\n !*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/netcore/android/webview/SMTAppWebViewJavaScriptInterface;", "", "Lorg/json/JSONObject;", "jsonDataFromJS", "", "evaluateJsonData", "(Lorg/json/JSONObject;)V", "", "eventId", "", "eventName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "payload", "eventType", "recordEvent", "(ILjava/lang/String;Ljava/util/HashMap;Ljava/lang/String;)V", "smtEvent", "eventPayLoad", "passEventDataWebViewToApp", "(Ljava/lang/String;Ljava/util/HashMap;)V", "setDataToSmartechSDK", "()Ljava/util/HashMap;", "getDataFromSmartechSDK", "()Ljava/lang/String;", "dataFromJS", "sendDataToSmartechSDK", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "smtSmartechParams", "Ljava/util/HashMap;", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "Lcom/netcore/android/webview/SMTAppWebViewListener;", "smtAppWebViewListener", "Lcom/netcore/android/webview/SMTAppWebViewListener;", "<init>", "(Landroid/content/Context;Lcom/netcore/android/webview/SMTAppWebViewListener;)V", "(Landroid/content/Context;Lcom/netcore/android/webview/SMTAppWebViewListener;Ljava/util/HashMap;)V", "Companion", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTAppWebViewJavaScriptInterface.kt */
public final class SMTAppWebViewJavaScriptInterface {
    public static final Companion Companion = new Companion(null);
    public static final String SMT_INTERFACE_NAME = "SmartechSDK";
    public final String TAG;
    public final Context context;
    public final SMTAppWebViewListener smtAppWebViewListener;
    public HashMap<String, Object> smtSmartechParams;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/netcore/android/webview/SMTAppWebViewJavaScriptInterface$Companion;", "", "", "SMT_INTERFACE_NAME", "Ljava/lang/String;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTAppWebViewJavaScriptInterface.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SMTAppWebViewJavaScriptInterface(Context context2, SMTAppWebViewListener sMTAppWebViewListener) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(sMTAppWebViewListener, "smtAppWebViewListener");
        this.context = context2;
        this.smtAppWebViewListener = sMTAppWebViewListener;
        this.TAG = SMTAppWebViewJavaScriptInterface.class.getSimpleName();
        this.smtSmartechParams = new HashMap<>();
    }

    private final void evaluateJsonData(JSONObject jSONObject) {
        if (jSONObject.has("event")) {
            JSONObject jSONObject2 = new JSONObject();
            HashMap<String, Object> hashMap = new HashMap<>();
            new JSONObject();
            String string = jSONObject.getString("event");
            Intrinsics.checkNotNullExpressionValue(string, "jsonDataFromJS.getString…pWebViewParams.KEY_EVENT)");
            boolean isInteger = SMTCommonUtility.INSTANCE.isInteger(string);
            if (jSONObject.has("eventPayload")) {
                try {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("eventPayload");
                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonDataFromJS.getJSONOb…Params.KEY_EVENT_PAYLOAD)");
                    jSONObject2 = jSONObject3;
                } catch (Exception e2) {
                    SMTLogger sMTLogger = SMTLogger.INSTANCE;
                    String str = this.TAG;
                    StringBuilder outline79 = GeneratedOutlineSupport.outline79(str, UeCustomType.TAG, "Smartech Error: ");
                    outline79.append(e2.getMessage());
                    sMTLogger.e(str, outline79.toString());
                }
                hashMap = SMTCommonUtility.INSTANCE.jsonToMap(jSONObject2);
            }
            boolean z = true;
            if (jSONObject.has(SMTNotificationConstants.NOTIF_SMT_PAYLOAD_KEY)) {
                try {
                    JSONObject jSONObject4 = jSONObject.getJSONObject(SMTNotificationConstants.NOTIF_SMT_PAYLOAD_KEY);
                    Intrinsics.checkNotNullExpressionValue(jSONObject4, "jsonDataFromJS.getJSONOb…ewParams.KEY_SMT_PAYLOAD)");
                    if (jSONObject4.getInt("autoTrackEvent") != 1) {
                        z = false;
                    }
                } catch (Exception e3) {
                    SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                    String str2 = this.TAG;
                    StringBuilder outline792 = GeneratedOutlineSupport.outline79(str2, UeCustomType.TAG, "Smartech Error: ");
                    outline792.append(e3.getMessage());
                    sMTLogger2.e(str2, outline792.toString());
                }
            }
            if (!z) {
                passEventDataWebViewToApp(string, hashMap);
            } else if (isInteger) {
                Integer.parseInt(string);
                SMTLogger sMTLogger3 = SMTLogger.INSTANCE;
                String str3 = this.TAG;
                Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
                sMTLogger3.w(str3, "Smartech warning : The Event name should be a string, ignoring SmartechSDK's track event.");
            } else {
                recordEvent(0, string, hashMap, SMTEventType.EVENT_TYPE_CUSTOM);
            }
        }
    }

    private final void passEventDataWebViewToApp(String str, HashMap<String, Object> hashMap) {
        try {
            this.smtAppWebViewListener.handleWebEvent(str, hashMap);
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str2 = this.TAG;
            StringBuilder outline79 = GeneratedOutlineSupport.outline79(str2, UeCustomType.TAG, "Smartech Error: ");
            outline79.append(e2.getMessage());
            sMTLogger.e(str2, outline79.toString());
        }
    }

    private final void recordEvent(int i, String str, HashMap<String, Object> hashMap, String str2) {
        Activity a2 = g.f1213b.a();
        if (a2 != null) {
            e.a(e.f1081f.b(a2), i, str, hashMap, str2, false, 16, null);
        }
    }

    private final HashMap<String, Object> setDataToSmartechSDK() {
        try {
            String str = null;
            SMTPreferenceHelper appPreferenceInstance = SMTPreferenceHelper.Companion.getAppPreferenceInstance(this.context, null);
            com.netcore.android.utility.g b2 = com.netcore.android.utility.g.f1302f.b(new WeakReference(this.context));
            Smartech instance = Smartech.Companion.getInstance(new WeakReference(this.context));
            this.smtSmartechParams.put("smtSrc", "smartech");
            this.smtSmartechParams.put("platform", "app");
            HashMap<String, Object> hashMap = this.smtSmartechParams;
            d c2 = b2.c();
            hashMap.put(SMTEventParamKeys.SMT_OS_NAME, c2 != null ? c2.o() : null);
            HashMap<String, Object> hashMap2 = this.smtSmartechParams;
            d c3 = b2.c();
            hashMap2.put("osVersion", c3 != null ? c3.p() : null);
            HashMap<String, Object> hashMap3 = this.smtSmartechParams;
            d c4 = b2.c();
            hashMap3.put(SMTEventParamKeys.SMT_DEVICE_MAKE, c4 != null ? c4.e() : null);
            HashMap<String, Object> hashMap4 = this.smtSmartechParams;
            d c5 = b2.c();
            if (c5 != null) {
                str = c5.f();
            }
            hashMap4.put(SMTEventParamKeys.SMT_DEVICE_MODEL, str);
            this.smtSmartechParams.put("guid", instance.getDeviceUniqueId());
            this.smtSmartechParams.put(SMTEventParamKeys.SMT_PUSH_TOKEN_CURRENT, appPreferenceInstance.getString(SMTPreferenceConstants.PUSH_TOKEN_CURRENT));
            this.smtSmartechParams.put("identity", instance.getUserIdentity());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.smtSmartechParams;
    }

    @JavascriptInterface
    public final String getDataFromSmartechSDK() {
        try {
            String jSONObject = new JSONObject(setDataToSmartechSDK()).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(setDataToSmartechSDK()).toString()");
            return jSONObject;
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.TAG;
            StringBuilder outline79 = GeneratedOutlineSupport.outline79(str, UeCustomType.TAG, "Smartech Error: ");
            outline79.append(e2.getMessage());
            sMTLogger.e(str, outline79.toString());
            return "";
        }
    }

    @JavascriptInterface
    public final void sendDataToSmartechSDK(String str) {
        try {
            evaluateJsonData(new JSONObject(str));
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str2 = this.TAG;
            StringBuilder outline79 = GeneratedOutlineSupport.outline79(str2, UeCustomType.TAG, "Smartech Error: ");
            outline79.append(e2.getMessage());
            sMTLogger.e(str2, outline79.toString());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SMTAppWebViewJavaScriptInterface(Context context2, SMTAppWebViewListener sMTAppWebViewListener, HashMap<String, Object> hashMap) {
        // Intrinsics.checkNotNullParameter(context2, "context");
        // Intrinsics.checkNotNullParameter(sMTAppWebViewListener, "smtAppWebViewListener");
        // Intrinsics.checkNotNullParameter(hashMap, "smtSmartechParams");
        this(context2, sMTAppWebViewListener);
        this.smtSmartechParams = hashMap;
    }

    public /* synthetic */ SMTAppWebViewJavaScriptInterface(Context context2, SMTAppWebViewListener sMTAppWebViewListener, HashMap hashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, sMTAppWebViewListener, (i & 4) != 0 ? new HashMap() : hashMap);
    }
}
