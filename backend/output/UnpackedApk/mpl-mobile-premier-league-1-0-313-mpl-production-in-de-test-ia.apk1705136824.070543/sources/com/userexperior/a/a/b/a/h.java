package com.userexperior.a.a.b.a;

import com.userexperior.a.a.b.b;
import com.userexperior.a.a.b.f;
import com.userexperior.a.a.c.a;
import com.userexperior.a.a.u;
import com.userexperior.a.a.v;
import java.lang.reflect.Type;
import java.util.Map;

public final class h implements v {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f3586a;

    /* renamed from: b  reason: collision with root package name */
    public final f f3587b;

    public h(f fVar, boolean z) {
        this.f3587b = fVar;
        this.f3586a = z;
    }

    public final <T> u<T> a(com.userexperior.a.a.f fVar, a<T> aVar) {
        Type type = aVar.f3726b;
        if (!Map.class.isAssignableFrom(aVar.f3725a)) {
            return null;
        }
        Type[] b2 = b.b(type, b.b(type));
        Type type2 = b2[0];
        u<Boolean> a2 = (type2 == Boolean.TYPE || type2 == Boolean.class) ? t.f3631f : fVar.a(a.a(type2));
        com.userexperior.a.a.f fVar2 = fVar;
        i iVar = new i(this, fVar2, b2[0], a2, b2[1], fVar.a(a.a(b2[1])), this.f3587b.a(aVar));
        return iVar;
    }
}
