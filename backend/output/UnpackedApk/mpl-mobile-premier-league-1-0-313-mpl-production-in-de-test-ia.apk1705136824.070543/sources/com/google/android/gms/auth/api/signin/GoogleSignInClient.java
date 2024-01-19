package com.google.android.gms.auth.api.signin;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.auth.api.signin.internal.zbb;
import com.google.android.gms.auth.api.signin.internal.zbi;
import com.google.android.gms.auth.api.signin.internal.zbk;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {
    @VisibleForTesting
    public static int zba = 1;
    public static final zbb zbb = new zbb();

    public GoogleSignInClient(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    public Task<Void> revokeAccess() {
        PendingResult pendingResult;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        boolean z = zba() == 3;
        zbm.zba.d("Revoking access", new Object[0]);
        String zaa = Storage.getInstance(applicationContext).zaa("refreshToken");
        zbm.zbh(applicationContext);
        if (z) {
            pendingResult = zbb.zba(zaa);
        } else {
            pendingResult = asGoogleApiClient.execute(new zbk(asGoogleApiClient));
        }
        return PendingResultUtil.toTask(pendingResult, new zar());
    }

    public Task<Void> signOut() {
        BasePendingResult basePendingResult;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        boolean z = zba() == 3;
        zbm.zba.d("Signing out", new Object[0]);
        zbm.zbh(applicationContext);
        if (z) {
            Status status = Status.RESULT_SUCCESS;
            Preconditions.checkNotNull(status, "Result must not be null");
            basePendingResult = new StatusPendingResult(asGoogleApiClient);
            basePendingResult.setResult(status);
        } else {
            basePendingResult = asGoogleApiClient.execute(new zbi(asGoogleApiClient));
        }
        return PendingResultUtil.toTask(basePendingResult, new zar());
    }

    public final synchronized int zba() {
        int i;
        try {
            i = zba;
            if (i == 1) {
                Context applicationContext = getApplicationContext();
                GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
                int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(applicationContext, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                if (isGooglePlayServicesAvailable == 0) {
                    zba = 4;
                    i = 4;
                } else if (googleApiAvailability.getErrorResolutionIntent(applicationContext, isGooglePlayServicesAvailable, null) != null || DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                    zba = 2;
                    i = 2;
                } else {
                    zba = 3;
                    i = 3;
                }
            }
        }
        return i;
    }
}
