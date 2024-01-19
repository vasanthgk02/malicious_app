package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaab implements StatusListener {
    public final /* synthetic */ BasePendingResult zaa;
    public final /* synthetic */ zaad zab;

    public zaab(zaad zaad, BasePendingResult basePendingResult) {
        this.zab = zaad;
        this.zaa = basePendingResult;
    }

    public final void onComplete(Status status) {
        this.zab.zaa.remove(this.zaa);
    }
}
