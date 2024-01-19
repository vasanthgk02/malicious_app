package com.xiaomi.push;

import com.xiaomi.push.o.a;
import com.xiaomi.push.o.b;

public class q extends b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f4802a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public q(o oVar, a aVar) {
        // this.f4802a = oVar;
        super(aVar);
    }

    public void b() {
        synchronized (o.a(this.f4802a)) {
            o.a(this.f4802a).remove(this.f4798a.a());
        }
    }
}
