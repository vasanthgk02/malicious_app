package com.google.android.gms.internal.location;

import android.os.DeadObjectException;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzh implements zzbg<zzam> {
    public final /* synthetic */ zzi zza;

    public zzh(zzi zzi) {
        this.zza = zzi;
    }

    public final zzam zza() throws DeadObjectException {
        return (zzam) this.zza.getService();
    }
}
