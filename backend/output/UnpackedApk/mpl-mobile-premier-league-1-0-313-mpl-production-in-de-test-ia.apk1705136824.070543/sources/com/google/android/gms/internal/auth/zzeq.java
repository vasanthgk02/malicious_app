package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzeo;
import com.google.android.gms.internal.auth.zzeq;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public abstract class zzeq<MessageType extends zzeq<MessageType, BuilderType>, BuilderType extends zzeo<MessageType, BuilderType>> extends zzdm<MessageType, BuilderType> {
    public static final Map<Object, zzeq<?, ?>> zzb = new ConcurrentHashMap();
    public zzgq zzc = zzgq.zza();

    public static <T extends zzeq> T zza(Class<T> cls) {
        T t = (zzeq) zzb.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzeq) zzb.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = (zzeq) ((zzeq) zzgz.zze(cls)).zzj(6, null, null);
            if (t != null) {
                zzb.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    public static <T extends zzeq<T, ?>> T zzb(T t, byte[] bArr) throws zzew {
        boolean z = false;
        T zzc2 = zzc(t, bArr, 0, bArr.length, zzeg.zza());
        if (zzc2 != null) {
            byte byteValue = ((Byte) zzc2.zzj(1, null, null)).byteValue();
            if (byteValue == 1) {
                z = true;
            } else if (byteValue != 0) {
                z = zzfy.zza().zzb(zzc2.getClass()).zzi(zzc2);
                zzc2.zzj(2, true != z ? null : zzc2, null);
            }
            if (!z) {
                zzew zzew = new zzew(new zzgo(zzc2).getMessage());
                zzew.zze(zzc2);
                throw zzew;
            }
        }
        return zzc2;
    }

    public static <T extends zzeq<T, ?>> T zzc(T t, byte[] bArr, int i, int i2, zzeg zzeg) throws zzew {
        T t2 = (zzeq) t.zzj(4, null, null);
        try {
            zzgb<?> zzb2 = zzfy.zza().zzb(t2.getClass());
            zzb2.zzg(t2, bArr, 0, i2, new zzdp(zzeg));
            zzb2.zze(t2);
            if (t2.zza == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (zzew e2) {
            e2.zze(t2);
            throw e2;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzew) {
                throw ((zzew) e3.getCause());
            }
            zzew zzew = new zzew(e3);
            zzew.zze(t2);
            throw zzew;
        } catch (IndexOutOfBoundsException unused) {
            zzew zzf = zzew.zzf();
            zzf.zze(t2);
            throw zzf;
        }
    }

    public static <E> zzeu<E> zzd() {
        return zzfz.zze();
    }

    public static Object zzf(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static Object zzg(zzfq zzfq, String str, Object[] objArr) {
        return new zzga(zzfq, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", objArr);
    }

    public static <T extends zzeq> void zzi(Class<T> cls, T t) {
        zzb.put(cls, t);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzfy.zza().zzb(getClass()).zzh(this, (zzeq) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zza = zzfy.zza().zzb(getClass()).zza(this);
        this.zza = zza;
        return zza;
    }

    public final String toString() {
        return zzfs.zza(this, super.toString());
    }

    public final /* bridge */ /* synthetic */ zzfp zze() {
        zzeo zzeo = (zzeo) zzj(5, null, null);
        zzeo.zze(this);
        return zzeo;
    }

    public final /* bridge */ /* synthetic */ zzfq zzh() {
        return (zzeq) zzj(6, null, null);
    }

    public abstract Object zzj(int i, Object obj, Object obj2);
}
