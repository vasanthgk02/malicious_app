package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import java.util.concurrent.TimeUnit;

public class TopicsSyncTask implements Runnable {
    public static final Object TOPIC_SYNC_TASK_LOCK = new Object();
    public static Boolean hasAccessNetworkStatePermission;
    public static Boolean hasWakeLockPermission;
    public final Context context;
    public final Metadata metadata;
    public final long nextDelaySeconds;
    public final WakeLock syncWakeLock;
    public final TopicsSubscriber topicsSubscriber;

    public class ConnectivityChangeReceiver extends BroadcastReceiver {
        public TopicsSyncTask task;

        public ConnectivityChangeReceiver(TopicsSyncTask topicsSyncTask) {
            this.task = topicsSyncTask;
        }

        public synchronized void onReceive(Context context, Intent intent) {
            if (this.task != null) {
                if (this.task.isDeviceConnected()) {
                    TopicsSyncTask.access$100();
                    TopicsSubscriber topicsSubscriber = this.task.topicsSubscriber;
                    topicsSubscriber.syncExecutor.schedule(this.task, 0, TimeUnit.SECONDS);
                    context.unregisterReceiver(this);
                    this.task = null;
                }
            }
        }
    }

    public TopicsSyncTask(TopicsSubscriber topicsSubscriber2, Context context2, Metadata metadata2, long j) {
        this.topicsSubscriber = topicsSubscriber2;
        this.context = context2;
        this.nextDelaySeconds = j;
        this.metadata = metadata2;
        this.syncWakeLock = ((PowerManager) context2.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static boolean access$100() {
        return Log.isLoggable("FirebaseMessaging", 3) || (VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    public static boolean hasAccessNetworkStatePermission(Context context2) {
        boolean z;
        boolean booleanValue;
        synchronized (TOPIC_SYNC_TASK_LOCK) {
            if (hasAccessNetworkStatePermission == null) {
                z = hasPermission(context2, "android.permission.ACCESS_NETWORK_STATE", hasAccessNetworkStatePermission);
            } else {
                z = hasAccessNetworkStatePermission.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(z);
            hasAccessNetworkStatePermission = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    public static boolean hasPermission(Context context2, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context2.checkCallingOrSelfPermission(str) == 0;
        if (!z) {
            Log.isLoggable("FirebaseMessaging", 3);
        }
        return z;
    }

    public static boolean hasWakeLockPermission(Context context2) {
        boolean z;
        boolean booleanValue;
        synchronized (TOPIC_SYNC_TASK_LOCK) {
            if (hasWakeLockPermission == null) {
                z = hasPermission(context2, "android.permission.WAKE_LOCK", hasWakeLockPermission);
            } else {
                z = hasWakeLockPermission.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(z);
            hasWakeLockPermission = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    public final synchronized boolean isDeviceConnected() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
        activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0080, code lost:
        if (hasWakeLockPermission(r5.context) != false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r5.syncWakeLock.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0098, code lost:
        if (hasWakeLockPermission(r5.context) == false) goto L_0x009b;
     */
    @android.annotation.SuppressLint({"Wakelock"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            android.content.Context r0 = r5.context
            boolean r0 = hasWakeLockPermission(r0)
            if (r0 == 0) goto L_0x000f
            android.os.PowerManager$WakeLock r0 = r5.syncWakeLock
            long r1 = com.google.firebase.messaging.Constants.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS
            r0.acquire(r1)
        L_0x000f:
            r0 = 0
            com.google.firebase.messaging.TopicsSubscriber r1 = r5.topicsSubscriber     // Catch:{ IOException -> 0x0063 }
            r2 = 1
            r1.setSyncScheduledOrRunning(r2)     // Catch:{ IOException -> 0x0063 }
            com.google.firebase.messaging.Metadata r1 = r5.metadata     // Catch:{ IOException -> 0x0063 }
            boolean r1 = r1.isGmscorePresent()     // Catch:{ IOException -> 0x0063 }
            if (r1 != 0) goto L_0x0031
            com.google.firebase.messaging.TopicsSubscriber r1 = r5.topicsSubscriber     // Catch:{ IOException -> 0x0063 }
            r1.setSyncScheduledOrRunning(r0)     // Catch:{ IOException -> 0x0063 }
            android.content.Context r0 = r5.context
            boolean r0 = hasWakeLockPermission(r0)
            if (r0 == 0) goto L_0x0030
            android.os.PowerManager$WakeLock r0 = r5.syncWakeLock     // Catch:{ RuntimeException -> 0x0030 }
            r0.release()     // Catch:{ RuntimeException -> 0x0030 }
        L_0x0030:
            return
        L_0x0031:
            android.content.Context r1 = r5.context     // Catch:{ IOException -> 0x0063 }
            boolean r1 = hasAccessNetworkStatePermission(r1)     // Catch:{ IOException -> 0x0063 }
            if (r1 == 0) goto L_0x0065
            boolean r1 = r5.isDeviceConnected()     // Catch:{ IOException -> 0x0063 }
            if (r1 != 0) goto L_0x0065
            com.google.firebase.messaging.TopicsSyncTask$ConnectivityChangeReceiver r1 = new com.google.firebase.messaging.TopicsSyncTask$ConnectivityChangeReceiver     // Catch:{ IOException -> 0x0063 }
            r1.<init>(r5)     // Catch:{ IOException -> 0x0063 }
            access$100()     // Catch:{ IOException -> 0x0063 }
            com.google.firebase.messaging.TopicsSyncTask r2 = com.google.firebase.messaging.TopicsSyncTask.this     // Catch:{ IOException -> 0x0063 }
            android.content.Context r2 = r2.context     // Catch:{ IOException -> 0x0063 }
            android.content.IntentFilter r3 = new android.content.IntentFilter     // Catch:{ IOException -> 0x0063 }
            java.lang.String r4 = "android.net.conn.CONNECTIVITY_CHANGE"
            r3.<init>(r4)     // Catch:{ IOException -> 0x0063 }
            r2.registerReceiver(r1, r3)     // Catch:{ IOException -> 0x0063 }
            android.content.Context r0 = r5.context
            boolean r0 = hasWakeLockPermission(r0)
            if (r0 == 0) goto L_0x0062
            android.os.PowerManager$WakeLock r0 = r5.syncWakeLock     // Catch:{ RuntimeException -> 0x0062 }
            r0.release()     // Catch:{ RuntimeException -> 0x0062 }
        L_0x0062:
            return
        L_0x0063:
            r1 = move-exception
            goto L_0x008a
        L_0x0065:
            com.google.firebase.messaging.TopicsSubscriber r1 = r5.topicsSubscriber     // Catch:{ IOException -> 0x0063 }
            boolean r1 = r1.syncTopics()     // Catch:{ IOException -> 0x0063 }
            if (r1 == 0) goto L_0x0073
            com.google.firebase.messaging.TopicsSubscriber r1 = r5.topicsSubscriber     // Catch:{ IOException -> 0x0063 }
            r1.setSyncScheduledOrRunning(r0)     // Catch:{ IOException -> 0x0063 }
            goto L_0x007a
        L_0x0073:
            com.google.firebase.messaging.TopicsSubscriber r1 = r5.topicsSubscriber     // Catch:{ IOException -> 0x0063 }
            long r2 = r5.nextDelaySeconds     // Catch:{ IOException -> 0x0063 }
            r1.syncWithDelaySecondsInternal(r2)     // Catch:{ IOException -> 0x0063 }
        L_0x007a:
            android.content.Context r0 = r5.context
            boolean r0 = hasWakeLockPermission(r0)
            if (r0 == 0) goto L_0x009b
        L_0x0082:
            android.os.PowerManager$WakeLock r0 = r5.syncWakeLock     // Catch:{ RuntimeException -> 0x009b }
            r0.release()     // Catch:{ RuntimeException -> 0x009b }
            goto L_0x009b
        L_0x0088:
            r0 = move-exception
            goto L_0x009c
        L_0x008a:
            r1.getMessage()     // Catch:{ all -> 0x0088 }
            com.google.firebase.messaging.TopicsSubscriber r1 = r5.topicsSubscriber     // Catch:{ all -> 0x0088 }
            r1.setSyncScheduledOrRunning(r0)     // Catch:{ all -> 0x0088 }
            android.content.Context r0 = r5.context
            boolean r0 = hasWakeLockPermission(r0)
            if (r0 == 0) goto L_0x009b
            goto L_0x0082
        L_0x009b:
            return
        L_0x009c:
            android.content.Context r1 = r5.context
            boolean r1 = hasWakeLockPermission(r1)
            if (r1 == 0) goto L_0x00a9
            android.os.PowerManager$WakeLock r1 = r5.syncWakeLock     // Catch:{ RuntimeException -> 0x00a9 }
            r1.release()     // Catch:{ RuntimeException -> 0x00a9 }
        L_0x00a9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSyncTask.run():void");
    }
}
