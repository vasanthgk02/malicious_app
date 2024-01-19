package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.android.c;
import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.push.C0097r.b;
import com.xiaomi.push.au;
import com.xiaomi.push.cv;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class bn {

    /* renamed from: a  reason: collision with root package name */
    public static bn f4919a = new bn();

    /* renamed from: a  reason: collision with other field name */
    public static String f888a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.at.a f889a;

    /* renamed from: a  reason: collision with other field name */
    public b f890a;

    /* renamed from: a  reason: collision with other field name */
    public List<a> f891a = new ArrayList();

    public static abstract class a {
        public void a(com.xiaomi.push.at.a aVar) {
        }

        public void a(au.b bVar) {
        }
    }

    public static bn a() {
        return f4919a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m837a() {
        String str;
        synchronized (bn.class) {
            if (f888a == null) {
                SharedPreferences sharedPreferences = j.a().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                f888a = string;
                if (string == null) {
                    String a2 = c.a(j.a());
                    f888a = a2;
                    if (a2 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f888a).commit();
                    }
                }
            }
            str = f888a;
        }
        return str;
    }

    private void b() {
        if (this.f889a == null) {
            d();
        }
    }

    private void c() {
        if (this.f890a == null) {
            bo boVar = new bo(this);
            this.f890a = boVar;
            cv.a((b) boVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.xiaomi.channel.commonutils.android.j.a()     // Catch:{ Exception -> 0x0027, all -> 0x0023 }
            java.lang.String r2 = "XMCloudCfg"
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch:{ Exception -> 0x0027, all -> 0x0023 }
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0027, all -> 0x0023 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0027, all -> 0x0023 }
            com.xiaomi.push.b r0 = com.xiaomi.push.b.a(r2)     // Catch:{ Exception -> 0x0021 }
            com.xiaomi.push.at$a r0 = com.xiaomi.push.at.a.b(r0)     // Catch:{ Exception -> 0x0021 }
            r4.f889a = r0     // Catch:{ Exception -> 0x0021 }
            r2.close()     // Catch:{ Exception -> 0x0021 }
        L_0x001d:
            com.xiaomi.push.h.a(r2)
            goto L_0x0043
        L_0x0021:
            r0 = move-exception
            goto L_0x002a
        L_0x0023:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x0050
        L_0x0027:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x002a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r1.<init>()     // Catch:{ all -> 0x004f }
            java.lang.String r3 = "load config failure: "
            r1.append(r3)     // Catch:{ all -> 0x004f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x004f }
            r1.append(r0)     // Catch:{ all -> 0x004f }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x004f }
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ all -> 0x004f }
            goto L_0x001d
        L_0x0043:
            com.xiaomi.push.at$a r0 = r4.f889a
            if (r0 != 0) goto L_0x004e
            com.xiaomi.push.at$a r0 = new com.xiaomi.push.at$a
            r0.<init>()
            r4.f889a = r0
        L_0x004e:
            return
        L_0x004f:
            r0 = move-exception
        L_0x0050:
            com.xiaomi.push.h.a(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.bn.d():void");
    }

    private void e() {
        try {
            if (this.f889a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(j.a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a((OutputStream) bufferedOutputStream);
                this.f889a.a(a2);
                a2.a();
                bufferedOutputStream.close();
            }
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("save config failure: ");
            outline73.append(e2.getMessage());
            com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m838a() {
        b();
        com.xiaomi.push.at.a aVar = this.f889a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m839a() {
        this.f891a.clear();
    }

    public void a(au.b bVar) {
        a[] aVarArr;
        if (bVar.d() && bVar.d() > a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f891a.toArray(new a[this.f891a.size()]);
        }
        for (a a2 : aVarArr) {
            a2.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.f891a.add(aVar);
    }
}
