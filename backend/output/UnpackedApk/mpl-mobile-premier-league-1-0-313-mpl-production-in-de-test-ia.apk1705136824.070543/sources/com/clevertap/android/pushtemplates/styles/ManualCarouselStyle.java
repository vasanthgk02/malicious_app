package com.clevertap.android.pushtemplates.styles;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.clevertap.android.pushtemplates.R$layout;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import com.clevertap.android.pushtemplates.content.ManualCarouselContentView;
import com.clevertap.android.pushtemplates.content.PendingIntentFactory;
import com.clevertap.android.pushtemplates.content.SmallContentView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0014J\"\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/clevertap/android/pushtemplates/styles/ManualCarouselStyle;", "Lcom/clevertap/android/pushtemplates/styles/Style;", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "extras", "Landroid/os/Bundle;", "(Lcom/clevertap/android/pushtemplates/TemplateRenderer;Landroid/os/Bundle;)V", "makeBigContentRemoteView", "Landroid/widget/RemoteViews;", "context", "Landroid/content/Context;", "makeDismissIntent", "Landroid/app/PendingIntent;", "notificationId", "", "makePendingIntent", "makeSmallContentRemoteView", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ManualCarouselStyle.kt */
public final class ManualCarouselStyle extends Style {
    public Bundle extras;
    public TemplateRenderer renderer;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ManualCarouselStyle(TemplateRenderer templateRenderer, Bundle bundle) {
        // Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        // Intrinsics.checkNotNullParameter(bundle, "extras");
        super(templateRenderer);
        this.renderer = templateRenderer;
        this.extras = bundle;
    }

    public RemoteViews makeBigContentRemoteView(Context context, TemplateRenderer templateRenderer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        return new ManualCarouselContentView(context, templateRenderer, this.extras).remoteView;
    }

    public PendingIntent makeDismissIntent(Context context, Bundle bundle, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        return PendingIntentFactory.getPendingIntent(context, i, bundle, false, 6, this.renderer);
    }

    public PendingIntent makePendingIntent(Context context, Bundle bundle, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        String string = bundle.getString("extras_from");
        if (string != null && Intrinsics.areEqual(string, "PTReceiver")) {
            return PendingIntentFactory.getPendingIntent(context, i, bundle, true, 3, null);
        }
        return PendingIntentFactory.getPendingIntent(context, i, bundle, true, 3, this.renderer);
    }

    public RemoteViews makeSmallContentRemoteView(Context context, TemplateRenderer templateRenderer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        return new SmallContentView(context, templateRenderer, R$layout.content_view_small_single_line_msg).remoteView;
    }
}
