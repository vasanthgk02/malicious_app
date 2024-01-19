package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.utils.MLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$download$2", f = "DownloadAssets.kt", l = {73, 77}, m = "invokeSuspend")
/* compiled from: DownloadAssets.kt */
public final class DownloadAssets$download$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ DownloadTaskParams $downloadTaskParams;
    public int label;
    public final /* synthetic */ DownloadAssets this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DownloadAssets$download$2(DownloadTaskParams downloadTaskParams, DownloadAssets downloadAssets, Continuation<? super DownloadAssets$download$2> continuation) {
        // this.$downloadTaskParams = downloadTaskParams;
        // this.this$0 = downloadAssets;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadAssets$download$2(this.$downloadTaskParams, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadAssets$download$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            MLogger.d("DownloadOfAssets", "Download manager is initializing ");
            String url = this.$downloadTaskParams.getUrl();
            String fileName = this.$downloadTaskParams.getFileName();
            long enqueue = this.this$0.getDownloadManager().enqueue(this.this$0.prepDownloadManager(url, fileName, new File(this.$downloadTaskParams.getDownloadPath(), fileName)));
            String valueOf = String.valueOf(this.$downloadTaskParams.getGameId());
            DownloadAssets downloadAssets = this.this$0;
            this.label = 1;
            if (downloadAssets.updateCache(valueOf, enqueue, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            try {
                TweetUtils.throwOnFailure(obj);
            } catch (Exception e2) {
                DownloadAssets downloadAssets2 = this.this$0;
                DownloadTaskParams downloadTaskParams = this.$downloadTaskParams;
                this.label = 2;
                if (downloadAssets2.handleException(e2, downloadTaskParams, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } else if (i == 2) {
            TweetUtils.throwOnFailure(obj);
            this.this$0.cleanUp();
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.cleanUp();
        return Unit.INSTANCE;
    }
}
