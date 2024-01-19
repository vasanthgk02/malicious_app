package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzlc implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb = "_err";
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ zzld zzd;

    public zzlc(zzld zzld, String str, Bundle bundle) {
        this.zzd = zzld;
        this.zza = str;
        this.zzc = bundle;
    }

    public final void run() {
        zzav zzz = this.zzd.zza.zzv().zzz(this.zza, this.zzb, this.zzc, "auto", this.zzd.zza.zzaw().currentTimeMillis(), false, true);
        zzli zzli = this.zzd.zza;
        Preconditions.checkNotNull(zzz);
        zzli.zzE(zzz, this.zza);
    }
}
