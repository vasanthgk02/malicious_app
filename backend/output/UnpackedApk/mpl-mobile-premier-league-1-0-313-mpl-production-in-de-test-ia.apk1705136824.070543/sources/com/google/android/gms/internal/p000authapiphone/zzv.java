package com.google.android.gms.internal.p000authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsCodeBrowserClient;
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
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzv  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
public final class zzv extends GoogleApi<NoOptions> implements SmsCodeBrowserClient {
    public static final ClientKey<zzw> zza = new ClientKey<>();
    public static final AbstractClientBuilder<zzw, NoOptions> zzb;
    public static final Api<NoOptions> zzc;

    static {
        zzt zzt = new zzt();
        zzb = zzt;
        zzc = new Api<>("SmsCodeBrowser.API", zzt, zza);
    }

    public zzv(Activity activity) {
        super(activity, zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public final Task<Void> startSmsCodeRetriever() {
        Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zzac.zzb};
        builder.zaa = new zzs(this);
        builder.zad = 1566;
        return doWrite(builder.build());
    }

    public zzv(Context context) {
        super(context, zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }
}
