package com.mpl.androidapp.updater.downloadmanager.di.modules;

import android.app.DownloadManager;
import android.content.Context;
import com.google.gson.Gson;
import com.mpl.androidapp.database.AssetsDatabase;
import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.mpl.androidapp.utils.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/di/modules/DownloadManagerModule;", "", "()V", "provideDownloadManager", "Landroid/app/DownloadManager;", "context", "Landroid/content/Context;", "provideGameAssetsRepo", "Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;", "appDatabase", "Lcom/mpl/androidapp/database/AssetsDatabase;", "provideGson", "Lcom/google/gson/Gson;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadManagerModule.kt */
public final class DownloadManagerModule {
    public final DownloadManager provideDownloadManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(Constant.DOWNLOAD);
        if (systemService != null) {
            return (DownloadManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.DownloadManager");
    }

    public final GameAssetResourceRepo provideGameAssetsRepo(AssetsDatabase assetsDatabase) {
        Intrinsics.checkNotNullParameter(assetsDatabase, "appDatabase");
        return new GameAssetResourceRepo(assetsDatabase);
    }

    public final Gson provideGson() {
        return new Gson();
    }
}
