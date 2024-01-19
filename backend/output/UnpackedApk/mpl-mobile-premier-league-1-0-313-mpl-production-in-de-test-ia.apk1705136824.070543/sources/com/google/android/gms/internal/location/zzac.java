package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.GeofencingRequest;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzac extends zzae {
    public final /* synthetic */ GeofencingRequest zza;
    public final /* synthetic */ PendingIntent zzb;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzac(zzaf zzaf, GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        // this.zza = geofencingRequest;
        // this.zzb = pendingIntent;
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzaz) anyClient).zzv(this.zza, this.zzb, this);
    }
}
