package com.google.android.gms.measurement.internal;

import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzr {
    public final zzgi zza;

    public zzr(zzgi zzgi) {
        this.zza = zzgi;
    }

    public final void zza(String str, Bundle bundle) {
        String str2;
        this.zza.zzaA().zzg();
        if (!this.zza.zzJ()) {
            if (bundle.isEmpty()) {
                str2 = null;
            } else {
                if (true == str.isEmpty()) {
                    str = "auto";
                }
                Builder builder = new Builder();
                builder.path(str);
                for (String str3 : bundle.keySet()) {
                    builder.appendQueryParameter(str3, bundle.getString(str3));
                }
                str2 = builder.build().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                this.zza.zzm().zzp.zzb(str2);
                this.zza.zzm().zzq.zzb(this.zza.zzr.currentTimeMillis());
            }
        }
    }

    public final boolean zzd() {
        return this.zza.zzm().zzq.zza() > 0;
    }

    public final boolean zze() {
        if (zzd() && this.zza.zzr.currentTimeMillis() - this.zza.zzm().zzq.zza() > this.zza.zzk.zzi(null, zzel.zzQ)) {
            return true;
        }
        return false;
    }
}
