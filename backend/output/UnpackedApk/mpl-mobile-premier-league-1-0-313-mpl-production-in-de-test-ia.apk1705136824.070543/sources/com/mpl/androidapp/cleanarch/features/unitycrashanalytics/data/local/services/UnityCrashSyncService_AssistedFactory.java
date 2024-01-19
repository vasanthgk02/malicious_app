package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services;

import android.content.Context;
import androidx.hilt.work.WorkerAssistedFactory;
import androidx.work.WorkerParameters;

public interface UnityCrashSyncService_AssistedFactory extends WorkerAssistedFactory<UnityCrashSyncService> {
    /* synthetic */ T create(Context context, WorkerParameters workerParameters);
}
