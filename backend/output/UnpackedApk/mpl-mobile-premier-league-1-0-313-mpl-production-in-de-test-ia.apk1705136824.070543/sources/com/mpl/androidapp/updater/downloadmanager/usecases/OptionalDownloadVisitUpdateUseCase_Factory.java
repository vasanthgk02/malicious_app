package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class OptionalDownloadVisitUpdateUseCase_Factory implements Factory<OptionalDownloadVisitUpdateUseCase> {
    public final Provider<CoroutineDispatcher> dispatcherProvider;
    public final Provider<GameAssetResourceRepo> gameAssetResourceRepoProvider;

    public OptionalDownloadVisitUpdateUseCase_Factory(Provider<GameAssetResourceRepo> provider, Provider<CoroutineDispatcher> provider2) {
        this.gameAssetResourceRepoProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static OptionalDownloadVisitUpdateUseCase_Factory create(Provider<GameAssetResourceRepo> provider, Provider<CoroutineDispatcher> provider2) {
        return new OptionalDownloadVisitUpdateUseCase_Factory(provider, provider2);
    }

    public static OptionalDownloadVisitUpdateUseCase newInstance(GameAssetResourceRepo gameAssetResourceRepo, CoroutineDispatcher coroutineDispatcher) {
        return new OptionalDownloadVisitUpdateUseCase(gameAssetResourceRepo, coroutineDispatcher);
    }

    public OptionalDownloadVisitUpdateUseCase get() {
        return newInstance((GameAssetResourceRepo) this.gameAssetResourceRepoProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
