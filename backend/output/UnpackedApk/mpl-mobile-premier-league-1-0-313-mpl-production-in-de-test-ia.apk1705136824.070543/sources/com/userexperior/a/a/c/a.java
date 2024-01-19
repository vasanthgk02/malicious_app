package com.userexperior.a.a.c;

import com.userexperior.a.a.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<? super T> f3725a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f3726b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3727c;

    public a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            Type a2 = b.a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
            this.f3726b = a2;
            this.f3725a = b.b(a2);
            this.f3727c = this.f3726b.hashCode();
            return;
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public a(Type type) {
        Type a2 = b.a((Type) com.userexperior.a.a.b.a.a(type));
        this.f3726b = a2;
        this.f3725a = b.b(a2);
        this.f3727c = this.f3726b.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.a(this.f3726b, ((a) obj).f3726b);
    }

    public final int hashCode() {
        return this.f3727c;
    }

    public final String toString() {
        return b.c(this.f3726b);
    }
}
