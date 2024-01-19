package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzlf {
    public static final zzle zza;
    public static final zzle zzb = new zzle();

    static {
        zzle zzle;
        try {
            zzle = (zzle) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzle = null;
        }
        zza = zzle;
    }

    public static zzle zza() {
        return zza;
    }

    public static zzle zzb() {
        return zzb;
    }
}
