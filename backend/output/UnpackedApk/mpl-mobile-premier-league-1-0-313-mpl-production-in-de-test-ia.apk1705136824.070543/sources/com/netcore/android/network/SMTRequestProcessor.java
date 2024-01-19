package com.netcore.android.network;

import com.netcore.android.network.models.SMTRequest;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/netcore/android/network/SMTRequestProcessor;", "Ljava/util/concurrent/Callable;", "Ljava/util/concurrent/Future;", "call", "()Ljava/util/concurrent/Future;", "Lcom/netcore/android/network/SMTInternalNetworkListener;", "internalListener", "Lcom/netcore/android/network/SMTInternalNetworkListener;", "Lcom/netcore/android/network/models/SMTRequest;", "apiRequest", "Lcom/netcore/android/network/models/SMTRequest;", "<init>", "(Lcom/netcore/android/network/models/SMTRequest;Lcom/netcore/android/network/SMTInternalNetworkListener;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTRequestProcessor.kt */
public final class SMTRequestProcessor implements Callable<Future<?>> {
    public SMTRequest apiRequest;
    public SMTInternalNetworkListener internalListener;

    public SMTRequestProcessor(SMTRequest sMTRequest, SMTInternalNetworkListener sMTInternalNetworkListener) {
        Intrinsics.checkNotNullParameter(sMTRequest, "apiRequest");
        Intrinsics.checkNotNullParameter(sMTInternalNetworkListener, "internalListener");
        this.apiRequest = sMTRequest;
        this.internalListener = sMTInternalNetworkListener;
    }

    public Future<?> call() {
        this.internalListener.onRequestProcessComplete(new SMTApiService(this.apiRequest).makeApiCall());
        return null;
    }
}
