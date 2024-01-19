package com.google.android.gms.internal.auth;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.AuthProxy;
import com.google.android.gms.auth.api.AuthProxyOptions;
import com.google.android.gms.auth.api.proxy.ProxyClient;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzbo extends GoogleApi<AuthProxyOptions> implements ProxyClient {
    public zzbo(Activity activity, AuthProxyOptions authProxyOptions) {
        super(activity, AuthProxy.API, authProxyOptions == null ? AuthProxyOptions.zza : authProxyOptions, Settings.DEFAULT_SETTINGS);
    }

    public final Task<String> getSpatulaHeader() {
        Builder builder = TaskApiCall.builder();
        builder.zaa = new zzbk(this);
        builder.zad = 1520;
        return doRead(builder.build());
    }

    public final Task<ProxyResponse> performProxyRequest(ProxyRequest proxyRequest) {
        Builder builder = TaskApiCall.builder();
        builder.zaa = new zzbl(this, proxyRequest);
        builder.zad = 1518;
        return doWrite(builder.build());
    }

    public zzbo(Context context, AuthProxyOptions authProxyOptions) {
        super(context, AuthProxy.API, authProxyOptions == null ? AuthProxyOptions.zza : authProxyOptions, Settings.DEFAULT_SETTINGS);
    }
}
