package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

public final class DownloadProgressWorker_AssistedFactory_Impl implements DownloadProgressWorker_AssistedFactory {
    public final DownloadProgressWorker_Factory delegateFactory;

    public DownloadProgressWorker_AssistedFactory_Impl(DownloadProgressWorker_Factory downloadProgressWorker_Factory) {
        this.delegateFactory = downloadProgressWorker_Factory;
    }

    public DownloadProgressWorker create(Context context, WorkerParameters workerParameters) {
        return this.delegateFactory.get(context, workerParameters);
    }

    public static Provider<DownloadProgressWorker_AssistedFactory> create(DownloadProgressWorker_Factory downloadProgressWorker_Factory) {
        return InstanceFactory.create(new DownloadProgressWorker_AssistedFactory_Impl(downloadProgressWorker_Factory));
    }
}
