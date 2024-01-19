package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TopicsSubscriber {
    public static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    public final Context context;
    public final FirebaseMessaging firebaseMessaging;
    public final Metadata metadata;
    public final Map<String, ArrayDeque<TaskCompletionSource<Void>>> pendingOperations = new ArrayMap();
    public final GmsRpc rpc;
    public final TopicsStore store;
    public final ScheduledExecutorService syncExecutor;
    public boolean syncScheduledOrRunning = false;

    public TopicsSubscriber(FirebaseMessaging firebaseMessaging2, Metadata metadata2, TopicsStore topicsStore, GmsRpc gmsRpc, Context context2, ScheduledExecutorService scheduledExecutorService) {
        this.firebaseMessaging = firebaseMessaging2;
        this.metadata = metadata2;
        this.store = topicsStore;
        this.rpc = gmsRpc;
        this.context = context2;
        this.syncExecutor = scheduledExecutorService;
    }

    public static <T> void awaitTask(Task<T> task) throws IOException {
        try {
            Tasks.await(task, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e2);
            }
        } catch (InterruptedException | TimeoutException e3) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e3);
        }
    }

    public static Task<TopicsSubscriber> createInstance(FirebaseMessaging firebaseMessaging2, Metadata metadata2, GmsRpc gmsRpc, Context context2, ScheduledExecutorService scheduledExecutorService) {
        $$Lambda$TopicsSubscriber$G7vU8VoaXQhzlXyZXgPRglqiFw r0 = new Callable(context2, scheduledExecutorService, firebaseMessaging2, metadata2, gmsRpc) {
            public final /* synthetic */ Context f$0;
            public final /* synthetic */ ScheduledExecutorService f$1;
            public final /* synthetic */ FirebaseMessaging f$2;
            public final /* synthetic */ Metadata f$3;
            public final /* synthetic */ GmsRpc f$4;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final Object call() {
                return TopicsSubscriber.lambda$createInstance$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
            }
        };
        return Tasks.call(scheduledExecutorService, r0);
    }

    public static boolean isDebugLogEnabled() {
        return Log.isLoggable("FirebaseMessaging", 3) || (VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    public static TopicsSubscriber lambda$createInstance$0(Context context2, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging2, Metadata metadata2, GmsRpc gmsRpc) throws Exception {
        TopicsStore topicsStore;
        synchronized (TopicsStore.class) {
            TopicsStore topicsStore2 = null;
            if (TopicsStore.topicsStoreWeakReference != null) {
                topicsStore2 = (TopicsStore) TopicsStore.topicsStoreWeakReference.get();
            }
            if (topicsStore2 == null) {
                TopicsStore topicsStore3 = new TopicsStore(context2.getSharedPreferences("com.google.android.gms.appid", 0), scheduledExecutorService);
                synchronized (topicsStore3) {
                    topicsStore3.topicOperationsQueue = SharedPreferencesQueue.createInstance(topicsStore3.sharedPreferences, "topic_operation_queue", ",", topicsStore3.syncExecutor);
                }
                TopicsStore.topicsStoreWeakReference = new WeakReference<>(topicsStore3);
                topicsStore = topicsStore3;
            } else {
                topicsStore = topicsStore2;
            }
        }
        TopicsSubscriber topicsSubscriber = new TopicsSubscriber(firebaseMessaging2, metadata2, topicsStore, gmsRpc, context2, scheduledExecutorService);
        return topicsSubscriber;
    }

    public final void blockingSubscribeToTopic(String str) throws IOException {
        GmsRpc gmsRpc = this.rpc;
        String blockingGetToken = this.firebaseMessaging.blockingGetToken();
        if (gmsRpc != null) {
            Bundle bundle = new Bundle();
            bundle.putString("gcm.topic", "/topics/" + str);
            awaitTask(gmsRpc.extractResponseWhenComplete(gmsRpc.startRpc(blockingGetToken, "/topics/" + str, bundle)));
            return;
        }
        throw null;
    }

    public final void blockingUnsubscribeFromTopic(String str) throws IOException {
        GmsRpc gmsRpc = this.rpc;
        String blockingGetToken = this.firebaseMessaging.blockingGetToken();
        if (gmsRpc != null) {
            Bundle bundle = new Bundle();
            bundle.putString("gcm.topic", "/topics/" + str);
            bundle.putString("delete", "1");
            awaitTask(gmsRpc.extractResponseWhenComplete(gmsRpc.startRpc(blockingGetToken, "/topics/" + str, bundle)));
            return;
        }
        throw null;
    }

    public synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    public void startTopicsSyncIfNecessary() {
        boolean z;
        if (this.store.getNextTopicOperation() != null) {
            synchronized (this) {
                z = this.syncScheduledOrRunning;
            }
            if (!z) {
                syncWithDelaySecondsInternal(0);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r3 = r0.operation;
        r4 = 65535;
        r5 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r5 == 83) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        if (r5 == 85) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        if (r3.equals(org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary.STYLE_UNDERLINE) == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        r4 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r3.equals("S") == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        if (r4 == 0) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
        if (r4 == 1) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        if (isDebugLogEnabled() == false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003f, code lost:
        "Unknown topic operation" + r0 + ".";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        blockingUnsubscribeFromTopic(r0.topic);
        isDebugLogEnabled();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
        blockingSubscribeToTopic(r0.topic);
        isDebugLogEnabled();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0072, code lost:
        if ("SERVICE_NOT_AVAILABLE".equals(r1.getMessage()) != false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0085, code lost:
        if (r1.getMessage() != null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0088, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0089, code lost:
        r1.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008c, code lost:
        r1 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean syncTopics() throws java.io.IOException {
        /*
            r7 = this;
        L_0x0000:
            monitor-enter(r7)
            com.google.firebase.messaging.TopicsStore r0 = r7.store     // Catch:{ all -> 0x00ef }
            com.google.firebase.messaging.TopicOperation r0 = r0.getNextTopicOperation()     // Catch:{ all -> 0x00ef }
            r1 = 1
            if (r0 != 0) goto L_0x0010
            boolean r0 = isDebugLogEnabled()     // Catch:{ all -> 0x00ef }
            monitor-exit(r7)     // Catch:{ all -> 0x00ef }
            return r1
        L_0x0010:
            monitor-exit(r7)     // Catch:{ all -> 0x00ef }
            r2 = 0
            java.lang.String r3 = r0.operation     // Catch:{ IOException -> 0x0067 }
            r4 = -1
            int r5 = r3.hashCode()     // Catch:{ IOException -> 0x0067 }
            r6 = 83
            if (r5 == r6) goto L_0x002c
            r6 = 85
            if (r5 == r6) goto L_0x0022
            goto L_0x0035
        L_0x0022:
            java.lang.String r5 = "U"
            boolean r3 = r3.equals(r5)     // Catch:{ IOException -> 0x0067 }
            if (r3 == 0) goto L_0x0035
            r4 = 1
            goto L_0x0035
        L_0x002c:
            java.lang.String r5 = "S"
            boolean r3 = r3.equals(r5)     // Catch:{ IOException -> 0x0067 }
            if (r3 == 0) goto L_0x0035
            r4 = 0
        L_0x0035:
            if (r4 == 0) goto L_0x005e
            if (r4 == r1) goto L_0x0055
            boolean r3 = isDebugLogEnabled()     // Catch:{ IOException -> 0x0067 }
            if (r3 == 0) goto L_0x008d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0067 }
            r3.<init>()     // Catch:{ IOException -> 0x0067 }
            java.lang.String r4 = "Unknown topic operation"
            r3.append(r4)     // Catch:{ IOException -> 0x0067 }
            r3.append(r0)     // Catch:{ IOException -> 0x0067 }
            java.lang.String r4 = "."
            r3.append(r4)     // Catch:{ IOException -> 0x0067 }
            r3.toString()     // Catch:{ IOException -> 0x0067 }
            goto L_0x008d
        L_0x0055:
            java.lang.String r3 = r0.topic     // Catch:{ IOException -> 0x0067 }
            r7.blockingUnsubscribeFromTopic(r3)     // Catch:{ IOException -> 0x0067 }
            isDebugLogEnabled()     // Catch:{ IOException -> 0x0067 }
            goto L_0x008d
        L_0x005e:
            java.lang.String r3 = r0.topic     // Catch:{ IOException -> 0x0067 }
            r7.blockingSubscribeToTopic(r3)     // Catch:{ IOException -> 0x0067 }
            isDebugLogEnabled()     // Catch:{ IOException -> 0x0067 }
            goto L_0x008d
        L_0x0067:
            r1 = move-exception
            java.lang.String r3 = r1.getMessage()
            java.lang.String r4 = "SERVICE_NOT_AVAILABLE"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0089
            java.lang.String r3 = r1.getMessage()
            java.lang.String r4 = "INTERNAL_SERVER_ERROR"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0081
            goto L_0x0089
        L_0x0081:
            java.lang.String r3 = r1.getMessage()
            if (r3 != 0) goto L_0x0088
            goto L_0x008c
        L_0x0088:
            throw r1
        L_0x0089:
            r1.getMessage()
        L_0x008c:
            r1 = 0
        L_0x008d:
            if (r1 != 0) goto L_0x0090
            return r2
        L_0x0090:
            com.google.firebase.messaging.TopicsStore r1 = r7.store
            monitor-enter(r1)
            com.google.firebase.messaging.SharedPreferencesQueue r2 = r1.topicOperationsQueue     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = r0.serializedString     // Catch:{ all -> 0x00ec }
            java.util.ArrayDeque<java.lang.String> r4 = r2.internalQueue     // Catch:{ all -> 0x00ec }
            monitor-enter(r4)     // Catch:{ all -> 0x00ec }
            java.util.ArrayDeque<java.lang.String> r5 = r2.internalQueue     // Catch:{ all -> 0x00e9 }
            boolean r3 = r5.remove(r3)     // Catch:{ all -> 0x00e9 }
            if (r3 == 0) goto L_0x00b0
            boolean r3 = r2.bulkOperation     // Catch:{ all -> 0x00e9 }
            if (r3 != 0) goto L_0x00b0
            java.util.concurrent.Executor r3 = r2.syncExecutor     // Catch:{ all -> 0x00e9 }
            com.google.firebase.messaging.-$$Lambda$sVIDTOwbvrMV_7NrfkDffuvRYZM r5 = new com.google.firebase.messaging.-$$Lambda$sVIDTOwbvrMV_7NrfkDffuvRYZM     // Catch:{ all -> 0x00e9 }
            r5.<init>()     // Catch:{ all -> 0x00e9 }
            r3.execute(r5)     // Catch:{ all -> 0x00e9 }
        L_0x00b0:
            monitor-exit(r4)     // Catch:{ all -> 0x00e9 }
            monitor-exit(r1)
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r2 = r7.pendingOperations
            monitor-enter(r2)
            java.lang.String r0 = r0.serializedString     // Catch:{ all -> 0x00e6 }
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r7.pendingOperations     // Catch:{ all -> 0x00e6 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x00e6 }
            if (r1 != 0) goto L_0x00c2
            monitor-exit(r2)     // Catch:{ all -> 0x00e6 }
            goto L_0x0000
        L_0x00c2:
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r7.pendingOperations     // Catch:{ all -> 0x00e6 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x00e6 }
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch:{ all -> 0x00e6 }
            java.lang.Object r3 = r1.poll()     // Catch:{ all -> 0x00e6 }
            com.google.android.gms.tasks.TaskCompletionSource r3 = (com.google.android.gms.tasks.TaskCompletionSource) r3     // Catch:{ all -> 0x00e6 }
            if (r3 == 0) goto L_0x00d8
            r4 = 0
            com.google.android.gms.tasks.zzw r3 = r3.zza     // Catch:{ all -> 0x00e6 }
            r3.zzb(r4)     // Catch:{ all -> 0x00e6 }
        L_0x00d8:
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00e6 }
            if (r1 == 0) goto L_0x00e3
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r7.pendingOperations     // Catch:{ all -> 0x00e6 }
            r1.remove(r0)     // Catch:{ all -> 0x00e6 }
        L_0x00e3:
            monitor-exit(r2)     // Catch:{ all -> 0x00e6 }
            goto L_0x0000
        L_0x00e6:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00e6 }
            throw r0
        L_0x00e9:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00e9 }
            throw r0     // Catch:{ all -> 0x00ec }
        L_0x00ec:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x00ef:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00ef }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.syncTopics():boolean");
    }

    public void syncWithDelaySecondsInternal(long j) {
        TopicsSyncTask topicsSyncTask = new TopicsSyncTask(this, this.context, this.metadata, Math.min(Math.max(30, 2 * j), MAX_DELAY_SEC));
        this.syncExecutor.schedule(topicsSyncTask, j, TimeUnit.SECONDS);
        setSyncScheduledOrRunning(true);
    }
}
