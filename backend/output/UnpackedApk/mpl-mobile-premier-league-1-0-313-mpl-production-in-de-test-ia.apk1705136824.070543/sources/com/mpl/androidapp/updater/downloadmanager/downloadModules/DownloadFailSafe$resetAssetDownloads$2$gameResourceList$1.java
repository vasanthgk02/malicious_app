package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import com.mpl.androidapp.database.entity.GameAssetResource;
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
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadFailSafe$resetAssetDownloads$2$gameResourceList$1", f = "DownloadFailSafe.kt", l = {32}, m = "invokeSuspend")
/* compiled from: DownloadFailSafe.kt */
public final class DownloadFailSafe$resetAssetDownloads$2$gameResourceList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends GameAssetResource>>, Object> {
    public int label;
    public final /* synthetic */ DownloadFailSafe this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DownloadFailSafe$resetAssetDownloads$2$gameResourceList$1(DownloadFailSafe downloadFailSafe, Continuation<? super DownloadFailSafe$resetAssetDownloads$2$gameResourceList$1> continuation) {
        // this.this$0 = downloadFailSafe;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadFailSafe$resetAssetDownloads$2$gameResourceList$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<GameAssetResource>> continuation) {
        return ((DownloadFailSafe$resetAssetDownloads$2$gameResourceList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            DownloadFailSafe downloadFailSafe = this.this$0;
            this.label = 1;
            obj = downloadFailSafe.getAllAssetResources(this);
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
