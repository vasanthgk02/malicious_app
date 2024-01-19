package com.google.firebase;

import a.a.a.a.d.b;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.events.Publisher;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public class FirebaseApp {
    public static final Map<String, FirebaseApp> INSTANCES = new ArrayMap();
    public static final Object LOCK = new Object();
    public static final Executor UI_EXECUTOR = new UiExecutor(null);
    public final Context applicationContext;
    public final AtomicBoolean automaticResourceManagementEnabled = new AtomicBoolean(false);
    public final List<BackgroundStateChangeListener> backgroundStateChangeListeners = new CopyOnWriteArrayList();
    public final ComponentRuntime componentRuntime;
    public final Lazy<DataCollectionConfigStorage> dataCollectionConfigStorage;
    public final Provider<DefaultHeartBeatController> defaultHeartBeatController;
    public final AtomicBoolean deleted = new AtomicBoolean();
    public final String name;
    public final FirebaseOptions options;

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    @TargetApi(14)
    public static class GlobalBackgroundStateListener implements com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener {
        public static AtomicReference<GlobalBackgroundStateListener> INSTANCE = new AtomicReference<>();

        public static void access$100(Context context) {
            if (context.getApplicationContext() instanceof Application) {
                Application application = (Application) context.getApplicationContext();
                if (INSTANCE.get() == null) {
                    GlobalBackgroundStateListener globalBackgroundStateListener = new GlobalBackgroundStateListener();
                    if (INSTANCE.compareAndSet(null, globalBackgroundStateListener)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector backgroundDetector = BackgroundDetector.zza;
                        if (backgroundDetector != null) {
                            synchronized (backgroundDetector) {
                                backgroundDetector.zzd.add(globalBackgroundStateListener);
                            }
                            return;
                        }
                        throw null;
                    }
                }
            }
        }

        public void onBackgroundStateChanged(boolean z) {
            synchronized (FirebaseApp.LOCK) {
                Iterator it = new ArrayList(FirebaseApp.INSTANCES.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.automaticResourceManagementEnabled.get()) {
                        for (BackgroundStateChangeListener onBackgroundStateChanged : firebaseApp.backgroundStateChangeListeners) {
                            onBackgroundStateChanged.onBackgroundStateChanged(z);
                        }
                    }
                }
            }
        }
    }

    public static class UiExecutor implements Executor {
        public static final Handler HANDLER = new Handler(Looper.getMainLooper());

        public UiExecutor(AnonymousClass1 r1) {
        }

        public void execute(Runnable runnable) {
            HANDLER.post(runnable);
        }
    }

    @TargetApi(24)
    public static class UserUnlockReceiver extends BroadcastReceiver {
        public static AtomicReference<UserUnlockReceiver> INSTANCE = new AtomicReference<>();
        public final Context applicationContext;

        public UserUnlockReceiver(Context context) {
            this.applicationContext = context;
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.LOCK) {
                for (FirebaseApp initializeAllApis : FirebaseApp.INSTANCES.values()) {
                    initializeAllApis.initializeAllApis();
                }
            }
            this.applicationContext.unregisterReceiver(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b0 A[LOOP:1: B:23:0x00aa->B:25:0x00b0, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FirebaseApp(android.content.Context r9, java.lang.String r10, com.google.firebase.FirebaseOptions r11) {
        /*
            r8 = this;
            r8.<init>()
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r1 = 0
            r0.<init>(r1)
            r8.automaticResourceManagementEnabled = r0
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r0.<init>()
            r8.deleted = r0
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            r8.backgroundStateChangeListeners = r0
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            r8.applicationContext = r9
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.name = r10
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)
            r8.options = r11
            java.lang.Class<com.google.firebase.components.ComponentDiscoveryService> r10 = com.google.firebase.components.ComponentDiscoveryService.class
            com.google.firebase.components.ComponentDiscovery$MetadataRegistrarNameRetriever r0 = new com.google.firebase.components.ComponentDiscovery$MetadataRegistrarNameRetriever
            r2 = 0
            r0.<init>(r10, r2)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            android.content.pm.PackageManager r3 = r9.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0066 }
            if (r3 != 0) goto L_0x0041
            goto L_0x0066
        L_0x0041:
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0066 }
            java.lang.Class<? extends android.app.Service> r5 = r0.discoveryService     // Catch:{ NameNotFoundException -> 0x0066 }
            r4.<init>(r9, r5)     // Catch:{ NameNotFoundException -> 0x0066 }
            r5 = 128(0x80, float:1.8E-43)
            android.content.pm.ServiceInfo r3 = r3.getServiceInfo(r4, r5)     // Catch:{ NameNotFoundException -> 0x0066 }
            if (r3 != 0) goto L_0x0063
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x0066 }
            r3.<init>()     // Catch:{ NameNotFoundException -> 0x0066 }
            java.lang.Class<? extends android.app.Service> r0 = r0.discoveryService     // Catch:{ NameNotFoundException -> 0x0066 }
            r3.append(r0)     // Catch:{ NameNotFoundException -> 0x0066 }
            java.lang.String r0 = " has no service info."
            r3.append(r0)     // Catch:{ NameNotFoundException -> 0x0066 }
            r3.toString()     // Catch:{ NameNotFoundException -> 0x0066 }
            goto L_0x0066
        L_0x0063:
            android.os.Bundle r0 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0066 }
            goto L_0x0067
        L_0x0066:
            r0 = r2
        L_0x0067:
            if (r0 != 0) goto L_0x006e
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x00a6
        L_0x006e:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Set r4 = r0.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x007b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00a5
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.get(r5)
            java.lang.String r7 = "com.google.firebase.components.ComponentRegistrar"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x007b
            java.lang.String r6 = "com.google.firebase.components:"
            boolean r6 = r5.startsWith(r6)
            if (r6 == 0) goto L_0x007b
            r6 = 31
            java.lang.String r5 = r5.substring(r6)
            r3.add(r5)
            goto L_0x007b
        L_0x00a5:
            r0 = r3
        L_0x00a6:
            java.util.Iterator r0 = r0.iterator()
        L_0x00aa:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00bf
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            com.google.firebase.components.-$$Lambda$ComponentDiscovery$oLM-yhYK-SYmNT0x_BcVGBdypps r4 = new com.google.firebase.components.-$$Lambda$ComponentDiscovery$oLM-yhYK-SYmNT0x_BcVGBdypps
            r4.<init>(r3)
            r10.add(r4)
            goto L_0x00aa
        L_0x00bf:
            java.util.concurrent.Executor r0 = UI_EXECUTOR
            com.google.firebase.components.ComponentRuntime$Builder r0 = com.google.firebase.components.ComponentRuntime.builder(r0)
            java.util.List<com.google.firebase.inject.Provider<com.google.firebase.components.ComponentRegistrar>> r3 = r0.lazyRegistrars
            r3.addAll(r10)
            com.google.firebase.FirebaseCommonRegistrar r10 = new com.google.firebase.FirebaseCommonRegistrar
            r10.<init>()
            java.util.List<com.google.firebase.inject.Provider<com.google.firebase.components.ComponentRegistrar>> r3 = r0.lazyRegistrars
            com.google.firebase.components.-$$Lambda$ComponentRuntime$Builder$PuZUk0ZoyoJafAUrHnbCxfAdM_4 r4 = new com.google.firebase.components.-$$Lambda$ComponentRuntime$Builder$PuZUk0ZoyoJafAUrHnbCxfAdM_4
            r4.<init>()
            r3.add(r4)
            java.lang.Class<android.content.Context> r10 = android.content.Context.class
            java.lang.Class[] r3 = new java.lang.Class[r1]
            com.google.firebase.components.Component r10 = com.google.firebase.components.Component.of(r9, r10, r3)
            java.util.List<com.google.firebase.components.Component<?>> r3 = r0.additionalComponents
            r3.add(r10)
            java.lang.Class<com.google.firebase.FirebaseApp> r10 = com.google.firebase.FirebaseApp.class
            java.lang.Class[] r3 = new java.lang.Class[r1]
            com.google.firebase.components.Component r10 = com.google.firebase.components.Component.of(r8, r10, r3)
            java.util.List<com.google.firebase.components.Component<?>> r3 = r0.additionalComponents
            r3.add(r10)
            java.lang.Class<com.google.firebase.FirebaseOptions> r10 = com.google.firebase.FirebaseOptions.class
            java.lang.Class[] r1 = new java.lang.Class[r1]
            com.google.firebase.components.Component r10 = com.google.firebase.components.Component.of(r11, r10, r1)
            java.util.List<com.google.firebase.components.Component<?>> r11 = r0.additionalComponents
            r11.add(r10)
            com.google.firebase.components.ComponentRuntime r10 = new com.google.firebase.components.ComponentRuntime
            java.util.concurrent.Executor r11 = r0.defaultExecutor
            java.util.List<com.google.firebase.inject.Provider<com.google.firebase.components.ComponentRegistrar>> r1 = r0.lazyRegistrars
            java.util.List<com.google.firebase.components.Component<?>> r0 = r0.additionalComponents
            r10.<init>(r11, r1, r0, r2)
            r8.componentRuntime = r10
            com.google.firebase.components.Lazy r10 = new com.google.firebase.components.Lazy
            com.google.firebase.-$$Lambda$FirebaseApp$g2HBDSvWXpy9ytXuN68VN_QnBHQ r11 = new com.google.firebase.-$$Lambda$FirebaseApp$g2HBDSvWXpy9ytXuN68VN_QnBHQ
            r11.<init>(r9)
            r10.<init>(r11)
            r8.dataCollectionConfigStorage = r10
            com.google.firebase.components.ComponentRuntime r9 = r8.componentRuntime
            java.lang.Class<com.google.firebase.heartbeatinfo.DefaultHeartBeatController> r10 = com.google.firebase.heartbeatinfo.DefaultHeartBeatController.class
            com.google.firebase.inject.Provider r9 = r9.getProvider(r10)
            r8.defaultHeartBeatController = r9
            com.google.firebase.-$$Lambda$FirebaseApp$L36zwVmbFPaqM0CmCLQQ8A8VcRs r9 = new com.google.firebase.-$$Lambda$FirebaseApp$L36zwVmbFPaqM0CmCLQQ8A8VcRs
            r9.<init>()
            r8.checkNotDeleted()
            java.util.concurrent.atomic.AtomicBoolean r10 = r8.automaticResourceManagementEnabled
            boolean r10 = r10.get()
            if (r10 == 0) goto L_0x0141
            com.google.android.gms.common.api.internal.BackgroundDetector r10 = com.google.android.gms.common.api.internal.BackgroundDetector.zza
            java.util.concurrent.atomic.AtomicBoolean r10 = r10.zzb
            boolean r10 = r10.get()
            if (r10 == 0) goto L_0x0141
            r10 = 1
            r9.onBackgroundStateChanged(r10)
        L_0x0141:
            java.util.List<com.google.firebase.FirebaseApp$BackgroundStateChangeListener> r10 = r8.backgroundStateChangeListeners
            r10.add(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.FirebaseApp.<init>(android.content.Context, java.lang.String, com.google.firebase.FirebaseOptions):void");
    }

    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (LOCK) {
            firebaseApp = INSTANCES.get("[DEFAULT]");
            if (firebaseApp == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp initializeApp(Context context) {
        synchronized (LOCK) {
            if (INSTANCES.containsKey("[DEFAULT]")) {
                FirebaseApp instance = getInstance();
                return instance;
            }
            FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
            if (fromResource == null) {
                return null;
            }
            FirebaseApp initializeApp = initializeApp(context, fromResource);
            return initializeApp;
        }
    }

    public final void checkNotDeleted() {
        Preconditions.checkState(!this.deleted.get(), "FirebaseApp was deleted");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        String str = this.name;
        FirebaseApp firebaseApp = (FirebaseApp) obj;
        firebaseApp.checkNotDeleted();
        return str.equals(firebaseApp.name);
    }

    @KeepForSdk
    public String getPersistenceKey() {
        String str;
        StringBuilder sb = new StringBuilder();
        checkNotDeleted();
        byte[] bytes = this.name.getBytes(Charset.defaultCharset());
        String str2 = null;
        if (bytes == null) {
            str = null;
        } else {
            str = Base64.encodeToString(bytes, 11);
        }
        sb.append(str);
        sb.append(MqttTopic.SINGLE_LEVEL_WILDCARD);
        checkNotDeleted();
        byte[] bytes2 = this.options.applicationId.getBytes(Charset.defaultCharset());
        if (bytes2 != null) {
            str2 = Base64.encodeToString(bytes2, 11);
        }
        sb.append(str2);
        return sb.toString();
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public final void initializeAllApis() {
        HashMap hashMap;
        if (!b.isUserUnlocked(this.applicationContext)) {
            checkNotDeleted();
            Context context = this.applicationContext;
            if (UserUnlockReceiver.INSTANCE.get() == null) {
                UserUnlockReceiver userUnlockReceiver = new UserUnlockReceiver(context);
                if (UserUnlockReceiver.INSTANCE.compareAndSet(null, userUnlockReceiver)) {
                    context.registerReceiver(userUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                    return;
                }
                return;
            }
            return;
        }
        checkNotDeleted();
        ComponentRuntime componentRuntime2 = this.componentRuntime;
        boolean isDefaultApp = isDefaultApp();
        if (componentRuntime2.eagerComponentsInitializedWith.compareAndSet(null, Boolean.valueOf(isDefaultApp))) {
            synchronized (componentRuntime2) {
                hashMap = new HashMap(componentRuntime2.components);
            }
            componentRuntime2.doInitializeEagerComponents(hashMap, isDefaultApp);
        }
        ((DefaultHeartBeatController) this.defaultHeartBeatController.get()).registerHeartBeat();
    }

    @KeepForSdk
    public boolean isDataCollectionDefaultEnabled() {
        boolean z;
        checkNotDeleted();
        DataCollectionConfigStorage dataCollectionConfigStorage2 = (DataCollectionConfigStorage) this.dataCollectionConfigStorage.get();
        synchronized (dataCollectionConfigStorage2) {
            z = dataCollectionConfigStorage2.dataCollectionDefaultEnabled;
        }
        return z;
    }

    @KeepForSdk
    public boolean isDefaultApp() {
        checkNotDeleted();
        return "[DEFAULT]".equals(this.name);
    }

    public /* synthetic */ DataCollectionConfigStorage lambda$new$0$FirebaseApp(Context context) {
        return new DataCollectionConfigStorage(context, getPersistenceKey(), (Publisher) this.componentRuntime.get(Publisher.class));
    }

    public /* synthetic */ void lambda$new$1$FirebaseApp(boolean z) {
        if (!z) {
            ((DefaultHeartBeatController) this.defaultHeartBeatController.get()).registerHeartBeat();
        }
    }

    public String toString() {
        ToStringHelper toStringHelper = new ToStringHelper(this);
        toStringHelper.add("name", this.name);
        toStringHelper.add("options", this.options);
        return toStringHelper.toString();
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        FirebaseApp firebaseApp;
        GlobalBackgroundStateListener.access$100(context);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (LOCK) {
            Preconditions.checkState(!INSTANCES.containsKey("[DEFAULT]"), "FirebaseApp name [DEFAULT] already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, "[DEFAULT]", firebaseOptions);
            INSTANCES.put("[DEFAULT]", firebaseApp);
        }
        firebaseApp.initializeAllApis();
        return firebaseApp;
    }
}
