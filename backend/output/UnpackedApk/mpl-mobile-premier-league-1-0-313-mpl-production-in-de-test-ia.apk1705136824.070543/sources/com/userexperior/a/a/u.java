package com.userexperior.a.a;

import com.userexperior.a.a.b.a.g;
import com.userexperior.a.a.d.a;
import com.userexperior.a.a.d.b;
import com.userexperior.a.a.d.c;
import java.io.IOException;

public abstract class u<T> {
    public final l a(T t) {
        try {
            g gVar = new g();
            a(gVar, t);
            if (gVar.f3584a.isEmpty()) {
                return gVar.f3585b;
            }
            throw new IllegalStateException("Expected one JSON element but was " + gVar.f3584a);
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        }
    }

    public final u<T> a() {
        return new u<T>() {
            public final T a(a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return u.this.a(aVar);
                }
                aVar.k();
                return null;
            }

            public final void a(c cVar, T t) throws IOException {
                if (t == null) {
                    cVar.e();
                } else {
                    u.this.a(cVar, t);
                }
            }
        };
    }

    public abstract T a(a aVar) throws IOException;

    public abstract void a(c cVar, T t) throws IOException;
}
