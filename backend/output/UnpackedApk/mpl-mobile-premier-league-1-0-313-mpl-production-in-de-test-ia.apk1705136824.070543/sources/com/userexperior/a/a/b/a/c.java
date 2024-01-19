package com.userexperior.a.a.b.a;

import com.userexperior.a.a.b.o;
import com.userexperior.a.a.d.a;
import com.userexperior.a.a.d.b;
import com.userexperior.a.a.f;
import com.userexperior.a.a.u;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class c<E> extends u<Collection<E>> {

    /* renamed from: a  reason: collision with root package name */
    public final u<E> f3573a;

    /* renamed from: b  reason: collision with root package name */
    public final o<? extends Collection<E>> f3574b;

    public c(f fVar, Type type, u<E> uVar, o<? extends Collection<E>> oVar) {
        this.f3573a = new s(fVar, uVar, type);
        this.f3574b = oVar;
    }

    public final /* synthetic */ Object a(a aVar) throws IOException {
        if (aVar.f() == b.NULL) {
            aVar.k();
            return null;
        }
        Collection collection = (Collection) this.f3574b.a();
        aVar.a();
        while (aVar.e()) {
            collection.add(this.f3573a.a(aVar));
        }
        aVar.b();
        return collection;
    }

    public final /* synthetic */ void a(com.userexperior.a.a.d.c cVar, Object obj) throws IOException {
        Collection<Object> collection = (Collection) obj;
        if (collection == null) {
            cVar.e();
            return;
        }
        cVar.a();
        for (Object a2 : collection) {
            this.f3573a.a(cVar, a2);
        }
        cVar.b();
    }
}
