package com.midtrans.sdk.gopaycheckout.core.web;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 16})
public final class GoPayCheckoutWebViewActivity$callbackUrl$2 extends Lambda implements Function0<String> {
    public final /* synthetic */ GoPayCheckoutWebViewActivity this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GoPayCheckoutWebViewActivity$callbackUrl$2(GoPayCheckoutWebViewActivity goPayCheckoutWebViewActivity) {
        // this.this$0 = goPayCheckoutWebViewActivity;
        super(0);
    }

    public final String invoke() {
        return this.this$0.getIntent().getStringExtra(GoPayCheckoutWebViewActivity.CALLBACK_URL);
    }
}
