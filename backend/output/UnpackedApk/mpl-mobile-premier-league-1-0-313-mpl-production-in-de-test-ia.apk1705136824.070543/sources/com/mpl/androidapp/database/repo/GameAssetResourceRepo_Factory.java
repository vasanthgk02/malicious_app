package com.mpl.androidapp.database.repo;

import com.mpl.androidapp.database.AssetsDatabase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class GameAssetResourceRepo_Factory implements Factory<GameAssetResourceRepo> {
    public final Provider<AssetsDatabase> dbProvider;

    public GameAssetResourceRepo_Factory(Provider<AssetsDatabase> provider) {
        this.dbProvider = provider;
    }

    public static GameAssetResourceRepo_Factory create(Provider<AssetsDatabase> provider) {
        return new GameAssetResourceRepo_Factory(provider);
    }

    public static GameAssetResourceRepo newInstance(AssetsDatabase assetsDatabase) {
        return new GameAssetResourceRepo(assetsDatabase);
    }

    public GameAssetResourceRepo get() {
        return newInstance((AssetsDatabase) this.dbProvider.get());
    }
}
