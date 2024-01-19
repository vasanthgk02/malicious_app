package com.clevertap.android.pushtemplates.content;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.pushtemplates.R$drawable;
import com.clevertap.android.pushtemplates.R$id;
import com.clevertap.android.pushtemplates.R$layout;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import com.mpl.androidapp.utils.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/clevertap/android/pushtemplates/content/RatingContentView;", "Lcom/clevertap/android/pushtemplates/content/BigImageContentView;", "context", "Landroid/content/Context;", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "extras", "Landroid/os/Bundle;", "(Landroid/content/Context;Lcom/clevertap/android/pushtemplates/TemplateRenderer;Landroid/os/Bundle;)V", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: RatingContentView.kt */
public final class RatingContentView extends BigImageContentView {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public RatingContentView(Context context, TemplateRenderer templateRenderer, Bundle bundle) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        // Intrinsics.checkNotNullParameter(bundle, "extras");
        super(context, templateRenderer, R$layout.rating);
        this.remoteView.setImageViewResource(R$id.star1, R$drawable.pt_star_outline);
        this.remoteView.setImageViewResource(R$id.star2, R$drawable.pt_star_outline);
        this.remoteView.setImageViewResource(R$id.star3, R$drawable.pt_star_outline);
        this.remoteView.setImageViewResource(R$id.star4, R$drawable.pt_star_outline);
        this.remoteView.setImageViewResource(R$id.star5, R$drawable.pt_star_outline);
        Bundle bundle2 = bundle;
        TemplateRenderer templateRenderer2 = templateRenderer;
        this.remoteView.setOnClickPendingIntent(R$id.star1, PendingIntentFactory.getPendingIntent(context, templateRenderer.notificationId, bundle2, false, 8, templateRenderer2));
        this.remoteView.setOnClickPendingIntent(R$id.star2, PendingIntentFactory.getPendingIntent(context, templateRenderer.notificationId, bundle2, false, 9, templateRenderer2));
        this.remoteView.setOnClickPendingIntent(R$id.star3, PendingIntentFactory.getPendingIntent(context, templateRenderer.notificationId, bundle2, false, 10, templateRenderer2));
        this.remoteView.setOnClickPendingIntent(R$id.star4, PendingIntentFactory.getPendingIntent(context, templateRenderer.notificationId, bundle2, false, 11, templateRenderer2));
        this.remoteView.setOnClickPendingIntent(R$id.star5, PendingIntentFactory.getPendingIntent(context, templateRenderer.notificationId, bundle2, false, 12, templateRenderer2));
        if (VERSION.SDK_INT >= 31) {
            this.remoteView.setViewVisibility(R$id.tVRatingConfirmation, 0);
            bundle.putInt(Constant.NOTIFICATION_ID, templateRenderer.notificationId);
            this.remoteView.setOnClickPendingIntent(R$id.tVRatingConfirmation, k.getActivityIntent(bundle, context));
        } else {
            this.remoteView.setViewVisibility(R$id.tVRatingConfirmation, 8);
        }
        if (Intrinsics.areEqual(bundle.getString("extras_from", ""), "PTReceiver")) {
            if (1 == bundle.getInt("clickedStar", 0)) {
                this.remoteView.setImageViewResource(R$id.star1, R$drawable.pt_star_filled);
            } else {
                this.remoteView.setImageViewResource(R$id.star1, R$drawable.pt_star_outline);
            }
            if (2 == bundle.getInt("clickedStar", 0)) {
                this.remoteView.setImageViewResource(R$id.star1, R$drawable.pt_star_filled);
                this.remoteView.setImageViewResource(R$id.star2, R$drawable.pt_star_filled);
            } else {
                this.remoteView.setImageViewResource(R$id.star2, R$drawable.pt_star_outline);
            }
            if (3 == bundle.getInt("clickedStar", 0)) {
                this.remoteView.setImageViewResource(R$id.star1, R$drawable.pt_star_filled);
                this.remoteView.setImageViewResource(R$id.star2, R$drawable.pt_star_filled);
                this.remoteView.setImageViewResource(R$id.star3, R$drawable.pt_star_filled);
            } else {
                this.remoteView.setImageViewResource(R$id.star3, R$drawable.pt_star_outline);
            }
            if (4 == bundle.getInt("clickedStar", 0)) {
                this.remoteView.setImageViewResource(R$id.star1, R$drawable.pt_star_filled);
                this.remoteView.setImageViewResource(R$id.star2, R$drawable.pt_star_filled);
                this.remoteView.setImageViewResource(R$id.star3, R$drawable.pt_star_filled);
                this.remoteView.setImageViewResource(R$id.star4, R$drawable.pt_star_filled);
            } else {
                this.remoteView.setImageViewResource(R$id.star4, R$drawable.pt_star_outline);
            }
            if (5 == bundle.getInt("clickedStar", 0)) {
                this.remoteView.setImageViewResource(R$id.star1, R$drawable.pt_star_filled);
                this.remoteView.setImageViewResource(R$id.star2, R$drawable.pt_star_filled);
                this.remoteView.setImageViewResource(R$id.star3, R$drawable.pt_star_filled);
                this.remoteView.setImageViewResource(R$id.star4, R$drawable.pt_star_filled);
                this.remoteView.setImageViewResource(R$id.star5, R$drawable.pt_star_filled);
                return;
            }
            this.remoteView.setImageViewResource(R$id.star5, R$drawable.pt_star_outline);
        }
    }
}
