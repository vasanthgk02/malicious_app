package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.di.modules;

import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.SendUnityCrashFeatureImpl;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.domain.feature.SendUnityCrashFeature;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/di/modules/FeatureModule;", "", "()V", "bindRepository", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/domain/feature/SendUnityCrashFeature;", "implementation", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/implementation/SendUnityCrashFeatureImpl;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeatureModule.kt */
public abstract class FeatureModule {
    public abstract SendUnityCrashFeature bindRepository(SendUnityCrashFeatureImpl sendUnityCrashFeatureImpl);
}
