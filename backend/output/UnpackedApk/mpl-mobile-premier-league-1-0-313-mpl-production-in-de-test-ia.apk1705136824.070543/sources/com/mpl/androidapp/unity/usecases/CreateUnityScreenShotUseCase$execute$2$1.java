package com.mpl.androidapp.unity.usecases;

import android.app.Activity;
import android.view.ViewGroup;
import com.mpl.androidapp.unity.models.UnityScreenShotParams;
import com.mpl.androidapp.unity.states.MPLUnityFeaturesState;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
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
@DebugMetadata(c = "com.mpl.androidapp.unity.usecases.CreateUnityScreenShotUseCase$execute$2$1", f = "CreateUnityScreenShotUseCase.kt", l = {52}, m = "invokeSuspend")
/* compiled from: CreateUnityScreenShotUseCase.kt */
public final class CreateUnityScreenShotUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends MPLUnityFeaturesState>> $coroutine;
    public final /* synthetic */ UnityScreenShotParams $parameters;
    public int label;
    public final /* synthetic */ CreateUnityScreenShotUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CreateUnityScreenShotUseCase$execute$2$1(UnityScreenShotParams unityScreenShotParams, CreateUnityScreenShotUseCase createUnityScreenShotUseCase, CancellableContinuation<? super UseCaseResult<? extends MPLUnityFeaturesState>> cancellableContinuation, Continuation<? super CreateUnityScreenShotUseCase$execute$2$1> continuation) {
        // this.$parameters = unityScreenShotParams;
        // this.this$0 = createUnityScreenShotUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateUnityScreenShotUseCase$execute$2$1(this.$parameters, this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateUnityScreenShotUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            Activity activity = this.$parameters.getActivity();
            ViewGroup decorView = this.$parameters.getDecorView();
            CreateUnityScreenShotUseCase createUnityScreenShotUseCase = this.this$0;
            CancellableContinuation<UseCaseResult<? extends MPLUnityFeaturesState>> cancellableContinuation = this.$coroutine;
            this.label = 1;
            if (createUnityScreenShotUseCase.createScreenShotFile(cancellableContinuation, activity, decorView, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            try {
                TweetUtils.throwOnFailure(obj);
            } catch (Exception e2) {
                this.$coroutine.resumeWith(new Error(e2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
