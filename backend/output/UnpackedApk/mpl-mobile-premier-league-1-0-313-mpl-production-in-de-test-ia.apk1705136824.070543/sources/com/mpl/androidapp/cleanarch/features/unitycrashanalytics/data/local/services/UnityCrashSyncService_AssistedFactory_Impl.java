package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

public final class UnityCrashSyncService_AssistedFactory_Impl implements UnityCrashSyncService_AssistedFactory {
    public final UnityCrashSyncService_Factory delegateFactory;

    public UnityCrashSyncService_AssistedFactory_Impl(UnityCrashSyncService_Factory unityCrashSyncService_Factory) {
        this.delegateFactory = unityCrashSyncService_Factory;
    }

    public UnityCrashSyncService create(Context context, WorkerParameters workerParameters) {
        return this.delegateFactory.get(context, workerParameters);
    }

    public static Provider<UnityCrashSyncService_AssistedFactory> create(UnityCrashSyncService_Factory unityCrashSyncService_Factory) {
        return InstanceFactory.create(new UnityCrashSyncService_AssistedFactory_Impl(unityCrashSyncService_Factory));
    }
}
