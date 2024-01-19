package com.cfg.mendikot.api.d.a.a.a.b.t;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.cfg.mendikot.api.d.a.a.a.b.i;
import com.cfg.mendikot.api.d.a.a.a.b.l;
import com.cfg.mendikot.api.d.a.a.a.b.n;
import com.cfg.mendikot.api.d.a.a.a.b.v.a;

public class d implements i {

    /* renamed from: b  reason: collision with root package name */
    public static final d f2302b = new d();

    /* renamed from: a  reason: collision with root package name */
    public final n f2303a = i.f2272f;

    static {
        i iVar = i.f2272f;
    }

    public n b(com.cfg.mendikot.api.d.a.a.a.b.w.d dVar, j jVar) {
        k.a(dVar, (String) "Char array buffer");
        k.a(jVar, (String) "Parser cursor");
        String str = this.f2303a.f2274a;
        int length = str.length();
        int i = jVar.f2314c;
        int i2 = jVar.f2313b;
        c(dVar, jVar);
        int i3 = jVar.f2314c;
        int i4 = i3 + length;
        if (i4 + 4 <= i2) {
            boolean z = false;
            boolean z2 = true;
            int i5 = 0;
            while (z2 && i5 < length) {
                z2 = dVar.f2317a[i3 + i5] == str.charAt(i5);
                i5++;
            }
            if (!z2) {
                z = z2;
            } else if (dVar.f2317a[i4] == '/') {
                z = true;
            }
            if (z) {
                int i6 = length + 1 + i3;
                int a2 = dVar.a(46, i6, i2);
                if (a2 != -1) {
                    try {
                        int parseInt = Integer.parseInt(dVar.b(i6, a2));
                        int i7 = a2 + 1;
                        int a3 = dVar.a(32, i7, i2);
                        if (a3 == -1) {
                            a3 = i2;
                        }
                        try {
                            int parseInt2 = Integer.parseInt(dVar.b(i7, a3));
                            jVar.a(a3);
                            return this.f2303a.a(parseInt, parseInt2);
                        } catch (NumberFormatException unused) {
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid protocol minor version number: ");
                            outline73.append(dVar.a(i, i2));
                            throw new l(outline73.toString());
                        }
                    } catch (NumberFormatException unused2) {
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73("Invalid protocol major version number: ");
                        outline732.append(dVar.a(i, i2));
                        throw new l(outline732.toString());
                    }
                } else {
                    StringBuilder outline733 = GeneratedOutlineSupport.outline73("Invalid protocol version number: ");
                    outline733.append(dVar.a(i, i2));
                    throw new l(outline733.toString());
                }
            } else {
                StringBuilder outline734 = GeneratedOutlineSupport.outline73("Not a valid protocol version: ");
                outline734.append(dVar.a(i, i2));
                throw new l(outline734.toString());
            }
        } else {
            StringBuilder outline735 = GeneratedOutlineSupport.outline73("Not a valid protocol version: ");
            outline735.append(dVar.a(i, i2));
            throw new l(outline735.toString());
        }
    }

    public void c(com.cfg.mendikot.api.d.a.a.a.b.w.d dVar, j jVar) {
        int i = jVar.f2314c;
        int i2 = jVar.f2313b;
        while (i < i2 && a.a(dVar.f2317a[i])) {
            i++;
        }
        jVar.a(i);
    }
}
