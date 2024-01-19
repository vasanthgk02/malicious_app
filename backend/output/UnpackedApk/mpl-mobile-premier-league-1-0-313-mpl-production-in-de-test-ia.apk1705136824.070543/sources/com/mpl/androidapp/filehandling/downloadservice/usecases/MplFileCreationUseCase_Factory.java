package com.mpl.androidapp.filehandling.downloadservice.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class MplFileCreationUseCase_Factory implements Factory<MplFileCreationUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public MplFileCreationUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static MplFileCreationUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new MplFileCreationUseCase_Factory(provider, provider2);
    }

    public static MplFileCreationUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new MplFileCreationUseCase(context, coroutineDispatcher);
    }

    public MplFileCreationUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
