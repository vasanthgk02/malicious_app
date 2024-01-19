package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.BitSet;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class eb implements ef<eb, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4736a = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f714a = new eu("XmPushActionUnRegistrationResult");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4737b = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4738c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4739d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4740e = new em("", 10, 6);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4741f = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 8);
    public static final em h = new em("", 10, 9);
    public static final em i = new em("", 10, 10);

    /* renamed from: a  reason: collision with other field name */
    public long f715a;

    /* renamed from: a  reason: collision with other field name */
    public dk f716a;

    /* renamed from: a  reason: collision with other field name */
    public String f717a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f718a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f719b;

    /* renamed from: b  reason: collision with other field name */
    public String f720b;

    /* renamed from: c  reason: collision with other field name */
    public long f721c;

    /* renamed from: c  reason: collision with other field name */
    public String f722c;

    /* renamed from: d  reason: collision with other field name */
    public String f723d;

    /* renamed from: e  reason: collision with other field name */
    public String f724e;

    /* renamed from: a */
    public int compareTo(eb ebVar) {
        if (!eb.class.equals(ebVar.getClass())) {
            return eb.class.getName().compareTo(eb.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(ebVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f717a, ebVar.f717a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ebVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a((Comparable) this.f716a, (Comparable) ebVar.f716a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ebVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f720b, ebVar.f720b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ebVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f722c, ebVar.f722c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ebVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f715a, ebVar.f715a);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ebVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f723d, ebVar.f723d);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ebVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f724e, ebVar.f724e);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ebVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h()) {
            int a9 = eg.a(this.f719b, ebVar.f719b);
            if (a9 != 0) {
                return a9;
            }
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ebVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i()) {
            int a10 = eg.a(this.f721c, ebVar.f721c);
            if (a10 != 0) {
                return a10;
            }
        }
        return 0;
    }

    public String a() {
        return this.f724e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m699a() {
        if (this.f720b == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'id' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        } else if (this.f722c == null) {
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
            if (r1 != 0) goto L_0x002f
            r6.f()
            boolean r6 = r5.e()
            if (r6 == 0) goto L_0x0018
            r5.a()
            return
        L_0x0018:
            com.xiaomi.push.eq r6 = new com.xiaomi.push.eq
            java.lang.String r0 = "Required field 'errorCode' was not found in serialized data! Struct: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = r5.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x002f:
            short r0 = r0.f755a
            r2 = 1
            r3 = 10
            r4 = 11
            switch(r0) {
                case 1: goto L_0x0091;
                case 2: goto L_0x0082;
                case 3: goto L_0x0079;
                case 4: goto L_0x0070;
                case 5: goto L_0x0039;
                case 6: goto L_0x0064;
                case 7: goto L_0x005b;
                case 8: goto L_0x0052;
                case 9: goto L_0x0046;
                case 10: goto L_0x003a;
                default: goto L_0x0039;
            }
        L_0x0039:
            goto L_0x009a
        L_0x003a:
            if (r1 != r3) goto L_0x009a
            long r0 = r6.a()
            r5.f721c = r0
            r5.c(r2)
            goto L_0x009d
        L_0x0046:
            if (r1 != r3) goto L_0x009a
            long r0 = r6.a()
            r5.f719b = r0
            r5.b(r2)
            goto L_0x009d
        L_0x0052:
            if (r1 != r4) goto L_0x009a
            java.lang.String r0 = r6.a()
            r5.f724e = r0
            goto L_0x009d
        L_0x005b:
            if (r1 != r4) goto L_0x009a
            java.lang.String r0 = r6.a()
            r5.f723d = r0
            goto L_0x009d
        L_0x0064:
            if (r1 != r3) goto L_0x009a
            long r0 = r6.a()
            r5.f715a = r0
            r5.a(r2)
            goto L_0x009d
        L_0x0070:
            if (r1 != r4) goto L_0x009a
            java.lang.String r0 = r6.a()
            r5.f722c = r0
            goto L_0x009d
        L_0x0079:
            if (r1 != r4) goto L_0x009a
            java.lang.String r0 = r6.a()
            r5.f720b = r0
            goto L_0x009d
        L_0x0082:
            r0 = 12
            if (r1 != r0) goto L_0x009a
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r5.f716a = r0
            r0.a(r6)
            goto L_0x009d
        L_0x0091:
            if (r1 != r4) goto L_0x009a
            java.lang.String r0 = r6.a()
            r5.f717a = r0
            goto L_0x009d
        L_0x009a:
            com.xiaomi.push.es.a(r6, r1)
        L_0x009d:
            r6.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.eb.a(com.xiaomi.push.ep):void");
    }

    public void a(boolean z) {
        this.f718a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m700a() {
        return this.f717a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m701a(eb ebVar) {
        if (ebVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = ebVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f717a.equals(ebVar.f717a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ebVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f716a.compareTo(ebVar.f716a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ebVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f720b.equals(ebVar.f720b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ebVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f722c.equals(ebVar.f722c))) || this.f715a != ebVar.f715a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ebVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f723d.equals(ebVar.f723d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ebVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f724e.equals(ebVar.f724e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ebVar.h();
        if ((h2 || h3) && (!h2 || !h3 || this.f719b != ebVar.f719b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ebVar.i();
        return (!i2 && !i3) || (i2 && i3 && this.f721c == ebVar.f721c);
    }

    public void b(ep epVar) {
        a();
        epVar.a(f714a);
        if (this.f717a != null && a()) {
            epVar.a(f4736a);
            epVar.a(this.f717a);
            epVar.b();
        }
        if (this.f716a != null && b()) {
            epVar.a(f4737b);
            this.f716a.b(epVar);
            epVar.b();
        }
        if (this.f720b != null) {
            epVar.a(f4738c);
            epVar.a(this.f720b);
            epVar.b();
        }
        if (this.f722c != null) {
            epVar.a(f4739d);
            epVar.a(this.f722c);
            epVar.b();
        }
        epVar.a(f4740e);
        epVar.a(this.f715a);
        epVar.b();
        if (this.f723d != null && f()) {
            epVar.a(f4741f);
            epVar.a(this.f723d);
            epVar.b();
        }
        if (this.f724e != null && g()) {
            epVar.a(g);
            epVar.a(this.f724e);
            epVar.b();
        }
        if (h()) {
            epVar.a(h);
            epVar.a(this.f719b);
            epVar.b();
        }
        if (i()) {
            epVar.a(i);
            epVar.a(this.f721c);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public void b(boolean z) {
        this.f718a.set(1, z);
    }

    public boolean b() {
        return this.f716a != null;
    }

    public void c(boolean z) {
        this.f718a.set(2, z);
    }

    public boolean c() {
        return this.f720b != null;
    }

    public boolean d() {
        return this.f722c != null;
    }

    public boolean e() {
        return this.f718a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof eb)) {
            return compareTo((eb) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f723d != null;
    }

    public boolean g() {
        return this.f724e != null;
    }

    public boolean h() {
        return this.f718a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f718a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.f717a;
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
            dk dkVar = this.f716a;
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
        String str2 = this.f720b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f722c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f715a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f723d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f724e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f719b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f721c);
        }
        sb.append(")");
        return sb.toString();
    }
}
