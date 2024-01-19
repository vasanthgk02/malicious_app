package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzey;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzke;
import com.google.android.gms.measurement.internal.zzkg;
import com.google.android.gms.measurement.internal.zzkh;
import com.google.android.gms.measurement.internal.zzki;
import com.google.android.gms.measurement.internal.zzli;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class AppMeasurementService extends Service implements zzkh {
    public zzki zza;

    public IBinder onBind(Intent intent) {
        zzki zzd = zzd();
        if (zzd == null) {
            throw null;
        } else if (intent == null) {
            zzd.zzk().zzd.zza("onBind called with null intent");
            return null;
        } else {
            String action = intent.getAction();
            if ("com.google.android.gms.measurement.START".equals(action)) {
                return new zzha(zzli.zzt(zzd.zza));
            }
            zzd.zzk().zzg.zzb("onBind received unknown action", action);
            return null;
        }
    }

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

    public int onStartCommand(Intent intent, int i, int i2) {
        zzki zzd = zzd();
        zzey zzaz = zzgi.zzp(zzd.zza, null, null).zzaz();
        if (intent == null) {
            zzaz.zzg.zza("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            zzaz.zzl.zzc("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                zzke zzke = new zzke(zzd, i2, zzaz, intent);
                zzli zzt = zzli.zzt(zzd.zza);
                zzt.zzaA().zzp(new zzkg(zzt, zzke));
            }
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        zzd().zzj(intent);
        return true;
    }

    public final void zza(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    public final void zzb(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final boolean zzc(int i) {
        return stopSelfResult(i);
    }

    public final zzki zzd() {
        if (this.zza == null) {
            this.zza = new zzki(this);
        }
        return this.zza;
    }
}
