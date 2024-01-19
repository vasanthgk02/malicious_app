package io.sentry.react;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.rudderstack.android.sdk.core.RudderTraits;
import in.juspay.hypersdk.core.PaymentConstants;
import io.sentry.Breadcrumb;
import io.sentry.HubAdapter;
import io.sentry.Integration;
import io.sentry.Scope;
import io.sentry.ScopeCallback;
import io.sentry.Sentry;
import io.sentry.Sentry.OptionsConfiguration;
import io.sentry.SentryBaseEvent;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.android.core.AnrIntegration;
import io.sentry.android.core.BuildConfig;
import io.sentry.android.core.NdkIntegration;
import io.sentry.android.core.SentryAndroid;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@ReactModule(name = "RNSentry")
public class RNSentryModule extends ReactContextBaseJavaModule {
    public static final String NAME = "RNSentry";
    public static final Logger logger = Logger.getLogger("react-native-sentry");
    public static PackageInfo packageInfo;

    public RNSentryModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        packageInfo = getPackageInfo(reactApplicationContext);
    }

    public static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException unused) {
            logger.warning("Error getting package info.");
            return null;
        }
    }

    public static /* synthetic */ void lambda$addBreadcrumb$3(ReadableMap readableMap, Scope scope) {
        Breadcrumb breadcrumb = new Breadcrumb();
        if (readableMap.hasKey("message")) {
            breadcrumb.setMessage(readableMap.getString("message"));
        }
        if (readableMap.hasKey("type")) {
            breadcrumb.setType(readableMap.getString("type"));
        }
        if (readableMap.hasKey("category")) {
            breadcrumb.setCategory(readableMap.getString("category"));
        }
        if (readableMap.hasKey("level")) {
            String string = readableMap.getString("level");
            char c2 = 65535;
            switch (string.hashCode()) {
                case 3237038:
                    if (string.equals("info")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 95458899:
                    if (string.equals("debug")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 96784904:
                    if (string.equals("error")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 97203460:
                    if (string.equals(CrashlyticsController.FIREBASE_CRASH_TYPE)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1124446108:
                    if (string.equals("warning")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                breadcrumb.setLevel(SentryLevel.FATAL);
            } else if (c2 == 1) {
                breadcrumb.setLevel(SentryLevel.WARNING);
            } else if (c2 == 2) {
                breadcrumb.setLevel(SentryLevel.INFO);
            } else if (c2 == 3) {
                breadcrumb.setLevel(SentryLevel.DEBUG);
            } else if (c2 != 4) {
                breadcrumb.setLevel(SentryLevel.ERROR);
            } else {
                breadcrumb.setLevel(SentryLevel.ERROR);
            }
        }
        if (readableMap.hasKey("data")) {
            ReadableMap map = readableMap.getMap("data");
            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                breadcrumb.setData(nextKey, map.getString(nextKey));
            }
        }
        scope.addBreadcrumb(breadcrumb);
    }

    public static /* synthetic */ void lambda$setUser$2(ReadableMap readableMap, ReadableMap readableMap2, Scope scope) {
        if (readableMap == null && readableMap2 == null) {
            scope.setUser(null);
            return;
        }
        User user = new User();
        if (readableMap != null) {
            if (readableMap.hasKey("email")) {
                user.setEmail(readableMap.getString("email"));
            }
            if (readableMap.hasKey("id")) {
                user.setId(readableMap.getString("id"));
            }
            if (readableMap.hasKey(RudderTraits.USERNAME_KEY)) {
                user.setUsername(readableMap.getString(RudderTraits.USERNAME_KEY));
            }
            if (readableMap.hasKey("ip_address")) {
                user.setIpAddress(readableMap.getString("ip_address"));
            }
        }
        if (readableMap2 != null) {
            HashMap hashMap = new HashMap();
            ReadableMapKeySetIterator keySetIterator = readableMap2.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                hashMap.put(nextKey, readableMap2.getString(nextKey));
            }
            user.setOthers(hashMap);
        }
        scope.setUser(user);
    }

    public static /* synthetic */ SentryEvent lambda$startWithOptions$0(SentryEvent sentryEvent, Object obj) {
        try {
            SentryException sentryException = sentryEvent.getExceptions().get(0);
            if (sentryException != null && sentryException.getType().contains("JavascriptException")) {
                return null;
            }
        } catch (Exception unused) {
        }
        SdkVersion sdk = sentryEvent.getSdk();
        if (sdk != null) {
            String name = sdk.getName();
            if (name != null) {
                if (name.equals("sentry.javascript.react-native")) {
                    sentryEvent.setTag("event.origin", "javascript");
                } else if (name.equals(BuildConfig.SENTRY_ANDROID_SDK_NAME) || name.equals("sentry.native")) {
                    sentryEvent.setTag("event.origin", "android");
                    if (name.equals("sentry.native")) {
                        sentryEvent.setTag("event.environment", FileStore.NATIVE_SESSION_SUBDIR);
                    } else {
                        sentryEvent.setTag("event.environment", SentryBaseEvent.DEFAULT_PLATFORM);
                    }
                }
            }
        }
        return sentryEvent;
    }

    public static /* synthetic */ void lambda$startWithOptions$1(ReadableMap readableMap, SentryAndroidOptions sentryAndroidOptions) {
        if (readableMap.hasKey("debug") && readableMap.getBoolean("debug")) {
            sentryAndroidOptions.setDebug(Boolean.TRUE);
            logger.setLevel(Level.INFO);
        }
        if (!readableMap.hasKey("dsn") || readableMap.getString("dsn") == null) {
            sentryAndroidOptions.setDsn("");
        } else {
            String string = readableMap.getString("dsn");
            logger.info(String.format("Starting with DSN: '%s'", new Object[]{string}));
            sentryAndroidOptions.setDsn(string);
        }
        if (readableMap.hasKey("maxBreadcrumbs")) {
            sentryAndroidOptions.setMaxBreadcrumbs(readableMap.getInt("maxBreadcrumbs"));
        }
        if (readableMap.hasKey(PaymentConstants.ENV) && readableMap.getString(PaymentConstants.ENV) != null) {
            sentryAndroidOptions.setEnvironment(readableMap.getString(PaymentConstants.ENV));
        }
        if (readableMap.hasKey("release") && readableMap.getString("release") != null) {
            sentryAndroidOptions.setRelease(readableMap.getString("release"));
        }
        if (readableMap.hasKey("dist") && readableMap.getString("dist") != null) {
            sentryAndroidOptions.setDist(readableMap.getString("dist"));
        }
        if (readableMap.hasKey("enableAutoSessionTracking")) {
            sentryAndroidOptions.setEnableAutoSessionTracking(readableMap.getBoolean("enableAutoSessionTracking"));
        }
        if (readableMap.hasKey("sessionTrackingIntervalMillis")) {
            sentryAndroidOptions.setSessionTrackingIntervalMillis((long) readableMap.getInt("sessionTrackingIntervalMillis"));
        }
        if (readableMap.hasKey("enableNdkScopeSync")) {
            sentryAndroidOptions.setEnableScopeSync(readableMap.getBoolean("enableNdkScopeSync"));
        }
        if (readableMap.hasKey("attachStacktrace")) {
            sentryAndroidOptions.setAttachStacktrace(readableMap.getBoolean("attachStacktrace"));
        }
        if (readableMap.hasKey("attachThreads")) {
            sentryAndroidOptions.setAttachThreads(readableMap.getBoolean("attachThreads"));
        }
        if (readableMap.hasKey("sendDefaultPii")) {
            sentryAndroidOptions.setSendDefaultPii(readableMap.getBoolean("sendDefaultPii"));
        }
        sentryAndroidOptions.setBeforeSend($$Lambda$RNSentryModule$OTy9FoDkHvQz92otKAoPExm7VY.INSTANCE);
        if (readableMap.hasKey("enableNativeCrashHandling") && !readableMap.getBoolean("enableNativeCrashHandling")) {
            List<Integration> integrations = sentryAndroidOptions.getIntegrations();
            for (Integration next : integrations) {
                if ((next instanceof UncaughtExceptionHandlerIntegration) || (next instanceof AnrIntegration) || (next instanceof NdkIntegration)) {
                    integrations.remove(next);
                }
            }
        }
        logger.info(String.format("Native Integrations '%s'", new Object[]{sentryAndroidOptions.getIntegrations().toString()}));
    }

    @ReactMethod
    public void addBreadcrumb(ReadableMap readableMap) {
        Sentry.configureScope(new ScopeCallback() {
            public final void run(Scope scope) {
                RNSentryModule.lambda$addBreadcrumb$3(ReadableMap.this, scope);
            }
        });
    }

    @ReactMethod
    public void captureEnvelope(String str, Promise promise) {
        FileOutputStream fileOutputStream;
        try {
            String outboxPath = HubAdapter.getInstance().getOptions().getOutboxPath();
            if (outboxPath == null) {
                logger.severe("Error retrieving outboxPath. Envelope will not be sent. Is the Android SDK initialized?");
            } else {
                fileOutputStream = new FileOutputStream(new File(outboxPath, UUID.randomUUID().toString()));
                fileOutputStream.write(str.getBytes(Charset.forName("UTF-8")));
                fileOutputStream.close();
            }
        } catch (Exception unused) {
            logger.severe("Error reading envelope");
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        promise.resolve(Boolean.TRUE);
        return;
        throw th;
    }

    @ReactMethod
    public void clearBreadcrumbs() {
        Sentry.configureScope($$Lambda$RNSentryModule$UXBbDDjVrpP0efteWIs6CIxXek.INSTANCE);
    }

    @ReactMethod
    public void closeNativeSdk(Promise promise) {
        Sentry.close();
        promise.resolve(Boolean.TRUE);
    }

    @ReactMethod
    public void crash() {
        throw new RuntimeException("TEST - Sentry Client Crash (only works in release mode)");
    }

    @ReactMethod
    public void fetchRelease(Promise promise) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("id", packageInfo.packageName);
        createMap.putString("version", packageInfo.versionName);
        createMap.putString("build", String.valueOf(packageInfo.versionCode));
        promise.resolve(createMap);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("nativeClientAvailable", Boolean.TRUE);
        hashMap.put("nativeTransport", Boolean.TRUE);
        return hashMap;
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void getStringBytesLength(String str, Promise promise) {
        try {
            promise.resolve(Integer.valueOf(str.getBytes("UTF-8").length));
        } catch (UnsupportedEncodingException e2) {
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void setExtra(String str, String str2) {
        Sentry.configureScope(new ScopeCallback(str, str2) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run(Scope scope) {
                scope.setExtra(this.f$0, this.f$1);
            }
        });
    }

    @ReactMethod
    public void setTag(String str, String str2) {
        Sentry.configureScope(new ScopeCallback(str, str2) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run(Scope scope) {
                scope.setTag(this.f$0, this.f$1);
            }
        });
    }

    @ReactMethod
    public void setUser(ReadableMap readableMap, ReadableMap readableMap2) {
        Sentry.configureScope(new ScopeCallback(readableMap2) {
            public final /* synthetic */ ReadableMap f$1;

            {
                this.f$1 = r2;
            }

            public final void run(Scope scope) {
                RNSentryModule.lambda$setUser$2(ReadableMap.this, this.f$1, scope);
            }
        });
    }

    @ReactMethod
    public void startWithOptions(ReadableMap readableMap, Promise promise) {
        SentryAndroid.init((Context) getReactApplicationContext(), (OptionsConfiguration<SentryAndroidOptions>) new OptionsConfiguration() {
            public final void configure(SentryOptions sentryOptions) {
                RNSentryModule.lambda$startWithOptions$1(ReadableMap.this, (SentryAndroidOptions) sentryOptions);
            }
        });
        promise.resolve(Boolean.TRUE);
    }
}
