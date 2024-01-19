package com.mpl.androidapp.unity.usecases;

import com.mpl.androidapp.unity.models.CrashParams;
import com.mpl.androidapp.unity.states.MPLUnityFeaturesState;
import com.mpl.androidapp.unity.states.MPLUnityFeaturesState.LogFirebaseCrashState;
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
@DebugMetadata(c = "com.mpl.androidapp.unity.usecases.LogCrashAnalyticsUseCase$execute$2$1", f = "LogCrashAnalyticsUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: LogCrashAnalyticsUseCase.kt */
public final class LogCrashAnalyticsUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends MPLUnityFeaturesState>> $coroutine;
    public final /* synthetic */ CrashParams $parameters;
    public int label;
    public final /* synthetic */ LogCrashAnalyticsUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LogCrashAnalyticsUseCase$execute$2$1(LogCrashAnalyticsUseCase logCrashAnalyticsUseCase, CrashParams crashParams, CancellableContinuation<? super UseCaseResult<? extends MPLUnityFeaturesState>> cancellableContinuation, Continuation<? super LogCrashAnalyticsUseCase$execute$2$1> continuation) {
        // this.this$0 = logCrashAnalyticsUseCase;
        // this.$parameters = crashParams;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LogCrashAnalyticsUseCase$execute$2$1(this.this$0, this.$parameters, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LogCrashAnalyticsUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                this.this$0.logCrashlytics(this.$parameters.getMsg(), this.$parameters.getStacktrace(), this.$parameters.getStacktrace());
                this.$coroutine.resumeWith(new Success(LogFirebaseCrashState.INSTANCE));
            } catch (Exception e2) {
                this.$coroutine.resumeWith(new Error(e2));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
