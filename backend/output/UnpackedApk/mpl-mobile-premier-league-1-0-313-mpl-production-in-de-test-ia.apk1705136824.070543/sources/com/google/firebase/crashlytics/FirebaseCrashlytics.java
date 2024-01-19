package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.inject.Deferred;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class FirebaseCrashlytics {
    public static final int APP_EXCEPTION_CALLBACK_TIMEOUT_MS = 500;
    public static final String FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN = "clx";
    public static final String LEGACY_CRASH_ANALYTICS_ORIGIN = "crash";
    public final CrashlyticsCore core;

    public FirebaseCrashlytics(CrashlyticsCore crashlyticsCore) {
        this.core = crashlyticsCore;
    }

    public static FirebaseCrashlytics getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        instance.checkNotDeleted();
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) instance.componentRuntime.get(FirebaseCrashlytics.class);
        if (firebaseCrashlytics != null) {
            return firebaseCrashlytics;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    public static FirebaseCrashlytics init(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Deferred<CrashlyticsNativeComponent> deferred, Deferred<AnalyticsConnector> deferred2) {
        FirebaseApp firebaseApp2 = firebaseApp;
        firebaseApp.checkNotDeleted();
        Context context = firebaseApp2.applicationContext;
        String packageName = context.getPackageName();
        Logger logger = Logger.getLogger();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Initializing Firebase Crashlytics ");
        outline73.append(CrashlyticsCore.getVersion());
        outline73.append(" for ");
        outline73.append(packageName);
        logger.i(outline73.toString());
        FileStore fileStore = new FileStore(context);
        DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp);
        IdManager idManager = new IdManager(context, packageName, firebaseInstallationsApi, dataCollectionArbiter);
        CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy = new CrashlyticsNativeComponentDeferredProxy(deferred);
        AnalyticsDeferredProxy analyticsDeferredProxy = new AnalyticsDeferredProxy(deferred2);
        FirebaseApp firebaseApp3 = firebaseApp;
        IdManager idManager2 = idManager;
        DataCollectionArbiter dataCollectionArbiter2 = dataCollectionArbiter;
        final CrashlyticsCore crashlyticsCore = new CrashlyticsCore(firebaseApp3, idManager2, crashlyticsNativeComponentDeferredProxy, dataCollectionArbiter2, analyticsDeferredProxy.getDeferredBreadcrumbSource(), analyticsDeferredProxy.getAnalyticsEventLogger(), fileStore, ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler"));
        firebaseApp.checkNotDeleted();
        String str = firebaseApp2.options.applicationId;
        String mappingFileId = CommonUtils.getMappingFileId(context);
        Logger logger2 = Logger.getLogger();
        logger2.d("Mapping file ID is: " + mappingFileId);
        try {
            AppData create = AppData.create(context, idManager, str, mappingFileId, new DevelopmentPlatformProvider(context));
            Logger logger3 = Logger.getLogger();
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Installer package name is: ");
            outline732.append(create.installerPackageName);
            logger3.v(outline732.toString());
            ExecutorService buildSingleThreadExecutorService = ExecutorUtils.buildSingleThreadExecutorService("com.google.firebase.crashlytics.startup");
            final SettingsController create2 = SettingsController.create(context, str, idManager, new HttpRequestFactory(), create.versionCode, create.versionName, fileStore, dataCollectionArbiter);
            create2.loadSettingsData(buildSingleThreadExecutorService).continueWith(buildSingleThreadExecutorService, new Continuation<Void, Object>() {
                public Object then(Task<Void> task) throws Exception {
                    if (!task.isSuccessful()) {
                        Logger.getLogger().e("Error fetching settings.", task.getException());
                    }
                    return null;
                }
            });
            final boolean onPreExecute = crashlyticsCore.onPreExecute(create, create2);
            Tasks.call(buildSingleThreadExecutorService, new Callable<Void>() {
                public Void call() throws Exception {
                    if (onPreExecute) {
                        crashlyticsCore.doBackgroundInitializationAsync(create2);
                    }
                    return null;
                }
            });
            return new FirebaseCrashlytics(crashlyticsCore);
        } catch (NameNotFoundException e2) {
            Logger.getLogger().e("Error retrieving app package info.", e2);
            return null;
        }
    }

    public Task<Boolean> checkForUnsentReports() {
        return this.core.checkForUnsentReports();
    }

    public void deleteUnsentReports() {
        this.core.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.core.didCrashOnPreviousExecution();
    }

    public void log(String str) {
        this.core.log(str);
    }

    public void recordException(Throwable th) {
        if (th == null) {
            Logger.getLogger().w("A null value was passed to recordException. Ignoring.");
        } else {
            this.core.logException(th);
        }
    }

    public void sendUnsentReports() {
        this.core.sendUnsentReports();
    }

    public void setCrashlyticsCollectionEnabled(boolean z) {
        this.core.setCrashlyticsCollectionEnabled(Boolean.valueOf(z));
    }

    public void setCustomKey(String str, boolean z) {
        this.core.setCustomKey(str, Boolean.toString(z));
    }

    public void setCustomKeys(CustomKeysAndValues customKeysAndValues) {
        this.core.setCustomKeys(customKeysAndValues.keysAndValues);
    }

    public void setUserId(String str) {
        this.core.setUserId(str);
    }

    public void setCrashlyticsCollectionEnabled(Boolean bool) {
        this.core.setCrashlyticsCollectionEnabled(bool);
    }

    public void setCustomKey(String str, double d2) {
        this.core.setCustomKey(str, Double.toString(d2));
    }

    public void setCustomKey(String str, float f2) {
        this.core.setCustomKey(str, Float.toString(f2));
    }

    public void setCustomKey(String str, int i) {
        this.core.setCustomKey(str, Integer.toString(i));
    }

    public void setCustomKey(String str, long j) {
        this.core.setCustomKey(str, Long.toString(j));
    }

    public void setCustomKey(String str, String str2) {
        this.core.setCustomKey(str, str2);
    }
}
