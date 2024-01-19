package com.google.android.gms.internal.auth;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.rudderstack.android.sdk.core.RudderTraits;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sfs2x.client.entities.invitation.InvitationReply;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzgz {
    public static final boolean zza;
    public static final Unsafe zzb = zzg();
    public static final Class<?> zzc = zzdo.zza();
    public static final boolean zzd = zzs(Long.TYPE);
    public static final boolean zze;
    public static final zzgy zzf;
    public static final boolean zzg;
    public static final boolean zzh;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x014a  */
    static {
        /*
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            java.lang.Class<double[]> r1 = double[].class
            java.lang.Class<float[]> r2 = float[].class
            java.lang.Class<long[]> r3 = long[].class
            java.lang.Class<int[]> r4 = int[].class
            java.lang.Class<boolean[]> r5 = boolean[].class
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            sun.misc.Unsafe r7 = zzg()
            zzb = r7
            java.lang.Class r7 = com.google.android.gms.internal.auth.zzdo.zza()
            zzc = r7
            java.lang.Class r7 = java.lang.Long.TYPE
            boolean r7 = zzs(r7)
            zzd = r7
            java.lang.Class r7 = java.lang.Integer.TYPE
            boolean r7 = zzs(r7)
            zze = r7
            sun.misc.Unsafe r8 = zzb
            r9 = 0
            if (r8 != 0) goto L_0x0030
            goto L_0x0041
        L_0x0030:
            boolean r10 = zzd
            if (r10 == 0) goto L_0x003a
            com.google.android.gms.internal.auth.zzgx r9 = new com.google.android.gms.internal.auth.zzgx
            r9.<init>(r8)
            goto L_0x0041
        L_0x003a:
            if (r7 == 0) goto L_0x0041
            com.google.android.gms.internal.auth.zzgw r9 = new com.google.android.gms.internal.auth.zzgw
            r9.<init>(r8)
        L_0x0041:
            zzf = r9
            java.lang.String r7 = "getLong"
            java.lang.String r8 = "objectFieldOffset"
            r10 = 2
            r11 = 1
            r12 = 0
            if (r9 != 0) goto L_0x004e
        L_0x004c:
            r9 = 0
            goto L_0x0079
        L_0x004e:
            sun.misc.Unsafe r9 = r9.zza
            if (r9 != 0) goto L_0x0053
            goto L_0x004c
        L_0x0053:
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0074 }
            java.lang.Class[] r13 = new java.lang.Class[r11]     // Catch:{ all -> 0x0074 }
            java.lang.Class<java.lang.reflect.Field> r14 = java.lang.reflect.Field.class
            r13[r12] = r14     // Catch:{ all -> 0x0074 }
            r9.getMethod(r8, r13)     // Catch:{ all -> 0x0074 }
            java.lang.Class[] r13 = new java.lang.Class[r10]     // Catch:{ all -> 0x0074 }
            r13[r12] = r6     // Catch:{ all -> 0x0074 }
            java.lang.Class r14 = java.lang.Long.TYPE     // Catch:{ all -> 0x0074 }
            r13[r11] = r14     // Catch:{ all -> 0x0074 }
            r9.getMethod(r7, r13)     // Catch:{ all -> 0x0074 }
            java.lang.reflect.Field r9 = zzy()     // Catch:{ all -> 0x0074 }
            if (r9 != 0) goto L_0x0072
            goto L_0x004c
        L_0x0072:
            r9 = 1
            goto L_0x0079
        L_0x0074:
            r9 = move-exception
            zzh(r9)
            goto L_0x004c
        L_0x0079:
            zzg = r9
            com.google.android.gms.internal.auth.zzgy r9 = zzf
            if (r9 != 0) goto L_0x0082
        L_0x007f:
            r6 = 0
            goto L_0x0109
        L_0x0082:
            sun.misc.Unsafe r9 = r9.zza
            if (r9 != 0) goto L_0x0087
            goto L_0x007f
        L_0x0087:
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r13 = new java.lang.Class[r11]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.reflect.Field> r14 = java.lang.reflect.Field.class
            r13[r12] = r14     // Catch:{ all -> 0x0103 }
            r9.getMethod(r8, r13)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r8 = new java.lang.Class[r11]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Class> r13 = java.lang.Class.class
            r8[r12] = r13     // Catch:{ all -> 0x0103 }
            java.lang.String r13 = "arrayBaseOffset"
            r9.getMethod(r13, r8)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r8 = new java.lang.Class[r11]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.Class> r13 = java.lang.Class.class
            r8[r12] = r13     // Catch:{ all -> 0x0103 }
            java.lang.String r13 = "arrayIndexScale"
            r9.getMethod(r13, r8)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r8 = new java.lang.Class[r10]     // Catch:{ all -> 0x0103 }
            r8[r12] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r8[r11] = r13     // Catch:{ all -> 0x0103 }
            java.lang.String r13 = "getInt"
            r9.getMethod(r13, r8)     // Catch:{ all -> 0x0103 }
            r8 = 3
            java.lang.Class[] r13 = new java.lang.Class[r8]     // Catch:{ all -> 0x0103 }
            r13[r12] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class r14 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r13[r11] = r14     // Catch:{ all -> 0x0103 }
            java.lang.Class r14 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0103 }
            r13[r10] = r14     // Catch:{ all -> 0x0103 }
            java.lang.String r14 = "putInt"
            r9.getMethod(r14, r13)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r13 = new java.lang.Class[r10]     // Catch:{ all -> 0x0103 }
            r13[r12] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class r14 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r13[r11] = r14     // Catch:{ all -> 0x0103 }
            r9.getMethod(r7, r13)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r7 = new java.lang.Class[r8]     // Catch:{ all -> 0x0103 }
            r7[r12] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r7[r11] = r13     // Catch:{ all -> 0x0103 }
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r7[r10] = r13     // Catch:{ all -> 0x0103 }
            java.lang.String r13 = "putLong"
            r9.getMethod(r13, r7)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r7 = new java.lang.Class[r10]     // Catch:{ all -> 0x0103 }
            r7[r12] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r7[r11] = r13     // Catch:{ all -> 0x0103 }
            java.lang.String r13 = "getObject"
            r9.getMethod(r13, r7)     // Catch:{ all -> 0x0103 }
            java.lang.Class[] r7 = new java.lang.Class[r8]     // Catch:{ all -> 0x0103 }
            r7[r12] = r6     // Catch:{ all -> 0x0103 }
            java.lang.Class r8 = java.lang.Long.TYPE     // Catch:{ all -> 0x0103 }
            r7[r11] = r8     // Catch:{ all -> 0x0103 }
            r7[r10] = r6     // Catch:{ all -> 0x0103 }
            java.lang.String r6 = "putObject"
            r9.getMethod(r6, r7)     // Catch:{ all -> 0x0103 }
            r6 = 1
            goto L_0x0109
        L_0x0103:
            r6 = move-exception
            zzh(r6)
            goto L_0x007f
        L_0x0109:
            zzh = r6
            java.lang.Class<byte[]> r6 = byte[].class
            zzw(r6)
            zzw(r5)
            zzx(r5)
            zzw(r4)
            zzx(r4)
            zzw(r3)
            zzx(r3)
            zzw(r2)
            zzx(r2)
            zzw(r1)
            zzx(r1)
            zzw(r0)
            zzx(r0)
            java.lang.reflect.Field r0 = zzy()
            if (r0 == 0) goto L_0x0141
            com.google.android.gms.internal.auth.zzgy r1 = zzf
            if (r1 == 0) goto L_0x0141
            r1.zzk(r0)
        L_0x0141:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x014a
            goto L_0x014b
        L_0x014a:
            r11 = 0
        L_0x014b:
            zza = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzgz.<clinit>():void");
    }

    public static double zza(Object obj, long j) {
        return zzf.zza(obj, j);
    }

    public static float zzb(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    public static int zzc(Object obj, long j) {
        return zzf.zzi(obj, j);
    }

    public static long zzd(Object obj, long j) {
        return zzf.zzj(obj, j);
    }

    public static <T> T zze(Class<T> cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Object zzf(Object obj, long j) {
        return zzf.zzl(obj, j);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzgv());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ void zzh(Throwable th) {
        Logger logger = Logger.getLogger(zzgz.class.getName());
        Level level = Level.WARNING;
        String valueOf = String.valueOf(th);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", GeneratedOutlineSupport.outline62(new StringBuilder(valueOf.length() + 71), "platform method missing - proto runtime falling back to safer methods: ", valueOf));
    }

    public static /* synthetic */ void zzi(Object obj, long j, boolean z) {
        long j2 = -4 & j;
        int zzi = zzf.zzi(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzf.zzm(obj, j2, ((z ? 1 : 0) << i) | (zzi & (~(InvitationReply.EXPIRED << i))));
    }

    public static /* synthetic */ void zzj(Object obj, long j, boolean z) {
        long j2 = -4 & j;
        int zzi = zzf.zzi(obj, j2);
        int i = (((int) j) & 3) << 3;
        zzf.zzm(obj, j2, ((z ? 1 : 0) << i) | (zzi & (~(InvitationReply.EXPIRED << i))));
    }

    public static void zzk(Object obj, long j, boolean z) {
        zzf.zzc(obj, j, z);
    }

    public static void zzl(Object obj, long j, double d2) {
        zzf.zzd(obj, j, d2);
    }

    public static void zzm(Object obj, long j, float f2) {
        zzf.zze(obj, j, f2);
    }

    public static void zzn(Object obj, long j, int i) {
        zzf.zzm(obj, j, i);
    }

    public static void zzo(Object obj, long j, long j2) {
        zzf.zzn(obj, j, j2);
    }

    public static void zzp(Object obj, long j, Object obj2) {
        zzf.zzo(obj, j, obj2);
    }

    public static /* synthetic */ boolean zzq(Object obj, long j) {
        return ((byte) ((zzf.zzi(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & InvitationReply.EXPIRED)) != 0;
    }

    public static /* synthetic */ boolean zzr(Object obj, long j) {
        return ((byte) ((zzf.zzi(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & InvitationReply.EXPIRED)) != 0;
    }

    public static boolean zzs(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        int i = zzdo.zza;
        try {
            Class<?> cls3 = zzc;
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

    public static boolean zzt(Object obj, long j) {
        return zzf.zzf(obj, j);
    }

    public static boolean zzu() {
        return zzh;
    }

    public static boolean zzv() {
        return zzg;
    }

    public static int zzw(Class<?> cls) {
        if (zzh) {
            return zzf.zzg(cls);
        }
        return -1;
    }

    public static int zzx(Class<?> cls) {
        if (zzh) {
            return zzf.zzh(cls);
        }
        return -1;
    }

    public static Field zzy() {
        int i = zzdo.zza;
        Field zzz = zzz(Buffer.class, "effectiveDirectAddress");
        if (zzz == null) {
            Field zzz2 = zzz(Buffer.class, RudderTraits.ADDRESS_KEY);
            if (zzz2 != null && zzz2.getType() == Long.TYPE) {
                return zzz2;
            }
            zzz = null;
        }
        return zzz;
    }

    public static Field zzz(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
