package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzgt implements Runnable {
    public final /* synthetic */ zzav zza;
    public final /* synthetic */ zzp zzb;
    public final /* synthetic */ zzha zzc;

    public zzgt(zzha zzha, zzav zzav, zzp zzp) {
        this.zzc = zzha;
        this.zza = zzav;
        this.zzb = zzp;
    }

    public final void run() {
        zzha zzha = this.zzc;
        zzav zzav = this.zza;
        zzc zzc2 = null;
        if (zzha != null) {
            if ("_cmp".equals(zzav.zza)) {
                zzat zzat = zzav.zzb;
                if (!(zzat == null || zzat.zza.size() == 0)) {
                    String string = zzav.zzb.zza.getString("_cis");
                    if ("referrer broadcast".equals(string) || "referrer API".equals(string)) {
                        zzha.zza.zzaz().zzj.zzb("Event has been filtered ", zzav.toString());
                        zzav zzav2 = new zzav("_cmpx", zzav.zzb, zzav.zzc, zzav.zzd);
                        zzav = zzav2;
                    }
                }
            }
            zzha zzha2 = this.zzc;
            zzp zzp = this.zzb;
            zzfz zzfz = zzha2.zza.zzc;
            zzli.zzak(zzfz);
            if (!zzfz.zzo(zzp.zza)) {
                zzha2.zza.zzA();
                zzha2.zza.zzD(zzav, zzp);
                return;
            }
            zzha2.zza.zzaz().zzl.zzb("EES config found for", zzp.zza);
            zzfz zzfz2 = zzha2.zza.zzc;
            zzli.zzak(zzfz2);
            String str = zzp.zza;
            if (!TextUtils.isEmpty(str)) {
                zzc2 = (zzc) zzfz2.zzd.get(str);
            }
            if (zzc2 != null) {
                try {
                    zzlk zzlk = zzha2.zza.zzi;
                    zzli.zzak(zzlk);
                    Map zzs = zzlk.zzs(zzav.zzb.zzc(), true);
                    String zza2 = zzhf.zza(zzav.zza);
                    if (zza2 == null) {
                        zza2 = zzav.zza;
                    }
                    if (zzc2.zze(new zzaa(zza2, zzav.zzd, zzs))) {
                        if (zzc2.zzg()) {
                            zzha2.zza.zzaz().zzl.zzb("EES edited event", zzav.zza);
                            zzlk zzlk2 = zzha2.zza.zzi;
                            zzli.zzak(zzlk2);
                            zzav zzi = zzlk2.zzi(zzc2.zza().zzb());
                            zzha2.zza.zzA();
                            zzha2.zza.zzD(zzi, zzp);
                        } else {
                            zzha2.zza.zzA();
                            zzha2.zza.zzD(zzav, zzp);
                        }
                        if (zzc2.zzf()) {
                            for (zzaa zzaa : zzc2.zza().zzc()) {
                                zzha2.zza.zzaz().zzl.zzb("EES logging created event", zzaa.zzd());
                                zzlk zzlk3 = zzha2.zza.zzi;
                                zzli.zzak(zzlk3);
                                zzav zzi2 = zzlk3.zzi(zzaa);
                                zzha2.zza.zzA();
                                zzha2.zza.zzD(zzi2, zzp);
                            }
                            return;
                        }
                        return;
                    }
                } catch (zzd unused) {
                    zzha2.zza.zzaz().zzd.zzc("EES error. appId, eventName", zzp.zzb, zzav.zza);
                }
                zzha2.zza.zzaz().zzl.zzb("EES was not applied to event", zzav.zza);
                zzha2.zza.zzA();
                zzha2.zza.zzD(zzav, zzp);
                return;
            }
            zzha2.zza.zzaz().zzl.zzb("EES not loaded for", zzp.zza);
            zzha2.zza.zzA();
            zzha2.zza.zzD(zzav, zzp);
            return;
        }
        throw null;
    }
}
