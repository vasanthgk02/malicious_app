package com.userexperior.a.a.b.a;

import com.userexperior.a.a.b.f;
import com.userexperior.a.a.c.a;
import com.userexperior.a.a.u;
import com.userexperior.a.a.v;
import java.lang.reflect.Type;
import java.util.Collection;

public final class b implements v {

    /* renamed from: a  reason: collision with root package name */
    public final f f3572a;

    public b(f fVar) {
        this.f3572a = fVar;
    }

    public final <T> u<T> a(com.userexperior.a.a.f fVar, a<T> aVar) {
        Type type = aVar.f3726b;
        Class<? super T> cls = aVar.f3725a;
        if (!Collection.class.isAssignableFrom(cls)) {
            return null;
        }
        Type a2 = com.userexperior.a.a.b.b.a(type, cls);
        return new c(fVar, a2, fVar.a(a.a(a2)), this.f3572a.a(aVar));
    }
}
