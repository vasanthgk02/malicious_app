package com.mpl.androidapp.share.usecases;

import android.content.Intent;
import com.mpl.androidapp.share.models.ShareData;
import com.mpl.androidapp.share.states.ShareModuleStates;
import com.mpl.androidapp.share.states.ShareModuleStates.ShareIntent;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.share.usecases.PrepareShareIntent$execute$2$1", f = "PrepareShareIntent.kt", l = {}, m = "invokeSuspend")
/* compiled from: PrepareShareIntent.kt */
public final class PrepareShareIntent$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends ShareModuleStates>> $coroutine;
    public final /* synthetic */ ShareData $parameters;
    public int label;
    public final /* synthetic */ PrepareShareIntent this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PrepareShareIntent$execute$2$1(ShareData shareData, PrepareShareIntent prepareShareIntent, CancellableContinuation<? super UseCaseResult<? extends ShareModuleStates>> cancellableContinuation, Continuation<? super PrepareShareIntent$execute$2$1> continuation) {
        // this.$parameters = shareData;
        // this.this$0 = prepareShareIntent;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrepareShareIntent$execute$2$1(this.$parameters, this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PrepareShareIntent$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                String shareType = this.$parameters.getShareType();
                String sharePlatform = this.$parameters.getSharePlatform();
                this.$parameters.getShareFormat();
                this.$parameters.getTextToBeShared();
                String imageUriToBeShared = this.$parameters.getImageUriToBeShared();
                Intent intent = new Intent("android.intent.action.SEND");
                this.this$0.setTypeToBeShared(shareType, intent);
                this.this$0.setPlatformToBeShared(sharePlatform, intent);
                this.this$0.setTextToShare(this.$parameters, intent);
                this.this$0.setImgToShare(imageUriToBeShared, intent);
                this.$coroutine.resumeWith(new Success(new ShareIntent(intent)));
            } catch (Exception e2) {
                this.$coroutine.resumeWith(new Error(e2));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
