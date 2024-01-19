package com.google.android.gms.measurement.internal;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzkg implements Runnable {
    public final /* synthetic */ zzli zza;
    public final /* synthetic */ Runnable zzb;

    public zzkg(zzli zzli, Runnable runnable) {
        this.zza = zzli;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzA();
        zzli zzli = this.zza;
        Runnable runnable = this.zzb;
        zzli.zzaA().zzg();
        if (zzli.zzq == null) {
            zzli.zzq = new ArrayList();
        }
        zzli.zzq.add(runnable);
        this.zza.zzW();
    }
}
