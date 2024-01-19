package com.userexperior.a.a.b;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import okhttp3.HttpUrl;

public final class c implements Serializable, GenericArrayType {

    /* renamed from: a  reason: collision with root package name */
    public final Type f3650a;

    public c(Type type) {
        this.f3650a = b.a(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && b.a((Type) this, (Type) (GenericArrayType) obj);
    }

    public final Type getGenericComponentType() {
        return this.f3650a;
    }

    public final int hashCode() {
        return this.f3650a.hashCode();
    }

    public final String toString() {
        return b.c(this.f3650a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }
}
