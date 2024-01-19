package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.BitSet;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class ed implements ef<ed, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4748a = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f734a = new eu("XmPushActionUnSubscriptionResult");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4749b = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4750c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4751d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4752e = new em("", 10, 6);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4753f = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 8);
    public static final em h = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 9);
    public static final em i = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10);

    /* renamed from: a  reason: collision with other field name */
    public long f735a;

    /* renamed from: a  reason: collision with other field name */
    public dk f736a;

    /* renamed from: a  reason: collision with other field name */
    public String f737a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f738a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f739b;

    /* renamed from: c  reason: collision with other field name */
    public String f740c;

    /* renamed from: d  reason: collision with other field name */
    public String f741d;

    /* renamed from: e  reason: collision with other field name */
    public String f742e;

    /* renamed from: f  reason: collision with other field name */
    public String f743f;

    /* renamed from: g  reason: collision with other field name */
    public String f744g;

    /* renamed from: a */
    public int compareTo(ed edVar) {
        if (!ed.class.equals(edVar.getClass())) {
            return ed.class.getName().compareTo(ed.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(edVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f737a, edVar.f737a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(edVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a((Comparable) this.f736a, (Comparable) edVar.f736a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(edVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f739b, edVar.f739b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(edVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f740c, edVar.f740c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(edVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f735a, edVar.f735a);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(edVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f741d, edVar.f741d);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(edVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f742e, edVar.f742e);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(edVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h()) {
            int a9 = eg.a(this.f743f, edVar.f743f);
            if (a9 != 0) {
                return a9;
            }
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(edVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i()) {
            int a10 = eg.a(this.f744g, edVar.f744g);
            if (a10 != 0) {
                return a10;
            }
        }
        return 0;
    }

    public String a() {
        return this.f739b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m704a() {
        if (this.f739b == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'id' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.xiaomi.push.ep r4) {
        /*
            r3 = this;
            r4.a()
        L_0x0003:
            com.xiaomi.push.em r0 = r4.a()
            byte r1 = r0.f4765a
            if (r1 != 0) goto L_0x0012
            r4.f()
            r3.a()
            return
        L_0x0012:
            short r0 = r0.f755a
            r2 = 11
            switch(r0) {
                case 1: goto L_0x0071;
                case 2: goto L_0x0062;
                case 3: goto L_0x0059;
                case 4: goto L_0x0050;
                case 5: goto L_0x0019;
                case 6: goto L_0x0041;
                case 7: goto L_0x0038;
                case 8: goto L_0x002f;
                case 9: goto L_0x0026;
                case 10: goto L_0x001d;
                default: goto L_0x0019;
            }
        L_0x0019:
            com.xiaomi.push.es.a(r4, r1)
            goto L_0x0079
        L_0x001d:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.a()
            r3.f744g = r0
            goto L_0x0079
        L_0x0026:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.a()
            r3.f743f = r0
            goto L_0x0079
        L_0x002f:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.a()
            r3.f742e = r0
            goto L_0x0079
        L_0x0038:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.a()
            r3.f741d = r0
            goto L_0x0079
        L_0x0041:
            r0 = 10
            if (r1 != r0) goto L_0x0019
            long r0 = r4.a()
            r3.f735a = r0
            r0 = 1
            r3.a(r0)
            goto L_0x0079
        L_0x0050:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.a()
            r3.f740c = r0
            goto L_0x0079
        L_0x0059:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.a()
            r3.f739b = r0
            goto L_0x0079
        L_0x0062:
            r0 = 12
            if (r1 != r0) goto L_0x0019
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r3.f736a = r0
            r0.a(r4)
            goto L_0x0079
        L_0x0071:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.a()
            r3.f737a = r0
        L_0x0079:
            r4.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ed.a(com.xiaomi.push.ep):void");
    }

    public void a(boolean z) {
        this.f738a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m705a() {
        return this.f737a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m706a(ed edVar) {
        if (edVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = edVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f737a.equals(edVar.f737a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = edVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f736a.compareTo(edVar.f736a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = edVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f739b.equals(edVar.f739b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = edVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f740c.equals(edVar.f740c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = edVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f735a != edVar.f735a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = edVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f741d.equals(edVar.f741d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = edVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f742e.equals(edVar.f742e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = edVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f743f.equals(edVar.f743f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = edVar.i();
        return (!i2 && !i3) || (i2 && i3 && this.f744g.equals(edVar.f744g));
    }

    public String b() {
        return this.f742e;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f734a);
        if (this.f737a != null && a()) {
            epVar.a(f4748a);
            epVar.a(this.f737a);
            epVar.b();
        }
        if (this.f736a != null && b()) {
            epVar.a(f4749b);
            this.f736a.b(epVar);
            epVar.b();
        }
        if (this.f739b != null) {
            epVar.a(f4750c);
            epVar.a(this.f739b);
            epVar.b();
        }
        if (this.f740c != null && d()) {
            epVar.a(f4751d);
            epVar.a(this.f740c);
            epVar.b();
        }
        if (e()) {
            epVar.a(f4752e);
            epVar.a(this.f735a);
            epVar.b();
        }
        if (this.f741d != null && f()) {
            epVar.a(f4753f);
            epVar.a(this.f741d);
            epVar.b();
        }
        if (this.f742e != null && g()) {
            epVar.a(g);
            epVar.a(this.f742e);
            epVar.b();
        }
        if (this.f743f != null && h()) {
            epVar.a(h);
            epVar.a(this.f743f);
            epVar.b();
        }
        if (this.f744g != null && i()) {
            epVar.a(i);
            epVar.a(this.f744g);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m707b() {
        return this.f736a != null;
    }

    public String c() {
        return this.f744g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m708c() {
        return this.f739b != null;
    }

    public boolean d() {
        return this.f740c != null;
    }

    public boolean e() {
        return this.f738a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ed)) {
            return compareTo((ed) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f741d != null;
    }

    public boolean g() {
        return this.f742e != null;
    }

    public boolean h() {
        return this.f743f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f744g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.f737a;
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
            dk dkVar = this.f736a;
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
        String str2 = this.f739b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f740c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f735a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f741d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f742e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f743f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f744g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
