package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzla implements zzlh {
    public final zzlh[] zza;

    public zzla(zzlh... zzlhArr) {
        this.zza = zzlhArr;
    }

    public final zzlg zzb(Class cls) {
        zzlh[] zzlhArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzlh zzlh = zzlhArr[i];
            if (zzlh.zzc(cls)) {
                return zzlh.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        zzlh[] zzlhArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzlhArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
