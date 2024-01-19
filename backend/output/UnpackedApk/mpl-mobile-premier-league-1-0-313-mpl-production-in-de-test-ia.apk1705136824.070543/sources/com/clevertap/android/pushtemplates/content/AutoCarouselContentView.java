package com.clevertap.android.pushtemplates.content;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Html;
import android.widget.RemoteViews;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.pushtemplates.PTConstants;
import com.clevertap.android.pushtemplates.R$id;
import com.clevertap.android.pushtemplates.R$layout;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002¨\u0006\u000f"}, d2 = {"Lcom/clevertap/android/pushtemplates/content/AutoCarouselContentView;", "Lcom/clevertap/android/pushtemplates/content/BigImageContentView;", "context", "Landroid/content/Context;", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "(Landroid/content/Context;Lcom/clevertap/android/pushtemplates/TemplateRenderer;)V", "setCustomContentViewMessageSummary", "", "pt_msg_summary", "", "setCustomContentViewViewFlipperInterval", "interval", "", "setViewFlipper", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AutoCarouselContentView.kt */
public final class AutoCarouselContentView extends BigImageContentView {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AutoCarouselContentView(Context context, TemplateRenderer templateRenderer) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        super(context, templateRenderer, R$layout.auto_carousel);
        String str = templateRenderer.pt_msg_summary;
        int i = 0;
        if (str != null) {
            if (str.length() > 0) {
                if (VERSION.SDK_INT >= 24) {
                    this.remoteView.setTextViewText(R$id.msg, Html.fromHtml(str, 0));
                } else {
                    this.remoteView.setTextViewText(R$id.msg, Html.fromHtml(str));
                }
            }
        }
        this.remoteView.setInt(R$id.view_flipper, "setFlipInterval", templateRenderer.pt_flip_interval);
        ArrayList<String> arrayList = this.renderer.imageList;
        Intrinsics.checkNotNull(arrayList);
        int size = arrayList.size() - 1;
        if (size >= 0) {
            while (true) {
                int i2 = i + 1;
                RemoteViews remoteViews = new RemoteViews(this.context.getPackageName(), R$layout.image_view);
                int i3 = R$id.fimg;
                ArrayList<String> arrayList2 = this.renderer.imageList;
                Intrinsics.checkNotNull(arrayList2);
                k.loadImageURLIntoRemoteView(i3, arrayList2.get(i), remoteViews);
                if (!PTConstants.PT_FALLBACK) {
                    this.remoteView.addView(R$id.view_flipper, remoteViews);
                } else {
                    k.debug("Skipping Image in Auto Carousel.");
                }
                if (i2 <= size) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }
}
