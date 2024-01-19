package com.mpl.androidapp.webview.view.activities;

import com.mpl.androidapp.webview.states.WebViewGameActivityStates;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.webview.view.activities.WebViewGameActivity$setupObserver$1", f = "WebViewGameActivity.kt", l = {178}, m = "invokeSuspend")
/* compiled from: WebViewGameActivity.kt */
public final class WebViewGameActivity$setupObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ WebViewGameActivity this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewGameActivity$setupObserver$1(WebViewGameActivity webViewGameActivity, Continuation<? super WebViewGameActivity$setupObserver$1> continuation) {
        // this.this$0 = webViewGameActivity;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewGameActivity$setupObserver$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewGameActivity$setupObserver$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            WebViewGameVm access$getViewModel$p = this.this$0.viewModel;
            if (access$getViewModel$p != null) {
                StateFlow<WebViewGameActivityStates> viewState = access$getViewModel$p.getViewState();
                final WebViewGameActivity webViewGameActivity = this.this$0;
                AnonymousClass1 r1 = new FlowCollector() {
                    public final Object emit(WebViewGameActivityStates webViewGameActivityStates, Continuation<? super Unit> continuation) {
                        webViewGameActivity.setViewState(webViewGameActivityStates);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (viewState.collect(r1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                throw null;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            TweetUtils.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
