package com.xiaomi.channel.commonutils.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class d {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f4308a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f173a;

        public a(String str, boolean z) {
            this.f4308a = str;
            this.f173a = z;
        }

        public String a() {
            return this.f4308a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m321a() {
            return this.f173a;
        }
    }

    public static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f4309a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f174a;

        public b() {
            this.f174a = false;
            this.f4309a = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() {
            if (!this.f174a) {
                this.f174a = true;
                return this.f4309a.poll(30000, TimeUnit.MILLISECONDS);
            }
            throw new IllegalStateException();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f4309a.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f4310a;

        public c(IBinder iBinder) {
            this.f4310a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f4310a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean a(boolean z) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z2 = true;
                obtain.writeInt(z ? 1 : 0);
                this.f4310a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z2 = false;
                }
                return z2;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f4310a;
        }
    }

    public static a a(Context context) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                b bVar = new b();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, bVar, 1)) {
                    try {
                        IBinder a2 = bVar.a();
                        if (a2 != null) {
                            c cVar = new c(a2);
                            a aVar = new a(cVar.a(), cVar.a(true));
                            context.unbindService(bVar);
                            return aVar;
                        }
                        context.unbindService(bVar);
                    } catch (Exception e2) {
                        throw e2;
                    } catch (Throwable th) {
                        context.unbindService(bVar);
                        throw th;
                    }
                }
                throw new IOException("Google Play connection failed");
            } catch (Exception e3) {
                throw e3;
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }
}
