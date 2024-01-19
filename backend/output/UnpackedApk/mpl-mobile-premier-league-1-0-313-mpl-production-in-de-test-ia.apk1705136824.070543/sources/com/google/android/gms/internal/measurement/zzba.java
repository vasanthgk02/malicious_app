package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzba implements Comparator {
    public final /* synthetic */ zzai zza;
    public final /* synthetic */ zzg zzb;

    public zzba(zzai zzai, zzg zzg) {
        this.zza = zzai;
        this.zzb = zzg;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzap zzap = (zzap) obj;
        zzap zzap2 = (zzap) obj2;
        zzai zzai = this.zza;
        zzg zzg = this.zzb;
        int i = 1;
        if (zzap instanceof zzau) {
            if (!(zzap2 instanceof zzau)) {
                return i;
            }
            return 0;
        } else if (zzap2 instanceof zzau) {
            i = -1;
        } else if (zzai == null) {
            i = zzap.zzi().compareTo(zzap2.zzi());
        } else {
            i = (int) zzh.zza(zzai.zza(zzg, Arrays.asList(new zzap[]{zzap, zzap2})).zzh().doubleValue());
        }
        return i;
    }
}
