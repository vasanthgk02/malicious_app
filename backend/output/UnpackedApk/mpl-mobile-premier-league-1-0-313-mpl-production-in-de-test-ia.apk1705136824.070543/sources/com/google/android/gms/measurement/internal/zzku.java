package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.internal.measurement.zzbs;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzku extends zzkw {
    public final AlarmManager zza = ((AlarmManager) this.zzs.zze.getSystemService(NotificationCompat.CATEGORY_ALARM));
    public zzao zzb;
    public Integer zzc;

    public zzku(zzli zzli) {
        super(zzli);
    }

    public final void zza() {
        zzW();
        this.zzs.zzaz().zzl.zza("Unscheduling upload");
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzh());
        }
        zzi().zzb();
        if (VERSION.SDK_INT >= 24) {
            zzj();
        }
    }

    public final boolean zzb() {
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzh());
        }
        if (VERSION.SDK_INT >= 24) {
            zzj();
        }
        return false;
    }

    public final int zzf() {
        if (this.zzc == null) {
            this.zzc = Integer.valueOf("measurement".concat(String.valueOf(this.zzs.zze.getPackageName())).hashCode());
        }
        return this.zzc.intValue();
    }

    public final PendingIntent zzh() {
        Context context = this.zzs.zze;
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), zzbs.zza);
    }

    public final zzao zzi() {
        if (this.zzb == null) {
            this.zzb = new zzkt(this, this.zzf.zzn);
        }
        return this.zzb;
    }

    @TargetApi(24)
    public final void zzj() {
        JobScheduler jobScheduler = (JobScheduler) this.zzs.zze.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(zzf());
        }
    }
}
