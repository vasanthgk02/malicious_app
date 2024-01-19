package io.hansel.visualizer.c.d.n;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import io.hansel.core.module.IMessageBroker;
import io.hansel.visualizer.c.d.c;
import io.hansel.visualizer.c.d.c.a;
import io.hansel.visualizer.c.d.d;
import io.hansel.visualizer.c.d.e;
import io.hansel.visualizer.c.d.h;
import io.hansel.visualizer.c.d.l;
import java.util.List;

public final class b extends io.hansel.visualizer.c.e.b implements h, a {

    /* renamed from: b  reason: collision with root package name */
    public final d f5828b;

    /* renamed from: c  reason: collision with root package name */
    public final d f5829c;

    public b(Application application, IMessageBroker iMessageBroker, List<e> list, io.hansel.visualizer.b.e eVar) {
        super(eVar);
        d dVar = new d(application);
        this.f5829c = dVar;
        d a2 = new d().a().a(d.class, dVar);
        e eVar2 = new e(iMessageBroker);
        Class<View> cls = View.class;
        Class<ViewGroup> cls2 = ViewGroup.class;
        this.f5828b = a2.a(Application.class, eVar2).a(Activity.class, new a()).a(cls, new f()).a(cls2, new g());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).a(this.f5828b);
        }
        this.f5828b.a((a) this).b();
    }

    public l b(Object obj) {
        a();
        return d(obj);
    }

    public Object c() {
        a();
        return this.f5829c;
    }

    public c<?> d(Object obj) {
        if (obj == null) {
            return null;
        }
        return this.f5828b.a(obj.getClass());
    }
}
