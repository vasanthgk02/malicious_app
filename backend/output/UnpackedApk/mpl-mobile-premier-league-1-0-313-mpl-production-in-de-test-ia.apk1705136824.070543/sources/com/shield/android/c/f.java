package com.shield.android.c;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentMap<String, String> f1517a;

    public f() {
        this.f1517a = new ConcurrentHashMap();
    }

    public f(ConcurrentMap<String, String> concurrentMap) {
        if (concurrentMap != null) {
            this.f1517a = concurrentMap;
            return;
        }
        throw new IllegalArgumentException("Map must not be null.");
    }
}
