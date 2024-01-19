package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzfd extends zzfe {
    public zzfd() {
        super(null);
    }

    public /* synthetic */ zzfd(zzfb zzfb) {
        super(null);
    }

    public final void zza(Object obj, long j) {
        ((zzeu) zzgz.zzf(obj, j)).zzb();
    }

    public final <E> void zzb(Object obj, Object obj2, long j) {
        zzeu zzeu = (zzeu) zzgz.zzf(obj, j);
        zzeu zzeu2 = (zzeu) zzgz.zzf(obj2, j);
        int size = zzeu.size();
        int size2 = zzeu2.size();
        if (size > 0 && size2 > 0) {
            if (!zzeu.zzc()) {
                zzeu = zzeu.zzd(size2 + size);
            }
            zzeu.addAll(zzeu2);
        }
        if (size > 0) {
            zzeu2 = zzeu;
        }
        zzgz.zzp(obj, j, zzeu2);
    }
}
