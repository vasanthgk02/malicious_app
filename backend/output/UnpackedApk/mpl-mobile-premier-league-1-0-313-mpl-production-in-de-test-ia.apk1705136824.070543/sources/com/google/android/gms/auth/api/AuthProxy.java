package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.auth.zzbe;
import com.google.android.gms.internal.auth.zzbt;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class AuthProxy {
    @ShowFirstParty
    @KeepForSdk
    public static final Api<AuthProxyOptions> API;
    @ShowFirstParty
    @KeepForSdk
    public static final ProxyApi ProxyApi = new zzbt();
    public static final ClientKey<zzbe> zza = new ClientKey<>();
    public static final AbstractClientBuilder<zzbe, AuthProxyOptions> zzb;

    static {
        zza zza2 = new zza();
        zzb = zza2;
        API = new Api<>("Auth.PROXY_API", zza2, zza);
    }
}
