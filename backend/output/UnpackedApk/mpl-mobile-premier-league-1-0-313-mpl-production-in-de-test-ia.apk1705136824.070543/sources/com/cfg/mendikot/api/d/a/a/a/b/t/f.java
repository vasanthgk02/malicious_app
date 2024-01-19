package com.cfg.mendikot.api.d.a.a.a.b.t;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.cfg.mendikot.api.d.a.a.a.b.c;
import com.cfg.mendikot.api.d.a.a.a.b.l;
import com.cfg.mendikot.api.d.a.a.a.b.w.d;
import java.io.Serializable;

public class f implements c, Cloneable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f2307a;

    /* renamed from: b  reason: collision with root package name */
    public final d f2308b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2309c;

    public f(d dVar) {
        k.a(dVar, (String) "Char array buffer");
        int a2 = dVar.a(58, 0, dVar.f2318b);
        if (a2 != -1) {
            String b2 = dVar.b(0, a2);
            if (b2.length() != 0) {
                this.f2308b = dVar;
                this.f2307a = b2;
                this.f2309c = a2 + 1;
                return;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid header: ");
            outline73.append(dVar.toString());
            throw new l(outline73.toString());
        }
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("Invalid header: ");
        outline732.append(dVar.toString());
        throw new l(outline732.toString());
    }

    public String a() {
        d dVar = this.f2308b;
        return dVar.b(this.f2309c, dVar.f2318b);
    }

    public String b() {
        return this.f2307a;
    }

    public Object clone() {
        return super.clone();
    }

    public String toString() {
        return this.f2308b.toString();
    }
}
