package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import com.mpl.androidapp.database.entity.GameAssetResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$downloadCompleteCleanup$2", f = "QueryDownload.kt", l = {257, 259, 261, 263, 265}, m = "invokeSuspend")
/* compiled from: QueryDownload.kt */
public final class QueryDownload$downloadCompleteCleanup$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ GameAssetResource $gameResource;
    public int label;
    public final /* synthetic */ QueryDownload this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public QueryDownload$downloadCompleteCleanup$2(QueryDownload queryDownload, GameAssetResource gameAssetResource, Continuation<? super QueryDownload$downloadCompleteCleanup$2> continuation) {
        // this.this$0 = queryDownload;
        // this.$gameResource = gameAssetResource;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QueryDownload$downloadCompleteCleanup$2(this.this$0, this.$gameResource, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QueryDownload$downloadCompleteCleanup$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0084 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r14.label
            r2 = 0
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 == r7) goto L_0x002e
            if (r1 == r6) goto L_0x002a
            if (r1 == r5) goto L_0x0026
            if (r1 == r4) goto L_0x0022
            if (r1 != r3) goto L_0x001a
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r15)
            goto L_0x0085
        L_0x001a:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0022:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r15)
            goto L_0x0076
        L_0x0026:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r15)
            goto L_0x0062
        L_0x002a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r15)
            goto L_0x0055
        L_0x002e:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r15)
            goto L_0x0046
        L_0x0032:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r15)
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r15 = r14.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r1 = r15.getDownloadTaskParams()
            r14.label = r7
            java.lang.String r8 = ""
            java.lang.Object r15 = r15.updateAssetsAnalytics(r2, r8, r1, r14)
            if (r15 != r0) goto L_0x0046
            return r0
        L_0x0046:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r15 = r14.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r1 = r15.getDownloadTaskParams()
            r14.label = r6
            java.lang.Object r15 = r15.extractAssetsCase(r1, r14)
            if (r15 != r0) goto L_0x0055
            return r0
        L_0x0055:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r15 = r14.this$0
            com.mpl.androidapp.database.entity.GameAssetResource r1 = r14.$gameResource
            r14.label = r5
            java.lang.Object r15 = r15.removeDownloadedGameAssetFromDatabase(r1, r14)
            if (r15 != r0) goto L_0x0062
            return r0
        L_0x0062:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r8 = r14.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r9 = r8.getDownloadTaskParams()
            r10 = 100
            r11 = 1
            r12 = 0
            r14.label = r4
            r13 = r14
            java.lang.Object r15 = r8.publishProgress(r9, r10, r11, r12, r13)
            if (r15 != r0) goto L_0x0076
            return r0
        L_0x0076:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r15 = r14.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r1 = r15.getDownloadTaskParams()
            r14.label = r3
            java.lang.Object r15 = r15.deleteFileUseCase(r1, r14)
            if (r15 != r0) goto L_0x0085
            return r0
        L_0x0085:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r15 = r14.this$0
            android.app.DownloadManager r15 = r15.getDownloadManager()
            long[] r0 = new long[r7]
            com.mpl.androidapp.database.entity.GameAssetResource r1 = r14.$gameResource
            long r3 = r1.getDownloadId()
            r0[r2] = r3
            r15.remove(r0)
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r15 = r14.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r15 = r15.getDownloadTaskParams()
            int r15 = r15.getGameId()
            com.mpl.androidapp.utils.AssetsUtils.deleteCurrentlyDownloadingAssetsIds(r15)
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$downloadCompleteCleanup$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
