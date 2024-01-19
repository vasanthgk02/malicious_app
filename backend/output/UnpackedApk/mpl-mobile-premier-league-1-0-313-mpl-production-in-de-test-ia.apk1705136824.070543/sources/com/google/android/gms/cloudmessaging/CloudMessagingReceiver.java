package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zze;
import com.google.android.material.resources.TextAppearanceConfig;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
public abstract class CloudMessagingReceiver extends BroadcastReceiver {
    public final ExecutorService zza;

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
    public static final class IntentActionKeys {
    }

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
    public static final class IntentKeys {
    }

    public CloudMessagingReceiver() {
        zze.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zza = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            boolean isOrderedBroadcast = isOrderedBroadcast();
            PendingResult goAsync = goAsync();
            ExecutorService executorService = this.zza;
            zze zze = new zze(this, intent, context, isOrderedBroadcast, goAsync);
            executorService.execute(zze);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0050 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(android.content.Context r7, android.content.Intent r8) {
        /*
            r6 = this;
            android.os.Bundle r0 = r8.getExtras()
            r1 = 500(0x1f4, float:7.0E-43)
            if (r0 != 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.String r0 = "google.message_id"
            java.lang.String r0 = r8.getStringExtra(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x001b
            r0 = 0
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forResult(r0)
            goto L_0x0036
        L_0x001b:
            java.lang.String r2 = "google.message_id"
            android.os.Bundle r0 = com.android.tools.r8.GeneratedOutlineSupport.outline14(r2, r0)
            com.google.android.gms.cloudmessaging.zzs r2 = com.google.android.gms.cloudmessaging.zzs.zzb(r7)
            com.google.android.gms.cloudmessaging.zzo r3 = new com.google.android.gms.cloudmessaging.zzo
            monitor-enter(r2)
            int r4 = r2.zze     // Catch:{ all -> 0x006b }
            int r5 = r4 + 1
            r2.zze = r5     // Catch:{ all -> 0x006b }
            monitor-exit(r2)
            r3.<init>(r4, r0)
            com.google.android.gms.tasks.Task r0 = r2.zzg(r3)
        L_0x0036:
            com.google.android.gms.cloudmessaging.CloudMessage r2 = new com.google.android.gms.cloudmessaging.CloudMessage
            r2.<init>(r8)
            com.google.firebase.messaging.FcmBroadcastProcessor r8 = new com.google.firebase.messaging.FcmBroadcastProcessor     // Catch:{ InterruptedException | ExecutionException -> 0x0050 }
            r8.<init>(r7)     // Catch:{ InterruptedException | ExecutionException -> 0x0050 }
            android.content.Intent r7 = r2.zza     // Catch:{ InterruptedException | ExecutionException -> 0x0050 }
            com.google.android.gms.tasks.Task r7 = r8.process(r7)     // Catch:{ InterruptedException | ExecutionException -> 0x0050 }
            java.lang.Object r7 = com.google.android.gms.tasks.Tasks.await(r7)     // Catch:{ InterruptedException | ExecutionException -> 0x0050 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ InterruptedException | ExecutionException -> 0x0050 }
            int r1 = r7.intValue()     // Catch:{ InterruptedException | ExecutionException -> 0x0050 }
        L_0x0050:
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x0062, InterruptedException -> 0x0060, TimeoutException -> 0x005e }
            r2 = 1
            long r7 = r7.toMillis(r2)     // Catch:{ ExecutionException -> 0x0062, InterruptedException -> 0x0060, TimeoutException -> 0x005e }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException -> 0x0062, InterruptedException -> 0x0060, TimeoutException -> 0x005e }
            com.google.android.gms.tasks.Tasks.await(r0, r7, r2)     // Catch:{ ExecutionException -> 0x0062, InterruptedException -> 0x0060, TimeoutException -> 0x005e }
            goto L_0x006a
        L_0x005e:
            r7 = move-exception
            goto L_0x0063
        L_0x0060:
            r7 = move-exception
            goto L_0x0063
        L_0x0062:
            r7 = move-exception
        L_0x0063:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r7.length()
        L_0x006a:
            return r1
        L_0x006b:
            r7 = move-exception
            monitor-exit(r2)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.CloudMessagingReceiver.zzb(android.content.Context, android.content.Intent):int");
    }

    public final int zzc(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (CanceledException unused) {
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if (!"com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(intent.getAction())) {
            return 500;
        }
        Intent putExtras = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(extras);
        if (TextAppearanceConfig.shouldUploadScionMetrics(putExtras)) {
            TextAppearanceConfig.logToScion("_nd", putExtras.getExtras());
        }
        return -1;
    }
}
