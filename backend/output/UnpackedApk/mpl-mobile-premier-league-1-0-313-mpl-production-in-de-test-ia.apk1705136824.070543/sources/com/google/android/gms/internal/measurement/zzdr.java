package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzdr extends zzdt {
    public final /* synthetic */ Long zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ Bundle zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ boolean zzf;
    public final /* synthetic */ zzee zzg;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzdr(zzee zzee, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        // this.zzg = zzee;
        // this.zza = l;
        // this.zzb = str;
        // this.zzc = str2;
        // this.zzd = bundle;
        // this.zze = z;
        // this.zzf = z2;
        super(zzee, true);
    }

    public final void zza() throws RemoteException {
        long j;
        Long l = this.zza;
        if (l == null) {
            j = this.zzh;
        } else {
            j = l.longValue();
        }
        long j2 = j;
        zzcc zze2 = this.zzg.zzj;
        Preconditions.checkNotNull(zze2);
        zze2.logEvent(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, j2);
    }
}
