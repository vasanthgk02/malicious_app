package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zacv extends TaskApiCall {
    public final /* synthetic */ Builder zaa;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zacv(Builder builder, Feature[] featureArr, boolean z, int i) {
        // this.zaa = builder;
        super(featureArr, z, i);
    }

    public final void doExecute(AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zaa.zaa.accept(anyClient, taskCompletionSource);
    }
}
