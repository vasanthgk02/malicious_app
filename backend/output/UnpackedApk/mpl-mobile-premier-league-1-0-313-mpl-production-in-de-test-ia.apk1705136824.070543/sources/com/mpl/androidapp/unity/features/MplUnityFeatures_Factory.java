package com.mpl.androidapp.unity.features;

import android.content.Context;
import com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature;
import com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature;
import com.mpl.androidapp.unity.usecases.CreateUnityScreenShotUseCase;
import com.mpl.androidapp.unity.usecases.LogCrashAnalyticsUseCase;
import com.mpl.androidapp.unity.usecases.SendEventForGamesUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class MplUnityFeatures_Factory implements Factory<MplUnityFeatures> {
    public final Provider<Context> contextProvider;
    public final Provider<CreateUnityScreenShotUseCase> createUnityScreenShotUseCaseProvider;
    public final Provider<GenericFileDownloadFeature> genericFileDownloadFeatureProvider;
    public final Provider<CoroutineDispatcher> ioDispatcherProvider;
    public final Provider<LogCrashAnalyticsUseCase> logCrashAnalyticsUseCaseProvider;
    public final Provider<NotificationUgcFeature> notificationUgcFeatureProvider;
    public final Provider<SendEventForGamesUseCase> sendEventForGamesUseCaseProvider;

    public MplUnityFeatures_Factory(Provider<Context> provider, Provider<GenericFileDownloadFeature> provider2, Provider<LogCrashAnalyticsUseCase> provider3, Provider<CreateUnityScreenShotUseCase> provider4, Provider<SendEventForGamesUseCase> provider5, Provider<NotificationUgcFeature> provider6, Provider<CoroutineDispatcher> provider7) {
        this.contextProvider = provider;
        this.genericFileDownloadFeatureProvider = provider2;
        this.logCrashAnalyticsUseCaseProvider = provider3;
        this.createUnityScreenShotUseCaseProvider = provider4;
        this.sendEventForGamesUseCaseProvider = provider5;
        this.notificationUgcFeatureProvider = provider6;
        this.ioDispatcherProvider = provider7;
    }

    public static MplUnityFeatures_Factory create(Provider<Context> provider, Provider<GenericFileDownloadFeature> provider2, Provider<LogCrashAnalyticsUseCase> provider3, Provider<CreateUnityScreenShotUseCase> provider4, Provider<SendEventForGamesUseCase> provider5, Provider<NotificationUgcFeature> provider6, Provider<CoroutineDispatcher> provider7) {
        MplUnityFeatures_Factory mplUnityFeatures_Factory = new MplUnityFeatures_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
        return mplUnityFeatures_Factory;
    }

    public static MplUnityFeatures newInstance(Context context, GenericFileDownloadFeature genericFileDownloadFeature, LogCrashAnalyticsUseCase logCrashAnalyticsUseCase, CreateUnityScreenShotUseCase createUnityScreenShotUseCase, SendEventForGamesUseCase sendEventForGamesUseCase, NotificationUgcFeature notificationUgcFeature, CoroutineDispatcher coroutineDispatcher) {
        MplUnityFeatures mplUnityFeatures = new MplUnityFeatures(context, genericFileDownloadFeature, logCrashAnalyticsUseCase, createUnityScreenShotUseCase, sendEventForGamesUseCase, notificationUgcFeature, coroutineDispatcher);
        return mplUnityFeatures;
    }

    public MplUnityFeatures get() {
        return newInstance((Context) this.contextProvider.get(), (GenericFileDownloadFeature) this.genericFileDownloadFeatureProvider.get(), (LogCrashAnalyticsUseCase) this.logCrashAnalyticsUseCaseProvider.get(), (CreateUnityScreenShotUseCase) this.createUnityScreenShotUseCaseProvider.get(), (SendEventForGamesUseCase) this.sendEventForGamesUseCaseProvider.get(), (NotificationUgcFeature) this.notificationUgcFeatureProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }
}
