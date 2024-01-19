package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient.LegacyClientCallbackAdapter;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.signin.zae;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class SignInClientImpl extends GmsClient<zaf> implements zae {
    public static final /* synthetic */ int zaa = 0;
    public final boolean zab = true;
    public final ClientSettings zac;
    public final Bundle zad;
    public final Integer zae;

    public SignInClientImpl(Context context, Looper looper, ClientSettings clientSettings, Bundle bundle, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zac = clientSettings;
        this.zad = bundle;
        this.zae = clientSettings.zaj;
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof zaf ? (zaf) queryLocalInterface : new zaf(iBinder);
    }

    public final Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.zac.zag)) {
            this.zad.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zac.zag);
        }
        return this.zad;
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    public final boolean requiresSignIn() {
        return this.zab;
    }

    public final void zaa() {
        try {
            zaf zaf = (zaf) getService();
            Integer num = this.zae;
            Preconditions.checkNotNull(num);
            int intValue = num.intValue();
            Parcel zaa2 = zaf.zaa();
            zaa2.writeInt(intValue);
            zaf.zac(7, zaa2);
        } catch (RemoteException unused) {
        }
    }

    public final void zab() {
        connect(new LegacyClientCallbackAdapter());
    }

    public final void zac(IAccountAccessor iAccountAccessor, boolean z) {
        try {
            zaf zaf = (zaf) getService();
            Integer num = this.zae;
            Preconditions.checkNotNull(num);
            int intValue = num.intValue();
            Parcel zaa2 = zaf.zaa();
            zac.zae(zaa2, iAccountAccessor);
            zaa2.writeInt(intValue);
            zac.zac(zaa2, z);
            zaf.zac(9, zaa2);
        } catch (RemoteException unused) {
        }
    }

    public final void zad(zae zae2) {
        Preconditions.checkNotNull(zae2, "Expecting a valid ISignInCallbacks");
        try {
            Account account = this.zac.zaa;
            if (account == null) {
                account = new Account(BaseGmsClient.DEFAULT_ACCOUNT, "com.google");
            }
            GoogleSignInAccount savedDefaultGoogleSignInAccount = BaseGmsClient.DEFAULT_ACCOUNT.equals(account.name) ? Storage.getInstance(getContext()).getSavedDefaultGoogleSignInAccount() : null;
            Integer num = this.zae;
            Preconditions.checkNotNull(num);
            zat zat = new zat(account, num.intValue(), savedDefaultGoogleSignInAccount);
            zaf zaf = (zaf) getService();
            zai zai = new zai(1, zat);
            Parcel zaa2 = zaf.zaa();
            zac.zad(zaa2, zai);
            zac.zae(zaa2, zae2);
            zaf.zac(12, zaa2);
        } catch (RemoteException e2) {
            try {
                zae2.zab(new zak(1, new ConnectionResult(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }
}
