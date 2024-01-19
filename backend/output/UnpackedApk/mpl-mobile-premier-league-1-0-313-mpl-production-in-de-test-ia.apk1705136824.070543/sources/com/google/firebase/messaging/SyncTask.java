package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.paynimo.android.payment.util.Constant;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SyncTask implements Runnable {
    public final FirebaseMessaging firebaseMessaging;
    public final long nextDelaySeconds;
    public final WakeLock syncWakeLock;

    @VisibleForTesting
    public static class ConnectivityChangeReceiver extends BroadcastReceiver {
        public SyncTask task;

        public ConnectivityChangeReceiver(SyncTask syncTask) {
            this.task = syncTask;
        }

        public void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.task;
            if (syncTask != null && syncTask.isDeviceConnected()) {
                boolean isDebugLogEnabled = SyncTask.isDebugLogEnabled();
                SyncTask syncTask2 = this.task;
                syncTask2.firebaseMessaging.enqueueTaskWithDelaySeconds(syncTask2, 0);
                this.task.firebaseMessaging.context.unregisterReceiver(this);
                this.task = null;
            }
        }

        public void registerReceiver() {
            boolean isDebugLogEnabled = SyncTask.isDebugLogEnabled();
            this.task.firebaseMessaging.context.registerReceiver(this, new IntentFilter(Constant.INTENT_NETWORK_STATUS));
        }
    }

    @SuppressLint({"InvalidWakeLockTag"})
    @VisibleForTesting
    public SyncTask(FirebaseMessaging firebaseMessaging2, long j) {
        new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));
        this.firebaseMessaging = firebaseMessaging2;
        this.nextDelaySeconds = j;
        WakeLock newWakeLock = ((PowerManager) firebaseMessaging2.context.getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.syncWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    public static boolean isDebugLogEnabled() {
        return Log.isLoggable("FirebaseMessaging", 3) || (VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    public boolean isDeviceConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.firebaseMessaging.context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @VisibleForTesting
    public boolean maybeRefreshToken() throws IOException {
        boolean z = true;
        try {
            if (this.firebaseMessaging.blockingGetToken() == null) {
                return false;
            }
            boolean isLoggable = Log.isLoggable("FirebaseMessaging", 3);
            return true;
        } catch (IOException e2) {
            String message = e2.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                z = false;
            }
            if (z) {
                e2.getMessage();
                return false;
            } else if (e2.getMessage() == null) {
                return false;
            } else {
                throw e2;
            }
        } catch (SecurityException unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008c, code lost:
        if (com.google.firebase.messaging.ServiceStarter.getInstance().hasWakeLockPermission(r4.firebaseMessaging.context) != false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008e, code lost:
        r4.syncWakeLock.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ac, code lost:
        if (com.google.firebase.messaging.ServiceStarter.getInstance().hasWakeLockPermission(r4.firebaseMessaging.context) == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00af, code lost:
        return;
     */
    @android.annotation.SuppressLint({"WakelockTimeout"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            com.google.firebase.messaging.ServiceStarter r0 = com.google.firebase.messaging.ServiceStarter.getInstance()
            com.google.firebase.messaging.FirebaseMessaging r1 = r4.firebaseMessaging
            android.content.Context r1 = r1.context
            boolean r0 = r0.hasWakeLockPermission(r1)
            if (r0 == 0) goto L_0x0013
            android.os.PowerManager$WakeLock r0 = r4.syncWakeLock
            r0.acquire()
        L_0x0013:
            r0 = 0
            com.google.firebase.messaging.FirebaseMessaging r1 = r4.firebaseMessaging     // Catch:{ IOException -> 0x0094 }
            r2 = 1
            r1.setSyncScheduledOrRunning(r2)     // Catch:{ IOException -> 0x0094 }
            com.google.firebase.messaging.FirebaseMessaging r1 = r4.firebaseMessaging     // Catch:{ IOException -> 0x0094 }
            com.google.firebase.messaging.Metadata r1 = r1.metadata     // Catch:{ IOException -> 0x0094 }
            boolean r1 = r1.isGmscorePresent()     // Catch:{ IOException -> 0x0094 }
            if (r1 != 0) goto L_0x003d
            com.google.firebase.messaging.FirebaseMessaging r1 = r4.firebaseMessaging     // Catch:{ IOException -> 0x0094 }
            r1.setSyncScheduledOrRunning(r0)     // Catch:{ IOException -> 0x0094 }
            com.google.firebase.messaging.ServiceStarter r0 = com.google.firebase.messaging.ServiceStarter.getInstance()
            com.google.firebase.messaging.FirebaseMessaging r1 = r4.firebaseMessaging
            android.content.Context r1 = r1.context
            boolean r0 = r0.hasWakeLockPermission(r1)
            if (r0 == 0) goto L_0x003c
            android.os.PowerManager$WakeLock r0 = r4.syncWakeLock
            r0.release()
        L_0x003c:
            return
        L_0x003d:
            com.google.firebase.messaging.ServiceStarter r1 = com.google.firebase.messaging.ServiceStarter.getInstance()     // Catch:{ IOException -> 0x0094 }
            com.google.firebase.messaging.FirebaseMessaging r2 = r4.firebaseMessaging     // Catch:{ IOException -> 0x0094 }
            android.content.Context r2 = r2.context     // Catch:{ IOException -> 0x0094 }
            boolean r1 = r1.hasAccessNetworkStatePermission(r2)     // Catch:{ IOException -> 0x0094 }
            if (r1 == 0) goto L_0x006d
            boolean r1 = r4.isDeviceConnected()     // Catch:{ IOException -> 0x0094 }
            if (r1 != 0) goto L_0x006d
            com.google.firebase.messaging.SyncTask$ConnectivityChangeReceiver r1 = new com.google.firebase.messaging.SyncTask$ConnectivityChangeReceiver     // Catch:{ IOException -> 0x0094 }
            r1.<init>(r4)     // Catch:{ IOException -> 0x0094 }
            r1.registerReceiver()     // Catch:{ IOException -> 0x0094 }
            com.google.firebase.messaging.ServiceStarter r0 = com.google.firebase.messaging.ServiceStarter.getInstance()
            com.google.firebase.messaging.FirebaseMessaging r1 = r4.firebaseMessaging
            android.content.Context r1 = r1.context
            boolean r0 = r0.hasWakeLockPermission(r1)
            if (r0 == 0) goto L_0x006c
            android.os.PowerManager$WakeLock r0 = r4.syncWakeLock
            r0.release()
        L_0x006c:
            return
        L_0x006d:
            boolean r1 = r4.maybeRefreshToken()     // Catch:{ IOException -> 0x0094 }
            if (r1 == 0) goto L_0x0079
            com.google.firebase.messaging.FirebaseMessaging r1 = r4.firebaseMessaging     // Catch:{ IOException -> 0x0094 }
            r1.setSyncScheduledOrRunning(r0)     // Catch:{ IOException -> 0x0094 }
            goto L_0x0080
        L_0x0079:
            com.google.firebase.messaging.FirebaseMessaging r1 = r4.firebaseMessaging     // Catch:{ IOException -> 0x0094 }
            long r2 = r4.nextDelaySeconds     // Catch:{ IOException -> 0x0094 }
            r1.syncWithDelaySecondsInternal(r2)     // Catch:{ IOException -> 0x0094 }
        L_0x0080:
            com.google.firebase.messaging.ServiceStarter r0 = com.google.firebase.messaging.ServiceStarter.getInstance()
            com.google.firebase.messaging.FirebaseMessaging r1 = r4.firebaseMessaging
            android.content.Context r1 = r1.context
            boolean r0 = r0.hasWakeLockPermission(r1)
            if (r0 == 0) goto L_0x00af
        L_0x008e:
            android.os.PowerManager$WakeLock r0 = r4.syncWakeLock
            r0.release()
            goto L_0x00af
        L_0x0094:
            r1 = move-exception
            goto L_0x0098
        L_0x0096:
            r0 = move-exception
            goto L_0x00b0
        L_0x0098:
            r1.getMessage()     // Catch:{ all -> 0x0096 }
            com.google.firebase.messaging.FirebaseMessaging r1 = r4.firebaseMessaging     // Catch:{ all -> 0x0096 }
            r1.setSyncScheduledOrRunning(r0)     // Catch:{ all -> 0x0096 }
            com.google.firebase.messaging.ServiceStarter r0 = com.google.firebase.messaging.ServiceStarter.getInstance()
            com.google.firebase.messaging.FirebaseMessaging r1 = r4.firebaseMessaging
            android.content.Context r1 = r1.context
            boolean r0 = r0.hasWakeLockPermission(r1)
            if (r0 == 0) goto L_0x00af
            goto L_0x008e
        L_0x00af:
            return
        L_0x00b0:
            com.google.firebase.messaging.ServiceStarter r1 = com.google.firebase.messaging.ServiceStarter.getInstance()
            com.google.firebase.messaging.FirebaseMessaging r2 = r4.firebaseMessaging
            android.content.Context r2 = r2.context
            boolean r1 = r1.hasWakeLockPermission(r2)
            if (r1 == 0) goto L_0x00c3
            android.os.PowerManager$WakeLock r1 = r4.syncWakeLock
            r1.release()
        L_0x00c3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.SyncTask.run():void");
    }
}
