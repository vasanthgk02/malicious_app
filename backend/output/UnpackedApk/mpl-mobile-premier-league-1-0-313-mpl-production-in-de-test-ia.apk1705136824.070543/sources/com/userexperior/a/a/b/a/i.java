package com.userexperior.a.a.b.a;

import com.userexperior.a.a.b.h;
import com.userexperior.a.a.b.o;
import com.userexperior.a.a.b.q;
import com.userexperior.a.a.d.a;
import com.userexperior.a.a.d.b;
import com.userexperior.a.a.d.c;
import com.userexperior.a.a.f;
import com.userexperior.a.a.j;
import com.userexperior.a.a.l;
import com.userexperior.a.a.n;
import com.userexperior.a.a.s;
import com.userexperior.a.a.u;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public final class i<K, V> extends u<Map<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f3588a;

    /* renamed from: b  reason: collision with root package name */
    public final u<K> f3589b;

    /* renamed from: c  reason: collision with root package name */
    public final u<V> f3590c;

    /* renamed from: d  reason: collision with root package name */
    public final o<? extends Map<K, V>> f3591d;

    public i(h hVar, f fVar, Type type, u<K> uVar, Type type2, u<V> uVar2, o<? extends Map<K, V>> oVar) {
        this.f3588a = hVar;
        this.f3589b = new s(fVar, uVar, type);
        this.f3590c = new s(fVar, uVar2, type2);
        this.f3591d = oVar;
    }

    public final /* synthetic */ Object a(a aVar) throws IOException {
        b f2 = aVar.f();
        if (f2 == b.NULL) {
            aVar.k();
            return null;
        }
        Map map = (Map) this.f3591d.a();
        if (f2 == b.BEGIN_ARRAY) {
            aVar.a();
            while (aVar.e()) {
                aVar.a();
                Object a2 = this.f3589b.a(aVar);
                if (map.put(a2, this.f3590c.a(aVar)) == null) {
                    aVar.b();
                } else {
                    throw new s("duplicate key: ".concat(String.valueOf(a2)));
                }
            }
            aVar.b();
        } else {
            aVar.c();
            while (aVar.e()) {
                h.f3692a.a(aVar);
                Object a3 = this.f3589b.a(aVar);
                if (map.put(a3, this.f3590c.a(aVar)) != null) {
                    throw new s("duplicate key: ".concat(String.valueOf(a3)));
                }
            }
            aVar.d();
        }
        return map;
    }

    public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
        String str;
        Map map = (Map) obj;
        if (map == null) {
            cVar.e();
        } else if (!this.f3588a.f3586a) {
            cVar.c();
            for (Entry entry : map.entrySet()) {
                cVar.a(String.valueOf(entry.getKey()));
                this.f3590c.a(cVar, entry.getValue());
            }
            cVar.d();
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i = 0;
            boolean z = false;
            for (Entry entry2 : map.entrySet()) {
                l a2 = this.f3589b.a(entry2.getKey());
                arrayList.add(a2);
                arrayList2.add(entry2.getValue());
                z |= (a2 instanceof j) || (a2 instanceof com.userexperior.a.a.o);
            }
            if (z) {
                cVar.a();
                while (i < arrayList.size()) {
                    cVar.a();
                    q.a((l) arrayList.get(i), cVar);
                    this.f3590c.a(cVar, arrayList2.get(i));
                    cVar.b();
                    i++;
                }
                cVar.b();
                return;
            }
            cVar.c();
            while (i < arrayList.size()) {
                l lVar = (l) arrayList.get(i);
                if (lVar instanceof com.userexperior.a.a.q) {
                    com.userexperior.a.a.q g = lVar.g();
                    Object obj2 = g.f3761a;
                    if (obj2 instanceof Number) {
                        str = String.valueOf(g.a());
                    } else if (obj2 instanceof Boolean) {
                        str = Boolean.toString(g.f());
                    } else if (obj2 instanceof String) {
                        str = g.b();
                    } else {
                        throw new AssertionError();
                    }
                } else if (lVar instanceof n) {
                    str = "null";
                } else {
                    throw new AssertionError();
                }
                cVar.a(str);
                this.f3590c.a(cVar, arrayList2.get(i));
                i++;
            }
            cVar.d();
        }
    }
}
