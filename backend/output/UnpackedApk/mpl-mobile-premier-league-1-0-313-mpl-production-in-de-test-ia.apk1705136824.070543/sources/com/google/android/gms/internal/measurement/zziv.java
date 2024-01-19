package com.google.android.gms.internal.measurement;

import com.android.tools.r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zziv extends zziy {
    public final int zzc;

    public zziv(byte[] bArr, int i, int i2) {
        super(bArr);
        zzjb.zzj(0, i2, bArr.length);
        this.zzc = i2;
    }

    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(GeneratedOutlineSupport.outline41("Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(GeneratedOutlineSupport.outline43("Index > length: ", i, ", ", i2));
    }

    public final byte zzb(int i) {
        return this.zza[i];
    }

    public final int zzc() {
        return 0;
    }

    public final int zzd() {
        return this.zzc;
    }
}
