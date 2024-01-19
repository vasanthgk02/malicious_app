package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import android.content.Context;
import androidx.hilt.work.WorkerAssistedFactory;
import androidx.work.WorkerParameters;

public interface DownloadProgressWorker_AssistedFactory extends WorkerAssistedFactory<DownloadProgressWorker> {
    /* synthetic */ T create(Context context, WorkerParameters workerParameters);
}
