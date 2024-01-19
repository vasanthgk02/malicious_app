package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class WithinAppServiceConnection implements ServiceConnection {
    public WithinAppServiceBinder binder;
    public boolean connectionInProgress = false;
    public final Intent connectionIntent;
    public final Context context;
    public final Queue<BindRequest> intentQueue = new ArrayDeque();
    public final ScheduledExecutorService scheduledExecutorService;

    public static class BindRequest {
        public final Intent intent;
        public final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();

        public BindRequest(Intent intent2) {
            this.intent = intent2;
        }

        public void finish() {
            this.taskCompletionSource.trySetResult(null);
        }

        public /* synthetic */ void lambda$arrangeTimeout$0$WithinAppServiceConnection$BindRequest() {
            this.intent.getAction();
            finish();
        }
    }

    public WithinAppServiceConnection(Context context2, String str) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection"));
        this.context = context2.getApplicationContext();
        this.connectionIntent = new Intent(str).setPackage(this.context.getPackageName());
        this.scheduledExecutorService = scheduledThreadPoolExecutor;
    }

    public final void finishAllInQueue() {
        while (!this.intentQueue.isEmpty()) {
            this.intentQueue.poll().finish();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        if (com.google.android.gms.common.stats.ConnectionTracker.getInstance().bindService(r4.context, r4.connectionIntent, r4, 65) != false) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void flushQueue() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "FirebaseMessaging"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x005e }
        L_0x0008:
            java.util.Queue<com.google.firebase.messaging.WithinAppServiceConnection$BindRequest> r0 = r4.intentQueue     // Catch:{ all -> 0x005e }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x005c
            java.lang.String r0 = "FirebaseMessaging"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x005e }
            com.google.firebase.messaging.WithinAppServiceBinder r0 = r4.binder     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0036
            com.google.firebase.messaging.WithinAppServiceBinder r0 = r4.binder     // Catch:{ all -> 0x005e }
            boolean r0 = r0.isBinderAlive()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0036
            java.lang.String r0 = "FirebaseMessaging"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x005e }
            java.util.Queue<com.google.firebase.messaging.WithinAppServiceConnection$BindRequest> r0 = r4.intentQueue     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x005e }
            com.google.firebase.messaging.WithinAppServiceConnection$BindRequest r0 = (com.google.firebase.messaging.WithinAppServiceConnection.BindRequest) r0     // Catch:{ all -> 0x005e }
            com.google.firebase.messaging.WithinAppServiceBinder r2 = r4.binder     // Catch:{ all -> 0x005e }
            r2.send(r0)     // Catch:{ all -> 0x005e }
            goto L_0x0008
        L_0x0036:
            java.lang.String r0 = "FirebaseMessaging"
            android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x005e }
            boolean r0 = r4.connectionInProgress     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0040
            goto L_0x005a
        L_0x0040:
            r0 = 1
            r4.connectionInProgress = r0     // Catch:{ all -> 0x005e }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ SecurityException -> 0x0054 }
            android.content.Context r1 = r4.context     // Catch:{ SecurityException -> 0x0054 }
            android.content.Intent r2 = r4.connectionIntent     // Catch:{ SecurityException -> 0x0054 }
            r3 = 65
            boolean r0 = r0.bindService(r1, r2, r4, r3)     // Catch:{ SecurityException -> 0x0054 }
            if (r0 == 0) goto L_0x0054
            goto L_0x005a
        L_0x0054:
            r0 = 0
            r4.connectionInProgress = r0     // Catch:{ all -> 0x005e }
            r4.finishAllInQueue()     // Catch:{ all -> 0x005e }
        L_0x005a:
            monitor-exit(r4)
            return
        L_0x005c:
            monitor-exit(r4)
            return
        L_0x005e:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.WithinAppServiceConnection.flushQueue():void");
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            "onServiceConnected: " + componentName;
        }
        this.connectionInProgress = false;
        if (!(iBinder instanceof WithinAppServiceBinder)) {
            "Invalid service connection: " + iBinder;
            finishAllInQueue();
            return;
        }
        this.binder = (WithinAppServiceBinder) iBinder;
        flushQueue();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            "onServiceDisconnected: " + componentName;
        }
        flushQueue();
    }
}
