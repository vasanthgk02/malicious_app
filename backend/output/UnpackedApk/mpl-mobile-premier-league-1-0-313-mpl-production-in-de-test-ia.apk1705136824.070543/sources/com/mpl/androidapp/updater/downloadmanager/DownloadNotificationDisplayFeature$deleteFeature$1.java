package com.mpl.androidapp.updater.downloadmanager;

import com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.DeleteGameAssetResourceFromId;
import com.mpl.androidapp.updater.downloadmanager.usecases.OptionalDownloadVisitDeleteUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResultKt;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.DownloadNotificationDisplayFeature$deleteFeature$1", f = "DownloadNotificationDisplayFeature.kt", l = {67, 72}, m = "invokeSuspend")
/* compiled from: DownloadNotificationDisplayFeature.kt */
public final class DownloadNotificationDisplayFeature$deleteFeature$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ String $gameId;
    public int label;
    public final /* synthetic */ DownloadNotificationDisplayFeature this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DownloadNotificationDisplayFeature$deleteFeature$1(DownloadNotificationDisplayFeature downloadNotificationDisplayFeature, String str, Continuation<? super DownloadNotificationDisplayFeature$deleteFeature$1> continuation) {
        // this.this$0 = downloadNotificationDisplayFeature;
        // this.$gameId = str;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadNotificationDisplayFeature$deleteFeature$1(this.this$0, this.$gameId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadNotificationDisplayFeature$deleteFeature$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            OptionalDownloadVisitDeleteUseCase access$getOptionalDownloadVisitDeleteUseCase$p = this.this$0.optionalDownloadVisitDeleteUseCase;
            String str = this.$gameId;
            this.label = 1;
            obj = access$getOptionalDownloadVisitDeleteUseCase$p.invoke(str, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else if (i == 2) {
            TweetUtils.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UseCaseResult useCaseResult = (UseCaseResult) obj;
        if (useCaseResult instanceof Success) {
            Object data = UseCaseResultKt.getData((UseCaseResult) ((Success) useCaseResult).getValue());
            if (data != null) {
                DeleteGameAssetResourceFromId deleteGameAssetResourceFromId = (DeleteGameAssetResourceFromId) data;
                if (deleteGameAssetResourceFromId.isDeleted()) {
                    this.this$0.queryDownloadState.setValue(deleteGameAssetResourceFromId);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.mpl.androidapp.updater.downloadmanager.states.QueryDownloadStates.DeleteGameAssetResourceFromId");
            }
        } else if (useCaseResult instanceof Error) {
            this.label = 2;
            if (this.this$0.useCaseError((Error) useCaseResult, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
