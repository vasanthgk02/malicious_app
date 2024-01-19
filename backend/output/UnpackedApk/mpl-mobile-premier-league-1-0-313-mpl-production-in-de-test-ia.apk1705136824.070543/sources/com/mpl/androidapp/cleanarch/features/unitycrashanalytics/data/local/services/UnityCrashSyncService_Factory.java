package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.domain.feature.SendUnityCrashFeature;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class UnityCrashSyncService_Factory {
    public final Provider<SendUnityCrashFeature> featuresProvider;
    public final Provider<CoroutineDispatcher> ioDispatcherProvider;

    public UnityCrashSyncService_Factory(Provider<CoroutineDispatcher> provider, Provider<SendUnityCrashFeature> provider2) {
        this.ioDispatcherProvider = provider;
        this.featuresProvider = provider2;
    }

    public static UnityCrashSyncService_Factory create(Provider<CoroutineDispatcher> provider, Provider<SendUnityCrashFeature> provider2) {
        return new UnityCrashSyncService_Factory(provider, provider2);
    }

    public static UnityCrashSyncService newInstance(Context context, WorkerParameters workerParameters, CoroutineDispatcher coroutineDispatcher, SendUnityCrashFeature sendUnityCrashFeature) {
        return new UnityCrashSyncService(context, workerParameters, coroutineDispatcher, sendUnityCrashFeature);
    }

    public UnityCrashSyncService get(Context context, WorkerParameters workerParameters) {
        return newInstance(context, workerParameters, (CoroutineDispatcher) this.ioDispatcherProvider.get(), (SendUnityCrashFeature) this.featuresProvider.get());
    }
}
