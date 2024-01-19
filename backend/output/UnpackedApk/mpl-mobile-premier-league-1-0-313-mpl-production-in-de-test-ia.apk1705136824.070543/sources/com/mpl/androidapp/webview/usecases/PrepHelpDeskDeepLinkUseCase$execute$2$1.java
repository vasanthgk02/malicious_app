package com.mpl.androidapp.webview.usecases;

import android.content.Intent;
import android.os.Bundle;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.HelpDeskRedirect;
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
@DebugMetadata(c = "com.mpl.androidapp.webview.usecases.PrepHelpDeskDeepLinkUseCase$execute$2$1", f = "PrepHelpDeskDeepLinkUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: PrepHelpDeskDeepLinkUseCase.kt */
public final class PrepHelpDeskDeepLinkUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends WebViewGameActivityStates>> $coroutine;
    public final /* synthetic */ int $gameId;
    public int label;
    public final /* synthetic */ PrepHelpDeskDeepLinkUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PrepHelpDeskDeepLinkUseCase$execute$2$1(PrepHelpDeskDeepLinkUseCase prepHelpDeskDeepLinkUseCase, CancellableContinuation<? super UseCaseResult<? extends WebViewGameActivityStates>> cancellableContinuation, int i, Continuation<? super PrepHelpDeskDeepLinkUseCase$execute$2$1> continuation) {
        // this.this$0 = prepHelpDeskDeepLinkUseCase;
        // this.$coroutine = cancellableContinuation;
        // this.$gameId = i;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrepHelpDeskDeepLinkUseCase$execute$2$1(this.this$0, this.$coroutine, this.$gameId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PrepHelpDeskDeepLinkUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                Intent intent = new Intent(this.this$0.getContext(), this.this$0.reactContainer);
                PrepHelpDeskDeepLinkUseCase prepHelpDeskDeepLinkUseCase = this.this$0;
                int i = this.$gameId;
                intent.putExtra("actionTaken", "payment");
                Bundle bundle = new Bundle();
                bundle.putString("action", "OPEN_DEEP_LINK");
                bundle.putString("actionParams", prepHelpDeskDeepLinkUseCase.helpDeskDeepLink(i));
                intent.putExtras(bundle);
                this.$coroutine.resumeWith(new Success(new HelpDeskRedirect(intent)));
            } catch (Exception e2) {
                this.$coroutine.resumeWith(TweetUtils.createFailure(new Exception(e2.getMessage())));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
