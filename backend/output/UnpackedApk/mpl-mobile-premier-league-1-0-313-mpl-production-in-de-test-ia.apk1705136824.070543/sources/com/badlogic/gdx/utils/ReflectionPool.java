package com.badlogic.gdx.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.utils.reflect.Constructor;

public class ReflectionPool<T> extends Pool<T> {
    public final Constructor constructor;

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r5 = co.hyperverge.hypersnapsdk.c.k.getDeclaredConstructor(r3, null);
        r5.constructor.setAccessible(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ReflectionPool(java.lang.Class<T> r3, int r4, int r5) {
        /*
            r2 = this;
            r2.<init>(r4, r5)
            r4 = 0
            com.badlogic.gdx.utils.reflect.Constructor r4 = co.hyperverge.hypersnapsdk.c.k.getConstructor(r3, r4)     // Catch:{ Exception -> 0x0009 }
            goto L_0x0016
        L_0x0009:
            com.badlogic.gdx.utils.reflect.Constructor r5 = co.hyperverge.hypersnapsdk.c.k.getDeclaredConstructor(r3, r4)     // Catch:{ ReflectionException -> 0x0015 }
            r0 = 1
            java.lang.reflect.Constructor r1 = r5.constructor     // Catch:{ ReflectionException -> 0x0015 }
            r1.setAccessible(r0)     // Catch:{ ReflectionException -> 0x0015 }
            r4 = r5
            goto L_0x0016
        L_0x0015:
        L_0x0016:
            r2.constructor = r4
            if (r4 == 0) goto L_0x001b
            return
        L_0x001b:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "Class cannot be created (missing no-arg constructor): "
            java.lang.StringBuilder r5 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r5)
            java.lang.String r3 = com.android.tools.r8.GeneratedOutlineSupport.outline35(r3, r5)
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.ReflectionPool.<init>(java.lang.Class, int, int):void");
    }

    public T newObject() {
        try {
            return this.constructor.newInstance(null);
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to create new instance: ");
            outline73.append(this.constructor.getDeclaringClass().getName());
            throw new GdxRuntimeException(outline73.toString(), e2);
        }
    }
}
