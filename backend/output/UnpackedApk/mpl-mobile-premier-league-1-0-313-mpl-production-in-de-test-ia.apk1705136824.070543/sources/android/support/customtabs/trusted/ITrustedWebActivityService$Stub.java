package android.support.customtabs.trusted;

import a.a.a.a.d.b;
import android.app.Notification;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.browser.trusted.TrustedWebActivityService;
import androidx.browser.trusted.TrustedWebActivityService.AnonymousClass1;

public abstract class ITrustedWebActivityService$Stub extends Binder implements IInterface {
    public ITrustedWebActivityService$Stub() {
        attachInterface(this, "android.support.customtabs.trusted.ITrustedWebActivityService");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1598968902) {
            Bundle bundle = null;
            switch (i) {
                case 2:
                    parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    AnonymousClass1 r8 = (AnonymousClass1) this;
                    r8.checkCaller();
                    b.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
                    b.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
                    b.ensureBundleContains(bundle, "android.support.customtabs.trusted.NOTIFICATION");
                    b.ensureBundleContains(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
                    String string = bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME");
                    boolean onNotifyNotificationWithChannel = TrustedWebActivityService.this.onNotifyNotificationWithChannel(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"), (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION"), string);
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", onNotifyNotificationWithChannel);
                    parcel2.writeNoException();
                    parcel2.writeInt(1);
                    bundle2.writeToParcel(parcel2, 1);
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    AnonymousClass1 r82 = (AnonymousClass1) this;
                    r82.checkCaller();
                    b.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
                    b.ensureBundleContains(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
                    TrustedWebActivityService.this.onCancelNotification(bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG"), bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID"));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    AnonymousClass1 r83 = (AnonymousClass1) this;
                    r83.checkCaller();
                    int onGetSmallIconId = TrustedWebActivityService.this.onGetSmallIconId();
                    parcel2.writeNoException();
                    parcel2.writeInt(onGetSmallIconId);
                    return true;
                case 5:
                    parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    AnonymousClass1 r84 = (AnonymousClass1) this;
                    r84.checkCaller();
                    Parcelable[] onGetActiveNotifications = TrustedWebActivityService.this.onGetActiveNotifications();
                    Bundle bundle3 = new Bundle();
                    bundle3.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", onGetActiveNotifications);
                    parcel2.writeNoException();
                    parcel2.writeInt(1);
                    bundle3.writeToParcel(parcel2, 1);
                    return true;
                case 6:
                    parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    AnonymousClass1 r85 = (AnonymousClass1) this;
                    r85.checkCaller();
                    b.ensureBundleContains(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
                    boolean onAreNotificationsEnabled = TrustedWebActivityService.this.onAreNotificationsEnabled(bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME"));
                    Bundle bundle4 = new Bundle();
                    bundle4.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", onAreNotificationsEnabled);
                    parcel2.writeNoException();
                    parcel2.writeInt(1);
                    bundle4.writeToParcel(parcel2, 1);
                    return true;
                case 7:
                    parcel.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    AnonymousClass1 r86 = (AnonymousClass1) this;
                    r86.checkCaller();
                    Bundle onGetSmallIconBitmap = TrustedWebActivityService.this.onGetSmallIconBitmap();
                    parcel2.writeNoException();
                    if (onGetSmallIconBitmap != null) {
                        parcel2.writeInt(1);
                        onGetSmallIconBitmap.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        } else {
            parcel2.writeString("android.support.customtabs.trusted.ITrustedWebActivityService");
            return true;
        }
    }
}
