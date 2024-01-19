package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import com.mpl.androidapp.database.entity.GameAssetResource;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadManagerStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$errorInDownload$2", f = "QueryDownload.kt", l = {278, 280, 283, 285}, m = "invokeSuspend")
/* compiled from: QueryDownload.kt */
public final class QueryDownload$errorInDownload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ DownloadManagerStatus $causeOfFailure;
    public final /* synthetic */ GameAssetResource $gameResource;
    public int label;
    public final /* synthetic */ QueryDownload this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public QueryDownload$errorInDownload$2(DownloadManagerStatus downloadManagerStatus, QueryDownload queryDownload, GameAssetResource gameAssetResource, Continuation<? super QueryDownload$errorInDownload$2> continuation) {
        // this.$causeOfFailure = downloadManagerStatus;
        // this.this$0 = queryDownload;
        // this.$gameResource = gameAssetResource;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QueryDownload$errorInDownload$2(this.$causeOfFailure, this.this$0, this.$gameResource, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QueryDownload$errorInDownload$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r13.label
            r2 = 0
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x0027
            if (r1 == r6) goto L_0x0023
            if (r1 == r5) goto L_0x0023
            if (r1 == r4) goto L_0x001f
            if (r1 != r3) goto L_0x0017
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)
            goto L_0x0080
        L_0x0017:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x001f:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)
            goto L_0x006c
        L_0x0023:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)
            goto L_0x005f
        L_0x0027:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)
            java.lang.Object[] r14 = new java.lang.Object[r6]
            java.lang.String r1 = "Error in download so extraction is not possible"
            r14[r2] = r1
            java.lang.String r1 = "DownloadOfAssets"
            com.mpl.androidapp.utils.MLogger.d(r1, r14)
            com.mpl.androidapp.updater.downloadmanager.data.DownloadManagerStatus r14 = r13.$causeOfFailure
            if (r14 != 0) goto L_0x004a
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r14 = r13.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r1 = r14.getDownloadTaskParams()
            r13.label = r6
            java.lang.String r5 = "Unknown error"
            java.lang.Object r14 = r14.updateAssetsAnalytics(r6, r5, r1, r13)
            if (r14 != r0) goto L_0x005f
            return r0
        L_0x004a:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r1 = r13.this$0
            java.lang.String r14 = r14.getFailedReason()
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r7 = r13.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r7 = r7.getDownloadTaskParams()
            r13.label = r5
            java.lang.Object r14 = r1.updateAssetsAnalytics(r6, r14, r7, r13)
            if (r14 != r0) goto L_0x005f
            return r0
        L_0x005f:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r14 = r13.this$0
            com.mpl.androidapp.database.entity.GameAssetResource r1 = r13.$gameResource
            r13.label = r4
            java.lang.Object r14 = r14.removeDownloadedGameAssetFromDatabase(r1, r13)
            if (r14 != r0) goto L_0x006c
            return r0
        L_0x006c:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r7 = r13.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r8 = r7.getDownloadTaskParams()
            r9 = -3333(0xfffffffffffff2fb, float:NaN)
            r10 = 0
            r11 = 1
            r13.label = r3
            r12 = r13
            java.lang.Object r14 = r7.publishProgress(r8, r9, r10, r11, r12)
            if (r14 != r0) goto L_0x0080
            return r0
        L_0x0080:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r14 = r13.this$0
            android.app.DownloadManager r14 = r14.getDownloadManager()
            long[] r0 = new long[r6]
            com.mpl.androidapp.database.entity.GameAssetResource r1 = r13.$gameResource
            long r3 = r1.getDownloadId()
            r0[r2] = r3
            r14.remove(r0)
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r14 = r13.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r14 = r14.getDownloadTaskParams()
            int r14 = r14.getGameId()
            com.mpl.androidapp.utils.AssetsUtils.deleteCurrentlyDownloadingAssetsIds(r14)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$errorInDownload$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
