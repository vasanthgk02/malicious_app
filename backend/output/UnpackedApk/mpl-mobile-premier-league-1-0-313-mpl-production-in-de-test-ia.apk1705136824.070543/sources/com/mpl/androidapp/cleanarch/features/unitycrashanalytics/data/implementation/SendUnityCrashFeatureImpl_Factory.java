package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation;

import com.mpl.androidapp.cleanarch.core.analytics.domain.AnalyticsFeature;
import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.modules.UnityCrashModule;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.implementation.UnityCrashDbServiceImpl;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SendUnityCrashFeatureImpl_Factory implements Factory<SendUnityCrashFeatureImpl> {
    public final Provider<AnalyticsFeature> analyticsProvider;
    public final Provider<LoggerFeature> loggerProvider;
    public final Provider<UnityCrashDbServiceImpl> unityCrashDbServiceImplProvider;
    public final Provider<UnityCrashModule> unityCrashModuleProvider;

    public SendUnityCrashFeatureImpl_Factory(Provider<UnityCrashDbServiceImpl> provider, Provider<UnityCrashModule> provider2, Provider<LoggerFeature> provider3, Provider<AnalyticsFeature> provider4) {
        this.unityCrashDbServiceImplProvider = provider;
        this.unityCrashModuleProvider = provider2;
        this.loggerProvider = provider3;
        this.analyticsProvider = provider4;
    }

    public static SendUnityCrashFeatureImpl_Factory create(Provider<UnityCrashDbServiceImpl> provider, Provider<UnityCrashModule> provider2, Provider<LoggerFeature> provider3, Provider<AnalyticsFeature> provider4) {
        return new SendUnityCrashFeatureImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SendUnityCrashFeatureImpl newInstance(UnityCrashDbServiceImpl unityCrashDbServiceImpl, UnityCrashModule unityCrashModule, LoggerFeature loggerFeature, AnalyticsFeature analyticsFeature) {
        return new SendUnityCrashFeatureImpl(unityCrashDbServiceImpl, unityCrashModule, loggerFeature, analyticsFeature);
    }

    public SendUnityCrashFeatureImpl get() {
        return newInstance((UnityCrashDbServiceImpl) this.unityCrashDbServiceImplProvider.get(), (UnityCrashModule) this.unityCrashModuleProvider.get(), (LoggerFeature) this.loggerProvider.get(), (AnalyticsFeature) this.analyticsProvider.get());
    }
}
