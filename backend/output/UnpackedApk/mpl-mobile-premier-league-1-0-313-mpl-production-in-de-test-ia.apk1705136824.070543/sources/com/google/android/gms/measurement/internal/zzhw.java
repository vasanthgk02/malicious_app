package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import io.hansel.core.criteria.HSLCriteriaBuilder;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhw implements Runnable {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzin zzb;

    public zzhw(zzin zzin, Bundle bundle) {
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
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get(HSLCriteriaBuilder.VALUE));
        if (!zzin.zzs.zzJ()) {
            zzin.zzs.zzaz().zzl.zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzll zzll = new zzll(string, bundle.getLong("triggered_timestamp"), bundle.get(HSLCriteriaBuilder.VALUE), string2);
        try {
            zzav zzz = zzin.zzs.zzv().zzz(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0, true, true);
            zzav zzz2 = zzin.zzs.zzv().zzz(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0, true, true);
            zzav zzz3 = zzin.zzs.zzv().zzz(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0, true, true);
            zzab zzab = new zzab(bundle.getString("app_id"), string2, zzll, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), zzz2, bundle.getLong("trigger_timeout"), zzz, bundle.getLong("time_to_live"), zzz3);
            zzin.zzs.zzt().zzE(zzab);
        } catch (IllegalArgumentException unused) {
        }
    }
}
