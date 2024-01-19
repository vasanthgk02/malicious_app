package org.apache.commons.lang.builder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HashCodeBuilder {
    public static ThreadLocal registry = new ThreadLocal() {
        public Object initialValue() {
            return new HashSet();
        }
    };
    public final int iConstant;
    public int iTotal;

    public HashCodeBuilder() {
        this.iTotal = 0;
        this.iConstant = 37;
        this.iTotal = 17;
    }

    public static Set getRegistry() {
        return (Set) registry.get();
    }

    public static boolean isRegistered(Object obj) {
        return getRegistry().contains(toIdentityHashCodeInteger(obj));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:20|21|22|23|24) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0056 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void reflectionAppend(java.lang.Object r4, java.lang.Class r5, org.apache.commons.lang.builder.HashCodeBuilder r6, boolean r7, java.lang.String[] r8) {
        /*
            boolean r0 = isRegistered(r4)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            register(r4)     // Catch:{ all -> 0x0065 }
            java.lang.reflect.Field[] r5 = r5.getDeclaredFields()     // Catch:{ all -> 0x0065 }
            if (r8 == 0) goto L_0x0015
            java.util.List r8 = java.util.Arrays.asList(r8)     // Catch:{ all -> 0x0065 }
            goto L_0x0017
        L_0x0015:
            java.util.List r8 = java.util.Collections.EMPTY_LIST     // Catch:{ all -> 0x0065 }
        L_0x0017:
            r0 = 1
            java.lang.reflect.AccessibleObject.setAccessible(r5, r0)     // Catch:{ all -> 0x0065 }
            r0 = 0
        L_0x001c:
            int r1 = r5.length     // Catch:{ all -> 0x0065 }
            if (r0 >= r1) goto L_0x0061
            r1 = r5[r0]     // Catch:{ all -> 0x0065 }
            java.lang.String r2 = r1.getName()     // Catch:{ all -> 0x0065 }
            boolean r2 = r8.contains(r2)     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x005e
            java.lang.String r2 = r1.getName()     // Catch:{ all -> 0x0065 }
            r3 = 36
            int r2 = r2.indexOf(r3)     // Catch:{ all -> 0x0065 }
            r3 = -1
            if (r2 != r3) goto L_0x005e
            if (r7 != 0) goto L_0x0044
            int r2 = r1.getModifiers()     // Catch:{ all -> 0x0065 }
            boolean r2 = java.lang.reflect.Modifier.isTransient(r2)     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x005e
        L_0x0044:
            int r2 = r1.getModifiers()     // Catch:{ all -> 0x0065 }
            boolean r2 = java.lang.reflect.Modifier.isStatic(r2)     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x005e
            java.lang.Object r1 = r1.get(r4)     // Catch:{ IllegalAccessException -> 0x0056 }
            r6.append(r1)     // Catch:{ IllegalAccessException -> 0x0056 }
            goto L_0x005e
        L_0x0056:
            java.lang.InternalError r5 = new java.lang.InternalError     // Catch:{ all -> 0x0065 }
            java.lang.String r6 = "Unexpected IllegalAccessException"
            r5.<init>(r6)     // Catch:{ all -> 0x0065 }
            throw r5     // Catch:{ all -> 0x0065 }
        L_0x005e:
            int r0 = r0 + 1
            goto L_0x001c
        L_0x0061:
            unregister(r4)
            return
        L_0x0065:
            r5 = move-exception
            unregister(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.builder.HashCodeBuilder.reflectionAppend(java.lang.Object, java.lang.Class, org.apache.commons.lang.builder.HashCodeBuilder, boolean, java.lang.String[]):void");
    }

    public static int reflectionHashCode(int i, int i2, Object obj) {
        return reflectionHashCode(i, i2, obj, false, null, null);
    }

    public static void register(Object obj) {
        getRegistry().add(toIdentityHashCodeInteger(obj));
    }

    public static Integer toIdentityHashCodeInteger(Object obj) {
        return new Integer(System.identityHashCode(obj));
    }

    public static void unregister(Object obj) {
        getRegistry().remove(toIdentityHashCodeInteger(obj));
    }

    public HashCodeBuilder append(boolean z) {
        this.iTotal = (this.iTotal * this.iConstant) + (z ^ true ? 1 : 0);
        return this;
    }

    public HashCodeBuilder appendSuper(int i) {
        this.iTotal = (this.iTotal * this.iConstant) + i;
        return this;
    }

    public int toHashCode() {
        return this.iTotal;
    }

    public static int reflectionHashCode(int i, int i2, Object obj, boolean z) {
        return reflectionHashCode(i, i2, obj, z, null, null);
    }

    public HashCodeBuilder append(boolean[] zArr) {
        if (zArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (boolean append : zArr) {
                append(append);
            }
        }
        return this;
    }

    public static int reflectionHashCode(int i, int i2, Object obj, boolean z, Class cls) {
        return reflectionHashCode(i, i2, obj, z, cls, null);
    }

    public static int reflectionHashCode(int i, int i2, Object obj, boolean z, Class cls, String[] strArr) {
        if (obj != null) {
            HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(i, i2);
            Class cls2 = obj.getClass();
            reflectionAppend(obj, cls2, hashCodeBuilder, z, strArr);
            while (cls2.getSuperclass() != null && cls2 != cls) {
                cls2 = cls2.getSuperclass();
                reflectionAppend(obj, cls2, hashCodeBuilder, z, strArr);
            }
            return hashCodeBuilder.toHashCode();
        }
        throw new IllegalArgumentException("The object to build a hash code for must not be null");
    }

    public HashCodeBuilder(int i, int i2) {
        this.iTotal = 0;
        if (i == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires a non zero initial value");
        } else if (i % 2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires an odd initial value");
        } else if (i2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires a non zero multiplier");
        } else if (i2 % 2 != 0) {
            this.iConstant = i2;
            this.iTotal = i;
        } else {
            throw new IllegalArgumentException("HashCodeBuilder requires an odd multiplier");
        }
    }

    public HashCodeBuilder append(byte b2) {
        this.iTotal = (this.iTotal * this.iConstant) + b2;
        return this;
    }

    public HashCodeBuilder append(byte[] bArr) {
        if (bArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (byte append : bArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(char c2) {
        this.iTotal = (this.iTotal * this.iConstant) + c2;
        return this;
    }

    public HashCodeBuilder append(char[] cArr) {
        if (cArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (char append : cArr) {
                append(append);
            }
        }
        return this;
    }

    public static int reflectionHashCode(Object obj) {
        return reflectionHashCode(17, 37, obj, false, null, null);
    }

    public static int reflectionHashCode(Object obj, boolean z) {
        return reflectionHashCode(17, 37, obj, z, null, null);
    }

    public HashCodeBuilder append(double d2) {
        return append(Double.doubleToLongBits(d2));
    }

    public static int reflectionHashCode(Object obj, Collection collection) {
        return reflectionHashCode(obj, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public HashCodeBuilder append(double[] dArr) {
        if (dArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (double append : dArr) {
                append(append);
            }
        }
        return this;
    }

    public static int reflectionHashCode(Object obj, String[] strArr) {
        return reflectionHashCode(17, 37, obj, false, null, strArr);
    }

    public HashCodeBuilder append(float f2) {
        this.iTotal = Float.floatToIntBits(f2) + (this.iTotal * this.iConstant);
        return this;
    }

    public HashCodeBuilder append(float[] fArr) {
        if (fArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (float append : fArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(int i) {
        this.iTotal = (this.iTotal * this.iConstant) + i;
        return this;
    }

    public HashCodeBuilder append(int[] iArr) {
        if (iArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (int append : iArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(long j) {
        this.iTotal = (this.iTotal * this.iConstant) + ((int) (j ^ (j >> 32)));
        return this;
    }

    public HashCodeBuilder append(long[] jArr) {
        if (jArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (long append : jArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(Object obj) {
        if (obj == null) {
            this.iTotal *= this.iConstant;
        } else if (obj instanceof long[]) {
            append((long[]) obj);
        } else if (obj instanceof int[]) {
            append((int[]) obj);
        } else if (obj instanceof short[]) {
            append((short[]) obj);
        } else if (obj instanceof char[]) {
            append((char[]) obj);
        } else if (obj instanceof byte[]) {
            append((byte[]) obj);
        } else if (obj instanceof double[]) {
            append((double[]) obj);
        } else if (obj instanceof float[]) {
            append((float[]) obj);
        } else if (obj instanceof boolean[]) {
            append((boolean[]) obj);
        } else if (obj instanceof Object[]) {
            append((Object[]) obj);
        } else {
            this.iTotal = obj.hashCode() + (this.iTotal * this.iConstant);
        }
        return this;
    }

    public HashCodeBuilder append(Object[] objArr) {
        if (objArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (Object append : objArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(short s) {
        this.iTotal = (this.iTotal * this.iConstant) + s;
        return this;
    }

    public HashCodeBuilder append(short[] sArr) {
        if (sArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (short append : sArr) {
                append(append);
            }
        }
        return this;
    }
}
