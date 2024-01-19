package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzio;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzb extends zzd {
    public final zzio zza;

    public zzb(zzio zzio) {
        Preconditions.checkNotNull(zzio);
        this.zza = zzio;
    }

    public final int zza(String str) {
        return this.zza.zza(str);
    }

    public final long zzb() {
        return this.zza.zzb();
    }

    public final String zzh() {
        return this.zza.zzh();
    }

    public final String zzi() {
        return this.zza.zzi();
    }

    public final String zzj() {
        return this.zza.zzj();
    }

    public final String zzk() {
        return this.zza.zzk();
    }

    public final List zzm(String str, String str2) {
        return this.zza.zzm(str, str2);
    }

    public final Map zzo(String str, String str2, boolean z) {
        return this.zza.zzo(str, str2, z);
    }

    public final void zzp(String str) {
        this.zza.zzp(str);
    }

    public final void zzq(String str, String str2, Bundle bundle) {
        this.zza.zzq(str, str2, bundle);
    }

    public final void zzr(String str) {
        this.zza.zzr(str);
    }

    public final void zzs(String str, String str2, Bundle bundle) {
        this.zza.zzs(str, str2, bundle);
    }

    public final void zzv(Bundle bundle) {
        this.zza.zzv(bundle);
    }
}
