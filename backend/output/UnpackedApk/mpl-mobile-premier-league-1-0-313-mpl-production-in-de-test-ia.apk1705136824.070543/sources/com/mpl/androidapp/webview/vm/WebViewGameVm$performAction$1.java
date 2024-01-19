package com.mpl.androidapp.webview.vm;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.webview.vm.WebViewGameVm$performAction$1", f = "WebViewGameVm.kt", l = {101, 102, 103, 104, 105, 106, 107, 108, 110}, m = "invokeSuspend")
/* compiled from: WebViewGameVm.kt */
public final class WebViewGameVm$performAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ String $action;
    public int label;
    public final /* synthetic */ WebViewGameVm this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewGameVm$performAction$1(String str, WebViewGameVm webViewGameVm, Continuation<? super WebViewGameVm$performAction$1> continuation) {
        // this.$action = str;
        // this.this$0 = webViewGameVm;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewGameVm$performAction$1(this.$action, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewGameVm$performAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003b, code lost:
        if (r8.equals("RESTART") == false) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007d, code lost:
        if (r8.equals("CLOSE") == false) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00dc, code lost:
        if (r8.equals("RELOAD") == false) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00df, code lost:
        r8 = r1._viewState;
        r1 = com.mpl.androidapp.webview.states.WebViewGameActivityStates.ReloadState.INSTANCE;
        r7.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00eb, code lost:
        if (r8.emit(r1, r7) != r0) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ed, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010d, code lost:
        if (r8.equals("CLOSE_WEB") == false) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0110, code lost:
        r8 = r1._viewState;
        r1 = com.mpl.androidapp.webview.states.WebViewGameActivityStates.CloseScreen.INSTANCE;
        r7.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011d, code lost:
        if (r8.emit(r1, r7) != r0) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x011f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0126, code lost:
        if (kotlin.text.CharsKt__CharKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) "addMoney_", false, 2) == false) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0128, code lost:
        r7.label = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0130, code lost:
        if (r1.prepPaymentDeepLink(r8, r7) != r0) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0139, code lost:
        if (kotlin.text.CharsKt__CharKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) "openURL_", false, 2) == false) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013b, code lost:
        r0 = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(kotlin.text.CharsKt__CharKt.replace$default(r8, (java.lang.String) "openURL_", (java.lang.String) "", false, 4)));
        r0.setFlags(org.eclipse.paho.client.mqttv3.internal.ClientDefaults.MAX_MSG_SIZE);
        r1.getContext().startActivity(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r7.label
            switch(r1) {
                case 0: goto L_0x0014;
                case 1: goto L_0x000f;
                case 2: goto L_0x000f;
                case 3: goto L_0x000f;
                case 4: goto L_0x000f;
                case 5: goto L_0x000f;
                case 6: goto L_0x000f;
                case 7: goto L_0x000f;
                case 8: goto L_0x000f;
                case 9: goto L_0x000f;
                default: goto L_0x0007;
            }
        L_0x0007:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x000f:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x0158
        L_0x0014:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            java.lang.String r8 = r7.$action
            if (r8 != 0) goto L_0x001d
            goto L_0x0158
        L_0x001d:
            com.mpl.androidapp.webview.vm.WebViewGameVm r1 = r7.this$0
            com.mpl.androidapp.webview.ct.WebViewGamesGamesCt r2 = com.mpl.androidapp.webview.ct.WebViewGamesGamesCt.INSTANCE
            int r3 = r1.getGameId()
            r4 = 0
            r5 = 1
            r2.sendCtEventForWebFlowGame(r4, r5, r8, r3)
            int r2 = r8.hashCode()
            r3 = 4
            r6 = 2
            switch(r2) {
                case -1989560243: goto L_0x0107;
                case -1881401917: goto L_0x00ee;
                case -1881311847: goto L_0x00d6;
                case -1635177780: goto L_0x00b9;
                case -790251142: goto L_0x00a0;
                case -339461814: goto L_0x0081;
                case 64218584: goto L_0x0077;
                case 155414613: goto L_0x005e;
                case 831485225: goto L_0x003f;
                case 1815489007: goto L_0x0035;
                default: goto L_0x0033;
            }
        L_0x0033:
            goto L_0x0120
        L_0x0035:
            java.lang.String r2 = "RESTART"
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L_0x00df
            goto L_0x0120
        L_0x003f:
            java.lang.String r2 = "ORIENTATION_SENSOR"
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L_0x0049
            goto L_0x0120
        L_0x0049:
            kotlinx.coroutines.flow.MutableStateFlow r8 = r1._viewState
            com.mpl.androidapp.webview.states.WebViewGameActivityStates$ChangeOrientation r1 = new com.mpl.androidapp.webview.states.WebViewGameActivityStates$ChangeOrientation
            java.lang.String r2 = "sensor"
            r1.<init>(r2)
            r2 = 6
            r7.label = r2
            java.lang.Object r8 = r8.emit(r1, r7)
            if (r8 != r0) goto L_0x0158
            return r0
        L_0x005e:
            java.lang.String r2 = "HANDLE_BACK_NAVIGATION"
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L_0x0068
            goto L_0x0120
        L_0x0068:
            kotlinx.coroutines.flow.MutableStateFlow r8 = r1._viewState
            com.mpl.androidapp.webview.states.WebViewGameActivityStates$HandleBackNavigation r1 = com.mpl.androidapp.webview.states.WebViewGameActivityStates.HandleBackNavigation.INSTANCE
            r7.label = r5
            java.lang.Object r8 = r8.emit(r1, r7)
            if (r8 != r0) goto L_0x0158
            return r0
        L_0x0077:
            java.lang.String r2 = "CLOSE"
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L_0x0110
            goto L_0x0120
        L_0x0081:
            java.lang.String r2 = "ORIENTATION_PORTRAIT"
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L_0x008b
            goto L_0x0120
        L_0x008b:
            kotlinx.coroutines.flow.MutableStateFlow r8 = r1._viewState
            com.mpl.androidapp.webview.states.WebViewGameActivityStates$ChangeOrientation r1 = new com.mpl.androidapp.webview.states.WebViewGameActivityStates$ChangeOrientation
            java.lang.String r2 = "portrait"
            r1.<init>(r2)
            r2 = 5
            r7.label = r2
            java.lang.Object r8 = r8.emit(r1, r7)
            if (r8 != r0) goto L_0x0158
            return r0
        L_0x00a0:
            java.lang.String r2 = "helpDesk"
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L_0x00aa
            goto L_0x0120
        L_0x00aa:
            int r8 = r1.getGameId()
            r2 = 8
            r7.label = r2
            java.lang.Object r8 = r1.prepHelpDeskDeepLink(r8, r7)
            if (r8 != r0) goto L_0x0158
            return r0
        L_0x00b9:
            java.lang.String r2 = "ORIENTATION_LANDSCAPE"
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L_0x00c2
            goto L_0x0120
        L_0x00c2:
            kotlinx.coroutines.flow.MutableStateFlow r8 = r1._viewState
            com.mpl.androidapp.webview.states.WebViewGameActivityStates$ChangeOrientation r1 = new com.mpl.androidapp.webview.states.WebViewGameActivityStates$ChangeOrientation
            java.lang.String r2 = "landscape"
            r1.<init>(r2)
            r7.label = r3
            java.lang.Object r8 = r8.emit(r1, r7)
            if (r8 != r0) goto L_0x0158
            return r0
        L_0x00d6:
            java.lang.String r2 = "RELOAD"
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L_0x00df
            goto L_0x0120
        L_0x00df:
            kotlinx.coroutines.flow.MutableStateFlow r8 = r1._viewState
            com.mpl.androidapp.webview.states.WebViewGameActivityStates$ReloadState r1 = com.mpl.androidapp.webview.states.WebViewGameActivityStates.ReloadState.INSTANCE
            r7.label = r6
            java.lang.Object r8 = r8.emit(r1, r7)
            if (r8 != r0) goto L_0x0158
            return r0
        L_0x00ee:
            java.lang.String r2 = "REINIT"
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L_0x00f7
            goto L_0x0120
        L_0x00f7:
            kotlinx.coroutines.flow.MutableStateFlow r8 = r1._viewState
            com.mpl.androidapp.webview.states.WebViewGameActivityStates$ReInitState r1 = com.mpl.androidapp.webview.states.WebViewGameActivityStates.ReInitState.INSTANCE
            r2 = 3
            r7.label = r2
            java.lang.Object r8 = r8.emit(r1, r7)
            if (r8 != r0) goto L_0x0158
            return r0
        L_0x0107:
            java.lang.String r2 = "CLOSE_WEB"
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L_0x0110
            goto L_0x0120
        L_0x0110:
            kotlinx.coroutines.flow.MutableStateFlow r8 = r1._viewState
            com.mpl.androidapp.webview.states.WebViewGameActivityStates$CloseScreen r1 = com.mpl.androidapp.webview.states.WebViewGameActivityStates.CloseScreen.INSTANCE
            r2 = 7
            r7.label = r2
            java.lang.Object r8 = r8.emit(r1, r7)
            if (r8 != r0) goto L_0x0158
            return r0
        L_0x0120:
            java.lang.String r2 = "addMoney_"
            boolean r2 = kotlin.text.CharsKt__CharKt.contains$default(r8, r2, r4, r6)
            if (r2 == 0) goto L_0x0133
            r2 = 9
            r7.label = r2
            java.lang.Object r8 = r1.prepPaymentDeepLink(r8, r7)
            if (r8 != r0) goto L_0x0158
            return r0
        L_0x0133:
            java.lang.String r0 = "openURL_"
            boolean r2 = kotlin.text.CharsKt__CharKt.contains$default(r8, r0, r4, r6)
            if (r2 == 0) goto L_0x0158
            java.lang.String r2 = ""
            java.lang.String r8 = kotlin.text.CharsKt__CharKt.replace$default(r8, r0, r2, r4, r3)
            android.content.Intent r0 = new android.content.Intent
            android.net.Uri r8 = android.net.Uri.parse(r8)
            java.lang.String r2 = "android.intent.action.VIEW"
            r0.<init>(r2, r8)
            r8 = 268435456(0x10000000, float:2.524355E-29)
            r0.setFlags(r8)
            android.app.Application r8 = r1.getContext()
            r8.startActivity(r0)
        L_0x0158:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.webview.vm.WebViewGameVm$performAction$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
