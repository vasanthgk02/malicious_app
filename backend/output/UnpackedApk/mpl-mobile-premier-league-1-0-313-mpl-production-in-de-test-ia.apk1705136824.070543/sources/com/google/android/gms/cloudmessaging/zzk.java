package com.google.android.gms.cloudmessaging;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public final /* synthetic */ class zzk implements Runnable {
    public final /* synthetic */ zzm zza;
    public final /* synthetic */ zzp zzb;

    public /* synthetic */ zzk(zzm zzm, zzp zzp) {
        this.zza = zzm;
        this.zzb = zzp;
    }

    public final void run() {
        zzm zzm = this.zza;
        int i = this.zzb.zza;
        synchronized (zzm) {
            zzp zzp = zzm.zze.get(i);
            if (zzp != null) {
                zzm.zze.remove(i);
                zzp.zzc(new zzq("Timed out waiting for response", null));
                zzm.zzf();
            }
        }
    }
}
