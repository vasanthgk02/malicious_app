package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzb;
import com.google.android.gms.internal.auth.zzc;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public abstract class zza extends zzb implements zzb {
    public zza() {
        super("com.google.android.gms.auth.account.IWorkAccountCallback");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb((Account) zzc.zza(parcel, Account.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zzc(zzc.zze(parcel));
        }
        return true;
    }
}
