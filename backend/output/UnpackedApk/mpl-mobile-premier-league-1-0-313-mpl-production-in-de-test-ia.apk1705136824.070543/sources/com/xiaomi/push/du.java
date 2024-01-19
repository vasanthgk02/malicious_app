package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.push.service.aw;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class du implements ef<du, Object>, Serializable, Cloneable {
    public static final em A = new em("", 13, 100);
    public static final em B = new em("", 2, 101);
    public static final em C = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 102);

    /* renamed from: a  reason: collision with root package name */
    public static final em f4694a = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f606a = new eu("XmPushActionRegistration");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4695b = new em("", MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4696c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4697d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4698e = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4699f = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 6);
    public static final em g = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7);
    public static final em h = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 8);
    public static final em i = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 9);
    public static final em j = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10);
    public static final em k = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 11);
    public static final em l = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 12);
    public static final em m = new em("", 8, 13);
    public static final em n = new em("", 8, 14);
    public static final em o = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 15);
    public static final em p = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 16);
    public static final em q = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 17);
    public static final em r = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 18);
    public static final em s = new em("", 8, 19);
    public static final em t = new em("", 8, 20);
    public static final em u = new em("", 2, 21);
    public static final em v = new em("", 10, 22);
    public static final em w = new em("", 10, 23);
    public static final em x = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 24);
    public static final em y = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 25);
    public static final em z = new em("", 2, 26);

    /* renamed from: a  reason: collision with other field name */
    public int f607a;

    /* renamed from: a  reason: collision with other field name */
    public long f608a;

    /* renamed from: a  reason: collision with other field name */
    public dj f609a;

    /* renamed from: a  reason: collision with other field name */
    public dk f610a;

    /* renamed from: a  reason: collision with other field name */
    public String f611a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f612a = new BitSet(8);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f613a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f614a = true;

    /* renamed from: b  reason: collision with other field name */
    public int f615b;

    /* renamed from: b  reason: collision with other field name */
    public long f616b;

    /* renamed from: b  reason: collision with other field name */
    public String f617b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f618b = false;

    /* renamed from: c  reason: collision with other field name */
    public int f619c;

    /* renamed from: c  reason: collision with other field name */
    public String f620c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f621c = false;

    /* renamed from: d  reason: collision with other field name */
    public String f622d;

    /* renamed from: e  reason: collision with other field name */
    public String f623e;

    /* renamed from: f  reason: collision with other field name */
    public String f624f;

    /* renamed from: g  reason: collision with other field name */
    public String f625g;

    /* renamed from: h  reason: collision with other field name */
    public String f626h;

    /* renamed from: i  reason: collision with other field name */
    public String f627i;

    /* renamed from: j  reason: collision with other field name */
    public String f628j;

    /* renamed from: k  reason: collision with other field name */
    public String f629k;

    /* renamed from: l  reason: collision with other field name */
    public String f630l;

    /* renamed from: m  reason: collision with other field name */
    public String f631m;

    /* renamed from: n  reason: collision with other field name */
    public String f632n;

    /* renamed from: o  reason: collision with other field name */
    public String f633o;

    /* renamed from: p  reason: collision with other field name */
    public String f634p;

    /* renamed from: q  reason: collision with other field name */
    public String f635q;

    /* renamed from: r  reason: collision with other field name */
    public String f636r;

    public boolean A() {
        return this.f613a != null;
    }

    public boolean B() {
        return this.f612a.get(7);
    }

    public boolean C() {
        return this.f636r != null;
    }

    /* renamed from: a */
    public int compareTo(du duVar) {
        if (!du.class.equals(duVar.getClass())) {
            return du.class.getName().compareTo(du.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(duVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f611a, duVar.f611a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(duVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a((Comparable) this.f610a, (Comparable) duVar.f610a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(duVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f617b, duVar.f617b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(duVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f620c, duVar.f620c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(duVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f622d, duVar.f622d);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(duVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f623e, duVar.f623e);
            if (a7 != 0) {
                return a7;
            }
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(duVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g()) {
            int a8 = eg.a(this.f624f, duVar.f624f);
            if (a8 != 0) {
                return a8;
            }
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(duVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h()) {
            int a9 = eg.a(this.f625g, duVar.f625g);
            if (a9 != 0) {
                return a9;
            }
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(duVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i()) {
            int a10 = eg.a(this.f626h, duVar.f626h);
            if (a10 != 0) {
                return a10;
            }
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(duVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j()) {
            int a11 = eg.a(this.f627i, duVar.f627i);
            if (a11 != 0) {
                return a11;
            }
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(duVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k()) {
            int a12 = eg.a(this.f628j, duVar.f628j);
            if (a12 != 0) {
                return a12;
            }
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(duVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l()) {
            int a13 = eg.a(this.f629k, duVar.f629k);
            if (a13 != 0) {
                return a13;
            }
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(duVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m()) {
            int a14 = eg.a(this.f607a, duVar.f607a);
            if (a14 != 0) {
                return a14;
            }
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(duVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n()) {
            int a15 = eg.a(this.f615b, duVar.f615b);
            if (a15 != 0) {
                return a15;
            }
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(duVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o()) {
            int a16 = eg.a(this.f630l, duVar.f630l);
            if (a16 != 0) {
                return a16;
            }
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(duVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p()) {
            int a17 = eg.a(this.f631m, duVar.f631m);
            if (a17 != 0) {
                return a17;
            }
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(duVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q()) {
            int a18 = eg.a(this.f632n, duVar.f632n);
            if (a18 != 0) {
                return a18;
            }
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(duVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r()) {
            int a19 = eg.a(this.f633o, duVar.f633o);
            if (a19 != 0) {
                return a19;
            }
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(duVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s()) {
            int a20 = eg.a(this.f619c, duVar.f619c);
            if (a20 != 0) {
                return a20;
            }
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(duVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (t()) {
            int a21 = eg.a((Comparable) this.f609a, (Comparable) duVar.f609a);
            if (a21 != 0) {
                return a21;
            }
        }
        int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(duVar.u()));
        if (compareTo21 != 0) {
            return compareTo21;
        }
        if (u()) {
            int a22 = eg.a(this.f614a, duVar.f614a);
            if (a22 != 0) {
                return a22;
            }
        }
        int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(duVar.v()));
        if (compareTo22 != 0) {
            return compareTo22;
        }
        if (v()) {
            int a23 = eg.a(this.f608a, duVar.f608a);
            if (a23 != 0) {
                return a23;
            }
        }
        int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(duVar.w()));
        if (compareTo23 != 0) {
            return compareTo23;
        }
        if (w()) {
            int a24 = eg.a(this.f616b, duVar.f616b);
            if (a24 != 0) {
                return a24;
            }
        }
        int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(duVar.x()));
        if (compareTo24 != 0) {
            return compareTo24;
        }
        if (x()) {
            int a25 = eg.a(this.f634p, duVar.f634p);
            if (a25 != 0) {
                return a25;
            }
        }
        int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(duVar.y()));
        if (compareTo25 != 0) {
            return compareTo25;
        }
        if (y()) {
            int a26 = eg.a(this.f635q, duVar.f635q);
            if (a26 != 0) {
                return a26;
            }
        }
        int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(duVar.z()));
        if (compareTo26 != 0) {
            return compareTo26;
        }
        if (z()) {
            int a27 = eg.a(this.f618b, duVar.f618b);
            if (a27 != 0) {
                return a27;
            }
        }
        int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(duVar.A()));
        if (compareTo27 != 0) {
            return compareTo27;
        }
        if (A()) {
            int a28 = eg.a((Map) this.f613a, (Map) duVar.f613a);
            if (a28 != 0) {
                return a28;
            }
        }
        int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(duVar.B()));
        if (compareTo28 != 0) {
            return compareTo28;
        }
        if (B()) {
            int a29 = eg.a(this.f621c, duVar.f621c);
            if (a29 != 0) {
                return a29;
            }
        }
        int compareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(duVar.C()));
        if (compareTo29 != 0) {
            return compareTo29;
        }
        if (C()) {
            int a30 = eg.a(this.f636r, duVar.f636r);
            if (a30 != 0) {
                return a30;
            }
        }
        return 0;
    }

    public du a(int i2) {
        this.f607a = i2;
        a(true);
        return this;
    }

    public du a(dj djVar) {
        this.f609a = djVar;
        return this;
    }

    public du a(String str) {
        this.f617b = str;
        return this;
    }

    public String a() {
        return this.f617b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m666a() {
        if (this.f617b == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'id' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        } else if (this.f620c == null) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Required field 'appId' was not present! Struct: ");
            outline732.append(toString());
            throw new eq(outline732.toString());
        } else if (this.f624f == null) {
            StringBuilder outline733 = GeneratedOutlineSupport.outline73("Required field 'token' was not present! Struct: ");
            outline733.append(toString());
            throw new eq(outline733.toString());
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.xiaomi.push.ep r8) {
        /*
            r7 = this;
            r8.a()
        L_0x0003:
            com.xiaomi.push.em r0 = r8.a()
            byte r1 = r0.f4765a
            if (r1 != 0) goto L_0x0012
            r8.f()
            r7.a()
            return
        L_0x0012:
            short r0 = r0.f755a
            r2 = 10
            r3 = 2
            r4 = 8
            r5 = 1
            r6 = 11
            switch(r0) {
                case 1: goto L_0x017a;
                case 2: goto L_0x016b;
                case 3: goto L_0x0162;
                case 4: goto L_0x0159;
                case 5: goto L_0x0150;
                case 6: goto L_0x0147;
                case 7: goto L_0x013e;
                case 8: goto L_0x0135;
                case 9: goto L_0x012c;
                case 10: goto L_0x0123;
                case 11: goto L_0x011a;
                case 12: goto L_0x0110;
                case 13: goto L_0x0103;
                case 14: goto L_0x00f6;
                case 15: goto L_0x00ec;
                case 16: goto L_0x00e2;
                case 17: goto L_0x00d8;
                case 18: goto L_0x00ce;
                case 19: goto L_0x00c1;
                case 20: goto L_0x00b3;
                case 21: goto L_0x00a6;
                case 22: goto L_0x0099;
                case 23: goto L_0x008c;
                case 24: goto L_0x0082;
                case 25: goto L_0x0078;
                case 26: goto L_0x006b;
                default: goto L_0x001f;
            }
        L_0x001f:
            switch(r0) {
                case 100: goto L_0x003e;
                case 101: goto L_0x0031;
                case 102: goto L_0x0027;
                default: goto L_0x0022;
            }
        L_0x0022:
            com.xiaomi.push.es.a(r8, r1)
            goto L_0x0182
        L_0x0027:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f636r = r0
            goto L_0x0182
        L_0x0031:
            if (r1 != r3) goto L_0x0022
            boolean r0 = r8.a()
            r7.f621c = r0
            r7.h(r5)
            goto L_0x0182
        L_0x003e:
            r0 = 13
            if (r1 != r0) goto L_0x0022
            com.xiaomi.push.eo r0 = r8.a()
            java.util.HashMap r1 = new java.util.HashMap
            int r2 = r0.f757a
            int r2 = r2 * 2
            r1.<init>(r2)
            r7.f613a = r1
            r1 = 0
        L_0x0052:
            int r2 = r0.f757a
            if (r1 >= r2) goto L_0x0066
            java.lang.String r2 = r8.a()
            java.lang.String r3 = r8.a()
            java.util.Map<java.lang.String, java.lang.String> r4 = r7.f613a
            r4.put(r2, r3)
            int r1 = r1 + 1
            goto L_0x0052
        L_0x0066:
            r8.h()
            goto L_0x0182
        L_0x006b:
            if (r1 != r3) goto L_0x0022
            boolean r0 = r8.a()
            r7.f618b = r0
            r7.g(r5)
            goto L_0x0182
        L_0x0078:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f635q = r0
            goto L_0x0182
        L_0x0082:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f634p = r0
            goto L_0x0182
        L_0x008c:
            if (r1 != r2) goto L_0x0022
            long r0 = r8.a()
            r7.f616b = r0
            r7.f(r5)
            goto L_0x0182
        L_0x0099:
            if (r1 != r2) goto L_0x0022
            long r0 = r8.a()
            r7.f608a = r0
            r7.e(r5)
            goto L_0x0182
        L_0x00a6:
            if (r1 != r3) goto L_0x0022
            boolean r0 = r8.a()
            r7.f614a = r0
            r7.d(r5)
            goto L_0x0182
        L_0x00b3:
            if (r1 != r4) goto L_0x0022
            int r0 = r8.a()
            com.xiaomi.push.dj r0 = com.xiaomi.push.dj.a(r0)
            r7.f609a = r0
            goto L_0x0182
        L_0x00c1:
            if (r1 != r4) goto L_0x0022
            int r0 = r8.a()
            r7.f619c = r0
            r7.c(r5)
            goto L_0x0182
        L_0x00ce:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f633o = r0
            goto L_0x0182
        L_0x00d8:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f632n = r0
            goto L_0x0182
        L_0x00e2:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f631m = r0
            goto L_0x0182
        L_0x00ec:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f630l = r0
            goto L_0x0182
        L_0x00f6:
            if (r1 != r4) goto L_0x0022
            int r0 = r8.a()
            r7.f615b = r0
            r7.b(r5)
            goto L_0x0182
        L_0x0103:
            if (r1 != r4) goto L_0x0022
            int r0 = r8.a()
            r7.f607a = r0
            r7.a(r5)
            goto L_0x0182
        L_0x0110:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f629k = r0
            goto L_0x0182
        L_0x011a:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f628j = r0
            goto L_0x0182
        L_0x0123:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f627i = r0
            goto L_0x0182
        L_0x012c:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f626h = r0
            goto L_0x0182
        L_0x0135:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f625g = r0
            goto L_0x0182
        L_0x013e:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f624f = r0
            goto L_0x0182
        L_0x0147:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f623e = r0
            goto L_0x0182
        L_0x0150:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f622d = r0
            goto L_0x0182
        L_0x0159:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f620c = r0
            goto L_0x0182
        L_0x0162:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f617b = r0
            goto L_0x0182
        L_0x016b:
            r0 = 12
            if (r1 != r0) goto L_0x0022
            com.xiaomi.push.dk r0 = new com.xiaomi.push.dk
            r0.<init>()
            r7.f610a = r0
            r0.a(r8)
            goto L_0x0182
        L_0x017a:
            if (r1 != r6) goto L_0x0022
            java.lang.String r0 = r8.a()
            r7.f611a = r0
        L_0x0182:
            r8.g()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.du.a(com.xiaomi.push.ep):void");
    }

    public void a(boolean z2) {
        this.f612a.set(0, z2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m667a() {
        return this.f611a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m668a(du duVar) {
        if (duVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = duVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f611a.equals(duVar.f611a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = duVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f610a.compareTo(duVar.f610a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = duVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f617b.equals(duVar.f617b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = duVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f620c.equals(duVar.f620c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = duVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f622d.equals(duVar.f622d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = duVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f623e.equals(duVar.f623e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = duVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f624f.equals(duVar.f624f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = duVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f625g.equals(duVar.f625g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = duVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f626h.equals(duVar.f626h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = duVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f627i.equals(duVar.f627i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = duVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f628j.equals(duVar.f628j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = duVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.f629k.equals(duVar.f629k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = duVar.m();
        if ((m2 || m3) && (!m2 || !m3 || this.f607a != duVar.f607a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = duVar.n();
        if ((n2 || n3) && (!n2 || !n3 || this.f615b != duVar.f615b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = duVar.o();
        if ((o2 || o3) && (!o2 || !o3 || !this.f630l.equals(duVar.f630l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = duVar.p();
        if ((p2 || p3) && (!p2 || !p3 || !this.f631m.equals(duVar.f631m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = duVar.q();
        if ((q2 || q3) && (!q2 || !q3 || !this.f632n.equals(duVar.f632n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = duVar.r();
        if ((r2 || r3) && (!r2 || !r3 || !this.f633o.equals(duVar.f633o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = duVar.s();
        if ((s2 || s3) && (!s2 || !s3 || this.f619c != duVar.f619c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = duVar.t();
        if ((t2 || t3) && (!t2 || !t3 || !this.f609a.equals(duVar.f609a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = duVar.u();
        if ((u2 || u3) && (!u2 || !u3 || this.f614a != duVar.f614a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = duVar.v();
        if ((v2 || v3) && (!v2 || !v3 || this.f608a != duVar.f608a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = duVar.w();
        if ((w2 || w3) && (!w2 || !w3 || this.f616b != duVar.f616b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = duVar.x();
        if ((x2 || x3) && (!x2 || !x3 || !this.f634p.equals(duVar.f634p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = duVar.y();
        if ((y2 || y3) && (!y2 || !y3 || !this.f635q.equals(duVar.f635q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = duVar.z();
        if ((z2 || z3) && (!z2 || !z3 || this.f618b != duVar.f618b)) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = duVar.A();
        if ((A2 || A3) && (!A2 || !A3 || !this.f613a.equals(duVar.f613a))) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = duVar.B();
        if ((B2 || B3) && (!B2 || !B3 || this.f621c != duVar.f621c)) {
            return false;
        }
        boolean C2 = C();
        boolean C3 = duVar.C();
        return (!C2 && !C3) || (C2 && C3 && this.f636r.equals(duVar.f636r));
    }

    public du b(int i2) {
        this.f615b = i2;
        b(true);
        return this;
    }

    public du b(String str) {
        this.f620c = str;
        return this;
    }

    public String b() {
        return this.f620c;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f606a);
        if (this.f611a != null && a()) {
            epVar.a(f4694a);
            epVar.a(this.f611a);
            epVar.b();
        }
        if (this.f610a != null && b()) {
            epVar.a(f4695b);
            this.f610a.b(epVar);
            epVar.b();
        }
        if (this.f617b != null) {
            epVar.a(f4696c);
            epVar.a(this.f617b);
            epVar.b();
        }
        if (this.f620c != null) {
            epVar.a(f4697d);
            epVar.a(this.f620c);
            epVar.b();
        }
        if (this.f622d != null && e()) {
            epVar.a(f4698e);
            epVar.a(this.f622d);
            epVar.b();
        }
        if (this.f623e != null && f()) {
            epVar.a(f4699f);
            epVar.a(this.f623e);
            epVar.b();
        }
        if (this.f624f != null) {
            epVar.a(g);
            epVar.a(this.f624f);
            epVar.b();
        }
        if (this.f625g != null && h()) {
            epVar.a(h);
            epVar.a(this.f625g);
            epVar.b();
        }
        if (this.f626h != null && i()) {
            epVar.a(i);
            epVar.a(this.f626h);
            epVar.b();
        }
        if (this.f627i != null && j()) {
            epVar.a(j);
            epVar.a(this.f627i);
            epVar.b();
        }
        if (this.f628j != null && k()) {
            epVar.a(k);
            epVar.a(this.f628j);
            epVar.b();
        }
        if (this.f629k != null && l()) {
            epVar.a(l);
            epVar.a(this.f629k);
            epVar.b();
        }
        if (m()) {
            epVar.a(m);
            epVar.a(this.f607a);
            epVar.b();
        }
        if (n()) {
            epVar.a(n);
            epVar.a(this.f615b);
            epVar.b();
        }
        if (this.f630l != null && o()) {
            epVar.a(o);
            epVar.a(this.f630l);
            epVar.b();
        }
        if (this.f631m != null && p()) {
            epVar.a(p);
            epVar.a(this.f631m);
            epVar.b();
        }
        if (this.f632n != null && q()) {
            epVar.a(q);
            epVar.a(this.f632n);
            epVar.b();
        }
        if (this.f633o != null && r()) {
            epVar.a(r);
            epVar.a(this.f633o);
            epVar.b();
        }
        if (s()) {
            epVar.a(s);
            epVar.a(this.f619c);
            epVar.b();
        }
        if (this.f609a != null && t()) {
            epVar.a(t);
            epVar.a(this.f609a.a());
            epVar.b();
        }
        if (u()) {
            epVar.a(u);
            epVar.a(this.f614a);
            epVar.b();
        }
        if (v()) {
            epVar.a(v);
            epVar.a(this.f608a);
            epVar.b();
        }
        if (w()) {
            epVar.a(w);
            epVar.a(this.f616b);
            epVar.b();
        }
        if (this.f634p != null && x()) {
            epVar.a(x);
            epVar.a(this.f634p);
            epVar.b();
        }
        if (this.f635q != null && y()) {
            epVar.a(y);
            epVar.a(this.f635q);
            epVar.b();
        }
        if (z()) {
            epVar.a(z);
            epVar.a(this.f618b);
            epVar.b();
        }
        if (this.f613a != null && A()) {
            epVar.a(A);
            epVar.a(new eo(MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, this.f613a.size()));
            for (Entry next : this.f613a.entrySet()) {
                epVar.a((String) next.getKey());
                epVar.a((String) next.getValue());
            }
            epVar.d();
            epVar.b();
        }
        if (B()) {
            epVar.a(B);
            epVar.a(this.f621c);
            epVar.b();
        }
        if (this.f636r != null && C()) {
            epVar.a(C);
            epVar.a(this.f636r);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public void b(boolean z2) {
        this.f612a.set(1, z2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m669b() {
        return this.f610a != null;
    }

    public du c(int i2) {
        this.f619c = i2;
        c(true);
        return this;
    }

    public du c(String str) {
        this.f622d = str;
        return this;
    }

    public String c() {
        return this.f624f;
    }

    public void c(boolean z2) {
        this.f612a.set(2, z2);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m670c() {
        return this.f617b != null;
    }

    public du d(String str) {
        this.f623e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f612a.set(3, z2);
    }

    public boolean d() {
        return this.f620c != null;
    }

    public du e(String str) {
        this.f624f = str;
        return this;
    }

    public void e(boolean z2) {
        this.f612a.set(4, z2);
    }

    public boolean e() {
        return this.f622d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof du)) {
            return compareTo((du) obj);
        }
        return false;
    }

    public du f(String str) {
        this.f625g = str;
        return this;
    }

    public void f(boolean z2) {
        this.f612a.set(5, z2);
    }

    public boolean f() {
        return this.f623e != null;
    }

    public du g(String str) {
        this.f626h = str;
        return this;
    }

    public void g(boolean z2) {
        this.f612a.set(6, z2);
    }

    public boolean g() {
        return this.f624f != null;
    }

    public du h(String str) {
        this.f629k = str;
        return this;
    }

    public void h(boolean z2) {
        this.f612a.set(7, z2);
    }

    public boolean h() {
        return this.f625g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f626h != null;
    }

    public boolean j() {
        return this.f627i != null;
    }

    public boolean k() {
        return this.f628j != null;
    }

    public boolean l() {
        return this.f629k != null;
    }

    public boolean m() {
        return this.f612a.get(0);
    }

    public boolean n() {
        return this.f612a.get(1);
    }

    public boolean o() {
        return this.f630l != null;
    }

    public boolean p() {
        return this.f631m != null;
    }

    public boolean q() {
        return this.f632n != null;
    }

    public boolean r() {
        return this.f633o != null;
    }

    public boolean s() {
        return this.f612a.get(2);
    }

    public boolean t() {
        return this.f609a != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.f611a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            dk dkVar = this.f610a;
            if (dkVar == null) {
                sb.append("null");
            } else {
                sb.append(dkVar);
            }
        } else {
            z3 = z2;
        }
        if (!z3) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f617b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(aw.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f620c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f622d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f623e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f624f;
        if (str6 == null) {
            sb.append("null");
        } else {
            sb.append(str6);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f625g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f626h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f627i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.f628j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.f629k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f607a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f615b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.f630l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.f631m;
            if (str13 == null) {
                sb.append("null");
            } else {
                sb.append(str13);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.f632n;
            if (str14 == null) {
                sb.append("null");
            } else {
                sb.append(str14);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.f633o;
            if (str15 == null) {
                sb.append("null");
            } else {
                sb.append(str15);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f619c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            dj djVar = this.f609a;
            if (djVar == null) {
                sb.append("null");
            } else {
                sb.append(djVar);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f614a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f608a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f616b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.f634p;
            if (str16 == null) {
                sb.append("null");
            } else {
                sb.append(str16);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.f635q;
            if (str17 == null) {
                sb.append("null");
            } else {
                sb.append(str17);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f618b);
        }
        if (A()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f613a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (B()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f621c);
        }
        if (C()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.f636r;
            if (str18 == null) {
                sb.append("null");
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f612a.get(3);
    }

    public boolean v() {
        return this.f612a.get(4);
    }

    public boolean w() {
        return this.f612a.get(5);
    }

    public boolean x() {
        return this.f634p != null;
    }

    public boolean y() {
        return this.f635q != null;
    }

    public boolean z() {
        return this.f612a.get(6);
    }
}
