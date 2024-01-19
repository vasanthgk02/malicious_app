package com.shield.android;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IIsolatedService extends IInterface {

    public static abstract class Stub extends Binder implements IIsolatedService {

        public static class a implements IIsolatedService {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f1447a;

            public a(IBinder iBinder) {
                this.f1447a = iBinder;
            }

            public IBinder asBinder() {
                return this.f1447a;
            }

            public boolean isMagiskPresent() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.shield.android.IIsolatedService");
                    boolean z = false;
                    this.f1447a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.shield.android.IIsolatedService");
        }

        public static IIsolatedService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.shield.android.IIsolatedService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IIsolatedService)) {
                return new a(iBinder);
            }
            return (IIsolatedService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.shield.android.IIsolatedService");
                boolean isMagiskPresent = isMagiskPresent();
                parcel2.writeNoException();
                parcel2.writeInt(isMagiskPresent ? 1 : 0);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.shield.android.IIsolatedService");
                return true;
            }
        }
    }

    boolean isMagiskPresent() throws RemoteException;
}
