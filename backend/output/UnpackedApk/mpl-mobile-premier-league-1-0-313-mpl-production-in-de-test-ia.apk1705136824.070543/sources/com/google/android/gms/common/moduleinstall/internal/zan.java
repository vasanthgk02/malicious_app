package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final /* synthetic */ class zan implements RemoteCall {
    public final void accept(Object obj, Object obj2) {
        ((zaf) ((zaz) obj).getService()).zag(new zas((TaskCompletionSource) obj2), null, null);
    }
}
