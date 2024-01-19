package com.userexperior.a.a.b.a;

import com.userexperior.a.a.b.b;
import com.userexperior.a.a.d.c;
import com.userexperior.a.a.f;
import com.userexperior.a.a.u;
import com.userexperior.a.a.v;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class a<E> extends u<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final v f3568a = new v() {
        public final <T> u<T> a(f fVar, com.userexperior.a.a.c.a<T> aVar) {
            Type type = aVar.f3726b;
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type d2 = b.d(type);
            return new a(fVar, fVar.a(com.userexperior.a.a.c.a.a(d2)), b.b(d2));
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final Class<E> f3569b;

    /* renamed from: c  reason: collision with root package name */
    public final u<E> f3570c;

    public a(f fVar, u<E> uVar, Class<E> cls) {
        this.f3570c = new s(fVar, uVar, cls);
        this.f3569b = cls;
    }

    public final Object a(com.userexperior.a.a.d.a aVar) throws IOException {
        if (aVar.f() == com.userexperior.a.a.d.b.NULL) {
            aVar.k();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.f3570c.a(aVar));
        }
        aVar.b();
        Object newInstance = Array.newInstance(this.f3569b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    public final void a(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.e();
            return;
        }
        cVar.a();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f3570c.a(cVar, Array.get(obj, i));
        }
        cVar.b();
    }
}
