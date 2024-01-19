package com.google.android.gms.internal.appset;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
public final class zzl implements AppSetIdClient {
    public static AppSetIdClient zza;
    public final Context zzb;
    public boolean zzc = false;
    public final ScheduledExecutorService zzd = Executors.newSingleThreadScheduledExecutor();
    public final ExecutorService zze = Executors.newSingleThreadExecutor();

    public zzl(Context context) {
        this.zzb = context;
        if (!this.zzc) {
            this.zzd.scheduleAtFixedRate(new zzj(this, null), 0, 86400, TimeUnit.SECONDS);
            this.zzc = true;
        }
    }

    public static synchronized AppSetIdClient zzc(Context context) {
        AppSetIdClient appSetIdClient;
        synchronized (zzl.class) {
            try {
                Preconditions.checkNotNull(context, "Context must not be null");
                if (zza == null) {
                    zza = new zzl(context.getApplicationContext());
                }
                appSetIdClient = zza;
            }
        }
        return appSetIdClient;
    }

    public static final void zze(Context context) {
        if (!zzf(context).edit().remove("app_set_id").commit()) {
            String valueOf = String.valueOf(context.getPackageName());
            if (valueOf.length() != 0) {
                "Failed to clear app set ID generated for App ".concat(valueOf);
            } else {
                new String("Failed to clear app set ID generated for App ");
            }
        }
        if (!zzf(context).edit().remove("app_set_id_last_used_time").commit()) {
            String valueOf2 = String.valueOf(context.getPackageName());
            if (valueOf2.length() != 0) {
                "Failed to clear app set ID last used time for App ".concat(valueOf2);
            } else {
                new String("Failed to clear app set ID last used time for App ");
            }
        }
    }

    public static final SharedPreferences zzf(Context context) {
        return context.getSharedPreferences("app_set_id_storage", 0);
    }

    public static final void zzg(Context context) throws zzk {
        SharedPreferences zzf = zzf(context);
        if (!zzf.edit().putLong("app_set_id_last_used_time", DefaultClock.zza.currentTimeMillis()).commit()) {
            String valueOf = String.valueOf(context.getPackageName());
            if (valueOf.length() != 0) {
                "Failed to store app set ID last used time for App ".concat(valueOf);
            } else {
                new String("Failed to store app set ID last used time for App ");
            }
            throw new zzk("Failed to store the app set ID last used time.");
        }
    }

    public final Task<AppSetIdInfo> getAppSetIdInfo() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zze.execute(new zzh(this, taskCompletionSource));
        return taskCompletionSource.zza;
    }

    public final long zza() {
        long j = zzf(this.zzb).getLong("app_set_id_last_used_time", -1);
        if (j != -1) {
            return j + 33696000000L;
        }
        return -1;
    }

    public final void zzd(TaskCompletionSource taskCompletionSource) {
        String string = zzf(this.zzb).getString("app_set_id", null);
        long zza2 = zza();
        if (string == null || DefaultClock.zza.currentTimeMillis() > zza2) {
            string = UUID.randomUUID().toString();
            try {
                Context context = this.zzb;
                if (!zzf(context).edit().putString("app_set_id", string).commit()) {
                    String valueOf = String.valueOf(context.getPackageName());
                    if (valueOf.length() != 0) {
                        "Failed to store app set ID generated for App ".concat(valueOf);
                    } else {
                        new String("Failed to store app set ID generated for App ");
                    }
                    throw new zzk("Failed to store the app set ID.");
                }
                zzg(context);
                Context context2 = this.zzb;
                SharedPreferences zzf = zzf(context2);
                if (!zzf.edit().putLong("app_set_id_creation_time", DefaultClock.zza.currentTimeMillis()).commit()) {
                    String valueOf2 = String.valueOf(context2.getPackageName());
                    if (valueOf2.length() != 0) {
                        "Failed to store app set ID creation time for App ".concat(valueOf2);
                    } else {
                        new String("Failed to store app set ID creation time for App ");
                    }
                    throw new zzk("Failed to store the app set ID creation time.");
                }
            } catch (zzk e2) {
                taskCompletionSource.zza.zza(e2);
                return;
            }
        } else {
            try {
                zzg(this.zzb);
            } catch (zzk e3) {
                taskCompletionSource.zza.zza(e3);
                return;
            }
        }
        taskCompletionSource.zza.zzb(new AppSetIdInfo(string, 1));
    }
}
