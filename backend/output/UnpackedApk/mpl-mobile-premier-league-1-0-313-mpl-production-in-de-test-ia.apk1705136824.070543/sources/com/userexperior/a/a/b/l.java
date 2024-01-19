package com.userexperior.a.a.b;

import java.util.AbstractSet;
import java.util.Iterator;

public final class l extends AbstractSet<K> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f3702a;

    public l(j jVar) {
        this.f3702a = jVar;
    }

    public final void clear() {
        this.f3702a.clear();
    }

    public final boolean contains(Object obj) {
        return this.f3702a.containsKey(obj);
    }

    public final Iterator<K> iterator() {
        return new m() {
            {
                j jVar = l.this.f3702a;
            }

            public final K next() {
                return a().f3713f;
            }
        };
    }

    public final boolean remove(Object obj) {
        return this.f3702a.a(obj) != null;
    }

    public final int size() {
        return this.f3702a.f3697c;
    }
}
