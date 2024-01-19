package com.google.protobuf;

import com.rudderstack.android.sdk.core.RudderTraits;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sfs2x.client.entities.invitation.InvitationReply;
import sun.misc.Unsafe;

public final class UnsafeUtil {
    public static final long BYTE_ARRAY_BASE_OFFSET = ((long) arrayBaseOffset(byte[].class));
    public static final boolean HAS_UNSAFE_ARRAY_OPERATIONS;
    public static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    public static final boolean IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
    public static final boolean IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
    public static final boolean IS_BIG_ENDIAN = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);
    public static final MemoryAccessor MEMORY_ACCESSOR;
    public static final Class<?> MEMORY_CLASS = Android.MEMORY_CLASS;
    public static final Unsafe UNSAFE = getUnsafe();

    public static final class Android32MemoryAccessor extends MemoryAccessor {
        public Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public boolean getBoolean(Object obj, long j) {
            boolean z = false;
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                if (UnsafeUtil.getByteBigEndian(obj, j) != 0) {
                    z = true;
                }
                return z;
            }
            if (UnsafeUtil.getByteLittleEndian(obj, j) != 0) {
                z = true;
            }
            return z;
        }

        public byte getByte(Object obj, long j) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getByteBigEndian(obj, j);
            }
            return UnsafeUtil.getByteLittleEndian(obj, j);
        }

        public double getDouble(Object obj, long j) {
            return Double.longBitsToDouble(getLong(obj, j));
        }

        public float getFloat(Object obj, long j) {
            return Float.intBitsToFloat(getInt(obj, j));
        }

        public void putBoolean(Object obj, long j, boolean z) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j, z ? (byte) 1 : 0);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j, z ? (byte) 1 : 0);
            }
        }

        public void putByte(Object obj, long j, byte b2) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j, b2);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j, b2);
            }
        }

        public void putDouble(Object obj, long j, double d2) {
            putLong(obj, j, Double.doubleToLongBits(d2));
        }

        public void putFloat(Object obj, long j, float f2) {
            putInt(obj, j, Float.floatToIntBits(f2));
        }
    }

    public static final class Android64MemoryAccessor extends MemoryAccessor {
        public Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public boolean getBoolean(Object obj, long j) {
            boolean z = false;
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                if (UnsafeUtil.getByteBigEndian(obj, j) != 0) {
                    z = true;
                }
                return z;
            }
            if (UnsafeUtil.getByteLittleEndian(obj, j) != 0) {
                z = true;
            }
            return z;
        }

        public byte getByte(Object obj, long j) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getByteBigEndian(obj, j);
            }
            return UnsafeUtil.getByteLittleEndian(obj, j);
        }

        public double getDouble(Object obj, long j) {
            return Double.longBitsToDouble(getLong(obj, j));
        }

        public float getFloat(Object obj, long j) {
            return Float.intBitsToFloat(getInt(obj, j));
        }

        public void putBoolean(Object obj, long j, boolean z) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j, z ? (byte) 1 : 0);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j, z ? (byte) 1 : 0);
            }
        }

        public void putByte(Object obj, long j, byte b2) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j, b2);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j, b2);
            }
        }

        public void putDouble(Object obj, long j, double d2) {
            putLong(obj, j, Double.doubleToLongBits(d2));
        }

        public void putFloat(Object obj, long j, float f2) {
            putInt(obj, j, Float.floatToIntBits(f2));
        }
    }

    public static final class JvmMemoryAccessor extends MemoryAccessor {
        public JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public boolean getBoolean(Object obj, long j) {
            return this.unsafe.getBoolean(obj, j);
        }

        public byte getByte(Object obj, long j) {
            return this.unsafe.getByte(obj, j);
        }

        public double getDouble(Object obj, long j) {
            return this.unsafe.getDouble(obj, j);
        }

        public float getFloat(Object obj, long j) {
            return this.unsafe.getFloat(obj, j);
        }

        public void putBoolean(Object obj, long j, boolean z) {
            this.unsafe.putBoolean(obj, j, z);
        }

        public void putByte(Object obj, long j, byte b2) {
            this.unsafe.putByte(obj, j, b2);
        }

        public void putDouble(Object obj, long j, double d2) {
            this.unsafe.putDouble(obj, j, d2);
        }

        public void putFloat(Object obj, long j, float f2) {
            this.unsafe.putFloat(obj, j, f2);
        }
    }

    public static abstract class MemoryAccessor {
        public Unsafe unsafe;

        public MemoryAccessor(Unsafe unsafe2) {
            this.unsafe = unsafe2;
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.unsafe.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.unsafe.arrayIndexScale(cls);
        }

        public abstract boolean getBoolean(Object obj, long j);

        public abstract byte getByte(Object obj, long j);

        public abstract double getDouble(Object obj, long j);

        public abstract float getFloat(Object obj, long j);

        public final int getInt(Object obj, long j) {
            return this.unsafe.getInt(obj, j);
        }

        public final long getLong(Object obj, long j) {
            return this.unsafe.getLong(obj, j);
        }

        public final Object getObject(Object obj, long j) {
            return this.unsafe.getObject(obj, j);
        }

        public final long objectFieldOffset(Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public abstract void putBoolean(Object obj, long j, boolean z);

        public abstract void putByte(Object obj, long j, byte b2);

        public abstract void putDouble(Object obj, long j, double d2);

        public abstract void putFloat(Object obj, long j, float f2);

        public final void putInt(Object obj, long j, int i) {
            this.unsafe.putInt(obj, j, i);
        }

        public final void putLong(Object obj, long j, long j2) {
            this.unsafe.putLong(obj, j, j2);
        }

        public final void putObject(Object obj, long j, Object obj2) {
            this.unsafe.putObject(obj, j, obj2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0158 A[SYNTHETIC, Splitter:B:41:0x0158] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x02cf  */
    static {
        /*
            java.lang.Class<java.lang.Object[]> r1 = java.lang.Object[].class
            java.lang.Class<double[]> r2 = double[].class
            java.lang.Class<float[]> r3 = float[].class
            java.lang.Class<long[]> r4 = long[].class
            java.lang.Class<int[]> r5 = int[].class
            java.lang.Class<boolean[]> r6 = boolean[].class
            java.lang.Class<com.google.protobuf.UnsafeUtil> r7 = com.google.protobuf.UnsafeUtil.class
            java.lang.Class<java.lang.Object> r8 = java.lang.Object.class
            sun.misc.Unsafe r0 = getUnsafe()
            UNSAFE = r0
            java.lang.Class<?> r0 = com.google.protobuf.Android.MEMORY_CLASS
            MEMORY_CLASS = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = determineAndroidSupportByAddressSize(r0)
            IS_ANDROID_64 = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = determineAndroidSupportByAddressSize(r0)
            IS_ANDROID_32 = r0
            sun.misc.Unsafe r0 = UNSAFE
            r9 = 0
            if (r0 != 0) goto L_0x0030
            goto L_0x0055
        L_0x0030:
            boolean r0 = com.google.protobuf.Android.isOnAndroidDevice()
            if (r0 == 0) goto L_0x004e
            boolean r0 = IS_ANDROID_64
            if (r0 == 0) goto L_0x0042
            com.google.protobuf.UnsafeUtil$Android64MemoryAccessor r9 = new com.google.protobuf.UnsafeUtil$Android64MemoryAccessor
            sun.misc.Unsafe r0 = UNSAFE
            r9.<init>(r0)
            goto L_0x0055
        L_0x0042:
            boolean r0 = IS_ANDROID_32
            if (r0 == 0) goto L_0x0055
            com.google.protobuf.UnsafeUtil$Android32MemoryAccessor r9 = new com.google.protobuf.UnsafeUtil$Android32MemoryAccessor
            sun.misc.Unsafe r0 = UNSAFE
            r9.<init>(r0)
            goto L_0x0055
        L_0x004e:
            com.google.protobuf.UnsafeUtil$JvmMemoryAccessor r9 = new com.google.protobuf.UnsafeUtil$JvmMemoryAccessor
            sun.misc.Unsafe r0 = UNSAFE
            r9.<init>(r0)
        L_0x0055:
            MEMORY_ACCESSOR = r9
            java.lang.String r0 = "copyMemory"
            sun.misc.Unsafe r9 = UNSAFE
            java.lang.String r11 = "putLong"
            java.lang.String r12 = "putInt"
            java.lang.String r13 = "getInt"
            java.lang.String r14 = "putByte"
            java.lang.String r15 = "getByte"
            java.lang.String r10 = "platform method missing - proto runtime falling back to safer methods: "
            r16 = r1
            java.lang.String r1 = "objectFieldOffset"
            r17 = r2
            java.lang.String r2 = "getLong"
            r18 = r3
            r3 = 1
            r19 = 0
            if (r9 != 0) goto L_0x007d
            r20 = r4
        L_0x0078:
            r22 = r5
        L_0x007a:
            r0 = 0
            goto L_0x014d
        L_0x007d:
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x012a }
            r20 = r4
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0128 }
            java.lang.Class<java.lang.reflect.Field> r21 = java.lang.reflect.Field.class
            r4[r19] = r21     // Catch:{ all -> 0x0128 }
            r9.getMethod(r1, r4)     // Catch:{ all -> 0x0128 }
            r4 = 2
            java.lang.Class[] r3 = new java.lang.Class[r4]     // Catch:{ all -> 0x0128 }
            r3[r19] = r8     // Catch:{ all -> 0x0128 }
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ all -> 0x0128 }
            r21 = 1
            r3[r21] = r4     // Catch:{ all -> 0x0128 }
            r9.getMethod(r2, r3)     // Catch:{ all -> 0x0128 }
            java.lang.reflect.Field r3 = bufferAddressField()     // Catch:{ all -> 0x0128 }
            if (r3 != 0) goto L_0x00a1
            goto L_0x0078
        L_0x00a1:
            boolean r3 = com.google.protobuf.Android.isOnAndroidDevice()     // Catch:{ all -> 0x0128 }
            if (r3 == 0) goto L_0x00ac
            r22 = r5
        L_0x00a9:
            r0 = 1
            goto L_0x014d
        L_0x00ac:
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0128 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0128 }
            r4[r19] = r3     // Catch:{ all -> 0x0128 }
            r9.getMethod(r15, r4)     // Catch:{ all -> 0x0128 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0128 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0128 }
            r4[r19] = r3     // Catch:{ all -> 0x0128 }
            java.lang.Class r3 = java.lang.Byte.TYPE     // Catch:{ all -> 0x0128 }
            r22 = r5
            r5 = 1
            r4[r5] = r3     // Catch:{ all -> 0x0126 }
            r9.getMethod(r14, r4)     // Catch:{ all -> 0x0126 }
            java.lang.Class[] r3 = new java.lang.Class[r5]     // Catch:{ all -> 0x0126 }
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ all -> 0x0126 }
            r3[r19] = r4     // Catch:{ all -> 0x0126 }
            r9.getMethod(r13, r3)     // Catch:{ all -> 0x0126 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0126 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0126 }
            r4[r19] = r3     // Catch:{ all -> 0x0126 }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0126 }
            r5 = 1
            r4[r5] = r3     // Catch:{ all -> 0x0126 }
            r9.getMethod(r12, r4)     // Catch:{ all -> 0x0126 }
            java.lang.Class[] r3 = new java.lang.Class[r5]     // Catch:{ all -> 0x0126 }
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ all -> 0x0126 }
            r3[r19] = r4     // Catch:{ all -> 0x0126 }
            r9.getMethod(r2, r3)     // Catch:{ all -> 0x0126 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0126 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0126 }
            r4[r19] = r3     // Catch:{ all -> 0x0126 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0126 }
            r5 = 1
            r4[r5] = r3     // Catch:{ all -> 0x0126 }
            r9.getMethod(r11, r4)     // Catch:{ all -> 0x0126 }
            r3 = 3
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0126 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0126 }
            r4[r19] = r3     // Catch:{ all -> 0x0126 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0126 }
            r5 = 1
            r4[r5] = r3     // Catch:{ all -> 0x0126 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0126 }
            r5 = 2
            r4[r5] = r3     // Catch:{ all -> 0x0126 }
            r9.getMethod(r0, r4)     // Catch:{ all -> 0x0126 }
            r3 = 5
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ all -> 0x0126 }
            r3[r19] = r8     // Catch:{ all -> 0x0126 }
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ all -> 0x0126 }
            r5 = 1
            r3[r5] = r4     // Catch:{ all -> 0x0126 }
            r4 = 2
            r3[r4] = r8     // Catch:{ all -> 0x0126 }
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ all -> 0x0126 }
            r5 = 3
            r3[r5] = r4     // Catch:{ all -> 0x0126 }
            r4 = 4
            java.lang.Class r5 = java.lang.Long.TYPE     // Catch:{ all -> 0x0126 }
            r3[r4] = r5     // Catch:{ all -> 0x0126 }
            r9.getMethod(r0, r3)     // Catch:{ all -> 0x0126 }
            goto L_0x00a9
        L_0x0126:
            r0 = move-exception
            goto L_0x012f
        L_0x0128:
            r0 = move-exception
            goto L_0x012d
        L_0x012a:
            r0 = move-exception
            r20 = r4
        L_0x012d:
            r22 = r5
        L_0x012f:
            java.lang.String r3 = r7.getName()
            java.util.logging.Logger r3 = java.util.logging.Logger.getLogger(r3)
            java.util.logging.Level r4 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r10)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r3.log(r4, r0)
            goto L_0x007a
        L_0x014d:
            HAS_UNSAFE_BYTEBUFFER_OPERATIONS = r0
            sun.misc.Unsafe r0 = UNSAFE
            if (r0 != 0) goto L_0x0158
            r0 = 0
        L_0x0154:
            r21 = 1
            goto L_0x0288
        L_0x0158:
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x0268 }
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0268 }
            java.lang.Class<java.lang.reflect.Field> r5 = java.lang.reflect.Field.class
            r4[r19] = r5     // Catch:{ all -> 0x0268 }
            r0.getMethod(r1, r4)     // Catch:{ all -> 0x0268 }
            java.lang.String r1 = "arrayBaseOffset"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0268 }
            java.lang.Class<java.lang.Class> r5 = java.lang.Class.class
            r4[r19] = r5     // Catch:{ all -> 0x0268 }
            r0.getMethod(r1, r4)     // Catch:{ all -> 0x0268 }
            java.lang.String r1 = "arrayIndexScale"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0268 }
            java.lang.Class<java.lang.Class> r3 = java.lang.Class.class
            r4[r19] = r3     // Catch:{ all -> 0x0268 }
            r0.getMethod(r1, r4)     // Catch:{ all -> 0x0268 }
            r1 = 2
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ all -> 0x0268 }
            r3[r19] = r8     // Catch:{ all -> 0x0268 }
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r4 = 1
            r3[r4] = r1     // Catch:{ all -> 0x0268 }
            r0.getMethod(r13, r3)     // Catch:{ all -> 0x0268 }
            r1 = 3
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ all -> 0x0268 }
            r3[r19] = r8     // Catch:{ all -> 0x0268 }
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r3[r4] = r1     // Catch:{ all -> 0x0268 }
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0268 }
            r4 = 2
            r3[r4] = r1     // Catch:{ all -> 0x0268 }
            r0.getMethod(r12, r3)     // Catch:{ all -> 0x0268 }
            java.lang.Class[] r1 = new java.lang.Class[r4]     // Catch:{ all -> 0x0268 }
            r1[r19] = r8     // Catch:{ all -> 0x0268 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r4 = 1
            r1[r4] = r3     // Catch:{ all -> 0x0268 }
            r0.getMethod(r2, r1)     // Catch:{ all -> 0x0268 }
            r1 = 3
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ all -> 0x0268 }
            r2[r19] = r8     // Catch:{ all -> 0x0268 }
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r2[r4] = r1     // Catch:{ all -> 0x0268 }
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r3 = 2
            r2[r3] = r1     // Catch:{ all -> 0x0268 }
            r0.getMethod(r11, r2)     // Catch:{ all -> 0x0268 }
            java.lang.String r1 = "getObject"
            java.lang.Class[] r2 = new java.lang.Class[r3]     // Catch:{ all -> 0x0268 }
            r2[r19] = r8     // Catch:{ all -> 0x0268 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r4 = 1
            r2[r4] = r3     // Catch:{ all -> 0x0268 }
            r0.getMethod(r1, r2)     // Catch:{ all -> 0x0268 }
            java.lang.String r1 = "putObject"
            r2 = 3
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ all -> 0x0268 }
            r3[r19] = r8     // Catch:{ all -> 0x0268 }
            java.lang.Class r2 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r4 = 1
            r3[r4] = r2     // Catch:{ all -> 0x0268 }
            r2 = 2
            r3[r2] = r8     // Catch:{ all -> 0x0268 }
            r0.getMethod(r1, r3)     // Catch:{ all -> 0x0268 }
            boolean r1 = com.google.protobuf.Android.isOnAndroidDevice()     // Catch:{ all -> 0x0268 }
            if (r1 == 0) goto L_0x01e0
            r0 = 1
            goto L_0x0154
        L_0x01e0:
            java.lang.Class[] r1 = new java.lang.Class[r2]     // Catch:{ all -> 0x0268 }
            r1[r19] = r8     // Catch:{ all -> 0x0268 }
            java.lang.Class r2 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r3 = 1
            r1[r3] = r2     // Catch:{ all -> 0x0268 }
            r0.getMethod(r15, r1)     // Catch:{ all -> 0x0268 }
            r1 = 3
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ all -> 0x0268 }
            r2[r19] = r8     // Catch:{ all -> 0x0268 }
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r2[r3] = r1     // Catch:{ all -> 0x0268 }
            java.lang.Class r1 = java.lang.Byte.TYPE     // Catch:{ all -> 0x0268 }
            r3 = 2
            r2[r3] = r1     // Catch:{ all -> 0x0268 }
            r0.getMethod(r14, r2)     // Catch:{ all -> 0x0268 }
            java.lang.String r1 = "getBoolean"
            java.lang.Class[] r2 = new java.lang.Class[r3]     // Catch:{ all -> 0x0268 }
            r2[r19] = r8     // Catch:{ all -> 0x0268 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r4 = 1
            r2[r4] = r3     // Catch:{ all -> 0x0268 }
            r0.getMethod(r1, r2)     // Catch:{ all -> 0x0268 }
            java.lang.String r1 = "putBoolean"
            r2 = 3
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ all -> 0x0268 }
            r3[r19] = r8     // Catch:{ all -> 0x0268 }
            java.lang.Class r2 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r4 = 1
            r3[r4] = r2     // Catch:{ all -> 0x0268 }
            java.lang.Class r2 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0268 }
            r4 = 2
            r3[r4] = r2     // Catch:{ all -> 0x0268 }
            r0.getMethod(r1, r3)     // Catch:{ all -> 0x0268 }
            java.lang.String r1 = "getFloat"
            java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ all -> 0x0268 }
            r2[r19] = r8     // Catch:{ all -> 0x0268 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r4 = 1
            r2[r4] = r3     // Catch:{ all -> 0x0268 }
            r0.getMethod(r1, r2)     // Catch:{ all -> 0x0268 }
            java.lang.String r1 = "putFloat"
            r2 = 3
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ all -> 0x0268 }
            r3[r19] = r8     // Catch:{ all -> 0x0268 }
            java.lang.Class r2 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r4 = 1
            r3[r4] = r2     // Catch:{ all -> 0x0268 }
            java.lang.Class r2 = java.lang.Float.TYPE     // Catch:{ all -> 0x0268 }
            r4 = 2
            r3[r4] = r2     // Catch:{ all -> 0x0268 }
            r0.getMethod(r1, r3)     // Catch:{ all -> 0x0268 }
            java.lang.String r1 = "getDouble"
            java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ all -> 0x0268 }
            r2[r19] = r8     // Catch:{ all -> 0x0268 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r4 = 1
            r2[r4] = r3     // Catch:{ all -> 0x0268 }
            r0.getMethod(r1, r2)     // Catch:{ all -> 0x0268 }
            java.lang.String r1 = "putDouble"
            r2 = 3
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ all -> 0x0268 }
            r2[r19] = r8     // Catch:{ all -> 0x0268 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0268 }
            r21 = 1
            r2[r21] = r3     // Catch:{ all -> 0x0266 }
            java.lang.Class r3 = java.lang.Double.TYPE     // Catch:{ all -> 0x0266 }
            r4 = 2
            r2[r4] = r3     // Catch:{ all -> 0x0266 }
            r0.getMethod(r1, r2)     // Catch:{ all -> 0x0266 }
            r0 = 1
            goto L_0x0288
        L_0x0266:
            r0 = move-exception
            goto L_0x026b
        L_0x0268:
            r0 = move-exception
            r21 = 1
        L_0x026b:
            java.lang.String r1 = r7.getName()
            java.util.logging.Logger r1 = java.util.logging.Logger.getLogger(r1)
            java.util.logging.Level r2 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r10)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.log(r2, r0)
            r0 = 0
        L_0x0288:
            HAS_UNSAFE_ARRAY_OPERATIONS = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = arrayBaseOffset(r0)
            long r0 = (long) r0
            BYTE_ARRAY_BASE_OFFSET = r0
            arrayBaseOffset(r6)
            arrayIndexScale(r6)
            arrayBaseOffset(r22)
            arrayIndexScale(r22)
            arrayBaseOffset(r20)
            arrayIndexScale(r20)
            arrayBaseOffset(r18)
            arrayIndexScale(r18)
            arrayBaseOffset(r17)
            arrayIndexScale(r17)
            arrayBaseOffset(r16)
            arrayIndexScale(r16)
            java.lang.reflect.Field r0 = bufferAddressField()
            if (r0 == 0) goto L_0x02c5
            com.google.protobuf.UnsafeUtil$MemoryAccessor r1 = MEMORY_ACCESSOR
            if (r1 != 0) goto L_0x02c2
            goto L_0x02c5
        L_0x02c2:
            r1.objectFieldOffset(r0)
        L_0x02c5:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x02cf
            r3 = 1
            goto L_0x02d0
        L_0x02cf:
            r3 = 0
        L_0x02d0:
            IS_BIG_ENDIAN = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.UnsafeUtil.<clinit>():void");
    }

    public static <T> T allocateInstance(Class<T> cls) {
        try {
            return UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int arrayBaseOffset(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int arrayIndexScale(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayIndexScale(cls);
        }
        return -1;
    }

    public static Field bufferAddressField() {
        Field field;
        Field field2;
        Field field3 = null;
        if (Android.isOnAndroidDevice()) {
            try {
                field2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                field2 = null;
            }
            if (field2 != null) {
                return field2;
            }
        }
        try {
            field = Buffer.class.getDeclaredField(RudderTraits.ADDRESS_KEY);
        } catch (Throwable unused2) {
            field = null;
        }
        if (field != null && field.getType() == Long.TYPE) {
            field3 = field;
        }
        return field3;
    }

    public static boolean determineAndroidSupportByAddressSize(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!Android.isOnAndroidDevice()) {
            return false;
        }
        try {
            Class<?> cls3 = MEMORY_CLASS;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean getBoolean(Object obj, long j) {
        return MEMORY_ACCESSOR.getBoolean(obj, j);
    }

    public static byte getByte(byte[] bArr, long j) {
        return MEMORY_ACCESSOR.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + j);
    }

    public static byte getByteBigEndian(Object obj, long j) {
        return (byte) ((getInt(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & InvitationReply.EXPIRED);
    }

    public static byte getByteLittleEndian(Object obj, long j) {
        return (byte) ((getInt(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & InvitationReply.EXPIRED);
    }

    public static double getDouble(Object obj, long j) {
        return MEMORY_ACCESSOR.getDouble(obj, j);
    }

    public static float getFloat(Object obj, long j) {
        return MEMORY_ACCESSOR.getFloat(obj, j);
    }

    public static int getInt(Object obj, long j) {
        return MEMORY_ACCESSOR.getInt(obj, j);
    }

    public static long getLong(Object obj, long j) {
        return MEMORY_ACCESSOR.getLong(obj, j);
    }

    public static Object getObject(Object obj, long j) {
        return MEMORY_ACCESSOR.getObject(obj, j);
    }

    public static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                public Unsafe run() throws Exception {
                    Class<Unsafe> cls = Unsafe.class;
                    for (Field field : cls.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (cls.isInstance(obj)) {
                            return cls.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void putBoolean(Object obj, long j, boolean z) {
        MEMORY_ACCESSOR.putBoolean(obj, j, z);
    }

    public static void putByte(byte[] bArr, long j, byte b2) {
        MEMORY_ACCESSOR.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + j, b2);
    }

    public static void putByteBigEndian(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int i = getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
        memoryAccessor.putInt(obj, j2, ((255 & b2) << i2) | (i & (~(InvitationReply.EXPIRED << i2))));
    }

    public static void putByteLittleEndian(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
        memoryAccessor.putInt(obj, j2, ((255 & b2) << i) | (getInt(obj, j2) & (~(InvitationReply.EXPIRED << i))));
    }

    public static void putDouble(Object obj, long j, double d2) {
        MEMORY_ACCESSOR.putDouble(obj, j, d2);
    }

    public static void putFloat(Object obj, long j, float f2) {
        MEMORY_ACCESSOR.putFloat(obj, j, f2);
    }

    public static void putInt(Object obj, long j, int i) {
        MEMORY_ACCESSOR.putInt(obj, j, i);
    }

    public static void putLong(Object obj, long j, long j2) {
        MEMORY_ACCESSOR.putLong(obj, j, j2);
    }

    public static void putObject(Object obj, long j, Object obj2) {
        MEMORY_ACCESSOR.putObject(obj, j, obj2);
    }
}
