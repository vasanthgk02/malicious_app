package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.updater.downloadmanager.data.PublishProgressParams;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.ProgressPublished;
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
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.usecases.PublishProgressUseCase$execute$2$1", f = "PublishProgressUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: PublishProgressUseCase.kt */
public final class PublishProgressUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends QueryDownloadStates>> $coroutine;
    public final /* synthetic */ PublishProgressParams $publishProgressParams;
    public int label;
    public final /* synthetic */ PublishProgressUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PublishProgressUseCase$execute$2$1(PublishProgressParams publishProgressParams, PublishProgressUseCase publishProgressUseCase, CancellableContinuation<? super UseCaseResult<? extends QueryDownloadStates>> cancellableContinuation, Continuation<? super PublishProgressUseCase$execute$2$1> continuation) {
        // this.$publishProgressParams = publishProgressParams;
        // this.this$0 = publishProgressUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PublishProgressUseCase$execute$2$1(this.$publishProgressParams, this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PublishProgressUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                this.this$0.publishTheProgress(this.$publishProgressParams.getId(), this.$publishProgressParams.getProgress(), this.$publishProgressParams.isProgressComplete());
                this.$coroutine.resumeWith(new Success(ProgressPublished.INSTANCE));
            } catch (Exception e2) {
                this.$coroutine.resumeWith(new Error(e2));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
