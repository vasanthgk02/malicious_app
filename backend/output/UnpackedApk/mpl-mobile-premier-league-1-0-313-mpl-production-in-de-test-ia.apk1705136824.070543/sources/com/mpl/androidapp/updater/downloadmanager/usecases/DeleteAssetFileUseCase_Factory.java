package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class DeleteAssetFileUseCase_Factory implements Factory<DeleteAssetFileUseCase> {
    public final Provider<CoroutineDispatcher> dispatcherProvider;
    public final Provider<GameAssetResourceRepo> gameAssetResourceRepoProvider;

    public DeleteAssetFileUseCase_Factory(Provider<GameAssetResourceRepo> provider, Provider<CoroutineDispatcher> provider2) {
        this.gameAssetResourceRepoProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static DeleteAssetFileUseCase_Factory create(Provider<GameAssetResourceRepo> provider, Provider<CoroutineDispatcher> provider2) {
        return new DeleteAssetFileUseCase_Factory(provider, provider2);
    }

    public static DeleteAssetFileUseCase newInstance(GameAssetResourceRepo gameAssetResourceRepo, CoroutineDispatcher coroutineDispatcher) {
        return new DeleteAssetFileUseCase(gameAssetResourceRepo, coroutineDispatcher);
    }

    public DeleteAssetFileUseCase get() {
        return newInstance((GameAssetResourceRepo) this.gameAssetResourceRepoProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
