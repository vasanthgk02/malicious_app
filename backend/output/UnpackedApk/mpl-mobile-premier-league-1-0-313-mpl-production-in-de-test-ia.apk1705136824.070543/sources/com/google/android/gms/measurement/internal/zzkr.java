package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzby;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzkr extends zzf {
    public final zzkq zza = new zzkq(this);
    public final zzkp zzb = new zzkp(this);
    public final zzkn zzc = new zzkn(this);
    public Handler zzd;

    public zzkr(zzgi zzgi) {
        super(zzgi);
    }

    public final boolean zzf() {
        return false;
    }

    public final void zzm() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new zzby(Looper.getMainLooper());
        }
    }
}
