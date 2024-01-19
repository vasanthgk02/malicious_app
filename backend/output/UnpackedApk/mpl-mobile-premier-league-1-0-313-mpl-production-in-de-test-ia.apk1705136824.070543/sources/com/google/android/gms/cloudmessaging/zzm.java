package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.cloudmessaging.zzf;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final class zzm implements ServiceConnection {
    public int zza = 0;
    public final Messenger zzb = new Messenger(new zzf(Looper.getMainLooper(), new zzf(this)));
    public zzn zzc;
    public final Queue<zzp<?>> zzd = new ArrayDeque();
    public final SparseArray<zzp<?>> zze = new SparseArray<>();
    public final /* synthetic */ zzs zzf;

    public /* synthetic */ zzm(zzs zzs, zzl zzl) {
        this.zzf = zzs;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean isLoggable = Log.isLoggable("MessengerIpcClient", 2);
        this.zzf.zzc.execute(new zzj(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        boolean isLoggable = Log.isLoggable("MessengerIpcClient", 2);
        this.zzf.zzc.execute(new zzg(this));
    }

    public final synchronized void zza(int i, String str) {
        zzb(i, str, null);
    }

    public final synchronized void zzb(int i, String str, Throwable th) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Disconnected: ".concat(valueOf);
            } else {
                new String("Disconnected: ");
            }
        }
        int i2 = this.zza;
        if (i2 == 0) {
            throw new IllegalStateException();
        } else if (i2 == 1 || i2 == 2) {
            Log.isLoggable("MessengerIpcClient", 2);
            this.zza = 4;
            ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
            zzq zzq = new zzq(str, th);
            for (zzp zzc2 : this.zzd) {
                zzc2.zzc(zzq);
            }
            this.zzd.clear();
            for (int i3 = 0; i3 < this.zze.size(); i3++) {
                this.zze.valueAt(i3).zzc(zzq);
            }
            this.zze.clear();
        } else if (i2 == 3) {
            this.zza = 4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzf() {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.zza     // Catch:{ all -> 0x002e }
            r1 = 2
            if (r0 != r1) goto L_0x002c
            java.util.Queue<com.google.android.gms.cloudmessaging.zzp<?>> r0 = r2.zzd     // Catch:{ all -> 0x002e }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x002c
            android.util.SparseArray<com.google.android.gms.cloudmessaging.zzp<?>> r0 = r2.zze     // Catch:{ all -> 0x002e }
            int r0 = r0.size()     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x002c
            java.lang.String r0 = "MessengerIpcClient"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x002e }
            r0 = 3
            r2.zza = r0     // Catch:{ all -> 0x002e }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ all -> 0x002e }
            com.google.android.gms.cloudmessaging.zzs r1 = r2.zzf     // Catch:{ all -> 0x002e }
            android.content.Context r1 = r1.zzb     // Catch:{ all -> 0x002e }
            r0.unbindService(r1, r2)     // Catch:{ all -> 0x002e }
            monitor-exit(r2)
            return
        L_0x002c:
            monitor-exit(r2)
            return
        L_0x002e:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzm.zzf():void");
    }

    public final synchronized boolean zzg(zzp<?> zzp) {
        int i = this.zza;
        if (i == 0) {
            this.zzd.add(zzp);
            Preconditions.checkState(this.zza == 0);
            Log.isLoggable("MessengerIpcClient", 2);
            this.zza = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            try {
                if (!ConnectionTracker.getInstance().bindService(this.zzf.zzb, intent, this, 1)) {
                    zza(0, "Unable to bind to service");
                } else {
                    this.zzf.zzc.schedule(new zzi(this), 30, TimeUnit.SECONDS);
                }
            } catch (SecurityException e2) {
                zzb(0, "Unable to bind to service", e2);
            }
        } else if (i == 1) {
            this.zzd.add(zzp);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            this.zzd.add(zzp);
            this.zzf.zzc.execute(new zzh(this));
            return true;
        }
        return true;
    }
}
