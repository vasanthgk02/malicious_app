package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import com.paynimo.android.payment.util.Constant;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfg extends BroadcastReceiver {
    public final zzli zzb;
    public boolean zzc;
    public boolean zzd;

    static {
        Class<zzfg> cls = zzfg.class;
    }

    public zzfg(zzli zzli) {
        Preconditions.checkNotNull(zzli);
        this.zzb = zzli;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzb.zzB();
        String action = intent.getAction();
        this.zzb.zzaz().zzl.zzb("NetworkBroadcastReceiver received action", action);
        if (Constant.INTENT_NETWORK_STATUS.equals(action)) {
            zzfe zzfe = this.zzb.zzd;
            zzli.zzak(zzfe);
            boolean zza = zzfe.zza();
            if (this.zzd != zza) {
                this.zzd = zza;
                this.zzb.zzaA().zzp(new zzff(this, zza));
            }
            return;
        }
        this.zzb.zzaz().zzg.zzb("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void zzc() {
        this.zzb.zzB();
        this.zzb.zzaA().zzg();
        this.zzb.zzaA().zzg();
        if (this.zzc) {
            this.zzb.zzaz().zzl.zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zzn.zze.unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                this.zzb.zzaz().zzd.zzb("Failed to unregister the network broadcast receiver", e2);
            }
        }
    }
}
