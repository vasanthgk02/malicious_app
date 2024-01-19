package com.mpl.androidapp.webview.vm;

import com.mpl.androidapp.webview.states.WebViewGameActivityStates.InitialState;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.webview.vm.WebViewGameVm$initializeStates$1", f = "WebViewGameVm.kt", l = {159}, m = "invokeSuspend")
/* compiled from: WebViewGameVm.kt */
public final class WebViewGameVm$initializeStates$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ WebViewGameVm this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewGameVm$initializeStates$1(WebViewGameVm webViewGameVm, Continuation<? super WebViewGameVm$initializeStates$1> continuation) {
        // this.this$0 = webViewGameVm;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewGameVm$initializeStates$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewGameVm$initializeStates$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            MutableStateFlow access$get_viewState$p = this.this$0._viewState;
            InitialState initialState = InitialState.INSTANCE;
            this.label = 1;
            if (access$get_viewState$p.emit(initialState, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
