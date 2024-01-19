package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.BitSet;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class dp implements ef<dp, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4674a = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f563a = new eu("XmPushActionCommandResult");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4675b = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4676c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4677d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 5);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4678e = new em("", 10, 7);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4679f = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 8);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 9);
    public static final em h = new em("", 15, 10);
    public static final em i = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 12);
    public static final em j = new em("", 2, 13);

    /* renamed from: a  reason: collision with other field name */
    public long f564a;

    /* renamed from: a  reason: collision with other field name */
    public dk f565a;

    /* renamed from: a  reason: collision with other field name */
    public String f566a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f567a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public List<String> f568a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f569a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f570b;

    /* renamed from: c  reason: collision with other field name */
    public String f571c;

    /* renamed from: d  reason: collision with other field name */
    public String f572d;

    /* renamed from: e  reason: collision with other field name */
    public String f573e;

    /* renamed from: f  reason: collision with other field name */
    public String f574f;

    /* renamed from: a */
    public int compareTo(dp dpVar) {
        if (!dp.class.equals(dpVar.getClass())) {
            return dp.class.getName().compareTo(dp.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(dpVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a((Comparable) this.f565a, (Comparable) dpVar.f565a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(dpVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a(this.f566a, dpVar.f566a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(dpVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f570b, dpVar.f570b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(dpVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f571c, dpVar.f571c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(dpVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f564a, dpVar.f564a);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(dpVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f572d, dpVar.f572d);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(dpVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f573e, dpVar.f573e);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(dpVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h()) {
            int a9 = eg.a((List) this.f568a, (List) dpVar.f568a);
            if (a9 != 0) {
                return a9;
            }
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(dpVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i()) {
            int a10 = eg.a(this.f574f, dpVar.f574f);
            if (a10 != 0) {
                return a10;
            }
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(dpVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j()) {
            int a11 = eg.a(this.f569a, dpVar.f569a);
            if (a11 != 0) {
                return a11;
            }
        }
        return 0;
    }

    public String a() {
        return this.f566a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m636a() {
        return this.f568a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m637a() {
        if (this.f566a == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'id' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        } else if (this.f570b == null) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Required field 'appId' was not present! Struct: ");
            outline732.append(toString());
            throw new eq(outline732.toString());
        } else if (this.f571c == null) {
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("Required field 'cmdName' was not present! Struct: ");
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
            if (r1 != 0) goto L_0x002f
            r5.f()
            boolean r5 = r4.e()
            if (r5 == 0) goto L_0x0018
            r4.a()
            return
        L_0x0018:
            com.xiaomi.push.eq r5 = new com.xiaomi.push.eq
            java.lang.String r0 = "Required field 'errorCode' was not found in serialized data! Struct: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = r4.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x002f:
            short r0 = r0.f755a
            r2 = 1
            r3 = 11
            switch(r0) {
                case 2: goto L_0x00b2;
                case 3: goto L_0x00a9;
                case 4: goto L_0x00a0;
                case 5: goto L_0x0097;
                case 6: goto L_0x0037;
                case 7: goto L_0x0089;
                case 8: goto L_0x0080;
                case 9: goto L_0x0077;
                case 10: goto L_0x0051;
                case 11: goto L_0x0037;
                case 12: goto L_0x0047;
                case 13: goto L_0x0039;
                default: goto L_0x0037;
            }
        L_0x0037:
            goto L_0x00c1
        L_0x0039:
            r0 = 2
            if (r1 != r0) goto L_0x00c1
            boolean r0 = r5.a()
            r4.f569a = r0
            r4.b(r2)
            goto L_0x00c4
        L_0x0047:
            if (r1 != r3) goto L_0x00c1
            java.lang.String r0 = r5.a()
            r4.f574f = r0
            goto L_0x00c4
        L_0x0051:
            r0 = 15
            if (r1 != r0) goto L_0x00c1
            com.xiaomi.push.en r0 = r5.a()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.f756a
            r1.<init>(r2)
            r4.f568a = r1
            r1 = 0
        L_0x0063:
            int r2 = r0.f756a
            if (r1 >= r2) goto L_0x0073
            java.lang.String r2 = r5.a()
            java.util.List<java.lang.String> r3 = r4.f568a
            r3.add(r2)
            int r1 = r1 + 1
            goto L_0x0063
        L_0x0073:
            r5.i()
            goto L_0x00c4
        L_0x0077:
            if (r1 != r3) goto L_0x00c1
            java.lang.String r0 = r5.a()
            r4.f573e = r0
            goto L_0x00c4
        L_0x0080:
            if (r1 != r3) goto L_0x00c1
            java.lang.String r0 = r5.a()
            r4.f572d = r0
            goto L_0x00c4
        L_0x0089:
            r0 = 10
            if (r1 != r0) goto L_0x00c1
            long r0 = r5.a()
            r4.f564a = r0
            r4.a(r2)
            goto L_0x00c4
        L_0x0097:
            if (r1 != r3) goto L_0x00c1
            java.lang.String r0 = r5.a()
            r4.f571c = r0
            goto L_0x00c4
        L_0x00a0:
            if (r1 != r3) goto L_0x00c1
            java.lang.String r0 = r5.a()
            r4.f570b = r0
            goto L_0x00c4
        L_0x00a9:
            if (r1 != r3) goto L_0x00c1
            java.lang.String r0 = r5.a()
            r4.f566a = r0
            goto L_0x00c4
        L_0x00b2:
            r0 = 12
            if (r1 != r0) goto L_0x00c1
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r4.f565a = r0
            r0.a(r5)
            goto L_0x00c4
        L_0x00c1:
            com.xiaomi.push.es.a(r5, r1)
        L_0x00c4:
            r5.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dp.a(com.xiaomi.push.ep):void");
    }

    public void a(boolean z) {
        this.f567a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m638a() {
        return this.f565a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m639a(dp dpVar) {
        if (dpVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = dpVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f565a.compareTo(dpVar.f565a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = dpVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f566a.equals(dpVar.f566a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dpVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f570b.equals(dpVar.f570b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dpVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f571c.equals(dpVar.f571c))) || this.f564a != dpVar.f564a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dpVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f572d.equals(dpVar.f572d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dpVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f573e.equals(dpVar.f573e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dpVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f568a.equals(dpVar.f568a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dpVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f574f.equals(dpVar.f574f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = dpVar.j();
        return (!j2 && !j3) || (j2 && j3 && this.f569a == dpVar.f569a);
    }

    public String b() {
        return this.f571c;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f563a);
        if (this.f565a != null && a()) {
            epVar.a(f4674a);
            this.f565a.b(epVar);
            epVar.b();
        }
        if (this.f566a != null) {
            epVar.a(f4675b);
            epVar.a(this.f566a);
            epVar.b();
        }
        if (this.f570b != null) {
            epVar.a(f4676c);
            epVar.a(this.f570b);
            epVar.b();
        }
        if (this.f571c != null) {
            epVar.a(f4677d);
            epVar.a(this.f571c);
            epVar.b();
        }
        epVar.a(f4678e);
        epVar.a(this.f564a);
        epVar.b();
        if (this.f572d != null && f()) {
            epVar.a(f4679f);
            epVar.a(this.f572d);
            epVar.b();
        }
        if (this.f573e != null && g()) {
            epVar.a(g);
            epVar.a(this.f573e);
            epVar.b();
        }
        if (this.f568a != null && h()) {
            epVar.a(h);
            epVar.a(new en(MqttWireMessage.MESSAGE_TYPE_UNSUBACK, this.f568a.size()));
            for (String a2 : this.f568a) {
                epVar.a(a2);
            }
            epVar.e();
            epVar.b();
        }
        if (this.f574f != null && i()) {
            epVar.a(i);
            epVar.a(this.f574f);
            epVar.b();
        }
        if (j()) {
            epVar.a(j);
            epVar.a(this.f569a);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public void b(boolean z) {
        this.f567a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m640b() {
        return this.f566a != null;
    }

    public String c() {
        return this.f574f;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m641c() {
        return this.f570b != null;
    }

    public boolean d() {
        return this.f571c != null;
    }

    public boolean e() {
        return this.f567a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dp)) {
            return compareTo((dp) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f572d != null;
    }

    public boolean g() {
        return this.f573e != null;
    }

    public boolean h() {
        return this.f568a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f574f != null;
    }

    public boolean j() {
        return this.f567a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (a()) {
            sb.append("target:");
            dk dkVar = this.f565a;
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
        String str = this.f566a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f570b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f571c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f564a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f572d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f573e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f568a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f574f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f569a);
        }
        sb.append(")");
        return sb.toString();
    }
}
