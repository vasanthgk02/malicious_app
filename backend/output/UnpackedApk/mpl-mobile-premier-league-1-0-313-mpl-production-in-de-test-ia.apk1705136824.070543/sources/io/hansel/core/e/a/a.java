package io.hansel.core.e.a;

import android.content.Context;
import io.hansel.core.base.task.HSLTaskHandler;
import io.hansel.core.e.b.a.C0074a;

public class a extends HSLTaskHandler implements C0074a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5163a;

    public a(Context context) {
        this.f5163a = context;
        a();
    }

    public void a() {
        if (io.hansel.core.e.b.a.c(this.f5163a)) {
            resume();
        } else {
            pause();
        }
    }

    public void schedule(Runnable runnable) {
        if (io.hansel.core.e.b.a.c(this.f5163a) && isPaused()) {
            resume();
        }
        super.schedule(runnable);
    }
}
