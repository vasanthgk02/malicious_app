package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
public final class zzo implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzp zzb;

    public zzo(zzp zzp, Task task) {
        this.zzb = zzp;
        this.zza = task;
    }

    public final void run() {
        try {
            Task then = this.zzb.zzb.then(this.zza.getResult());
            if (then == null) {
                zzp zzp = this.zzb;
                zzp.zzc.zza(new NullPointerException("Continuation returned null"));
                return;
            }
            then.addOnSuccessListener(TaskExecutors.zza, (OnSuccessListener<? super TResult>) this.zzb);
            then.addOnFailureListener(TaskExecutors.zza, this.zzb);
            then.addOnCanceledListener(TaskExecutors.zza, this.zzb);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.zzb.zzc.zza((Exception) e2.getCause());
                return;
            }
            this.zzb.zzc.zza(e2);
        } catch (CancellationException unused) {
            this.zzb.zzc.zzc();
        } catch (Exception e3) {
            this.zzb.zzc.zza(e3);
        }
    }
}
