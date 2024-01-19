package com.google.android.gms.internal.p000authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzab  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
public final class zzab extends SmsRetrieverClient {
    public zzab(Activity activity) {
        super(activity);
    }

    public final Task<Void> startSmsRetriever() {
        Builder builder = TaskApiCall.builder();
        builder.zaa = new zzx(this);
        builder.zac = new Feature[]{zzac.zzc};
        builder.zad = 1567;
        return doWrite(builder.build());
    }

    public final Task<Void> startSmsUserConsent(String str) {
        Builder builder = TaskApiCall.builder();
        builder.zaa = new zzy(this, str);
        builder.zac = new Feature[]{zzac.zzd};
        builder.zad = 1568;
        return doWrite(builder.build());
    }

    public zzab(Context context) {
        super(context);
    }
}
