package com.mpl.androidapp.filehandling.downloadservice.usecases;

import com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates;
import com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates.IsConnectedToInternet;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
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
@DebugMetadata(c = "com.mpl.androidapp.filehandling.downloadservice.usecases.CheckConnectivityUseCase$execute$2$1", f = "CheckConnectivityUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: CheckConnectivityUseCase.kt */
public final class CheckConnectivityUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends GenericFileDownloadStates>> $coroutine;
    public int label;
    public final /* synthetic */ CheckConnectivityUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CheckConnectivityUseCase$execute$2$1(CheckConnectivityUseCase checkConnectivityUseCase, CancellableContinuation<? super UseCaseResult<? extends GenericFileDownloadStates>> cancellableContinuation, Continuation<? super CheckConnectivityUseCase$execute$2$1> continuation) {
        // this.this$0 = checkConnectivityUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CheckConnectivityUseCase$execute$2$1(this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CheckConnectivityUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                this.$coroutine.resumeWith(new Success(new IsConnectedToInternet(this.this$0.isNetworkAvailable(this.this$0.getContext()))));
            } catch (Exception e2) {
                this.$coroutine.resumeWith(TweetUtils.createFailure(new Exception(e2.getMessage())));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
