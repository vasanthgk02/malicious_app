package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class dg implements ef<dg, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4627a = new em("", 8, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f459a = new eu("OnlineConfigItem");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4628b = new em("", 8, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4629c = new em("", 2, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4630d = new em("", 8, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4631e = new em("", 10, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4632f = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 6);
    public static final em g = new em("", 2, 7);

    /* renamed from: a  reason: collision with other field name */
    public int f460a;

    /* renamed from: a  reason: collision with other field name */
    public long f461a;

    /* renamed from: a  reason: collision with other field name */
    public String f462a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f463a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f464a;

    /* renamed from: b  reason: collision with other field name */
    public int f465b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f466b;

    /* renamed from: c  reason: collision with other field name */
    public int f467c;

    public int a() {
        return this.f460a;
    }

    /* renamed from: a */
    public int compareTo(dg dgVar) {
        if (!dg.class.equals(dgVar.getClass())) {
            return dg.class.getName().compareTo(dg.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(dgVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f460a, dgVar.f460a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(dgVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a(this.f465b, dgVar.f465b);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(dgVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f464a, dgVar.f464a);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(dgVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f467c, dgVar.f467c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(dgVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f461a, dgVar.f461a);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(dgVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f462a, dgVar.f462a);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(dgVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h()) {
            int a8 = eg.a(this.f466b, dgVar.f466b);
            if (a8 != 0) {
                return a8;
            }
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m596a() {
        return this.f461a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m597a() {
        return this.f462a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m598a() {
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
            r3 = 8
            r4 = 1
            switch(r0) {
                case 1: goto L_0x0068;
                case 2: goto L_0x005c;
                case 3: goto L_0x0050;
                case 4: goto L_0x0044;
                case 5: goto L_0x0036;
                case 6: goto L_0x002b;
                case 7: goto L_0x001f;
                default: goto L_0x001b;
            }
        L_0x001b:
            com.xiaomi.push.es.a(r6, r1)
            goto L_0x0073
        L_0x001f:
            if (r1 != r2) goto L_0x001b
            boolean r0 = r6.a()
            r5.f466b = r0
            r5.f(r4)
            goto L_0x0073
        L_0x002b:
            r0 = 11
            if (r1 != r0) goto L_0x001b
            java.lang.String r0 = r6.a()
            r5.f462a = r0
            goto L_0x0073
        L_0x0036:
            r0 = 10
            if (r1 != r0) goto L_0x001b
            long r0 = r6.a()
            r5.f461a = r0
            r5.e(r4)
            goto L_0x0073
        L_0x0044:
            if (r1 != r3) goto L_0x001b
            int r0 = r6.a()
            r5.f467c = r0
            r5.d(r4)
            goto L_0x0073
        L_0x0050:
            if (r1 != r2) goto L_0x001b
            boolean r0 = r6.a()
            r5.f464a = r0
            r5.c(r4)
            goto L_0x0073
        L_0x005c:
            if (r1 != r3) goto L_0x001b
            int r0 = r6.a()
            r5.f465b = r0
            r5.b(r4)
            goto L_0x0073
        L_0x0068:
            if (r1 != r3) goto L_0x001b
            int r0 = r6.a()
            r5.f460a = r0
            r5.a(r4)
        L_0x0073:
            r6.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dg.a(com.xiaomi.push.ep):void");
    }

    public void a(boolean z) {
        this.f463a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m599a() {
        return this.f463a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m600a(dg dgVar) {
        if (dgVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = dgVar.a();
        if ((a2 || a3) && (!a2 || !a3 || this.f460a != dgVar.f460a)) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = dgVar.b();
        if ((b2 || b3) && (!b2 || !b3 || this.f465b != dgVar.f465b)) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dgVar.c();
        if ((c2 || c3) && (!c2 || !c3 || this.f464a != dgVar.f464a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dgVar.d();
        if ((d2 || d3) && (!d2 || !d3 || this.f467c != dgVar.f467c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = dgVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f461a != dgVar.f461a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dgVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f462a.equals(dgVar.f462a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = dgVar.h();
        return (!h && !h2) || (h && h2 && this.f466b == dgVar.f466b);
    }

    public int b() {
        return this.f465b;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f459a);
        if (a()) {
            epVar.a(f4627a);
            epVar.a(this.f460a);
            epVar.b();
        }
        if (b()) {
            epVar.a(f4628b);
            epVar.a(this.f465b);
            epVar.b();
        }
        if (c()) {
            epVar.a(f4629c);
            epVar.a(this.f464a);
            epVar.b();
        }
        if (d()) {
            epVar.a(f4630d);
            epVar.a(this.f467c);
            epVar.b();
        }
        if (e()) {
            epVar.a(f4631e);
            epVar.a(this.f461a);
            epVar.b();
        }
        if (this.f462a != null && f()) {
            epVar.a(f4632f);
            epVar.a(this.f462a);
            epVar.b();
        }
        if (h()) {
            epVar.a(g);
            epVar.a(this.f466b);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public void b(boolean z) {
        this.f463a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m601b() {
        return this.f463a.get(1);
    }

    public int c() {
        return this.f467c;
    }

    public void c(boolean z) {
        this.f463a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m602c() {
        return this.f463a.get(2);
    }

    public void d(boolean z) {
        this.f463a.set(3, z);
    }

    public boolean d() {
        return this.f463a.get(3);
    }

    public void e(boolean z) {
        this.f463a.set(4, z);
    }

    public boolean e() {
        return this.f463a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dg)) {
            return compareTo((dg) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f463a.set(5, z);
    }

    public boolean f() {
        return this.f462a != null;
    }

    public boolean g() {
        return this.f466b;
    }

    public boolean h() {
        return this.f463a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (a()) {
            sb.append("key:");
            sb.append(this.f460a);
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f465b);
            z = false;
        }
        if (c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f464a);
            z = false;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f467c);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f461a);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f462a;
            if (str == null) {
                str = "null";
            }
            sb.append(str);
        } else {
            z2 = z;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f466b);
        }
        sb.append(")");
        return sb.toString();
    }
}
