package com.google.android.gms.internal.auth;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sfs2x.client.entities.invitation.InvitationReply;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzft<T> implements zzgb<T> {
    public static final int[] zza = new int[0];
    public static final Unsafe zzb = zzgz.zzg();
    public final int[] zzc;
    public final Object[] zzd;
    public final int zze;
    public final int zzf;
    public final zzfq zzg;
    public final boolean zzh;
    public final int[] zzi;
    public final int zzj;
    public final int zzk;
    public final zzfe zzl;
    public final zzgp<?, ?> zzm;
    public final zzeh<?> zzn;
    public final zzfv zzo;
    public final zzfl zzp;

    /* JADX WARNING: type inference failed for: r1v2, types: [int] */
    /* JADX WARNING: type inference failed for: r1v6, types: [int] */
    /* JADX WARNING: type inference failed for: r1v9, types: [com.google.android.gms.internal.auth.zzfe] */
    /* JADX WARNING: type inference failed for: r1v10, types: [com.google.android.gms.internal.auth.zzgp<?, ?>] */
    /* JADX WARNING: type inference failed for: r1v11, types: [com.google.android.gms.internal.auth.zzeh<?>] */
    /* JADX WARNING: type inference failed for: r1v12, types: [com.google.android.gms.internal.auth.zzfq] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzft(int[] r3, int[] r4, java.lang.Object[] r5, int r6, int r7, com.google.android.gms.internal.auth.zzfq r8, boolean r9, boolean r10, int[] r11, int r12, int r13, com.google.android.gms.internal.auth.zzfv r14, com.google.android.gms.internal.auth.zzfe r15, com.google.android.gms.internal.auth.zzgp<?, ?> r16, com.google.android.gms.internal.auth.zzeh<?> r17, com.google.android.gms.internal.auth.zzfl r18) {
        /*
            r2 = this;
            r0 = r2
            r2.<init>()
            r1 = r3
            r0.zzc = r1
            r1 = r4
            r0.zzd = r1
            r1 = r5
            r0.zze = r1
            r1 = r6
            r0.zzf = r1
            r1 = r8
            r0.zzh = r1
            r1 = r10
            r0.zzi = r1
            r1 = r11
            r0.zzj = r1
            r1 = r12
            r0.zzk = r1
            r1 = r13
            r0.zzo = r1
            r1 = r14
            r0.zzl = r1
            r1 = r15
            r0.zzm = r1
            r1 = r16
            r0.zzn = r1
            r1 = r7
            r0.zzg = r1
            r1 = r17
            r0.zzp = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzft.<init>(int[], java.lang.Object[], int, int, com.google.android.gms.internal.auth.zzfq, boolean, boolean, int[], int, int, com.google.android.gms.internal.auth.zzfv, com.google.android.gms.internal.auth.zzfe, com.google.android.gms.internal.auth.zzgp, com.google.android.gms.internal.auth.zzeh, com.google.android.gms.internal.auth.zzfl, byte[]):void");
    }

    public static Field zzA(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline6(String.valueOf(str).length(), 40, name.length(), String.valueOf(arrays).length()));
            GeneratedOutlineSupport.outline103(sb, "Field ", str, " for ", name);
            throw new RuntimeException(GeneratedOutlineSupport.outline62(sb, " not found. Known fields are ", arrays));
        }
    }

    private final void zzB(T t, T t2, int i) {
        long zzv = (long) (zzv(i) & 1048575);
        if (zzG(t2, i)) {
            Object zzf2 = zzgz.zzf(t, zzv);
            Object zzf3 = zzgz.zzf(t2, zzv);
            if (zzf2 == null || zzf3 == null) {
                if (zzf3 != null) {
                    zzgz.zzp(t, zzv, zzf3);
                    zzD(t, i);
                }
                return;
            }
            zzgz.zzp(t, zzv, zzev.zzg(zzf2, zzf3));
            zzD(t, i);
        }
    }

    private final void zzC(T t, T t2, int i) {
        int zzv = zzv(i);
        int i2 = this.zzc[i];
        long j = (long) (zzv & 1048575);
        if (zzJ(t2, i2, i)) {
            Object zzf2 = zzJ(t, i2, i) ? zzgz.zzf(t, j) : null;
            Object zzf3 = zzgz.zzf(t2, j);
            if (zzf2 == null || zzf3 == null) {
                if (zzf3 != null) {
                    zzgz.zzp(t, j, zzf3);
                    zzE(t, i2, i);
                }
                return;
            }
            zzgz.zzp(t, j, zzev.zzg(zzf2, zzf3));
            zzE(t, i2, i);
        }
    }

    private final void zzD(T t, int i) {
        int zzs = zzs(i);
        long j = (long) (1048575 & zzs);
        if (j != 1048575) {
            zzgz.zzn(t, j, (1 << (zzs >>> 20)) | zzgz.zzc(t, j));
        }
    }

    private final void zzE(T t, int i, int i2) {
        zzgz.zzn(t, (long) (zzs(i2) & 1048575), i);
    }

    private final boolean zzF(T t, T t2, int i) {
        return zzG(t, i) == zzG(t2, i);
    }

    private final boolean zzG(T t, int i) {
        int zzs = zzs(i);
        long j = (long) (zzs & 1048575);
        if (j != 1048575) {
            return (zzgz.zzc(t, j) & (1 << (zzs >>> 20))) != 0;
        }
        int zzv = zzv(i);
        long j2 = (long) (zzv & 1048575);
        switch (zzu(zzv)) {
            case 0:
                return zzgz.zza(t, j2) != 0.0d;
            case 1:
                return zzgz.zzb(t, j2) != 0.0f;
            case 2:
                return zzgz.zzd(t, j2) != 0;
            case 3:
                return zzgz.zzd(t, j2) != 0;
            case 4:
                return zzgz.zzc(t, j2) != 0;
            case 5:
                return zzgz.zzd(t, j2) != 0;
            case 6:
                return zzgz.zzc(t, j2) != 0;
            case 7:
                return zzgz.zzt(t, j2);
            case 8:
                Object zzf2 = zzgz.zzf(t, j2);
                if (zzf2 instanceof String) {
                    return !((String) zzf2).isEmpty();
                }
                if (zzf2 instanceof zzeb) {
                    return !zzeb.zzb.equals(zzf2);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzgz.zzf(t, j2) != null;
            case 10:
                return !zzeb.zzb.equals(zzgz.zzf(t, j2));
            case 11:
                return zzgz.zzc(t, j2) != 0;
            case 12:
                return zzgz.zzc(t, j2) != 0;
            case 13:
                return zzgz.zzc(t, j2) != 0;
            case 14:
                return zzgz.zzd(t, j2) != 0;
            case 15:
                return zzgz.zzc(t, j2) != 0;
            case 16:
                return zzgz.zzd(t, j2) != 0;
            case 17:
                return zzgz.zzf(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzH(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzG(t, i);
        }
        return (i3 & i4) != 0;
    }

    public static boolean zzI(Object obj, int i, zzgb zzgb) {
        return zzgb.zzi(zzgz.zzf(obj, (long) (i & 1048575)));
    }

    private final boolean zzJ(T t, int i, int i2) {
        return zzgz.zzc(t, (long) (zzs(i2) & 1048575)) == i;
    }

    public static zzgq zzc(Object obj) {
        zzeq zzeq = (zzeq) obj;
        zzgq zzgq = zzeq.zzc;
        if (zzgq != zzgq.zza()) {
            return zzgq;
        }
        zzgq zzc2 = zzgq.zzc();
        zzeq.zzc = zzc2;
        return zzc2;
    }

    public static <T> zzft<T> zzj(Class<T> cls, zzfn zzfn, zzfv zzfv, zzfe zzfe, zzgp<?, ?> zzgp, zzeh<?> zzeh, zzfl zzfl) {
        if (zzfn instanceof zzga) {
            return zzk((zzga) zzfn, zzfv, zzfe, zzgp, zzeh, zzfl);
        }
        zzgm zzgm = (zzgm) zzfn;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x032b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> com.google.android.gms.internal.auth.zzft<T> zzk(com.google.android.gms.internal.auth.zzga r33, com.google.android.gms.internal.auth.zzfv r34, com.google.android.gms.internal.auth.zzfe r35, com.google.android.gms.internal.auth.zzgp<?, ?> r36, com.google.android.gms.internal.auth.zzeh<?> r37, com.google.android.gms.internal.auth.zzfl r38) {
        /*
            int r0 = r33.zzc()
            r1 = 0
            r3 = 2
            if (r0 != r3) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = 0
        L_0x000b:
            java.lang.String r0 = r33.zzd()
            int r3 = r0.length()
            char r4 = r0.charAt(r1)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0056
            int[] r6 = zza
            r13 = r6
            r6 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            goto L_0x0165
        L_0x0056:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0062:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0072
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0062
        L_0x0072:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0075:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0094
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0081:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0091
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0081
        L_0x0091:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0094:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b3
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b0
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a0
        L_0x00b0:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b3:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ee
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00de
        L_0x00ee:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f1:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010d
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fd
        L_0x010d:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0110:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011c
        L_0x012d:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0131:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x014f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013d
        L_0x014f:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0154:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r32 = r12
            r12 = r9
            r9 = r32
        L_0x0165:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r33.zze()
            com.google.android.gms.internal.auth.zzfq r18 = r33.zza()
            java.lang.Class r1 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0183:
            if (r4 >= r3) goto L_0x03ca
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ab
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r2 = r24
            r24 = 13
        L_0x0193:
            int r26 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01a5
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r24
            r4 = r4 | r2
            int r24 = r24 + 13
            r2 = r26
            goto L_0x0193
        L_0x01a5:
            int r2 = r2 << r24
            r4 = r4 | r2
            r2 = r26
            goto L_0x01ad
        L_0x01ab:
            r2 = r24
        L_0x01ad:
            int r24 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01da
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bb:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r3) goto L_0x01d4
            r3 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r2 = r2 | r3
            int r24 = r24 + 13
            r5 = r27
            r3 = r28
            goto L_0x01bb
        L_0x01d4:
            int r3 = r5 << r24
            r2 = r2 | r3
            r3 = r27
            goto L_0x01de
        L_0x01da:
            r28 = r3
            r3 = r24
        L_0x01de:
            r5 = r2 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r2 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ec
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ec:
            r14 = 51
            if (r5 < r14) goto L_0x0295
            int r14 = r3 + 1
            char r3 = r0.charAt(r3)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r14) goto L_0x0222
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0203:
            int r30 = r14 + 1
            char r14 = r0.charAt(r14)
            r31 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021c
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r3 = r3 | r12
            int r27 = r27 + 13
            r14 = r30
            r12 = r31
            goto L_0x0203
        L_0x021c:
            int r12 = r14 << r27
            r3 = r3 | r12
            r14 = r30
            goto L_0x0226
        L_0x0222:
            r31 = r12
            r14 = r27
        L_0x0226:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0247
            r14 = 17
            if (r12 != r14) goto L_0x0233
            goto L_0x0247
        L_0x0233:
            r14 = 12
            if (r12 != r14) goto L_0x0256
            if (r10 != 0) goto L_0x0256
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0254
        L_0x0247:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0254:
            r16 = r14
        L_0x0256:
            int r3 = r3 + r3
            r12 = r17[r3]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0260
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0268
        L_0x0260:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzA(r1, r12)
            r17[r3] = r12
        L_0x0268:
            r30 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r8 = (int) r7
            int r3 = r3 + 1
            r7 = r17[r3]
            boolean r12 = r7 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027b
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0283
        L_0x027b:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzA(r1, r7)
            r17[r3] = r7
        L_0x0283:
            r3 = r8
            long r7 = r15.objectFieldOffset(r7)
            int r8 = (int) r7
            r26 = r1
            r1 = r8
            r29 = r11
            r25 = 1
            r11 = r0
            r8 = r3
            r3 = 0
            goto L_0x0391
        L_0x0295:
            r30 = r7
            r14 = r8
            r31 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzA(r1, r8)
            r12 = 9
            if (r5 == r12) goto L_0x030d
            r12 = 17
            if (r5 != r12) goto L_0x02ad
            goto L_0x030d
        L_0x02ad:
            r12 = 27
            if (r5 == r12) goto L_0x02fd
            r12 = 49
            if (r5 != r12) goto L_0x02b6
            goto L_0x02fd
        L_0x02b6:
            r12 = 12
            if (r5 == r12) goto L_0x02ed
            r12 = 30
            if (r5 == r12) goto L_0x02ed
            r12 = 44
            if (r5 != r12) goto L_0x02c3
            goto L_0x02ed
        L_0x02c3:
            r12 = 50
            if (r5 != r12) goto L_0x02e3
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r2 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02e6
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02e3:
            r25 = 1
            goto L_0x031a
        L_0x02e6:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x031b
        L_0x02ed:
            if (r10 != 0) goto L_0x02e3
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030a
        L_0x02fd:
            r25 = 1
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030a:
            r12 = r27
            goto L_0x031b
        L_0x030d:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x031a:
            r12 = r7
        L_0x031b:
            long r7 = r15.objectFieldOffset(r8)
            int r8 = (int) r7
            r7 = r2 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r7 != r11) goto L_0x0378
            r7 = 17
            if (r5 > r7) goto L_0x0378
            int r7 = r3 + 1
            char r3 = r0.charAt(r3)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r11) goto L_0x0354
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x033e:
            int r27 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r11) goto L_0x0350
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r26
            r3 = r3 | r7
            int r26 = r26 + 13
            r7 = r27
            goto L_0x033e
        L_0x0350:
            int r7 = r7 << r26
            r3 = r3 | r7
            goto L_0x0356
        L_0x0354:
            r27 = r7
        L_0x0356:
            int r7 = r6 + r6
            int r26 = r3 / 32
            int r26 = r26 + r7
            r7 = r17[r26]
            boolean r11 = r7 instanceof java.lang.reflect.Field
            if (r11 == 0) goto L_0x0365
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x036d
        L_0x0365:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzA(r1, r7)
            r17[r26] = r7
        L_0x036d:
            r11 = r0
            r26 = r1
            long r0 = r15.objectFieldOffset(r7)
            int r1 = (int) r0
            int r3 = r3 % 32
            goto L_0x0381
        L_0x0378:
            r11 = r0
            r26 = r1
            r27 = r3
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r3 = 0
        L_0x0381:
            r0 = 18
            if (r5 < r0) goto L_0x038f
            r0 = 49
            if (r5 > r0) goto L_0x038f
            int r0 = r23 + 1
            r13[r23] = r8
            r23 = r0
        L_0x038f:
            r16 = r12
        L_0x0391:
            int r0 = r9 + 1
            r30[r9] = r4
            int r4 = r0 + 1
            r7 = r2 & 512(0x200, float:7.17E-43)
            if (r7 == 0) goto L_0x039e
            r7 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x039f
        L_0x039e:
            r7 = 0
        L_0x039f:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03a6
            r2 = 268435456(0x10000000, float:2.524355E-29)
            goto L_0x03a7
        L_0x03a6:
            r2 = 0
        L_0x03a7:
            r2 = r2 | r7
            int r5 = r5 << 20
            r2 = r2 | r5
            r2 = r2 | r8
            r30[r0] = r2
            int r9 = r4 + 1
            int r0 = r3 << 20
            r0 = r0 | r1
            r30[r4] = r0
            r0 = r11
            r8 = r14
            r14 = r24
            r1 = r26
            r4 = r27
            r3 = r28
            r11 = r29
            r7 = r30
            r12 = r31
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0183
        L_0x03ca:
            r30 = r7
            r29 = r11
            r31 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.auth.zzft r0 = new com.google.android.gms.internal.auth.zzft
            r4 = r0
            com.google.android.gms.internal.auth.zzfq r9 = r33.zza()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r30
            r6 = r1
            r7 = r14
            r8 = r31
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r34
            r16 = r35
            r17 = r36
            r18 = r37
            r19 = r38
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzft.zzk(com.google.android.gms.internal.auth.zzga, com.google.android.gms.internal.auth.zzfv, com.google.android.gms.internal.auth.zzfe, com.google.android.gms.internal.auth.zzgp, com.google.android.gms.internal.auth.zzeh, com.google.android.gms.internal.auth.zzfl):com.google.android.gms.internal.auth.zzft");
    }

    public static <T> int zzl(T t, long j) {
        return ((Integer) zzgz.zzf(t, j)).intValue();
    }

    private final <K, V> int zzm(T t, byte[] bArr, int i, int i2, int i3, long j, zzdp zzdp) throws IOException {
        Unsafe unsafe = zzb;
        Object zzz = zzz(i3);
        Object object = unsafe.getObject(t, j);
        if (!((zzfk) object).zze()) {
            zzfk zzb2 = zzfk.zza().zzb();
            zzfl.zza(zzb2, object);
            unsafe.putObject(t, j, zzb2);
        }
        zzfj zzfj = (zzfj) zzz;
        throw null;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzn(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.auth.zzdp r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzb
            int[] r7 = r0.zzc
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x01bc;
                case 52: goto L_0x01a4;
                case 53: goto L_0x0190;
                case 54: goto L_0x0190;
                case 55: goto L_0x017c;
                case 56: goto L_0x0167;
                case 57: goto L_0x0152;
                case 58: goto L_0x0136;
                case 59: goto L_0x0102;
                case 60: goto L_0x00d4;
                case 61: goto L_0x00c3;
                case 62: goto L_0x017c;
                case 63: goto L_0x0094;
                case 64: goto L_0x0152;
                case 65: goto L_0x0167;
                case 66: goto L_0x007b;
                case 67: goto L_0x0062;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01d5
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01d5
            com.google.android.gms.internal.auth.zzgb r5 = r0.zzy(r6)
            r2 = r2 & -8
            r6 = r2 | 4
            r2 = r5
            r3 = r18
            r4 = r19
            r5 = r20
            r7 = r29
            int r2 = com.google.android.gms.internal.auth.zzdq.zzc(r2, r3, r4, r5, r6, r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0054
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x005d
        L_0x0054:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzev.zzg(r15, r3)
            r12.putObject(r1, r9, r3)
        L_0x005d:
            r12.putInt(r1, r13, r8)
            goto L_0x01d6
        L_0x0062:
            if (r5 == 0) goto L_0x0066
            goto L_0x01d5
        L_0x0066:
            int r2 = com.google.android.gms.internal.auth.zzdq.zzm(r3, r4, r11)
            long r3 = r11.zzb
            long r3 = com.google.android.gms.internal.auth.zzee.zzc(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            r12.putInt(r1, r13, r8)
            return r2
        L_0x007b:
            if (r5 == 0) goto L_0x007f
            goto L_0x01d5
        L_0x007f:
            int r2 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r11)
            int r3 = r11.zza
            int r3 = com.google.android.gms.internal.auth.zzee.zzb(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            r12.putInt(r1, r13, r8)
            return r2
        L_0x0094:
            if (r5 != 0) goto L_0x01d5
            int r3 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r11)
            int r4 = r11.zza
            com.google.android.gms.internal.auth.zzet r5 = r0.zzx(r6)
            if (r5 == 0) goto L_0x00b6
            boolean r5 = r5.zza()
            if (r5 == 0) goto L_0x00a9
            goto L_0x00b6
        L_0x00a9:
            com.google.android.gms.internal.auth.zzgq r1 = zzc(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zzf(r2, r4)
            goto L_0x00c0
        L_0x00b6:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r12.putInt(r1, r13, r8)
        L_0x00c0:
            r2 = r3
            goto L_0x01d6
        L_0x00c3:
            if (r5 == r15) goto L_0x00c7
            goto L_0x01d5
        L_0x00c7:
            int r2 = com.google.android.gms.internal.auth.zzdq.zza(r3, r4, r11)
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            r12.putInt(r1, r13, r8)
            return r2
        L_0x00d4:
            if (r5 != r15) goto L_0x01d5
            com.google.android.gms.internal.auth.zzgb r2 = r0.zzy(r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.auth.zzdq.zzd(r2, r3, r4, r5, r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00eb
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00ec
        L_0x00eb:
            r15 = 0
        L_0x00ec:
            if (r15 != 0) goto L_0x00f4
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x00fd
        L_0x00f4:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzev.zzg(r15, r3)
            r12.putObject(r1, r9, r3)
        L_0x00fd:
            r12.putInt(r1, r13, r8)
            goto L_0x01d6
        L_0x0102:
            if (r5 != r15) goto L_0x01d5
            int r2 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r11)
            int r4 = r11.zza
            if (r4 != 0) goto L_0x0112
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0131
        L_0x0112:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0126
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.auth.zzhd.zzd(r3, r2, r5)
            if (r5 == 0) goto L_0x0121
            goto L_0x0126
        L_0x0121:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzb()
            throw r1
        L_0x0126:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.auth.zzev.zza
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0131:
            r12.putInt(r1, r13, r8)
            goto L_0x01d6
        L_0x0136:
            if (r5 != 0) goto L_0x01d5
            int r2 = com.google.android.gms.internal.auth.zzdq.zzm(r3, r4, r11)
            long r3 = r11.zzb
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0146
            r15 = 1
            goto L_0x0147
        L_0x0146:
            r15 = 0
        L_0x0147:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            r12.putInt(r1, r13, r8)
            return r2
        L_0x0152:
            if (r5 == r7) goto L_0x0156
            goto L_0x01d5
        L_0x0156:
            int r2 = com.google.android.gms.internal.auth.zzdq.zzb(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            r12.putInt(r1, r13, r8)
            int r1 = r4 + 4
            return r1
        L_0x0167:
            r2 = 1
            if (r5 == r2) goto L_0x016b
            goto L_0x01d5
        L_0x016b:
            long r2 = com.google.android.gms.internal.auth.zzdq.zzn(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            r12.putInt(r1, r13, r8)
            int r1 = r4 + 8
            return r1
        L_0x017c:
            if (r5 == 0) goto L_0x017f
            goto L_0x01d5
        L_0x017f:
            int r2 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r11)
            int r3 = r11.zza
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            r12.putInt(r1, r13, r8)
            return r2
        L_0x0190:
            if (r5 == 0) goto L_0x0193
            goto L_0x01d5
        L_0x0193:
            int r2 = com.google.android.gms.internal.auth.zzdq.zzm(r3, r4, r11)
            long r3 = r11.zzb
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            r12.putInt(r1, r13, r8)
            return r2
        L_0x01a4:
            if (r5 == r7) goto L_0x01a7
            goto L_0x01d5
        L_0x01a7:
            int r2 = com.google.android.gms.internal.auth.zzdq.zzb(r18, r19)
            float r2 = java.lang.Float.intBitsToFloat(r2)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
            r12.putInt(r1, r13, r8)
            int r1 = r4 + 4
            return r1
        L_0x01bc:
            r2 = 1
            if (r5 == r2) goto L_0x01c0
            goto L_0x01d5
        L_0x01c0:
            long r2 = com.google.android.gms.internal.auth.zzdq.zzn(r18, r19)
            double r2 = java.lang.Double.longBitsToDouble(r2)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
            r12.putInt(r1, r13, r8)
            int r1 = r4 + 8
            return r1
        L_0x01d5:
            r2 = r4
        L_0x01d6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzft.zzn(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.auth.zzdp):int");
    }

    /* JADX WARNING: type inference failed for: r32v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r12v1, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r0v3, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r17v0, types: [int] */
    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: type inference failed for: r0v7, types: [int] */
    /* JADX WARNING: type inference failed for: r1v7, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v4 */
    /* JADX WARNING: type inference failed for: r2v11, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v2, types: [int] */
    /* JADX WARNING: type inference failed for: r2v12, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: type inference failed for: r2v15, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v5, types: [int] */
    /* JADX WARNING: type inference failed for: r1v23, types: [int] */
    /* JADX WARNING: type inference failed for: r2v16, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r17v4 */
    /* JADX WARNING: type inference failed for: r3v10, types: [int] */
    /* JADX WARNING: type inference failed for: r17v5 */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: type inference failed for: r12v9 */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: type inference failed for: r12v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02a8, code lost:
        if (r0 != r15) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02be, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02f1, code lost:
        if (r0 != r15) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0314, code lost:
        if (r0 != r15) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x001a, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x017d, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r1 = r20;
        r8 = 1048575;
        r10 = -1;
        r29 = r13;
        r13 = r2;
        r2 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01d2, code lost:
        r6 = r6 | r21;
        r9 = r10;
        r2 = r13;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0207, code lost:
        r6 = r6 | r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x020a, code lost:
        r2 = r4;
        r28 = r10;
        r19 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r12v2
      assigns: []
      uses: []
      mth insns count: 348
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzo(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.auth.zzdp r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            if (r0 >= r13) goto L_0x033d
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = com.google.android.gms.internal.auth.zzdq.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002f
        L_0x002c:
            r17 = r0
            r4 = r3
        L_0x002f:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003c
            int r2 = r2 / 3
            int r0 = r15.zzr(r5, r2)
            goto L_0x0040
        L_0x003c:
            int r0 = r15.zzq(r5)
        L_0x0040:
            r2 = r0
            if (r2 != r10) goto L_0x004e
            r2 = r4
            r20 = r5
            r28 = r9
            r18 = -1
            r19 = 0
            goto L_0x0317
        L_0x004e:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = zzu(r1)
            r10 = r1 & r8
            r19 = r9
            long r8 = (long) r10
            r10 = 17
            r33 = r5
            if (r0 > r10) goto L_0x0213
            int[] r10 = r15.zzc
            int r21 = r2 + 2
            r10 = r10[r21]
            int r21 = r10 >>> 20
            r5 = 1
            int r21 = r5 << r21
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r13
            if (r10 == r7) goto L_0x0090
            r23 = r1
            r20 = r2
            if (r7 == r13) goto L_0x0081
            long r1 = (long) r7
            r7 = r19
            r7.putInt(r14, r1, r6)
            goto L_0x0083
        L_0x0081:
            r7 = r19
        L_0x0083:
            if (r10 == r13) goto L_0x008a
            long r1 = (long) r10
            int r6 = r7.getInt(r14, r1)
        L_0x008a:
            r29 = r10
            r10 = r7
            r7 = r29
            goto L_0x0096
        L_0x0090:
            r23 = r1
            r20 = r2
            r10 = r19
        L_0x0096:
            r1 = 5
            switch(r0) {
                case 0: goto L_0x01f1;
                case 1: goto L_0x01da;
                case 2: goto L_0x01bc;
                case 3: goto L_0x01bc;
                case 4: goto L_0x01a9;
                case 5: goto L_0x018d;
                case 6: goto L_0x0169;
                case 7: goto L_0x014c;
                case 8: goto L_0x012b;
                case 9: goto L_0x00f9;
                case 10: goto L_0x00e7;
                case 11: goto L_0x01a9;
                case 12: goto L_0x00d6;
                case 13: goto L_0x0169;
                case 14: goto L_0x018d;
                case 15: goto L_0x00c1;
                case 16: goto L_0x00a3;
                default: goto L_0x009a;
            }
        L_0x009a:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            goto L_0x020a
        L_0x00a3:
            if (r3 != 0) goto L_0x00bc
            int r17 = com.google.android.gms.internal.auth.zzdq.zzm(r12, r4, r11)
            long r0 = r11.zzb
            long r4 = com.google.android.gms.internal.auth.zzee.zzc(r0)
            r0 = r10
            r1 = r31
            r13 = r20
            r2 = r8
            r20 = r33
            r0.putLong(r1, r2, r4)
            goto L_0x01d2
        L_0x00bc:
            r13 = r20
            r20 = r33
            goto L_0x0126
        L_0x00c1:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x0126
            int r0 = com.google.android.gms.internal.auth.zzdq.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.auth.zzee.zzb(r1)
            r10.putInt(r14, r8, r1)
            goto L_0x0207
        L_0x00d6:
            r13 = r20
            r20 = r33
            if (r3 != 0) goto L_0x0126
            int r0 = com.google.android.gms.internal.auth.zzdq.zzj(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x0207
        L_0x00e7:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x0126
            int r0 = com.google.android.gms.internal.auth.zzdq.zza(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0207
        L_0x00f9:
            r13 = r20
            r0 = 2
            r20 = r33
            if (r3 != r0) goto L_0x0124
            com.google.android.gms.internal.auth.zzgb r0 = r15.zzy(r13)
            r2 = r34
            r19 = 1048575(0xfffff, float:1.469367E-39)
            int r0 = com.google.android.gms.internal.auth.zzdq.zzd(r0, r12, r4, r2, r11)
            java.lang.Object r1 = r10.getObject(r14, r8)
            if (r1 != 0) goto L_0x011a
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x017d
        L_0x011a:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.auth.zzev.zzg(r1, r3)
            r10.putObject(r14, r8, r1)
            goto L_0x017d
        L_0x0124:
            r2 = r34
        L_0x0126:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x020a
        L_0x012b:
            r2 = r34
            r13 = r20
            r0 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r0) goto L_0x020a
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r23 & r0
            if (r0 != 0) goto L_0x0142
            int r0 = com.google.android.gms.internal.auth.zzdq.zzg(r12, r4, r11)
            goto L_0x0146
        L_0x0142:
            int r0 = com.google.android.gms.internal.auth.zzdq.zzh(r12, r4, r11)
        L_0x0146:
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x017d
        L_0x014c:
            r2 = r34
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != 0) goto L_0x020a
            int r0 = com.google.android.gms.internal.auth.zzdq.zzm(r12, r4, r11)
            long r3 = r11.zzb
            r22 = 0
            int r1 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r1 == 0) goto L_0x0164
            goto L_0x0165
        L_0x0164:
            r5 = 0
        L_0x0165:
            com.google.android.gms.internal.auth.zzgz.zzk(r14, r8, r5)
            goto L_0x017d
        L_0x0169:
            r2 = r34
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r1) goto L_0x020a
            int r0 = com.google.android.gms.internal.auth.zzdq.zzb(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
        L_0x017d:
            r6 = r6 | r21
            r9 = r10
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r29 = r13
            r13 = r2
            r2 = r29
            goto L_0x001a
        L_0x018d:
            r2 = r34
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r5) goto L_0x020a
            long r22 = com.google.android.gms.internal.auth.zzdq.zzn(r12, r4)
            r0 = r10
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0207
        L_0x01a9:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != 0) goto L_0x020a
            int r0 = com.google.android.gms.internal.auth.zzdq.zzj(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x0207
        L_0x01bc:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != 0) goto L_0x020a
            int r17 = com.google.android.gms.internal.auth.zzdq.zzm(r12, r4, r11)
            long r4 = r11.zzb
            r0 = r10
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
        L_0x01d2:
            r6 = r6 | r21
            r9 = r10
            r2 = r13
            r0 = r17
            goto L_0x0257
        L_0x01da:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r1) goto L_0x020a
            int r0 = com.google.android.gms.internal.auth.zzdq.zzb(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.auth.zzgz.zzm(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x0207
        L_0x01f1:
            r13 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r33
            if (r3 != r5) goto L_0x020a
            long r0 = com.google.android.gms.internal.auth.zzdq.zzn(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.auth.zzgz.zzl(r14, r8, r0)
            int r0 = r4 + 8
        L_0x0207:
            r6 = r6 | r21
            goto L_0x0255
        L_0x020a:
            r2 = r4
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x0317
        L_0x0213:
            r20 = r33
            r23 = r1
            r13 = r2
            r10 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 27
            if (r0 != r1) goto L_0x026e
            r1 = 2
            if (r3 != r1) goto L_0x0261
            java.lang.Object r0 = r10.getObject(r14, r8)
            com.google.android.gms.internal.auth.zzeu r0 = (com.google.android.gms.internal.auth.zzeu) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0241
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0239
            r1 = 10
            goto L_0x023a
        L_0x0239:
            int r1 = r1 + r1
        L_0x023a:
            com.google.android.gms.internal.auth.zzeu r0 = r0.zzd(r1)
            r10.putObject(r14, r8, r0)
        L_0x0241:
            r5 = r0
            com.google.android.gms.internal.auth.zzgb r0 = r15.zzy(r13)
            r1 = r17
            r2 = r32
            r3 = r4
            r4 = r34
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.auth.zzdq.zze(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
        L_0x0255:
            r9 = r10
            r2 = r13
        L_0x0257:
            r1 = r20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r13 = r34
            goto L_0x001a
        L_0x0261:
            r15 = r4
            r24 = r6
            r25 = r7
            r28 = r10
            r19 = r13
            r18 = -1
            goto L_0x02f4
        L_0x026e:
            r1 = 49
            if (r0 > r1) goto L_0x02c0
            r1 = r23
            long r1 = (long) r1
            r5 = r0
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r33 = r3
            r3 = r4
            r15 = r4
            r4 = r34
            r23 = r5
            r5 = r17
            r24 = r6
            r6 = r20
            r25 = r7
            r7 = r33
            r26 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r13
            r28 = r10
            r18 = -1
            r9 = r21
            r11 = r23
            r19 = r13
            r12 = r26
            r14 = r35
            int r0 = r0.zzp(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02be
        L_0x02aa:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r19
            r1 = r20
            r6 = r24
            r7 = r25
            goto L_0x0335
        L_0x02be:
            r2 = r0
            goto L_0x02f5
        L_0x02c0:
            r33 = r3
            r15 = r4
            r24 = r6
            r25 = r7
            r26 = r8
            r28 = r10
            r19 = r13
            r1 = r23
            r18 = -1
            r23 = r0
            r0 = 50
            r9 = r23
            if (r9 != r0) goto L_0x02fa
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x02f4
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r26
            r8 = r35
            int r0 = r0.zzm(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02be
            goto L_0x02aa
        L_0x02f4:
            r2 = r15
        L_0x02f5:
            r6 = r24
            r7 = r25
            goto L_0x0317
        L_0x02fa:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r20
            r10 = r26
            r12 = r19
            r13 = r35
            int r0 = r0.zzn(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02be
            goto L_0x02aa
        L_0x0317:
            com.google.android.gms.internal.auth.zzgq r4 = zzc(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.auth.zzdq.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r19
            r1 = r20
        L_0x0335:
            r9 = r28
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            goto L_0x001a
        L_0x033d:
            r24 = r6
            r28 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x0350
            long r1 = (long) r7
            r3 = r31
            r6 = r24
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x0350:
            r1 = r34
            if (r0 != r1) goto L_0x0355
            return r0
        L_0x0355:
            com.google.android.gms.internal.auth.zzew r0 = com.google.android.gms.internal.auth.zzew.zzd()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzft.zzo(java.lang.Object, byte[], int, int, com.google.android.gms.internal.auth.zzdp):int");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:690)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:695)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:690)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:869)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:128)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0451 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0451 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01d1  */
    private final int zzp(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.auth.zzdp r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.auth.zzeu r11 = (com.google.android.gms.internal.auth.zzeu) r11
            boolean r12 = r11.zzc()
            if (r12 != 0) goto L_0x0034
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002a
            r12 = 10
            goto L_0x002b
        L_0x002a:
            int r12 = r12 + r12
        L_0x002b:
            com.google.android.gms.internal.auth.zzeu r11 = r11.zzd(r12)
            sun.misc.Unsafe r12 = zzb
            r12.putObject(r1, r9, r11)
        L_0x0034:
            r9 = 5
            r12 = 0
            r10 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e3;
                case 19: goto L_0x0396;
                case 20: goto L_0x0353;
                case 21: goto L_0x0353;
                case 22: goto L_0x0338;
                case 23: goto L_0x02f7;
                case 24: goto L_0x02b6;
                case 25: goto L_0x025c;
                case 26: goto L_0x01a9;
                case 27: goto L_0x018e;
                case 28: goto L_0x0134;
                case 29: goto L_0x0338;
                case 30: goto L_0x00fc;
                case 31: goto L_0x02b6;
                case 32: goto L_0x02f7;
                case 33: goto L_0x00ad;
                case 34: goto L_0x005e;
                case 35: goto L_0x03e3;
                case 36: goto L_0x0396;
                case 37: goto L_0x0353;
                case 38: goto L_0x0353;
                case 39: goto L_0x0338;
                case 40: goto L_0x02f7;
                case 41: goto L_0x02b6;
                case 42: goto L_0x025c;
                case 43: goto L_0x0338;
                case 44: goto L_0x00fc;
                case 45: goto L_0x02b6;
                case 46: goto L_0x02f7;
                case 47: goto L_0x00ad;
                case 48: goto L_0x005e;
                default: goto L_0x003c;
            }
        L_0x003c:
            r1 = 3
            if (r6 != r1) goto L_0x0451
            com.google.android.gms.internal.auth.zzgb r1 = r15.zzy(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.auth.zzdq.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
            goto L_0x042f
        L_0x005e:
            if (r6 != r14) goto L_0x0082
            com.google.android.gms.internal.auth.zzff r11 = (com.google.android.gms.internal.auth.zzff) r11
            int r1 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0069:
            if (r1 >= r2) goto L_0x0079
            int r1 = com.google.android.gms.internal.auth.zzdq.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.auth.zzee.zzc(r4)
            r11.zze(r4)
            goto L_0x0069
        L_0x0079:
            if (r1 != r2) goto L_0x007d
            goto L_0x0452
        L_0x007d:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzf()
            throw r1
        L_0x0082:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.auth.zzff r11 = (com.google.android.gms.internal.auth.zzff) r11
            int r1 = com.google.android.gms.internal.auth.zzdq.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.auth.zzee.zzc(r8)
            r11.zze(r8)
        L_0x0093:
            if (r1 >= r5) goto L_0x00ac
            int r4 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009e
            goto L_0x00ac
        L_0x009e:
            int r1 = com.google.android.gms.internal.auth.zzdq.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.auth.zzee.zzc(r8)
            r11.zze(r8)
            goto L_0x0093
        L_0x00ac:
            return r1
        L_0x00ad:
            if (r6 != r14) goto L_0x00d1
            com.google.android.gms.internal.auth.zzer r11 = (com.google.android.gms.internal.auth.zzer) r11
            int r1 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b8:
            if (r1 >= r2) goto L_0x00c8
            int r1 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.auth.zzee.zzb(r4)
            r11.zze(r4)
            goto L_0x00b8
        L_0x00c8:
            if (r1 != r2) goto L_0x00cc
            goto L_0x0452
        L_0x00cc:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzf()
            throw r1
        L_0x00d1:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.auth.zzer r11 = (com.google.android.gms.internal.auth.zzer) r11
            int r1 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.auth.zzee.zzb(r4)
            r11.zze(r4)
        L_0x00e2:
            if (r1 >= r5) goto L_0x00fb
            int r4 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00ed
            goto L_0x00fb
        L_0x00ed:
            int r1 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.auth.zzee.zzb(r4)
            r11.zze(r4)
            goto L_0x00e2
        L_0x00fb:
            return r1
        L_0x00fc:
            if (r6 != r14) goto L_0x0103
            int r2 = com.google.android.gms.internal.auth.zzdq.zzf(r3, r4, r11, r7)
            goto L_0x0114
        L_0x0103:
            if (r6 != 0) goto L_0x0451
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r11
            r7 = r29
            int r2 = com.google.android.gms.internal.auth.zzdq.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0114:
            com.google.android.gms.internal.auth.zzeq r1 = (com.google.android.gms.internal.auth.zzeq) r1
            com.google.android.gms.internal.auth.zzgq r3 = r1.zzc
            com.google.android.gms.internal.auth.zzgq r4 = com.google.android.gms.internal.auth.zzgq.zza()
            if (r3 != r4) goto L_0x011f
            r3 = 0
        L_0x011f:
            com.google.android.gms.internal.auth.zzet r4 = r15.zzx(r8)
            com.google.android.gms.internal.auth.zzgp<?, ?> r5 = r0.zzm
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgd.zzd(r6, r11, r4, r3, r5)
            if (r3 != 0) goto L_0x012f
            goto L_0x027d
        L_0x012f:
            com.google.android.gms.internal.auth.zzgq r3 = (com.google.android.gms.internal.auth.zzgq) r3
            r1.zzc = r3
            return r2
        L_0x0134:
            if (r6 != r14) goto L_0x0451
            int r1 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0189
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0184
            if (r4 != 0) goto L_0x014a
            com.google.android.gms.internal.auth.zzeb r4 = com.google.android.gms.internal.auth.zzeb.zzb
            r11.add(r4)
            goto L_0x0152
        L_0x014a:
            com.google.android.gms.internal.auth.zzeb r6 = com.google.android.gms.internal.auth.zzeb.zzk(r3, r1, r4)
            r11.add(r6)
        L_0x0151:
            int r1 = r1 + r4
        L_0x0152:
            if (r1 >= r5) goto L_0x0183
            int r4 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015d
            goto L_0x0183
        L_0x015d:
            int r1 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017e
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0179
            if (r4 != 0) goto L_0x0171
            com.google.android.gms.internal.auth.zzeb r4 = com.google.android.gms.internal.auth.zzeb.zzb
            r11.add(r4)
            goto L_0x0152
        L_0x0171:
            com.google.android.gms.internal.auth.zzeb r6 = com.google.android.gms.internal.auth.zzeb.zzk(r3, r1, r4)
            r11.add(r6)
            goto L_0x0151
        L_0x0179:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzf()
            throw r1
        L_0x017e:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzc()
            throw r1
        L_0x0183:
            return r1
        L_0x0184:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzf()
            throw r1
        L_0x0189:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzc()
            throw r1
        L_0x018e:
            if (r6 == r14) goto L_0x0192
            goto L_0x0451
        L_0x0192:
            com.google.android.gms.internal.auth.zzgb r1 = r15.zzy(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r11
            r27 = r29
            int r1 = com.google.android.gms.internal.auth.zzdq.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a9:
            if (r6 != r14) goto L_0x0451
            r8 = 536870912(0x20000000, double:2.65249474E-315)
            long r8 = r24 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 != 0) goto L_0x01fc
            int r4 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01f7
            if (r6 != 0) goto L_0x01c4
            r11.add(r1)
            goto L_0x01cf
        L_0x01c4:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.auth.zzev.zza
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
        L_0x01ce:
            int r4 = r4 + r6
        L_0x01cf:
            if (r4 >= r5) goto L_0x0451
            int r6 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0451
            int r4 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x01f2
            if (r6 != 0) goto L_0x01e7
            r11.add(r1)
            goto L_0x01cf
        L_0x01e7:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.auth.zzev.zza
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
            goto L_0x01ce
        L_0x01f2:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzc()
            throw r1
        L_0x01f7:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzc()
            throw r1
        L_0x01fc:
            int r4 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0257
            if (r6 != 0) goto L_0x020a
            r11.add(r1)
            goto L_0x021d
        L_0x020a:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.auth.zzhd.zzd(r3, r4, r8)
            if (r9 == 0) goto L_0x0252
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.auth.zzev.zza
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
        L_0x021c:
            r4 = r8
        L_0x021d:
            if (r4 >= r5) goto L_0x0451
            int r6 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0451
            int r4 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x024d
            if (r6 != 0) goto L_0x0235
            r11.add(r1)
            goto L_0x021d
        L_0x0235:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.auth.zzhd.zzd(r3, r4, r8)
            if (r9 == 0) goto L_0x0248
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.auth.zzev.zza
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
            goto L_0x021c
        L_0x0248:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzb()
            throw r1
        L_0x024d:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzc()
            throw r1
        L_0x0252:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzb()
            throw r1
        L_0x0257:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzc()
            throw r1
        L_0x025c:
            r1 = 0
            if (r6 != r14) goto L_0x0285
            com.google.android.gms.internal.auth.zzdr r11 = (com.google.android.gms.internal.auth.zzdr) r11
            int r2 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0268:
            if (r2 >= r4) goto L_0x027b
            int r2 = com.google.android.gms.internal.auth.zzdq.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r8 == 0) goto L_0x0276
            r5 = 1
            goto L_0x0277
        L_0x0276:
            r5 = 0
        L_0x0277:
            r11.zze(r5)
            goto L_0x0268
        L_0x027b:
            if (r2 != r4) goto L_0x0280
        L_0x027d:
            r1 = r2
            goto L_0x0452
        L_0x0280:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzf()
            throw r1
        L_0x0285:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.auth.zzdr r11 = (com.google.android.gms.internal.auth.zzdr) r11
            int r4 = com.google.android.gms.internal.auth.zzdq.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x0295
            r6 = 1
            goto L_0x0296
        L_0x0295:
            r6 = 0
        L_0x0296:
            r11.zze(r6)
        L_0x0299:
            if (r4 >= r5) goto L_0x02b5
            int r6 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a4
            goto L_0x02b5
        L_0x02a4:
            int r4 = com.google.android.gms.internal.auth.zzdq.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x02b0
            r6 = 1
            goto L_0x02b1
        L_0x02b0:
            r6 = 0
        L_0x02b1:
            r11.zze(r6)
            goto L_0x0299
        L_0x02b5:
            return r4
        L_0x02b6:
            if (r6 != r14) goto L_0x02d6
            com.google.android.gms.internal.auth.zzer r11 = (com.google.android.gms.internal.auth.zzer) r11
            int r1 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02c1:
            if (r1 >= r2) goto L_0x02cd
            int r4 = com.google.android.gms.internal.auth.zzdq.zzb(r3, r1)
            r11.zze(r4)
            int r1 = r1 + 4
            goto L_0x02c1
        L_0x02cd:
            if (r1 != r2) goto L_0x02d1
            goto L_0x0452
        L_0x02d1:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzf()
            throw r1
        L_0x02d6:
            if (r6 != r9) goto L_0x0451
            com.google.android.gms.internal.auth.zzer r11 = (com.google.android.gms.internal.auth.zzer) r11
            int r1 = com.google.android.gms.internal.auth.zzdq.zzb(r17, r18)
            r11.zze(r1)
        L_0x02e1:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f6
            int r4 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ee
            goto L_0x02f6
        L_0x02ee:
            int r1 = com.google.android.gms.internal.auth.zzdq.zzb(r3, r4)
            r11.zze(r1)
            goto L_0x02e1
        L_0x02f6:
            return r1
        L_0x02f7:
            if (r6 != r14) goto L_0x0317
            com.google.android.gms.internal.auth.zzff r11 = (com.google.android.gms.internal.auth.zzff) r11
            int r1 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0302:
            if (r1 >= r2) goto L_0x030e
            long r4 = com.google.android.gms.internal.auth.zzdq.zzn(r3, r1)
            r11.zze(r4)
            int r1 = r1 + 8
            goto L_0x0302
        L_0x030e:
            if (r1 != r2) goto L_0x0312
            goto L_0x0452
        L_0x0312:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzf()
            throw r1
        L_0x0317:
            if (r6 != r10) goto L_0x0451
            com.google.android.gms.internal.auth.zzff r11 = (com.google.android.gms.internal.auth.zzff) r11
            long r8 = com.google.android.gms.internal.auth.zzdq.zzn(r17, r18)
            r11.zze(r8)
        L_0x0322:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0337
            int r4 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032f
            goto L_0x0337
        L_0x032f:
            long r8 = com.google.android.gms.internal.auth.zzdq.zzn(r3, r4)
            r11.zze(r8)
            goto L_0x0322
        L_0x0337:
            return r1
        L_0x0338:
            if (r6 != r14) goto L_0x0340
            int r1 = com.google.android.gms.internal.auth.zzdq.zzf(r3, r4, r11, r7)
            goto L_0x0452
        L_0x0340:
            if (r6 == 0) goto L_0x0344
            goto L_0x0451
        L_0x0344:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r11
            r25 = r29
            int r1 = com.google.android.gms.internal.auth.zzdq.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0353:
            if (r6 != r14) goto L_0x0373
            com.google.android.gms.internal.auth.zzff r11 = (com.google.android.gms.internal.auth.zzff) r11
            int r1 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035e:
            if (r1 >= r2) goto L_0x036a
            int r1 = com.google.android.gms.internal.auth.zzdq.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r11.zze(r4)
            goto L_0x035e
        L_0x036a:
            if (r1 != r2) goto L_0x036e
            goto L_0x0452
        L_0x036e:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzf()
            throw r1
        L_0x0373:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.auth.zzff r11 = (com.google.android.gms.internal.auth.zzff) r11
            int r1 = com.google.android.gms.internal.auth.zzdq.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r11.zze(r8)
        L_0x0380:
            if (r1 >= r5) goto L_0x0395
            int r4 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x038b
            goto L_0x0395
        L_0x038b:
            int r1 = com.google.android.gms.internal.auth.zzdq.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r11.zze(r8)
            goto L_0x0380
        L_0x0395:
            return r1
        L_0x0396:
            if (r6 != r14) goto L_0x03ba
            com.google.android.gms.internal.auth.zzem r11 = (com.google.android.gms.internal.auth.zzem) r11
            int r1 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03a1:
            if (r1 >= r2) goto L_0x03b1
            int r4 = com.google.android.gms.internal.auth.zzdq.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r11.zze(r4)
            int r1 = r1 + 4
            goto L_0x03a1
        L_0x03b1:
            if (r1 != r2) goto L_0x03b5
            goto L_0x0452
        L_0x03b5:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzf()
            throw r1
        L_0x03ba:
            if (r6 != r9) goto L_0x0451
            com.google.android.gms.internal.auth.zzem r11 = (com.google.android.gms.internal.auth.zzem) r11
            int r1 = com.google.android.gms.internal.auth.zzdq.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r11.zze(r1)
        L_0x03c9:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e2
            int r4 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d6
            goto L_0x03e2
        L_0x03d6:
            int r1 = com.google.android.gms.internal.auth.zzdq.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r11.zze(r1)
            goto L_0x03c9
        L_0x03e2:
            return r1
        L_0x03e3:
            if (r6 != r14) goto L_0x0406
            com.google.android.gms.internal.auth.zzef r11 = (com.google.android.gms.internal.auth.zzef) r11
            int r1 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ee:
            if (r1 >= r2) goto L_0x03fe
            long r4 = com.google.android.gms.internal.auth.zzdq.zzn(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r11.zze(r4)
            int r1 = r1 + 8
            goto L_0x03ee
        L_0x03fe:
            if (r1 != r2) goto L_0x0401
            goto L_0x0452
        L_0x0401:
            com.google.android.gms.internal.auth.zzew r1 = com.google.android.gms.internal.auth.zzew.zzf()
            throw r1
        L_0x0406:
            if (r6 != r10) goto L_0x0451
            com.google.android.gms.internal.auth.zzef r11 = (com.google.android.gms.internal.auth.zzef) r11
            long r8 = com.google.android.gms.internal.auth.zzdq.zzn(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r11.zze(r8)
        L_0x0415:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042e
            int r4 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0422
            goto L_0x042e
        L_0x0422:
            long r8 = com.google.android.gms.internal.auth.zzdq.zzn(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r11.zze(r8)
            goto L_0x0415
        L_0x042e:
            return r1
        L_0x042f:
            if (r4 >= r5) goto L_0x0450
            int r8 = com.google.android.gms.internal.auth.zzdq.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x043a
            goto L_0x0450
        L_0x043a:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.auth.zzdq.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
            goto L_0x042f
        L_0x0450:
            return r4
        L_0x0451:
            r1 = r4
        L_0x0452:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzft.zzp(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.auth.zzdp):int");
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzt(i, 0);
    }

    private final int zzr(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzt(i, i2);
    }

    private final int zzs(int i) {
        return this.zzc[i + 2];
    }

    private final int zzt(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public static int zzu(int i) {
        return (i >>> 20) & InvitationReply.EXPIRED;
    }

    private final int zzv(int i) {
        return this.zzc[i + 1];
    }

    public static <T> long zzw(T t, long j) {
        return ((Long) zzgz.zzf(t, j)).longValue();
    }

    private final zzet zzx(int i) {
        int i2 = i / 3;
        return (zzet) this.zzd[i2 + i2 + 1];
    }

    private final zzgb zzy(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgb zzgb = (zzgb) this.zzd[i3];
        if (zzgb != null) {
            return zzgb;
        }
        zzgb zzb2 = zzfy.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01d4, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0238, code lost:
        r2 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x023a, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x023e
            int r3 = r8.zzv(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzu(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x022a;
                case 1: goto L_0x021f;
                case 2: goto L_0x0214;
                case 3: goto L_0x0209;
                case 4: goto L_0x0202;
                case 5: goto L_0x01f7;
                case 6: goto L_0x01f0;
                case 7: goto L_0x01e5;
                case 8: goto L_0x01d8;
                case 9: goto L_0x01ca;
                case 10: goto L_0x01be;
                case 11: goto L_0x01b6;
                case 12: goto L_0x01ae;
                case 13: goto L_0x01a6;
                case 14: goto L_0x019a;
                case 15: goto L_0x0192;
                case 16: goto L_0x0186;
                case 17: goto L_0x017b;
                case 18: goto L_0x016f;
                case 19: goto L_0x016f;
                case 20: goto L_0x016f;
                case 21: goto L_0x016f;
                case 22: goto L_0x016f;
                case 23: goto L_0x016f;
                case 24: goto L_0x016f;
                case 25: goto L_0x016f;
                case 26: goto L_0x016f;
                case 27: goto L_0x016f;
                case 28: goto L_0x016f;
                case 29: goto L_0x016f;
                case 30: goto L_0x016f;
                case 31: goto L_0x016f;
                case 32: goto L_0x016f;
                case 33: goto L_0x016f;
                case 34: goto L_0x016f;
                case 35: goto L_0x016f;
                case 36: goto L_0x016f;
                case 37: goto L_0x016f;
                case 38: goto L_0x016f;
                case 39: goto L_0x016f;
                case 40: goto L_0x016f;
                case 41: goto L_0x016f;
                case 42: goto L_0x016f;
                case 43: goto L_0x016f;
                case 44: goto L_0x016f;
                case 45: goto L_0x016f;
                case 46: goto L_0x016f;
                case 47: goto L_0x016f;
                case 48: goto L_0x016f;
                case 49: goto L_0x016f;
                case 50: goto L_0x0163;
                case 51: goto L_0x0147;
                case 52: goto L_0x012f;
                case 53: goto L_0x011d;
                case 54: goto L_0x010b;
                case 55: goto L_0x00fd;
                case 56: goto L_0x00eb;
                case 57: goto L_0x00dd;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x023a
        L_0x001f:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgz.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x0031:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzev.zzc(r3)
            goto L_0x0238
        L_0x0043:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x0051:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzev.zzc(r3)
            goto L_0x0238
        L_0x0063:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x0071:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x007f:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x008d:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgz.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x009f:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgz.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x00b1:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgz.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x00c5:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgz.zzf(r9, r5)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            int r3 = com.google.android.gms.internal.auth.zzev.zza(r3)
            goto L_0x0238
        L_0x00dd:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x00eb:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzev.zzc(r3)
            goto L_0x0238
        L_0x00fd:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x010b:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzev.zzc(r3)
            goto L_0x0238
        L_0x011d:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzev.zzc(r3)
            goto L_0x0238
        L_0x012f:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgz.zzf(r9, r5)
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0238
        L_0x0147:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x023a
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgz.zzf(r9, r5)
            java.lang.Double r3 = (java.lang.Double) r3
            double r3 = r3.doubleValue()
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.auth.zzev.zzc(r3)
            goto L_0x0238
        L_0x0163:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgz.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x016f:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgz.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x017b:
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgz.zzf(r9, r5)
            if (r3 == 0) goto L_0x01d4
            int r7 = r3.hashCode()
            goto L_0x01d4
        L_0x0186:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzgz.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzev.zzc(r3)
            goto L_0x0238
        L_0x0192:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzgz.zzc(r9, r5)
            goto L_0x0238
        L_0x019a:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzgz.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzev.zzc(r3)
            goto L_0x0238
        L_0x01a6:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzgz.zzc(r9, r5)
            goto L_0x0238
        L_0x01ae:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzgz.zzc(r9, r5)
            goto L_0x0238
        L_0x01b6:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzgz.zzc(r9, r5)
            goto L_0x0238
        L_0x01be:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgz.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x01ca:
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgz.zzf(r9, r5)
            if (r3 == 0) goto L_0x01d4
            int r7 = r3.hashCode()
        L_0x01d4:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x023a
        L_0x01d8:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgz.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x01e5:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.auth.zzgz.zzt(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzev.zza(r3)
            goto L_0x0238
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzgz.zzc(r9, r5)
            goto L_0x0238
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzgz.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzev.zzc(r3)
            goto L_0x0238
        L_0x0202:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzgz.zzc(r9, r5)
            goto L_0x0238
        L_0x0209:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzgz.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzev.zzc(r3)
            goto L_0x0238
        L_0x0214:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzgz.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzev.zzc(r3)
            goto L_0x0238
        L_0x021f:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.auth.zzgz.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0238
        L_0x022a:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.auth.zzgz.zza(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.auth.zzev.zzc(r3)
        L_0x0238:
            int r3 = r3 + r2
            r2 = r3
        L_0x023a:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x023e:
            int r2 = r2 * 53
            com.google.android.gms.internal.auth.zzgp<?, ?> r0 = r8.zzm
            java.lang.Object r9 = r0.zza(r9)
            int r9 = r9.hashCode()
            int r9 = r9 + r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzft.zza(java.lang.Object):int");
    }

    /* JADX WARNING: type inference failed for: r30v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r12v1, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r0v8, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r4v3, types: [int] */
    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r0v12, types: [int] */
    /* JADX WARNING: type inference failed for: r1v7, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v4 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r20v1 */
    /* JADX WARNING: type inference failed for: r12v5 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r11v6 */
    /* JADX WARNING: type inference failed for: r18v1 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r18v2 */
    /* JADX WARNING: type inference failed for: r18v3 */
    /* JADX WARNING: type inference failed for: r2v14, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v12, types: [int] */
    /* JADX WARNING: type inference failed for: r2v15, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r18v4 */
    /* JADX WARNING: type inference failed for: r18v5 */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r2v18, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v16, types: [int] */
    /* JADX WARNING: type inference failed for: r18v6 */
    /* JADX WARNING: type inference failed for: r18v7 */
    /* JADX WARNING: type inference failed for: r1v16, types: [int] */
    /* JADX WARNING: type inference failed for: r2v19, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v9 */
    /* JADX WARNING: type inference failed for: r11v12 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: type inference failed for: r11v13 */
    /* JADX WARNING: type inference failed for: r1v21 */
    /* JADX WARNING: type inference failed for: r12v11 */
    /* JADX WARNING: type inference failed for: r11v14 */
    /* JADX WARNING: type inference failed for: r12v12, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r11v15 */
    /* JADX WARNING: type inference failed for: r12v13, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r11v16 */
    /* JADX WARNING: type inference failed for: r12v14 */
    /* JADX WARNING: type inference failed for: r11v17 */
    /* JADX WARNING: type inference failed for: r12v15, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r11v18 */
    /* JADX WARNING: type inference failed for: r12v16, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r11v19 */
    /* JADX WARNING: type inference failed for: r11v20 */
    /* JADX WARNING: type inference failed for: r12v17, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r11v21 */
    /* JADX WARNING: type inference failed for: r12v18, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r11v22 */
    /* JADX WARNING: type inference failed for: r12v19, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r11v23 */
    /* JADX WARNING: type inference failed for: r12v20, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r11v24 */
    /* JADX WARNING: type inference failed for: r12v21, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r11v25 */
    /* JADX WARNING: type inference failed for: r12v22, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r11v26 */
    /* JADX WARNING: type inference failed for: r12v23, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r11v27, types: [int] */
    /* JADX WARNING: type inference failed for: r1v38 */
    /* JADX WARNING: type inference failed for: r12v24, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r11v28 */
    /* JADX WARNING: type inference failed for: r12v25 */
    /* JADX WARNING: type inference failed for: r11v29 */
    /* JADX WARNING: type inference failed for: r12v26, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r11v30 */
    /* JADX WARNING: type inference failed for: r12v27 */
    /* JADX WARNING: type inference failed for: r11v31 */
    /* JADX WARNING: type inference failed for: r1v43, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v29 */
    /* JADX WARNING: type inference failed for: r8v36 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r1v48, types: [int] */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* JADX WARNING: type inference failed for: r12v30 */
    /* JADX WARNING: type inference failed for: r1v50 */
    /* JADX WARNING: type inference failed for: r12v31 */
    /* JADX WARNING: type inference failed for: r1v51 */
    /* JADX WARNING: type inference failed for: r12v32 */
    /* JADX WARNING: type inference failed for: r1v52 */
    /* JADX WARNING: type inference failed for: r18v8 */
    /* JADX WARNING: type inference failed for: r18v9 */
    /* JADX WARNING: type inference failed for: r1v53 */
    /* JADX WARNING: type inference failed for: r12v33 */
    /* JADX WARNING: type inference failed for: r12v34 */
    /* JADX WARNING: type inference failed for: r11v35 */
    /* JADX WARNING: type inference failed for: r12v35 */
    /* JADX WARNING: type inference failed for: r12v36 */
    /* JADX WARNING: type inference failed for: r12v37 */
    /* JADX WARNING: type inference failed for: r11v36 */
    /* JADX WARNING: type inference failed for: r12v38 */
    /* JADX WARNING: type inference failed for: r12v39 */
    /* JADX WARNING: type inference failed for: r11v37 */
    /* JADX WARNING: type inference failed for: r12v40 */
    /* JADX WARNING: type inference failed for: r12v41 */
    /* JADX WARNING: type inference failed for: r12v42 */
    /* JADX WARNING: type inference failed for: r12v43 */
    /* JADX WARNING: type inference failed for: r12v44 */
    /* JADX WARNING: type inference failed for: r12v45 */
    /* JADX WARNING: type inference failed for: r12v46 */
    /* JADX WARNING: type inference failed for: r12v47 */
    /* JADX WARNING: type inference failed for: r12v48 */
    /* JADX WARNING: type inference failed for: r12v49 */
    /* JADX WARNING: type inference failed for: r12v50 */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0322, code lost:
        if (r0 != r15) goto L_0x0324;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x033c, code lost:
        r7 = r33;
        r2 = r0;
        r18 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0366, code lost:
        if (r0 != r15) goto L_0x0324;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0388, code lost:
        if (r0 != r15) goto L_0x0324;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01ef, code lost:
        r2 = r1;
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0226, code lost:
        r5 = r6 | r22;
        r6 = r31;
        r0 = r7;
        r12 = r12;
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0260, code lost:
        r5 = r6 | r22;
        r6 = r31;
        r12 = r12;
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0264, code lost:
        r3 = r8;
        r1 = r11;
        r2 = r19;
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0280, code lost:
        r7 = r33;
        r22 = r6;
        r20 = r8;
        r27 = r10;
        r8 = r11;
        r6 = r31;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r12v2
      assigns: []
      uses: []
      mth insns count: 468
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 36 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.auth.zzdp r34) throws java.io.IOException {
        /*
            r28 = this;
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r31
            r1 = 0
            r2 = -1
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            if (r0 >= r13) goto L_0x03b9
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002a
            int r0 = com.google.android.gms.internal.auth.zzdq.zzk(r0, r12, r1, r9)
            int r1 = r9.zza
            r4 = r1
            r1 = r0
            goto L_0x002b
        L_0x002a:
            r4 = r0
        L_0x002b:
            int r0 = r4 >>> 3
            r7 = r4 & 7
            r8 = 3
            if (r0 <= r2) goto L_0x0038
            int r3 = r3 / r8
            int r2 = r15.zzr(r0, r3)
            goto L_0x003c
        L_0x0038:
            int r2 = r15.zzq(r0)
        L_0x003c:
            r3 = -1
            if (r2 != r3) goto L_0x004e
            r19 = r0
            r2 = r1
            r8 = r4
            r22 = r5
            r27 = r10
            r7 = r11
            r17 = -1
            r20 = 0
            goto L_0x038b
        L_0x004e:
            int[] r3 = r15.zzc
            int r19 = r2 + 1
            r3 = r3[r19]
            int r8 = zzu(r3)
            r19 = r0
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r3 & r17
            r21 = r3
            r20 = r4
            long r3 = (long) r0
            r0 = 17
            if (r8 > r0) goto L_0x028f
            int[] r0 = r15.zzc
            int r22 = r2 + 2
            r0 = r0[r22]
            int r22 = r0 >>> 20
            r11 = 1
            int r22 = r11 << r22
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r11
            if (r0 == r6) goto L_0x0086
            if (r6 == r11) goto L_0x007f
            long r11 = (long) r6
            r10.putInt(r14, r11, r5)
        L_0x007f:
            long r5 = (long) r0
            int r5 = r10.getInt(r14, r5)
            r11 = r0
            goto L_0x0087
        L_0x0086:
            r11 = r6
        L_0x0087:
            r6 = r5
            r0 = 5
            switch(r8) {
                case 0: goto L_0x0246;
                case 1: goto L_0x022c;
                case 2: goto L_0x0209;
                case 3: goto L_0x0209;
                case 4: goto L_0x01f2;
                case 5: goto L_0x01d1;
                case 6: goto L_0x01bb;
                case 7: goto L_0x019c;
                case 8: goto L_0x017a;
                case 9: goto L_0x014c;
                case 10: goto L_0x0135;
                case 11: goto L_0x01f2;
                case 12: goto L_0x00fd;
                case 13: goto L_0x01bb;
                case 14: goto L_0x01d1;
                case 15: goto L_0x00e3;
                case 16: goto L_0x00b8;
                default: goto L_0x008c;
            }
        L_0x008c:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r20
            r0 = 3
            r18 = -1
            r2 = r1
            if (r7 != r0) goto L_0x0280
            com.google.android.gms.internal.auth.zzgb r0 = r15.zzy(r8)
            int r1 = r19 << 3
            r5 = r1 | 4
            r1 = r30
            r12 = r3
            r3 = r32
            r4 = r5
            r5 = r34
            int r0 = com.google.android.gms.internal.auth.zzdq.zzc(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x026a
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r12, r1)
            goto L_0x0277
        L_0x00b8:
            if (r7 != 0) goto L_0x00d8
            r12 = r30
            int r7 = com.google.android.gms.internal.auth.zzdq.zzm(r12, r1, r9)
            long r0 = r9.zzb
            long r23 = com.google.android.gms.internal.auth.zzee.zzc(r0)
            r0 = r10
            r1 = r29
            r8 = r2
            r18 = -1
            r2 = r3
            r31 = r11
            r11 = r20
            r4 = r23
            r0.putLong(r1, r2, r4)
            goto L_0x0226
        L_0x00d8:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r20
            r18 = -1
            goto L_0x01ef
        L_0x00e3:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r20
            r18 = -1
            if (r7 != 0) goto L_0x01ef
            int r0 = com.google.android.gms.internal.auth.zzdq.zzj(r12, r1, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.auth.zzee.zzb(r1)
            r10.putInt(r14, r3, r1)
            goto L_0x0260
        L_0x00fd:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r20
            r18 = -1
            if (r7 != 0) goto L_0x01ef
            int r0 = com.google.android.gms.internal.auth.zzdq.zzj(r12, r1, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.auth.zzet r2 = r15.zzx(r8)
            if (r2 == 0) goto L_0x0130
            boolean r2 = r2.zza()
            if (r2 == 0) goto L_0x011b
            goto L_0x0130
        L_0x011b:
            com.google.android.gms.internal.auth.zzgq r2 = zzc(r29)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzf(r11, r1)
            r5 = r6
            r3 = r8
            r1 = r11
            r2 = r19
            r6 = r31
            goto L_0x02de
        L_0x0130:
            r10.putInt(r14, r3, r1)
            goto L_0x0260
        L_0x0135:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r20
            r0 = 2
            r18 = -1
            if (r7 != r0) goto L_0x01ef
            int r0 = com.google.android.gms.internal.auth.zzdq.zza(r12, r1, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x0260
        L_0x014c:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r20
            r0 = 2
            r18 = -1
            if (r7 != r0) goto L_0x01ef
            com.google.android.gms.internal.auth.zzgb r0 = r15.zzy(r8)
            int r0 = com.google.android.gms.internal.auth.zzdq.zzd(r0, r12, r1, r13, r9)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x016b
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x0260
        L_0x016b:
            java.lang.Object r1 = r10.getObject(r14, r3)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.auth.zzev.zzg(r1, r2)
            r10.putObject(r14, r3, r1)
            goto L_0x0260
        L_0x017a:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r20
            r0 = 2
            r18 = -1
            if (r7 != r0) goto L_0x01ef
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r21 & r0
            if (r0 != 0) goto L_0x0191
            int r0 = com.google.android.gms.internal.auth.zzdq.zzg(r12, r1, r9)
            goto L_0x0195
        L_0x0191:
            int r0 = com.google.android.gms.internal.auth.zzdq.zzh(r12, r1, r9)
        L_0x0195:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x0260
        L_0x019c:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r20
            r18 = -1
            if (r7 != 0) goto L_0x01ef
            int r0 = com.google.android.gms.internal.auth.zzdq.zzm(r12, r1, r9)
            long r1 = r9.zzb
            r20 = 0
            int r5 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r5 == 0) goto L_0x01b5
            r1 = 1
            goto L_0x01b6
        L_0x01b5:
            r1 = 0
        L_0x01b6:
            com.google.android.gms.internal.auth.zzgz.zzk(r14, r3, r1)
            goto L_0x0260
        L_0x01bb:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r20
            r18 = -1
            if (r7 != r0) goto L_0x01ef
            int r0 = com.google.android.gms.internal.auth.zzdq.zzb(r12, r1)
            r10.putInt(r14, r3, r0)
            int r0 = r1 + 4
            goto L_0x0260
        L_0x01d1:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r20
            r0 = 1
            r18 = -1
            if (r7 != r0) goto L_0x01ef
            long r20 = com.google.android.gms.internal.auth.zzdq.zzn(r12, r1)
            r0 = r10
            r7 = r1
            r1 = r29
            r2 = r3
            r4 = r20
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x0260
        L_0x01ef:
            r2 = r1
            goto L_0x0280
        L_0x01f2:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r20
            r18 = -1
            r2 = r1
            if (r7 != 0) goto L_0x0280
            int r0 = com.google.android.gms.internal.auth.zzdq.zzj(r12, r2, r9)
            int r1 = r9.zza
            r10.putInt(r14, r3, r1)
            goto L_0x0260
        L_0x0209:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r20
            r18 = -1
            r2 = r1
            if (r7 != 0) goto L_0x0280
            int r7 = com.google.android.gms.internal.auth.zzdq.zzm(r12, r2, r9)
            long r1 = r9.zzb
            r0 = r10
            r20 = r1
            r1 = r29
            r2 = r3
            r4 = r20
            r0.putLong(r1, r2, r4)
        L_0x0226:
            r5 = r6 | r22
            r6 = r31
            r0 = r7
            goto L_0x0264
        L_0x022c:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r20
            r18 = -1
            r2 = r1
            if (r7 != r0) goto L_0x0280
            int r0 = com.google.android.gms.internal.auth.zzdq.zzb(r12, r2)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.auth.zzgz.zzm(r14, r3, r0)
            int r0 = r2 + 4
            goto L_0x0260
        L_0x0246:
            r12 = r30
            r8 = r2
            r31 = r11
            r11 = r20
            r0 = 1
            r18 = -1
            r2 = r1
            if (r7 != r0) goto L_0x0280
            long r0 = com.google.android.gms.internal.auth.zzdq.zzn(r12, r2)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.auth.zzgz.zzl(r14, r3, r0)
            int r0 = r2 + 8
        L_0x0260:
            r5 = r6 | r22
            r6 = r31
        L_0x0264:
            r3 = r8
            r1 = r11
            r2 = r19
            goto L_0x02de
        L_0x026a:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.auth.zzev.zzg(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x0277:
            r5 = r6 | r22
            r12 = r30
            r6 = r31
            r13 = r32
            goto L_0x0264
        L_0x0280:
            r7 = r33
            r22 = r6
            r20 = r8
            r27 = r10
            r8 = r11
            r17 = -1
            r6 = r31
            goto L_0x038b
        L_0x028f:
            r12 = r3
            r11 = r20
            r18 = -1
            r4 = r2
            r2 = r1
            r0 = 27
            if (r8 != r0) goto L_0x02f1
            r0 = 2
            if (r7 != r0) goto L_0x02e2
            java.lang.Object r0 = r10.getObject(r14, r12)
            com.google.android.gms.internal.auth.zzeu r0 = (com.google.android.gms.internal.auth.zzeu) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x02ba
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02b2
            r1 = 10
            goto L_0x02b3
        L_0x02b2:
            int r1 = r1 + r1
        L_0x02b3:
            com.google.android.gms.internal.auth.zzeu r0 = r0.zzd(r1)
            r10.putObject(r14, r12, r0)
        L_0x02ba:
            r7 = r0
            com.google.android.gms.internal.auth.zzgb r0 = r15.zzy(r4)
            r1 = r11
            r3 = r2
            r2 = r30
            r20 = r4
            r4 = r32
            r22 = r5
            r5 = r7
            r24 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.auth.zzdq.zze(r0, r1, r2, r3, r4, r5, r6)
            r12 = r30
            r13 = r32
            r2 = r19
            r3 = r20
            r5 = r22
            r6 = r24
        L_0x02de:
            r11 = r33
            goto L_0x0019
        L_0x02e2:
            r20 = r4
            r22 = r5
            r24 = r6
            r15 = r2
            r27 = r10
            r18 = r11
            r17 = -1
            goto L_0x0369
        L_0x02f1:
            r3 = r2
            r20 = r4
            r22 = r5
            r24 = r6
            r0 = 49
            if (r8 > r0) goto L_0x0340
            r4 = r21
            long r5 = (long) r4
            r0 = r28
            r1 = r29
            r2 = r30
            r4 = r3
            r15 = r4
            r4 = r32
            r25 = r5
            r5 = r11
            r6 = r19
            r31 = r8
            r17 = -1
            r8 = r20
            r27 = r10
            r9 = r25
            r18 = r11
            r11 = r31
            r14 = r34
            int r0 = r0.zzp(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x033c
        L_0x0324:
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            r1 = r18
            r2 = r19
            r3 = r20
            r5 = r22
            r6 = r24
            goto L_0x03b5
        L_0x033c:
            r7 = r33
            r2 = r0
            goto L_0x036c
        L_0x0340:
            r15 = r3
            r31 = r8
            r27 = r10
            r18 = r11
            r4 = r21
            r17 = -1
            r0 = 50
            r9 = r31
            if (r9 != r0) goto L_0x0371
            r0 = 2
            if (r7 != r0) goto L_0x0369
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r20
            r6 = r12
            r8 = r34
            int r0 = r0.zzm(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x033c
            goto L_0x0324
        L_0x0369:
            r7 = r33
            r2 = r15
        L_0x036c:
            r8 = r18
            r6 = r24
            goto L_0x038b
        L_0x0371:
            r0 = r28
            r1 = r29
            r2 = r30
            r8 = r4
            r3 = r15
            r4 = r32
            r5 = r18
            r6 = r19
            r10 = r12
            r12 = r20
            r13 = r34
            int r0 = r0.zzn(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x033c
            goto L_0x0324
        L_0x038b:
            if (r8 != r7) goto L_0x0394
            if (r7 == 0) goto L_0x0394
            r0 = r2
            r1 = r8
            r5 = r22
            goto L_0x03c0
        L_0x0394:
            com.google.android.gms.internal.auth.zzgq r4 = zzc(r29)
            r0 = r8
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.auth.zzdq.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r9 = r34
            r11 = r7
            r1 = r8
            r2 = r19
            r3 = r20
            r5 = r22
        L_0x03b5:
            r10 = r27
            goto L_0x0019
        L_0x03b9:
            r22 = r5
            r24 = r6
            r27 = r10
            r7 = r11
        L_0x03c0:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r2) goto L_0x03ce
            long r3 = (long) r6
            r6 = r29
            r8 = r27
            r8.putInt(r6, r3, r5)
            goto L_0x03d0
        L_0x03ce:
            r6 = r29
        L_0x03d0:
            r3 = r28
            int r4 = r3.zzj
        L_0x03d4:
            int r5 = r3.zzk
            if (r4 >= r5) goto L_0x0400
            int[] r5 = r3.zzi
            r5 = r5[r4]
            int[] r8 = r3.zzc
            r8 = r8[r5]
            int r8 = r3.zzv(r5)
            r8 = r8 & r2
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.auth.zzgz.zzf(r6, r8)
            if (r8 != 0) goto L_0x03ed
            goto L_0x03f3
        L_0x03ed:
            com.google.android.gms.internal.auth.zzet r9 = r3.zzx(r5)
            if (r9 != 0) goto L_0x03f6
        L_0x03f3:
            int r4 = r4 + 1
            goto L_0x03d4
        L_0x03f6:
            com.google.android.gms.internal.auth.zzfk r8 = (com.google.android.gms.internal.auth.zzfk) r8
            java.lang.Object r0 = r3.zzz(r5)
            com.google.android.gms.internal.auth.zzfj r0 = (com.google.android.gms.internal.auth.zzfj) r0
            r0 = 0
            throw r0
        L_0x0400:
            if (r7 != 0) goto L_0x040c
            r2 = r32
            if (r0 != r2) goto L_0x0407
            goto L_0x0412
        L_0x0407:
            com.google.android.gms.internal.auth.zzew r0 = com.google.android.gms.internal.auth.zzew.zzd()
            throw r0
        L_0x040c:
            r2 = r32
            if (r0 > r2) goto L_0x0413
            if (r1 != r7) goto L_0x0413
        L_0x0412:
            return r0
        L_0x0413:
            com.google.android.gms.internal.auth.zzew r0 = com.google.android.gms.internal.auth.zzew.zzd()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzft.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzdp):int");
    }

    public final T zzd() {
        return ((zzeq) this.zzg).zzj(4, null, null);
    }

    public final void zze(T t) {
        int i;
        int i2 = this.zzj;
        while (true) {
            i = this.zzk;
            if (i2 >= i) {
                break;
            }
            long zzv = (long) (zzv(this.zzi[i2]) & 1048575);
            Object zzf2 = zzgz.zzf(t, zzv);
            if (zzf2 != null) {
                ((zzfk) zzf2).zzc();
                zzgz.zzp(t, zzv, zzf2);
            }
            i2++;
        }
        int length = this.zzi.length;
        while (i < length) {
            this.zzl.zza(t, (long) this.zzi[i]);
            i++;
        }
        this.zzm.zze(t);
    }

    public final void zzf(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzv = zzv(i);
                long j = (long) (1048575 & zzv);
                int i2 = this.zzc[i];
                switch (zzu(zzv)) {
                    case 0:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzl(t, j, zzgz.zza(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 1:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzm(t, j, zzgz.zzb(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 2:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzo(t, j, zzgz.zzd(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 3:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzo(t, j, zzgz.zzd(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 4:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzn(t, j, zzgz.zzc(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 5:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzo(t, j, zzgz.zzd(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 6:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzn(t, j, zzgz.zzc(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 7:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzk(t, j, zzgz.zzt(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 8:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzp(t, j, zzgz.zzf(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 9:
                        zzB(t, t2, i);
                        break;
                    case 10:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzp(t, j, zzgz.zzf(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 11:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzn(t, j, zzgz.zzc(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 12:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzn(t, j, zzgz.zzc(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 13:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzn(t, j, zzgz.zzc(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 14:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzo(t, j, zzgz.zzd(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 15:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzn(t, j, zzgz.zzc(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 16:
                        if (!zzG(t2, i)) {
                            break;
                        } else {
                            zzgz.zzo(t, j, zzgz.zzd(t2, j));
                            zzD(t, i);
                            break;
                        }
                    case 17:
                        zzB(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzl.zzb(t, t2, j);
                        break;
                    case 50:
                        zzgd.zzi(this.zzp, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zzJ(t2, i2, i)) {
                            break;
                        } else {
                            zzgz.zzp(t, j, zzgz.zzf(t2, j));
                            zzE(t, i2, i);
                            break;
                        }
                    case 60:
                        zzC(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zzJ(t2, i2, i)) {
                            break;
                        } else {
                            zzgz.zzp(t, j, zzgz.zzf(t2, j));
                            zzE(t, i2, i);
                            break;
                        }
                    case 68:
                        zzC(t, t2, i);
                        break;
                }
            }
            zzgd.zzf(this.zzm, t, t2);
            return;
        }
        throw null;
    }

    public final void zzg(T t, byte[] bArr, int i, int i2, zzdp zzdp) throws IOException {
        if (this.zzh) {
            zzo(t, bArr, i, i2, zzdp);
        } else {
            zzb(t, bArr, i, i2, 0, zzdp);
        }
    }

    public final boolean zzh(T t, T t2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzv = zzv(i);
            long j = (long) (zzv & 1048575);
            switch (zzu(zzv)) {
                case 0:
                    if (zzF(t, t2, i) && Double.doubleToLongBits(zzgz.zza(t, j)) == Double.doubleToLongBits(zzgz.zza(t2, j))) {
                        continue;
                    }
                case 1:
                    if (zzF(t, t2, i) && Float.floatToIntBits(zzgz.zzb(t, j)) == Float.floatToIntBits(zzgz.zzb(t2, j))) {
                        continue;
                    }
                case 2:
                    if (zzF(t, t2, i) && zzgz.zzd(t, j) == zzgz.zzd(t2, j)) {
                        continue;
                    }
                case 3:
                    if (zzF(t, t2, i) && zzgz.zzd(t, j) == zzgz.zzd(t2, j)) {
                        continue;
                    }
                case 4:
                    if (zzF(t, t2, i) && zzgz.zzc(t, j) == zzgz.zzc(t2, j)) {
                        continue;
                    }
                case 5:
                    if (zzF(t, t2, i) && zzgz.zzd(t, j) == zzgz.zzd(t2, j)) {
                        continue;
                    }
                case 6:
                    if (zzF(t, t2, i) && zzgz.zzc(t, j) == zzgz.zzc(t2, j)) {
                        continue;
                    }
                case 7:
                    if (zzF(t, t2, i) && zzgz.zzt(t, j) == zzgz.zzt(t2, j)) {
                        continue;
                    }
                case 8:
                    if (zzF(t, t2, i) && zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
                        continue;
                    }
                case 9:
                    if (zzF(t, t2, i) && zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
                        continue;
                    }
                case 10:
                    if (zzF(t, t2, i) && zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
                        continue;
                    }
                case 11:
                    if (zzF(t, t2, i) && zzgz.zzc(t, j) == zzgz.zzc(t2, j)) {
                        continue;
                    }
                case 12:
                    if (zzF(t, t2, i) && zzgz.zzc(t, j) == zzgz.zzc(t2, j)) {
                        continue;
                    }
                case 13:
                    if (zzF(t, t2, i) && zzgz.zzc(t, j) == zzgz.zzc(t2, j)) {
                        continue;
                    }
                case 14:
                    if (zzF(t, t2, i) && zzgz.zzd(t, j) == zzgz.zzd(t2, j)) {
                        continue;
                    }
                case 15:
                    if (zzF(t, t2, i) && zzgz.zzc(t, j) == zzgz.zzc(t2, j)) {
                        continue;
                    }
                case 16:
                    if (zzF(t, t2, i) && zzgz.zzd(t, j) == zzgz.zzd(t2, j)) {
                        continue;
                    }
                case 17:
                    if (zzF(t, t2, i) && zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j));
                    break;
                case 50:
                    z = zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzs = (long) (zzs(i) & 1048575);
                    if (zzgz.zzc(t, zzs) == zzgz.zzc(t2, zzs) && zzgd.zzh(zzgz.zzf(t, j), zzgz.zzf(t2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzm.zza(t).equals(this.zzm.zza(t2))) {
            return false;
        }
        return true;
    }

    public final boolean zzi(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzj) {
            int i6 = this.zzi[i5];
            int i7 = this.zzc[i6];
            int zzv = zzv(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzv) != 0 && !zzH(t, i6, i2, i, i10)) {
                return false;
            }
            int zzu = zzu(zzv);
            if (zzu != 9 && zzu != 17) {
                if (zzu != 27) {
                    if (zzu == 60 || zzu == 68) {
                        if (zzJ(t2, i7, i6) && !zzI(t2, zzv, zzy(i6))) {
                            return false;
                        }
                    } else if (zzu != 49) {
                        if (zzu == 50 && !((zzfk) zzgz.zzf(t2, (long) (zzv & 1048575))).isEmpty()) {
                            zzfj zzfj = (zzfj) zzz(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzgz.zzf(t2, (long) (zzv & 1048575));
                if (!list.isEmpty()) {
                    zzgb zzy = zzy(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzy.zzi(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzH(t, i6, i2, i, i10) && !zzI(t2, zzv, zzy(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        return true;
    }
}
