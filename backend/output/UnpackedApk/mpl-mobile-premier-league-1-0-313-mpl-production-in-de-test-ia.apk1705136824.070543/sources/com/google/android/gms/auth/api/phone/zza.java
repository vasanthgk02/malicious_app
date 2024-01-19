package com.google.android.gms.auth.api.phone;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.p000authapiphone.zzw;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
public final class zza extends AbstractClientBuilder<zzw, NoOptions> {
    public final /* bridge */ /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        NoOptions noOptions = (NoOptions) obj;
        zzw zzw = new zzw(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener);
        return zzw;
    }
}
