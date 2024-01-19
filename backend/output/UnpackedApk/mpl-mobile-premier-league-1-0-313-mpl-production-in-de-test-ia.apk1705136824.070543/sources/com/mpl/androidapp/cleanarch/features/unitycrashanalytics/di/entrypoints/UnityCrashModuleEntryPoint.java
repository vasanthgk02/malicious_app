package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.di.entrypoints;

import com.mpl.androidapp.cleanarch.core.config.domain.ConfigZkFeatures;
import com.mpl.androidapp.cleanarch.core.logger.data.LoggerFeatureImpl;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.implementation.UnityCrashDbServiceImpl;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/di/entrypoints/UnityCrashModuleEntryPoint;", "", "configService", "Lcom/mpl/androidapp/cleanarch/core/config/domain/ConfigZkFeatures;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "loggerFeatureService", "Lcom/mpl/androidapp/cleanarch/core/logger/data/LoggerFeatureImpl;", "unityCrashImplService", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/implementation/UnityCrashDbServiceImpl;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityCrashModuleEntryPoint.kt */
public interface UnityCrashModuleEntryPoint {
    ConfigZkFeatures configService();

    @IoDispatcher
    CoroutineDispatcher ioDispatcher();

    LoggerFeatureImpl loggerFeatureService();

    UnityCrashDbServiceImpl unityCrashImplService();
}
