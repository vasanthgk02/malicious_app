package com.userexperior.a.a.b;

import com.userexperior.a.a.a.d;
import com.userexperior.a.a.a.e;
import com.userexperior.a.a.b;
import com.userexperior.a.a.c.a;
import com.userexperior.a.a.d.c;
import com.userexperior.a.a.f;
import com.userexperior.a.a.u;
import com.userexperior.a.a.v;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public final class g implements v, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final g f3680a = new g();

    /* renamed from: b  reason: collision with root package name */
    public double f3681b = -1.0d;

    /* renamed from: c  reason: collision with root package name */
    public int f3682c = 136;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3683d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3684e;

    /* renamed from: f  reason: collision with root package name */
    public List<b> f3685f = Collections.emptyList();
    public List<b> g = Collections.emptyList();

    /* access modifiers changed from: private */
    /* renamed from: a */
    public g clone() {
        try {
            return (g) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    private boolean a(d dVar) {
        return dVar == null || dVar.a() <= this.f3681b;
    }

    private boolean a(e eVar) {
        return eVar == null || eVar.a() > this.f3681b;
    }

    public static boolean a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public static boolean b(Class<?> cls) {
        return cls.isMemberClass() && !c(cls);
    }

    public static boolean c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public final <T> u<T> a(f fVar, a<T> aVar) {
        Class<? super T> cls = aVar.f3725a;
        final boolean a2 = a(cls, true);
        final boolean a3 = a(cls, false);
        if (!a2 && !a3) {
            return null;
        }
        final f fVar2 = fVar;
        final a<T> aVar2 = aVar;
        AnonymousClass1 r2 = new u<T>() {

            /* renamed from: f  reason: collision with root package name */
            public u<T> f3691f;

            private u<T> b() {
                u<T> uVar = this.f3691f;
                if (uVar != null) {
                    return uVar;
                }
                u<T> a2 = fVar2.a((v) g.this, aVar2);
                this.f3691f = a2;
                return a2;
            }

            public final T a(com.userexperior.a.a.d.a aVar) throws IOException {
                if (!a3) {
                    return b().a(aVar);
                }
                aVar.o();
                return null;
            }

            public final void a(c cVar, T t) throws IOException {
                if (a2) {
                    cVar.e();
                } else {
                    b().a(cVar, t);
                }
            }
        };
        return r2;
    }

    public final boolean a(d dVar, e eVar) {
        return a(dVar) && a(eVar);
    }

    public final boolean a(Class<?> cls, boolean z) {
        if (this.f3681b != -1.0d && !a((d) cls.getAnnotation(d.class), (e) cls.getAnnotation(e.class))) {
            return true;
        }
        if ((!this.f3683d && b(cls)) || a(cls)) {
            return true;
        }
        for (b b2 : z ? this.f3685f : this.g) {
            if (b2.b()) {
                return true;
            }
        }
        return false;
    }
}
