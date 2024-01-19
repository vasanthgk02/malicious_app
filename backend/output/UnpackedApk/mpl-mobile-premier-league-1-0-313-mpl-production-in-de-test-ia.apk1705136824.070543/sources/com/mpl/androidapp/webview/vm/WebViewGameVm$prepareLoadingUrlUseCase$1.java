package com.mpl.androidapp.webview.vm;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.webview.vm.WebViewGameVm", f = "WebViewGameVm.kt", l = {268, 273}, m = "prepareLoadingUrlUseCase")
/* compiled from: WebViewGameVm.kt */
public final class WebViewGameVm$prepareLoadingUrlUseCase$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ WebViewGameVm this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewGameVm$prepareLoadingUrlUseCase$1(WebViewGameVm webViewGameVm, Continuation<? super WebViewGameVm$prepareLoadingUrlUseCase$1> continuation) {
        // this.this$0 = webViewGameVm;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.prepareLoadingUrlUseCase(null, this);
    }
}
