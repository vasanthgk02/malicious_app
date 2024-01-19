package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzp extends zzx {
    public final /* synthetic */ Location zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzp(zzz zzz, GoogleApiClient googleApiClient, Location location) {
        // this.zza = location;
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzaz) anyClient).zzJ(this.zza);
        setResult(Status.RESULT_SUCCESS);
    }
}
