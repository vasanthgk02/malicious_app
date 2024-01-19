package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import com.mpl.androidapp.database.entity.GameAssetResource;
import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/mpl/androidapp/database/entity/GameAssetResource;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadFailSafe$getAllAssetResources$2", f = "DownloadFailSafe.kt", l = {78}, m = "invokeSuspend")
/* compiled from: DownloadFailSafe.kt */
public final class DownloadFailSafe$getAllAssetResources$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends GameAssetResource>>, Object> {
    public int label;
    public final /* synthetic */ DownloadFailSafe this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DownloadFailSafe$getAllAssetResources$2(DownloadFailSafe downloadFailSafe, Continuation<? super DownloadFailSafe$getAllAssetResources$2> continuation) {
        // this.this$0 = downloadFailSafe;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadFailSafe$getAllAssetResources$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<GameAssetResource>> continuation) {
        return ((DownloadFailSafe$getAllAssetResources$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            GameAssetResourceRepo gameAssetResourceRepo = this.this$0.getGameAssetResourceRepo();
            this.label = 1;
            obj = gameAssetResourceRepo.getGameAssetResourceList(this);
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
