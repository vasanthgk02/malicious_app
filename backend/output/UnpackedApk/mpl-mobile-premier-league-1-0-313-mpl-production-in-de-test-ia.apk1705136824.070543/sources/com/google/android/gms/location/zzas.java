package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final /* synthetic */ class zzas implements RemoteCall {
    public final List zza;

    public zzas(List list) {
        this.zza = list;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzaz) obj).zzy(this.zza, new zzat((TaskCompletionSource) obj2));
    }
}
