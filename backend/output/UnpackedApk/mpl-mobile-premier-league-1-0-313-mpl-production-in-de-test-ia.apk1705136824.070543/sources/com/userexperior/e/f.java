package com.userexperior.e;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class f implements u {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f3991a;

    public f(final Handler handler) {
        this.f3991a = new Executor() {
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public final void a(o<?> oVar, r<?> rVar) {
        a(oVar, rVar, null);
    }

    public final void a(o<?> oVar, r<?> rVar, Runnable runnable) {
        oVar.n = true;
        oVar.a((String) "post-response");
        this.f3991a.execute(new g(this, oVar, rVar, runnable));
    }

    public final void a(o<?> oVar, y yVar) {
        oVar.a((String) "post-error");
        this.f3991a.execute(new g(this, oVar, new r(yVar), null));
    }
}
