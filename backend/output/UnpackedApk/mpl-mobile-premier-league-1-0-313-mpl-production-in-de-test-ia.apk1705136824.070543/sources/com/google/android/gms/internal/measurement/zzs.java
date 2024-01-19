package com.google.android.gms.internal.measurement;

import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzs extends zzai {
    public final boolean zza;
    public final boolean zzb;
    public final /* synthetic */ zzt zzc;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzs(zzt zzt, boolean z, boolean z2) {
        // this.zzc = zzt;
        super(AnalyticsConstants.LOG);
        this.zza = z;
        this.zzb = z2;
    }

    public final zzap zza(zzg zzg, List list) {
        zzh.zzi(AnalyticsConstants.LOG, 1, list);
        if (list.size() == 1) {
            this.zzc.zza.zza(3, zzg.zzb((zzap) list.get(0)).zzi(), Collections.emptyList(), this.zza, this.zzb);
            return zzap.zzf;
        }
        int zzb2 = zzh.zzb(zzg.zzb((zzap) list.get(0)).zzh().doubleValue());
        int i = zzb2 != 2 ? zzb2 != 3 ? zzb2 != 5 ? zzb2 != 6 ? 3 : 2 : 5 : 1 : 4;
        String zzi = zzg.zzb((zzap) list.get(1)).zzi();
        if (list.size() == 2) {
            this.zzc.zza.zza(i, zzi, Collections.emptyList(), this.zza, this.zzb);
            return zzap.zzf;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 2; i2 < Math.min(list.size(), 5); i2++) {
            arrayList.add(zzg.zzb((zzap) list.get(i2)).zzi());
        }
        this.zzc.zza.zza(i, zzi, arrayList, this.zza, this.zzb);
        return zzap.zzf;
    }
}
