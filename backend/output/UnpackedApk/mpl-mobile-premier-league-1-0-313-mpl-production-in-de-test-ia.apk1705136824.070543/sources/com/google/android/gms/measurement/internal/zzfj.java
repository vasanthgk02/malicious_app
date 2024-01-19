package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzfj {
    public final /* synthetic */ zzfn zza;
    public final String zzb;
    public final long zzc;
    public boolean zzd;
    public long zze;

    public zzfj(zzfn zzfn, String str, long j) {
        this.zza = zzfn;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = j;
    }

    public final long zza() {
        if (!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.zza().getLong(this.zzb, this.zzc);
        }
        return this.zze;
    }

    public final void zzb(long j) {
        Editor edit = this.zza.zza().edit();
        edit.putLong(this.zzb, j);
        edit.apply();
        this.zze = j;
    }
}
