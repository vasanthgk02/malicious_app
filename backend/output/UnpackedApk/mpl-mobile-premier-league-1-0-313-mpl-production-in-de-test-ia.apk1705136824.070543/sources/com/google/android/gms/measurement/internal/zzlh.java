package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzlh {
    public final String zza;
    public long zzb;

    public zzlh(zzli zzli) {
        this.zza = zzli.zzv().zzC();
        this.zzb = zzli.zzaw().elapsedRealtime();
    }

    public zzlh(zzli zzli, String str, zzlg zzlg) {
        this.zza = str;
        this.zzb = zzli.zzaw().elapsedRealtime();
    }
}
