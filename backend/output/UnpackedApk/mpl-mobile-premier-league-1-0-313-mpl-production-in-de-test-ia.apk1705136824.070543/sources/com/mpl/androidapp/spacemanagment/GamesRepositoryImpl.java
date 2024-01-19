package com.mpl.androidapp.spacemanagment;

import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageStats;
import android.os.Build.VERSION;
import android.os.UserHandle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.MLogger;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamesRepositoryImpl implements GamesRepository {
    public static final String TAG = "GameSpaceManagement";
    public long totAppsSize = 0;

    private boolean isSystemPackage(PackageInfo packageInfo) {
        return (packageInfo.applicationInfo.flags & 1) != 0;
    }

    public void getAPKSize(Context context, String str, final GamesModel gamesModel) {
        final long[] jArr = {0};
        try {
            if (VERSION.SDK_INT >= 26) {
                jArr[0] = new File(str).length();
                this.totAppsSize += jArr[0];
                gamesModel.setSize(jArr[0]);
                return;
            }
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass().getMethod("getPackageSizeInfo", new Class[]{String.class, Integer.TYPE, IPackageStatsObserver.class}).invoke(packageManager, new Object[]{gamesModel.getPackageName(), Integer.valueOf(((Integer) UserHandle.class.getMethod("myUserId", new Class[0]).invoke(packageManager, new Object[0])).intValue()), new Stub() {
                public void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                    jArr[0] = packageStats.cacheSize + packageStats.dataSize + packageStats.codeSize;
                    GamesRepositoryImpl gamesRepositoryImpl = GamesRepositoryImpl.this;
                    gamesRepositoryImpl.totAppsSize = gamesRepositoryImpl.totAppsSize + jArr[0];
                    gamesModel.setSize(jArr[0]);
                    MLogger.i("GameSpaceManagement", gamesModel.getPackageName() + ": " + jArr[0]);
                }
            }});
        } catch (Exception e2) {
            MLogger.e("GameSpaceManagement", e2);
        }
    }

    public Map getInstalledApps(Context context, boolean z) {
        MLogger.d("GameSpaceManagement", Thread.currentThread().getName());
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        this.totAppsSize = 0;
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = installedPackages.get(i);
            if (!z && (packageInfo.versionName == null || isSystemPackage(packageInfo))) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("system pkg: ");
                outline73.append(packageInfo.packageName);
                MLogger.d("GameSpaceManagement", outline73.toString());
            } else if (!context.getPackageName().equalsIgnoreCase(packageInfo.packageName)) {
                GamesModel gamesModel = new GamesModel();
                gamesModel.setAppName(packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString());
                gamesModel.setPackageName(packageInfo.packageName);
                gamesModel.setVersionNo(packageInfo.versionName);
                gamesModel.setIcon(packageInfo.applicationInfo.loadIcon(context.getPackageManager()));
                gamesModel.setLastUpdatedTime(packageInfo.lastUpdateTime);
                getAPKSize(context, packageInfo.applicationInfo.sourceDir, gamesModel);
                arrayList.add(gamesModel);
            }
        }
        hashMap.put(SpaceUtils.INSTALLED_APP_LIST, arrayList);
        hashMap.put(SpaceUtils.TOT_APPS_SIZE, Long.valueOf(this.totAppsSize));
        return hashMap;
    }

    public void getpackageSize(Context context, final String str, final GamesModel gamesModel) {
        final long[] jArr = {0};
        try {
            if (VERSION.SDK_INT >= 26) {
                StorageStatsManager storageStatsManager = (StorageStatsManager) context.getSystemService("storagestats");
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
                if (storageStatsManager != null) {
                    StorageStats queryStatsForUid = storageStatsManager.queryStatsForUid(applicationInfo.storageUuid, applicationInfo.uid);
                    jArr[0] = queryStatsForUid.getCacheBytes() + queryStatsForUid.getDataBytes() + queryStatsForUid.getAppBytes();
                    this.totAppsSize += jArr[0];
                    gamesModel.setSize(jArr[0]);
                    MLogger.i("GameSpaceManagement", str + ": " + jArr[0]);
                    return;
                }
                return;
            }
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass().getMethod("getPackageSizeInfo", new Class[]{String.class, Integer.TYPE, IPackageStatsObserver.class}).invoke(packageManager, new Object[]{str, Integer.valueOf(((Integer) UserHandle.class.getMethod("myUserId", new Class[0]).invoke(packageManager, new Object[0])).intValue()), new Stub() {
                public void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                    jArr[0] = packageStats.cacheSize + packageStats.dataSize + packageStats.codeSize;
                    GamesRepositoryImpl gamesRepositoryImpl = GamesRepositoryImpl.this;
                    gamesRepositoryImpl.totAppsSize = gamesRepositoryImpl.totAppsSize + jArr[0];
                    gamesModel.setSize(jArr[0]);
                    MLogger.i("GameSpaceManagement", str + ": " + jArr[0]);
                }
            }});
        } catch (NameNotFoundException | IOException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | NullPointerException | SecurityException | InvocationTargetException e2) {
            MLogger.e("GameSpaceManagement", "getpackageSize", e2);
        }
    }
}
