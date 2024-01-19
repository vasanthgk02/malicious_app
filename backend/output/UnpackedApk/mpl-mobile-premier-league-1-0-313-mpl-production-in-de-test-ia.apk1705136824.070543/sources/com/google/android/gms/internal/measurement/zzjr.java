package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzjr {
    public static final zzjp zza = new zzjq();
    public static final zzjp zzb;

    static {
        zzjp zzjp;
        try {
            zzjp = (zzjp) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzjp = null;
        }
        zzb = zzjp;
    }

    public static zzjp zza() {
        zzjp zzjp = zzb;
        if (zzjp != null) {
            return zzjp;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzjp zzb() {
        return zza;
    }
}
