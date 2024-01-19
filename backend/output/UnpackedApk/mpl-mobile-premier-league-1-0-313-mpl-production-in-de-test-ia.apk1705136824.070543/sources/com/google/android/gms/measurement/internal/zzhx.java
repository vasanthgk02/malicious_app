package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhx implements Runnable {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzin zzb;

    public zzhx(zzin zzin, Bundle bundle) {
        this.zzb = zzin;
        this.zza = bundle;
    }

    public final void run() {
        zzin zzin = this.zzb;
        Bundle bundle = this.zza;
        zzin.zzg();
        zzin.zza();
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString("name");
        Preconditions.checkNotEmpty(string);
        if (!zzin.zzs.zzJ()) {
            zzin.zzs.zzaz().zzl.zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzll zzll = new zzll(string, 0, null, "");
        try {
            zzab zzab = r4;
            zzab zzab2 = new zzab(bundle.getString("app_id"), "", zzll, bundle.getLong("creation_timestamp"), bundle.getBoolean(AppStateModule.APP_STATE_ACTIVE), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), zzin.zzs.zzv().zzz(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true, true));
            zzin.zzs.zzt().zzE(zzab);
        } catch (IllegalArgumentException unused) {
        }
    }
}
