package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzjx implements zzlh {
    public static final zzjx zza = new zzjx();

    public static zzjx zza() {
        return zza;
    }

    public final zzlg zzb(Class cls) {
        Class<zzkc> cls2 = zzkc.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (zzlg) zzkc.zzbC(cls.asSubclass(cls2)).zzl(3, null, null);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e2);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }

    public final boolean zzc(Class cls) {
        return zzkc.class.isAssignableFrom(cls);
    }
}
