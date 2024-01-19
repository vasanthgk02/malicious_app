package com.google.firebase.crashlytics.internal.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsController implements SettingsDataProvider {
    public static final String PREFS_BUILD_INSTANCE_IDENTIFIER = "existing_instance_identifier";
    public static final String SETTINGS_URL_FORMAT = "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings";
    public final AtomicReference<TaskCompletionSource<AppSettingsData>> appSettingsData = new AtomicReference<>(new TaskCompletionSource());
    public final CachedSettingsIo cachedSettingsIo;
    public final Context context;
    public final CurrentTimeProvider currentTimeProvider;
    public final DataCollectionArbiter dataCollectionArbiter;
    public final AtomicReference<Settings> settings = new AtomicReference<>();
    public final SettingsJsonParser settingsJsonParser;
    public final SettingsRequest settingsRequest;
    public final SettingsSpiCall settingsSpiCall;

    public SettingsController(Context context2, SettingsRequest settingsRequest2, CurrentTimeProvider currentTimeProvider2, SettingsJsonParser settingsJsonParser2, CachedSettingsIo cachedSettingsIo2, SettingsSpiCall settingsSpiCall2, DataCollectionArbiter dataCollectionArbiter2) {
        this.context = context2;
        this.settingsRequest = settingsRequest2;
        this.currentTimeProvider = currentTimeProvider2;
        this.settingsJsonParser = settingsJsonParser2;
        this.cachedSettingsIo = cachedSettingsIo2;
        this.settingsSpiCall = settingsSpiCall2;
        this.dataCollectionArbiter = dataCollectionArbiter2;
        this.settings.set(DefaultSettingsJsonTransform.defaultSettings(currentTimeProvider2));
    }

    public static SettingsController create(Context context2, String str, IdManager idManager, HttpRequestFactory httpRequestFactory, String str2, String str3, FileStore fileStore, DataCollectionArbiter dataCollectionArbiter2) {
        String installerPackageName = idManager.getInstallerPackageName();
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        SettingsJsonParser settingsJsonParser2 = new SettingsJsonParser(systemCurrentTimeProvider);
        CachedSettingsIo cachedSettingsIo2 = new CachedSettingsIo(fileStore);
        DefaultSettingsSpiCall defaultSettingsSpiCall = new DefaultSettingsSpiCall(String.format(Locale.US, SETTINGS_URL_FORMAT, new Object[]{str}), httpRequestFactory);
        String modelName = idManager.getModelName();
        String osBuildVersionString = idManager.getOsBuildVersionString();
        String osDisplayVersionString = idManager.getOsDisplayVersionString();
        String createInstanceIdFrom = CommonUtils.createInstanceIdFrom(CommonUtils.getMappingFileId(context2), str, str3, str2);
        SettingsRequest settingsRequest2 = new SettingsRequest(str, modelName, osBuildVersionString, osDisplayVersionString, idManager, createInstanceIdFrom, str3, str2, DeliveryMechanism.determineFrom(installerPackageName).getId());
        SettingsController settingsController = new SettingsController(context2, settingsRequest2, systemCurrentTimeProvider, settingsJsonParser2, cachedSettingsIo2, defaultSettingsSpiCall, dataCollectionArbiter2);
        return settingsController;
    }

    private SettingsData getCachedSettingsData(SettingsCacheBehavior settingsCacheBehavior) {
        SettingsData settingsData = null;
        try {
            if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                return null;
            }
            JSONObject readCachedSettings = this.cachedSettingsIo.readCachedSettings();
            if (readCachedSettings != null) {
                SettingsData parseSettingsJson = this.settingsJsonParser.parseSettingsJson(readCachedSettings);
                if (parseSettingsJson != null) {
                    logSettings(readCachedSettings, "Loaded cached settings: ");
                    long currentTimeMillis = this.currentTimeProvider.getCurrentTimeMillis();
                    if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior)) {
                        if (parseSettingsJson.isExpired(currentTimeMillis)) {
                            Logger.getLogger().v("Cached settings have expired.");
                            return null;
                        }
                    }
                    try {
                        Logger.getLogger().v("Returning cached settings.");
                        return parseSettingsJson;
                    } catch (Exception e2) {
                        e = e2;
                        settingsData = parseSettingsJson;
                        Logger.getLogger().e("Failed to get cached settings", e);
                        return settingsData;
                    }
                } else {
                    Logger.getLogger().e("Failed to parse cached settings data.", null);
                    return null;
                }
            } else {
                Logger.getLogger().d("No cached settings data found.");
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            Logger.getLogger().e("Failed to get cached settings", e);
            return settingsData;
        }
    }

    private String getStoredBuildInstanceIdentifier() {
        return CommonUtils.getSharedPrefs(this.context).getString(PREFS_BUILD_INSTANCE_IDENTIFIER, "");
    }

    /* access modifiers changed from: private */
    public void logSettings(JSONObject jSONObject, String str) throws JSONException {
        Logger logger = Logger.getLogger();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
        outline73.append(jSONObject.toString());
        logger.d(outline73.toString());
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public boolean setStoredBuildInstanceIdentifier(String str) {
        Editor edit = CommonUtils.getSharedPrefs(this.context).edit();
        edit.putString(PREFS_BUILD_INSTANCE_IDENTIFIER, str);
        edit.apply();
        return true;
    }

    public boolean buildInstanceIdentifierChanged() {
        return !getStoredBuildInstanceIdentifier().equals(this.settingsRequest.instanceId);
    }

    public Task<AppSettingsData> getAppSettings() {
        return this.appSettingsData.get().zza;
    }

    public Settings getSettings() {
        return this.settings.get();
    }

    public Task<Void> loadSettingsData(Executor executor) {
        return loadSettingsData(SettingsCacheBehavior.USE_CACHE, executor);
    }

    public Task<Void> loadSettingsData(SettingsCacheBehavior settingsCacheBehavior, Executor executor) {
        if (!buildInstanceIdentifierChanged()) {
            SettingsData cachedSettingsData = getCachedSettingsData(settingsCacheBehavior);
            if (cachedSettingsData != null) {
                this.settings.set(cachedSettingsData);
                this.appSettingsData.get().trySetResult(cachedSettingsData.getAppSettingsData());
                return Tasks.forResult(null);
            }
        }
        SettingsData cachedSettingsData2 = getCachedSettingsData(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
        if (cachedSettingsData2 != null) {
            this.settings.set(cachedSettingsData2);
            this.appSettingsData.get().trySetResult(cachedSettingsData2.getAppSettingsData());
        }
        return this.dataCollectionArbiter.waitForDataCollectionPermission(executor).onSuccessTask(executor, new SuccessContinuation<Void, Void>() {
            public Task<Void> then(Void voidR) throws Exception {
                JSONObject invoke = SettingsController.this.settingsSpiCall.invoke(SettingsController.this.settingsRequest, true);
                if (invoke != null) {
                    SettingsData parseSettingsJson = SettingsController.this.settingsJsonParser.parseSettingsJson(invoke);
                    SettingsController.this.cachedSettingsIo.writeCachedSettings(parseSettingsJson.getExpiresAtMillis(), invoke);
                    SettingsController.this.logSettings(invoke, "Loaded settings: ");
                    SettingsController settingsController = SettingsController.this;
                    settingsController.setStoredBuildInstanceIdentifier(settingsController.settingsRequest.instanceId);
                    SettingsController.this.settings.set(parseSettingsJson);
                    ((TaskCompletionSource) SettingsController.this.appSettingsData.get()).trySetResult(parseSettingsJson.getAppSettingsData());
                    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                    taskCompletionSource.trySetResult(parseSettingsJson.getAppSettingsData());
                    SettingsController.this.appSettingsData.set(taskCompletionSource);
                }
                return Tasks.forResult(null);
            }
        });
    }
}
