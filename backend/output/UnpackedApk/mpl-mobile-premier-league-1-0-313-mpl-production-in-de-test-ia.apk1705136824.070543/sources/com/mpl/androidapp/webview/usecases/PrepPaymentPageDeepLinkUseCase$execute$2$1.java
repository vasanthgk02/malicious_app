package com.mpl.androidapp.webview.usecases;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates;
import com.mpl.androidapp.webview.states.WebViewGameActivityStates.PaymentRedirect;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.Regex;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.webview.usecases.PrepPaymentPageDeepLinkUseCase$execute$2$1", f = "PrepPaymentPageDeepLinkUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: PrepPaymentPageDeepLinkUseCase.kt */
public final class PrepPaymentPageDeepLinkUseCase$execute$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends WebViewGameActivityStates>> $coroutine;
    public final /* synthetic */ String $data;
    public int label;
    public final /* synthetic */ PrepPaymentPageDeepLinkUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PrepPaymentPageDeepLinkUseCase$execute$2$1(String str, PrepPaymentPageDeepLinkUseCase prepPaymentPageDeepLinkUseCase, CancellableContinuation<? super UseCaseResult<? extends WebViewGameActivityStates>> cancellableContinuation, Continuation<? super PrepPaymentPageDeepLinkUseCase$execute$2$1> continuation) {
        // this.$data = str;
        // this.this$0 = prepPaymentPageDeepLinkUseCase;
        // this.$coroutine = cancellableContinuation;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrepPaymentPageDeepLinkUseCase$execute$2$1(this.$data, this.this$0, this.$coroutine, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PrepPaymentPageDeepLinkUseCase$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            try {
                String replace = new Regex((String) "addMoney_").replace(this.$data, "");
                if (TextUtils.isDigitsOnly(replace)) {
                    Intent intent = new Intent(this.this$0.getContext(), this.this$0.reactContainer);
                    PrepPaymentPageDeepLinkUseCase prepPaymentPageDeepLinkUseCase = this.this$0;
                    Bundle bundle = new Bundle();
                    JSONObject access$prepareJsonParam = prepPaymentPageDeepLinkUseCase.prepareJsonParam(replace);
                    bundle.putString("action", "OPEN_DEEP_LINK");
                    bundle.putString("actionParams", prepPaymentPageDeepLinkUseCase.deepLinkPayment(access$prepareJsonParam));
                    intent.putExtra("actionTaken", "payment");
                    intent.putExtras(bundle);
                    this.$coroutine.resumeWith(new Success(new PaymentRedirect(intent)));
                }
            } catch (Exception e2) {
                this.$coroutine.resumeWith(TweetUtils.createFailure(new Exception(e2.getMessage())));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
