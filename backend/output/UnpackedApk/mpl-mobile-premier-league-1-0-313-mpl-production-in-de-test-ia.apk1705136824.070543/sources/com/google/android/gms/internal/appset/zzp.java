package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.appset.zze;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
public final class zzp extends GoogleApi<NoOptions> implements AppSetIdClient {
    public static final ClientKey<zzd> zza = new ClientKey<>();
    public static final AbstractClientBuilder<zzd, NoOptions> zzb;
    public static final Api<NoOptions> zzc;
    public final Context zzd;
    public final GoogleApiAvailabilityLight zze;

    static {
        zzn zzn = new zzn();
        zzb = zzn;
        zzc = new Api<>("AppSet.API", zzn, zza);
    }

    public zzp(Context context, GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        super(context, zzc, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
        this.zzd = context;
        this.zze = googleApiAvailabilityLight;
    }

    public final Task<AppSetIdInfo> getAppSetIdInfo() {
        if (this.zze.isGooglePlayServicesAvailable(this.zzd, 212800000) != 0) {
            return Tasks.forException(new ApiException(new Status(17, null)));
        }
        Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zze.zza};
        builder.zaa = new zzm(this);
        builder.zab = false;
        builder.zad = 27601;
        return doRead(builder.build());
    }
}
