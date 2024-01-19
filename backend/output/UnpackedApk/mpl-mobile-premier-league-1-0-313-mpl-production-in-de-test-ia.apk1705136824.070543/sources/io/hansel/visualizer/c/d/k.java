package io.hansel.visualizer.c.d;

import io.hansel.visualizer.b.d;
import io.hansel.visualizer.b.g;
import java.util.List;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final Object f5815a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f5816b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Object> f5817c;

    public k(Object obj, Object obj2, List<Object> list) {
        this.f5815a = g.b(obj);
        this.f5816b = obj2;
        this.f5817c = d.a(list);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (!(this.f5815a == kVar.f5815a && this.f5816b == kVar.f5816b && d.a(this.f5817c, kVar.f5817c))) {
            z = false;
        }
        return z;
    }
}
