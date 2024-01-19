package com.clevertap.android.pushtemplates.styles;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat.Builder;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H$J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH$J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH$J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H$JD\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0011H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/clevertap/android/pushtemplates/styles/Style;", "", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "(Lcom/clevertap/android/pushtemplates/TemplateRenderer;)V", "builderFromStyle", "Landroidx/core/app/NotificationCompat$Builder;", "context", "Landroid/content/Context;", "extras", "Landroid/os/Bundle;", "notificationId", "", "nb", "makeBigContentRemoteView", "Landroid/widget/RemoteViews;", "makeDismissIntent", "Landroid/app/PendingIntent;", "makePendingIntent", "makeSmallContentRemoteView", "setNotificationBuilderBasics", "notificationBuilder", "contentViewSmall", "contentViewBig", "pt_title", "", "pIntent", "dIntent", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Style.kt */
public abstract class Style {
    public TemplateRenderer renderer;

    public Style(TemplateRenderer templateRenderer) {
        Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        this.renderer = templateRenderer;
    }

    public Builder builderFromStyle(Context context, Bundle bundle, int i, Builder builder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        Intrinsics.checkNotNullParameter(builder, PaymentConstants.WIDGET_NETBANKING);
        return setNotificationBuilderBasics(builder, makeSmallContentRemoteView(context, this.renderer), makeBigContentRemoteView(context, this.renderer), this.renderer.pt_title, makePendingIntent(context, bundle, i), makeDismissIntent(context, bundle, i));
    }

    public abstract RemoteViews makeBigContentRemoteView(Context context, TemplateRenderer templateRenderer);

    public abstract PendingIntent makeDismissIntent(Context context, Bundle bundle, int i);

    public abstract PendingIntent makePendingIntent(Context context, Bundle bundle, int i);

    public abstract RemoteViews makeSmallContentRemoteView(Context context, TemplateRenderer templateRenderer);

    public Builder setNotificationBuilderBasics(Builder builder, RemoteViews remoteViews, RemoteViews remoteViews2, String str, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        if (pendingIntent2 != null) {
            builder.setDeleteIntent(pendingIntent2);
        }
        if (remoteViews != null) {
            builder.setCustomContentView(remoteViews);
        }
        if (remoteViews2 != null) {
            builder.setCustomBigContentView(remoteViews2);
        }
        Builder when = builder.setSmallIcon(this.renderer.smallIcon).setContentTitle(Html.fromHtml(str)).setContentIntent(pendingIntent).setVibrate(new long[]{0}).setWhen(System.currentTimeMillis());
        String str2 = this.renderer.pt_small_icon_clr;
        if (str2 == null) {
            str2 = "#FFFFFF";
        }
        Builder onlyAlertOnce = when.setColor(Color.parseColor(str2)).setAutoCancel(true).setOnlyAlertOnce(true);
        Intrinsics.checkNotNullExpressionValue(onlyAlertOnce, "notificationBuilder.setS…  .setOnlyAlertOnce(true)");
        return onlyAlertOnce;
    }
}
