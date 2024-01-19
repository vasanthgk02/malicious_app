package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.google.gson.Gson;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class DownloadProgressWorker_Factory {
    public final Provider<Gson> gsonProvider;
    public final Provider<CoroutineDispatcher> ioDispatcherProvider;
    public final Provider<CoroutineDispatcher> mainDispatcherProvider;
    public final Provider<QueryDownload> queryDownloadProvider;

    public DownloadProgressWorker_Factory(Provider<Gson> provider, Provider<QueryDownload> provider2, Provider<CoroutineDispatcher> provider3, Provider<CoroutineDispatcher> provider4) {
        this.gsonProvider = provider;
        this.queryDownloadProvider = provider2;
        this.ioDispatcherProvider = provider3;
        this.mainDispatcherProvider = provider4;
    }

    public static DownloadProgressWorker_Factory create(Provider<Gson> provider, Provider<QueryDownload> provider2, Provider<CoroutineDispatcher> provider3, Provider<CoroutineDispatcher> provider4) {
        return new DownloadProgressWorker_Factory(provider, provider2, provider3, provider4);
    }

    public static DownloadProgressWorker newInstance(Context context, WorkerParameters workerParameters, Gson gson, QueryDownload queryDownload, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2) {
        DownloadProgressWorker downloadProgressWorker = new DownloadProgressWorker(context, workerParameters, gson, queryDownload, coroutineDispatcher, coroutineDispatcher2);
        return downloadProgressWorker;
    }

    public DownloadProgressWorker get(Context context, WorkerParameters workerParameters) {
        return newInstance(context, workerParameters, (Gson) this.gsonProvider.get(), (QueryDownload) this.queryDownloadProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get(), (CoroutineDispatcher) this.mainDispatcherProvider.get());
    }
}
