package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final /* synthetic */ class zzs implements RemoteCall {
    public final /* synthetic */ zzab zza;
    public final /* synthetic */ AccountChangeEventsRequest zzb;

    public /* synthetic */ zzs(zzab zzab, AccountChangeEventsRequest accountChangeEventsRequest) {
        this.zza = zzab;
        this.zzb = accountChangeEventsRequest;
    }

    public final void accept(Object obj, Object obj2) {
        zzab zzab = this.zza;
        AccountChangeEventsRequest accountChangeEventsRequest = this.zzb;
        ((zzp) ((zzi) obj).getService()).zze(new zzz(zzab, (TaskCompletionSource) obj2), accountChangeEventsRequest);
    }
}
