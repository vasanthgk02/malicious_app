package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services;

import androidx.hilt.work.WorkerAssistedFactory;
import androidx.work.ListenableWorker;

public interface UnityCrashSyncService_HiltModule {
    WorkerAssistedFactory<? extends ListenableWorker> bind(UnityCrashSyncService_AssistedFactory unityCrashSyncService_AssistedFactory);
}
