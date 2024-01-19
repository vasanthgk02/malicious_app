package com.clevertap.android.pushtemplates.styles;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.pushtemplates.R$layout;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import com.clevertap.android.pushtemplates.content.PendingIntentFactory;
import com.clevertap.android.pushtemplates.content.TimerBigContentView;
import com.clevertap.android.pushtemplates.content.TimerSmallContentView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\bH\u0014J\"\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\bH\u0014J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/clevertap/android/pushtemplates/styles/TimerStyle;", "Lcom/clevertap/android/pushtemplates/styles/Style;", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "extras", "Landroid/os/Bundle;", "(Lcom/clevertap/android/pushtemplates/TemplateRenderer;Landroid/os/Bundle;)V", "getTimerEnd", "", "()Ljava/lang/Integer;", "makeBigContentRemoteView", "Landroid/widget/RemoteViews;", "context", "Landroid/content/Context;", "makeDismissIntent", "Landroid/app/PendingIntent;", "notificationId", "makePendingIntent", "makeSmallContentRemoteView", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TimerStyle.kt */
public final class TimerStyle extends Style {
    public Bundle extras;
    public TemplateRenderer renderer;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TimerStyle(TemplateRenderer templateRenderer, Bundle bundle) {
        // Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        // Intrinsics.checkNotNullParameter(bundle, "extras");
        super(templateRenderer);
        this.renderer = templateRenderer;
        this.extras = bundle;
    }

    public final Integer getTimerEnd() {
        int i = this.renderer.pt_timer_threshold;
        if (i != -1 && i >= 10) {
            return Integer.valueOf((i * 1000) + 1000);
        }
        int i2 = this.renderer.pt_timer_end;
        if (i2 >= 10) {
            return Integer.valueOf((i2 * 1000) + 1000);
        }
        k.debug("Not rendering notification Timer End value lesser than threshold (10 seconds) from current time: pt_timer_end");
        return null;
    }

    public RemoteViews makeBigContentRemoteView(Context context, TemplateRenderer templateRenderer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        if (getTimerEnd() == null) {
            return null;
        }
        return new TimerBigContentView(context, getTimerEnd(), templateRenderer).remoteView;
    }

    public PendingIntent makeDismissIntent(Context context, Bundle bundle, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        return null;
    }

    public PendingIntent makePendingIntent(Context context, Bundle bundle, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        return PendingIntentFactory.getPendingIntent(context, i, bundle, true, 30, this.renderer);
    }

    public RemoteViews makeSmallContentRemoteView(Context context, TemplateRenderer templateRenderer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        if (getTimerEnd() == null) {
            return null;
        }
        return new TimerSmallContentView(context, getTimerEnd(), templateRenderer, R$layout.timer_collapsed).remoteView;
    }
}
