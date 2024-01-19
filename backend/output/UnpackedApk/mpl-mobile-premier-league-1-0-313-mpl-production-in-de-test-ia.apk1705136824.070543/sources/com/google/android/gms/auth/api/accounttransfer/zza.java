package com.google.android.gms.auth.api.accounttransfer;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.auth.zzap;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zza extends AbstractClientBuilder<zzap, zzq> {
    public final /* bridge */ /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        zzap zzap = new zzap(context, looper, clientSettings, (zzq) obj, connectionCallbacks, onConnectionFailedListener);
        return zzap;
    }
}
