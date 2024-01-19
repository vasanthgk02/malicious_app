package io.hansel.visualizer.c.e;

import io.hansel.visualizer.b.e;
import io.hansel.visualizer.b.f;
import io.hansel.visualizer.b.g;

public abstract class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public final e f5845a;

    public b(e eVar) {
        this.f5845a = (e) g.b(eVar);
    }

    public final <V> V a(f<V> fVar) {
        return this.f5845a.a(fVar);
    }

    public final void a() {
        this.f5845a.a();
    }

    public final void a(Runnable runnable) {
        this.f5845a.a(runnable);
    }
}
