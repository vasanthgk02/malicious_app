package com.google.android.gms.common;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzk extends zzj {
    public final byte[] zza;

    public zzk(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zza = bArr;
    }

    public final byte[] zzf() {
        return this.zza;
    }
}
