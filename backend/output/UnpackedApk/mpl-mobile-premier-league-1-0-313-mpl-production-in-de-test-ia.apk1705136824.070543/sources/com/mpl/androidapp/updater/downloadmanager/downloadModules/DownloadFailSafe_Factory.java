package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import android.app.DownloadManager;
import android.content.Context;
import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class DownloadFailSafe_Factory implements Factory<DownloadFailSafe> {
    public final Provider<Context> contextProvider;
    public final Provider<DownloadManager> downloadManagerProvider;
    public final Provider<GameAssetResourceRepo> gameAssetResourceRepoProvider;
    public final Provider<CoroutineDispatcher> ioDispatcherProvider;

    public DownloadFailSafe_Factory(Provider<Context> provider, Provider<GameAssetResourceRepo> provider2, Provider<DownloadManager> provider3, Provider<CoroutineDispatcher> provider4) {
        this.contextProvider = provider;
        this.gameAssetResourceRepoProvider = provider2;
        this.downloadManagerProvider = provider3;
        this.ioDispatcherProvider = provider4;
    }

    public static DownloadFailSafe_Factory create(Provider<Context> provider, Provider<GameAssetResourceRepo> provider2, Provider<DownloadManager> provider3, Provider<CoroutineDispatcher> provider4) {
        return new DownloadFailSafe_Factory(provider, provider2, provider3, provider4);
    }

    public static DownloadFailSafe newInstance(Context context, GameAssetResourceRepo gameAssetResourceRepo, DownloadManager downloadManager, CoroutineDispatcher coroutineDispatcher) {
        return new DownloadFailSafe(context, gameAssetResourceRepo, downloadManager, coroutineDispatcher);
    }

    public DownloadFailSafe get() {
        return newInstance((Context) this.contextProvider.get(), (GameAssetResourceRepo) this.gameAssetResourceRepoProvider.get(), (DownloadManager) this.downloadManagerProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }
}
