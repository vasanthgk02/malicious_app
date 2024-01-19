package com.userexperior.e;

public final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f3994a;

    /* renamed from: b  reason: collision with root package name */
    public final o f3995b;

    /* renamed from: c  reason: collision with root package name */
    public final r f3996c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f3997d;

    public g(f fVar, o oVar, r rVar, Runnable runnable) {
        this.f3994a = fVar;
        this.f3995b = oVar;
        this.f3996c = rVar;
        this.f3997d = runnable;
    }

    public final void run() {
        o oVar = this.f3995b;
        if (oVar.m) {
            oVar.b((String) "canceled-at-delivery");
            return;
        }
        if (this.f3996c.f4029c == null) {
            this.f3995b.a(this.f3996c.f4027a);
        } else {
            this.f3995b.b(this.f3996c.f4029c);
        }
        if (this.f3996c.f4030d) {
            this.f3995b.a((String) "intermediate-response");
        } else {
            this.f3995b.b((String) "done");
        }
        Runnable runnable = this.f3997d;
        if (runnable != null) {
            runnable.run();
        }
    }
}
