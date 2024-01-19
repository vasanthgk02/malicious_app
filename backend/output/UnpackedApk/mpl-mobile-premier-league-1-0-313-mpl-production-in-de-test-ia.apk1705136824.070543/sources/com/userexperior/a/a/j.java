package com.userexperior.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j extends l implements Iterable<l> {

    /* renamed from: a  reason: collision with root package name */
    public final List<l> f3757a = new ArrayList();

    public final Number a() {
        if (this.f3757a.size() == 1) {
            return this.f3757a.get(0).a();
        }
        throw new IllegalStateException();
    }

    public final void a(l lVar) {
        if (lVar == null) {
            lVar = n.f3758a;
        }
        this.f3757a.add(lVar);
    }

    public final String b() {
        if (this.f3757a.size() == 1) {
            return this.f3757a.get(0).b();
        }
        throw new IllegalStateException();
    }

    public final double c() {
        if (this.f3757a.size() == 1) {
            return this.f3757a.get(0).c();
        }
        throw new IllegalStateException();
    }

    public final long d() {
        if (this.f3757a.size() == 1) {
            return this.f3757a.get(0).d();
        }
        throw new IllegalStateException();
    }

    public final int e() {
        if (this.f3757a.size() == 1) {
            return this.f3757a.get(0).e();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof j) && ((j) obj).f3757a.equals(this.f3757a));
    }

    public final boolean f() {
        if (this.f3757a.size() == 1) {
            return this.f3757a.get(0).f();
        }
        throw new IllegalStateException();
    }

    public final int hashCode() {
        return this.f3757a.hashCode();
    }

    public final Iterator<l> iterator() {
        return this.f3757a.iterator();
    }
}
