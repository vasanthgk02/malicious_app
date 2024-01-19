package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzbm extends zzbd {
    public final /* synthetic */ TaskCompletionSource zza;

    public zzbm(zzbo zzbo, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(ProxyResponse proxyResponse) throws RemoteException {
        TaskUtil.setResultOrApiException(new Status(proxyResponse.googlePlayServicesStatusCode, null), proxyResponse, this.zza);
    }
}
