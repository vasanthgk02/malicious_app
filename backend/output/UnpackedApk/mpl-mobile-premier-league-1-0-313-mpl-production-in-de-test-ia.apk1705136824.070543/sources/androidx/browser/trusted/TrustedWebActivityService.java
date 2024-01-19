package androidx.browser.trusted;

import a.a.a.a.d.b;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.customtabs.trusted.ITrustedWebActivityService$Stub;
import androidx.core.app.NotificationManagerCompat;
import java.util.Locale;

public abstract class TrustedWebActivityService extends Service {
    public final ITrustedWebActivityService$Stub mBinder = new ITrustedWebActivityService$Stub() {
        public final void checkCaller() {
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            if (trustedWebActivityService.mVerifiedUid == -1) {
                String[] packagesForUid = trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                if (packagesForUid == null) {
                    packagesForUid = new String[0];
                }
                Token load = TrustedWebActivityService.this.getTokenStore().load();
                TrustedWebActivityService.this.getPackageManager();
                if (load != null && packagesForUid.length > 0) {
                    String str = packagesForUid[0];
                    throw null;
                }
            }
            if (TrustedWebActivityService.this.mVerifiedUid != Binder.getCallingUid()) {
                throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
            }
        }
    };
    public NotificationManager mNotificationManager;
    public int mVerifiedUid = -1;

    public static String channelNameToId(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    public final void ensureOnCreateCalled() {
        if (this.mNotificationManager == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
    }

    public abstract TokenStore getTokenStore();

    public boolean onAreNotificationsEnabled(String str) {
        ensureOnCreateCalled();
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            return false;
        }
        if (VERSION.SDK_INT < 26) {
            return true;
        }
        return b.isChannelEnabled(this.mNotificationManager, channelNameToId(str));
    }

    public final IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public void onCancelNotification(String str, int i) {
        ensureOnCreateCalled();
        this.mNotificationManager.cancel(str, i);
    }

    public void onCreate() {
        super.onCreate();
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
    }

    public Parcelable[] onGetActiveNotifications() {
        ensureOnCreateCalled();
        if (VERSION.SDK_INT >= 23) {
            return this.mNotificationManager.getActiveNotifications();
        }
        throw new IllegalStateException("onGetActiveNotifications cannot be called pre-M.");
    }

    public Bundle onGetSmallIconBitmap() {
        int onGetSmallIconId = onGetSmallIconId();
        Bundle bundle = new Bundle();
        if (onGetSmallIconId == -1) {
            return bundle;
        }
        bundle.putParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP", BitmapFactory.decodeResource(getResources(), onGetSmallIconId));
        return bundle;
    }

    public int onGetSmallIconId() {
        int i = -1;
        try {
            ServiceInfo serviceInfo = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128);
            if (serviceInfo.metaData == null) {
                return -1;
            }
            i = serviceInfo.metaData.getInt("android.support.customtabs.trusted.SMALL_ICON", -1);
            return i;
        } catch (NameNotFoundException unused) {
        }
    }

    public boolean onNotifyNotificationWithChannel(String str, int i, Notification notification, String str2) {
        ensureOnCreateCalled();
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            return false;
        }
        if (VERSION.SDK_INT >= 26) {
            String channelNameToId = channelNameToId(str2);
            NotificationManager notificationManager = this.mNotificationManager;
            notificationManager.createNotificationChannel(new NotificationChannel(channelNameToId, str2, 3));
            if (notificationManager.getNotificationChannel(channelNameToId).getImportance() == 0) {
                notification = null;
            } else {
                Builder recoverBuilder = Builder.recoverBuilder(this, notification);
                recoverBuilder.setChannelId(channelNameToId);
                notification = recoverBuilder.build();
            }
            if (!b.isChannelEnabled(this.mNotificationManager, channelNameToId)) {
                return false;
            }
        }
        this.mNotificationManager.notify(str, i, notification);
        return true;
    }

    public final boolean onUnbind(Intent intent) {
        this.mVerifiedUid = -1;
        return super.onUnbind(intent);
    }
}
