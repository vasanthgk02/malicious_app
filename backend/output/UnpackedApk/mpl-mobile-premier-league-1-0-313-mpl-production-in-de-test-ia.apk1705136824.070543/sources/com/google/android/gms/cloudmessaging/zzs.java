package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zze;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final class zzs {
    public static zzs zza;
    public final Context zzb;
    public final ScheduledExecutorService zzc;
    public zzm zzd = new zzm(this, null);
    public int zze = 1;

    public zzs(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public static synchronized zzs zzb(Context context) {
        zzs zzs;
        synchronized (zzs.class) {
            try {
                if (zza == null) {
                    zze.zza();
                    zza = new zzs(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
                }
                zzs = zza;
            }
        }
        return zzs;
    }

    public final synchronized <T> Task<T> zzg(zzp<T> zzp) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String.valueOf(zzp).length();
            }
            if (!this.zzd.zzg(zzp)) {
                zzm zzm = new zzm(this, null);
                this.zzd = zzm;
                zzm.zzg(zzp);
            }
        }
        return zzp.zzb.zza;
    }
}
