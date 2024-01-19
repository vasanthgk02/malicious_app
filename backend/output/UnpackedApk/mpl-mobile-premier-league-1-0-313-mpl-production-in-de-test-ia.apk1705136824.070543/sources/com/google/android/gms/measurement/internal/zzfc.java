package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfc implements Runnable {
    public final zzfa zza;
    public final int zzb;
    public final Throwable zzc;
    public final byte[] zzd;
    public final String zze;
    public final Map zzf;

    public /* synthetic */ zzfc(String str, zzfa zzfa, int i, Throwable th, byte[] bArr, Map map) {
        Preconditions.checkNotNull(zzfa);
        this.zza = zzfa;
        this.zzb = i;
        this.zzc = th;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = map;
    }

    public final void run() {
        this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
