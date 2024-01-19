package com.google.android.gms.cloudmessaging;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final /* synthetic */ class zzi implements Runnable {
    public final /* synthetic */ zzm zza;

    public /* synthetic */ zzi(zzm zzm) {
        this.zza = zzm;
    }

    public final void run() {
        zzm zzm = this.zza;
        synchronized (zzm) {
            if (zzm.zza == 1) {
                zzm.zza(1, "Timed out while binding");
            }
        }
    }
}
