package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class ec implements ef<ec, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4742a = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f725a = new eu("XmPushActionUnSubscription");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4743b = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4744c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4745d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4746e = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4747f = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 6);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7);
    public static final em h = new em("", 15, 8);

    /* renamed from: a  reason: collision with other field name */
    public dk f726a;

    /* renamed from: a  reason: collision with other field name */
    public String f727a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f728a;

    /* renamed from: b  reason: collision with other field name */
    public String f729b;

    /* renamed from: c  reason: collision with other field name */
    public String f730c;

    /* renamed from: d  reason: collision with other field name */
    public String f731d;

    /* renamed from: e  reason: collision with other field name */
    public String f732e;

    /* renamed from: f  reason: collision with other field name */
    public String f733f;

    /* renamed from: a */
    public int compareTo(ec ecVar) {
        if (!ec.class.equals(ecVar.getClass())) {
            return ec.class.getName().compareTo(ec.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(ecVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f727a, ecVar.f727a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ecVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a((Comparable) this.f726a, (Comparable) ecVar.f726a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ecVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f729b, ecVar.f729b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ecVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f730c, ecVar.f730c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ecVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f731d, ecVar.f731d);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ecVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f732e, ecVar.f732e);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ecVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f733f, ecVar.f733f);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ecVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h()) {
            int a9 = eg.a((List) this.f728a, (List) ecVar.f728a);
            if (a9 != 0) {
                return a9;
            }
        }
        return 0;
    }

    public ec a(String str) {
        this.f729b = str;
        return this;
    }

    public void a() {
        if (this.f729b == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'id' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        } else if (this.f730c == null) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Required field 'appId' was not present! Struct: ");
            outline732.append(toString());
            throw new eq(outline732.toString());
        } else if (this.f731d == null) {
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("Required field 'topic' was not present! Struct: ");
            outline733.append(toString());
            throw new eq(outline733.toString());
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.xiaomi.push.ep r5) {
        /*
            r4 = this;
            r5.a()
        L_0x0003:
            com.xiaomi.push.em r0 = r5.a()
            byte r1 = r0.f4765a
            if (r1 != 0) goto L_0x0012
            r5.f()
            r4.a()
            return
        L_0x0012:
            short r0 = r0.f755a
            r2 = 11
            switch(r0) {
                case 1: goto L_0x0080;
                case 2: goto L_0x0071;
                case 3: goto L_0x0068;
                case 4: goto L_0x005f;
                case 5: goto L_0x0056;
                case 6: goto L_0x004d;
                case 7: goto L_0x0044;
                case 8: goto L_0x001e;
                default: goto L_0x0019;
            }
        L_0x0019:
            com.xiaomi.push.es.a(r5, r1)
            goto L_0x0088
        L_0x001e:
            r0 = 15
            if (r1 != r0) goto L_0x0019
            com.xiaomi.push.en r0 = r5.a()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.f756a
            r1.<init>(r2)
            r4.f728a = r1
            r1 = 0
        L_0x0030:
            int r2 = r0.f756a
            if (r1 >= r2) goto L_0x0040
            java.lang.String r2 = r5.a()
            java.util.List<java.lang.String> r3 = r4.f728a
            r3.add(r2)
            int r1 = r1 + 1
            goto L_0x0030
        L_0x0040:
            r5.i()
            goto L_0x0088
        L_0x0044:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.a()
            r4.f733f = r0
            goto L_0x0088
        L_0x004d:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.a()
            r4.f732e = r0
            goto L_0x0088
        L_0x0056:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.a()
            r4.f731d = r0
            goto L_0x0088
        L_0x005f:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.a()
            r4.f730c = r0
            goto L_0x0088
        L_0x0068:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.a()
            r4.f729b = r0
            goto L_0x0088
        L_0x0071:
            r0 = 12
            if (r1 != r0) goto L_0x0019
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r4.f726a = r0
            r0.a(r5)
            goto L_0x0088
        L_0x0080:
            if (r1 != r2) goto L_0x0019
            java.lang.String r0 = r5.a()
            r4.f727a = r0
        L_0x0088:
            r5.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ec.a(com.xiaomi.push.ep):void");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m702a() {
        return this.f727a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m703a(ec ecVar) {
        if (ecVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = ecVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f727a.equals(ecVar.f727a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ecVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f726a.compareTo(ecVar.f726a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ecVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f729b.equals(ecVar.f729b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ecVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f730c.equals(ecVar.f730c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ecVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f731d.equals(ecVar.f731d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ecVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f732e.equals(ecVar.f732e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ecVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f733f.equals(ecVar.f733f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ecVar.h();
        return (!h2 && !h3) || (h2 && h3 && this.f728a.equals(ecVar.f728a));
    }

    public ec b(String str) {
        this.f730c = str;
        return this;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f725a);
        if (this.f727a != null && a()) {
            epVar.a(f4742a);
            epVar.a(this.f727a);
            epVar.b();
        }
        if (this.f726a != null && b()) {
            epVar.a(f4743b);
            this.f726a.b(epVar);
            epVar.b();
        }
        if (this.f729b != null) {
            epVar.a(f4744c);
            epVar.a(this.f729b);
            epVar.b();
        }
        if (this.f730c != null) {
            epVar.a(f4745d);
            epVar.a(this.f730c);
            epVar.b();
        }
        if (this.f731d != null) {
            epVar.a(f4746e);
            epVar.a(this.f731d);
            epVar.b();
        }
        if (this.f732e != null && f()) {
            epVar.a(f4747f);
            epVar.a(this.f732e);
            epVar.b();
        }
        if (this.f733f != null && g()) {
            epVar.a(g);
            epVar.a(this.f733f);
            epVar.b();
        }
        if (this.f728a != null && h()) {
            epVar.a(h);
            epVar.a(new en(MqttWireMessage.MESSAGE_TYPE_UNSUBACK, this.f728a.size()));
            for (String a2 : this.f728a) {
                epVar.a(a2);
            }
            epVar.e();
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public boolean b() {
        return this.f726a != null;
    }

    public ec c(String str) {
        this.f731d = str;
        return this;
    }

    public boolean c() {
        return this.f729b != null;
    }

    public ec d(String str) {
        this.f732e = str;
        return this;
    }

    public boolean d() {
        return this.f730c != null;
    }

    public ec e(String str) {
        this.f733f = str;
        return this;
    }

    public boolean e() {
        return this.f731d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ec)) {
            return compareTo((ec) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f732e != null;
    }

    public boolean g() {
        return this.f733f != null;
    }

    public boolean h() {
        return this.f728a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.f727a;
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
            dk dkVar = this.f726a;
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
        String str2 = this.f729b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f730c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f731d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f732e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f733f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f728a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
