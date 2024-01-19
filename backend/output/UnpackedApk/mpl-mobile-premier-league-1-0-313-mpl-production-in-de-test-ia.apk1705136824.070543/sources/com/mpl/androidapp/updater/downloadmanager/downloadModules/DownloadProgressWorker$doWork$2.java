package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import androidx.work.ListenableWorker.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker$doWork$2", f = "DownloadProgressWorker.kt", l = {40, 43}, m = "invokeSuspend")
/* compiled from: DownloadProgressWorker.kt */
public final class DownloadProgressWorker$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result>, Object> {
    public Object L$0;
    public int label;
    public final /* synthetic */ DownloadProgressWorker this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DownloadProgressWorker$doWork$2(DownloadProgressWorker downloadProgressWorker, Continuation<? super DownloadProgressWorker$doWork$2> continuation) {
        // this.this$0 = downloadProgressWorker;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadProgressWorker$doWork$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result> continuation) {
        return ((DownloadProgressWorker$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0020
            if (r1 == r3) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            java.lang.Object r0 = r5.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker) r0
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            goto L_0x0067
        L_0x0014:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001c:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            goto L_0x0048
        L_0x0020:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r1 = 0
            java.lang.String r4 = "Work manager Do work method is called"
            r6[r1] = r4
            java.lang.String r1 = "DownloadOfAssets"
            com.mpl.androidapp.utils.MLogger.d(r1, r6)
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker r6 = r5.this$0
            androidx.work.Data r1 = r6.getInputData()
            java.lang.String r4 = "inputData"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            r6.getInputParamsData(r1)
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker r6 = r5.this$0
            r5.label = r3
            java.lang.Object r6 = r6.displayDebugLog(r5)
            if (r6 != r0) goto L_0x0048
            return r0
        L_0x0048:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker r6 = r5.this$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r1 = r6.queryDownload
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker r3 = r5.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r3 = r3.getDownloadTaskParams()
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker r4 = r5.this$0
            boolean r4 = r4.isWebViewFlow()
            r5.L$0 = r6
            r5.label = r2
            java.lang.Object r1 = r1.downloadFileProcess(r3, r4, r5)
            if (r1 != r0) goto L_0x0065
            return r0
        L_0x0065:
            r0 = r6
            r6 = r1
        L_0x0067:
            java.lang.String r6 = (java.lang.String) r6
            r0.setStatus(r6)
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker r6 = r5.this$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r6 = r6.queryDownload
            r6.cleanUp()
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker r6 = r5.this$0
            java.lang.String r6 = r6.getStatus()
            int r0 = r6.hashCode()
            r1 = -670529065(0xffffffffd80889d7, float:-6.005024E14)
            if (r0 == r1) goto L_0x00ad
            r1 = 601036331(0x23d3162b, float:2.2886054E-17)
            if (r0 == r1) goto L_0x009e
            r1 = 2096857181(0x7cfb805d, float:1.044696E37)
            if (r0 == r1) goto L_0x008f
            goto L_0x00b5
        L_0x008f:
            java.lang.String r0 = "Failed"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0098
            goto L_0x00b5
        L_0x0098:
            androidx.work.ListenableWorker$Result$Failure r6 = new androidx.work.ListenableWorker$Result$Failure
            r6.<init>()
            goto L_0x00c0
        L_0x009e:
            java.lang.String r0 = "Completed"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00a7
            goto L_0x00b5
        L_0x00a7:
            androidx.work.ListenableWorker$Result$Success r6 = new androidx.work.ListenableWorker$Result$Success
            r6.<init>()
            goto L_0x00c0
        L_0x00ad:
            java.lang.String r0 = "Invalid"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00bb
        L_0x00b5:
            androidx.work.ListenableWorker$Result$Retry r6 = new androidx.work.ListenableWorker$Result$Retry
            r6.<init>()
            goto L_0x00c0
        L_0x00bb:
            androidx.work.ListenableWorker$Result$Failure r6 = new androidx.work.ListenableWorker$Result$Failure
            r6.<init>()
        L_0x00c0:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgressWorker$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
