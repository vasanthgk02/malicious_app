package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.ExecutorService;

public class DisplayNotification {
    public final Context context;
    public final ExecutorService networkIoExecutor;
    public final NotificationParams params;

    public DisplayNotification(Context context2, NotificationParams notificationParams, ExecutorService executorService) {
        this.networkIoExecutor = executorService;
        this.context = context2;
        this.params = notificationParams;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0093 A[SYNTHETIC, Splitter:B:28:0x0093] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleNotification() {
        /*
            r9 = this;
            com.google.firebase.messaging.NotificationParams r0 = r9.params
            java.lang.String r1 = "gcm.n.noui"
            boolean r0 = r0.getBoolean(r1)
            r1 = 1
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            android.content.Context r0 = r9.context
            java.lang.String r2 = "keyguard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.app.KeyguardManager r0 = (android.app.KeyguardManager) r0
            boolean r0 = r0.inKeyguardRestrictedInputMode()
            r2 = 0
            if (r0 == 0) goto L_0x001e
            goto L_0x004e
        L_0x001e:
            int r0 = android.os.Process.myPid()
            android.content.Context r3 = r9.context
            java.lang.String r4 = "activity"
            java.lang.Object r3 = r3.getSystemService(r4)
            android.app.ActivityManager r3 = (android.app.ActivityManager) r3
            java.util.List r3 = r3.getRunningAppProcesses()
            if (r3 == 0) goto L_0x004e
            java.util.Iterator r3 = r3.iterator()
        L_0x0036:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x004e
            java.lang.Object r4 = r3.next()
            android.app.ActivityManager$RunningAppProcessInfo r4 = (android.app.ActivityManager.RunningAppProcessInfo) r4
            int r5 = r4.pid
            if (r5 != r0) goto L_0x0036
            int r0 = r4.importance
            r3 = 100
            if (r0 != r3) goto L_0x004e
            r0 = 1
            goto L_0x004f
        L_0x004e:
            r0 = 0
        L_0x004f:
            if (r0 == 0) goto L_0x0052
            return r2
        L_0x0052:
            com.google.firebase.messaging.NotificationParams r0 = r9.params
            java.lang.String r2 = "gcm.n.image"
            java.lang.String r0 = r0.getString(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            r3 = 0
            if (r2 == 0) goto L_0x0062
            goto L_0x006d
        L_0x0062:
            com.google.firebase.messaging.ImageDownload r2 = new com.google.firebase.messaging.ImageDownload     // Catch:{ MalformedURLException -> 0x006d }
            java.net.URL r4 = new java.net.URL     // Catch:{ MalformedURLException -> 0x006d }
            r4.<init>(r0)     // Catch:{ MalformedURLException -> 0x006d }
            r2.<init>(r4)     // Catch:{ MalformedURLException -> 0x006d }
            goto L_0x006e
        L_0x006d:
            r2 = r3
        L_0x006e:
            if (r2 == 0) goto L_0x0086
            java.util.concurrent.ExecutorService r0 = r9.networkIoExecutor
            com.google.android.gms.tasks.TaskCompletionSource r4 = new com.google.android.gms.tasks.TaskCompletionSource
            r4.<init>()
            com.google.firebase.messaging.-$$Lambda$ImageDownload$1Xn11wJGkQ0YswSUNQTBL7K7Rek r5 = new com.google.firebase.messaging.-$$Lambda$ImageDownload$1Xn11wJGkQ0YswSUNQTBL7K7Rek
            r5.<init>(r4)
            java.util.concurrent.Future r0 = r0.submit(r5)
            r2.future = r0
            com.google.android.gms.tasks.zzw r0 = r4.zza
            r2.task = r0
        L_0x0086:
            android.content.Context r0 = r9.context
            com.google.firebase.messaging.NotificationParams r4 = r9.params
            com.google.firebase.messaging.CommonNotificationBuilder$DisplayNotificationInfo r0 = com.google.firebase.messaging.CommonNotificationBuilder.createNotificationInfo(r0, r4)
            androidx.core.app.NotificationCompat$Builder r4 = r0.notificationBuilder
            if (r2 != 0) goto L_0x0093
            goto L_0x00d6
        L_0x0093:
            com.google.android.gms.tasks.Task<android.graphics.Bitmap> r5 = r2.task     // Catch:{ ExecutionException -> 0x00c5, InterruptedException -> 0x00ba, TimeoutException -> 0x00b6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ ExecutionException -> 0x00c5, InterruptedException -> 0x00ba, TimeoutException -> 0x00b6 }
            r6 = 5
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x00c5, InterruptedException -> 0x00ba, TimeoutException -> 0x00b6 }
            java.lang.Object r5 = com.google.android.gms.tasks.Tasks.await(r5, r6, r8)     // Catch:{ ExecutionException -> 0x00c5, InterruptedException -> 0x00ba, TimeoutException -> 0x00b6 }
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5     // Catch:{ ExecutionException -> 0x00c5, InterruptedException -> 0x00ba, TimeoutException -> 0x00b6 }
            r4.setLargeIcon(r5)     // Catch:{ ExecutionException -> 0x00c5, InterruptedException -> 0x00ba, TimeoutException -> 0x00b6 }
            androidx.core.app.NotificationCompat$BigPictureStyle r6 = new androidx.core.app.NotificationCompat$BigPictureStyle     // Catch:{ ExecutionException -> 0x00c5, InterruptedException -> 0x00ba, TimeoutException -> 0x00b6 }
            r6.<init>()     // Catch:{ ExecutionException -> 0x00c5, InterruptedException -> 0x00ba, TimeoutException -> 0x00b6 }
            androidx.core.app.NotificationCompat$BigPictureStyle r5 = r6.bigPicture(r5)     // Catch:{ ExecutionException -> 0x00c5, InterruptedException -> 0x00ba, TimeoutException -> 0x00b6 }
            androidx.core.app.NotificationCompat$BigPictureStyle r3 = r5.bigLargeIcon(r3)     // Catch:{ ExecutionException -> 0x00c5, InterruptedException -> 0x00ba, TimeoutException -> 0x00b6 }
            r4.setStyle(r3)     // Catch:{ ExecutionException -> 0x00c5, InterruptedException -> 0x00ba, TimeoutException -> 0x00b6 }
            goto L_0x00d6
        L_0x00b6:
            r2.close()
            goto L_0x00d6
        L_0x00ba:
            r2.close()
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
            goto L_0x00d6
        L_0x00c5:
            r2 = move-exception
            java.lang.String r3 = "Failed to download image: "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.Throwable r2 = r2.getCause()
            r3.append(r2)
            r3.toString()
        L_0x00d6:
            r2 = 3
            java.lang.String r3 = "FirebaseMessaging"
            android.util.Log.isLoggable(r3, r2)
            android.content.Context r2 = r9.context
            java.lang.String r3 = "notification"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.app.NotificationManager r2 = (android.app.NotificationManager) r2
            java.lang.String r3 = r0.tag
            int r4 = r0.id
            androidx.core.app.NotificationCompat$Builder r0 = r0.notificationBuilder
            android.app.Notification r0 = r0.build()
            r2.notify(r3, r4, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.DisplayNotification.handleNotification():boolean");
    }
}
