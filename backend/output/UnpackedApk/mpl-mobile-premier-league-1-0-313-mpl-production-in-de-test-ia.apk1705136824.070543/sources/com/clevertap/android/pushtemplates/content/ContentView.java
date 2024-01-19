package com.clevertap.android.pushtemplates.content;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.Html;
import android.widget.RemoteViews;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.pushtemplates.R$id;
import com.clevertap.android.pushtemplates.TemplateRenderer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u001bJ\u0010\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010#\u001a\u00020\u0018J\u0010\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010&\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010\u001bJ\b\u0010(\u001a\u00020\u0018H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/clevertap/android/pushtemplates/content/ContentView;", "", "context", "Landroid/content/Context;", "layoutId", "", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "(Landroid/content/Context;ILcom/clevertap/android/pushtemplates/TemplateRenderer;)V", "getContext$clevertap_pushtemplates_release", "()Landroid/content/Context;", "setContext$clevertap_pushtemplates_release", "(Landroid/content/Context;)V", "remoteView", "Landroid/widget/RemoteViews;", "getRemoteView$clevertap_pushtemplates_release", "()Landroid/widget/RemoteViews;", "setRemoteView$clevertap_pushtemplates_release", "(Landroid/widget/RemoteViews;)V", "getRenderer$clevertap_pushtemplates_release", "()Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "setRenderer$clevertap_pushtemplates_release", "(Lcom/clevertap/android/pushtemplates/TemplateRenderer;)V", "setCustomContentViewBasicKeys", "", "setCustomContentViewCollapsedBackgroundColour", "pt_bg", "", "setCustomContentViewExpandedBackgroundColour", "setCustomContentViewLargeIcon", "pt_large_icon", "setCustomContentViewMessage", "pt_msg", "setCustomContentViewMessageColour", "pt_msg_clr", "setCustomContentViewSmallIcon", "setCustomContentViewTitle", "pt_title", "setCustomContentViewTitleColour", "pt_title_clr", "setDotSep", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ContentView.kt */
public class ContentView {
    public Context context;
    public RemoteViews remoteView;
    public TemplateRenderer renderer;

    public ContentView(Context context2, int i, TemplateRenderer templateRenderer) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(templateRenderer, "renderer");
        this.context = context2;
        this.renderer = templateRenderer;
        this.remoteView = new RemoteViews(this.context.getPackageName(), i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setCustomContentViewBasicKeys() {
        /*
            r6 = this;
            android.widget.RemoteViews r0 = r6.remoteView
            int r1 = com.clevertap.android.pushtemplates.R$id.app_name
            android.content.Context r2 = r6.context
            java.lang.String r2 = co.hyperverge.hypersnapsdk.c.k.getApplicationName(r2)
            r0.setTextViewText(r1, r2)
            android.widget.RemoteViews r0 = r6.remoteView
            int r1 = com.clevertap.android.pushtemplates.R$id.timestamp
            android.content.Context r2 = r6.context
            long r3 = java.lang.System.currentTimeMillis()
            r5 = 1
            java.lang.String r2 = android.text.format.DateUtils.formatDateTime(r2, r3, r5)
            r0.setTextViewText(r1, r2)
            com.clevertap.android.pushtemplates.TemplateRenderer r0 = r6.renderer
            java.lang.String r0 = r0.pt_subtitle
            r1 = 0
            if (r0 == 0) goto L_0x005a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0031
            r0 = 1
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            if (r0 == 0) goto L_0x005a
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r0 < r2) goto L_0x004a
            android.widget.RemoteViews r0 = r6.remoteView
            int r2 = com.clevertap.android.pushtemplates.R$id.subtitle
            com.clevertap.android.pushtemplates.TemplateRenderer r3 = r6.renderer
            java.lang.String r3 = r3.pt_subtitle
            android.text.Spanned r3 = android.text.Html.fromHtml(r3, r1)
            r0.setTextViewText(r2, r3)
            goto L_0x006a
        L_0x004a:
            android.widget.RemoteViews r0 = r6.remoteView
            int r2 = com.clevertap.android.pushtemplates.R$id.subtitle
            com.clevertap.android.pushtemplates.TemplateRenderer r3 = r6.renderer
            java.lang.String r3 = r3.pt_subtitle
            android.text.Spanned r3 = android.text.Html.fromHtml(r3)
            r0.setTextViewText(r2, r3)
            goto L_0x006a
        L_0x005a:
            android.widget.RemoteViews r0 = r6.remoteView
            int r2 = com.clevertap.android.pushtemplates.R$id.subtitle
            r3 = 8
            r0.setViewVisibility(r2, r3)
            android.widget.RemoteViews r0 = r6.remoteView
            int r2 = com.clevertap.android.pushtemplates.R$id.sep_subtitle
            r0.setViewVisibility(r2, r3)
        L_0x006a:
            com.clevertap.android.pushtemplates.TemplateRenderer r0 = r6.renderer
            java.lang.String r0 = r0.pt_meta_clr
            if (r0 == 0) goto L_0x00dc
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r5 = 0
        L_0x007b:
            if (r5 == 0) goto L_0x00dc
            android.widget.RemoteViews r0 = r6.remoteView
            int r1 = com.clevertap.android.pushtemplates.R$id.app_name
            com.clevertap.android.pushtemplates.TemplateRenderer r2 = r6.renderer
            java.lang.String r2 = r2.pt_meta_clr
            java.lang.String r3 = "#A6A6A6"
            int r2 = co.hyperverge.hypersnapsdk.c.k.getColour(r2, r3)
            r0.setTextColor(r1, r2)
            android.widget.RemoteViews r0 = r6.remoteView
            int r1 = com.clevertap.android.pushtemplates.R$id.timestamp
            com.clevertap.android.pushtemplates.TemplateRenderer r2 = r6.renderer
            java.lang.String r2 = r2.pt_meta_clr
            int r2 = co.hyperverge.hypersnapsdk.c.k.getColour(r2, r3)
            r0.setTextColor(r1, r2)
            android.widget.RemoteViews r0 = r6.remoteView
            int r1 = com.clevertap.android.pushtemplates.R$id.subtitle
            com.clevertap.android.pushtemplates.TemplateRenderer r2 = r6.renderer
            java.lang.String r2 = r2.pt_meta_clr
            int r2 = co.hyperverge.hypersnapsdk.c.k.getColour(r2, r3)
            r0.setTextColor(r1, r2)
            com.clevertap.android.pushtemplates.TemplateRenderer r0 = r6.renderer     // Catch:{ NullPointerException -> 0x00d7 }
            android.content.Context r1 = r6.context     // Catch:{ NullPointerException -> 0x00d7 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ NullPointerException -> 0x00d7 }
            java.lang.String r2 = "pt_dot_sep"
            java.lang.String r3 = "drawable"
            android.content.Context r4 = r6.context     // Catch:{ NullPointerException -> 0x00d7 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ NullPointerException -> 0x00d7 }
            int r1 = r1.getIdentifier(r2, r3, r4)     // Catch:{ NullPointerException -> 0x00d7 }
            r0.pt_dot = r1     // Catch:{ NullPointerException -> 0x00d7 }
            com.clevertap.android.pushtemplates.TemplateRenderer r0 = r6.renderer     // Catch:{ NullPointerException -> 0x00d7 }
            android.content.Context r1 = r6.context     // Catch:{ NullPointerException -> 0x00d7 }
            com.clevertap.android.pushtemplates.TemplateRenderer r2 = r6.renderer     // Catch:{ NullPointerException -> 0x00d7 }
            int r2 = r2.pt_dot     // Catch:{ NullPointerException -> 0x00d7 }
            com.clevertap.android.pushtemplates.TemplateRenderer r3 = r6.renderer     // Catch:{ NullPointerException -> 0x00d7 }
            java.lang.String r3 = r3.pt_meta_clr     // Catch:{ NullPointerException -> 0x00d7 }
            android.graphics.Bitmap r1 = co.hyperverge.hypersnapsdk.c.k.setBitMapColour(r1, r2, r3)     // Catch:{ NullPointerException -> 0x00d7 }
            r0.pt_dot_sep = r1     // Catch:{ NullPointerException -> 0x00d7 }
            goto L_0x00dc
        L_0x00d7:
            java.lang.String r0 = "NPE while setting dot sep color"
            co.hyperverge.hypersnapsdk.c.k.debug(r0)
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.pushtemplates.content.ContentView.setCustomContentViewBasicKeys():void");
    }

    public final void setCustomContentViewCollapsedBackgroundColour(String str) {
        if (str != null) {
            if (str.length() > 0) {
                this.remoteView.setInt(R$id.content_view_small, "setBackgroundColor", k.getColour(str, "#FFFFFF"));
            }
        }
    }

    public final void setCustomContentViewExpandedBackgroundColour(String str) {
        if (str != null) {
            if (str.length() > 0) {
                this.remoteView.setInt(R$id.content_view_big, "setBackgroundColor", k.getColour(str, "#FFFFFF"));
            }
        }
    }

    public final void setCustomContentViewLargeIcon(String str) {
        if (str != null) {
            if (str.length() > 0) {
                k.loadImageURLIntoRemoteView(R$id.large_icon, str, this.remoteView);
                return;
            }
        }
        this.remoteView.setViewVisibility(R$id.large_icon, 8);
    }

    public final void setCustomContentViewMessage(String str) {
        if (str != null) {
            if (!(str.length() > 0)) {
                return;
            }
            if (VERSION.SDK_INT >= 24) {
                this.remoteView.setTextViewText(R$id.msg, Html.fromHtml(str, 0));
            } else {
                this.remoteView.setTextViewText(R$id.msg, Html.fromHtml(str));
            }
        }
    }

    public final void setCustomContentViewMessageColour(String str) {
        if (str != null) {
            if (str.length() > 0) {
                this.remoteView.setTextColor(R$id.msg, k.getColour(str, "#000000"));
            }
        }
    }

    public final void setCustomContentViewSmallIcon() {
        TemplateRenderer templateRenderer = this.renderer;
        Bitmap bitmap = templateRenderer.pt_small_icon;
        if (bitmap != null) {
            this.remoteView.setImageViewBitmap(R$id.small_icon, bitmap);
            return;
        }
        this.remoteView.setImageViewResource(R$id.small_icon, templateRenderer.smallIcon);
    }

    public final void setCustomContentViewTitle(String str) {
        if (str != null) {
            if (!(str.length() > 0)) {
                return;
            }
            if (VERSION.SDK_INT >= 24) {
                this.remoteView.setTextViewText(R$id.title, Html.fromHtml(str, 0));
            } else {
                this.remoteView.setTextViewText(R$id.title, Html.fromHtml(str));
            }
        }
    }

    public final void setCustomContentViewTitleColour(String str) {
        if (str != null) {
            if (str.length() > 0) {
                this.remoteView.setTextColor(R$id.title, k.getColour(str, "#000000"));
            }
        }
    }
}
