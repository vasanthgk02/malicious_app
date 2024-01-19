package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.BitSet;

public class dn implements ef<dn, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4666a = new em("", 8, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f547a = new eu("XmPushActionCheckClientInfo");

    /* renamed from: b  reason: collision with root package name */
    public static final em f4667b = new em("", 8, 2);

    /* renamed from: a  reason: collision with other field name */
    public int f548a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f549a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f550b;

    /* renamed from: a */
    public int compareTo(dn dnVar) {
        if (!dn.class.equals(dnVar.getClass())) {
            return dn.class.getName().compareTo(dn.class.getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(dnVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            int a2 = eg.a(this.f548a, dnVar.f548a);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(dnVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b()) {
            int a3 = eg.a(this.f550b, dnVar.f550b);
            if (a3 != 0) {
                return a3;
            }
        }
        return 0;
    }

    public dn a(int i) {
        this.f548a = i;
        a(true);
        return this;
    }

    public void a() {
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
                if (s == 2 && b2 == 8) {
                    this.f550b = epVar.a();
                    b(true);
                    epVar.g();
                }
            } else if (b2 == 8) {
                this.f548a = epVar.a();
                a(true);
                epVar.g();
            }
            es.a(epVar, b2);
            epVar.g();
        }
        epVar.f();
        if (!a()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'miscConfigVersion' was not found in serialized data! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        } else if (b()) {
            a();
        } else {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Required field 'pluginConfigVersion' was not found in serialized data! Struct: ");
            outline732.append(toString());
            throw new eq(outline732.toString());
        }
    }

    public void a(boolean z) {
        this.f549a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m631a() {
        return this.f549a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m632a(dn dnVar) {
        return dnVar != null && this.f548a == dnVar.f548a && this.f550b == dnVar.f550b;
    }

    public dn b(int i) {
        this.f550b = i;
        b(true);
        return this;
    }

    public void b(ep epVar) {
        a();
        epVar.a(f547a);
        epVar.a(f4666a);
        epVar.a(this.f548a);
        epVar.b();
        epVar.a(f4667b);
        epVar.a(this.f550b);
        epVar.b();
        epVar.c();
        epVar.a();
    }

    public void b(boolean z) {
        this.f549a.set(1, z);
    }

    public boolean b() {
        return this.f549a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dn)) {
            return compareTo((dn) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("XmPushActionCheckClientInfo(", "miscConfigVersion:");
        outline77.append(this.f548a);
        outline77.append(", ");
        outline77.append("pluginConfigVersion:");
        return GeneratedOutlineSupport.outline57(outline77, this.f550b, ")");
    }
}
