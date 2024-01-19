package com.mpl.androidapp.cleanarch.main.presentation.vm;

import android.content.Context;
import com.mpl.androidapp.cleanarch.core.config.domain.ConfigZkFeatures;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.modules.UnityCrashModule;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.domain.feature.SendUnityCrashFeature;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class MPLReactContainerVm_Factory implements Factory<MPLReactContainerVm> {
    public final Provider<Context> appProvider;
    public final Provider<ConfigZkFeatures> configProvider;
    public final Provider<SendUnityCrashFeature> featuresProvider;
    public final Provider<UnityCrashModule> unityCrashModuleProvider;

    public MPLReactContainerVm_Factory(Provider<Context> provider, Provider<SendUnityCrashFeature> provider2, Provider<UnityCrashModule> provider3, Provider<ConfigZkFeatures> provider4) {
        this.appProvider = provider;
        this.featuresProvider = provider2;
        this.unityCrashModuleProvider = provider3;
        this.configProvider = provider4;
    }

    public static MPLReactContainerVm_Factory create(Provider<Context> provider, Provider<SendUnityCrashFeature> provider2, Provider<UnityCrashModule> provider3, Provider<ConfigZkFeatures> provider4) {
        return new MPLReactContainerVm_Factory(provider, provider2, provider3, provider4);
    }

    public static MPLReactContainerVm newInstance(Context context, SendUnityCrashFeature sendUnityCrashFeature, UnityCrashModule unityCrashModule, ConfigZkFeatures configZkFeatures) {
        return new MPLReactContainerVm(context, sendUnityCrashFeature, unityCrashModule, configZkFeatures);
    }

    public MPLReactContainerVm get() {
        return newInstance((Context) this.appProvider.get(), (SendUnityCrashFeature) this.featuresProvider.get(), (UnityCrashModule) this.unityCrashModuleProvider.get(), (ConfigZkFeatures) this.configProvider.get());
    }
}
