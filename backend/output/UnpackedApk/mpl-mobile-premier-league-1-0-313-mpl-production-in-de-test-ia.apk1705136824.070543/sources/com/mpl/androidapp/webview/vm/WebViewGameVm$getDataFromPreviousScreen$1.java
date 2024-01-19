package com.mpl.androidapp.webview.vm;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.webview.vm.WebViewGameVm$getDataFromPreviousScreen$1", f = "WebViewGameVm.kt", l = {310, 312}, m = "invokeSuspend")
/* compiled from: WebViewGameVm.kt */
public final class WebViewGameVm$getDataFromPreviousScreen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Intent $intent;
    public final /* synthetic */ String $key;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ WebViewGameVm this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewGameVm$getDataFromPreviousScreen$1(Intent intent, String str, WebViewGameVm webViewGameVm, Continuation<? super WebViewGameVm$getDataFromPreviousScreen$1> continuation) {
        // this.$intent = intent;
        // this.$key = str;
        // this.this$0 = webViewGameVm;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WebViewGameVm$getDataFromPreviousScreen$1 webViewGameVm$getDataFromPreviousScreen$1 = new WebViewGameVm$getDataFromPreviousScreen$1(this.$intent, this.$key, this.this$0, continuation);
        webViewGameVm$getDataFromPreviousScreen$1.L$0 = obj;
        return webViewGameVm$getDataFromPreviousScreen$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewGameVm$getDataFromPreviousScreen$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r8.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0021
            if (r1 == r4) goto L_0x0019
            if (r1 != r3) goto L_0x0011
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x006b
        L_0x0011:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0019:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            goto L_0x004f
        L_0x0021:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            android.content.Intent r1 = r8.$intent
            if (r1 != 0) goto L_0x002e
            r9 = r2
            goto L_0x0051
        L_0x002e:
            java.lang.String r5 = r8.$key
            com.mpl.androidapp.webview.vm.WebViewGameVm r6 = r8.this$0
            java.lang.String r1 = r1.getStringExtra(r5)
            kotlinx.coroutines.flow.MutableStateFlow r5 = r6._viewState
            com.mpl.androidapp.webview.states.WebViewGameActivityStates$GetDataFromPreviousScreen r6 = new com.mpl.androidapp.webview.states.WebViewGameActivityStates$GetDataFromPreviousScreen
            java.lang.String r7 = "dataReceived"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r7)
            r6.<init>(r1)
            r8.L$0 = r9
            r8.label = r4
            java.lang.Object r9 = r5.emit(r6, r8)
            if (r9 != r0) goto L_0x004f
            return r0
        L_0x004f:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
        L_0x0051:
            if (r9 != 0) goto L_0x006b
            com.mpl.androidapp.webview.vm.WebViewGameVm r9 = r8.this$0
            kotlinx.coroutines.flow.MutableStateFlow r9 = r9._viewState
            com.mpl.androidapp.webview.states.WebViewGameActivityStates$ErrorState r1 = new com.mpl.androidapp.webview.states.WebViewGameActivityStates$ErrorState
            java.lang.String r4 = "Null value is received from intent"
            r1.<init>(r4)
            r8.L$0 = r2
            r8.label = r3
            java.lang.Object r9 = r9.emit(r1, r8)
            if (r9 != r0) goto L_0x006b
            return r0
        L_0x006b:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.webview.vm.WebViewGameVm$getDataFromPreviousScreen$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
