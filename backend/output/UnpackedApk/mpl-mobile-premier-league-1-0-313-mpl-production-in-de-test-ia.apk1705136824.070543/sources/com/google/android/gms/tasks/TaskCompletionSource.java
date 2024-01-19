package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
public class TaskCompletionSource<TResult> {
    public final zzw zza = new zzw();

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        zzs zzs = new zzs(this);
        ((zzb) cancellationToken).zza.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) new zza<Object>(zzs));
    }

    public void setException(Exception exc) {
        this.zza.zza(exc);
    }

    public void setResult(TResult tresult) {
        this.zza.zzb(tresult);
    }

    public boolean trySetException(Exception exc) {
        zzw zzw = this.zza;
        if (zzw != null) {
            Preconditions.checkNotNull(exc, "Exception must not be null");
            synchronized (zzw.zza) {
                if (zzw.zzc) {
                    return false;
                }
                zzw.zzc = true;
                zzw.zzf = exc;
                zzw.zzb.zzb(zzw);
                return true;
            }
        }
        throw null;
    }

    public boolean trySetResult(TResult tresult) {
        return this.zza.zze(tresult);
    }
}
