package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p001authapi.zbb;
import com.google.android.gms.internal.p001authapi.zbc;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public abstract class zbq extends zbb implements zbr {
    public zbq() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    public final boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 101:
                zbd((GoogleSignInAccount) zbc.zba(parcel, GoogleSignInAccount.CREATOR), (Status) zbc.zba(parcel, Status.CREATOR));
                break;
            case 102:
                zbc((Status) zbc.zba(parcel, Status.CREATOR));
                break;
            case 103:
                zbb((Status) zbc.zba(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
