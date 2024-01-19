package com.mpl.androidapp.updater.downloadmanager;

import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitCheckUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitDeleteUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitInsertUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitUpdateUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class DownloadNotificationDisplayFeature_Factory implements Factory<DownloadNotificationDisplayFeature> {
    public final Provider<CoroutineDispatcher> ioDispatcherProvider;
    public final Provider<OptionalDownloadVisitCheckUseCase> optionalDownloadVisitCheckUseCaseProvider;
    public final Provider<OptionalDownloadVisitDeleteUseCase> optionalDownloadVisitDeleteUseCaseProvider;
    public final Provider<OptionalDownloadVisitInsertUseCase> optionalDownloadVisitInsertUseCaseProvider;
    public final Provider<OptionalDownloadVisitUpdateUseCase> optionalDownloadVisitUpdateUseCaseProvider;

    public DownloadNotificationDisplayFeature_Factory(Provider<CoroutineDispatcher> provider, Provider<OptionalDownloadVisitInsertUseCase> provider2, Provider<OptionalDownloadVisitUpdateUseCase> provider3, Provider<OptionalDownloadVisitCheckUseCase> provider4, Provider<OptionalDownloadVisitDeleteUseCase> provider5) {
        this.ioDispatcherProvider = provider;
        this.optionalDownloadVisitInsertUseCaseProvider = provider2;
        this.optionalDownloadVisitUpdateUseCaseProvider = provider3;
        this.optionalDownloadVisitCheckUseCaseProvider = provider4;
        this.optionalDownloadVisitDeleteUseCaseProvider = provider5;
    }

    public static DownloadNotificationDisplayFeature_Factory create(Provider<CoroutineDispatcher> provider, Provider<OptionalDownloadVisitInsertUseCase> provider2, Provider<OptionalDownloadVisitUpdateUseCase> provider3, Provider<OptionalDownloadVisitCheckUseCase> provider4, Provider<OptionalDownloadVisitDeleteUseCase> provider5) {
        DownloadNotificationDisplayFeature_Factory downloadNotificationDisplayFeature_Factory = new DownloadNotificationDisplayFeature_Factory(provider, provider2, provider3, provider4, provider5);
        return downloadNotificationDisplayFeature_Factory;
    }

    public static DownloadNotificationDisplayFeature newInstance(CoroutineDispatcher coroutineDispatcher, OptionalDownloadVisitInsertUseCase optionalDownloadVisitInsertUseCase, OptionalDownloadVisitUpdateUseCase optionalDownloadVisitUpdateUseCase, OptionalDownloadVisitCheckUseCase optionalDownloadVisitCheckUseCase, OptionalDownloadVisitDeleteUseCase optionalDownloadVisitDeleteUseCase) {
        DownloadNotificationDisplayFeature downloadNotificationDisplayFeature = new DownloadNotificationDisplayFeature(coroutineDispatcher, optionalDownloadVisitInsertUseCase, optionalDownloadVisitUpdateUseCase, optionalDownloadVisitCheckUseCase, optionalDownloadVisitDeleteUseCase);
        return downloadNotificationDisplayFeature;
    }

    public DownloadNotificationDisplayFeature get() {
        return newInstance((CoroutineDispatcher) this.ioDispatcherProvider.get(), (OptionalDownloadVisitInsertUseCase) this.optionalDownloadVisitInsertUseCaseProvider.get(), (OptionalDownloadVisitUpdateUseCase) this.optionalDownloadVisitUpdateUseCaseProvider.get(), (OptionalDownloadVisitCheckUseCase) this.optionalDownloadVisitCheckUseCaseProvider.get(), (OptionalDownloadVisitDeleteUseCase) this.optionalDownloadVisitDeleteUseCaseProvider.get());
    }
}
