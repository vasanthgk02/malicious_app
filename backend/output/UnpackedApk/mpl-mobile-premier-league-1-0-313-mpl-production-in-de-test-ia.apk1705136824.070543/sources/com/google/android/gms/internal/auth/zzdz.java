package com.google.android.gms.internal.auth;

import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public class zzdz extends zzdy {
    public final byte[] zza;

    public zzdz(byte[] bArr) {
        if (bArr != null) {
            this.zza = bArr;
            return;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeb) || zzd() != ((zzeb) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzdz)) {
            return obj.equals(this);
        }
        zzdz zzdz = (zzdz) obj;
        int zzj = zzj();
        int zzj2 = zzdz.zzj();
        if (zzj != 0 && zzj2 != 0 && zzj != zzj2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzdz.zzd()) {
            int zzd2 = zzd();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(zzd);
            sb.append(zzd2);
            throw new IllegalArgumentException(sb.toString());
        } else if (zzd <= zzdz.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzdz.zza;
            zzdz.zzc();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= zzd) {
                    break;
                } else if (bArr[i] != bArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i++;
                    i2++;
                }
            }
            return z;
        } else {
            int zzd3 = zzdz.zzd();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(zzd);
            sb2.append(", ");
            sb2.append(zzd3);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    public final int zze(int i, int i2, int i3) {
        return zzev.zzd(i, this.zza, 0, i3);
    }

    public final zzeb zzf(int i, int i2) {
        int zzi = zzeb.zzi(0, i2, zzd());
        if (zzi == 0) {
            return zzeb.zzb;
        }
        return new zzdw(this.zza, 0, zzi);
    }

    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    public final boolean zzh() {
        return zzhd.zzd(this.zza, 0, zzd());
    }
}
