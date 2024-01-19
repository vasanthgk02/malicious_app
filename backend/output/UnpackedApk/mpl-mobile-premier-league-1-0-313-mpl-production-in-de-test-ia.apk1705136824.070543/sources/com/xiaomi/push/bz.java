package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService.j;
import com.xiaomi.push.service.n;
import java.io.IOException;
import java.net.Socket;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

public abstract class bz extends bt {

    /* renamed from: a  reason: collision with root package name */
    public Exception f4524a = null;

    /* renamed from: a  reason: collision with other field name */
    public Socket f403a;

    /* renamed from: b  reason: collision with root package name */
    public XMPushService f4525b;

    /* renamed from: c  reason: collision with root package name */
    public int f4526c;

    /* renamed from: c  reason: collision with other field name */
    public String f404c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f4527d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f4528e = 0;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f4529f = 0;
    public volatile long g = 0;
    public long h = 0;

    public bz(XMPushService xMPushService, bu buVar) {
        super(xMPushService, buVar);
        this.f4525b = xMPushService;
    }

    private void a(bu buVar) {
        a(buVar.c(), buVar.a());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x015a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x015b, code lost:
        r26 = r3;
        r3 = r14;
        r23 = r15;
        r15 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0162, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0163, code lost:
        r26 = r3;
        r25 = r13;
        r3 = r14;
        r23 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02cd A[EDGE_INSN: B:104:0x02cd->B:85:0x02cd ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0261 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0162 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:18:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x030e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r28, int r29) {
        /*
            r27 = this;
            r1 = r27
            r0 = r28
            r2 = r29
            java.lang.String r3 = "|"
            java.lang.String r4 = "\n"
            java.lang.String r5 = " err:"
            java.lang.String r6 = " port:"
            java.lang.String r7 = "SMACK: Could not connect to "
            java.lang.String r8 = "SMACK: Could not connect to:"
            r9 = 0
            r1.f4524a = r9
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "get bucket for host : "
            r10.append(r11)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.Integer r10 = com.xiaomi.channel.commonutils.logger.b.a(r10)
            int r10 = r10.intValue()
            com.xiaomi.push.ag r15 = r27.a(r28)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            com.xiaomi.channel.commonutils.logger.b.a(r10)
            r10 = 1
            if (r15 == 0) goto L_0x0046
            java.util.ArrayList r9 = r15.a(r10)
        L_0x0046:
            com.xiaomi.push.ak r11 = com.xiaomi.push.ak.a()
            com.xiaomi.push.ag r11 = r11.d(r0)
            if (r11 == 0) goto L_0x006f
            java.util.ArrayList r10 = r11.a(r10)
            java.util.Iterator r10 = r10.iterator()
        L_0x0058:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x006f
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            int r12 = r9.indexOf(r11)
            r13 = -1
            if (r12 != r13) goto L_0x0058
            r9.add(r11)
            goto L_0x0058
        L_0x006f:
            boolean r10 = r9.isEmpty()
            if (r10 == 0) goto L_0x0078
            r9.add(r0)
        L_0x0078:
            r10 = 0
            r1.g = r10
            android.os.SystemClock.elapsedRealtime()
            com.xiaomi.push.service.XMPushService r0 = r1.f4525b
            java.lang.String r13 = com.xiaomi.push.y.a(r0)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.util.Iterator r9 = r9.iterator()
            java.lang.String r0 = ""
            r11 = r10
            r10 = r0
        L_0x0092:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x02d1
            java.lang.Object r0 = r9.next()
            r28 = r9
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            long r17 = java.lang.System.currentTimeMillis()
            int r0 = r1.f384a
            int r0 = r0 + 1
            r1.f384a = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ef, all -> 0x0162 }
            r0.<init>()     // Catch:{ Exception -> 0x015a, all -> 0x0162 }
            java.lang.String r11 = "begin to connect to "
            r0.append(r11)     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            r0.append(r9)     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            java.net.Socket r0 = r27.a()     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            r1.f403a = r0     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            java.net.InetSocketAddress r0 = com.xiaomi.push.ai.a(r9, r2)     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            java.net.Socket r11 = r1.f403a     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            r12 = 8000(0x1f40, float:1.121E-41)
            r11.connect(r0, r12)     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            java.lang.String r0 = "tcp connected"
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            java.net.Socket r0 = r1.f403a     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            r11 = 1
            r0.setTcpNoDelay(r11)     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            r1.f4527d = r9     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            r27.a()     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            long r11 = r11 - r17
            r1.f385a = r11     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            r1.f394b = r13     // Catch:{ Exception -> 0x014a, all -> 0x013f }
            if (r15 == 0) goto L_0x0104
            r19 = 0
            r21 = 0
            r23 = r11
            r11 = r15
            r12 = r9
            r26 = r3
            r25 = r13
            r3 = r14
            r13 = r23
            r23 = r15
            r15 = r19
            r11.b(r12, r13, r15)     // Catch:{ Exception -> 0x0138, all -> 0x0134 }
            goto L_0x010d
        L_0x0104:
            r26 = r3
            r25 = r13
            r3 = r14
            r23 = r15
            r21 = 0
        L_0x010d:
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0138, all -> 0x0134 }
            r1.g = r11     // Catch:{ Exception -> 0x0138, all -> 0x0134 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138, all -> 0x0134 }
            r0.<init>()     // Catch:{ Exception -> 0x0138, all -> 0x0134 }
            java.lang.String r11 = "connected to "
            r0.append(r11)     // Catch:{ Exception -> 0x0138, all -> 0x0134 }
            r0.append(r9)     // Catch:{ Exception -> 0x0138, all -> 0x0134 }
            java.lang.String r11 = " in "
            r0.append(r11)     // Catch:{ Exception -> 0x0138, all -> 0x0134 }
            long r11 = r1.f385a     // Catch:{ Exception -> 0x0138, all -> 0x0134 }
            r0.append(r11)     // Catch:{ Exception -> 0x0138, all -> 0x0134 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0138, all -> 0x0134 }
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ Exception -> 0x0138, all -> 0x0134 }
            r0 = 1
            goto L_0x02d5
        L_0x0134:
            r0 = move-exception
            r11 = r21
            goto L_0x016a
        L_0x0138:
            r0 = move-exception
            r15 = r25
            r13 = r26
            goto L_0x01f7
        L_0x013f:
            r0 = move-exception
            r26 = r3
            r25 = r13
            r3 = r14
            r23 = r15
            r11 = 0
            goto L_0x016a
        L_0x014a:
            r0 = move-exception
            r26 = r3
            r25 = r13
            r3 = r14
            r23 = r15
            r11 = 0
            r15 = r25
        L_0x0156:
            r13 = r26
            goto L_0x01f5
        L_0x015a:
            r0 = move-exception
            r26 = r3
            r3 = r14
            r23 = r15
            r15 = r13
            goto L_0x0156
        L_0x0162:
            r0 = move-exception
            r26 = r3
            r25 = r13
            r3 = r14
            r23 = r15
        L_0x016a:
            r19 = r11
            java.lang.Exception r11 = new java.lang.Exception     // Catch:{ all -> 0x01ea }
            java.lang.String r12 = "abnormal exception"
            r11.<init>(r12, r0)     // Catch:{ all -> 0x01ea }
            r1.f4524a = r11     // Catch:{ all -> 0x01ea }
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ all -> 0x01ea }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r0)
            r3.append(r7)
            r3.append(r9)
            r3.append(r6)
            r3.append(r2)
            r3.append(r5)
            java.lang.Exception r0 = r1.f4524a
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r3.append(r0)
            r3.append(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto L_0x01b3
            r0 = r9
            r15 = r26
            goto L_0x01b9
        L_0x01b3:
            r15 = r26
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r10, r15, r9)
        L_0x01b9:
            if (r23 == 0) goto L_0x01d1
            long r10 = java.lang.System.currentTimeMillis()
            long r13 = r10 - r17
            r16 = 0
            java.lang.Exception r10 = r1.f4524a
            r11 = r23
            r12 = r9
            r9 = r15
            r15 = r16
            r17 = r10
            r11.b(r12, r13, r15, r17)
            goto L_0x01d2
        L_0x01d1:
            r9 = r15
        L_0x01d2:
            com.xiaomi.push.service.XMPushService r10 = r1.f4525b
            java.lang.String r10 = com.xiaomi.push.y.a(r10)
            r15 = r25
            boolean r10 = android.text.TextUtils.equals(r15, r10)
            if (r10 != 0) goto L_0x01e2
            goto L_0x02cd
        L_0x01e2:
            r10 = r0
            r11 = r19
            r20 = r9
            r9 = r15
            goto L_0x0268
        L_0x01ea:
            r0 = move-exception
            r15 = r25
            goto L_0x0275
        L_0x01ef:
            r0 = move-exception
            r23 = r15
            r15 = r13
            r13 = r3
            r3 = r14
        L_0x01f5:
            r21 = r11
        L_0x01f7:
            r1.f4524a = r0     // Catch:{ all -> 0x0272 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r0)
            r3.append(r7)
            r3.append(r9)
            r3.append(r6)
            r3.append(r2)
            r3.append(r5)
            java.lang.Exception r0 = r1.f4524a
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r3.append(r0)
            r3.append(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto L_0x0232
            r0 = r9
            goto L_0x0236
        L_0x0232:
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r10, r13, r9)
        L_0x0236:
            if (r23 == 0) goto L_0x0252
            long r10 = java.lang.System.currentTimeMillis()
            long r16 = r10 - r17
            r18 = 0
            java.lang.Exception r10 = r1.f4524a
            r11 = r23
            r12 = r9
            r20 = r13
            r13 = r16
            r9 = r15
            r15 = r18
            r17 = r10
            r11.b(r12, r13, r15, r17)
            goto L_0x0255
        L_0x0252:
            r20 = r13
            r9 = r15
        L_0x0255:
            com.xiaomi.push.service.XMPushService r10 = r1.f4525b
            java.lang.String r10 = com.xiaomi.push.y.a(r10)
            boolean r10 = android.text.TextUtils.equals(r9, r10)
            if (r10 != 0) goto L_0x0265
            r11 = r21
            goto L_0x02d2
        L_0x0265:
            r10 = r0
            r11 = r21
        L_0x0268:
            r14 = r3
            r13 = r9
            r3 = r20
            r15 = r23
            r9 = r28
            goto L_0x0092
        L_0x0272:
            r0 = move-exception
            r19 = r21
        L_0x0275:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r8)
            r11.append(r9)
            java.lang.String r8 = r11.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r8)
            r3.append(r7)
            r3.append(r9)
            r3.append(r6)
            r3.append(r2)
            r3.append(r5)
            java.lang.Exception r2 = r1.f4524a
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r3.append(r2)
            r3.append(r4)
            android.text.TextUtils.isEmpty(r10)
            if (r23 == 0) goto L_0x02c0
            long r4 = java.lang.System.currentTimeMillis()
            long r13 = r4 - r17
            r4 = 0
            java.lang.Exception r2 = r1.f4524a
            r11 = r23
            r12 = r9
            r6 = r15
            r15 = r4
            r17 = r2
            r11.b(r12, r13, r15, r17)
            goto L_0x02c1
        L_0x02c0:
            r6 = r15
        L_0x02c1:
            com.xiaomi.push.service.XMPushService r2 = r1.f4525b
            java.lang.String r2 = com.xiaomi.push.y.a(r2)
            boolean r2 = android.text.TextUtils.equals(r6, r2)
            if (r2 != 0) goto L_0x02d0
        L_0x02cd:
            r11 = r19
            goto L_0x02d2
        L_0x02d0:
            throw r0
        L_0x02d1:
            r3 = r14
        L_0x02d2:
            r0 = 0
            r21 = r11
        L_0x02d5:
            com.xiaomi.push.ak r2 = com.xiaomi.push.ak.a()
            r2.d()
            android.os.SystemClock.elapsedRealtime()
            if (r0 != 0) goto L_0x030e
            long r4 = r1.h
            int r0 = (r4 > r21 ? 1 : (r4 == r21 ? 0 : -1))
            if (r0 == 0) goto L_0x02f5
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r6 = r1.h
            long r4 = r4 - r6
            r6 = 480000(0x75300, double:2.371515E-318)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0304
        L_0x02f5:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r1.h = r4
            com.xiaomi.push.service.XMPushService r0 = r1.f4525b
            android.content.Context r0 = r0.getApplicationContext()
            com.xiaomi.push.y.b(r0)
        L_0x0304:
            com.xiaomi.push.cd r0 = new com.xiaomi.push.cd
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x030e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bz.a(java.lang.String, int):void");
    }

    public ag a(String str) {
        ag a2 = ak.a().a(str, false);
        if (!a2.b()) {
            cv.a((Runnable) new cc(this, str));
        }
        return a2;
    }

    public String a() {
        return this.f4527d;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Socket m545a() {
        return new Socket();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m546a() {
    }

    public synchronized void a(int i, Exception exc) {
        if (a() != 2) {
            a(2, i, exc);
            this.f389a = "";
            try {
                this.f403a.close();
            } catch (Throwable unused) {
            }
            this.f4528e = 0;
            this.f4529f = 0;
        }
    }

    public void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.g < 300000) {
            if (y.a((Context) this.f4525b)) {
                int i = this.f4526c + 1;
                this.f4526c = i;
                if (i >= 2) {
                    String a2 = a();
                    b.a("max short conn time reached, sink down current host:" + a2);
                    a(a2, 0, exc);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.f4526c = 0;
    }

    public void a(String str, long j, Exception exc) {
        ag a2 = ak.a().a(bu.a(), false);
        if (a2 != null) {
            a2.b(str, j, 0, exc);
            ak.a().d();
        }
    }

    public abstract void a(boolean z);

    public void a(bi[] biVarArr) {
        throw new cd((String) "Don't support send Blob");
    }

    public void b(int i, Exception exc) {
        a(i, exc);
        if ((exc != null || i == 18) && this.g != 0) {
            a(exc);
        }
    }

    public void b(boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        a(z);
        n.a((Context) this.f4525b).c();
        if (!z) {
            XMPushService xMPushService = this.f4525b;
            ca caVar = new ca(this, 13, elapsedRealtime, currentTimeMillis);
            xMPushService.a((j) caVar, (long) MqttAsyncClient.DISCONNECT_TIMEOUT);
        }
    }

    public String c() {
        return this.f389a;
    }

    public void c(int i, Exception exc) {
        this.f4525b.a((j) new cb(this, 2, i, exc));
    }

    public synchronized void e() {
        try {
            if (!c()) {
                if (!b()) {
                    a(0, 0, null);
                    a(this.f386a);
                    return;
                }
            }
            b.a((String) "WARNING: current xmpp has connected");
        } catch (IOException e2) {
            throw new cd((Throwable) e2);
        }
    }

    public void f() {
        this.f4528e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f4529f = SystemClock.elapsedRealtime();
    }
}
