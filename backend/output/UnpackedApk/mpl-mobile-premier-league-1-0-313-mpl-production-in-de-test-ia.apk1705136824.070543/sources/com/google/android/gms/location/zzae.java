package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzba;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final /* synthetic */ class zzae implements RemoteCall {
    public final FusedLocationProviderClient zza;
    public final zzap zzb;
    public final LocationCallback zzc;
    public final zzan zzd;
    public final zzba zze;
    public final ListenerHolder zzf;

    public zzae(FusedLocationProviderClient fusedLocationProviderClient, zzap zzap, LocationCallback locationCallback, zzan zzan, zzba zzba, ListenerHolder listenerHolder) {
        this.zza = fusedLocationProviderClient;
        this.zzb = zzap;
        this.zzc = locationCallback;
        this.zzd = zzan;
        this.zze = zzba;
        this.zzf = listenerHolder;
    }

    public final void accept(Object obj, Object obj2) {
        FusedLocationProviderClient fusedLocationProviderClient = this.zza;
        zzap zzap = this.zzb;
        LocationCallback locationCallback = this.zzc;
        zzan zzan = this.zzd;
        zzba zzba = this.zze;
        ListenerHolder listenerHolder = this.zzf;
        zzaz zzaz = (zzaz) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        if (fusedLocationProviderClient != null) {
            zzam zzam = new zzam(taskCompletionSource, new zzx(fusedLocationProviderClient, zzap, locationCallback, zzan));
            zzba.zzc(fusedLocationProviderClient.getContextAttributionTag());
            zzaz.zzB(zzba, listenerHolder, zzam);
            return;
        }
        throw null;
    }
}
