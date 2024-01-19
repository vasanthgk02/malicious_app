package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzao extends zzai implements zzal {
    public final List zza;
    public final List zzb;
    public zzg zzc;

    public zzao(zzao zzao) {
        super(zzao.zzd);
        ArrayList arrayList = new ArrayList(zzao.zza.size());
        this.zza = arrayList;
        arrayList.addAll(zzao.zza);
        ArrayList arrayList2 = new ArrayList(zzao.zzb.size());
        this.zzb = arrayList2;
        arrayList2.addAll(zzao.zzb);
        this.zzc = zzao.zzc;
    }

    public final zzap zza(zzg zzg, List list) {
        zzg zza2 = this.zzc.zza();
        for (int i = 0; i < this.zza.size(); i++) {
            if (i < list.size()) {
                zza2.zze((String) this.zza.get(i), zzg.zzb((zzap) list.get(i)));
            } else {
                zza2.zze((String) this.zza.get(i), zzap.zzf);
            }
        }
        for (zzap zzap : this.zzb) {
            zzap zzb2 = zza2.zzb(zzap);
            if (zzb2 instanceof zzaq) {
                zzb2 = zza2.zzb(zzap);
            }
            if (zzb2 instanceof zzag) {
                return ((zzag) zzb2).zzb();
            }
        }
        return zzap.zzf;
    }

    public final zzap zzd() {
        return new zzao(this);
    }

    public zzao(String str, List<zzap> list, List list2, zzg zzg) {
        super(str);
        this.zza = new ArrayList();
        this.zzc = zzg;
        if (!list.isEmpty()) {
            for (zzap zzi : list) {
                this.zza.add(zzi.zzi());
            }
        }
        this.zzb = new ArrayList(list2);
    }
}
