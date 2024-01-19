package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.net.Uri;
import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.InitialState;
import com.mpl.androidapp.updater.downloadmanager.usecases.GetGameResourceUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.PublishProgressUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.RemoveGameResourceUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.UpdateAssetsAnalyticsUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.DownloadUtils;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BK\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\b\u0010%\u001a\u00020&H\u0002J\u0019\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H@ø\u0001\u0000¢\u0006\u0002\u0010*J\u001b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.H@ø\u0001\u0000¢\u0006\u0002\u0010/J%\u00100\u001a\u00020&2\n\u00101\u001a\u000602j\u0002`32\u0006\u0010(\u001a\u00020)H@ø\u0001\u0000¢\u0006\u0002\u00104J \u00105\u001a\u0002062\u0006\u00107\u001a\u00020.2\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020:H\u0002J)\u0010;\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H@ø\u0001\u0000¢\u0006\u0002\u0010@J\u0019\u0010A\u001a\u00020&2\u0006\u0010B\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0002\u0010CJ)\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020?2\u0006\u0010F\u001a\u00020.2\u0006\u0010(\u001a\u00020)H@ø\u0001\u0000¢\u0006\u0002\u0010GJ!\u0010H\u001a\u00020&2\u0006\u0010-\u001a\u00020.2\u0006\u0010I\u001a\u00020JH@ø\u0001\u0000¢\u0006\u0002\u0010KR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006L"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/DownloadAssets;", "Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/Download;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Landroid/content/Context;", "downloadManager", "Landroid/app/DownloadManager;", "gameAssetResourceRepo", "Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "updateAssetsAnalyticsUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/UpdateAssetsAnalyticsUseCase;", "publishProgressUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/PublishProgressUseCase;", "getGameResourceUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/GetGameResourceUseCase;", "removeGameResourceUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/RemoveGameResourceUseCase;", "(Landroid/content/Context;Landroid/app/DownloadManager;Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/mpl/androidapp/updater/downloadmanager/usecases/UpdateAssetsAnalyticsUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/PublishProgressUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/GetGameResourceUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/RemoveGameResourceUseCase;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getDownloadManager", "()Landroid/app/DownloadManager;", "setDownloadManager", "(Landroid/app/DownloadManager;)V", "getGameAssetResourceRepo", "()Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;", "queryDownloadState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "cleanUp", "", "download", "downloadTaskParams", "Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "(Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGameResource", "Lcom/mpl/androidapp/database/entity/GameAssetResource;", "gameId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleException", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepDownloadManager", "Landroid/app/DownloadManager$Request;", "urlToDownload", "fileName", "file", "Ljava/io/File;", "publishProgress", "code", "", "isProgressComplete", "", "(Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeDownloadedGameAssetFromDatabase", "gameResource", "(Lcom/mpl/androidapp/database/entity/GameAssetResource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAssetsAnalytics", "errorOnDownload", "failedReason", "(ZLjava/lang/String;Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCache", "downloadId", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadAssets.kt */
public final class DownloadAssets implements Download, CoroutineScope {
    public Context context;
    public DownloadManager downloadManager;
    public final GameAssetResourceRepo gameAssetResourceRepo;
    public final GetGameResourceUseCase getGameResourceUseCase;
    public final CoroutineDispatcher ioDispatcher;
    public final PublishProgressUseCase publishProgressUseCase;
    public MutableStateFlow<QueryDownloadStates> queryDownloadState;
    public final RemoveGameResourceUseCase removeGameResourceUseCase;
    public final UpdateAssetsAnalyticsUseCase updateAssetsAnalyticsUseCase;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$1", f = "DownloadAssets.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$1  reason: invalid class name */
    /* compiled from: DownloadAssets.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;
        public final /* synthetic */ DownloadAssets this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                TweetUtils.throwOnFailure(obj);
                this.this$0.queryDownloadState = StateFlowKt.MutableStateFlow(InitialState.INSTANCE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DownloadAssets(Context context2, DownloadManager downloadManager2, GameAssetResourceRepo gameAssetResourceRepo2, @IoDispatcher CoroutineDispatcher coroutineDispatcher, UpdateAssetsAnalyticsUseCase updateAssetsAnalyticsUseCase2, PublishProgressUseCase publishProgressUseCase2, GetGameResourceUseCase getGameResourceUseCase2, RemoveGameResourceUseCase removeGameResourceUseCase2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(downloadManager2, "downloadManager");
        Intrinsics.checkNotNullParameter(gameAssetResourceRepo2, "gameAssetResourceRepo");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(updateAssetsAnalyticsUseCase2, "updateAssetsAnalyticsUseCase");
        Intrinsics.checkNotNullParameter(publishProgressUseCase2, "publishProgressUseCase");
        Intrinsics.checkNotNullParameter(getGameResourceUseCase2, "getGameResourceUseCase");
        Intrinsics.checkNotNullParameter(removeGameResourceUseCase2, "removeGameResourceUseCase");
        this.context = context2;
        this.downloadManager = downloadManager2;
        this.gameAssetResourceRepo = gameAssetResourceRepo2;
        this.ioDispatcher = coroutineDispatcher;
        this.updateAssetsAnalyticsUseCase = updateAssetsAnalyticsUseCase2;
        this.publishProgressUseCase = publishProgressUseCase2;
        this.getGameResourceUseCase = getGameResourceUseCase2;
        this.removeGameResourceUseCase = removeGameResourceUseCase2;
        TypeUtilsKt.launch$default(this, null, null, new AnonymousClass1(this, null), 3, null);
    }

    /* access modifiers changed from: private */
    public final void cleanUp() {
        TypeUtilsKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getGameResource(java.lang.String r5, kotlin.coroutines.Continuation<? super com.mpl.androidapp.database.entity.GameAssetResource> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$getGameResource$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$getGameResource$1 r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$getGameResource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$getGameResource$1 r0 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$getGameResource$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            java.lang.Object r5 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets r5 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets) r5
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            goto L_0x004e
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0033:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r2 = "gameId"
            r6.put(r2, r5)
            com.mpl.androidapp.updater.downloadmanager.usecases.GetGameResourceUseCase r5 = r4.getGameResourceUseCase
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r5.invoke(r6, r0)
            if (r6 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r5 = r4
        L_0x004e:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r6
            boolean r0 = r6 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            java.lang.String r1 = "queryDownloadState"
            r2 = 0
            if (r0 == 0) goto L_0x007f
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r6
            java.lang.Object r6 = r6.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r6
            java.lang.Object r6 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r6)
            if (r6 == 0) goto L_0x0077
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$GameAssetResourceState r6 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.GameAssetResourceState) r6
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates> r5 = r5.queryDownloadState
            if (r5 == 0) goto L_0x0073
            r5.setValue(r6)
            com.mpl.androidapp.database.entity.GameAssetResource r5 = r6.getGameAssetResource()
            return r5
        L_0x0073:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            throw r2
        L_0x0077:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.GameAssetResourceState"
            r5.<init>(r6)
            throw r5
        L_0x007f:
            boolean r0 = r6 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r0 == 0) goto L_0x00a2
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates> r5 = r5.queryDownloadState
            if (r5 == 0) goto L_0x009e
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$ErrorState r0 = new com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$ErrorState
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r6
            java.lang.Exception r6 = r6.getException()
            java.lang.String r6 = r6.getMessage()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r0.<init>(r6)
            r5.setValue(r0)
            goto L_0x00a2
        L_0x009e:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            throw r2
        L_0x00a2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets.getGameResource(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleException(java.lang.Exception r11, com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$handleException$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$handleException$1 r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$handleException$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$handleException$1 r0 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$handleException$1
            r0.<init>(r10, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            java.lang.String r4 = "Exception Thrown by download manager:-> "
            r5 = 0
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            if (r2 == 0) goto L_0x0071
            if (r2 == r9) goto L_0x0060
            if (r2 == r8) goto L_0x004e
            if (r2 == r7) goto L_0x0041
            if (r2 != r6) goto L_0x0039
            java.lang.Object r11 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r11 = (com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams) r11
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)
            goto L_0x00d1
        L_0x0039:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0041:
            java.lang.Object r11 = r0.L$1
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r11 = (com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams) r11
            java.lang.Object r12 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets r12 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets) r12
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)
            goto L_0x00c2
        L_0x004e:
            java.lang.Object r11 = r0.L$2
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r11 = (com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams) r11
            java.lang.Object r12 = r0.L$1
            java.lang.Exception r12 = (java.lang.Exception) r12
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets r2 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)
            r13 = r12
        L_0x005e:
            r12 = r2
            goto L_0x00af
        L_0x0060:
            java.lang.Object r11 = r0.L$2
            r12 = r11
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r12 = (com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams) r12
            java.lang.Object r11 = r0.L$1
            java.lang.Exception r11 = (java.lang.Exception) r11
            java.lang.Object r2 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets r2 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)
            goto L_0x0099
        L_0x0071:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r13)
            java.lang.Object[] r13 = new java.lang.Object[r9]
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r11)
            r13[r5] = r2
            java.lang.String r2 = "DownloadOfAssets"
            com.mpl.androidapp.utils.MLogger.d(r2, r13)
            int r13 = r12.getGameId()
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.label = r9
            java.lang.Object r13 = r10.getGameResource(r13, r0)
            if (r13 != r1) goto L_0x0098
            return r1
        L_0x0098:
            r2 = r10
        L_0x0099:
            com.mpl.androidapp.database.entity.GameAssetResource r13 = (com.mpl.androidapp.database.entity.GameAssetResource) r13
            if (r13 == 0) goto L_0x00d8
            r0.L$0 = r2
            r0.L$1 = r11
            r0.L$2 = r12
            r0.label = r8
            java.lang.Object r13 = r2.removeDownloadedGameAssetFromDatabase(r13, r0)
            if (r13 != r1) goto L_0x00ac
            return r1
        L_0x00ac:
            r13 = r11
            r11 = r12
            goto L_0x005e
        L_0x00af:
            java.lang.String r13 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r13)
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r3
            r0.label = r7
            java.lang.Object r13 = r12.updateAssetsAnalytics(r9, r13, r11, r0)
            if (r13 != r1) goto L_0x00c2
            return r1
        L_0x00c2:
            r13 = -3333(0xfffffffffffff2fb, float:NaN)
            r0.L$0 = r11
            r0.L$1 = r3
            r0.label = r6
            java.lang.Object r12 = r12.publishProgress(r11, r13, r5, r0)
            if (r12 != r1) goto L_0x00d1
            return r1
        L_0x00d1:
            int r11 = r11.getGameId()
            com.mpl.androidapp.utils.AssetsUtils.deleteCurrentlyDownloadingAssetsIds(r11)
        L_0x00d8:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets.handleException(java.lang.Exception, com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Request prepDownloadManager(String str, String str2, File file) {
        if (DownloadUtils.INSTANCE.isDownloadManagerEqualOrAboveNougat()) {
            Request request = new Request(Uri.parse(str));
            request.setTitle(str2);
            request.setNotificationVisibility(2);
            request.setDestinationUri(Uri.fromFile(file));
            request.setRequiresCharging(false);
            request.setAllowedOverMetered(true);
            request.setAllowedOverRoaming(true);
            return request;
        }
        Request request2 = new Request(Uri.parse(str));
        request2.setTitle(str2);
        request2.setNotificationVisibility(2);
        request2.setDestinationUri(Uri.fromFile(file));
        request2.setAllowedOverMetered(true);
        request2.setAllowedOverRoaming(true);
        return request2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object publishProgress(com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r7, int r8, boolean r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$publishProgress$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$publishProgress$1 r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$publishProgress$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$publishProgress$1 r0 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$publishProgress$1
            r0.<init>(r6, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            int r7 = r0.I$1
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r0 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets) r0
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            goto L_0x006a
        L_0x0033:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003b:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            com.mpl.androidapp.updater.model.GameAssets r10 = r7.getGameAssets()
            java.lang.String r10 = r10.getGameName()
            int r2 = r7.getGameId()
            int r7 = r7.getTournamentId()
            com.mpl.androidapp.updater.downloadmanager.usecases.PublishProgressUseCase r4 = r6.publishProgressUseCase
            com.mpl.androidapp.updater.downloadmanager.data.PublishProgressParams r5 = new com.mpl.androidapp.updater.downloadmanager.data.PublishProgressParams
            r5.<init>(r2, r8, r9)
            r0.L$0 = r6
            r0.L$1 = r10
            r0.I$0 = r2
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r8 = r4.invoke(r5, r0)
            if (r8 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r0 = r6
            r9 = r10
            r10 = r8
            r8 = r2
        L_0x006a:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r10
            boolean r1 = r10 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            r2 = 0
            java.lang.String r4 = "queryDownloadState"
            if (r1 == 0) goto L_0x00ba
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates> r1 = r0.queryDownloadState
            if (r1 == 0) goto L_0x00b6
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r10
            java.lang.Object r10 = r10.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r10
            java.lang.Object r10 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r10)
            if (r10 == 0) goto L_0x00ae
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$ProgressPublished r10 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.ProgressPublished) r10
            r1.setValue(r10)
            java.lang.Object[] r10 = new java.lang.Object[r3]
            r1 = 0
            java.lang.String r2 = "Notification published to notification channel"
            r10[r1] = r2
            java.lang.String r1 = "DownloadOfAssets"
            com.mpl.androidapp.utils.MLogger.d(r1, r10)
            com.mpl.androidapp.notification.NotificationBuilder r10 = new com.mpl.androidapp.notification.NotificationBuilder
            android.content.Context r1 = r0.getContext()
            r10.<init>(r1)
            android.content.Context r0 = r0.getContext()
            r1 = 2131951668(0x7f130034, float:1.9539757E38)
            java.lang.String r0 = r0.getString(r1)
            r10.buildNotification(r9, r0, r8, r7)
            goto L_0x00dd
        L_0x00ae:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.ProgressPublished"
            r7.<init>(r8)
            throw r7
        L_0x00b6:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            throw r2
        L_0x00ba:
            boolean r7 = r10 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r7 == 0) goto L_0x00dd
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates> r7 = r0.queryDownloadState
            if (r7 == 0) goto L_0x00d9
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$ErrorState r8 = new com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$ErrorState
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r10 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r10
            java.lang.Exception r9 = r10.getException()
            java.lang.String r9 = r9.getMessage()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r8.<init>(r9)
            r7.setValue(r8)
            goto L_0x00dd
        L_0x00d9:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            throw r2
        L_0x00dd:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets.publishProgress(com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams, int, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object removeDownloadedGameAssetFromDatabase(com.mpl.androidapp.database.entity.GameAssetResource r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$removeDownloadedGameAssetFromDatabase$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$removeDownloadedGameAssetFromDatabase$1 r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$removeDownloadedGameAssetFromDatabase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$removeDownloadedGameAssetFromDatabase$1 r0 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$removeDownloadedGameAssetFromDatabase$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            java.lang.Object r5 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets r5 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets) r5
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            goto L_0x0044
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0033:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            com.mpl.androidapp.updater.downloadmanager.usecases.RemoveGameResourceUseCase r6 = r4.removeGameResourceUseCase
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.invoke(r5, r0)
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r5 = r4
        L_0x0044:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r6
            boolean r0 = r6 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            r1 = 0
            java.lang.String r2 = "queryDownloadState"
            if (r0 == 0) goto L_0x0071
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates> r5 = r5.queryDownloadState
            if (r5 == 0) goto L_0x006d
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r6
            java.lang.Object r6 = r6.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r6
            java.lang.Object r6 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r6)
            if (r6 == 0) goto L_0x0065
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$GameResourceDeleted r6 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.GameResourceDeleted) r6
            r5.setValue(r6)
            goto L_0x0094
        L_0x0065:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.GameResourceDeleted"
            r5.<init>(r6)
            throw r5
        L_0x006d:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r1
        L_0x0071:
            boolean r0 = r6 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r0 == 0) goto L_0x0094
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates> r5 = r5.queryDownloadState
            if (r5 == 0) goto L_0x0090
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$ErrorState r0 = new com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$ErrorState
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r6
            java.lang.Exception r6 = r6.getException()
            java.lang.String r6 = r6.getMessage()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r0.<init>(r6)
            r5.setValue(r0)
            goto L_0x0094
        L_0x0090:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            throw r1
        L_0x0094:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets.removeDownloadedGameAssetFromDatabase(com.mpl.androidapp.database.entity.GameAssetResource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateAssetsAnalytics(boolean r5, java.lang.String r6, com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$updateAssetsAnalytics$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$updateAssetsAnalytics$1 r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$updateAssetsAnalytics$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$updateAssetsAnalytics$1 r0 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets$updateAssetsAnalytics$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            java.lang.Object r5 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets r5 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets) r5
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x0049
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0033:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            com.mpl.androidapp.updater.downloadmanager.usecases.UpdateAssetsAnalyticsUseCase r8 = r4.updateAssetsAnalyticsUseCase
            com.mpl.androidapp.updater.downloadmanager.data.AnalyticsParams r2 = new com.mpl.androidapp.updater.downloadmanager.data.AnalyticsParams
            r2.<init>(r5, r6, r7)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r8 = r8.invoke(r2, r0)
            if (r8 != r1) goto L_0x0048
            return r1
        L_0x0048:
            r5 = r4
        L_0x0049:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            boolean r6 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            r7 = 0
            java.lang.String r0 = "queryDownloadState"
            if (r6 == 0) goto L_0x0071
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r8
            java.lang.Object r6 = r8.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r6
            java.lang.Object r6 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r6)
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates r6 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates) r6
            if (r6 != 0) goto L_0x0063
            goto L_0x0094
        L_0x0063:
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates> r5 = r5.queryDownloadState
            if (r5 == 0) goto L_0x006d
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$AnalyticsUpdated r6 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.AnalyticsUpdated) r6
            r5.setValue(r6)
            goto L_0x0094
        L_0x006d:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            throw r7
        L_0x0071:
            boolean r6 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r6 == 0) goto L_0x0094
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates> r5 = r5.queryDownloadState
            if (r5 == 0) goto L_0x0090
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$ErrorState r6 = new com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$ErrorState
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r8
            java.lang.Exception r7 = r8.getException()
            java.lang.String r7 = r7.getMessage()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r6.<init>(r7)
            r5.setValue(r6)
            goto L_0x0094
        L_0x0090:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            throw r7
        L_0x0094:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadAssets.updateAssetsAnalytics(boolean, java.lang.String, com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object updateCache(String str, long j, Continuation<? super Unit> continuation) {
        DownloadAssets$updateCache$2 downloadAssets$updateCache$2 = new DownloadAssets$updateCache$2(this, str, j, null);
        Object coroutineScope = TypeUtilsKt.coroutineScope(downloadAssets$updateCache$2, continuation);
        if (coroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    public Object download(DownloadTaskParams downloadTaskParams, Continuation<? super Unit> continuation) {
        Object withContext = TypeUtilsKt.withContext(this.ioDispatcher, new DownloadAssets$download$2(downloadTaskParams, this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Context getContext() {
        return this.context;
    }

    public CoroutineContext getCoroutineContext() {
        return DefaultImpls.plus((JobSupport) TypeUtilsKt.SupervisorJob$default(null, 1), this.ioDispatcher);
    }

    public final DownloadManager getDownloadManager() {
        return this.downloadManager;
    }

    public final GameAssetResourceRepo getGameAssetResourceRepo() {
        return this.gameAssetResourceRepo;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setDownloadManager(DownloadManager downloadManager2) {
        Intrinsics.checkNotNullParameter(downloadManager2, "<set-?>");
        this.downloadManager = downloadManager2;
    }
}
