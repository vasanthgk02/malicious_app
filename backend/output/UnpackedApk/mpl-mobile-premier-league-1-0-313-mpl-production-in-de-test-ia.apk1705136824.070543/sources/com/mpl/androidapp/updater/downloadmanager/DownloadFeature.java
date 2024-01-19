package com.mpl.androidapp.updater.downloadmanager;

import com.mpl.androidapp.cleverTap.AssetsAnalytics;
import com.mpl.androidapp.cleverTap.AssetsAnalyticsProps;
import com.mpl.androidapp.database.entity.GameAssetResource;
import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.downloadModules.Download;
import com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgress;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.ErrorState;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.InitialState;
import com.mpl.androidapp.updater.downloadmanager.usecases.GetGameResourceUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.InsertAssetEntryUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.UpdateAssetsAnalyticsUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.updater.model.GameAssets;
import com.mpl.androidapp.utils.AssetsUtils;
import com.mpl.androidapp.utils.Constant;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BS\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\b\u00101\u001a\u000202H\u0002J\u001b\u00103\u001a\u0004\u0018\u00010 2\u0006\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u00104J\u0019\u00105\u001a\u0002022\u0006\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00106\u001a\u000202H@ø\u0001\u0000¢\u0006\u0002\u00107J\u0010\u00108\u001a\u0002022\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u00109\u001a\u000202J)\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010>J\u0019\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020AH@ø\u0001\u0000¢\u0006\u0002\u0010BR\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010)\"\u0004\b*\u0010+R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b/\u00100\u0002\u0004\n\u0002\b\u0019¨\u0006C"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/DownloadFeature;", "Lkotlinx/coroutines/CoroutineScope;", "downloadTaskParams", "Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "download", "Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/Download;", "downloadProgress", "Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/DownloadProgress;", "gameAssetResourceRepo", "Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;", "getGameResourceUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/GetGameResourceUseCase;", "updateAssetsAnalyticsUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/UpdateAssetsAnalyticsUseCase;", "insertAssetEntryUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/InsertAssetEntryUseCase;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "isWebViewFlow", "", "(Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/Download;Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/DownloadProgress;Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;Lcom/mpl/androidapp/updater/downloadmanager/usecases/GetGameResourceUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/UpdateAssetsAnalyticsUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/InsertAssetEntryUseCase;Lkotlinx/coroutines/CoroutineDispatcher;Z)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getDownload", "()Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/Download;", "getDownloadTaskParams", "()Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "setDownloadTaskParams", "(Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;)V", "gameAssetResourceFromDb", "Lcom/mpl/androidapp/database/entity/GameAssetResource;", "getGameAssetResourceFromDb", "()Lcom/mpl/androidapp/database/entity/GameAssetResource;", "setGameAssetResourceFromDb", "(Lcom/mpl/androidapp/database/entity/GameAssetResource;)V", "getGameAssetResourceRepo", "()Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;", "getGetGameResourceUseCase", "()Lcom/mpl/androidapp/updater/downloadmanager/usecases/GetGameResourceUseCase;", "()Z", "setWebViewFlow", "(Z)V", "queryDownloadState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "getUpdateAssetsAnalyticsUseCase", "()Lcom/mpl/androidapp/updater/downloadmanager/usecases/UpdateAssetsAnalyticsUseCase;", "cleanUp", "", "getGameResource", "(Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAssetResource", "launchFunctionality", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "publishToAssetAnalytics", "runFeature", "updateAssetsAnalytics", "errorOnDownload", "failedReason", "", "(ZLjava/lang/String;Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useCaseError", "result", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;", "(Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadFeature.kt */
public final class DownloadFeature implements CoroutineScope {
    public final Download download;
    public final DownloadProgress downloadProgress;
    public DownloadTaskParams downloadTaskParams;
    public GameAssetResource gameAssetResourceFromDb;
    public final GameAssetResourceRepo gameAssetResourceRepo;
    public final GetGameResourceUseCase getGameResourceUseCase;
    public final InsertAssetEntryUseCase insertAssetEntryUseCase;
    public final CoroutineDispatcher ioDispatcher;
    public boolean isWebViewFlow;
    public MutableStateFlow<QueryDownloadStates> queryDownloadState;
    public final UpdateAssetsAnalyticsUseCase updateAssetsAnalyticsUseCase;

    public DownloadFeature(DownloadTaskParams downloadTaskParams2, Download download2, DownloadProgress downloadProgress2, GameAssetResourceRepo gameAssetResourceRepo2, GetGameResourceUseCase getGameResourceUseCase2, UpdateAssetsAnalyticsUseCase updateAssetsAnalyticsUseCase2, InsertAssetEntryUseCase insertAssetEntryUseCase2, @IoDispatcher CoroutineDispatcher coroutineDispatcher, boolean z) {
        Intrinsics.checkNotNullParameter(downloadTaskParams2, "downloadTaskParams");
        Intrinsics.checkNotNullParameter(download2, Constant.DOWNLOAD);
        Intrinsics.checkNotNullParameter(downloadProgress2, "downloadProgress");
        Intrinsics.checkNotNullParameter(gameAssetResourceRepo2, "gameAssetResourceRepo");
        Intrinsics.checkNotNullParameter(getGameResourceUseCase2, "getGameResourceUseCase");
        Intrinsics.checkNotNullParameter(updateAssetsAnalyticsUseCase2, "updateAssetsAnalyticsUseCase");
        Intrinsics.checkNotNullParameter(insertAssetEntryUseCase2, "insertAssetEntryUseCase");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.downloadTaskParams = downloadTaskParams2;
        this.download = download2;
        this.downloadProgress = downloadProgress2;
        this.gameAssetResourceRepo = gameAssetResourceRepo2;
        this.getGameResourceUseCase = getGameResourceUseCase2;
        this.updateAssetsAnalyticsUseCase = updateAssetsAnalyticsUseCase2;
        this.insertAssetEntryUseCase = insertAssetEntryUseCase2;
        this.ioDispatcher = coroutineDispatcher;
        this.isWebViewFlow = z;
        this.queryDownloadState = StateFlowKt.MutableStateFlow(InitialState.INSTANCE);
    }

    private final void cleanUp() {
        TypeUtilsKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getGameResource(com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r7, kotlin.coroutines.Continuation<? super com.mpl.androidapp.database.entity.GameAssetResource> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.DownloadFeature$getGameResource$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature$getGameResource$1 r0 = (com.mpl.androidapp.updater.downloadmanager.DownloadFeature$getGameResource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature$getGameResource$1 r0 = new com.mpl.androidapp.updater.downloadmanager.DownloadFeature$getGameResource$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 == r5) goto L_0x0033
            if (r2 != r4) goto L_0x002b
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x009d
        L_0x002b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0033:
            java.lang.Object r7 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature r7 = (com.mpl.androidapp.updater.downloadmanager.DownloadFeature) r7
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x0064
        L_0x003b:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            com.mpl.androidapp.updater.model.GameAssets r7 = r7.getGameAssets()
            int r7 = r7.getGameId()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r2 = "gameId"
            r8.put(r2, r7)
            com.mpl.androidapp.updater.downloadmanager.usecases.GetGameResourceUseCase r7 = r6.getGetGameResourceUseCase()
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r8 = r7.invoke(r8, r0)
            if (r8 != r1) goto L_0x0063
            return r1
        L_0x0063:
            r7 = r6
        L_0x0064:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            boolean r2 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r2 == 0) goto L_0x008c
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r8
            java.lang.Object r8 = r8.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            java.lang.Object r8 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r8)
            if (r8 == 0) goto L_0x0084
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$GameAssetResourceState r8 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.GameAssetResourceState) r8
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates> r7 = r7.queryDownloadState
            r7.setValue(r8)
            com.mpl.androidapp.database.entity.GameAssetResource r7 = r8.getGameAssetResource()
            return r7
        L_0x0084:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.GameAssetResourceState"
            r7.<init>(r8)
            throw r7
        L_0x008c:
            boolean r2 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r2 == 0) goto L_0x009d
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r8
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r7 = r7.useCaseError(r8, r0)
            if (r7 != r1) goto L_0x009d
            return r1
        L_0x009d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.DownloadFeature.getGameResource(com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object insertAssetResource(com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.DownloadFeature$insertAssetResource$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature$insertAssetResource$1 r0 = (com.mpl.androidapp.updater.downloadmanager.DownloadFeature$insertAssetResource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature$insertAssetResource$1 r0 = new com.mpl.androidapp.updater.downloadmanager.DownloadFeature$insertAssetResource$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x0081
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            java.lang.Object r6 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature r6 = (com.mpl.androidapp.updater.downloadmanager.DownloadFeature) r6
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x004b
        L_0x003a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            com.mpl.androidapp.updater.downloadmanager.usecases.InsertAssetEntryUseCase r7 = r5.insertAssetEntryUseCase
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r7.invoke(r6, r0)
            if (r7 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r6 = r5
        L_0x004b:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            boolean r2 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r2 == 0) goto L_0x006f
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates> r6 = r6.queryDownloadState
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r7
            java.lang.Object r7 = r7.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            java.lang.Object r7 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r7)
            if (r7 == 0) goto L_0x0067
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$AssetInserted r7 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.AssetInserted) r7
            r6.setValue(r7)
            goto L_0x0084
        L_0x0067:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.AssetInserted"
            r6.<init>(r7)
            throw r6
        L_0x006f:
            boolean r2 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r2 == 0) goto L_0x0084
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r7
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.useCaseError(r7, r0)
            if (r6 != r1) goto L_0x0081
            return r1
        L_0x0081:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0084:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.DownloadFeature.insertAssetResource(com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object launchFunctionality(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.mpl.androidapp.updater.downloadmanager.DownloadFeature$launchFunctionality$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature$launchFunctionality$1 r0 = (com.mpl.androidapp.updater.downloadmanager.DownloadFeature$launchFunctionality$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature$launchFunctionality$1 r0 = new com.mpl.androidapp.updater.downloadmanager.DownloadFeature$launchFunctionality$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            java.lang.Object r0 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature r0 = (com.mpl.androidapp.updater.downloadmanager.DownloadFeature) r0
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)
            goto L_0x004d
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0033:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)
            r4.cleanUp()
            com.mpl.androidapp.updater.downloadmanager.downloadModules.Download r5 = r4.getDownload()
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r2 = r4.getDownloadTaskParams()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.download(r2, r0)
            if (r5 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r0 = r4
        L_0x004d:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.DownloadProgress r5 = r0.downloadProgress
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r1 = r0.getDownloadTaskParams()
            boolean r0 = r0.isWebViewFlow()
            r5.startProgress(r1, r0)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.DownloadFeature.launchFunctionality(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void publishToAssetAnalytics(DownloadTaskParams downloadTaskParams2) {
        GameAssets gameAssets = downloadTaskParams2.getGameAssets();
        int gameId = downloadTaskParams2.getGameId();
        AssetsUtils.addCurrentlyDownloadingAssetsIds(gameId);
        int currentlyDownloadingAssetsPosition = AssetsUtils.getCurrentlyDownloadingAssetsPosition(gameId);
        AssetsAnalyticsProps assetsAnalyticsProps = new AssetsAnalyticsProps();
        assetsAnalyticsProps.setAssetsType("Assets");
        assetsAnalyticsProps.setGameName(gameAssets.getGameName());
        assetsAnalyticsProps.setGameId(gameAssets.getGameId());
        assetsAnalyticsProps.setAssetsSize(gameAssets.getSize());
        boolean z = false;
        assetsAnalyticsProps.setUpdateAssets(gameAssets.getGameVersion() > 1);
        assetsAnalyticsProps.setAssetsVersion(gameAssets.getAssetVersion());
        if (currentlyDownloadingAssetsPosition > 0) {
            z = true;
        }
        assetsAnalyticsProps.setQueued(z);
        assetsAnalyticsProps.setQueuePriority(currentlyDownloadingAssetsPosition);
        assetsAnalyticsProps.setDownloadType("New");
        AssetsAnalytics.sendGameFileDownloadInitiatedEvent(assetsAnalyticsProps);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateAssetsAnalytics(boolean r6, java.lang.String r7, com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.DownloadFeature$updateAssetsAnalytics$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature$updateAssetsAnalytics$1 r0 = (com.mpl.androidapp.updater.downloadmanager.DownloadFeature$updateAssetsAnalytics$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature$updateAssetsAnalytics$1 r0 = new com.mpl.androidapp.updater.downloadmanager.DownloadFeature$updateAssetsAnalytics$1
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x0088
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            java.lang.Object r6 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.DownloadFeature r6 = (com.mpl.androidapp.updater.downloadmanager.DownloadFeature) r6
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x0052
        L_0x003a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            com.mpl.androidapp.updater.downloadmanager.usecases.UpdateAssetsAnalyticsUseCase r9 = r5.getUpdateAssetsAnalyticsUseCase()
            com.mpl.androidapp.updater.downloadmanager.data.AnalyticsParams r2 = new com.mpl.androidapp.updater.downloadmanager.data.AnalyticsParams
            r2.<init>(r6, r7, r8)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r9 = r9.invoke(r2, r0)
            if (r9 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r6 = r5
        L_0x0052:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r9
            boolean r7 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r7 == 0) goto L_0x0076
            kotlinx.coroutines.flow.MutableStateFlow<com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates> r6 = r6.queryDownloadState
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r9
            java.lang.Object r7 = r9.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            java.lang.Object r7 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r7)
            if (r7 == 0) goto L_0x006e
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$AnalyticsUpdated r7 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.AnalyticsUpdated) r7
            r6.setValue(r7)
            goto L_0x008b
        L_0x006e:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.AnalyticsUpdated"
            r6.<init>(r7)
            throw r6
        L_0x0076:
            boolean r7 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r7 == 0) goto L_0x008b
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r9
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r6.useCaseError(r9, r0)
            if (r6 != r1) goto L_0x0088
            return r1
        L_0x0088:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x008b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.DownloadFeature.updateAssetsAnalytics(boolean, java.lang.String, com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object useCaseError(Error error, Continuation<? super Unit> continuation) {
        String valueOf = String.valueOf(error.getException().getMessage());
        this.queryDownloadState.setValue(new ErrorState(valueOf));
        Object updateAssetsAnalytics = updateAssetsAnalytics(true, valueOf, getDownloadTaskParams(), continuation);
        if (updateAssetsAnalytics == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return updateAssetsAnalytics;
        }
        return Unit.INSTANCE;
    }

    public CoroutineContext getCoroutineContext() {
        return DefaultImpls.plus((JobSupport) TypeUtilsKt.SupervisorJob$default(null, 1), this.ioDispatcher);
    }

    public final Download getDownload() {
        return this.download;
    }

    public final DownloadTaskParams getDownloadTaskParams() {
        return this.downloadTaskParams;
    }

    public final GameAssetResource getGameAssetResourceFromDb() {
        return this.gameAssetResourceFromDb;
    }

    public final GameAssetResourceRepo getGameAssetResourceRepo() {
        return this.gameAssetResourceRepo;
    }

    public final GetGameResourceUseCase getGetGameResourceUseCase() {
        return this.getGameResourceUseCase;
    }

    public final UpdateAssetsAnalyticsUseCase getUpdateAssetsAnalyticsUseCase() {
        return this.updateAssetsAnalyticsUseCase;
    }

    public final boolean isWebViewFlow() {
        return this.isWebViewFlow;
    }

    public final void runFeature() {
        TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.IO), null, null, new DownloadFeature$runFeature$1(this, null), 3, null);
    }

    public final void setDownloadTaskParams(DownloadTaskParams downloadTaskParams2) {
        Intrinsics.checkNotNullParameter(downloadTaskParams2, "<set-?>");
        this.downloadTaskParams = downloadTaskParams2;
    }

    public final void setGameAssetResourceFromDb(GameAssetResource gameAssetResource) {
        this.gameAssetResourceFromDb = gameAssetResource;
    }

    public final void setWebViewFlow(boolean z) {
        this.isWebViewFlow = z;
    }

    public /* synthetic */ DownloadFeature(DownloadTaskParams downloadTaskParams2, Download download2, DownloadProgress downloadProgress2, GameAssetResourceRepo gameAssetResourceRepo2, GetGameResourceUseCase getGameResourceUseCase2, UpdateAssetsAnalyticsUseCase updateAssetsAnalyticsUseCase2, InsertAssetEntryUseCase insertAssetEntryUseCase2, CoroutineDispatcher coroutineDispatcher, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(downloadTaskParams2, download2, downloadProgress2, gameAssetResourceRepo2, getGameResourceUseCase2, updateAssetsAnalyticsUseCase2, insertAssetEntryUseCase2, coroutineDispatcher, (i & 256) != 0 ? false : z);
    }
}
