package com.google.android.gms.internal.measurement;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzbi extends zzaw {
    public zzbi() {
        this.zza.add(zzbl.ADD);
        this.zza.add(zzbl.DIVIDE);
        this.zza.add(zzbl.MODULUS);
        this.zza.add(zzbl.MULTIPLY);
        this.zza.add(zzbl.NEGATE);
        this.zza.add(zzbl.POST_DECREMENT);
        this.zza.add(zzbl.POST_INCREMENT);
        this.zza.add(zzbl.PRE_DECREMENT);
        this.zza.add(zzbl.PRE_INCREMENT);
        this.zza.add(zzbl.SUBTRACT);
    }

    public final zzap zza(String str, zzg zzg, List list) {
        zzap zzap;
        zzbl zzbl = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 0) {
            zzap zzb = zzg.zzb((zzap) GeneratedOutlineSupport.outline27(zzbl.ADD, 2, list, 0));
            zzap zzb2 = zzg.zzb((zzap) list.get(1));
            if ((zzb instanceof zzal) || (zzb instanceof zzat) || (zzb2 instanceof zzal) || (zzb2 instanceof zzat)) {
                zzap = new zzat(String.valueOf(zzb.zzi()).concat(String.valueOf(zzb2.zzi())));
            } else {
                zzap = new zzah(Double.valueOf(zzb2.zzh().doubleValue() + zzb.zzh().doubleValue()));
            }
            return zzap;
        } else if (ordinal == 21) {
            return new zzah(Double.valueOf(zzg.zzb((zzap) GeneratedOutlineSupport.outline27(zzbl.DIVIDE, 2, list, 0)).zzh().doubleValue() / zzg.zzb((zzap) list.get(1)).zzh().doubleValue()));
        } else {
            if (ordinal == 59) {
                zzap zzb3 = zzg.zzb((zzap) GeneratedOutlineSupport.outline27(zzbl.SUBTRACT, 2, list, 0));
                zzah zzah = new zzah(Double.valueOf(-zzg.zzb((zzap) list.get(1)).zzh().doubleValue()));
                return new zzah(Double.valueOf(zzah.zzh().doubleValue() + zzb3.zzh().doubleValue()));
            } else if (ordinal == 52 || ordinal == 53) {
                zzh.zzh(str, 2, list);
                zzap zzb4 = zzg.zzb((zzap) list.get(0));
                zzg.zzb((zzap) list.get(1));
                return zzb4;
            } else if (ordinal == 55 || ordinal == 56) {
                zzh.zzh(str, 1, list);
                return zzg.zzb((zzap) list.get(0));
            } else {
                switch (ordinal) {
                    case 44:
                        return new zzah(Double.valueOf(zzg.zzb((zzap) GeneratedOutlineSupport.outline27(zzbl.MODULUS, 2, list, 0)).zzh().doubleValue() % zzg.zzb((zzap) list.get(1)).zzh().doubleValue()));
                    case 45:
                        return new zzah(Double.valueOf(zzg.zzb((zzap) GeneratedOutlineSupport.outline27(zzbl.MULTIPLY, 2, list, 0)).zzh().doubleValue() * zzg.zzb((zzap) list.get(1)).zzh().doubleValue()));
                    case 46:
                        return new zzah(Double.valueOf(-zzg.zzb((zzap) GeneratedOutlineSupport.outline27(zzbl.NEGATE, 1, list, 0)).zzh().doubleValue()));
                    default:
                        return super.zzb(str);
                }
            }
        }
    }
}
