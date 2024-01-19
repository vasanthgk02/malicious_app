package com.userexperior.a.a.b;

import com.facebook.react.bridge.ColorPropConverter;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public final class e implements Serializable, WildcardType {

    /* renamed from: a  reason: collision with root package name */
    public final Type f3654a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f3655b;

    public e(Type[] typeArr, Type[] typeArr2) {
        Class<Object> cls = Object.class;
        boolean z = true;
        a.a(typeArr2.length <= 1);
        a.a(typeArr.length == 1);
        if (typeArr2.length == 1) {
            a.a(typeArr2[0]);
            b.e(typeArr2[0]);
            a.a(typeArr[0] != cls ? false : z);
            this.f3655b = b.a(typeArr2[0]);
            this.f3654a = cls;
            return;
        }
        a.a(typeArr[0]);
        b.e(typeArr[0]);
        this.f3655b = null;
        this.f3654a = b.a(typeArr[0]);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && b.a((Type) this, (Type) (WildcardType) obj);
    }

    public final Type[] getLowerBounds() {
        Type type = this.f3655b;
        if (type == null) {
            return b.f3649a;
        }
        return new Type[]{type};
    }

    public final Type[] getUpperBounds() {
        return new Type[]{this.f3654a};
    }

    public final int hashCode() {
        Type type = this.f3655b;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.f3654a.hashCode() + 31);
    }

    public final String toString() {
        StringBuilder sb;
        Type type;
        if (this.f3655b != null) {
            sb = new StringBuilder("? super ");
            type = this.f3655b;
        } else if (this.f3654a == Object.class) {
            return ColorPropConverter.PREFIX_ATTR;
        } else {
            sb = new StringBuilder("? extends ");
            type = this.f3654a;
        }
        sb.append(b.c(type));
        return sb.toString();
    }
}
