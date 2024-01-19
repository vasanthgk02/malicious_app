package com.google.android.gms.common.internal;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public abstract class zzc {
    public Object zza;
    public boolean zzb = false;
    public final /* synthetic */ BaseGmsClient zzd;

    public zzc(BaseGmsClient baseGmsClient, Object obj) {
        this.zzd = baseGmsClient;
        this.zza = obj;
    }

    public abstract void zza(Object obj);

    public final void zzg() {
        synchronized (this) {
            this.zza = null;
        }
        synchronized (this.zzd.zzt) {
            this.zzd.zzt.remove(this);
        }
    }
}
