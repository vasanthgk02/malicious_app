package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public abstract class zzw extends zzj {
    public final CharSequence zzb;
    public final zzo zzc;
    public final boolean zzd;
    public int zze = 0;
    public int zzf;

    public zzw(zzx zzx, CharSequence charSequence) {
        this.zzc = zzx.zza;
        this.zzd = zzx.zzb;
        this.zzf = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        int zzd2;
        int i;
        int i2 = this.zze;
        while (true) {
            int i3 = this.zze;
            if (i3 != -1) {
                zzd2 = zzd(i3);
                if (zzd2 == -1) {
                    zzd2 = this.zzb.length();
                    this.zze = -1;
                    i = -1;
                } else {
                    i = zzc(zzd2);
                    this.zze = i;
                }
                if (i == i2) {
                    int i4 = i + 1;
                    this.zze = i4;
                    if (i4 > this.zzb.length()) {
                        this.zze = -1;
                    }
                } else {
                    if (i2 < zzd2) {
                        this.zzb.charAt(i2);
                    }
                    if (i2 < zzd2) {
                        this.zzb.charAt(zzd2 - 1);
                    }
                    if (!this.zzd || i2 != zzd2) {
                        int i5 = this.zzf;
                    } else {
                        i2 = this.zze;
                    }
                }
            } else {
                zzb();
                return null;
            }
        }
        int i52 = this.zzf;
        if (i52 == 1) {
            zzd2 = this.zzb.length();
            this.zze = -1;
            if (zzd2 > i2) {
                this.zzb.charAt(zzd2 - 1);
            }
        } else {
            this.zzf = i52 - 1;
        }
        return this.zzb.subSequence(i2, zzd2).toString();
    }

    public abstract int zzc(int i);

    public abstract int zzd(int i);
}
