package com.mpl.androidapp.notification.usecases;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import androidx.core.app.NotificationCompat.Builder;
import com.mpl.androidapp.notification.models.NotificationBuilderInput;
import com.mpl.androidapp.notification.states.MPLNotificationStates;
import com.mpl.androidapp.notification.states.MPLNotificationStates.BuildNotification;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.notification.usecases.BuildMplNotificationUseCase$execute$2$1", f = "BuildMplNotificationUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: BuildMplNotificationUseCase.kt */
public final class BuildMplNotificationUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends MPLNotificationStates>> $coroutine;
    public final /* synthetic */ NotificationBuilderInput $parameters;
    public int label;
    public final /* synthetic */ BuildMplNotificationUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BuildMplNotificationUseCase$execute$2$1(NotificationBuilderInput notificationBuilderInput, BuildMplNotificationUseCase buildMplNotificationUseCase, CancellableContinuation<? super UseCaseResult<? extends MPLNotificationStates>> cancellableContinuation, Continuation<? super BuildMplNotificationUseCase$execute$2$1> continuation) {
        // this.$parameters = notificationBuilderInput;
        // this.this$0 = buildMplNotificationUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BuildMplNotificationUseCase$execute$2$1(this.$parameters, this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BuildMplNotificationUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                String title = this.$parameters.getTitle();
                String message = this.$parameters.getMessage();
                Bitmap notificationLargeIcon = this.$parameters.getNotificationLargeIcon();
                int notificationSmallIcon = this.$parameters.getNotificationSmallIcon();
                int notificationColor = this.$parameters.getNotificationColor();
                int pendingIntentRequestCode = this.$parameters.getPendingIntentRequestCode();
                Intent intent = this.$parameters.getIntent();
                boolean setAutoCancel = this.$parameters.getSetAutoCancel();
                int priority = this.$parameters.getPriority();
                this.$parameters.getSetDefaults();
                String channelId = this.$parameters.getChannelId();
                boolean isSoundEnabled = this.$parameters.isSoundEnabled();
                boolean isVibrationEnabled = this.$parameters.isVibrationEnabled();
                Builder access$generateNotificationBuilder = this.this$0.generateNotificationBuilder(title, message, notificationLargeIcon, notificationSmallIcon, notificationColor, channelId);
                access$generateNotificationBuilder.setContentIntent(PendingIntent.getActivity(this.this$0.getContext(), pendingIntentRequestCode, intent, 134217728));
                access$generateNotificationBuilder.setAutoCancel(setAutoCancel);
                if (VERSION.SDK_INT < 26) {
                    access$generateNotificationBuilder.setPriority(priority);
                }
                if (isSoundEnabled && isVibrationEnabled) {
                    access$generateNotificationBuilder.setDefaults(3);
                } else if (isSoundEnabled) {
                    access$generateNotificationBuilder.setDefaults(1);
                } else if (isVibrationEnabled) {
                    access$generateNotificationBuilder.setDefaults(2);
                }
                Notification build = access$generateNotificationBuilder.build();
                Intrinsics.checkNotNullExpressionValue(build, "notificationBuilder.build()");
                this.$coroutine.resumeWith(new Success(new BuildNotification(build)));
            } catch (Exception e2) {
                this.$coroutine.resumeWith(new Error(e2));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
