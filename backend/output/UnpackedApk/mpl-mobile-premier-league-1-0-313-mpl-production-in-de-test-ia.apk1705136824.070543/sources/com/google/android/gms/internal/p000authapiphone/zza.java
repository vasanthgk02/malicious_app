package com.google.android.gms.internal.p000authapiphone;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zza  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
public class zza implements IInterface {
    public final IBinder zza;
    public final String zzb = "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";

    public zza(IBinder iBinder, String str) {
        this.zza = iBinder;
    }

    public final IBinder asBinder() {
        return this.zza;
    }

    public final Parcel zza() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        return obtain;
    }

    public final void zzb(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zza.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
