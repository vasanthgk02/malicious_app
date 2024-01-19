package com.mpl.androidapp.notification.usecases;

import android.content.Intent;
import android.os.Bundle;
import com.mpl.androidapp.notification.models.NotificationLaunchIntentInput;
import com.mpl.androidapp.notification.states.MPLNotificationStates;
import com.mpl.androidapp.notification.states.MPLNotificationStates.BuildLaunchIntent;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.mpl.androidapp.utils.Constant;
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
@DebugMetadata(c = "com.mpl.androidapp.notification.usecases.BuildLaunchIntentUseCase$execute$2$1", f = "BuildLaunchIntentUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: BuildLaunchIntentUseCase.kt */
public final class BuildLaunchIntentUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends MPLNotificationStates>> $coroutine;
    public final /* synthetic */ NotificationLaunchIntentInput $parameters;
    public int label;
    public final /* synthetic */ BuildLaunchIntentUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BuildLaunchIntentUseCase$execute$2$1(NotificationLaunchIntentInput notificationLaunchIntentInput, BuildLaunchIntentUseCase buildLaunchIntentUseCase, CancellableContinuation<? super UseCaseResult<? extends MPLNotificationStates>> cancellableContinuation, Continuation<? super BuildLaunchIntentUseCase$execute$2$1> continuation) {
        // this.$parameters = notificationLaunchIntentInput;
        // this.this$0 = buildLaunchIntentUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BuildLaunchIntentUseCase$execute$2$1(this.$parameters, this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BuildLaunchIntentUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                int gameId = this.$parameters.getGameId();
                int tournamentId = this.$parameters.getTournamentId();
                int notificationId = this.$parameters.getNotificationId();
                String featureName = this.$parameters.getFeatureName();
                Intent intent = new Intent(this.this$0.getContext(), MPLReactContainerActivity.class);
                BuildLaunchIntentUseCase buildLaunchIntentUseCase = this.this$0;
                Bundle bundle = new Bundle();
                bundle.putInt(Constant.INTENT_EXTRA_NOTIFICATION_ID, notificationId);
                bundle.putString("action", "OPEN_DEEP_LINK");
                buildLaunchIntentUseCase.setScreenNavigation(featureName, bundle, gameId, tournamentId);
                intent.putExtra(Constant.INTENT_EXTRA_NOTIFICATION_ID, notificationId);
                intent.putExtras(bundle);
                this.$coroutine.resumeWith(new Success(new BuildLaunchIntent(intent)));
            } catch (Exception e2) {
                this.$coroutine.resumeWith(new Error(e2));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
