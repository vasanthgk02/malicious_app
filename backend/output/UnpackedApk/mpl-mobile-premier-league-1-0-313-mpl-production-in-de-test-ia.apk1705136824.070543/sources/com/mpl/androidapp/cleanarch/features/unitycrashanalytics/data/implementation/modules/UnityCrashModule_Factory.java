package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.modules;

import com.mpl.androidapp.cleanarch.core.config.domain.ConfigZkFeatures;
import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.implementation.UnityCrashDbServiceImpl;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class UnityCrashModule_Factory implements Factory<UnityCrashModule> {
    public final Provider<ConfigZkFeatures> configProvider;
    public final Provider<CoroutineDispatcher> ioDispatcherProvider;
    public final Provider<LoggerFeature> loggerProvider;
    public final Provider<UnityCrashDbServiceImpl> unityCrashDbServiceImplProvider;

    public UnityCrashModule_Factory(Provider<UnityCrashDbServiceImpl> provider, Provider<LoggerFeature> provider2, Provider<ConfigZkFeatures> provider3, Provider<CoroutineDispatcher> provider4) {
        this.unityCrashDbServiceImplProvider = provider;
        this.loggerProvider = provider2;
        this.configProvider = provider3;
        this.ioDispatcherProvider = provider4;
    }

    public static UnityCrashModule_Factory create(Provider<UnityCrashDbServiceImpl> provider, Provider<LoggerFeature> provider2, Provider<ConfigZkFeatures> provider3, Provider<CoroutineDispatcher> provider4) {
        return new UnityCrashModule_Factory(provider, provider2, provider3, provider4);
    }

    public static UnityCrashModule newInstance(UnityCrashDbServiceImpl unityCrashDbServiceImpl, LoggerFeature loggerFeature, ConfigZkFeatures configZkFeatures, CoroutineDispatcher coroutineDispatcher) {
        return new UnityCrashModule(unityCrashDbServiceImpl, loggerFeature, configZkFeatures, coroutineDispatcher);
    }

    public UnityCrashModule get() {
        return newInstance((UnityCrashDbServiceImpl) this.unityCrashDbServiceImplProvider.get(), (LoggerFeature) this.loggerProvider.get(), (ConfigZkFeatures) this.configProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }
}
