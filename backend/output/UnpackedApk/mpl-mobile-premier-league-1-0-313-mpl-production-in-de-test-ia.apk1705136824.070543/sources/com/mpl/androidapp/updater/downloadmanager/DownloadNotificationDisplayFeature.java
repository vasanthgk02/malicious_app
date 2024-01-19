package com.mpl.androidapp.updater.downloadmanager;

import com.mpl.androidapp.notification.ApkDownloadNotificationData;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.ErrorState;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.InitialState;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitCheckUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitDeleteUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitInsertUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitUpdateUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dJ \u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\u000e\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010%\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#J\u000e\u0010&\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010'\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eJ\u0019\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010+R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/DownloadNotificationDisplayFeature;", "Lkotlinx/coroutines/CoroutineScope;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "optionalDownloadVisitInsertUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitInsertUseCase;", "optionalDownloadVisitUpdateUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitUpdateUseCase;", "optionalDownloadVisitCheckUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitCheckUseCase;", "optionalDownloadVisitDeleteUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitDeleteUseCase;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitInsertUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitUpdateUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitCheckUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitDeleteUseCase;)V", "callback", "Lcom/mpl/androidapp/updater/downloadmanager/DownloadNotificationDisplayFeatureCallback;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "queryDownloadState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "checkIfNotificationToBeDisplayed", "", "gameId", "", "apkDownloadNotificationData", "Lcom/mpl/androidapp/notification/ApkDownloadNotificationData;", "progress", "", "checkNotificationBeDisplayed", "cleanUp", "deleteFeature", "performInsert", "downloadId", "", "performUpdate", "runInsertFeature", "runUpdateFeature", "setPlayersListScrolledCallback", "useCaseError", "result", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;", "(Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadNotificationDisplayFeature.kt */
public final class DownloadNotificationDisplayFeature implements CoroutineScope {
    public DownloadNotificationDisplayFeatureCallback callback;
    public final CoroutineDispatcher ioDispatcher;
    public final OptionalDownloadVisitCheckUseCase optionalDownloadVisitCheckUseCase;
    public final OptionalDownloadVisitDeleteUseCase optionalDownloadVisitDeleteUseCase;
    public final OptionalDownloadVisitInsertUseCase optionalDownloadVisitInsertUseCase;
    public final OptionalDownloadVisitUpdateUseCase optionalDownloadVisitUpdateUseCase;
    public MutableStateFlow<QueryDownloadStates> queryDownloadState = StateFlowKt.MutableStateFlow(InitialState.INSTANCE);

    public DownloadNotificationDisplayFeature(@IoDispatcher CoroutineDispatcher coroutineDispatcher, OptionalDownloadVisitInsertUseCase optionalDownloadVisitInsertUseCase2, OptionalDownloadVisitUpdateUseCase optionalDownloadVisitUpdateUseCase2, OptionalDownloadVisitCheckUseCase optionalDownloadVisitCheckUseCase2, OptionalDownloadVisitDeleteUseCase optionalDownloadVisitDeleteUseCase2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(optionalDownloadVisitInsertUseCase2, "optionalDownloadVisitInsertUseCase");
        Intrinsics.checkNotNullParameter(optionalDownloadVisitUpdateUseCase2, "optionalDownloadVisitUpdateUseCase");
        Intrinsics.checkNotNullParameter(optionalDownloadVisitCheckUseCase2, "optionalDownloadVisitCheckUseCase");
        Intrinsics.checkNotNullParameter(optionalDownloadVisitDeleteUseCase2, "optionalDownloadVisitDeleteUseCase");
        this.ioDispatcher = coroutineDispatcher;
        this.optionalDownloadVisitInsertUseCase = optionalDownloadVisitInsertUseCase2;
        this.optionalDownloadVisitUpdateUseCase = optionalDownloadVisitUpdateUseCase2;
        this.optionalDownloadVisitCheckUseCase = optionalDownloadVisitCheckUseCase2;
        this.optionalDownloadVisitDeleteUseCase = optionalDownloadVisitDeleteUseCase2;
    }

    private final void checkNotificationBeDisplayed(String str, ApkDownloadNotificationData apkDownloadNotificationData, int i) {
        CoroutineScope CoroutineScope = TypeUtilsKt.CoroutineScope(Dispatchers.IO);
        DownloadNotificationDisplayFeature$checkNotificationBeDisplayed$1 downloadNotificationDisplayFeature$checkNotificationBeDisplayed$1 = new DownloadNotificationDisplayFeature$checkNotificationBeDisplayed$1(this, str, apkDownloadNotificationData, i, null);
        TypeUtilsKt.launch$default(CoroutineScope, null, null, downloadNotificationDisplayFeature$checkNotificationBeDisplayed$1, 3, null);
    }

    /* access modifiers changed from: private */
    public final void cleanUp() {
        TypeUtilsKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    private final void performInsert(String str, long j) {
        CoroutineScope CoroutineScope = TypeUtilsKt.CoroutineScope(Dispatchers.IO);
        DownloadNotificationDisplayFeature$performInsert$1 downloadNotificationDisplayFeature$performInsert$1 = new DownloadNotificationDisplayFeature$performInsert$1(str, j, this, null);
        TypeUtilsKt.launch$default(CoroutineScope, null, null, downloadNotificationDisplayFeature$performInsert$1, 3, null);
    }

    private final void performUpdate(String str) {
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.IO), null, null, new DownloadNotificationDisplayFeature$performUpdate$1(this, str, null), 3, null);
    }

    /* access modifiers changed from: private */
    public final Object useCaseError(Error error, Continuation<? super Unit> continuation) {
        this.queryDownloadState.setValue(new ErrorState(String.valueOf(error.getException().getMessage())));
        return Unit.INSTANCE;
    }

    public final void checkIfNotificationToBeDisplayed(String str, ApkDownloadNotificationData apkDownloadNotificationData, DownloadNotificationDisplayFeatureCallback downloadNotificationDisplayFeatureCallback, int i) {
        Intrinsics.checkNotNullParameter(str, "gameId");
        Intrinsics.checkNotNullParameter(apkDownloadNotificationData, "apkDownloadNotificationData");
        Intrinsics.checkNotNullParameter(downloadNotificationDisplayFeatureCallback, "callback");
        this.callback = downloadNotificationDisplayFeatureCallback;
        checkNotificationBeDisplayed(str, apkDownloadNotificationData, i);
    }

    public final void deleteFeature(String str) {
        Intrinsics.checkNotNullParameter(str, "gameId");
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.IO), null, null, new DownloadNotificationDisplayFeature$deleteFeature$1(this, str, null), 3, null);
    }

    public CoroutineContext getCoroutineContext() {
        return DefaultImpls.plus((JobSupport) TypeUtilsKt.SupervisorJob$default(null, 1), this.ioDispatcher);
    }

    public final void runInsertFeature(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "gameId");
        performInsert(str, j);
    }

    public final void runUpdateFeature(String str) {
        Intrinsics.checkNotNullParameter(str, "gameId");
        performUpdate(str);
    }

    public final void setPlayersListScrolledCallback(DownloadNotificationDisplayFeatureCallback downloadNotificationDisplayFeatureCallback) {
        Intrinsics.checkNotNullParameter(downloadNotificationDisplayFeatureCallback, "callback");
        this.callback = downloadNotificationDisplayFeatureCallback;
    }
}
