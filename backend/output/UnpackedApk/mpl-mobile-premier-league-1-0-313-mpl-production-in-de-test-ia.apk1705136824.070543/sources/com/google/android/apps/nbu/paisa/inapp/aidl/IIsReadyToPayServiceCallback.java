package com.google.android.apps.nbu.paisa.inapp.aidl;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;
import com.google.android.apps.nbu.paisa.inapp.client.api.PaymentsClient.IsReadyToPayServiceConnection;
import com.google.android.apps.nbu.paisa.inapp.client.api.PaymentsClient.IsReadyToPayServiceConnection.AnonymousClass1;
import com.google.android.gms.tasks.TaskCompletionSource;

public interface IIsReadyToPayServiceCallback extends IInterface {

    public static abstract class Stub extends BaseStub implements IIsReadyToPayServiceCallback {
        public Stub() {
            super("com.google.android.apps.nbu.paisa.inapp.aidl.IIsReadyToPayServiceCallback");
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            boolean createBoolean = Codecs.createBoolean(parcel);
            AnonymousClass1 r2 = (AnonymousClass1) this;
            TaskCompletionSource<Boolean> taskCompletionSource = IsReadyToPayServiceConnection.this.isReadyToPayCompletionSource;
            taskCompletionSource.zza.zzb(Boolean.valueOf(createBoolean));
            IsReadyToPayServiceConnection.this.disconnect();
            return true;
        }
    }
}
