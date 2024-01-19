package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzgd {
    public static final Class<?> zza;
    public static final zzgp<?, ?> zzb = zzj(false);
    public static final zzgp<?, ?> zzc = zzj(true);
    public static final zzgp<?, ?> zzd = new zzgr();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzgp<?, ?> zza() {
        return zzb;
    }

    public static zzgp<?, ?> zzb() {
        return zzc;
    }

    public static zzgp<?, ?> zzc() {
        return zzd;
    }

    public static <UT, UB> UB zzd(int i, List<Integer> list, zzet zzet, UB ub, zzgp<UT, UB> zzgp) {
        if (zzet == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzet.zza()) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = zze(i, intValue, ub, zzgp);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return ub;
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzet.zza()) {
                    ub = zze(i, intValue2, ub, zzgp);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static <UT, UB> UB zze(int i, int i2, UB ub, zzgp<UT, UB> zzgp) {
        if (ub == null) {
            ub = zzgp.zzc();
        }
        zzgp.zzd(ub, i, (long) i2);
        return ub;
    }

    public static <T, UT, UB> void zzf(zzgp<UT, UB> zzgp, T t, T t2) {
        zzgp.zzf(t, zzgp.zzb(zzgp.zza(t), zzgp.zza(t2)));
    }

    public static void zzg(Class<?> cls) {
        if (!zzeq.class.isAssignableFrom(cls)) {
            Class<?> cls2 = zza;
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    public static boolean zzh(Object obj, Object obj2) {
        boolean z = false;
        if (obj != obj2) {
            if (obj != null) {
                if (!obj.equals(obj2)) {
                    return false;
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    public static <T> void zzi(zzfl zzfl, T t, T t2, long j) {
        zzgz.zzp(t, j, zzfl.zza(zzgz.zzf(t, j), zzgz.zzf(t2, j)));
    }

    public static zzgp<?, ?> zzj(boolean z) {
        Class cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzgp) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }
}
