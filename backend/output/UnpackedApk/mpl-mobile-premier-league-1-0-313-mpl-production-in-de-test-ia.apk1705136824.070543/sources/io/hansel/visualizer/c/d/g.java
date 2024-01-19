package io.hansel.visualizer.c.d;

import android.os.SystemClock;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.logger.HSLLogger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public final class g extends io.hansel.visualizer.c.e.b {

    /* renamed from: b  reason: collision with root package name */
    public final i f5791b;

    /* renamed from: c  reason: collision with root package name */
    public final io.hansel.visualizer.c.e.a f5792c = new f(this, null);

    /* renamed from: d  reason: collision with root package name */
    public final Queue<Object> f5793d = new ArrayDeque();

    /* renamed from: e  reason: collision with root package name */
    public h f5794e;

    /* renamed from: f  reason: collision with root package name */
    public m f5795f;
    public h g = new h(this);
    public e h;
    public io.hansel.visualizer.b.b<Object> i;
    public int j = 0;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                g gVar = g.this;
                gVar.f5795f = new m(gVar.h().c());
                g.this.f().b();
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public class b implements io.hansel.visualizer.b.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ io.hansel.visualizer.c.d.m.a f5797a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f5798b;

        public b(io.hansel.visualizer.c.d.m.a aVar, ArrayList arrayList) {
            this.f5797a = aVar;
            this.f5798b = arrayList;
        }

        public void a(Object obj) {
            try {
                Integer num = (Integer) io.hansel.visualizer.b.g.b(g.this.f5792c.b(obj));
                if (this.f5797a.a(obj).f5816b == null) {
                    g.this.g.a(g.this.f5792c.b(g.this.f5795f.a(obj).f5816b).intValue(), num.intValue());
                }
                this.f5798b.add(num);
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public class c implements io.hansel.visualizer.b.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f5800a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ io.hansel.visualizer.c.d.m.a f5801b;

        public c(ArrayList arrayList, io.hansel.visualizer.c.d.m.a aVar) {
            this.f5800a = arrayList;
            this.f5801b = aVar;
        }

        public void a(Object obj) {
            try {
                Integer num = (Integer) io.hansel.visualizer.b.g.b(g.this.f5792c.b(obj));
                if (Collections.binarySearch(this.f5800a, num) < 0) {
                    k a2 = g.this.f5795f.a(obj);
                    if (!(a2 == null || this.f5801b.a(obj).f5816b == a2.f5816b)) {
                        g.this.g.a(g.this.f5792c.b(a2.f5816b).intValue(), num.intValue());
                    }
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public class d implements io.hansel.visualizer.b.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final HashSet<Object> f5803a = new HashSet<>();

        /* renamed from: b  reason: collision with root package name */
        public io.hansel.visualizer.b.a<Object> f5804b = new a();

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ io.hansel.visualizer.c.d.m.a f5805c;

        public class a implements io.hansel.visualizer.b.a<Object> {
            public a() {
            }

            public void a(Object obj) {
                try {
                    if (d.this.f5805c.b(obj)) {
                        d.this.f5803a.add(obj);
                    }
                } catch (Throwable th) {
                    HSLLogger.printStackTrace(th);
                }
            }
        }

        public d(io.hansel.visualizer.c.d.m.a aVar) {
            this.f5805c = aVar;
        }

        public void a(Object obj) {
            if (g.this.f5792c.a(obj) && !this.f5803a.contains(obj)) {
                k a2 = g.this.f5795f.a(obj);
                k a3 = this.f5805c.a(obj);
                List<Object> emptyList = a2 != null ? a2.f5817c : Collections.emptyList();
                List<Object> list = a3.f5817c;
                e a4 = g.this.a(obj, (j) this.f5805c);
                int size = emptyList.size();
                for (int i = 0; i < size; i++) {
                    Object obj2 = emptyList.get(i);
                    if (g.this.f5792c.a(obj2)) {
                        k a5 = this.f5805c.a(obj2);
                        if (a5 == null || a5.f5816b == obj) {
                            a4.add(obj2);
                        }
                    }
                }
                g.b(a4, list, this.f5804b);
                g.this.a(a4);
            }
        }
    }

    public final class e extends ArrayList<Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f5808a;

        /* renamed from: b  reason: collision with root package name */
        public int f5809b;

        /* renamed from: c  reason: collision with root package name */
        public j f5810c;

        public e() {
            this.f5808a = null;
            this.f5809b = -1;
        }

        public /* synthetic */ e(g gVar, a aVar) {
            this();
        }

        public void a() {
            clear();
            this.f5808a = null;
            this.f5809b = -1;
            this.f5810c = null;
        }

        public void a(int i) {
            g.this.g.a(this.f5809b, g.this.f5792c.b(remove(i)).intValue());
        }

        public void a(int i, Object obj, io.hansel.visualizer.b.a<Object> aVar) {
            Object obj2 = i == 0 ? null : get(i - 1);
            int intValue = obj2 == null ? -1 : g.this.f5792c.b(obj2).intValue();
            add(i, obj);
            g.this.g.a(this.f5810c, obj, this.f5809b, intValue, aVar);
        }

        public void a(Object obj, j jVar) {
            this.f5808a = obj;
            this.f5809b = obj == null ? -1 : g.this.f5792c.b(this.f5808a).intValue();
            this.f5810c = jVar;
        }
    }

    public final class f extends io.hansel.visualizer.c.e.a {
        public f() {
        }

        public /* synthetic */ f(g gVar, a aVar) {
            this();
        }

        public void c(Object obj) {
            g.this.a();
            g.this.h().b(obj).a(obj);
        }

        public void d(Object obj) {
            g.this.a();
            g.this.h().b(obj).c(obj);
        }
    }

    /* renamed from: io.hansel.visualizer.c.d.g$g  reason: collision with other inner class name */
    public interface C0089g {
        void a(int i, int i2);

        void a(j jVar, Object obj, int i, int i2, io.hansel.visualizer.b.a<Object> aVar);
    }

    public class h implements C0089g {

        /* renamed from: a  reason: collision with root package name */
        public final List<C0089g> f5813a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public volatile C0089g[] f5814b;

        public h(g gVar) {
        }

        private C0089g[] a() {
            while (true) {
                C0089g[] gVarArr = this.f5814b;
                if (gVarArr != null) {
                    return gVarArr;
                }
                synchronized (this) {
                    if (this.f5814b == null) {
                        List<C0089g> list = this.f5813a;
                        this.f5814b = (C0089g[]) list.toArray(new C0089g[list.size()]);
                        C0089g[] gVarArr2 = this.f5814b;
                        return gVarArr2;
                    }
                }
            }
        }

        public void a(int i, int i2) {
            for (C0089g a2 : a()) {
                a2.a(i, i2);
            }
        }

        public void a(j jVar, Object obj, int i, int i2, io.hansel.visualizer.b.a<Object> aVar) {
            for (C0089g a2 : a()) {
                a2.a(jVar, obj, i, i2, aVar);
            }
        }
    }

    public g(i iVar) {
        super(iVar);
        this.f5791b = iVar;
    }

    /* access modifiers changed from: private */
    public e a(Object obj, j jVar) {
        e eVar = this.h;
        if (eVar == null) {
            eVar = new e(this, null);
        }
        this.h = null;
        eVar.a(obj, jVar);
        return eVar;
    }

    private void a(io.hansel.visualizer.b.b<Object> bVar) {
        bVar.clear();
        if (this.i == null) {
            this.i = bVar;
        }
    }

    /* access modifiers changed from: private */
    public void a(e eVar) {
        eVar.a();
        if (this.h == null) {
            this.h = eVar;
        }
    }

    private void a(io.hansel.visualizer.c.d.m.a aVar) {
        ArrayList arrayList = new ArrayList();
        aVar.b((io.hansel.visualizer.b.a<Object>) new b<Object>(aVar, arrayList));
        Collections.sort(arrayList);
        aVar.a((io.hansel.visualizer.b.a<Object>) new c<Object>(arrayList, aVar));
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f5792c.a(((Integer) arrayList.get(i2)).intValue());
        }
        aVar.a((io.hansel.visualizer.b.a<Object>) new d<Object>(aVar));
        aVar.b();
    }

    public static void b(e eVar, List<Object> list, io.hansel.visualizer.b.a<Object> aVar) {
        int i2 = 0;
        while (i2 <= eVar.size()) {
            if (i2 == eVar.size()) {
                if (i2 != list.size()) {
                    eVar.a(i2, list.get(i2), aVar);
                } else {
                    return;
                }
            } else if (i2 == list.size()) {
                eVar.a(i2);
            } else {
                Object obj = eVar.get(i2);
                Object obj2 = list.get(i2);
                if (obj != obj2) {
                    int indexOf = eVar.indexOf(obj2);
                    if (indexOf != -1) {
                        eVar.a(indexOf);
                    }
                    eVar.a(i2, obj2, aVar);
                }
            }
            i2++;
        }
    }

    private io.hansel.visualizer.b.b<Object> d() {
        io.hansel.visualizer.b.b<Object> bVar = this.i;
        if (bVar == null) {
            bVar = new io.hansel.visualizer.b.b<>();
        }
        this.i = null;
        return bVar;
    }

    /* access modifiers changed from: private */
    public io.hansel.visualizer.c.d.m.a f() {
        a();
        if (h().c() == this.f5795f.b()) {
            io.hansel.visualizer.b.b<Object> d2 = d();
            io.hansel.visualizer.c.d.m.b a2 = this.f5795f.a();
            this.f5793d.add(h().c());
            while (!this.f5793d.isEmpty()) {
                Object remove = this.f5793d.remove();
                l b2 = h().b(remove);
                this.f5792c.e(remove);
                b2.a(remove, (io.hansel.visualizer.b.a<Object>) d2);
                int i2 = 0;
                int size = d2.size();
                while (i2 < size) {
                    Object obj = d2.get(i2);
                    if (obj != null) {
                        this.f5793d.add(obj);
                    } else {
                        HSLLogger.e(b2.getClass().getName() + "getChildren() emitted a null child at position " + i2 + " for element " + remove);
                        d2.remove(i2);
                        i2 += -1;
                        size += -1;
                    }
                    i2++;
                }
                a2.a(remove, (List<Object>) d2);
                d2.clear();
            }
            a(d2);
            return a2.b();
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: private */
    public h h() {
        if (this.f5794e == null) {
            this.f5794e = this.f5791b.b();
        }
        return this.f5794e;
    }

    private void i() {
        h().a((Runnable) new a());
    }

    public l b(Object obj) {
        a();
        return h().b(obj);
    }

    public Object c() {
        a();
        Object c2 = h().c();
        if (c2 == null) {
            throw new IllegalStateException();
        } else if (c2 == this.f5795f.b()) {
            return c2;
        } else {
            throw new IllegalStateException();
        }
    }

    public synchronized void e() {
        int i2 = this.j;
        this.j = i2 + 1;
        if (i2 == 0) {
            i();
        }
    }

    public j g() {
        a();
        return this.f5795f;
    }

    public void j() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        io.hansel.visualizer.c.d.m.a f2 = f();
        boolean c2 = f2.c();
        if (c2) {
            f2.a();
        } else {
            a(f2);
        }
        StringBuilder outline76 = GeneratedOutlineSupport.outline76("Document.updateTree() completed in ", SystemClock.elapsedRealtime() - elapsedRealtime, " ms");
        outline76.append(c2 ? " (no changes)" : "");
        HSLLogger.d(outline76.toString());
    }
}
