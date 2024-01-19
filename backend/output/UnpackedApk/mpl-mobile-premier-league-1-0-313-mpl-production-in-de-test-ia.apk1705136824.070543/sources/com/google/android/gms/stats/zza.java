package com.google.android.gms.stats;

/* compiled from: com.google.android.gms:play-services-stats@@17.0.1 */
public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ WakeLock zza;

    public /* synthetic */ zza(WakeLock wakeLock) {
        this.zza = wakeLock;
    }

    public final void run() {
        WakeLock wakeLock = this.zza;
        synchronized (wakeLock.zzf) {
            if (wakeLock.isHeld()) {
                String.valueOf(wakeLock.zzp).concat(" ** IS FORCE-RELEASED ON TIMEOUT **");
                wakeLock.zzc();
                if (wakeLock.isHeld()) {
                    wakeLock.zzh = 1;
                    wakeLock.zzd(0);
                }
            }
        }
    }
}
