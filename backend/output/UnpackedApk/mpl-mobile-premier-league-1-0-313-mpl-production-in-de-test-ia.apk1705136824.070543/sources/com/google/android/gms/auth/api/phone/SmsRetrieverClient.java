package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.internal.p000authapiphone.zzw;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
public abstract class SmsRetrieverClient extends GoogleApi<NoOptions> implements SmsRetrieverApi {
    public static final ClientKey<zzw> zza = new ClientKey<>();
    public static final AbstractClientBuilder<zzw, NoOptions> zzb;
    public static final Api<NoOptions> zzc;

    static {
        zza zza2 = new zza();
        zzb = zza2;
        zzc = new Api<>("SmsRetriever.API", zza2, zza);
    }

    public SmsRetrieverClient(Activity activity) {
        super(activity, zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }

    public abstract Task<Void> startSmsRetriever();

    public abstract Task<Void> startSmsUserConsent(String str);

    public SmsRetrieverClient(Context context) {
        super(context, zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
    }
}
