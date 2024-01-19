package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.AuthProxy;
import com.google.android.gms.auth.api.AuthProxyOptions;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.zab;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzbe extends GmsClient<zzbh> {
    public final Bundle zze;

    public zzbe(Context context, Looper looper, ClientSettings clientSettings, AuthProxyOptions authProxyOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        Bundle bundle;
        super(context, looper, 16, clientSettings, connectionCallbacks, onConnectionFailedListener);
        if (authProxyOptions == null) {
            bundle = new Bundle();
        } else {
            bundle = new Bundle(authProxyOptions.zzb);
        }
        this.zze = bundle;
    }

    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (queryLocalInterface instanceof zzbh) {
            return (zzbh) queryLocalInterface;
        }
        return new zzbh(iBinder);
    }

    public final Bundle getGetServiceRequestExtraArgs() {
        return this.zze;
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.service.START";
    }

    public final boolean requiresSignIn() {
        Set set;
        ClientSettings clientSettings = getClientSettings();
        Account account = clientSettings.zaa;
        if (!TextUtils.isEmpty(account != null ? account.name : null)) {
            zab zab = (zab) clientSettings.zad.get(AuthProxy.API);
            if (zab == null || zab.zaa.isEmpty()) {
                set = clientSettings.zab;
            } else {
                AbstractSet hashSet = new HashSet(clientSettings.zab);
                hashSet.addAll(zab.zaa);
                set = hashSet;
            }
            if (!set.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
