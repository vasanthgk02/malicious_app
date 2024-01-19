package com.xiaomi.push;

import com.xiaomi.push.o.a;
import com.xiaomi.push.o.b;

public class p extends b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f4799a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f768a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f769a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public p(o oVar, a aVar, boolean z, String str) {
        // this.f4799a = oVar;
        // this.f769a = z;
        // this.f768a = str;
        super(aVar);
    }

    public void a() {
        super.a();
    }

    public void b() {
        if (!this.f769a) {
            o.a(this.f4799a).edit().putLong(this.f768a, System.currentTimeMillis()).commit();
        }
    }
}
