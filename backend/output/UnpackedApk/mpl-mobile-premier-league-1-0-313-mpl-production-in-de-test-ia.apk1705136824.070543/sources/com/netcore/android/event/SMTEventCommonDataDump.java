package com.netcore.android.event;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.utility.SMTGWSource;
import com.netcore.android.utility.encoding.SMTEncoding;
import com.netcore.android.utility.encoding.SMTEncoding.Companion;
import com.netcore.android.utility.g;
import com.userexperior.models.recording.enums.UeCustomType;
import java.util.HashMap;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b6\u00107J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u001c\u0010\u001e\u001a\u00020\u001d8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0013R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0013R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0013R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0013R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010\u0013R\u0016\u0010'\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010\u0013R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010\u0013R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010\u0013R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010\u0013R\u001e\u0010.\u001a\n -*\u0004\u0018\u00010\u00040\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0013R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010\u0013R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010\u0013R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u0010\u0013R\u0016\u00105\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010\u0013¨\u00068"}, d2 = {"Lcom/netcore/android/event/SMTEventCommonDataDump;", "", "Landroid/content/Context;", "context", "", "currentToken", "oldToken", "Lorg/json/JSONArray;", "getPushTokensArray", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONArray;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getPayloadParams", "()Ljava/util/HashMap;", "getURLParameters", "()Ljava/lang/String;", "getAppBundleId", "getDeviceMake", "appId", "Ljava/lang/String;", "deviceModel", "eventTime", "sdkVersion", "deviceWidth", "guid", "deviceHeight", "carrier", "eventName", "appBuid", "Lcom/netcore/android/utility/g;", "mSmtInfo", "Lcom/netcore/android/utility/g;", "getMSmtInfo", "()Lcom/netcore/android/utility/g;", "osName", "pushId", "osVersion", "eventId", "adId", "pushTokens", "Lorg/json/JSONArray;", "radio", "deviceLocale", "countryCode", "deviceMake", "kotlin.jvm.PlatformType", "TAG", "pushTokenOld", "appBundleId", "", "bod", "I", "appVersion", "vendorId", "<init>", "(Landroid/content/Context;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTEventCommonDataDump.kt */
public final class SMTEventCommonDataDump {
    public final String TAG = SMTEventCommonDataDump.class.getSimpleName();
    public String adId;
    public String appBuid;
    public String appBundleId;
    public String appId;
    public String appVersion;
    public int bod;
    public String carrier;
    public String countryCode;
    public String deviceHeight;
    public String deviceLocale;
    public String deviceMake;
    public String deviceModel;
    public String deviceWidth;
    public String eventId;
    public String eventName;
    public String eventTime;
    public String guid;
    public final g mSmtInfo;
    public String osName;
    public String osVersion;
    public String pushId;
    public String pushTokenOld;
    public JSONArray pushTokens = new JSONArray();
    public String radio;
    public String sdkVersion;
    public String vendorId = "";

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004f, code lost:
        r2 = r2.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        if (r2 != null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
        r2 = r2.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        if (r2 != null) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        r4 = r4.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0082, code lost:
        if (r4 != null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
        r4 = r4.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x002e, code lost:
        r2 = r2.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0098, code lost:
        if (r4 != null) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bc, code lost:
        r2 = r2.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c0, code lost:
        if (r2 != null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cc, code lost:
        r2 = r2.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0032, code lost:
        if (r2 != null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d0, code lost:
        if (r2 != null) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00dc, code lost:
        r2 = r2.p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e0, code lost:
        if (r2 != null) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ec, code lost:
        r2 = r2.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f0, code lost:
        if (r2 != null) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00fc, code lost:
        r2 = r2.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0100, code lost:
        if (r2 != null) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010c, code lost:
        r2 = r2.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0110, code lost:
        if (r2 != null) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x011c, code lost:
        r2 = r2.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0120, code lost:
        if (r2 != null) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x012c, code lost:
        r2 = r2.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0130, code lost:
        if (r2 != null) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0168, code lost:
        r7 = r7.h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x016c, code lost:
        if (r7 != null) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0178, code lost:
        r7 = r7.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003e, code lost:
        r2 = r2.o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x017c, code lost:
        if (r7 != null) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0188, code lost:
        r7 = r7.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x018c, code lost:
        if (r7 != null) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0042, code lost:
        if (r2 != null) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SMTEventCommonDataDump(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r6.<init>()
            java.lang.Class<com.netcore.android.event.SMTEventCommonDataDump> r0 = com.netcore.android.event.SMTEventCommonDataDump.class
            java.lang.String r0 = r0.getSimpleName()
            r6.TAG = r0
            java.lang.String r0 = ""
            r6.vendorId = r0
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            r6.pushTokens = r1
            com.netcore.android.utility.g$a r1 = com.netcore.android.utility.g.f1302f
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            r2.<init>(r7)
            com.netcore.android.utility.g r1 = r1.b(r2)
            r6.mSmtInfo = r1
            com.netcore.android.utility.a r2 = r1.b()
            if (r2 == 0) goto L_0x0035
            java.lang.String r2 = r2.c()
            if (r2 == 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r2 = r0
        L_0x0036:
            r6.appVersion = r2
            com.netcore.android.utility.d r2 = r1.c()
            if (r2 == 0) goto L_0x0045
            java.lang.String r2 = r2.o()
            if (r2 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            java.lang.String r2 = "android"
        L_0x0047:
            r6.osName = r2
            com.netcore.android.utility.d r2 = r1.c()
            if (r2 == 0) goto L_0x0056
            java.lang.String r2 = r2.e()
            if (r2 == 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r2 = r0
        L_0x0057:
            r6.deviceMake = r2
            com.netcore.android.utility.d r2 = r1.c()
            if (r2 == 0) goto L_0x0066
            java.lang.String r2 = r2.f()
            if (r2 == 0) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r2 = r0
        L_0x0067:
            r6.deviceModel = r2
            com.netcore.android.preference.SMTPreferenceHelper$Companion r2 = com.netcore.android.preference.SMTPreferenceHelper.Companion
            r3 = 0
            com.netcore.android.preference.SMTPreferenceHelper r4 = r2.getAppPreferenceInstance(r7, r3)
            java.lang.String r5 = "adid"
            java.lang.String r4 = r4.getString(r5, r0)
            r6.adId = r4
            com.netcore.android.utility.a r4 = r1.b()
            if (r4 == 0) goto L_0x0085
            java.lang.String r4 = r4.a()
            if (r4 == 0) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r4 = r0
        L_0x0086:
            r6.appBuid = r4
            com.netcore.android.utility.a r4 = r1.b()
            if (r4 == 0) goto L_0x009b
            com.netcore.android.utility.h r4 = r4.d()
            if (r4 == 0) goto L_0x009b
            java.lang.String r4 = r4.b()
            if (r4 == 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r4 = r0
        L_0x009c:
            r6.appId = r4
            com.netcore.android.preference.SMTPreferenceHelper r4 = r2.getAppPreferenceInstance(r7, r3)
            java.lang.String r5 = "push_token_current"
            java.lang.String r4 = r4.getString(r5)
            r6.pushId = r4
            com.netcore.android.preference.SMTPreferenceHelper r2 = r2.getAppPreferenceInstance(r7, r3)
            java.lang.String r3 = "push_token_old"
            java.lang.String r2 = r2.getString(r3)
            r6.pushTokenOld = r2
            com.netcore.android.utility.a r2 = r1.b()
            if (r2 == 0) goto L_0x00c3
            java.lang.String r2 = r2.a()
            if (r2 == 0) goto L_0x00c3
            goto L_0x00c4
        L_0x00c3:
            r2 = r0
        L_0x00c4:
            r6.appBuid = r2
            com.netcore.android.utility.a r2 = r1.b()
            if (r2 == 0) goto L_0x00d3
            java.lang.String r2 = r2.b()
            if (r2 == 0) goto L_0x00d3
            goto L_0x00d4
        L_0x00d3:
            r2 = r0
        L_0x00d4:
            r6.appBundleId = r2
            com.netcore.android.utility.d r2 = r1.c()
            if (r2 == 0) goto L_0x00e3
            java.lang.String r2 = r2.p()
            if (r2 == 0) goto L_0x00e3
            goto L_0x00e4
        L_0x00e3:
            r2 = r0
        L_0x00e4:
            r6.osVersion = r2
            com.netcore.android.utility.j r2 = r1.d()
            if (r2 == 0) goto L_0x00f3
            java.lang.String r2 = r2.d()
            if (r2 == 0) goto L_0x00f3
            goto L_0x00f4
        L_0x00f3:
            r2 = r0
        L_0x00f4:
            r6.carrier = r2
            com.netcore.android.utility.j r2 = r1.d()
            if (r2 == 0) goto L_0x0103
            java.lang.String r2 = r2.e()
            if (r2 == 0) goto L_0x0103
            goto L_0x0104
        L_0x0103:
            r2 = r0
        L_0x0104:
            r6.countryCode = r2
            com.netcore.android.utility.j r2 = r1.d()
            if (r2 == 0) goto L_0x0113
            java.lang.String r2 = r2.g()
            if (r2 == 0) goto L_0x0113
            goto L_0x0114
        L_0x0113:
            r2 = r0
        L_0x0114:
            r6.radio = r2
            com.netcore.android.utility.d r2 = r1.c()
            if (r2 == 0) goto L_0x0123
            java.lang.String r2 = r2.g()
            if (r2 == 0) goto L_0x0123
            goto L_0x0124
        L_0x0123:
            r2 = r0
        L_0x0124:
            r6.deviceWidth = r2
            com.netcore.android.utility.d r2 = r1.c()
            if (r2 == 0) goto L_0x0133
            java.lang.String r2 = r2.c()
            if (r2 == 0) goto L_0x0133
            goto L_0x0134
        L_0x0133:
            r2 = r0
        L_0x0134:
            r6.deviceHeight = r2
            java.lang.String r2 = r6.pushId
            java.lang.String r3 = r6.pushTokenOld
            org.json.JSONArray r2 = r6.getPushTokensArray(r7, r2, r3)
            r6.pushTokens = r2
            com.netcore.android.utility.SMTCommonUtility r2 = com.netcore.android.utility.SMTCommonUtility.INSTANCE
            int r7 = r2.getBOD$smartech_release(r7)
            r6.bod = r7
            r7 = 99
            java.lang.String r2 = java.lang.String.valueOf(r7)
            r6.eventId = r2
            com.netcore.android.event.SMTEventId$Companion r2 = com.netcore.android.event.SMTEventId.Companion
            java.lang.String r7 = r2.getEventName(r7)
            r6.eventName = r7
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r7 = java.lang.String.valueOf(r2)
            r6.eventTime = r7
            com.netcore.android.utility.d r7 = r1.c()
            if (r7 == 0) goto L_0x016f
            java.lang.String r7 = r7.h()
            if (r7 == 0) goto L_0x016f
            goto L_0x0170
        L_0x016f:
            r7 = r0
        L_0x0170:
            r6.guid = r7
            com.netcore.android.utility.d r7 = r1.c()
            if (r7 == 0) goto L_0x017f
            java.lang.String r7 = r7.d()
            if (r7 == 0) goto L_0x017f
            goto L_0x0180
        L_0x017f:
            r7 = r0
        L_0x0180:
            r6.deviceLocale = r7
            com.netcore.android.utility.a r7 = r1.b()
            if (r7 == 0) goto L_0x018f
            java.lang.String r7 = r7.f()
            if (r7 == 0) goto L_0x018f
            goto L_0x0190
        L_0x018f:
            r7 = r0
        L_0x0190:
            r6.sdkVersion = r7
            r6.vendorId = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.event.SMTEventCommonDataDump.<init>(android.content.Context):void");
    }

    private final JSONArray getPushTokensArray(Context context, String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SMTEventParamKeys.SMT_GWSOURCE, SMTGWSource.FCM.getValue());
            jSONObject.put(SMTEventParamKeys.SMT_PUSH_TOKEN_CURRENT, str);
            jSONObject.put(SMTEventParamKeys.SMT_PUSH_TOKEN_OLD, str2);
            jSONArray.put(jSONObject);
            SMTPreferenceHelper appPreferenceInstance = SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null);
            Companion companion = SMTEncoding.Companion;
            String encodeStringToUTF8 = companion.encodeStringToUTF8(appPreferenceInstance.getString(SMTPreferenceConstants.XIAOMI_PUSH_TOKEN_CURRENT, ""));
            String encodeStringToUTF82 = companion.encodeStringToUTF8(appPreferenceInstance.getString(SMTPreferenceConstants.XIAOMI_PUSH_TOKEN_OLD, ""));
            boolean z = true;
            if (encodeStringToUTF8.length() > 0) {
                if (encodeStringToUTF82.length() <= 0) {
                    z = false;
                }
                if (z) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(SMTEventParamKeys.SMT_GWSOURCE, SMTGWSource.XIAOMI.getValue());
                    jSONObject2.put(SMTEventParamKeys.SMT_PUSH_TOKEN_CURRENT, encodeStringToUTF8);
                    jSONObject2.put(SMTEventParamKeys.SMT_PUSH_TOKEN_OLD, encodeStringToUTF82);
                    jSONArray.put(jSONObject2);
                }
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str3 = this.TAG;
            GeneratedOutlineSupport.outline96(str3, UeCustomType.TAG, e2, sMTLogger, str3);
        }
        return jSONArray;
    }

    public final String getAppBundleId() {
        return this.appBundleId;
    }

    public final String getDeviceMake() {
        return this.deviceMake;
    }

    public final g getMSmtInfo() {
        return this.mSmtInfo;
    }

    public final HashMap<String, Object> getPayloadParams() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(SMTEventParamKeys.SMT_APP_VERSION, this.appVersion);
        hashMap.put("sdkVersion", this.sdkVersion);
        hashMap.put(SMTEventParamKeys.SMT_OS_NAME, this.osName);
        hashMap.put(SMTEventParamKeys.SMT_DEVICE_MAKE, this.deviceMake);
        hashMap.put(SMTEventParamKeys.SMT_DEVICE_MODEL, this.deviceModel);
        hashMap.put(SMTEventParamKeys.SMT_AD_ID, this.adId);
        hashMap.put(SMTEventParamKeys.SMT_APP_ID, this.appId);
        hashMap.put(SMTEventParamKeys.SMT_PUSH_TOKEN_CURRENT, this.pushId);
        hashMap.put(SMTEventParamKeys.SMT_PUSH_TOKEN_OLD, this.pushTokenOld);
        hashMap.put(SMTEventParamKeys.SMT_PUSH_TOKENS, this.pushTokens);
        hashMap.put(SMTEventParamKeys.SMT_APP_BUILD, this.appBuid);
        hashMap.put(SMTEventParamKeys.SMT_APP_BUNDLE_ID, this.appBundleId);
        hashMap.put("osVersion", this.osVersion);
        hashMap.put("carrier", this.carrier);
        hashMap.put("countryCode", this.countryCode);
        hashMap.put(SMTEventParamKeys.SMT_RADIO, this.radio);
        hashMap.put(SMTEventParamKeys.SMT_DEVICE_WIDTH, this.deviceWidth);
        hashMap.put(SMTEventParamKeys.SMT_DEVICE_HEIGHT, this.deviceHeight);
        hashMap.put(SMTEventParamKeys.SMT_BOD, Integer.valueOf(this.bod));
        hashMap.put(SMTEventParamKeys.SMT_EVENT_ID, this.eventId);
        hashMap.put("eventName", this.eventName);
        hashMap.put(SMTEventParamKeys.SMT_EVENT_TIME, this.eventTime);
        hashMap.put(SMTEventParamKeys.SMT_EVENT_TIME, this.eventTime);
        hashMap.put("guid", this.guid);
        hashMap.put("deviceLocale", this.deviceLocale);
        hashMap.put(SMTEventParamKeys.SMT_VENDOR_ID, this.vendorId);
        return hashMap;
    }

    public final String getURLParameters() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("appId=");
        outline73.append(this.appId);
        outline73.append("&appVersion=");
        outline73.append(this.appVersion);
        outline73.append("&sdkVersion=");
        outline73.append(this.sdkVersion);
        return outline73.toString();
    }
}
