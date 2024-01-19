package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.AttributionIdentifiers.Companion;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0010\bÁ\u0002\u0018\u00002\u00020\u0001:\u00018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010 \u001a\u00020\u001fH\u0007J\b\u0010!\u001a\u00020\u001fH\u0007J\b\u0010\"\u001a\u00020\u001fH\u0007J\b\u0010#\u001a\u00020\u001fH\u0007J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J!\u0010'\u001a\u00020%2\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140)\"\u00020\u0014H\u0002¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u0014H\u0002J\b\u0010-\u001a\u00020%H\u0007J\b\u0010.\u001a\u00020%H\u0002J\b\u0010/\u001a\u00020%H\u0002J\u0010\u00100\u001a\u00020%2\u0006\u0010,\u001a\u00020\u0014H\u0002J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u001fH\u0007J\u0010\u00103\u001a\u00020%2\u0006\u00102\u001a\u00020\u001fH\u0007J\u0010\u00104\u001a\u00020%2\u0006\u00102\u001a\u00020\u001fH\u0007J\u0010\u00105\u001a\u00020%2\u0006\u00102\u001a\u00020\u001fH\u0007J\b\u00106\u001a\u00020%H\u0002J\u0010\u00107\u001a\u00020%2\u0006\u0010,\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/UserSettingsManager;", "", "()V", "ADVERTISERID_COLLECTION_FALSE_WARNING", "", "ADVERTISERID_COLLECTION_NOT_SET_WARNING", "ADVERTISER_ID_KEY", "APPLICATION_FIELDS", "AUTOLOG_APPEVENT_NOT_SET_WARNING", "AUTO_APP_LINK_WARNING", "EVENTS_CODELESS_SETUP_ENABLED", "LAST_TIMESTAMP", "TAG", "kotlin.jvm.PlatformType", "TIMEOUT_7D", "", "USER_SETTINGS", "USER_SETTINGS_BITMASK", "VALUE", "advertiserIDCollectionEnabled", "Lcom/facebook/UserSettingsManager$UserSetting;", "autoInitEnabled", "autoLogAppEventsEnabled", "codelessSetupEnabled", "isFetchingCodelessStatus", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitialized", "monitorEnabled", "userSettingPref", "Landroid/content/SharedPreferences;", "getAdvertiserIDCollectionEnabled", "", "getAutoInitEnabled", "getAutoLogAppEventsEnabled", "getCodelessSetupEnabled", "getMonitorEnabled", "initializeCodelessSetupEnabledAsync", "", "initializeIfNotInitialized", "initializeUserSetting", "userSettings", "", "([Lcom/facebook/UserSettingsManager$UserSetting;)V", "loadSettingFromManifest", "userSetting", "logIfAutoAppLinkEnabled", "logIfSDKSettingsChanged", "logWarnings", "readSettingFromCache", "setAdvertiserIDCollectionEnabled", "flag", "setAutoInitEnabled", "setAutoLogAppEventsEnabled", "setMonitorEnabled", "validateInitialized", "writeSettingToCache", "UserSetting", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: UserSettingsManager.kt */
public final class UserSettingsManager {
    public static final UserSettingsManager INSTANCE = new UserSettingsManager();
    public static final UserSetting advertiserIDCollectionEnabled = new UserSetting(true, "com.facebook.sdk.AdvertiserIDCollectionEnabled");
    public static final UserSetting autoInitEnabled = new UserSetting(true, "com.facebook.sdk.AutoInitEnabled");
    public static final UserSetting autoLogAppEventsEnabled = new UserSetting(true, "com.facebook.sdk.AutoLogAppEventsEnabled");
    public static final UserSetting codelessSetupEnabled = new UserSetting(false, "auto_event_setup_enabled");
    public static final AtomicBoolean isFetchingCodelessStatus = new AtomicBoolean(false);
    public static final AtomicBoolean isInitialized = new AtomicBoolean(false);
    public static final UserSetting monitorEnabled = new UserSetting(true, "com.facebook.sdk.MonitorEnabled");
    public static SharedPreferences userSettingPref;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/facebook/UserSettingsManager$UserSetting;", "", "defaultVal", "", "key", "", "(ZLjava/lang/String;)V", "getDefaultVal", "()Z", "setDefaultVal", "(Z)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "lastTS", "", "getLastTS", "()J", "setLastTS", "(J)V", "value", "getValue", "()Ljava/lang/Boolean;", "setValue", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: UserSettingsManager.kt */
    public static final class UserSetting {
        public boolean defaultVal;
        public String key;
        public long lastTS;
        public Boolean value;

        public UserSetting(boolean z, String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.defaultVal = z;
            this.key = str;
        }

        public final boolean getValue() {
            Boolean bool = this.value;
            return bool == null ? this.defaultVal : bool.booleanValue();
        }
    }

    public static final boolean getAdvertiserIDCollectionEnabled() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return advertiserIDCollectionEnabled.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static final boolean getAutoLogAppEventsEnabled() {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return autoLogAppEventsEnabled.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    /* renamed from: initializeCodelessSetupEnabledAsync$lambda-0  reason: not valid java name */
    public static final void m136initializeCodelessSetupEnabledAsync$lambda0(long j) {
        Class<UserSettingsManager> cls = UserSettingsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (advertiserIDCollectionEnabled.getValue()) {
                    FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                    if (queryAppSettings != null && queryAppSettings.codelessEventsEnabled) {
                        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                        AttributionIdentifiers attributionIdentifiers = Companion.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                        String androidAdvertiserId = (attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) ? null : attributionIdentifiers.getAndroidAdvertiserId();
                        if (androidAdvertiserId != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("advertiser_id", androidAdvertiserId);
                            bundle.putString("fields", "auto_event_setup_enabled");
                            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(null, "app", null);
                            newGraphPathRequest.setParameters(bundle);
                            JSONObject jSONObject = newGraphPathRequest.executeAndWait().graphObject;
                            if (jSONObject != null) {
                                codelessSetupEnabled.value = Boolean.valueOf(jSONObject.optBoolean("auto_event_setup_enabled", false));
                                codelessSetupEnabled.lastTS = j;
                                INSTANCE.writeSettingToCache(codelessSetupEnabled);
                            }
                        }
                    }
                }
                isFetchingCodelessStatus.set(false);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void initializeCodelessSetupEnabledAsync() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                readSettingFromCache(codelessSetupEnabled);
                long currentTimeMillis = System.currentTimeMillis();
                if (codelessSetupEnabled.value == null || currentTimeMillis - codelessSetupEnabled.lastTS >= 604800000) {
                    codelessSetupEnabled.value = null;
                    codelessSetupEnabled.lastTS = 0;
                    if (isFetchingCodelessStatus.compareAndSet(false, true)) {
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        FacebookSdk.getExecutor().execute(new Runnable(currentTimeMillis) {
                            public final /* synthetic */ long f$0;

                            {
                                this.f$0 = r1;
                            }

                            public final void run() {
                                UserSettingsManager.m136initializeCodelessSetupEnabledAsync$lambda0(this.f$0);
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void initializeIfNotInitialized() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FacebookSdk.isInitialized()) {
                    int i = 0;
                    if (isInitialized.compareAndSet(false, true)) {
                        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.USER_SETTINGS", 0);
                        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "FacebookSdk.getApplicationContext()\n            .getSharedPreferences(USER_SETTINGS, Context.MODE_PRIVATE)");
                        userSettingPref = sharedPreferences;
                        UserSetting[] userSettingArr = {autoLogAppEventsEnabled, advertiserIDCollectionEnabled, autoInitEnabled};
                        if (!CrashShieldHandler.isObjectCrashing(this)) {
                            while (i < 3) {
                                UserSetting userSetting = userSettingArr[i];
                                i++;
                                if (userSetting == codelessSetupEnabled) {
                                    initializeCodelessSetupEnabledAsync();
                                } else if (userSetting.value == null) {
                                    readSettingFromCache(userSetting);
                                    if (userSetting.value == null) {
                                        loadSettingFromManifest(userSetting);
                                    }
                                } else {
                                    writeSettingToCache(userSetting);
                                }
                            }
                        }
                        initializeCodelessSetupEnabledAsync();
                        logWarnings();
                        logIfSDKSettingsChanged();
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void loadSettingFromManifest(UserSetting userSetting) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                validateInitialized();
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
                if (applicationInfo.metaData != null && applicationInfo.metaData.containsKey(userSetting.key)) {
                    userSetting.value = Boolean.valueOf(applicationInfo.metaData.getBoolean(userSetting.key, userSetting.defaultVal));
                }
            } catch (NameNotFoundException e2) {
                Utility.logd("com.facebook.UserSettingsManager", e2);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:34|35|36|(3:38|39|(8:40|41|42|(1:44)(1:45)|46|47|(1:49)(0)|52))|50|52|53|(1:55)(1:56)|(1:58)|60) */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0108, code lost:
        if (com.facebook.FacebookSdk.getAutoLogAppEventsEnabled() != false) goto L_0x010a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x00cf */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00fd A[Catch:{ all -> 0x0119 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ff A[Catch:{ all -> 0x0119 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0102 A[Catch:{ all -> 0x0119 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void logIfSDKSettingsChanged() {
        /*
            r16 = this;
            java.lang.String r0 = "previous"
            java.lang.String r1 = "com.facebook.sdk.USER_SETTINGS_BITMASK"
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r16)
            if (r2 == 0) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicBoolean r2 = isInitialized     // Catch:{ all -> 0x0119 }
            boolean r2 = r2.get()     // Catch:{ all -> 0x0119 }
            if (r2 != 0) goto L_0x0014
            return
        L_0x0014:
            com.facebook.FacebookSdk r2 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0119 }
            boolean r2 = com.facebook.FacebookSdk.isInitialized()     // Catch:{ all -> 0x0119 }
            if (r2 != 0) goto L_0x001d
            return
        L_0x001d:
            com.facebook.FacebookSdk r2 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0119 }
            android.content.Context r2 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0119 }
            com.facebook.UserSettingsManager$UserSetting r3 = autoInitEnabled     // Catch:{ all -> 0x0119 }
            boolean r3 = r3.getValue()     // Catch:{ all -> 0x0119 }
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x002f
            r3 = 1
            goto L_0x0030
        L_0x002f:
            r3 = 0
        L_0x0030:
            int r3 = r3 << r5
            r3 = r3 | r5
            com.facebook.UserSettingsManager$UserSetting r6 = autoLogAppEventsEnabled     // Catch:{ all -> 0x0119 }
            boolean r6 = r6.getValue()     // Catch:{ all -> 0x0119 }
            if (r6 == 0) goto L_0x003c
            r6 = 1
            goto L_0x003d
        L_0x003c:
            r6 = 0
        L_0x003d:
            int r6 = r6 << r4
            r3 = r3 | r6
            com.facebook.UserSettingsManager$UserSetting r6 = advertiserIDCollectionEnabled     // Catch:{ all -> 0x0119 }
            boolean r6 = r6.getValue()     // Catch:{ all -> 0x0119 }
            if (r6 == 0) goto L_0x0049
            r6 = 1
            goto L_0x004a
        L_0x0049:
            r6 = 0
        L_0x004a:
            r7 = 2
            int r6 = r6 << r7
            r3 = r3 | r6
            com.facebook.UserSettingsManager$UserSetting r6 = monitorEnabled     // Catch:{ all -> 0x0119 }
            boolean r6 = r6.getValue()     // Catch:{ all -> 0x0119 }
            if (r6 == 0) goto L_0x0057
            r6 = 1
            goto L_0x0058
        L_0x0057:
            r6 = 0
        L_0x0058:
            r8 = 3
            int r6 = r6 << r8
            r3 = r3 | r6
            android.content.SharedPreferences r6 = userSettingPref     // Catch:{ all -> 0x0119 }
            java.lang.String r9 = "userSettingPref"
            r10 = 0
            if (r6 == 0) goto L_0x0115
            int r6 = r6.getInt(r1, r5)     // Catch:{ all -> 0x0119 }
            if (r6 == r3) goto L_0x0114
            android.content.SharedPreferences r11 = userSettingPref     // Catch:{ all -> 0x0119 }
            if (r11 == 0) goto L_0x0110
            android.content.SharedPreferences$Editor r9 = r11.edit()     // Catch:{ all -> 0x0119 }
            android.content.SharedPreferences$Editor r1 = r9.putInt(r1, r3)     // Catch:{ all -> 0x0119 }
            r1.apply()     // Catch:{ all -> 0x0119 }
            android.content.pm.PackageManager r1 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00cd }
            java.lang.String r9 = r2.getPackageName()     // Catch:{ NameNotFoundException -> 0x00cd }
            r11 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo(r9, r11)     // Catch:{ NameNotFoundException -> 0x00cd }
            java.lang.String r9 = "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r9)     // Catch:{ NameNotFoundException -> 0x00cd }
            android.os.Bundle r9 = r1.metaData     // Catch:{ NameNotFoundException -> 0x00cd }
            if (r9 == 0) goto L_0x00cd
            java.lang.String r9 = "com.facebook.sdk.AutoInitEnabled"
            java.lang.String r11 = "com.facebook.sdk.AutoLogAppEventsEnabled"
            java.lang.String r12 = "com.facebook.sdk.AdvertiserIDCollectionEnabled"
            java.lang.String r13 = "com.facebook.sdk.MonitorEnabled"
            java.lang.String[] r9 = new java.lang.String[]{r9, r11, r12, r13}     // Catch:{ NameNotFoundException -> 0x00cd }
            r11 = 4
            boolean[] r11 = new boolean[r11]     // Catch:{ NameNotFoundException -> 0x00cd }
            r11[r5] = r4     // Catch:{ NameNotFoundException -> 0x00cd }
            r11[r4] = r4     // Catch:{ NameNotFoundException -> 0x00cd }
            r11[r7] = r4     // Catch:{ NameNotFoundException -> 0x00cd }
            r11[r8] = r4     // Catch:{ NameNotFoundException -> 0x00cd }
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x00a8:
            int r15 = r12 + 1
            android.os.Bundle r4 = r1.metaData     // Catch:{ NameNotFoundException -> 0x00cf }
            r5 = r9[r12]     // Catch:{ NameNotFoundException -> 0x00cf }
            boolean r4 = r4.containsKey(r5)     // Catch:{ NameNotFoundException -> 0x00cf }
            if (r4 == 0) goto L_0x00b6
            r4 = 1
            goto L_0x00b7
        L_0x00b6:
            r4 = 0
        L_0x00b7:
            int r4 = r4 << r12
            r13 = r13 | r4
            android.os.Bundle r4 = r1.metaData     // Catch:{ NameNotFoundException -> 0x00cf }
            r5 = r9[r12]     // Catch:{ NameNotFoundException -> 0x00cf }
            boolean r7 = r11[r12]     // Catch:{ NameNotFoundException -> 0x00cf }
            boolean r4 = r4.getBoolean(r5, r7)     // Catch:{ NameNotFoundException -> 0x00cf }
            int r4 = r4 << r12
            r14 = r14 | r4
            if (r15 <= r8) goto L_0x00c8
            goto L_0x00cf
        L_0x00c8:
            r12 = r15
            r4 = 1
            r5 = 0
            r7 = 2
            goto L_0x00a8
        L_0x00cd:
            r13 = 0
            r14 = 0
        L_0x00cf:
            com.facebook.appevents.AppEventsLoggerImpl r1 = new com.facebook.appevents.AppEventsLoggerImpl     // Catch:{ all -> 0x0119 }
            r1.<init>(r2, r10, r10)     // Catch:{ all -> 0x0119 }
            java.lang.String r2 = "loggerImpl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)     // Catch:{ all -> 0x0119 }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ all -> 0x0119 }
            r2.<init>()     // Catch:{ all -> 0x0119 }
            java.lang.String r4 = "usage"
            r2.putInt(r4, r13)     // Catch:{ all -> 0x0119 }
            java.lang.String r4 = "initial"
            r2.putInt(r4, r14)     // Catch:{ all -> 0x0119 }
            r2.putInt(r0, r6)     // Catch:{ all -> 0x0119 }
            java.lang.String r4 = "current"
            r2.putInt(r4, r3)     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = "parameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)     // Catch:{ all -> 0x0119 }
            int r0 = r2.getInt(r0)     // Catch:{ all -> 0x0119 }
            r3 = 2
            r0 = r0 & r3
            if (r0 == 0) goto L_0x00ff
            r4 = 1
            goto L_0x0100
        L_0x00ff:
            r4 = 0
        L_0x0100:
            if (r4 != 0) goto L_0x010a
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0119 }
            boolean r0 = com.facebook.FacebookSdk.getAutoLogAppEventsEnabled()     // Catch:{ all -> 0x0119 }
            if (r0 == 0) goto L_0x0114
        L_0x010a:
            java.lang.String r0 = "fb_sdk_settings_changed"
            r1.logEventImplicitly(r0, r10, r2)     // Catch:{ all -> 0x0119 }
            goto L_0x0114
        L_0x0110:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)     // Catch:{ all -> 0x0119 }
            throw r10
        L_0x0114:
            return
        L_0x0115:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)     // Catch:{ all -> 0x0119 }
            throw r10
        L_0x0119:
            r0 = move-exception
            r1 = r16
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.UserSettingsManager.logIfSDKSettingsChanged():void");
    }

    public final void logWarnings() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
                if (applicationInfo.metaData != null) {
                    boolean containsKey = applicationInfo.metaData.containsKey("com.facebook.sdk.AutoLogAppEventsEnabled");
                    boolean containsKey2 = applicationInfo.metaData.containsKey("com.facebook.sdk.AdvertiserIDCollectionEnabled");
                    boolean advertiserIDCollectionEnabled2 = getAdvertiserIDCollectionEnabled();
                }
            } catch (NameNotFoundException unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void readSettingFromCache(UserSetting userSetting) {
        String str = "";
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                validateInitialized();
                SharedPreferences sharedPreferences = userSettingPref;
                if (sharedPreferences != null) {
                    String string = sharedPreferences.getString(userSetting.key, str);
                    if (string != null) {
                        str = string;
                    }
                    if (str.length() > 0) {
                        JSONObject jSONObject = new JSONObject(str);
                        userSetting.value = Boolean.valueOf(jSONObject.getBoolean(HSLCriteriaBuilder.VALUE));
                        userSetting.lastTS = jSONObject.getLong("last_timestamp");
                    }
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                throw null;
            } catch (JSONException e2) {
                Utility.logd("com.facebook.UserSettingsManager", e2);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void validateInitialized() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!isInitialized.get()) {
                    throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void writeSettingToCache(UserSetting userSetting) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                validateInitialized();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(HSLCriteriaBuilder.VALUE, userSetting.value);
                jSONObject.put("last_timestamp", userSetting.lastTS);
                SharedPreferences sharedPreferences = userSettingPref;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString(userSetting.key, jSONObject.toString()).apply();
                    logIfSDKSettingsChanged();
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                throw null;
            } catch (Exception e2) {
                Utility.logd("com.facebook.UserSettingsManager", e2);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
