package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class dt implements ef<dt, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4688a = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f589a = new eu("XmPushActionNotification");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4689b = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4690c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4691d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4692e = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4693f = new em("", 2, 6);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7);
    public static final em h = new em("", 13, 8);
    public static final em i = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 9);
    public static final em j = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10);
    public static final em k = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 12);
    public static final em l = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 13);
    public static final em m = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 14);
    public static final em n = new em("", 10, 15);
    public static final em o = new em("", 2, 20);

    /* renamed from: a  reason: collision with other field name */
    public long f590a;

    /* renamed from: a  reason: collision with other field name */
    public dk f591a;

    /* renamed from: a  reason: collision with other field name */
    public String f592a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f593a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f594a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f595a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f596a;

    /* renamed from: b  reason: collision with other field name */
    public String f597b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f598b;

    /* renamed from: c  reason: collision with other field name */
    public String f599c;

    /* renamed from: d  reason: collision with other field name */
    public String f600d;

    /* renamed from: e  reason: collision with other field name */
    public String f601e;

    /* renamed from: f  reason: collision with other field name */
    public String f602f;

    /* renamed from: g  reason: collision with other field name */
    public String f603g;

    /* renamed from: h  reason: collision with other field name */
    public String f604h;

    /* renamed from: i  reason: collision with other field name */
    public String f605i;

    public dt() {
        this.f594a = new BitSet(3);
        this.f596a = true;
        this.f598b = false;
    }

    public dt(String str, boolean z) {
        this();
        this.f597b = str;
        this.f596a = z;
        a(true);
    }

    /* renamed from: a */
    public int compareTo(dt dtVar) {
        if (!dt.class.equals(dtVar.getClass())) {
            return dt.class.getName().compareTo(dt.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(dtVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f592a, dtVar.f592a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(dtVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a((Comparable) this.f591a, (Comparable) dtVar.f591a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(dtVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f597b, dtVar.f597b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(dtVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f599c, dtVar.f599c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(dtVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f600d, dtVar.f600d);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(dtVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f596a, dtVar.f596a);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(dtVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f601e, dtVar.f601e);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(dtVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h()) {
            int a9 = eg.a((Map) this.f595a, (Map) dtVar.f595a);
            if (a9 != 0) {
                return a9;
            }
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(dtVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i()) {
            int a10 = eg.a(this.f602f, dtVar.f602f);
            if (a10 != 0) {
                return a10;
            }
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(dtVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j()) {
            int a11 = eg.a(this.f603g, dtVar.f603g);
            if (a11 != 0) {
                return a11;
            }
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(dtVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k()) {
            int a12 = eg.a(this.f604h, dtVar.f604h);
            if (a12 != 0) {
                return a12;
            }
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(dtVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l()) {
            int a13 = eg.a(this.f605i, dtVar.f605i);
            if (a13 != 0) {
                return a13;
            }
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(dtVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m()) {
            int a14 = eg.a((Comparable) this.f593a, (Comparable) dtVar.f593a);
            if (a14 != 0) {
                return a14;
            }
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(dtVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n()) {
            int a15 = eg.a(this.f590a, dtVar.f590a);
            if (a15 != 0) {
                return a15;
            }
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(dtVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o()) {
            int a16 = eg.a(this.f598b, dtVar.f598b);
            if (a16 != 0) {
                return a16;
            }
        }
        return 0;
    }

    public dk a() {
        return this.f591a;
    }

    public dt a(String str) {
        this.f597b = str;
        return this;
    }

    public dt a(ByteBuffer byteBuffer) {
        this.f593a = byteBuffer;
        return this;
    }

    public dt a(Map<String, String> map) {
        this.f595a = map;
        return this;
    }

    public dt a(boolean z) {
        this.f596a = z;
        a(true);
        return this;
    }

    public dt a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m657a() {
        return this.f597b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m658a() {
        return this.f595a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m659a() {
        if (this.f597b == null) {
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
            if (r1 != 0) goto L_0x002f
            r6.f()
            boolean r6 = r5.f()
            if (r6 == 0) goto L_0x0018
            r5.a()
            return
        L_0x0018:
            com.xiaomi.push.eq r6 = new com.xiaomi.push.eq
            java.lang.String r0 = "Required field 'requireAck' was not found in serialized data! Struct: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = r5.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x002f:
            short r0 = r0.f755a
            r2 = 2
            r3 = 1
            r4 = 11
            switch(r0) {
                case 1: goto L_0x00f3;
                case 2: goto L_0x00e4;
                case 3: goto L_0x00db;
                case 4: goto L_0x00d2;
                case 5: goto L_0x00c9;
                case 6: goto L_0x00bd;
                case 7: goto L_0x00b4;
                case 8: goto L_0x0088;
                case 9: goto L_0x007e;
                case 10: goto L_0x0074;
                case 11: goto L_0x0038;
                case 12: goto L_0x006a;
                case 13: goto L_0x0060;
                case 14: goto L_0x0056;
                case 15: goto L_0x0047;
                case 16: goto L_0x0038;
                case 17: goto L_0x0038;
                case 18: goto L_0x0038;
                case 19: goto L_0x0038;
                case 20: goto L_0x003a;
                default: goto L_0x0038;
            }
        L_0x0038:
            goto L_0x00fc
        L_0x003a:
            if (r1 != r2) goto L_0x00fc
            boolean r0 = r6.a()
            r5.f598b = r0
            r5.c(r3)
            goto L_0x00ff
        L_0x0047:
            r0 = 10
            if (r1 != r0) goto L_0x00fc
            long r0 = r6.a()
            r5.f590a = r0
            r5.b(r3)
            goto L_0x00ff
        L_0x0056:
            if (r1 != r4) goto L_0x00fc
            java.nio.ByteBuffer r0 = r6.a()
            r5.f593a = r0
            goto L_0x00ff
        L_0x0060:
            if (r1 != r4) goto L_0x00fc
            java.lang.String r0 = r6.a()
            r5.f605i = r0
            goto L_0x00ff
        L_0x006a:
            if (r1 != r4) goto L_0x00fc
            java.lang.String r0 = r6.a()
            r5.f604h = r0
            goto L_0x00ff
        L_0x0074:
            if (r1 != r4) goto L_0x00fc
            java.lang.String r0 = r6.a()
            r5.f603g = r0
            goto L_0x00ff
        L_0x007e:
            if (r1 != r4) goto L_0x00fc
            java.lang.String r0 = r6.a()
            r5.f602f = r0
            goto L_0x00ff
        L_0x0088:
            r0 = 13
            if (r1 != r0) goto L_0x00fc
            com.xiaomi.push.eo r0 = r6.a()
            java.util.HashMap r1 = new java.util.HashMap
            int r2 = r0.f757a
            int r2 = r2 * 2
            r1.<init>(r2)
            r5.f595a = r1
            r1 = 0
        L_0x009c:
            int r2 = r0.f757a
            if (r1 >= r2) goto L_0x00b0
            java.lang.String r2 = r6.a()
            java.lang.String r3 = r6.a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r5.f595a
            r4.put(r2, r3)
            int r1 = r1 + 1
            goto L_0x009c
        L_0x00b0:
            r6.h()
            goto L_0x00ff
        L_0x00b4:
            if (r1 != r4) goto L_0x00fc
            java.lang.String r0 = r6.a()
            r5.f601e = r0
            goto L_0x00ff
        L_0x00bd:
            if (r1 != r2) goto L_0x00fc
            boolean r0 = r6.a()
            r5.f596a = r0
            r5.a(r3)
            goto L_0x00ff
        L_0x00c9:
            if (r1 != r4) goto L_0x00fc
            java.lang.String r0 = r6.a()
            r5.f600d = r0
            goto L_0x00ff
        L_0x00d2:
            if (r1 != r4) goto L_0x00fc
            java.lang.String r0 = r6.a()
            r5.f599c = r0
            goto L_0x00ff
        L_0x00db:
            if (r1 != r4) goto L_0x00fc
            java.lang.String r0 = r6.a()
            r5.f597b = r0
            goto L_0x00ff
        L_0x00e4:
            r0 = 12
            if (r1 != r0) goto L_0x00fc
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r5.f591a = r0
            r0.a(r6)
            goto L_0x00ff
        L_0x00f3:
            if (r1 != r4) goto L_0x00fc
            java.lang.String r0 = r6.a()
            r5.f592a = r0
            goto L_0x00ff
        L_0x00fc:
            com.xiaomi.push.es.a(r6, r1)
        L_0x00ff:
            r6.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dt.a(com.xiaomi.push.ep):void");
    }

    public void a(String str, String str2) {
        if (this.f595a == null) {
            this.f595a = new HashMap();
        }
        this.f595a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m660a(boolean z) {
        this.f594a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m661a() {
        return this.f592a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m662a(dt dtVar) {
        if (dtVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = dtVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f592a.equals(dtVar.f592a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = dtVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f591a.compareTo(dtVar.f591a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dtVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f597b.equals(dtVar.f597b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dtVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f599c.equals(dtVar.f599c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = dtVar.e();
        if (((e2 || e3) && (!e2 || !e3 || !this.f600d.equals(dtVar.f600d))) || this.f596a != dtVar.f596a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dtVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f601e.equals(dtVar.f601e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dtVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f595a.equals(dtVar.f595a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = dtVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f602f.equals(dtVar.f602f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = dtVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f603g.equals(dtVar.f603g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = dtVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f604h.equals(dtVar.f604h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = dtVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.f605i.equals(dtVar.f605i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = dtVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.f593a.equals(dtVar.f593a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = dtVar.n();
        if ((n2 || n3) && (!n2 || !n3 || this.f590a != dtVar.f590a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = dtVar.o();
        return (!o2 && !o3) || (o2 && o3 && this.f598b == dtVar.f598b);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m663a() {
        a(eg.a(this.f593a));
        return this.f593a.array();
    }

    public dt b(String str) {
        this.f599c = str;
        return this;
    }

    public String b() {
        return this.f599c;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f589a);
        if (this.f592a != null && a()) {
            epVar.a(f4688a);
            epVar.a(this.f592a);
            epVar.b();
        }
        if (this.f591a != null && b()) {
            epVar.a(f4689b);
            this.f591a.b(epVar);
            epVar.b();
        }
        if (this.f597b != null) {
            epVar.a(f4690c);
            epVar.a(this.f597b);
            epVar.b();
        }
        if (this.f599c != null && d()) {
            epVar.a(f4691d);
            epVar.a(this.f599c);
            epVar.b();
        }
        if (this.f600d != null && e()) {
            epVar.a(f4692e);
            epVar.a(this.f600d);
            epVar.b();
        }
        epVar.a(f4693f);
        epVar.a(this.f596a);
        epVar.b();
        if (this.f601e != null && g()) {
            epVar.a(g);
            epVar.a(this.f601e);
            epVar.b();
        }
        if (this.f595a != null && h()) {
            epVar.a(h);
            epVar.a(new eo(MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, this.f595a.size()));
            for (Entry next : this.f595a.entrySet()) {
                epVar.a((String) next.getKey());
                epVar.a((String) next.getValue());
            }
            epVar.d();
            epVar.b();
        }
        if (this.f602f != null && i()) {
            epVar.a(i);
            epVar.a(this.f602f);
            epVar.b();
        }
        if (this.f603g != null && j()) {
            epVar.a(j);
            epVar.a(this.f603g);
            epVar.b();
        }
        if (this.f604h != null && k()) {
            epVar.a(k);
            epVar.a(this.f604h);
            epVar.b();
        }
        if (this.f605i != null && l()) {
            epVar.a(l);
            epVar.a(this.f605i);
            epVar.b();
        }
        if (this.f593a != null && m()) {
            epVar.a(m);
            epVar.a(this.f593a);
            epVar.b();
        }
        if (n()) {
            epVar.a(n);
            epVar.a(this.f590a);
            epVar.b();
        }
        if (o()) {
            epVar.a(o);
            epVar.a(this.f598b);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public void b(boolean z) {
        this.f594a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m664b() {
        return this.f591a != null;
    }

    public dt c(String str) {
        this.f600d = str;
        return this;
    }

    public String c() {
        return this.f602f;
    }

    public void c(boolean z) {
        this.f594a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m665c() {
        return this.f597b != null;
    }

    public dt d(String str) {
        this.f602f = str;
        return this;
    }

    public boolean d() {
        return this.f599c != null;
    }

    public boolean e() {
        return this.f600d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dt)) {
            return compareTo((dt) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f594a.get(0);
    }

    public boolean g() {
        return this.f601e != null;
    }

    public boolean h() {
        return this.f595a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f602f != null;
    }

    public boolean j() {
        return this.f603g != null;
    }

    public boolean k() {
        return this.f604h != null;
    }

    public boolean l() {
        return this.f605i != null;
    }

    public boolean m() {
        return this.f593a != null;
    }

    public boolean n() {
        return this.f594a.get(1);
    }

    public boolean o() {
        return this.f594a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.f592a;
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
            dk dkVar = this.f591a;
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
        String str2 = this.f597b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f599c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f600d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f596a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f601e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f595a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f602f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f603g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f604h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f605i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f593a;
            if (byteBuffer == null) {
                sb.append("null");
            } else {
                eg.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f590a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f598b);
        }
        sb.append(")");
        return sb.toString();
    }
}
