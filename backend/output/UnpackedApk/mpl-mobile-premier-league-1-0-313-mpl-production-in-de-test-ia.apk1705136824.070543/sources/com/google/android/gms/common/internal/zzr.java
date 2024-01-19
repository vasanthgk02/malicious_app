package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import com.google.firebase.perf.config.RemoteConfigManager;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzr extends GmsClientSupervisor {
    public final HashMap zzb = new HashMap();
    public final Context zzc;
    public volatile Handler zzd;
    public final zzq zze = new zzq(this);
    public final ConnectionTracker zzf;
    public final long zzg;
    public final long zzh;

    public zzr(Context context, Looper looper) {
        this.zzc = context.getApplicationContext();
        this.zzd = new zzi(looper, this.zze);
        this.zzf = ConnectionTracker.getInstance();
        this.zzg = RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS;
        this.zzh = 300000;
    }

    public final void zza(zzn zzn, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzb) {
            zzo zzo = (zzo) this.zzb.get(zzn);
            if (zzo == null) {
                String zzn2 = zzn.toString();
                throw new IllegalStateException("Nonexistent connection status for service config: " + zzn2);
            } else if (zzo.zzb.containsKey(serviceConnection)) {
                zzo.zzb.remove(serviceConnection);
                if (zzo.zzb.isEmpty()) {
                    this.zzd.sendMessageDelayed(this.zzd.obtainMessage(0, zzn), this.zzg);
                }
            } else {
                String zzn3 = zzn.toString();
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zzn3);
            }
        }
    }

    public final boolean zzc(zzn zzn, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean z;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzb) {
            zzo zzo = (zzo) this.zzb.get(zzn);
            if (zzo == null) {
                zzo = new zzo(this, zzn);
                zzo.zzb.put(serviceConnection, serviceConnection);
                zzo.zze(str, executor);
                this.zzb.put(zzn, zzo);
            } else {
                this.zzd.removeMessages(0, zzn);
                if (!zzo.zzb.containsKey(serviceConnection)) {
                    zzo.zzb.put(serviceConnection, serviceConnection);
                    int i = zzo.zzc;
                    if (i == 1) {
                        serviceConnection.onServiceConnected(zzo.zzg, zzo.zze);
                    } else if (i == 2) {
                        zzo.zze(str, executor);
                    }
                } else {
                    String zzn2 = zzn.toString();
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zzn2);
                }
            }
            z = zzo.zzd;
        }
        return z;
    }
}
