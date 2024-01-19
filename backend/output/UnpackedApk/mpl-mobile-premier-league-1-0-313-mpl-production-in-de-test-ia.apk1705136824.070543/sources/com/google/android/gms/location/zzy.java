package com.google.android.gms.location;

import com.google.android.gms.tasks.OnTokenCanceledListener;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final /* synthetic */ class zzy implements OnTokenCanceledListener {
    public final FusedLocationProviderClient zza;
    public final LocationCallback zzb;

    public zzy(FusedLocationProviderClient fusedLocationProviderClient, LocationCallback locationCallback) {
        this.zza = fusedLocationProviderClient;
        this.zzb = locationCallback;
    }

    public final void onCanceled() {
        this.zza.removeLocationUpdates(this.zzb);
    }
}
