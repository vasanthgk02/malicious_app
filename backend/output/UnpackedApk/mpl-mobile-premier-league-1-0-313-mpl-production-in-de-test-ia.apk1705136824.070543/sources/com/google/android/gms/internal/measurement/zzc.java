package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzc {
    public final zzf zza;
    public zzg zzb;
    public final zzab zzc = new zzab();
    public final zzz zzd = new zzz();

    public zzc() {
        zzf zzf = new zzf();
        this.zza = zzf;
        this.zzb = zzf.zzb.zza();
        zzf zzf2 = this.zza;
        zzf2.zzd.zza("internal.registerCallback", new zza(this));
        zzf zzf3 = this.zza;
        zzf3.zzd.zza("internal.eventLogger", new zzb(this));
    }

    public final zzab zza() {
        return this.zzc;
    }

    public final /* synthetic */ zzai zzb() throws Exception {
        return new zzv(this.zzd);
    }

    public final void zzc(zzgs zzgs) throws zzd {
        zzai zzai;
        try {
            this.zzb = this.zza.zzb.zza();
            if (!(this.zza.zza(this.zzb, (zzgx[]) zzgs.zzc().toArray(new zzgx[0])) instanceof zzag)) {
                for (zzgq zzgq : zzgs.zza().zzd()) {
                    List zzc2 = zzgq.zzc();
                    String zzb2 = zzgq.zzb();
                    Iterator it = zzc2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            zzap zza2 = this.zza.zza(this.zzb, (zzgx) it.next());
                            if (zza2 instanceof zzam) {
                                zzg zzg = this.zzb;
                                if (!zzg.zzh(zzb2)) {
                                    zzai = null;
                                } else {
                                    zzap zzd2 = zzg.zzd(zzb2);
                                    if (zzd2 instanceof zzai) {
                                        zzai = (zzai) zzd2;
                                    } else {
                                        throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(zzb2)));
                                    }
                                }
                                if (zzai != null) {
                                    zzai.zza(this.zzb, Collections.singletonList(zza2));
                                } else {
                                    throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(zzb2)));
                                }
                            } else {
                                throw new IllegalArgumentException("Invalid rule definition");
                            }
                        }
                    }
                }
                return;
            }
            throw new IllegalStateException("Program loading failed");
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final void zzd(String str, Callable callable) {
        this.zza.zzd.zza(str, callable);
    }

    public final boolean zze(zzaa zzaa) throws zzd {
        try {
            this.zzc.zzd(zzaa);
            this.zza.zzc.zzg("runtime.counter", new zzah(Double.valueOf(0.0d)));
            this.zzd.zzb(this.zzb.zza(), this.zzc);
            return zzg() || zzf();
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final boolean zzf() {
        return !this.zzc.zzc().isEmpty();
    }

    public final boolean zzg() {
        zzab zzab = this.zzc;
        return !zzab.zzb().equals(zzab.zza());
    }
}
