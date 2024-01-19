package com.razorpay;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class AdvertisingIdUtil$Q_$2$ implements IInterface {
    public IBinder R$$r_;

    public AdvertisingIdUtil$Q_$2$(IBinder iBinder) {
        this.R$$r_ = iBinder;
    }

    public final String R$$r_() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.R$$r_.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.R$$r_;
    }

    public AdvertisingIdUtil$Q_$2$() {
    }
}
