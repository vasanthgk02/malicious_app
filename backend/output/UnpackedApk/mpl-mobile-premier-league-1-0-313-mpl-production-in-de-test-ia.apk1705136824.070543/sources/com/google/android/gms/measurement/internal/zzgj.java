package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final /* synthetic */ class zzgj implements Runnable {
    public final /* synthetic */ zzha zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Bundle zzc;

    public /* synthetic */ zzgj(zzha zzha, String str, Bundle bundle) {
        this.zza = zzha;
        this.zzb = str;
        this.zzc = bundle;
    }

    public final void run() {
        zzha zzha = this.zza;
        String str = this.zzb;
        Bundle bundle = this.zzc;
        zzal zzal = zzha.zza.zze;
        zzli.zzak(zzal);
        zzal.zzg();
        zzal.zzW();
        zzaq zzaq = new zzaq(zzal.zzs, (String) "", str, (String) "dep", 0, 0, bundle);
        zzlk zzlk = zzal.zzf.zzi;
        zzli.zzak(zzlk);
        byte[] zzby = zzlk.zzj(zzaq).zzby();
        zzal.zzs.zzaz().zzl.zzc("Saving default event parameters, appId, data size", zzal.zzs.zzq.zzd(str), Integer.valueOf(zzby.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY, zzby);
        try {
            if (zzal.zzh().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                zzal.zzs.zzaz().zzd.zzb("Failed to insert default event parameters (got -1). appId", zzey.zzn(str));
            }
        } catch (SQLiteException e2) {
            zzal.zzs.zzaz().zzd.zzc("Error storing default event parameters. appId", zzey.zzn(str), e2);
        }
    }
}
