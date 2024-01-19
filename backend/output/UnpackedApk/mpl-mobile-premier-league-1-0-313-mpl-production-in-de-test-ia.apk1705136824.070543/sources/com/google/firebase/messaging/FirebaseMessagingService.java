package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.material.resources.TextAppearanceConfig;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirebaseMessagingService extends EnhancedIntentService {
    public static final String ACTION_DIRECT_BOOT_REMOTE_INTENT = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT";
    public static final String ACTION_NEW_TOKEN = "com.google.firebase.messaging.NEW_TOKEN";
    public static final String ACTION_REMOTE_INTENT = "com.google.android.c2dm.intent.RECEIVE";
    public static final String EXTRA_TOKEN = "token";
    public static final int RECENTLY_RECEIVED_MESSAGE_IDS_MAX_SIZE = 10;
    public static final Queue<String> recentlyReceivedMessageIds = new ArrayDeque(10);

    private boolean alreadyReceivedMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (recentlyReceivedMessageIds.contains(str)) {
            boolean isLoggable = Log.isLoggable("FirebaseMessaging", 3);
            return true;
        }
        if (recentlyReceivedMessageIds.size() >= 10) {
            recentlyReceivedMessageIds.remove();
        }
        recentlyReceivedMessageIds.add(str);
        return false;
    }

    private void dispatchMessage(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (NotificationParams.isNotification(extras)) {
            NotificationParams notificationParams = new NotificationParams(extras);
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Network-Io"));
            try {
                if (!new DisplayNotification(this, notificationParams, newSingleThreadExecutor).handleNotification()) {
                    newSingleThreadExecutor.shutdown();
                    if (TextAppearanceConfig.shouldUploadScionMetrics(intent)) {
                        TextAppearanceConfig.logToScion("_nf", intent.getExtras());
                    }
                } else {
                    return;
                }
            } finally {
                newSingleThreadExecutor.shutdown();
            }
        }
        onMessageReceived(new RemoteMessage(extras));
    }

    private String getMessageId(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    private void handleMessageIntent(Intent intent) {
        if (!alreadyReceivedMessage(intent.getStringExtra("google.message_id"))) {
            passMessageIntentToSdk(intent);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void passMessageIntentToSdk(android.content.Intent r13) {
        /*
            r12 = this;
            java.lang.String r0 = "message_type"
            java.lang.String r0 = r13.getStringExtra(r0)
            java.lang.String r1 = "gcm"
            if (r0 != 0) goto L_0x000b
            r0 = r1
        L_0x000b:
            r2 = -1
            int r3 = r0.hashCode()
            r4 = 3
            r5 = 0
            r6 = 2
            r7 = 1
            switch(r3) {
                case -2062414158: goto L_0x0034;
                case 102161: goto L_0x002c;
                case 814694033: goto L_0x0022;
                case 814800675: goto L_0x0018;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x003d
        L_0x0018:
            java.lang.String r1 = "send_event"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003d
            r2 = 2
            goto L_0x003d
        L_0x0022:
            java.lang.String r1 = "send_error"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003d
            r2 = 3
            goto L_0x003d
        L_0x002c:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003d
            r2 = 0
            goto L_0x003d
        L_0x0034:
            java.lang.String r1 = "deleted_messages"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003d
            r2 = 1
        L_0x003d:
            java.lang.String r0 = "google.message_id"
            if (r2 == 0) goto L_0x006b
            if (r2 == r7) goto L_0x0066
            if (r2 == r6) goto L_0x005d
            if (r2 == r4) goto L_0x0049
            goto L_0x0227
        L_0x0049:
            java.lang.String r0 = r12.getMessageId(r13)
            com.google.firebase.messaging.SendException r1 = new com.google.firebase.messaging.SendException
            java.lang.String r2 = "error"
            java.lang.String r13 = r13.getStringExtra(r2)
            r1.<init>(r13)
            r12.onSendError(r0, r1)
            goto L_0x0227
        L_0x005d:
            java.lang.String r13 = r13.getStringExtra(r0)
            r12.onMessageSent(r13)
            goto L_0x0227
        L_0x0066:
            r12.onDeletedMessages()
            goto L_0x0227
        L_0x006b:
            boolean r1 = com.google.android.material.resources.TextAppearanceConfig.shouldUploadScionMetrics(r13)
            if (r1 == 0) goto L_0x007a
            android.os.Bundle r1 = r13.getExtras()
            java.lang.String r2 = "_nr"
            com.google.android.material.resources.TextAppearanceConfig.logToScion(r2, r1)
        L_0x007a:
            java.lang.String r1 = r13.getAction()
            java.lang.String r2 = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0087
            goto L_0x00cd
        L_0x0087:
            java.lang.String r1 = "delivery_metrics_exported_to_big_query_enabled"
            com.google.firebase.FirebaseApp.getInstance()     // Catch:{ IllegalStateException -> 0x00cd }
            com.google.firebase.FirebaseApp r2 = com.google.firebase.FirebaseApp.getInstance()
            r2.checkNotDeleted()
            android.content.Context r2 = r2.applicationContext
            java.lang.String r3 = "com.google.firebase.messaging"
            android.content.SharedPreferences r3 = r2.getSharedPreferences(r3, r5)
            java.lang.String r4 = "export_to_big_query"
            boolean r8 = r3.contains(r4)
            if (r8 == 0) goto L_0x00a8
            boolean r1 = r3.getBoolean(r4, r5)
            goto L_0x00ce
        L_0x00a8:
            android.content.pm.PackageManager r3 = r2.getPackageManager()     // Catch:{  }
            if (r3 == 0) goto L_0x00cd
            java.lang.String r2 = r2.getPackageName()     // Catch:{  }
            r4 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r2 = r3.getApplicationInfo(r2, r4)     // Catch:{  }
            if (r2 == 0) goto L_0x00cd
            android.os.Bundle r3 = r2.metaData     // Catch:{  }
            if (r3 == 0) goto L_0x00cd
            android.os.Bundle r3 = r2.metaData     // Catch:{  }
            boolean r3 = r3.containsKey(r1)     // Catch:{  }
            if (r3 == 0) goto L_0x00cd
            android.os.Bundle r2 = r2.metaData     // Catch:{  }
            boolean r1 = r2.getBoolean(r1, r5)     // Catch:{  }
            goto L_0x00ce
        L_0x00cd:
            r1 = 0
        L_0x00ce:
            if (r1 == 0) goto L_0x0224
            com.google.firebase.messaging.reporting.MessagingClientEvent$Event r1 = com.google.firebase.messaging.reporting.MessagingClientEvent.Event.MESSAGE_DELIVERED
            com.google.android.datatransport.TransportFactory r2 = com.google.firebase.messaging.FirebaseMessaging.transportFactory
            if (r2 != 0) goto L_0x00d8
            goto L_0x0224
        L_0x00d8:
            r3 = 0
            android.os.Bundle r4 = r13.getExtras()
            if (r4 != 0) goto L_0x00e1
            android.os.Bundle r4 = android.os.Bundle.EMPTY
        L_0x00e1:
            com.google.firebase.messaging.reporting.MessagingClientEvent$Builder r8 = com.google.firebase.messaging.reporting.MessagingClientEvent.newBuilder()
            java.lang.String r9 = "google.ttl"
            java.lang.Object r9 = r4.get(r9)
            boolean r10 = r9 instanceof java.lang.Integer
            if (r10 == 0) goto L_0x00f6
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r5 = r9.intValue()
            goto L_0x0112
        L_0x00f6:
            boolean r10 = r9 instanceof java.lang.String
            if (r10 == 0) goto L_0x0112
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ NumberFormatException -> 0x0102 }
            int r5 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x0102 }
            goto L_0x0112
        L_0x0102:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Invalid TTL: "
            r10.append(r11)
            r10.append(r9)
            r10.toString()
        L_0x0112:
            r8.ttl_ = r5
            r8.event_ = r1
            java.lang.String r1 = "google.to"
            java.lang.String r1 = r4.getString(r1)
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x0123
            goto L_0x0135
        L_0x0123:
            com.google.firebase.FirebaseApp r1 = com.google.firebase.FirebaseApp.getInstance()     // Catch:{ ExecutionException -> 0x021d, InterruptedException -> 0x021b }
            com.google.firebase.installations.FirebaseInstallations r1 = com.google.firebase.installations.FirebaseInstallations.getInstance(r1)     // Catch:{ ExecutionException -> 0x021d, InterruptedException -> 0x021b }
            com.google.android.gms.tasks.Task r1 = r1.getId()     // Catch:{ ExecutionException -> 0x021d, InterruptedException -> 0x021b }
            java.lang.Object r1 = com.google.android.gms.tasks.Tasks.await(r1)     // Catch:{ ExecutionException -> 0x021d, InterruptedException -> 0x021b }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ ExecutionException -> 0x021d, InterruptedException -> 0x021b }
        L_0x0135:
            r8.instance_id_ = r1
            com.google.firebase.FirebaseApp r1 = com.google.firebase.FirebaseApp.getInstance()
            r1.checkNotDeleted()
            android.content.Context r1 = r1.applicationContext
            java.lang.String r1 = r1.getPackageName()
            r8.package_name_ = r1
            com.google.firebase.messaging.reporting.MessagingClientEvent$SDKPlatform r1 = com.google.firebase.messaging.reporting.MessagingClientEvent.SDKPlatform.ANDROID
            r8.sdk_platform_ = r1
            boolean r1 = com.google.firebase.messaging.NotificationParams.isNotification(r4)
            if (r1 == 0) goto L_0x0153
            com.google.firebase.messaging.reporting.MessagingClientEvent$MessageType r1 = com.google.firebase.messaging.reporting.MessagingClientEvent.MessageType.DISPLAY_NOTIFICATION
            goto L_0x0155
        L_0x0153:
            com.google.firebase.messaging.reporting.MessagingClientEvent$MessageType r1 = com.google.firebase.messaging.reporting.MessagingClientEvent.MessageType.DATA_MESSAGE
        L_0x0155:
            r8.message_type_ = r1
            java.lang.String r0 = r4.getString(r0)
            if (r0 != 0) goto L_0x0163
            java.lang.String r0 = "message_id"
            java.lang.String r0 = r4.getString(r0)
        L_0x0163:
            if (r0 == 0) goto L_0x0167
            r8.message_id_ = r0
        L_0x0167:
            java.lang.String r0 = com.google.android.material.resources.TextAppearanceConfig.getTopic(r4)
            if (r0 == 0) goto L_0x016f
            r8.topic_ = r0
        L_0x016f:
            java.lang.String r0 = "collapse_key"
            java.lang.String r0 = r4.getString(r0)
            if (r0 == 0) goto L_0x0179
            r8.collapse_key_ = r0
        L_0x0179:
            java.lang.String r0 = "google.c.a.m_l"
            java.lang.String r0 = r4.getString(r0)
            if (r0 == 0) goto L_0x0183
            r8.analytics_label_ = r0
        L_0x0183:
            java.lang.String r0 = "google.c.a.c_l"
            java.lang.String r0 = r4.getString(r0)
            if (r0 == 0) goto L_0x018d
            r8.composer_label_ = r0
        L_0x018d:
            java.lang.String r0 = "google.c.sender.id"
            boolean r1 = r4.containsKey(r0)
            r9 = 0
            if (r1 == 0) goto L_0x01a1
            java.lang.String r0 = r4.getString(r0)     // Catch:{ NumberFormatException -> 0x01a0 }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x01a0 }
            goto L_0x01e1
        L_0x01a0:
        L_0x01a1:
            com.google.firebase.FirebaseApp r0 = com.google.firebase.FirebaseApp.getInstance()
            r0.checkNotDeleted()
            com.google.firebase.FirebaseOptions r1 = r0.options
            java.lang.String r1 = r1.gcmSenderId
            if (r1 == 0) goto L_0x01b4
            long r0 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x01b3 }
            goto L_0x01e1
        L_0x01b3:
        L_0x01b4:
            r0.checkNotDeleted()
            com.google.firebase.FirebaseOptions r0 = r0.options
            java.lang.String r0 = r0.applicationId
            java.lang.String r1 = "1:"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x01c8
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x01e0 }
            goto L_0x01e1
        L_0x01c8:
            java.lang.String r1 = ":"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            if (r1 >= r6) goto L_0x01d2
            goto L_0x01e0
        L_0x01d2:
            r0 = r0[r7]
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x01db
            goto L_0x01e0
        L_0x01db:
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x01e0 }
            goto L_0x01e1
        L_0x01e0:
            r0 = r9
        L_0x01e1:
            int r4 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x01e7
            r8.project_number_ = r0
        L_0x01e7:
            com.google.firebase.messaging.reporting.MessagingClientEvent r0 = r8.build()
            if (r0 != 0) goto L_0x01ee
            goto L_0x0224
        L_0x01ee:
            java.lang.String r1 = "FCM_CLIENT_EVENT_LOGGING"
            java.lang.Class<com.google.firebase.messaging.reporting.MessagingClientEventExtension> r4 = com.google.firebase.messaging.reporting.MessagingClientEventExtension.class
            java.lang.String r5 = "src/main/proto"
            com.google.android.datatransport.Encoding r6 = new com.google.android.datatransport.Encoding     // Catch:{ RuntimeException -> 0x0224 }
            r6.<init>(r5)     // Catch:{ RuntimeException -> 0x0224 }
            com.google.android.material.resources.-$$Lambda$uEJG-TB5tb-7m58JwTwENhOn6oY r5 = com.google.android.material.resources.$$Lambda$uEJGTB5tb7m58JwTwENhOn6oY.INSTANCE     // Catch:{ RuntimeException -> 0x0224 }
            com.google.android.datatransport.Transport r1 = r2.getTransport(r1, r4, r6, r5)     // Catch:{ RuntimeException -> 0x0224 }
            com.google.firebase.messaging.reporting.MessagingClientEventExtension$Builder r2 = com.google.firebase.messaging.reporting.MessagingClientEventExtension.newBuilder()     // Catch:{ RuntimeException -> 0x0224 }
            r2.messaging_client_event_ = r0     // Catch:{ RuntimeException -> 0x0224 }
            com.google.firebase.messaging.reporting.MessagingClientEventExtension r0 = new com.google.firebase.messaging.reporting.MessagingClientEventExtension     // Catch:{ RuntimeException -> 0x0224 }
            com.google.firebase.messaging.reporting.MessagingClientEvent r2 = r2.messaging_client_event_     // Catch:{ RuntimeException -> 0x0224 }
            r0.<init>(r2)     // Catch:{ RuntimeException -> 0x0224 }
            com.google.android.datatransport.AutoValue_Event r2 = new com.google.android.datatransport.AutoValue_Event     // Catch:{ RuntimeException -> 0x0224 }
            com.google.android.datatransport.Priority r4 = com.google.android.datatransport.Priority.VERY_LOW     // Catch:{ RuntimeException -> 0x0224 }
            r2.<init>(r3, r0, r4)     // Catch:{ RuntimeException -> 0x0224 }
            com.google.android.datatransport.runtime.TransportImpl r1 = (com.google.android.datatransport.runtime.TransportImpl) r1     // Catch:{ RuntimeException -> 0x0224 }
            com.google.android.datatransport.runtime.-$$Lambda$TransportImpl$GkHqAwUYheh1JbNmhy95RHZujbw r0 = com.google.android.datatransport.runtime.$$Lambda$TransportImpl$GkHqAwUYheh1JbNmhy95RHZujbw.INSTANCE     // Catch:{ RuntimeException -> 0x0224 }
            r1.schedule(r2, r0)     // Catch:{ RuntimeException -> 0x0224 }
            goto L_0x0224
        L_0x021b:
            r13 = move-exception
            goto L_0x021e
        L_0x021d:
            r13 = move-exception
        L_0x021e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r13)
            throw r0
        L_0x0224:
            r12.dispatchMessage(r13)
        L_0x0227:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.passMessageIntentToSdk(android.content.Intent):void");
    }

    public static void resetForTesting() {
        recentlyReceivedMessageIds.clear();
    }

    public Intent getStartCommandIntent(Intent intent) {
        return ServiceStarter.getInstance().messagingEvents.poll();
    }

    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        if (ACTION_REMOTE_INTENT.equals(action) || ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(action)) {
            handleMessageIntent(intent);
        } else if (ACTION_NEW_TOKEN.equals(action)) {
            onNewToken(intent.getStringExtra("token"));
        } else {
            intent.getAction();
        }
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onSendError(String str, Exception exc) {
    }
}
