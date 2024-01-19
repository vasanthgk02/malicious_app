package com.mpl.androidapp.webview.vm;

import com.mpl.androidapp.share.MplShareFeature;
import com.mpl.androidapp.share.deeplink.DeepLinkObjects;
import com.mpl.androidapp.share.models.ShareData;
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
@DebugMetadata(c = "com.mpl.androidapp.webview.vm.WebViewGameVm$initiateShare$1", f = "WebViewGameVm.kt", l = {}, m = "invokeSuspend")
/* compiled from: WebViewGameVm.kt */
public final class WebViewGameVm$initiateShare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ String $launchFrom;
    public final /* synthetic */ String $platform;
    public final /* synthetic */ String $screenName;
    public final /* synthetic */ String $shareMessage;
    public int label;
    public final /* synthetic */ WebViewGameVm this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewGameVm$initiateShare$1(String str, String str2, String str3, String str4, WebViewGameVm webViewGameVm, Continuation<? super WebViewGameVm$initiateShare$1> continuation) {
        // this.$launchFrom = str;
        // this.$screenName = str2;
        // this.$shareMessage = str3;
        // this.$platform = str4;
        // this.this$0 = webViewGameVm;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WebViewGameVm$initiateShare$1 webViewGameVm$initiateShare$1 = new WebViewGameVm$initiateShare$1(this.$launchFrom, this.$screenName, this.$shareMessage, this.$platform, this.this$0, continuation);
        return webViewGameVm$initiateShare$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewGameVm$initiateShare$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            if (!(this.$launchFrom == null || this.$screenName == null || this.$shareMessage == null || this.$platform == null)) {
                ShareData prepWebFlowGameTxtShare = DeepLinkObjects.INSTANCE.prepWebFlowGameTxtShare(this.this$0.getGameId(), this.$shareMessage, this.$launchFrom, this.$screenName, this.$platform);
                MplShareFeature access$getMplShareFeature$p = this.this$0.mplShareFeature;
                access$getMplShareFeature$p.setShareConditions(prepWebFlowGameTxtShare);
                access$getMplShareFeature$p.runFeature();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
