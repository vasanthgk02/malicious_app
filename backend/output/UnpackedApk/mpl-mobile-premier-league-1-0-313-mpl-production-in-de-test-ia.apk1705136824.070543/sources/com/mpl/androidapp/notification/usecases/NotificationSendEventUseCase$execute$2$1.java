package com.mpl.androidapp.notification.usecases;

import android.os.Bundle;
import com.mpl.androidapp.notification.NotificationBuilder;
import com.mpl.androidapp.notification.models.NotificationEventInput;
import com.mpl.androidapp.notification.states.MPLNotificationStates;
import com.mpl.androidapp.notification.states.MPLNotificationStates.NotificationEventPublished;
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
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.notification.usecases.NotificationSendEventUseCase$execute$2$1", f = "NotificationSendEventUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: NotificationSendEventUseCase.kt */
public final class NotificationSendEventUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends MPLNotificationStates>> $coroutine;
    public final /* synthetic */ NotificationEventInput $parameters;
    public int label;
    public final /* synthetic */ NotificationSendEventUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NotificationSendEventUseCase$execute$2$1(NotificationEventInput notificationEventInput, NotificationSendEventUseCase notificationSendEventUseCase, CancellableContinuation<? super UseCaseResult<? extends MPLNotificationStates>> cancellableContinuation, Continuation<? super NotificationSendEventUseCase$execute$2$1> continuation) {
        // this.$parameters = notificationEventInput;
        // this.this$0 = notificationSendEventUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationSendEventUseCase$execute$2$1(this.$parameters, this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationSendEventUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                String feature = this.$parameters.getFeature();
                int notificationId = this.$parameters.getNotificationId();
                Bundle bundle = new Bundle();
                bundle.putString("feature", feature);
                NotificationBuilder.sendEvent(this.this$0.getContext(), bundle, notificationId);
                this.$coroutine.resumeWith(new Success(NotificationEventPublished.INSTANCE));
            } catch (Exception e2) {
                this.$coroutine.resumeWith(new Error(e2));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
