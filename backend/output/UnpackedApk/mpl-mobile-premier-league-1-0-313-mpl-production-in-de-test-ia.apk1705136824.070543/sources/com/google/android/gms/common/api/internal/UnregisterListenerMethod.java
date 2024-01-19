package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class UnregisterListenerMethod<A extends AnyClient, L> {
    public final ListenerKey zaa;

    @KeepForSdk
    public UnregisterListenerMethod(ListenerKey<L> listenerKey) {
        this.zaa = listenerKey;
    }
}
