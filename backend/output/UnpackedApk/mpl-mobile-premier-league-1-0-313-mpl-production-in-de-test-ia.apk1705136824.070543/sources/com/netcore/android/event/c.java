package com.netcore.android.event;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.inapp.b.C0009b;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.notification.SMTNotificationConstants;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceHelper.Companion;
import java.util.HashMap;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONObject;

/* compiled from: SMTEventPayloadCreator.kt */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f1074a = new c();

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r3 != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        if (r1 != null) goto L_0x000d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(java.util.HashMap<java.lang.String, java.lang.Object> r6, java.util.HashMap<java.lang.String, java.lang.Object> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "mid"
            if (r7 == 0) goto L_0x000b
            java.lang.Object r1 = r7.get(r0)
            if (r1 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            java.lang.String r1 = ""
        L_0x000d:
            java.lang.String r2 = "customPayload?.get(SMTEv…ID)\n                ?: \"\""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r6.put(r0, r1)
            java.lang.String r0 = "cg"
            r1 = 0
            if (r7 == 0) goto L_0x001f
            java.lang.Object r2 = r7.get(r0)
            goto L_0x0020
        L_0x001f:
            r2 = r1
        L_0x0020:
            if (r2 == 0) goto L_0x0069
            java.lang.String r2 = "cgRepeat"
            if (r7 == 0) goto L_0x002d
            java.lang.Object r3 = r7.get(r2)
            if (r3 == 0) goto L_0x002d
            goto L_0x0032
        L_0x002d:
            r3 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0032:
            java.lang.String r4 = "customPayload?.get(SMTEv…\n                    ?: 0"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r6.put(r2, r3)
            if (r7 == 0) goto L_0x0041
            java.lang.Object r2 = r7.get(r0)
            goto L_0x0042
        L_0x0041:
            r2 = r1
        L_0x0042:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r6.put(r0, r2)
            java.lang.String r0 = "cgRandom"
            if (r7 == 0) goto L_0x0052
            java.lang.Object r2 = r7.get(r0)
            goto L_0x0053
        L_0x0052:
            r2 = r1
        L_0x0053:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r6.put(r0, r2)
            java.lang.String r0 = "cgControlGroup"
            if (r7 == 0) goto L_0x0062
            java.lang.Object r1 = r7.get(r0)
        L_0x0062:
            java.lang.String r7 = java.lang.String.valueOf(r1)
            r6.put(r0, r7)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.event.c.b(java.util.HashMap, java.util.HashMap):void");
    }

    private final void c(Context context, HashMap<String, Object> hashMap) {
        SMTPreferenceHelper appPreferenceInstance = SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null);
        String string = appPreferenceInstance.getString(SMTPreferenceConstants.SMT_USER_OLD_IDENTITY, "");
        String string2 = appPreferenceInstance.getString(SMTPreferenceConstants.SMT_USER_IDENTITY, "");
        boolean z = true;
        boolean z2 = !Intrinsics.areEqual(string, string2);
        if (z2) {
            appPreferenceInstance.setString(SMTPreferenceConstants.SMT_USER_OLD_IDENTITY, string2);
        } else if (!z2) {
            z = false;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        hashMap.put(SMTEventParamKeys.SMT_LATE_BIND, Boolean.valueOf(z));
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("APP Launch status  ");
        outline73.append(hashMap.get(SMTEventParamKeys.SMT_LATE_BIND));
        sMTLogger.v("SMTEventPayload", outline73.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01db, code lost:
        if (r1 != null) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01ef, code lost:
        if (r1 != null) goto L_0x01fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0215, code lost:
        if (r2 != null) goto L_0x021a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0237, code lost:
        if (r1 != null) goto L_0x023b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02e0, code lost:
        if (r1 != null) goto L_0x02e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x02f4, code lost:
        if (r1 != null) goto L_0x02f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0325, code lost:
        if (r2 != null) goto L_0x0329;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0346, code lost:
        if (r1 != null) goto L_0x034f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x035b, code lost:
        if (r1 != null) goto L_0x035f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x037a, code lost:
        if (r1 != null) goto L_0x0382;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x038e, code lost:
        if (r1 != null) goto L_0x039a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
        if (r7 != null) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0099, code lost:
        if (r7 != null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ae, code lost:
        if (r7 != null) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002c, code lost:
        if (r7 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x012c, code lost:
        if (r1 != null) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0141, code lost:
        if (r1 != null) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0153, code lost:
        if (r2 != null) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0163, code lost:
        if (r1 != null) goto L_0x016b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0186, code lost:
        if (r1 != null) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01a7, code lost:
        if (r1 != null) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01bc, code lost:
        if (r1 != null) goto L_0x01c0;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.String, code=java.lang.Object, for r19v0, types: [java.lang.Object, java.lang.String] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.HashMap<java.lang.String, java.lang.Object> a(android.content.Context r17, int r18, java.lang.Object r19, com.netcore.android.utility.g r20, java.util.HashMap<java.lang.String, java.lang.Object> r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r21
            java.lang.String r4 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "smtInfo"
            r5 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)
            com.netcore.android.preference.SMTPreferenceHelper$Companion r4 = com.netcore.android.preference.SMTPreferenceHelper.Companion
            r6 = 0
            com.netcore.android.preference.SMTPreferenceHelper r4 = r4.getAppPreferenceInstance(r1, r6)
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            com.netcore.android.utility.j r7 = r20.d()
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x002f
            java.lang.String r7 = r7.f()
            if (r7 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r7 = r8
        L_0x0030:
            java.lang.String r9 = "networkMode"
            r6.put(r9, r7)
            r7 = 13
            r9 = 18
            if (r2 == r7) goto L_0x005b
            r7 = 14
            if (r2 == r7) goto L_0x005b
            r7 = 12
            if (r2 == r7) goto L_0x005b
            if (r2 == r9) goto L_0x005b
            java.lang.String r7 = "current_session_id"
            long r10 = r4.getLong(r7)
            r12 = 0
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 >= 0) goto L_0x0052
            r10 = r12
        L_0x0052:
            java.lang.String r7 = java.lang.String.valueOf(r10)
            java.lang.String r10 = "sessionId"
            r6.put(r10, r7)
        L_0x005b:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r18)
            java.lang.String r10 = "eventId"
            r6.put(r10, r7)
            if (r19 == 0) goto L_0x0069
            r7 = r19
            goto L_0x006a
        L_0x0069:
            r7 = r8
        L_0x006a:
            java.lang.String r10 = "eventName"
            r6.put(r10, r7)
            long r10 = java.lang.System.currentTimeMillis()
            java.lang.String r7 = java.lang.String.valueOf(r10)
            java.lang.String r10 = "eventTime"
            r6.put(r10, r7)
            com.netcore.android.utility.d r7 = r20.c()
            if (r7 == 0) goto L_0x0089
            java.lang.String r7 = r7.r()
            if (r7 == 0) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r7 = r8
        L_0x008a:
            java.lang.String r10 = "timeZone"
            r6.put(r10, r7)
            com.netcore.android.utility.d r7 = r20.c()
            if (r7 == 0) goto L_0x009c
            java.lang.String r7 = r7.s()
            if (r7 == 0) goto L_0x009c
            goto L_0x009d
        L_0x009c:
            r7 = r8
        L_0x009d:
            java.lang.String r10 = "screenOrientation"
            r6.put(r10, r7)
            com.netcore.android.utility.d r7 = r20.c()
            java.lang.String r10 = "0.0"
            if (r7 == 0) goto L_0x00b1
            java.lang.String r7 = r7.i()
            if (r7 == 0) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r7 = r10
        L_0x00b2:
            java.lang.String r11 = "lat"
            r6.put(r11, r7)
            com.netcore.android.utility.d r5 = r20.c()
            if (r5 == 0) goto L_0x00c4
            java.lang.String r5 = r5.l()
            if (r5 == 0) goto L_0x00c4
            r10 = r5
        L_0x00c4:
            java.lang.String r5 = "lng"
            r6.put(r5, r10)
            r5 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            java.lang.String r10 = "retry"
            r6.put(r10, r7)
            java.lang.String r7 = "smt_user_identity"
            java.lang.String r10 = r4.getString(r7)
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x00e1
            r10 = 1
            goto L_0x00e2
        L_0x00e1:
            r10 = 0
        L_0x00e2:
            if (r10 == 0) goto L_0x00e9
            java.lang.String r4 = r4.getString(r7)
            goto L_0x00ea
        L_0x00e9:
            r4 = r8
        L_0x00ea:
            java.lang.String r7 = "identity"
            r6.put(r7, r4)
            java.lang.String r4 = "payload"
            if (r2 == 0) goto L_0x03a8
            java.lang.String r7 = "customPayload?.get(SMTEv…: JSONObject().toString()"
            java.lang.String r10 = "pnMeta"
            java.lang.String r11 = "ct"
            java.lang.String r12 = "customPayload?.get(SMTEv…                     ?: 0"
            java.lang.String r13 = "isAmplified"
            java.lang.String r14 = "gwSource"
            java.lang.String r15 = "trid"
            java.lang.String r5 = "customPayload?.get(SMTEv…                    ?: \"\""
            if (r2 == r9) goto L_0x0340
            r9 = 19
            if (r2 == r9) goto L_0x031d
            switch(r2) {
                case 12: goto L_0x01a1;
                case 13: goto L_0x0123;
                case 14: goto L_0x0340;
                default: goto L_0x010c;
            }
        L_0x010c:
            switch(r2) {
                case 21: goto L_0x0229;
                case 22: goto L_0x0224;
                case 23: goto L_0x020a;
                default: goto L_0x010f;
            }
        L_0x010f:
            java.lang.String r7 = "cgRandom"
            java.lang.String r9 = "cgControlGroup"
            java.lang.String r10 = "cgRepeat"
            switch(r2) {
                case 40: goto L_0x02a8;
                case 41: goto L_0x02a0;
                case 42: goto L_0x027b;
                case 43: goto L_0x026a;
                case 44: goto L_0x0259;
                case 45: goto L_0x0259;
                case 46: goto L_0x0231;
                case 47: goto L_0x0259;
                default: goto L_0x0118;
            }
        L_0x0118:
            switch(r2) {
                case 63: goto L_0x02cc;
                case 64: goto L_0x02c0;
                case 65: goto L_0x02b4;
                default: goto L_0x011b;
            }
        L_0x011b:
            switch(r2) {
                case 86: goto L_0x02d8;
                case 87: goto L_0x02d8;
                case 88: goto L_0x02d8;
                default: goto L_0x011e;
            }
        L_0x011e:
            switch(r2) {
                case 91: goto L_0x0311;
                case 92: goto L_0x0311;
                case 93: goto L_0x0311;
                default: goto L_0x0121;
            }
        L_0x0121:
            goto L_0x03b8
        L_0x0123:
            r0.b(r1, r6)
            if (r3 == 0) goto L_0x012f
            java.lang.Object r1 = r3.get(r13)
            if (r1 == 0) goto L_0x012f
            goto L_0x0135
        L_0x012f:
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r1 = r2
        L_0x0135:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)
            r6.put(r13, r1)
            if (r3 == 0) goto L_0x0144
            java.lang.Object r1 = r3.get(r15)
            if (r1 == 0) goto L_0x0144
            goto L_0x0145
        L_0x0144:
            r1 = r8
        L_0x0145:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            r6.put(r15, r1)
            java.lang.String r1 = "apnClickLink"
            if (r3 == 0) goto L_0x0156
            java.lang.Object r2 = r3.get(r1)
            if (r2 == 0) goto L_0x0156
            goto L_0x0157
        L_0x0156:
            r2 = r8
        L_0x0157:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            r6.put(r1, r2)
            if (r3 == 0) goto L_0x0166
            java.lang.Object r1 = r3.get(r11)
            if (r1 == 0) goto L_0x0166
            goto L_0x016b
        L_0x0166:
            r1 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x016b:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)
            r6.put(r11, r1)
            if (r3 == 0) goto L_0x017a
            java.lang.Object r1 = r3.get(r14)
            if (r1 == 0) goto L_0x017a
            r8 = r1
        L_0x017a:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            r6.put(r14, r8)
            if (r3 == 0) goto L_0x0189
            java.lang.Object r1 = r3.get(r10)
            if (r1 == 0) goto L_0x0189
            goto L_0x0192
        L_0x0189:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r1 = r1.toString()
        L_0x0192:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r7)
            org.json.JSONObject r2 = new org.json.JSONObject
            java.lang.String r1 = (java.lang.String) r1
            r2.<init>(r1)
            r6.put(r10, r2)
            goto L_0x03b8
        L_0x01a1:
            if (r3 == 0) goto L_0x01aa
            java.lang.Object r1 = r3.get(r13)
            if (r1 == 0) goto L_0x01aa
            goto L_0x01b0
        L_0x01aa:
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r1 = r2
        L_0x01b0:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)
            r6.put(r13, r1)
            if (r3 == 0) goto L_0x01bf
            java.lang.Object r1 = r3.get(r15)
            if (r1 == 0) goto L_0x01bf
            goto L_0x01c0
        L_0x01bf:
            r1 = r8
        L_0x01c0:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            r6.put(r15, r1)
            if (r3 == 0) goto L_0x01cf
            java.lang.Object r1 = r3.get(r14)
            if (r1 == 0) goto L_0x01cf
            r8 = r1
        L_0x01cf:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            r6.put(r14, r8)
            if (r3 == 0) goto L_0x01de
            java.lang.Object r1 = r3.get(r11)
            if (r1 == 0) goto L_0x01de
            goto L_0x01e3
        L_0x01de:
            r1 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x01e3:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)
            r6.put(r11, r1)
            if (r3 == 0) goto L_0x01f2
            java.lang.Object r1 = r3.get(r10)
            if (r1 == 0) goto L_0x01f2
            goto L_0x01fb
        L_0x01f2:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r1 = r1.toString()
        L_0x01fb:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r7)
            org.json.JSONObject r2 = new org.json.JSONObject
            java.lang.String r1 = (java.lang.String) r1
            r2.<init>(r1)
            r6.put(r10, r2)
            goto L_0x03b8
        L_0x020a:
            r0.b(r1, r6)
            java.lang.String r1 = "clearIdentity"
            if (r3 == 0) goto L_0x0218
            java.lang.Object r2 = r3.get(r1)
            if (r2 == 0) goto L_0x0218
            goto L_0x021a
        L_0x0218:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
        L_0x021a:
            java.lang.String r3 = "customPayload?.get(SMTEv…                 ?: false"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r6.put(r1, r2)
            goto L_0x03b8
        L_0x0224:
            r0.b(r1, r6)
            goto L_0x03b8
        L_0x0229:
            r0.b(r1, r6)
            r0.c(r1, r6)
            goto L_0x03b8
        L_0x0231:
            if (r3 == 0) goto L_0x023a
            java.lang.Object r1 = r3.get(r15)
            if (r1 == 0) goto L_0x023a
            goto L_0x023b
        L_0x023a:
            r1 = r8
        L_0x023b:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            r6.put(r15, r1)
            if (r3 == 0) goto L_0x024c
            java.lang.String r1 = "inboxClickLink"
            java.lang.Object r1 = r3.get(r1)
            if (r1 == 0) goto L_0x024c
            r8 = r1
        L_0x024c:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            java.lang.String r1 = "inboxClickLink"
            r6.put(r1, r8)
            r0.a(r6, r3)
            goto L_0x03b8
        L_0x0259:
            if (r3 == 0) goto L_0x0262
            java.lang.Object r1 = r3.get(r15)
            if (r1 == 0) goto L_0x0262
            r8 = r1
        L_0x0262:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            r6.put(r15, r8)
            goto L_0x03b8
        L_0x026a:
            r0.b(r1, r6)
            r0.b(r6, r3)
            r6.remove(r10)
            r6.remove(r9)
            r6.remove(r7)
            goto L_0x03b8
        L_0x027b:
            r0.b(r6, r3)
            r0.a(r6, r3)
            r0.b(r1, r6)
            r6.remove(r10)
            r6.remove(r9)
            r6.remove(r7)
            java.lang.String r1 = "inAppClickLink"
            if (r3 == 0) goto L_0x0298
            java.lang.Object r2 = r3.get(r1)
            if (r2 == 0) goto L_0x0298
            r8 = r2
        L_0x0298:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            r6.put(r1, r8)
            goto L_0x03b8
        L_0x02a0:
            r0.b(r1, r6)
            r0.b(r6, r3)
            goto L_0x03b8
        L_0x02a8:
            if (r3 == 0) goto L_0x02af
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r3)
        L_0x02af:
            r6.put(r4, r8)
            goto L_0x03b8
        L_0x02b4:
            if (r3 == 0) goto L_0x02bb
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r3)
        L_0x02bb:
            r6.put(r4, r8)
            goto L_0x03b8
        L_0x02c0:
            if (r3 == 0) goto L_0x02c7
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r3)
        L_0x02c7:
            r6.put(r4, r8)
            goto L_0x03b8
        L_0x02cc:
            if (r3 == 0) goto L_0x02d3
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r3)
        L_0x02d3:
            r6.put(r4, r8)
            goto L_0x03b8
        L_0x02d8:
            if (r3 == 0) goto L_0x02e3
            java.lang.String r1 = "pushTokenOld"
            java.lang.Object r1 = r3.get(r1)
            if (r1 == 0) goto L_0x02e3
            goto L_0x02e4
        L_0x02e3:
            r1 = r8
        L_0x02e4:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            java.lang.String r2 = "pushTokenOld"
            r6.put(r2, r1)
            if (r3 == 0) goto L_0x02f7
            java.lang.String r1 = "pushToken"
            java.lang.Object r1 = r3.get(r1)
            if (r1 == 0) goto L_0x02f7
            goto L_0x02f8
        L_0x02f7:
            r1 = r8
        L_0x02f8:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            java.lang.String r2 = "pushToken"
            r6.put(r2, r1)
            if (r3 == 0) goto L_0x0309
            java.lang.Object r1 = r3.get(r14)
            if (r1 == 0) goto L_0x0309
            r8 = r1
        L_0x0309:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            r6.put(r14, r8)
            goto L_0x03b8
        L_0x0311:
            if (r3 == 0) goto L_0x0318
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r3)
        L_0x0318:
            r6.put(r4, r8)
            goto L_0x03b8
        L_0x031d:
            java.lang.String r1 = "pnReply"
            if (r3 == 0) goto L_0x0328
            java.lang.Object r2 = r3.get(r1)
            if (r2 == 0) goto L_0x0328
            goto L_0x0329
        L_0x0328:
            r2 = r8
        L_0x0329:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            r6.put(r1, r2)
            if (r3 == 0) goto L_0x0338
            java.lang.Object r1 = r3.get(r15)
            if (r1 == 0) goto L_0x0338
            r8 = r1
        L_0x0338:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            r6.put(r15, r8)
            goto L_0x03b8
        L_0x0340:
            if (r3 == 0) goto L_0x0349
            java.lang.Object r1 = r3.get(r13)
            if (r1 == 0) goto L_0x0349
            goto L_0x034f
        L_0x0349:
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r1 = r2
        L_0x034f:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)
            r6.put(r13, r1)
            if (r3 == 0) goto L_0x035e
            java.lang.Object r1 = r3.get(r15)
            if (r1 == 0) goto L_0x035e
            goto L_0x035f
        L_0x035e:
            r1 = r8
        L_0x035f:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            r6.put(r15, r1)
            if (r3 == 0) goto L_0x036e
            java.lang.Object r1 = r3.get(r14)
            if (r1 == 0) goto L_0x036e
            r8 = r1
        L_0x036e:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            r6.put(r14, r8)
            if (r3 == 0) goto L_0x037d
            java.lang.Object r1 = r3.get(r11)
            if (r1 == 0) goto L_0x037d
            goto L_0x0382
        L_0x037d:
            r1 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0382:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)
            r6.put(r11, r1)
            if (r3 == 0) goto L_0x0391
            java.lang.Object r1 = r3.get(r10)
            if (r1 == 0) goto L_0x0391
            goto L_0x039a
        L_0x0391:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r1 = r1.toString()
        L_0x039a:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r7)
            org.json.JSONObject r2 = new org.json.JSONObject
            java.lang.String r1 = (java.lang.String) r1
            r2.<init>(r1)
            r6.put(r10, r2)
            goto L_0x03b8
        L_0x03a8:
            r0.b(r1, r6)
            r0.a(r1, r6)
            if (r3 == 0) goto L_0x03b5
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r3)
        L_0x03b5:
            r6.put(r4, r8)
        L_0x03b8:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.event.c.a(android.content.Context, int, java.lang.String, com.netcore.android.utility.g, java.util.HashMap):java.util.HashMap");
    }

    private final void b(Context context, HashMap<String, Object> hashMap) {
        JSONObject jSONObject;
        String string = SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null).getString(SMTPreferenceConstants.SMT_ATTRIBUTION_PARAMS);
        boolean z = string.length() > 0;
        if (z) {
            jSONObject = new JSONObject(string);
        } else if (!z) {
            jSONObject = new JSONObject();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        hashMap.put("attrParams", jSONObject);
    }

    private final void a(Context context, HashMap<String, Object> hashMap) {
        Companion companion = SMTPreferenceHelper.Companion;
        String string = companion.getAppPreferenceInstance(context, null).getString(SMTPreferenceConstants.SMT_CG, "");
        boolean z = true;
        if (string.length() > 0) {
            hashMap.put(SMTEventParamKeys.SMT_CG, string);
        }
        String string2 = companion.getAppPreferenceInstance(context, null).getString(SMTPreferenceConstants.SMT_MID, "");
        if (string2.length() <= 0) {
            z = false;
        }
        if (z) {
            hashMap.put(SMTEventParamKeys.SMT_MID, Integer.valueOf(Integer.parseInt(string2)));
        }
    }

    private final void a(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        if (hashMap2 != null && (!hashMap2.isEmpty())) {
            if (hashMap2.containsKey(SMTNotificationConstants.NOTIF_ATTRIBUTION_ID)) {
                try {
                    hashMap.put("atci", Integer.valueOf(Integer.parseInt(String.valueOf(hashMap2.get(SMTNotificationConstants.NOTIF_ATTRIBUTION_ID)))));
                } catch (Exception unused) {
                }
            }
            Object obj = "";
            if (hashMap2.containsKey(SMTNotificationConstants.NOTIF_ATTRIBUTION_SOURCE)) {
                Object obj2 = hashMap2.get(SMTNotificationConstants.NOTIF_ATTRIBUTION_SOURCE);
                if (obj2 == null) {
                    obj2 = obj;
                }
                Intrinsics.checkNotNullExpressionValue(obj2, "customPayload[SMTNotific…                    ?: \"\"");
                hashMap.put("atcs", obj2);
            }
            if (hashMap2.containsKey(SMTNotificationConstants.NOTIF_ATTRIBUTION_MEDIUM)) {
                Object obj3 = hashMap2.get(SMTNotificationConstants.NOTIF_ATTRIBUTION_MEDIUM);
                if (obj3 != null) {
                    obj = obj3;
                }
                Intrinsics.checkNotNullExpressionValue(obj, "customPayload[SMTNotific…                    ?: \"\"");
                hashMap.put("atcm", obj);
            }
        }
    }

    public final HashMap<String, Object> a(com.netcore.android.inapp.h.b.c cVar) {
        int i;
        Intrinsics.checkNotNullParameter(cVar, "multiEventsRules");
        HashMap<String, Object> hashMap = new HashMap<>();
        String a2 = cVar.a();
        if (CharsKt__CharKt.equals(a2, C0009b.APP_LAUNCH.getValue(), true)) {
            i = 21;
        } else {
            i = CharsKt__CharKt.equals(a2, C0009b.FIRST_APP_LAUNCH.getValue(), true) ? 80 : 0;
        }
        hashMap.put(SMTEventParamKeys.SMT_EVENT_ID, Integer.valueOf(i));
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        if (a2 != null) {
            String lowerCase = a2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            hashMap.put("eventName", lowerCase);
            hashMap.put(SMTEventParamKeys.SMT_EVENT_TIME, cVar.b());
            return hashMap;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
