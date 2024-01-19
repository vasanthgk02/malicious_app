package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.AccessToken.Companion;
import com.facebook.GraphRequest.Callback;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.AppEventsManager$start$1;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.$$Lambda$O45CUUZLqADBRGg36POLE65ON_4;
import com.facebook.internal.instrument.$$Lambda$W14zN8pSqs882CZOyfFpXGD91k;
import com.facebook.internal.instrument.$$Lambda$afbQg6_R8R87G093r1zWqUFMaOY;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0001\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020?H\u0007J\b\u0010H\u001a\u00020FH\u0007J\b\u0010I\u001a\u00020FH\u0007J\b\u0010J\u001a\u00020*H\u0007J\b\u0010K\u001a\u00020&H\u0007J\b\u0010L\u001a\u00020\u0004H\u0007J\n\u0010M\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010N\u001a\u0004\u0018\u00010\u00042\b\u0010O\u001a\u0004\u0018\u00010&H\u0007J\b\u0010P\u001a\u00020*H\u0007J\b\u0010Q\u001a\u00020*H\u0007J\n\u0010R\u001a\u0004\u0018\u00010-H\u0007J\b\u0010S\u001a\u00020\u0016H\u0007J\b\u0010T\u001a\u00020\u0004H\u0007J\b\u0010U\u001a\u00020*H\u0007J\b\u0010V\u001a\u00020*H\u0007J\b\u0010W\u001a\u000202H\u0007J\b\u0010X\u001a\u00020\u0004H\u0007J\b\u0010Y\u001a\u00020\u0004H\u0007J\b\u0010Z\u001a\u00020\u0004H\u0007J\b\u0010[\u001a\u00020\u0004H\u0007J\b\u0010\\\u001a\u00020\u0004H\u0007J\u0010\u0010]\u001a\u00020*2\u0006\u0010O\u001a\u00020&H\u0007J\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020?0_H\u0007J\b\u0010`\u001a\u00020*H\u0007J\b\u0010a\u001a\u00020bH\u0007J\b\u0010c\u001a\u00020\u0004H\u0007J\b\u0010d\u001a\u00020*H\u0007J\u0010\u0010e\u001a\u00020*2\u0006\u0010f\u001a\u00020\u0016H\u0007J\b\u0010;\u001a\u00020*H\u0007J\b\u0010g\u001a\u00020*H\u0007J\b\u0010<\u001a\u00020*H\u0007J\u0010\u0010h\u001a\u00020*2\u0006\u0010G\u001a\u00020?H\u0007J\u0017\u0010i\u001a\u00020F2\b\u0010O\u001a\u0004\u0018\u00010&H\u0001¢\u0006\u0002\bjJ\u0018\u0010k\u001a\u00020F2\u0006\u0010O\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004H\u0003J\u0018\u0010l\u001a\u00020F2\u0006\u0010O\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004H\u0007J\u0010\u0010m\u001a\u00020F2\u0006\u0010G\u001a\u00020?H\u0007J\u0010\u0010n\u001a\u00020F2\u0006\u0010%\u001a\u00020&H\u0007J\u001a\u0010n\u001a\u00020F2\u0006\u0010%\u001a\u00020&2\b\u0010o\u001a\u0004\u0018\u00010pH\u0007J\u0018\u0010n\u001a\u00020F2\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020\u0016H\u0007J\"\u0010n\u001a\u00020F2\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020\u00162\b\u0010o\u001a\u0004\u0018\u00010pH\u0007J\u0010\u0010q\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u0010\u0010s\u001a\u00020F2\u0006\u0010'\u001a\u00020\u0004H\u0007J\u0012\u0010t\u001a\u00020F2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010u\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u0010\u0010v\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u0010\u0010w\u001a\u00020F2\u0006\u0010+\u001a\u00020-H\u0007J\u0012\u0010x\u001a\u00020F2\b\u0010y\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010z\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u001d\u0010{\u001a\u00020F2\u000e\u0010|\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010}H\u0007¢\u0006\u0002\u0010~J/\u0010{\u001a\u00020F2\u000e\u0010|\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010}2\u0006\u0010\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u0016H\u0007¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0001\u001a\u00020F2\u0006\u00101\u001a\u000202H\u0007J\u0011\u0010\u0001\u001a\u00020F2\u0006\u00103\u001a\u00020\u0004H\u0007J\u0011\u0010\u0001\u001a\u00020F2\u0006\u00104\u001a\u00020\u0004H\u0007J\u0017\u0010\u0001\u001a\u00020F2\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0003\b\u0001J\u0012\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020*H\u0007J\u0012\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020*H\u0007J\u001a\u0010\u0001\u001a\u00020F2\u0006\u0010O\u001a\u00020&2\u0007\u0010\u0001\u001a\u00020*H\u0007J\u0011\u0010\u0001\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u0012\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020bH\u0007J\t\u0010\u0001\u001a\u00020FH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n \"*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010=\u001a\u0012\u0012\u0004\u0012\u00020?0>j\b\u0012\u0004\u0012\u00020?`@X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/facebook/FacebookSdk;", "", "()V", "ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY", "", "APPLICATION_ID_PROPERTY", "APPLICATION_NAME_PROPERTY", "APP_EVENT_PREFERENCES", "ATTRIBUTION_PREFERENCES", "AUTO_INIT_ENABLED_PROPERTY", "AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY", "CALLBACK_OFFSET_CHANGED_AFTER_INIT", "CALLBACK_OFFSET_NEGATIVE", "CALLBACK_OFFSET_PROPERTY", "CLIENT_TOKEN_PROPERTY", "CLOUDBRIDGE_SAVED_CREDENTIALS", "CODELESS_DEBUG_LOG_ENABLED_PROPERTY", "DATA_PROCESSING_OPTIONS_PREFERENCES", "DATA_PROCESSION_OPTIONS", "DATA_PROCESSION_OPTIONS_COUNTRY", "DATA_PROCESSION_OPTIONS_STATE", "DEFAULT_CALLBACK_REQUEST_CODE_OFFSET", "", "FACEBOOK_COM", "FB_GG", "GAMING", "INSTAGRAM", "INSTAGRAM_COM", "LOCK", "Ljava/util/concurrent/locks/ReentrantLock;", "MAX_REQUEST_CODE_RANGE", "MONITOR_ENABLED_PROPERTY", "PUBLISH_ACTIVITY_PATH", "TAG", "kotlin.jvm.PlatformType", "WEB_DIALOG_THEME", "appClientToken", "applicationContext", "Landroid/content/Context;", "applicationId", "applicationName", "bypassAppSwitch", "", "cacheDir", "Lcom/facebook/internal/LockOnGetVariable;", "Ljava/io/File;", "callbackRequestCodeOffset", "codelessDebugLogEnabled", "Ljava/lang/Boolean;", "executor", "Ljava/util/concurrent/Executor;", "facebookDomain", "graphApiVersion", "graphRequestCreator", "Lcom/facebook/FacebookSdk$GraphRequestCreator;", "hasCustomTabsPrefetching", "ignoreAppSwitchToLoggedOut", "instagramDomain", "isDebugEnabledField", "isFullyInitialized", "isLegacyTokenUpgradeSupported", "loggingBehaviors", "Ljava/util/HashSet;", "Lcom/facebook/LoggingBehavior;", "Lkotlin/collections/HashSet;", "onProgressThreshold", "Ljava/util/concurrent/atomic/AtomicLong;", "sdkInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "addLoggingBehavior", "", "behavior", "clearLoggingBehaviors", "fullyInitialize", "getAdvertiserIDCollectionEnabled", "getApplicationContext", "getApplicationId", "getApplicationName", "getApplicationSignature", "context", "getAutoInitEnabled", "getAutoLogAppEventsEnabled", "getCacheDir", "getCallbackRequestCodeOffset", "getClientToken", "getCodelessDebugLogEnabled", "getCodelessSetupEnabled", "getExecutor", "getFacebookDomain", "getFacebookGamingDomain", "getGraphApiVersion", "getGraphDomain", "getInstagramDomain", "getLimitEventAndDataUsage", "getLoggingBehaviors", "", "getMonitorEnabled", "getOnProgressThreshold", "", "getSdkVersion", "isDebugEnabled", "isFacebookRequestCode", "requestCode", "isInitialized", "isLoggingBehaviorEnabled", "loadDefaultsFromMetadata", "loadDefaultsFromMetadata$facebook_core_release", "publishInstallAndWaitForResponse", "publishInstallAsync", "removeLoggingBehavior", "sdkInitialize", "callback", "Lcom/facebook/FacebookSdk$InitializeCallback;", "setAdvertiserIDCollectionEnabled", "flag", "setApplicationId", "setApplicationName", "setAutoInitEnabled", "setAutoLogAppEventsEnabled", "setCacheDir", "setClientToken", "clientToken", "setCodelessDebugLogEnabled", "setDataProcessingOptions", "options", "", "([Ljava/lang/String;)V", "country", "state", "([Ljava/lang/String;II)V", "setExecutor", "setFacebookDomain", "setGraphApiVersion", "setGraphRequestCreator", "setGraphRequestCreator$facebook_core_release", "setIsDebugEnabled", "enabled", "setLegacyTokenUpgradeSupported", "supported", "setLimitEventAndDataUsage", "limitEventUsage", "setMonitorEnabled", "setOnProgressThreshold", "threshold", "updateGraphDebugBehavior", "GraphRequestCreator", "InitializeCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FacebookSdk.kt */
public final class FacebookSdk {
    public static final FacebookSdk INSTANCE = new FacebookSdk();
    public static final ReentrantLock LOCK = new ReentrantLock();
    public static volatile String appClientToken;
    public static Context applicationContext;
    public static volatile String applicationId;
    public static volatile String applicationName;
    public static boolean bypassAppSwitch;
    public static LockOnGetVariable<File> cacheDir;
    public static int callbackRequestCodeOffset = 64206;
    public static volatile Boolean codelessDebugLogEnabled;
    public static Executor executor;
    public static volatile String facebookDomain = "facebook.com";
    public static String graphApiVersion = "v16.0";
    public static GraphRequestCreator graphRequestCreator = $$Lambda$2ro22SgLIEGEQvscKl0ZvNzqZbA.INSTANCE;
    public static boolean hasCustomTabsPrefetching;
    public static boolean ignoreAppSwitchToLoggedOut;
    public static volatile String instagramDomain = "instagram.com";
    public static volatile boolean isDebugEnabledField;
    public static boolean isFullyInitialized;
    public static final HashSet<LoggingBehavior> loggingBehaviors = TweetUtils.hashSetOf(LoggingBehavior.DEVELOPER_ERRORS);
    public static AtomicLong onProgressThreshold = new AtomicLong(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
    public static final AtomicBoolean sdkInitialized = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bá\u0001\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/facebook/FacebookSdk$GraphRequestCreator;", "", "createPostRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "publishUrl", "", "publishParams", "Lorg/json/JSONObject;", "callback", "Lcom/facebook/GraphRequest$Callback;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FacebookSdk.kt */
    public interface GraphRequestCreator {
        GraphRequest createPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, Callback callback);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/FacebookSdk$InitializeCallback;", "", "onInitialized", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FacebookSdk.kt */
    public interface InitializeCallback {
        void onInitialized();
    }

    public static final void addLoggingBehavior(LoggingBehavior loggingBehavior) {
        Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
        synchronized (loggingBehaviors) {
            loggingBehaviors.add(loggingBehavior);
            if (loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO) && !loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
                loggingBehaviors.add(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
            }
        }
    }

    public static final Context getApplicationContext() {
        Validate.sdkInitialized();
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        throw null;
    }

    public static final String getApplicationId() {
        Validate.sdkInitialized();
        String str = applicationId;
        if (str != null) {
            return str;
        }
        throw new FacebookException((String) "A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
    }

    public static final boolean getAutoLogAppEventsEnabled() {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        return UserSettingsManager.getAutoLogAppEventsEnabled();
    }

    public static final String getClientToken() {
        Validate.sdkInitialized();
        String str = appClientToken;
        if (str != null) {
            return str;
        }
        throw new FacebookException((String) "A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
    }

    /* JADX INFO: finally extract failed */
    public static final Executor getExecutor() {
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            reentrantLock.unlock();
            Executor executor2 = executor;
            if (executor2 != null) {
                return executor2;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static final String getGraphApiVersion() {
        Intrinsics.checkNotNullExpressionValue(String.format("getGraphApiVersion: %s", Arrays.copyOf(new Object[]{graphApiVersion}, 1)), "java.lang.String.format(format, *args)");
        return graphApiVersion;
    }

    public static final String getGraphDomain() {
        Companion companion = AccessToken.Companion;
        AccessToken currentAccessToken = Companion.getCurrentAccessToken();
        String str = currentAccessToken != null ? currentAccessToken.graphDomain : null;
        String str2 = facebookDomain;
        if (str == null) {
            return str2;
        }
        if (Intrinsics.areEqual(str, "gaming")) {
            return CharsKt__CharKt.replace$default(str2, (String) "facebook.com", (String) "fb.gg", false, 4);
        }
        return Intrinsics.areEqual(str, "instagram") ? CharsKt__CharKt.replace$default(str2, (String) "facebook.com", (String) "instagram.com", false, 4) : str2;
    }

    public static final boolean getLimitEventAndDataUsage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Validate.sdkInitialized();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    /* renamed from: graphRequestCreator$lambda-0  reason: not valid java name */
    public static final GraphRequest m122graphRequestCreator$lambda0(AccessToken accessToken, String str, JSONObject jSONObject, Callback callback) {
        return GraphRequest.Companion.newPostRequest(accessToken, str, jSONObject, callback);
    }

    public static final boolean isFacebookRequestCode(int i) {
        int i2 = callbackRequestCodeOffset;
        return i >= i2 && i < i2 + 100;
    }

    public static final synchronized boolean isFullyInitialized() {
        boolean z;
        synchronized (FacebookSdk.class) {
            z = isFullyInitialized;
        }
        return z;
    }

    public static final boolean isInitialized() {
        return sdkInitialized.get();
    }

    public static final boolean isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        boolean z;
        Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
        synchronized (loggingBehaviors) {
            try {
                z = isDebugEnabledField && loggingBehaviors.contains(loggingBehavior);
            }
        }
        return z;
    }

    public static final void loadDefaultsFromMetadata$facebook_core_release(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "try {\n          context.packageManager.getApplicationInfo(\n              context.packageName, PackageManager.GET_META_DATA)\n        } catch (e: PackageManager.NameNotFoundException) {\n          return\n        }");
            if (applicationInfo.metaData != null) {
                if (applicationId == null) {
                    Object obj = applicationInfo.metaData.get("com.facebook.sdk.ApplicationId");
                    if (obj instanceof String) {
                        String str = (String) obj;
                        Locale locale = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                        String lowerCase = str.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        if (CharsKt__CharKt.startsWith$default(lowerCase, (String) "fb", false, 2)) {
                            String substring = str.substring(2);
                            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                            applicationId = substring;
                        } else {
                            applicationId = str;
                        }
                    } else if (obj instanceof Number) {
                        throw new FacebookException((String) "App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                    }
                }
                if (applicationName == null) {
                    applicationName = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationName");
                }
                if (appClientToken == null) {
                    appClientToken = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
                }
                if (callbackRequestCodeOffset == 64206) {
                    callbackRequestCodeOffset = applicationInfo.metaData.getInt("com.facebook.sdk.CallbackOffset", 64206);
                }
                if (codelessDebugLogEnabled == null) {
                    codelessDebugLogEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean("com.facebook.sdk.CodelessDebugLogEnabled", false));
                }
            }
        } catch (NameNotFoundException unused) {
        }
    }

    /* renamed from: publishInstallAsync$lambda-15  reason: not valid java name */
    public static final void m123publishInstallAsync$lambda15(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, "$applicationId");
        FacebookSdk facebookSdk = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(context, "applicationContext");
        if (!CrashShieldHandler.isObjectCrashing(facebookSdk)) {
            try {
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(context);
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
                String stringPlus = Intrinsics.stringPlus(str, "ping");
                long j = sharedPreferences.getLong(stringPlus, 0);
                AppEventsLoggerUtility appEventsLoggerUtility = AppEventsLoggerUtility.INSTANCE;
                JSONObject jSONObjectForGraphAPICall = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.Companion.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context);
                String format = String.format("%s/activities", Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                GraphRequest createPostRequest = graphRequestCreator.createPostRequest(null, format, jSONObjectForGraphAPICall, null);
                if (j == 0 && createPostRequest.executeAndWait().error == null) {
                    Editor edit = sharedPreferences.edit();
                    edit.putLong(stringPlus, System.currentTimeMillis());
                    edit.apply();
                }
            } catch (JSONException e2) {
                throw new FacebookException("An error occurred while publishing install.", e2);
            } catch (Exception e3) {
                try {
                    Utility.logd("Facebook-publish", e3);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, facebookSdk);
                }
            }
        }
    }

    public static final synchronized void sdkInitialize(Context context) {
        synchronized (FacebookSdk.class) {
            Intrinsics.checkNotNullParameter(context, "applicationContext");
            sdkInitialize(context, null);
        }
    }

    /* renamed from: sdkInitialize$lambda-3  reason: not valid java name */
    public static final File m124sdkInitialize$lambda3() {
        Context context = applicationContext;
        if (context != null) {
            return context.getCacheDir();
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        throw null;
    }

    /* renamed from: sdkInitialize$lambda-4  reason: not valid java name */
    public static final void m125sdkInitialize$lambda4(boolean z) {
        if (z && getAutoLogAppEventsEnabled()) {
            FeatureManager featureManager = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(Feature.CrashReport, $$Lambda$W14zN8pSqs882CZOyfFpXGD91k.INSTANCE);
            FeatureManager featureManager2 = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(Feature.ErrorReport, $$Lambda$O45CUUZLqADBRGg36POLE65ON_4.INSTANCE);
            FeatureManager featureManager3 = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(Feature.AnrReport, $$Lambda$afbQg6_R8R87G093r1zWqUFMaOY.INSTANCE);
        }
    }

    /* renamed from: sdkInitialize$lambda-5  reason: not valid java name */
    public static final void m126sdkInitialize$lambda5(boolean z) {
        if (z) {
            Class<AppEventsManager> cls = AppEventsManager.class;
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                    AppEventsManager$start$1 appEventsManager$start$1 = new AppEventsManager$start$1();
                    Intrinsics.checkNotNullParameter(appEventsManager$start$1, "callback");
                    FetchedAppSettingsManager.fetchedAppSettingsCallbacks.add(appEventsManager$start$1);
                    FetchedAppSettingsManager.loadAppSettingsAsync();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    /* renamed from: sdkInitialize$lambda-6  reason: not valid java name */
    public static final void m127sdkInitialize$lambda6(boolean z) {
        if (z) {
            hasCustomTabsPrefetching = true;
        }
    }

    /* renamed from: sdkInitialize$lambda-7  reason: not valid java name */
    public static final void m128sdkInitialize$lambda7(boolean z) {
        if (z) {
            ignoreAppSwitchToLoggedOut = true;
        }
    }

    /* renamed from: sdkInitialize$lambda-8  reason: not valid java name */
    public static final void m129sdkInitialize$lambda8(boolean z) {
        if (z) {
            bypassAppSwitch = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040 A[SYNTHETIC, Splitter:B:13:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a1 A[SYNTHETIC, Splitter:B:33:0x00a1] */
    /* renamed from: sdkInitialize$lambda-9  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Void m130sdkInitialize$lambda9(com.facebook.FacebookSdk.InitializeCallback r7) {
        /*
            com.facebook.AccessTokenManager$Companion r0 = com.facebook.AccessTokenManager.Companion
            com.facebook.AccessTokenManager r0 = r0.getInstance()
            com.facebook.AccessTokenCache r1 = r0.accessTokenCache
            android.content.SharedPreferences r2 = r1.sharedPreferences
            java.lang.String r3 = "com.facebook.AccessTokenManager.CachedAccessToken"
            boolean r2 = r2.contains(r3)
            r4 = 0
            if (r2 == 0) goto L_0x0027
            android.content.SharedPreferences r1 = r1.sharedPreferences
            java.lang.String r1 = r1.getString(r3, r4)
            if (r1 == 0) goto L_0x0027
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0027 }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x0027 }
            com.facebook.AccessToken$Companion r1 = com.facebook.AccessToken.Companion     // Catch:{ JSONException -> 0x0027 }
            com.facebook.AccessToken r1 = com.facebook.AccessToken.Companion.createFromJSONObject$facebook_core_release(r2)     // Catch:{ JSONException -> 0x0027 }
            goto L_0x0028
        L_0x0027:
            r1 = r4
        L_0x0028:
            r2 = 0
            if (r1 == 0) goto L_0x002e
            r0.setCurrentAccessToken(r1, r2)
        L_0x002e:
            com.facebook.ProfileManager$Companion r0 = com.facebook.ProfileManager.Companion
            com.facebook.ProfileManager r0 = r0.getInstance()
            com.facebook.ProfileCache r1 = r0.profileCache
            android.content.SharedPreferences r1 = r1.sharedPreferences
            java.lang.String r3 = "com.facebook.ProfileManager.CachedProfile"
            java.lang.String r1 = r1.getString(r3, r4)
            if (r1 == 0) goto L_0x004b
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x004b }
            r3.<init>(r1)     // Catch:{ JSONException -> 0x004b }
            com.facebook.Profile r1 = new com.facebook.Profile     // Catch:{ JSONException -> 0x004b }
            r1.<init>(r3)     // Catch:{ JSONException -> 0x004b }
            goto L_0x004c
        L_0x004b:
            r1 = r4
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r0.setCurrentProfile(r1, r2)
        L_0x0051:
            com.facebook.AccessToken$Companion r0 = com.facebook.AccessToken.Companion
            boolean r0 = com.facebook.AccessToken.Companion.isCurrentAccessTokenActive()
            if (r0 == 0) goto L_0x0066
            com.facebook.Profile r0 = com.facebook.Profile.Companion
            com.facebook.Profile r0 = com.facebook.Profile.getCurrentProfile()
            if (r0 != 0) goto L_0x0066
            com.facebook.Profile r0 = com.facebook.Profile.Companion
            com.facebook.Profile.fetchProfileForCurrentAccessToken()
        L_0x0066:
            if (r7 != 0) goto L_0x0069
            goto L_0x006c
        L_0x0069:
            r7.onInitialized()
        L_0x006c:
            android.content.Context r7 = getApplicationContext()
            java.lang.String r0 = applicationId
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            com.facebook.appevents.AppEventsLoggerImpl$Companion r3 = com.facebook.appevents.AppEventsLoggerImpl.Companion
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            boolean r3 = getAutoLogAppEventsEnabled()
            if (r3 != 0) goto L_0x0083
            goto L_0x0096
        L_0x0083:
            com.facebook.appevents.AppEventsLoggerImpl r3 = new com.facebook.appevents.AppEventsLoggerImpl
            r3.<init>(r7, r0, r4)
            java.util.concurrent.ScheduledThreadPoolExecutor r0 = com.facebook.appevents.AppEventsLoggerImpl.access$getBackgroundExecutor$cp()
            if (r0 == 0) goto L_0x010d
            com.facebook.appevents.-$$Lambda$OtEKWNTpemGLv8KvV1MrIn0dNIU r5 = new com.facebook.appevents.-$$Lambda$OtEKWNTpemGLv8KvV1MrIn0dNIU
            r5.<init>(r7, r3)
            r0.execute(r5)
        L_0x0096:
            com.facebook.UserSettingsManager r7 = com.facebook.UserSettingsManager.INSTANCE
            java.lang.Class<com.facebook.UserSettingsManager> r7 = com.facebook.UserSettingsManager.class
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r7)
            if (r0 == 0) goto L_0x00a1
            goto L_0x00f2
        L_0x00a1:
            android.content.Context r0 = getApplicationContext()     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            android.content.pm.PackageManager r3 = r0.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            java.lang.String r5 = r0.getPackageName()     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            r6 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo(r5, r6)     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            java.lang.String r5 = "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            android.os.Bundle r5 = r3.metaData     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            if (r5 == 0) goto L_0x00f2
            android.os.Bundle r3 = r3.metaData     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            java.lang.String r5 = "com.facebook.sdk.AutoAppLinkEnabled"
            boolean r2 = r3.getBoolean(r5, r2)     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            if (r2 == 0) goto L_0x00f2
            com.facebook.appevents.AppEventsLoggerImpl r2 = new com.facebook.appevents.AppEventsLoggerImpl     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            r2.<init>(r0, r4, r4)     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            java.lang.String r0 = "loggerImpl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            r0.<init>()     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            boolean r3 = com.facebook.internal.Utility.isAutoAppLinkSetup()     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            if (r3 != 0) goto L_0x00e2
            java.lang.String r3 = "SchemeWarning"
            java.lang.String r5 = "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest"
            r0.putString(r3, r5)     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
        L_0x00e2:
            java.lang.String r3 = "fb_auto_applink"
            boolean r5 = getAutoLogAppEventsEnabled()     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            if (r5 == 0) goto L_0x00f2
            r2.logEvent(r3, r0)     // Catch:{ NameNotFoundException -> 0x00f2, all -> 0x00ee }
            goto L_0x00f2
        L_0x00ee:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r7)
        L_0x00f2:
            android.content.Context r7 = getApplicationContext()
            android.content.Context r7 = r7.getApplicationContext()
            java.lang.String r0 = "getApplicationContext().applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            com.facebook.appevents.AppEventsLogger r0 = new com.facebook.appevents.AppEventsLogger
            r0.<init>(r7, r4, r4, r4)
            com.facebook.appevents.AppEventsLoggerImpl r7 = r0.loggerImpl
            r7.flush()
            return r4
        L_0x010d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Required value was null."
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.m130sdkInitialize$lambda9(com.facebook.FacebookSdk$InitializeCallback):java.lang.Void");
    }

    public static final void setDataProcessingOptions(String[] strArr, int i, int i2) {
        Class<FacebookSdk> cls = FacebookSdk.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            if (strArr == null) {
                try {
                    strArr = new String[0];
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data_processing_options", new JSONArray(TweetUtils.toList(strArr)));
                jSONObject.put("data_processing_options_country", i);
                jSONObject.put("data_processing_options_state", i2);
                Context context = applicationContext;
                if (context != null) {
                    context.getSharedPreferences("com.facebook.sdk.DataProcessingOptions", 0).edit().putString("data_processing_options", jSONObject.toString()).apply();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                    throw null;
                }
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[Catch:{ all -> 0x0072 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056 A[Catch:{ all -> 0x0072 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0104 A[SYNTHETIC, Splitter:B:65:0x0104] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010c A[Catch:{ all -> 0x0072 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized void sdkInitialize(android.content.Context r5, com.facebook.FacebookSdk.InitializeCallback r6) {
        /*
            java.lang.Class<com.facebook.FacebookSdk> r0 = com.facebook.FacebookSdk.class
            monitor-enter(r0)
            java.lang.String r1 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)     // Catch:{ all -> 0x011a }
            java.util.concurrent.atomic.AtomicBoolean r1 = sdkInitialized     // Catch:{ all -> 0x011a }
            boolean r1 = r1.get()     // Catch:{ all -> 0x011a }
            if (r1 == 0) goto L_0x0018
            if (r6 != 0) goto L_0x0013
            goto L_0x0016
        L_0x0013:
            r6.onInitialized()     // Catch:{ all -> 0x011a }
        L_0x0016:
            monitor-exit(r0)
            return
        L_0x0018:
            r1 = 0
            com.facebook.internal.Validate.hasFacebookActivity(r5, r1)     // Catch:{ all -> 0x011a }
            com.facebook.internal.Validate.hasInternetPermissions(r5, r1)     // Catch:{ all -> 0x011a }
            android.content.Context r2 = r5.getApplicationContext()     // Catch:{ all -> 0x011a }
            java.lang.String r3 = "applicationContext.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x011a }
            applicationContext = r2     // Catch:{ all -> 0x011a }
            com.facebook.appevents.AppEventsLogger.Companion.getAnonymousAppDeviceGUID(r5)     // Catch:{ all -> 0x011a }
            android.content.Context r5 = applicationContext     // Catch:{ all -> 0x011a }
            r2 = 0
            if (r5 == 0) goto L_0x0114
            loadDefaultsFromMetadata$facebook_core_release(r5)     // Catch:{ all -> 0x011a }
            java.lang.String r5 = applicationId     // Catch:{ all -> 0x011a }
            r3 = 1
            if (r5 == 0) goto L_0x0043
            int r5 = r5.length()     // Catch:{ all -> 0x011a }
            if (r5 != 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r5 = 0
            goto L_0x0044
        L_0x0043:
            r5 = 1
        L_0x0044:
            if (r5 != 0) goto L_0x010c
            java.lang.String r5 = appClientToken     // Catch:{ all -> 0x011a }
            if (r5 == 0) goto L_0x0053
            int r5 = r5.length()     // Catch:{ all -> 0x011a }
            if (r5 != 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r5 = 0
            goto L_0x0054
        L_0x0053:
            r5 = 1
        L_0x0054:
            if (r5 != 0) goto L_0x0104
            java.util.concurrent.atomic.AtomicBoolean r5 = sdkInitialized     // Catch:{ all -> 0x011a }
            r5.set(r3)     // Catch:{ all -> 0x011a }
            com.facebook.UserSettingsManager r5 = com.facebook.UserSettingsManager.INSTANCE     // Catch:{ all -> 0x011a }
            java.lang.Class<com.facebook.UserSettingsManager> r5 = com.facebook.UserSettingsManager.class
            boolean r4 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r5)     // Catch:{ all -> 0x011a }
            if (r4 == 0) goto L_0x0066
            goto L_0x0076
        L_0x0066:
            com.facebook.UserSettingsManager r4 = com.facebook.UserSettingsManager.INSTANCE     // Catch:{ all -> 0x0072 }
            r4.initializeIfNotInitialized()     // Catch:{ all -> 0x0072 }
            com.facebook.UserSettingsManager$UserSetting r4 = com.facebook.UserSettingsManager.autoInitEnabled     // Catch:{ all -> 0x0072 }
            boolean r1 = r4.getValue()     // Catch:{ all -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r4 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r5)     // Catch:{ all -> 0x011a }
        L_0x0076:
            if (r1 == 0) goto L_0x007a
            isFullyInitialized = r3     // Catch:{ all -> 0x011a }
        L_0x007a:
            android.content.Context r5 = applicationContext     // Catch:{ all -> 0x011a }
            if (r5 == 0) goto L_0x00fe
            boolean r5 = r5 instanceof android.app.Application     // Catch:{ all -> 0x011a }
            if (r5 == 0) goto L_0x009e
            com.facebook.UserSettingsManager r5 = com.facebook.UserSettingsManager.INSTANCE     // Catch:{ all -> 0x011a }
            boolean r5 = com.facebook.UserSettingsManager.getAutoLogAppEventsEnabled()     // Catch:{ all -> 0x011a }
            if (r5 == 0) goto L_0x009e
            com.facebook.appevents.internal.ActivityLifecycleTracker r5 = com.facebook.appevents.internal.ActivityLifecycleTracker.INSTANCE     // Catch:{ all -> 0x011a }
            android.content.Context r5 = applicationContext     // Catch:{ all -> 0x011a }
            if (r5 == 0) goto L_0x0098
            android.app.Application r5 = (android.app.Application) r5     // Catch:{ all -> 0x011a }
            java.lang.String r1 = applicationId     // Catch:{ all -> 0x011a }
            com.facebook.appevents.internal.ActivityLifecycleTracker.startTracking(r5, r1)     // Catch:{ all -> 0x011a }
            goto L_0x009e
        L_0x0098:
            java.lang.String r5 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x011a }
            throw r2
        L_0x009e:
            com.facebook.internal.FetchedAppSettingsManager r5 = com.facebook.internal.FetchedAppSettingsManager.INSTANCE     // Catch:{ all -> 0x011a }
            com.facebook.internal.FetchedAppSettingsManager.loadAppSettingsAsync()     // Catch:{ all -> 0x011a }
            com.facebook.internal.NativeProtocol r5 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch:{ all -> 0x011a }
            com.facebook.internal.NativeProtocol.updateAllAvailableProtocolVersionsAsync()     // Catch:{ all -> 0x011a }
            android.content.Context r5 = applicationContext     // Catch:{ all -> 0x011a }
            if (r5 == 0) goto L_0x00f8
            com.facebook.internal.BoltsMeasurementEventListener.getInstance(r5)     // Catch:{ all -> 0x011a }
            com.facebook.internal.LockOnGetVariable r5 = new com.facebook.internal.LockOnGetVariable     // Catch:{ all -> 0x011a }
            com.facebook.-$$Lambda$J0805Clgxed1K59G9leFVPRGzM4 r1 = com.facebook.$$Lambda$J0805Clgxed1K59G9leFVPRGzM4.INSTANCE     // Catch:{ all -> 0x011a }
            r5.<init>(r1)     // Catch:{ all -> 0x011a }
            cacheDir = r5     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager r5 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.Instrument     // Catch:{ all -> 0x011a }
            com.facebook.-$$Lambda$fGv4uIuB4ckkxwOf8O4RgtXZub4 r1 = com.facebook.$$Lambda$fGv4uIuB4ckkxwOf8O4RgtXZub4.INSTANCE     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager r5 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.AppEvents     // Catch:{ all -> 0x011a }
            com.facebook.-$$Lambda$8Xi3kKcv5EqcfpghgczttKFq8YE r1 = com.facebook.$$Lambda$8Xi3kKcv5EqcfpghgczttKFq8YE.INSTANCE     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager r5 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.ChromeCustomTabsPrefetching     // Catch:{ all -> 0x011a }
            com.facebook.-$$Lambda$PFMuGw4-GX6YxoewlCboSNJ46iw r1 = com.facebook.$$Lambda$PFMuGw4GX6YxoewlCboSNJ46iw.INSTANCE     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager r5 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.IgnoreAppSwitchToLoggedOut     // Catch:{ all -> 0x011a }
            com.facebook.-$$Lambda$xnPiGMIrZY-efkOoczDJVIjnueQ r1 = com.facebook.$$Lambda$xnPiGMIrZYefkOoczDJVIjnueQ.INSTANCE     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager r5 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.BypassAppSwitch     // Catch:{ all -> 0x011a }
            com.facebook.-$$Lambda$4yZ8An2h0IO8z381mtb9us73H-E r1 = com.facebook.$$Lambda$4yZ8An2h0IO8z381mtb9us73HE.INSTANCE     // Catch:{ all -> 0x011a }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x011a }
            java.util.concurrent.FutureTask r5 = new java.util.concurrent.FutureTask     // Catch:{ all -> 0x011a }
            com.facebook.-$$Lambda$0kbXjfnH1rWqSbnFNjnUSyk2drw r1 = new com.facebook.-$$Lambda$0kbXjfnH1rWqSbnFNjnUSyk2drw     // Catch:{ all -> 0x011a }
            r1.<init>()     // Catch:{ all -> 0x011a }
            r5.<init>(r1)     // Catch:{ all -> 0x011a }
            java.util.concurrent.Executor r6 = getExecutor()     // Catch:{ all -> 0x011a }
            r6.execute(r5)     // Catch:{ all -> 0x011a }
            monitor-exit(r0)
            return
        L_0x00f8:
            java.lang.String r5 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x011a }
            throw r2
        L_0x00fe:
            java.lang.String r5 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x011a }
            throw r2
        L_0x0104:
            com.facebook.FacebookException r5 = new com.facebook.FacebookException     // Catch:{ all -> 0x011a }
            java.lang.String r6 = "A valid Facebook app client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk."
            r5.<init>(r6)     // Catch:{ all -> 0x011a }
            throw r5     // Catch:{ all -> 0x011a }
        L_0x010c:
            com.facebook.FacebookException r5 = new com.facebook.FacebookException     // Catch:{ all -> 0x011a }
            java.lang.String r6 = "A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk."
            r5.<init>(r6)     // Catch:{ all -> 0x011a }
            throw r5     // Catch:{ all -> 0x011a }
        L_0x0114:
            java.lang.String r5 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x011a }
            throw r2
        L_0x011a:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.sdkInitialize(android.content.Context, com.facebook.FacebookSdk$InitializeCallback):void");
    }
}
