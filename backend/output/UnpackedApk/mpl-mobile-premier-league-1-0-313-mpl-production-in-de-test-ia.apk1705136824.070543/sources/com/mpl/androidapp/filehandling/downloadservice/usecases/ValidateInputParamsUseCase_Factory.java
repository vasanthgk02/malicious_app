package com.mpl.androidapp.filehandling.downloadservice.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class ValidateInputParamsUseCase_Factory implements Factory<ValidateInputParamsUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public ValidateInputParamsUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static ValidateInputParamsUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new ValidateInputParamsUseCase_Factory(provider, provider2);
    }

    public static ValidateInputParamsUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new ValidateInputParamsUseCase(context, coroutineDispatcher);
    }

    public ValidateInputParamsUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
