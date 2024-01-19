package com.mpl.androidapp.unity.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class LogCrashAnalyticsUseCase_Factory implements Factory<LogCrashAnalyticsUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public LogCrashAnalyticsUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static LogCrashAnalyticsUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new LogCrashAnalyticsUseCase_Factory(provider, provider2);
    }

    public static LogCrashAnalyticsUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new LogCrashAnalyticsUseCase(context, coroutineDispatcher);
    }

    public LogCrashAnalyticsUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
