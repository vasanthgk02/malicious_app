package com.mpl.androidapp.webview.view.activities;

import com.mpl.androidapp.R;
import com.mpl.androidapp.databinding.ActivityWebviewGameBinding;
import com.mpl.androidapp.webview.view.customviews.WebViewLoaderContainer;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.webview.view.activities.WebViewGameActivity$prepareSessionApiParams$2", f = "WebViewGameActivity.kt", l = {}, m = "invokeSuspend")
/* compiled from: WebViewGameActivity.kt */
public final class WebViewGameActivity$prepareSessionApiParams$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ JSONObject $reactDataForWebGame;
    public int label;
    public final /* synthetic */ WebViewGameActivity this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewGameActivity$prepareSessionApiParams$2(WebViewGameActivity webViewGameActivity, JSONObject jSONObject, Continuation<? super WebViewGameActivity$prepareSessionApiParams$2> continuation) {
        // this.this$0 = webViewGameActivity;
        // this.$reactDataForWebGame = jSONObject;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewGameActivity$prepareSessionApiParams$2(this.this$0, this.$reactDataForWebGame, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewGameActivity$prepareSessionApiParams$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            ((WebViewLoaderContainer) ((ActivityWebviewGameBinding) this.this$0.getBinding()).webViewGamesContainerId._$_findCachedViewById(R.id.web_games_loader_view)).setProgressType(true);
            ((WebViewLoaderContainer) ((ActivityWebviewGameBinding) this.this$0.getBinding()).webViewGamesContainerId._$_findCachedViewById(R.id.web_games_loader_view)).setLoadingMessageText("Validating the user");
            WebViewGameVm access$getViewModel$p = this.this$0.viewModel;
            if (access$getViewModel$p != null) {
                access$getViewModel$p.callSessionApi(this.$reactDataForWebGame, this.this$0.isConnectedToNetwork());
                return Unit.INSTANCE;
            }
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            throw null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
