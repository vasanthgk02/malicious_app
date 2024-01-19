package com.userexperior.a.a;

import com.userexperior.a.a.b.a.p;
import com.userexperior.a.a.b.g;
import com.userexperior.a.a.c.a;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3751a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3752b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3753c = false;

    /* renamed from: d  reason: collision with root package name */
    public g f3754d = g.f3680a;

    /* renamed from: e  reason: collision with root package name */
    public t f3755e = t.DEFAULT;

    /* renamed from: f  reason: collision with root package name */
    public e f3756f = d.IDENTITY;
    public final Map<Type, i<?>> g = new HashMap();
    public final List<v> h = new ArrayList();
    public final List<v> i = new ArrayList();
    public boolean j = false;
    public String k;
    public int l = 2;
    public int m = 2;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;

    public final f a() {
        a aVar;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.h);
        Collections.reverse(arrayList);
        arrayList.addAll(this.i);
        String str = this.k;
        int i2 = this.l;
        int i3 = this.m;
        if (str == null || "".equals(str.trim())) {
            if (!(i2 == 2 || i3 == 2)) {
                aVar = new a(i2, i3);
            }
            f fVar = new f(this.f3754d, this.f3756f, this.g, this.j, this.n, this.p, this.f3751a, this.f3752b, this.f3753c, this.o, this.f3755e, arrayList);
            return fVar;
        }
        aVar = new a(str);
        arrayList.add(p.a(a.a(Date.class), (Object) aVar));
        arrayList.add(p.a(a.a(Timestamp.class), (Object) aVar));
        arrayList.add(p.a(a.a(java.sql.Date.class), (Object) aVar));
        f fVar2 = new f(this.f3754d, this.f3756f, this.g, this.j, this.n, this.p, this.f3751a, this.f3752b, this.f3753c, this.o, this.f3755e, arrayList);
        return fVar2;
    }
}
