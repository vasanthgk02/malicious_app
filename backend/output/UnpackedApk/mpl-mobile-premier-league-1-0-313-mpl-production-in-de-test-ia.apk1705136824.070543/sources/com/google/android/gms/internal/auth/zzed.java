package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzed extends zzee {
    public final byte[] zzb;
    public int zzc;
    public int zzd;
    public int zze = Integer.MAX_VALUE;

    public /* synthetic */ zzed(byte[] bArr, int i, int i2, boolean z, zzec zzec) {
        super(null);
        this.zzb = bArr;
        this.zzc = 0;
    }

    public final int zza(int i) throws zzew {
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
