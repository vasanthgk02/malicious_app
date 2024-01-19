package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.database.entity.GameAssetResource;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.GameAssetResourceState;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.HashMap;
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
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.usecases.GetGameResourceUseCase$execute$2$1", f = "GetGameResourceUseCase.kt", l = {28}, m = "invokeSuspend")
/* compiled from: GetGameResourceUseCase.kt */
public final class GetGameResourceUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends QueryDownloadStates>> $coroutine;
    public final /* synthetic */ HashMap<String, String> $parameters;
    public int label;
    public final /* synthetic */ GetGameResourceUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GetGameResourceUseCase$execute$2$1(HashMap<String, String> hashMap, GetGameResourceUseCase getGameResourceUseCase, CancellableContinuation<? super UseCaseResult<? extends QueryDownloadStates>> cancellableContinuation, Continuation<? super GetGameResourceUseCase$execute$2$1> continuation) {
        // this.$parameters = hashMap;
        // this.this$0 = getGameResourceUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GetGameResourceUseCase$execute$2$1(this.$parameters, this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GetGameResourceUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            String str = this.$parameters.get("gameId");
            if (str != null) {
                GetGameResourceUseCase getGameResourceUseCase = this.this$0;
                this.label = 1;
                obj = getGameResourceUseCase.getGameResource(str, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                this.$coroutine.resumeWith(new Error(new Exception(GetGameResourceUseCase.INVALID_GAME_ID)));
                return Unit.INSTANCE;
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
        this.$coroutine.resumeWith(new Success(new GameAssetResourceState((GameAssetResource) obj)));
        return Unit.INSTANCE;
    }
}
