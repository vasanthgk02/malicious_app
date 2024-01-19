package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.config.DefaultRemoteConfig;
import com.xiaomi.channel.commonutils.android.h;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.PushMessageHandler.a;
import com.xiaomi.push.ad;
import com.xiaomi.push.cz;
import com.xiaomi.push.df;
import com.xiaomi.push.dh;
import com.xiaomi.push.di;
import com.xiaomi.push.dj;
import com.xiaomi.push.dl;
import com.xiaomi.push.dm;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.dx;
import com.xiaomi.push.ee;
import com.xiaomi.push.ef;
import com.xiaomi.push.ej;
import com.xiaomi.push.service.ag;
import com.xiaomi.push.service.bj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

public class ae {

    /* renamed from: a  reason: collision with root package name */
    public static ae f4342a;

    /* renamed from: a  reason: collision with other field name */
    public static Object f202a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static Queue<String> f203a;

    /* renamed from: a  reason: collision with other field name */
    public Context f204a;

    public ae(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f204a = applicationContext;
        if (applicationContext == null) {
            this.f204a = context;
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        return ag.b(context, str, map, i);
    }

    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1, types: [com.xiaomi.mipush.sdk.PushMessageHandler$a] */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r11v2, types: [com.xiaomi.mipush.sdk.MiPushMessage, java.io.Serializable] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r18v1, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r6v5, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r18v2, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r6v7, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r18v3, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r6v9, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: type inference failed for: r6v13 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], java.util.ArrayList]
      uses: [com.xiaomi.mipush.sdk.PushMessageHandler$a, ?[OBJECT, ARRAY], java.util.ArrayList]
      mth insns count: 786
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.xiaomi.mipush.sdk.PushMessageHandler.a a(com.xiaomi.push.dq r17, boolean r18, byte[] r19, java.lang.String r20, int r21, android.content.Intent r22) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r18
            r0 = r20
            r4 = r21
            java.lang.Class<com.xiaomi.mipush.sdk.x> r5 = com.xiaomi.mipush.sdk.x.class
            r6 = 0
            android.content.Context r7 = r1.f204a     // Catch:{ o -> 0x0910, ej -> 0x0901 }
            com.xiaomi.push.ef r7 = com.xiaomi.mipush.sdk.aa.a(r7, r2)     // Catch:{ o -> 0x0910, ej -> 0x0901 }
            if (r7 != 0) goto L_0x0031
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ o -> 0x0910, ej -> 0x0901 }
            r0.<init>()     // Catch:{ o -> 0x0910, ej -> 0x0901 }
            java.lang.String r4 = "receiving an un-recognized message. "
            r0.append(r4)     // Catch:{ o -> 0x0910, ej -> 0x0901 }
            com.xiaomi.push.cz r4 = r2.f576a     // Catch:{ o -> 0x0910, ej -> 0x0901 }
            r0.append(r4)     // Catch:{ o -> 0x0910, ej -> 0x0901 }
            java.lang.String r0 = r0.toString()     // Catch:{ o -> 0x0910, ej -> 0x0901 }
            com.xiaomi.channel.commonutils.logger.b.d(r0)     // Catch:{ o -> 0x0910, ej -> 0x0901 }
            android.content.Context r0 = r1.f204a     // Catch:{ o -> 0x0910, ej -> 0x0901 }
            com.xiaomi.mipush.sdk.n.c(r0, r2, r3)     // Catch:{ o -> 0x0910, ej -> 0x0901 }
            return r6
        L_0x0031:
            com.xiaomi.push.cz r8 = r17.a()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "processing a message, action="
            r9.append(r10)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r9)
            int[] r9 = com.xiaomi.mipush.sdk.af.f4343a
            int r8 = r8.ordinal()
            r8 = r9[r8]
            r9 = 1
            r10 = 0
            r11 = 0
            switch(r8) {
                case 1: goto L_0x06e9;
                case 2: goto L_0x063d;
                case 3: goto L_0x0616;
                case 4: goto L_0x05b6;
                case 5: goto L_0x0556;
                case 6: goto L_0x0438;
                case 7: goto L_0x005a;
                default: goto L_0x0058;
            }
        L_0x0058:
            goto L_0x0900
        L_0x005a:
            boolean r0 = r7 instanceof com.xiaomi.push.dm
            if (r0 == 0) goto L_0x0200
            com.xiaomi.push.dm r7 = (com.xiaomi.push.dm) r7
            java.lang.String r0 = r7.a()
            java.lang.String r2 = "resp-type:"
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r3 = r7.b()
            r2.append(r3)
            java.lang.String r3 = ", code:"
            r2.append(r3)
            long r3 = r7.f536a
            r2.append(r3)
            java.lang.String r3 = ", "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.xiaomi.channel.commonutils.logger.b.e(r2)
            com.xiaomi.push.df r2 = com.xiaomi.push.df.DisablePushMessage
            java.lang.String r2 = r2.f458a
            java.lang.String r3 = r7.f543d
            boolean r2 = r2.equalsIgnoreCase(r3)
            r3 = 10
            if (r2 == 0) goto L_0x0143
            long r7 = r7.f536a
            int r2 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x00f3
            monitor-enter(r5)
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x00f0 }
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)     // Catch:{ all -> 0x00f0 }
            boolean r2 = r2.a(r0)     // Catch:{ all -> 0x00f0 }
            if (r2 == 0) goto L_0x00ed
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x00f0 }
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)     // Catch:{ all -> 0x00f0 }
            r2.c(r0)     // Catch:{ all -> 0x00f0 }
            java.lang.String r0 = "syncing"
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x00f0 }
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)     // Catch:{ all -> 0x00f0 }
            com.xiaomi.mipush.sdk.am r3 = com.xiaomi.mipush.sdk.am.DISABLE_PUSH     // Catch:{ all -> 0x00f0 }
            java.lang.String r2 = r2.a(r3)     // Catch:{ all -> 0x00f0 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x00ed
            android.content.Context r0 = r1.f204a     // Catch:{ all -> 0x00f0 }
            com.xiaomi.mipush.sdk.x r0 = com.xiaomi.mipush.sdk.x.a(r0)     // Catch:{ all -> 0x00f0 }
            com.xiaomi.mipush.sdk.am r2 = com.xiaomi.mipush.sdk.am.DISABLE_PUSH     // Catch:{ all -> 0x00f0 }
            java.lang.String r3 = "synced"
            r0.a(r2, r3)     // Catch:{ all -> 0x00f0 }
            android.content.Context r0 = r1.f204a     // Catch:{ all -> 0x00f0 }
            com.xiaomi.mipush.sdk.MiPushClient.clearNotification(r0)     // Catch:{ all -> 0x00f0 }
            android.content.Context r0 = r1.f204a     // Catch:{ all -> 0x00f0 }
            com.xiaomi.mipush.sdk.MiPushClient.clearLocalNotificationType(r0)     // Catch:{ all -> 0x00f0 }
            com.xiaomi.mipush.sdk.PushMessageHandler.a()     // Catch:{ all -> 0x00f0 }
            android.content.Context r0 = r1.f204a     // Catch:{ all -> 0x00f0 }
            com.xiaomi.mipush.sdk.ag r0 = com.xiaomi.mipush.sdk.ag.a(r0)     // Catch:{ all -> 0x00f0 }
            r0.b()     // Catch:{ all -> 0x00f0 }
        L_0x00ed:
            monitor-exit(r5)     // Catch:{ all -> 0x00f0 }
            goto L_0x0900
        L_0x00f0:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00f0 }
            throw r0
        L_0x00f3:
            java.lang.String r2 = "syncing"
            android.content.Context r4 = r1.f204a
            com.xiaomi.mipush.sdk.x r4 = com.xiaomi.mipush.sdk.x.a(r4)
            com.xiaomi.mipush.sdk.am r7 = com.xiaomi.mipush.sdk.am.DISABLE_PUSH
            java.lang.String r4 = r4.a(r7)
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x01e4
            monitor-enter(r5)
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x0140 }
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)     // Catch:{ all -> 0x0140 }
            boolean r2 = r2.a(r0)     // Catch:{ all -> 0x0140 }
            if (r2 == 0) goto L_0x013d
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x0140 }
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)     // Catch:{ all -> 0x0140 }
            int r2 = r2.a(r0)     // Catch:{ all -> 0x0140 }
            if (r2 >= r3) goto L_0x0134
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x0140 }
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)     // Catch:{ all -> 0x0140 }
            r2.b(r0)     // Catch:{ all -> 0x0140 }
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x0140 }
            com.xiaomi.mipush.sdk.ag r2 = com.xiaomi.mipush.sdk.ag.a(r2)     // Catch:{ all -> 0x0140 }
            r2.a(r9, r0)     // Catch:{ all -> 0x0140 }
            goto L_0x013d
        L_0x0134:
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x0140 }
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)     // Catch:{ all -> 0x0140 }
            r2.c(r0)     // Catch:{ all -> 0x0140 }
        L_0x013d:
            monitor-exit(r5)     // Catch:{ all -> 0x0140 }
            goto L_0x0900
        L_0x0140:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0140 }
            throw r0
        L_0x0143:
            com.xiaomi.push.df r2 = com.xiaomi.push.df.EnablePushMessage
            java.lang.String r2 = r2.f458a
            java.lang.String r4 = r7.f543d
            boolean r2 = r2.equalsIgnoreCase(r4)
            if (r2 == 0) goto L_0x01ef
            long r7 = r7.f536a
            int r2 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x0194
            monitor-enter(r5)
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x0191 }
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)     // Catch:{ all -> 0x0191 }
            boolean r2 = r2.a(r0)     // Catch:{ all -> 0x0191 }
            if (r2 == 0) goto L_0x018e
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x0191 }
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)     // Catch:{ all -> 0x0191 }
            r2.c(r0)     // Catch:{ all -> 0x0191 }
            java.lang.String r0 = "syncing"
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x0191 }
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)     // Catch:{ all -> 0x0191 }
            com.xiaomi.mipush.sdk.am r3 = com.xiaomi.mipush.sdk.am.ENABLE_PUSH     // Catch:{ all -> 0x0191 }
            java.lang.String r2 = r2.a(r3)     // Catch:{ all -> 0x0191 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0191 }
            if (r0 == 0) goto L_0x018e
            android.content.Context r0 = r1.f204a     // Catch:{ all -> 0x0191 }
            com.xiaomi.mipush.sdk.x r0 = com.xiaomi.mipush.sdk.x.a(r0)     // Catch:{ all -> 0x0191 }
            com.xiaomi.mipush.sdk.am r2 = com.xiaomi.mipush.sdk.am.ENABLE_PUSH     // Catch:{ all -> 0x0191 }
            java.lang.String r3 = "synced"
            r0.a(r2, r3)     // Catch:{ all -> 0x0191 }
        L_0x018e:
            monitor-exit(r5)     // Catch:{ all -> 0x0191 }
            goto L_0x0900
        L_0x0191:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0191 }
            throw r0
        L_0x0194:
            java.lang.String r2 = "syncing"
            android.content.Context r4 = r1.f204a
            com.xiaomi.mipush.sdk.x r4 = com.xiaomi.mipush.sdk.x.a(r4)
            com.xiaomi.mipush.sdk.am r7 = com.xiaomi.mipush.sdk.am.ENABLE_PUSH
            java.lang.String r4 = r4.a(r7)
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x01e4
            monitor-enter(r5)
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x01e1 }
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)     // Catch:{ all -> 0x01e1 }
            boolean r2 = r2.a(r0)     // Catch:{ all -> 0x01e1 }
            if (r2 == 0) goto L_0x01de
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x01e1 }
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)     // Catch:{ all -> 0x01e1 }
            int r2 = r2.a(r0)     // Catch:{ all -> 0x01e1 }
            if (r2 >= r3) goto L_0x01d5
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x01e1 }
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)     // Catch:{ all -> 0x01e1 }
            r2.b(r0)     // Catch:{ all -> 0x01e1 }
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x01e1 }
            com.xiaomi.mipush.sdk.ag r2 = com.xiaomi.mipush.sdk.ag.a(r2)     // Catch:{ all -> 0x01e1 }
            r2.a(r10, r0)     // Catch:{ all -> 0x01e1 }
            goto L_0x01de
        L_0x01d5:
            android.content.Context r2 = r1.f204a     // Catch:{ all -> 0x01e1 }
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)     // Catch:{ all -> 0x01e1 }
            r2.c(r0)     // Catch:{ all -> 0x01e1 }
        L_0x01de:
            monitor-exit(r5)     // Catch:{ all -> 0x01e1 }
            goto L_0x0900
        L_0x01e1:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x01e1 }
            throw r0
        L_0x01e4:
            android.content.Context r2 = r1.f204a
            com.xiaomi.mipush.sdk.x r2 = com.xiaomi.mipush.sdk.x.a(r2)
            r2.c(r0)
            goto L_0x0900
        L_0x01ef:
            com.xiaomi.push.df r0 = com.xiaomi.push.df.ThirdPartyRegUpdate
            java.lang.String r0 = r0.f458a
            java.lang.String r2 = r7.f543d
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0900
            r1.a(r7)
            goto L_0x0900
        L_0x0200:
            boolean r0 = r7 instanceof com.xiaomi.push.dt
            if (r0 == 0) goto L_0x0900
            com.xiaomi.push.dt r7 = (com.xiaomi.push.dt) r7
            java.lang.String r0 = "registration id expired"
            java.lang.String r2 = r7.f600d
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x02b8
            android.content.Context r0 = r1.f204a
            java.util.List r0 = com.xiaomi.mipush.sdk.MiPushClient.getAllAlias(r0)
            android.content.Context r2 = r1.f204a
            java.util.List r2 = com.xiaomi.mipush.sdk.MiPushClient.getAllTopic(r2)
            android.content.Context r3 = r1.f204a
            java.util.List r3 = com.xiaomi.mipush.sdk.MiPushClient.getAllUserAccount(r3)
            android.content.Context r4 = r1.f204a
            java.lang.String r4 = com.xiaomi.mipush.sdk.MiPushClient.getAcceptTime(r4)
            java.lang.String r5 = "resp-type:"
            java.lang.StringBuilder r5 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r5)
            java.lang.String r8 = r7.f600d
            r5.append(r8)
            java.lang.String r8 = ", "
            r5.append(r8)
            java.lang.String r7 = r7.a()
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            com.xiaomi.channel.commonutils.logger.b.e(r5)
            android.content.Context r5 = r1.f204a
            com.xiaomi.push.dj r7 = com.xiaomi.push.dj.RegIdExpired
            com.xiaomi.mipush.sdk.MiPushClient.reInitialize(r5, r7)
            java.util.Iterator r0 = r0.iterator()
        L_0x0251:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0268
            java.lang.Object r5 = r0.next()
            java.lang.String r5 = (java.lang.String) r5
            android.content.Context r7 = r1.f204a
            com.xiaomi.mipush.sdk.MiPushClient.removeAlias(r7, r5)
            android.content.Context r7 = r1.f204a
            com.xiaomi.mipush.sdk.MiPushClient.setAlias(r7, r5, r6)
            goto L_0x0251
        L_0x0268:
            java.util.Iterator r0 = r2.iterator()
        L_0x026c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0283
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            android.content.Context r5 = r1.f204a
            com.xiaomi.mipush.sdk.MiPushClient.removeTopic(r5, r2)
            android.content.Context r5 = r1.f204a
            com.xiaomi.mipush.sdk.MiPushClient.subscribe(r5, r2, r6)
            goto L_0x026c
        L_0x0283:
            java.util.Iterator r0 = r3.iterator()
        L_0x0287:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x029e
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            android.content.Context r3 = r1.f204a
            com.xiaomi.mipush.sdk.MiPushClient.removeAccount(r3, r2)
            android.content.Context r3 = r1.f204a
            com.xiaomi.mipush.sdk.MiPushClient.setUserAccount(r3, r2, r6)
            goto L_0x0287
        L_0x029e:
            java.lang.String r0 = ","
            java.lang.String[] r0 = r4.split(r0)
            int r2 = r0.length
            r3 = 2
            if (r2 != r3) goto L_0x0900
            android.content.Context r2 = r1.f204a
            com.xiaomi.mipush.sdk.MiPushClient.removeAcceptTime(r2)
            android.content.Context r2 = r1.f204a
            r3 = r0[r10]
            r0 = r0[r9]
            com.xiaomi.mipush.sdk.MiPushClient.addAcceptTime(r2, r3, r0)
            goto L_0x0900
        L_0x02b8:
            com.xiaomi.push.df r0 = com.xiaomi.push.df.ClientInfoUpdateOk
            java.lang.String r0 = r0.f458a
            java.lang.String r2 = r7.f600d
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x02ed
            java.util.Map r0 = r7.a()
            if (r0 == 0) goto L_0x0900
            java.util.Map r0 = r7.a()
            java.lang.String r2 = "app_version"
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0900
            java.util.Map r0 = r7.a()
            java.lang.String r2 = "app_version"
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            android.content.Context r2 = r1.f204a
            com.xiaomi.mipush.sdk.a r2 = com.xiaomi.mipush.sdk.a.a(r2)
            r2.a(r0)
            goto L_0x0900
        L_0x02ed:
            com.xiaomi.push.df r0 = com.xiaomi.push.df.NormalClientConfigUpdate
            java.lang.String r0 = r0.f458a
            java.lang.String r2 = r7.f600d
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0310
            com.xiaomi.push.ds r0 = new com.xiaomi.push.ds
            r0.<init>()
            byte[] r2 = r7.a()     // Catch:{ ej -> 0x0900 }
            com.xiaomi.push.ee.a(r0, r2)     // Catch:{ ej -> 0x0900 }
            android.content.Context r2 = r1.f204a     // Catch:{ ej -> 0x0900 }
            com.xiaomi.push.service.at r2 = com.xiaomi.push.service.at.a(r2)     // Catch:{ ej -> 0x0900 }
            com.xiaomi.push.service.au.a(r2, r0)     // Catch:{ ej -> 0x0900 }
            goto L_0x0900
        L_0x0310:
            com.xiaomi.push.df r0 = com.xiaomi.push.df.CustomClientConfigUpdate
            java.lang.String r0 = r0.f458a
            java.lang.String r2 = r7.f600d
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0333
            com.xiaomi.push.dr r0 = new com.xiaomi.push.dr
            r0.<init>()
            byte[] r2 = r7.a()     // Catch:{ ej -> 0x0900 }
            com.xiaomi.push.ee.a(r0, r2)     // Catch:{ ej -> 0x0900 }
            android.content.Context r2 = r1.f204a     // Catch:{ ej -> 0x0900 }
            com.xiaomi.push.service.at r2 = com.xiaomi.push.service.at.a(r2)     // Catch:{ ej -> 0x0900 }
            com.xiaomi.push.service.au.a(r2, r0)     // Catch:{ ej -> 0x0900 }
            goto L_0x0900
        L_0x0333:
            com.xiaomi.push.df r0 = com.xiaomi.push.df.SyncInfoResult
            java.lang.String r0 = r0.f458a
            java.lang.String r2 = r7.f600d
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0346
            android.content.Context r0 = r1.f204a
            com.xiaomi.mipush.sdk.an.a(r0, r7)
            goto L_0x0900
        L_0x0346:
            com.xiaomi.push.df r0 = com.xiaomi.push.df.CancelPushMessage
            java.lang.String r0 = r0.f458a
            java.lang.String r2 = r7.f600d
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x03e6
            java.lang.String r0 = "resp-type:"
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r2 = r7.f600d
            r0.append(r2)
            java.lang.String r2 = ", "
            r0.append(r2)
            java.lang.String r2 = r7.a()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.e(r0)
            java.util.Map r0 = r7.a()
            if (r0 == 0) goto L_0x03e1
            java.util.Map r0 = r7.a()
            java.lang.String r2 = com.xiaomi.push.service.bd.N
            boolean r0 = r0.containsKey(r2)
            r2 = -2
            if (r0 == 0) goto L_0x039f
            java.util.Map r0 = r7.a()
            java.lang.String r3 = com.xiaomi.push.service.bd.N
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x039f
            int r2 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x039a }
            goto L_0x039f
        L_0x039a:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x039f:
            r0 = -1
            if (r2 < r0) goto L_0x03a8
            android.content.Context r0 = r1.f204a
            com.xiaomi.mipush.sdk.MiPushClient.clearNotification(r0, r2)
            goto L_0x03e1
        L_0x03a8:
            java.lang.String r0 = ""
            java.lang.String r2 = ""
            java.util.Map r3 = r7.a()
            java.lang.String r4 = com.xiaomi.push.service.bd.L
            boolean r3 = r3.containsKey(r4)
            if (r3 == 0) goto L_0x03c4
            java.util.Map r0 = r7.a()
            java.lang.String r3 = com.xiaomi.push.service.bd.L
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
        L_0x03c4:
            java.util.Map r3 = r7.a()
            java.lang.String r4 = com.xiaomi.push.service.bd.M
            boolean r3 = r3.containsKey(r4)
            if (r3 == 0) goto L_0x03dc
            java.util.Map r2 = r7.a()
            java.lang.String r3 = com.xiaomi.push.service.bd.M
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
        L_0x03dc:
            android.content.Context r3 = r1.f204a
            com.xiaomi.mipush.sdk.MiPushClient.clearNotification(r3, r0, r2)
        L_0x03e1:
            r1.a(r7)
            goto L_0x0900
        L_0x03e6:
            com.xiaomi.push.df r0 = com.xiaomi.push.df.HybridRegisterResult
            java.lang.String r0 = r0.f458a
            java.lang.String r2 = r7.f600d
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0407
            com.xiaomi.push.dv r0 = new com.xiaomi.push.dv     // Catch:{ ej -> 0x0405 }
            r0.<init>()     // Catch:{ ej -> 0x0405 }
            byte[] r2 = r7.a()     // Catch:{ ej -> 0x0405 }
            com.xiaomi.push.ee.a(r0, r2)     // Catch:{ ej -> 0x0405 }
            android.content.Context r2 = r1.f204a     // Catch:{ ej -> 0x0405 }
            com.xiaomi.mipush.sdk.MiPushClient4Hybrid.onReceiveRegisterResult(r2, r0)     // Catch:{ ej -> 0x0405 }
            goto L_0x0900
        L_0x0405:
            r0 = move-exception
            goto L_0x0426
        L_0x0407:
            com.xiaomi.push.df r0 = com.xiaomi.push.df.HybridUnregisterResult
            java.lang.String r0 = r0.f458a
            java.lang.String r2 = r7.f600d
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x042b
            com.xiaomi.push.eb r0 = new com.xiaomi.push.eb     // Catch:{ ej -> 0x0405 }
            r0.<init>()     // Catch:{ ej -> 0x0405 }
            byte[] r2 = r7.a()     // Catch:{ ej -> 0x0405 }
            com.xiaomi.push.ee.a(r0, r2)     // Catch:{ ej -> 0x0405 }
            android.content.Context r2 = r1.f204a     // Catch:{ ej -> 0x0405 }
            com.xiaomi.mipush.sdk.MiPushClient4Hybrid.onReceiveUnregisterResult(r2, r0)     // Catch:{ ej -> 0x0405 }
            goto L_0x0900
        L_0x0426:
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            goto L_0x0900
        L_0x042b:
            boolean r0 = com.xiaomi.push.service.i.a(r7)
            if (r0 == 0) goto L_0x0900
            java.lang.String r0 = "receive notification handle by cpra"
            com.xiaomi.channel.commonutils.logger.b.b(r0)
            goto L_0x0900
        L_0x0438:
            com.xiaomi.push.dp r7 = (com.xiaomi.push.dp) r7
            java.lang.String r0 = r7.b()
            java.util.List r2 = r7.a()
            long r3 = r7.f564a
            int r5 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r5 != 0) goto L_0x0529
            com.xiaomi.push.bg r3 = com.xiaomi.push.bg.COMMAND_SET_ACCEPT_TIME
            java.lang.String r3 = r3.f350a
            boolean r3 = android.text.TextUtils.equals(r0, r3)
            if (r3 == 0) goto L_0x04a6
            if (r2 == 0) goto L_0x04a6
            int r3 = r2.size()
            if (r3 <= r9) goto L_0x04a6
            android.content.Context r3 = r1.f204a
            java.lang.Object r4 = r2.get(r10)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r2.get(r9)
            java.lang.String r5 = (java.lang.String) r5
            com.xiaomi.mipush.sdk.MiPushClient.addAcceptTime(r3, r4, r5)
            java.lang.String r3 = "00:00"
            java.lang.Object r4 = r2.get(r10)
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x048d
            java.lang.String r3 = "00:00"
            java.lang.Object r4 = r2.get(r9)
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x048d
            android.content.Context r3 = r1.f204a
            com.xiaomi.mipush.sdk.a r3 = com.xiaomi.mipush.sdk.a.a(r3)
            r3.a(r9)
            goto L_0x0496
        L_0x048d:
            android.content.Context r3 = r1.f204a
            com.xiaomi.mipush.sdk.a r3 = com.xiaomi.mipush.sdk.a.a(r3)
            r3.a(r10)
        L_0x0496:
            java.lang.String r3 = "GMT+08"
            java.util.TimeZone r3 = java.util.TimeZone.getTimeZone(r3)
            java.util.TimeZone r4 = java.util.TimeZone.getDefault()
            java.util.List r2 = r1.a(r3, r4, r2)
            goto L_0x0529
        L_0x04a6:
            com.xiaomi.push.bg r3 = com.xiaomi.push.bg.COMMAND_SET_ALIAS
            java.lang.String r3 = r3.f350a
            boolean r3 = android.text.TextUtils.equals(r0, r3)
            if (r3 == 0) goto L_0x04c4
            if (r2 == 0) goto L_0x04c4
            int r3 = r2.size()
            if (r3 <= 0) goto L_0x04c4
            android.content.Context r3 = r1.f204a
            java.lang.Object r4 = r2.get(r10)
            java.lang.String r4 = (java.lang.String) r4
            com.xiaomi.mipush.sdk.MiPushClient.addAlias(r3, r4)
            goto L_0x0529
        L_0x04c4:
            com.xiaomi.push.bg r3 = com.xiaomi.push.bg.COMMAND_UNSET_ALIAS
            java.lang.String r3 = r3.f350a
            boolean r3 = android.text.TextUtils.equals(r0, r3)
            if (r3 == 0) goto L_0x04e2
            if (r2 == 0) goto L_0x04e2
            int r3 = r2.size()
            if (r3 <= 0) goto L_0x04e2
            android.content.Context r3 = r1.f204a
            java.lang.Object r4 = r2.get(r10)
            java.lang.String r4 = (java.lang.String) r4
            com.xiaomi.mipush.sdk.MiPushClient.removeAlias(r3, r4)
            goto L_0x0529
        L_0x04e2:
            com.xiaomi.push.bg r3 = com.xiaomi.push.bg.COMMAND_SET_ACCOUNT
            java.lang.String r3 = r3.f350a
            boolean r3 = android.text.TextUtils.equals(r0, r3)
            if (r3 == 0) goto L_0x0500
            if (r2 == 0) goto L_0x0500
            int r3 = r2.size()
            if (r3 <= 0) goto L_0x0500
            android.content.Context r3 = r1.f204a
            java.lang.Object r4 = r2.get(r10)
            java.lang.String r4 = (java.lang.String) r4
            com.xiaomi.mipush.sdk.MiPushClient.addAccount(r3, r4)
            goto L_0x0529
        L_0x0500:
            com.xiaomi.push.bg r3 = com.xiaomi.push.bg.COMMAND_UNSET_ACCOUNT
            java.lang.String r3 = r3.f350a
            boolean r3 = android.text.TextUtils.equals(r0, r3)
            if (r3 == 0) goto L_0x051e
            if (r2 == 0) goto L_0x051e
            int r3 = r2.size()
            if (r3 <= 0) goto L_0x051e
            android.content.Context r3 = r1.f204a
            java.lang.Object r4 = r2.get(r10)
            java.lang.String r4 = (java.lang.String) r4
            com.xiaomi.mipush.sdk.MiPushClient.removeAccount(r3, r4)
            goto L_0x0529
        L_0x051e:
            com.xiaomi.push.bg r3 = com.xiaomi.push.bg.COMMAND_CHK_VDEVID
            java.lang.String r3 = r3.f350a
            boolean r3 = android.text.TextUtils.equals(r0, r3)
            if (r3 == 0) goto L_0x0529
            return r6
        L_0x0529:
            java.lang.String r3 = "resp-cmd:"
            java.lang.String r4 = ", "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r3, r0, r4)
            java.lang.String r4 = r7.a()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.e(r3)
            long r3 = r7.f564a
            java.lang.String r5 = r7.f572d
            java.lang.String r6 = r7.c()
            r17 = r0
            r18 = r2
            r19 = r3
            r21 = r5
            r22 = r6
            com.xiaomi.mipush.sdk.MiPushCommandMessage r0 = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r17, r18, r19, r21, r22)
            return r0
        L_0x0556:
            com.xiaomi.push.ed r7 = (com.xiaomi.push.ed) r7
            long r2 = r7.f735a
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x0567
            android.content.Context r0 = r1.f204a
            java.lang.String r2 = r7.b()
            com.xiaomi.mipush.sdk.MiPushClient.removeTopic(r0, r2)
        L_0x0567:
            java.lang.String r0 = r7.b()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x057d
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.lang.String r0 = r7.b()
            r6.add(r0)
        L_0x057d:
            java.lang.String r0 = "resp-cmd:"
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            com.xiaomi.push.bg r2 = com.xiaomi.push.bg.COMMAND_UNSUBSCRIBE_TOPIC
            r0.append(r2)
            java.lang.String r2 = ", "
            r0.append(r2)
            java.lang.String r2 = r7.a()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.e(r0)
            com.xiaomi.push.bg r0 = com.xiaomi.push.bg.COMMAND_UNSUBSCRIBE_TOPIC
            java.lang.String r0 = r0.f350a
            long r2 = r7.f735a
            java.lang.String r4 = r7.f741d
            java.lang.String r5 = r7.c()
            r17 = r0
            r18 = r6
            r19 = r2
            r21 = r4
            r22 = r5
            com.xiaomi.mipush.sdk.MiPushCommandMessage r0 = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r17, r18, r19, r21, r22)
            return r0
        L_0x05b6:
            com.xiaomi.push.dz r7 = (com.xiaomi.push.dz) r7
            long r2 = r7.f690a
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x05c7
            android.content.Context r0 = r1.f204a
            java.lang.String r2 = r7.b()
            com.xiaomi.mipush.sdk.MiPushClient.addTopic(r0, r2)
        L_0x05c7:
            java.lang.String r0 = r7.b()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x05dd
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.lang.String r0 = r7.b()
            r6.add(r0)
        L_0x05dd:
            java.lang.String r0 = "resp-cmd:"
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            com.xiaomi.push.bg r2 = com.xiaomi.push.bg.COMMAND_SUBSCRIBE_TOPIC
            r0.append(r2)
            java.lang.String r2 = ", "
            r0.append(r2)
            java.lang.String r2 = r7.a()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.e(r0)
            com.xiaomi.push.bg r0 = com.xiaomi.push.bg.COMMAND_SUBSCRIBE_TOPIC
            java.lang.String r0 = r0.f350a
            long r2 = r7.f690a
            java.lang.String r4 = r7.f696d
            java.lang.String r5 = r7.c()
            r17 = r0
            r18 = r6
            r19 = r2
            r21 = r4
            r22 = r5
            com.xiaomi.mipush.sdk.MiPushCommandMessage r0 = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r17, r18, r19, r21, r22)
            return r0
        L_0x0616:
            boolean r0 = r17.b()
            if (r0 != 0) goto L_0x0622
            java.lang.String r0 = "receiving an un-encrypt message(UnRegistration)."
            com.xiaomi.channel.commonutils.logger.b.d(r0)
            return r6
        L_0x0622:
            com.xiaomi.push.eb r7 = (com.xiaomi.push.eb) r7
            long r2 = r7.f715a
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x0638
            android.content.Context r0 = r1.f204a
            com.xiaomi.mipush.sdk.a r0 = com.xiaomi.mipush.sdk.a.a(r0)
            r0.a()
            android.content.Context r0 = r1.f204a
            com.xiaomi.mipush.sdk.MiPushClient.clearExtras(r0)
        L_0x0638:
            com.xiaomi.mipush.sdk.PushMessageHandler.a()
            goto L_0x0900
        L_0x063d:
            com.xiaomi.push.dv r7 = (com.xiaomi.push.dv) r7
            android.content.Context r2 = r1.f204a
            com.xiaomi.mipush.sdk.a r2 = com.xiaomi.mipush.sdk.a.a(r2)
            java.lang.String r2 = r2.f195a
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x06e3
            java.lang.String r3 = r7.a()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 != 0) goto L_0x0659
            goto L_0x06e3
        L_0x0659:
            android.content.Context r2 = r1.f204a
            com.xiaomi.mipush.sdk.ag r2 = com.xiaomi.mipush.sdk.ag.a(r2)
            long r2 = r2.a()
            int r5 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x068e
            long r8 = android.os.SystemClock.elapsedRealtime()
            long r8 = r8 - r2
            r2 = 900000(0xdbba0, double:4.44659E-318)
            int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x068e
            java.lang.String r2 = "The received registration result has expired."
            com.xiaomi.channel.commonutils.logger.b.a(r2)
            android.content.Context r2 = r1.f204a
            com.xiaomi.push.aw r2 = com.xiaomi.push.aw.a(r2)
            android.content.Context r3 = r1.f204a
            java.lang.String r3 = r3.getPackageName()
            java.lang.String r4 = com.xiaomi.push.av.a(r21)
            java.lang.String r5 = "26"
            r2.a(r3, r4, r0, r5)
            return r6
        L_0x068e:
            android.content.Context r0 = r1.f204a
            com.xiaomi.mipush.sdk.a r0 = com.xiaomi.mipush.sdk.a.a(r0)
            r0.f195a = r6
            long r2 = r7.f639a
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x06b0
            android.content.Context r0 = r1.f204a
            com.xiaomi.mipush.sdk.a r0 = com.xiaomi.mipush.sdk.a.a(r0)
            java.lang.String r2 = r7.f649e
            java.lang.String r3 = r7.f650f
            java.lang.String r4 = r7.f656l
            r0.b(r2, r3, r4)
            android.content.Context r0 = r1.f204a
            com.xiaomi.mipush.sdk.FCMPushHelper.persistIfXmsfSupDecrypt(r0)
        L_0x06b0:
            java.lang.String r0 = r7.f649e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x06c2
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.lang.String r0 = r7.f649e
            r6.add(r0)
        L_0x06c2:
            com.xiaomi.push.bg r0 = com.xiaomi.push.bg.COMMAND_REGISTER
            java.lang.String r0 = r0.f350a
            long r2 = r7.f639a
            java.lang.String r4 = r7.f648d
            r5 = 0
            r17 = r0
            r18 = r6
            r19 = r2
            r21 = r4
            r22 = r5
            com.xiaomi.mipush.sdk.MiPushCommandMessage r0 = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r17, r18, r19, r21, r22)
            android.content.Context r2 = r1.f204a
            com.xiaomi.mipush.sdk.ag r2 = com.xiaomi.mipush.sdk.ag.a(r2)
            r2.d()
            return r0
        L_0x06e3:
            java.lang.String r0 = "bad Registration result:"
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            return r6
        L_0x06e9:
            boolean r5 = r17.b()
            if (r5 != 0) goto L_0x06f5
            java.lang.String r0 = "receiving an un-encrypt message(SendMessage)."
            com.xiaomi.channel.commonutils.logger.b.d(r0)
            return r6
        L_0x06f5:
            android.content.Context r5 = r1.f204a
            com.xiaomi.mipush.sdk.a r5 = com.xiaomi.mipush.sdk.a.a(r5)
            boolean r5 = r5.e()
            if (r5 == 0) goto L_0x0709
            if (r3 != 0) goto L_0x0709
            java.lang.String r0 = "receive a message in pause state. drop it"
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            return r6
        L_0x0709:
            com.xiaomi.push.dx r7 = (com.xiaomi.push.dx) r7
            com.xiaomi.push.dh r5 = r7.a()
            if (r5 != 0) goto L_0x071c
            java.lang.String r0 = "receive an empty message without push content, drop it"
            com.xiaomi.channel.commonutils.logger.b.d(r0)
            android.content.Context r0 = r1.f204a
            com.xiaomi.mipush.sdk.n.d(r0, r2, r3)
            return r6
        L_0x071c:
            java.lang.String r8 = "notification_click_button"
            r9 = r22
            int r8 = r9.getIntExtra(r8, r10)
            if (r3 == 0) goto L_0x077d
            boolean r9 = com.xiaomi.push.service.ag.a(r17)
            if (r9 == 0) goto L_0x0740
            android.content.Context r9 = r1.f204a
            java.lang.String r10 = r5.a()
            com.xiaomi.push.di r13 = r17.a()
            java.lang.String r14 = r2.f583b
            java.lang.String r15 = r5.b()
            com.xiaomi.mipush.sdk.MiPushClient.reportIgnoreRegMessageClicked(r9, r10, r13, r14, r15)
            goto L_0x077d
        L_0x0740:
            com.xiaomi.push.di r9 = r17.a()
            if (r9 == 0) goto L_0x0750
            com.xiaomi.push.di r9 = new com.xiaomi.push.di
            com.xiaomi.push.di r10 = r17.a()
            r9.<init>(r10)
            goto L_0x0755
        L_0x0750:
            com.xiaomi.push.di r9 = new com.xiaomi.push.di
            r9.<init>()
        L_0x0755:
            java.util.Map r10 = r9.a()
            if (r10 != 0) goto L_0x0763
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            r9.a(r10)
        L_0x0763:
            java.util.Map r10 = r9.a()
            java.lang.String r13 = "notification_click_button"
            java.lang.String r14 = java.lang.String.valueOf(r8)
            r10.put(r13, r14)
            android.content.Context r10 = r1.f204a
            java.lang.String r13 = r5.a()
            java.lang.String r14 = r5.b()
            com.xiaomi.mipush.sdk.MiPushClient.reportMessageClicked(r10, r13, r9, r14)
        L_0x077d:
            if (r3 != 0) goto L_0x07c2
            java.lang.String r9 = r7.d()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x07a1
            android.content.Context r9 = r1.f204a
            java.lang.String r10 = r7.d()
            long r9 = com.xiaomi.mipush.sdk.MiPushClient.aliasSetTime(r9, r10)
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x07a1
            android.content.Context r9 = r1.f204a
            java.lang.String r10 = r7.d()
            com.xiaomi.mipush.sdk.MiPushClient.addAlias(r9, r10)
            goto L_0x07c2
        L_0x07a1:
            java.lang.String r9 = r7.c()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x07c2
            android.content.Context r9 = r1.f204a
            java.lang.String r10 = r7.c()
            long r9 = com.xiaomi.mipush.sdk.MiPushClient.topicSubscribedTime(r9, r10)
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x07c2
            android.content.Context r9 = r1.f204a
            java.lang.String r10 = r7.c()
            com.xiaomi.mipush.sdk.MiPushClient.addTopic(r9, r10)
        L_0x07c2:
            com.xiaomi.push.di r9 = r2.f577a
            if (r9 == 0) goto L_0x07d9
            java.util.Map r9 = r9.a()
            if (r9 == 0) goto L_0x07d9
            com.xiaomi.push.di r9 = r2.f577a
            java.util.Map<java.lang.String, java.lang.String> r9 = r9.f493a
            java.lang.String r10 = "jobkey"
            java.lang.Object r9 = r9.get(r10)
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x07da
        L_0x07d9:
            r9 = r6
        L_0x07da:
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            if (r10 == 0) goto L_0x07e5
            java.lang.String r10 = r5.a()
            goto L_0x07e6
        L_0x07e5:
            r10 = r9
        L_0x07e6:
            if (r3 != 0) goto L_0x0806
            android.content.Context r11 = r1.f204a
            boolean r11 = a(r11, r10)
            if (r11 == 0) goto L_0x0806
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "drop a duplicate message, key="
            r0.append(r4)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            goto L_0x08f5
        L_0x0806:
            com.xiaomi.push.di r11 = r17.a()
            com.xiaomi.mipush.sdk.MiPushMessage r11 = com.xiaomi.mipush.sdk.PushMessageHelper.generateMessage(r7, r11, r3)
            int r12 = r11.getPassThrough()
            if (r12 != 0) goto L_0x0828
            if (r3 != 0) goto L_0x0828
            java.util.Map r12 = r11.getExtra()
            boolean r12 = com.xiaomi.push.service.ag.a(r12)
            if (r12 == 0) goto L_0x0828
            android.content.Context r0 = r1.f204a
            r3 = r19
            com.xiaomi.push.service.ag.a(r0, r2, r3)
            return r6
        L_0x0828:
            java.lang.String r12 = "receive a message, msgid="
            java.lang.StringBuilder r12 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r12)
            java.lang.String r13 = r5.a()
            r12.append(r13)
            java.lang.String r13 = ", jobkey="
            r12.append(r13)
            r12.append(r10)
            java.lang.String r10 = ", btn="
            r12.append(r10)
            r12.append(r8)
            java.lang.String r10 = r12.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r10)
            java.util.Map r10 = r11.getExtra()
            java.lang.String r10 = com.xiaomi.push.service.ag.a(r10, r8)
            if (r3 == 0) goto L_0x08f4
            java.util.Map r12 = r11.getExtra()
            if (r12 == 0) goto L_0x08f4
            boolean r12 = android.text.TextUtils.isEmpty(r10)
            if (r12 != 0) goto L_0x08f4
            java.util.Map r3 = r11.getExtra()
            if (r8 == 0) goto L_0x087f
            com.xiaomi.push.di r7 = r17.a()
            if (r7 == 0) goto L_0x087f
            android.content.Context r7 = r1.f204a
            com.xiaomi.mipush.sdk.ag r7 = com.xiaomi.mipush.sdk.ag.a(r7)
            com.xiaomi.push.di r12 = r17.a()
            int r12 = r12.c()
            r7.a(r12, r8)
        L_0x087f:
            boolean r7 = com.xiaomi.push.service.ag.a(r17)
            if (r7 == 0) goto L_0x08b6
            android.content.Context r7 = r1.f204a
            java.lang.String r10 = r2.f583b
            android.content.Intent r3 = a(r7, r10, r3, r8)
            java.lang.String r7 = "eventMessageType"
            r3.putExtra(r7, r4)
            java.lang.String r4 = "messageId"
            r3.putExtra(r4, r0)
            java.lang.String r0 = "jobkey"
            r3.putExtra(r0, r9)
            java.lang.String r0 = r5.c()
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x08ab
            java.lang.String r4 = "payload"
            r3.putExtra(r4, r0)
        L_0x08ab:
            android.content.Context r0 = r1.f204a
            r0.startActivity(r3)
            android.content.Context r0 = r1.f204a
            com.xiaomi.mipush.sdk.n.a(r0, r2)
            goto L_0x08f3
        L_0x08b6:
            android.content.Context r5 = r1.f204a
            java.lang.String r7 = r5.getPackageName()
            android.content.Intent r3 = a(r5, r7, r3, r8)
            if (r3 == 0) goto L_0x08f3
            java.lang.String r5 = com.xiaomi.push.service.bd.f4900c
            boolean r5 = r10.equals(r5)
            if (r5 != 0) goto L_0x08de
            java.lang.String r5 = "key_message"
            r3.putExtra(r5, r11)
            java.lang.String r5 = "eventMessageType"
            r3.putExtra(r5, r4)
            java.lang.String r4 = "messageId"
            r3.putExtra(r4, r0)
            java.lang.String r0 = "jobkey"
            r3.putExtra(r0, r9)
        L_0x08de:
            android.content.Context r0 = r1.f204a
            r0.startActivity(r3)
            android.content.Context r0 = r1.f204a
            com.xiaomi.mipush.sdk.n.a(r0, r2)
            java.lang.String r0 = "start activity succ"
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            java.lang.String r0 = com.xiaomi.push.service.bd.f4900c
            r10.equals(r0)
        L_0x08f3:
            return r6
        L_0x08f4:
            r6 = r11
        L_0x08f5:
            com.xiaomi.push.di r0 = r17.a()
            if (r0 != 0) goto L_0x0900
            if (r3 != 0) goto L_0x0900
            r1.a(r7, r2)
        L_0x0900:
            return r6
        L_0x0901:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            java.lang.String r0 = "receive a message which action string is not valid. is the reg expired?"
            com.xiaomi.channel.commonutils.logger.b.d(r0)
            android.content.Context r0 = r1.f204a
            com.xiaomi.mipush.sdk.n.c(r0, r2, r3)
            return r6
        L_0x0910:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            r16.a(r17)
            android.content.Context r0 = r1.f204a
            com.xiaomi.mipush.sdk.n.c(r0, r2, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ae.a(com.xiaomi.push.dq, boolean, byte[], java.lang.String, int, android.content.Intent):com.xiaomi.mipush.sdk.PushMessageHandler$a");
    }

    private a a(dq dqVar, byte[] bArr) {
        String str;
        String str2 = null;
        try {
            ef a2 = aa.a(this.f204a, dqVar);
            if (a2 == null) {
                b.d("message arrived: receiving an un-recognized message. " + dqVar.f576a);
                return null;
            }
            cz a3 = dqVar.a();
            b.a("message arrived: processing an arrived message, action=" + a3);
            if (af.f4343a[a3.ordinal()] != 1) {
                return null;
            }
            if (!dqVar.b()) {
                str = "message arrived: receiving an un-encrypt message(SendMessage).";
            } else {
                dx dxVar = (dx) a2;
                dh a4 = dxVar.a();
                if (a4 == null) {
                    str = "message arrived: receive an empty message without push content, drop it";
                } else {
                    di diVar = dqVar.f577a;
                    if (!(diVar == null || diVar.a() == null)) {
                        str2 = dqVar.f577a.f493a.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(dxVar, dqVar.a(), false);
                    generateMessage.setArrivedMessage(true);
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("message arrived: receive a message, msgid=");
                    outline73.append(a4.a());
                    outline73.append(", jobkey=");
                    outline73.append(str2);
                    b.a(outline73.toString());
                    return generateMessage;
                }
            }
            b.d(str);
            return null;
        } catch (o e2) {
            b.a((Throwable) e2);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (ej e3) {
            b.a((Throwable) e3);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
    }

    public static ae a(Context context) {
        if (f4342a == null) {
            f4342a = new ae(context);
        }
        return f4342a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f204a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0)) > DefaultRemoteConfig.SESSION_TIMEOUT_DURATION) {
            MiPushClient.reInitialize(this.f204a, dj.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    public static void a(Context context, String str) {
        synchronized (f202a) {
            f203a.remove(str);
            a.a(context);
            SharedPreferences a2 = a.a(context);
            String a3 = ad.a((Collection<?>) f203a, (String) ",");
            Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            h.a(edit);
        }
    }

    private void a(dm dmVar) {
        c cVar;
        long j;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ASSEMBLE_PUSH : ");
        outline73.append(dmVar.toString());
        b.c(outline73.toString());
        String a2 = dmVar.a();
        Map a3 = dmVar.a();
        if (a3 != null) {
            String str = (String) a3.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (!TextUtils.isEmpty(str)) {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("brand:");
                outline732.append(y.FCM.name());
                if (str.contains(outline732.toString())) {
                    b.a((String) "ASSEMBLE_PUSH : receive fcm token sync ack");
                    g.b(this.f204a, c.ASSEMBLE_PUSH_FCM, str);
                    j = dmVar.f536a;
                    cVar = c.ASSEMBLE_PUSH_FCM;
                } else {
                    StringBuilder outline733 = GeneratedOutlineSupport.outline73("brand:");
                    outline733.append(y.HUAWEI.name());
                    if (str.contains(outline733.toString())) {
                        b.a((String) "ASSEMBLE_PUSH : receive hw token sync ack");
                        g.b(this.f204a, c.ASSEMBLE_PUSH_HUAWEI, str);
                        j = dmVar.f536a;
                        cVar = c.ASSEMBLE_PUSH_HUAWEI;
                    } else {
                        StringBuilder outline734 = GeneratedOutlineSupport.outline73("brand:");
                        outline734.append(y.OPPO.name());
                        if (str.contains(outline734.toString())) {
                            b.a((String) "ASSEMBLE_PUSH : receive COS token sync ack");
                            g.b(this.f204a, c.ASSEMBLE_PUSH_COS, str);
                            j = dmVar.f536a;
                            cVar = c.ASSEMBLE_PUSH_COS;
                        } else {
                            StringBuilder outline735 = GeneratedOutlineSupport.outline73("brand:");
                            outline735.append(y.VIVO.name());
                            if (str.contains(outline735.toString())) {
                                b.a((String) "ASSEMBLE_PUSH : receive FTOS token sync ack");
                                g.b(this.f204a, c.ASSEMBLE_PUSH_FTOS, str);
                                j = dmVar.f536a;
                                cVar = c.ASSEMBLE_PUSH_FTOS;
                            } else {
                                return;
                            }
                        }
                    }
                }
                a(a2, j, cVar);
            }
        }
    }

    private void a(dq dqVar) {
        b.a((String) "receive a message but decrypt failed. report now.");
        dt dtVar = new dt(dqVar.a().f491a, false);
        dtVar.c(df.DecryptMessageFail.f458a);
        dtVar.b(dqVar.a());
        dtVar.d(dqVar.f583b);
        HashMap hashMap = new HashMap();
        dtVar.f595a = hashMap;
        hashMap.put("regid", MiPushClient.getRegId(this.f204a));
        ag.a(this.f204a).a(dtVar, cz.Notification, false, (di) null);
    }

    private void a(dt dtVar) {
        dm dmVar = new dm();
        dmVar.c(df.CancelPushMessageACK.f458a);
        dmVar.a(dtVar.a());
        dmVar.a(dtVar.a());
        dmVar.b(dtVar.b());
        dmVar.e(dtVar.c());
        dmVar.a(0);
        dmVar.d("success clear push message.");
        ag.a(this.f204a).a(dmVar, cz.Notification, false, true, null, false, this.f204a.getPackageName(), a.a(this.f204a).a(), false);
    }

    private void a(dx dxVar, dq dqVar) {
        di a2 = dqVar.a();
        if (a2 != null) {
            a2 = bj.a(a2.a());
        }
        dl dlVar = new dl();
        dlVar.b(dxVar.b());
        dlVar.a(dxVar.a());
        dlVar.a(dxVar.a().a());
        if (!TextUtils.isEmpty(dxVar.c())) {
            dlVar.c(dxVar.c());
        }
        if (!TextUtils.isEmpty(dxVar.d())) {
            dlVar.d(dxVar.d());
        }
        dlVar.a(ee.a(this.f204a, dqVar));
        ag.a(this.f204a).a(dlVar, cz.AckMessage, a2);
    }

    private void a(String str, long j, c cVar) {
        Class<x> cls = x.class;
        am a2 = j.a(cVar);
        if (a2 != null) {
            if (j == 0) {
                synchronized (cls) {
                    if (x.a(this.f204a).a(str)) {
                        x.a(this.f204a).c(str);
                        if ("syncing".equals(x.a(this.f204a).a(a2))) {
                            x.a(this.f204a).a(a2, "synced");
                        }
                    }
                }
            } else if ("syncing".equals(x.a(this.f204a).a(a2))) {
                synchronized (cls) {
                    if (x.a(this.f204a).a(str)) {
                        if (x.a(this.f204a).a(str) < 10) {
                            x.a(this.f204a).b(str);
                            ag.a(this.f204a).a(str, a2, cVar);
                        } else {
                            x.a(this.f204a).c(str);
                        }
                    }
                }
            } else {
                x.a(this.f204a).c(str);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m356a(Context context, String str) {
        synchronized (f202a) {
            a.a(context);
            SharedPreferences a2 = a.a(context);
            if (f203a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(",");
                f203a = new LinkedList();
                for (String add : split) {
                    f203a.add(add);
                }
            }
            if (f203a.contains(str)) {
                return true;
            }
            f203a.add(str);
            if (f203a.size() > 25) {
                f203a.poll();
            }
            String a3 = ad.a((Collection<?>) f203a, (String) ",");
            Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            h.a(edit);
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m357a(dq dqVar) {
        Map a2 = dqVar.a() == null ? null : dqVar.a().a();
        if (a2 == null) {
            return false;
        }
        String str = (String) a2.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }

    private void b(dq dqVar) {
        di a2 = dqVar.a();
        if (a2 != null) {
            a2 = bj.a(a2.a());
        }
        dl dlVar = new dl();
        dlVar.b(dqVar.a());
        dlVar.a(a2.a());
        dlVar.a(a2.a());
        if (!TextUtils.isEmpty(a2.b())) {
            dlVar.c(a2.b());
        }
        dlVar.a(ee.a(this.f204a, dqVar));
        ag.a(this.f204a).a(dlVar, cz.AckMessage, false, a2);
    }

    public a a(Intent intent) {
        String str;
        String str2;
        String format;
        String action = intent.getAction();
        b.a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                str2 = "receiving an empty message, drop";
            } else {
                dq dqVar = new dq();
                try {
                    ee.a(dqVar, byteArrayExtra);
                    a a2 = a.a(this.f204a);
                    di a3 = dqVar.a();
                    if (dqVar.a() == cz.SendMessage && a3 != null && !a2.e() && !booleanExtra) {
                        a3.a("mrt", stringExtra);
                        a3.a("mat", Long.toString(System.currentTimeMillis()));
                        if (!a(dqVar)) {
                            b(dqVar);
                        } else {
                            b.b("this is a mina's message, ack later");
                            a3.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(a3.a()));
                            a3.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf(ee.a(this.f204a, dqVar)));
                        }
                    }
                    String str3 = "";
                    if (dqVar.a() == cz.SendMessage) {
                        if (!dqVar.b()) {
                            if (ag.a(dqVar)) {
                                Object[] objArr = new Object[2];
                                objArr[0] = dqVar.b();
                                if (a3 != null) {
                                    str3 = a3.a();
                                }
                                objArr[1] = str3;
                                format = String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr);
                            } else {
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = dqVar.b();
                                if (a3 != null) {
                                    str3 = a3.a();
                                }
                                objArr2[1] = str3;
                                format = String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2);
                            }
                            b.a(format);
                            n.a(this.f204a, dqVar, booleanExtra);
                            return null;
                        }
                    }
                    if (dqVar.a() == cz.SendMessage && dqVar.b() && ag.a(dqVar)) {
                        if (!booleanExtra || a3 == null || a3.a() == null || !a3.a().containsKey("notify_effect")) {
                            Object[] objArr3 = new Object[2];
                            objArr3[0] = dqVar.b();
                            if (a3 != null) {
                                str3 = a3.a();
                            }
                            objArr3[1] = str3;
                            b.a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                            n.b(this.f204a, dqVar, booleanExtra);
                            return null;
                        }
                    }
                    if (a2.c() || dqVar.f576a == cz.Registration) {
                        if (!a2.c() || !a2.f()) {
                            return a(dqVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                        }
                        if (dqVar.f576a != cz.UnRegistration) {
                            n.e(this.f204a, dqVar, booleanExtra);
                            MiPushClient.unregisterPush(this.f204a);
                        } else if (dqVar.b()) {
                            a2.a();
                            MiPushClient.clearExtras(this.f204a);
                            PushMessageHandler.a();
                        } else {
                            b.d("receiving an un-encrypt unregistration message");
                        }
                        return null;
                    } else if (ag.a(dqVar)) {
                        return a(dqVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    } else {
                        n.e(this.f204a, dqVar, booleanExtra);
                        boolean d2 = a2.d();
                        b.d("receive message without registration. need re-register!registered?" + d2);
                        if (d2) {
                            a();
                        }
                        return null;
                    }
                } catch (ej | Exception e2) {
                    b.a(e2);
                }
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            dq dqVar2 = new dq();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    ee.a(dqVar2, byteArrayExtra2);
                }
            } catch (ej unused) {
            }
            miPushCommandMessage.setCommand(String.valueOf(dqVar2.a()));
            miPushCommandMessage.setResultCode((long) intent.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
            b.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else {
            if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra3 == null) {
                    str2 = "message arrived: receiving an empty message, drop";
                } else {
                    dq dqVar3 = new dq();
                    try {
                        ee.a(dqVar3, byteArrayExtra3);
                        a a4 = a.a(this.f204a);
                        if (ag.a(dqVar3)) {
                            str = "message arrived: receive ignore reg message, ignore!";
                        } else if (!a4.c()) {
                            str = "message arrived: receive message without registration. need unregister or re-register!";
                        } else if (!a4.c() || !a4.f()) {
                            return a(dqVar3, byteArrayExtra3);
                        } else {
                            str = "message arrived: app info is invalidated";
                        }
                        b.d(str);
                    } catch (Exception e3) {
                        b.d("fail to deal with arrived message. " + e3);
                    }
                }
            }
            return null;
        }
        b.d(str2);
        return null;
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        List<String> list2 = list;
        if (timeZone.equals(timeZone2)) {
            return list2;
        }
        long rawOffset = (long) (((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60);
        long parseLong = Long.parseLong(list2.get(0).split(":")[0]);
        long parseLong2 = Long.parseLong(list2.get(0).split(":")[1]);
        long j = ((((parseLong * 60) + parseLong2) - rawOffset) + 1440) % 1440;
        long parseLong3 = ((((Long.parseLong(list2.get(1).split(":")[0]) * 60) + Long.parseLong(list2.get(1).split(":")[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(parseLong3 / 60), Long.valueOf(parseLong3 % 60)}));
        return arrayList;
    }
}
