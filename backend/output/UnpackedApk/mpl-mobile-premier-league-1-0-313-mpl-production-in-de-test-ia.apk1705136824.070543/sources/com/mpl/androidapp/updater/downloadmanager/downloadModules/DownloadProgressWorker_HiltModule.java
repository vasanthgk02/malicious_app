package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import androidx.hilt.work.WorkerAssistedFactory;
import androidx.work.ListenableWorker;

public interface DownloadProgressWorker_HiltModule {
    WorkerAssistedFactory<? extends ListenableWorker> bind(DownloadProgressWorker_AssistedFactory downloadProgressWorker_AssistedFactory);
}
