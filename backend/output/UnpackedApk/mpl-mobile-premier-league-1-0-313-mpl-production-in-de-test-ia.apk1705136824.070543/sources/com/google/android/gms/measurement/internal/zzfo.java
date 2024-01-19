package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbr;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfo implements Runnable {
    public final /* synthetic */ zzbr zza;
    public final /* synthetic */ ServiceConnection zzb;
    public final /* synthetic */ zzfp zzc;

    public zzfo(zzfp zzfp, zzbr zzbr, ServiceConnection serviceConnection) {
        this.zzc = zzfp;
        this.zza = zzbr;
        this.zzb = serviceConnection;
    }

    public final void run() {
        zzfp zzfp = this.zzc;
        zzfq zzfq = zzfp.zza;
        String str = zzfp.zzb;
        zzbr zzbr = this.zza;
        zzfq.zza.zzaA().zzg();
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            if (zzbr.zzd(bundle) == null) {
                zzfq.zza.zzaz().zzd.zza("Install Referrer Service returned a null response");
            }
        } catch (Exception e2) {
            zzfq.zza.zzaz().zzd.zzb("Exception occurred while retrieving the Install Referrer", e2.getMessage());
        }
        zzfq.zza.zzaA().zzg();
        zzgi.zzO();
        throw null;
    }
}
