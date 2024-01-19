package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$downloadFileProcess$2", f = "QueryDownload.kt", l = {93, 145, 146, 147, 157, 171, 177, 181, 192, 207}, m = "invokeSuspend")
/* compiled from: QueryDownload.kt */
public final class QueryDownload$downloadFileProcess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    public final /* synthetic */ DownloadTaskParams $params;
    public final /* synthetic */ boolean $webView;
    public int I$0;
    public int I$1;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public Object L$6;
    public int label;
    public final /* synthetic */ QueryDownload this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public QueryDownload$downloadFileProcess$2(QueryDownload queryDownload, boolean z, DownloadTaskParams downloadTaskParams, Continuation<? super QueryDownload$downloadFileProcess$2> continuation) {
        // this.this$0 = queryDownload;
        // this.$webView = z;
        // this.$params = downloadTaskParams;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QueryDownload$downloadFileProcess$2(this.this$0, this.$webView, this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((QueryDownload$downloadFileProcess$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r7v11 */
    /* JADX WARNING: type inference failed for: r8v10, types: [boolean] */
    /* JADX WARNING: type inference failed for: r7v13 */
    /* JADX WARNING: type inference failed for: r7v14 */
    /* JADX WARNING: type inference failed for: r7v21 */
    /* JADX WARNING: type inference failed for: r7v28 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r11v21 */
    /* JADX WARNING: type inference failed for: r7v31 */
    /* JADX WARNING: type inference failed for: r7v32 */
    /* JADX WARNING: type inference failed for: r7v33 */
    /* JADX WARNING: type inference failed for: r7v34 */
    /* JADX WARNING: type inference failed for: r7v35 */
    /* JADX WARNING: type inference failed for: r8v48 */
    /* JADX WARNING: type inference failed for: r11v25 */
    /* JADX WARNING: type inference failed for: r7v36 */
    /* JADX WARNING: type inference failed for: r7v37 */
    /* JADX WARNING: type inference failed for: r8v49 */
    /* JADX WARNING: type inference failed for: r11v26 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0144, code lost:
        r8 = (com.mpl.androidapp.database.entity.GameAssetResource) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0146, code lost:
        if (r8 != null) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0149, code lost:
        r0.this$0.setCurrentGameResource(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x014e, code lost:
        if (r8 == null) goto L_0x03e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0150, code lost:
        com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints.PropertyTimeOne.INSTANCE.logCtEvent(r0.this$0.getDownloadTaskParams().getGameId());
        com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints.PropertyTimeTwo.INSTANCE.getStartPoint();
        r8 = new kotlin.jvm.internal.Ref$BooleanRef();
        r8.element = true;
        r10 = r0;
        r6 = r8;
        r3 = com.mpl.androidapp.updater.downloadmanager.utils.DownloadUtils.INSTANCE.prepareQuery(r0.this$0.getCurrentGameResource().getDownloadId());
        r7 = 1;
        r9 = r2;
        r2 = 4;
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0184, code lost:
        if (r6.element == false) goto L_0x03e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0186, code lost:
        r11 = com.mpl.androidapp.updater.downloadmanager.utils.DownloadUtils.INSTANCE.prepareCursor(r10.this$0.getDownloadManager(), r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0192, code lost:
        if (r11 != null) goto L_0x0196;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0196, code lost:
        r12 = r10.this$0;
        r13 = new java.lang.Object[r7];
        r13[r8] = "While ( downloading = true )";
        com.mpl.androidapp.utils.MLogger.d(r5, r13);
        r13 = new java.lang.Object[r7];
        r13[r8] = "Download cursor opened";
        com.mpl.androidapp.utils.MLogger.d(r5, r13);
        r12.downloadManagerCursorStatus.checkDownloadStatus(r11);
        r13 = r11.getInt(r11.getColumnIndex("bytes_so_far"));
        r14 = r11.getInt(r11.getColumnIndex("total_size"));
        com.mpl.androidapp.updater.downloadmanager.utils.DownloadLogUtils.INSTANCE.printDataBytes(r13, r14);
        r15 = r11.getInt(r11.getColumnIndex("status"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x01d4, code lost:
        if (r15 == r7) goto L_0x03af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x01d7, code lost:
        if (r15 == 2) goto L_0x0382;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x01d9, code lost:
        if (r15 == r2) goto L_0x037d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x01dd, code lost:
        if (r15 == 8) goto L_0x028f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x01e1, code lost:
        if (r15 == 16) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x01e3, code lost:
        r9.element = com.mpl.androidapp.updater.downloadmanager.utils.Constants.DOWNLOAD_STATUS_UNKNOWN;
        r6.element = r8;
        r2 = r12.prepCustomDownloadManagerStatus("Unknown error");
        r7 = r12.getCurrentGameResource();
        r10.L$0 = r9;
        r10.L$1 = r6;
        r10.L$2 = r3;
        r10.L$3 = r3;
        r10.L$4 = r11;
        r10.L$5 = r11;
        r10.L$6 = null;
        r10.label = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x020a, code lost:
        if (r12.errorInDownload(r2, r7, r10) != r1) goto L_0x03b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x020c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x020d, code lost:
        r9.element = com.mpl.androidapp.updater.downloadmanager.utils.Constants.DOWNLOAD_STATUS_FAILED;
        r6.element = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0217, code lost:
        if (r12.isWebViewFlow() == false) goto L_0x026b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0219, code lost:
        r12.publishBroadcast(r13, r14, r8, true);
        r2 = r12.getCurrentGameResource();
        r10.L$0 = r9;
        r10.L$1 = r6;
        r10.L$2 = r3;
        r10.L$3 = r12;
        r10.L$4 = r3;
        r10.L$5 = r11;
        r10.L$6 = r11;
        r10.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0236, code lost:
        if (r12.removeDownloadedGameAssetFromDatabase(r2, r10) != r1) goto L_0x0239;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0238, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0239, code lost:
        r7 = r8;
        r2 = r11;
        r8 = r12;
        r12 = r9;
        r9 = r3;
        r11 = r6;
        r6 = r9;
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0241, code lost:
        r13 = r8.downloadManagerCursorStatus.checkDownloadStatus(r2);
        r14 = r8.getCurrentGameResource();
        r10.L$0 = r12;
        r10.L$1 = r11;
        r10.L$2 = r9;
        r10.L$3 = r6;
        r10.L$4 = r3;
        r10.L$5 = r2;
        r10.L$6 = null;
        r10.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0263, code lost:
        if (r8.errorInDownload(r13, r14, r10) != r1) goto L_0x0266;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0265, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0266, code lost:
        r3 = r9;
        r6 = r11;
        r8 = r12;
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x026b, code lost:
        r7 = r12.downloadManagerCursorStatus.checkDownloadStatus(r11);
        r13 = r12.getCurrentGameResource();
        r10.L$0 = r9;
        r10.L$1 = r6;
        r10.L$2 = r3;
        r10.L$3 = r3;
        r10.L$4 = r11;
        r10.L$5 = r11;
        r10.L$6 = null;
        r10.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x028c, code lost:
        if (r12.errorInDownload(r7, r13, r10) != r1) goto L_0x03b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x028e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x028f, code lost:
        com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints.PropertyTimeTwo.INSTANCE.logCtEvent(r12.getDownloadTaskParams().getGameId());
        r9.element = com.mpl.androidapp.updater.downloadmanager.utils.Constants.DOWNLOAD_STATUS_COMPLETED;
        r6.element = r8;
        com.mpl.androidapp.config.UpdaterAnalytics.gameAssetsDownloadedEvent(r12.getCurrentGameResource().getName(), java.lang.Integer.parseInt(r12.getCurrentGameResource().getGameId()), 100, r8, r12.getDownloadTaskParams().getGameAssets());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x02c7, code lost:
        if (r12.isWebViewFlow() == false) goto L_0x0360;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x02c9, code lost:
        com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints.PropertyTimeThree.INSTANCE.getStartPoint();
        r10.L$0 = r9;
        r10.L$1 = r6;
        r10.L$2 = r3;
        r10.L$3 = r12;
        r10.L$4 = r3;
        r10.L$5 = r11;
        r10.L$6 = r11;
        r10.I$0 = r13;
        r10.I$1 = r14;
        r10.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x02e7, code lost:
        if (r12.copyPokerAssetsFileFromExternalToInternal(r10) != r1) goto L_0x02ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x02e9, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x02ea, code lost:
        r0 = r6;
        r7 = r8;
        r6 = r11;
        r8 = r6;
        r2 = r14;
        r11 = r3;
        r3 = r13;
        r13 = r9;
        r9 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x02f3, code lost:
        r10.L$0 = r13;
        r10.L$1 = r0;
        r10.L$2 = r11;
        r10.L$3 = r12;
        r10.L$4 = r9;
        r10.L$5 = r8;
        r10.L$6 = r6;
        r10.I$0 = r3;
        r10.I$1 = r2;
        r10.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x030c, code lost:
        if (r12.extractPokerAssetsFile(r10) != r1) goto L_0x030f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x030e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x030f, code lost:
        r19 = r12;
        r12 = r0;
        r0 = r8;
        r8 = r19;
        r20 = r10;
        r10 = r9;
        r9 = r11;
        r11 = r20;
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x031b, code lost:
        r14 = r8.getCurrentGameResource();
        r11.L$0 = r13;
        r11.L$1 = r12;
        r11.L$2 = r9;
        r11.L$3 = r8;
        r11.L$4 = r10;
        r11.L$5 = r0;
        r11.L$6 = r6;
        r11.I$0 = r3;
        r11.I$1 = r2;
        r11.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0338, code lost:
        if (r8.removeDownloadedGameAssetFromDatabase(r14, r11) != r1) goto L_0x033b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x033a, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x033b, code lost:
        r0 = r4;
        r10 = r6;
        r15 = r11;
        r14 = r13;
        r4 = r2;
        r11 = r7;
        r2 = r8;
        r13 = r12;
        r12 = r9;
        r9 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0345, code lost:
        com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints.PropertyTimeThree.INSTANCE.logCtEvent(r2.getDownloadTaskParams().getGameId());
        com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload.publishBroadcast$default(r2, r3, r4, true, false, 8, null);
        r2 = 1;
        r5 = r9;
        r3 = r12;
        r6 = r13;
        r9 = r14;
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0360, code lost:
        r0 = r12.getCurrentGameResource();
        r10.L$0 = r9;
        r10.L$1 = r6;
        r10.L$2 = r3;
        r10.L$3 = r3;
        r10.L$4 = r11;
        r10.L$5 = r11;
        r10.L$6 = null;
        r10.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x037a, code lost:
        if (r12.downloadComplete(r0, r10) != r1) goto L_0x03b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x037c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x037d, code lost:
        r9.element = com.mpl.androidapp.updater.downloadmanager.utils.Constants.DOWNLOAD_STATUS_PAUSED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0382, code lost:
        r9.element = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0388, code lost:
        if (r12.isWebViewFlow() == false) goto L_0x0395;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x038a, code lost:
        com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload.publishBroadcast$default(r12, r13, r14, false, false, 12, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0395, code lost:
        r10.L$0 = r9;
        r10.L$1 = r6;
        r10.L$2 = r3;
        r10.L$3 = r3;
        r10.L$4 = r11;
        r10.L$5 = r11;
        r10.L$6 = null;
        r10.label = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x03ac, code lost:
        if (r12.currentProgressToDisplayedProgressBar(r13, r14, r10) != r1) goto L_0x03b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x03ae, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x03af, code lost:
        r9.element = com.mpl.androidapp.updater.downloadmanager.utils.Constants.DOWNLOAD_STATUS_PENDING;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x03b3, code lost:
        r7 = r8;
        r8 = r9;
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x03b6, code lost:
        r0 = r4;
        r11 = r7;
        r9 = r8;
        r15 = r10;
        r10 = r2;
        r2 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x03bd, code lost:
        r4 = new java.lang.Object[r2];
        r4[r11] = kotlin.jvm.internal.Intrinsics.stringPlus("Download Manager download status:-> ", r9.element);
        com.mpl.androidapp.utils.MLogger.d(r5, r4);
        r10.close();
        r4 = new java.lang.Object[r2];
        r4[r11] = "Download cursor closed";
        com.mpl.androidapp.utils.MLogger.d(r5, r4);
        r4 = r0;
        r7 = r2;
        r8 = r11;
        r10 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x03dc, code lost:
        r2 = 4;
        r0 = r21;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x03e1, code lost:
        r6 = r7;
        r7 = r8;
        r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x03e5, code lost:
        r2.element = com.mpl.androidapp.updater.downloadmanager.utils.Constants.DOWNLOAD_STATUS_INVALID;
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x03e9, code lost:
        r0 = new java.lang.Object[r6];
        r0[r7] = com.android.tools.r8.GeneratedOutlineSupport.outline62(com.android.tools.r8.GeneratedOutlineSupport.outline73("Work manager on status "), (java.lang.String) r2.element, " is returned");
        com.mpl.androidapp.utils.MLogger.d(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0402, code lost:
        return r2.element;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r8v0
      assigns: []
      uses: []
      mth insns count: 445
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 10 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 4
            java.lang.String r4 = "Running"
            java.lang.String r5 = "DownloadOfAssets"
            r6 = 1
            r7 = 0
            switch(r2) {
                case 0: goto L_0x00eb;
                case 1: goto L_0x00e1;
                case 2: goto L_0x00b6;
                case 3: goto L_0x0089;
                case 4: goto L_0x005a;
                case 5: goto L_0x0018;
                case 6: goto L_0x0036;
                case 7: goto L_0x0018;
                case 8: goto L_0x0018;
                case 9: goto L_0x0018;
                case 10: goto L_0x0018;
                default: goto L_0x0010;
            }
        L_0x0010:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0018:
            java.lang.Object r2 = r0.L$5
            android.database.Cursor r2 = (android.database.Cursor) r2
            java.lang.Object r3 = r0.L$4
            android.database.Cursor r3 = (android.database.Cursor) r3
            java.lang.Object r3 = r0.L$3
            android.app.DownloadManager$Query r3 = (android.app.DownloadManager.Query) r3
            java.lang.Object r3 = r0.L$2
            android.app.DownloadManager$Query r3 = (android.app.DownloadManager.Query) r3
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.internal.Ref$BooleanRef r6 = (kotlin.jvm.internal.Ref$BooleanRef) r6
            java.lang.Object r8 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref$ObjectRef) r8
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r22)
            r10 = r0
            goto L_0x03b6
        L_0x0036:
            java.lang.Object r2 = r0.L$6
            android.database.Cursor r2 = (android.database.Cursor) r2
            java.lang.Object r3 = r0.L$5
            android.database.Cursor r3 = (android.database.Cursor) r3
            java.lang.Object r6 = r0.L$4
            android.app.DownloadManager$Query r6 = (android.app.DownloadManager.Query) r6
            java.lang.Object r8 = r0.L$3
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r8 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload) r8
            java.lang.Object r9 = r0.L$2
            android.app.DownloadManager$Query r9 = (android.app.DownloadManager.Query) r9
            java.lang.Object r10 = r0.L$1
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref$BooleanRef) r10
            java.lang.Object r11 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref$ObjectRef) r11
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r22)
            r12 = r11
            r11 = r10
            r10 = r0
            goto L_0x0241
        L_0x005a:
            int r2 = r0.I$1
            int r3 = r0.I$0
            java.lang.Object r6 = r0.L$6
            android.database.Cursor r6 = (android.database.Cursor) r6
            java.lang.Object r8 = r0.L$5
            android.database.Cursor r8 = (android.database.Cursor) r8
            java.lang.Object r8 = r0.L$4
            android.app.DownloadManager$Query r8 = (android.app.DownloadManager.Query) r8
            java.lang.Object r8 = r0.L$3
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r8 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload) r8
            java.lang.Object r9 = r0.L$2
            android.app.DownloadManager$Query r9 = (android.app.DownloadManager.Query) r9
            java.lang.Object r10 = r0.L$1
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref$BooleanRef) r10
            java.lang.Object r11 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref$ObjectRef) r11
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r22)
            r15 = r0
            r0 = r4
            r12 = r9
            r13 = r10
            r14 = r11
            r11 = 0
            r4 = r2
            r9 = r5
            r10 = r6
            r2 = r8
            goto L_0x0345
        L_0x0089:
            int r2 = r0.I$1
            int r3 = r0.I$0
            java.lang.Object r6 = r0.L$6
            android.database.Cursor r6 = (android.database.Cursor) r6
            java.lang.Object r8 = r0.L$5
            android.database.Cursor r8 = (android.database.Cursor) r8
            java.lang.Object r9 = r0.L$4
            android.app.DownloadManager$Query r9 = (android.app.DownloadManager.Query) r9
            java.lang.Object r10 = r0.L$3
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r10 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload) r10
            java.lang.Object r11 = r0.L$2
            android.app.DownloadManager$Query r11 = (android.app.DownloadManager.Query) r11
            java.lang.Object r12 = r0.L$1
            kotlin.jvm.internal.Ref$BooleanRef r12 = (kotlin.jvm.internal.Ref$BooleanRef) r12
            java.lang.Object r13 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref$ObjectRef) r13
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r22)
            r19 = r11
            r11 = r0
            r0 = r8
            r8 = r10
            r10 = r9
            r9 = r19
            goto L_0x031b
        L_0x00b6:
            int r2 = r0.I$1
            int r3 = r0.I$0
            java.lang.Object r6 = r0.L$6
            android.database.Cursor r6 = (android.database.Cursor) r6
            java.lang.Object r8 = r0.L$5
            android.database.Cursor r8 = (android.database.Cursor) r8
            java.lang.Object r9 = r0.L$4
            android.app.DownloadManager$Query r9 = (android.app.DownloadManager.Query) r9
            java.lang.Object r10 = r0.L$3
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r10 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload) r10
            java.lang.Object r11 = r0.L$2
            android.app.DownloadManager$Query r11 = (android.app.DownloadManager.Query) r11
            java.lang.Object r12 = r0.L$1
            kotlin.jvm.internal.Ref$BooleanRef r12 = (kotlin.jvm.internal.Ref$BooleanRef) r12
            java.lang.Object r13 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref$ObjectRef) r13
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r22)
            r19 = r10
            r10 = r0
            r0 = r12
            r12 = r19
            goto L_0x02f3
        L_0x00e1:
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r22)
            r8 = r22
            goto L_0x0144
        L_0x00eb:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r22)
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.String r8 = "QueryDownload downloadFileProcess is initiated "
            r2[r7] = r8
            com.mpl.androidapp.utils.MLogger.d(r5, r2)
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r2 = r0.this$0
            boolean r8 = r0.$webView
            r2.setWebViewFlow(r8)
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r2 = r0.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r8 = r0.$params
            r2.setDownloadTaskParams(r8)
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r2 = r0.this$0
            java.util.HashMap r2 = r2.idProgress
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r8 = r0.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r8 = r8.getDownloadTaskParams()
            int r8 = r8.getGameId()
            java.lang.Integer r9 = new java.lang.Integer
            r9.<init>(r8)
            java.lang.Integer r8 = new java.lang.Integer
            r8.<init>(r7)
            r2.put(r9, r8)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            r2.element = r4
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r8 = r0.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r8 = r8.getDownloadTaskParams()
            int r8 = r8.getGameId()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r9 = r0.this$0
            r0.L$0 = r2
            r0.label = r6
            java.lang.Object r8 = r9.getGameResource(r8, r0)
            if (r8 != r1) goto L_0x0144
            return r1
        L_0x0144:
            com.mpl.androidapp.database.entity.GameAssetResource r8 = (com.mpl.androidapp.database.entity.GameAssetResource) r8
            if (r8 != 0) goto L_0x0149
            goto L_0x014e
        L_0x0149:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r9 = r0.this$0
            r9.setCurrentGameResource(r8)
        L_0x014e:
            if (r8 == 0) goto L_0x03e5
            com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints$PropertyTimeOne r8 = com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints.PropertyTimeOne.INSTANCE
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r9 = r0.this$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r9 = r9.getDownloadTaskParams()
            int r9 = r9.getGameId()
            r8.logCtEvent(r9)
            com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints$PropertyTimeTwo r8 = com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints.PropertyTimeTwo.INSTANCE
            r8.getStartPoint()
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            r8.element = r6
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r9 = r0.this$0
            com.mpl.androidapp.database.entity.GameAssetResource r9 = r9.getCurrentGameResource()
            long r9 = r9.getDownloadId()
            com.mpl.androidapp.updater.downloadmanager.utils.DownloadUtils r11 = com.mpl.androidapp.updater.downloadmanager.utils.DownloadUtils.INSTANCE
            android.app.DownloadManager$Query r9 = r11.prepareQuery(r9)
            r10 = r0
            r6 = r8
            r3 = r9
            r7 = 1
            r8 = 0
            r9 = r2
            r2 = 4
        L_0x0182:
            boolean r11 = r6.element
            if (r11 == 0) goto L_0x03e1
            com.mpl.androidapp.updater.downloadmanager.utils.DownloadUtils r11 = com.mpl.androidapp.updater.downloadmanager.utils.DownloadUtils.INSTANCE
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r12 = r10.this$0
            android.app.DownloadManager r12 = r12.getDownloadManager()
            android.database.Cursor r11 = r11.prepareCursor(r12, r3)
            if (r11 != 0) goto L_0x0196
            goto L_0x03dc
        L_0x0196:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r12 = r10.this$0
            java.lang.Object[] r13 = new java.lang.Object[r7]
            java.lang.String r14 = "While ( downloading = true )"
            r13[r8] = r14
            com.mpl.androidapp.utils.MLogger.d(r5, r13)
            java.lang.Object[] r13 = new java.lang.Object[r7]
            java.lang.String r14 = "Download cursor opened"
            r13[r8] = r14
            com.mpl.androidapp.utils.MLogger.d(r5, r13)
            com.mpl.androidapp.updater.downloadmanager.utils.DownloadManagerCursorStatus r13 = r12.downloadManagerCursorStatus
            r13.checkDownloadStatus(r11)
            java.lang.String r13 = "bytes_so_far"
            int r13 = r11.getColumnIndex(r13)
            int r13 = r11.getInt(r13)
            java.lang.String r14 = "total_size"
            int r14 = r11.getColumnIndex(r14)
            int r14 = r11.getInt(r14)
            com.mpl.androidapp.updater.downloadmanager.utils.DownloadLogUtils r15 = com.mpl.androidapp.updater.downloadmanager.utils.DownloadLogUtils.INSTANCE
            r15.printDataBytes(r13, r14)
            java.lang.String r15 = "status"
            int r15 = r11.getColumnIndex(r15)
            int r15 = r11.getInt(r15)
            if (r15 == r7) goto L_0x03af
            r7 = 2
            if (r15 == r7) goto L_0x0382
            if (r15 == r2) goto L_0x037d
            r2 = 8
            if (r15 == r2) goto L_0x028f
            r7 = 16
            if (r15 == r7) goto L_0x020d
            java.lang.String r2 = "Unknown"
            r9.element = r2
            r6.element = r8
            java.lang.String r2 = "Unknown error"
            com.mpl.androidapp.updater.downloadmanager.data.DownloadManagerStatus r2 = r12.prepCustomDownloadManagerStatus(r2)
            com.mpl.androidapp.database.entity.GameAssetResource r7 = r12.getCurrentGameResource()
            r10.L$0 = r9
            r10.L$1 = r6
            r10.L$2 = r3
            r10.L$3 = r3
            r10.L$4 = r11
            r10.L$5 = r11
            r13 = 0
            r10.L$6 = r13
            r13 = 10
            r10.label = r13
            java.lang.Object r2 = r12.errorInDownload(r2, r7, r10)
            if (r2 != r1) goto L_0x03b3
            return r1
        L_0x020d:
            java.lang.String r7 = "Failed"
            r9.element = r7
            r6.element = r8
            boolean r7 = r12.isWebViewFlow()
            if (r7 == 0) goto L_0x026b
            r2 = 1
            r12.publishBroadcast(r13, r14, r8, r2)
            com.mpl.androidapp.database.entity.GameAssetResource r2 = r12.getCurrentGameResource()
            r10.L$0 = r9
            r10.L$1 = r6
            r10.L$2 = r3
            r10.L$3 = r12
            r10.L$4 = r3
            r10.L$5 = r11
            r10.L$6 = r11
            r7 = 6
            r10.label = r7
            java.lang.Object r2 = r12.removeDownloadedGameAssetFromDatabase(r2, r10)
            if (r2 != r1) goto L_0x0239
            return r1
        L_0x0239:
            r7 = r8
            r2 = r11
            r8 = r12
            r12 = r9
            r9 = r3
            r11 = r6
            r6 = r9
            r3 = r2
        L_0x0241:
            com.mpl.androidapp.updater.downloadmanager.utils.DownloadManagerCursorStatus r13 = r8.downloadManagerCursorStatus
            com.mpl.androidapp.updater.downloadmanager.data.DownloadManagerStatus r13 = r13.checkDownloadStatus(r2)
            com.mpl.androidapp.database.entity.GameAssetResource r14 = r8.getCurrentGameResource()
            r10.L$0 = r12
            r10.L$1 = r11
            r10.L$2 = r9
            r10.L$3 = r6
            r10.L$4 = r3
            r10.L$5 = r2
            r3 = 0
            r10.L$6 = r3
            r3 = 7
            r10.label = r3
            java.lang.Object r3 = r8.errorInDownload(r13, r14, r10)
            if (r3 != r1) goto L_0x0266
            return r1
        L_0x0266:
            r3 = r9
            r6 = r11
            r8 = r12
            goto L_0x03b6
        L_0x026b:
            com.mpl.androidapp.updater.downloadmanager.utils.DownloadManagerCursorStatus r7 = r12.downloadManagerCursorStatus
            com.mpl.androidapp.updater.downloadmanager.data.DownloadManagerStatus r7 = r7.checkDownloadStatus(r11)
            com.mpl.androidapp.database.entity.GameAssetResource r13 = r12.getCurrentGameResource()
            r10.L$0 = r9
            r10.L$1 = r6
            r10.L$2 = r3
            r10.L$3 = r3
            r10.L$4 = r11
            r10.L$5 = r11
            r14 = 0
            r10.L$6 = r14
            r10.label = r2
            java.lang.Object r2 = r12.errorInDownload(r7, r13, r10)
            if (r2 != r1) goto L_0x03b3
            return r1
        L_0x028f:
            com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints$PropertyTimeTwo r2 = com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints.PropertyTimeTwo.INSTANCE
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r7 = r12.getDownloadTaskParams()
            int r7 = r7.getGameId()
            r2.logCtEvent(r7)
            java.lang.String r2 = "Completed"
            r9.element = r2
            r6.element = r8
            com.mpl.androidapp.database.entity.GameAssetResource r2 = r12.getCurrentGameResource()
            java.lang.String r2 = r2.getName()
            com.mpl.androidapp.database.entity.GameAssetResource r7 = r12.getCurrentGameResource()
            java.lang.String r7 = r7.getGameId()
            int r7 = java.lang.Integer.parseInt(r7)
            r15 = 100
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r16 = r12.getDownloadTaskParams()
            com.mpl.androidapp.updater.model.GameAssets r0 = r16.getGameAssets()
            com.mpl.androidapp.config.UpdaterAnalytics.gameAssetsDownloadedEvent(r2, r7, r15, r8, r0)
            boolean r0 = r12.isWebViewFlow()
            if (r0 == 0) goto L_0x0360
            com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints$PropertyTimeThree r0 = com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints.PropertyTimeThree.INSTANCE
            r0.getStartPoint()
            r10.L$0 = r9
            r10.L$1 = r6
            r10.L$2 = r3
            r10.L$3 = r12
            r10.L$4 = r3
            r10.L$5 = r11
            r10.L$6 = r11
            r10.I$0 = r13
            r10.I$1 = r14
            r0 = 2
            r10.label = r0
            java.lang.Object r0 = r12.copyPokerAssetsFileFromExternalToInternal(r10)
            if (r0 != r1) goto L_0x02ea
            return r1
        L_0x02ea:
            r0 = r6
            r7 = r8
            r6 = r11
            r8 = r6
            r2 = r14
            r11 = r3
            r3 = r13
            r13 = r9
            r9 = r11
        L_0x02f3:
            r10.L$0 = r13
            r10.L$1 = r0
            r10.L$2 = r11
            r10.L$3 = r12
            r10.L$4 = r9
            r10.L$5 = r8
            r10.L$6 = r6
            r10.I$0 = r3
            r10.I$1 = r2
            r14 = 3
            r10.label = r14
            java.lang.Object r14 = r12.extractPokerAssetsFile(r10)
            if (r14 != r1) goto L_0x030f
            return r1
        L_0x030f:
            r19 = r12
            r12 = r0
            r0 = r8
            r8 = r19
            r20 = r10
            r10 = r9
            r9 = r11
            r11 = r20
        L_0x031b:
            com.mpl.androidapp.database.entity.GameAssetResource r14 = r8.getCurrentGameResource()
            r11.L$0 = r13
            r11.L$1 = r12
            r11.L$2 = r9
            r11.L$3 = r8
            r11.L$4 = r10
            r11.L$5 = r0
            r11.L$6 = r6
            r11.I$0 = r3
            r11.I$1 = r2
            r0 = 4
            r11.label = r0
            java.lang.Object r0 = r8.removeDownloadedGameAssetFromDatabase(r14, r11)
            if (r0 != r1) goto L_0x033b
            return r1
        L_0x033b:
            r0 = r4
            r10 = r6
            r15 = r11
            r14 = r13
            r4 = r2
            r11 = r7
            r2 = r8
            r13 = r12
            r12 = r9
            r9 = r5
        L_0x0345:
            com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints$PropertyTimeThree r5 = com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints.PropertyTimeThree.INSTANCE
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r6 = r2.getDownloadTaskParams()
            int r6 = r6.getGameId()
            r5.logCtEvent(r6)
            r5 = 1
            r6 = 0
            r7 = 8
            r8 = 0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload.publishBroadcast$default(r2, r3, r4, r5, r6, r7, r8)
            r2 = 1
            r5 = r9
            r3 = r12
            r6 = r13
            r9 = r14
            goto L_0x03bd
        L_0x0360:
            com.mpl.androidapp.database.entity.GameAssetResource r0 = r12.getCurrentGameResource()
            r10.L$0 = r9
            r10.L$1 = r6
            r10.L$2 = r3
            r10.L$3 = r3
            r10.L$4 = r11
            r10.L$5 = r11
            r2 = 0
            r10.L$6 = r2
            r2 = 5
            r10.label = r2
            java.lang.Object r0 = r12.downloadComplete(r0, r10)
            if (r0 != r1) goto L_0x03b3
            return r1
        L_0x037d:
            java.lang.String r0 = "Paused"
            r9.element = r0
            goto L_0x03b3
        L_0x0382:
            r9.element = r4
            boolean r0 = r12.isWebViewFlow()
            if (r0 == 0) goto L_0x0395
            r15 = 0
            r16 = 0
            r17 = 12
            r18 = 0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload.publishBroadcast$default(r12, r13, r14, r15, r16, r17, r18)
            goto L_0x03b3
        L_0x0395:
            r10.L$0 = r9
            r10.L$1 = r6
            r10.L$2 = r3
            r10.L$3 = r3
            r10.L$4 = r11
            r10.L$5 = r11
            r0 = 0
            r10.L$6 = r0
            r0 = 9
            r10.label = r0
            java.lang.Object r0 = r12.currentProgressToDisplayedProgressBar(r13, r14, r10)
            if (r0 != r1) goto L_0x03b3
            return r1
        L_0x03af:
            java.lang.String r0 = "Pending"
            r9.element = r0
        L_0x03b3:
            r7 = r8
            r8 = r9
            r2 = r11
        L_0x03b6:
            r0 = 1
            r0 = r4
            r11 = r7
            r9 = r8
            r15 = r10
            r10 = r2
            r2 = 1
        L_0x03bd:
            java.lang.Object[] r4 = new java.lang.Object[r2]
            T r7 = r9.element
            java.lang.String r8 = "Download Manager download status:-> "
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r7)
            r4[r11] = r7
            com.mpl.androidapp.utils.MLogger.d(r5, r4)
            r10.close()
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r7 = "Download cursor closed"
            r4[r11] = r7
            com.mpl.androidapp.utils.MLogger.d(r5, r4)
            r4 = r0
            r7 = r2
            r8 = r11
            r10 = r15
        L_0x03dc:
            r2 = 4
            r0 = r21
            goto L_0x0182
        L_0x03e1:
            r6 = r7
            r7 = r8
            r2 = r9
            goto L_0x03e9
        L_0x03e5:
            java.lang.String r0 = "Invalid"
            r2.element = r0
        L_0x03e9:
            java.lang.Object[] r0 = new java.lang.Object[r6]
            java.lang.String r1 = "Work manager on status "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            T r3 = r2.element
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = " is returned"
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r1, r3, r4)
            r0[r7] = r1
            com.mpl.androidapp.utils.MLogger.d(r5, r0)
            T r0 = r2.element
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$downloadFileProcess$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
