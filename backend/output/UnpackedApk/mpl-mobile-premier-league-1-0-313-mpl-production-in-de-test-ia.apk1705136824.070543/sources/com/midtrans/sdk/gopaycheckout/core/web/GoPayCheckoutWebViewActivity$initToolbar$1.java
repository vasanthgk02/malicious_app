package com.midtrans.sdk.gopaycheckout.core.web;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.widget.Toolbar;
import com.midtrans.sdk.gopaycheckout.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
public final class GoPayCheckoutWebViewActivity$initToolbar$1 implements OnClickListener {
    public final /* synthetic */ GoPayCheckoutWebViewActivity this$0;

    public GoPayCheckoutWebViewActivity$initToolbar$1(GoPayCheckoutWebViewActivity goPayCheckoutWebViewActivity) {
        this.this$0 = goPayCheckoutWebViewActivity;
    }

    public final void onClick(View view) {
        Toolbar toolbar = (Toolbar) this.this$0._$_findCachedViewById(R.id.toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar, "toolbar");
        toolbar.setEnabled(false);
        this.this$0.complete();
    }
}
