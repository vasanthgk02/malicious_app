package com.clevertap.android.pushtemplates.content;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Html;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.pushtemplates.PTConstants;
import com.clevertap.android.pushtemplates.R$id;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0002¨\u0006\u000f"}, d2 = {"Lcom/clevertap/android/pushtemplates/content/BigImageContentView;", "Lcom/clevertap/android/pushtemplates/content/ContentView;", "context", "Landroid/content/Context;", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "layoutId", "", "(Landroid/content/Context;Lcom/clevertap/android/pushtemplates/TemplateRenderer;I)V", "setCustomContentViewBigImage", "", "pt_big_img", "", "setCustomContentViewMessageSummary", "pt_msg_summary", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: BigImageContentView.kt */
public class BigImageContentView extends ContentView {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BigImageContentView(Context context, TemplateRenderer templateRenderer, int i) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        super(context, i, templateRenderer);
        setCustomContentViewBasicKeys();
        setCustomContentViewTitle(templateRenderer.pt_title);
        setCustomContentViewMessage(templateRenderer.pt_msg);
        setCustomContentViewExpandedBackgroundColour(templateRenderer.pt_bg);
        setCustomContentViewTitleColour(templateRenderer.pt_title_clr);
        setCustomContentViewMessageColour(templateRenderer.pt_msg_clr);
        String str = templateRenderer.pt_msg_summary;
        boolean z = true;
        if (str != null) {
            if (str.length() > 0) {
                if (VERSION.SDK_INT >= 24) {
                    this.remoteView.setTextViewText(R$id.msg, Html.fromHtml(str, 0));
                } else {
                    this.remoteView.setTextViewText(R$id.msg, Html.fromHtml(str));
                }
            }
        }
        setCustomContentViewSmallIcon();
        String str2 = templateRenderer.pt_big_img;
        if (str2 != null) {
            if (str2.length() <= 0 ? false : z) {
                k.loadImageURLIntoRemoteView(R$id.big_image, str2, this.remoteView);
                if (PTConstants.PT_FALLBACK) {
                    this.remoteView.setViewVisibility(R$id.big_image, 8);
                }
                setCustomContentViewLargeIcon(templateRenderer.pt_large_icon);
            }
        }
        this.remoteView.setViewVisibility(R$id.big_image, 8);
        setCustomContentViewLargeIcon(templateRenderer.pt_large_icon);
    }
}
