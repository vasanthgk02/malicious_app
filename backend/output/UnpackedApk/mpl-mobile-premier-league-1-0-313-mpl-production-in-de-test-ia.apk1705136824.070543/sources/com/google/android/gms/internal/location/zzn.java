package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationCallback;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzn extends zzx {
    public final /* synthetic */ LocationCallback zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzn(zzz zzz, GoogleApiClient googleApiClient, LocationCallback locationCallback) {
        // this.zza = locationCallback;
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzaz) anyClient).zzH(ListenerHolders.createListenerKey(this.zza, LocationCallback.class.getSimpleName()), new zzy(this));
    }
}
