package com.mpl.androidapp.notification.usecases;

import com.mpl.androidapp.miniprofile.extensions.StringExtKt;
import com.mpl.androidapp.notification.models.NotificationChannelInput;
import com.mpl.androidapp.notification.states.MPLNotificationStates;
import com.mpl.androidapp.notification.states.MPLNotificationStates.NotificationChannel;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.mpl.androidapp.utils.Constant.ChannelConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.notification.usecases.NotificationChannelUseCase$execute$2$1", f = "NotificationChannelUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: NotificationChannelUseCase.kt */
public final class NotificationChannelUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends MPLNotificationStates>> $coroutine;
    public final /* synthetic */ NotificationChannelInput $parameters;
    public int label;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NotificationChannelUseCase$execute$2$1(NotificationChannelInput notificationChannelInput, CancellableContinuation<? super UseCaseResult<? extends MPLNotificationStates>> cancellableContinuation, Continuation<? super NotificationChannelUseCase$execute$2$1> continuation) {
        // this.$parameters = notificationChannelInput;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationChannelUseCase$execute$2$1(this.$parameters, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationChannelUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                boolean isGamePlayStarted = this.$parameters.isGamePlayStarted();
                StringExtKt.getEMPTY(StringCompanionObject.INSTANCE);
                this.$coroutine.resumeWith(new Success(new NotificationChannel(isGamePlayStarted ? ChannelConstants.GAME_PLAY_CHANNEL_ID : "assets")));
            } catch (Exception e2) {
                this.$coroutine.resumeWith(new Error(e2));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
