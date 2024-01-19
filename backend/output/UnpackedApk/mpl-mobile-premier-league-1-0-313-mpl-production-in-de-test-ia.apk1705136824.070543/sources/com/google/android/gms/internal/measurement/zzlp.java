package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzlp {
    public static final zzlo zza;
    public static final zzlo zzb = new zzlo();

    static {
        zzlo zzlo;
        try {
            zzlo = (zzlo) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzlo = null;
        }
        zza = zzlo;
    }

    public static zzlo zza() {
        return zza;
    }

    public static zzlo zzb() {
        return zzb;
    }
}
