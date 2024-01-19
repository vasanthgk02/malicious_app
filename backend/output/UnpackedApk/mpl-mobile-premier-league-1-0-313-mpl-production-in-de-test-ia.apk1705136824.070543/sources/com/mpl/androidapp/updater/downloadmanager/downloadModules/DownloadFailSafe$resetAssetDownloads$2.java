package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadFailSafe$resetAssetDownloads$2", f = "DownloadFailSafe.kt", l = {32, 33}, m = "invokeSuspend")
/* compiled from: DownloadFailSafe.kt */
public final class DownloadFailSafe$resetAssetDownloads$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ DownloadFailSafe this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DownloadFailSafe$resetAssetDownloads$2(DownloadFailSafe downloadFailSafe, Continuation<? super DownloadFailSafe$resetAssetDownloads$2> continuation) {
        // this.this$0 = downloadFailSafe;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadFailSafe$resetAssetDownloads$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadFailSafe$resetAssetDownloads$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcher = Dispatchers.Default;
            DownloadFailSafe$resetAssetDownloads$2$gameResourceList$1 downloadFailSafe$resetAssetDownloads$2$gameResourceList$1 = new DownloadFailSafe$resetAssetDownloads$2$gameResourceList$1(this.this$0, null);
            this.label = 1;
            obj = TypeUtilsKt.withContext(coroutineDispatcher, downloadFailSafe$resetAssetDownloads$2$gameResourceList$1, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else if (i == 2) {
            TweetUtils.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DownloadFailSafe downloadFailSafe = this.this$0;
        this.label = 2;
        if (downloadFailSafe.clearDownloadIds((List) obj, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }
}
