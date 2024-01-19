package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationListener;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzv extends zzx {
    public final /* synthetic */ LocationListener zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzv(zzz zzz, GoogleApiClient googleApiClient, LocationListener locationListener) {
        // this.zza = locationListener;
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzaz) anyClient).zzF(ListenerHolders.createListenerKey(this.zza, LocationListener.class.getSimpleName()), new zzy(this));
    }
}
