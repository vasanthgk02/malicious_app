package com.google.android.gms.internal.auth;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzhi extends zzeq<zzhi, zzhh> implements zzfr {
    public static final zzhi zzb;
    public zzeu<String> zzd = zzeq.zzd();

    static {
        zzhi zzhi = new zzhi();
        zzb = zzhi;
        zzeq.zzi(zzhi.class, zzhi);
    }

    public static zzhi zzl(byte[] bArr) throws zzew {
        return (zzhi) zzeq.zzb(zzb, bArr);
    }

    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzeq.zzg(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzd"});
        } else if (i2 == 3) {
            return new zzhi();
        } else {
            if (i2 == 4) {
                return new zzhh(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final List<String> zzm() {
        return this.zzd;
    }
}
