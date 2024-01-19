package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;
import com.mpl.payment.gopay.GopayLinkingHandler;
import java.util.concurrent.Executor;

public class DataCollectionArbiter {
    public static final String FIREBASE_CRASHLYTICS_COLLECTION_ENABLED = "firebase_crashlytics_collection_enabled";
    public Boolean crashlyticsDataCollectionEnabled;
    public TaskCompletionSource<Void> dataCollectionEnabledTask = new TaskCompletionSource<>();
    public final TaskCompletionSource<Void> dataCollectionExplicitlyApproved = new TaskCompletionSource<>();
    public final FirebaseApp firebaseApp;
    public boolean setInManifest = false;
    public final SharedPreferences sharedPreferences;
    public final Object taskLock = new Object();
    public boolean taskResolved = false;

    public DataCollectionArbiter(FirebaseApp firebaseApp2) {
        firebaseApp2.checkNotDeleted();
        Context context = firebaseApp2.applicationContext;
        this.firebaseApp = firebaseApp2;
        this.sharedPreferences = CommonUtils.getSharedPrefs(context);
        this.crashlyticsDataCollectionEnabled = getDataCollectionValueFromSharedPreferences() == null ? getDataCollectionValueFromManifest(context) : getDataCollectionValueFromSharedPreferences();
        synchronized (this.taskLock) {
            if (isAutomaticDataCollectionEnabled()) {
                this.dataCollectionEnabledTask.trySetResult(null);
                this.taskResolved = true;
            }
        }
    }

    private Boolean getDataCollectionValueFromManifest(Context context) {
        Boolean readCrashlyticsDataCollectionEnabledFromManifest = readCrashlyticsDataCollectionEnabledFromManifest(context);
        if (readCrashlyticsDataCollectionEnabledFromManifest == null) {
            this.setInManifest = false;
            return null;
        }
        this.setInManifest = true;
        return Boolean.valueOf(Boolean.TRUE.equals(readCrashlyticsDataCollectionEnabledFromManifest));
    }

    private Boolean getDataCollectionValueFromSharedPreferences() {
        if (!this.sharedPreferences.contains(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED)) {
            return null;
        }
        this.setInManifest = false;
        return Boolean.valueOf(this.sharedPreferences.getBoolean(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED, true));
    }

    private void logDataCollectionState(boolean z) {
        String str;
        String str2 = z ? GopayLinkingHandler.AS_ENABLED : "DISABLED";
        if (this.crashlyticsDataCollectionEnabled == null) {
            str = "global Firebase setting";
        } else {
            str = this.setInManifest ? "firebase_crashlytics_collection_enabled manifest flag" : "API";
        }
        Logger.getLogger().d(String.format("Crashlytics automatic data collection %s by %s.", new Object[]{str2, str}));
    }

    public static Boolean readCrashlyticsDataCollectionEnabledFromManifest(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                if (!(applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED))) {
                    return Boolean.valueOf(applicationInfo.metaData.getBoolean(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED));
                }
            }
        } catch (NameNotFoundException e2) {
            Logger.getLogger().e("Could not read data collection permission from manifest", e2);
        }
        return null;
    }

    @SuppressLint({"ApplySharedPref"})
    public static void storeDataCollectionValueInSharedPreferences(SharedPreferences sharedPreferences2, Boolean bool) {
        Editor edit = sharedPreferences2.edit();
        if (bool != null) {
            edit.putBoolean(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED, bool.booleanValue());
        } else {
            edit.remove(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED);
        }
        edit.apply();
    }

    public void grantDataCollectionPermission(boolean z) {
        if (z) {
            this.dataCollectionExplicitlyApproved.trySetResult(null);
            return;
        }
        throw new IllegalStateException("An invalid data collection token was used.");
    }

    public synchronized boolean isAutomaticDataCollectionEnabled() {
        boolean z;
        try {
            if (this.crashlyticsDataCollectionEnabled != null) {
                z = this.crashlyticsDataCollectionEnabled.booleanValue();
            } else {
                z = this.firebaseApp.isDataCollectionDefaultEnabled();
            }
            logDataCollectionState(z);
        }
        return z;
    }

    public synchronized void setCrashlyticsDataCollectionEnabled(Boolean bool) {
        Boolean bool2;
        if (bool != null) {
            try {
                this.setInManifest = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            bool2 = bool;
        } else {
            FirebaseApp firebaseApp2 = this.firebaseApp;
            firebaseApp2.checkNotDeleted();
            bool2 = getDataCollectionValueFromManifest(firebaseApp2.applicationContext);
        }
        this.crashlyticsDataCollectionEnabled = bool2;
        storeDataCollectionValueInSharedPreferences(this.sharedPreferences, bool);
        synchronized (this.taskLock) {
            if (isAutomaticDataCollectionEnabled()) {
                if (!this.taskResolved) {
                    this.dataCollectionEnabledTask.trySetResult(null);
                    this.taskResolved = true;
                }
            } else if (this.taskResolved) {
                this.dataCollectionEnabledTask = new TaskCompletionSource<>();
                this.taskResolved = false;
            }
        }
    }

    public Task<Void> waitForAutomaticDataCollectionEnabled() {
        zzw zzw;
        synchronized (this.taskLock) {
            zzw = this.dataCollectionEnabledTask.zza;
        }
        return zzw;
    }

    public Task<Void> waitForDataCollectionPermission(Executor executor) {
        return Utils.race(executor, this.dataCollectionExplicitlyApproved.zza, waitForAutomaticDataCollectionEnabled());
    }
}
