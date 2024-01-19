package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.BitSet;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class dk implements ef<dk, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4648a = new em("", 10, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f505a = new eu("Target");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4649b = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4650c = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final em f4651d = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final em f4652e = new em("", 2, 5);

    /* renamed from: f  reason: collision with root package name */
    public static final em f4653f = new em("", MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7);

    /* renamed from: a  reason: collision with other field name */
    public long f506a = 5;

    /* renamed from: a  reason: collision with other field name */
    public String f507a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f508a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f509a = false;

    /* renamed from: b  reason: collision with other field name */
    public String f510b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f511c = "";

    /* renamed from: d  reason: collision with other field name */
    public String f512d;

    /* renamed from: a */
    public int compareTo(dk dkVar) {
        if (!dk.class.equals(dkVar.getClass())) {
            return dk.class.getName().compareTo(dk.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(dkVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f506a, dkVar.f506a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(dkVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a(this.f507a, dkVar.f507a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(dkVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a(this.f510b, dkVar.f510b);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(dkVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d()) {
            int a5 = eg.a(this.f511c, dkVar.f511c);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(dkVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e()) {
            int a6 = eg.a(this.f509a, dkVar.f509a);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(dkVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f()) {
            int a7 = eg.a(this.f512d, dkVar.f512d);
            if (a7 != 0) {
                return a7;
            }
        }
        return 0;
    }

    public void a() {
        if (this.f507a == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'userId' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        }
    }

    public void a(ep epVar) {
        epVar.a();
        while (true) {
            em a2 = epVar.a();
            byte b2 = a2.f4765a;
            if (b2 == 0) {
                break;
            }
            short s = a2.f755a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            if (s != 5) {
                                if (s == 7 && b2 == 11) {
                                    this.f512d = epVar.a();
                                    epVar.g();
                                }
                            } else if (b2 == 2) {
                                this.f509a = epVar.a();
                                b(true);
                                epVar.g();
                            }
                        } else if (b2 == 11) {
                            this.f511c = epVar.a();
                            epVar.g();
                        }
                    } else if (b2 == 11) {
                        this.f510b = epVar.a();
                        epVar.g();
                    }
                } else if (b2 == 11) {
                    this.f507a = epVar.a();
                    epVar.g();
                }
            } else if (b2 == 10) {
                this.f506a = epVar.a();
                a(true);
                epVar.g();
            }
            es.a(epVar, b2);
            epVar.g();
        }
        epVar.f();
        if (a()) {
            a();
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'channelId' was not found in serialized data! Struct: ");
        outline73.append(toString());
        throw new eq(outline73.toString());
    }

    public void a(boolean z) {
        this.f508a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m622a() {
        return this.f508a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m623a(dk dkVar) {
        if (dkVar == null || this.f506a != dkVar.f506a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = dkVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f507a.equals(dkVar.f507a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = dkVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f510b.equals(dkVar.f510b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = dkVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f511c.equals(dkVar.f511c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = dkVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f509a != dkVar.f509a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = dkVar.f();
        return (!f2 && !f3) || (f2 && f3 && this.f512d.equals(dkVar.f512d));
    }

    public void b(ep epVar) {
        a();
        epVar.a(f505a);
        epVar.a(f4648a);
        epVar.a(this.f506a);
        epVar.b();
        if (this.f507a != null) {
            epVar.a(f4649b);
            epVar.a(this.f507a);
            epVar.b();
        }
        if (this.f510b != null && c()) {
            epVar.a(f4650c);
            epVar.a(this.f510b);
            epVar.b();
        }
        if (this.f511c != null && d()) {
            epVar.a(f4651d);
            epVar.a(this.f511c);
            epVar.b();
        }
        if (e()) {
            epVar.a(f4652e);
            epVar.a(this.f509a);
            epVar.b();
        }
        if (this.f512d != null && f()) {
            epVar.a(f4653f);
            epVar.a(this.f512d);
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public void b(boolean z) {
        this.f508a.set(1, z);
    }

    public boolean b() {
        return this.f507a != null;
    }

    public boolean c() {
        return this.f510b != null;
    }

    public boolean d() {
        return this.f511c != null;
    }

    public boolean e() {
        return this.f508a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dk)) {
            return compareTo((dk) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f512d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("Target(", "channelId:");
        outline77.append(this.f506a);
        outline77.append(", ");
        outline77.append("userId:");
        String str = this.f507a;
        if (str == null) {
            outline77.append("null");
        } else {
            outline77.append(str);
        }
        if (c()) {
            outline77.append(", ");
            outline77.append("server:");
            String str2 = this.f510b;
            if (str2 == null) {
                outline77.append("null");
            } else {
                outline77.append(str2);
            }
        }
        if (d()) {
            outline77.append(", ");
            outline77.append("resource:");
            String str3 = this.f511c;
            if (str3 == null) {
                outline77.append("null");
            } else {
                outline77.append(str3);
            }
        }
        if (e()) {
            outline77.append(", ");
            outline77.append("isPreview:");
            outline77.append(this.f509a);
        }
        if (f()) {
            outline77.append(", ");
            outline77.append("token:");
            String str4 = this.f512d;
            if (str4 == null) {
                outline77.append("null");
            } else {
                outline77.append(str4);
            }
        }
        outline77.append(")");
        return outline77.toString();
    }
}
