package com.mpl.androidapp.updater.downloadmanager.di.entrypoints;

import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets;
import com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressAssets;
import com.mpl.androidapp.updater.downloadmanager.usecases.GetGameResourceUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.InsertAssetEntryUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.UpdateAssetsAnalyticsUseCase;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH'J\b\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/di/entrypoints/AssetDownloadEntryPoint;", "", "InsertAssetEntryUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/InsertAssetEntryUseCase;", "downloadAssetsService", "Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/DownloadAssets;", "downloadProgressAssetsService", "Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/DownloadProgressAssets;", "gameAssetResourceRepo", "Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;", "getGameResourceUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/GetGameResourceUseCase;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "updateAssetsAnalyticsUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/UpdateAssetsAnalyticsUseCase;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AssetDownloadEntryPoint.kt */
public interface AssetDownloadEntryPoint {
    InsertAssetEntryUseCase InsertAssetEntryUseCase();

    DownloadAssets downloadAssetsService();

    DownloadProgressAssets downloadProgressAssetsService();

    GameAssetResourceRepo gameAssetResourceRepo();

    GetGameResourceUseCase getGameResourceUseCase();

    @IoDispatcher
    CoroutineDispatcher ioDispatcher();

    UpdateAssetsAnalyticsUseCase updateAssetsAnalyticsUseCase();
}
