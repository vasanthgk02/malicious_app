package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.database.entity.GameAssetResource;
import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.UserVisitToOptionalDownload;
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
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitCheckUseCase$execute$2$1", f = "OptionalDownloadVisitCheckUseCase.kt", l = {26}, m = "invokeSuspend")
/* compiled from: OptionalDownloadVisitCheckUseCase.kt */
public final class OptionalDownloadVisitCheckUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends QueryDownloadStates>> $coroutine;
    public final /* synthetic */ String $gameId;
    public int label;
    public final /* synthetic */ OptionalDownloadVisitCheckUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public OptionalDownloadVisitCheckUseCase$execute$2$1(OptionalDownloadVisitCheckUseCase optionalDownloadVisitCheckUseCase, String str, CancellableContinuation<? super UseCaseResult<? extends QueryDownloadStates>> cancellableContinuation, Continuation<? super OptionalDownloadVisitCheckUseCase$execute$2$1> continuation) {
        // this.this$0 = optionalDownloadVisitCheckUseCase;
        // this.$gameId = str;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OptionalDownloadVisitCheckUseCase$execute$2$1(this.this$0, this.$gameId, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OptionalDownloadVisitCheckUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            GameAssetResourceRepo gameAssetResourceRepo = this.this$0.getGameAssetResourceRepo();
            String str = this.$gameId;
            this.label = 1;
            obj = gameAssetResourceRepo.getGameAssetResource(str, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            try {
                TweetUtils.throwOnFailure(obj);
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GameAssetResource gameAssetResource = (GameAssetResource) obj;
        if (gameAssetResource == null) {
            this.$coroutine.resumeWith(new Success(new UserVisitToOptionalDownload(false)));
        } else if (gameAssetResource.getOptScreenUserVisit()) {
            this.$coroutine.resumeWith(new Success(new UserVisitToOptionalDownload(true)));
        } else {
            this.$coroutine.resumeWith(new Success(new UserVisitToOptionalDownload(false)));
        }
        return Unit.INSTANCE;
    }
}
