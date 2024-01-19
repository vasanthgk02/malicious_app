package com.userexperior.a.a.b.a;

import com.userexperior.a.a.c.a;
import com.userexperior.a.a.f;
import com.userexperior.a.a.k;
import com.userexperior.a.a.u;
import com.userexperior.a.a.v;

public final class r implements v {

    /* renamed from: a  reason: collision with root package name */
    public final a<?> f3618a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f3619b;

    /* renamed from: c  reason: collision with root package name */
    public final Class<?> f3620c;

    /* renamed from: d  reason: collision with root package name */
    public final com.userexperior.a.a.r<?> f3621d;

    /* renamed from: e  reason: collision with root package name */
    public final k<?> f3622e;

    public r(Object obj, a<?> aVar) {
        this.f3621d = obj instanceof com.userexperior.a.a.r ? (com.userexperior.a.a.r) obj : null;
        k<?> kVar = obj instanceof k ? (k) obj : null;
        this.f3622e = kVar;
        com.userexperior.a.a.b.a.a((this.f3621d == null && kVar == null) ? false : true);
        this.f3618a = aVar;
        this.f3619b = false;
        this.f3620c = null;
    }

    public final <T> u<T> a(f fVar, a<T> aVar) {
        a<?> aVar2 = this.f3618a;
        if (!(aVar2 != null ? aVar2.equals(aVar) || (this.f3619b && this.f3618a.f3726b == aVar.f3725a) : this.f3620c.isAssignableFrom(aVar.f3725a))) {
            return null;
        }
        p pVar = new p(this.f3621d, this.f3622e, fVar, aVar, this);
        return pVar;
    }
}
