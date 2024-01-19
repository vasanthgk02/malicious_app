package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.auth.zze;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzab extends GoogleApi<NoOptions> implements zzg {
    public static final ClientKey<zzi> zza = new ClientKey<>();
    public static final AbstractClientBuilder<zzi, NoOptions> zzb;
    public static final Api<NoOptions> zzc;
    public static final Logger zzd = new Logger("Auth", "GoogleAuthServiceClient");

    static {
        zzv zzv = new zzv();
        zzb = zzv;
        zzc = new Api<>("GoogleAuthService.API", zzv, zza);
    }

    public zzab(Context context) {
        super(context, zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public static void zzf(Status status, Object obj, TaskCompletionSource taskCompletionSource) {
        if (!TaskUtil.trySetResultOrApiException(status, obj, taskCompletionSource)) {
            zzd.format("The task is already complete.", new Object[0]);
        }
    }

    public final Task<Void> zza(zzbw zzbw) {
        Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zze.zzf};
        builder.zaa = new zzt(this, zzbw);
        builder.zad = 1513;
        return doWrite(builder.build());
    }

    public final Task<AccountChangeEventsResponse> zzb(AccountChangeEventsRequest accountChangeEventsRequest) {
        Preconditions.checkNotNull(accountChangeEventsRequest, "request cannot be null.");
        Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zze.zzg};
        builder.zaa = new zzs(this, accountChangeEventsRequest);
        builder.zad = 1515;
        return doWrite(builder.build());
    }

    public final Task<Bundle> zzc(Account account, String str, Bundle bundle) {
        Preconditions.checkNotNull(account, "Account name cannot be null!");
        Preconditions.checkNotEmpty(str, "Scope cannot be null!");
        Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zze.zzf};
        builder.zaa = new zzr(this, account, str, bundle);
        builder.zad = 1512;
        return doWrite(builder.build());
    }

    public final Task<Bundle> zzd(Account account) {
        Preconditions.checkNotNull(account, "account cannot be null.");
        Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zze.zzg};
        builder.zaa = new zzq(this, account);
        builder.zad = 1517;
        return doWrite(builder.build());
    }

    public final Task<Bundle> zze(String str) {
        Preconditions.checkNotNull(str, "Client package name cannot be null!");
        Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zze.zzg};
        builder.zaa = new zzu(this, str);
        builder.zad = 1514;
        return doWrite(builder.build());
    }
}
