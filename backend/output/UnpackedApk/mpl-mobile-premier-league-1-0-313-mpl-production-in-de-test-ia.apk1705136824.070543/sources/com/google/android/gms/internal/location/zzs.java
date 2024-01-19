package com.google.android.gms.internal.location;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzs extends zzx {
    public final /* synthetic */ LocationRequest zza;
    public final /* synthetic */ LocationListener zzb;
    public final /* synthetic */ Looper zzc;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzs(zzz zzz, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        // this.zza = locationRequest;
        // this.zzb = locationListener;
        // this.zzc = looper;
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzaz) anyClient).zzC(this.zza, ListenerHolders.createListenerHolder(this.zzb, zzbj.zza(this.zzc), LocationListener.class.getSimpleName()), new zzy(this));
    }
}
