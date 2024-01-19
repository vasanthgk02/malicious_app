package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.config.DefaultConversationConfig;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.by;
import com.xiaomi.push.db;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class n {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile n f4951a;

    /* renamed from: a  reason: collision with other field name */
    public int f916a = -1;

    /* renamed from: a  reason: collision with other field name */
    public long f917a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f918a;

    /* renamed from: a  reason: collision with other field name */
    public final SharedPreferences f919a;

    /* renamed from: a  reason: collision with other field name */
    public String f920a = null;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicInteger f921a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f922a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f4952b = null;

    /* renamed from: b  reason: collision with other field name */
    public final AtomicInteger f923b = new AtomicInteger(0);

    /* renamed from: b  reason: collision with other field name */
    public final boolean f924b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f4953c = new AtomicInteger(0);

    /* renamed from: c  reason: collision with other field name */
    public final boolean f925c;

    public static class a {
        public static String a() {
            return "support_wifi_digest";
        }

        public static String a(String str) {
            return String.format("HB_%s", new Object[]{str});
        }

        public static String b() {
            return "record_support_wifi_digest_reported";
        }

        public static String b(String str) {
            return String.format("HB_dead_time_%s", new Object[]{str});
        }

        public static String c() {
            return "record_hb_count_start";
        }

        public static String d() {
            return "record_short_hb_count";
        }

        public static String e() {
            return "record_long_hb_count";
        }

        public static String f() {
            return "record_hb_change";
        }

        public static String g() {
            return "record_mobile_ptc";
        }

        public static String h() {
            return "record_wifi_ptc";
        }

        public static String i() {
            return "record_ptc_start";
        }

        public static String j() {
            return "keep_short_hb_effective_time";
        }
    }

    public n(Context context) {
        this.f918a = context;
        this.f925c = f.a(context);
        this.f924b = false;
        this.f919a = this.f918a.getSharedPreferences("hb_record", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f919a.getLong(a.c(), -1) == -1) {
            this.f919a.edit().putLong(a.c(), currentTimeMillis).apply();
        }
        long j = this.f919a.getLong(a.i(), -1);
        this.f917a = j;
        if (j == -1) {
            this.f917a = currentTimeMillis;
            this.f919a.edit().putLong(a.i(), currentTimeMillis).apply();
        }
    }

    private int a() {
        if (TextUtils.isEmpty(this.f920a)) {
            return -1;
        }
        try {
            return this.f919a.getInt(a.a(this.f920a), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static n a(Context context) {
        if (f4951a == null) {
            synchronized (n.class) {
                try {
                    if (f4951a == null) {
                        f4951a = new n(context);
                    }
                }
            }
        }
        return f4951a;
    }

    private void a(String str, String str2, Map<String, String> map) {
    }

    private void a(boolean z) {
        if (c()) {
            int incrementAndGet = (z ? this.f923b : this.f4953c).incrementAndGet();
            Object[] objArr = new Object[2];
            Object obj = "short";
            objArr[0] = z ? obj : "long";
            objArr[1] = Integer.valueOf(incrementAndGet);
            b.b(String.format("[HB] %s ping interval count: %s", objArr));
            if (incrementAndGet >= 5) {
                String d2 = z ? a.d() : a.e();
                int i = this.f919a.getInt(d2, 0) + incrementAndGet;
                this.f919a.edit().putInt(d2, i).apply();
                Object[] objArr2 = new Object[2];
                if (!z) {
                    obj = "long";
                }
                objArr2[0] = obj;
                objArr2[1] = Integer.valueOf(i);
                b.a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                (z ? this.f923b : this.f4953c).set(0);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m847a() {
        return this.f921a.get() >= Math.max(5, 3);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    private long b() {
        return this.f919a.getLong(a.j(), -1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "WIFI-ID-UNKNOWN"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0016
            java.lang.String r10 = r9.f920a
            if (r10 == 0) goto L_0x0015
            java.lang.String r0 = "W-"
            boolean r10 = r10.startsWith(r0)
            if (r10 == 0) goto L_0x0015
            goto L_0x0018
        L_0x0015:
            r10 = 0
        L_0x0016:
            r9.f920a = r10
        L_0x0018:
            android.content.SharedPreferences r10 = r9.f919a
            java.lang.String r0 = r9.f920a
            java.lang.String r0 = com.xiaomi.push.service.n.a.a(r0)
            r1 = -1
            int r10 = r10.getInt(r0, r1)
            android.content.SharedPreferences r0 = r9.f919a
            java.lang.String r2 = r9.f920a
            java.lang.String r2 = com.xiaomi.push.service.n.a.b(r2)
            r3 = -1
            long r5 = r0.getLong(r2, r3)
            long r7 = java.lang.System.currentTimeMillis()
            if (r10 == r1) goto L_0x0075
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 != 0) goto L_0x0056
            android.content.SharedPreferences r10 = r9.f919a
            android.content.SharedPreferences$Editor r10 = r10.edit()
            java.lang.String r0 = r9.f920a
            java.lang.String r0 = com.xiaomi.push.service.n.a.b(r0)
            long r2 = r9.c()
            long r7 = r7 + r2
            android.content.SharedPreferences$Editor r10 = r10.putLong(r0, r7)
        L_0x0052:
            r10.apply()
            goto L_0x0075
        L_0x0056:
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 <= 0) goto L_0x0075
            android.content.SharedPreferences r10 = r9.f919a
            android.content.SharedPreferences$Editor r10 = r10.edit()
            java.lang.String r0 = r9.f920a
            java.lang.String r0 = com.xiaomi.push.service.n.a.a(r0)
            android.content.SharedPreferences$Editor r10 = r10.remove(r0)
            java.lang.String r0 = r9.f920a
            java.lang.String r0 = com.xiaomi.push.service.n.a.b(r0)
            android.content.SharedPreferences$Editor r10 = r10.remove(r0)
            goto L_0x0052
        L_0x0075:
            java.util.concurrent.atomic.AtomicInteger r10 = r9.f921a
            r0 = 0
            r10.getAndSet(r0)
            java.lang.String r10 = r9.f920a
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            r2 = 1
            if (r10 != 0) goto L_0x008e
            int r10 = r9.a()
            if (r10 == r1) goto L_0x008b
            goto L_0x008e
        L_0x008b:
            r9.f922a = r2
            goto L_0x0090
        L_0x008e:
            r9.f922a = r0
        L_0x0090:
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.String r1 = r9.f920a
            r10[r0] = r1
            boolean r0 = r9.f922a
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r10[r2] = r0
            java.lang.String r0 = "[HB] network changed, netid:%s, %s"
            java.lang.String r10 = java.lang.String.format(r0, r10)
            com.xiaomi.channel.commonutils.logger.b.a(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.n.b(java.lang.String):void");
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m848b() {
        return !TextUtils.isEmpty(this.f920a) && this.f920a.startsWith("M-");
    }

    private long c() {
        return 777600000;
    }

    private void c(String str) {
        if (a(str)) {
            this.f919a.edit().putInt(a.a(str), 235000).apply();
            this.f919a.edit().putLong(a.b(this.f920a), System.currentTimeMillis() + c()).apply();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m849c() {
        return false;
    }

    private void d(String str) {
        String str2;
        String str3;
        if (c() && !TextUtils.isEmpty(str)) {
            if (str.startsWith("W-")) {
                str2 = "W";
            } else {
                if (str.startsWith("M-")) {
                    str2 = "M";
                }
            }
            String valueOf = String.valueOf(235000);
            String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
            StringBuilder outline82 = GeneratedOutlineSupport.outline82(str, ":::", str2, ":::", valueOf);
            outline82.append(":::");
            outline82.append(valueOf2);
            String string = this.f919a.getString(a.f(), null);
            if (TextUtils.isEmpty(string)) {
                str3 = outline82.toString();
            } else {
                StringBuilder outline78 = GeneratedOutlineSupport.outline78(string, "###");
                outline78.append(outline82.toString());
                str3 = outline78.toString();
            }
            this.f919a.edit().putString(a.f(), str3).apply();
        }
    }

    private boolean d() {
        return this.f925c && (this.f924b || ((b() > System.currentTimeMillis() ? 1 : (b() == System.currentTimeMillis() ? 0 : -1)) >= 0));
    }

    private void e() {
        if (!this.f919a.getBoolean(a.a(), false)) {
            this.f919a.edit().putBoolean(a.a(), true).apply();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m850e() {
        long j = this.f919a.getLong(a.c(), -1);
        if (j == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return j > currentTimeMillis || currentTimeMillis - j >= DefaultConversationConfig.ACTIVE_CONV_WINDOW;
    }

    private void f() {
        int i = this.f916a;
        String h = i != 0 ? i != 1 ? null : a.h() : a.g();
        if (!TextUtils.isEmpty(h)) {
            if (this.f919a.getLong(a.i(), -1) == -1) {
                this.f917a = System.currentTimeMillis();
                this.f919a.edit().putLong(a.i(), this.f917a).apply();
            }
            this.f919a.edit().putInt(h, this.f919a.getInt(h, 0) + 1).apply();
        }
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m851f() {
        if (this.f917a == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f917a;
        return j > currentTimeMillis || currentTimeMillis - j >= DefaultConversationConfig.ACTIVE_CONV_WINDOW;
    }

    private void g() {
        int i;
        if (c()) {
            String string = this.f919a.getString(a.f(), null);
            char c2 = 1;
            char c3 = 0;
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split("###");
                if (split != null) {
                    int i2 = 0;
                    while (i2 < split.length) {
                        if (!TextUtils.isEmpty(split[i2])) {
                            String[] split2 = split[i2].split(":::");
                            if (split2 != null && split2.length >= 4) {
                                String str = split2[c3];
                                String str2 = split2[c2];
                                String str3 = split2[2];
                                String str4 = split2[3];
                                HashMap outline87 = GeneratedOutlineSupport.outline87("event", "change");
                                outline87.put("model", Build.MODEL);
                                outline87.put("net_type", str2);
                                outline87.put("net_name", str);
                                outline87.put("interval", str3);
                                outline87.put("timestamp", str4);
                                a("category_hb_change", null, outline87);
                                b.a((String) "[HB] report hb changed events.");
                            }
                        }
                        i2++;
                        c2 = 1;
                        c3 = 0;
                    }
                    this.f919a.edit().remove(a.f()).apply();
                }
            }
            if (this.f919a.getBoolean(a.a(), false) && !this.f919a.getBoolean(a.b(), false)) {
                HashMap outline872 = GeneratedOutlineSupport.outline87("event", "support");
                outline872.put("model", Build.MODEL);
                outline872.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                a("category_hb_change", null, outline872);
                b.a((String) "[HB] report support wifi digest events.");
                this.f919a.edit().putBoolean(a.b(), true).apply();
            }
            if (e()) {
                int i3 = this.f919a.getInt(a.d(), 0);
                int i4 = this.f919a.getInt(a.e(), 0);
                if (i3 > 0 || i4 > 0) {
                    long j = this.f919a.getLong(a.c(), -1);
                    String valueOf = String.valueOf(235000);
                    String valueOf2 = String.valueOf(j);
                    String valueOf3 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("interval", valueOf);
                        jSONObject.put("c_short", String.valueOf(i3));
                        jSONObject.put("c_long", String.valueOf(i4));
                        jSONObject.put("count", String.valueOf(i3 + i4));
                        jSONObject.put("start_time", valueOf2);
                        jSONObject.put("end_time", valueOf3);
                        String jSONObject2 = jSONObject.toString();
                        HashMap hashMap = new HashMap();
                        hashMap.put("event", "long_and_short_hb_count");
                        a("category_hb_count", jSONObject2, hashMap);
                        b.a((String) "[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f919a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (f()) {
                String valueOf4 = String.valueOf(this.f917a);
                String valueOf5 = String.valueOf(System.currentTimeMillis());
                int i5 = this.f919a.getInt(a.g(), 0);
                if (i5 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("net_type", "M");
                        jSONObject3.put("ptc", i5);
                        jSONObject3.put("start_time", valueOf4);
                        jSONObject3.put("end_time", valueOf5);
                        String jSONObject4 = jSONObject3.toString();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject4, hashMap2);
                        b.a((String) "[HB] report ping timeout count events of mobile network.");
                        this.f919a.edit().putInt(a.g(), 0).apply();
                    } catch (Throwable unused2) {
                        i = 0;
                        this.f919a.edit().putInt(a.g(), 0).apply();
                    }
                }
                i = 0;
                int i6 = this.f919a.getInt(a.h(), i);
                if (i6 > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("net_type", "W");
                        jSONObject5.put("ptc", i6);
                        jSONObject5.put("start_time", valueOf4);
                        jSONObject5.put("end_time", valueOf5);
                        String jSONObject6 = jSONObject5.toString();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject6, hashMap3);
                        b.a((String) "[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f919a.edit().putInt(a.h(), 0).apply();
                }
                this.f917a = System.currentTimeMillis();
                this.f919a.edit().putLong(a.i(), this.f917a).apply();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m852a() {
        long b2 = (long) by.b();
        boolean z = true;
        if (this.f925c && !b() && (at.a(this.f918a).a(db.IntelligentHeartbeatSwitchBoolean.a(), true) || b() >= System.currentTimeMillis())) {
            int a2 = a();
            if (a2 != -1) {
                b2 = (long) a2;
            }
        }
        if (!TextUtils.isEmpty(this.f920a) && !"WIFI-ID-UNKNOWN".equals(this.f920a) && this.f916a == 1) {
            if (b2 >= 300000) {
                z = false;
            }
            a(z);
        }
        b.a("[HB] ping interval:" + b2);
        return b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m853a() {
    }

    public void a(int i) {
        this.f919a.edit().putLong(a.j(), System.currentTimeMillis() + ((long) (i * 1000))).apply();
    }

    public synchronized void a(NetworkInfo networkInfo) {
        if (d()) {
            String str = null;
            if (networkInfo == null) {
                b(null);
            } else if (networkInfo.getType() == 0) {
                String subtypeName = networkInfo.getSubtypeName();
                if (!TextUtils.isEmpty(subtypeName) && !"UNKNOWN".equalsIgnoreCase(subtypeName)) {
                    str = "M-" + subtypeName;
                }
                b(str);
                this.f916a = 0;
            } else {
                if (networkInfo.getType() != 1) {
                    if (networkInfo.getType() != 6) {
                        b(null);
                    }
                }
                b("WIFI-ID-UNKNOWN");
                this.f916a = 1;
            }
            this.f916a = -1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m854a(String str) {
        if (!TextUtils.isEmpty(str)) {
            e();
        }
        if (d() && !TextUtils.isEmpty(str)) {
            b("W-" + str);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m855b() {
        if (d()) {
            f();
            if (this.f922a && !TextUtils.isEmpty(this.f920a) && this.f920a.equals(this.f4952b)) {
                this.f921a.getAndIncrement();
                b.a("[HB] ping timeout count:" + this.f921a);
                if (a()) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("[HB] change hb interval for net:");
                    outline73.append(this.f920a);
                    b.a(outline73.toString());
                    c(this.f920a);
                    this.f922a = false;
                    this.f921a.getAndSet(0);
                    d(this.f920a);
                }
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m856c() {
        if (d()) {
            this.f4952b = this.f920a;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m857d() {
        if (d()) {
            g();
            if (this.f922a) {
                this.f921a.getAndSet(0);
            }
        }
    }
}
