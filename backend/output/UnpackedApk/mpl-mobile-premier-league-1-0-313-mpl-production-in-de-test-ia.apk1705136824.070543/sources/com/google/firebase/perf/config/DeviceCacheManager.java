package com.google.firebase.perf.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.FirebaseApp;
import com.google.firebase.perf.logging.AndroidLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeviceCacheManager {
    public static DeviceCacheManager instance;
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public final ExecutorService serialExecutor;
    public volatile SharedPreferences sharedPref;

    public DeviceCacheManager(ExecutorService executorService) {
        this.serialExecutor = executorService;
    }

    public static synchronized DeviceCacheManager getInstance() {
        DeviceCacheManager deviceCacheManager;
        synchronized (DeviceCacheManager.class) {
            try {
                if (instance == null) {
                    instance = new DeviceCacheManager(Executors.newSingleThreadExecutor());
                }
                deviceCacheManager = instance;
            }
        }
        return deviceCacheManager;
    }

    public final Context getFirebaseApplicationContext() {
        try {
            FirebaseApp.getInstance();
            FirebaseApp instance2 = FirebaseApp.getInstance();
            instance2.checkNotDeleted();
            return instance2.applicationContext;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public /* synthetic */ void lambda$setContext$0$DeviceCacheManager(Context context) {
        if (this.sharedPref == null && context != null) {
            this.sharedPref = context.getSharedPreferences("FirebasePerfSharedPrefs", 0);
        }
    }

    public synchronized void setContext(Context context) {
        if (this.sharedPref == null && context != null) {
            this.serialExecutor.execute(new Runnable(context) {
                public final /* synthetic */ Context f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    DeviceCacheManager.this.lambda$setContext$0$DeviceCacheManager(this.f$1);
                }
            });
        }
    }

    public boolean setValue(String str, String str2) {
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        if (str2 == null) {
            GeneratedOutlineSupport.outline93(this.sharedPref, str);
            return true;
        }
        this.sharedPref.edit().putString(str, str2).apply();
        return true;
    }

    public boolean setValue(String str, float f2) {
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        this.sharedPref.edit().putFloat(str, f2).apply();
        return true;
    }

    public boolean setValue(String str, long j) {
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        this.sharedPref.edit().putLong(str, j).apply();
        return true;
    }
}
