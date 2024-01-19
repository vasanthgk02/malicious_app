package com.appsflyer.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.appsflyer.AFLogger;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Deprecated
public final class aa {
    public final Context AFInAppEventParameterName;
    public Bundle valueOf;

    public static final class a implements ServiceConnection {
        public boolean AFKeystoreWrapper;
        public final LinkedBlockingQueue<IBinder> valueOf;

        public a() {
            this.valueOf = new LinkedBlockingQueue<>(1);
            this.AFKeystoreWrapper = false;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.valueOf.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class c implements IInterface {
        public final IBinder AFKeystoreWrapper;

        public c(IBinder iBinder) {
            this.AFKeystoreWrapper = iBinder;
        }

        public final String AFInAppEventType() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.AFKeystoreWrapper.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final IBinder asBinder() {
            return this.AFKeystoreWrapper;
        }

        public final boolean values() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.AFKeystoreWrapper.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static final class e {
        public final String AFInAppEventParameterName;
        public final boolean valueOf;

        public e(String str, boolean z) {
            this.AFInAppEventParameterName = str;
            this.valueOf = z;
        }

        public final boolean AFKeystoreWrapper() {
            return this.valueOf;
        }
    }

    public aa() {
    }

    public static e AFKeystoreWrapper(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            a aVar = new a(0);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (!context.bindService(intent, aVar, 1)) {
                    context.unbindService(aVar);
                    throw new IOException("Google Play connection failed");
                } else if (!aVar.AFKeystoreWrapper) {
                    aVar.AFKeystoreWrapper = true;
                    IBinder poll = aVar.valueOf.poll(10, TimeUnit.SECONDS);
                    if (poll != null) {
                        c cVar = new c(poll);
                        return new e(cVar.AFInAppEventType(), cVar.values());
                    }
                    throw new TimeoutException("Timed out waiting for the service connection");
                } else {
                    throw new IllegalStateException("Cannot call get on this connection more than once");
                }
            } finally {
                context.unbindService(aVar);
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }

    public final String AFInAppEventParameterName(String str) {
        try {
            if (this.valueOf == null) {
                this.valueOf = this.AFInAppEventParameterName.getPackageManager().getApplicationInfo(this.AFInAppEventParameterName.getPackageName(), 128).metaData;
            }
            Bundle bundle = this.valueOf;
            if (bundle != null) {
                Object obj = bundle.get(str);
                if (obj != null) {
                    return obj.toString();
                }
            }
            return null;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Could not load manifest metadata!");
            sb.append(th.getMessage());
            AFLogger.valueOf(sb.toString(), th);
            return null;
        }
    }

    public aa(Context context) {
        this.valueOf = null;
        this.AFInAppEventParameterName = context.getApplicationContext();
    }
}
