package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzgl implements Runnable {
    public final /* synthetic */ zzab zza;
    public final /* synthetic */ zzha zzb;

    public zzgl(zzha zzha, zzab zzab) {
        this.zzb = zzha;
        this.zza = zzab;
    }

    public final void run() {
        this.zzb.zza.zzA();
        if (this.zza.zzc.zza() == null) {
            zzli zzli = this.zzb.zza;
            zzab zzab = this.zza;
            if (zzli != null) {
                String str = zzab.zza;
                Preconditions.checkNotNull(str);
                zzp zzab2 = zzli.zzab(str);
                if (zzab2 != null) {
                    zzli.zzN(zzab, zzab2);
                }
                return;
            }
            throw null;
        }
        zzli zzli2 = this.zzb.zza;
        zzab zzab3 = this.zza;
        if (zzli2 != null) {
            String str2 = zzab3.zza;
            Preconditions.checkNotNull(str2);
            zzp zzab4 = zzli2.zzab(str2);
            if (zzab4 != null) {
                zzli2.zzT(zzab3, zzab4);
            }
            return;
        }
        throw null;
    }
}
