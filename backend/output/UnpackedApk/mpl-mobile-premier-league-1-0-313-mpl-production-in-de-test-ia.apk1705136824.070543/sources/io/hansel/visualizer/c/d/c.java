package io.hansel.visualizer.c.d;

import io.hansel.visualizer.b.e;
import io.hansel.visualizer.b.f;
import io.hansel.visualizer.b.g;

public abstract class c<E> implements l<E> {

    /* renamed from: a  reason: collision with root package name */
    public a f5787a;

    public interface a extends e {
    }

    public final <V> V a(f<V> fVar) {
        return d().a(fVar);
    }

    public final void a() {
        d().a();
    }

    public final void a(a aVar) {
        g.b(aVar);
        g.a((Object) this.f5787a);
        this.f5787a = aVar;
    }

    public final void a(Runnable runnable) {
        d().a(runnable);
    }

    public final a d() {
        return this.f5787a;
    }

    public final boolean e() {
        return this.f5787a != null;
    }
}
