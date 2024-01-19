package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final /* synthetic */ class zzw implements OnCompleteListener {
    public final /* synthetic */ Rpc zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ ScheduledFuture zzc;

    public /* synthetic */ zzw(Rpc rpc, String str, ScheduledFuture scheduledFuture) {
        this.zza = rpc;
        this.zzb = str;
        this.zzc = scheduledFuture;
    }

    public final void onComplete(Task task) {
        Rpc rpc = this.zza;
        String str = this.zzb;
        ScheduledFuture scheduledFuture = this.zzc;
        synchronized (rpc.zze) {
            rpc.zze.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
