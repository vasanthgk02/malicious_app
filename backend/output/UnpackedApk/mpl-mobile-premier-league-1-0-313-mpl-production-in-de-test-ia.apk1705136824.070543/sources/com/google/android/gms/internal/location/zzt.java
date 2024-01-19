package com.google.android.gms.internal.location;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzt extends zzx {
    public final /* synthetic */ LocationRequest zza;
    public final /* synthetic */ LocationCallback zzb;
    public final /* synthetic */ Looper zzc;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzt(zzz zzz, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        // this.zza = locationRequest;
        // this.zzb = locationCallback;
        // this.zzc = looper;
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzaz) anyClient).zzB(zzba.zza(null, this.zza), ListenerHolders.createListenerHolder(this.zzb, zzbj.zza(this.zzc), LocationCallback.class.getSimpleName()), new zzy(this));
    }
}
