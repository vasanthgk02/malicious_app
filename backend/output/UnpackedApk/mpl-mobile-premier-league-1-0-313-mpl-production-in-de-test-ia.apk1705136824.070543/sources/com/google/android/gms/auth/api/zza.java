package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.auth.zzbe;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zza extends AbstractClientBuilder<zzbe, AuthProxyOptions> {
    public final /* bridge */ /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        zzbe zzbe = new zzbe(context, looper, clientSettings, (AuthProxyOptions) obj, connectionCallbacks, onConnectionFailedListener);
        return zzbe;
    }
}
