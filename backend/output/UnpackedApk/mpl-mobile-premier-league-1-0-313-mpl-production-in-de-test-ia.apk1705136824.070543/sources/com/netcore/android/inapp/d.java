package com.netcore.android.inapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.Smartech;
import com.netcore.android.inapp.b.a;
import com.netcore.android.inapp.h.b;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.utility.SMTCommonUtility;
import com.netcore.android.utility.g;
import com.userexperior.models.recording.enums.UeCustomType;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010#\u001a\u00020 \u0012\b\u0010'\u001a\u0004\u0018\u00010$¢\u0006\u0004\b+\u0010,J/\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0010\u0010\tR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00030\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R6\u0010*\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/netcore/android/inapp/d;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "()Ljava/util/HashMap;", "url", "", "(Ljava/lang/String;)V", "getDataFromSmartechSDK", "()Ljava/lang/String;", "payload", "intentAction", "(Ljava/lang/String;Ljava/lang/String;)V", "value", "closeAction", "Lcom/netcore/android/inapp/h/b;", "e", "Lcom/netcore/android/inapp/h/b;", "inAppRule", "kotlin.jvm.PlatformType", "b", "Ljava/lang/String;", "TAG", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "", "Z", "isRecordInAppDismissEent", "Lcom/netcore/android/inapp/e;", "f", "Lcom/netcore/android/inapp/e;", "actionListener", "Lcom/netcore/android/inapp/InAppCustomHTMLListener;", "g", "Lcom/netcore/android/inapp/InAppCustomHTMLListener;", "inAppCustomHtmlListener", "c", "Ljava/util/HashMap;", "smtSmartechParams", "<init>", "(Landroid/content/Context;Lcom/netcore/android/inapp/h/b;Lcom/netcore/android/inapp/e;Lcom/netcore/android/inapp/InAppCustomHTMLListener;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTInAppJavaScriptInterface.kt */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1206a = true;

    /* renamed from: b  reason: collision with root package name */
    public final String f1207b = d.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, Object> f1208c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final Context f1209d;

    /* renamed from: e  reason: collision with root package name */
    public b f1210e;

    /* renamed from: f  reason: collision with root package name */
    public final e f1211f;
    public final InAppCustomHTMLListener g;

    public d(Context context, b bVar, e eVar, InAppCustomHTMLListener inAppCustomHTMLListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bVar, "inAppRule");
        Intrinsics.checkNotNullParameter(eVar, "actionListener");
        this.f1209d = context;
        this.f1210e = bVar;
        this.f1211f = eVar;
        this.g = inAppCustomHTMLListener;
    }

    private final HashMap<String, Object> a() {
        try {
            g b2 = g.f1302f.b(new WeakReference(this.f1209d));
            Smartech instance = Smartech.Companion.getInstance(new WeakReference(this.f1209d));
            HashMap<String, Object> hashMap = this.f1208c;
            a aVar = b.g;
            hashMap.put(aVar.f(), "smartech");
            this.f1208c.put(aVar.e(), "app");
            this.f1208c.put(aVar.a(), Boolean.valueOf(aVar.b()));
            this.f1208c.put(aVar.c(), aVar.d());
            HashMap<String, Object> hashMap2 = this.f1208c;
            com.netcore.android.utility.d c2 = b2.c();
            String str = null;
            hashMap2.put(SMTEventParamKeys.SMT_OS_NAME, c2 != null ? c2.o() : null);
            HashMap<String, Object> hashMap3 = this.f1208c;
            com.netcore.android.utility.d c3 = b2.c();
            hashMap3.put("osVersion", c3 != null ? c3.p() : null);
            HashMap<String, Object> hashMap4 = this.f1208c;
            com.netcore.android.utility.d c4 = b2.c();
            hashMap4.put(SMTEventParamKeys.SMT_DEVICE_MAKE, c4 != null ? c4.e() : null);
            HashMap<String, Object> hashMap5 = this.f1208c;
            com.netcore.android.utility.d c5 = b2.c();
            if (c5 != null) {
                str = c5.f();
            }
            hashMap5.put(SMTEventParamKeys.SMT_DEVICE_MODEL, str);
            this.f1208c.put("guid", instance.getDeviceUniqueId());
            this.f1208c.put("identity", instance.getUserIdentity());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.f1208c;
    }

    @JavascriptInterface
    public final void closeAction(String str) {
        Intrinsics.checkNotNullParameter(str, HSLCriteriaBuilder.VALUE);
        this.f1211f.a(this.f1206a);
    }

    @JavascriptInterface
    public final String getDataFromSmartechSDK() {
        try {
            String jSONObject = new JSONObject(a()).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(setDataToSmartechSDK()).toString()");
            return jSONObject;
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1207b;
            StringBuilder outline79 = GeneratedOutlineSupport.outline79(str, UeCustomType.TAG, "Smartech Error: ");
            outline79.append(e2.getMessage());
            sMTLogger.e(str, outline79.toString());
            return "";
        }
    }

    @JavascriptInterface
    public final void intentAction(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        if (str.length() > 0) {
            a(str);
            if (new Regex((String) "sms:[0-9]*.&body=(?s:.)*").matches(str)) {
                str = new Regex((String) "&body").replace(str, "\\?body");
            }
            try {
                InAppCustomHTMLListener inAppCustomHTMLListener = this.g;
                if (inAppCustomHTMLListener != null) {
                    g.f1213b.a(inAppCustomHTMLListener, str2);
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                Activity a2 = g.f1213b.a();
                if (a2 != null) {
                    a2.startActivity(intent);
                }
            } catch (Exception e2) {
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str3 = this.f1207b;
                GeneratedOutlineSupport.outline96(str3, UeCustomType.TAG, e2, sMTLogger, str3);
            }
            this.f1206a = false;
            closeAction("");
            return;
        }
        this.f1206a = false;
    }

    private final void a(String str) {
        Activity a2 = g.f1213b.a();
        if (a2 != null) {
            SMTCommonUtility sMTCommonUtility = SMTCommonUtility.INSTANCE;
            Context applicationContext = a2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "it.applicationContext");
            SMTCommonUtility.updateAttributionParams$default(sMTCommonUtility, applicationContext, str, null, 4, null);
            this.f1211f.a(42, this.f1210e, str);
        }
    }
}
