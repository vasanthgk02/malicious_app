package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.database.entity.GameAssetResource;
import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/mpl/androidapp/database/entity/GameAssetResource;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.usecases.GetGameResourceUseCase$getGameResource$2", f = "GetGameResourceUseCase.kt", l = {44}, m = "invokeSuspend")
/* compiled from: GetGameResourceUseCase.kt */
public final class GetGameResourceUseCase$getGameResource$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GameAssetResource>, Object> {
    public final /* synthetic */ String $gameId;
    public int label;
    public final /* synthetic */ GetGameResourceUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GetGameResourceUseCase$getGameResource$2(GetGameResourceUseCase getGameResourceUseCase, String str, Continuation<? super GetGameResourceUseCase$getGameResource$2> continuation) {
        // this.this$0 = getGameResourceUseCase;
        // this.$gameId = str;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GetGameResourceUseCase$getGameResource$2(this.this$0, this.$gameId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GameAssetResource> continuation) {
        return ((GetGameResourceUseCase$getGameResource$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
