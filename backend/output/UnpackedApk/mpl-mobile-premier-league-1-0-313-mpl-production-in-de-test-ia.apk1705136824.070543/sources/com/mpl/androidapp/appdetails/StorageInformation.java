package com.mpl.androidapp.appdetails;

import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageStats;
import android.os.Build.VERSION;
import com.mpl.androidapp.IPackageStatsObserver;
import com.mpl.androidapp.IPackageStatsObserver.Stub;
import com.mpl.androidapp.utils.MLogger;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class StorageInformation {
    public static final String TAG = "StorageInformation";
    public final Context context;

    public StorageInformation(Context context2) {
        this.context = context2;
    }

    public long getpackageSize() {
        final long[] jArr = {0};
        try {
            if (VERSION.SDK_INT >= 26) {
                StorageStatsManager storageStatsManager = (StorageStatsManager) this.context.getSystemService("storagestats");
                ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 0);
                if (storageStatsManager != null) {
                    StorageStats queryStatsForUid = storageStatsManager.queryStatsForUid(applicationInfo.storageUuid, applicationInfo.uid);
                    jArr[0] = queryStatsForUid.getCacheBytes() + queryStatsForUid.getDataBytes() + queryStatsForUid.getAppBytes();
                    MLogger.i(TAG, "APK Size", Long.valueOf(jArr[0]));
                }
            } else {
                PackageManager packageManager = this.context.getPackageManager();
                packageManager.getClass().getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(packageManager, new Object[]{"com.mpl.androidapp", new Stub() {
                    public void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                        long[] jArr = jArr;
                        jArr[0] = packageStats.cacheSize + packageStats.dataSize + packageStats.codeSize;
                        MLogger.i(StorageInformation.TAG, "APK Size", Long.valueOf(jArr[0]));
                    }
                }});
            }
        } catch (NameNotFoundException | IOException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
            MLogger.e(TAG, "getpackageSize", e2);
        }
        return jArr[0];
    }
}
