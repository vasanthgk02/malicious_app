package com.google.android.gms.internal.p000authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsCodeAutofillClient;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzr  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
public final class zzr extends GoogleApi<NoOptions> implements SmsCodeAutofillClient {
    public static final ClientKey<zzw> zza = new ClientKey<>();
    public static final AbstractClientBuilder<zzw, NoOptions> zzb;
    public static final Api<NoOptions> zzc;

    static {
        zzn zzn = new zzn();
        zzb = zzn;
        zzc = new Api<>("SmsCodeAutofill.API", zzn, zza);
    }

    public zzr(Activity activity) {
        super(activity, zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public final Task<Integer> checkPermissionState() {
        Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zzac.zza};
        builder.zaa = new zzk(this);
        builder.zad = 1564;
        return doRead(builder.build());
    }

    public final Task<Boolean> hasOngoingSmsRequest(String str) {
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(!str.isEmpty(), "The package name cannot be empty.");
        Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zzac.zza};
        builder.zaa = new zzm(this, str);
        builder.zad = 1565;
        return doRead(builder.build());
    }

    public final Task<Void> startSmsCodeRetriever() {
        Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zzac.zza};
        builder.zaa = new zzl(this);
        builder.zad = 1563;
        return doWrite(builder.build());
    }

    public zzr(Context context) {
        super(context, zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }
}
