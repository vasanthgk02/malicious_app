package com.userexperior.e;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public AtomicInteger f4021a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Queue<o<?>>> f4022b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<o<?>> f4023c;

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<o<?>> f4024d;

    /* renamed from: e  reason: collision with root package name */
    public final PriorityBlockingQueue<o<?>> f4025e;

    /* renamed from: f  reason: collision with root package name */
    public final b f4026f;
    public final j g;
    public final u h;
    public k[] i;
    public d j;
    public List<Object> k;

    public q(b bVar, j jVar) {
        this(bVar, jVar, (u) new f(new Handler(Looper.getMainLooper())));
    }

    public q(b bVar, j jVar, byte b2) {
        this(bVar, jVar);
    }

    public q(b bVar, j jVar, u uVar) {
        this.f4021a = new AtomicInteger();
        this.f4022b = new HashMap();
        this.f4023c = new HashSet();
        this.f4024d = new PriorityBlockingQueue<>();
        this.f4025e = new PriorityBlockingQueue<>();
        this.k = new ArrayList();
        this.f4026f = bVar;
        this.g = jVar;
        this.i = new k[4];
        this.h = uVar;
    }

    public final <T> o<T> a(o<T> oVar) {
        oVar.k = this;
        synchronized (this.f4023c) {
            this.f4023c.add(oVar);
        }
        oVar.j = Integer.valueOf(this.f4021a.incrementAndGet());
        oVar.a((String) "add-to-queue");
        if (!oVar.l) {
            this.f4025e.add(oVar);
            return oVar;
        }
        synchronized (this.f4022b) {
            String c2 = oVar.c();
            if (this.f4022b.containsKey(c2)) {
                Queue queue = this.f4022b.get(c2);
                if (queue == null) {
                    queue = new LinkedList();
                }
                queue.add(oVar);
                this.f4022b.put(c2, queue);
                if (z.f4034b) {
                    z.a("Request for cacheKey=%s is in flight, putting on hold.", c2);
                }
            } else {
                this.f4022b.put(c2, null);
                this.f4024d.add(oVar);
            }
        }
        return oVar;
    }

    public final void a() {
        d dVar = this.j;
        if (dVar != null) {
            dVar.f3980a = true;
            dVar.interrupt();
        }
        int i2 = 0;
        while (true) {
            k[] kVarArr = this.i;
            if (i2 >= kVarArr.length) {
                break;
            }
            if (kVarArr[i2] != null) {
                k kVar = kVarArr[i2];
                kVar.f4002a = true;
                kVar.interrupt();
            }
            i2++;
        }
        d dVar2 = new d(this.f4024d, this.f4025e, this.f4026f, this.h);
        this.j = dVar2;
        dVar2.start();
        for (int i3 = 0; i3 < this.i.length; i3++) {
            k kVar2 = new k(this.f4025e, this.g, this.f4026f, this.h);
            this.i[i3] = kVar2;
            kVar2.start();
        }
    }

    public final <T> void b(o<T> oVar) {
        synchronized (this.f4023c) {
            this.f4023c.remove(oVar);
        }
        synchronized (this.k) {
            Iterator<Object> it = this.k.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (oVar.l) {
            synchronized (this.f4022b) {
                String c2 = oVar.c();
                Queue remove = this.f4022b.remove(c2);
                if (remove != null) {
                    if (z.f4034b) {
                        z.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), c2);
                    }
                    this.f4024d.addAll(remove);
                }
            }
        }
    }
}
