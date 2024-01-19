package com.firebase.jobdispatcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IJobCallback extends IInterface {

    public static abstract class Stub extends Binder implements IJobCallback {

        public static class Proxy implements IJobCallback {
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void jobFinished(Bundle bundle, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.firebase.jobdispatcher.IJobCallback");
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.firebase.jobdispatcher.IJobCallback");
        }

        public static IJobCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.firebase.jobdispatcher.IJobCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IJobCallback)) {
                return new Proxy(iBinder);
            }
            return (IJobCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.firebase.jobdispatcher.IJobCallback");
                jobFinished(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.firebase.jobdispatcher.IJobCallback");
                return true;
            }
        }
    }

    void jobFinished(Bundle bundle, int i) throws RemoteException;
}
