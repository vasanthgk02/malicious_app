package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzu extends zzx {
    public final /* synthetic */ LocationRequest zza;
    public final /* synthetic */ PendingIntent zzb;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzu(zzz zzz, GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        // this.zza = locationRequest;
        // this.zzb = pendingIntent;
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzaz) anyClient).zzE(this.zza, this.zzb, new zzy(this));
    }
}
