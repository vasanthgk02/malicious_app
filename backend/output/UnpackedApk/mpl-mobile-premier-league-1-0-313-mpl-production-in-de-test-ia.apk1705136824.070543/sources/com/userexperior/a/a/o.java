package com.userexperior.a.a;

import com.userexperior.a.a.b.j;

public final class o extends l {

    /* renamed from: a  reason: collision with root package name */
    public final j<String, l> f3759a = new j<>();

    public final void a(String str, l lVar) {
        if (lVar == null) {
            lVar = n.f3758a;
        }
        this.f3759a.put(str, lVar);
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f3759a.equals(this.f3759a));
    }

    public final int hashCode() {
        return this.f3759a.hashCode();
    }
}
