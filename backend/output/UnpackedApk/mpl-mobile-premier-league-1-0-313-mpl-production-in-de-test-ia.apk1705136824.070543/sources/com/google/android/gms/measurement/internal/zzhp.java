package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final /* synthetic */ class zzhp implements Runnable {
    public final /* synthetic */ zzin zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzhp(zzin zzin, String str) {
        this.zza = zzin;
        this.zzb = str;
    }

    public final void run() {
        zzin zzin = this.zza;
        String str = this.zzb;
        zzep zzh = zzin.zzs.zzh();
        String str2 = zzh.zzo;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        zzh.zzo = str;
        if (z) {
            zzin.zzs.zzh().zzo();
        }
    }
}
