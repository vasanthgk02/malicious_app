package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.push.service.aw;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class di implements ef<di, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4639a = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f488a = new eu("PushMetaInfo");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4640b = new em("", 10, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4641c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4642d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4643e = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4644f = new em("", 8, 6);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7);
    public static final em h = new em("", 8, 8);
    public static final em i = new em("", 8, 9);
    public static final em j = new em("", 13, 10);
    public static final em k = new em("", 13, 11);
    public static final em l = new em("", 2, 12);
    public static final em m = new em("", 13, 13);

    /* renamed from: a  reason: collision with other field name */
    public int f489a;

    /* renamed from: a  reason: collision with other field name */
    public long f490a;

    /* renamed from: a  reason: collision with other field name */
    public String f491a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f492a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f493a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f494a;

    /* renamed from: b  reason: collision with other field name */
    public int f495b;

    /* renamed from: b  reason: collision with other field name */
    public String f496b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f497b;

    /* renamed from: c  reason: collision with other field name */
    public int f498c;

    /* renamed from: c  reason: collision with other field name */
    public String f499c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f500c;

    /* renamed from: d  reason: collision with other field name */
    public String f501d;

    /* renamed from: e  reason: collision with other field name */
    public String f502e;

    public di() {
        this.f492a = new BitSet(5);
        this.f494a = false;
    }

    public di(di diVar) {
        BitSet bitSet = new BitSet(5);
        this.f492a = bitSet;
        bitSet.clear();
        this.f492a.or(diVar.f492a);
        if (diVar.a()) {
            this.f491a = diVar.f491a;
        }
        this.f490a = diVar.f490a;
        if (diVar.c()) {
            this.f496b = diVar.f496b;
        }
        if (diVar.d()) {
            this.f499c = diVar.f499c;
        }
        if (diVar.e()) {
            this.f501d = diVar.f501d;
        }
        this.f489a = diVar.f489a;
        if (diVar.g()) {
            this.f502e = diVar.f502e;
        }
        this.f495b = diVar.f495b;
        this.f498c = diVar.f498c;
        if (diVar.j()) {
            HashMap hashMap = new HashMap();
            for (Entry next : diVar.f493a.entrySet()) {
                hashMap.put((String) next.getKey(), (String) next.getValue());
            }
            this.f493a = hashMap;
        }
        if (diVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Entry next2 : diVar.f497b.entrySet()) {
                hashMap2.put((String) next2.getKey(), (String) next2.getValue());
            }
            this.f497b = hashMap2;
        }
        this.f494a = diVar.f494a;
        if (diVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Entry next3 : diVar.f500c.entrySet()) {
                hashMap3.put((String) next3.getKey(), (String) next3.getValue());
            }
            this.f500c = hashMap3;
        }
    }

    public int a() {
        return this.f489a;
    }

    /* renamed from: a */
    public int compareTo(di diVar) {
        if (!di.class.equals(diVar.getClass())) {
            return di.class.getName().compareTo(di.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(diVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f491a, diVar.f491a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(diVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a(this.f490a, diVar.f490a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(diVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f496b, diVar.f496b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(diVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f499c, diVar.f499c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(diVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f501d, diVar.f501d);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(diVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f489a, diVar.f489a);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(diVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f502e, diVar.f502e);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(diVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h()) {
            int a9 = eg.a(this.f495b, diVar.f495b);
            if (a9 != 0) {
                return a9;
            }
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(diVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i()) {
            int a10 = eg.a(this.f498c, diVar.f498c);
            if (a10 != 0) {
                return a10;
            }
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(diVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j()) {
            int a11 = eg.a((Map) this.f493a, (Map) diVar.f493a);
            if (a11 != 0) {
                return a11;
            }
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(diVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k()) {
            int a12 = eg.a((Map) this.f497b, (Map) diVar.f497b);
            if (a12 != 0) {
                return a12;
            }
        }
        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(diVar.m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m()) {
            int a13 = eg.a(this.f494a, diVar.f494a);
            if (a13 != 0) {
                return a13;
            }
        }
        int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(diVar.n()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (n()) {
            int a14 = eg.a((Map) this.f500c, (Map) diVar.f500c);
            if (a14 != 0) {
                return a14;
            }
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m609a() {
        return this.f490a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public di m610a() {
        return new di(this);
    }

    public di a(int i2) {
        this.f489a = i2;
        b(true);
        return this;
    }

    public di a(String str) {
        this.f491a = str;
        return this;
    }

    public di a(Map<String, String> map) {
        this.f493a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m611a() {
        return this.f491a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m612a() {
        return this.f493a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m613a() {
        if (this.f491a == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'id' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00bb, code lost:
        r9.h();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.xiaomi.push.ep r9) {
        /*
            r8 = this;
            r9.a()
        L_0x0003:
            com.xiaomi.push.em r0 = r9.a()
            byte r1 = r0.f4765a
            if (r1 != 0) goto L_0x002f
            r9.f()
            boolean r9 = r8.b()
            if (r9 == 0) goto L_0x0018
            r8.a()
            return
        L_0x0018:
            com.xiaomi.push.eq r9 = new com.xiaomi.push.eq
            java.lang.String r0 = "Required field 'messageTs' was not found in serialized data! Struct: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = r8.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L_0x002f:
            short r0 = r0.f755a
            r2 = 0
            r3 = 13
            r4 = 8
            r5 = 2
            r6 = 11
            r7 = 1
            switch(r0) {
                case 1: goto L_0x0116;
                case 2: goto L_0x0108;
                case 3: goto L_0x00ff;
                case 4: goto L_0x00f6;
                case 5: goto L_0x00ed;
                case 6: goto L_0x00e1;
                case 7: goto L_0x00d8;
                case 8: goto L_0x00cc;
                case 9: goto L_0x00c0;
                case 10: goto L_0x0096;
                case 11: goto L_0x0071;
                case 12: goto L_0x0064;
                case 13: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x011f
        L_0x003f:
            if (r1 != r3) goto L_0x011f
            com.xiaomi.push.eo r0 = r9.a()
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r0.f757a
            int r3 = r3 * 2
            r1.<init>(r3)
            r8.f500c = r1
        L_0x0050:
            int r1 = r0.f757a
            if (r2 >= r1) goto L_0x00bb
            java.lang.String r1 = r9.a()
            java.lang.String r3 = r9.a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r8.f500c
            r4.put(r1, r3)
            int r2 = r2 + 1
            goto L_0x0050
        L_0x0064:
            if (r1 != r5) goto L_0x011f
            boolean r0 = r9.a()
            r8.f494a = r0
            r8.e(r7)
            goto L_0x0122
        L_0x0071:
            if (r1 != r3) goto L_0x011f
            com.xiaomi.push.eo r0 = r9.a()
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r0.f757a
            int r3 = r3 * 2
            r1.<init>(r3)
            r8.f497b = r1
        L_0x0082:
            int r1 = r0.f757a
            if (r2 >= r1) goto L_0x00bb
            java.lang.String r1 = r9.a()
            java.lang.String r3 = r9.a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r8.f497b
            r4.put(r1, r3)
            int r2 = r2 + 1
            goto L_0x0082
        L_0x0096:
            if (r1 != r3) goto L_0x011f
            com.xiaomi.push.eo r0 = r9.a()
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r0.f757a
            int r3 = r3 * 2
            r1.<init>(r3)
            r8.f493a = r1
        L_0x00a7:
            int r1 = r0.f757a
            if (r2 >= r1) goto L_0x00bb
            java.lang.String r1 = r9.a()
            java.lang.String r3 = r9.a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r8.f493a
            r4.put(r1, r3)
            int r2 = r2 + 1
            goto L_0x00a7
        L_0x00bb:
            r9.h()
            goto L_0x0122
        L_0x00c0:
            if (r1 != r4) goto L_0x011f
            int r0 = r9.a()
            r8.f498c = r0
            r8.d(r7)
            goto L_0x0122
        L_0x00cc:
            if (r1 != r4) goto L_0x011f
            int r0 = r9.a()
            r8.f495b = r0
            r8.c(r7)
            goto L_0x0122
        L_0x00d8:
            if (r1 != r6) goto L_0x011f
            java.lang.String r0 = r9.a()
            r8.f502e = r0
            goto L_0x0122
        L_0x00e1:
            if (r1 != r4) goto L_0x011f
            int r0 = r9.a()
            r8.f489a = r0
            r8.b(r7)
            goto L_0x0122
        L_0x00ed:
            if (r1 != r6) goto L_0x011f
            java.lang.String r0 = r9.a()
            r8.f501d = r0
            goto L_0x0122
        L_0x00f6:
            if (r1 != r6) goto L_0x011f
            java.lang.String r0 = r9.a()
            r8.f499c = r0
            goto L_0x0122
        L_0x00ff:
            if (r1 != r6) goto L_0x011f
            java.lang.String r0 = r9.a()
            r8.f496b = r0
            goto L_0x0122
        L_0x0108:
            r0 = 10
            if (r1 != r0) goto L_0x011f
            long r0 = r9.a()
            r8.f490a = r0
            r8.a(r7)
            goto L_0x0122
        L_0x0116:
            if (r1 != r6) goto L_0x011f
            java.lang.String r0 = r9.a()
            r8.f491a = r0
            goto L_0x0122
        L_0x011f:
            com.xiaomi.push.es.a(r9, r1)
        L_0x0122:
            r9.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.di.a(com.xiaomi.push.ep):void");
    }

    public void a(String str, String str2) {
        if (this.f493a == null) {
            this.f493a = new HashMap();
        }
        this.f493a.put(str, str2);
    }

    public void a(boolean z) {
        this.f492a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m614a() {
        return this.f491a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m615a(di diVar) {
        if (diVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = diVar.a();
        if (((a2 || a3) && (!a2 || !a3 || !this.f491a.equals(diVar.f491a))) || this.f490a != diVar.f490a) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = diVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f496b.equals(diVar.f496b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = diVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f499c.equals(diVar.f499c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = diVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f501d.equals(diVar.f501d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = diVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f489a != diVar.f489a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = diVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f502e.equals(diVar.f502e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = diVar.h();
        if ((h2 || h3) && (!h2 || !h3 || this.f495b != diVar.f495b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = diVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.f498c != diVar.f498c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = diVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f493a.equals(diVar.f493a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = diVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f497b.equals(diVar.f497b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = diVar.m();
        if ((m2 || m3) && (!m2 || !m3 || this.f494a != diVar.f494a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = diVar.n();
        return (!n && !n2) || (n && n2 && this.f500c.equals(diVar.f500c));
    }

    public int b() {
        return this.f495b;
    }

    public di b(int i2) {
        this.f495b = i2;
        c(true);
        return this;
    }

    public di b(String str) {
        this.f496b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m616b() {
        return this.f496b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m617b() {
        return this.f497b;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f488a);
        if (this.f491a != null) {
            epVar.a(f4639a);
            epVar.a(this.f491a);
            epVar.b();
        }
        epVar.a(f4640b);
        epVar.a(this.f490a);
        epVar.b();
        if (this.f496b != null && c()) {
            epVar.a(f4641c);
            epVar.a(this.f496b);
            epVar.b();
        }
        if (this.f499c != null && d()) {
            epVar.a(f4642d);
            epVar.a(this.f499c);
            epVar.b();
        }
        if (this.f501d != null && e()) {
            epVar.a(f4643e);
            epVar.a(this.f501d);
            epVar.b();
        }
        if (f()) {
            epVar.a(f4644f);
            epVar.a(this.f489a);
            epVar.b();
        }
        if (this.f502e != null && g()) {
            epVar.a(g);
            epVar.a(this.f502e);
            epVar.b();
        }
        if (h()) {
            epVar.a(h);
            epVar.a(this.f495b);
            epVar.b();
        }
        if (i()) {
            epVar.a(i);
            epVar.a(this.f498c);
            epVar.b();
        }
        if (this.f493a != null && j()) {
            epVar.a(j);
            epVar.a(new eo(MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, this.f493a.size()));
            for (Entry next : this.f493a.entrySet()) {
                epVar.a((String) next.getKey());
                epVar.a((String) next.getValue());
            }
            epVar.d();
            epVar.b();
        }
        if (this.f497b != null && k()) {
            epVar.a(k);
            epVar.a(new eo(MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, this.f497b.size()));
            for (Entry next2 : this.f497b.entrySet()) {
                epVar.a((String) next2.getKey());
                epVar.a((String) next2.getValue());
            }
            epVar.d();
            epVar.b();
        }
        if (m()) {
            epVar.a(l);
            epVar.a(this.f494a);
            epVar.b();
        }
        if (this.f500c != null && n()) {
            epVar.a(m);
            epVar.a(new eo(MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, this.f500c.size()));
            for (Entry next3 : this.f500c.entrySet()) {
                epVar.a((String) next3.getKey());
                epVar.a((String) next3.getValue());
            }
            epVar.d();
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public void b(boolean z) {
        this.f492a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m618b() {
        return this.f492a.get(0);
    }

    public int c() {
        return this.f498c;
    }

    public di c(int i2) {
        this.f498c = i2;
        d(true);
        return this;
    }

    public di c(String str) {
        this.f499c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m619c() {
        return this.f499c;
    }

    public void c(boolean z) {
        this.f492a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m620c() {
        return this.f496b != null;
    }

    public di d(String str) {
        this.f501d = str;
        return this;
    }

    public String d() {
        return this.f501d;
    }

    public void d(boolean z) {
        this.f492a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m621d() {
        return this.f499c != null;
    }

    public void e(boolean z) {
        this.f492a.set(4, z);
    }

    public boolean e() {
        return this.f501d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof di)) {
            return compareTo((di) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f492a.get(1);
    }

    public boolean g() {
        return this.f502e != null;
    }

    public boolean h() {
        return this.f492a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f492a.get(3);
    }

    public boolean j() {
        return this.f493a != null;
    }

    public boolean k() {
        return this.f497b != null;
    }

    public boolean l() {
        return this.f494a;
    }

    public boolean m() {
        return this.f492a.get(4);
    }

    public boolean n() {
        return this.f500c != null;
    }

    public String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("PushMetaInfo(", "id:");
        String str = this.f491a;
        if (str == null) {
            outline77.append("null");
        } else {
            outline77.append(aw.a(str));
        }
        outline77.append(", ");
        outline77.append("messageTs:");
        outline77.append(this.f490a);
        if (c()) {
            outline77.append(", ");
            outline77.append("topic:");
            String str2 = this.f496b;
            if (str2 == null) {
                outline77.append("null");
            } else {
                outline77.append(str2);
            }
        }
        if (d()) {
            outline77.append(", ");
            outline77.append("title:");
            String str3 = this.f499c;
            if (str3 == null) {
                outline77.append("null");
            } else {
                outline77.append(str3);
            }
        }
        if (e()) {
            outline77.append(", ");
            outline77.append("description:");
            String str4 = this.f501d;
            if (str4 == null) {
                outline77.append("null");
            } else {
                outline77.append(str4);
            }
        }
        if (f()) {
            outline77.append(", ");
            outline77.append("notifyType:");
            outline77.append(this.f489a);
        }
        if (g()) {
            outline77.append(", ");
            outline77.append("url:");
            String str5 = this.f502e;
            if (str5 == null) {
                outline77.append("null");
            } else {
                outline77.append(str5);
            }
        }
        if (h()) {
            outline77.append(", ");
            outline77.append("passThrough:");
            outline77.append(this.f495b);
        }
        if (i()) {
            outline77.append(", ");
            outline77.append("notifyId:");
            outline77.append(this.f498c);
        }
        if (j()) {
            outline77.append(", ");
            outline77.append("extra:");
            Map<String, String> map = this.f493a;
            if (map == null) {
                outline77.append("null");
            } else {
                outline77.append(map);
            }
        }
        if (k()) {
            outline77.append(", ");
            outline77.append("internal:");
            Map<String, String> map2 = this.f497b;
            if (map2 == null) {
                outline77.append("null");
            } else {
                outline77.append(map2);
            }
        }
        if (m()) {
            outline77.append(", ");
            outline77.append("ignoreRegInfo:");
            outline77.append(this.f494a);
        }
        if (n()) {
            outline77.append(", ");
            outline77.append("apsProperFields:");
            Map<String, String> map3 = this.f500c;
            if (map3 == null) {
                outline77.append("null");
            } else {
                outline77.append(map3);
            }
        }
        outline77.append(")");
        return outline77.toString();
    }
}
