package com.userexperior.a.a.b.a;

import com.userexperior.a.a.a.c;
import com.userexperior.a.a.d.a;
import com.userexperior.a.a.d.b;
import java.io.IOException;
import java.lang.Enum;
import java.util.HashMap;
import java.util.Map;

public final class u<T extends Enum<T>> extends com.userexperior.a.a.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, T> f3647a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<T, String> f3648b = new HashMap();

    public u(Class<T> cls) {
        try {
            for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                String name = enumR.name();
                c cVar = (c) cls.getField(name).getAnnotation(c.class);
                if (cVar != null) {
                    name = cVar.a();
                    for (String put : cVar.b()) {
                        this.f3647a.put(put, enumR);
                    }
                }
                this.f3647a.put(name, enumR);
                this.f3648b.put(enumR, name);
            }
        } catch (NoSuchFieldException e2) {
            throw new AssertionError(e2);
        }
    }

    public final /* synthetic */ Object a(a aVar) throws IOException {
        if (aVar.f() != b.NULL) {
            return (Enum) this.f3647a.get(aVar.i());
        }
        aVar.k();
        return null;
    }

    public final /* synthetic */ void a(com.userexperior.a.a.d.c cVar, Object obj) throws IOException {
        Enum enumR = (Enum) obj;
        cVar.b(enumR == null ? null : this.f3648b.get(enumR));
    }
}
