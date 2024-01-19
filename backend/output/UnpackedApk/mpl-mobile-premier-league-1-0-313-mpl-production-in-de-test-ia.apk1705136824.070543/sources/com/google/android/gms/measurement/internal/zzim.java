package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzim implements ActivityLifecycleCallbacks {
    public final /* synthetic */ zzin zza;

    public /* synthetic */ zzim(zzin zzin) {
        this.zza = zzin;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzgi zzgi;
        try {
            this.zza.zzs.zzaz().zzl.zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                zzgi = this.zza.zzs;
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.zza.zzs.zzv();
                        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        boolean z = true;
                        String str = true != ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? "auto" : "gs";
                        String queryParameter = data.getQueryParameter("referrer");
                        if (bundle != null) {
                            z = false;
                        }
                        zzgf zzaA = this.zza.zzs.zzaA();
                        zzik zzik = new zzik(this, z, data, str, queryParameter);
                        zzaA.zzp(zzik);
                        zzgi = this.zza.zzs;
                    }
                }
                zzgi = this.zza.zzs;
            }
        } catch (RuntimeException e2) {
            this.zza.zzs.zzaz().zzd.zzb("Throwable caught in onActivityCreated", e2);
            zzgi = this.zza.zzs;
        } catch (Throwable th) {
            this.zza.zzs.zzs().zzr(activity, bundle);
            throw th;
        }
        zzgi.zzs().zzr(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        zzjb zzs = this.zza.zzs.zzs();
        synchronized (zzs.zzj) {
            if (activity == zzs.zze) {
                zzs.zze = null;
            }
        }
        if (zzs.zzs.zzk.zzu()) {
            zzs.zzd.remove(activity);
        }
    }

    public final void onActivityPaused(Activity activity) {
        zzjb zzs = this.zza.zzs.zzs();
        synchronized (zzs.zzj) {
            zzs.zzi = false;
            zzs.zzf = true;
        }
        long elapsedRealtime = zzs.zzs.zzr.elapsedRealtime();
        if (!zzs.zzs.zzk.zzu()) {
            zzs.zzb = null;
            zzs.zzs.zzaA().zzp(new zziy(zzs, elapsedRealtime));
        } else {
            zziu zzz = zzs.zzz(activity);
            zzs.zzc = zzs.zzb;
            zzs.zzb = null;
            zzs.zzs.zzaA().zzp(new zziz(zzs, zzz, elapsedRealtime));
        }
        zzkr zzu = this.zza.zzs.zzu();
        zzu.zzs.zzaA().zzp(new zzkk(zzu, zzu.zzs.zzr.elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzkr zzu = this.zza.zzs.zzu();
        zzu.zzs.zzaA().zzp(new zzkj(zzu, zzu.zzs.zzr.elapsedRealtime()));
        zzjb zzs = this.zza.zzs.zzs();
        synchronized (zzs.zzj) {
            zzs.zzi = true;
            if (activity != zzs.zze) {
                synchronized (zzs.zzj) {
                    zzs.zze = activity;
                    zzs.zzf = false;
                }
                if (zzs.zzs.zzk.zzu()) {
                    zzs.zzg = null;
                    zzs.zzs.zzaA().zzp(new zzja(zzs));
                }
            }
        }
        if (!zzs.zzs.zzk.zzu()) {
            zzs.zzb = zzs.zzg;
            zzs.zzs.zzaA().zzp(new zzix(zzs));
            return;
        }
        zzs.zzA(activity, zzs.zzz(activity), false);
        zzd zzd = zzs.zzs.zzd();
        zzd.zzs.zzaA().zzp(new zzc(zzd, zzd.zzs.zzr.elapsedRealtime()));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzjb zzs = this.zza.zzs.zzs();
        if (zzs.zzs.zzk.zzu() && bundle != null) {
            zziu zziu = (zziu) zzs.zzd.get(activity);
            if (zziu != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("id", zziu.zzc);
                bundle2.putString("name", zziu.zza);
                bundle2.putString("referrer_name", zziu.zzb);
                bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
            }
        }
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
