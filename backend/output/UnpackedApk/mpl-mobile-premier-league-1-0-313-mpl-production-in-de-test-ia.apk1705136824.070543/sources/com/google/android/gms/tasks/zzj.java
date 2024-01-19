package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
public final class zzj implements zzq {
    public final Executor zza;
    public final Object zzb = new Object();
    public OnCompleteListener zzc;

    public zzj(Executor executor, OnCompleteListener onCompleteListener) {
        this.zza = executor;
        this.zzc = onCompleteListener;
    }

    public final void zzc() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }

    public final void zzd(Task task) {
        synchronized (this.zzb) {
            if (this.zzc != null) {
                this.zza.execute(new zzi(this, task));
            }
        }
    }
}
