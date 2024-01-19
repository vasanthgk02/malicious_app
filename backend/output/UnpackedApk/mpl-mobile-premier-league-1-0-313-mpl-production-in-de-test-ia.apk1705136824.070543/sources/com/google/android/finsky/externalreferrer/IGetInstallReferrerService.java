package com.google.android.finsky.externalreferrer;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.a.a;
import com.google.android.a.b;
import com.google.android.a.c;

public interface IGetInstallReferrerService extends IInterface {

    public static abstract class Stub extends b implements IGetInstallReferrerService {

        public static class Proxy extends a implements IGetInstallReferrerService {
            public Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            }

            public final Bundle a(Bundle bundle) throws RemoteException {
                Parcelable parcelable;
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(this.f1717b);
                c.a(obtain, bundle);
                obtain = Parcel.obtain();
                try {
                    this.f1716a.transact(1, obtain, obtain, 0);
                    obtain.readException();
                    obtain.recycle();
                    Creator creator = Bundle.CREATOR;
                    if (obtain.readInt() == 0) {
                        parcelable = null;
                    } else {
                        parcelable = (Parcelable) creator.createFromParcel(obtain);
                    }
                    return (Bundle) parcelable;
                } catch (RuntimeException e2) {
                    throw e2;
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static IGetInstallReferrerService a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface instanceof IGetInstallReferrerService) {
                return (IGetInstallReferrerService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }
    }

    Bundle a(Bundle bundle) throws RemoteException;
}
