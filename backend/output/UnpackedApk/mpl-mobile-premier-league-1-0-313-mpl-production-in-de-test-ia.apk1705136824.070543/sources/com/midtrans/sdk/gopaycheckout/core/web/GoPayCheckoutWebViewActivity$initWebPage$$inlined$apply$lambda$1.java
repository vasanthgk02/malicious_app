package com.midtrans.sdk.gopaycheckout.core.web;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "url", "", "invoke", "com/midtrans/sdk/gopaycheckout/core/web/GoPayCheckoutWebViewActivity$initWebPage$1$1"}, k = 3, mv = {1, 1, 16})
public final class GoPayCheckoutWebViewActivity$initWebPage$$inlined$apply$lambda$1 extends Lambda implements Function1<String, Boolean> {
    public final /* synthetic */ GoPayCheckoutWebViewActivity this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GoPayCheckoutWebViewActivity$initWebPage$$inlined$apply$lambda$1(GoPayCheckoutWebViewActivity goPayCheckoutWebViewActivity) {
        // this.this$0 = goPayCheckoutWebViewActivity;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((String) obj));
    }

    public final boolean invoke(String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        return this.this$0.checkCallbackUrl(str);
    }
}
