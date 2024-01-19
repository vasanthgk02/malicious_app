package com.mpl.androidapp.updater.downloadmanager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.DownloadFeature$runFeature$1", f = "DownloadFeature.kt", l = {50, 59, 61}, m = "invokeSuspend")
/* compiled from: DownloadFeature.kt */
public final class DownloadFeature$runFeature$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object L$0;
    public int label;
    public final /* synthetic */ DownloadFeature this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DownloadFeature$runFeature$1(DownloadFeature downloadFeature, Continuation<? super DownloadFeature$runFeature$1> continuation) {
        // this.this$0 = downloadFeature;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadFeature$runFeature$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadFeature$runFeature$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0027
            if (r1 == r4) goto L_0x001f
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x0083
        L_0x0013:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001b:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x006f
        L_0x001f:
            java.lang.Object r1 = r6.L$0
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature r1 = (com.mpl.androidapp.updater.downloadmanager.DownloadFeature) r1
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x003b
        L_0x0027:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature r1 = r6.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r7 = r1.getDownloadTaskParams()
            r6.L$0 = r1
            r6.label = r4
            java.lang.Object r7 = r1.getGameResource(r7, r6)
            if (r7 != r0) goto L_0x003b
            return r0
        L_0x003b:
            com.mpl.androidapp.database.entity.GameAssetResource r7 = (com.mpl.androidapp.database.entity.GameAssetResource) r7
            r1.setGameAssetResourceFromDb(r7)
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature r7 = r6.this$0
            com.mpl.androidapp.database.entity.GameAssetResource r7 = r7.getGameAssetResourceFromDb()
            r1 = 0
            java.lang.String r5 = "DownloadOfAssets"
            if (r7 != 0) goto L_0x007a
            java.lang.Object[] r7 = new java.lang.Object[r4]
            java.lang.String r4 = "New asset download, current value does not exists in DB"
            r7[r1] = r4
            com.mpl.androidapp.utils.MLogger.d(r5, r7)
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature r7 = r6.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r1 = r7.getDownloadTaskParams()
            r7.publishToAssetAnalytics(r1)
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature r7 = r6.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r1 = r7.getDownloadTaskParams()
            r4 = 0
            r6.L$0 = r4
            r6.label = r3
            java.lang.Object r7 = r7.insertAssetResource(r1, r6)
            if (r7 != r0) goto L_0x006f
            return r0
        L_0x006f:
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature r7 = r6.this$0
            r6.label = r2
            java.lang.Object r7 = r7.launchFunctionality(r6)
            if (r7 != r0) goto L_0x0083
            return r0
        L_0x007a:
            java.lang.Object[] r7 = new java.lang.Object[r4]
            java.lang.String r0 = "Download is already in progress, current value exists in DB"
            r7[r1] = r0
            com.mpl.androidapp.utils.MLogger.d(r5, r7)
        L_0x0083:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.DownloadFeature$runFeature$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
