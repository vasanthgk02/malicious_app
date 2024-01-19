package com.mpl.androidapp.unity.features;

import android.content.Context;
import android.content.Intent;
import com.mpl.androidapp.ScreenshotShareActivity;
import com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature;
import com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature.GenericFileDownloadFeatureCallback;
import com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput;
import com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature;
import com.mpl.androidapp.notification.models.FeatureUgcInput;
import com.mpl.androidapp.unity.models.CrashParams;
import com.mpl.androidapp.unity.models.UnityScreenShotParams;
import com.mpl.androidapp.unity.models.UnitySendEventGameParams;
import com.mpl.androidapp.unity.states.MPLUnityFeaturesState;
import com.mpl.androidapp.unity.states.MPLUnityFeaturesState.ErrorState;
import com.mpl.androidapp.unity.states.MPLUnityFeaturesState.InitialState;
import com.mpl.androidapp.unity.usecases.CreateUnityScreenShotUseCase;
import com.mpl.androidapp.unity.usecases.LogCrashAnalyticsUseCase;
import com.mpl.androidapp.unity.usecases.SendEventForGamesUseCase;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.GameConstant;
import com.mpl.androidapp.utils.MLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BC\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0019\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0016\u0010\u0004\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0019\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,J\u0019\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00102J\u000e\u00103\u001a\u00020\u001f2\u0006\u00100\u001a\u000201J\u0010\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u000206H\u0002J\u000e\u00107\u001a\u00020\u001f2\u0006\u00105\u001a\u000206J\u0018\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020;H\u0002J\u0019\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020>H@ø\u0001\u0000¢\u0006\u0002\u0010?R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, d2 = {"Lcom/mpl/androidapp/unity/features/MplUnityFeatures;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Landroid/content/Context;", "genericFileDownloadFeature", "Lcom/mpl/androidapp/filehandling/downloadservice/features/GenericFileDownloadFeature;", "logCrashAnalyticsUseCase", "Lcom/mpl/androidapp/unity/usecases/LogCrashAnalyticsUseCase;", "createUnityScreenShotUseCase", "Lcom/mpl/androidapp/unity/usecases/CreateUnityScreenShotUseCase;", "sendEventForGamesUseCase", "Lcom/mpl/androidapp/unity/usecases/SendEventForGamesUseCase;", "notificationUgcFeature", "Lcom/mpl/androidapp/notification/features/implementations/NotificationUgcFeature;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/mpl/androidapp/filehandling/downloadservice/features/GenericFileDownloadFeature;Lcom/mpl/androidapp/unity/usecases/LogCrashAnalyticsUseCase;Lcom/mpl/androidapp/unity/usecases/CreateUnityScreenShotUseCase;Lcom/mpl/androidapp/unity/usecases/SendEventForGamesUseCase;Lcom/mpl/androidapp/notification/features/implementations/NotificationUgcFeature;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "mPLUnityFeaturesState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState;", "cleanUp", "", "createScreenShotFile", "unityScreenShotParams", "Lcom/mpl/androidapp/unity/models/UnityScreenShotParams;", "(Lcom/mpl/androidapp/unity/models/UnityScreenShotParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createScreenShotFileFeature", "genericFileDownload", "featureFileDownloadInput", "Lcom/mpl/androidapp/filehandling/downloadservice/models/FeatureFileDownloadInput;", "view", "Lcom/mpl/androidapp/filehandling/downloadservice/features/GenericFileDownloadFeature$GenericFileDownloadFeatureCallback;", "logCrashIntoCrashlytics", "crashParams", "Lcom/mpl/androidapp/unity/models/CrashParams;", "(Lcom/mpl/androidapp/unity/models/CrashParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logCrashIntoCrashlyticsFeature", "sendEventForGames", "unitySendEventGameParams", "Lcom/mpl/androidapp/unity/models/UnitySendEventGameParams;", "(Lcom/mpl/androidapp/unity/models/UnitySendEventGameParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendEventForGamesFeature", "sendNotificationForUgc", "featureUgcInput", "Lcom/mpl/androidapp/notification/models/FeatureUgcInput;", "sendNotificationForUgcFeature", "startScreenShotScreen", "value", "fileLink", "", "useCaseError", "result", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;", "(Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MplUnityFeatures.kt */
public final class MplUnityFeatures implements CoroutineScope {
    public Context context;
    public final CreateUnityScreenShotUseCase createUnityScreenShotUseCase;
    public final CoroutineExceptionHandler exceptionHandler = new MplUnityFeatures$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    public final GenericFileDownloadFeature genericFileDownloadFeature;
    public final CoroutineDispatcher ioDispatcher;
    public final LogCrashAnalyticsUseCase logCrashAnalyticsUseCase;
    public MutableStateFlow<MPLUnityFeaturesState> mPLUnityFeaturesState = StateFlowKt.MutableStateFlow(InitialState.INSTANCE);
    public final NotificationUgcFeature notificationUgcFeature;
    public final SendEventForGamesUseCase sendEventForGamesUseCase;

    public MplUnityFeatures(Context context2, GenericFileDownloadFeature genericFileDownloadFeature2, LogCrashAnalyticsUseCase logCrashAnalyticsUseCase2, CreateUnityScreenShotUseCase createUnityScreenShotUseCase2, SendEventForGamesUseCase sendEventForGamesUseCase2, NotificationUgcFeature notificationUgcFeature2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(genericFileDownloadFeature2, "genericFileDownloadFeature");
        Intrinsics.checkNotNullParameter(logCrashAnalyticsUseCase2, "logCrashAnalyticsUseCase");
        Intrinsics.checkNotNullParameter(createUnityScreenShotUseCase2, "createUnityScreenShotUseCase");
        Intrinsics.checkNotNullParameter(sendEventForGamesUseCase2, "sendEventForGamesUseCase");
        Intrinsics.checkNotNullParameter(notificationUgcFeature2, "notificationUgcFeature");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.context = context2;
        this.genericFileDownloadFeature = genericFileDownloadFeature2;
        this.logCrashAnalyticsUseCase = logCrashAnalyticsUseCase2;
        this.createUnityScreenShotUseCase = createUnityScreenShotUseCase2;
        this.sendEventForGamesUseCase = sendEventForGamesUseCase2;
        this.notificationUgcFeature = notificationUgcFeature2;
        this.ioDispatcher = coroutineDispatcher;
    }

    private final void cleanUp() {
        TypeUtilsKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createScreenShotFile(com.mpl.androidapp.unity.models.UnityScreenShotParams r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.mpl.androidapp.unity.features.MplUnityFeatures$createScreenShotFile$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.mpl.androidapp.unity.features.MplUnityFeatures$createScreenShotFile$1 r0 = (com.mpl.androidapp.unity.features.MplUnityFeatures$createScreenShotFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.unity.features.MplUnityFeatures$createScreenShotFile$1 r0 = new com.mpl.androidapp.unity.features.MplUnityFeatures$createScreenShotFile$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x008b
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            java.lang.Object r6 = r0.L$1
            com.mpl.androidapp.unity.models.UnityScreenShotParams r6 = (com.mpl.androidapp.unity.models.UnityScreenShotParams) r6
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.unity.features.MplUnityFeatures r2 = (com.mpl.androidapp.unity.features.MplUnityFeatures) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x0051
        L_0x003e:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            com.mpl.androidapp.unity.usecases.CreateUnityScreenShotUseCase r7 = r5.createUnityScreenShotUseCase
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.invoke(r6, r0)
            if (r7 != r1) goto L_0x0050
            return r1
        L_0x0050:
            r2 = r5
        L_0x0051:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            boolean r4 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r4 == 0) goto L_0x0077
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r7
            java.lang.Object r7 = r7.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            java.lang.Object r7 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r7)
            com.mpl.androidapp.unity.states.MPLUnityFeaturesState r7 = (com.mpl.androidapp.unity.states.MPLUnityFeaturesState) r7
            if (r7 != 0) goto L_0x0068
            goto L_0x008e
        L_0x0068:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.unity.states.MPLUnityFeaturesState> r0 = r2.mPLUnityFeaturesState
            r0.setValue(r7)
            com.mpl.androidapp.unity.states.MPLUnityFeaturesState$UnityScreenSnapshotSuccess r7 = (com.mpl.androidapp.unity.states.MPLUnityFeaturesState.UnityScreenSnapshotSuccess) r7
            java.lang.String r7 = r7.getFileLink()
            r2.startScreenShotScreen(r6, r7)
            goto L_0x008e
        L_0x0077:
            boolean r6 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r6 == 0) goto L_0x008e
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r7
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r6 = r2.useCaseError(r7, r0)
            if (r6 != r1) goto L_0x008b
            return r1
        L_0x008b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x008e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.unity.features.MplUnityFeatures.createScreenShotFile(com.mpl.androidapp.unity.models.UnityScreenShotParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void genericFileDownload(FeatureFileDownloadInput featureFileDownloadInput, GenericFileDownloadFeatureCallback genericFileDownloadFeatureCallback) {
        this.genericFileDownloadFeature.runFeature(featureFileDownloadInput, genericFileDownloadFeatureCallback);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object logCrashIntoCrashlytics(com.mpl.androidapp.unity.models.CrashParams r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.mpl.androidapp.unity.features.MplUnityFeatures$logCrashIntoCrashlytics$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.mpl.androidapp.unity.features.MplUnityFeatures$logCrashIntoCrashlytics$1 r0 = (com.mpl.androidapp.unity.features.MplUnityFeatures$logCrashIntoCrashlytics$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.unity.features.MplUnityFeatures$logCrashIntoCrashlytics$1 r0 = new com.mpl.androidapp.unity.features.MplUnityFeatures$logCrashIntoCrashlytics$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x007a
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            java.lang.Object r6 = r0.L$0
            com.mpl.androidapp.unity.features.MplUnityFeatures r6 = (com.mpl.androidapp.unity.features.MplUnityFeatures) r6
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x004b
        L_0x003a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            com.mpl.androidapp.unity.usecases.LogCrashAnalyticsUseCase r7 = r5.logCrashAnalyticsUseCase
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r7.invoke(r6, r0)
            if (r7 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r6 = r5
        L_0x004b:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            boolean r2 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r2 == 0) goto L_0x0068
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r7
            java.lang.Object r7 = r7.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            java.lang.Object r7 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r7)
            com.mpl.androidapp.unity.states.MPLUnityFeaturesState r7 = (com.mpl.androidapp.unity.states.MPLUnityFeaturesState) r7
            if (r7 != 0) goto L_0x0062
            goto L_0x007d
        L_0x0062:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.unity.states.MPLUnityFeaturesState> r6 = r6.mPLUnityFeaturesState
            r6.setValue(r7)
            goto L_0x007d
        L_0x0068:
            boolean r2 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r2 == 0) goto L_0x007d
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r7
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.useCaseError(r7, r0)
            if (r6 != r1) goto L_0x007a
            return r1
        L_0x007a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x007d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.unity.features.MplUnityFeatures.logCrashIntoCrashlytics(com.mpl.androidapp.unity.models.CrashParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendEventForGames(com.mpl.androidapp.unity.models.UnitySendEventGameParams r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.mpl.androidapp.unity.features.MplUnityFeatures$sendEventForGames$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.mpl.androidapp.unity.features.MplUnityFeatures$sendEventForGames$1 r0 = (com.mpl.androidapp.unity.features.MplUnityFeatures$sendEventForGames$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.unity.features.MplUnityFeatures$sendEventForGames$1 r0 = new com.mpl.androidapp.unity.features.MplUnityFeatures$sendEventForGames$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x007a
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            java.lang.Object r6 = r0.L$0
            com.mpl.androidapp.unity.features.MplUnityFeatures r6 = (com.mpl.androidapp.unity.features.MplUnityFeatures) r6
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x004b
        L_0x003a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            com.mpl.androidapp.unity.usecases.SendEventForGamesUseCase r7 = r5.sendEventForGamesUseCase
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r7.invoke(r6, r0)
            if (r7 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r6 = r5
        L_0x004b:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            boolean r2 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r2 == 0) goto L_0x0068
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r7
            java.lang.Object r7 = r7.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            java.lang.Object r7 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r7)
            com.mpl.androidapp.unity.states.MPLUnityFeaturesState r7 = (com.mpl.androidapp.unity.states.MPLUnityFeaturesState) r7
            if (r7 != 0) goto L_0x0062
            goto L_0x007d
        L_0x0062:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.unity.states.MPLUnityFeaturesState> r6 = r6.mPLUnityFeaturesState
            r6.setValue(r7)
            goto L_0x007d
        L_0x0068:
            boolean r2 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r2 == 0) goto L_0x007d
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r7
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.useCaseError(r7, r0)
            if (r6 != r1) goto L_0x007a
            return r1
        L_0x007a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x007d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.unity.features.MplUnityFeatures.sendEventForGames(com.mpl.androidapp.unity.models.UnitySendEventGameParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void sendNotificationForUgc(FeatureUgcInput featureUgcInput) {
        this.notificationUgcFeature.runFeature(featureUgcInput);
    }

    private final void startScreenShotScreen(UnityScreenShotParams unityScreenShotParams, String str) {
        Intent intent = new Intent(unityScreenShotParams.getActivity(), ScreenshotShareActivity.class);
        intent.putExtra(Constant.SHARE_SCREEN_NAME, unityScreenShotParams.getScreenName());
        intent.putExtra(Constant.SHARE_GAME_NAME, unityScreenShotParams.getGameName());
        intent.putExtra(GameConstant.GAME_IS_SCREEN_SHARE_UI_DISABLED, unityScreenShotParams.isScreenshotUiDisabled());
        intent.putExtra(GameConstant.GAME_IS_SCREEN_SHARE_OPTION, unityScreenShotParams.isScreenShotOptions());
        intent.putExtra("shouldCloseScreen", true);
        intent.putExtra(Constant.SHARE_IMAGE_PATH, str);
        intent.addFlags(65536);
        unityScreenShotParams.getActivity().startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final Object useCaseError(Error error, Continuation<? super Unit> continuation) {
        String valueOf = String.valueOf(error.getException().getMessage());
        this.mPLUnityFeaturesState.setValue(new ErrorState(valueOf));
        MLogger.e("GenericShare", Intrinsics.stringPlus("Error in share module:->", valueOf));
        return Unit.INSTANCE;
    }

    public final void createScreenShotFileFeature(UnityScreenShotParams unityScreenShotParams) {
        Intrinsics.checkNotNullParameter(unityScreenShotParams, "unityScreenShotParams");
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.IO), null, null, new MplUnityFeatures$createScreenShotFileFeature$1(this, unityScreenShotParams, null), 3, null);
    }

    public final void genericFileDownloadFeature(FeatureFileDownloadInput featureFileDownloadInput, GenericFileDownloadFeatureCallback genericFileDownloadFeatureCallback) {
        Intrinsics.checkNotNullParameter(featureFileDownloadInput, "featureFileDownloadInput");
        Intrinsics.checkNotNullParameter(genericFileDownloadFeatureCallback, "view");
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.IO), null, null, new MplUnityFeatures$genericFileDownloadFeature$1(this, featureFileDownloadInput, genericFileDownloadFeatureCallback, null), 3, null);
    }

    public final Context getContext() {
        return this.context;
    }

    public CoroutineContext getCoroutineContext() {
        return DefaultImpls.plus((JobSupport) TypeUtilsKt.SupervisorJob$default(null, 1), this.ioDispatcher).plus(this.exceptionHandler);
    }

    public final void logCrashIntoCrashlyticsFeature(CrashParams crashParams) {
        Intrinsics.checkNotNullParameter(crashParams, "crashParams");
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.IO), null, null, new MplUnityFeatures$logCrashIntoCrashlyticsFeature$1(this, crashParams, null), 3, null);
    }

    public final void sendEventForGamesFeature(UnitySendEventGameParams unitySendEventGameParams) {
        Intrinsics.checkNotNullParameter(unitySendEventGameParams, "unitySendEventGameParams");
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.IO), null, null, new MplUnityFeatures$sendEventForGamesFeature$1(this, unitySendEventGameParams, null), 3, null);
    }

    public final void sendNotificationForUgcFeature(FeatureUgcInput featureUgcInput) {
        Intrinsics.checkNotNullParameter(featureUgcInput, "featureUgcInput");
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.IO), null, null, new MplUnityFeatures$sendNotificationForUgcFeature$1(this, featureUgcInput, null), 3, null);
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }
}
