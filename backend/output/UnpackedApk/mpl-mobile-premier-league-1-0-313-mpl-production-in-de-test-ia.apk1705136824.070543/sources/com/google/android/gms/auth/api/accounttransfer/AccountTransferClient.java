package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.auth.zzap;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public class AccountTransferClient extends GoogleApi<zzq> {
    public static final ClientKey<zzap> zzb = new ClientKey<>();
    public static final AbstractClientBuilder<zzap, zzq> zzc;

    static {
        zzb zzb2 = new zzb();
        zzc = zzb2;
        new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzb2, zzb);
    }
}
