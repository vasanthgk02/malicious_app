package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzr;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfx implements zzr {
    public final /* synthetic */ zzfz zza;

    public zzfx(zzfz zzfz) {
        this.zza = zzfz;
    }

    public final void zza(int i, String str, List list, boolean z, boolean z2) {
        zzew zzew;
        int i2 = i - 1;
        if (i2 == 0) {
            zzew = this.zza.zzs.zzaz().zzk;
        } else if (i2 != 1) {
            if (i2 == 3) {
                zzew = this.zza.zzs.zzaz().zzl;
            } else if (i2 != 4) {
                zzew = this.zza.zzs.zzaz().zzj;
            } else if (z) {
                zzew = this.zza.zzs.zzaz().zzh;
            } else if (!z2) {
                zzew = this.zza.zzs.zzaz().zzi;
            } else {
                zzew = this.zza.zzs.zzaz().zzg;
            }
        } else if (z) {
            zzew = this.zza.zzs.zzaz().zze;
        } else if (!z2) {
            zzew = this.zza.zzs.zzaz().zzf;
        } else {
            zzew = this.zza.zzs.zzaz().zzd;
        }
        int size = list.size();
        if (size == 1) {
            zzew.zzb(str, list.get(0));
        } else if (size == 2) {
            zzew.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzew.zza(str);
        } else {
            zzew.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
