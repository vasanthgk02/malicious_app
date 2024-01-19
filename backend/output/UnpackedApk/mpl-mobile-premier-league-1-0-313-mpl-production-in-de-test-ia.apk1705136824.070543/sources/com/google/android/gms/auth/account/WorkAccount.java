package com.google.android.gms.auth.account;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.auth.zzal;
import com.google.android.gms.internal.auth.zzam;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public class WorkAccount {
    public static final Api<NoOptions> API;
    public static final ClientKey<zzam> zza = new ClientKey<>();
    public static final AbstractClientBuilder<zzam, NoOptions> zzb;

    static {
        zzf zzf = new zzf();
        zzb = zzf;
        API = new Api<>("WorkAccount.API", zzf, zza);
        new zzal();
    }
}
