package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final /* synthetic */ class zzbs implements RemoteCall {
    public final LocationSettingsRequest zza;

    public zzbs(LocationSettingsRequest locationSettingsRequest) {
        this.zza = locationSettingsRequest;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzaz) obj).zzL(this.zza, new zzbt((TaskCompletionSource) obj2), null);
    }
}
