package com.google.android.gms.internal.auth;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzfu<T> implements zzgb<T> {
    public final zzfq zza;
    public final zzgp<?, ?> zzb;
    public final zzeh<?> zzc;

    public zzfu(zzgp<?, ?> zzgp, zzeh<?> zzeh, zzfq zzfq) {
        this.zzb = zzgp;
        zzeh.zzc(zzfq);
        this.zzc = zzeh;
        this.zza = zzfq;
    }

    public static <T> zzfu<T> zzb(zzgp<?, ?> zzgp, zzeh<?> zzeh, zzfq zzfq) {
        return new zzfu<>(zzgp, zzeh, zzfq);
    }

    public final int zza(T t) {
        return this.zzb.zza(t).hashCode();
    }

    public final T zzd() {
        return ((zzeo) ((zzeq) this.zza).zzj(5, null, null)).zzg();
    }

    public final void zze(T t) {
        this.zzb.zze(t);
        this.zzc.zzb(t);
    }

    public final void zzf(T t, T t2) {
        zzgd.zzf(this.zzb, t, t2);
    }

    public final void zzg(T t, byte[] bArr, int i, int i2, zzdp zzdp) throws IOException {
        zzeq zzeq = (zzeq) t;
        if (zzeq.zzc == zzgq.zza()) {
            zzeq.zzc = zzgq.zzc();
        }
        zzep zzep = (zzep) t;
        throw null;
    }

    public final boolean zzh(T t, T t2) {
        return this.zzb.zza(t).equals(this.zzb.zza(t2));
    }

    public final boolean zzi(T t) {
        this.zzc.zza(t);
        throw null;
    }
}
