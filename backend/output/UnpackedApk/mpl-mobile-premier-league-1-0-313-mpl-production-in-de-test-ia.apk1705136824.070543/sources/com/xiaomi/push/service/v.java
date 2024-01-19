package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.android.a;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bi;
import com.xiaomi.push.cd;
import com.xiaomi.push.cg;
import com.xiaomi.push.ci;
import com.xiaomi.push.cj;
import com.xiaomi.push.cx;
import com.xiaomi.push.cz;
import com.xiaomi.push.df;
import com.xiaomi.push.di;
import com.xiaomi.push.dl;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.ee;
import com.xiaomi.push.service.XMPushService.j;
import com.xiaomi.push.service.ag.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.pdfparser.BaseParser;

public class v {
    public static Intent a(byte[] bArr, long j) {
        dq a2 = a(bArr);
        if (a2 == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a2.f583b);
        return intent;
    }

    public static dq a(Context context, dq dqVar) {
        return a(context, dqVar, (Map<String, String>) null);
    }

    public static dq a(Context context, dq dqVar, Map<String, String> map) {
        dl dlVar = new dl();
        dlVar.b(dqVar.a());
        di a2 = dqVar.a();
        if (a2 != null) {
            dlVar.a(a2.a());
            dlVar.a(a2.a());
            if (!TextUtils.isEmpty(a2.b())) {
                dlVar.c(a2.b());
            }
        }
        dlVar.a(ee.a(context, dqVar));
        dq a3 = ad.a(dqVar.b(), dqVar.a(), dlVar, cz.AckMessage);
        di a4 = dqVar.a();
        if (a4 != null) {
            a4 = bj.a(a4.a());
        }
        a4.a("mat", Long.toString(System.currentTimeMillis()));
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String next : map.keySet()) {
                        a4.a(next, map.get(next));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        a3.a(a4);
        return a3;
    }

    public static dq a(byte[] bArr) {
        dq dqVar = new dq();
        try {
            ee.a(dqVar, bArr);
            return dqVar;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public static void a(Context context, dq dqVar, byte[] bArr) {
        try {
            ag.a(dqVar);
            dqVar.a();
            c a2 = ag.a(context, dqVar, bArr);
            if (a2.f4849a > 0 && !TextUtils.isEmpty(a2.f837a)) {
                cx.a(context, a2.f837a, a2.f4849a, true, false, System.currentTimeMillis());
            }
            if (!f.a(context) || !ac.a(context, dqVar, a2.f838a)) {
                b(context, dqVar, bArr);
                return;
            }
            ac.a(context, dqVar);
            b.a((String) "consume this broadcast by tts");
        } catch (Exception e2) {
            b.a("notify push msg error " + e2);
            e2.printStackTrace();
        }
    }

    public static void a(XMPushService xMPushService, dq dqVar) {
        xMPushService.a((j) new w(4, xMPushService, dqVar));
    }

    public static void a(XMPushService xMPushService, dq dqVar, dt dtVar) {
        xMPushService.a((j) new ab(4, dtVar, dqVar, xMPushService));
    }

    public static void a(XMPushService xMPushService, dq dqVar, String str) {
        xMPushService.a((j) new z(4, xMPushService, dqVar, str));
    }

    public static void a(XMPushService xMPushService, dq dqVar, String str, String str2) {
        aa aaVar = new aa(4, xMPushService, dqVar, str, str2);
        xMPushService.a((j) aaVar);
    }

    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11, types: [com.xiaomi.push.ef] */
    /* JADX WARNING: type inference failed for: r2v12, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r2v13, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v14, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v16, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v38 */
    /* JADX WARNING: type inference failed for: r2v39 */
    /* JADX WARNING: type inference failed for: r2v40 */
    /* JADX WARNING: type inference failed for: r2v41 */
    /* JADX WARNING: type inference failed for: r2v42 */
    /* JADX WARNING: type inference failed for: r2v43 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v10
      assigns: []
      uses: []
      mth insns count: 231
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x022b A[SYNTHETIC, Splitter:B:101:0x022b] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02ae  */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.xiaomi.push.service.XMPushService r12, java.lang.String r13, byte[] r14, android.content.Intent r15) {
        /*
            com.xiaomi.push.dq r0 = a(r14)
            com.xiaomi.push.di r1 = r0.a()
            boolean r2 = c(r0)
            if (r2 == 0) goto L_0x0019
            boolean r2 = a(r12, r13)
            if (r2 == 0) goto L_0x0019
            b(r12, r0)
            goto L_0x02d1
        L_0x0019:
            boolean r2 = a(r0)
            if (r2 == 0) goto L_0x0030
            boolean r2 = a(r12, r13)
            if (r2 != 0) goto L_0x0030
            boolean r2 = b(r0)
            if (r2 != 0) goto L_0x0030
            c(r12, r0)
            goto L_0x02d1
        L_0x0030:
            boolean r2 = com.xiaomi.push.service.ag.a(r0)
            if (r2 != 0) goto L_0x0044
            boolean r2 = a(r12, r15)
            if (r2 == 0) goto L_0x003d
            goto L_0x0044
        L_0x003d:
            java.lang.String r12 = "receive a mipush message, we can see the app, but we can't see the receiver."
            com.xiaomi.channel.commonutils.logger.b.a(r12)
            goto L_0x02d1
        L_0x0044:
            com.xiaomi.push.cz r2 = com.xiaomi.push.cz.Registration
            com.xiaomi.push.cz r3 = r0.a()
            r4 = 0
            java.lang.String r5 = "eventMessageType"
            java.lang.String r6 = "messageId"
            if (r2 != r3) goto L_0x00b0
            java.lang.String r2 = r0.b()
            java.lang.String r3 = "pref_registered_pkg_names"
            android.content.SharedPreferences r3 = r12.getSharedPreferences(r3, r4)
            android.content.SharedPreferences$Editor r3 = r3.edit()
            java.lang.String r7 = r0.f579a
            r3.putString(r2, r7)
            r3.commit()
            com.xiaomi.push.dv r3 = com.xiaomi.push.service.m.a(r0)
            long r7 = r3.a()
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0087
            java.lang.String r7 = r3.b()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0087
            java.lang.String r3 = r3.b()
            com.xiaomi.push.service.m.a(r12, r2, r3)
            goto L_0x008c
        L_0x0087:
            java.lang.String r3 = "read regSecret failed"
            com.xiaomi.channel.commonutils.logger.b.d(r3)
        L_0x008c:
            com.xiaomi.push.service.s r3 = com.xiaomi.push.service.s.a(r12)
            r3.e(r2)
            com.xiaomi.push.service.s r3 = com.xiaomi.push.service.s.a(r12)
            r3.f(r2)
            java.lang.String r2 = r1.a()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00b0
            java.lang.String r2 = r1.a()
            r15.putExtra(r6, r2)
            r2 = 6000(0x1770, float:8.408E-42)
            r15.putExtra(r5, r2)
        L_0x00b0:
            boolean r2 = com.xiaomi.push.service.ag.c(r0)
            if (r2 == 0) goto L_0x00cc
            java.lang.String r2 = r1.a()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00cc
            java.lang.String r2 = r1.a()
            r15.putExtra(r6, r2)
            r2 = 1000(0x3e8, float:1.401E-42)
            r15.putExtra(r5, r2)
        L_0x00cc:
            boolean r2 = com.xiaomi.push.service.ag.b(r0)
            if (r2 == 0) goto L_0x00e8
            java.lang.String r2 = r1.a()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00e8
            java.lang.String r2 = r1.a()
            r15.putExtra(r6, r2)
            r2 = 2000(0x7d0, float:2.803E-42)
            r15.putExtra(r5, r2)
        L_0x00e8:
            boolean r2 = com.xiaomi.push.service.ag.a(r0)
            if (r2 == 0) goto L_0x0104
            java.lang.String r2 = r1.a()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0104
            java.lang.String r2 = r1.a()
            r15.putExtra(r6, r2)
            r2 = 3000(0xbb8, float:4.204E-42)
            r15.putExtra(r5, r2)
        L_0x0104:
            r2 = 0
            java.lang.String r3 = "com.xiaomi.xmsf"
            r5 = 1
            if (r1 == 0) goto L_0x017e
            java.lang.String r6 = r1.c()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x017e
            java.lang.String r6 = r1.d()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x017e
            int r6 = r1.f495b
            if (r6 == r5) goto L_0x017e
            java.lang.String r6 = r0.f583b
            java.util.Map r7 = r1.a()
            boolean r7 = com.xiaomi.push.service.ag.a(r7)
            boolean r6 = com.xiaomi.push.service.ag.a(r12, r6, r7)
            if (r6 == 0) goto L_0x0133
            goto L_0x017e
        L_0x0133:
            java.util.Map<java.lang.String, java.lang.String> r13 = r1.f493a
            if (r13 == 0) goto L_0x0140
            java.lang.String r15 = "jobkey"
            java.lang.Object r13 = r13.get(r15)
            r2 = r13
            java.lang.String r2 = (java.lang.String) r2
        L_0x0140:
            boolean r13 = android.text.TextUtils.isEmpty(r2)
            if (r13 == 0) goto L_0x014a
            java.lang.String r2 = r1.a()
        L_0x014a:
            java.lang.String r13 = r0.f583b
            boolean r13 = com.xiaomi.push.service.ai.a(r12, r13, r2)
            if (r13 == 0) goto L_0x0167
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "drop a duplicate message, key="
            r13.append(r14)
            r13.append(r2)
            java.lang.String r13 = r13.toString()
        L_0x0163:
            com.xiaomi.channel.commonutils.logger.b.a(r13)
            goto L_0x0179
        L_0x0167:
            boolean r13 = com.xiaomi.channel.commonutils.android.f.a(r12)
            if (r13 == 0) goto L_0x0176
            boolean r13 = com.xiaomi.push.service.ac.a(r0)
            if (r13 == 0) goto L_0x0176
            java.lang.String r13 = "receive pull down message"
            goto L_0x0163
        L_0x0176:
            a(r12, r0, r14)
        L_0x0179:
            a(r12, r0)
            goto L_0x02bc
        L_0x017e:
            java.lang.String r14 = r0.f583b
            boolean r14 = r3.contains(r14)
            if (r14 == 0) goto L_0x01bd
            boolean r14 = r0.b()
            if (r14 != 0) goto L_0x01bd
            if (r1 == 0) goto L_0x01bd
            java.util.Map r14 = r1.a()
            if (r14 == 0) goto L_0x01bd
            java.util.Map r14 = r1.a()
            java.lang.String r6 = "ab"
            boolean r14 = r14.containsKey(r6)
            if (r14 == 0) goto L_0x01bd
            a(r12, r0)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "receive abtest message. ack it."
            r13.append(r14)
            java.lang.String r14 = r1.a()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            com.xiaomi.channel.commonutils.logger.b.c(r13)
            goto L_0x02bc
        L_0x01bd:
            boolean r13 = a(r12, r13, r0, r1)
            if (r13 == 0) goto L_0x02bc
            com.xiaomi.push.cz r13 = com.xiaomi.push.cz.Notification
            com.xiaomi.push.cz r14 = r0.f576a
            if (r13 != r14) goto L_0x02ab
            com.xiaomi.push.ef r2 = com.xiaomi.push.service.bt.a(r12, r0)     // Catch:{ ej -> 0x01e8 }
            if (r2 != 0) goto L_0x01e6
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ ej -> 0x01e8 }
            r13.<init>()     // Catch:{ ej -> 0x01e8 }
            java.lang.String r14 = "receiving an un-recognized notification message. "
            r13.append(r14)     // Catch:{ ej -> 0x01e8 }
            com.xiaomi.push.cz r14 = r0.f576a     // Catch:{ ej -> 0x01e8 }
            r13.append(r14)     // Catch:{ ej -> 0x01e8 }
            java.lang.String r13 = r13.toString()     // Catch:{ ej -> 0x01e8 }
            com.xiaomi.channel.commonutils.logger.b.d(r13)     // Catch:{ ej -> 0x01e8 }
            goto L_0x01fd
        L_0x01e6:
            r13 = 1
            goto L_0x01fe
        L_0x01e8:
            r13 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r6 = "receive a message which action string is not valid. "
            r14.append(r6)
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r13)
        L_0x01fd:
            r13 = 0
        L_0x01fe:
            if (r13 == 0) goto L_0x02ab
            boolean r13 = r2 instanceof com.xiaomi.push.dt
            if (r13 == 0) goto L_0x02ab
            com.xiaomi.push.dt r2 = (com.xiaomi.push.dt) r2
            com.xiaomi.push.df r13 = com.xiaomi.push.df.CancelPushMessage
            java.lang.String r13 = r13.f458a
            java.lang.String r14 = r2.f600d
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x02ab
            java.util.Map r13 = r2.a()
            if (r13 == 0) goto L_0x02ab
            java.util.Map r13 = r2.a()
            java.lang.String r14 = com.xiaomi.push.service.bd.N
            java.lang.Object r13 = r13.get(r14)
            java.lang.String r13 = (java.lang.String) r13
            boolean r14 = android.text.TextUtils.isEmpty(r13)
            r5 = -2
            if (r14 != 0) goto L_0x0245
            int r5 = java.lang.Integer.parseInt(r13)     // Catch:{ NumberFormatException -> 0x0230 }
            goto L_0x0245
        L_0x0230:
            r13 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r6 = "parse notifyId from STRING to INT failed: "
            r14.append(r6)
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r13)
        L_0x0245:
            r13 = -1
            if (r5 < r13) goto L_0x0263
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "try to retract a message by notifyId="
            r13.append(r14)
            r13.append(r5)
            java.lang.String r13 = r13.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r13)
            java.lang.String r13 = r0.f583b
            com.xiaomi.push.service.ag.a(r12, r13, r5)
            goto L_0x0286
        L_0x0263:
            java.util.Map r13 = r2.a()
            java.lang.String r14 = com.xiaomi.push.service.bd.L
            java.lang.Object r13 = r13.get(r14)
            java.lang.String r13 = (java.lang.String) r13
            java.util.Map r14 = r2.a()
            java.lang.String r5 = com.xiaomi.push.service.bd.M
            java.lang.Object r14 = r14.get(r5)
            java.lang.String r14 = (java.lang.String) r14
            java.lang.String r5 = "try to retract a message by title&description."
            com.xiaomi.channel.commonutils.logger.b.a(r5)
            java.lang.String r5 = r0.f583b
            com.xiaomi.push.service.ag.a(r12, r5, r13, r14)
        L_0x0286:
            if (r1 == 0) goto L_0x02a7
            java.util.Map r13 = r1.a()
            if (r13 == 0) goto L_0x02a7
            boolean r13 = com.xiaomi.channel.commonutils.android.f.a(r12)
            if (r13 == 0) goto L_0x02a7
            java.util.Map r13 = r1.a()
            java.lang.String r13 = com.xiaomi.push.service.ar.a(r13)
            java.lang.String r14 = "pulldown"
            boolean r13 = r14.equals(r13)
            if (r13 == 0) goto L_0x02a7
            com.xiaomi.push.service.ac.a(r0)
        L_0x02a7:
            a(r12, r0, r2)
            goto L_0x02ac
        L_0x02ab:
            r4 = 1
        L_0x02ac:
            if (r4 == 0) goto L_0x02bc
            java.lang.String r13 = "broadcast passthrough message."
            com.xiaomi.channel.commonutils.logger.b.a(r13)
            java.lang.String r13 = r0.f583b
            java.lang.String r13 = com.xiaomi.push.service.ad.a(r13)
            r12.sendBroadcast(r15, r13)
        L_0x02bc:
            com.xiaomi.push.cz r13 = r0.a()
            com.xiaomi.push.cz r14 = com.xiaomi.push.cz.UnRegistration
            if (r13 != r14) goto L_0x02d1
            java.lang.String r13 = r12.getPackageName()
            boolean r13 = r3.equals(r13)
            if (r13 != 0) goto L_0x02d1
            r12.stopSelf()
        L_0x02d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.v.a(com.xiaomi.push.service.XMPushService, java.lang.String, byte[], android.content.Intent):void");
    }

    public static void a(XMPushService xMPushService, byte[] bArr, long j) {
        dq a2 = a(bArr);
        if (a2 != null) {
            if (TextUtils.isEmpty(a2.f583b)) {
                b.a((String) "receive a mipush message without package name");
                return;
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            Intent a3 = a(bArr, valueOf.longValue());
            String a4 = ag.a(a2);
            cx.a(xMPushService, a4, j, true, true, System.currentTimeMillis());
            di a5 = a2.a();
            if (!(a5 == null || a5.a() == null)) {
                b.e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", new Object[]{a2.a(), aw.a(a5.a()), a2.a()}));
            }
            if (a5 != null) {
                a5.a("mrt", Long.toString(valueOf.longValue()));
            }
            String str = "";
            if (cz.SendMessage == a2.a() && s.a((Context) xMPushService).a(a2.f583b) && !ag.a(a2)) {
                if (a5 != null) {
                    str = a5.a();
                }
                b.a("Drop a message for unregistered, msgid=" + str);
                a(xMPushService, a2, a2.f583b);
            } else if (cz.SendMessage == a2.a() && s.a((Context) xMPushService).c(a2.f583b) && !ag.a(a2)) {
                if (a5 != null) {
                    str = a5.a();
                }
                b.a("Drop a message for push closed, msgid=" + str);
                a(xMPushService, a2, a2.f583b);
            } else if (cz.SendMessage != a2.a() || TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") || TextUtils.equals(xMPushService.getPackageName(), a2.f583b)) {
                if (a5 != null) {
                    Map a6 = a5.a();
                    if (a6 != null && a6.containsKey("hide") && BaseParser.TRUE.equalsIgnoreCase((String) a6.get("hide"))) {
                        a(xMPushService, a2);
                        return;
                    }
                }
                a(xMPushService, a4, bArr, a3);
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Receive a message with wrong package name, expect ");
                outline73.append(xMPushService.getPackageName());
                outline73.append(", received ");
                outline73.append(a2.f583b);
                b.a(outline73.toString());
                a(xMPushService, a2, (String) "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a2.f583b);
            }
        }
    }

    public static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            return queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty();
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        boolean z = false;
        try {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (!queryBroadcastReceivers.isEmpty() || !queryIntentServices.isEmpty()) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            b.a((Throwable) e2);
            return false;
        }
    }

    public static boolean a(Context context, String str, byte[] bArr) {
        if (!a.a(context, str)) {
            return false;
        }
        Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
        intent.putExtra("mipush_payload", bArr);
        intent.setPackage(str);
        try {
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                return false;
            }
            b.a((String) "broadcast message arrived.");
            context.sendBroadcast(intent, ad.a(str));
            return true;
        } catch (Exception e2) {
            b.a("meet error when broadcast message arrived. " + e2);
            return false;
        }
    }

    public static boolean a(dq dqVar) {
        return "com.xiaomi.xmsf".equals(dqVar.f583b) && dqVar.a() != null && dqVar.a().a() != null && dqVar.a().a().containsKey("miui_package_name");
    }

    public static boolean a(XMPushService xMPushService, String str, dq dqVar, di diVar) {
        boolean z = true;
        if (diVar != null && diVar.a() != null && diVar.a().containsKey("__check_alive") && diVar.a().containsKey("__awake")) {
            dt dtVar = new dt();
            dtVar.b(dqVar.a());
            dtVar.d(str);
            dtVar.c(df.AwakeSystemApp.f458a);
            dtVar.a(diVar.a());
            dtVar.f595a = new HashMap();
            boolean a2 = a.a(xMPushService.getApplicationContext(), str);
            dtVar.f595a.put("app_running", Boolean.toString(a2));
            if (!a2) {
                boolean parseBoolean = Boolean.parseBoolean((String) diVar.a().get("__awake"));
                dtVar.f595a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                ad.a(xMPushService, ad.a(dqVar.b(), dqVar.a(), dtVar, cz.Notification));
            } catch (cd e2) {
                b.a((Throwable) e2);
            }
        }
        return z;
    }

    public static void b(Context context, dq dqVar, byte[] bArr) {
        if (!ag.a(dqVar)) {
            String a2 = ag.a(dqVar);
            if (!TextUtils.isEmpty(a2)) {
                a(context, a2, bArr);
            }
        }
    }

    public static void b(XMPushService xMPushService, dq dqVar) {
        xMPushService.a((j) new x(4, xMPushService, dqVar));
    }

    public static boolean b(dq dqVar) {
        Map a2 = dqVar.a().a();
        return a2 != null && a2.containsKey("notify_effect");
    }

    public static void c(XMPushService xMPushService, dq dqVar) {
        xMPushService.a((j) new y(4, xMPushService, dqVar));
    }

    public static boolean c(dq dqVar) {
        if (dqVar.a() == null || dqVar.a().a() == null) {
            return false;
        }
        return "1".equals(dqVar.a().a().get("obslete_ads_message"));
    }

    public void a(Context context, az.b bVar, boolean z, int i, String str) {
        if (!z) {
            q a2 = r.a(context);
            if (a2 != null && "token-expired".equals(str)) {
                r.a(context, a2.f4972f, a2.f4970d, a2.f4971e);
            }
        }
    }

    public void a(XMPushService xMPushService, bi biVar, az.b bVar) {
        try {
            a(xMPushService, biVar.a(bVar.h), (long) biVar.c());
        } catch (IllegalArgumentException e2) {
            b.a((Throwable) e2);
        }
    }

    public void a(XMPushService xMPushService, cj cjVar, az.b bVar) {
        if (cjVar instanceof ci) {
            ci ciVar = (ci) cjVar;
            cg a2 = ciVar.a((String) "s");
            if (a2 != null) {
                try {
                    a(xMPushService, bh.a(bh.a(bVar.h, ciVar.j()), a2.c()), (long) cx.a(cjVar.a()));
                } catch (IllegalArgumentException e2) {
                    b.a((Throwable) e2);
                }
            }
        } else {
            b.a((String) "not a mipush message");
        }
    }
}
