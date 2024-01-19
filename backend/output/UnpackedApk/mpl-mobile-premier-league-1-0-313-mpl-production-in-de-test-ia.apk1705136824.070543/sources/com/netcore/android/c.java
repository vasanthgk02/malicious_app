package com.netcore.android;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.d.a;
import com.netcore.android.event.SMTEventId;
import com.netcore.android.event.SMTEventType;
import com.netcore.android.event.e;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.SMTEnumHttpMethodType;
import com.netcore.android.network.SMTNetworkManager;
import com.netcore.android.network.SMTRequestQueue;
import com.netcore.android.network.SMTResponseListener;
import com.netcore.android.network.models.SMTRequest.Builder;
import com.netcore.android.network.models.SMTRequest.SMTApiTypeID;
import com.netcore.android.network.models.SMTSdkInitializeResponse.SmartTechSettings;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.utility.SMTCommonUtility;
import com.netcore.android.utility.d;
import com.netcore.android.utility.g;
import com.netcore.android.utility.h;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SmartechHelper.kt */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f1016a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Context> f1017b;

    /* renamed from: c  reason: collision with root package name */
    public final g f1018c;

    /* renamed from: d  reason: collision with root package name */
    public final SMTPreferenceHelper f1019d;

    /* renamed from: e  reason: collision with root package name */
    public final SMTResponseListener f1020e;

    public c(WeakReference<Context> weakReference, g gVar, SMTPreferenceHelper sMTPreferenceHelper, SMTResponseListener sMTResponseListener) {
        Intrinsics.checkNotNullParameter(weakReference, "context");
        Intrinsics.checkNotNullParameter(gVar, "smtInfo");
        Intrinsics.checkNotNullParameter(sMTPreferenceHelper, "mPreferences");
        Intrinsics.checkNotNullParameter(sMTResponseListener, "responseListener");
        this.f1017b = weakReference;
        this.f1018c = gVar;
        this.f1019d = sMTPreferenceHelper;
        this.f1020e = sMTResponseListener;
    }

    private final void b() {
        Context context = (Context) this.f1017b.get();
        if (context != null) {
            boolean z = this.f1019d.getBoolean(SMTPreferenceConstants.SMT_IS_LOCATION_PERMISSION_AVAILABLE);
            SMTCommonUtility sMTCommonUtility = SMTCommonUtility.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(context, "it");
            boolean isPermissionGranted$smartech_release = sMTCommonUtility.isPermissionGranted$smartech_release(context, SMTConfigConstants.LOCATION_PERMISSION_MF_KEY);
            if (isPermissionGranted$smartech_release != this.f1019d.getBoolean(SMTPreferenceConstants.SMT_LOCATION_PERMISSION) || !z) {
                b(isPermissionGranted$smartech_release);
                d c2 = this.f1018c.c();
                if (c2 != null) {
                    c2.u();
                }
            }
            this.f1019d.setBoolean(SMTPreferenceConstants.SMT_IS_LOCATION_PERMISSION_AVAILABLE, true);
            this.f1019d.setBoolean(SMTPreferenceConstants.SMT_LOCATION_PERMISSION, isPermissionGranted$smartech_release);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        if (r3 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0059, code lost:
        if (r3 != null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
        if (r3 != null) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void c() {
        /*
            r10 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r10.f1017b
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r1 = "TAG"
            if (r0 == 0) goto L_0x009f
            com.netcore.android.utility.SMTCommonUtility r2 = com.netcore.android.utility.SMTCommonUtility.INSTANCE
            com.netcore.android.utility.g r3 = r10.f1018c
            java.lang.String r4 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            boolean r2 = r2.checkIfDeviceDetailChanged$smartech_release(r3, r0)
            if (r2 == 0) goto L_0x00ab
            com.netcore.android.preference.SMTPreferenceHelper r2 = r10.f1019d
            com.netcore.android.utility.g r3 = r10.f1018c
            com.netcore.android.utility.d r3 = r3.c()
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x002e
            java.lang.String r3 = r3.p()
            if (r3 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r3 = r4
        L_0x002f:
            java.lang.String r5 = "os_version"
            r2.setString(r5, r3)
            com.netcore.android.preference.SMTPreferenceHelper r2 = r10.f1019d
            com.netcore.android.utility.g r3 = r10.f1018c
            com.netcore.android.utility.j r3 = r3.d()
            if (r3 == 0) goto L_0x0045
            java.lang.String r3 = r3.d()
            if (r3 == 0) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r3 = r4
        L_0x0046:
            java.lang.String r5 = "carrier"
            r2.setString(r5, r3)
            com.netcore.android.preference.SMTPreferenceHelper r2 = r10.f1019d
            com.netcore.android.utility.g r3 = r10.f1018c
            com.netcore.android.utility.d r3 = r3.c()
            if (r3 == 0) goto L_0x005c
            java.lang.String r3 = r3.d()
            if (r3 == 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r3 = r4
        L_0x005d:
            java.lang.String r5 = "deviceLocale"
            r2.setString(r5, r3)
            com.netcore.android.preference.SMTPreferenceHelper r2 = r10.f1019d
            com.netcore.android.utility.g r3 = r10.f1018c
            com.netcore.android.utility.d r3 = r3.c()
            if (r3 == 0) goto L_0x0073
            java.lang.String r3 = r3.r()
            if (r3 == 0) goto L_0x0073
            r4 = r3
        L_0x0073:
            java.lang.String r3 = "timezone"
            r2.setString(r3, r4)
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r3 = r10.f1016a
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            java.lang.String r1 = "recording device detail updated event"
            r2.i(r3, r1)
            com.netcore.android.event.e$a r1 = com.netcore.android.event.e.f1081f
            com.netcore.android.event.e r2 = r1.b(r0)
            com.netcore.android.event.SMTEventId$Companion r0 = com.netcore.android.event.SMTEventId.Companion
            r1 = 26
            java.lang.String r4 = r0.getEventName(r1)
            r3 = 26
            r5 = 0
            r7 = 0
            r8 = 16
            r9 = 0
            java.lang.String r6 = "system_app_lifecycle"
            com.netcore.android.event.e.a(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x00ab
        L_0x009f:
            com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r2 = r10.f1016a
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            java.lang.String r1 = "CheckAndUpdateDeviceDetails: Context is null."
            r0.i(r2, r1)
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.c.c():void");
    }

    private final String e() {
        return "https://cpn.netcoresmartech.com/";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0020, code lost:
        if (r1 != null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String f() {
        /*
            r4 = this;
            com.netcore.android.preference.SMTPreferenceHelper r0 = r4.f1019d
            java.lang.String r1 = "app_id"
            java.lang.String r0 = r0.getString(r1)
            java.lang.ref.WeakReference<android.content.Context> r1 = r4.f1017b
            java.lang.Object r1 = r1.get()
            android.content.Context r1 = (android.content.Context) r1
            if (r1 == 0) goto L_0x0023
            com.netcore.android.event.SMTEventCommonDataDump r2 = new com.netcore.android.event.SMTEventCommonDataDump
            java.lang.String r3 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r2.<init>(r1)
            java.lang.String r1 = r2.getURLParameters()
            if (r1 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            java.lang.String r1 = ""
        L_0x0025:
            java.lang.String r2 = "appinit/"
            java.lang.String r3 = ".json?"
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline53(r2, r0, r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.c.f():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0039, code lost:
        if (r1 != null) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void h() {
        /*
            r11 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r11.f1017b
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            if (r0 == 0) goto L_0x0059
            com.netcore.android.event.e$a r1 = com.netcore.android.event.e.f1081f
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.netcore.android.event.e r3 = r1.b(r0)
            com.netcore.android.event.SMTEventId$Companion r0 = com.netcore.android.event.SMTEventId.Companion
            r1 = 81
            java.lang.String r5 = r0.getEventName(r1)
            r4 = 81
            r6 = 0
            r8 = 0
            r9 = 16
            r10 = 0
            java.lang.String r7 = "system_app_lifecycle"
            com.netcore.android.event.e.a(r3, r4, r5, r6, r7, r8, r9, r10)
            com.netcore.android.preference.SMTPreferenceHelper r0 = r11.f1019d
            com.netcore.android.utility.g r1 = r11.f1018c
            com.netcore.android.utility.a r1 = r1.b()
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x003c
            java.lang.String r1 = r1.c()
            if (r1 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r1 = r2
        L_0x003d:
            java.lang.String r3 = "app_version"
            r0.setString(r3, r1)
            com.netcore.android.preference.SMTPreferenceHelper r0 = r11.f1019d
            com.netcore.android.utility.g r1 = r11.f1018c
            com.netcore.android.utility.a r1 = r1.b()
            if (r1 == 0) goto L_0x0053
            java.lang.String r1 = r1.f()
            if (r1 == 0) goto L_0x0053
            r2 = r1
        L_0x0053:
            java.lang.String r1 = "sdk_version"
            r0.setString(r1, r2)
            goto L_0x0067
        L_0x0059:
            com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r1 = r11.f1016a
            java.lang.String r2 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r2 = "RecordAndStoreAppAndSdkVersion: Context is null."
            r0.i(r1, r2)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.c.h():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cb A[Catch:{ Exception -> 0x00d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d3 A[Catch:{ Exception -> 0x00d9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void k() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r0 = "version_code"
            com.netcore.android.preference.SMTPreferenceHelper r2 = r1.f1019d
            java.lang.String r3 = "is_app_install_update_by_smartech"
            r4 = 0
            boolean r2 = r2.getBoolean(r3, r4)
            com.netcore.android.preference.SMTPreferenceHelper r5 = r1.f1019d
            java.lang.String r6 = "updated_from_legacy_sdk"
            boolean r5 = r5.getBoolean(r6, r4)
            com.netcore.android.logger.SMTLogger r6 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r7 = r1.f1016a
            java.lang.String r8 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Tracking app install."
            r9.append(r10)
            r9.append(r2)
            java.lang.String r10 = " && "
            r9.append(r10)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            r6.internal(r7, r9)
            if (r2 != 0) goto L_0x0072
            java.lang.ref.WeakReference<android.content.Context> r2 = r1.f1017b
            java.lang.Object r2 = r2.get()
            android.content.Context r2 = (android.content.Context) r2
            if (r2 == 0) goto L_0x0072
            if (r5 == 0) goto L_0x004c
            r17.h()
            goto L_0x006c
        L_0x004c:
            com.netcore.android.event.e$a r5 = com.netcore.android.event.e.f1081f
            java.lang.String r7 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            com.netcore.android.event.e r9 = r5.b(r2)
            com.netcore.android.event.SMTEventId$Companion r2 = com.netcore.android.event.SMTEventId.Companion
            r5 = 20
            java.lang.String r11 = r2.getEventName(r5)
            r10 = 20
            r12 = 0
            r14 = 0
            r15 = 16
            r16 = 0
            java.lang.String r13 = "system_app_lifecycle"
            com.netcore.android.event.e.a(r9, r10, r11, r12, r13, r14, r15, r16)
        L_0x006c:
            com.netcore.android.preference.SMTPreferenceHelper r2 = r1.f1019d
            r5 = 1
            r2.setBoolean(r3, r5)
        L_0x0072:
            com.netcore.android.utility.g r2 = r1.f1018c     // Catch:{ Exception -> 0x00d9 }
            com.netcore.android.utility.a r2 = r2.b()     // Catch:{ Exception -> 0x00d9 }
            if (r2 == 0) goto L_0x0089
            java.lang.String r2 = r2.a()     // Catch:{ Exception -> 0x00d9 }
            if (r2 == 0) goto L_0x0089
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x00d9 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00d9 }
            goto L_0x008a
        L_0x0089:
            r2 = 0
        L_0x008a:
            com.netcore.android.preference.SMTPreferenceHelper r3 = r1.f1019d     // Catch:{ Exception -> 0x00d9 }
            int r3 = r3.getInt(r0, r4)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r4 = r1.f1016a     // Catch:{ Exception -> 0x00d9 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)     // Catch:{ Exception -> 0x00d9 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d9 }
            r5.<init>()     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r7 = "App version code "
            r5.append(r7)     // Catch:{ Exception -> 0x00d9 }
            r5.append(r2)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r7 = "  &&  "
            r5.append(r7)     // Catch:{ Exception -> 0x00d9 }
            r5.append(r3)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00d9 }
            r6.internal(r4, r5)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.Int"
            if (r3 == 0) goto L_0x00c7
            if (r2 == 0) goto L_0x00c1
            int r5 = r2.intValue()     // Catch:{ Exception -> 0x00d9 }
            if (r5 <= r3) goto L_0x00c7
            r17.h()     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00c7
        L_0x00c1:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x00d9 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x00d9 }
            throw r0     // Catch:{ Exception -> 0x00d9 }
        L_0x00c7:
            com.netcore.android.preference.SMTPreferenceHelper r3 = r1.f1019d     // Catch:{ Exception -> 0x00d9 }
            if (r2 == 0) goto L_0x00d3
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x00d9 }
            r3.setInt(r0, r2)     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00e1
        L_0x00d3:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x00d9 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x00d9 }
            throw r0     // Catch:{ Exception -> 0x00d9 }
        L_0x00d9:
            r0 = move-exception
            com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r3 = r1.f1016a
            com.android.tools.r8.GeneratedOutlineSupport.outline96(r3, r8, r0, r2, r3)
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.c.k():void");
    }

    public final void a(SMTApiTypeID sMTApiTypeID) {
        Intrinsics.checkNotNullParameter(sMTApiTypeID, "apiId");
        SMTNetworkManager.Companion.getInstance(SMTRequestQueue.Companion.getInstance()).processRequest(new Builder().setHttpMethod(SMTEnumHttpMethodType.GET).setBaseUrl(e()).setEndPoint(f()).setApiId(sMTApiTypeID).setResponseListener(this.f1020e).build());
    }

    public final boolean d() {
        long j = this.f1019d.getLong(SMTPreferenceConstants.LAST_APP_ACTIVE_TIME_STAMP);
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1016a;
        StringBuilder outline79 = GeneratedOutlineSupport.outline79(str, UeCustomType.TAG, "Session Interval ");
        outline79.append(this.f1019d.getInt(SMTPreferenceConstants.SESSION_INTERVAL));
        sMTLogger.internal(str, outline79.toString());
        long millis = TimeUnit.MINUTES.toMillis((long) this.f1019d.getInt(SMTPreferenceConstants.SESSION_INTERVAL));
        String str2 = this.f1016a;
        StringBuilder outline792 = GeneratedOutlineSupport.outline79(str2, UeCustomType.TAG, "Current session id: ");
        outline792.append(this.f1019d.getLong(SMTPreferenceConstants.CURRENT_SESSION_ID));
        sMTLogger.internal(str2, outline792.toString());
        String str3 = this.f1016a;
        Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
        sMTLogger.internal(str3, "Session Details: lastAppActiveTimeStamp: " + j + " || currenttimemillis: " + System.currentTimeMillis() + " || sessionInterval: " + millis + ' ');
        String str4 = this.f1016a;
        StringBuilder outline793 = GeneratedOutlineSupport.outline79(str4, UeCustomType.TAG, "Session calculation: ");
        outline793.append(j - (System.currentTimeMillis() - millis) < 0);
        sMTLogger.internal(str4, outline793.toString());
        return this.f1019d.getLong(SMTPreferenceConstants.CURRENT_SESSION_ID) == 0 || j - (System.currentTimeMillis() - millis) < 0;
    }

    public final void g() {
        Context context = (Context) this.f1017b.get();
        if (context != null) {
            a aVar = d.f1022f;
            Intrinsics.checkNotNullExpressionValue(context, "it");
            aVar.b(context).i();
        }
    }

    public final void i() {
        b();
        Context context = (Context) this.f1017b.get();
        if (context != null) {
            a aVar = d.f1022f;
            Intrinsics.checkNotNullExpressionValue(context, "it");
            aVar.b(context).e();
        }
    }

    public final void j() {
        Context context = (Context) this.f1017b.get();
        if (context != null) {
            a aVar = d.f1022f;
            Intrinsics.checkNotNullExpressionValue(context, "it");
            aVar.b(context).c();
        }
    }

    public final void a(SmartTechSettings smartTechSettings) {
        Intrinsics.checkNotNullParameter(smartTechSettings, "settings");
        Context context = (Context) this.f1017b.get();
        if (context != null) {
            SMTCommonUtility sMTCommonUtility = SMTCommonUtility.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(context, "it");
            sMTCommonUtility.updateSmartechSettingsConfig$smartech_release(context, smartTechSettings);
        }
    }

    private final void b(boolean z) {
        String str;
        int i;
        if (z) {
            str = SMTEventId.Companion.getEventName(89);
            i = 89;
        } else {
            str = SMTEventId.Companion.getEventName(90);
            i = 90;
        }
        Context context = (Context) this.f1017b.get();
        if (context != null) {
            e.a aVar = e.f1081f;
            Intrinsics.checkNotNullExpressionValue(context, "it");
            e.a(aVar.b(context), i, str, null, "system", false, 16, null);
        }
    }

    private final void a(boolean z) {
        if (!z) {
            Context context = (Context) this.f1017b.get();
            if (context != null) {
                e.a aVar = e.f1081f;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                e.a(aVar.b(context), 21, SMTEventId.Companion.getEventName(21), null, SMTEventType.EVENT_TYPE_SYSTEM_APP_LIFECYCLE, false, 16, null);
                return;
            }
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1016a;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.i(str, "RecordAppLaunchEvents: Context is null.");
        }
    }

    public final void b(String str) {
        if (((Context) this.f1017b.get()) != null) {
            SMTPreferenceHelper sMTPreferenceHelper = this.f1019d;
            if (str == null) {
                str = "";
            }
            sMTPreferenceHelper.setString(SMTPreferenceConstants.SMT_ADID, str);
        }
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "userIdentity");
        String string = this.f1019d.getString(SMTPreferenceConstants.SMT_USER_IDENTITY, "");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        if (string != null) {
            String lowerCase = string.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (!Intrinsics.areEqual(str, lowerCase)) {
                this.f1019d.setString(SMTPreferenceConstants.SMT_ATTRIBUTION_PARAMS, "");
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final boolean b(WeakReference<Context> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "context");
        return h.j.b(weakReference).c();
    }

    public final void a(ArrayList<Integer> arrayList) {
        boolean z;
        Intrinsics.checkNotNullParameter(arrayList, "initEventTrackList");
        boolean a2 = arrayList.contains(Integer.valueOf(83)) ? a() : false;
        if (!arrayList.contains(Integer.valueOf(999)) || a2) {
            z = false;
        } else {
            z = true;
            k();
        }
        if (arrayList.contains(Integer.valueOf(20)) && !a2 && !z) {
            Context context = (Context) this.f1017b.get();
            if (context != null) {
                e.a aVar = e.f1081f;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                e.a(aVar.b(context), 20, SMTEventId.Companion.getEventName(20), null, "system", false, 16, null);
            }
        }
        if (arrayList.contains(Integer.valueOf(81)) && !z) {
            h();
        }
        if (arrayList.contains(Integer.valueOf(21))) {
            a(false);
        }
        if (arrayList.contains(Integer.valueOf(26))) {
            c();
        }
        if (arrayList.contains(Integer.valueOf(89))) {
            b();
        }
    }

    private final boolean a() {
        boolean z = this.f1019d.getBoolean(SMTPreferenceConstants.UPDATED_FROM_LEGACY_SDK, false);
        if (!this.f1019d.getBoolean(SMTPreferenceConstants.IS_SMT_GUID_STORED_PREVIOUSLY, false)) {
            return false;
        }
        Context context = (Context) this.f1017b.get();
        if (context != null) {
            if (z) {
                return false;
            }
            e.a aVar = e.f1081f;
            Intrinsics.checkNotNullExpressionValue(context, "it");
            e.a(aVar.b(context), 83, SMTEventId.Companion.getEventName(83), null, SMTEventType.EVENT_TYPE_SYSTEM_APP_LIFECYCLE, false, 16, null);
            this.f1019d.setBoolean(SMTPreferenceConstants.SMT_IS_APP_INSTALL_UPDATE_BY_SMARTECH, true);
        }
        return true;
    }

    public final String a(WeakReference<Context> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "context");
        return h.j.b(weakReference).b();
    }
}
