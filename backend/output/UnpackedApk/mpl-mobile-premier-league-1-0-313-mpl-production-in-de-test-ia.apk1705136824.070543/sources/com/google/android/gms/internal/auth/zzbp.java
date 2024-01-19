package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzbp extends zzbd {
    public final /* synthetic */ zzbq zza;

    public zzbp(zzbq zzbq) {
        this.zza = zzbq;
    }

    public final void zzb(ProxyResponse proxyResponse) {
        this.zza.setResult(new zzbu(proxyResponse));
    }
}
