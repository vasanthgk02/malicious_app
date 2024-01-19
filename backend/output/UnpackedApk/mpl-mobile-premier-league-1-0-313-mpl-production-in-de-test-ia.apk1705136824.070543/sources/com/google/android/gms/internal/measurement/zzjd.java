package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzjd extends zzjf {
    public final byte[] zzb;
    public int zzc;
    public int zzd;
    public int zze = Integer.MAX_VALUE;

    public /* synthetic */ zzjd(byte[] bArr, int i, int i2, boolean z, zzjc zzjc) {
        super(null);
        this.zzb = bArr;
        this.zzc = 0;
    }

    public final int zza(int i) throws zzkm {
        int i2 = this.zze;
        this.zze = 0;
        int i3 = this.zzc + this.zzd;
        this.zzc = i3;
        if (i3 > 0) {
            this.zzd = i3;
            this.zzc = 0;
        } else {
            this.zzd = 0;
        }
        return i2;
    }
}
