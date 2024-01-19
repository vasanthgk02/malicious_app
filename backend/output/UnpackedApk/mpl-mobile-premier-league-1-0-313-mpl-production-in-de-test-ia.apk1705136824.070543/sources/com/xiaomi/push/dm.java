package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class dm implements ef<dm, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4660a = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f535a = new eu("XmPushActionAckNotification");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4661b = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4662c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4663d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4664e = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4665f = new em("", 10, 7);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 8);
    public static final em h = new em("", 13, 9);
    public static final em i = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10);
    public static final em j = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 11);

    /* renamed from: a  reason: collision with other field name */
    public long f536a = 0;

    /* renamed from: a  reason: collision with other field name */
    public dk f537a;

    /* renamed from: a  reason: collision with other field name */
    public String f538a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f539a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f540a;

    /* renamed from: b  reason: collision with other field name */
    public String f541b;

    /* renamed from: c  reason: collision with other field name */
    public String f542c;

    /* renamed from: d  reason: collision with other field name */
    public String f543d;

    /* renamed from: e  reason: collision with other field name */
    public String f544e;

    /* renamed from: f  reason: collision with other field name */
    public String f545f;

    /* renamed from: g  reason: collision with other field name */
    public String f546g;

    /* renamed from: a */
    public int compareTo(dm dmVar) {
        if (!dm.class.equals(dmVar.getClass())) {
            return dm.class.getName().compareTo(dm.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(dmVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f538a, dmVar.f538a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(dmVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a((Comparable) this.f537a, (Comparable) dmVar.f537a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(dmVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f541b, dmVar.f541b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(dmVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f542c, dmVar.f542c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(dmVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f543d, dmVar.f543d);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(dmVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f536a, dmVar.f536a);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(dmVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f544e, dmVar.f544e);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(dmVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h()) {
            int a9 = eg.a((Map) this.f540a, (Map) dmVar.f540a);
            if (a9 != 0) {
                return a9;
            }
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(dmVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i()) {
            int a10 = eg.a(this.f545f, dmVar.f545f);
            if (a10 != 0) {
                return a10;
            }
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(dmVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j()) {
            int a11 = eg.a(this.f546g, dmVar.f546g);
            if (a11 != 0) {
                return a11;
            }
        }
        return 0;
    }

    public dm a(long j2) {
        this.f536a = j2;
        a(true);
        return this;
    }

    public dm a(dk dkVar) {
        this.f537a = dkVar;
        return this;
    }

    public dm a(String str) {
        this.f541b = str;
        return this;
    }

    public String a() {
        return this.f541b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m626a() {
        return this.f540a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m627a() {
        if (this.f541b == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'id' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
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
            r2 = 11
            switch(r0) {
                case 1: goto L_0x00a0;
                case 2: goto L_0x0091;
                case 3: goto L_0x0088;
                case 4: goto L_0x007f;
                case 5: goto L_0x0076;
                case 6: goto L_0x0019;
                case 7: goto L_0x0067;
                case 8: goto L_0x005e;
                case 9: goto L_0x0032;
                case 10: goto L_0x0028;
                case 11: goto L_0x001e;
                default: goto L_0x0019;
            }
        L_0x0019:
            com.xiaomi.push.es.a(r6, r1)
            goto L_0x00a8
        L_0x001e:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.a()
            r5.f546g = r0
            goto L_0x00a8
        L_0x0028:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.a()
            r5.f545f = r0
            goto L_0x00a8
        L_0x0032:
            r0 = 13
            if (r1 != r0) goto L_0x0019
            com.xiaomi.push.eo r0 = r6.a()
            java.util.HashMap r1 = new java.util.HashMap
            int r2 = r0.f757a
            int r2 = r2 * 2
            r1.<init>(r2)
            r5.f540a = r1
            r1 = 0
        L_0x0046:
            int r2 = r0.f757a
            if (r1 >= r2) goto L_0x005a
            java.lang.String r2 = r6.a()
            java.lang.String r3 = r6.a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r5.f540a
            r4.put(r2, r3)
            int r1 = r1 + 1
            goto L_0x0046
        L_0x005a:
            r6.h()
            goto L_0x00a8
        L_0x005e:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.a()
            r5.f544e = r0
            goto L_0x00a8
        L_0x0067:
            r0 = 10
            if (r1 != r0) goto L_0x0019
            long r0 = r6.a()
            r5.f536a = r0
            r0 = 1
            r5.a(r0)
            goto L_0x00a8
        L_0x0076:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.a()
            r5.f543d = r0
            goto L_0x00a8
        L_0x007f:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.a()
            r5.f542c = r0
            goto L_0x00a8
        L_0x0088:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.a()
            r5.f541b = r0
            goto L_0x00a8
        L_0x0091:
            r0 = 12
            if (r1 != r0) goto L_0x0019
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r5.f537a = r0
            r0.a(r6)
            goto L_0x00a8
        L_0x00a0:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r6.a()
            r5.f538a = r0
        L_0x00a8:
            r6.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dm.a(com.xiaomi.push.ep):void");
    }

    public void a(boolean z) {
        this.f539a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m628a() {
        return this.f538a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m629a(dm dmVar) {
        if (dmVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = dmVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f538a.equals(dmVar.f538a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = dmVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f537a.compareTo(dmVar.f537a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dmVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f541b.equals(dmVar.f541b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dmVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f542c.equals(dmVar.f542c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = dmVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f543d.equals(dmVar.f543d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dmVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f536a != dmVar.f536a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dmVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f544e.equals(dmVar.f544e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dmVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f540a.equals(dmVar.f540a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dmVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f545f.equals(dmVar.f545f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = dmVar.j();
        return (!j2 && !j3) || (j2 && j3 && this.f546g.equals(dmVar.f546g));
    }

    public dm b(String str) {
        this.f542c = str;
        return this;
    }

    public String b() {
        return this.f543d;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f535a);
        if (this.f538a != null && a()) {
            epVar.a(f4660a);
            epVar.a(this.f538a);
            epVar.b();
        }
        if (this.f537a != null && b()) {
            epVar.a(f4661b);
            this.f537a.b(epVar);
            epVar.b();
        }
        if (this.f541b != null) {
            epVar.a(f4662c);
            epVar.a(this.f541b);
            epVar.b();
        }
        if (this.f542c != null && d()) {
            epVar.a(f4663d);
            epVar.a(this.f542c);
            epVar.b();
        }
        if (this.f543d != null && e()) {
            epVar.a(f4664e);
            epVar.a(this.f543d);
            epVar.b();
        }
        if (f()) {
            epVar.a(f4665f);
            epVar.a(this.f536a);
            epVar.b();
        }
        if (this.f544e != null && g()) {
            epVar.a(g);
            epVar.a(this.f544e);
            epVar.b();
        }
        if (this.f540a != null && h()) {
            epVar.a(h);
            epVar.a(new eo(MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, this.f540a.size()));
            for (Entry next : this.f540a.entrySet()) {
                epVar.a((String) next.getKey());
                epVar.a((String) next.getValue());
            }
            epVar.d();
            epVar.b();
        }
        if (this.f545f != null && i()) {
            epVar.a(i);
            epVar.a(this.f545f);
            epVar.b();
        }
        if (this.f546g != null && j()) {
            epVar.a(j);
            epVar.a(this.f546g);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m630b() {
        return this.f537a != null;
    }

    public dm c(String str) {
        this.f543d = str;
        return this;
    }

    public boolean c() {
        return this.f541b != null;
    }

    public dm d(String str) {
        this.f544e = str;
        return this;
    }

    public boolean d() {
        return this.f542c != null;
    }

    public dm e(String str) {
        this.f545f = str;
        return this;
    }

    public boolean e() {
        return this.f543d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dm)) {
            return compareTo((dm) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f539a.get(0);
    }

    public boolean g() {
        return this.f544e != null;
    }

    public boolean h() {
        return this.f540a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f545f != null;
    }

    public boolean j() {
        return this.f546g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.f538a;
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
            dk dkVar = this.f537a;
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
        String str2 = this.f541b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f542c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f543d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f536a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f544e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f540a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f545f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f546g;
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
