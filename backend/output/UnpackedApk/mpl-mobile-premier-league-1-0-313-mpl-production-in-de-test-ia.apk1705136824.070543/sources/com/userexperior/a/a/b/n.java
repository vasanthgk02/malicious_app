package com.userexperior.a.a.b;

import in.juspay.hypersdk.core.InflateView;
import java.util.Map.Entry;

public final class n<K, V> implements Entry<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public n<K, V> f3708a;

    /* renamed from: b  reason: collision with root package name */
    public n<K, V> f3709b;

    /* renamed from: c  reason: collision with root package name */
    public n<K, V> f3710c;

    /* renamed from: d  reason: collision with root package name */
    public n<K, V> f3711d;

    /* renamed from: e  reason: collision with root package name */
    public n<K, V> f3712e;

    /* renamed from: f  reason: collision with root package name */
    public final K f3713f;
    public V g;
    public int h;

    public n() {
        this.f3713f = null;
        this.f3712e = this;
        this.f3711d = this;
    }

    public n(n<K, V> nVar, K k, n<K, V> nVar2, n<K, V> nVar3) {
        this.f3708a = nVar;
        this.f3713f = k;
        this.h = 1;
        this.f3711d = nVar2;
        this.f3712e = nVar3;
        nVar3.f3711d = this;
        nVar2.f3712e = this;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Entry) {
            Entry entry = (Entry) obj;
            K k = this.f3713f;
            if (k != null ? k.equals(entry.getKey()) : entry.getKey() == null) {
                V v = this.g;
                Object value = entry.getValue();
                if (v != null ? v.equals(value) : value == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final K getKey() {
        return this.f3713f;
    }

    public final V getValue() {
        return this.g;
    }

    public final int hashCode() {
        K k = this.f3713f;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.g;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        V v2 = this.g;
        this.g = v;
        return v2;
    }

    public final String toString() {
        return this.f3713f + InflateView.SETTER_EQUALS + this.g;
    }
}
