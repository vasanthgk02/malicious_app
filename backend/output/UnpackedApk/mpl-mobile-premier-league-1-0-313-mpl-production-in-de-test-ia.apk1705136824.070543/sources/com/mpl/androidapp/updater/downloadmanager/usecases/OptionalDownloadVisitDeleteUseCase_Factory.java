package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class OptionalDownloadVisitDeleteUseCase_Factory implements Factory<OptionalDownloadVisitDeleteUseCase> {
    public final Provider<CoroutineDispatcher> dispatcherProvider;
    public final Provider<GameAssetResourceRepo> gameAssetResourceRepoProvider;

    public OptionalDownloadVisitDeleteUseCase_Factory(Provider<GameAssetResourceRepo> provider, Provider<CoroutineDispatcher> provider2) {
        this.gameAssetResourceRepoProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static OptionalDownloadVisitDeleteUseCase_Factory create(Provider<GameAssetResourceRepo> provider, Provider<CoroutineDispatcher> provider2) {
        return new OptionalDownloadVisitDeleteUseCase_Factory(provider, provider2);
    }

    public static OptionalDownloadVisitDeleteUseCase newInstance(GameAssetResourceRepo gameAssetResourceRepo, CoroutineDispatcher coroutineDispatcher) {
        return new OptionalDownloadVisitDeleteUseCase(gameAssetResourceRepo, coroutineDispatcher);
    }

    public OptionalDownloadVisitDeleteUseCase get() {
        return newInstance((GameAssetResourceRepo) this.gameAssetResourceRepoProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
