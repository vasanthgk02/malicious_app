package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzbq;
import com.google.android.gms.internal.measurement.zzbr;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfp implements ServiceConnection {
    public final /* synthetic */ zzfq zza;
    public final String zzb;

    public zzfp(zzfq zzfq, String str) {
        this.zza = zzfq;
        this.zzb = str;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            try {
                zzbr zzb2 = zzbq.zzb(iBinder);
                if (zzb2 == null) {
                    this.zza.zza.zzaz().zzg.zza("Install Referrer Service implementation was not found");
                    return;
                }
                this.zza.zza.zzaz().zzl.zza("Install Referrer Service connected");
                this.zza.zza.zzaA().zzp(new zzfo(this, zzb2, this));
            } catch (RuntimeException e2) {
                this.zza.zza.zzaz().zzg.zzb("Exception occurred while calling Install Referrer API", e2);
            }
        } else {
            this.zza.zza.zzaz().zzg.zza("Install Referrer connection returned with null binder");
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzaz().zzl.zza("Install Referrer Service disconnected");
    }
}
