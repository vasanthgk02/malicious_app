package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzaw extends zzaj {
    public ResultHolder<Status> zza;

    public zzaw(ResultHolder<Status> resultHolder) {
        this.zza = resultHolder;
    }

    public final void zzb(int i, String[] strArr) {
        if (this.zza == null) {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times", new Exception());
            return;
        }
        if ((i < 0 || i > 1) && (i < 1000 || i >= 1006)) {
            i = 1;
        }
        if (i == 1) {
            i = 13;
        }
        this.zza.setResult(new Status(i, null));
        this.zza = null;
    }

    public final void zzc(int i, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult", new Exception());
    }

    public final void zzd(int i, PendingIntent pendingIntent) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult", new Exception());
    }
}
