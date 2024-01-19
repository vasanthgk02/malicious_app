package com.google.android.gms.internal.measurement;

import com.rudderstack.android.sdk.core.RudderTraits;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sfs2x.client.entities.invitation.InvitationReply;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzmv {
    public static final long zza = ((long) zzz(byte[].class));
    public static final boolean zzb;
    public static final Unsafe zzc = zzg();
    public static final Class zzd = zzin.zza();
    public static final boolean zze = zzv(Long.TYPE);
    public static final zzmu zzf;
    public static final boolean zzg;
    public static final boolean zzh;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0146  */
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
            zzc = r7
            java.lang.Class r7 = com.google.android.gms.internal.measurement.zzin.zza()
            zzd = r7
            java.lang.Class r7 = java.lang.Long.TYPE
            boolean r7 = zzv(r7)
            zze = r7
            java.lang.Class r7 = java.lang.Integer.TYPE
            boolean r7 = zzv(r7)
            sun.misc.Unsafe r8 = zzc
            r9 = 0
            if (r8 != 0) goto L_0x002e
            goto L_0x003f
        L_0x002e:
            boolean r10 = zze
            if (r10 == 0) goto L_0x0038
            com.google.android.gms.internal.measurement.zzmt r9 = new com.google.android.gms.internal.measurement.zzmt
            r9.<init>(r8)
            goto L_0x003f
        L_0x0038:
            if (r7 == 0) goto L_0x003f
            com.google.android.gms.internal.measurement.zzms r9 = new com.google.android.gms.internal.measurement.zzms
            r9.<init>(r8)
        L_0x003f:
            zzf = r9
            java.lang.String r7 = "getLong"
            java.lang.String r8 = "objectFieldOffset"
            r10 = 2
            r11 = 1
            r12 = 0
            if (r9 != 0) goto L_0x004c
        L_0x004a:
            r9 = 0
            goto L_0x0074
        L_0x004c:
            sun.misc.Unsafe r9 = r9.zza
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x006f }
            java.lang.Class[] r13 = new java.lang.Class[r11]     // Catch:{ all -> 0x006f }
            java.lang.Class<java.lang.reflect.Field> r14 = java.lang.reflect.Field.class
            r13[r12] = r14     // Catch:{ all -> 0x006f }
            r9.getMethod(r8, r13)     // Catch:{ all -> 0x006f }
            java.lang.Class[] r13 = new java.lang.Class[r10]     // Catch:{ all -> 0x006f }
            r13[r12] = r6     // Catch:{ all -> 0x006f }
            java.lang.Class r14 = java.lang.Long.TYPE     // Catch:{ all -> 0x006f }
            r13[r11] = r14     // Catch:{ all -> 0x006f }
            r9.getMethod(r7, r13)     // Catch:{ all -> 0x006f }
            java.lang.reflect.Field r9 = zzB()     // Catch:{ all -> 0x006f }
            if (r9 != 0) goto L_0x006d
            goto L_0x004a
        L_0x006d:
            r9 = 1
            goto L_0x0074
        L_0x006f:
            r9 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.measurement.zzmv.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r9.toString()))
            goto L_0x004a
        L_0x0074:
            zzg = r9
            com.google.android.gms.internal.measurement.zzmu r9 = zzf
            if (r9 != 0) goto L_0x007d
        L_0x007a:
            r6 = 0
            goto L_0x0101
        L_0x007d:
            sun.misc.Unsafe r9 = r9.zza
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x00fb }
            java.lang.Class[] r13 = new java.lang.Class[r11]     // Catch:{ all -> 0x00fb }
            java.lang.Class<java.lang.reflect.Field> r14 = java.lang.reflect.Field.class
            r13[r12] = r14     // Catch:{ all -> 0x00fb }
            r9.getMethod(r8, r13)     // Catch:{ all -> 0x00fb }
            java.lang.Class[] r8 = new java.lang.Class[r11]     // Catch:{ all -> 0x00fb }
            java.lang.Class<java.lang.Class> r13 = java.lang.Class.class
            r8[r12] = r13     // Catch:{ all -> 0x00fb }
            java.lang.String r13 = "arrayBaseOffset"
            r9.getMethod(r13, r8)     // Catch:{ all -> 0x00fb }
            java.lang.Class[] r8 = new java.lang.Class[r11]     // Catch:{ all -> 0x00fb }
            java.lang.Class<java.lang.Class> r13 = java.lang.Class.class
            r8[r12] = r13     // Catch:{ all -> 0x00fb }
            java.lang.String r13 = "arrayIndexScale"
            r9.getMethod(r13, r8)     // Catch:{ all -> 0x00fb }
            java.lang.Class[] r8 = new java.lang.Class[r10]     // Catch:{ all -> 0x00fb }
            r8[r12] = r6     // Catch:{ all -> 0x00fb }
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x00fb }
            r8[r11] = r13     // Catch:{ all -> 0x00fb }
            java.lang.String r13 = "getInt"
            r9.getMethod(r13, r8)     // Catch:{ all -> 0x00fb }
            r8 = 3
            java.lang.Class[] r13 = new java.lang.Class[r8]     // Catch:{ all -> 0x00fb }
            r13[r12] = r6     // Catch:{ all -> 0x00fb }
            java.lang.Class r14 = java.lang.Long.TYPE     // Catch:{ all -> 0x00fb }
            r13[r11] = r14     // Catch:{ all -> 0x00fb }
            java.lang.Class r14 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00fb }
            r13[r10] = r14     // Catch:{ all -> 0x00fb }
            java.lang.String r14 = "putInt"
            r9.getMethod(r14, r13)     // Catch:{ all -> 0x00fb }
            java.lang.Class[] r13 = new java.lang.Class[r10]     // Catch:{ all -> 0x00fb }
            r13[r12] = r6     // Catch:{ all -> 0x00fb }
            java.lang.Class r14 = java.lang.Long.TYPE     // Catch:{ all -> 0x00fb }
            r13[r11] = r14     // Catch:{ all -> 0x00fb }
            r9.getMethod(r7, r13)     // Catch:{ all -> 0x00fb }
            java.lang.Class[] r7 = new java.lang.Class[r8]     // Catch:{ all -> 0x00fb }
            r7[r12] = r6     // Catch:{ all -> 0x00fb }
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x00fb }
            r7[r11] = r13     // Catch:{ all -> 0x00fb }
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x00fb }
            r7[r10] = r13     // Catch:{ all -> 0x00fb }
            java.lang.String r13 = "putLong"
            r9.getMethod(r13, r7)     // Catch:{ all -> 0x00fb }
            java.lang.Class[] r7 = new java.lang.Class[r10]     // Catch:{ all -> 0x00fb }
            r7[r12] = r6     // Catch:{ all -> 0x00fb }
            java.lang.Class r13 = java.lang.Long.TYPE     // Catch:{ all -> 0x00fb }
            r7[r11] = r13     // Catch:{ all -> 0x00fb }
            java.lang.String r13 = "getObject"
            r9.getMethod(r13, r7)     // Catch:{ all -> 0x00fb }
            java.lang.Class[] r7 = new java.lang.Class[r8]     // Catch:{ all -> 0x00fb }
            r7[r12] = r6     // Catch:{ all -> 0x00fb }
            java.lang.Class r8 = java.lang.Long.TYPE     // Catch:{ all -> 0x00fb }
            r7[r11] = r8     // Catch:{ all -> 0x00fb }
            r7[r10] = r6     // Catch:{ all -> 0x00fb }
            java.lang.String r6 = "putObject"
            r9.getMethod(r6, r7)     // Catch:{ all -> 0x00fb }
            r6 = 1
            goto L_0x0101
        L_0x00fb:
            r6 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.measurement.zzmv.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r6.toString()))
            goto L_0x007a
        L_0x0101:
            zzh = r6
            java.lang.Class<byte[]> r6 = byte[].class
            int r6 = zzz(r6)
            long r6 = (long) r6
            zza = r6
            zzz(r5)
            zzA(r5)
            zzz(r4)
            zzA(r4)
            zzz(r3)
            zzA(r3)
            zzz(r2)
            zzA(r2)
            zzz(r1)
            zzA(r1)
            zzz(r0)
            zzA(r0)
            java.lang.reflect.Field r0 = zzB()
            if (r0 == 0) goto L_0x013d
            com.google.android.gms.internal.measurement.zzmu r1 = zzf
            if (r1 == 0) goto L_0x013d
            r1.zzl(r0)
        L_0x013d:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x0146
            goto L_0x0147
        L_0x0146:
            r11 = 0
        L_0x0147:
            zzb = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzmv.<clinit>():void");
    }

    public static int zzA(Class cls) {
        if (zzh) {
            return zzf.zzi(cls);
        }
        return -1;
    }

    public static Field zzB() {
        int i = zzin.zza;
        Field zzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (zzC == null) {
            Field zzC2 = zzC(Buffer.class, RudderTraits.ADDRESS_KEY);
            if (zzC2 != null && zzC2.getType() == Long.TYPE) {
                return zzC2;
            }
            zzC = null;
        }
        return zzC;
    }

    public static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzD(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int zzj = zzf.zzj(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzf.zzn(obj, j2, ((b2 & 255) << i) | (zzj & (~(InvitationReply.EXPIRED << i))));
    }

    public static void zzE(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        int i2 = (b2 & 255) << i;
        zzf.zzn(obj, j2, i2 | (zzf.zzj(obj, j2) & (~(InvitationReply.EXPIRED << i))));
    }

    public static double zza(Object obj, long j) {
        return zzf.zza(obj, j);
    }

    public static float zzb(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    public static int zzc(Object obj, long j) {
        return zzf.zzj(obj, j);
    }

    public static long zzd(Object obj, long j) {
        return zzf.zzk(obj, j);
    }

    public static Object zze(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Object zzf(Object obj, long j) {
        return zzf.zzm(obj, j);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzmr());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzm(Object obj, long j, boolean z) {
        zzf.zzc(obj, j, z);
    }

    public static void zzn(byte[] bArr, long j, byte b2) {
        zzf.zzd(bArr, zza + j, b2);
    }

    public static void zzo(Object obj, long j, double d2) {
        zzf.zze(obj, j, d2);
    }

    public static void zzp(Object obj, long j, float f2) {
        zzf.zzf(obj, j, f2);
    }

    public static void zzq(Object obj, long j, int i) {
        zzf.zzn(obj, j, i);
    }

    public static void zzr(Object obj, long j, long j2) {
        zzf.zzo(obj, j, j2);
    }

    public static void zzs(Object obj, long j, Object obj2) {
        zzf.zzp(obj, j, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean zzt(Object obj, long j) {
        return ((byte) ((zzf.zzj(obj, -4 & j) >>> ((int) (((~j) & 3) << 3))) & InvitationReply.EXPIRED)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean zzu(Object obj, long j) {
        return ((byte) ((zzf.zzj(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & InvitationReply.EXPIRED)) != 0;
    }

    public static boolean zzv(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        int i = zzin.zza;
        try {
            Class cls3 = zzd;
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

    public static boolean zzw(Object obj, long j) {
        return zzf.zzg(obj, j);
    }

    public static boolean zzx() {
        return zzh;
    }

    public static boolean zzy() {
        return zzg;
    }

    public static int zzz(Class cls) {
        if (zzh) {
            return zzf.zzh(cls);
        }
        return -1;
    }
}
