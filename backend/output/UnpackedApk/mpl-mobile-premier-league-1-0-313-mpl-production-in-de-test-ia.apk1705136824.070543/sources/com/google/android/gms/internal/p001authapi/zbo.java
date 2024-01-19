package com.google.android.gms.internal.p001authapi;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

/* renamed from: com.google.android.gms.internal.auth-api.zbo  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbo extends GmsClient {
    public final AuthCredentialsOptions zba;

    public zbo(Context context, Looper looper, ClientSettings clientSettings, AuthCredentialsOptions authCredentialsOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, clientSettings, connectionCallbacks, onConnectionFailedListener);
        Builder builder = new Builder(authCredentialsOptions == null ? AuthCredentialsOptions.zba : authCredentialsOptions);
        builder.zbb = zbbb.zba();
        this.zba = new AuthCredentialsOptions(builder);
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return queryLocalInterface instanceof zbt ? (zbt) queryLocalInterface : new zbt(iBinder);
    }

    public final Bundle getGetServiceRequestExtraArgs() {
        AuthCredentialsOptions authCredentialsOptions = this.zba;
        if (authCredentialsOptions != null) {
            Bundle outline14 = GeneratedOutlineSupport.outline14("consumer_package", null);
            outline14.putBoolean("force_save_dialog", authCredentialsOptions.zbc);
            outline14.putString("log_session_id", authCredentialsOptions.zbd);
            return outline14;
        }
        throw null;
    }

    public final int getMinApkVersion() {
        return 12800000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    public final AuthCredentialsOptions zba() {
        return this.zba;
    }
}
