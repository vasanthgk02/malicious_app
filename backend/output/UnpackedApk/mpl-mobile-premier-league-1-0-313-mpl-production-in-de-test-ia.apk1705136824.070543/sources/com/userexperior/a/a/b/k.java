package com.userexperior.a.a.b;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

public final class k extends AbstractSet<Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f3700a;

    public k(j jVar) {
        this.f3700a = jVar;
    }

    public final void clear() {
        this.f3700a.clear();
    }

    public final boolean contains(Object obj) {
        return (obj instanceof Entry) && this.f3700a.a((Entry) obj) != null;
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new m() {
            {
                j jVar = k.this.f3700a;
            }

            public final /* synthetic */ Object next() {
                return a();
            }
        };
    }

    public final boolean remove(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        n a2 = this.f3700a.a((Entry) obj);
        if (a2 == null) {
            return false;
        }
        this.f3700a.a(a2, true);
        return true;
    }

    public final int size() {
        return this.f3700a.f3697c;
    }
}
