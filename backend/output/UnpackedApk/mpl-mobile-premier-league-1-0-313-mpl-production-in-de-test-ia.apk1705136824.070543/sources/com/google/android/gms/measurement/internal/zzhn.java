package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final /* synthetic */ class zzhn implements Runnable {
    public final /* synthetic */ zzin zza;
    public final /* synthetic */ Bundle zzb;

    public /* synthetic */ zzhn(zzin zzin, Bundle bundle) {
        this.zza = zzin;
        this.zzb = bundle;
    }

    public final void run() {
        zzin zzin = this.zza;
        Bundle bundle = this.zzb;
        if (bundle == null) {
            zzin.zzs.zzm().zzr.zzb(new Bundle());
            return;
        }
        Bundle zza2 = zzin.zzs.zzm().zzr.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (zzin.zzs.zzv().zzaf(obj)) {
                    zzin.zzs.zzv().zzN(zzin.zzn, null, 27, null, null, 0);
                }
                zzin.zzs.zzaz().zzi.zzc("Invalid default event parameter type. Name, value", str, obj);
            } else if (zzlp.zzah(str)) {
                zzin.zzs.zzaz().zzi.zzb("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                zza2.remove(str);
            } else {
                zzlp zzv = zzin.zzs.zzv();
                zzaf zzaf = zzin.zzs.zzk;
                if (zzv.zzaa("param", str, 100, obj)) {
                    zzin.zzs.zzv().zzO(zza2, str, obj);
                }
            }
        }
        zzin.zzs.zzv();
        int zzc = zzin.zzs.zzk.zzc();
        if (zza2.size() > zzc) {
            Iterator it = new TreeSet(zza2.keySet()).iterator();
            int i = 0;
            while (it.hasNext()) {
                String str2 = (String) it.next();
                i++;
                if (i > zzc) {
                    zza2.remove(str2);
                }
            }
            zzin.zzs.zzv().zzN(zzin.zzn, null, 26, null, null, 0);
            zzin.zzs.zzaz().zzi.zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        zzin.zzs.zzm().zzr.zzb(zza2);
        zzkb zzt = zzin.zzs.zzt();
        zzt.zzg();
        zzt.zza();
        zzt.zzR(new zzjk(zzt, zzt.zzO(false), zza2));
    }
}
