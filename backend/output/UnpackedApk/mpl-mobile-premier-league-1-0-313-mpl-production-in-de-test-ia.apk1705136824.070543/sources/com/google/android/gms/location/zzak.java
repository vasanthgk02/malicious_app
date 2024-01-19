package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzak extends zzap {
    public final /* synthetic */ ListenerHolder zza;
    public final /* synthetic */ FusedLocationProviderClient zzb;

    public zzak(FusedLocationProviderClient fusedLocationProviderClient, ListenerHolder listenerHolder) {
        this.zzb = fusedLocationProviderClient;
        this.zza = listenerHolder;
    }

    public final void accept(Object obj, Object obj2) throws RemoteException {
        zzaz zzaz = (zzaz) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        if (this.zza) {
            zzal zzal = new zzal(taskCompletionSource);
            try {
                ListenerKey listenerKey = this.zza.zac;
                if (listenerKey != null) {
                    zzaz.zzH(listenerKey, zzal);
                }
            } catch (RuntimeException e2) {
                taskCompletionSource.trySetException(e2);
            }
        }
    }
}
