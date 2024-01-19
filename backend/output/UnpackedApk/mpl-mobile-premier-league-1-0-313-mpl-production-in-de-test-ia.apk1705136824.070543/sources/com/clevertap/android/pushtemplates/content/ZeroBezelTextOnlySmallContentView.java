package com.clevertap.android.pushtemplates.content;

import android.content.Context;
import com.clevertap.android.pushtemplates.R$id;
import com.clevertap.android.pushtemplates.R$layout;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/clevertap/android/pushtemplates/content/ZeroBezelTextOnlySmallContentView;", "Lcom/clevertap/android/pushtemplates/content/ZeroBezelSmallContentView;", "context", "Landroid/content/Context;", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "(Landroid/content/Context;Lcom/clevertap/android/pushtemplates/TemplateRenderer;)V", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ZeroBezelTextOnlySmallContentView.kt */
public final class ZeroBezelTextOnlySmallContentView extends ZeroBezelSmallContentView {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ZeroBezelTextOnlySmallContentView(Context context, TemplateRenderer templateRenderer) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        super(context, R$layout.cv_small_text_only, templateRenderer);
        this.remoteView.setViewVisibility(R$id.msg, 8);
        setCustomContentViewLargeIcon(templateRenderer.pt_large_icon);
    }
}
