package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class dl implements ef<dl, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4654a = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f513a = new eu("XmPushActionAckMessage");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4655b = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4656c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4657d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4658e = new em("", 10, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4659f = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 6);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7);
    public static final em h = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 8);
    public static final em i = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 9);
    public static final em j = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10);
    public static final em k = new em("", 2, 11);
    public static final em l = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 12);
    public static final em m = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 13);
    public static final em n = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 14);
    public static final em o = new em("", 6, 15);
    public static final em p = new em("", 6, 16);
    public static final em q = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 20);
    public static final em r = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 21);
    public static final em s = new em("", 8, 22);
    public static final em t = new em("", 13, 23);

    /* renamed from: a  reason: collision with other field name */
    public int f514a;

    /* renamed from: a  reason: collision with other field name */
    public long f515a;

    /* renamed from: a  reason: collision with other field name */
    public dk f516a;

    /* renamed from: a  reason: collision with other field name */
    public dx f517a;

    /* renamed from: a  reason: collision with other field name */
    public String f518a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f519a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f520a;

    /* renamed from: a  reason: collision with other field name */
    public short f521a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f522a = false;

    /* renamed from: b  reason: collision with other field name */
    public String f523b;

    /* renamed from: b  reason: collision with other field name */
    public short f524b;

    /* renamed from: c  reason: collision with other field name */
    public String f525c;

    /* renamed from: d  reason: collision with other field name */
    public String f526d;

    /* renamed from: e  reason: collision with other field name */
    public String f527e;

    /* renamed from: f  reason: collision with other field name */
    public String f528f;

    /* renamed from: g  reason: collision with other field name */
    public String f529g;

    /* renamed from: h  reason: collision with other field name */
    public String f530h;

    /* renamed from: i  reason: collision with other field name */
    public String f531i;

    /* renamed from: j  reason: collision with other field name */
    public String f532j;

    /* renamed from: k  reason: collision with other field name */
    public String f533k;

    /* renamed from: l  reason: collision with other field name */
    public String f534l;

    /* renamed from: a */
    public int compareTo(dl dlVar) {
        if (!dl.class.equals(dlVar.getClass())) {
            return dl.class.getName().compareTo(dl.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(dlVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f518a, dlVar.f518a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(dlVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a((Comparable) this.f516a, (Comparable) dlVar.f516a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(dlVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f523b, dlVar.f523b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(dlVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f525c, dlVar.f525c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(dlVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f515a, dlVar.f515a);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(dlVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f526d, dlVar.f526d);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(dlVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f527e, dlVar.f527e);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(dlVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h()) {
            int a9 = eg.a((Comparable) this.f517a, (Comparable) dlVar.f517a);
            if (a9 != 0) {
                return a9;
            }
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(dlVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i()) {
            int a10 = eg.a(this.f528f, dlVar.f528f);
            if (a10 != 0) {
                return a10;
            }
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(dlVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j()) {
            int a11 = eg.a(this.f529g, dlVar.f529g);
            if (a11 != 0) {
                return a11;
            }
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(dlVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k()) {
            int a12 = eg.a(this.f522a, dlVar.f522a);
            if (a12 != 0) {
                return a12;
            }
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(dlVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l()) {
            int a13 = eg.a(this.f530h, dlVar.f530h);
            if (a13 != 0) {
                return a13;
            }
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(dlVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m()) {
            int a14 = eg.a(this.f531i, dlVar.f531i);
            if (a14 != 0) {
                return a14;
            }
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(dlVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n()) {
            int a15 = eg.a(this.f532j, dlVar.f532j);
            if (a15 != 0) {
                return a15;
            }
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(dlVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o()) {
            int a16 = eg.a(this.f521a, dlVar.f521a);
            if (a16 != 0) {
                return a16;
            }
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(dlVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p()) {
            int a17 = eg.a(this.f524b, dlVar.f524b);
            if (a17 != 0) {
                return a17;
            }
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(dlVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q()) {
            int a18 = eg.a(this.f533k, dlVar.f533k);
            if (a18 != 0) {
                return a18;
            }
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(dlVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r()) {
            int a19 = eg.a(this.f534l, dlVar.f534l);
            if (a19 != 0) {
                return a19;
            }
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(dlVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s()) {
            int a20 = eg.a(this.f514a, dlVar.f514a);
            if (a20 != 0) {
                return a20;
            }
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(dlVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (t()) {
            int a21 = eg.a((Map) this.f520a, (Map) dlVar.f520a);
            if (a21 != 0) {
                return a21;
            }
        }
        return 0;
    }

    public dl a(long j2) {
        this.f515a = j2;
        a(true);
        return this;
    }

    public dl a(String str) {
        this.f523b = str;
        return this;
    }

    public dl a(short s2) {
        this.f521a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f523b == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'id' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        } else if (this.f525c == null) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Required field 'appId' was not present! Struct: ");
            outline732.append(toString());
            throw new eq(outline732.toString());
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.xiaomi.push.ep r8) {
        /*
            r7 = this;
            r8.a()
        L_0x0003:
            com.xiaomi.push.em r0 = r8.a()
            byte r1 = r0.f4765a
            if (r1 != 0) goto L_0x002f
            r8.f()
            boolean r8 = r7.e()
            if (r8 == 0) goto L_0x0018
            r7.a()
            return
        L_0x0018:
            com.xiaomi.push.eq r8 = new com.xiaomi.push.eq
            java.lang.String r0 = "Required field 'messageTs' was not found in serialized data! Struct: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = r7.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L_0x002f:
            short r0 = r0.f755a
            r2 = 6
            r3 = 2
            r4 = 12
            r5 = 1
            r6 = 11
            switch(r0) {
                case 1: goto L_0x0130;
                case 2: goto L_0x0123;
                case 3: goto L_0x011a;
                case 4: goto L_0x0111;
                case 5: goto L_0x0103;
                case 6: goto L_0x00fa;
                case 7: goto L_0x00f1;
                case 8: goto L_0x00e4;
                case 9: goto L_0x00db;
                case 10: goto L_0x00d2;
                case 11: goto L_0x00c5;
                case 12: goto L_0x00bb;
                case 13: goto L_0x00b1;
                case 14: goto L_0x00a7;
                case 15: goto L_0x009a;
                case 16: goto L_0x008d;
                case 17: goto L_0x003b;
                case 18: goto L_0x003b;
                case 19: goto L_0x003b;
                case 20: goto L_0x0083;
                case 21: goto L_0x0079;
                case 22: goto L_0x006a;
                case 23: goto L_0x003d;
                default: goto L_0x003b;
            }
        L_0x003b:
            goto L_0x0139
        L_0x003d:
            r0 = 13
            if (r1 != r0) goto L_0x0139
            com.xiaomi.push.eo r0 = r8.a()
            java.util.HashMap r1 = new java.util.HashMap
            int r2 = r0.f757a
            int r2 = r2 * 2
            r1.<init>(r2)
            r7.f520a = r1
            r1 = 0
        L_0x0051:
            int r2 = r0.f757a
            if (r1 >= r2) goto L_0x0065
            java.lang.String r2 = r8.a()
            java.lang.String r3 = r8.a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r7.f520a
            r4.put(r2, r3)
            int r1 = r1 + 1
            goto L_0x0051
        L_0x0065:
            r8.h()
            goto L_0x013c
        L_0x006a:
            r0 = 8
            if (r1 != r0) goto L_0x0139
            int r0 = r8.a()
            r7.f514a = r0
            r7.e(r5)
            goto L_0x013c
        L_0x0079:
            if (r1 != r6) goto L_0x0139
            java.lang.String r0 = r8.a()
            r7.f534l = r0
            goto L_0x013c
        L_0x0083:
            if (r1 != r6) goto L_0x0139
            java.lang.String r0 = r8.a()
            r7.f533k = r0
            goto L_0x013c
        L_0x008d:
            if (r1 != r2) goto L_0x0139
            short r0 = r8.a()
            r7.f524b = r0
            r7.d(r5)
            goto L_0x013c
        L_0x009a:
            if (r1 != r2) goto L_0x0139
            short r0 = r8.a()
            r7.f521a = r0
            r7.c(r5)
            goto L_0x013c
        L_0x00a7:
            if (r1 != r6) goto L_0x0139
            java.lang.String r0 = r8.a()
            r7.f532j = r0
            goto L_0x013c
        L_0x00b1:
            if (r1 != r6) goto L_0x0139
            java.lang.String r0 = r8.a()
            r7.f531i = r0
            goto L_0x013c
        L_0x00bb:
            if (r1 != r6) goto L_0x0139
            java.lang.String r0 = r8.a()
            r7.f530h = r0
            goto L_0x013c
        L_0x00c5:
            if (r1 != r3) goto L_0x0139
            boolean r0 = r8.a()
            r7.f522a = r0
            r7.b(r5)
            goto L_0x013c
        L_0x00d2:
            if (r1 != r6) goto L_0x0139
            java.lang.String r0 = r8.a()
            r7.f529g = r0
            goto L_0x013c
        L_0x00db:
            if (r1 != r6) goto L_0x0139
            java.lang.String r0 = r8.a()
            r7.f528f = r0
            goto L_0x013c
        L_0x00e4:
            if (r1 != r4) goto L_0x0139
            com.xiaomi.push.dx r0 = new com.xiaomi.push.dx
            r0.<init>()
            r7.f517a = r0
            r0.a(r8)
            goto L_0x013c
        L_0x00f1:
            if (r1 != r6) goto L_0x0139
            java.lang.String r0 = r8.a()
            r7.f527e = r0
            goto L_0x013c
        L_0x00fa:
            if (r1 != r6) goto L_0x0139
            java.lang.String r0 = r8.a()
            r7.f526d = r0
            goto L_0x013c
        L_0x0103:
            r0 = 10
            if (r1 != r0) goto L_0x0139
            long r0 = r8.a()
            r7.f515a = r0
            r7.a(r5)
            goto L_0x013c
        L_0x0111:
            if (r1 != r6) goto L_0x0139
            java.lang.String r0 = r8.a()
            r7.f525c = r0
            goto L_0x013c
        L_0x011a:
            if (r1 != r6) goto L_0x0139
            java.lang.String r0 = r8.a()
            r7.f523b = r0
            goto L_0x013c
        L_0x0123:
            if (r1 != r4) goto L_0x0139
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r7.f516a = r0
            r0.a(r8)
            goto L_0x013c
        L_0x0130:
            if (r1 != r6) goto L_0x0139
            java.lang.String r0 = r8.a()
            r7.f518a = r0
            goto L_0x013c
        L_0x0139:
            com.xiaomi.push.es.a(r8, r1)
        L_0x013c:
            r8.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dl.a(com.xiaomi.push.ep):void");
    }

    public void a(boolean z) {
        this.f519a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m624a() {
        return this.f518a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m625a(dl dlVar) {
        if (dlVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = dlVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f518a.equals(dlVar.f518a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = dlVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f516a.compareTo(dlVar.f516a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dlVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f523b.equals(dlVar.f523b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dlVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f525c.equals(dlVar.f525c))) || this.f515a != dlVar.f515a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dlVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f526d.equals(dlVar.f526d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dlVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f527e.equals(dlVar.f527e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dlVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f517a.compareTo(dlVar.f517a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dlVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f528f.equals(dlVar.f528f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = dlVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f529g.equals(dlVar.f529g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = dlVar.k();
        if ((k2 || k3) && (!k2 || !k3 || this.f522a != dlVar.f522a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = dlVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.f530h.equals(dlVar.f530h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = dlVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.f531i.equals(dlVar.f531i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = dlVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.f532j.equals(dlVar.f532j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = dlVar.o();
        if ((o2 || o3) && (!o2 || !o3 || this.f521a != dlVar.f521a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = dlVar.p();
        if ((p2 || p3) && (!p2 || !p3 || this.f524b != dlVar.f524b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = dlVar.q();
        if ((q2 || q3) && (!q2 || !q3 || !this.f533k.equals(dlVar.f533k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = dlVar.r();
        if ((r2 || r3) && (!r2 || !r3 || !this.f534l.equals(dlVar.f534l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = dlVar.s();
        if ((s2 || s3) && (!s2 || !s3 || this.f514a != dlVar.f514a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = dlVar.t();
        return (!t2 && !t3) || (t2 && t3 && this.f520a.equals(dlVar.f520a));
    }

    public dl b(String str) {
        this.f525c = str;
        return this;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f513a);
        if (this.f518a != null && a()) {
            epVar.a(f4654a);
            epVar.a(this.f518a);
            epVar.b();
        }
        if (this.f516a != null && b()) {
            epVar.a(f4655b);
            this.f516a.b(epVar);
            epVar.b();
        }
        if (this.f523b != null) {
            epVar.a(f4656c);
            epVar.a(this.f523b);
            epVar.b();
        }
        if (this.f525c != null) {
            epVar.a(f4657d);
            epVar.a(this.f525c);
            epVar.b();
        }
        epVar.a(f4658e);
        epVar.a(this.f515a);
        epVar.b();
        if (this.f526d != null && f()) {
            epVar.a(f4659f);
            epVar.a(this.f526d);
            epVar.b();
        }
        if (this.f527e != null && g()) {
            epVar.a(g);
            epVar.a(this.f527e);
            epVar.b();
        }
        if (this.f517a != null && h()) {
            epVar.a(h);
            this.f517a.b(epVar);
            epVar.b();
        }
        if (this.f528f != null && i()) {
            epVar.a(i);
            epVar.a(this.f528f);
            epVar.b();
        }
        if (this.f529g != null && j()) {
            epVar.a(j);
            epVar.a(this.f529g);
            epVar.b();
        }
        if (k()) {
            epVar.a(k);
            epVar.a(this.f522a);
            epVar.b();
        }
        if (this.f530h != null && l()) {
            epVar.a(l);
            epVar.a(this.f530h);
            epVar.b();
        }
        if (this.f531i != null && m()) {
            epVar.a(m);
            epVar.a(this.f531i);
            epVar.b();
        }
        if (this.f532j != null && n()) {
            epVar.a(n);
            epVar.a(this.f532j);
            epVar.b();
        }
        if (o()) {
            epVar.a(o);
            epVar.a(this.f521a);
            epVar.b();
        }
        if (p()) {
            epVar.a(p);
            epVar.a(this.f524b);
            epVar.b();
        }
        if (this.f533k != null && q()) {
            epVar.a(q);
            epVar.a(this.f533k);
            epVar.b();
        }
        if (this.f534l != null && r()) {
            epVar.a(r);
            epVar.a(this.f534l);
            epVar.b();
        }
        if (s()) {
            epVar.a(s);
            epVar.a(this.f514a);
            epVar.b();
        }
        if (this.f520a != null && t()) {
            epVar.a(t);
            epVar.a(new eo(MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, this.f520a.size()));
            for (Entry next : this.f520a.entrySet()) {
                epVar.a((String) next.getKey());
                epVar.a((String) next.getValue());
            }
            epVar.d();
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public void b(boolean z) {
        this.f519a.set(1, z);
    }

    public boolean b() {
        return this.f516a != null;
    }

    public dl c(String str) {
        this.f526d = str;
        return this;
    }

    public void c(boolean z) {
        this.f519a.set(2, z);
    }

    public boolean c() {
        return this.f523b != null;
    }

    public dl d(String str) {
        this.f527e = str;
        return this;
    }

    public void d(boolean z) {
        this.f519a.set(3, z);
    }

    public boolean d() {
        return this.f525c != null;
    }

    public void e(boolean z) {
        this.f519a.set(4, z);
    }

    public boolean e() {
        return this.f519a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dl)) {
            return compareTo((dl) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f526d != null;
    }

    public boolean g() {
        return this.f527e != null;
    }

    public boolean h() {
        return this.f517a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f528f != null;
    }

    public boolean j() {
        return this.f529g != null;
    }

    public boolean k() {
        return this.f519a.get(1);
    }

    public boolean l() {
        return this.f530h != null;
    }

    public boolean m() {
        return this.f531i != null;
    }

    public boolean n() {
        return this.f532j != null;
    }

    public boolean o() {
        return this.f519a.get(2);
    }

    public boolean p() {
        return this.f519a.get(3);
    }

    public boolean q() {
        return this.f533k != null;
    }

    public boolean r() {
        return this.f534l != null;
    }

    public boolean s() {
        return this.f519a.get(4);
    }

    public boolean t() {
        return this.f520a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.f518a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            dk dkVar = this.f516a;
            if (dkVar == null) {
                sb.append("null");
            } else {
                sb.append(dkVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f523b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f525c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f515a);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f526d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f527e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            dx dxVar = this.f517a;
            if (dxVar == null) {
                sb.append("null");
            } else {
                sb.append(dxVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f528f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f529g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f522a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f530h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f531i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f532j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append(this.f521a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append(this.f524b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f533k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f534l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f514a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f520a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
