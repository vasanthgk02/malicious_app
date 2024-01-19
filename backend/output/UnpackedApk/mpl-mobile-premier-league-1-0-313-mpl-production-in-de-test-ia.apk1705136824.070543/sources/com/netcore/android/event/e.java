package com.netcore.android.event;

import android.content.Context;
import com.netcore.android.Smartech;
import com.netcore.android.e.b;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.utility.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTEventRecorder.kt */
public final class e {

    /* renamed from: c  reason: collision with root package name */
    public static b f1078c;

    /* renamed from: d  reason: collision with root package name */
    public static g f1079d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile e f1080e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f1081f = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final String f1082a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1083b;

    /* compiled from: SMTEventRecorder.kt */
    public static final class a {
        public a() {
        }

        private final e a(Context context) {
            e.f1079d = g.f1302f.b(new WeakReference(context));
            e.f1078c = b.f1030c.b(new WeakReference(context));
            return new e(context, null);
        }

        public final e b(Context context) {
            e eVar;
            Intrinsics.checkNotNullParameter(context, "context");
            e a2 = e.f1080e;
            if (a2 != null) {
                return a2;
            }
            synchronized (e.class) {
                try {
                    e a3 = e.f1080e;
                    if (a3 != null) {
                        eVar = a3;
                    } else {
                        eVar = e.f1081f.a(context);
                        e.f1080e = eVar;
                    }
                }
            }
            return eVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e(Context context) {
        this.f1083b = context;
        this.f1082a = e.class.getSimpleName();
    }

    public final Pair<String, Boolean> b(String str) {
        Intrinsics.checkNotNullParameter(str, "eventType");
        return new Pair<>(str, Boolean.valueOf(a(str)));
    }

    public /* synthetic */ e(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public static /* synthetic */ void a(e eVar, int i, String str, HashMap hashMap, String str2, boolean z, int i2, Object obj) {
        eVar.a(i, str, hashMap, str2, (i2 & 16) != 0 ? false : z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x011e, code lost:
        if (java.lang.Double.parseDouble(r6) == 0.0d) goto L_0x0120;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r22, java.lang.String r23, java.util.HashMap<java.lang.String, java.lang.Object> r24, java.lang.String r25, boolean r26) {
        /*
            r21 = this;
            r0 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            java.lang.String r1 = "eventType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            com.netcore.android.utility.SMTCommonUtility r1 = com.netcore.android.utility.SMTCommonUtility.INSTANCE
            android.content.Context r2 = r0.f1083b
            boolean r2 = r1.checkIfTrackingAllowed$smartech_release(r2)
            com.netcore.android.logger.SMTLogger r11 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Status of tracking: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            java.lang.String r12 = "SMTEventRecorder"
            r11.internal(r12, r3)
            boolean r1 = r1.eventsRepository$smartech_release(r7)
            if (r1 != 0) goto L_0x0038
            if (r2 != 0) goto L_0x0038
            return
        L_0x0038:
            kotlin.Pair r1 = r0.b(r10)
            A r2 = r1.first
            java.lang.String r2 = (java.lang.String) r2
            B r1 = r1.second
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x006b
            java.lang.String r1 = r0.f1082a
            java.lang.String r3 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Event type "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = " is not allowed."
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r11.internal(r1, r2)
            return
        L_0x006b:
            com.netcore.android.utility.g r5 = f1079d
            if (r5 == 0) goto L_0x01d6
            r13 = 0
            r15 = 0
            if (r26 != 0) goto L_0x00c3
            com.netcore.android.Smartech$Companion r1 = com.netcore.android.Smartech.Companion
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            android.content.Context r3 = r0.f1083b
            r2.<init>(r3)
            com.netcore.android.Smartech r2 = r1.getInstance(r2)
            com.netcore.android.smartechbase.communication.HanselInterface r2 = r2.getHanselInstance$smartech_release()
            if (r2 == 0) goto L_0x0090
            kotlin.jvm.internal.Intrinsics.checkNotNull(r23)
            java.lang.String r3 = "smt"
            java.util.HashMap r2 = r2.logEvent(r8, r3, r9)
            goto L_0x0091
        L_0x0090:
            r2 = r13
        L_0x0091:
            if (r2 == 0) goto L_0x009c
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x009a
            goto L_0x009c
        L_0x009a:
            r3 = 0
            goto L_0x009d
        L_0x009c:
            r3 = 1
        L_0x009d:
            if (r3 != 0) goto L_0x00c3
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference
            android.content.Context r4 = r0.f1083b
            r3.<init>(r4)
            com.netcore.android.Smartech r1 = r1.getInstance(r3)
            java.lang.String r1 = r1.getUserIdentity()
            int r3 = r1.length()
            if (r3 <= 0) goto L_0x00b6
            r3 = 1
            goto L_0x00b7
        L_0x00b6:
            r3 = 0
        L_0x00b7:
            if (r3 == 0) goto L_0x00be
            java.lang.String r3 = "identity"
            r2.put(r3, r1)
        L_0x00be:
            if (r9 == 0) goto L_0x00c3
            r9.putAll(r2)
        L_0x00c3:
            com.netcore.android.event.c r1 = com.netcore.android.event.c.f1074a
            android.content.Context r2 = r0.f1083b
            r3 = r22
            r4 = r23
            r6 = r24
            java.util.HashMap r1 = r1.a(r2, r3, r4, r5, r6)
            int r2 = r1.size()
            if (r2 != 0) goto L_0x00d8
            return
        L_0x00d8:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>(r1)
            java.lang.String r3 = "lat"
            java.lang.String r4 = r2.optString(r3)
            java.lang.String r5 = "lng"
            java.lang.String r6 = r2.optString(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)
            int r16 = r4.length()
            if (r16 != 0) goto L_0x00f5
            r16 = 1
            goto L_0x00f7
        L_0x00f5:
            r16 = 0
        L_0x00f7:
            r17 = 0
            if (r16 != 0) goto L_0x0103
            double r19 = java.lang.Double.parseDouble(r4)
            int r16 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1))
            if (r16 != 0) goto L_0x0108
        L_0x0103:
            java.lang.Object r14 = org.json.JSONObject.NULL
            r2.put(r3, r14)
        L_0x0108:
            int r3 = r4.length()
            if (r3 != 0) goto L_0x0110
            r14 = 1
            goto L_0x0111
        L_0x0110:
            r14 = 0
        L_0x0111:
            if (r14 != 0) goto L_0x0120
            java.lang.String r3 = "long"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            double r3 = java.lang.Double.parseDouble(r6)
            int r6 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r6 != 0) goto L_0x0125
        L_0x0120:
            java.lang.Object r3 = org.json.JSONObject.NULL
            r2.put(r5, r3)
        L_0x0125:
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "if (eventMap.size == 0) ….toString()\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.netcore.android.e.b r3 = f1078c
            if (r3 == 0) goto L_0x0135
            r3.a(r7, r8, r2, r10)
        L_0x0135:
            com.netcore.android.e.b r3 = f1078c
            if (r3 == 0) goto L_0x014c
            com.netcore.android.preference.SMTPreferenceHelper$Companion r4 = com.netcore.android.preference.SMTPreferenceHelper.Companion
            android.content.Context r5 = r0.f1083b
            com.netcore.android.preference.SMTPreferenceHelper r4 = r4.getAppPreferenceInstance(r5, r13)
            r5 = 200(0xc8, float:2.8E-43)
            java.lang.String r6 = "eventLimit"
            int r4 = r4.getInt(r6, r5)
            r3.c(r4)
        L_0x014c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Event name: "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r11.i(r12, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Event id: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r11.i(r12, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Event type: "
            r3.append(r4)
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            r11.i(r12, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Event Payload: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r11.i(r12, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Payload: "
            r2.append(r3)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            r11.i(r12, r2)
            com.netcore.android.inapp.g$a r2 = com.netcore.android.inapp.g.f1213b
            boolean r2 = r2.a(r7)
            if (r2 != 0) goto L_0x01db
            if (r7 <= 0) goto L_0x01cc
            android.content.Context r2 = r0.f1083b
            boolean r2 = r0.a(r2, r7)
            if (r2 == 0) goto L_0x01db
            com.netcore.android.inapp.c$a r2 = com.netcore.android.inapp.c.g
            com.netcore.android.inapp.c r2 = r2.b()
            r2.a(r1)
            goto L_0x01db
        L_0x01cc:
            com.netcore.android.inapp.c$a r2 = com.netcore.android.inapp.c.g
            com.netcore.android.inapp.c r2 = r2.b()
            r2.a(r1)
            goto L_0x01db
        L_0x01d6:
            java.lang.String r1 = "SMTInfo is null."
            r11.internal(r12, r1)
        L_0x01db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.event.e.a(int, java.lang.String, java.util.HashMap, java.lang.String, boolean):void");
    }

    private final boolean a(Context context, int i) {
        boolean z = i == 20 || i == 21 || i == 26 || i == 83 || i == 84 || i == 89 || i == 90;
        Smartech instance = Smartech.Companion.getInstance(new WeakReference(context));
        boolean inAppRuleListStatus$smartech_release = instance.getInAppRuleListStatus$smartech_release();
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        sMTLogger.i("SMTEventRecorder", "InApp : Flag is " + inAppRuleListStatus$smartech_release + " , Event id " + i + " present " + z);
        if (!z || inAppRuleListStatus$smartech_release) {
            return true;
        }
        instance.getSystemInAppEventList$smartech_release().add(Integer.valueOf(i));
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        if (r8.equals("system") != false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        if (r8.equals(com.netcore.android.event.SMTEventType.EVENT_TYPE_CUSTOM) != false) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean a(java.lang.String r8) {
        /*
            r7 = this;
            com.netcore.android.preference.SMTPreferenceHelper$Companion r0 = com.netcore.android.preference.SMTPreferenceHelper.Companion
            android.content.Context r1 = r7.f1083b
            r2 = 0
            com.netcore.android.preference.SMTPreferenceHelper r0 = r0.getAppPreferenceInstance(r1, r2)
            java.lang.String r1 = "isAllEventsEnabled"
            r2 = 1
            boolean r1 = r0.getBoolean(r1, r2)
            r3 = 0
            if (r1 != 0) goto L_0x0014
            return r3
        L_0x0014:
            java.lang.String r1 = "isPushEventsEnabled"
            boolean r1 = r0.getBoolean(r1, r2)
            java.lang.String r4 = "isLifecycleEventsEnabled"
            boolean r4 = r0.getBoolean(r4, r2)
            java.lang.String r5 = "isInAppEventsEnabled"
            boolean r5 = r0.getBoolean(r5, r2)
            java.lang.String r6 = "isInboxEventsEnabled"
            boolean r0 = r0.getBoolean(r6, r2)
            int r6 = r8.hashCode()
            switch(r6) {
                case -1498731332: goto L_0x0064;
                case -1349088399: goto L_0x005b;
                case -887328209: goto L_0x0052;
                case -633937704: goto L_0x0048;
                case 1888363543: goto L_0x003e;
                case 2010049504: goto L_0x0034;
                default: goto L_0x0033;
            }
        L_0x0033:
            goto L_0x006e
        L_0x0034:
            java.lang.String r0 = "system_push_notification"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x006e
            r2 = r1
            goto L_0x006f
        L_0x003e:
            java.lang.String r0 = "system_in_app"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x006e
            r2 = r5
            goto L_0x006f
        L_0x0048:
            java.lang.String r1 = "system_app_inbox"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x006e
            r2 = r0
            goto L_0x006f
        L_0x0052:
            java.lang.String r0 = "system"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x006e
            goto L_0x006f
        L_0x005b:
            java.lang.String r0 = "custom"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x006e
            goto L_0x006f
        L_0x0064:
            java.lang.String r0 = "system_app_lifecycle"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x006e
            r2 = r4
            goto L_0x006f
        L_0x006e:
            r2 = 0
        L_0x006f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.event.e.a(java.lang.String):boolean");
    }
}
