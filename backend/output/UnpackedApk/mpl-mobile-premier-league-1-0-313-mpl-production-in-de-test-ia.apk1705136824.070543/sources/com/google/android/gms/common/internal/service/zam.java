package com.google.android.gms.common.internal.service;

import android.os.Parcel;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final /* synthetic */ class zam implements RemoteCall {
    public final /* synthetic */ TelemetryData zaa;

    public /* synthetic */ zam(TelemetryData telemetryData) {
        this.zaa = telemetryData;
    }

    public final void accept(Object obj, Object obj2) {
        TelemetryData telemetryData = this.zaa;
        int i = zao.zab;
        zai zai = (zai) ((zap) obj).getService();
        Parcel zaa2 = zai.zaa();
        zac.zad(zaa2, telemetryData);
        zai.zad(1, zaa2);
        ((TaskCompletionSource) obj2).zza.zzb(null);
    }
}
