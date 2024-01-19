package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: k  reason: default package */
public interface k extends IInterface {

    /* renamed from: k$a */
    public static abstract class a extends Binder implements k {

        /* renamed from: k$a$a  reason: collision with other inner class name */
        public static class C0064a implements k {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f3318a;

            public C0064a(IBinder iBinder) {
                this.f3318a = iBinder;
            }

            public Bundle a(Bundle bundle, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.userexperior.utilities.k.f4287a);
                    obtain.writeInt(0);
                    obtain.writeString(str);
                    this.f3318a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle a(Bundle bundle, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.userexperior.utilities.k.f4287a);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    boolean transact = this.f3318a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3318a;
            }

            public Bundle b(Bundle bundle, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.userexperior.utilities.k.f4287a);
                    obtain.writeInt(0);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.f3318a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static k a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(com.userexperior.utilities.k.f4287a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof k)) ? new C0064a(iBinder) : (k) queryLocalInterface;
        }
    }

    Bundle a(Bundle bundle, String str) throws RemoteException;

    Bundle a(Bundle bundle, String str, String[] strArr) throws RemoteException;

    Bundle b(Bundle bundle, String str, String[] strArr) throws RemoteException;
}
