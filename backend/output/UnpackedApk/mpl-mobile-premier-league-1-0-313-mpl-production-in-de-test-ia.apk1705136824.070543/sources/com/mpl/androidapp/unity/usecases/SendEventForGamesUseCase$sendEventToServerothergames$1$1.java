package com.mpl.androidapp.unity.usecases;

import com.mpl.androidapp.database.DatabaseClient;
import com.mpl.androidapp.react.MPLReactContainerActivity.GameEventCallback;
import com.mpl.androidapp.unity.states.MPLUnityFeaturesState;
import com.mpl.androidapp.unity.states.MPLUnityFeaturesState.SendEventForGamesSuccessful;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.network.modules.listeners.IResponseListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/mpl/androidapp/unity/usecases/SendEventForGamesUseCase$sendEventToServerothergames$1$1", "Lcom/mpl/network/modules/listeners/IResponseListener;", "", "onResponseFail", "", "ex", "Ljava/lang/Exception;", "onResponseSuccess", "o", "progressResponse", "bytesRead", "", "contentLength", "done", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SendEventForGamesUseCase.kt */
public final class SendEventForGamesUseCase$sendEventToServerothergames$1$1 extends IResponseListener<String> {
    public final /* synthetic */ GameEventCallback $callback;
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends MPLUnityFeaturesState>> $coroutine;
    public final /* synthetic */ String $event;
    public final /* synthetic */ String $eventProp;
    public final /* synthetic */ SendEventForGamesUseCase this$0;

    public SendEventForGamesUseCase$sendEventToServerothergames$1$1(SendEventForGamesUseCase sendEventForGamesUseCase, GameEventCallback gameEventCallback, CancellableContinuation<? super UseCaseResult<? extends MPLUnityFeaturesState>> cancellableContinuation, String str, String str2) {
        this.this$0 = sendEventForGamesUseCase;
        this.$callback = gameEventCallback;
        this.$coroutine = cancellableContinuation;
        this.$event = str;
        this.$eventProp = str2;
    }

    public void onResponseFail(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "ex");
        DatabaseClient.getInstance(this.this$0.getContext()).addEventAll(this.$event, this.$eventProp);
        System.out.println("failed and stored in data base");
        MLogger.d(this.this$0.getTag(), Intrinsics.stringPlus("final call failed with exception", exc));
        this.$callback.onFailure(exc.getMessage());
        this.$coroutine.resumeWith(new Error(new Exception(exc.getMessage())));
    }

    public void progressResponse(long j, long j2, boolean z) {
    }

    public void onResponseSuccess(String str) {
        MLogger.d(this.this$0.getTag(), "final call made");
        this.$callback.onSuccess(str);
        this.$coroutine.resumeWith(new Success(SendEventForGamesSuccessful.INSTANCE));
        System.out.println("success and given to api");
    }
}
