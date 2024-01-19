package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbt extends zbo {
    public final Context zba;

    public zbt(Context context) {
        this.zba = context;
    }

    public final void zbb() {
        zbd();
        zbn.zbc(this.zba).zbd();
    }

    public final void zbc() {
        zbd();
        Storage instance = Storage.getInstance(this.zba);
        GoogleSignInAccount savedDefaultGoogleSignInAccount = instance.getSavedDefaultGoogleSignInAccount();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.DEFAULT_SIGN_IN;
        if (savedDefaultGoogleSignInAccount != null) {
            googleSignInOptions = instance.getSavedDefaultGoogleSignInOptions();
        }
        Context context = this.zba;
        Preconditions.checkNotNull(googleSignInOptions);
        GoogleSignInClient googleSignInClient = new GoogleSignInClient(context, googleSignInOptions);
        if (savedDefaultGoogleSignInAccount != null) {
            googleSignInClient.revokeAccess();
        } else {
            googleSignInClient.signOut();
        }
    }

    public final void zbd() {
        if (!UidVerifier.isGooglePlayServicesUid(this.zba, Binder.getCallingUid())) {
            int callingUid = Binder.getCallingUid();
            StringBuilder sb = new StringBuilder(52);
            sb.append("Calling UID ");
            sb.append(callingUid);
            sb.append(" is not Google Play services.");
            throw new SecurityException(sb.toString());
        }
    }
}
