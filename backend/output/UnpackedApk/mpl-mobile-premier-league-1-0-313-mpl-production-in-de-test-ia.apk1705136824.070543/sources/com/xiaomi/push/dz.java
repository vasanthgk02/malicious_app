package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.BitSet;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class dz implements ef<dz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4724a = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f689a = new eu("XmPushActionSubscriptionResult");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4725b = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4726c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4727d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4728e = new em("", 10, 6);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4729f = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 8);
    public static final em h = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 9);
    public static final em i = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10);

    /* renamed from: a  reason: collision with other field name */
    public long f690a;

    /* renamed from: a  reason: collision with other field name */
    public dk f691a;

    /* renamed from: a  reason: collision with other field name */
    public String f692a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f693a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f694b;

    /* renamed from: c  reason: collision with other field name */
    public String f695c;

    /* renamed from: d  reason: collision with other field name */
    public String f696d;

    /* renamed from: e  reason: collision with other field name */
    public String f697e;

    /* renamed from: f  reason: collision with other field name */
    public String f698f;

    /* renamed from: g  reason: collision with other field name */
    public String f699g;

    /* renamed from: a */
    public int compareTo(dz dzVar) {
        if (!dz.class.equals(dzVar.getClass())) {
            return dz.class.getName().compareTo(dz.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(dzVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f692a, dzVar.f692a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(dzVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a((Comparable) this.f691a, (Comparable) dzVar.f691a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(dzVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f694b, dzVar.f694b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(dzVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f695c, dzVar.f695c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(dzVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f690a, dzVar.f690a);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(dzVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f696d, dzVar.f696d);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(dzVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f697e, dzVar.f697e);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(dzVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h()) {
            int a9 = eg.a(this.f698f, dzVar.f698f);
            if (a9 != 0) {
                return a9;
            }
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(dzVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i()) {
            int a10 = eg.a(this.f699g, dzVar.f699g);
            if (a10 != 0) {
                return a10;
            }
        }
        return 0;
    }

    public String a() {
        return this.f694b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m690a() {
        if (this.f694b == null) {
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
            r3.f699g = r0
            goto L_0x0079
        L_0x0026:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.a()
            r3.f698f = r0
            goto L_0x0079
        L_0x002f:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.a()
            r3.f697e = r0
            goto L_0x0079
        L_0x0038:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.a()
            r3.f696d = r0
            goto L_0x0079
        L_0x0041:
            r0 = 10
            if (r1 != r0) goto L_0x0019
            long r0 = r4.a()
            r3.f690a = r0
            r0 = 1
            r3.a(r0)
            goto L_0x0079
        L_0x0050:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.a()
            r3.f695c = r0
            goto L_0x0079
        L_0x0059:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.a()
            r3.f694b = r0
            goto L_0x0079
        L_0x0062:
            r0 = 12
            if (r1 != r0) goto L_0x0019
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r3.f691a = r0
            r0.a(r4)
            goto L_0x0079
        L_0x0071:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r4.a()
            r3.f692a = r0
        L_0x0079:
            r4.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dz.a(com.xiaomi.push.ep):void");
    }

    public void a(boolean z) {
        this.f693a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m691a() {
        return this.f692a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m692a(dz dzVar) {
        if (dzVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = dzVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f692a.equals(dzVar.f692a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = dzVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f691a.compareTo(dzVar.f691a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dzVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f694b.equals(dzVar.f694b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dzVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f695c.equals(dzVar.f695c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = dzVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f690a != dzVar.f690a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dzVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f696d.equals(dzVar.f696d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dzVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f697e.equals(dzVar.f697e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dzVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f698f.equals(dzVar.f698f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dzVar.i();
        return (!i2 && !i3) || (i2 && i3 && this.f699g.equals(dzVar.f699g));
    }

    public String b() {
        return this.f697e;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f689a);
        if (this.f692a != null && a()) {
            epVar.a(f4724a);
            epVar.a(this.f692a);
            epVar.b();
        }
        if (this.f691a != null && b()) {
            epVar.a(f4725b);
            this.f691a.b(epVar);
            epVar.b();
        }
        if (this.f694b != null) {
            epVar.a(f4726c);
            epVar.a(this.f694b);
            epVar.b();
        }
        if (this.f695c != null && d()) {
            epVar.a(f4727d);
            epVar.a(this.f695c);
            epVar.b();
        }
        if (e()) {
            epVar.a(f4728e);
            epVar.a(this.f690a);
            epVar.b();
        }
        if (this.f696d != null && f()) {
            epVar.a(f4729f);
            epVar.a(this.f696d);
            epVar.b();
        }
        if (this.f697e != null && g()) {
            epVar.a(g);
            epVar.a(this.f697e);
            epVar.b();
        }
        if (this.f698f != null && h()) {
            epVar.a(h);
            epVar.a(this.f698f);
            epVar.b();
        }
        if (this.f699g != null && i()) {
            epVar.a(i);
            epVar.a(this.f699g);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m693b() {
        return this.f691a != null;
    }

    public String c() {
        return this.f699g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m694c() {
        return this.f694b != null;
    }

    public boolean d() {
        return this.f695c != null;
    }

    public boolean e() {
        return this.f693a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dz)) {
            return compareTo((dz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f696d != null;
    }

    public boolean g() {
        return this.f697e != null;
    }

    public boolean h() {
        return this.f698f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f699g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.f692a;
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
            dk dkVar = this.f691a;
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
        String str2 = this.f694b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f695c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f690a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f696d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f697e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f698f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f699g;
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
