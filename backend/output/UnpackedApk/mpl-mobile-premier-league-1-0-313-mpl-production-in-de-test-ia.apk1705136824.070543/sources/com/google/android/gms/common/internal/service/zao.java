package com.google.android.gms.common.internal.service;

import android.content.Context;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zao extends GoogleApi implements TelemetryLoggingClient {
    public static final /* synthetic */ int zab = 0;
    public static final ClientKey zac = new ClientKey();
    public static final AbstractClientBuilder zad;
    public static final Api zae;

    static {
        zan zan = new zan();
        zad = zan;
        zae = new Api("ClientTelemetry.API", zan, zac);
    }

    public zao(Context context, TelemetryLoggingOptions telemetryLoggingOptions) {
        super(context, zae, telemetryLoggingOptions, Settings.DEFAULT_SETTINGS);
    }

    public final Task<Void> log(TelemetryData telemetryData) {
        Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zaf.zaa};
        builder.zab = false;
        builder.zaa = new zam(telemetryData);
        return doBestEffortWrite(builder.build());
    }
}
