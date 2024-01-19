package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import com.mpl.androidapp.database.entity.GameAssetResource;
import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.mpl.androidapp.utils.MLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadFailSafe$clearDownloadIds$2", f = "DownloadFailSafe.kt", l = {68}, m = "invokeSuspend")
/* compiled from: DownloadFailSafe.kt */
public final class DownloadFailSafe$clearDownloadIds$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ List<GameAssetResource> $gameResourceList;
    public Object L$0;
    public int label;
    public final /* synthetic */ DownloadFailSafe this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DownloadFailSafe$clearDownloadIds$2(List<GameAssetResource> list, DownloadFailSafe downloadFailSafe, Continuation<? super DownloadFailSafe$clearDownloadIds$2> continuation) {
        // this.$gameResourceList = list;
        // this.this$0 = downloadFailSafe;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadFailSafe$clearDownloadIds$2(this.$gameResourceList, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadFailSafe$clearDownloadIds$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Iterator it;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            MLogger.d("DownloadOfAssets", "Started clearing download Id's from fail safe");
            if (!this.$gameResourceList.isEmpty()) {
                it = this.$gameResourceList.iterator();
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            it = (Iterator) this.L$0;
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            GameAssetResource gameAssetResource = (GameAssetResource) it.next();
            String downloadFilePath = gameAssetResource.getDownloadFilePath();
            String downloadFileName = gameAssetResource.getDownloadFileName();
            long downloadId = gameAssetResource.getDownloadId();
            MLogger.d("DownloadOfAssets", "DownloadFileName=" + downloadFileName + " with DownloadID=" + downloadId + " is removed");
            File file = new File(downloadFilePath, downloadFileName);
            if (file.exists()) {
                file.delete();
            }
            this.this$0.getDownloadManager().remove(new long[]{downloadId});
            GameAssetResourceRepo gameAssetResourceRepo = this.this$0.getGameAssetResourceRepo();
            this.L$0 = it;
            this.label = 1;
            if (gameAssetResourceRepo.removeGameAssetResource(gameAssetResource, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
