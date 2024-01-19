package com.clevertap.android.pushtemplates.styles;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import com.clevertap.android.pushtemplates.content.ContentView;
import com.clevertap.android.pushtemplates.content.FiveIconBigContentView;
import com.clevertap.android.pushtemplates.content.FiveIconSmallContentView;
import com.clevertap.android.pushtemplates.content.PendingIntentFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/clevertap/android/pushtemplates/styles/FiveIconStyle;", "Lcom/clevertap/android/pushtemplates/styles/Style;", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "extras", "Landroid/os/Bundle;", "(Lcom/clevertap/android/pushtemplates/TemplateRenderer;Landroid/os/Bundle;)V", "fiveIconBigContentView", "Lcom/clevertap/android/pushtemplates/content/ContentView;", "getFiveIconBigContentView", "()Lcom/clevertap/android/pushtemplates/content/ContentView;", "setFiveIconBigContentView", "(Lcom/clevertap/android/pushtemplates/content/ContentView;)V", "fiveIconSmallContentView", "getFiveIconSmallContentView", "setFiveIconSmallContentView", "makeBigContentRemoteView", "Landroid/widget/RemoteViews;", "context", "Landroid/content/Context;", "makeDismissIntent", "Landroid/app/PendingIntent;", "notificationId", "", "makePendingIntent", "makeSmallContentRemoteView", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FiveIconStyle.kt */
public final class FiveIconStyle extends Style {
    public Bundle extras;
    public ContentView fiveIconBigContentView;
    public ContentView fiveIconSmallContentView;
    public TemplateRenderer renderer;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public FiveIconStyle(TemplateRenderer templateRenderer, Bundle bundle) {
        // Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        // Intrinsics.checkNotNullParameter(bundle, "extras");
        super(templateRenderer);
        this.renderer = templateRenderer;
        this.extras = bundle;
    }

    public RemoteViews makeBigContentRemoteView(Context context, TemplateRenderer templateRenderer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        FiveIconBigContentView fiveIconBigContentView2 = new FiveIconBigContentView(context, templateRenderer, this.extras);
        Intrinsics.checkNotNullParameter(fiveIconBigContentView2, "<set-?>");
        this.fiveIconBigContentView = fiveIconBigContentView2;
        return fiveIconBigContentView2.remoteView;
    }

    public PendingIntent makeDismissIntent(Context context, Bundle bundle, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        return null;
    }

    public PendingIntent makePendingIntent(Context context, Bundle bundle, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        return PendingIntentFactory.getPendingIntent(context, i, bundle, true, 13, this.renderer);
    }

    public RemoteViews makeSmallContentRemoteView(Context context, TemplateRenderer templateRenderer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        FiveIconSmallContentView fiveIconSmallContentView2 = new FiveIconSmallContentView(context, templateRenderer, this.extras);
        Intrinsics.checkNotNullParameter(fiveIconSmallContentView2, "<set-?>");
        this.fiveIconSmallContentView = fiveIconSmallContentView2;
        return fiveIconSmallContentView2.remoteView;
    }
}
