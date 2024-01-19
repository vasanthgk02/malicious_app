package com.google.firebase.perf;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.datatransport.TransportFactory;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.ImmutableBundle;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FirebasePerformance {
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public final ConfigResolver configResolver;
    public final Map<String, String> mCustomAttributes = new ConcurrentHashMap();
    public final ImmutableBundle mMetadataBundle;
    public Boolean mPerformanceCollectionForceEnabledState = null;

    public FirebasePerformance(FirebaseApp firebaseApp, Provider<RemoteConfigComponent> provider, FirebaseInstallationsApi firebaseInstallationsApi, Provider<TransportFactory> provider2, RemoteConfigManager remoteConfigManager, ConfigResolver configResolver2, SessionManager sessionManager) {
        Bundle bundle;
        ImmutableBundle immutableBundle;
        boolean z;
        if (firebaseApp == null) {
            this.mPerformanceCollectionForceEnabledState = Boolean.FALSE;
            this.configResolver = configResolver2;
            this.mMetadataBundle = new ImmutableBundle(new Bundle());
            return;
        }
        TransportManager transportManager = TransportManager.instance;
        transportManager.firebaseApp = firebaseApp;
        firebaseApp.checkNotDeleted();
        transportManager.projectId = firebaseApp.options.projectId;
        transportManager.firebaseInstallationsApi = firebaseInstallationsApi;
        transportManager.flgTransportFactoryProvider = provider2;
        transportManager.executorService.execute(new Runnable() {
            public final void run() {
                TransportManager.this.syncInit();
            }
        });
        firebaseApp.checkNotDeleted();
        Context context = firebaseApp.applicationContext;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (NameNotFoundException | NullPointerException e2) {
            e2.getMessage();
            bundle = null;
        }
        if (bundle != null) {
            immutableBundle = new ImmutableBundle(bundle);
        } else {
            immutableBundle = new ImmutableBundle();
        }
        this.mMetadataBundle = immutableBundle;
        remoteConfigManager.setFirebaseRemoteConfigProvider(provider);
        this.configResolver = configResolver2;
        configResolver2.metadataBundle = this.mMetadataBundle;
        ConfigResolver.logger.isLogcatEnabled = Utils.isDebugLoggingEnabled(context);
        configResolver2.deviceCacheManager.setContext(context);
        sessionManager.setApplicationContext(context);
        Boolean isPerformanceCollectionEnabled = configResolver2.getIsPerformanceCollectionEnabled();
        this.mPerformanceCollectionForceEnabledState = isPerformanceCollectionEnabled;
        if (logger.isLogcatEnabled) {
            if (isPerformanceCollectionEnabled != null) {
                z = isPerformanceCollectionEnabled.booleanValue();
            } else {
                z = FirebaseApp.getInstance().isDataCollectionDefaultEnabled();
            }
            if (z) {
                AndroidLogger androidLogger = logger;
                firebaseApp.checkNotDeleted();
                String.format("Firebase Performance Monitoring is successfully initialized! In a minute, visit the Firebase console to view your data: %s", new Object[]{String.format("%s/trends?utm_source=%s&utm_medium=%s", new Object[]{TextAppearanceConfig.getRootUrl(firebaseApp.options.projectId, context.getPackageName()), "perf-android-sdk", "android-ide"})});
                if (androidLogger.isLogcatEnabled && androidLogger.logWrapper == null) {
                    throw null;
                }
            }
        }
    }

    public static FirebasePerformance getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        instance.checkNotDeleted();
        return (FirebasePerformance) instance.componentRuntime.get(FirebasePerformance.class);
    }

    public static Trace startTrace(String str) {
        Trace trace = new Trace(str, TransportManager.instance, new Clock(), AppStateMonitor.getInstance(), GaugeManager.getInstance());
        trace.start();
        return trace;
    }
}
