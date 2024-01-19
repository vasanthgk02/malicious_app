package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final /* synthetic */ class zzu implements Continuation {
    public final /* synthetic */ Rpc zza;
    public final /* synthetic */ Bundle zzb;

    public /* synthetic */ zzu(Rpc rpc, Bundle bundle) {
        this.zza = rpc;
        this.zzb = bundle;
    }

    public final Object then(Task task) {
        Rpc rpc = this.zza;
        Bundle bundle = this.zzb;
        if (rpc == null) {
            throw null;
        } else if (!task.isSuccessful()) {
            return task;
        } else {
            Bundle bundle2 = (Bundle) task.getResult();
            return !(bundle2 != null && bundle2.containsKey("google.messenger")) ? task : rpc.zze(bundle).onSuccessTask(Rpc.zzc, zzx.zza);
        }
    }
}
