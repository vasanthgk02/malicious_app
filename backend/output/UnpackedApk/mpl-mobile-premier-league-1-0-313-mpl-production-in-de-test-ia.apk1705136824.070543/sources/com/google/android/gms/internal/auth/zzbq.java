package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzbq extends zzbi {
    public final /* synthetic */ ProxyRequest zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzbq(zzbt zzbt, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        // this.zza = proxyRequest;
        super(googleApiClient);
    }

    public final void zza(Context context, zzbh zzbh) throws RemoteException {
        zzbh.zze(new zzbp(this), this.zza);
    }
}
