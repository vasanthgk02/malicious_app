package com.userexperior.a.a.b.a;

import com.userexperior.a.a.d.a;
import com.userexperior.a.a.d.c;
import com.userexperior.a.a.f;
import com.userexperior.a.a.u;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class s<T> extends u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final f f3623a;

    /* renamed from: b  reason: collision with root package name */
    public final u<T> f3624b;

    /* renamed from: c  reason: collision with root package name */
    public final Type f3625c;

    public s(f fVar, u<T> uVar, Type type) {
        this.f3623a = fVar;
        this.f3624b = uVar;
        this.f3625c = type;
    }

    public final T a(a aVar) throws IOException {
        return this.f3624b.a(aVar);
    }

    public final void a(c cVar, T t) throws IOException {
        u<T> uVar = this.f3624b;
        Type type = this.f3625c;
        if (t != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t.getClass();
        }
        if (type != this.f3625c) {
            uVar = this.f3623a.a(com.userexperior.a.a.c.a.a(type));
            if (uVar instanceof l) {
                u<T> uVar2 = this.f3624b;
                if (!(uVar2 instanceof l)) {
                    uVar = uVar2;
                }
            }
        }
        uVar.a(cVar, t);
    }
}
