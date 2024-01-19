package com.userexperior.a.a.b.a;

import com.userexperior.a.a.b.q;
import com.userexperior.a.a.c.a;
import com.userexperior.a.a.d.c;
import com.userexperior.a.a.f;
import com.userexperior.a.a.k;
import com.userexperior.a.a.l;
import com.userexperior.a.a.n;
import com.userexperior.a.a.r;
import com.userexperior.a.a.u;
import com.userexperior.a.a.v;
import java.io.IOException;

public final class p<T> extends u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final r<T> f3611a;

    /* renamed from: b  reason: collision with root package name */
    public final k<T> f3612b;

    /* renamed from: c  reason: collision with root package name */
    public final f f3613c;

    /* renamed from: d  reason: collision with root package name */
    public final a<T> f3614d;

    /* renamed from: e  reason: collision with root package name */
    public final v f3615e;

    /* renamed from: f  reason: collision with root package name */
    public final q f3616f = new q(this, 0);
    public u<T> g;

    public p(r<T> rVar, k<T> kVar, f fVar, a<T> aVar, v vVar) {
        this.f3611a = rVar;
        this.f3612b = kVar;
        this.f3613c = fVar;
        this.f3614d = aVar;
        this.f3615e = vVar;
    }

    public static v a(a<?> aVar, Object obj) {
        return new r(obj, aVar);
    }

    private u<T> b() {
        u<T> uVar = this.g;
        if (uVar != null) {
            return uVar;
        }
        u<T> a2 = this.f3613c.a(this.f3615e, this.f3614d);
        this.g = a2;
        return a2;
    }

    public final T a(com.userexperior.a.a.d.a aVar) throws IOException {
        if (this.f3612b == null) {
            return b().a(aVar);
        }
        l a2 = q.a(aVar);
        if (a2 instanceof n) {
            return null;
        }
        return this.f3612b.a(a2, this.f3614d.f3726b);
    }

    public final void a(c cVar, T t) throws IOException {
        r<T> rVar = this.f3611a;
        if (rVar == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.e();
        } else {
            q.a(rVar.a(t), cVar);
        }
    }
}
