package java8.util.concurrent;

import java.security.AccessControlContext;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import sun.misc.Unsafe;

public final class TLR {
    public static final long CCL;
    public static final long INHERITABLETHREADLOCALS;
    public static final long INHERITEDACCESSCONTROLCONTEXT;
    public static final boolean IS_ANDROID;
    public static final boolean IS_PRE8_IBM;
    public static final long THREADLOCALS;
    public static final Unsafe U = UnsafeAcc.unsafe;
    public static final ThreadLocal<SeedsHolder> localSeeds = new ThreadLocal<SeedsHolder>() {
        public Object initialValue() {
            return new SeedsHolder();
        }
    };
    public static final AtomicInteger probeGenerator = new AtomicInteger();
    public static final AtomicLong seeder = new AtomicLong(mix64(System.currentTimeMillis()) ^ mix64(System.nanoTime()));

    public static final class SeedsHolder {
        public int threadProbe;
        public int threadSecondarySeed;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[Catch:{ Exception -> 0x00eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a A[Catch:{ Exception -> 0x00eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[Catch:{ Exception -> 0x00eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d A[Catch:{ Exception -> 0x00eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    static {
        /*
            sun.misc.Unsafe r0 = java8.util.concurrent.UnsafeAcc.unsafe
            U = r0
            java.lang.String r0 = "com.ibm.misc.JarVersion"
            boolean r0 = isClassPresent(r0)     // Catch:{ Exception -> 0x00eb }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = "java.class.version"
            java.lang.String r3 = "45"
            java.lang.String r0 = java.lang.System.getProperty(r0, r3)     // Catch:{ Exception -> 0x00eb }
            if (r0 == 0) goto L_0x002d
            int r3 = r0.length()     // Catch:{ Exception -> 0x00eb }
            r4 = 2
            if (r3 < r4) goto L_0x002d
            java.lang.String r0 = r0.substring(r1, r4)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r3 = "52"
            int r0 = r3.compareTo(r0)     // Catch:{ Exception -> 0x00eb }
            if (r0 <= 0) goto L_0x002d
            r0 = 1
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            IS_PRE8_IBM = r0     // Catch:{ Exception -> 0x00eb }
            java.lang.String r0 = "android.util.DisplayMetrics"
            boolean r0 = isClassPresent(r0)     // Catch:{ Exception -> 0x00eb }
            if (r0 == 0) goto L_0x003a
            r0 = 1
            goto L_0x0040
        L_0x003a:
            java.lang.String r0 = "org.robovm.rt.bro.Bro"
            boolean r0 = isClassPresent(r0)     // Catch:{ Exception -> 0x00eb }
        L_0x0040:
            IS_ANDROID = r0     // Catch:{ Exception -> 0x00eb }
            if (r0 != 0) goto L_0x008d
            sun.misc.Unsafe r0 = U     // Catch:{ Exception -> 0x00eb }
            java.lang.Class<java.lang.Thread> r3 = java.lang.Thread.class
            java.lang.String r4 = "threadLocals"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ Exception -> 0x00eb }
            long r3 = r0.objectFieldOffset(r3)     // Catch:{ Exception -> 0x00eb }
            THREADLOCALS = r3     // Catch:{ Exception -> 0x00eb }
            sun.misc.Unsafe r0 = U     // Catch:{ Exception -> 0x00eb }
            java.lang.Class<java.lang.Thread> r3 = java.lang.Thread.class
            java.lang.String r4 = "inheritableThreadLocals"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ Exception -> 0x00eb }
            long r3 = r0.objectFieldOffset(r3)     // Catch:{ Exception -> 0x00eb }
            INHERITABLETHREADLOCALS = r3     // Catch:{ Exception -> 0x00eb }
            boolean r0 = IS_PRE8_IBM     // Catch:{ Exception -> 0x00eb }
            if (r0 == 0) goto L_0x006c
            java.lang.String r0 = "accessControlContext"
            goto L_0x006e
        L_0x006c:
            java.lang.String r0 = "inheritedAccessControlContext"
        L_0x006e:
            sun.misc.Unsafe r3 = U     // Catch:{ Exception -> 0x00eb }
            java.lang.Class<java.lang.Thread> r4 = java.lang.Thread.class
            java.lang.reflect.Field r0 = r4.getDeclaredField(r0)     // Catch:{ Exception -> 0x00eb }
            long r3 = r3.objectFieldOffset(r0)     // Catch:{ Exception -> 0x00eb }
            INHERITEDACCESSCONTROLCONTEXT = r3     // Catch:{ Exception -> 0x00eb }
            sun.misc.Unsafe r0 = U     // Catch:{ Exception -> 0x00eb }
            java.lang.Class<java.lang.Thread> r3 = java.lang.Thread.class
            java.lang.String r4 = "contextClassLoader"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ Exception -> 0x00eb }
            long r3 = r0.objectFieldOffset(r3)     // Catch:{ Exception -> 0x00eb }
            CCL = r3     // Catch:{ Exception -> 0x00eb }
            goto L_0x0097
        L_0x008d:
            r3 = 0
            THREADLOCALS = r3     // Catch:{ Exception -> 0x00eb }
            INHERITABLETHREADLOCALS = r3     // Catch:{ Exception -> 0x00eb }
            INHERITEDACCESSCONTROLCONTEXT = r3     // Catch:{ Exception -> 0x00eb }
            CCL = r3     // Catch:{ Exception -> 0x00eb }
        L_0x0097:
            java8.util.concurrent.TLR$1 r0 = new java8.util.concurrent.TLR$1
            r0.<init>()
            localSeeds = r0
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            r0.<init>()
            probeGenerator = r0
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = mix64(r3)
            long r5 = java.lang.System.nanoTime()
            long r5 = mix64(r5)
            long r3 = r3 ^ r5
            r0.<init>(r3)
            seeder = r0
            java8.util.concurrent.TLR$2 r0 = new java8.util.concurrent.TLR$2
            r0.<init>()
            java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00ea
            r0 = 8
            byte[] r3 = java.security.SecureRandom.getSeed(r0)
            byte r1 = r3[r1]
            long r4 = (long) r1
            r6 = 255(0xff, double:1.26E-321)
            long r4 = r4 & r6
        L_0x00da:
            if (r2 >= r0) goto L_0x00e5
            long r4 = r4 << r0
            byte r1 = r3[r2]
            long r8 = (long) r1
            long r8 = r8 & r6
            long r4 = r4 | r8
            int r2 = r2 + 1
            goto L_0x00da
        L_0x00e5:
            java.util.concurrent.atomic.AtomicLong r0 = seeder
            r0.set(r4)
        L_0x00ea:
            return
        L_0x00eb:
            r0 = move-exception
            java.lang.ExceptionInInitializerError r1 = new java.lang.ExceptionInInitializerError
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.concurrent.TLR.<clinit>():void");
    }

    public static final void eraseThreadLocals(Thread thread) {
        if (!IS_ANDROID) {
            U.putObject(thread, THREADLOCALS, null);
            U.putObject(thread, INHERITABLETHREADLOCALS, null);
        }
    }

    public static final int getProbe() {
        return localSeeds.get().threadProbe;
    }

    public static boolean isClassPresent(String str) {
        Class<?> cls;
        try {
            cls = Class.forName(str, false, TLR.class.getClassLoader());
        } catch (Throwable unused) {
            cls = null;
        }
        return cls != null;
    }

    public static long mix64(long j) {
        long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
        long j3 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
        return j3 ^ (j3 >>> 33);
    }

    public static final int nextSecondarySeed() {
        int i;
        int i2 = localSeeds.get().threadSecondarySeed;
        if (i2 != 0) {
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >>> 17);
            i = i4 ^ (i4 << 5);
        } else {
            long andAdd = seeder.getAndAdd(-4942790177534073029L);
            long j = (andAdd ^ (andAdd >>> 33)) * -49064778989728563L;
            i = (int) (((j ^ (j >>> 33)) * -4265267296055464877L) >>> 32);
            if (i == 0) {
                i = 1;
            }
        }
        localSeeds.get().threadSecondarySeed = i;
        return i;
    }

    public static final void setContextClassLoader(Thread thread, ClassLoader classLoader) {
        if (!IS_ANDROID) {
            U.putObject(thread, CCL, classLoader);
        }
    }

    public static final void setInheritedAccessControlContext(Thread thread, AccessControlContext accessControlContext) {
        if (!IS_ANDROID) {
            U.putOrderedObject(thread, INHERITEDACCESSCONTROLCONTEXT, accessControlContext);
        }
    }
}
