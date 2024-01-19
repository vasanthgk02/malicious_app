package com.google.android.gms.safetynet;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.safetynet.zzk;
import com.google.android.gms.internal.safetynet.zzx;
import com.google.android.gms.internal.safetynet.zzy;

public final class SafetyNet {
    @Deprecated
    public static final Api<NoOptions> API;
    public static final AbstractClientBuilder<zzx, NoOptions> CLIENT_BUILDER;
    public static final ClientKey<zzx> CLIENT_KEY = new ClientKey<>();

    static {
        zzk zzk = new zzk();
        CLIENT_BUILDER = zzk;
        API = new Api<>("SafetyNet.API", zzk, CLIENT_KEY);
        new zzk();
        new zzy();
    }

    public static SafetyNetClient getClient(Context context) {
        return new SafetyNetClient(context);
    }
}
