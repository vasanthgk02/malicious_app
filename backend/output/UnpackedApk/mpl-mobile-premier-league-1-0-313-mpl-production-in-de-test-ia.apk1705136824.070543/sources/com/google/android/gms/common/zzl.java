package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public abstract class zzl extends zzj {
    public static final WeakReference zza = new WeakReference(null);
    public WeakReference zzb = zza;

    public zzl(byte[] bArr) {
        super(bArr);
    }

    public abstract byte[] zzb();

    public final byte[] zzf() {
        byte[] bArr;
        synchronized (this) {
            try {
                bArr = (byte[]) this.zzb.get();
                if (bArr == null) {
                    bArr = zzb();
                    this.zzb = new WeakReference(bArr);
                }
            }
        }
        return bArr;
    }
}
