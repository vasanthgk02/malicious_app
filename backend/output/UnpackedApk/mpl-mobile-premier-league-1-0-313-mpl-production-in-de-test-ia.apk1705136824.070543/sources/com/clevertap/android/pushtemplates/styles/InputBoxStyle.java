package com.clevertap.android.pushtemplates.styles;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat.Action;
import androidx.core.app.NotificationCompat.BigPictureStyle;
import androidx.core.app.NotificationCompat.BigTextStyle;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.app.NotificationCompat.Style;
import androidx.core.app.RemoteInput;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import com.clevertap.android.pushtemplates.content.PendingIntentFactory;
import com.squareup.picasso.NetworkRequestHandler;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0014JB\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011H\u0014J*\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/clevertap/android/pushtemplates/styles/InputBoxStyle;", "Lcom/clevertap/android/pushtemplates/styles/Style;", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "(Lcom/clevertap/android/pushtemplates/TemplateRenderer;)V", "builderFromStyle", "Landroidx/core/app/NotificationCompat$Builder;", "context", "Landroid/content/Context;", "extras", "Landroid/os/Bundle;", "notificationId", "", "nb", "makeBigContentRemoteView", "Landroid/widget/RemoteViews;", "makeDismissIntent", "Landroid/app/PendingIntent;", "makePendingIntent", "makeSmallContentRemoteView", "setNotificationBuilderBasics", "notificationBuilder", "contentViewSmall", "contentViewBig", "pt_title", "", "pIntent", "dIntent", "setStandardViewBigImageStyle", "pt_big_img", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InputBoxStyle.kt */
public final class InputBoxStyle extends Style {
    public TemplateRenderer renderer;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public InputBoxStyle(TemplateRenderer templateRenderer) {
        // Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        super(templateRenderer);
        this.renderer = templateRenderer;
    }

    public Builder builderFromStyle(Context context, Bundle bundle, int i, Builder builder) {
        Style style;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        Intrinsics.checkNotNullParameter(builder, PaymentConstants.WIDGET_NETBANKING);
        Builder builderFromStyle = super.builderFromStyle(context, bundle, i, builder);
        String str = this.renderer.pt_big_img;
        boolean z = false;
        if (str == null || !CharsKt__CharKt.startsWith$default(str, (String) NetworkRequestHandler.SCHEME_HTTP, false, 2)) {
            style = new BigTextStyle().bigText(this.renderer.pt_msg);
            Intrinsics.checkNotNullExpressionValue(style, "BigTextStyle()\n         ….bigText(renderer.pt_msg)");
        } else {
            try {
                Bitmap notificationBitmap = k.getNotificationBitmap(str, false, context);
                if (notificationBitmap == null) {
                    throw new Exception("Failed to fetch big picture!");
                } else if (bundle.containsKey("pt_msg_summary")) {
                    style = new BigPictureStyle().setSummaryText(this.renderer.pt_msg_summary).bigPicture(notificationBitmap);
                    Intrinsics.checkNotNullExpressionValue(style, "{\n                    va…(bpMap)\n                }");
                } else {
                    style = new BigPictureStyle().setSummaryText(this.renderer.pt_msg).bigPicture(notificationBitmap);
                    Intrinsics.checkNotNullExpressionValue(style, "{\n                    No…(bpMap)\n                }");
                }
            } catch (Throwable th) {
                Style bigText = new BigTextStyle().bigText(this.renderer.pt_msg);
                Intrinsics.checkNotNullExpressionValue(bigText, "BigTextStyle()\n         ….bigText(renderer.pt_msg)");
                k.verbose("Falling back to big text notification, couldn't fetch big picture", th);
                style = bigText;
            }
        }
        builderFromStyle.setStyle(style);
        String str2 = this.renderer.pt_input_label;
        if (str2 != null) {
            Intrinsics.checkNotNull(str2);
            if (str2.length() > 0) {
                RemoteInput build = new RemoteInput.Builder("pt_input_reply").setLabel(this.renderer.pt_input_label).build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder(PTConstants.PT_I…\n                .build()");
                PendingIntent pendingIntent = PendingIntentFactory.getPendingIntent(context, i, bundle, false, 32, this.renderer);
                Intrinsics.checkNotNull(pendingIntent);
                Action build2 = new Action.Builder(17301646, (CharSequence) this.renderer.pt_input_label, pendingIntent).addRemoteInput(build).setAllowGeneratedReplies(true).build();
                Intrinsics.checkNotNullExpressionValue(build2, "Builder(\n               …\n                .build()");
                builderFromStyle.addAction(build2);
            }
        }
        String str3 = this.renderer.pt_dismiss_on_click;
        if (str3 != null) {
            Intrinsics.checkNotNull(str3);
            if (str3.length() > 0) {
                z = true;
            }
            if (z) {
                bundle.putString("pt_dismiss_on_click", this.renderer.pt_dismiss_on_click);
            }
        }
        TemplateRenderer templateRenderer = this.renderer;
        templateRenderer.setActionButtons(context, bundle, i, builderFromStyle, templateRenderer.actions);
        return builderFromStyle;
    }

    public RemoteViews makeBigContentRemoteView(Context context, TemplateRenderer templateRenderer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        return null;
    }

    public PendingIntent makeDismissIntent(Context context, Bundle bundle, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        return null;
    }

    public PendingIntent makePendingIntent(Context context, Bundle bundle, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        return PendingIntentFactory.getPendingIntent(context, i, bundle, true, 31, this.renderer);
    }

    public RemoteViews makeSmallContentRemoteView(Context context, TemplateRenderer templateRenderer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        return null;
    }

    public Builder setNotificationBuilderBasics(Builder builder, RemoteViews remoteViews, RemoteViews remoteViews2, String str, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Builder contentText = super.setNotificationBuilderBasics(builder, remoteViews, remoteViews2, str, pendingIntent, pendingIntent2).setContentText(this.renderer.pt_msg);
        Intrinsics.checkNotNullExpressionValue(contentText, "super.setNotificationBui…tentText(renderer.pt_msg)");
        return contentText;
    }
}
