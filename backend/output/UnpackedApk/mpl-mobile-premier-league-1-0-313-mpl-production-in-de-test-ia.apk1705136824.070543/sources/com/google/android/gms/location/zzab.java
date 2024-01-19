package com.google.android.gms.location;

import android.os.Looper;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzba;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zza;
import com.google.android.gms.tasks.zzb;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final /* synthetic */ class zzab implements RemoteCall {
    public final FusedLocationProviderClient zza;
    public final CancellationToken zzb;
    public final zzba zzc;

    public zzab(FusedLocationProviderClient fusedLocationProviderClient, CancellationToken cancellationToken, zzba zzba) {
        this.zza = fusedLocationProviderClient;
        this.zzb = cancellationToken;
        this.zzc = zzba;
    }

    public final void accept(Object obj, Object obj2) {
        FusedLocationProviderClient fusedLocationProviderClient = this.zza;
        CancellationToken cancellationToken = this.zzb;
        zzba zzba = this.zzc;
        zzaz zzaz = (zzaz) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        if (fusedLocationProviderClient != null) {
            zzaj zzaj = new zzaj(fusedLocationProviderClient, taskCompletionSource);
            if (cancellationToken != null) {
                zzy zzy = new zzy(fusedLocationProviderClient, zzaj);
                ((zzb) cancellationToken).zza.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) new zza<Object>(zzy));
            }
            fusedLocationProviderClient.zze(zzba, zzaj, Looper.getMainLooper(), new zzz(taskCompletionSource), 2437).continueWithTask(new zzaa(taskCompletionSource));
            return;
        }
        throw null;
    }
}
