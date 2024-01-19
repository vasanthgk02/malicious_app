package com.clevertap.android.pushtemplates.content;

import android.os.Build.VERSION;
import android.text.Html;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0002J\u001f\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\b\u001eJ\u001d\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\fH\u0000¢\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b$R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/clevertap/android/pushtemplates/content/ProductDisplayLinearBigContentView;", "Lcom/clevertap/android/pushtemplates/content/ContentView;", "context", "Landroid/content/Context;", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "extras", "Landroid/os/Bundle;", "layoutId", "", "(Landroid/content/Context;Lcom/clevertap/android/pushtemplates/TemplateRenderer;Landroid/os/Bundle;I)V", "productDL", "", "productMessage", "getProductMessage", "()Ljava/lang/String;", "setProductMessage", "(Ljava/lang/String;)V", "productName", "getProductName", "setProductName", "productPrice", "setCustomContentViewButtonColour", "", "resourceID", "pt_product_display_action_clr", "setCustomContentViewButtonLabel", "pt_product_display_action", "setCustomContentViewButtonText", "pt_product_display_action_text_clr", "setCustomContentViewButtonText$clevertap_pushtemplates_release", "setCustomContentViewText", "resourceId", "s", "setCustomContentViewText$clevertap_pushtemplates_release", "setImageList", "setImageList$clevertap_pushtemplates_release", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ProductDisplayLinearBigContentView.kt */
public class ProductDisplayLinearBigContentView extends ContentView {
    public String productDL;
    public String productMessage;
    public String productName;
    public String productPrice;

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ProductDisplayLinearBigContentView(android.content.Context r17, com.clevertap.android.pushtemplates.TemplateRenderer r18, android.os.Bundle r19, int r20) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "renderer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "extras"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            r2 = r20
            r0.<init>(r7, r2, r8)
            java.util.ArrayList<java.lang.String> r2 = r8.bigTextList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r4 = "renderer.bigTextList!![0]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r2 = (java.lang.String) r2
            r0.productName = r2
            java.util.ArrayList<java.lang.String> r2 = r8.priceList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r4 = "renderer.priceList!![0]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r2 = (java.lang.String) r2
            r0.productPrice = r2
            java.util.ArrayList<java.lang.String> r2 = r8.smallTextList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r4 = "renderer.smallTextList!![0]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r2 = (java.lang.String) r2
            r0.productMessage = r2
            java.util.ArrayList<java.lang.String> r2 = r8.deepLinkList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r4 = "renderer.deepLinkList!![0]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r2 = (java.lang.String) r2
            r0.productDL = r2
            java.lang.String r2 = "extras_from"
            java.lang.String r4 = ""
            java.lang.String r2 = r9.getString(r2, r4)
            java.lang.String r4 = "PTReceiver"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
            if (r2 == 0) goto L_0x00c4
            java.lang.String r2 = "pt_current_position"
            int r2 = r9.getInt(r2, r3)
            java.util.ArrayList<java.lang.String> r4 = r8.bigTextList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.Object r4 = r4.get(r2)
            java.lang.String r5 = "renderer.bigTextList!![currentPosition]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.String r4 = (java.lang.String) r4
            r0.productName = r4
            java.util.ArrayList<java.lang.String> r4 = r8.priceList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.Object r4 = r4.get(r2)
            java.lang.String r5 = "renderer.priceList!![currentPosition]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.String r4 = (java.lang.String) r4
            r0.productPrice = r4
            java.util.ArrayList<java.lang.String> r4 = r8.smallTextList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.Object r4 = r4.get(r2)
            java.lang.String r5 = "renderer.smallTextList!![currentPosition]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.String r4 = (java.lang.String) r4
            r0.productMessage = r4
            java.util.ArrayList<java.lang.String> r4 = r8.deepLinkList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.Object r4 = r4.get(r2)
            java.lang.String r5 = "renderer.deepLinkList!![currentPosition]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.String r4 = (java.lang.String) r4
            r0.productDL = r4
            goto L_0x00c5
        L_0x00c4:
            r2 = 0
        L_0x00c5:
            r16.setCustomContentViewBasicKeys()
            java.util.ArrayList<java.lang.String> r4 = r8.bigTextList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            boolean r4 = r4.isEmpty()
            r10 = 1
            r4 = r4 ^ r10
            if (r4 == 0) goto L_0x00dc
            int r4 = com.clevertap.android.pushtemplates.R$id.product_name
            java.lang.String r5 = r0.productName
            r0.setCustomContentViewText$clevertap_pushtemplates_release(r4, r5)
        L_0x00dc:
            java.util.ArrayList<java.lang.String> r4 = r8.priceList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r10
            if (r4 == 0) goto L_0x00ef
            int r4 = com.clevertap.android.pushtemplates.R$id.product_price
            java.lang.String r5 = r0.productPrice
            r0.setCustomContentViewText$clevertap_pushtemplates_release(r4, r5)
        L_0x00ef:
            java.lang.String r4 = r8.pt_bg
            r0.setCustomContentViewExpandedBackgroundColour(r4)
            int r4 = com.clevertap.android.pushtemplates.R$id.product_action
            java.lang.String r5 = r8.pt_product_display_action
            if (r5 == 0) goto L_0x011e
            int r6 = r5.length()
            if (r6 <= 0) goto L_0x0102
            r6 = 1
            goto L_0x0103
        L_0x0102:
            r6 = 0
        L_0x0103:
            if (r6 == 0) goto L_0x011e
            int r6 = android.os.Build.VERSION.SDK_INT
            r11 = 24
            if (r6 < r11) goto L_0x0115
            android.widget.RemoteViews r6 = r0.remoteView
            android.text.Spanned r5 = android.text.Html.fromHtml(r5, r3)
            r6.setTextViewText(r4, r5)
            goto L_0x011e
        L_0x0115:
            android.widget.RemoteViews r6 = r0.remoteView
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)
            r6.setTextViewText(r4, r5)
        L_0x011e:
            int r4 = com.clevertap.android.pushtemplates.R$id.product_action
            java.lang.String r5 = r8.pt_product_display_action_clr
            if (r5 == 0) goto L_0x013c
            int r6 = r5.length()
            if (r6 <= 0) goto L_0x012c
            r6 = 1
            goto L_0x012d
        L_0x012c:
            r6 = 0
        L_0x012d:
            if (r6 == 0) goto L_0x013c
            android.widget.RemoteViews r6 = r0.remoteView
            java.lang.String r11 = "#FFBB33"
            int r5 = co.hyperverge.hypersnapsdk.c.k.getColour(r5, r11)
            java.lang.String r11 = "setBackgroundColor"
            r6.setInt(r4, r11, r5)
        L_0x013c:
            int r4 = com.clevertap.android.pushtemplates.R$id.product_action
            java.lang.String r5 = r8.pt_product_display_action_text_clr
            if (r5 == 0) goto L_0x0158
            int r6 = r5.length()
            if (r6 <= 0) goto L_0x014a
            r6 = 1
            goto L_0x014b
        L_0x014a:
            r6 = 0
        L_0x014b:
            if (r6 == 0) goto L_0x0158
            android.widget.RemoteViews r6 = r0.remoteView
            java.lang.String r11 = "#FFFFFF"
            int r5 = co.hyperverge.hypersnapsdk.c.k.getColour(r5, r11)
            r6.setTextColor(r4, r5)
        L_0x0158:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r4 = com.clevertap.android.pushtemplates.R$id.small_image1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.add(r4)
            int r4 = com.clevertap.android.pushtemplates.R$id.small_image2
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.add(r4)
            int r4 = com.clevertap.android.pushtemplates.R$id.small_image3
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.add(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            com.clevertap.android.pushtemplates.TemplateRenderer r5 = r0.renderer
            java.util.ArrayList<java.lang.String> r5 = r5.imageList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r5 = r5.size()
            int r5 = r5 + -1
            if (r5 < 0) goto L_0x0238
            r6 = 0
            r11 = 0
            r12 = 0
        L_0x0192:
            int r13 = r6 + 1
            java.lang.Object r14 = r1.get(r11)
            java.lang.String r15 = "smallImageLayoutIds[imageCounter]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r15)
            java.lang.Number r14 = (java.lang.Number) r14
            int r14 = r14.intValue()
            com.clevertap.android.pushtemplates.TemplateRenderer r10 = r0.renderer
            java.util.ArrayList<java.lang.String> r10 = r10.imageList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.lang.Object r10 = r10.get(r6)
            java.lang.String r10 = (java.lang.String) r10
            android.widget.RemoteViews r3 = r0.remoteView
            co.hyperverge.hypersnapsdk.c.k.loadImageURLIntoRemoteView(r14, r10, r3)
            android.widget.RemoteViews r3 = new android.widget.RemoteViews
            android.content.Context r10 = r0.context
            java.lang.String r10 = r10.getPackageName()
            int r14 = com.clevertap.android.pushtemplates.R$layout.image_view
            r3.<init>(r10, r14)
            int r10 = com.clevertap.android.pushtemplates.R$id.fimg
            com.clevertap.android.pushtemplates.TemplateRenderer r14 = r0.renderer
            java.util.ArrayList<java.lang.String> r14 = r14.imageList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            java.lang.Object r14 = r14.get(r6)
            java.lang.String r14 = (java.lang.String) r14
            co.hyperverge.hypersnapsdk.c.k.loadImageURLIntoRemoteView(r10, r14, r3)
            boolean r10 = com.clevertap.android.pushtemplates.PTConstants.PT_FALLBACK
            if (r10 != 0) goto L_0x0206
            if (r12 != 0) goto L_0x01db
            r12 = 1
        L_0x01db:
            android.widget.RemoteViews r10 = r0.remoteView
            java.lang.Object r14 = r1.get(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r15)
            java.lang.Number r14 = (java.lang.Number) r14
            int r14 = r14.intValue()
            r15 = 0
            r10.setViewVisibility(r14, r15)
            android.widget.RemoteViews r10 = r0.remoteView
            int r14 = com.clevertap.android.pushtemplates.R$id.carousel_image
            r10.addView(r14, r3)
            int r11 = r11 + 1
            com.clevertap.android.pushtemplates.TemplateRenderer r3 = r0.renderer
            java.util.ArrayList<java.lang.String> r3 = r3.imageList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Object r3 = r3.get(r6)
            r4.add(r3)
            goto L_0x022f
        L_0x0206:
            r15 = 0
            com.clevertap.android.pushtemplates.TemplateRenderer r3 = r0.renderer
            java.util.ArrayList<java.lang.String> r3 = r3.deepLinkList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r3.remove(r6)
            com.clevertap.android.pushtemplates.TemplateRenderer r3 = r0.renderer
            java.util.ArrayList<java.lang.String> r3 = r3.bigTextList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r3.remove(r6)
            com.clevertap.android.pushtemplates.TemplateRenderer r3 = r0.renderer
            java.util.ArrayList<java.lang.String> r3 = r3.smallTextList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r3.remove(r6)
            com.clevertap.android.pushtemplates.TemplateRenderer r3 = r0.renderer
            java.util.ArrayList<java.lang.String> r3 = r3.priceList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r3.remove(r6)
        L_0x022f:
            if (r13 <= r5) goto L_0x0233
            r3 = r11
            goto L_0x023a
        L_0x0233:
            r6 = r13
            r3 = 0
            r10 = 1
            goto L_0x0192
        L_0x0238:
            r15 = 0
            r3 = 0
        L_0x023a:
            java.lang.String r1 = "pt_image_list"
            r9.putStringArrayList(r1, r4)
            com.clevertap.android.pushtemplates.TemplateRenderer r1 = r0.renderer
            java.util.ArrayList<java.lang.String> r1 = r1.deepLinkList
            java.lang.String r4 = "pt_deeplink_list"
            r9.putStringArrayList(r4, r1)
            com.clevertap.android.pushtemplates.TemplateRenderer r1 = r0.renderer
            java.util.ArrayList<java.lang.String> r1 = r1.bigTextList
            java.lang.String r4 = "pt_big_text_list"
            r9.putStringArrayList(r4, r1)
            com.clevertap.android.pushtemplates.TemplateRenderer r1 = r0.renderer
            java.util.ArrayList<java.lang.String> r1 = r1.smallTextList
            java.lang.String r4 = "pt_small_text_list"
            r9.putStringArrayList(r4, r1)
            com.clevertap.android.pushtemplates.TemplateRenderer r1 = r0.renderer
            java.util.ArrayList<java.lang.String> r1 = r1.priceList
            java.lang.String r4 = "pt_price_list"
            r9.putStringArrayList(r4, r1)
            r1 = 1
            if (r3 > r1) goto L_0x026b
            java.lang.String r1 = "2 or more images are not retrievable, not displaying the notification."
            co.hyperverge.hypersnapsdk.c.k.debug(r1)
        L_0x026b:
            android.widget.RemoteViews r1 = r0.remoteView
            int r3 = com.clevertap.android.pushtemplates.R$id.carousel_image
            r1.setDisplayedChild(r3, r2)
            r16.setCustomContentViewSmallIcon()
            android.widget.RemoteViews r10 = r0.remoteView
            int r11 = com.clevertap.android.pushtemplates.R$id.small_image1
            int r2 = r8.notificationId
            r4 = 0
            r5 = 21
            r1 = r17
            r3 = r19
            r6 = r18
            android.app.PendingIntent r1 = com.clevertap.android.pushtemplates.content.PendingIntentFactory.getPendingIntent(r1, r2, r3, r4, r5, r6)
            r10.setOnClickPendingIntent(r11, r1)
            java.util.ArrayList<java.lang.String> r1 = r8.deepLinkList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.size()
            r2 = 2
            if (r1 < r2) goto L_0x02ad
            android.widget.RemoteViews r10 = r0.remoteView
            int r11 = com.clevertap.android.pushtemplates.R$id.small_image2
            int r2 = r8.notificationId
            r4 = 0
            r5 = 22
            r1 = r17
            r3 = r19
            r6 = r18
            android.app.PendingIntent r1 = com.clevertap.android.pushtemplates.content.PendingIntentFactory.getPendingIntent(r1, r2, r3, r4, r5, r6)
            r10.setOnClickPendingIntent(r11, r1)
        L_0x02ad:
            java.util.ArrayList<java.lang.String> r1 = r8.deepLinkList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.size()
            r2 = 3
            if (r1 < r2) goto L_0x02cf
            android.widget.RemoteViews r10 = r0.remoteView
            int r11 = com.clevertap.android.pushtemplates.R$id.small_image3
            int r2 = r8.notificationId
            r4 = 0
            r5 = 23
            r1 = r17
            r3 = r19
            r6 = r18
            android.app.PendingIntent r1 = com.clevertap.android.pushtemplates.content.PendingIntentFactory.getPendingIntent(r1, r2, r3, r4, r5, r6)
            r10.setOnClickPendingIntent(r11, r1)
        L_0x02cf:
            java.lang.Object r1 = r19.clone()
            android.os.Bundle r1 = (android.os.Bundle) r1
            java.lang.String r2 = "img1"
            r3 = 1
            r1.putBoolean(r2, r3)
            int r2 = r8.notificationId
            java.lang.String r4 = "notificationId"
            r1.putInt(r4, r2)
            java.lang.String r2 = r0.productDL
            java.lang.String r4 = "pt_buy_now_dl"
            r1.putString(r4, r2)
            java.lang.String r2 = "buynow"
            r1.putBoolean(r2, r3)
            android.widget.RemoteViews r2 = r0.remoteView
            int r3 = com.clevertap.android.pushtemplates.R$id.product_action
            java.lang.String r4 = r0.productDL
            int r5 = r8.notificationId
            android.app.PendingIntent r1 = com.clevertap.android.pushtemplates.content.PendingIntentFactory.getCtaLaunchPendingIntent(r7, r1, r4, r5)
            r2.setOnClickPendingIntent(r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.pushtemplates.content.ProductDisplayLinearBigContentView.<init>(android.content.Context, com.clevertap.android.pushtemplates.TemplateRenderer, android.os.Bundle, int):void");
    }

    public final void setCustomContentViewText$clevertap_pushtemplates_release(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "s");
        if (!(str.length() > 0)) {
            return;
        }
        if (VERSION.SDK_INT >= 24) {
            this.remoteView.setTextViewText(i, Html.fromHtml(str, 0));
        } else {
            this.remoteView.setTextViewText(i, Html.fromHtml(str));
        }
    }
}
