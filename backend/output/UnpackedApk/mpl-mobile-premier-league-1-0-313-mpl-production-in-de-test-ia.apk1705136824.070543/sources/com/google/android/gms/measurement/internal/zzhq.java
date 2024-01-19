package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.razorpay.AnalyticsConstants;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhq implements Runnable {
    public final /* synthetic */ zzin zza;

    public zzhq(zzin zzin) {
        this.zza = zzin;
    }

    public final void run() {
        String str;
        zzr zzr = this.zza.zzb;
        zzr.zza.zzaA().zzg();
        if (zzr.zzd()) {
            if (zzr.zze()) {
                zzr.zza.zzm().zzp.zzb(null);
                Bundle bundle = new Bundle();
                bundle.putString(DefaultSettingsSpiCall.SOURCE_PARAM, "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", AnalyticsConstants.INTENT);
                bundle.putLong("_cc", 1);
                zzr.zza.zzq().zzH("auto", "_cmpx", bundle);
            } else {
                String zza2 = zzr.zza.zzm().zzp.zza();
                if (TextUtils.isEmpty(zza2)) {
                    zzr.zza.zzaz().zze.zza("Cache still valid but referrer not found");
                } else {
                    long zza3 = ((zzr.zza.zzm().zzq.zza() / 3600000) - 1) * 3600000;
                    Uri parse = Uri.parse(zza2);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String next : parse.getQueryParameterNames()) {
                        bundle2.putString(next, parse.getQueryParameter(next));
                    }
                    ((Bundle) pair.second).putLong("_cc", zza3);
                    Object obj = pair.first;
                    if (obj == null) {
                        str = "app";
                    } else {
                        str = (String) obj;
                    }
                    zzr.zza.zzq().zzH(str, "_cmp", (Bundle) pair.second);
                }
                zzr.zza.zzm().zzp.zzb(null);
            }
            zzr.zza.zzm().zzq.zzb(0);
        }
    }
}
