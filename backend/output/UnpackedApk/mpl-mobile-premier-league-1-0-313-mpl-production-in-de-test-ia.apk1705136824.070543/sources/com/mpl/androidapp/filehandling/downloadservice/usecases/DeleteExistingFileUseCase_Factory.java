package com.mpl.androidapp.filehandling.downloadservice.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class DeleteExistingFileUseCase_Factory implements Factory<DeleteExistingFileUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public DeleteExistingFileUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static DeleteExistingFileUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new DeleteExistingFileUseCase_Factory(provider, provider2);
    }

    public static DeleteExistingFileUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new DeleteExistingFileUseCase(context, coroutineDispatcher);
    }

    public DeleteExistingFileUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
