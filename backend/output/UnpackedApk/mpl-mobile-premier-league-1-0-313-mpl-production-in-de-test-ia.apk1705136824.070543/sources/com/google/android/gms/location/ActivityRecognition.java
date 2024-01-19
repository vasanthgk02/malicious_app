package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzg;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public class ActivityRecognition {
    public static final Api<NoOptions> API;
    public static final ClientKey<zzaz> zza = new ClientKey<>();
    public static final AbstractClientBuilder<zzaz, NoOptions> zzb;

    static {
        zza zza2 = new zza();
        zzb = zza2;
        API = new Api<>("ActivityRecognition.API", zza2, zza);
        new zzg();
    }
}
