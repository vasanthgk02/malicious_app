package com.mpl.androidapp.updater.downloadmanager.di.modules;

import com.mpl.androidapp.database.AssetsDatabase;
import com.mpl.androidapp.database.dao.GameAssetsDao;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DatabaseModule_ProvideChannelDaoFactory implements Factory<GameAssetsDao> {
    public final Provider<AssetsDatabase> assetsDatabaseProvider;
    public final DatabaseModule module;

    public DatabaseModule_ProvideChannelDaoFactory(DatabaseModule databaseModule, Provider<AssetsDatabase> provider) {
        this.module = databaseModule;
        this.assetsDatabaseProvider = provider;
    }

    public static DatabaseModule_ProvideChannelDaoFactory create(DatabaseModule databaseModule, Provider<AssetsDatabase> provider) {
        return new DatabaseModule_ProvideChannelDaoFactory(databaseModule, provider);
    }

    public static GameAssetsDao provideChannelDao(DatabaseModule databaseModule, AssetsDatabase assetsDatabase) {
        GameAssetsDao provideChannelDao = databaseModule.provideChannelDao(assetsDatabase);
        TweetUtils.checkNotNullFromProvides(provideChannelDao);
        return provideChannelDao;
    }

    public GameAssetsDao get() {
        return provideChannelDao(this.module, (AssetsDatabase) this.assetsDatabaseProvider.get());
    }
}
