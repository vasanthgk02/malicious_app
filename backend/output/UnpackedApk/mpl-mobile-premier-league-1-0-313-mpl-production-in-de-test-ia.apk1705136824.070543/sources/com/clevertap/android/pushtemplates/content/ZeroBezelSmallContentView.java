package com.clevertap.android.pushtemplates.content;

import android.content.Context;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/clevertap/android/pushtemplates/content/ZeroBezelSmallContentView;", "Lcom/clevertap/android/pushtemplates/content/ContentView;", "context", "Landroid/content/Context;", "layoutId", "", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "(Landroid/content/Context;ILcom/clevertap/android/pushtemplates/TemplateRenderer;)V", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ZeroBezelSmallContentView.kt */
public class ZeroBezelSmallContentView extends ContentView {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ZeroBezelSmallContentView(Context context, int i, TemplateRenderer templateRenderer) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        super(context, i, templateRenderer);
        setCustomContentViewBasicKeys();
        setCustomContentViewTitle(templateRenderer.pt_title);
        setCustomContentViewTitleColour(templateRenderer.pt_title_clr);
        setCustomContentViewCollapsedBackgroundColour(templateRenderer.pt_bg);
        setCustomContentViewMessageColour(templateRenderer.pt_msg_clr);
        setCustomContentViewSmallIcon();
    }
}
