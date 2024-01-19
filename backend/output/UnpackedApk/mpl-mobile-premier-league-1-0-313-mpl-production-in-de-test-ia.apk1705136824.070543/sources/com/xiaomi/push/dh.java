package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.BitSet;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class dh implements ef<dh, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4633a = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f468a = new eu("PushMessage");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4634b = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4635c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4636d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4637e = new em("", 10, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4638f = new em("", 10, 6);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7);
    public static final em h = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 8);
    public static final em i = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 9);
    public static final em j = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10);
    public static final em k = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 11);
    public static final em l = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 12);
    public static final em m = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 13);
    public static final em n = new em("", 2, 14);
    public static final em o = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 15);
    public static final em p = new em("", 10, 16);
    public static final em q = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 20);
    public static final em r = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 21);

    /* renamed from: a  reason: collision with other field name */
    public long f469a;

    /* renamed from: a  reason: collision with other field name */
    public di f470a;

    /* renamed from: a  reason: collision with other field name */
    public dk f471a;

    /* renamed from: a  reason: collision with other field name */
    public String f472a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f473a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f474a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f475b;

    /* renamed from: b  reason: collision with other field name */
    public String f476b;

    /* renamed from: c  reason: collision with other field name */
    public long f477c;

    /* renamed from: c  reason: collision with other field name */
    public String f478c;

    /* renamed from: d  reason: collision with other field name */
    public String f479d;

    /* renamed from: e  reason: collision with other field name */
    public String f480e;

    /* renamed from: f  reason: collision with other field name */
    public String f481f;

    /* renamed from: g  reason: collision with other field name */
    public String f482g;

    /* renamed from: h  reason: collision with other field name */
    public String f483h;

    /* renamed from: i  reason: collision with other field name */
    public String f484i;

    /* renamed from: j  reason: collision with other field name */
    public String f485j;

    /* renamed from: k  reason: collision with other field name */
    public String f486k;

    /* renamed from: l  reason: collision with other field name */
    public String f487l;

    /* renamed from: a */
    public int compareTo(dh dhVar) {
        if (!dh.class.equals(dhVar.getClass())) {
            return dh.class.getName().compareTo(dh.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(dhVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a((Comparable) this.f471a, (Comparable) dhVar.f471a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(dhVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a(this.f472a, dhVar.f472a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(dhVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f476b, dhVar.f476b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(dhVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f478c, dhVar.f478c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(dhVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f469a, dhVar.f469a);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(dhVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f475b, dhVar.f475b);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(dhVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f479d, dhVar.f479d);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(dhVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h()) {
            int a9 = eg.a(this.f480e, dhVar.f480e);
            if (a9 != 0) {
                return a9;
            }
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(dhVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i()) {
            int a10 = eg.a(this.f481f, dhVar.f481f);
            if (a10 != 0) {
                return a10;
            }
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(dhVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j()) {
            int a11 = eg.a(this.f482g, dhVar.f482g);
            if (a11 != 0) {
                return a11;
            }
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(dhVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k()) {
            int a12 = eg.a(this.f483h, dhVar.f483h);
            if (a12 != 0) {
                return a12;
            }
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(dhVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l()) {
            int a13 = eg.a((Comparable) this.f470a, (Comparable) dhVar.f470a);
            if (a13 != 0) {
                return a13;
            }
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(dhVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m()) {
            int a14 = eg.a(this.f484i, dhVar.f484i);
            if (a14 != 0) {
                return a14;
            }
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(dhVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n()) {
            int a15 = eg.a(this.f474a, dhVar.f474a);
            if (a15 != 0) {
                return a15;
            }
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(dhVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o()) {
            int a16 = eg.a(this.f485j, dhVar.f485j);
            if (a16 != 0) {
                return a16;
            }
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(dhVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p()) {
            int a17 = eg.a(this.f477c, dhVar.f477c);
            if (a17 != 0) {
                return a17;
            }
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(dhVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q()) {
            int a18 = eg.a(this.f486k, dhVar.f486k);
            if (a18 != 0) {
                return a18;
            }
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(dhVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r()) {
            int a19 = eg.a(this.f487l, dhVar.f487l);
            if (a19 != 0) {
                return a19;
            }
        }
        return 0;
    }

    public long a() {
        return this.f469a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m603a() {
        return this.f472a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m604a() {
        if (this.f472a == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'id' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        } else if (this.f476b == null) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Required field 'appId' was not present! Struct: ");
            outline732.append(toString());
            throw new eq(outline732.toString());
        } else if (this.f478c == null) {
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("Required field 'payload' was not present! Struct: ");
            outline733.append(toString());
            throw new eq(outline733.toString());
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.xiaomi.push.ep r7) {
        /*
            r6 = this;
            r7.a()
        L_0x0003:
            com.xiaomi.push.em r0 = r7.a()
            byte r1 = r0.f4765a
            if (r1 != 0) goto L_0x0012
            r7.f()
            r6.a()
            return
        L_0x0012:
            short r0 = r0.f755a
            r2 = 20
            r3 = 11
            if (r0 == r2) goto L_0x00e1
            r2 = 21
            if (r0 == r2) goto L_0x00d8
            r2 = 12
            r4 = 10
            r5 = 1
            switch(r0) {
                case 1: goto L_0x00cb;
                case 2: goto L_0x00c2;
                case 3: goto L_0x00b9;
                case 4: goto L_0x00b0;
                case 5: goto L_0x00a4;
                case 6: goto L_0x0098;
                case 7: goto L_0x008f;
                case 8: goto L_0x0086;
                case 9: goto L_0x007c;
                case 10: goto L_0x0072;
                case 11: goto L_0x0068;
                case 12: goto L_0x005a;
                case 13: goto L_0x0050;
                case 14: goto L_0x0042;
                case 15: goto L_0x0038;
                case 16: goto L_0x002b;
                default: goto L_0x0026;
            }
        L_0x0026:
            com.xiaomi.push.es.a(r7, r1)
            goto L_0x00e9
        L_0x002b:
            if (r1 != r4) goto L_0x0026
            long r0 = r7.a()
            r6.f477c = r0
            r6.d(r5)
            goto L_0x00e9
        L_0x0038:
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.a()
            r6.f485j = r0
            goto L_0x00e9
        L_0x0042:
            r0 = 2
            if (r1 != r0) goto L_0x0026
            boolean r0 = r7.a()
            r6.f474a = r0
            r6.c(r5)
            goto L_0x00e9
        L_0x0050:
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.a()
            r6.f484i = r0
            goto L_0x00e9
        L_0x005a:
            if (r1 != r2) goto L_0x0026
            com.xiaomi.push.di r0 = new com.xiaomi.push.di
            r0.<init>()
            r6.f470a = r0
            r0.a(r7)
            goto L_0x00e9
        L_0x0068:
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.a()
            r6.f483h = r0
            goto L_0x00e9
        L_0x0072:
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.a()
            r6.f482g = r0
            goto L_0x00e9
        L_0x007c:
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.a()
            r6.f481f = r0
            goto L_0x00e9
        L_0x0086:
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.a()
            r6.f480e = r0
            goto L_0x00e9
        L_0x008f:
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.a()
            r6.f479d = r0
            goto L_0x00e9
        L_0x0098:
            if (r1 != r4) goto L_0x0026
            long r0 = r7.a()
            r6.f475b = r0
            r6.b(r5)
            goto L_0x00e9
        L_0x00a4:
            if (r1 != r4) goto L_0x0026
            long r0 = r7.a()
            r6.f469a = r0
            r6.a(r5)
            goto L_0x00e9
        L_0x00b0:
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.a()
            r6.f478c = r0
            goto L_0x00e9
        L_0x00b9:
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.a()
            r6.f476b = r0
            goto L_0x00e9
        L_0x00c2:
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.a()
            r6.f472a = r0
            goto L_0x00e9
        L_0x00cb:
            if (r1 != r2) goto L_0x0026
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r6.f471a = r0
            r0.a(r7)
            goto L_0x00e9
        L_0x00d8:
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.a()
            r6.f487l = r0
            goto L_0x00e9
        L_0x00e1:
            if (r1 != r3) goto L_0x0026
            java.lang.String r0 = r7.a()
            r6.f486k = r0
        L_0x00e9:
            r7.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dh.a(com.xiaomi.push.ep):void");
    }

    public void a(boolean z) {
        this.f473a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m605a() {
        return this.f471a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m606a(dh dhVar) {
        if (dhVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = dhVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f471a.compareTo(dhVar.f471a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = dhVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f472a.equals(dhVar.f472a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dhVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f476b.equals(dhVar.f476b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dhVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f478c.equals(dhVar.f478c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = dhVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f469a != dhVar.f469a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dhVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f475b != dhVar.f475b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dhVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f479d.equals(dhVar.f479d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dhVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f480e.equals(dhVar.f480e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dhVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f481f.equals(dhVar.f481f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = dhVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f482g.equals(dhVar.f482g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = dhVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f483h.equals(dhVar.f483h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = dhVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.f470a.compareTo(dhVar.f470a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = dhVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.f484i.equals(dhVar.f484i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = dhVar.n();
        if ((n2 || n3) && (!n2 || !n3 || this.f474a != dhVar.f474a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = dhVar.o();
        if ((o2 || o3) && (!o2 || !o3 || !this.f485j.equals(dhVar.f485j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = dhVar.p();
        if ((p2 || p3) && (!p2 || !p3 || this.f477c != dhVar.f477c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = dhVar.q();
        if ((q2 || q3) && (!q2 || !q3 || !this.f486k.equals(dhVar.f486k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = dhVar.r();
        return (!r2 && !r3) || (r2 && r3 && this.f487l.equals(dhVar.f487l));
    }

    public String b() {
        return this.f476b;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f468a);
        if (this.f471a != null && a()) {
            epVar.a(f4633a);
            this.f471a.b(epVar);
            epVar.b();
        }
        if (this.f472a != null) {
            epVar.a(f4634b);
            epVar.a(this.f472a);
            epVar.b();
        }
        if (this.f476b != null) {
            epVar.a(f4635c);
            epVar.a(this.f476b);
            epVar.b();
        }
        if (this.f478c != null) {
            epVar.a(f4636d);
            epVar.a(this.f478c);
            epVar.b();
        }
        if (e()) {
            epVar.a(f4637e);
            epVar.a(this.f469a);
            epVar.b();
        }
        if (f()) {
            epVar.a(f4638f);
            epVar.a(this.f475b);
            epVar.b();
        }
        if (this.f479d != null && g()) {
            epVar.a(g);
            epVar.a(this.f479d);
            epVar.b();
        }
        if (this.f480e != null && h()) {
            epVar.a(h);
            epVar.a(this.f480e);
            epVar.b();
        }
        if (this.f481f != null && i()) {
            epVar.a(i);
            epVar.a(this.f481f);
            epVar.b();
        }
        if (this.f482g != null && j()) {
            epVar.a(j);
            epVar.a(this.f482g);
            epVar.b();
        }
        if (this.f483h != null && k()) {
            epVar.a(k);
            epVar.a(this.f483h);
            epVar.b();
        }
        if (this.f470a != null && l()) {
            epVar.a(l);
            this.f470a.b(epVar);
            epVar.b();
        }
        if (this.f484i != null && m()) {
            epVar.a(m);
            epVar.a(this.f484i);
            epVar.b();
        }
        if (n()) {
            epVar.a(n);
            epVar.a(this.f474a);
            epVar.b();
        }
        if (this.f485j != null && o()) {
            epVar.a(o);
            epVar.a(this.f485j);
            epVar.b();
        }
        if (p()) {
            epVar.a(p);
            epVar.a(this.f477c);
            epVar.b();
        }
        if (this.f486k != null && q()) {
            epVar.a(q);
            epVar.a(this.f486k);
            epVar.b();
        }
        if (this.f487l != null && r()) {
            epVar.a(r);
            epVar.a(this.f487l);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public void b(boolean z) {
        this.f473a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m607b() {
        return this.f472a != null;
    }

    public String c() {
        return this.f478c;
    }

    public void c(boolean z) {
        this.f473a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m608c() {
        return this.f476b != null;
    }

    public void d(boolean z) {
        this.f473a.set(3, z);
    }

    public boolean d() {
        return this.f478c != null;
    }

    public boolean e() {
        return this.f473a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dh)) {
            return compareTo((dh) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f473a.get(1);
    }

    public boolean g() {
        return this.f479d != null;
    }

    public boolean h() {
        return this.f480e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f481f != null;
    }

    public boolean j() {
        return this.f482g != null;
    }

    public boolean k() {
        return this.f483h != null;
    }

    public boolean l() {
        return this.f470a != null;
    }

    public boolean m() {
        return this.f484i != null;
    }

    public boolean n() {
        return this.f473a.get(2);
    }

    public boolean o() {
        return this.f485j != null;
    }

    public boolean p() {
        return this.f473a.get(3);
    }

    public boolean q() {
        return this.f486k != null;
    }

    public boolean r() {
        return this.f487l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (a()) {
            sb.append("to:");
            dk dkVar = this.f471a;
            if (dkVar == null) {
                sb.append("null");
            } else {
                sb.append(dkVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f472a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f476b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f478c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f469a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f475b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.f479d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f480e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f481f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f482g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.f483h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            di diVar = this.f470a;
            if (diVar == null) {
                sb.append("null");
            } else {
                sb.append(diVar);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f484i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f474a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f485j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f477c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f486k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f487l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
