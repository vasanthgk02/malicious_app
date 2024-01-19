package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

public class IdManager implements InstallIdProvider {
    public static final String DEFAULT_VERSION_NAME = "0.0";
    public static final String FORWARD_SLASH_REGEX = Pattern.quote("/");
    public static final Pattern ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
    public static final String PREFKEY_ADVERTISING_ID = "crashlytics.advertising.id";
    public static final String PREFKEY_FIREBASE_IID = "firebase.installation.id";
    public static final String PREFKEY_INSTALLATION_UUID = "crashlytics.installation.id";
    public static final String PREFKEY_LEGACY_INSTALLATION_UUID = "crashlytics.installation.id";
    public static final String SYNTHETIC_FID_PREFIX = "SYN_";
    public final Context appContext;
    public final String appIdentifier;
    public String crashlyticsInstallId;
    public final DataCollectionArbiter dataCollectionArbiter;
    public final FirebaseInstallationsApi firebaseInstallationsApi;
    public final InstallerPackageNameProvider installerPackageNameProvider;

    public IdManager(Context context, String str, FirebaseInstallationsApi firebaseInstallationsApi2, DataCollectionArbiter dataCollectionArbiter2) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str != null) {
            this.appContext = context;
            this.appIdentifier = str;
            this.firebaseInstallationsApi = firebaseInstallationsApi2;
            this.dataCollectionArbiter = dataCollectionArbiter2;
            this.installerPackageNameProvider = new InstallerPackageNameProvider();
        } else {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
    }

    private synchronized String createAndCacheCrashlyticsInstallId(String str, SharedPreferences sharedPreferences) {
        String formatId;
        formatId = formatId(UUID.randomUUID().toString());
        Logger logger = Logger.getLogger();
        logger.v("Created new Crashlytics installation ID: " + formatId + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", formatId).putString(PREFKEY_FIREBASE_IID, str).apply();
        return formatId;
    }

    public static String createSyntheticFid() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(SYNTHETIC_FID_PREFIX);
        outline73.append(UUID.randomUUID().toString());
        return outline73.toString();
    }

    private String fetchTrueFid() {
        try {
            return (String) Utils.awaitEvenIfOnMainThread(this.firebaseInstallationsApi.getId());
        } catch (Exception e2) {
            Logger.getLogger().w("Failed to retrieve Firebase Installations ID.", e2);
            return null;
        }
    }

    public static String formatId(String str) {
        if (str == null) {
            return null;
        }
        return ID_PATTERN.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public static boolean isSyntheticFid(String str) {
        return str != null && str.startsWith(SYNTHETIC_FID_PREFIX);
    }

    private String readCachedCrashlyticsInstallId(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", null);
    }

    private String removeForwardSlashesIn(String str) {
        return str.replaceAll(FORWARD_SLASH_REGEX, "");
    }

    public String getAppIdentifier() {
        return this.appIdentifier;
    }

    public synchronized String getCrashlyticsInstallId() {
        if (this.crashlyticsInstallId != null) {
            return this.crashlyticsInstallId;
        }
        Logger.getLogger().v("Determining Crashlytics installation ID...");
        SharedPreferences sharedPrefs = CommonUtils.getSharedPrefs(this.appContext);
        String string = sharedPrefs.getString(PREFKEY_FIREBASE_IID, null);
        Logger logger = Logger.getLogger();
        logger.v("Cached Firebase Installation ID: " + string);
        if (this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
            String fetchTrueFid = fetchTrueFid();
            Logger logger2 = Logger.getLogger();
            logger2.v("Fetched Firebase Installation ID: " + fetchTrueFid);
            if (fetchTrueFid == null) {
                fetchTrueFid = string == null ? createSyntheticFid() : string;
            }
            if (fetchTrueFid.equals(string)) {
                this.crashlyticsInstallId = readCachedCrashlyticsInstallId(sharedPrefs);
            } else {
                this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId(fetchTrueFid, sharedPrefs);
            }
        } else if (isSyntheticFid(string)) {
            this.crashlyticsInstallId = readCachedCrashlyticsInstallId(sharedPrefs);
        } else {
            this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId(createSyntheticFid(), sharedPrefs);
        }
        if (this.crashlyticsInstallId == null) {
            Logger.getLogger().w("Unable to determine Crashlytics Install Id, creating a new one.");
            this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId(createSyntheticFid(), sharedPrefs);
        }
        Logger logger3 = Logger.getLogger();
        logger3.v("Crashlytics installation ID: " + this.crashlyticsInstallId);
        return this.crashlyticsInstallId;
    }

    public String getInstallerPackageName() {
        return this.installerPackageNameProvider.getInstallerPackageName(this.appContext);
    }

    public String getModelName() {
        return String.format(Locale.US, "%s/%s", new Object[]{removeForwardSlashesIn(Build.MANUFACTURER), removeForwardSlashesIn(Build.MODEL)});
    }

    public String getOsBuildVersionString() {
        return removeForwardSlashesIn(VERSION.INCREMENTAL);
    }

    public String getOsDisplayVersionString() {
        return removeForwardSlashesIn(VERSION.RELEASE);
    }
}
