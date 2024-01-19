package com.mpl.androidapp.updater.downloadmanager.di.modules;

import com.mpl.androidapp.database.AssetsDatabase;
import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DownloadManagerModule_ProvideGameAssetsRepoFactory implements Factory<GameAssetResourceRepo> {
    public final Provider<AssetsDatabase> appDatabaseProvider;
    public final DownloadManagerModule module;

    public DownloadManagerModule_ProvideGameAssetsRepoFactory(DownloadManagerModule downloadManagerModule, Provider<AssetsDatabase> provider) {
        this.module = downloadManagerModule;
        this.appDatabaseProvider = provider;
    }

    public static DownloadManagerModule_ProvideGameAssetsRepoFactory create(DownloadManagerModule downloadManagerModule, Provider<AssetsDatabase> provider) {
        return new DownloadManagerModule_ProvideGameAssetsRepoFactory(downloadManagerModule, provider);
    }

    public static GameAssetResourceRepo provideGameAssetsRepo(DownloadManagerModule downloadManagerModule, AssetsDatabase assetsDatabase) {
        GameAssetResourceRepo provideGameAssetsRepo = downloadManagerModule.provideGameAssetsRepo(assetsDatabase);
        TweetUtils.checkNotNullFromProvides(provideGameAssetsRepo);
        return provideGameAssetsRepo;
    }

    public GameAssetResourceRepo get() {
        return provideGameAssetsRepo(this.module, (AssetsDatabase) this.appDatabaseProvider.get());
    }
}
