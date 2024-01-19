package com.mpl.androidapp.filehandling.downloadservice.usecases;

import android.app.DownloadManager;
import android.content.Context;
import com.mpl.androidapp.filehandling.downloadservice.utils.DownloadServiceCursorStatus;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class InitDownloadManagerUseCase_Factory implements Factory<InitDownloadManagerUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;
    public final Provider<DownloadManager> downloadManagerProvider;
    public final Provider<DownloadServiceCursorStatus> downloadServiceCursorStatusProvider;

    public InitDownloadManagerUseCase_Factory(Provider<Context> provider, Provider<DownloadManager> provider2, Provider<DownloadServiceCursorStatus> provider3, Provider<CoroutineDispatcher> provider4) {
        this.contextProvider = provider;
        this.downloadManagerProvider = provider2;
        this.downloadServiceCursorStatusProvider = provider3;
        this.dispatcherProvider = provider4;
    }

    public static InitDownloadManagerUseCase_Factory create(Provider<Context> provider, Provider<DownloadManager> provider2, Provider<DownloadServiceCursorStatus> provider3, Provider<CoroutineDispatcher> provider4) {
        return new InitDownloadManagerUseCase_Factory(provider, provider2, provider3, provider4);
    }

    public static InitDownloadManagerUseCase newInstance(Context context, DownloadManager downloadManager, DownloadServiceCursorStatus downloadServiceCursorStatus, CoroutineDispatcher coroutineDispatcher) {
        return new InitDownloadManagerUseCase(context, downloadManager, downloadServiceCursorStatus, coroutineDispatcher);
    }

    public InitDownloadManagerUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (DownloadManager) this.downloadManagerProvider.get(), (DownloadServiceCursorStatus) this.downloadServiceCursorStatusProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
