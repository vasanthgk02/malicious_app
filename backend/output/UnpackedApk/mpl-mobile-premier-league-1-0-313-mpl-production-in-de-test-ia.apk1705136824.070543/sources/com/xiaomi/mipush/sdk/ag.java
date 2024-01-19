package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.push.ac;
import com.xiaomi.push.cz;
import com.xiaomi.push.da;
import com.xiaomi.push.db;
import com.xiaomi.push.df;
import com.xiaomi.push.di;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.ea;
import com.xiaomi.push.ee;
import com.xiaomi.push.ef;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.bf;
import com.xiaomi.push.service.i;
import com.xiaomi.push.service.i.b;
import com.xiaomi.push.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ag {

    /* renamed from: a  reason: collision with root package name */
    public static ag f4344a;

    /* renamed from: a  reason: collision with other field name */
    public static final ArrayList<a> f205a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f4345b;

    /* renamed from: a  reason: collision with other field name */
    public long f206a;

    /* renamed from: a  reason: collision with other field name */
    public Context f207a;

    /* renamed from: a  reason: collision with other field name */
    public Intent f208a = null;

    /* renamed from: a  reason: collision with other field name */
    public Handler f209a = null;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f210a;

    /* renamed from: a  reason: collision with other field name */
    public Integer f211a = null;

    /* renamed from: a  reason: collision with other field name */
    public String f212a;

    /* renamed from: a  reason: collision with other field name */
    public List<Message> f213a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public boolean f214a = false;

    /* renamed from: b  reason: collision with other field name */
    public String f215b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4346c = false;

    public static class a<T extends ef<T, ?>> {

        /* renamed from: a  reason: collision with root package name */
        public cz f4347a;

        /* renamed from: a  reason: collision with other field name */
        public T f216a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f217a;
    }

    public ag(Context context) {
        this.f207a = context.getApplicationContext();
        this.f212a = null;
        this.f214a = c();
        f4345b = d();
        this.f209a = new ah(this, Looper.getMainLooper());
        if (f.a(context)) {
            i.a((b) new ai(this));
        }
        Intent b2 = b();
        if (b2 != null) {
            a(b2);
        }
    }

    private synchronized int a() {
        try {
        }
        return this.f207a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m358a() {
        return (!a() || "com.xiaomi.xmsf".equals(this.f207a.getPackageName())) ? e() : d();
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static synchronized ag a(Context context) {
        ag agVar;
        synchronized (ag.class) {
            try {
                if (f4344a == null) {
                    f4344a = new ag(context);
                }
                agVar = f4344a;
            }
        }
        return agVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m359a() {
        String str = this.f215b;
        if (str != null) {
            return str;
        }
        try {
            if (this.f207a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106) {
                this.f215b = "com.xiaomi.push.service.XMPushService";
                return "com.xiaomi.push.service.XMPushService";
            }
        } catch (Exception unused) {
        }
        this.f215b = "com.xiaomi.xmsf.push.service.XMPushService";
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m360a(Intent intent) {
        try {
            if (!a((String) "startServiceSafely")) {
                if (f.a() || VERSION.SDK_INT < 26) {
                    this.f207a.startService(intent);
                } else {
                    c(intent);
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r12, com.xiaomi.mipush.sdk.am r13, boolean r14, java.util.HashMap<java.lang.String, java.lang.String> r15) {
        /*
            r11 = this;
            android.content.Context r0 = r11.f207a
            com.xiaomi.mipush.sdk.a r0 = com.xiaomi.mipush.sdk.a.a(r0)
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x0155
            android.content.Context r0 = r11.f207a
            boolean r0 = com.xiaomi.push.y.a(r0)
            if (r0 != 0) goto L_0x0016
            goto L_0x0155
        L_0x0016:
            com.xiaomi.push.dt r0 = new com.xiaomi.push.dt
            r0.<init>()
            r1 = 1
            r0.a(r1)
            android.content.Intent r2 = r11.a()
            boolean r3 = android.text.TextUtils.isEmpty(r12)
            r4 = 0
            if (r3 == 0) goto L_0x004b
            java.lang.String r12 = com.xiaomi.push.service.aw.a()
            r0.a(r12)
            if (r14 == 0) goto L_0x0039
            com.xiaomi.push.dt r3 = new com.xiaomi.push.dt
            r3.<init>(r12, r1)
            goto L_0x003a
        L_0x0039:
            r3 = r4
        L_0x003a:
            java.lang.Class<com.xiaomi.mipush.sdk.x> r5 = com.xiaomi.mipush.sdk.x.class
            monitor-enter(r5)
            android.content.Context r6 = r11.f207a     // Catch:{ all -> 0x0048 }
            com.xiaomi.mipush.sdk.x r6 = com.xiaomi.mipush.sdk.x.a(r6)     // Catch:{ all -> 0x0048 }
            r6.a(r12)     // Catch:{ all -> 0x0048 }
            monitor-exit(r5)     // Catch:{ all -> 0x0048 }
            goto L_0x0055
        L_0x0048:
            r12 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0048 }
            throw r12
        L_0x004b:
            r0.a(r12)
            if (r14 == 0) goto L_0x0057
            com.xiaomi.push.dt r3 = new com.xiaomi.push.dt
            r3.<init>(r12, r1)
        L_0x0055:
            r6 = r3
            goto L_0x0058
        L_0x0057:
            r6 = r4
        L_0x0058:
            int[] r3 = com.xiaomi.mipush.sdk.al.f4352a
            int r5 = r13.ordinal()
            r3 = r3[r5]
            switch(r3) {
                case 1: goto L_0x008a;
                case 2: goto L_0x0071;
                case 3: goto L_0x0064;
                case 4: goto L_0x0064;
                case 5: goto L_0x0064;
                case 6: goto L_0x0064;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x00a5
        L_0x0064:
            com.xiaomi.push.df r3 = com.xiaomi.push.df.ThirdPartyRegUpdate
            java.lang.String r3 = r3.f458a
            r0.c(r3)
            if (r15 == 0) goto L_0x00a5
            r0.a(r15)
            goto L_0x00a5
        L_0x0071:
            com.xiaomi.push.df r3 = com.xiaomi.push.df.EnablePushMessage
            java.lang.String r3 = r3.f458a
            r0.c(r3)
            com.xiaomi.push.df r3 = com.xiaomi.push.df.EnablePushMessage
            java.lang.String r3 = r3.f458a
            r6.c(r3)
            if (r15 == 0) goto L_0x0087
            r0.a(r15)
            r6.a(r15)
        L_0x0087:
            java.lang.String r15 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE"
            goto L_0x00a2
        L_0x008a:
            com.xiaomi.push.df r3 = com.xiaomi.push.df.DisablePushMessage
            java.lang.String r3 = r3.f458a
            r0.c(r3)
            com.xiaomi.push.df r3 = com.xiaomi.push.df.DisablePushMessage
            java.lang.String r3 = r3.f458a
            r6.c(r3)
            if (r15 == 0) goto L_0x00a0
            r0.a(r15)
            r6.a(r15)
        L_0x00a0:
            java.lang.String r15 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE"
        L_0x00a2:
            r2.setAction(r15)
        L_0x00a5:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r3 = "type:"
            r15.append(r3)
            r15.append(r13)
            java.lang.String r3 = ", "
            r15.append(r3)
            r15.append(r12)
            java.lang.String r15 = r15.toString()
            com.xiaomi.channel.commonutils.logger.b.e(r15)
            android.content.Context r15 = r11.f207a
            com.xiaomi.mipush.sdk.a r15 = com.xiaomi.mipush.sdk.a.a(r15)
            java.lang.String r15 = r15.a()
            r0.b(r15)
            android.content.Context r15 = r11.f207a
            java.lang.String r15 = r15.getPackageName()
            r0.d(r15)
            com.xiaomi.push.cz r15 = com.xiaomi.push.cz.Notification
            r3 = 0
            r11.a((T) r0, r15, r3, r4)
            if (r14 == 0) goto L_0x013e
            android.content.Context r14 = r11.f207a
            com.xiaomi.mipush.sdk.a r14 = com.xiaomi.mipush.sdk.a.a(r14)
            java.lang.String r14 = r14.a()
            r6.b(r14)
            android.content.Context r14 = r11.f207a
            java.lang.String r14 = r14.getPackageName()
            r6.d(r14)
            android.content.Context r5 = r11.f207a
            com.xiaomi.push.cz r7 = com.xiaomi.push.cz.Notification
            r8 = 0
            java.lang.String r9 = r5.getPackageName()
            android.content.Context r14 = r11.f207a
            com.xiaomi.mipush.sdk.a r14 = com.xiaomi.mipush.sdk.a.a(r14)
            java.lang.String r10 = r14.a()
            com.xiaomi.push.dq r14 = com.xiaomi.mipush.sdk.aa.a(r5, r6, r7, r8, r9, r10)
            byte[] r14 = com.xiaomi.push.ee.a(r14)
            if (r14 == 0) goto L_0x013e
            java.lang.String r15 = "mipush_payload"
            r2.putExtra(r15, r14)
            java.lang.String r14 = "com.xiaomi.mipush.MESSAGE_CACHE"
            r2.putExtra(r14, r1)
            java.lang.String r14 = "mipush_app_id"
            android.content.Context r15 = r11.f207a
            com.xiaomi.mipush.sdk.a r15 = com.xiaomi.mipush.sdk.a.a(r15)
            java.lang.String r15 = r15.a()
            r2.putExtra(r14, r15)
            java.lang.String r14 = "mipush_app_token"
            android.content.Context r15 = r11.f207a
            com.xiaomi.mipush.sdk.a r15 = com.xiaomi.mipush.sdk.a.a(r15)
            java.lang.String r15 = r15.b()
            r2.putExtra(r14, r15)
            r11.b(r2)
        L_0x013e:
            android.os.Message r14 = android.os.Message.obtain()
            r15 = 19
            r14.what = r15
            int r13 = r13.ordinal()
            r14.obj = r12
            r14.arg1 = r13
            android.os.Handler r12 = r11.f209a
            r0 = 5000(0x1388, double:2.4703E-320)
            r12.sendMessageDelayed(r14, r0)
        L_0x0155:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ag.a(java.lang.String, com.xiaomi.mipush.sdk.am, boolean, java.util.HashMap):void");
    }

    private Intent b() {
        if (!"com.xiaomi.xmsf".equals(this.f207a.getPackageName())) {
            return c();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
        return e();
    }

    private void b(Intent intent) {
        if (!a((String) "callService")) {
            int a2 = at.a(this.f207a).a(db.ServiceBootMode.a(), da.START.a());
            int a3 = a();
            boolean z = a2 == da.BIND.a() && f4345b;
            int a4 = (z ? da.BIND : da.START).a();
            if (a4 != a3) {
                a(a4);
            }
            if (z) {
                c(intent);
            } else {
                a(intent);
            }
        }
    }

    private Intent c() {
        if (a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i) {
        this.f207a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private synchronized void c(Intent intent) {
        if (!a((String) "bindServiceSafely")) {
            if (this.f4346c) {
                Message a2 = a(intent);
                if (this.f213a.size() >= 50) {
                    this.f213a.remove(0);
                }
                this.f213a.add(a2);
                return;
            } else if (this.f210a == null) {
                this.f207a.bindService(intent, new ak(this), 1);
                this.f4346c = true;
                this.f213a.clear();
                this.f213a.add(a(intent));
            } else {
                try {
                    this.f210a.send(a(intent));
                } catch (RemoteException unused) {
                    this.f210a = null;
                    this.f4346c = false;
                }
            }
        } else {
            return;
        }
        return;
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m361c() {
        try {
            PackageInfo packageInfo = this.f207a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    private Intent d() {
        Intent intent = new Intent();
        String packageName = this.f207a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", a());
        intent.putExtra("mipush_app_package", packageName);
        g();
        return intent;
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m362d() {
        if (a()) {
            try {
                return this.f207a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f207a.getPackageName();
        h();
        intent.setComponent(new ComponentName(this.f207a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m363e() {
        String packageName = this.f207a.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f207a.getApplicationInfo().flags & 1) != 0;
    }

    private void f() {
        this.f206a = SystemClock.elapsedRealtime();
    }

    private void g() {
        try {
            PackageManager packageManager = this.f207a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f207a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable unused) {
        }
    }

    private void h() {
        try {
            PackageManager packageManager = this.f207a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f207a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m364a() {
        return this.f206a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m365a() {
        a(a());
    }

    public void a(int i) {
        a(i, 0);
    }

    public void a(int i, int i2) {
        Intent a2 = a();
        a2.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        a2.putExtra(bd.C, this.f207a.getPackageName());
        a2.putExtra(bd.D, i);
        a2.putExtra(bd.E, i2);
        b(a2);
    }

    public void a(int i, String str) {
        Intent a2 = a();
        a2.setAction("com.xiaomi.mipush.thirdparty");
        a2.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        a2.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        a(a2);
    }

    public final void a(du duVar, boolean z, boolean z2) {
        this.f208a = null;
        a.a(this.f207a).f195a = duVar.a();
        Intent a2 = a();
        byte[] a3 = ee.a(aa.a(this.f207a, duVar, cz.Registration));
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.a((String) "register fail, because msgBytes is null.");
            return;
        }
        a2.setAction("com.xiaomi.mipush.REGISTER_APP");
        a2.putExtra("mipush_app_id", a.a(this.f207a).a());
        a2.putExtra("mipush_payload", a3);
        a2.putExtra("mipush_session", this.f212a);
        a2.putExtra("mipush_env_chanage", z);
        a2.putExtra("mipush_env_type", a.a(this.f207a).a());
        a2.putExtra("mipush_region_change", z2);
        if (!y.a(this.f207a) || !b()) {
            this.f208a = a2;
        } else {
            f();
            b(a2);
        }
    }

    public final void a(ea eaVar) {
        byte[] a2 = ee.a(aa.a(this.f207a, eaVar, cz.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.a((String) "unregister fail, because msgBytes is null.");
            return;
        }
        Intent a3 = a();
        a3.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        a3.putExtra("mipush_app_id", a.a(this.f207a).a());
        a3.putExtra("mipush_payload", a2);
        b(a3);
    }

    public final <T extends ef<T, ?>> void a(T t, cz czVar, di diVar) {
        a(t, czVar, !czVar.equals(cz.Registration), diVar);
    }

    public <T extends ef<T, ?>> void a(T t, cz czVar, boolean z) {
        a aVar = new a();
        aVar.f216a = t;
        aVar.f4347a = czVar;
        aVar.f217a = z;
        synchronized (f205a) {
            f205a.add(aVar);
            if (f205a.size() > 10) {
                f205a.remove(0);
            }
        }
    }

    public final <T extends ef<T, ?>> void a(T t, cz czVar, boolean z, di diVar) {
        a(t, czVar, z, true, diVar, true);
    }

    public final <T extends ef<T, ?>> void a(T t, cz czVar, boolean z, di diVar, boolean z2) {
        a(t, czVar, z, true, diVar, z2);
    }

    public final <T extends ef<T, ?>> void a(T t, cz czVar, boolean z, boolean z2, di diVar, boolean z3) {
        a(t, czVar, z, z2, diVar, z3, this.f207a.getPackageName(), a.a(this.f207a).a());
    }

    public final <T extends ef<T, ?>> void a(T t, cz czVar, boolean z, boolean z2, di diVar, boolean z3, String str, String str2) {
        a(t, czVar, z, z2, diVar, z3, str, str2, true);
    }

    public final <T extends ef<T, ?>> void a(T t, cz czVar, boolean z, boolean z2, di diVar, boolean z3, String str, String str2, boolean z4) {
        a(t, czVar, z, z2, diVar, z3, str, str2, z4, true);
    }

    public final <T extends ef<T, ?>> void a(T t, cz czVar, boolean z, boolean z2, di diVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        di diVar2 = diVar;
        if (!z5 || a.a(this.f207a).c()) {
            dq a2 = z4 ? aa.a(this.f207a, t, czVar, z, str, str2) : aa.b(this.f207a, t, czVar, z, str, str2);
            if (diVar2 != null) {
                a2.a(diVar);
            }
            byte[] a3 = ee.a(a2);
            if (a3 == null) {
                com.xiaomi.channel.commonutils.logger.b.a((String) "send message fail, because msgBytes is null.");
                return;
            }
            Intent a4 = a();
            a4.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            a4.putExtra("mipush_payload", a3);
            boolean z6 = z3;
            a4.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
            b(a4);
        } else if (z2) {
            a(t, czVar, z);
        } else {
            com.xiaomi.channel.commonutils.logger.b.a((String) "drop the message before initialization.");
        }
    }

    public final void a(String str, am amVar, c cVar) {
        x.a(this.f207a).a(amVar, "syncing");
        a(str, amVar, false, g.a(this.f207a, cVar));
    }

    public void a(String str, String str2) {
        Intent a2 = a();
        a2.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        a2.putExtra(bd.C, this.f207a.getPackageName());
        a2.putExtra(bd.I, str);
        a2.putExtra(bd.J, str2);
        b(a2);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        am amVar;
        if (z) {
            x.a(this.f207a).a(am.DISABLE_PUSH, "syncing");
            x.a(this.f207a).a(am.ENABLE_PUSH, "");
            amVar = am.DISABLE_PUSH;
        } else {
            x.a(this.f207a).a(am.ENABLE_PUSH, "syncing");
            x.a(this.f207a).a(am.DISABLE_PUSH, "");
            amVar = am.ENABLE_PUSH;
        }
        a(str, amVar, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m366a() {
        return this.f214a && 1 == a.a(this.f207a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m367a(int i) {
        if (!a.a(this.f207a).b()) {
            return false;
        }
        c(i);
        dt dtVar = new dt();
        dtVar.a(aw.a());
        dtVar.b(a.a(this.f207a).a());
        dtVar.d(this.f207a.getPackageName());
        dtVar.c(df.ClientABTest.f458a);
        HashMap hashMap = new HashMap();
        dtVar.f595a = hashMap;
        hashMap.put("boot_mode", i + "");
        a(this.f207a).a((T) dtVar, cz.Notification, false, (di) null);
        return true;
    }

    public boolean a(String str) {
        if (!f.a() || this.f214a) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.d("Error,Missing XMSF application in MIUI system. The calling method [" + str + "] was rejected by mipush service.");
        return true;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m368b() {
        Intent a2 = a();
        a2.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        b(a2);
    }

    public void b(int i) {
        Intent a2 = a();
        a2.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        a2.putExtra(bd.C, this.f207a.getPackageName());
        a2.putExtra(bd.F, i);
        String str = bd.H;
        a2.putExtra(str, ac.b(this.f207a.getPackageName() + i));
        b(a2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m369b() {
        if (!a() || !e()) {
            return true;
        }
        if (this.f211a == null) {
            Integer valueOf = Integer.valueOf(bf.a(this.f207a).a());
            this.f211a = valueOf;
            if (valueOf.intValue() == 0) {
                this.f207a.getContentResolver().registerContentObserver(bf.a(this.f207a).a(), false, new aj(this, new Handler(Looper.getMainLooper())));
            }
        }
        return this.f211a.intValue() != 0;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m370c() {
        if (this.f208a != null) {
            f();
            b(this.f208a);
            this.f208a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m371d() {
        synchronized (f205a) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<a> it = f205a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f216a, next.f4347a, next.f217a, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f205a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m372e() {
        Intent a2 = a();
        a2.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        a2.putExtra(bd.C, this.f207a.getPackageName());
        a2.putExtra(bd.H, ac.b(this.f207a.getPackageName()));
        b(a2);
    }
}
