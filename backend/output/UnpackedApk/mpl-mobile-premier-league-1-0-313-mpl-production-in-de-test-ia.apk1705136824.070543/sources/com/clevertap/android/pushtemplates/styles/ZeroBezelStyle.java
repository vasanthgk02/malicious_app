package com.clevertap.android.pushtemplates.styles;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import com.clevertap.android.pushtemplates.content.PendingIntentFactory;
import com.clevertap.android.pushtemplates.content.ZeroBezelBigContentView;
import com.clevertap.android.pushtemplates.content.ZeroBezelMixedSmallContentView;
import com.clevertap.android.pushtemplates.content.ZeroBezelTextOnlySmallContentView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J\"\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\"\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/clevertap/android/pushtemplates/styles/ZeroBezelStyle;", "Lcom/clevertap/android/pushtemplates/styles/Style;", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "(Lcom/clevertap/android/pushtemplates/TemplateRenderer;)V", "makeBigContentRemoteView", "Landroid/widget/RemoteViews;", "context", "Landroid/content/Context;", "makeDismissIntent", "Landroid/app/PendingIntent;", "extras", "Landroid/os/Bundle;", "notificationId", "", "makePendingIntent", "makeSmallContentRemoteView", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ZeroBezelStyle.kt */
public final class ZeroBezelStyle extends Style {
    public TemplateRenderer renderer;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ZeroBezelStyle(TemplateRenderer templateRenderer) {
        // Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        super(templateRenderer);
        this.renderer = templateRenderer;
    }

    public RemoteViews makeBigContentRemoteView(Context context, TemplateRenderer templateRenderer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        return new ZeroBezelBigContentView(context, templateRenderer).remoteView;
    }

    public PendingIntent makeDismissIntent(Context context, Bundle bundle, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        return null;
    }

    public PendingIntent makePendingIntent(Context context, Bundle bundle, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        return PendingIntentFactory.getPendingIntent(context, i, bundle, true, 29, this.renderer);
    }

    public RemoteViews makeSmallContentRemoteView(Context context, TemplateRenderer templateRenderer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        String str = templateRenderer.pt_small_view;
        if (str != null && Intrinsics.areEqual(str, "text_only")) {
            return new ZeroBezelTextOnlySmallContentView(context, templateRenderer).remoteView;
        }
        return new ZeroBezelMixedSmallContentView(context, templateRenderer).remoteView;
    }
}
