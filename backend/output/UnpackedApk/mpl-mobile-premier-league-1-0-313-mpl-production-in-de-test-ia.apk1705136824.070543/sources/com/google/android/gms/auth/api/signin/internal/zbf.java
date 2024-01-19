package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbf extends zba {
    public final /* synthetic */ zbg zba;

    public zbf(zbg zbg) {
        this.zba = zbg;
    }

    public final void zbd(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
        if (googleSignInAccount != null) {
            zbn zbc = zbn.zbc(this.zba.zba);
            GoogleSignInOptions googleSignInOptions = this.zba.zbb;
            synchronized (zbc) {
                zbc.zba.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
                zbc.zbb = googleSignInAccount;
                zbc.zbc = googleSignInOptions;
            }
        }
        this.zba.setResult(new GoogleSignInResult(googleSignInAccount, status));
    }
}
