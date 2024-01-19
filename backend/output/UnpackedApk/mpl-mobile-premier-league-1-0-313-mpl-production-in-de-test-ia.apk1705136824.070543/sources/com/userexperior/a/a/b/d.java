package com.userexperior.a.a.b;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public final class d implements Serializable, ParameterizedType {

    /* renamed from: a  reason: collision with root package name */
    public final Type f3651a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f3652b;

    /* renamed from: c  reason: collision with root package name */
    public final Type[] f3653c;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        r3 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(java.lang.reflect.Type r5, java.lang.reflect.Type r6, java.lang.reflect.Type... r7) {
        /*
            r4 = this;
            r4.<init>()
            boolean r0 = r6 instanceof java.lang.Class
            r1 = 0
            if (r0 == 0) goto L_0x0029
            r0 = r6
            java.lang.Class r0 = (java.lang.Class) r0
            int r2 = r0.getModifiers()
            boolean r2 = java.lang.reflect.Modifier.isStatic(r2)
            r3 = 1
            if (r2 != 0) goto L_0x001f
            java.lang.Class r0 = r0.getEnclosingClass()
            if (r0 != 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            if (r5 != 0) goto L_0x0026
            if (r0 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r3 = 0
        L_0x0026:
            com.userexperior.a.a.b.a.a(r3)
        L_0x0029:
            if (r5 != 0) goto L_0x002d
            r5 = 0
            goto L_0x0031
        L_0x002d:
            java.lang.reflect.Type r5 = com.userexperior.a.a.b.b.a(r5)
        L_0x0031:
            r4.f3651a = r5
            java.lang.reflect.Type r5 = com.userexperior.a.a.b.b.a(r6)
            r4.f3652b = r5
            java.lang.Object r5 = r7.clone()
            java.lang.reflect.Type[] r5 = (java.lang.reflect.Type[]) r5
            r4.f3653c = r5
        L_0x0041:
            java.lang.reflect.Type[] r5 = r4.f3653c
            int r6 = r5.length
            if (r1 >= r6) goto L_0x005f
            r5 = r5[r1]
            com.userexperior.a.a.b.a.a(r5)
            java.lang.reflect.Type[] r5 = r4.f3653c
            r5 = r5[r1]
            com.userexperior.a.a.b.b.e(r5)
            java.lang.reflect.Type[] r5 = r4.f3653c
            r6 = r5[r1]
            java.lang.reflect.Type r6 = com.userexperior.a.a.b.b.a(r6)
            r5[r1] = r6
            int r1 = r1 + 1
            goto L_0x0041
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.b.d.<init>(java.lang.reflect.Type, java.lang.reflect.Type, java.lang.reflect.Type[]):void");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && b.a((Type) this, (Type) (ParameterizedType) obj);
    }

    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f3653c.clone();
    }

    public final Type getOwnerType() {
        return this.f3651a;
    }

    public final Type getRawType() {
        return this.f3652b;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.f3653c) ^ this.f3652b.hashCode()) ^ b.a((Object) this.f3651a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f3653c.length + 1) * 30);
        sb.append(b.c(this.f3652b));
        if (this.f3653c.length == 0) {
            return sb.toString();
        }
        sb.append("<");
        sb.append(b.c(this.f3653c[0]));
        for (int i = 1; i < this.f3653c.length; i++) {
            sb.append(", ");
            sb.append(b.c(this.f3653c[i]));
        }
        sb.append(">");
        return sb.toString();
    }
}
