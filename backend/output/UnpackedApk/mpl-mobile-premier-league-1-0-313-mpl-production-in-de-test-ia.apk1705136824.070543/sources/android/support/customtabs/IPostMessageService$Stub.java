package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback.Stub;

public abstract class IPostMessageService$Stub extends Binder implements IInterface {
    public IPostMessageService$Stub() {
        attachInterface(this, "android.support.customtabs.IPostMessageService");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        Bundle bundle = null;
        if (i == 2) {
            parcel.enforceInterface("android.support.customtabs.IPostMessageService");
            ICustomTabsCallback asInterface = Stub.asInterface(parcel.readStrongBinder());
            if (parcel.readInt() != 0) {
                bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
            }
            asInterface.onMessageChannelReady(bundle);
            parcel2.writeNoException();
            return true;
        } else if (i == 3) {
            parcel.enforceInterface("android.support.customtabs.IPostMessageService");
            ICustomTabsCallback asInterface2 = Stub.asInterface(parcel.readStrongBinder());
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
            }
            asInterface2.onPostMessage(readString, bundle);
            parcel2.writeNoException();
            return true;
        } else if (i != 1598968902) {
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel2.writeString("android.support.customtabs.IPostMessageService");
            return true;
        }
    }
}
