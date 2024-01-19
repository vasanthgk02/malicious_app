package com.mpl.androidapp.updater.downloadmanager;

import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.updater.downloadmanager.downloadModules.Download;
import com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgress;
import com.mpl.androidapp.updater.downloadmanager.usecases.GetGameResourceUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.InsertAssetEntryUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.UpdateAssetsAnalyticsUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class DownloadFeature_Factory implements Factory<DownloadFeature> {
    public final Provider<DownloadProgress> downloadProgressProvider;
    public final Provider<Download> downloadProvider;
    public final Provider<DownloadTaskParams> downloadTaskParamsProvider;
    public final Provider<GameAssetResourceRepo> gameAssetResourceRepoProvider;
    public final Provider<GetGameResourceUseCase> getGameResourceUseCaseProvider;
    public final Provider<InsertAssetEntryUseCase> insertAssetEntryUseCaseProvider;
    public final Provider<CoroutineDispatcher> ioDispatcherProvider;
    public final Provider<Boolean> isWebViewFlowProvider;
    public final Provider<UpdateAssetsAnalyticsUseCase> updateAssetsAnalyticsUseCaseProvider;

    public DownloadFeature_Factory(Provider<DownloadTaskParams> provider, Provider<Download> provider2, Provider<DownloadProgress> provider3, Provider<GameAssetResourceRepo> provider4, Provider<GetGameResourceUseCase> provider5, Provider<UpdateAssetsAnalyticsUseCase> provider6, Provider<InsertAssetEntryUseCase> provider7, Provider<CoroutineDispatcher> provider8, Provider<Boolean> provider9) {
        this.downloadTaskParamsProvider = provider;
        this.downloadProvider = provider2;
        this.downloadProgressProvider = provider3;
        this.gameAssetResourceRepoProvider = provider4;
        this.getGameResourceUseCaseProvider = provider5;
        this.updateAssetsAnalyticsUseCaseProvider = provider6;
        this.insertAssetEntryUseCaseProvider = provider7;
        this.ioDispatcherProvider = provider8;
        this.isWebViewFlowProvider = provider9;
    }

    public static DownloadFeature_Factory create(Provider<DownloadTaskParams> provider, Provider<Download> provider2, Provider<DownloadProgress> provider3, Provider<GameAssetResourceRepo> provider4, Provider<GetGameResourceUseCase> provider5, Provider<UpdateAssetsAnalyticsUseCase> provider6, Provider<InsertAssetEntryUseCase> provider7, Provider<CoroutineDispatcher> provider8, Provider<Boolean> provider9) {
        DownloadFeature_Factory downloadFeature_Factory = new DownloadFeature_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
        return downloadFeature_Factory;
    }

    public static DownloadFeature newInstance(DownloadTaskParams downloadTaskParams, Download download, DownloadProgress downloadProgress, GameAssetResourceRepo gameAssetResourceRepo, GetGameResourceUseCase getGameResourceUseCase, UpdateAssetsAnalyticsUseCase updateAssetsAnalyticsUseCase, InsertAssetEntryUseCase insertAssetEntryUseCase, CoroutineDispatcher coroutineDispatcher, boolean z) {
        DownloadFeature downloadFeature = new DownloadFeature(downloadTaskParams, download, downloadProgress, gameAssetResourceRepo, getGameResourceUseCase, updateAssetsAnalyticsUseCase, insertAssetEntryUseCase, coroutineDispatcher, z);
        return downloadFeature;
    }

    public DownloadFeature get() {
        return newInstance((DownloadTaskParams) this.downloadTaskParamsProvider.get(), (Download) this.downloadProvider.get(), (DownloadProgress) this.downloadProgressProvider.get(), (GameAssetResourceRepo) this.gameAssetResourceRepoProvider.get(), (GetGameResourceUseCase) this.getGameResourceUseCaseProvider.get(), (UpdateAssetsAnalyticsUseCase) this.updateAssetsAnalyticsUseCaseProvider.get(), (InsertAssetEntryUseCase) this.insertAssetEntryUseCaseProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get(), ((Boolean) this.isWebViewFlowProvider.get()).booleanValue());
    }
}
