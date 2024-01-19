package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zacy implements Runnable {
    public final /* synthetic */ Result zaa;
    public final /* synthetic */ zada zab;

    public zacy(zada zada, Result result) {
        this.zab = zada;
        this.zaa = result;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006a, code lost:
        if (r0 == null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x003a, code lost:
        if (r0 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x003c, code lost:
        r0.zap(r4.zab);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0041, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
            java.lang.ThreadLocal r0 = com.google.android.gms.common.api.internal.BasePendingResult.zaa     // Catch:{ RuntimeException -> 0x0042 }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ RuntimeException -> 0x0042 }
            r0.set(r1)     // Catch:{ RuntimeException -> 0x0042 }
            com.google.android.gms.common.api.internal.zada r0 = r4.zab     // Catch:{ RuntimeException -> 0x0042 }
            com.google.android.gms.common.api.ResultTransform r0 = r0.zaa     // Catch:{ RuntimeException -> 0x0042 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ RuntimeException -> 0x0042 }
            com.google.android.gms.common.api.ResultTransform r0 = (com.google.android.gms.common.api.ResultTransform) r0     // Catch:{ RuntimeException -> 0x0042 }
            com.google.android.gms.common.api.Result r1 = r4.zaa     // Catch:{ RuntimeException -> 0x0042 }
            com.google.android.gms.common.api.PendingResult r0 = r0.onSuccess(r1)     // Catch:{ RuntimeException -> 0x0042 }
            com.google.android.gms.common.api.internal.zada r1 = r4.zab     // Catch:{ RuntimeException -> 0x0042 }
            com.google.android.gms.common.api.internal.zacz r2 = r1.zah     // Catch:{ RuntimeException -> 0x0042 }
            com.google.android.gms.common.api.internal.zacz r1 = r1.zah     // Catch:{ RuntimeException -> 0x0042 }
            r3 = 0
            android.os.Message r0 = r1.obtainMessage(r3, r0)     // Catch:{ RuntimeException -> 0x0042 }
            r2.sendMessage(r0)     // Catch:{ RuntimeException -> 0x0042 }
            java.lang.ThreadLocal r0 = com.google.android.gms.common.api.internal.BasePendingResult.zaa
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.set(r1)
            com.google.android.gms.common.api.Result r0 = r4.zaa
            com.google.android.gms.common.api.internal.zada.zan(r0)
            com.google.android.gms.common.api.internal.zada r0 = r4.zab
            java.lang.ref.WeakReference r0 = r0.zag
            java.lang.Object r0 = r0.get()
            com.google.android.gms.common.api.GoogleApiClient r0 = (com.google.android.gms.common.api.GoogleApiClient) r0
            if (r0 == 0) goto L_0x006d
        L_0x003c:
            com.google.android.gms.common.api.internal.zada r1 = r4.zab
            r0.zap(r1)
            return
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            goto L_0x006e
        L_0x0046:
            com.google.android.gms.common.api.internal.zada r1 = r4.zab     // Catch:{ all -> 0x0044 }
            com.google.android.gms.common.api.internal.zacz r2 = r1.zah     // Catch:{ all -> 0x0044 }
            com.google.android.gms.common.api.internal.zacz r1 = r1.zah     // Catch:{ all -> 0x0044 }
            r3 = 1
            android.os.Message r0 = r1.obtainMessage(r3, r0)     // Catch:{ all -> 0x0044 }
            r2.sendMessage(r0)     // Catch:{ all -> 0x0044 }
            java.lang.ThreadLocal r0 = com.google.android.gms.common.api.internal.BasePendingResult.zaa
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.set(r1)
            com.google.android.gms.common.api.Result r0 = r4.zaa
            com.google.android.gms.common.api.internal.zada.zan(r0)
            com.google.android.gms.common.api.internal.zada r0 = r4.zab
            java.lang.ref.WeakReference r0 = r0.zag
            java.lang.Object r0 = r0.get()
            com.google.android.gms.common.api.GoogleApiClient r0 = (com.google.android.gms.common.api.GoogleApiClient) r0
            if (r0 == 0) goto L_0x006d
            goto L_0x003c
        L_0x006d:
            return
        L_0x006e:
            java.lang.ThreadLocal r1 = com.google.android.gms.common.api.internal.BasePendingResult.zaa
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r1.set(r2)
            com.google.android.gms.common.api.Result r1 = r4.zaa
            com.google.android.gms.common.api.internal.zada.zan(r1)
            com.google.android.gms.common.api.internal.zada r1 = r4.zab
            java.lang.ref.WeakReference r1 = r1.zag
            java.lang.Object r1 = r1.get()
            com.google.android.gms.common.api.GoogleApiClient r1 = (com.google.android.gms.common.api.GoogleApiClient) r1
            if (r1 != 0) goto L_0x0087
            goto L_0x008c
        L_0x0087:
            com.google.android.gms.common.api.internal.zada r2 = r4.zab
            r1.zap(r2)
        L_0x008c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zacy.run():void");
    }
}
