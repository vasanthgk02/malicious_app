package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import android.app.DownloadManager;
import android.content.Context;
import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.mpl.androidapp.updater.downloadmanager.usecases.GetGameResourceUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.PublishProgressUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.RemoveGameResourceUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.UpdateAssetsAnalyticsUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class DownloadAssets_Factory implements Factory<DownloadAssets> {
    public final Provider<Context> contextProvider;
    public final Provider<DownloadManager> downloadManagerProvider;
    public final Provider<GameAssetResourceRepo> gameAssetResourceRepoProvider;
    public final Provider<GetGameResourceUseCase> getGameResourceUseCaseProvider;
    public final Provider<CoroutineDispatcher> ioDispatcherProvider;
    public final Provider<PublishProgressUseCase> publishProgressUseCaseProvider;
    public final Provider<RemoveGameResourceUseCase> removeGameResourceUseCaseProvider;
    public final Provider<UpdateAssetsAnalyticsUseCase> updateAssetsAnalyticsUseCaseProvider;

    public DownloadAssets_Factory(Provider<Context> provider, Provider<DownloadManager> provider2, Provider<GameAssetResourceRepo> provider3, Provider<CoroutineDispatcher> provider4, Provider<UpdateAssetsAnalyticsUseCase> provider5, Provider<PublishProgressUseCase> provider6, Provider<GetGameResourceUseCase> provider7, Provider<RemoveGameResourceUseCase> provider8) {
        this.contextProvider = provider;
        this.downloadManagerProvider = provider2;
        this.gameAssetResourceRepoProvider = provider3;
        this.ioDispatcherProvider = provider4;
        this.updateAssetsAnalyticsUseCaseProvider = provider5;
        this.publishProgressUseCaseProvider = provider6;
        this.getGameResourceUseCaseProvider = provider7;
        this.removeGameResourceUseCaseProvider = provider8;
    }

    public static DownloadAssets_Factory create(Provider<Context> provider, Provider<DownloadManager> provider2, Provider<GameAssetResourceRepo> provider3, Provider<CoroutineDispatcher> provider4, Provider<UpdateAssetsAnalyticsUseCase> provider5, Provider<PublishProgressUseCase> provider6, Provider<GetGameResourceUseCase> provider7, Provider<RemoveGameResourceUseCase> provider8) {
        DownloadAssets_Factory downloadAssets_Factory = new DownloadAssets_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
        return downloadAssets_Factory;
    }

    public static DownloadAssets newInstance(Context context, DownloadManager downloadManager, GameAssetResourceRepo gameAssetResourceRepo, CoroutineDispatcher coroutineDispatcher, UpdateAssetsAnalyticsUseCase updateAssetsAnalyticsUseCase, PublishProgressUseCase publishProgressUseCase, GetGameResourceUseCase getGameResourceUseCase, RemoveGameResourceUseCase removeGameResourceUseCase) {
        DownloadAssets downloadAssets = new DownloadAssets(context, downloadManager, gameAssetResourceRepo, coroutineDispatcher, updateAssetsAnalyticsUseCase, publishProgressUseCase, getGameResourceUseCase, removeGameResourceUseCase);
        return downloadAssets;
    }

    public DownloadAssets get() {
        return newInstance((Context) this.contextProvider.get(), (DownloadManager) this.downloadManagerProvider.get(), (GameAssetResourceRepo) this.gameAssetResourceRepoProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get(), (UpdateAssetsAnalyticsUseCase) this.updateAssetsAnalyticsUseCaseProvider.get(), (PublishProgressUseCase) this.publishProgressUseCaseProvider.get(), (GetGameResourceUseCase) this.getGameResourceUseCaseProvider.get(), (RemoveGameResourceUseCase) this.removeGameResourceUseCaseProvider.get());
    }
}
