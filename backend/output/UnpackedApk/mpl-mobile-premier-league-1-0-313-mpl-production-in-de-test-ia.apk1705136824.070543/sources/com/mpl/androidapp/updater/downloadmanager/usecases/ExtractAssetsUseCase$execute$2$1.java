package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.AssetsExtracted;
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
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.usecases.ExtractAssetsUseCase$execute$2$1", f = "ExtractAssetsUseCase.kt", l = {35}, m = "invokeSuspend")
/* compiled from: ExtractAssetsUseCase.kt */
public final class ExtractAssetsUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends QueryDownloadStates>> $coroutine;
    public final /* synthetic */ DownloadTaskParams $downloadTaskParams;
    public int label;
    public final /* synthetic */ ExtractAssetsUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ExtractAssetsUseCase$execute$2$1(ExtractAssetsUseCase extractAssetsUseCase, DownloadTaskParams downloadTaskParams, CancellableContinuation<? super UseCaseResult<? extends QueryDownloadStates>> cancellableContinuation, Continuation<? super ExtractAssetsUseCase$execute$2$1> continuation) {
        // this.this$0 = extractAssetsUseCase;
        // this.$downloadTaskParams = downloadTaskParams;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExtractAssetsUseCase$execute$2$1(this.this$0, this.$downloadTaskParams, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExtractAssetsUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            ExtractAssetsUseCase extractAssetsUseCase = this.this$0;
            DownloadTaskParams downloadTaskParams = this.$downloadTaskParams;
            this.label = 1;
            if (extractAssetsUseCase.extract(downloadTaskParams, this) == coroutineSingletons) {
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
        this.$coroutine.resumeWith(new Success(AssetsExtracted.INSTANCE));
        return Unit.INSTANCE;
    }
}