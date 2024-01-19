package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class de implements ef<de, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4618a = new em("", 8, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f452a = new eu("NormalConfig");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4619b = new em("", 15, 2);

    /* renamed from: c  reason: collision with root package name */
    public static final em f4620c = new em("", 8, 3);

    /* renamed from: a  reason: collision with other field name */
    public int f453a;

    /* renamed from: a  reason: collision with other field name */
    public dc f454a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f455a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<dg> f456a;

    public int a() {
        return this.f453a;
    }

    /* renamed from: a */
    public int compareTo(de deVar) {
        if (!de.class.equals(deVar.getClass())) {
            return de.class.getName().compareTo(de.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(deVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f453a, deVar.f453a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(deVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a((List) this.f456a, (List) deVar.f456a);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(deVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c()) {
            int a4 = eg.a((Comparable) this.f454a, (Comparable) deVar.f454a);
            if (a4 != 0) {
                return a4;
            }
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dc m592a() {
        return this.f454a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m593a() {
        if (this.f456a == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'configItems' was not present! Struct: ");
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
                    if (s == 3 && b2 == 8) {
                        this.f454a = dc.a(epVar.a());
                        epVar.g();
                    }
                } else if (b2 == 15) {
                    en a3 = epVar.a();
                    this.f456a = new ArrayList(a3.f756a);
                    for (int i = 0; i < a3.f756a; i++) {
                        dg dgVar = new dg();
                        dgVar.a(epVar);
                        this.f456a.add(dgVar);
                    }
                    epVar.i();
                    epVar.g();
                }
            } else if (b2 == 8) {
                this.f453a = epVar.a();
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
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'version' was not found in serialized data! Struct: ");
        outline73.append(toString());
        throw new eq(outline73.toString());
    }

    public void a(boolean z) {
        this.f455a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m594a() {
        return this.f455a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m595a(de deVar) {
        if (deVar == null || this.f453a != deVar.f453a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = deVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f456a.equals(deVar.f456a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = deVar.c();
        return (!c2 && !c3) || (c2 && c3 && this.f454a.equals(deVar.f454a));
    }

    public void b(ep epVar) {
        a();
        epVar.a(f452a);
        epVar.a(f4618a);
        epVar.a(this.f453a);
        epVar.b();
        if (this.f456a != null) {
            epVar.a(f4619b);
            epVar.a(new en(MqttWireMessage.MESSAGE_TYPE_PINGREQ, this.f456a.size()));
            for (dg b2 : this.f456a) {
                b2.b(epVar);
            }
            epVar.e();
            epVar.b();
        }
        if (this.f454a != null && c()) {
            epVar.a(f4620c);
            epVar.a(this.f454a.a());
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public boolean b() {
        return this.f456a != null;
    }

    public boolean c() {
        return this.f454a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof de)) {
            return compareTo((de) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("NormalConfig(", "version:");
        outline77.append(this.f453a);
        outline77.append(", ");
        outline77.append("configItems:");
        List<dg> list = this.f456a;
        if (list == null) {
            outline77.append("null");
        } else {
            outline77.append(list);
        }
        if (c()) {
            outline77.append(", ");
            outline77.append("type:");
            dc dcVar = this.f454a;
            if (dcVar == null) {
                outline77.append("null");
            } else {
                outline77.append(dcVar);
            }
        }
        outline77.append(")");
        return outline77.toString();
    }
}
