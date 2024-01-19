package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* renamed from: com.xiaomi.push.do  reason: invalid class name */
public class Cdo implements ef<Cdo, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4668a = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f551a = new eu("XmPushActionCommand");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4669b = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4670c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4671d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 5);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4672e = new em("", 15, 6);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4673f = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 9);
    public static final em h = new em("", 2, 10);
    public static final em i = new em("", 2, 11);
    public static final em j = new em("", 10, 12);

    /* renamed from: a  reason: collision with other field name */
    public long f552a;

    /* renamed from: a  reason: collision with other field name */
    public dk f553a;

    /* renamed from: a  reason: collision with other field name */
    public String f554a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f555a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public List<String> f556a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f557a = false;

    /* renamed from: b  reason: collision with other field name */
    public String f558b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f559b = true;

    /* renamed from: c  reason: collision with other field name */
    public String f560c;

    /* renamed from: d  reason: collision with other field name */
    public String f561d;

    /* renamed from: e  reason: collision with other field name */
    public String f562e;

    /* renamed from: a */
    public int compareTo(Cdo doVar) {
        if (!Cdo.class.equals(doVar.getClass())) {
            return Cdo.class.getName().compareTo(Cdo.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(doVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a((Comparable) this.f553a, (Comparable) doVar.f553a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(doVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a(this.f554a, doVar.f554a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(doVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f558b, doVar.f558b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(doVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f560c, doVar.f560c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(doVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a((List) this.f556a, (List) doVar.f556a);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(doVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f561d, doVar.f561d);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(doVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f562e, doVar.f562e);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(doVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h()) {
            int a9 = eg.a(this.f557a, doVar.f557a);
            if (a9 != 0) {
                return a9;
            }
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(doVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i()) {
            int a10 = eg.a(this.f559b, doVar.f559b);
            if (a10 != 0) {
                return a10;
            }
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(doVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j()) {
            int a11 = eg.a(this.f552a, doVar.f552a);
            if (a11 != 0) {
                return a11;
            }
        }
        return 0;
    }

    public Cdo a(String str) {
        this.f554a = str;
        return this;
    }

    public void a() {
        if (this.f554a == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'id' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        } else if (this.f558b == null) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Required field 'appId' was not present! Struct: ");
            outline732.append(toString());
            throw new eq(outline732.toString());
        } else if (this.f560c == null) {
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("Required field 'cmdName' was not present! Struct: ");
            outline733.append(toString());
            throw new eq(outline733.toString());
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
            r3 = 1
            r4 = 11
            switch(r0) {
                case 2: goto L_0x009b;
                case 3: goto L_0x0092;
                case 4: goto L_0x0089;
                case 5: goto L_0x0080;
                case 6: goto L_0x005a;
                case 7: goto L_0x0051;
                case 8: goto L_0x001b;
                case 9: goto L_0x0048;
                case 10: goto L_0x003c;
                case 11: goto L_0x002f;
                case 12: goto L_0x0020;
                default: goto L_0x001b;
            }
        L_0x001b:
            com.xiaomi.push.es.a(r6, r1)
            goto L_0x00a9
        L_0x0020:
            r0 = 10
            if (r1 != r0) goto L_0x001b
            long r0 = r6.a()
            r5.f552a = r0
            r5.c(r3)
            goto L_0x00a9
        L_0x002f:
            if (r1 != r2) goto L_0x001b
            boolean r0 = r6.a()
            r5.f559b = r0
            r5.b(r3)
            goto L_0x00a9
        L_0x003c:
            if (r1 != r2) goto L_0x001b
            boolean r0 = r6.a()
            r5.f557a = r0
            r5.a(r3)
            goto L_0x00a9
        L_0x0048:
            if (r1 != r4) goto L_0x001b
            java.lang.String r0 = r6.a()
            r5.f562e = r0
            goto L_0x00a9
        L_0x0051:
            if (r1 != r4) goto L_0x001b
            java.lang.String r0 = r6.a()
            r5.f561d = r0
            goto L_0x00a9
        L_0x005a:
            r0 = 15
            if (r1 != r0) goto L_0x001b
            com.xiaomi.push.en r0 = r6.a()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.f756a
            r1.<init>(r2)
            r5.f556a = r1
            r1 = 0
        L_0x006c:
            int r2 = r0.f756a
            if (r1 >= r2) goto L_0x007c
            java.lang.String r2 = r6.a()
            java.util.List<java.lang.String> r3 = r5.f556a
            r3.add(r2)
            int r1 = r1 + 1
            goto L_0x006c
        L_0x007c:
            r6.i()
            goto L_0x00a9
        L_0x0080:
            if (r1 != r4) goto L_0x001b
            java.lang.String r0 = r6.a()
            r5.f560c = r0
            goto L_0x00a9
        L_0x0089:
            if (r1 != r4) goto L_0x001b
            java.lang.String r0 = r6.a()
            r5.f558b = r0
            goto L_0x00a9
        L_0x0092:
            if (r1 != r4) goto L_0x001b
            java.lang.String r0 = r6.a()
            r5.f554a = r0
            goto L_0x00a9
        L_0x009b:
            r0 = 12
            if (r1 != r0) goto L_0x001b
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r5.f553a = r0
            r0.a(r6)
        L_0x00a9:
            r6.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.Cdo.a(com.xiaomi.push.ep):void");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m633a(String str) {
        if (this.f556a == null) {
            this.f556a = new ArrayList();
        }
        this.f556a.add(str);
    }

    public void a(boolean z) {
        this.f555a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m634a() {
        return this.f553a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m635a(Cdo doVar) {
        if (doVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = doVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f553a.compareTo(doVar.f553a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = doVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f554a.equals(doVar.f554a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = doVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f558b.equals(doVar.f558b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = doVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f560c.equals(doVar.f560c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = doVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f556a.equals(doVar.f556a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = doVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f561d.equals(doVar.f561d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = doVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f562e.equals(doVar.f562e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = doVar.h();
        if ((h2 || h3) && (!h2 || !h3 || this.f557a != doVar.f557a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = doVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.f559b != doVar.f559b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = doVar.j();
        return (!j2 && !j3) || (j2 && j3 && this.f552a == doVar.f552a);
    }

    public Cdo b(String str) {
        this.f558b = str;
        return this;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f551a);
        if (this.f553a != null && a()) {
            epVar.a(f4668a);
            this.f553a.b(epVar);
            epVar.b();
        }
        if (this.f554a != null) {
            epVar.a(f4669b);
            epVar.a(this.f554a);
            epVar.b();
        }
        if (this.f558b != null) {
            epVar.a(f4670c);
            epVar.a(this.f558b);
            epVar.b();
        }
        if (this.f560c != null) {
            epVar.a(f4671d);
            epVar.a(this.f560c);
            epVar.b();
        }
        if (this.f556a != null && e()) {
            epVar.a(f4672e);
            epVar.a(new en(MqttWireMessage.MESSAGE_TYPE_UNSUBACK, this.f556a.size()));
            for (String a2 : this.f556a) {
                epVar.a(a2);
            }
            epVar.e();
            epVar.b();
        }
        if (this.f561d != null && f()) {
            epVar.a(f4673f);
            epVar.a(this.f561d);
            epVar.b();
        }
        if (this.f562e != null && g()) {
            epVar.a(g);
            epVar.a(this.f562e);
            epVar.b();
        }
        if (h()) {
            epVar.a(h);
            epVar.a(this.f557a);
            epVar.b();
        }
        if (i()) {
            epVar.a(i);
            epVar.a(this.f559b);
            epVar.b();
        }
        if (j()) {
            epVar.a(j);
            epVar.a(this.f552a);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public void b(boolean z) {
        this.f555a.set(1, z);
    }

    public boolean b() {
        return this.f554a != null;
    }

    public Cdo c(String str) {
        this.f560c = str;
        return this;
    }

    public void c(boolean z) {
        this.f555a.set(2, z);
    }

    public boolean c() {
        return this.f558b != null;
    }

    public Cdo d(String str) {
        this.f561d = str;
        return this;
    }

    public boolean d() {
        return this.f560c != null;
    }

    public Cdo e(String str) {
        this.f562e = str;
        return this;
    }

    public boolean e() {
        return this.f556a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cdo)) {
            return compareTo((Cdo) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f561d != null;
    }

    public boolean g() {
        return this.f562e != null;
    }

    public boolean h() {
        return this.f555a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f555a.get(1);
    }

    public boolean j() {
        return this.f555a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (a()) {
            sb.append("target:");
            dk dkVar = this.f553a;
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
        String str = this.f554a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f558b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f560c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f556a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f561d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f562e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f557a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f559b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f552a);
        }
        sb.append(")");
        return sb.toString();
    }
}
