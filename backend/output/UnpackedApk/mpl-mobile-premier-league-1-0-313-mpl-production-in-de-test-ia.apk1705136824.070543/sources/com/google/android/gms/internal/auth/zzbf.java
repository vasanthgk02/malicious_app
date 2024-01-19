package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public abstract class zzbf extends zzb implements zzbg {
    public zzbf() {
        super("com.google.android.gms.auth.api.internal.IAuthCallbacks");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb((ProxyResponse) zzc.zza(parcel, ProxyResponse.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zzc(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
