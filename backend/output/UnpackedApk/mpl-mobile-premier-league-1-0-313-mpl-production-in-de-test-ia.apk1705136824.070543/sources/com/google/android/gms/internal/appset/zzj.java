package com.google.android.gms.internal.appset;

import com.google.android.gms.common.util.DefaultClock;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
public final class zzj implements Runnable {
    public final /* synthetic */ zzl zza;

    public /* synthetic */ zzj(zzl zzl, zzi zzi) {
        this.zza = zzl;
    }

    public final void run() {
        long zza2 = this.zza.zza();
        if (zza2 != -1 && DefaultClock.zza.currentTimeMillis() > zza2) {
            zzl.zze(this.zza.zzb);
        }
    }
}
