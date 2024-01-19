package com.mpl.androidapp.notification.features.implementations;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import com.mpl.androidapp.miniprofile.extensions.StringExtKt;
import com.mpl.androidapp.notification.features.NotificationFeatureNames;
import com.mpl.androidapp.notification.models.FeatureUgcInput;
import com.mpl.androidapp.notification.states.MPLNotificationStates;
import com.mpl.androidapp.notification.states.MPLNotificationStates.ErrorState;
import com.mpl.androidapp.notification.states.MPLNotificationStates.InitialState;
import com.mpl.androidapp.notification.usecases.BuildLaunchIntentUseCase;
import com.mpl.androidapp.notification.usecases.BuildMplNotificationUseCase;
import com.mpl.androidapp.notification.usecases.IsAppIsInBackgroundUseCase;
import com.mpl.androidapp.notification.usecases.NotificationChannelUseCase;
import com.mpl.androidapp.notification.usecases.NotificationPriorityUseCase;
import com.mpl.androidapp.notification.usecases.NotificationSendEventUseCase;
import com.mpl.androidapp.notification.usecases.NotificationTimerUseCase;
import com.mpl.androidapp.notification.usecases.NotifyNotificationUseCase;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.utils.MLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B[\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0011\u00100\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00102J\u0011\u00103\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00102J\u0011\u00104\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00102J\u0011\u00105\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00102J\u0011\u00106\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00102J\u0011\u00107\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00102J\b\u00108\u001a\u000201H\u0002J\u000e\u00109\u001a\u0002012\u0006\u0010#\u001a\u00020$J\u0019\u0010:\u001a\u0002012\u0006\u0010;\u001a\u00020/H@ø\u0001\u0000¢\u0006\u0002\u0010<J\u0011\u0010=\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00102J\u0019\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020@H@ø\u0001\u0000¢\u0006\u0002\u0010AR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lcom/mpl/androidapp/notification/features/implementations/NotificationUgcFeature;", "Lkotlinx/coroutines/CoroutineScope;", "notificationChannelUseCase", "Lcom/mpl/androidapp/notification/usecases/NotificationChannelUseCase;", "notificationPriorityUseCase", "Lcom/mpl/androidapp/notification/usecases/NotificationPriorityUseCase;", "buildLaunchIntentUseCase", "Lcom/mpl/androidapp/notification/usecases/BuildLaunchIntentUseCase;", "buildMplNotificationUseCase", "Lcom/mpl/androidapp/notification/usecases/BuildMplNotificationUseCase;", "notificationTimerUseCase", "Lcom/mpl/androidapp/notification/usecases/NotificationTimerUseCase;", "isAppIsInBackgroundUseCase", "Lcom/mpl/androidapp/notification/usecases/IsAppIsInBackgroundUseCase;", "notifyNotificationUseCase", "Lcom/mpl/androidapp/notification/usecases/NotifyNotificationUseCase;", "notificationSendEventUseCase", "Lcom/mpl/androidapp/notification/usecases/NotificationSendEventUseCase;", "context", "Landroid/content/Context;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/mpl/androidapp/notification/usecases/NotificationChannelUseCase;Lcom/mpl/androidapp/notification/usecases/NotificationPriorityUseCase;Lcom/mpl/androidapp/notification/usecases/BuildLaunchIntentUseCase;Lcom/mpl/androidapp/notification/usecases/BuildMplNotificationUseCase;Lcom/mpl/androidapp/notification/usecases/NotificationTimerUseCase;Lcom/mpl/androidapp/notification/usecases/IsAppIsInBackgroundUseCase;Lcom/mpl/androidapp/notification/usecases/NotifyNotificationUseCase;Lcom/mpl/androidapp/notification/usecases/NotificationSendEventUseCase;Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;)V", "channelId", "", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "input", "Lcom/mpl/androidapp/notification/models/FeatureUgcInput;", "intent", "Landroid/content/Intent;", "isMplInBackground", "", "mplNotificationStates", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mpl/androidapp/notification/states/MPLNotificationStates;", "notification", "Landroid/app/Notification;", "priority", "", "buildLaunchIntent", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildMPLNotification", "checkNotificationPriority", "determineNotificationChannel", "isAppInBackground", "notifyMplNotification", "onDestroyCoroutine", "runFeature", "sendEventForNotification", "notificationId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timerMpl", "useCaseError", "result", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;", "(Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotificationUgcFeature.kt */
public final class NotificationUgcFeature implements CoroutineScope {
    public final BuildLaunchIntentUseCase buildLaunchIntentUseCase;
    public final BuildMplNotificationUseCase buildMplNotificationUseCase;
    public String channelId = StringExtKt.getEMPTY(StringCompanionObject.INSTANCE);
    public Context context;
    public final CoroutineExceptionHandler exceptionHandler = new NotificationUgcFeature$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    public FeatureUgcInput input;
    public Intent intent;
    public final CoroutineDispatcher ioDispatcher;
    public final IsAppIsInBackgroundUseCase isAppIsInBackgroundUseCase;
    public boolean isMplInBackground = true;
    public MutableStateFlow<MPLNotificationStates> mplNotificationStates = StateFlowKt.MutableStateFlow(InitialState.INSTANCE);
    public Notification notification;
    public final NotificationChannelUseCase notificationChannelUseCase;
    public final NotificationPriorityUseCase notificationPriorityUseCase;
    public final NotificationSendEventUseCase notificationSendEventUseCase;
    public final NotificationTimerUseCase notificationTimerUseCase;
    public final NotifyNotificationUseCase notifyNotificationUseCase;
    public int priority = -2;

    public NotificationUgcFeature(NotificationChannelUseCase notificationChannelUseCase2, NotificationPriorityUseCase notificationPriorityUseCase2, BuildLaunchIntentUseCase buildLaunchIntentUseCase2, BuildMplNotificationUseCase buildMplNotificationUseCase2, NotificationTimerUseCase notificationTimerUseCase2, IsAppIsInBackgroundUseCase isAppIsInBackgroundUseCase2, NotifyNotificationUseCase notifyNotificationUseCase2, NotificationSendEventUseCase notificationSendEventUseCase2, Context context2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(notificationChannelUseCase2, "notificationChannelUseCase");
        Intrinsics.checkNotNullParameter(notificationPriorityUseCase2, "notificationPriorityUseCase");
        Intrinsics.checkNotNullParameter(buildLaunchIntentUseCase2, "buildLaunchIntentUseCase");
        Intrinsics.checkNotNullParameter(buildMplNotificationUseCase2, "buildMplNotificationUseCase");
        Intrinsics.checkNotNullParameter(notificationTimerUseCase2, "notificationTimerUseCase");
        Intrinsics.checkNotNullParameter(isAppIsInBackgroundUseCase2, "isAppIsInBackgroundUseCase");
        Intrinsics.checkNotNullParameter(notifyNotificationUseCase2, "notifyNotificationUseCase");
        Intrinsics.checkNotNullParameter(notificationSendEventUseCase2, "notificationSendEventUseCase");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.notificationChannelUseCase = notificationChannelUseCase2;
        this.notificationPriorityUseCase = notificationPriorityUseCase2;
        this.buildLaunchIntentUseCase = buildLaunchIntentUseCase2;
        this.buildMplNotificationUseCase = buildMplNotificationUseCase2;
        this.notificationTimerUseCase = notificationTimerUseCase2;
        this.isAppIsInBackgroundUseCase = isAppIsInBackgroundUseCase2;
        this.notifyNotificationUseCase = notifyNotificationUseCase2;
        this.notificationSendEventUseCase = notificationSendEventUseCase2;
        this.context = context2;
        this.ioDispatcher = coroutineDispatcher;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object buildLaunchIntent(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$buildLaunchIntent$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$buildLaunchIntent$1 r0 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$buildLaunchIntent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$buildLaunchIntent$1 r0 = new com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$buildLaunchIntent$1
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0044
            if (r2 == r5) goto L_0x003c
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r11)
            goto L_0x00ca
        L_0x002f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0037:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r11)
            goto L_0x00dd
        L_0x003c:
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature r2 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r11)
            goto L_0x007e
        L_0x0044:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r11)
            com.mpl.androidapp.notification.models.FeatureUgcInput r11 = r10.input
            if (r11 == 0) goto L_0x00dd
            java.lang.String r2 = "input"
            if (r11 == 0) goto L_0x00d9
            int r11 = r11.getGameId()
            com.mpl.androidapp.notification.models.FeatureUgcInput r7 = r10.input
            if (r7 == 0) goto L_0x00d5
            int r7 = r7.getGameId()
            com.mpl.androidapp.notification.models.FeatureUgcInput r8 = r10.input
            if (r8 == 0) goto L_0x00d1
            int r8 = r8.getTournamentId()
            com.mpl.androidapp.notification.models.FeatureUgcInput r9 = r10.input
            if (r9 == 0) goto L_0x00cd
            java.lang.String r2 = r9.getFeatureName()
            com.mpl.androidapp.notification.models.NotificationLaunchIntentInput r9 = new com.mpl.androidapp.notification.models.NotificationLaunchIntentInput
            r9.<init>(r7, r8, r11, r2)
            com.mpl.androidapp.notification.usecases.BuildLaunchIntentUseCase r11 = r10.buildLaunchIntentUseCase
            r0.L$0 = r10
            r0.label = r5
            java.lang.Object r11 = r11.invoke(r9, r0)
            if (r11 != r1) goto L_0x007d
            return r1
        L_0x007d:
            r2 = r10
        L_0x007e:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r11 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r11
            boolean r7 = r11 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r7 == 0) goto L_0x00b9
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r11 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r11
            java.lang.Object r11 = r11.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r11 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r11
            java.lang.Object r11 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r11)
            com.mpl.androidapp.notification.states.MPLNotificationStates r11 = (com.mpl.androidapp.notification.states.MPLNotificationStates) r11
            if (r11 != 0) goto L_0x0095
            goto L_0x00dd
        L_0x0095:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.notification.states.MPLNotificationStates> r3 = r2.mplNotificationStates
            r3.setValue(r11)
            com.mpl.androidapp.notification.states.MPLNotificationStates$BuildLaunchIntent r11 = (com.mpl.androidapp.notification.states.MPLNotificationStates.BuildLaunchIntent) r11
            android.content.Intent r11 = r11.getIntent()
            r2.intent = r11
            java.lang.Object[] r11 = new java.lang.Object[r5]
            r3 = 0
            java.lang.String r5 = "Notification deep link is constructed"
            r11[r3] = r5
            java.lang.String r3 = "NotificationUgcFeature"
            com.mpl.androidapp.utils.MLogger.i(r3, r11)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r11 = r2.buildMPLNotification(r0)
            if (r11 != r1) goto L_0x00dd
            return r1
        L_0x00b9:
            boolean r4 = r11 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r4 == 0) goto L_0x00dd
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r11 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r11
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r11 = r2.useCaseError(r11, r0)
            if (r11 != r1) goto L_0x00ca
            return r1
        L_0x00ca:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00cd:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r6
        L_0x00d1:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r6
        L_0x00d5:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r6
        L_0x00d9:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r6
        L_0x00dd:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature.buildLaunchIntent(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object buildMPLNotification(kotlin.coroutines.Continuation<? super kotlin.Unit> r31) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            boolean r2 = r1 instanceof com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$buildMPLNotification$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$buildMPLNotification$1 r2 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$buildMPLNotification$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$buildMPLNotification$1 r2 = new com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$buildMPLNotification$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r4 = r2.label
            r5 = 0
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            java.lang.String r10 = "input"
            r11 = 0
            if (r4 == 0) goto L_0x004f
            if (r4 == r9) goto L_0x0046
            if (r4 == r8) goto L_0x0041
            if (r4 == r7) goto L_0x0041
            if (r4 != r6) goto L_0x0039
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r1)
            goto L_0x01ae
        L_0x0039:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0041:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r1)
            goto L_0x01df
        L_0x0046:
            java.lang.Object r4 = r2.L$0
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature r4 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature) r4
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r1)
            goto L_0x0146
        L_0x004f:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r1)
            android.content.Intent r1 = r0.intent
            if (r1 == 0) goto L_0x01df
            com.mpl.androidapp.notification.models.FeatureUgcInput r1 = r0.input
            if (r1 == 0) goto L_0x01df
            android.content.Context r1 = r30.getContext()
            com.mpl.androidapp.notification.models.FeatureUgcInput r4 = r0.input
            if (r4 == 0) goto L_0x01db
            int r4 = r4.getNotificationLargeIcon()
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r4)
            if (r1 != 0) goto L_0x006f
            r19 = r11
            goto L_0x00d1
        L_0x006f:
            int r4 = r1.getIntrinsicWidth()
            int r12 = r1.getIntrinsicHeight()
            java.lang.String r13 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r13)
            boolean r13 = r1 instanceof android.graphics.drawable.BitmapDrawable
            java.lang.String r14 = "bitmap"
            if (r13 == 0) goto L_0x00a6
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1
            int r13 = r1.getIntrinsicWidth()
            if (r4 != r13) goto L_0x0098
            int r13 = r1.getIntrinsicHeight()
            if (r12 != r13) goto L_0x0098
            android.graphics.Bitmap r1 = r1.getBitmap()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r14)
            goto L_0x00cf
        L_0x0098:
            android.graphics.Bitmap r1 = r1.getBitmap()
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createScaledBitmap(r1, r4, r12, r9)
            java.lang.String r4 = "createScaledBitmap(bitmap, width, height, true)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            goto L_0x00cf
        L_0x00a6:
            android.graphics.Rect r13 = r1.getBounds()
            java.lang.String r15 = "bounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r15)
            int r15 = r13.left
            int r6 = r13.top
            int r7 = r13.right
            int r13 = r13.bottom
            android.graphics.Bitmap$Config r8 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r4, r12, r8)
            r1.setBounds(r5, r5, r4, r12)
            android.graphics.Canvas r4 = new android.graphics.Canvas
            r4.<init>(r8)
            r1.draw(r4)
            r1.setBounds(r15, r6, r7, r13)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r14)
            r1 = r8
        L_0x00cf:
            r19 = r1
        L_0x00d1:
            android.content.Context r1 = r30.getContext()
            com.mpl.androidapp.notification.models.FeatureUgcInput r4 = r0.input
            if (r4 == 0) goto L_0x01d7
            int r4 = r4.getNotificationColor()
            int r21 = androidx.core.content.ContextCompat.getColor(r1, r4)
            int r1 = r0.priority
            android.content.Intent r4 = r0.intent
            if (r4 == 0) goto L_0x01d1
            if (r19 == 0) goto L_0x01df
            com.mpl.androidapp.notification.models.FeatureUgcInput r6 = r0.input
            if (r6 == 0) goto L_0x01cd
            java.lang.String r17 = r6.getTitle()
            com.mpl.androidapp.notification.models.FeatureUgcInput r6 = r0.input
            if (r6 == 0) goto L_0x01c9
            java.lang.String r18 = r6.getMessage()
            com.mpl.androidapp.notification.models.FeatureUgcInput r6 = r0.input
            if (r6 == 0) goto L_0x01c5
            int r20 = r6.getNotificationSmallIcon()
            com.mpl.androidapp.notification.models.FeatureUgcInput r6 = r0.input
            if (r6 == 0) goto L_0x01c1
            int r22 = r6.getPendingIntentRequestCode()
            com.mpl.androidapp.notification.models.FeatureUgcInput r6 = r0.input
            if (r6 == 0) goto L_0x01bd
            boolean r25 = r6.getSetAutoCancel()
            com.mpl.androidapp.notification.models.FeatureUgcInput r6 = r0.input
            if (r6 == 0) goto L_0x01b9
            int r28 = r6.getSetDefaults()
            java.lang.String r6 = r0.channelId
            com.mpl.androidapp.notification.models.FeatureUgcInput r7 = r0.input
            if (r7 == 0) goto L_0x01b5
            boolean r26 = r7.isSoundEnabled()
            com.mpl.androidapp.notification.models.FeatureUgcInput r7 = r0.input
            if (r7 == 0) goto L_0x01b1
            boolean r27 = r7.isVibrationEnabled()
            com.mpl.androidapp.notification.models.NotificationBuilderInput r7 = new com.mpl.androidapp.notification.models.NotificationBuilderInput
            r16 = r7
            r23 = r4
            r24 = r1
            r29 = r6
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            com.mpl.androidapp.notification.usecases.BuildMplNotificationUseCase r1 = r0.buildMplNotificationUseCase
            r2.L$0 = r0
            r2.label = r9
            java.lang.Object r1 = r1.invoke(r7, r2)
            if (r1 != r3) goto L_0x0145
            return r3
        L_0x0145:
            r4 = r0
        L_0x0146:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r1 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r1
            boolean r6 = r1 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r6 == 0) goto L_0x019c
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r1 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r1
            java.lang.Object r1 = r1.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r1 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r1
            java.lang.Object r1 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r1)
            com.mpl.androidapp.notification.states.MPLNotificationStates r1 = (com.mpl.androidapp.notification.states.MPLNotificationStates) r1
            if (r1 != 0) goto L_0x015e
            goto L_0x01df
        L_0x015e:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.notification.states.MPLNotificationStates> r6 = r4.mplNotificationStates
            r6.setValue(r1)
            com.mpl.androidapp.notification.states.MPLNotificationStates$BuildNotification r1 = (com.mpl.androidapp.notification.states.MPLNotificationStates.BuildNotification) r1
            java.lang.Object[] r6 = new java.lang.Object[r9]
            java.lang.String r7 = "Notification object is built"
            r6[r5] = r7
            java.lang.String r5 = "NotificationUgcFeature"
            com.mpl.androidapp.utils.MLogger.i(r5, r6)
            android.app.Notification r1 = r1.getNotification()
            r4.notification = r1
            com.mpl.androidapp.notification.models.FeatureUgcInput r1 = r4.input
            if (r1 == 0) goto L_0x0198
            boolean r1 = r1.isTimerPresentForNotification()
            if (r1 == 0) goto L_0x018c
            r2.L$0 = r11
            r1 = 2
            r2.label = r1
            java.lang.Object r1 = r4.timerMpl(r2)
            if (r1 != r3) goto L_0x01df
            return r3
        L_0x018c:
            r2.L$0 = r11
            r1 = 3
            r2.label = r1
            java.lang.Object r1 = r4.notifyMplNotification(r2)
            if (r1 != r3) goto L_0x01df
            return r3
        L_0x0198:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            throw r11
        L_0x019c:
            boolean r5 = r1 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r5 == 0) goto L_0x01df
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r1 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r1
            r2.L$0 = r11
            r5 = 4
            r2.label = r5
            java.lang.Object r1 = r4.useCaseError(r1, r2)
            if (r1 != r3) goto L_0x01ae
            return r3
        L_0x01ae:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x01b1:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            throw r11
        L_0x01b5:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            throw r11
        L_0x01b9:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            throw r11
        L_0x01bd:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            throw r11
        L_0x01c1:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            throw r11
        L_0x01c5:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            throw r11
        L_0x01c9:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            throw r11
        L_0x01cd:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            throw r11
        L_0x01d1:
            java.lang.String r1 = "intent"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            throw r11
        L_0x01d7:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            throw r11
        L_0x01db:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            throw r11
        L_0x01df:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature.buildMPLNotification(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkNotificationPriority(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$checkNotificationPriority$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$checkNotificationPriority$1 r0 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$checkNotificationPriority$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$checkNotificationPriority$1 r0 = new com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$checkNotificationPriority$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0044
            if (r2 == r5) goto L_0x003c
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            goto L_0x00ba
        L_0x002f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0037:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            goto L_0x00c5
        L_0x003c:
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature r2 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            goto L_0x006e
        L_0x0044:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            com.mpl.androidapp.notification.models.FeatureUgcInput r10 = r9.input
            if (r10 == 0) goto L_0x00c5
            com.mpl.androidapp.notification.models.NotificationPriorityInput r2 = new com.mpl.androidapp.notification.models.NotificationPriorityInput
            java.lang.String r7 = "input"
            if (r10 == 0) goto L_0x00c1
            boolean r10 = r10.isUserPlayingGame()
            com.mpl.androidapp.notification.models.FeatureUgcInput r8 = r9.input
            if (r8 == 0) goto L_0x00bd
            int r7 = r8.getDeviceOsVersion()
            r2.<init>(r10, r7)
            com.mpl.androidapp.notification.usecases.NotificationPriorityUseCase r10 = r9.notificationPriorityUseCase
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r10 = r10.invoke(r2, r0)
            if (r10 != r1) goto L_0x006d
            return r1
        L_0x006d:
            r2 = r9
        L_0x006e:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r10
            boolean r7 = r10 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r7 == 0) goto L_0x00a9
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r10
            java.lang.Object r10 = r10.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r10
            java.lang.Object r10 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r10)
            com.mpl.androidapp.notification.states.MPLNotificationStates r10 = (com.mpl.androidapp.notification.states.MPLNotificationStates) r10
            if (r10 != 0) goto L_0x0085
            goto L_0x00c5
        L_0x0085:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.notification.states.MPLNotificationStates> r3 = r2.mplNotificationStates
            r3.setValue(r10)
            com.mpl.androidapp.notification.states.MPLNotificationStates$NotificationPriority r10 = (com.mpl.androidapp.notification.states.MPLNotificationStates.NotificationPriority) r10
            int r10 = r10.getPriority()
            r2.priority = r10
            java.lang.Object[] r10 = new java.lang.Object[r5]
            r3 = 0
            java.lang.String r5 = "Notification priority is set"
            r10[r3] = r5
            java.lang.String r3 = "NotificationUgcFeature"
            com.mpl.androidapp.utils.MLogger.i(r3, r10)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r10 = r2.buildLaunchIntent(r0)
            if (r10 != r1) goto L_0x00c5
            return r1
        L_0x00a9:
            boolean r4 = r10 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r4 == 0) goto L_0x00c5
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r10
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r10 = r2.useCaseError(r10, r0)
            if (r10 != r1) goto L_0x00ba
            return r1
        L_0x00ba:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00bd:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r6
        L_0x00c1:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r6
        L_0x00c5:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature.checkNotificationPriority(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object determineNotificationChannel(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$determineNotificationChannel$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$determineNotificationChannel$1 r0 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$determineNotificationChannel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$determineNotificationChannel$1 r0 = new com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$determineNotificationChannel$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r5) goto L_0x003b
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x00ae
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0036:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x00b1
        L_0x003b:
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature r2 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x005d
        L_0x0043:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            com.mpl.androidapp.notification.models.NotificationChannelInput r9 = new com.mpl.androidapp.notification.models.NotificationChannelInput
            boolean r2 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isUserPlayingGame()
            r9.<init>(r2)
            com.mpl.androidapp.notification.usecases.NotificationChannelUseCase r2 = r8.notificationChannelUseCase
            r0.L$0 = r8
            r0.label = r5
            java.lang.Object r9 = r2.invoke(r9, r0)
            if (r9 != r1) goto L_0x005c
            return r1
        L_0x005c:
            r2 = r8
        L_0x005d:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r9
            boolean r6 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            r7 = 0
            if (r6 == 0) goto L_0x009d
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r9
            java.lang.Object r9 = r9.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r9
            java.lang.Object r9 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r9)
            com.mpl.androidapp.notification.states.MPLNotificationStates r9 = (com.mpl.androidapp.notification.states.MPLNotificationStates) r9
            if (r9 != 0) goto L_0x0075
            goto L_0x00b1
        L_0x0075:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.notification.states.MPLNotificationStates> r3 = r2.mplNotificationStates
            r3.setValue(r9)
            com.mpl.androidapp.notification.states.MPLNotificationStates$NotificationChannel r9 = (com.mpl.androidapp.notification.states.MPLNotificationStates.NotificationChannel) r9
            java.lang.String r9 = r9.getChannelId()
            r2.channelId = r9
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r5 = 0
            java.lang.String r6 = "Notification channel is set up, Channel is => "
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r9)
            r3[r5] = r9
            java.lang.String r9 = "NotificationUgcFeature"
            com.mpl.androidapp.utils.MLogger.i(r9, r3)
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r9 = r2.checkNotificationPriority(r0)
            if (r9 != r1) goto L_0x00b1
            return r1
        L_0x009d:
            boolean r4 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r4 == 0) goto L_0x00b1
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r9
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r9 = r2.useCaseError(r9, r0)
            if (r9 != r1) goto L_0x00ae
            return r1
        L_0x00ae:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00b1:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature.determineNotificationChannel(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object isAppInBackground(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$isAppInBackground$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$isAppInBackground$1 r0 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$isAppInBackground$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$isAppInBackground$1 r0 = new com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$isAppInBackground$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r5) goto L_0x003b
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            goto L_0x00ba
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0036:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            goto L_0x00bd
        L_0x003b:
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature r2 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            goto L_0x0056
        L_0x0043:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            com.mpl.androidapp.notification.usecases.IsAppIsInBackgroundUseCase r2 = r9.isAppIsInBackgroundUseCase
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r10 = r2.invoke(r10, r0)
            if (r10 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r2 = r9
        L_0x0056:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r10
            boolean r6 = r10 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            r7 = 0
            if (r6 == 0) goto L_0x00a9
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r10
            java.lang.Object r10 = r10.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r10
            java.lang.Object r10 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r10)
            com.mpl.androidapp.notification.states.MPLNotificationStates r10 = (com.mpl.androidapp.notification.states.MPLNotificationStates) r10
            if (r10 != 0) goto L_0x006e
            goto L_0x00bd
        L_0x006e:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.notification.states.MPLNotificationStates> r3 = r2.mplNotificationStates
            r3.setValue(r10)
            com.mpl.androidapp.notification.states.MPLNotificationStates$IsAppIsInBackground r10 = (com.mpl.androidapp.notification.states.MPLNotificationStates.IsAppIsInBackground) r10
            boolean r10 = r10.isInBackground()
            r2.isMplInBackground = r10
            java.lang.Object[] r10 = new java.lang.Object[r5]
            java.lang.String r3 = "Notification, whether if it's in background/foreground is determined"
            r6 = 0
            r10[r6] = r3
            java.lang.String r3 = "NotificationUgcFeature"
            com.mpl.androidapp.utils.MLogger.i(r3, r10)
            java.lang.Object[] r10 = new java.lang.Object[r5]
            boolean r5 = r2.isMplInBackground
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            java.lang.String r8 = "Is MPL in background => "
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r5)
            r10[r6] = r5
            com.mpl.androidapp.utils.MLogger.i(r3, r10)
            boolean r10 = r2.isMplInBackground
            if (r10 == 0) goto L_0x00bd
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r10 = r2.notifyMplNotification(r0)
            if (r10 != r1) goto L_0x00bd
            return r1
        L_0x00a9:
            boolean r4 = r10 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r4 == 0) goto L_0x00bd
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r10
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r10 = r2.useCaseError(r10, r0)
            if (r10 != r1) goto L_0x00ba
            return r1
        L_0x00ba:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00bd:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature.isAppInBackground(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object notifyMplNotification(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$notifyMplNotification$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$notifyMplNotification$1 r0 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$notifyMplNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$notifyMplNotification$1 r0 = new com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$notifyMplNotification$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0044
            if (r2 == r5) goto L_0x003c
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x00ca
        L_0x002f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0037:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x00d3
        L_0x003c:
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature r2 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x006c
        L_0x0044:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            android.app.Notification r9 = r8.notification
            if (r9 == 0) goto L_0x00d3
            com.mpl.androidapp.notification.models.FeatureUgcInput r9 = r8.input
            if (r9 == 0) goto L_0x00d3
            com.mpl.androidapp.notification.features.NotificationID r9 = com.mpl.androidapp.notification.features.NotificationID.INSTANCE
            int r9 = r9.getID()
            com.mpl.androidapp.notification.models.NotificationInput r2 = new com.mpl.androidapp.notification.models.NotificationInput
            android.app.Notification r7 = r8.notification
            if (r7 == 0) goto L_0x00cd
            r2.<init>(r7, r9)
            com.mpl.androidapp.notification.usecases.NotifyNotificationUseCase r9 = r8.notifyNotificationUseCase
            r0.L$0 = r8
            r0.label = r5
            java.lang.Object r9 = r9.invoke(r2, r0)
            if (r9 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r2 = r8
        L_0x006c:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r9
            boolean r7 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r7 == 0) goto L_0x00b9
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r9
            java.lang.Object r9 = r9.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r9
            java.lang.Object r9 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r9)
            com.mpl.androidapp.notification.states.MPLNotificationStates r9 = (com.mpl.androidapp.notification.states.MPLNotificationStates) r9
            if (r9 != 0) goto L_0x0083
            goto L_0x00d3
        L_0x0083:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.notification.states.MPLNotificationStates> r3 = r2.mplNotificationStates
            r3.setValue(r9)
            com.mpl.androidapp.notification.states.MPLNotificationStates$NotificationPublished r9 = (com.mpl.androidapp.notification.states.MPLNotificationStates.NotificationPublished) r9
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r5 = 0
            java.lang.String r7 = "Notification Published"
            r3[r5] = r7
            java.lang.String r5 = "NotificationUgcFeature"
            com.mpl.androidapp.utils.MLogger.i(r5, r3)
            com.mpl.androidapp.notification.models.FeatureUgcInput r3 = r2.input
            if (r3 == 0) goto L_0x00b3
            boolean r3 = r3.getSendEvent()
            if (r3 == 0) goto L_0x00af
            int r9 = r9.getNotificationId()
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r9 = r2.sendEventForNotification(r9, r0)
            if (r9 != r1) goto L_0x00d3
            return r1
        L_0x00af:
            r2.onDestroyCoroutine()
            goto L_0x00d3
        L_0x00b3:
            java.lang.String r9 = "input"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            throw r6
        L_0x00b9:
            boolean r4 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r4 == 0) goto L_0x00d3
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r9
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r9 = r2.useCaseError(r9, r0)
            if (r9 != r1) goto L_0x00ca
            return r1
        L_0x00ca:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00cd:
            java.lang.String r9 = "notification"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            throw r6
        L_0x00d3:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature.notifyMplNotification(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void onDestroyCoroutine() {
        MLogger.i(NotificationFeatureNames.NOTIFICATION_UGC_FEATURE_TAG, "Co-routine is canceled");
        TypeUtilsKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendEventForNotification(int r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$sendEventForNotification$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$sendEventForNotification$1 r0 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$sendEventForNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$sendEventForNotification$1 r0 = new com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$sendEventForNotification$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 == r5) goto L_0x0033
            if (r2 != r4) goto L_0x002b
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x0098
        L_0x002b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0033:
            java.lang.Object r7 = r0.L$0
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature r7 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature) r7
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x005b
        L_0x003b:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            com.mpl.androidapp.notification.models.FeatureUgcInput r8 = r6.input
            if (r8 == 0) goto L_0x00a1
            com.mpl.androidapp.notification.models.NotificationEventInput r2 = new com.mpl.androidapp.notification.models.NotificationEventInput
            if (r8 == 0) goto L_0x009b
            java.lang.String r8 = r8.getFeatureName()
            r2.<init>(r8, r7)
            com.mpl.androidapp.notification.usecases.NotificationSendEventUseCase r7 = r6.notificationSendEventUseCase
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r8 = r7.invoke(r2, r0)
            if (r8 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r7 = r6
        L_0x005b:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            boolean r2 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r2 == 0) goto L_0x0087
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r8
            java.lang.Object r8 = r8.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            java.lang.Object r8 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r8)
            com.mpl.androidapp.notification.states.MPLNotificationStates r8 = (com.mpl.androidapp.notification.states.MPLNotificationStates) r8
            if (r8 != 0) goto L_0x0072
            goto L_0x00a1
        L_0x0072:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.notification.states.MPLNotificationStates> r0 = r7.mplNotificationStates
            r0.setValue(r8)
            java.lang.Object[] r8 = new java.lang.Object[r5]
            r0 = 0
            java.lang.String r1 = "Notification Event Published"
            r8[r0] = r1
            java.lang.String r0 = "NotificationUgcFeature"
            com.mpl.androidapp.utils.MLogger.i(r0, r8)
            r7.onDestroyCoroutine()
            goto L_0x00a1
        L_0x0087:
            boolean r2 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r2 == 0) goto L_0x00a1
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r8
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r7 = r7.useCaseError(r8, r0)
            if (r7 != r1) goto L_0x0098
            return r1
        L_0x0098:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x009b:
            java.lang.String r7 = "input"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r3
        L_0x00a1:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature.sendEventForNotification(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object timerMpl(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$timerMpl$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$timerMpl$1 r0 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$timerMpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$timerMpl$1 r0 = new com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature$timerMpl$1
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            java.lang.String r4 = "NotificationUgcFeature"
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r8) goto L_0x003f
            if (r2 == r6) goto L_0x003a
            if (r2 != r5) goto L_0x0032
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r12)
            goto L_0x00c9
        L_0x0032:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x003a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r12)
            goto L_0x00d4
        L_0x003f:
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature r2 = (com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r12)
            goto L_0x0088
        L_0x0047:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r12)
            com.mpl.androidapp.notification.models.FeatureUgcInput r12 = r11.input
            if (r12 == 0) goto L_0x00d4
            java.lang.Object[] r12 = new java.lang.Object[r8]
            java.lang.String r2 = "Notification timer started for duration => "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            com.mpl.androidapp.notification.models.FeatureUgcInput r9 = r11.input
            java.lang.String r10 = "input"
            if (r9 == 0) goto L_0x00d0
            r2.append(r9)
            java.lang.String r9 = ".timerDuration"
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            r12[r3] = r2
            com.mpl.androidapp.utils.MLogger.i(r4, r12)
            com.mpl.androidapp.notification.usecases.NotificationTimerUseCase r12 = r11.notificationTimerUseCase
            com.mpl.androidapp.notification.models.FeatureUgcInput r2 = r11.input
            if (r2 == 0) goto L_0x00cc
            long r9 = r2.getTimerDuration()
            java.lang.Long r2 = new java.lang.Long
            r2.<init>(r9)
            r0.L$0 = r11
            r0.label = r8
            java.lang.Object r12 = r12.invoke(r2, r0)
            if (r12 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r2 = r11
        L_0x0088:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r12 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r12
            boolean r9 = r12 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r9 == 0) goto L_0x00b8
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r12 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r12
            java.lang.Object r12 = r12.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r12 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r12
            java.lang.Object r12 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r12)
            com.mpl.androidapp.notification.states.MPLNotificationStates r12 = (com.mpl.androidapp.notification.states.MPLNotificationStates) r12
            if (r12 != 0) goto L_0x009f
            goto L_0x00d4
        L_0x009f:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.notification.states.MPLNotificationStates> r5 = r2.mplNotificationStates
            r5.setValue(r12)
            java.lang.Object[] r12 = new java.lang.Object[r8]
            java.lang.String r5 = "Notification timer finished"
            r12[r3] = r5
            com.mpl.androidapp.utils.MLogger.i(r4, r12)
            r0.L$0 = r7
            r0.label = r6
            java.lang.Object r12 = r2.isAppInBackground(r0)
            if (r12 != r1) goto L_0x00d4
            return r1
        L_0x00b8:
            boolean r3 = r12 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r3 == 0) goto L_0x00d4
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r12 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r12
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r12 = r2.useCaseError(r12, r0)
            if (r12 != r1) goto L_0x00c9
            return r1
        L_0x00c9:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00cc:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            throw r7
        L_0x00d0:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            throw r7
        L_0x00d4:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.features.implementations.NotificationUgcFeature.timerMpl(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object useCaseError(Error error, Continuation<? super Unit> continuation) {
        String valueOf = String.valueOf(error.getException().getMessage());
        this.mplNotificationStates.setValue(new ErrorState(valueOf));
        MLogger.e(NotificationFeatureNames.NOTIFICATION_UGC_FEATURE_TAG, Intrinsics.stringPlus("Error in share module:->", valueOf));
        onDestroyCoroutine();
        return Unit.INSTANCE;
    }

    public final Context getContext() {
        return this.context;
    }

    public CoroutineContext getCoroutineContext() {
        return DefaultImpls.plus((JobSupport) TypeUtilsKt.SupervisorJob$default(null, 1), this.ioDispatcher).plus(this.exceptionHandler);
    }

    public final void runFeature(FeatureUgcInput featureUgcInput) {
        Intrinsics.checkNotNullParameter(featureUgcInput, "input");
        this.input = featureUgcInput;
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.getMain()), null, null, new NotificationUgcFeature$runFeature$1(this, null), 3, null);
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }
}
