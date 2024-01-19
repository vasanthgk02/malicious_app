package com.google.android.gms.tasks;

import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
public final class zzad<T> implements zzae<T> {
    public final CountDownLatch zza = new CountDownLatch(1);

    public /* synthetic */ zzad(zzac zzac) {
    }

    public final void onCanceled() {
        this.zza.countDown();
    }

    public final void onFailure(Exception exc) {
        this.zza.countDown();
    }

    public final void onSuccess(T t) {
        this.zza.countDown();
    }
}
