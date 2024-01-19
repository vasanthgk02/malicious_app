package com.google.android.apps.nbu.paisa.inapp.aidl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;

public interface IIsReadyToPayService extends IInterface {

    public static abstract class Stub extends BaseStub implements IIsReadyToPayService {

        public static class Proxy extends BaseProxy implements IIsReadyToPayService {
            public Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.apps.nbu.paisa.inapp.aidl.IIsReadyToPayService");
            }

            public void isReadyToPay(IsReadyToPayRequest isReadyToPayRequest, IIsReadyToPayServiceCallback iIsReadyToPayServiceCallback) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, isReadyToPayRequest);
                obtainAndWriteInterfaceToken.writeStrongBinder(iIsReadyToPayServiceCallback.asBinder());
                transactOneway(1, obtainAndWriteInterfaceToken);
            }
        }

        public static IIsReadyToPayService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.apps.nbu.paisa.inapp.aidl.IIsReadyToPayService");
            if (queryLocalInterface instanceof IIsReadyToPayService) {
                return (IIsReadyToPayService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }
    }

    void isReadyToPay(IsReadyToPayRequest isReadyToPayRequest, IIsReadyToPayServiceCallback iIsReadyToPayServiceCallback) throws RemoteException;
}
