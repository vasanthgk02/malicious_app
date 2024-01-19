package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzib implements zzlo {
    public final /* synthetic */ zzin zza;

    public zzib(zzin zzin) {
        this.zza = zzin;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzE("auto", "_err", bundle);
        } else if (this.zza != null) {
            zzgi.zzO();
            throw null;
        } else {
            throw null;
        }
    }
}
