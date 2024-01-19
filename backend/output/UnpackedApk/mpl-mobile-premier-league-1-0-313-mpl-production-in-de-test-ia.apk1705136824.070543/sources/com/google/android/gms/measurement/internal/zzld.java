package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzld implements zzlo {
    public final /* synthetic */ zzli zza;

    public zzld(zzli zzli) {
        this.zza = zzli;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            zzgi zzgi = this.zza.zzn;
            if (zzgi != null) {
                zzgi.zzaz().zzd.zzb("AppId not known when logging event", "_err");
            }
            return;
        }
        this.zza.zzaA().zzp(new zzlc(this, str, bundle));
    }
}
