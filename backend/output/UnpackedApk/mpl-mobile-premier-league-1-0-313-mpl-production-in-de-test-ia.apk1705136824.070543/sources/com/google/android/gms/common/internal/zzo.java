package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.StrictMode;
import android.os.StrictMode.VmPolicy;
import android.os.StrictMode.VmPolicy.Builder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzo implements ServiceConnection, zzs {
    public final /* synthetic */ zzr zza;
    public final Map zzb = new HashMap();
    public int zzc = 2;
    public boolean zzd;
    public IBinder zze;
    public final zzn zzf;
    public ComponentName zzg;

    public zzo(zzr zzr, zzn zzn) {
        this.zza = zzr;
        this.zzf = zzn;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zza.zzb) {
            this.zza.zzd.removeMessages(1, this.zzf);
            this.zze = iBinder;
            this.zzg = componentName;
            for (ServiceConnection onServiceConnected : this.zzb.values()) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.zzc = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zza.zzb) {
            this.zza.zzd.removeMessages(1, this.zzf);
            this.zze = null;
            this.zzg = componentName;
            for (ServiceConnection onServiceDisconnected : this.zzb.values()) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.zzc = 2;
        }
    }

    public final void zze(String str, Executor executor) {
        this.zzc = 3;
        VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (VERSION.SDK_INT >= 31) {
            StrictMode.setVmPolicy(new Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            zzr zzr = this.zza;
            boolean zzc2 = zzr.zzf.zzc(zzr.zzc, str, this.zzf.zzc(zzr.zzc), this, this.zzf.zze, true, executor);
            this.zzd = zzc2;
            if (zzc2) {
                this.zza.zzd.sendMessageDelayed(this.zza.zzd.obtainMessage(1, this.zzf), this.zza.zzh);
            } else {
                this.zzc = 2;
                try {
                    zzr zzr2 = this.zza;
                    zzr2.zzf.unbindService(zzr2.zzc, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }
}
