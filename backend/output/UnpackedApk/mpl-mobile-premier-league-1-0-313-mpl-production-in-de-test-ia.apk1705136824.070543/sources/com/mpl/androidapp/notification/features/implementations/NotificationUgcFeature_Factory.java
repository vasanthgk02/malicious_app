package com.mpl.androidapp.notification.features.implementations;

import android.content.Context;
import com.mpl.androidapp.notification.usecases.BuildLaunchIntentUseCase;
import com.mpl.androidapp.notification.usecases.BuildMplNotificationUseCase;
import com.mpl.androidapp.notification.usecases.IsAppIsInBackgroundUseCase;
import com.mpl.androidapp.notification.usecases.NotificationChannelUseCase;
import com.mpl.androidapp.notification.usecases.NotificationPriorityUseCase;
import com.mpl.androidapp.notification.usecases.NotificationSendEventUseCase;
import com.mpl.androidapp.notification.usecases.NotificationTimerUseCase;
import com.mpl.androidapp.notification.usecases.NotifyNotificationUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class NotificationUgcFeature_Factory implements Factory<NotificationUgcFeature> {
    public final Provider<BuildLaunchIntentUseCase> buildLaunchIntentUseCaseProvider;
    public final Provider<BuildMplNotificationUseCase> buildMplNotificationUseCaseProvider;
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> ioDispatcherProvider;
    public final Provider<IsAppIsInBackgroundUseCase> isAppIsInBackgroundUseCaseProvider;
    public final Provider<NotificationChannelUseCase> notificationChannelUseCaseProvider;
    public final Provider<NotificationPriorityUseCase> notificationPriorityUseCaseProvider;
    public final Provider<NotificationSendEventUseCase> notificationSendEventUseCaseProvider;
    public final Provider<NotificationTimerUseCase> notificationTimerUseCaseProvider;
    public final Provider<NotifyNotificationUseCase> notifyNotificationUseCaseProvider;

    public NotificationUgcFeature_Factory(Provider<NotificationChannelUseCase> provider, Provider<NotificationPriorityUseCase> provider2, Provider<BuildLaunchIntentUseCase> provider3, Provider<BuildMplNotificationUseCase> provider4, Provider<NotificationTimerUseCase> provider5, Provider<IsAppIsInBackgroundUseCase> provider6, Provider<NotifyNotificationUseCase> provider7, Provider<NotificationSendEventUseCase> provider8, Provider<Context> provider9, Provider<CoroutineDispatcher> provider10) {
        this.notificationChannelUseCaseProvider = provider;
        this.notificationPriorityUseCaseProvider = provider2;
        this.buildLaunchIntentUseCaseProvider = provider3;
        this.buildMplNotificationUseCaseProvider = provider4;
        this.notificationTimerUseCaseProvider = provider5;
        this.isAppIsInBackgroundUseCaseProvider = provider6;
        this.notifyNotificationUseCaseProvider = provider7;
        this.notificationSendEventUseCaseProvider = provider8;
        this.contextProvider = provider9;
        this.ioDispatcherProvider = provider10;
    }

    public static NotificationUgcFeature_Factory create(Provider<NotificationChannelUseCase> provider, Provider<NotificationPriorityUseCase> provider2, Provider<BuildLaunchIntentUseCase> provider3, Provider<BuildMplNotificationUseCase> provider4, Provider<NotificationTimerUseCase> provider5, Provider<IsAppIsInBackgroundUseCase> provider6, Provider<NotifyNotificationUseCase> provider7, Provider<NotificationSendEventUseCase> provider8, Provider<Context> provider9, Provider<CoroutineDispatcher> provider10) {
        NotificationUgcFeature_Factory notificationUgcFeature_Factory = new NotificationUgcFeature_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
        return notificationUgcFeature_Factory;
    }

    public static NotificationUgcFeature newInstance(NotificationChannelUseCase notificationChannelUseCase, NotificationPriorityUseCase notificationPriorityUseCase, BuildLaunchIntentUseCase buildLaunchIntentUseCase, BuildMplNotificationUseCase buildMplNotificationUseCase, NotificationTimerUseCase notificationTimerUseCase, IsAppIsInBackgroundUseCase isAppIsInBackgroundUseCase, NotifyNotificationUseCase notifyNotificationUseCase, NotificationSendEventUseCase notificationSendEventUseCase, Context context, CoroutineDispatcher coroutineDispatcher) {
        NotificationUgcFeature notificationUgcFeature = new NotificationUgcFeature(notificationChannelUseCase, notificationPriorityUseCase, buildLaunchIntentUseCase, buildMplNotificationUseCase, notificationTimerUseCase, isAppIsInBackgroundUseCase, notifyNotificationUseCase, notificationSendEventUseCase, context, coroutineDispatcher);
        return notificationUgcFeature;
    }

    public NotificationUgcFeature get() {
        return newInstance((NotificationChannelUseCase) this.notificationChannelUseCaseProvider.get(), (NotificationPriorityUseCase) this.notificationPriorityUseCaseProvider.get(), (BuildLaunchIntentUseCase) this.buildLaunchIntentUseCaseProvider.get(), (BuildMplNotificationUseCase) this.buildMplNotificationUseCaseProvider.get(), (NotificationTimerUseCase) this.notificationTimerUseCaseProvider.get(), (IsAppIsInBackgroundUseCase) this.isAppIsInBackgroundUseCaseProvider.get(), (NotifyNotificationUseCase) this.notifyNotificationUseCaseProvider.get(), (NotificationSendEventUseCase) this.notificationSendEventUseCaseProvider.get(), (Context) this.contextProvider.get(), (CoroutineDispatcher) this.ioDispatcherProvider.get());
    }
}
