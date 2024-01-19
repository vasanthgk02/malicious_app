package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final /* synthetic */ class zap implements RemoteCall {
    public final void accept(Object obj, Object obj2) {
        zar zar = new zar((TaskCompletionSource) obj2);
        zaf zaf = (zaf) ((zaz) obj).getService();
        Parcel zaa = zaf.zaa();
        zac.zae(zaa, zar);
        zac.zad(zaa, null);
        zaf.zac(1, zaa);
    }
}
