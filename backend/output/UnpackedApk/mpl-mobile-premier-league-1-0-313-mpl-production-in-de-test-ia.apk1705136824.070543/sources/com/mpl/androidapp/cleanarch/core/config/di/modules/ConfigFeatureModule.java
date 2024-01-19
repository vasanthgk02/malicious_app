package com.mpl.androidapp.cleanarch.core.config.di.modules;

import com.mpl.androidapp.cleanarch.core.config.data.ConfigManagerFeatureImpl;
import com.mpl.androidapp.cleanarch.core.config.domain.ConfigManagerFeature;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/mpl/androidapp/cleanarch/core/config/di/modules/ConfigFeatureModule;", "", "bindConfigManagerFeature", "Lcom/mpl/androidapp/cleanarch/core/config/domain/ConfigManagerFeature;", "implementation", "Lcom/mpl/androidapp/cleanarch/core/config/data/ConfigManagerFeatureImpl;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfigFeatureModule.kt */
public interface ConfigFeatureModule {
    ConfigManagerFeature bindConfigManagerFeature(ConfigManagerFeatureImpl configManagerFeatureImpl);
}
