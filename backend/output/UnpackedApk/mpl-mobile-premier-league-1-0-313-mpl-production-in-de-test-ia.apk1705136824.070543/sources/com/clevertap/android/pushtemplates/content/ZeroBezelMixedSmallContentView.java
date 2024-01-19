package com.clevertap.android.pushtemplates.content;

import android.content.Context;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.pushtemplates.PTConstants;
import com.clevertap.android.pushtemplates.R$id;
import com.clevertap.android.pushtemplates.R$layout;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/clevertap/android/pushtemplates/content/ZeroBezelMixedSmallContentView;", "Lcom/clevertap/android/pushtemplates/content/ZeroBezelSmallContentView;", "context", "Landroid/content/Context;", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "(Landroid/content/Context;Lcom/clevertap/android/pushtemplates/TemplateRenderer;)V", "setCustomContentViewBigImage", "", "pt_big_img", "", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ZeroBezelMixedSmallContentView.kt */
public final class ZeroBezelMixedSmallContentView extends ZeroBezelSmallContentView {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ZeroBezelMixedSmallContentView(Context context, TemplateRenderer templateRenderer) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        super(context, R$layout.cv_small_zero_bezel, templateRenderer);
        setCustomContentViewMessage(templateRenderer.pt_msg);
        String str = templateRenderer.pt_big_img;
        if (str != null) {
            if (str.length() > 0) {
                k.loadImageURLIntoRemoteView(R$id.big_image, str, this.remoteView);
                if (PTConstants.PT_FALLBACK) {
                    this.remoteView.setViewVisibility(R$id.big_image, 8);
                    return;
                }
                return;
            }
        }
        this.remoteView.setViewVisibility(R$id.big_image, 8);
    }
}
