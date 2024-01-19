package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzd extends zzf {
    public final /* synthetic */ long zza;
    public final /* synthetic */ PendingIntent zzb;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzd(zzg zzg, GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
        // this.zza = j;
        // this.zzb = pendingIntent;
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzaz) anyClient).zzq(this.zza, this.zzb);
        setResult(Status.RESULT_SUCCESS);
    }
}
