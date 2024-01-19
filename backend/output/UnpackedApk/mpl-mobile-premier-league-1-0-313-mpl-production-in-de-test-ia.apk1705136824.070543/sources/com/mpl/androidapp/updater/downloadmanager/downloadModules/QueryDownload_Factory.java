package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import android.app.DownloadManager;
import android.content.Context;
import com.mpl.androidapp.updater.downloadmanager.usecases.CopyPokerAssetFileUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.DeleteAssetFileUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.ExtractAssetsUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.GetGameResourceUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadNotificationFlowCheckUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitCheckUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.PublishProgressUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.RemoveGameResourceUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.UpdateAssetsAnalyticsUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.DownloadManagerCursorStatus;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class QueryDownload_Factory implements Factory<QueryDownload> {
    public final Provider<Context> contextProvider;
    public final Provider<CopyPokerAssetFileUseCase> copyAssetUseCaseProvider;
    public final Provider<DeleteAssetFileUseCase> deleteAssetFileUseCaseProvider;
    public final Provider<DownloadManagerCursorStatus> downloadManagerCursorStatusProvider;
    public final Provider<DownloadManager> downloadManagerProvider;
    public final Provider<ExtractAssetsUseCase> extractAssetsUseCaseProvider;
    public final Provider<GetGameResourceUseCase> getGameResourceUseCaseProvider;
    public final Provider<CoroutineDispatcher> ioDispatcherProvider;
    public final Provider<OptionalDownloadNotificationFlowCheckUseCase> optionalDownloadNotificationFlowCheckUseCaseProvider;
    public final Provider<OptionalDownloadVisitCheckUseCase> optionalDownloadVisitCheckUseCaseProvider;
    public final Provider<PublishProgressUseCase> publishProgressUseCaseProvider;
    public final Provider<RemoveGameResourceUseCase> removeGameResourceUseCaseProvider;
    public final Provider<UpdateAssetsAnalyticsUseCase> updateAssetsAnalyticsUseCaseProvider;

    public QueryDownload_Factory(Provider<Context> provider, Provider<DownloadManager> provider2, Provider<DownloadManagerCursorStatus> provider3, Provider<CoroutineDispatcher> provider4, Provider<GetGameResourceUseCase> provider5, Provider<RemoveGameResourceUseCase> provider6, Provider<DeleteAssetFileUseCase> provider7, Provider<UpdateAssetsAnalyticsUseCase> provider8, Provider<PublishProgressUseCase> provider9, Provider<CopyPokerAssetFileUseCase> provider10, Provider<ExtractAssetsUseCase> provider11, Provider<OptionalDownloadVisitCheckUseCase> provider12, Provider<OptionalDownloadNotificationFlowCheckUseCase> provider13) {
        this.contextProvider = provider;
        this.downloadManagerProvider = provider2;
        this.downloadManagerCursorStatusProvider = provider3;
        this.ioDispatcherProvider = provider4;
        this.getGameResourceUseCaseProvider = provider5;
        this.removeGameResourceUseCaseProvider = provider6;
        this.deleteAssetFileUseCaseProvider = provider7;
        this.updateAssetsAnalyticsUseCaseProvider = provider8;
        this.publishProgressUseCaseProvider = provider9;
        this.copyAssetUseCaseProvider = provider10;
        this.extractAssetsUseCaseProvider = provider11;
        this.optionalDownloadVisitCheckUseCaseProvider = provider12;
        this.optionalDownloadNotificationFlowCheckUseCaseProvider = provider13;
    }

    public static QueryDownload_Factory create(Provider<Context> provider, Provider<DownloadManager> provider2, Provider<DownloadManagerCursorStatus> provider3, Provider<CoroutineDispatcher> provider4, Provider<GetGameResourceUseCase> provider5, Provider<RemoveGameResourceUseCase> provider6, Provider<DeleteAssetFileUseCase> provider7, Provider<UpdateAssetsAnalyticsUseCase> provider8, Provider<PublishProgressUseCase> provider9, Provider<CopyPokerAssetFileUseCase> provider10, Provider<ExtractAssetsUseCase> provider11, Provider<OptionalDownloadVisitCheckUseCase> provider12, Provider<OptionalDownloadNotificationFlowCheckUseCase> provider13) {
        QueryDownload_Factory queryDownload_Factory = new QueryDownload_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
        return queryDownload_Factory;
    }

    public static QueryDownload newInstance(Context context, DownloadManager downloadManager, DownloadManagerCursorStatus downloadManagerCursorStatus, CoroutineDispatcher coroutineDispatcher, GetGameResourceUseCase getGameResourceUseCase, RemoveGameResourceUseCase removeGameResourceUseCase, DeleteAssetFileUseCase deleteAssetFileUseCase, UpdateAssetsAnalyticsUseCase updateAssetsAnalyticsUseCase, PublishProgressUseCase publishProgressUseCase, CopyPokerAssetFileUseCase copyPokerAssetFileUseCase, ExtractAssetsUseCase extractAssetsUseCase, OptionalDownloadVisitCheckUseCase optionalDownloadVisitCheckUseCase, OptionalDownloadNotificationFlowCheckUseCase optionalDownloadNotificationFlowCheckUseCase) {
        QueryDownload queryDownload = new QueryDownload(context, downloadManager, downloadManagerCursorStatus, coroutineDispatcher, getGameResourceUseCase, removeGameResourceUseCase, deleteAssetFileUseCase, updateAssetsAnalyticsUseCase, publishProgressUseCase, copyPokerAssetFileUseCase, extractAssetsUseCase, optionalDownloadVisitCheckUseCase, optionalDownloadNotificationFlowCheckUseCase);
        return queryDownload;
    }

    public QueryDownload get() {
        return newInstance((Context) this.contextProvider.get(), (DownloadManager) this.downloadManagerProvider.get(), (DownloadManagerCursorStatus) this.downloadManagerCursorStatusProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get(), (GetGameResourceUseCase) this.getGameResourceUseCaseProvider.get(), (RemoveGameResourceUseCase) this.removeGameResourceUseCaseProvider.get(), (DeleteAssetFileUseCase) this.deleteAssetFileUseCaseProvider.get(), (UpdateAssetsAnalyticsUseCase) this.updateAssetsAnalyticsUseCaseProvider.get(), (PublishProgressUseCase) this.publishProgressUseCaseProvider.get(), (CopyPokerAssetFileUseCase) this.copyAssetUseCaseProvider.get(), (ExtractAssetsUseCase) this.extractAssetsUseCaseProvider.get(), (OptionalDownloadVisitCheckUseCase) this.optionalDownloadVisitCheckUseCaseProvider.get(), (OptionalDownloadNotificationFlowCheckUseCase) this.optionalDownloadNotificationFlowCheckUseCaseProvider.get());
    }
}
