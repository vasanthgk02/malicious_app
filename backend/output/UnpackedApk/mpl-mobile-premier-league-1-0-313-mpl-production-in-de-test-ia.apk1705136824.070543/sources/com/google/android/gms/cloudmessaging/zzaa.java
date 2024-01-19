package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.cloudmessaging.zzf;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final class zzaa extends zzf {
    public final /* synthetic */ Rpc zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzaa(Rpc rpc, Looper looper) {
        // this.zza = rpc;
        super(looper);
    }

    public final void handleMessage(Message message) {
        Rpc.zzc(this.zza, message);
    }
}
