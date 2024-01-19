package com.cfg.mendikot.api.d.a.a.a.b.t;

import co.hyperverge.hypersnapsdk.c.k;
import com.cfg.mendikot.api.d.a.a.a.b.c;
import com.cfg.mendikot.api.d.a.a.a.b.f;
import com.cfg.mendikot.api.d.a.a.a.b.g;
import com.cfg.mendikot.api.d.a.a.a.b.i;
import com.cfg.mendikot.api.d.a.a.a.b.n;
import com.cfg.mendikot.api.d.a.a.a.b.o;
import com.cfg.mendikot.api.d.a.a.a.b.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class b implements g, f {

    /* renamed from: a  reason: collision with root package name */
    public g f2297a = new g();

    /* renamed from: b  reason: collision with root package name */
    public p f2298b;

    /* renamed from: c  reason: collision with root package name */
    public n f2299c;

    /* renamed from: d  reason: collision with root package name */
    public int f2300d;

    /* renamed from: e  reason: collision with root package name */
    public String f2301e;
    public final o g;
    public Locale h;

    public b(p pVar, o oVar, Locale locale) {
        k.a(pVar, (String) "Status line");
        this.f2298b = pVar;
        this.f2299c = pVar.a();
        this.f2300d = pVar.b();
        this.f2301e = pVar.c();
        this.g = oVar;
        this.h = locale;
    }

    public p a() {
        if (this.f2298b == null) {
            n nVar = this.f2299c;
            if (nVar == null) {
                nVar = i.f2272f;
            }
            int i = this.f2300d;
            String str = this.f2301e;
            if (str == null) {
                o oVar = this.g;
                if (oVar != null) {
                    Locale locale = this.h;
                    if (locale == null) {
                        locale = Locale.getDefault();
                    }
                    str = oVar.a(i, locale);
                } else {
                    str = null;
                }
            }
            this.f2298b = new e(nVar, i, str);
        }
        return this.f2298b;
    }

    public String toString() {
        return a() + ' ' + this.f2297a;
    }

    public void a(c[] cVarArr) {
        g gVar = this.f2297a;
        gVar.f2311b.clear();
        Collections.addAll(gVar.f2311b, cVarArr);
    }

    public c[] a(String str) {
        g gVar = this.f2297a;
        ArrayList arrayList = null;
        for (int i = 0; i < gVar.f2311b.size(); i++) {
            c cVar = gVar.f2311b.get(i);
            if (cVar.b().equalsIgnoreCase(str)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(cVar);
            }
        }
        return arrayList != null ? (c[]) arrayList.toArray(new c[arrayList.size()]) : gVar.f2310a;
    }
}
