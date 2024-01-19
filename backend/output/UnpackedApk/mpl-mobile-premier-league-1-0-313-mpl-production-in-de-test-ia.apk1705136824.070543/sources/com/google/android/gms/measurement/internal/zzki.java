package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzki {
    public final Context zza;

    public zzki(Context context) {
        Preconditions.checkNotNull(context);
        this.zza = context;
    }

    public final void zzg(Intent intent) {
        if (intent == null) {
            zzk().zzd.zza("onRebind called with null intent");
            return;
        }
        zzk().zzl.zzb("onRebind called. action", intent.getAction());
    }

    public final boolean zzj(Intent intent) {
        if (intent == null) {
            zzk().zzd.zza("onUnbind called with null intent");
            return true;
        }
        zzk().zzl.zzb("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final zzey zzk() {
        return zzgi.zzp(this.zza, null, null).zzaz();
    }
}
