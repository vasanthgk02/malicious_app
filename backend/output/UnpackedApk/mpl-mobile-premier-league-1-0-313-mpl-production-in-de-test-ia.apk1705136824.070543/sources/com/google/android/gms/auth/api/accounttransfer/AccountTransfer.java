package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.auth.zzao;
import com.google.android.gms.internal.auth.zzap;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class AccountTransfer {
    public static final ClientKey<zzap> zzd = new ClientKey<>();
    public static final AbstractClientBuilder<zzap, zzq> zze;

    static {
        zza zza = new zza();
        zze = zza;
        new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zza, zzd);
        new zzao();
        new zzao();
    }
}
