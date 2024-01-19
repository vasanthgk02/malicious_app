package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzlb implements Callable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ zzli zzb;

    public zzlb(zzli zzli, zzp zzp) {
        this.zzb = zzli;
        this.zza = zzp;
    }

    public final Object call() throws Exception {
        zzli zzli = this.zzb;
        String str = this.zza.zza;
        Preconditions.checkNotNull(str);
        if (zzli.zzh(str).zzi(zzag.ANALYTICS_STORAGE) && zzah.zzb(this.zza.zzv).zzi(zzag.ANALYTICS_STORAGE)) {
            return this.zzb.zzd(this.zza).zzu();
        }
        this.zzb.zzaz().zzl.zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
