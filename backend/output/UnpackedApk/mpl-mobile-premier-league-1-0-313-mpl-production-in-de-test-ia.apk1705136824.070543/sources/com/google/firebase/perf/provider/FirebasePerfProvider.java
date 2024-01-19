package com.google.firebase.perf.provider;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.perf.FirebasePerformanceInitializer;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.google.firebase.perf.metrics.AppStartTrace.StartFromBackgroundRunnable;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Keep
public class FirebasePerfProvider extends ContentProvider {
    public static final Timer APP_START_TIME = new Timer();
    @VisibleForTesting
    public static final String EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY = "com.google.firebase.firebaseperfprovider";
    public final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static void checkContentProviderAuthority(ProviderInfo providerInfo) {
        Preconditions.checkNotNull(providerInfo, "FirebasePerfProvider ProviderInfo cannot be null.");
        if (EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY.equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }

    public static Timer getAppStartTime() {
        return APP_START_TIME;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        AppStartTrace appStartTrace;
        checkContentProviderAuthority(providerInfo);
        super.attachInfo(context, providerInfo);
        ConfigResolver instance = ConfigResolver.getInstance();
        Context context2 = getContext();
        if (instance != null) {
            Context applicationContext = context2.getApplicationContext();
            ConfigResolver.logger.isLogcatEnabled = Utils.isDebugLoggingEnabled(applicationContext);
            instance.deviceCacheManager.setContext(applicationContext);
            AppStateMonitor instance2 = AppStateMonitor.getInstance();
            Context context3 = getContext();
            synchronized (instance2) {
                if (!instance2.isRegisteredForLifecycleCallbacks) {
                    Context applicationContext2 = context3.getApplicationContext();
                    if (applicationContext2 instanceof Application) {
                        ((Application) applicationContext2).registerActivityLifecycleCallbacks(instance2);
                        instance2.isRegisteredForLifecycleCallbacks = true;
                    }
                }
            }
            FirebasePerformanceInitializer firebasePerformanceInitializer = new FirebasePerformanceInitializer();
            synchronized (instance2.appStateSubscribers) {
                instance2.appColdStartSubscribers.add(firebasePerformanceInitializer);
            }
            if (AppStartTrace.instance != null) {
                appStartTrace = AppStartTrace.instance;
            } else {
                TransportManager transportManager = TransportManager.instance;
                Clock clock = new Clock();
                if (AppStartTrace.instance == null) {
                    synchronized (AppStartTrace.class) {
                        if (AppStartTrace.instance == null) {
                            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, AppStartTrace.MAX_LATENCY_BEFORE_UI_INIT + 10, TimeUnit.SECONDS, new LinkedBlockingQueue(1));
                            AppStartTrace.instance = new AppStartTrace(transportManager, clock, threadPoolExecutor);
                        }
                    }
                }
                appStartTrace = AppStartTrace.instance;
            }
            Context context4 = getContext();
            synchronized (appStartTrace) {
                if (!appStartTrace.isRegisteredForLifecycleCallbacks) {
                    Context applicationContext3 = context4.getApplicationContext();
                    if (applicationContext3 instanceof Application) {
                        ((Application) applicationContext3).registerActivityLifecycleCallbacks(appStartTrace);
                        appStartTrace.isRegisteredForLifecycleCallbacks = true;
                        appStartTrace.appContext = applicationContext3;
                    }
                }
            }
            this.mainHandler.post(new StartFromBackgroundRunnable(appStartTrace));
            SessionManager.getInstance().initializeGaugeCollection();
            return;
        }
        throw null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
