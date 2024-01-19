package com.userexperior.a.a.b;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class m<T> implements Iterator<T> {

    /* renamed from: b  reason: collision with root package name */
    public n<K, V> f3704b;

    /* renamed from: c  reason: collision with root package name */
    public n<K, V> f3705c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f3706d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ j f3707e;

    public m(j jVar) {
        this.f3707e = jVar;
        j jVar2 = this.f3707e;
        this.f3704b = jVar2.f3699e.f3711d;
        this.f3706d = jVar2.f3698d;
    }

    public final n<K, V> a() {
        n<K, V> nVar = this.f3704b;
        j jVar = this.f3707e;
        if (nVar == jVar.f3699e) {
            throw new NoSuchElementException();
        } else if (jVar.f3698d == this.f3706d) {
            this.f3704b = nVar.f3711d;
            this.f3705c = nVar;
            return nVar;
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean hasNext() {
        return this.f3704b != this.f3707e.f3699e;
    }

    public final void remove() {
        n<K, V> nVar = this.f3705c;
        if (nVar != null) {
            this.f3707e.a(nVar, true);
            this.f3705c = null;
            this.f3706d = this.f3707e.f3698d;
            return;
        }
        throw new IllegalStateException();
    }
}
