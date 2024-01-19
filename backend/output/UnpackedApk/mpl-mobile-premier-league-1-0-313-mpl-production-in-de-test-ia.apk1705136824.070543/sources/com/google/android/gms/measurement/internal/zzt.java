package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgj;
import com.google.android.gms.internal.measurement.zzoi;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzt {
    public final /* synthetic */ zzz zza;
    public String zzb;
    public boolean zzc;
    public zzgh zzd;
    public BitSet zze;
    public BitSet zzf;
    public Map zzg;
    public Map zzh;

    public /* synthetic */ zzt(zzz zzz, String str) {
        this.zza = zzz;
        this.zzb = str;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
    }

    public final zzfo zza(int i) {
        ArrayList arrayList;
        Iterable iterable;
        zzfn zzb2 = zzfo.zzb();
        zzb2.zza(i);
        zzb2.zzc(this.zzc);
        zzgh zzgh = this.zzd;
        if (zzgh != null) {
            zzb2.zzd(zzgh);
        }
        zzgg zzf2 = zzgh.zzf();
        zzf2.zzb(zzlk.zzr(this.zze));
        zzf2.zzd(zzlk.zzr(this.zzf));
        Map map = this.zzg;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer intValue : this.zzg.keySet()) {
                int intValue2 = intValue.intValue();
                Long l = (Long) this.zzg.get(Integer.valueOf(intValue2));
                if (l != null) {
                    zzfp zzc2 = zzfq.zzc();
                    zzc2.zzb(intValue2);
                    zzc2.zza(l.longValue());
                    arrayList2.add((zzfq) zzc2.zzaE());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzf2.zza(arrayList);
        }
        Map map2 = this.zzh;
        if (map2 == null) {
            iterable = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num : this.zzh.keySet()) {
                zzgi zzd2 = zzgj.zzd();
                zzd2.zzb(num.intValue());
                List list = (List) this.zzh.get(num);
                if (list != null) {
                    Collections.sort(list);
                    zzd2.zza(list);
                }
                arrayList3.add((zzgj) zzd2.zzaE());
            }
            iterable = arrayList3;
        }
        zzf2.zzc(iterable);
        zzb2.zzb(zzf2);
        return (zzfo) zzb2.zzaE();
    }

    public final void zzc(zzx zzx) {
        int zza2 = zzx.zza();
        Boolean bool = zzx.zzd;
        if (bool != null) {
            this.zzf.set(zza2, bool.booleanValue());
        }
        Boolean bool2 = zzx.zze;
        if (bool2 != null) {
            this.zze.set(zza2, bool2.booleanValue());
        }
        if (zzx.zzf != null) {
            Map map = this.zzg;
            Integer valueOf = Integer.valueOf(zza2);
            Long l = (Long) map.get(valueOf);
            long longValue = zzx.zzf.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzg.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (zzx.zzg != null) {
            Map map2 = this.zzh;
            Integer valueOf2 = Integer.valueOf(zza2);
            List list = (List) map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.zzh.put(valueOf2, list);
            }
            if (zzx.zzc()) {
                list.clear();
            }
            zzoi.zzc();
            if (this.zza.zzs.zzk.zzs(this.zzb, zzel.zzX) && zzx.zzb()) {
                list.clear();
            }
            zzoi.zzc();
            if (this.zza.zzs.zzk.zzs(this.zzb, zzel.zzX)) {
                Long valueOf3 = Long.valueOf(zzx.zzg.longValue() / 1000);
                if (!list.contains(valueOf3)) {
                    list.add(valueOf3);
                }
            } else {
                list.add(Long.valueOf(zzx.zzg.longValue() / 1000));
            }
        }
    }

    public /* synthetic */ zzt(zzz zzz, String str, zzgh zzgh, BitSet bitSet, BitSet bitSet2, Map map, Map map2) {
        this.zza = zzz;
        this.zzb = str;
        this.zze = bitSet;
        this.zzf = bitSet2;
        this.zzg = map;
        this.zzh = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.zzh.put(num, arrayList);
        }
        this.zzc = false;
        this.zzd = zzgh;
    }
}
