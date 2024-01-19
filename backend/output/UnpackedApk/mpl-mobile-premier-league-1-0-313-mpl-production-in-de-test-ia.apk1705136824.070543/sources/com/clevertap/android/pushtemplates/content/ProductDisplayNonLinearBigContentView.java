package com.clevertap.android.pushtemplates.content;

import android.content.Context;
import android.os.Bundle;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.pushtemplates.R$id;
import com.clevertap.android.pushtemplates.R$layout;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/clevertap/android/pushtemplates/content/ProductDisplayNonLinearBigContentView;", "Lcom/clevertap/android/pushtemplates/content/ProductDisplayLinearBigContentView;", "context", "Landroid/content/Context;", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "extras", "Landroid/os/Bundle;", "(Landroid/content/Context;Lcom/clevertap/android/pushtemplates/TemplateRenderer;Landroid/os/Bundle;)V", "setCustomContentViewElementColour", "", "rId", "", "colour", "", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ProductDisplayNonLinearBigContentView.kt */
public final class ProductDisplayNonLinearBigContentView extends ProductDisplayLinearBigContentView {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ProductDisplayNonLinearBigContentView(Context context, TemplateRenderer templateRenderer, Bundle bundle) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        // Intrinsics.checkNotNullParameter(bundle, "extras");
        super(context, templateRenderer, bundle, R$layout.product_display_template);
        setCustomContentViewTitle(this.productName);
        setCustomContentViewMessage(this.productMessage);
        setCustomContentViewElementColour(R$id.msg, templateRenderer.pt_msg_clr);
        setCustomContentViewElementColour(R$id.title, templateRenderer.pt_title_clr);
    }

    public final void setCustomContentViewElementColour(int i, String str) {
        if (str != null) {
            if (str.length() > 0) {
                this.remoteView.setTextColor(i, k.getColour(str, "#000000"));
            }
        }
    }
}
