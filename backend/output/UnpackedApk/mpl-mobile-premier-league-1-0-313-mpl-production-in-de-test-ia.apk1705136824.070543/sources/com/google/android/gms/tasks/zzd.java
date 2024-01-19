package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
public final class zzd implements zzq {
    public final Executor zza;
    public final Continuation zzb;
    public final zzw zzc;

    public zzd(Executor executor, Continuation continuation, zzw zzw) {
        this.zza = executor;
        this.zzb = continuation;
        this.zzc = zzw;
    }

    public final void zzc() {
        throw new UnsupportedOperationException();
    }

    public final void zzd(Task task) {
        this.zza.execute(new zzc(this, task));
    }
}
