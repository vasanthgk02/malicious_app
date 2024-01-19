package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class RemoveGameResourceUseCase_Factory implements Factory<RemoveGameResourceUseCase> {
    public final Provider<CoroutineDispatcher> dispatcherProvider;
    public final Provider<GameAssetResourceRepo> gameAssetResourceRepoProvider;

    public RemoveGameResourceUseCase_Factory(Provider<GameAssetResourceRepo> provider, Provider<CoroutineDispatcher> provider2) {
        this.gameAssetResourceRepoProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static RemoveGameResourceUseCase_Factory create(Provider<GameAssetResourceRepo> provider, Provider<CoroutineDispatcher> provider2) {
        return new RemoveGameResourceUseCase_Factory(provider, provider2);
    }

    public static RemoveGameResourceUseCase newInstance(GameAssetResourceRepo gameAssetResourceRepo, CoroutineDispatcher coroutineDispatcher) {
        return new RemoveGameResourceUseCase(gameAssetResourceRepo, coroutineDispatcher);
    }

    public RemoveGameResourceUseCase get() {
        return newInstance((GameAssetResourceRepo) this.gameAssetResourceRepoProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
