package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.config.UpdaterAnalytics;
import com.mpl.androidapp.updater.downloadmanager.data.AnalyticsParams;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates;
import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.AnalyticsUpdated;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.mpl.androidapp.updater.model.GameAssets;
import com.mpl.androidapp.utils.MLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.usecases.UpdateAssetsAnalyticsUseCase$execute$2$1", f = "UpdateAssetsAnalyticsUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: UpdateAssetsAnalyticsUseCase.kt */
public final class UpdateAssetsAnalyticsUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ AnalyticsParams $analyticsParams;
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends QueryDownloadStates>> $coroutine;
    public int label;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public UpdateAssetsAnalyticsUseCase$execute$2$1(AnalyticsParams analyticsParams, CancellableContinuation<? super UseCaseResult<? extends QueryDownloadStates>> cancellableContinuation, Continuation<? super UpdateAssetsAnalyticsUseCase$execute$2$1> continuation) {
        // this.$analyticsParams = analyticsParams;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpdateAssetsAnalyticsUseCase$execute$2$1(this.$analyticsParams, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UpdateAssetsAnalyticsUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                String message = this.$analyticsParams.getMessage();
                boolean errorOnDownload = this.$analyticsParams.getErrorOnDownload();
                DownloadTaskParams downloadTaskParams = this.$analyticsParams.getDownloadTaskParams();
                String gameName = downloadTaskParams.getGameAssets().getGameName();
                int gameId = downloadTaskParams.getGameId();
                int size = (int) (downloadTaskParams.getGameAssets().getSize() / downloadTaskParams.getSIZE_MB());
                GameAssets gameAssets = downloadTaskParams.getGameAssets();
                String stringPlus = Intrinsics.stringPlus("Error in downloading the file caused due to :", message);
                boolean z = true;
                MLogger.d("DownloadOfAssets", "Updating the analytics whether downloads are successful or un successful");
                Object[] objArr = new Object[1];
                if (!errorOnDownload) {
                    z = false;
                }
                objArr[0] = Intrinsics.stringPlus("Is Successful download:------> ", Boolean.valueOf(z));
                MLogger.d("DownloadOfAssets", objArr);
                if (!errorOnDownload) {
                    UpdaterAnalytics.gameAssetsDownloadedEvent(gameName, gameId, size, false, gameAssets);
                } else {
                    UpdaterAnalytics.gameAssetsDownloadFailedEvent(gameName, gameId, size, false, gameAssets, new Exception(stringPlus));
                }
                this.$coroutine.resumeWith(new Success(AnalyticsUpdated.INSTANCE));
            } catch (Exception e2) {
                this.$coroutine.resumeWith(new Error(e2));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
