package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzo extends zzx {
    public final /* synthetic */ boolean zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzo(zzz zzz, GoogleApiClient googleApiClient, boolean z) {
        // this.zza = z;
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzaz) anyClient).zzI(this.zza);
        setResult(Status.RESULT_SUCCESS);
    }
}