package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public interface zzg extends HasApiKey<NoOptions> {
    @KeepForSdk
    /* synthetic */ ApiKey<O> getApiKey();

    Task<Void> zza(zzbw zzbw);

    Task<AccountChangeEventsResponse> zzb(AccountChangeEventsRequest accountChangeEventsRequest);

    Task<Bundle> zzc(Account account, String str, Bundle bundle);

    Task<Bundle> zzd(Account account);

    Task<Bundle> zze(String str);
}
