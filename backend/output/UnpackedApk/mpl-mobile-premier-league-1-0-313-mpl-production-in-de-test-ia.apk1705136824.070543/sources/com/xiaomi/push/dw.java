package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.BitSet;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class dw implements ef<dw, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4706a = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f657a = new eu("XmPushActionSendFeedbackResult");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4707b = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4708c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4709d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4710e = new em("", 10, 6);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4711f = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 8);

    /* renamed from: a  reason: collision with other field name */
    public long f658a;

    /* renamed from: a  reason: collision with other field name */
    public dk f659a;

    /* renamed from: a  reason: collision with other field name */
    public String f660a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f661a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f662b;

    /* renamed from: c  reason: collision with other field name */
    public String f663c;

    /* renamed from: d  reason: collision with other field name */
    public String f664d;

    /* renamed from: e  reason: collision with other field name */
    public String f665e;

    /* renamed from: a */
    public int compareTo(dw dwVar) {
        if (!dw.class.equals(dwVar.getClass())) {
            return dw.class.getName().compareTo(dw.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(dwVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f660a, dwVar.f660a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(dwVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a((Comparable) this.f659a, (Comparable) dwVar.f659a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(dwVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f662b, dwVar.f662b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(dwVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f663c, dwVar.f663c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(dwVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f658a, dwVar.f658a);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(dwVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f664d, dwVar.f664d);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(dwVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f665e, dwVar.f665e);
            if (a8 != 0) {
                return a8;
            }
        }
        return 0;
    }

    public void a() {
        if (this.f662b == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'id' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        } else if (this.f663c == null) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Required field 'appId' was not present! Struct: ");
            outline732.append(toString());
            throw new eq(outline732.toString());
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
            if (r1 != 0) goto L_0x002f
            r4.f()
            boolean r4 = r3.e()
            if (r4 == 0) goto L_0x0018
            r3.a()
            return
        L_0x0018:
            com.xiaomi.push.eq r4 = new com.xiaomi.push.eq
            java.lang.String r0 = "Required field 'errorCode' was not found in serialized data! Struct: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = r3.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        L_0x002f:
            short r0 = r0.f755a
            r2 = 11
            switch(r0) {
                case 1: goto L_0x0079;
                case 2: goto L_0x006a;
                case 3: goto L_0x0061;
                case 4: goto L_0x0058;
                case 5: goto L_0x0036;
                case 6: goto L_0x0049;
                case 7: goto L_0x0040;
                case 8: goto L_0x0037;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0082
        L_0x0037:
            if (r1 != r2) goto L_0x0082
            java.lang.String r0 = r4.a()
            r3.f665e = r0
            goto L_0x0085
        L_0x0040:
            if (r1 != r2) goto L_0x0082
            java.lang.String r0 = r4.a()
            r3.f664d = r0
            goto L_0x0085
        L_0x0049:
            r0 = 10
            if (r1 != r0) goto L_0x0082
            long r0 = r4.a()
            r3.f658a = r0
            r0 = 1
            r3.a(r0)
            goto L_0x0085
        L_0x0058:
            if (r1 != r2) goto L_0x0082
            java.lang.String r0 = r4.a()
            r3.f663c = r0
            goto L_0x0085
        L_0x0061:
            if (r1 != r2) goto L_0x0082
            java.lang.String r0 = r4.a()
            r3.f662b = r0
            goto L_0x0085
        L_0x006a:
            r0 = 12
            if (r1 != r0) goto L_0x0082
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r3.f659a = r0
            r0.a(r4)
            goto L_0x0085
        L_0x0079:
            if (r1 != r2) goto L_0x0082
            java.lang.String r0 = r4.a()
            r3.f660a = r0
            goto L_0x0085
        L_0x0082:
            com.xiaomi.push.es.a(r4, r1)
        L_0x0085:
            r4.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dw.a(com.xiaomi.push.ep):void");
    }

    public void a(boolean z) {
        this.f661a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m677a() {
        return this.f660a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m678a(dw dwVar) {
        if (dwVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = dwVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f660a.equals(dwVar.f660a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = dwVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f659a.compareTo(dwVar.f659a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dwVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f662b.equals(dwVar.f662b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dwVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f663c.equals(dwVar.f663c))) || this.f658a != dwVar.f658a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dwVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f664d.equals(dwVar.f664d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dwVar.g();
        return (!g2 && !g3) || (g2 && g3 && this.f665e.equals(dwVar.f665e));
    }

    public void b(ep epVar) {
        a();
        epVar.a(f657a);
        if (this.f660a != null && a()) {
            epVar.a(f4706a);
            epVar.a(this.f660a);
            epVar.b();
        }
        if (this.f659a != null && b()) {
            epVar.a(f4707b);
            this.f659a.b(epVar);
            epVar.b();
        }
        if (this.f662b != null) {
            epVar.a(f4708c);
            epVar.a(this.f662b);
            epVar.b();
        }
        if (this.f663c != null) {
            epVar.a(f4709d);
            epVar.a(this.f663c);
            epVar.b();
        }
        epVar.a(f4710e);
        epVar.a(this.f658a);
        epVar.b();
        if (this.f664d != null && f()) {
            epVar.a(f4711f);
            epVar.a(this.f664d);
            epVar.b();
        }
        if (this.f665e != null && g()) {
            epVar.a(g);
            epVar.a(this.f665e);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public boolean b() {
        return this.f659a != null;
    }

    public boolean c() {
        return this.f662b != null;
    }

    public boolean d() {
        return this.f663c != null;
    }

    public boolean e() {
        return this.f661a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dw)) {
            return compareTo((dw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f664d != null;
    }

    public boolean g() {
        return this.f665e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.f660a;
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
            dk dkVar = this.f659a;
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
        String str2 = this.f662b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f663c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f658a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f664d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f665e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
