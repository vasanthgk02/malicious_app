package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public abstract class zza extends zzc {
    public final int zza;
    public final Bundle zzb;
    public final /* synthetic */ BaseGmsClient zzc;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zza(BaseGmsClient baseGmsClient, int i, Bundle bundle) {
        // this.zzc = baseGmsClient;
        super(baseGmsClient, Boolean.TRUE);
        this.zza = i;
        this.zzb = bundle;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        PendingIntent pendingIntent = null;
        if (this.zza == 0) {
            if (!zzd()) {
                this.zzc.zzp(1, null);
                zzb(new ConnectionResult(8, null));
            }
            return;
        }
        this.zzc.zzp(1, null);
        Bundle bundle = this.zzb;
        if (bundle != null) {
            pendingIntent = (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT);
        }
        zzb(new ConnectionResult(this.zza, pendingIntent));
    }

    public abstract void zzb(ConnectionResult connectionResult);

    public abstract boolean zzd();
}
