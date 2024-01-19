package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzey;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzkf;
import com.google.android.gms.measurement.internal.zzkg;
import com.google.android.gms.measurement.internal.zzkh;
import com.google.android.gms.measurement.internal.zzki;
import com.google.android.gms.measurement.internal.zzli;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class AppMeasurementJobService extends JobService implements zzkh {
    public zzki zza;

    public void onCreate() {
        super.onCreate();
        zzgi.zzp(zzd().zza, null, null).zzaz().zzl.zza("Local AppMeasurementService is starting up");
    }

    public void onDestroy() {
        zzgi.zzp(zzd().zza, null, null).zzaz().zzl.zza("Local AppMeasurementService is shutting down");
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        zzd().zzg(intent);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        zzki zzd = zzd();
        zzey zzaz = zzgi.zzp(zzd.zza, null, null).zzaz();
        String string = jobParameters.getExtras().getString("action");
        zzaz.zzl.zzb("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            zzkf zzkf = new zzkf(zzd, zzaz, jobParameters);
            zzli zzt = zzli.zzt(zzd.zza);
            zzt.zzaA().zzp(new zzkg(zzt, zzkf));
        }
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public boolean onUnbind(Intent intent) {
        zzd().zzj(intent);
        return true;
    }

    public final void zza(Intent intent) {
    }

    @TargetApi(24)
    public final void zzb(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public final boolean zzc(int i) {
        throw new UnsupportedOperationException();
    }

    public final zzki zzd() {
        if (this.zza == null) {
            this.zza = new zzki(this);
        }
        return this.zza;
    }
}
