package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.push.service.aw;
import java.io.Serializable;
import java.util.BitSet;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class dv implements ef<dv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4700a = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f637a = new eu("XmPushActionRegistrationResult");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4701b = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4702c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4703d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4704e = new em("", 10, 6);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4705f = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 8);
    public static final em h = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 9);
    public static final em i = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10);
    public static final em j = new em("", 10, 11);
    public static final em k = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 12);
    public static final em l = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 13);
    public static final em m = new em("", 10, 14);
    public static final em n = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 15);
    public static final em o = new em("", 8, 16);
    public static final em p = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 17);
    public static final em q = new em("", 8, 18);
    public static final em r = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 19);

    /* renamed from: a  reason: collision with other field name */
    public int f638a;

    /* renamed from: a  reason: collision with other field name */
    public long f639a;

    /* renamed from: a  reason: collision with other field name */
    public dk f640a;

    /* renamed from: a  reason: collision with other field name */
    public String f641a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f642a = new BitSet(5);

    /* renamed from: b  reason: collision with other field name */
    public int f643b;

    /* renamed from: b  reason: collision with other field name */
    public long f644b;

    /* renamed from: b  reason: collision with other field name */
    public String f645b;

    /* renamed from: c  reason: collision with other field name */
    public long f646c;

    /* renamed from: c  reason: collision with other field name */
    public String f647c;

    /* renamed from: d  reason: collision with other field name */
    public String f648d;

    /* renamed from: e  reason: collision with other field name */
    public String f649e;

    /* renamed from: f  reason: collision with other field name */
    public String f650f;

    /* renamed from: g  reason: collision with other field name */
    public String f651g;

    /* renamed from: h  reason: collision with other field name */
    public String f652h;

    /* renamed from: i  reason: collision with other field name */
    public String f653i;

    /* renamed from: j  reason: collision with other field name */
    public String f654j;

    /* renamed from: k  reason: collision with other field name */
    public String f655k;

    /* renamed from: l  reason: collision with other field name */
    public String f656l;

    /* renamed from: a */
    public int compareTo(dv dvVar) {
        if (!dv.class.equals(dvVar.getClass())) {
            return dv.class.getName().compareTo(dv.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(dvVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f641a, dvVar.f641a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(dvVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a((Comparable) this.f640a, (Comparable) dvVar.f640a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(dvVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f645b, dvVar.f645b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(dvVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f647c, dvVar.f647c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(dvVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f639a, dvVar.f639a);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(dvVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f648d, dvVar.f648d);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(dvVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f649e, dvVar.f649e);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(dvVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h()) {
            int a9 = eg.a(this.f650f, dvVar.f650f);
            if (a9 != 0) {
                return a9;
            }
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(dvVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i()) {
            int a10 = eg.a(this.f651g, dvVar.f651g);
            if (a10 != 0) {
                return a10;
            }
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(dvVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j()) {
            int a11 = eg.a(this.f644b, dvVar.f644b);
            if (a11 != 0) {
                return a11;
            }
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(dvVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k()) {
            int a12 = eg.a(this.f652h, dvVar.f652h);
            if (a12 != 0) {
                return a12;
            }
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(dvVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l()) {
            int a13 = eg.a(this.f653i, dvVar.f653i);
            if (a13 != 0) {
                return a13;
            }
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(dvVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m()) {
            int a14 = eg.a(this.f646c, dvVar.f646c);
            if (a14 != 0) {
                return a14;
            }
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(dvVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n()) {
            int a15 = eg.a(this.f654j, dvVar.f654j);
            if (a15 != 0) {
                return a15;
            }
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(dvVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o()) {
            int a16 = eg.a(this.f638a, dvVar.f638a);
            if (a16 != 0) {
                return a16;
            }
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(dvVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p()) {
            int a17 = eg.a(this.f655k, dvVar.f655k);
            if (a17 != 0) {
                return a17;
            }
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(dvVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q()) {
            int a18 = eg.a(this.f643b, dvVar.f643b);
            if (a18 != 0) {
                return a18;
            }
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(dvVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r()) {
            int a19 = eg.a(this.f656l, dvVar.f656l);
            if (a19 != 0) {
                return a19;
            }
        }
        return 0;
    }

    public long a() {
        return this.f639a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m671a() {
        return this.f645b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m672a() {
        if (this.f645b == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'id' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        } else if (this.f647c == null) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Required field 'appId' was not present! Struct: ");
            outline732.append(toString());
            throw new eq(outline732.toString());
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
            if (r1 != 0) goto L_0x002f
            r7.f()
            boolean r7 = r6.e()
            if (r7 == 0) goto L_0x0018
            r6.a()
            return
        L_0x0018:
            com.xiaomi.push.eq r7 = new com.xiaomi.push.eq
            java.lang.String r0 = "Required field 'errorCode' was not found in serialized data! Struct: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x002f:
            short r0 = r0.f755a
            r2 = 8
            r3 = 10
            r4 = 1
            r5 = 11
            switch(r0) {
                case 1: goto L_0x00f3;
                case 2: goto L_0x00e4;
                case 3: goto L_0x00db;
                case 4: goto L_0x00d2;
                case 5: goto L_0x003b;
                case 6: goto L_0x00c6;
                case 7: goto L_0x00bd;
                case 8: goto L_0x00b4;
                case 9: goto L_0x00ab;
                case 10: goto L_0x00a2;
                case 11: goto L_0x0096;
                case 12: goto L_0x008c;
                case 13: goto L_0x0082;
                case 14: goto L_0x0075;
                case 15: goto L_0x006b;
                case 16: goto L_0x005e;
                case 17: goto L_0x0054;
                case 18: goto L_0x0047;
                case 19: goto L_0x003d;
                default: goto L_0x003b;
            }
        L_0x003b:
            goto L_0x00fc
        L_0x003d:
            if (r1 != r5) goto L_0x00fc
            java.lang.String r0 = r7.a()
            r6.f656l = r0
            goto L_0x00ff
        L_0x0047:
            if (r1 != r2) goto L_0x00fc
            int r0 = r7.a()
            r6.f643b = r0
            r6.e(r4)
            goto L_0x00ff
        L_0x0054:
            if (r1 != r5) goto L_0x00fc
            java.lang.String r0 = r7.a()
            r6.f655k = r0
            goto L_0x00ff
        L_0x005e:
            if (r1 != r2) goto L_0x00fc
            int r0 = r7.a()
            r6.f638a = r0
            r6.d(r4)
            goto L_0x00ff
        L_0x006b:
            if (r1 != r5) goto L_0x00fc
            java.lang.String r0 = r7.a()
            r6.f654j = r0
            goto L_0x00ff
        L_0x0075:
            if (r1 != r3) goto L_0x00fc
            long r0 = r7.a()
            r6.f646c = r0
            r6.c(r4)
            goto L_0x00ff
        L_0x0082:
            if (r1 != r5) goto L_0x00fc
            java.lang.String r0 = r7.a()
            r6.f653i = r0
            goto L_0x00ff
        L_0x008c:
            if (r1 != r5) goto L_0x00fc
            java.lang.String r0 = r7.a()
            r6.f652h = r0
            goto L_0x00ff
        L_0x0096:
            if (r1 != r3) goto L_0x00fc
            long r0 = r7.a()
            r6.f644b = r0
            r6.b(r4)
            goto L_0x00ff
        L_0x00a2:
            if (r1 != r5) goto L_0x00fc
            java.lang.String r0 = r7.a()
            r6.f651g = r0
            goto L_0x00ff
        L_0x00ab:
            if (r1 != r5) goto L_0x00fc
            java.lang.String r0 = r7.a()
            r6.f650f = r0
            goto L_0x00ff
        L_0x00b4:
            if (r1 != r5) goto L_0x00fc
            java.lang.String r0 = r7.a()
            r6.f649e = r0
            goto L_0x00ff
        L_0x00bd:
            if (r1 != r5) goto L_0x00fc
            java.lang.String r0 = r7.a()
            r6.f648d = r0
            goto L_0x00ff
        L_0x00c6:
            if (r1 != r3) goto L_0x00fc
            long r0 = r7.a()
            r6.f639a = r0
            r6.a(r4)
            goto L_0x00ff
        L_0x00d2:
            if (r1 != r5) goto L_0x00fc
            java.lang.String r0 = r7.a()
            r6.f647c = r0
            goto L_0x00ff
        L_0x00db:
            if (r1 != r5) goto L_0x00fc
            java.lang.String r0 = r7.a()
            r6.f645b = r0
            goto L_0x00ff
        L_0x00e4:
            r0 = 12
            if (r1 != r0) goto L_0x00fc
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r6.f640a = r0
            r0.a(r7)
            goto L_0x00ff
        L_0x00f3:
            if (r1 != r5) goto L_0x00fc
            java.lang.String r0 = r7.a()
            r6.f641a = r0
            goto L_0x00ff
        L_0x00fc:
            com.xiaomi.push.es.a(r7, r1)
        L_0x00ff:
            r7.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dv.a(com.xiaomi.push.ep):void");
    }

    public void a(boolean z) {
        this.f642a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m673a() {
        return this.f641a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m674a(dv dvVar) {
        if (dvVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = dvVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f641a.equals(dvVar.f641a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = dvVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f640a.compareTo(dvVar.f640a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dvVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f645b.equals(dvVar.f645b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dvVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f647c.equals(dvVar.f647c))) || this.f639a != dvVar.f639a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dvVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f648d.equals(dvVar.f648d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dvVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f649e.equals(dvVar.f649e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dvVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f650f.equals(dvVar.f650f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dvVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f651g.equals(dvVar.f651g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = dvVar.j();
        if ((j2 || j3) && (!j2 || !j3 || this.f644b != dvVar.f644b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = dvVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f652h.equals(dvVar.f652h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = dvVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.f653i.equals(dvVar.f653i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = dvVar.m();
        if ((m2 || m3) && (!m2 || !m3 || this.f646c != dvVar.f646c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = dvVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.f654j.equals(dvVar.f654j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = dvVar.o();
        if ((o2 || o3) && (!o2 || !o3 || this.f638a != dvVar.f638a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = dvVar.p();
        if ((p2 || p3) && (!p2 || !p3 || !this.f655k.equals(dvVar.f655k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = dvVar.q();
        if ((q2 || q3) && (!q2 || !q3 || this.f643b != dvVar.f643b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = dvVar.r();
        return (!r2 && !r3) || (r2 && r3 && this.f656l.equals(dvVar.f656l));
    }

    public String b() {
        return this.f650f;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f637a);
        if (this.f641a != null && a()) {
            epVar.a(f4700a);
            epVar.a(this.f641a);
            epVar.b();
        }
        if (this.f640a != null && b()) {
            epVar.a(f4701b);
            this.f640a.b(epVar);
            epVar.b();
        }
        if (this.f645b != null) {
            epVar.a(f4702c);
            epVar.a(this.f645b);
            epVar.b();
        }
        if (this.f647c != null) {
            epVar.a(f4703d);
            epVar.a(this.f647c);
            epVar.b();
        }
        epVar.a(f4704e);
        epVar.a(this.f639a);
        epVar.b();
        if (this.f648d != null && f()) {
            epVar.a(f4705f);
            epVar.a(this.f648d);
            epVar.b();
        }
        if (this.f649e != null && g()) {
            epVar.a(g);
            epVar.a(this.f649e);
            epVar.b();
        }
        if (this.f650f != null && h()) {
            epVar.a(h);
            epVar.a(this.f650f);
            epVar.b();
        }
        if (this.f651g != null && i()) {
            epVar.a(i);
            epVar.a(this.f651g);
            epVar.b();
        }
        if (j()) {
            epVar.a(j);
            epVar.a(this.f644b);
            epVar.b();
        }
        if (this.f652h != null && k()) {
            epVar.a(k);
            epVar.a(this.f652h);
            epVar.b();
        }
        if (this.f653i != null && l()) {
            epVar.a(l);
            epVar.a(this.f653i);
            epVar.b();
        }
        if (m()) {
            epVar.a(m);
            epVar.a(this.f646c);
            epVar.b();
        }
        if (this.f654j != null && n()) {
            epVar.a(n);
            epVar.a(this.f654j);
            epVar.b();
        }
        if (o()) {
            epVar.a(o);
            epVar.a(this.f638a);
            epVar.b();
        }
        if (this.f655k != null && p()) {
            epVar.a(p);
            epVar.a(this.f655k);
            epVar.b();
        }
        if (q()) {
            epVar.a(q);
            epVar.a(this.f643b);
            epVar.b();
        }
        if (this.f656l != null && r()) {
            epVar.a(r);
            epVar.a(this.f656l);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public void b(boolean z) {
        this.f642a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m675b() {
        return this.f640a != null;
    }

    public String c() {
        return this.f651g;
    }

    public void c(boolean z) {
        this.f642a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m676c() {
        return this.f645b != null;
    }

    public void d(boolean z) {
        this.f642a.set(3, z);
    }

    public boolean d() {
        return this.f647c != null;
    }

    public void e(boolean z) {
        this.f642a.set(4, z);
    }

    public boolean e() {
        return this.f642a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dv)) {
            return compareTo((dv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f648d != null;
    }

    public boolean g() {
        return this.f649e != null;
    }

    public boolean h() {
        return this.f650f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f651g != null;
    }

    public boolean j() {
        return this.f642a.get(1);
    }

    public boolean k() {
        return this.f652h != null;
    }

    public boolean l() {
        return this.f653i != null;
    }

    public boolean m() {
        return this.f642a.get(2);
    }

    public boolean n() {
        return this.f654j != null;
    }

    public boolean o() {
        return this.f642a.get(3);
    }

    public boolean p() {
        return this.f655k != null;
    }

    public boolean q() {
        return this.f642a.get(4);
    }

    public boolean r() {
        return this.f656l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.f641a;
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
            dk dkVar = this.f640a;
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
        String str2 = this.f645b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(aw.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f647c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f639a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f648d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f649e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f651g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f644b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str7 = this.f652h;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            String str8 = this.f653i;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f646c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str9 = this.f654j;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f638a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str10 = this.f655k;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f643b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            String str11 = this.f656l;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
