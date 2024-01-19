package io.hansel.visualizer.c.d;

import io.hansel.visualizer.b.d;
import io.hansel.visualizer.b.g;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class m implements j {

    /* renamed from: a  reason: collision with root package name */
    public final Object f5818a;

    /* renamed from: b  reason: collision with root package name */
    public final IdentityHashMap<Object, k> f5819b = new IdentityHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f5820c;

    public final class a implements j {

        /* renamed from: a  reason: collision with root package name */
        public final Map<Object, k> f5821a;

        /* renamed from: b  reason: collision with root package name */
        public final Set<Object> f5822b;

        public a(Map<Object, k> map, Set<Object> set) {
            this.f5821a = map;
            this.f5822b = set;
        }

        private void a(Map<Object, k> map, Object obj) {
            k kVar = map.get(obj);
            Object obj2 = kVar.f5816b;
            if (obj2 == null || !map.containsKey(obj2)) {
                map.remove(obj);
                int size = kVar.f5817c.size();
                for (int i = 0; i < size; i++) {
                    a(map, kVar.f5817c.get(i));
                }
            }
        }

        public k a(Object obj) {
            k kVar = this.f5821a.get(obj);
            return kVar != null ? kVar : (k) m.this.f5819b.get(obj);
        }

        public void a() {
            if (m.this.f5820c) {
                m.this.f5820c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public void a(io.hansel.visualizer.b.a<Object> aVar) {
            ArrayList arrayList = new ArrayList(this.f5821a.keySet());
            for (int i = 0; i < arrayList.size(); i++) {
                aVar.a(arrayList.get(i));
            }
        }

        public void b() {
            if (m.this.f5820c) {
                m.this.f5819b.putAll(this.f5821a);
                ArrayList arrayList = new ArrayList(this.f5822b);
                for (int i = 0; i < arrayList.size(); i++) {
                    a(m.this.f5819b, arrayList.get(i));
                }
                m.this.f5820c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public void b(io.hansel.visualizer.b.a<Object> aVar) {
            ArrayDeque arrayDeque = new ArrayDeque();
            ArrayList arrayList = new ArrayList(this.f5822b);
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                k a2 = a(obj);
                if (obj != m.this.f5818a && a2.f5816b == null) {
                    arrayDeque.add(obj);
                    arrayDeque.add(obj);
                }
            }
            while (!arrayDeque.isEmpty()) {
                Object remove = arrayDeque.remove();
                Object remove2 = arrayDeque.remove();
                if (remove == remove2) {
                    remove2 = null;
                }
                if (a(remove).f5816b == remove2) {
                    aVar.a(remove);
                    k a3 = m.this.a(remove);
                    if (a3 != null) {
                        int size = a3.f5817c.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            arrayDeque.add(a3.f5817c.get(i2));
                            arrayDeque.add(remove);
                        }
                    }
                }
            }
        }

        public boolean b(Object obj) {
            return this.f5821a.containsKey(obj);
        }

        public boolean c() {
            return this.f5821a.isEmpty();
        }
    }

    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Map<Object, k> f5824a = new LinkedHashMap();

        /* renamed from: b  reason: collision with root package name */
        public final HashSet<Object> f5825b = new HashSet<>();

        /* renamed from: c  reason: collision with root package name */
        public HashSet<Object> f5826c;

        public b() {
        }

        private HashSet<Object> a() {
            HashSet<Object> hashSet = this.f5826c;
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            this.f5826c = null;
            return hashSet;
        }

        private void a(Object obj, Object obj2) {
            k kVar = this.f5824a.get(obj);
            if (kVar == null || obj2 != kVar.f5816b) {
                k kVar2 = (k) m.this.f5819b.get(obj);
                if (kVar != null || kVar2 == null || obj2 != kVar2.f5816b) {
                    if (kVar == null || kVar2 == null || obj2 != kVar2.f5816b || !d.a(kVar2.f5817c, kVar.f5817c)) {
                        this.f5824a.put(obj, new k(obj, obj2, kVar != null ? kVar.f5817c : kVar2 != null ? kVar2.f5817c : Collections.emptyList()));
                        if (obj2 == null) {
                            this.f5825b.add(obj);
                        } else {
                            this.f5825b.remove(obj);
                        }
                        return;
                    }
                    this.f5824a.remove(obj);
                    if (obj2 == null) {
                        this.f5825b.remove(obj);
                    }
                }
            }
        }

        private void a(HashSet<Object> hashSet) {
            hashSet.clear();
            if (this.f5826c == null) {
                this.f5826c = hashSet;
            }
        }

        public void a(Object obj, List<Object> list) {
            k kVar;
            k kVar2 = this.f5824a.get(obj);
            if (kVar2 == null || !d.a(list, kVar2.f5817c)) {
                k kVar3 = (k) m.this.f5819b.get(obj);
                if (kVar2 != null || kVar3 == null || !d.a(list, kVar3.f5817c)) {
                    if (kVar2 == null || kVar3 == null || kVar3.f5816b != kVar2.f5816b || !d.a(list, kVar3.f5817c)) {
                        k kVar4 = new k(obj, kVar2 != null ? kVar2.f5816b : kVar3 != null ? kVar3.f5816b : null, list);
                        this.f5824a.put(obj, kVar4);
                        kVar = kVar4;
                    } else {
                        kVar = (k) m.this.f5819b.get(obj);
                        this.f5824a.remove(obj);
                    }
                    HashSet<Object> a2 = a();
                    if (kVar3 != null) {
                        List<Object> list2 = kVar3.f5817c;
                        if (list2 != kVar.f5817c) {
                            int size = list2.size();
                            for (int i = 0; i < size; i++) {
                                a2.add(kVar3.f5817c.get(i));
                            }
                        }
                    }
                    if (kVar2 != null) {
                        List<Object> list3 = kVar2.f5817c;
                        if (list3 != kVar.f5817c) {
                            int size2 = list3.size();
                            for (int i2 = 0; i2 < size2; i2++) {
                                a2.add(kVar2.f5817c.get(i2));
                            }
                        }
                    }
                    int size3 = kVar.f5817c.size();
                    for (int i3 = 0; i3 < size3; i3++) {
                        Object obj2 = kVar.f5817c.get(i3);
                        a(obj2, obj);
                        a2.remove(obj2);
                    }
                    Iterator<Object> it = a2.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        k kVar5 = this.f5824a.get(next);
                        if (kVar5 == null || kVar5.f5816b == obj) {
                            k kVar6 = (k) m.this.f5819b.get(next);
                            if (kVar6 != null && kVar6.f5816b == obj) {
                                a(next, (Object) null);
                            }
                        }
                    }
                    a(a2);
                }
            }
        }

        public a b() {
            return new a(this.f5824a, this.f5825b);
        }
    }

    public m(Object obj) {
        this.f5818a = g.b(obj);
    }

    public k a(Object obj) {
        return this.f5819b.get(obj);
    }

    public b a() {
        if (!this.f5820c) {
            this.f5820c = true;
            return new b();
        }
        throw new IllegalStateException();
    }

    public Object b() {
        return this.f5818a;
    }
}
