package io.hansel.visualizer.c.d.n;

import android.app.Activity;
import android.app.Application;
import io.hansel.core.module.IMessageBroker;
import io.hansel.visualizer.c.d.b;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

public final class e extends io.hansel.visualizer.c.d.a<Application> {

    /* renamed from: b  reason: collision with root package name */
    public final Map<Application, a> f5835b = Collections.synchronizedMap(new IdentityHashMap());

    /* renamed from: c  reason: collision with root package name */
    public final b f5836c;

    public class a {
        public a() {
        }

        public Activity a() {
            return e.this.f5836c.b();
        }

        public void a(Application application) {
        }

        public void b() {
        }
    }

    public e(IMessageBroker iMessageBroker) {
        b a2 = b.a();
        this.f5836c = a2;
        a2.a(iMessageBroker);
    }

    private a a(Application application) {
        return this.f5835b.get(application);
    }

    /* renamed from: a */
    public void b(Application application, io.hansel.visualizer.b.a<Object> aVar) {
        aVar.a(a(application).a());
    }

    /* renamed from: b */
    public void d(Application application) {
        a aVar = new a();
        aVar.a(application);
        this.f5835b.put(application, aVar);
    }

    /* renamed from: c */
    public void e(Application application) {
        this.f5835b.remove(application).b();
    }
}
