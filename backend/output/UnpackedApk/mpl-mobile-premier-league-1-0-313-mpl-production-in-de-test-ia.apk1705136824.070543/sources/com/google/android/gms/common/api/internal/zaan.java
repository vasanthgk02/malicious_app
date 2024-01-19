package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaan extends zabg {
    public final /* synthetic */ ConnectionProgressReportCallbacks zaa;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zaan(zabf zabf, ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        // this.zaa = connectionProgressReportCallbacks;
        super(zabf);
    }

    public final void zaa() {
        this.zaa.onReportServiceBinding(new ConnectionResult(16, null));
    }
}
