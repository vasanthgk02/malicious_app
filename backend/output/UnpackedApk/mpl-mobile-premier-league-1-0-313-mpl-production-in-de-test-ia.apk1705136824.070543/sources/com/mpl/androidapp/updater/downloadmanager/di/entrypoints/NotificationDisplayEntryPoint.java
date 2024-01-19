package com.mpl.androidapp.updater.downloadmanager.di.entrypoints;

import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitCheckUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitDeleteUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitInsertUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitUpdateUseCase;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/di/entrypoints/NotificationDisplayEntryPoint;", "", "OptionalDownloadVisitUpdateUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitUpdateUseCase;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "optionalDownloadVisitCheckUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitCheckUseCase;", "optionalDownloadVisitDeleteUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitDeleteUseCase;", "optionalDownloadVisitInsertUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitInsertUseCase;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotificationDisplayEntryPoint.kt */
public interface NotificationDisplayEntryPoint {
    OptionalDownloadVisitUpdateUseCase OptionalDownloadVisitUpdateUseCase();

    @IoDispatcher
    CoroutineDispatcher ioDispatcher();

    OptionalDownloadVisitCheckUseCase optionalDownloadVisitCheckUseCase();

    OptionalDownloadVisitDeleteUseCase optionalDownloadVisitDeleteUseCase();

    OptionalDownloadVisitInsertUseCase optionalDownloadVisitInsertUseCase();
}
