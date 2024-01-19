package com.google.android.gms.internal.measurement;

import androidx.core.app.NotificationCompat;
import com.razorpay.AnalyticsConstants;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzt extends zzai {
    public final zzr zza;

    public zzt(zzr zzr) {
        super("internal.logger");
        this.zza = zzr;
        this.zze.put(AnalyticsConstants.LOG, new zzs(this, false, true));
        this.zze.put(NotificationCompat.GROUP_KEY_SILENT, new zzp(this, NotificationCompat.GROUP_KEY_SILENT));
        ((zzai) this.zze.get(NotificationCompat.GROUP_KEY_SILENT)).zzr(AnalyticsConstants.LOG, new zzs(this, true, true));
        this.zze.put("unmonitored", new zzq(this, "unmonitored"));
        ((zzai) this.zze.get("unmonitored")).zzr(AnalyticsConstants.LOG, new zzs(this, false, false));
    }

    public final zzap zza(zzg zzg, List list) {
        return zzap.zzf;
    }
}
