package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.location.zzaz;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbh extends AbstractClientBuilder<zzaz, NoOptions> {
    public final /* bridge */ /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        NoOptions noOptions = (NoOptions) obj;
        zzaz zzaz = new zzaz(context, looper, connectionCallbacks, onConnectionFailedListener, "locationServices", clientSettings);
        return zzaz;
    }
}
