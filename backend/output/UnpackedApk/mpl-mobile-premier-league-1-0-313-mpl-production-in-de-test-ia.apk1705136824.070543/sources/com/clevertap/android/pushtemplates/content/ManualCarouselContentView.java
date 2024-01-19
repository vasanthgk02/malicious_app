package com.clevertap.android.pushtemplates.content;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¨\u0006\r"}, d2 = {"Lcom/clevertap/android/pushtemplates/content/ManualCarouselContentView;", "Lcom/clevertap/android/pushtemplates/content/BigImageContentView;", "context", "Landroid/content/Context;", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "extras", "Landroid/os/Bundle;", "(Landroid/content/Context;Lcom/clevertap/android/pushtemplates/TemplateRenderer;Landroid/os/Bundle;)V", "setCustomContentViewMessageSummary", "", "pt_msg_summary", "", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ManualCarouselContentView.kt */
public final class ManualCarouselContentView extends BigImageContentView {
    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ManualCarouselContentView(android.content.Context r18, com.clevertap.android.pushtemplates.TemplateRenderer r19, android.os.Bundle r20) {
        /*
            r17 = this;
            r0 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "renderer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "extras"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            int r1 = com.clevertap.android.pushtemplates.R$layout.manual_carousel
            r0.<init>(r7, r8, r1)
            java.lang.String r1 = r8.pt_msg_summary
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x004a
            int r4 = r1.length()
            if (r4 <= 0) goto L_0x002a
            r4 = 1
            goto L_0x002b
        L_0x002a:
            r4 = 0
        L_0x002b:
            if (r4 == 0) goto L_0x004a
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 24
            if (r4 < r5) goto L_0x003f
            android.widget.RemoteViews r4 = r0.remoteView
            int r5 = com.clevertap.android.pushtemplates.R$id.msg
            android.text.Spanned r1 = android.text.Html.fromHtml(r1, r3)
            r4.setTextViewText(r5, r1)
            goto L_0x004a
        L_0x003f:
            android.widget.RemoteViews r4 = r0.remoteView
            int r5 = com.clevertap.android.pushtemplates.R$id.msg
            android.text.Spanned r1 = android.text.Html.fromHtml(r1)
            r4.setTextViewText(r5, r1)
        L_0x004a:
            android.widget.RemoteViews r1 = r0.remoteView
            int r4 = com.clevertap.android.pushtemplates.R$id.leftArrowPos0
            r1.setViewVisibility(r4, r3)
            android.widget.RemoteViews r1 = r0.remoteView
            int r4 = com.clevertap.android.pushtemplates.R$id.rightArrowPos0
            r1.setViewVisibility(r4, r3)
            java.util.ArrayList<java.lang.String> r1 = r8.deepLinkList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.Object r1 = r1.get(r3)
            java.lang.String r4 = "renderer.deepLinkList!![0]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            java.lang.String r1 = (java.lang.String) r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList<java.lang.String> r4 = r8.imageList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r4 = r4.size()
            int r4 = r4 + -1
            if (r4 < 0) goto L_0x011b
            r5 = 0
            r6 = 0
            r10 = 0
            r11 = 0
        L_0x007e:
            int r12 = r5 + 1
            android.widget.RemoteViews r13 = new android.widget.RemoteViews
            java.lang.String r14 = r18.getPackageName()
            int r15 = com.clevertap.android.pushtemplates.R$layout.image_view_rounded
            r13.<init>(r14, r15)
            int r14 = com.clevertap.android.pushtemplates.R$id.flipper_img
            java.util.ArrayList<java.lang.String> r15 = r8.imageList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            java.lang.Object r15 = r15.get(r5)
            java.lang.String r15 = (java.lang.String) r15
            android.graphics.Bitmap r3 = co.hyperverge.hypersnapsdk.c.k.getBitmapFromURL(r15)
            java.lang.Boolean r16 = java.lang.Boolean.FALSE
            co.hyperverge.hypersnapsdk.c.k.setFallback(r16)
            if (r3 == 0) goto L_0x00a7
            r13.setImageViewBitmap(r14, r3)
            goto L_0x00c5
        L_0x00a7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r14 = "Image was not perfect. URL:"
            r3.append(r14)
            r3.append(r15)
            java.lang.String r14 = " hiding image view"
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            co.hyperverge.hypersnapsdk.c.k.debug(r3)
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            co.hyperverge.hypersnapsdk.c.k.setFallback(r3)
        L_0x00c5:
            boolean r3 = com.clevertap.android.pushtemplates.PTConstants.PT_FALLBACK
            if (r3 != 0) goto L_0x00f1
            if (r6 != 0) goto L_0x00cd
            r11 = r5
            r6 = 1
        L_0x00cd:
            android.widget.RemoteViews r3 = r0.remoteView
            int r14 = com.clevertap.android.pushtemplates.R$id.carousel_image
            r3.addView(r14, r13)
            android.widget.RemoteViews r3 = r0.remoteView
            int r14 = com.clevertap.android.pushtemplates.R$id.carousel_image_right
            r3.addView(r14, r13)
            android.widget.RemoteViews r3 = r0.remoteView
            int r14 = com.clevertap.android.pushtemplates.R$id.carousel_image_left
            r3.addView(r14, r13)
            int r10 = r10 + 1
            java.util.ArrayList<java.lang.String> r3 = r8.imageList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Object r3 = r3.get(r5)
            r1.add(r3)
            goto L_0x0114
        L_0x00f1:
            java.util.ArrayList<java.lang.String> r3 = r8.deepLinkList
            if (r3 == 0) goto L_0x010f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r3 = r3.size()
            java.util.ArrayList<java.lang.String> r13 = r8.imageList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            int r13 = r13.size()
            if (r3 != r13) goto L_0x010f
            java.util.ArrayList<java.lang.String> r3 = r8.deepLinkList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r3.remove(r5)
        L_0x010f:
            java.lang.String r3 = "Skipping Image in Manual Carousel."
            co.hyperverge.hypersnapsdk.c.k.debug(r3)
        L_0x0114:
            if (r12 <= r4) goto L_0x0117
            goto L_0x011d
        L_0x0117:
            r5 = r12
            r3 = 0
            goto L_0x007e
        L_0x011b:
            r10 = 0
            r11 = 0
        L_0x011d:
            java.lang.String r3 = r8.pt_manual_carousel_type
            if (r3 == 0) goto L_0x0129
            java.lang.String r4 = "filmstrip"
            boolean r3 = kotlin.text.CharsKt__CharKt.equals(r3, r4, r2)
            if (r3 != 0) goto L_0x0139
        L_0x0129:
            android.widget.RemoteViews r3 = r0.remoteView
            int r4 = com.clevertap.android.pushtemplates.R$id.carousel_image_right
            r5 = 8
            r3.setViewVisibility(r4, r5)
            android.widget.RemoteViews r3 = r0.remoteView
            int r4 = com.clevertap.android.pushtemplates.R$id.carousel_image_left
            r3.setViewVisibility(r4, r5)
        L_0x0139:
            java.lang.String r3 = "right_swipe"
            boolean r4 = r9.containsKey(r3)
            java.lang.String r5 = "manual_carousel_from"
            java.lang.String r6 = "wzrk_dl"
            java.lang.String r12 = "pt_manual_carousel_current"
            if (r4 == 0) goto L_0x0231
            boolean r4 = r9.getBoolean(r3)
            int r10 = r9.getInt(r12)
            int r11 = r1.size()
            int r11 = r11 - r2
            if (r10 != r11) goto L_0x0158
            r11 = 0
            goto L_0x015a
        L_0x0158:
            int r11 = r10 + 1
        L_0x015a:
            if (r10 != 0) goto L_0x0162
            int r13 = r1.size()
            int r13 = r13 - r2
            goto L_0x0164
        L_0x0162:
            int r13 = r10 + -1
        L_0x0164:
            android.widget.RemoteViews r14 = r0.remoteView
            int r15 = com.clevertap.android.pushtemplates.R$id.carousel_image
            r14.setDisplayedChild(r15, r10)
            android.widget.RemoteViews r14 = r0.remoteView
            int r15 = com.clevertap.android.pushtemplates.R$id.carousel_image_right
            r14.setDisplayedChild(r15, r11)
            android.widget.RemoteViews r14 = r0.remoteView
            int r15 = com.clevertap.android.pushtemplates.R$id.carousel_image_left
            r14.setDisplayedChild(r15, r13)
            if (r4 == 0) goto L_0x0191
            android.widget.RemoteViews r4 = r0.remoteView
            int r13 = com.clevertap.android.pushtemplates.R$id.carousel_image
            r4.showNext(r13)
            android.widget.RemoteViews r4 = r0.remoteView
            int r13 = com.clevertap.android.pushtemplates.R$id.carousel_image_right
            r4.showNext(r13)
            android.widget.RemoteViews r4 = r0.remoteView
            int r13 = com.clevertap.android.pushtemplates.R$id.carousel_image_left
            r4.showNext(r13)
            goto L_0x01a7
        L_0x0191:
            android.widget.RemoteViews r4 = r0.remoteView
            int r11 = com.clevertap.android.pushtemplates.R$id.carousel_image
            r4.showPrevious(r11)
            android.widget.RemoteViews r4 = r0.remoteView
            int r11 = com.clevertap.android.pushtemplates.R$id.carousel_image_right
            r4.showPrevious(r11)
            android.widget.RemoteViews r4 = r0.remoteView
            int r11 = com.clevertap.android.pushtemplates.R$id.carousel_image_left
            r4.showPrevious(r11)
            r11 = r13
        L_0x01a7:
            java.util.ArrayList<java.lang.String> r4 = r8.deepLinkList
            java.lang.String r13 = "deepLinkList.get(newPosition)"
            if (r4 == 0) goto L_0x01c1
            int r14 = r4.size()
            int r1 = r1.size()
            if (r14 != r1) goto L_0x01c1
            java.lang.Object r1 = r4.get(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x01ff
        L_0x01c1:
            java.lang.String r1 = "deepLinkList.get(0)"
            if (r4 == 0) goto L_0x01d7
            int r14 = r4.size()
            if (r14 != r2) goto L_0x01d7
            r2 = 0
            java.lang.Object r2 = r4.get(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x01ff
        L_0x01d7:
            if (r4 == 0) goto L_0x01e9
            int r2 = r4.size()
            if (r2 <= r11) goto L_0x01e9
            java.lang.Object r1 = r4.get(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x01ff
        L_0x01e9:
            if (r4 == 0) goto L_0x01fd
            int r2 = r4.size()
            if (r2 >= r11) goto L_0x01fd
            r2 = 0
            java.lang.Object r2 = r4.get(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x01ff
        L_0x01fd:
            java.lang.String r1 = ""
        L_0x01ff:
            r9.putInt(r12, r11)
            r9.remove(r3)
            r9.putString(r6, r1)
            r9.putInt(r5, r10)
            android.widget.RemoteViews r10 = r0.remoteView
            int r11 = com.clevertap.android.pushtemplates.R$id.rightArrowPos0
            int r2 = r8.notificationId
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r18
            r3 = r20
            android.app.PendingIntent r1 = com.clevertap.android.pushtemplates.content.PendingIntentFactory.getPendingIntent(r1, r2, r3, r4, r5, r6)
            r10.setOnClickPendingIntent(r11, r1)
            android.widget.RemoteViews r10 = r0.remoteView
            int r11 = com.clevertap.android.pushtemplates.R$id.leftArrowPos0
            int r2 = r8.notificationId
            r5 = 5
            r1 = r18
            android.app.PendingIntent r1 = com.clevertap.android.pushtemplates.content.PendingIntentFactory.getPendingIntent(r1, r2, r3, r4, r5, r6)
            r10.setOnClickPendingIntent(r11, r1)
            goto L_0x02ae
        L_0x0231:
            android.widget.RemoteViews r3 = r0.remoteView
            int r4 = com.clevertap.android.pushtemplates.R$id.carousel_image_right
            r3.setDisplayedChild(r4, r2)
            android.widget.RemoteViews r3 = r0.remoteView
            int r4 = com.clevertap.android.pushtemplates.R$id.carousel_image
            r13 = 0
            r3.setDisplayedChild(r4, r13)
            android.widget.RemoteViews r3 = r0.remoteView
            int r4 = com.clevertap.android.pushtemplates.R$id.carousel_image_left
            int r13 = r1.size()
            int r13 = r13 - r2
            r3.setDisplayedChild(r4, r13)
            r9.putInt(r12, r11)
            java.lang.String r2 = "pt_image_list"
            r9.putStringArrayList(r2, r1)
            java.util.ArrayList<java.lang.String> r1 = r8.deepLinkList
            java.lang.String r2 = "pt_deeplink_list"
            r9.putStringArrayList(r2, r1)
            java.util.ArrayList<java.lang.String> r1 = r8.deepLinkList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            r9.putString(r6, r1)
            r9.putInt(r5, r2)
            android.widget.RemoteViews r11 = r0.remoteView
            int r12 = com.clevertap.android.pushtemplates.R$id.rightArrowPos0
            int r2 = r8.notificationId
            r4 = 0
            r5 = 4
            r1 = r18
            r3 = r20
            r6 = r19
            android.app.PendingIntent r1 = com.clevertap.android.pushtemplates.content.PendingIntentFactory.getPendingIntent(r1, r2, r3, r4, r5, r6)
            r11.setOnClickPendingIntent(r12, r1)
            android.widget.RemoteViews r11 = r0.remoteView
            int r12 = com.clevertap.android.pushtemplates.R$id.leftArrowPos0
            int r2 = r8.notificationId
            r5 = 5
            r1 = r18
            android.app.PendingIntent r1 = com.clevertap.android.pushtemplates.content.PendingIntentFactory.getPendingIntent(r1, r2, r3, r4, r5, r6)
            r11.setOnClickPendingIntent(r12, r1)
            r1 = 2
            if (r10 >= r1) goto L_0x02ae
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Need at least 2 images to display Manual Carousel, found - "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r2 = ", not displaying the notification."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            co.hyperverge.hypersnapsdk.c.k.debug(r1)
        L_0x02ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.pushtemplates.content.ManualCarouselContentView.<init>(android.content.Context, com.clevertap.android.pushtemplates.TemplateRenderer, android.os.Bundle):void");
    }
}
