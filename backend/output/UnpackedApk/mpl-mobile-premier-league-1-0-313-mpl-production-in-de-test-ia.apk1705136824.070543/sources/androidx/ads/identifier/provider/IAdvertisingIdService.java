package androidx.ads.identifier.provider;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAdvertisingIdService extends IInterface {

    public static abstract class Stub extends Binder implements IAdvertisingIdService {

        public static class Proxy implements IAdvertisingIdService {
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.ads.identifier.provider.IAdvertisingIdService");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isLimitAdTrackingEnabled() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.ads.identifier.provider.IAdvertisingIdService");
                    boolean z = false;
                    this.mRemote.transact(2, obtain, obtain2, 0);
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

        public static IAdvertisingIdService asInterface(IBinder iBinder) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.ads.identifier.provider.IAdvertisingIdService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IAdvertisingIdService)) {
                return new Proxy(iBinder);
            }
            return (IAdvertisingIdService) queryLocalInterface;
        }
    }

    String getId() throws RemoteException;

    boolean isLimitAdTrackingEnabled() throws RemoteException;
}
