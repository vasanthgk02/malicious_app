package com.google.android.gms.internal.p001authapi;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInRequest.Builder;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.identity.zbn;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbay  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbay extends GoogleApi implements SignInClient {
    public static final ClientKey zba = new ClientKey();
    public static final AbstractClientBuilder zbb;
    public static final Api zbc;
    public final String zbd = zbbb.zba();

    static {
        zbat zbat = new zbat();
        zbb = zbat;
        zbc = new Api("Auth.Api.Identity.SignIn.API", zbat, zba);
    }

    public zbay(Activity activity, zbn zbn) {
        super(activity, zbc, zbn, Settings.DEFAULT_SETTINGS);
    }

    public final Task<BeginSignInResult> beginSignIn(BeginSignInRequest beginSignInRequest) {
        Builder zba2 = BeginSignInRequest.zba(beginSignInRequest);
        zba2.zbc = this.zbd;
        BeginSignInRequest beginSignInRequest2 = new BeginSignInRequest(zba2.zba, zba2.zbb, zba2.zbc, zba2.zbd, zba2.zbe);
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zbba.zba};
        builder.zaa = new zbaq(this, beginSignInRequest2);
        builder.zab = false;
        builder.zad = 1553;
        return doRead(builder.build());
    }

    public final String getPhoneNumberFromIntent(Intent intent) throws ApiException {
        if (intent != null) {
            Status status = (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "status", Status.CREATOR);
            if (status == null) {
                throw new ApiException(Status.RESULT_CANCELED);
            } else if (status.isSuccess()) {
                String stringExtra = intent.getStringExtra("phone_number_hint_result");
                if (stringExtra != null) {
                    return stringExtra;
                }
                throw new ApiException(Status.RESULT_INTERNAL_ERROR);
            } else {
                throw new ApiException(status);
            }
        } else {
            throw new ApiException(Status.RESULT_INTERNAL_ERROR);
        }
    }

    public final Task<PendingIntent> getPhoneNumberHintIntent(GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest) {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zbba.zbh};
        builder.zaa = new zbar(this, getPhoneNumberHintIntentRequest);
        builder.zad = 1653;
        return doRead(builder.build());
    }

    public final SignInCredential getSignInCredentialFromIntent(Intent intent) throws ApiException {
        if (intent != null) {
            Status status = (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "status", Status.CREATOR);
            if (status == null) {
                throw new ApiException(Status.RESULT_CANCELED);
            } else if (status.isSuccess()) {
                SignInCredential signInCredential = (SignInCredential) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "sign_in_credential", SignInCredential.CREATOR);
                if (signInCredential != null) {
                    return signInCredential;
                }
                throw new ApiException(Status.RESULT_INTERNAL_ERROR);
            } else {
                throw new ApiException(status);
            }
        } else {
            throw new ApiException(Status.RESULT_INTERNAL_ERROR);
        }
    }

    public final Task<PendingIntent> getSignInIntent(GetSignInIntentRequest getSignInIntentRequest) {
        GetSignInIntentRequest.Builder zba2 = GetSignInIntentRequest.zba(getSignInIntentRequest);
        zba2.zbc = this.zbd;
        GetSignInIntentRequest getSignInIntentRequest2 = new GetSignInIntentRequest(zba2.zba, zba2.zbb, zba2.zbc, zba2.zbd, zba2.zbe, zba2.zbf);
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zbba.zbf};
        builder.zaa = new zbas(this, getSignInIntentRequest2);
        builder.zad = 1555;
        return doRead(builder.build());
    }

    public final Task<Void> signOut() {
        getApplicationContext().getSharedPreferences("com.google.android.gms.signin", 0).edit().clear().apply();
        for (GoogleApiClient maybeSignOut : GoogleApiClient.getAllClients()) {
            maybeSignOut.maybeSignOut();
        }
        GoogleApiManager.reportSignOut();
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.zac = new Feature[]{zbba.zbb};
        builder.zaa = new zbap(this);
        builder.zab = false;
        builder.zad = 1554;
        return doRead(builder.build());
    }

    public final /* synthetic */ void zba(GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest, zbaz zbaz, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zbai) zbaz.getService()).zbd(new zbax(this, taskCompletionSource), getPhoneNumberHintIntentRequest, this.zbd);
    }

    public final /* synthetic */ void zbb(zbaz zbaz, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zbai) zbaz.getService()).zbf(new zbav(this, taskCompletionSource), this.zbd);
    }

    public zbay(Context context, zbn zbn) {
        super(context, zbc, zbn, Settings.DEFAULT_SETTINGS);
    }
}
