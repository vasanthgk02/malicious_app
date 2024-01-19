package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
public final class zzr implements AppSetIdClient {
    public final AppSetIdClient zza;
    public final AppSetIdClient zzb;

    public zzr(Context context) {
        this.zza = new zzp(context, GoogleApiAvailabilityLight.zza);
        this.zzb = zzl.zzc(context);
    }

    public static Task zza(zzr zzr, Task<AppSetIdInfo> task) {
        if (!task.isSuccessful() && !((zzw) task).zzd) {
            Exception exception = task.getException();
            if (exception instanceof ApiException) {
                int i = ((ApiException) exception).mStatus.zzc;
                if (i == 43001 || i == 43002 || i == 43003 || i == 17) {
                    task = zzr.zzb.getAppSetIdInfo();
                } else if (i == 43000) {
                    task = Tasks.forException(new Exception("Failed to get app set ID due to an internal error. Please try again later."));
                } else if (i == 15) {
                    return Tasks.forException(new Exception("The operation to get app set ID timed out. Please try again later."));
                }
            }
        }
        return task;
    }

    public final Task<AppSetIdInfo> getAppSetIdInfo() {
        return this.zza.getAppSetIdInfo().continueWithTask(new zzq(this));
    }
}
