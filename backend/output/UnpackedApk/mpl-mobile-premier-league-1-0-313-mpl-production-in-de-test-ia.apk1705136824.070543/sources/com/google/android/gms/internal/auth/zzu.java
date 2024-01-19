package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final /* synthetic */ class zzu implements RemoteCall {
    public final /* synthetic */ zzab zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzu(zzab zzab, String str) {
        this.zza = zzab;
        this.zzb = str;
    }

    public final void accept(Object obj, Object obj2) {
        zzab zzab = this.zza;
        ((zzp) ((zzi) obj).getService()).zzh(new zzy(zzab, (TaskCompletionSource) obj2), this.zzb);
    }
}
