package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjy;
import com.google.android.gms.internal.measurement.zzkc;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public abstract class zzkc<MessageType extends zzkc<MessageType, BuilderType>, BuilderType extends zzjy<MessageType, BuilderType>> extends zzil<MessageType, BuilderType> {
    public static final Map zza = new ConcurrentHashMap();
    public zzmm zzc = zzmm.zzc();
    public int zzd = -1;

    public static zzkc zzbC(Class cls) {
        zzkc zzkc = (zzkc) zza.get(cls);
        if (zzkc == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzkc = (zzkc) zza.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzkc == null) {
            zzkc = (zzkc) ((zzkc) zzmv.zze(cls)).zzl(6, null, null);
            if (zzkc != null) {
                zza.put(cls, zzkc);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzkc;
    }

    public static zzkh zzbD() {
        return zzkd.zzf();
    }

    public static zzki zzbE() {
        return zzky.zzf();
    }

    public static zzki zzbF(zzki zzki) {
        int size = zzki.size();
        return zzki.zze(size == 0 ? 10 : size + size);
    }

    public static zzkj zzbG() {
        return zzls.zze();
    }

    public static zzkj zzbH(zzkj zzkj) {
        int size = zzkj.size();
        return zzkj.zzd(size == 0 ? 10 : size + size);
    }

    public static Object zzbK(Method method, Object obj, Object... objArr) {
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

    public static Object zzbL(zzlj zzlj, String str, Object[] objArr) {
        return new zzlt(zzlj, str, objArr);
    }

    public static void zzbM(Class cls, zzkc zzkc) {
        zza.put(cls, zzkc);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzlr.zza().zzb(getClass()).zzj(this, (zzkc) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int zzb = zzlr.zza().zzb(getClass()).zzb(this);
        this.zzb = zzb;
        return zzb;
    }

    public final String toString() {
        return zzll.zza(this, super.toString());
    }

    public final zzjy zzbA() {
        return (zzjy) zzl(5, null, null);
    }

    public final zzjy zzbB() {
        zzjy zzjy = (zzjy) zzl(5, null, null);
        zzjy.zzaC(this);
        return zzjy;
    }

    public final /* synthetic */ zzli zzbI() {
        return (zzjy) zzl(5, null, null);
    }

    public final /* synthetic */ zzli zzbJ() {
        zzjy zzjy = (zzjy) zzl(5, null, null);
        zzjy.zzaC(this);
        return zzjy;
    }

    public final void zzbN(zzjj zzjj) throws IOException {
        zzlr.zza().zzb(getClass()).zzi(this, zzjk.zza(zzjj));
    }

    public final /* synthetic */ zzlj zzbR() {
        return (zzkc) zzl(6, null, null);
    }

    public final int zzbu() {
        return this.zzd;
    }

    public final void zzbx(int i) {
        this.zzd = i;
    }

    public final int zzbz() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int zza2 = zzlr.zza().zzb(getClass()).zza(this);
        this.zzd = zza2;
        return zza2;
    }

    public abstract Object zzl(int i, Object obj, Object obj2);
}
