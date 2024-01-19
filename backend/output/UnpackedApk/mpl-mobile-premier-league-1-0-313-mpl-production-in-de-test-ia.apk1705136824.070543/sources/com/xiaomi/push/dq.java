package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class dq implements ef<dq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4680a = new em("", 8, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f575a = new eu("XmPushActionContainer");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4681b = new em("", 2, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4682c = new em("", 2, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4683d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4684e = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4685f = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 6);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 7);
    public static final em h = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 8);

    /* renamed from: a  reason: collision with other field name */
    public cz f576a;

    /* renamed from: a  reason: collision with other field name */
    public di f577a;

    /* renamed from: a  reason: collision with other field name */
    public dk f578a;

    /* renamed from: a  reason: collision with other field name */
    public String f579a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f580a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f581a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f582a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f583b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f584b = true;

    /* renamed from: a */
    public int compareTo(dq dqVar) {
        if (!dq.class.equals(dqVar.getClass())) {
            return dq.class.getName().compareTo(dq.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(dqVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a((Comparable) this.f576a, (Comparable) dqVar.f576a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(dqVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c()) {
            int a3 = eg.a(this.f582a, dqVar.f582a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(dqVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d()) {
            int a4 = eg.a(this.f584b, dqVar.f584b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(dqVar.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e()) {
            int a5 = eg.a((Comparable) this.f580a, (Comparable) dqVar.f580a);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(dqVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f()) {
            int a6 = eg.a(this.f579a, dqVar.f579a);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(dqVar.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g()) {
            int a7 = eg.a(this.f583b, dqVar.f583b);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(dqVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h()) {
            int a8 = eg.a((Comparable) this.f578a, (Comparable) dqVar.f578a);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(dqVar.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (i()) {
            int a9 = eg.a((Comparable) this.f577a, (Comparable) dqVar.f577a);
            if (a9 != 0) {
                return a9;
            }
        }
        return 0;
    }

    public cz a() {
        return this.f576a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public di m642a() {
        return this.f577a;
    }

    public dq a(cz czVar) {
        this.f576a = czVar;
        return this;
    }

    public dq a(di diVar) {
        this.f577a = diVar;
        return this;
    }

    public dq a(dk dkVar) {
        this.f578a = dkVar;
        return this;
    }

    public dq a(String str) {
        this.f579a = str;
        return this;
    }

    public dq a(ByteBuffer byteBuffer) {
        this.f580a = byteBuffer;
        return this;
    }

    public dq a(boolean z) {
        this.f582a = z;
        a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m643a() {
        return this.f579a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m644a() {
        if (this.f576a == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'action' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        } else if (this.f580a == null) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Required field 'pushAction' was not present! Struct: ");
            outline732.append(toString());
            throw new eq(outline732.toString());
        } else if (this.f578a == null) {
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("Required field 'target' was not present! Struct: ");
            outline733.append(toString());
            throw new eq(outline733.toString());
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.xiaomi.push.ep r7) {
        /*
            r6 = this;
            r7.a()
        L_0x0003:
            com.xiaomi.push.em r0 = r7.a()
            byte r1 = r0.f4765a
            if (r1 != 0) goto L_0x004c
            r7.f()
            boolean r7 = r6.c()
            if (r7 == 0) goto L_0x0035
            boolean r7 = r6.d()
            if (r7 == 0) goto L_0x001e
            r6.a()
            return
        L_0x001e:
            com.xiaomi.push.eq r7 = new com.xiaomi.push.eq
            java.lang.String r0 = "Required field 'isRequest' was not found in serialized data! Struct: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x0035:
            com.xiaomi.push.eq r7 = new com.xiaomi.push.eq
            java.lang.String r0 = "Required field 'encryptAction' was not found in serialized data! Struct: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = r6.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x004c:
            short r0 = r0.f755a
            r2 = 1
            r3 = 12
            r4 = 2
            r5 = 11
            switch(r0) {
                case 1: goto L_0x00a5;
                case 2: goto L_0x0099;
                case 3: goto L_0x008d;
                case 4: goto L_0x0084;
                case 5: goto L_0x007b;
                case 6: goto L_0x0072;
                case 7: goto L_0x0065;
                case 8: goto L_0x0058;
                default: goto L_0x0057;
            }
        L_0x0057:
            goto L_0x00b4
        L_0x0058:
            if (r1 != r3) goto L_0x00b4
            com.xiaomi.push.di r0 = new com.xiaomi.push.di
            r0.<init>()
            r6.f577a = r0
            r0.a(r7)
            goto L_0x00b7
        L_0x0065:
            if (r1 != r3) goto L_0x00b4
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r6.f578a = r0
            r0.a(r7)
            goto L_0x00b7
        L_0x0072:
            if (r1 != r5) goto L_0x00b4
            java.lang.String r0 = r7.a()
            r6.f583b = r0
            goto L_0x00b7
        L_0x007b:
            if (r1 != r5) goto L_0x00b4
            java.lang.String r0 = r7.a()
            r6.f579a = r0
            goto L_0x00b7
        L_0x0084:
            if (r1 != r5) goto L_0x00b4
            java.nio.ByteBuffer r0 = r7.a()
            r6.f580a = r0
            goto L_0x00b7
        L_0x008d:
            if (r1 != r4) goto L_0x00b4
            boolean r0 = r7.a()
            r6.f584b = r0
            r6.b(r2)
            goto L_0x00b7
        L_0x0099:
            if (r1 != r4) goto L_0x00b4
            boolean r0 = r7.a()
            r6.f582a = r0
            r6.a(r2)
            goto L_0x00b7
        L_0x00a5:
            r0 = 8
            if (r1 != r0) goto L_0x00b4
            int r0 = r7.a()
            com.xiaomi.push.cz r0 = com.xiaomi.push.cz.a(r0)
            r6.f576a = r0
            goto L_0x00b7
        L_0x00b4:
            com.xiaomi.push.es.a(r7, r1)
        L_0x00b7:
            r7.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dq.a(com.xiaomi.push.ep):void");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m645a(boolean z) {
        this.f581a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m646a() {
        return this.f576a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m647a(dq dqVar) {
        if (dqVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = dqVar.a();
        if (((a2 || a3) && (!a2 || !a3 || !this.f576a.equals(dqVar.f576a))) || this.f582a != dqVar.f582a || this.f584b != dqVar.f584b) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = dqVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f580a.equals(dqVar.f580a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dqVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f579a.equals(dqVar.f579a))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = dqVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f583b.equals(dqVar.f583b))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = dqVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f578a.compareTo(dqVar.f578a))) {
            return false;
        }
        boolean i = i();
        boolean i2 = dqVar.i();
        return (!i && !i2) || (i && i2 && this.f577a.compareTo(dqVar.f577a));
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m648a() {
        a(eg.a(this.f580a));
        return this.f580a.array();
    }

    public dq b(String str) {
        this.f583b = str;
        return this;
    }

    public dq b(boolean z) {
        this.f584b = z;
        b(true);
        return this;
    }

    public String b() {
        return this.f583b;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f575a);
        if (this.f576a != null) {
            epVar.a(f4680a);
            epVar.a(this.f576a.a());
            epVar.b();
        }
        epVar.a(f4681b);
        epVar.a(this.f582a);
        epVar.b();
        epVar.a(f4682c);
        epVar.a(this.f584b);
        epVar.b();
        if (this.f580a != null) {
            epVar.a(f4683d);
            epVar.a(this.f580a);
            epVar.b();
        }
        if (this.f579a != null && f()) {
            epVar.a(f4684e);
            epVar.a(this.f579a);
            epVar.b();
        }
        if (this.f583b != null && g()) {
            epVar.a(f4685f);
            epVar.a(this.f583b);
            epVar.b();
        }
        if (this.f578a != null) {
            epVar.a(g);
            this.f578a.b(epVar);
            epVar.b();
        }
        if (this.f577a != null && i()) {
            epVar.a(h);
            this.f577a.b(epVar);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m649b(boolean z) {
        this.f581a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m650b() {
        return this.f582a;
    }

    public boolean c() {
        return this.f581a.get(0);
    }

    public boolean d() {
        return this.f581a.get(1);
    }

    public boolean e() {
        return this.f580a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dq)) {
            return compareTo((dq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f579a != null;
    }

    public boolean g() {
        return this.f583b != null;
    }

    public boolean h() {
        return this.f578a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f577a != null;
    }

    public String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("XmPushActionContainer(", "action:");
        cz czVar = this.f576a;
        if (czVar == null) {
            outline77.append("null");
        } else {
            outline77.append(czVar);
        }
        outline77.append(", ");
        outline77.append("encryptAction:");
        outline77.append(this.f582a);
        outline77.append(", ");
        outline77.append("isRequest:");
        outline77.append(this.f584b);
        if (f()) {
            outline77.append(", ");
            outline77.append("appid:");
            String str = this.f579a;
            if (str == null) {
                outline77.append("null");
            } else {
                outline77.append(str);
            }
        }
        if (g()) {
            outline77.append(", ");
            outline77.append("packageName:");
            String str2 = this.f583b;
            if (str2 == null) {
                outline77.append("null");
            } else {
                outline77.append(str2);
            }
        }
        outline77.append(", ");
        outline77.append("target:");
        dk dkVar = this.f578a;
        if (dkVar == null) {
            outline77.append("null");
        } else {
            outline77.append(dkVar);
        }
        if (i()) {
            outline77.append(", ");
            outline77.append("metaInfo:");
            di diVar = this.f577a;
            if (diVar == null) {
                outline77.append("null");
            } else {
                outline77.append(diVar);
            }
        }
        outline77.append(")");
        return outline77.toString();
    }
}
