package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.zzbq;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzad extends zzae {
    public final /* synthetic */ zzbq zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzad(zzaf zzaf, GoogleApiClient googleApiClient, zzbq zzbq) {
        // this.zza = zzbq;
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzaz) anyClient).zzw(this.zza, this);
    }
}
