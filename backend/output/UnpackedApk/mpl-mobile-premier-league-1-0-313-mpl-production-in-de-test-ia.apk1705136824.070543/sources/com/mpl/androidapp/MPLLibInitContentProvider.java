package com.mpl.androidapp;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.soloader.SoLoader;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.network.modules.MClient;
import kotlin.jvm.internal.Intrinsics;

public class MPLLibInitContentProvider extends ContentProvider {
    @VisibleForTesting
    public static final String EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY = "com.google.firebase.libinitcontentprovider";
    public static final String TAG = "AppLoading:Content";
    public static MPLLibInitContentProvider libInitContentProvider;
    public AppEventsLogger mFacebookAppEventsLogger;
    public FirebaseAnalytics mFirebaseAnalytics;

    public static void checkContentProviderAuthority(ProviderInfo providerInfo) {
        Preconditions.checkNotNull(providerInfo, "FirebaseInitProvider ProviderInfo cannot be null.");
        if (EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY.equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }

    public static MPLLibInitContentProvider getLibInitContentProvider() {
        return libInitContentProvider;
    }

    private void initFacebook() {
        SoLoader.init(getContext(), false);
        FacebookSdk.sdkInitialize(getContext());
        if (MBuildConfigUtils.isLogEnabled()) {
            FacebookSdk.isDebugEnabledField = true;
            FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_RAW_RESPONSES);
        }
        Context context = getContext();
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFacebookAppEventsLogger = new AppEventsLogger(context, null, null, null);
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                UserSettingsManager.autoLogAppEventsEnabled.value = Boolean.TRUE;
                UserSettingsManager.autoLogAppEventsEnabled.lastTS = System.currentTimeMillis();
                if (UserSettingsManager.isInitialized.get()) {
                    UserSettingsManager.INSTANCE.writeSettingToCache(UserSettingsManager.autoLogAppEventsEnabled);
                } else {
                    UserSettingsManager.INSTANCE.initializeIfNotInitialized();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        ActivityLifecycleTracker.startTracking((Application) FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId());
        FacebookSdk.isDebugEnabledField = MBuildConfigUtils.isLogEnabled();
        if (getContext() != null) {
            Fresco.initialize(getContext(), null, null);
        }
    }

    private void initJodaLib() {
        if (getContext() != null) {
            getContext();
        }
    }

    private void initializeFireBase() {
        if (getContext() != null) {
            this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(getContext());
        }
    }

    private void initializeLogger() {
        MLogger.setIsLogEnabled(MBuildConfigUtils.isLogEnabled());
        MClient.setLogEnable(MBuildConfigUtils.isLogEnabled());
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        checkContentProviderAuthority(providerInfo);
        super.attachInfo(context, providerInfo);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public AppEventsLogger getFacebookAppEventsLogger() {
        return this.mFacebookAppEventsLogger;
    }

    public FirebaseAnalytics getFirebaseAnalytics() {
        return this.mFirebaseAnalytics;
    }

    public String getType(Uri uri) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean onCreate() {
        libInitContentProvider = this;
        initializeLogger();
        initializeFireBase();
        initJodaLib();
        initFacebook();
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
