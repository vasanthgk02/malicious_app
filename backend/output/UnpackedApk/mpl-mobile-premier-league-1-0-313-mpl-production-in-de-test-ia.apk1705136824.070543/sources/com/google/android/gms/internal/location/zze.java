package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zze extends zzf {
    public final /* synthetic */ PendingIntent zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zze(zzg zzg, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        // this.zza = pendingIntent;
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzaz) anyClient).zzt(this.zza);
        setResult(Status.RESULT_SUCCESS);
    }
}
