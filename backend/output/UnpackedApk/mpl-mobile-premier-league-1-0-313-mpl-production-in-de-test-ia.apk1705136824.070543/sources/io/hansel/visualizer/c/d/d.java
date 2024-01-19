package io.hansel.visualizer.c.d;

import io.hansel.visualizer.b.g;
import io.hansel.visualizer.c.d.c.a;
import java.util.IdentityHashMap;
import java.util.Map;

public final class d implements f {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, c> f5788a = new IdentityHashMap();

    /* renamed from: b  reason: collision with root package name */
    public boolean f5789b;

    /* renamed from: c  reason: collision with root package name */
    public a f5790c;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r2v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.hansel.visualizer.c.d.c b(java.lang.Class r2) {
        /*
            r1 = this;
        L_0x0000:
            if (r2 == 0) goto L_0x0012
            java.util.Map<java.lang.Class<?>, io.hansel.visualizer.c.d.c> r0 = r1.f5788a
            java.lang.Object r0 = r0.get(r2)
            io.hansel.visualizer.c.d.c r0 = (io.hansel.visualizer.c.d.c) r0
            if (r0 == 0) goto L_0x000d
            return r0
        L_0x000d:
            java.lang.Class r2 = r2.getSuperclass()
            goto L_0x0000
        L_0x0012:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.c.d.d.b(java.lang.Class):io.hansel.visualizer.c.d.c");
    }

    public c a(Class<?> cls) {
        g.b(cls);
        g.a(this.f5789b);
        return b(cls);
    }

    public d a() {
        g.a(this.f5789b);
        this.f5789b = true;
        return this;
    }

    public d a(a aVar) {
        g.b(aVar);
        g.b(this.f5789b);
        g.a((Object) this.f5790c);
        this.f5790c = aVar;
        return this;
    }

    public d a(Class<?> cls, c cVar) {
        g.b(cls);
        g.b(cVar);
        g.a(cVar.e());
        g.b(this.f5789b);
        if (this.f5788a.containsKey(cls)) {
            throw new UnsupportedOperationException();
        } else if (!this.f5788a.containsValue(cVar)) {
            this.f5788a.put(cls, cVar);
            return this;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public d b() {
        g.b(this.f5789b);
        g.b(this.f5790c);
        this.f5789b = false;
        for (Class<?> cls : this.f5788a.keySet()) {
            this.f5788a.get(cls).a(this.f5790c);
        }
        return this;
    }
}
