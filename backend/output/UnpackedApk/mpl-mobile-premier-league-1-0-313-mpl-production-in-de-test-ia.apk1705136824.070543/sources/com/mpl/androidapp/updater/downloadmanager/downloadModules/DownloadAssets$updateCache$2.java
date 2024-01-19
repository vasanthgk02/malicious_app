package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.mpl.androidapp.utils.MLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$updateCache$2", f = "DownloadAssets.kt", l = {127}, m = "invokeSuspend")
/* compiled from: DownloadAssets.kt */
public final class DownloadAssets$updateCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ long $downloadId;
    public final /* synthetic */ String $gameId;
    public int label;
    public final /* synthetic */ DownloadAssets this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$updateCache$2$1", f = "DownloadAssets.kt", l = {128}, m = "invokeSuspend")
    /* renamed from: com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$updateCache$2$1  reason: invalid class name */
    /* compiled from: DownloadAssets.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(downloadAssets, str, j, continuation);
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i == 0) {
                TweetUtils.throwOnFailure(obj);
                GameAssetResourceRepo gameAssetResourceRepo = downloadAssets.getGameAssetResourceRepo();
                String str = str;
                long j = j;
                this.label = 1;
                if (gameAssetResourceRepo.updateGameAssetResource(str, j, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else if (i == 1) {
                TweetUtils.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MLogger.d("DownloadOfAssets", "Download ID added to database");
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DownloadAssets$updateCache$2(DownloadAssets downloadAssets, String str, long j, Continuation<? super DownloadAssets$updateCache$2> continuation) {
        // this.this$0 = downloadAssets;
        // this.$gameId = str;
        // this.$downloadId = j;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DownloadAssets$updateCache$2 downloadAssets$updateCache$2 = new DownloadAssets$updateCache$2(this.this$0, this.$gameId, this.$downloadId, continuation);
        return downloadAssets$updateCache$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadAssets$updateCache$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            CoroutineDispatcher access$getIoDispatcher$p = this.this$0.ioDispatcher;
            final DownloadAssets downloadAssets = this.this$0;
            final String str = this.$gameId;
            final long j = this.$downloadId;
            AnonymousClass1 r3 = new AnonymousClass1(null);
            this.label = 1;
            if (TypeUtilsKt.withContext(access$getIoDispatcher$p, r3, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
