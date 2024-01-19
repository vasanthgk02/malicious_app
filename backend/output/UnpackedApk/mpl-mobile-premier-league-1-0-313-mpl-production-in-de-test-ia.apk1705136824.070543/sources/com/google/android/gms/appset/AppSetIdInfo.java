package com.google.android.gms.appset;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
public class AppSetIdInfo {
    public final String zza;
    public final int zzb;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
    public @interface Scope {
    }

    public AppSetIdInfo(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }
}
