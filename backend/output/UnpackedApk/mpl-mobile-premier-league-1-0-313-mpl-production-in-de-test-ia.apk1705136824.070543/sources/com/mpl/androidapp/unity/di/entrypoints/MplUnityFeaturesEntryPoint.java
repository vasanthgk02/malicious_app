package com.mpl.androidapp.unity.di.entrypoints;

import com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature;
import com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature;
import com.mpl.androidapp.unity.usecases.CreateUnityScreenShotUseCase;
import com.mpl.androidapp.unity.usecases.LogCrashAnalyticsUseCase;
import com.mpl.androidapp.unity.usecases.SendEventForGamesUseCase;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lcom/mpl/androidapp/unity/di/entrypoints/MplUnityFeaturesEntryPoint;", "", "CreateUnityScreenShotUseCase", "Lcom/mpl/androidapp/unity/usecases/CreateUnityScreenShotUseCase;", "GenericFileDownloadFeature", "Lcom/mpl/androidapp/filehandling/downloadservice/features/GenericFileDownloadFeature;", "LogCrashAnalyticsUseCase", "Lcom/mpl/androidapp/unity/usecases/LogCrashAnalyticsUseCase;", "NotificationUgcFeature", "Lcom/mpl/androidapp/notification/features/implementations/NotificationUgcFeature;", "SendEventForGamesUseCase", "Lcom/mpl/androidapp/unity/usecases/SendEventForGamesUseCase;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MplUnityFeaturesEntryPoint.kt */
public interface MplUnityFeaturesEntryPoint {
    CreateUnityScreenShotUseCase CreateUnityScreenShotUseCase();

    GenericFileDownloadFeature GenericFileDownloadFeature();

    LogCrashAnalyticsUseCase LogCrashAnalyticsUseCase();

    NotificationUgcFeature NotificationUgcFeature();

    SendEventForGamesUseCase SendEventForGamesUseCase();

    @IoDispatcher
    CoroutineDispatcher ioDispatcher();
}
