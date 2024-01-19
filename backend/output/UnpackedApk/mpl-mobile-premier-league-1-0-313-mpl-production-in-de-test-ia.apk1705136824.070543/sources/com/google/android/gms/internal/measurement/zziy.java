package com.google.android.gms.internal.measurement;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public class zziy extends zzix {
    public final byte[] zza;

    public zziy(byte[] bArr) {
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
        if (!(obj instanceof zzjb) || zzd() != ((zzjb) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zziy)) {
            return obj.equals(this);
        }
        zziy zziy = (zziy) obj;
        int zzk = zzk();
        int zzk2 = zziy.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zziy.zzd()) {
            int zzd2 = zzd();
            throw new IllegalArgumentException("Length too large: " + zzd + zzd2);
        } else if (zzd <= zziy.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zziy.zza;
            zziy.zzc();
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
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline43("Ran off end of other: 0, ", zzd, ", ", zziy.zzd()));
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
        return zzkk.zzd(i, this.zza, 0, i3);
    }

    public final zzjb zzf(int i, int i2) {
        int zzj = zzjb.zzj(0, i2, zzd());
        if (zzj == 0) {
            return zzjb.zzb;
        }
        return new zziv(this.zza, 0, zzj);
    }

    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    public final void zzh(zzir zzir) throws IOException {
        ((zzjg) zzir).zzc(this.zza, 0, zzd());
    }

    public final boolean zzi() {
        return zzna.zzf(this.zza, 0, zzd());
    }
}
