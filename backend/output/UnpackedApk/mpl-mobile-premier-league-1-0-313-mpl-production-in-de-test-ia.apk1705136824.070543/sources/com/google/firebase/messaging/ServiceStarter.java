package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayDeque;
import java.util.Queue;

@KeepForSdk
public class ServiceStarter {
    public static ServiceStarter instance;
    public String firebaseMessagingServiceClassName = null;
    public Boolean hasAccessNetworkStatePermission = null;
    public Boolean hasWakeLockPermission = null;
    public final Queue<Intent> messagingEvents = new ArrayDeque();

    public static synchronized ServiceStarter getInstance() {
        ServiceStarter serviceStarter;
        synchronized (ServiceStarter.class) {
            try {
                if (instance == null) {
                    instance = new ServiceStarter();
                }
                serviceStarter = instance;
            }
        }
        return serviceStarter;
    }

    public boolean hasAccessNetworkStatePermission(Context context) {
        if (this.hasAccessNetworkStatePermission == null) {
            this.hasAccessNetworkStatePermission = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.hasWakeLockPermission.booleanValue()) {
            boolean isLoggable = Log.isLoggable("FirebaseMessaging", 3);
        }
        return this.hasAccessNetworkStatePermission.booleanValue();
    }

    public boolean hasWakeLockPermission(Context context) {
        if (this.hasWakeLockPermission == null) {
            this.hasWakeLockPermission = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.hasWakeLockPermission.booleanValue()) {
            boolean isLoggable = Log.isLoggable("FirebaseMessaging", 3);
        }
        return this.hasWakeLockPermission.booleanValue();
    }
}
