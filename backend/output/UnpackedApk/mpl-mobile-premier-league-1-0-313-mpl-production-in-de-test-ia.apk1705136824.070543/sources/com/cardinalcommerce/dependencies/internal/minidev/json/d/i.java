package com.cardinalcommerce.dependencies.internal.minidev.json.d;

import com.cardinalcommerce.dependencies.internal.minidev.json.JSONArray;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONAware;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONAwareEx;
import com.cardinalcommerce.dependencies.internal.minidev.json.JSONObject;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public j<JSONAwareEx> f1941a = new e(this);

    /* renamed from: b  reason: collision with root package name */
    public j<JSONAwareEx> f1942b = new g(this);

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<Type, j<?>> f1943c;

    public i() {
        ConcurrentHashMap<Type, j<?>> concurrentHashMap = new ConcurrentHashMap<>(100);
        this.f1943c = concurrentHashMap;
        concurrentHashMap.put(Date.class, b.f1940a);
        this.f1943c.put(int[].class, a.f1936a);
        this.f1943c.put(Integer[].class, a.f1937b);
        this.f1943c.put(short[].class, a.f1936a);
        this.f1943c.put(Short[].class, a.f1937b);
        this.f1943c.put(long[].class, a.i);
        this.f1943c.put(Long[].class, a.j);
        this.f1943c.put(byte[].class, a.f1938e);
        this.f1943c.put(Byte[].class, a.f1939f);
        this.f1943c.put(char[].class, a.g);
        this.f1943c.put(Character[].class, a.h);
        this.f1943c.put(float[].class, a.k);
        this.f1943c.put(Float[].class, a.l);
        this.f1943c.put(double[].class, a.m);
        this.f1943c.put(Double[].class, a.n);
        this.f1943c.put(boolean[].class, a.o);
        this.f1943c.put(Boolean[].class, a.p);
        this.f1943c.put(JSONAwareEx.class, this.f1941a);
        this.f1943c.put(JSONAware.class, this.f1941a);
        this.f1943c.put(JSONArray.class, this.f1941a);
        this.f1943c.put(JSONObject.class, this.f1941a);
    }
}
