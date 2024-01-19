package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class InsertAssetEntryUseCase_Factory implements Factory<InsertAssetEntryUseCase> {
    public final Provider<CoroutineDispatcher> dispatcherProvider;
    public final Provider<GameAssetResourceRepo> gameAssetResourceRepoProvider;

    public InsertAssetEntryUseCase_Factory(Provider<GameAssetResourceRepo> provider, Provider<CoroutineDispatcher> provider2) {
        this.gameAssetResourceRepoProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static InsertAssetEntryUseCase_Factory create(Provider<GameAssetResourceRepo> provider, Provider<CoroutineDispatcher> provider2) {
        return new InsertAssetEntryUseCase_Factory(provider, provider2);
    }

    public static InsertAssetEntryUseCase newInstance(GameAssetResourceRepo gameAssetResourceRepo, CoroutineDispatcher coroutineDispatcher) {
        return new InsertAssetEntryUseCase(gameAssetResourceRepo, coroutineDispatcher);
    }

    public InsertAssetEntryUseCase get() {
        return newInstance((GameAssetResourceRepo) this.gameAssetResourceRepoProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
