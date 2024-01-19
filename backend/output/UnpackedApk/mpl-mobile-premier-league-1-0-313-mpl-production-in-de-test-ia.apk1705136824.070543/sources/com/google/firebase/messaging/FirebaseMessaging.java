package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzn;
import com.google.android.gms.tasks.zzw;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal.NewTokenListener;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.FirebaseMessaging.AutoInit;
import com.google.firebase.messaging.Store.Token;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.userexperior.models.recording.enums.UeCustomType;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FirebaseMessaging {
    public static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    public static Store store;
    public static ScheduledExecutorService syncExecutor;
    @SuppressLint({"FirebaseUnknownNullness"})
    public static TransportFactory transportFactory;
    public final AutoInit autoInit;
    public final Context context;
    public final Executor fileIoExecutor;
    public final FirebaseApp firebaseApp;
    public final GmsRpc gmsRpc;
    public final FirebaseInstanceIdInternal iid;
    public final ActivityLifecycleCallbacks lifecycleCallbacks;
    public final Metadata metadata;
    public final RequestDeduplicator requestDeduplicator;
    public boolean syncScheduledOrRunning = false;
    public final Task<TopicsSubscriber> topicsSubscriberTask;

    public class AutoInit {
        public Boolean autoInitEnabled;
        public EventHandler<DataCollectionDefaultChange> dataCollectionDefaultChangeEventHandler;
        public boolean initialized;
        public final Subscriber subscriber;

        public AutoInit(Subscriber subscriber2) {
            this.subscriber = subscriber2;
        }

        public synchronized void initialize() {
            if (!this.initialized) {
                Boolean readEnabled = readEnabled();
                this.autoInitEnabled = readEnabled;
                if (readEnabled == null) {
                    $$Lambda$FirebaseMessaging$AutoInit$23P0yZa6bM1cE5lPQqbBlaLiDs4 r0 = new EventHandler() {
                        public final void handle(Event event) {
                            AutoInit.this.lambda$initialize$0$FirebaseMessaging$AutoInit(event);
                        }
                    };
                    this.dataCollectionDefaultChangeEventHandler = r0;
                    this.subscriber.subscribe(DataCollectionDefaultChange.class, r0);
                }
                this.initialized = true;
            }
        }

        public synchronized boolean isEnabled() {
            boolean z;
            initialize();
            if (this.autoInitEnabled != null) {
                z = this.autoInitEnabled.booleanValue();
            } else {
                z = FirebaseMessaging.this.firebaseApp.isDataCollectionDefaultEnabled();
            }
            return z;
        }

        public /* synthetic */ void lambda$initialize$0$FirebaseMessaging$AutoInit(Event event) {
            if (isEnabled()) {
                FirebaseMessaging.this.startSyncIfNecessary();
            }
        }

        public final Boolean readEnabled() {
            FirebaseApp firebaseApp = FirebaseMessaging.this.firebaseApp;
            firebaseApp.checkNotDeleted();
            Context context = firebaseApp.applicationContext;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                    if (!(applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled"))) {
                        return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
                    }
                }
            } catch (NameNotFoundException unused) {
            }
            return null;
        }
    }

    public FirebaseMessaging(FirebaseApp firebaseApp2, FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, TransportFactory transportFactory2, Subscriber subscriber) {
        firebaseApp2.checkNotDeleted();
        Metadata metadata2 = new Metadata(firebaseApp2.applicationContext);
        GmsRpc gmsRpc2 = new GmsRpc(firebaseApp2, metadata2, provider, provider2, firebaseInstallationsApi);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Task"));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Init"));
        transportFactory = transportFactory2;
        this.firebaseApp = firebaseApp2;
        this.iid = firebaseInstanceIdInternal;
        this.autoInit = new AutoInit(subscriber);
        firebaseApp2.checkNotDeleted();
        this.context = firebaseApp2.applicationContext;
        this.lifecycleCallbacks = new FcmLifecycleCallbacks();
        this.metadata = metadata2;
        this.gmsRpc = gmsRpc2;
        this.requestDeduplicator = new RequestDeduplicator(newSingleThreadExecutor);
        this.fileIoExecutor = scheduledThreadPoolExecutor;
        firebaseApp2.checkNotDeleted();
        Context context2 = firebaseApp2.applicationContext;
        if (context2 instanceof Application) {
            ((Application) context2).registerActivityLifecycleCallbacks(this.lifecycleCallbacks);
        } else {
            "Context " + context2 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.";
        }
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.addNewTokenListener(new NewTokenListener() {
            });
        }
        scheduledThreadPoolExecutor.execute(new Runnable() {
            public final void run() {
                FirebaseMessaging.this.lambda$new$1$FirebaseMessaging();
            }
        });
        Task<TopicsSubscriber> createInstance = TopicsSubscriber.createInstance(this, metadata2, gmsRpc2, this.context, new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Topics-Io")));
        this.topicsSubscriberTask = createInstance;
        zzw zzw = (zzw) createInstance;
        zzw.zzb.zza(new zzn(scheduledThreadPoolExecutor, new OnSuccessListener() {
            public final void onSuccess(Object obj) {
                FirebaseMessaging.this.lambda$new$2$FirebaseMessaging((TopicsSubscriber) obj);
            }
        }));
        zzw.zzi();
        scheduledThreadPoolExecutor.execute(new Runnable() {
            public final void run() {
                FirebaseMessaging.this.lambda$new$3$FirebaseMessaging();
            }
        });
    }

    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging instance;
        synchronized (FirebaseMessaging.class) {
            try {
                instance = getInstance(FirebaseApp.getInstance());
            }
        }
        return instance;
    }

    public static synchronized Store getStore(Context context2) {
        Store store2;
        synchronized (FirebaseMessaging.class) {
            if (store == null) {
                store = new Store(context2);
            }
            store2 = store;
        }
        return store2;
    }

    public String blockingGetToken() throws IOException {
        Task task;
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            try {
                return (String) Tasks.await(firebaseInstanceIdInternal.getTokenTask());
            } catch (InterruptedException | ExecutionException e2) {
                throw new IOException(e2);
            }
        } else {
            Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync();
            if (!tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
                return tokenWithoutTriggeringSync.token;
            }
            String defaultSenderId = Metadata.getDefaultSenderId(this.firebaseApp);
            RequestDeduplicator requestDeduplicator2 = this.requestDeduplicator;
            synchronized (requestDeduplicator2) {
                task = requestDeduplicator2.getTokenRequests.get(defaultSenderId);
                if (task != null) {
                    Log.isLoggable("FirebaseMessaging", 3);
                } else {
                    Log.isLoggable("FirebaseMessaging", 3);
                    task = lambda$blockingGetToken$10$FirebaseMessaging(defaultSenderId, tokenWithoutTriggeringSync).continueWithTask(requestDeduplicator2.executor, new Continuation(defaultSenderId) {
                        public final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final Object then(Task task) {
                            return RequestDeduplicator.this.lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(this.f$1, task);
                        }
                    });
                    requestDeduplicator2.getTokenRequests.put(defaultSenderId, task);
                }
            }
            try {
                return (String) Tasks.await(task);
            } catch (InterruptedException | ExecutionException e3) {
                throw new IOException(e3);
            }
        }
    }

    public void enqueueTaskWithDelaySeconds(Runnable runnable, long j) {
        synchronized (FirebaseMessaging.class) {
            if (syncExecutor == null) {
                syncExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory(UeCustomType.TAG));
            }
            syncExecutor.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    public final String getSubtype() {
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        if ("[DEFAULT]".equals(firebaseApp2.name)) {
            return "";
        }
        return this.firebaseApp.getPersistenceKey();
    }

    public Task<String> getToken() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            return firebaseInstanceIdInternal.getTokenTask();
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.fileIoExecutor.execute(new Runnable(taskCompletionSource) {
            public final /* synthetic */ TaskCompletionSource f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                FirebaseMessaging.this.lambda$getToken$4$FirebaseMessaging(this.f$1);
            }
        });
        return taskCompletionSource.zza;
    }

    public Token getTokenWithoutTriggeringSync() {
        Token parse;
        Store store2 = getStore(this.context);
        String subtype = getSubtype();
        String defaultSenderId = Metadata.getDefaultSenderId(this.firebaseApp);
        synchronized (store2) {
            parse = Token.parse(store2.store.getString(store2.createTokenKey(subtype, defaultSenderId), null));
        }
        return parse;
    }

    public final void invokeOnTokenRefresh(String str) {
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        if ("[DEFAULT]".equals(firebaseApp2.name)) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                this.firebaseApp.checkNotDeleted();
            }
            Intent intent = new Intent(FirebaseMessagingService.ACTION_NEW_TOKEN);
            intent.putExtra("token", str);
            new FcmBroadcastProcessor(this.context).process(intent);
        }
    }

    public boolean isAutoInitEnabled() {
        return this.autoInit.isEnabled();
    }

    public /* synthetic */ Task lambda$blockingGetToken$10$FirebaseMessaging(String str, Token token) {
        return this.gmsRpc.getToken().onSuccessTask($$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE, new SuccessContinuation(str, token) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ Token f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Task then(Object obj) {
                return FirebaseMessaging.this.lambda$blockingGetToken$9$FirebaseMessaging(this.f$1, this.f$2, (String) obj);
            }
        });
    }

    public /* synthetic */ Task lambda$blockingGetToken$9$FirebaseMessaging(String str, Token token, String str2) throws Exception {
        getStore(this.context).saveToken(getSubtype(), str, str2, this.metadata.getAppVersionCode());
        if (token == null || !str2.equals(token.token)) {
            invokeOnTokenRefresh(str2);
        }
        return Tasks.forResult(str2);
    }

    public /* synthetic */ void lambda$getToken$4$FirebaseMessaging(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(blockingGetToken());
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    public /* synthetic */ void lambda$new$1$FirebaseMessaging() {
        if (isAutoInitEnabled()) {
            startSyncIfNecessary();
        }
    }

    public /* synthetic */ void lambda$new$2$FirebaseMessaging(TopicsSubscriber topicsSubscriber) {
        if (isAutoInitEnabled()) {
            topicsSubscriber.startTopicsSyncIfNecessary();
        }
    }

    public /* synthetic */ void lambda$new$3$FirebaseMessaging() {
        TextAppearanceConfig.initialize(this.context);
    }

    public synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    public final void startSyncIfNecessary() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.getToken();
            return;
        }
        if (tokenNeedsRefresh(getTokenWithoutTriggeringSync())) {
            synchronized (this) {
                if (!this.syncScheduledOrRunning) {
                    syncWithDelaySecondsInternal(0);
                }
            }
        }
    }

    public synchronized void syncWithDelaySecondsInternal(long j) {
        enqueueTaskWithDelaySeconds(new SyncTask(this, Math.min(Math.max(30, 2 * j), MAX_DELAY_SEC)), j);
        this.syncScheduledOrRunning = true;
    }

    public boolean tokenNeedsRefresh(Token token) {
        if (token != null) {
            if (!(System.currentTimeMillis() > token.timestamp + Token.REFRESH_PERIOD_MILLIS || !this.metadata.getAppVersionCode().equals(token.appVersion))) {
                return false;
            }
        }
        return true;
    }

    @Keep
    public static synchronized FirebaseMessaging getInstance(FirebaseApp firebaseApp2) {
        FirebaseMessaging firebaseMessaging;
        Class cls = FirebaseMessaging.class;
        synchronized (cls) {
            firebaseApp2.checkNotDeleted();
            firebaseMessaging = (FirebaseMessaging) firebaseApp2.componentRuntime.get(cls);
            Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }
}
