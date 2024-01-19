package com.google.android.gms.internal.location;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbr extends zzbs {
    public final transient int zza;
    public final transient int zzb;
    public final /* synthetic */ zzbs zzc;

    public zzbr(zzbs zzbs, int i, int i2) {
        this.zzc = zzbs;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzbm.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    public final boolean zzf() {
        return true;
    }

    /* renamed from: zzh */
    public final zzbs subList(int i, int i2) {
        zzbm.zzc(i, i2, this.zzb);
        zzbs zzbs = this.zzc;
        int i3 = this.zza;
        return zzbs.subList(i + i3, i2 + i3);
    }
}
