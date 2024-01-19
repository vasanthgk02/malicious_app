package com.mpl.androidapp.updater.downloadmanager.utils;

import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0000\"\u0004\b\u0001\u0010\u0002*\u00020\u0004H@"}, d2 = {"<anonymous>", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Success;", "R", "P", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase$invoke$2", f = "SuspendUseCase.kt", l = {30}, m = "invokeSuspend")
/* compiled from: SuspendUseCase.kt */
public final class SuspendUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Success<? extends R>>, Object> {
    public final /* synthetic */ P $parameters;
    public int label;
    public final /* synthetic */ SuspendUseCase<P, R> this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SuspendUseCase$invoke$2(SuspendUseCase<? super P, R> suspendUseCase, P p, Continuation<? super SuspendUseCase$invoke$2> continuation) {
        // this.this$0 = suspendUseCase;
        // this.$parameters = p;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuspendUseCase$invoke$2(this.this$0, this.$parameters, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Success<? extends R>> continuation) {
        return ((SuspendUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            SuspendUseCase<P, R> suspendUseCase = this.this$0;
            P p = this.$parameters;
            this.label = 1;
            obj = suspendUseCase.execute(p, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return new Success(obj);
    }
}
