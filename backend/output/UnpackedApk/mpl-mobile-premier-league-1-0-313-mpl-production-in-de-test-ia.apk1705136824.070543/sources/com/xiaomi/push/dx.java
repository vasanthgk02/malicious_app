package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class dx implements ef<dx, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4712a = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f666a = new eu("XmPushActionSendMessage");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4713b = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4714c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4715d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4716e = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4717f = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 6);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7);
    public static final em h = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 8);
    public static final em i = new em("", 2, 9);
    public static final em j = new em("", 13, 10);
    public static final em k = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 11);
    public static final em l = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 12);

    /* renamed from: a  reason: collision with other field name */
    public dh f667a;

    /* renamed from: a  reason: collision with other field name */
    public dk f668a;

    /* renamed from: a  reason: collision with other field name */
    public String f669a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f670a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f671a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f672a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f673b;

    /* renamed from: c  reason: collision with other field name */
    public String f674c;

    /* renamed from: d  reason: collision with other field name */
    public String f675d;

    /* renamed from: e  reason: collision with other field name */
    public String f676e;

    /* renamed from: f  reason: collision with other field name */
    public String f677f;

    /* renamed from: g  reason: collision with other field name */
    public String f678g;

    /* renamed from: h  reason: collision with other field name */
    public String f679h;

    /* renamed from: a */
    public int compareTo(dx dxVar) {
        if (!dx.class.equals(dxVar.getClass())) {
            return dx.class.getName().compareTo(dx.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(dxVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f669a, dxVar.f669a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(dxVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a((Comparable) this.f668a, (Comparable) dxVar.f668a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(dxVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f673b, dxVar.f673b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(dxVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f674c, dxVar.f674c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(dxVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f675d, dxVar.f675d);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(dxVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f676e, dxVar.f676e);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(dxVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f677f, dxVar.f677f);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(dxVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h()) {
            int a9 = eg.a((Comparable) this.f667a, (Comparable) dxVar.f667a);
            if (a9 != 0) {
                return a9;
            }
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(dxVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i()) {
            int a10 = eg.a(this.f672a, dxVar.f672a);
            if (a10 != 0) {
                return a10;
            }
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(dxVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j()) {
            int a11 = eg.a((Map) this.f671a, (Map) dxVar.f671a);
            if (a11 != 0) {
                return a11;
            }
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(dxVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k()) {
            int a12 = eg.a(this.f678g, dxVar.f678g);
            if (a12 != 0) {
                return a12;
            }
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(dxVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l()) {
            int a13 = eg.a(this.f679h, dxVar.f679h);
            if (a13 != 0) {
                return a13;
            }
        }
        return 0;
    }

    public dh a() {
        return this.f667a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m679a() {
        return this.f673b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m680a() {
        if (this.f673b == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'id' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        } else if (this.f674c == null) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Required field 'appId' was not present! Struct: ");
            outline732.append(toString());
            throw new eq(outline732.toString());
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.xiaomi.push.ep r6) {
        /*
            r5 = this;
            r6.a()
        L_0x0003:
            com.xiaomi.push.em r0 = r6.a()
            byte r1 = r0.f4765a
            if (r1 != 0) goto L_0x0012
            r6.f()
            r5.a()
            return
        L_0x0012:
            short r0 = r0.f755a
            r2 = 2
            r3 = 12
            r4 = 11
            switch(r0) {
                case 1: goto L_0x00b5;
                case 2: goto L_0x00a8;
                case 3: goto L_0x009f;
                case 4: goto L_0x0096;
                case 5: goto L_0x008d;
                case 6: goto L_0x0084;
                case 7: goto L_0x007b;
                case 8: goto L_0x006e;
                case 9: goto L_0x0061;
                case 10: goto L_0x0035;
                case 11: goto L_0x002b;
                case 12: goto L_0x0021;
                default: goto L_0x001c;
            }
        L_0x001c:
            com.xiaomi.push.es.a(r6, r1)
            goto L_0x00bd
        L_0x0021:
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.a()
            r5.f679h = r0
            goto L_0x00bd
        L_0x002b:
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.a()
            r5.f678g = r0
            goto L_0x00bd
        L_0x0035:
            r0 = 13
            if (r1 != r0) goto L_0x001c
            com.xiaomi.push.eo r0 = r6.a()
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r0.f757a
            int r3 = r3 * 2
            r1.<init>(r3)
            r5.f671a = r1
            r1 = 0
        L_0x0049:
            int r2 = r0.f757a
            if (r1 >= r2) goto L_0x005d
            java.lang.String r2 = r6.a()
            java.lang.String r3 = r6.a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r5.f671a
            r4.put(r2, r3)
            int r1 = r1 + 1
            goto L_0x0049
        L_0x005d:
            r6.h()
            goto L_0x00bd
        L_0x0061:
            if (r1 != r2) goto L_0x001c
            boolean r0 = r6.a()
            r5.f672a = r0
            r0 = 1
            r5.a(r0)
            goto L_0x00bd
        L_0x006e:
            if (r1 != r3) goto L_0x001c
            com.xiaomi.push.dh r0 = new com.xiaomi.push.dh
            r0.<init>()
            r5.f667a = r0
            r0.a(r6)
            goto L_0x00bd
        L_0x007b:
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.a()
            r5.f677f = r0
            goto L_0x00bd
        L_0x0084:
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.a()
            r5.f676e = r0
            goto L_0x00bd
        L_0x008d:
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.a()
            r5.f675d = r0
            goto L_0x00bd
        L_0x0096:
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.a()
            r5.f674c = r0
            goto L_0x00bd
        L_0x009f:
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.a()
            r5.f673b = r0
            goto L_0x00bd
        L_0x00a8:
            if (r1 != r3) goto L_0x001c
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r5.f668a = r0
            r0.a(r6)
            goto L_0x00bd
        L_0x00b5:
            if (r1 != r4) goto L_0x001c
            java.lang.String r0 = r6.a()
            r5.f669a = r0
        L_0x00bd:
            r6.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dx.a(com.xiaomi.push.ep):void");
    }

    public void a(boolean z) {
        this.f670a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m681a() {
        return this.f669a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m682a(dx dxVar) {
        if (dxVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = dxVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f669a.equals(dxVar.f669a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = dxVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f668a.compareTo(dxVar.f668a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dxVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f673b.equals(dxVar.f673b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dxVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f674c.equals(dxVar.f674c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = dxVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f675d.equals(dxVar.f675d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dxVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f676e.equals(dxVar.f676e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dxVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f677f.equals(dxVar.f677f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dxVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f667a.compareTo(dxVar.f667a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dxVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.f672a != dxVar.f672a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = dxVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f671a.equals(dxVar.f671a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = dxVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f678g.equals(dxVar.f678g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = dxVar.l();
        return (!l2 && !l3) || (l2 && l3 && this.f679h.equals(dxVar.f679h));
    }

    public String b() {
        return this.f674c;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f666a);
        if (this.f669a != null && a()) {
            epVar.a(f4712a);
            epVar.a(this.f669a);
            epVar.b();
        }
        if (this.f668a != null && b()) {
            epVar.a(f4713b);
            this.f668a.b(epVar);
            epVar.b();
        }
        if (this.f673b != null) {
            epVar.a(f4714c);
            epVar.a(this.f673b);
            epVar.b();
        }
        if (this.f674c != null) {
            epVar.a(f4715d);
            epVar.a(this.f674c);
            epVar.b();
        }
        if (this.f675d != null && e()) {
            epVar.a(f4716e);
            epVar.a(this.f675d);
            epVar.b();
        }
        if (this.f676e != null && f()) {
            epVar.a(f4717f);
            epVar.a(this.f676e);
            epVar.b();
        }
        if (this.f677f != null && g()) {
            epVar.a(g);
            epVar.a(this.f677f);
            epVar.b();
        }
        if (this.f667a != null && h()) {
            epVar.a(h);
            this.f667a.b(epVar);
            epVar.b();
        }
        if (i()) {
            epVar.a(i);
            epVar.a(this.f672a);
            epVar.b();
        }
        if (this.f671a != null && j()) {
            epVar.a(j);
            epVar.a(new eo(MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, this.f671a.size()));
            for (Entry next : this.f671a.entrySet()) {
                epVar.a((String) next.getKey());
                epVar.a((String) next.getValue());
            }
            epVar.d();
            epVar.b();
        }
        if (this.f678g != null && k()) {
            epVar.a(k);
            epVar.a(this.f678g);
            epVar.b();
        }
        if (this.f679h != null && l()) {
            epVar.a(l);
            epVar.a(this.f679h);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m683b() {
        return this.f668a != null;
    }

    public String c() {
        return this.f676e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m684c() {
        return this.f673b != null;
    }

    public String d() {
        return this.f677f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m685d() {
        return this.f674c != null;
    }

    public String e() {
        return this.f678g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m686e() {
        return this.f675d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dx)) {
            return compareTo((dx) obj);
        }
        return false;
    }

    public String f() {
        return this.f679h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m687f() {
        return this.f676e != null;
    }

    public boolean g() {
        return this.f677f != null;
    }

    public boolean h() {
        return this.f667a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f670a.get(0);
    }

    public boolean j() {
        return this.f671a != null;
    }

    public boolean k() {
        return this.f678g != null;
    }

    public boolean l() {
        return this.f679h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.f669a;
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
            dk dkVar = this.f668a;
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
        String str2 = this.f673b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f674c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f675d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f676e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f677f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            dh dhVar = this.f667a;
            if (dhVar == null) {
                sb.append("null");
            } else {
                sb.append(dhVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f672a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f671a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f678g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.f679h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
