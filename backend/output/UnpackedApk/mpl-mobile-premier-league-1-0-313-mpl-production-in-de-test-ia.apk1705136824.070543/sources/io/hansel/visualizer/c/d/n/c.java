package io.hansel.visualizer.c.d.n;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import io.hansel.core.module.IMessageBroker;
import io.hansel.visualizer.b.e;
import io.hansel.visualizer.b.f;
import io.hansel.visualizer.b.g;
import io.hansel.visualizer.b.h.a;
import io.hansel.visualizer.c.d.h;
import io.hansel.visualizer.c.d.i;
import java.util.List;

public final class c implements i, e {

    /* renamed from: a  reason: collision with root package name */
    public final Application f5830a;

    /* renamed from: b  reason: collision with root package name */
    public final List<io.hansel.visualizer.c.d.e> f5831b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f5832c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public final IMessageBroker f5833d;

    public c(Application application, IMessageBroker iMessageBroker, List<io.hansel.visualizer.c.d.e> list) {
        this.f5830a = (Application) g.b(application);
        this.f5833d = iMessageBroker;
        this.f5831b = (List) g.b(list);
    }

    public <V> V a(f<V> fVar) {
        return a.a(this.f5832c, fVar);
    }

    public void a() {
        a.b(this.f5832c);
    }

    public void a(Runnable runnable) {
        a.a(this.f5832c, runnable);
    }

    public h b() {
        return new b(this.f5830a, this.f5833d, this.f5831b, this);
    }
}
