package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class Common {
    @KeepForSdk
    public static final ClientKey<zah> CLIENT_KEY = new ClientKey<>();
    public static final AbstractClientBuilder zab;

    static {
        zab zab2 = new zab();
        zab = zab2;
        new Api("Common.API", zab2, CLIENT_KEY);
        new zae();
    }
}
