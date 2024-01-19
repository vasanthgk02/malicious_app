package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.mpl.androidapp.database.entity.GameAssetResource;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadManagerStatus;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.ErrorState;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.InitialState;
import com.mpl.androidapp.updater.downloadmanager.usecases.CopyPokerAssetFileUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.DeleteAssetFileUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.ExtractAssetsUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.GetGameResourceUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadNotificationFlowCheckUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitCheckUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.PublishProgressUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.RemoveGameResourceUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.UpdateAssetsAnalyticsUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.mpl.androidapp.updater.downloadmanager.utils.DownloadManagerCursorStatus;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.HashMap;
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

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bs\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u0019\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020&H@ø\u0001\u0000¢\u0006\u0002\u0010HJ\u0006\u0010I\u001a\u00020FJ\u0019\u0010J\u001a\u00020F2\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u0010KJ\u0011\u0010L\u001a\u00020FH@ø\u0001\u0000¢\u0006\u0002\u0010MJ!\u0010N\u001a\u00020F2\u0006\u0010O\u001a\u0002072\u0006\u0010P\u001a\u000207H@ø\u0001\u0000¢\u0006\u0002\u0010QJ\u0019\u0010R\u001a\u00020F2\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u0010KJ\u0019\u0010S\u001a\u00020F2\u0006\u0010G\u001a\u00020&H@ø\u0001\u0000¢\u0006\u0002\u0010HJ\u0019\u0010T\u001a\u00020F2\u0006\u0010G\u001a\u00020&H@ø\u0001\u0000¢\u0006\u0002\u0010HJ!\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u0002002\u0006\u0010X\u001a\u00020:H@ø\u0001\u0000¢\u0006\u0002\u0010YJ#\u0010Z\u001a\u00020F2\b\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010G\u001a\u00020&H@ø\u0001\u0000¢\u0006\u0002\u0010]J\u0019\u0010^\u001a\u00020F2\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u0010KJ\u0011\u0010_\u001a\u00020FH@ø\u0001\u0000¢\u0006\u0002\u0010MJ\u001b\u0010`\u001a\u0004\u0018\u00010&2\u0006\u0010a\u001a\u00020VH@ø\u0001\u0000¢\u0006\u0002\u0010bJ!\u0010c\u001a\u00020F2\u0006\u0010a\u001a\u0002072\u0006\u0010d\u001a\u00020:H@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0010\u0010f\u001a\u00020\\2\u0006\u0010g\u001a\u00020VH\u0002J,\u0010h\u001a\u00020F2\u0006\u0010i\u001a\u0002072\u0006\u0010P\u001a\u0002072\b\b\u0002\u0010j\u001a\u00020:2\b\b\u0002\u0010k\u001a\u00020:H\u0002J1\u0010l\u001a\u00020F2\u0006\u0010/\u001a\u0002002\u0006\u0010m\u001a\u0002072\u0006\u0010n\u001a\u00020:2\u0006\u0010o\u001a\u00020:H@ø\u0001\u0000¢\u0006\u0002\u0010pJ\u0019\u0010q\u001a\u00020F2\u0006\u0010G\u001a\u00020&H@ø\u0001\u0000¢\u0006\u0002\u0010HJ)\u0010r\u001a\u00020F2\u0006\u0010s\u001a\u00020:2\u0006\u0010t\u001a\u00020V2\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u0010uJ\u0019\u0010v\u001a\u00020F2\u0006\u0010w\u001a\u00020xH@ø\u0001\u0000¢\u0006\u0002\u0010yR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000200X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R*\u00105\u001a\u001e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020706j\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000207`8X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010;\"\u0004\b<\u0010=R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R \u0010>\u001a\b\u0012\u0004\u0012\u00020@0?X.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006z"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/QueryDownload;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Landroid/content/Context;", "downloadManager", "Landroid/app/DownloadManager;", "downloadManagerCursorStatus", "Lcom/mpl/androidapp/updater/downloadmanager/utils/DownloadManagerCursorStatus;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getGameResourceUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/GetGameResourceUseCase;", "removeGameResourceUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/RemoveGameResourceUseCase;", "deleteAssetFileUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/DeleteAssetFileUseCase;", "updateAssetsAnalyticsUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/UpdateAssetsAnalyticsUseCase;", "publishProgressUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/PublishProgressUseCase;", "copyAssetUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/CopyPokerAssetFileUseCase;", "extractAssetsUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/ExtractAssetsUseCase;", "optionalDownloadVisitCheckUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitCheckUseCase;", "optionalDownloadNotificationFlowCheckUseCase", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadNotificationFlowCheckUseCase;", "(Landroid/content/Context;Landroid/app/DownloadManager;Lcom/mpl/androidapp/updater/downloadmanager/utils/DownloadManagerCursorStatus;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/mpl/androidapp/updater/downloadmanager/usecases/GetGameResourceUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/RemoveGameResourceUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/DeleteAssetFileUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/UpdateAssetsAnalyticsUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/PublishProgressUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/CopyPokerAssetFileUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/ExtractAssetsUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadVisitCheckUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/OptionalDownloadNotificationFlowCheckUseCase;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "currentGameResource", "Lcom/mpl/androidapp/database/entity/GameAssetResource;", "getCurrentGameResource", "()Lcom/mpl/androidapp/database/entity/GameAssetResource;", "setCurrentGameResource", "(Lcom/mpl/androidapp/database/entity/GameAssetResource;)V", "getDownloadManager", "()Landroid/app/DownloadManager;", "setDownloadManager", "(Landroid/app/DownloadManager;)V", "downloadTaskParams", "Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "getDownloadTaskParams", "()Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "setDownloadTaskParams", "(Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;)V", "idProgress", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isWebViewFlow", "", "()Z", "setWebViewFlow", "(Z)V", "queryDownloadState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mpl/androidapp/updater/downloadmanager/states/QueryDownloadStates;", "getQueryDownloadState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setQueryDownloadState", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "checkIfNotificationToBeDisplayed", "", "gameResource", "(Lcom/mpl/androidapp/database/entity/GameAssetResource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanUp", "copyAssetsCase", "(Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyPokerAssetsFileFromExternalToInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentProgressToDisplayedProgressBar", "downloaded", "totalSize", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFileUseCase", "downloadComplete", "downloadCompleteCleanup", "downloadFileProcess", "", "params", "webView", "(Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "errorInDownload", "causeOfFailure", "Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadManagerStatus;", "(Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadManagerStatus;Lcom/mpl/androidapp/database/entity/GameAssetResource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractAssetsCase", "extractPokerAssetsFile", "getGameResource", "gameId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "optionalDownloadVisitUseCase", "visitTrueFromDb", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepCustomDownloadManagerStatus", "errMessage", "publishBroadcast", "bytesDownloaded", "isDownloadComplete", "isDownloadFail", "publishProgress", "code", "isProgressComplete", "isError", "(Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;IZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeDownloadedGameAssetFromDatabase", "updateAssetsAnalytics", "errorOnDownload", "failedReason", "(ZLjava/lang/String;Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useCaseError", "result", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;", "(Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QueryDownload.kt */
public final class QueryDownload implements CoroutineScope {
    public Context context;
    public final CopyPokerAssetFileUseCase copyAssetUseCase;
    public GameAssetResource currentGameResource;
    public final DeleteAssetFileUseCase deleteAssetFileUseCase;
    public DownloadManager downloadManager;
    public final DownloadManagerCursorStatus downloadManagerCursorStatus;
    public DownloadTaskParams downloadTaskParams;
    public final ExtractAssetsUseCase extractAssetsUseCase;
    public final GetGameResourceUseCase getGameResourceUseCase;
    public final HashMap<Integer, Integer> idProgress = new HashMap<>();
    public final CoroutineDispatcher ioDispatcher;
    public boolean isWebViewFlow;
    public final OptionalDownloadNotificationFlowCheckUseCase optionalDownloadNotificationFlowCheckUseCase;
    public final OptionalDownloadVisitCheckUseCase optionalDownloadVisitCheckUseCase;
    public final PublishProgressUseCase publishProgressUseCase;
    public MutableStateFlow<QueryDownloadStates> queryDownloadState;
    public final RemoveGameResourceUseCase removeGameResourceUseCase;
    public final UpdateAssetsAnalyticsUseCase updateAssetsAnalyticsUseCase;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$1", f = "QueryDownload.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$1  reason: invalid class name */
    /* compiled from: QueryDownload.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;
        public final /* synthetic */ QueryDownload this$0;

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
                this.this$0.setQueryDownloadState(StateFlowKt.MutableStateFlow(InitialState.INSTANCE));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public QueryDownload(Context context2, DownloadManager downloadManager2, DownloadManagerCursorStatus downloadManagerCursorStatus2, @IoDispatcher CoroutineDispatcher coroutineDispatcher, GetGameResourceUseCase getGameResourceUseCase2, RemoveGameResourceUseCase removeGameResourceUseCase2, DeleteAssetFileUseCase deleteAssetFileUseCase2, UpdateAssetsAnalyticsUseCase updateAssetsAnalyticsUseCase2, PublishProgressUseCase publishProgressUseCase2, CopyPokerAssetFileUseCase copyPokerAssetFileUseCase, ExtractAssetsUseCase extractAssetsUseCase2, OptionalDownloadVisitCheckUseCase optionalDownloadVisitCheckUseCase2, OptionalDownloadNotificationFlowCheckUseCase optionalDownloadNotificationFlowCheckUseCase2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(downloadManager2, "downloadManager");
        Intrinsics.checkNotNullParameter(downloadManagerCursorStatus2, "downloadManagerCursorStatus");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(getGameResourceUseCase2, "getGameResourceUseCase");
        Intrinsics.checkNotNullParameter(removeGameResourceUseCase2, "removeGameResourceUseCase");
        Intrinsics.checkNotNullParameter(deleteAssetFileUseCase2, "deleteAssetFileUseCase");
        Intrinsics.checkNotNullParameter(updateAssetsAnalyticsUseCase2, "updateAssetsAnalyticsUseCase");
        Intrinsics.checkNotNullParameter(publishProgressUseCase2, "publishProgressUseCase");
        Intrinsics.checkNotNullParameter(copyPokerAssetFileUseCase, "copyAssetUseCase");
        Intrinsics.checkNotNullParameter(extractAssetsUseCase2, "extractAssetsUseCase");
        Intrinsics.checkNotNullParameter(optionalDownloadVisitCheckUseCase2, "optionalDownloadVisitCheckUseCase");
        Intrinsics.checkNotNullParameter(optionalDownloadNotificationFlowCheckUseCase2, "optionalDownloadNotificationFlowCheckUseCase");
        this.context = context2;
        this.downloadManager = downloadManager2;
        this.downloadManagerCursorStatus = downloadManagerCursorStatus2;
        this.ioDispatcher = coroutineDispatcher;
        this.getGameResourceUseCase = getGameResourceUseCase2;
        this.removeGameResourceUseCase = removeGameResourceUseCase2;
        this.deleteAssetFileUseCase = deleteAssetFileUseCase2;
        this.updateAssetsAnalyticsUseCase = updateAssetsAnalyticsUseCase2;
        this.publishProgressUseCase = publishProgressUseCase2;
        this.copyAssetUseCase = copyPokerAssetFileUseCase;
        this.extractAssetsUseCase = extractAssetsUseCase2;
        this.optionalDownloadVisitCheckUseCase = optionalDownloadVisitCheckUseCase2;
        this.optionalDownloadNotificationFlowCheckUseCase = optionalDownloadNotificationFlowCheckUseCase2;
        TypeUtilsKt.launch$default(this, null, null, new AnonymousClass1(this, null), 3, null);
    }

    /* access modifiers changed from: private */
    public final Object checkIfNotificationToBeDisplayed(GameAssetResource gameAssetResource, Continuation<? super Unit> continuation) {
        Object withContext = TypeUtilsKt.withContext(this.ioDispatcher, new QueryDownload$checkIfNotificationToBeDisplayed$2(this, gameAssetResource, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object copyAssetsCase(com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$copyAssetsCase$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$copyAssetsCase$1 r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$copyAssetsCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$copyAssetsCase$1 r0 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$copyAssetsCase$1
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
            goto L_0x0086
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            java.lang.Object r6 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r6 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload) r6
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x004b
        L_0x003a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            com.mpl.androidapp.updater.downloadmanager.usecases.CopyPokerAssetFileUseCase r7 = r5.copyAssetUseCase
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
            if (r2 == 0) goto L_0x0074
            kotlinx.coroutines.flow.MutableStateFlow r6 = r6.getQueryDownloadState()
            if (r6 != 0) goto L_0x0058
            goto L_0x0089
        L_0x0058:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r7
            java.lang.Object r7 = r7.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            java.lang.Object r7 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r7)
            if (r7 == 0) goto L_0x006c
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$AssetCopied r7 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.AssetCopied) r7
            r6.setValue(r7)
            goto L_0x0089
        L_0x006c:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.AssetCopied"
            r6.<init>(r7)
            throw r6
        L_0x0074:
            boolean r2 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r2 == 0) goto L_0x0089
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r7
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.useCaseError(r7, r0)
            if (r6 != r1) goto L_0x0086
            return r1
        L_0x0086:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0089:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload.copyAssetsCase(com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object copyPokerAssetsFileFromExternalToInternal(Continuation<? super Unit> continuation) {
        Object copyAssetsCase = copyAssetsCase(getDownloadTaskParams(), continuation);
        if (copyAssetsCase == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return copyAssetsCase;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object currentProgressToDisplayedProgressBar(int r10, int r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$currentProgressToDisplayedProgressBar$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$currentProgressToDisplayedProgressBar$1 r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$currentProgressToDisplayedProgressBar$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$currentProgressToDisplayedProgressBar$1 r0 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$currentProgressToDisplayedProgressBar$1
            r0.<init>(r9, r12)
        L_0x0018:
            r6 = r0
            java.lang.Object r12 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0030
            if (r1 != r2) goto L_0x0028
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r12)
            goto L_0x008a
        L_0x0028:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0030:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r12)
            com.mpl.androidapp.updater.downloadmanager.utils.DownloadLogUtils r12 = com.mpl.androidapp.updater.downloadmanager.utils.DownloadLogUtils.INSTANCE
            r12.printProgressToProgressBar(r10, r11)
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r12 = r9.getDownloadTaskParams()
            int r12 = r12.getGameId()
            long r3 = (long) r10
            r7 = 100
            long r3 = r3 * r7
            long r10 = (long) r11
            long r3 = r3 / r10
            int r3 = (int) r3
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r10 = r9.idProgress
            java.lang.Integer r11 = new java.lang.Integer
            r11.<init>(r12)
            java.lang.Object r10 = r10.get(r11)
            java.lang.Integer r10 = (java.lang.Integer) r10
            com.mpl.androidapp.updater.downloadmanager.utils.DownloadLogUtils r11 = com.mpl.androidapp.updater.downloadmanager.utils.DownloadLogUtils.INSTANCE
            r11.printProgressToDisplayedProgressBar(r3, r10)
            if (r10 != 0) goto L_0x005d
            goto L_0x008a
        L_0x005d:
            r10.intValue()
            int r11 = r3 % 5
            if (r11 != 0) goto L_0x008a
            int r10 = r10.intValue()
            if (r10 >= r3) goto L_0x008a
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r10 = r9.idProgress
            java.lang.Integer r11 = new java.lang.Integer
            r11.<init>(r12)
            java.lang.Integer r12 = new java.lang.Integer
            r12.<init>(r3)
            r10.put(r11, r12)
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r10 = r9.getDownloadTaskParams()
            r4 = 0
            r5 = 0
            r6.label = r2
            r1 = r9
            r2 = r10
            java.lang.Object r10 = r1.publishProgress(r2, r3, r4, r5, r6)
            if (r10 != r0) goto L_0x008a
            return r0
        L_0x008a:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload.currentProgressToDisplayedProgressBar(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteFileUseCase(com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$deleteFileUseCase$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$deleteFileUseCase$1 r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$deleteFileUseCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$deleteFileUseCase$1 r0 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$deleteFileUseCase$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x009a
        L_0x002a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0032:
            java.lang.Object r7 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r7 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload) r7
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x0062
        L_0x003a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r2 = r7.getDownloadPath()
            java.lang.String r5 = "downloadPath"
            r8.put(r5, r2)
            java.lang.String r7 = r7.getFileName()
            java.lang.String r2 = "fileName"
            r8.put(r2, r7)
            com.mpl.androidapp.updater.downloadmanager.usecases.DeleteAssetFileUseCase r7 = r6.deleteAssetFileUseCase
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r8 = r7.invoke(r8, r0)
            if (r8 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r7 = r6
        L_0x0062:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            boolean r2 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r2 == 0) goto L_0x0088
            kotlinx.coroutines.flow.MutableStateFlow r7 = r7.getQueryDownloadState()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r8
            java.lang.Object r8 = r8.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            java.lang.Object r8 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r8)
            if (r8 == 0) goto L_0x0080
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$DeleteAssetFile r8 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.DeleteAssetFile) r8
            r7.setValue(r8)
            goto L_0x009d
        L_0x0080:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.DeleteAssetFile"
            r7.<init>(r8)
            throw r7
        L_0x0088:
            boolean r2 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r2 == 0) goto L_0x009d
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r8
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r7.useCaseError(r8, r0)
            if (r7 != r1) goto L_0x009a
            return r1
        L_0x009a:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x009d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload.deleteFileUseCase(com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object downloadComplete(GameAssetResource gameAssetResource, Continuation<? super Unit> continuation) {
        Object withContext = TypeUtilsKt.withContext(this.ioDispatcher, new QueryDownload$downloadComplete$2(this, gameAssetResource, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object downloadCompleteCleanup(GameAssetResource gameAssetResource, Continuation<? super Unit> continuation) {
        Object withContext = TypeUtilsKt.withContext(this.ioDispatcher, new QueryDownload$downloadCompleteCleanup$2(this, gameAssetResource, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object errorInDownload(DownloadManagerStatus downloadManagerStatus, GameAssetResource gameAssetResource, Continuation<? super Unit> continuation) {
        Object withContext = TypeUtilsKt.withContext(this.ioDispatcher, new QueryDownload$errorInDownload$2(downloadManagerStatus, this, gameAssetResource, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object extractAssetsCase(com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$extractAssetsCase$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$extractAssetsCase$1 r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$extractAssetsCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$extractAssetsCase$1 r0 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$extractAssetsCase$1
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
            goto L_0x0086
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            java.lang.Object r6 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r6 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload) r6
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x004b
        L_0x003a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            com.mpl.androidapp.updater.downloadmanager.usecases.ExtractAssetsUseCase r7 = r5.extractAssetsUseCase
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
            if (r2 == 0) goto L_0x0074
            kotlinx.coroutines.flow.MutableStateFlow r6 = r6.getQueryDownloadState()
            if (r6 != 0) goto L_0x0058
            goto L_0x0089
        L_0x0058:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r7
            java.lang.Object r7 = r7.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            java.lang.Object r7 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r7)
            if (r7 == 0) goto L_0x006c
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$AssetsExtracted r7 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.AssetsExtracted) r7
            r6.setValue(r7)
            goto L_0x0089
        L_0x006c:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.AssetsExtracted"
            r6.<init>(r7)
            throw r6
        L_0x0074:
            boolean r2 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r2 == 0) goto L_0x0089
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r7
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.useCaseError(r7, r0)
            if (r6 != r1) goto L_0x0086
            return r1
        L_0x0086:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0089:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload.extractAssetsCase(com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object extractPokerAssetsFile(Continuation<? super Unit> continuation) {
        getDownloadTaskParams().setPokerFlow(isWebViewFlow());
        Object extractAssetsCase = extractAssetsCase(getDownloadTaskParams(), continuation);
        if (extractAssetsCase == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return extractAssetsCase;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getGameResource(java.lang.String r7, kotlin.coroutines.Continuation<? super com.mpl.androidapp.database.entity.GameAssetResource> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$getGameResource$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$getGameResource$1 r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$getGameResource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$getGameResource$1 r0 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$getGameResource$1
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
            goto L_0x0091
        L_0x002b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0033:
            java.lang.Object r7 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r7 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload) r7
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x0056
        L_0x003b:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r2 = "gameId"
            r8.put(r2, r7)
            com.mpl.androidapp.updater.downloadmanager.usecases.GetGameResourceUseCase r7 = r6.getGameResourceUseCase
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r8 = r7.invoke(r8, r0)
            if (r8 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r7 = r6
        L_0x0056:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            boolean r2 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r2 == 0) goto L_0x0080
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r8
            java.lang.Object r8 = r8.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            java.lang.Object r8 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r8)
            if (r8 == 0) goto L_0x0078
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$GameAssetResourceState r8 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.GameAssetResourceState) r8
            kotlinx.coroutines.flow.MutableStateFlow r7 = r7.getQueryDownloadState()
            r7.setValue(r8)
            com.mpl.androidapp.database.entity.GameAssetResource r7 = r8.getGameAssetResource()
            return r7
        L_0x0078:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.GameAssetResourceState"
            r7.<init>(r8)
            throw r7
        L_0x0080:
            boolean r2 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r2 == 0) goto L_0x0091
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r8
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r7 = r7.useCaseError(r8, r0)
            if (r7 != r1) goto L_0x0091
            return r1
        L_0x0091:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload.getGameResource(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object optionalDownloadVisitUseCase(int r6, boolean r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$optionalDownloadVisitUseCase$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$optionalDownloadVisitUseCase$1 r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$optionalDownloadVisitUseCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$optionalDownloadVisitUseCase$1 r0 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$optionalDownloadVisitUseCase$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x00aa
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            boolean r7 = r0.Z$0
            java.lang.Object r6 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r6 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload) r6
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x0055
        L_0x003d:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadNotificationFlowCheckUseCase r8 = r5.optionalDownloadNotificationFlowCheckUseCase
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r6)
            r0.L$0 = r5
            r0.Z$0 = r7
            r0.label = r4
            java.lang.Object r8 = r8.invoke(r2, r0)
            if (r8 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r6 = r5
        L_0x0055:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            boolean r2 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r2 == 0) goto L_0x0098
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r8
            java.lang.Object r8 = r8.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r8
            java.lang.Object r8 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r8)
            if (r8 == 0) goto L_0x0090
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$CheckOptionalDownloadNotificationDisplay r8 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.CheckOptionalDownloadNotificationDisplay) r8
            boolean r8 = r8.isEnabled()
            r0 = 0
            if (r8 == 0) goto L_0x0082
            if (r7 == 0) goto L_0x00ad
            com.mpl.androidapp.updater.downloadmanager.utils.DownloadUtils r7 = com.mpl.androidapp.updater.downloadmanager.utils.DownloadUtils.INSTANCE
            android.content.Context r8 = r6.getContext()
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r6 = r6.getDownloadTaskParams()
            r7.notificationBuilderUtil(r0, r8, r6)
            goto L_0x00ad
        L_0x0082:
            com.mpl.androidapp.updater.downloadmanager.utils.DownloadUtils r7 = com.mpl.androidapp.updater.downloadmanager.utils.DownloadUtils.INSTANCE
            android.content.Context r8 = r6.getContext()
            com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r6 = r6.getDownloadTaskParams()
            r7.notificationBuilderUtil(r0, r8, r6)
            goto L_0x00ad
        L_0x0090:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.CheckOptionalDownloadNotificationDisplay"
            r6.<init>(r7)
            throw r6
        L_0x0098:
            boolean r7 = r8 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r7 == 0) goto L_0x00ad
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r8 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r8
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r6.useCaseError(r8, r0)
            if (r6 != r1) goto L_0x00aa
            return r1
        L_0x00aa:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x00ad:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload.optionalDownloadVisitUseCase(int, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final DownloadManagerStatus prepCustomDownloadManagerStatus(String str) {
        DownloadManagerStatus downloadManagerStatus = new DownloadManagerStatus(true, false, false, false, false, str, "", "", "", "");
        return downloadManagerStatus;
    }

    /* access modifiers changed from: private */
    public final void publishBroadcast(int i, int i2, boolean z, boolean z2) {
        if (z2) {
            Intent intent = new Intent(Constants.WEB_VIEW_ASSET_DOWNLOAD_FAIL);
            intent.putExtra(Constants.BYTES_DOWNLOADED, i);
            intent.putExtra(Constants.TOTAL_SIZE, i2);
            intent.putExtra("GameId", getDownloadTaskParams().getGameId());
            intent.putExtra(Constants.NEW_VERSION, getDownloadTaskParams().getGameAssets().getAssetVersion());
            LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent);
        } else if (!z) {
            Intent intent2 = new Intent(Constants.WEB_VIEW_ASSET_PROGRESS);
            intent2.putExtra(Constants.BYTES_DOWNLOADED, i);
            intent2.putExtra(Constants.TOTAL_SIZE, i2);
            LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent2);
        } else {
            Intent intent3 = new Intent(Constants.WEB_VIEW_ASSET_PROGRESS_COMPLETE);
            intent3.putExtra(Constants.BYTES_DOWNLOADED, i);
            intent3.putExtra(Constants.TOTAL_SIZE, i2);
            intent3.putExtra("GameId", getDownloadTaskParams().getGameId());
            intent3.putExtra(Constants.NEW_VERSION, getDownloadTaskParams().getGameAssets().getAssetVersion());
            LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent3);
        }
    }

    public static /* synthetic */ void publishBroadcast$default(QueryDownload queryDownload, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            z2 = false;
        }
        queryDownload.publishBroadcast(i, i2, z, z2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object publishProgress(com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r5, int r6, boolean r7, boolean r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r4 = this;
            boolean r8 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$publishProgress$1
            if (r8 == 0) goto L_0x0013
            r8 = r9
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$publishProgress$1 r8 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$publishProgress$1) r8
            int r0 = r8.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r8.label = r0
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$publishProgress$1 r8 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$publishProgress$1
            r8.<init>(r4, r9)
        L_0x0018:
            java.lang.Object r9 = r8.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003a
            if (r1 == r3) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x008c
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            java.lang.Object r5 = r8.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r5 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload) r5
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x0054
        L_0x003a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            int r5 = r5.getGameId()
            com.mpl.androidapp.updater.downloadmanager.usecases.PublishProgressUseCase r9 = r4.publishProgressUseCase
            com.mpl.androidapp.updater.downloadmanager.data.PublishProgressParams r1 = new com.mpl.androidapp.updater.downloadmanager.data.PublishProgressParams
            r1.<init>(r5, r6, r7)
            r8.L$0 = r4
            r8.label = r3
            java.lang.Object r9 = r9.invoke(r1, r8)
            if (r9 != r0) goto L_0x0053
            return r0
        L_0x0053:
            r5 = r4
        L_0x0054:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r9
            boolean r6 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r6 == 0) goto L_0x007a
            kotlinx.coroutines.flow.MutableStateFlow r5 = r5.getQueryDownloadState()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r9
            java.lang.Object r6 = r9.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r6 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r6
            java.lang.Object r6 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r6)
            if (r6 == 0) goto L_0x0072
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$ProgressPublished r6 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.ProgressPublished) r6
            r5.setValue(r6)
            goto L_0x008f
        L_0x0072:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.ProgressPublished"
            r5.<init>(r6)
            throw r5
        L_0x007a:
            boolean r6 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r6 == 0) goto L_0x008f
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r9
            r6 = 0
            r8.L$0 = r6
            r8.label = r2
            java.lang.Object r5 = r5.useCaseError(r9, r8)
            if (r5 != r0) goto L_0x008c
            return r0
        L_0x008c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x008f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload.publishProgress(com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams, int, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object removeDownloadedGameAssetFromDatabase(com.mpl.androidapp.database.entity.GameAssetResource r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$removeDownloadedGameAssetFromDatabase$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$removeDownloadedGameAssetFromDatabase$1 r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$removeDownloadedGameAssetFromDatabase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$removeDownloadedGameAssetFromDatabase$1 r0 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$removeDownloadedGameAssetFromDatabase$1
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
            goto L_0x0086
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            java.lang.Object r6 = r0.L$0
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r6 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload) r6
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            goto L_0x004b
        L_0x003a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r7)
            com.mpl.androidapp.updater.downloadmanager.usecases.RemoveGameResourceUseCase r7 = r5.removeGameResourceUseCase
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
            if (r2 == 0) goto L_0x0074
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Success r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success) r7
            java.lang.Object r7 = r7.getValue()
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r7
            java.lang.Object r7 = com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt.getData(r7)
            if (r7 == 0) goto L_0x006c
            com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates$GameResourceDeleted r7 = (com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.GameResourceDeleted) r7
            kotlinx.coroutines.flow.MutableStateFlow r6 = r6.getQueryDownloadState()
            if (r6 != 0) goto L_0x0068
            goto L_0x0089
        L_0x0068:
            r6.setValue(r7)
            goto L_0x0089
        L_0x006c:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.GameResourceDeleted"
            r6.<init>(r7)
            throw r6
        L_0x0074:
            boolean r2 = r7 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error
            if (r2 == 0) goto L_0x0089
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult$Error r7 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error) r7
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.useCaseError(r7, r0)
            if (r6 != r1) goto L_0x0086
            return r1
        L_0x0086:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0089:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload.removeDownloadedGameAssetFromDatabase(com.mpl.androidapp.database.entity.GameAssetResource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateAssetsAnalytics(boolean r6, java.lang.String r7, com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$updateAssetsAnalytics$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$updateAssetsAnalytics$1 r0 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$updateAssetsAnalytics$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$updateAssetsAnalytics$1 r0 = new com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload$updateAssetsAnalytics$1
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
            com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload r6 = (com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload) r6
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x0050
        L_0x003a:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            com.mpl.androidapp.updater.downloadmanager.usecases.UpdateAssetsAnalyticsUseCase r9 = r5.updateAssetsAnalyticsUseCase
            com.mpl.androidapp.updater.downloadmanager.data.AnalyticsParams r2 = new com.mpl.androidapp.updater.downloadmanager.data.AnalyticsParams
            r2.<init>(r6, r7, r8)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r9 = r9.invoke(r2, r0)
            if (r9 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r6 = r5
        L_0x0050:
            com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult r9 = (com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult) r9
            boolean r7 = r9 instanceof com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success
            if (r7 == 0) goto L_0x0076
            kotlinx.coroutines.flow.MutableStateFlow r6 = r6.getQueryDownloadState()
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
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.downloadModules.QueryDownload.updateAssetsAnalytics(boolean, java.lang.String, com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object useCaseError(Error error, Continuation<? super Unit> continuation) {
        String valueOf = String.valueOf(error.getException().getMessage());
        getQueryDownloadState().setValue(new ErrorState(valueOf));
        Object errorInDownload = errorInDownload(prepCustomDownloadManagerStatus(valueOf), getCurrentGameResource(), continuation);
        if (errorInDownload == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return errorInDownload;
        }
        return Unit.INSTANCE;
    }

    public final void cleanUp() {
        TypeUtilsKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    @SuppressLint({"Range"})
    public final Object downloadFileProcess(DownloadTaskParams downloadTaskParams2, boolean z, Continuation<? super String> continuation) {
        return TypeUtilsKt.withContext(this.ioDispatcher, new QueryDownload$downloadFileProcess$2(this, z, downloadTaskParams2, null), continuation);
    }

    public final Context getContext() {
        return this.context;
    }

    public CoroutineContext getCoroutineContext() {
        return DefaultImpls.plus((JobSupport) TypeUtilsKt.SupervisorJob$default(null, 1), this.ioDispatcher);
    }

    public final GameAssetResource getCurrentGameResource() {
        GameAssetResource gameAssetResource = this.currentGameResource;
        if (gameAssetResource != null) {
            return gameAssetResource;
        }
        Intrinsics.throwUninitializedPropertyAccessException("currentGameResource");
        throw null;
    }

    public final DownloadManager getDownloadManager() {
        return this.downloadManager;
    }

    public final DownloadTaskParams getDownloadTaskParams() {
        DownloadTaskParams downloadTaskParams2 = this.downloadTaskParams;
        if (downloadTaskParams2 != null) {
            return downloadTaskParams2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("downloadTaskParams");
        throw null;
    }

    public final MutableStateFlow<QueryDownloadStates> getQueryDownloadState() {
        MutableStateFlow<QueryDownloadStates> mutableStateFlow = this.queryDownloadState;
        if (mutableStateFlow != null) {
            return mutableStateFlow;
        }
        Intrinsics.throwUninitializedPropertyAccessException("queryDownloadState");
        throw null;
    }

    public final boolean isWebViewFlow() {
        return this.isWebViewFlow;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setCurrentGameResource(GameAssetResource gameAssetResource) {
        Intrinsics.checkNotNullParameter(gameAssetResource, "<set-?>");
        this.currentGameResource = gameAssetResource;
    }

    public final void setDownloadManager(DownloadManager downloadManager2) {
        Intrinsics.checkNotNullParameter(downloadManager2, "<set-?>");
        this.downloadManager = downloadManager2;
    }

    public final void setDownloadTaskParams(DownloadTaskParams downloadTaskParams2) {
        Intrinsics.checkNotNullParameter(downloadTaskParams2, "<set-?>");
        this.downloadTaskParams = downloadTaskParams2;
    }

    public final void setQueryDownloadState(MutableStateFlow<QueryDownloadStates> mutableStateFlow) {
        Intrinsics.checkNotNullParameter(mutableStateFlow, "<set-?>");
        this.queryDownloadState = mutableStateFlow;
    }

    public final void setWebViewFlow(boolean z) {
        this.isWebViewFlow = z;
    }
}
