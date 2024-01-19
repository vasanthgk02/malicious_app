package com.google.android.gms.internal.p001authapi;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.auth.api.identity.CredentialSavingClient;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest.Builder;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.auth.api.identity.zbc;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.android.gms.internal.auth-api.zbao  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbao extends GoogleApi implements CredentialSavingClient {
    public static final ClientKey zba = new ClientKey();
    public static final AbstractClientBuilder zbb;
    public static final Api zbc;
    public final String zbd = zbbb.zba();

    static {
        zbal zbal = new zbal();
        zbb = zbal;
        zbc = new Api("Auth.Api.Identity.CredentialSaving.API", zbal, zba);
    }

    public zbao(Activity activity, zbc zbc2) {
        super(activity, zbc, zbc2, Settings.DEFAULT_SETTINGS);
    }

    public final Task<SaveAccountLinkingTokenResult> saveAccountLinkingToken(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        Builder zba2 = SaveAccountLinkingTokenRequest.zba(saveAccountLinkingTokenRequest);
        zba2.zbe = this.zbd;
        Preconditions.checkArgument(zba2.zba != null, "Consent PendingIntent cannot be null");
        Preconditions.checkArgument("auth_code".equals(zba2.zbb), "Invalid tokenType");
        Preconditions.checkArgument(!TextUtils.isEmpty(zba2.zbc), "serviceId cannot be null or empty");
        Preconditions.checkArgument(zba2.zbd != null, "scopes cannot be null");
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest2 = new SaveAccountLinkingTokenRequest(zba2.zba, zba2.zbb, zba2.zbc, zba2.zbd, zba2.zbe, zba2.zbf);
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zbba.zbg};
        builder.zaa = new zbaj(this, saveAccountLinkingTokenRequest2);
        builder.zab = false;
        builder.zad = 1535;
        return doRead(builder.build());
    }

    public final Task<SavePasswordResult> savePassword(SavePasswordRequest savePasswordRequest) {
        SavePasswordRequest.Builder zba2 = SavePasswordRequest.zba(savePasswordRequest);
        zba2.zbb = this.zbd;
        SavePasswordRequest savePasswordRequest2 = new SavePasswordRequest(zba2.zba, zba2.zbb, zba2.zbc);
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zbba.zbe};
        builder.zaa = new zbak(this, savePasswordRequest2);
        builder.zab = false;
        builder.zad = 1536;
        return doRead(builder.build());
    }

    public zbao(Context context, zbc zbc2) {
        super(context, zbc, zbc2, Settings.DEFAULT_SETTINGS);
    }
}
