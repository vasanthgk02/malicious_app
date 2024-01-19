package com.google.android.gms.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class zzx {
    public static final zzx zze = new zzx(true, 3, null, null);
    public final boolean zza;
    public final String zzb;
    public final Throwable zzc;

    public zzx(boolean z, int i, String str, Throwable th) {
        this.zza = z;
        this.zzb = str;
        this.zzc = th;
    }

    public static zzx zzc(String str) {
        return new zzx(false, 1, str, null);
    }

    public static zzx zzd(String str, Throwable th) {
        return new zzx(false, 1, str, th);
    }

    public String zza() {
        return this.zzb;
    }
}
