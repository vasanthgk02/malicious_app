package io.hansel.visualizer.f;

import android.content.Context;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.visualizer.e.a.k.h;
import java.net.URI;
import java.util.HashMap;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public io.hansel.visualizer.e.a.f.a f5932a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5933b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<f, e> f5934c = new HashMap<>();

    public class a extends io.hansel.visualizer.e.a.f.a {
        public a(URI uri) {
            super(uri);
        }

        public void a(int i, String str, boolean z) {
            g.this.f5933b = false;
            HashMap a2 = g.this.f5934c;
            f fVar = f.ws_close;
            if (a2.get(fVar) != null) {
                d dVar = new d();
                dVar.a(fVar);
                ((e) g.this.f5934c.get(fVar)).a(dVar);
            }
        }

        public void a(h hVar) {
            try {
                HashMap a2 = g.this.f5934c;
                f fVar = f.ws_open;
                if (a2.get(fVar) != null) {
                    ((e) g.this.f5934c.get(fVar)).a(new d(fVar));
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }

        public void a(Exception exc) {
            g.this.f5933b = false;
        }

        public void a(String str) {
            f a2 = g.this.a(str);
            if (a2 != null) {
                d dVar = new d();
                dVar.a(str);
                if (g.this.f5934c.get(a2) != null) {
                    ((e) g.this.f5934c.get(a2)).a(dVar);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public f a(String str) {
        if (str != null) {
            try {
                return f.valueOf(new CoreJSONObject(str).optString("message"));
            } catch (CoreJSONException e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return null;
    }

    private void a() {
        io.hansel.visualizer.e.a.f.a aVar = this.f5932a;
        if (aVar != null) {
            if (!this.f5933b || !aVar.m()) {
                this.f5933b = false;
                return;
            }
            this.f5932a.h();
        }
        this.f5933b = false;
    }

    public void a(f fVar, e eVar) {
        this.f5934c.put(fVar, eVar);
    }

    public void a(String str, Context context) {
        b(str, context);
    }

    public void b(d dVar) {
        io.hansel.visualizer.e.a.f.a aVar = this.f5932a;
        if (aVar != null && aVar.m()) {
            this.f5932a.b(dVar.b().toString());
        }
    }

    public void b(String str, Context context) {
        if (!this.f5933b) {
            this.f5933b = true;
            this.f5932a = new a(URI.create(c.a(str, context)));
        }
        try {
            this.f5932a.i();
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public boolean b() {
        io.hansel.visualizer.e.a.f.a aVar = this.f5932a;
        return aVar != null && aVar.m();
    }

    public void c() {
        this.f5934c.clear();
        a();
    }
}
