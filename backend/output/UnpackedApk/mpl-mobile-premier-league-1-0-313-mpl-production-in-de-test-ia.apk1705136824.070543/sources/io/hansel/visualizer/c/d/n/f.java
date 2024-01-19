package io.hansel.visualizer.c.d.n;

import android.view.View;
import io.hansel.visualizer.b.g;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

public final class f extends io.hansel.visualizer.c.d.a<View> {

    /* renamed from: b  reason: collision with root package name */
    public final Map<View, b> f5838b = Collections.synchronizedMap(new IdentityHashMap());

    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public View f5839a;

        public b(f fVar) {
        }

        public void a() {
            if (this.f5839a != null) {
                this.f5839a = null;
            }
        }

        public void a(View view) {
            this.f5839a = (View) g.b(view);
        }
    }

    public void d(View view) {
        b bVar = new b();
        bVar.a(view);
        this.f5838b.put(view, bVar);
    }

    public void e(View view) {
        this.f5838b.remove(view).a();
    }
}
