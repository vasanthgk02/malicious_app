package com.mpl.androidapp.filehandling.downloadservice.usecases;

import com.mpl.androidapp.filehandling.downloadservice.models.CustomFileDownloadInput;
import com.mpl.androidapp.filehandling.downloadservice.states.GenericFileDownloadStates;
import com.mpl.androidapp.filehandling.downloadservice.utils.DownloadServiceUtils;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
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
@DebugMetadata(c = "com.mpl.androidapp.filehandling.downloadservice.usecases.InitDownloadManagerUseCase$execute$2$1", f = "InitDownloadManagerUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: InitDownloadManagerUseCase.kt */
public final class InitDownloadManagerUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends GenericFileDownloadStates>> $coroutine;
    public final /* synthetic */ CustomFileDownloadInput $parameters;
    public int label;
    public final /* synthetic */ InitDownloadManagerUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public InitDownloadManagerUseCase$execute$2$1(CustomFileDownloadInput customFileDownloadInput, InitDownloadManagerUseCase initDownloadManagerUseCase, CancellableContinuation<? super UseCaseResult<? extends GenericFileDownloadStates>> cancellableContinuation, Continuation<? super InitDownloadManagerUseCase$execute$2$1> continuation) {
        // this.$parameters = customFileDownloadInput;
        // this.this$0 = initDownloadManagerUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitDownloadManagerUseCase$execute$2$1(this.$parameters, this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitDownloadManagerUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                File file = this.$parameters.getFile();
                this.this$0.setDownloadId(this.this$0.getDownloadManager().enqueue(this.this$0.prepDownloadManager(this.$parameters.getUrlToDownload(), "Downloading File", file)));
                this.this$0.queryTheDownloadProcess(this.$coroutine, DownloadServiceUtils.INSTANCE.prepQuery(this.this$0.getDownloadId()), file, this.this$0.getDownloadId());
            } catch (Exception e2) {
                this.this$0.unSuccessfulUseCase(this.$coroutine, e2.getMessage());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
