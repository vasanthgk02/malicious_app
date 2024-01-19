package com.clevertap.android.pushtemplates.content;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0002\b\fR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/clevertap/android/pushtemplates/content/FiveIconBigContentView;", "Lcom/clevertap/android/pushtemplates/content/ContentView;", "context", "Landroid/content/Context;", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "extras", "Landroid/os/Bundle;", "(Landroid/content/Context;Lcom/clevertap/android/pushtemplates/TemplateRenderer;Landroid/os/Bundle;)V", "imageCounter", "", "getUnloadedFiveIconsCount", "getUnloadedFiveIconsCount$clevertap_pushtemplates_release", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FiveIconBigContentView.kt */
public final class FiveIconBigContentView extends ContentView {
    public int imageCounter;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0026, code lost:
        if ((r0.length() == 0) != false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FiveIconBigContentView(android.content.Context r13, com.clevertap.android.pushtemplates.TemplateRenderer r14, android.os.Bundle r15) {
        /*
            r12 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "renderer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "extras"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            int r0 = com.clevertap.android.pushtemplates.R$layout.five_cta_expanded
            r12.<init>(r13, r0, r14)
            java.lang.String r0 = r14.pt_title
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0028
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0025
            r0 = 1
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            if (r0 == 0) goto L_0x002e
        L_0x0028:
            java.lang.String r0 = co.hyperverge.hypersnapsdk.c.k.getApplicationName(r13)
            r14.pt_title = r0
        L_0x002e:
            java.lang.String r0 = r14.pt_bg
            r12.setCustomContentViewExpandedBackgroundColour(r0)
            java.util.ArrayList<java.lang.String> r0 = r14.imageList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.size()
            int r0 = r0 + -1
            r3 = 4
            r4 = 3
            r5 = 2
            if (r0 < 0) goto L_0x012d
            r6 = 0
        L_0x0044:
            int r7 = r6 + 1
            r8 = 8
            if (r6 == 0) goto L_0x00fe
            if (r6 == r1) goto L_0x00d4
            if (r6 == r5) goto L_0x00aa
            if (r6 == r4) goto L_0x007f
            if (r6 == r3) goto L_0x0054
            goto L_0x0127
        L_0x0054:
            android.widget.RemoteViews r9 = r12.remoteView
            int r10 = com.clevertap.android.pushtemplates.R$id.cta5
            r9.setViewVisibility(r10, r2)
            int r9 = com.clevertap.android.pushtemplates.R$id.cta5
            java.util.ArrayList<java.lang.String> r10 = r14.imageList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.lang.Object r6 = r10.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            android.widget.RemoteViews r10 = r12.remoteView
            co.hyperverge.hypersnapsdk.c.k.loadImageURLIntoRemoteView(r9, r6, r10)
            boolean r6 = com.clevertap.android.pushtemplates.PTConstants.PT_FALLBACK
            if (r6 == 0) goto L_0x0127
            int r6 = r12.imageCounter
            int r6 = r6 + r1
            r12.imageCounter = r6
            android.widget.RemoteViews r6 = r12.remoteView
            int r9 = com.clevertap.android.pushtemplates.R$id.cta5
            r6.setViewVisibility(r9, r8)
            goto L_0x0127
        L_0x007f:
            android.widget.RemoteViews r9 = r12.remoteView
            int r10 = com.clevertap.android.pushtemplates.R$id.cta4
            r9.setViewVisibility(r10, r2)
            int r9 = com.clevertap.android.pushtemplates.R$id.cta4
            java.util.ArrayList<java.lang.String> r10 = r14.imageList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.lang.Object r6 = r10.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            android.widget.RemoteViews r10 = r12.remoteView
            co.hyperverge.hypersnapsdk.c.k.loadImageURLIntoRemoteView(r9, r6, r10)
            boolean r6 = com.clevertap.android.pushtemplates.PTConstants.PT_FALLBACK
            if (r6 == 0) goto L_0x0127
            int r6 = r12.imageCounter
            int r6 = r6 + r1
            r12.imageCounter = r6
            android.widget.RemoteViews r6 = r12.remoteView
            int r9 = com.clevertap.android.pushtemplates.R$id.cta4
            r6.setViewVisibility(r9, r8)
            goto L_0x0127
        L_0x00aa:
            android.widget.RemoteViews r9 = r12.remoteView
            int r10 = com.clevertap.android.pushtemplates.R$id.cta3
            r9.setViewVisibility(r10, r2)
            int r9 = com.clevertap.android.pushtemplates.R$id.cta3
            java.util.ArrayList<java.lang.String> r10 = r14.imageList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.lang.Object r6 = r10.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            android.widget.RemoteViews r10 = r12.remoteView
            co.hyperverge.hypersnapsdk.c.k.loadImageURLIntoRemoteView(r9, r6, r10)
            boolean r6 = com.clevertap.android.pushtemplates.PTConstants.PT_FALLBACK
            if (r6 == 0) goto L_0x0127
            int r6 = r12.imageCounter
            int r6 = r6 + r1
            r12.imageCounter = r6
            android.widget.RemoteViews r6 = r12.remoteView
            int r9 = com.clevertap.android.pushtemplates.R$id.cta3
            r6.setViewVisibility(r9, r8)
            goto L_0x0127
        L_0x00d4:
            android.widget.RemoteViews r9 = r12.remoteView
            int r10 = com.clevertap.android.pushtemplates.R$id.cta2
            r9.setViewVisibility(r10, r2)
            int r9 = com.clevertap.android.pushtemplates.R$id.cta2
            java.util.ArrayList<java.lang.String> r10 = r14.imageList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.lang.Object r6 = r10.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            android.widget.RemoteViews r10 = r12.remoteView
            co.hyperverge.hypersnapsdk.c.k.loadImageURLIntoRemoteView(r9, r6, r10)
            boolean r6 = com.clevertap.android.pushtemplates.PTConstants.PT_FALLBACK
            if (r6 == 0) goto L_0x0127
            int r6 = r12.imageCounter
            int r6 = r6 + r1
            r12.imageCounter = r6
            android.widget.RemoteViews r6 = r12.remoteView
            int r9 = com.clevertap.android.pushtemplates.R$id.cta2
            r6.setViewVisibility(r9, r8)
            goto L_0x0127
        L_0x00fe:
            android.widget.RemoteViews r9 = r12.remoteView
            int r10 = com.clevertap.android.pushtemplates.R$id.cta1
            r9.setViewVisibility(r10, r2)
            int r9 = com.clevertap.android.pushtemplates.R$id.cta1
            java.util.ArrayList<java.lang.String> r10 = r14.imageList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.lang.Object r6 = r10.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            android.widget.RemoteViews r10 = r12.remoteView
            co.hyperverge.hypersnapsdk.c.k.loadImageURLIntoRemoteView(r9, r6, r10)
            boolean r6 = com.clevertap.android.pushtemplates.PTConstants.PT_FALLBACK
            if (r6 == 0) goto L_0x0127
            android.widget.RemoteViews r6 = r12.remoteView
            int r9 = com.clevertap.android.pushtemplates.R$id.cta1
            r6.setViewVisibility(r9, r8)
            int r6 = r12.imageCounter
            int r6 = r6 + r1
            r12.imageCounter = r6
        L_0x0127:
            if (r7 <= r0) goto L_0x012a
            goto L_0x012d
        L_0x012a:
            r6 = r7
            goto L_0x0044
        L_0x012d:
            int r0 = com.clevertap.android.pushtemplates.R$id.close
            int r6 = com.clevertap.android.pushtemplates.R$drawable.pt_close
            android.widget.RemoteViews r7 = r12.remoteView
            r7.setImageViewResource(r0, r6)
            int r0 = r14.notificationId
            java.lang.String r6 = "notificationId"
            r15.putInt(r6, r0)
            java.lang.String r0 = "close_system_dialogs"
            r15.putBoolean(r0, r1)
            java.lang.Object r0 = r15.clone()
            android.os.Bundle r0 = (android.os.Bundle) r0
            java.lang.String r6 = "cta1"
            r0.putBoolean(r6, r1)
            java.util.ArrayList<java.lang.String> r6 = r14.deepLinkList
            r7 = 0
            if (r6 != 0) goto L_0x0154
            r6 = r7
            goto L_0x015a
        L_0x0154:
            java.lang.Object r6 = r6.get(r2)
            java.lang.String r6 = (java.lang.String) r6
        L_0x015a:
            java.lang.String r8 = "wzrk_dl"
            r0.putString(r8, r6)
            java.util.ArrayList<java.lang.String> r6 = r14.deepLinkList
            if (r6 != 0) goto L_0x0165
            r2 = r7
            goto L_0x016b
        L_0x0165:
            java.lang.Object r2 = r6.get(r2)
            java.lang.String r2 = (java.lang.String) r2
        L_0x016b:
            java.lang.String r6 = "5cta_1_"
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r2)
            java.lang.String r6 = "wzrk_c2a"
            r0.putString(r6, r2)
            android.widget.RemoteViews r2 = r12.remoteView
            int r9 = com.clevertap.android.pushtemplates.R$id.cta1
            android.app.PendingIntent r0 = co.hyperverge.hypersnapsdk.c.k.getLaunchPendingIntent(r0, r13)
            r2.setOnClickPendingIntent(r9, r0)
            java.lang.Object r0 = r15.clone()
            android.os.Bundle r0 = (android.os.Bundle) r0
            java.lang.String r2 = "cta2"
            r0.putBoolean(r2, r1)
            java.util.ArrayList<java.lang.String> r2 = r14.deepLinkList
            if (r2 != 0) goto L_0x0192
            r2 = r7
            goto L_0x0198
        L_0x0192:
            java.lang.Object r2 = r2.get(r1)
            java.lang.String r2 = (java.lang.String) r2
        L_0x0198:
            r0.putString(r8, r2)
            java.util.ArrayList<java.lang.String> r2 = r14.deepLinkList
            if (r2 != 0) goto L_0x01a1
            r2 = r7
            goto L_0x01a7
        L_0x01a1:
            java.lang.Object r2 = r2.get(r1)
            java.lang.String r2 = (java.lang.String) r2
        L_0x01a7:
            java.lang.String r9 = "5cta_2_"
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r2)
            r0.putString(r6, r2)
            android.widget.RemoteViews r2 = r12.remoteView
            int r9 = com.clevertap.android.pushtemplates.R$id.cta2
            android.app.PendingIntent r0 = co.hyperverge.hypersnapsdk.c.k.getLaunchPendingIntent(r0, r13)
            r2.setOnClickPendingIntent(r9, r0)
            java.lang.Object r0 = r15.clone()
            android.os.Bundle r0 = (android.os.Bundle) r0
            java.lang.String r2 = "cta3"
            r0.putBoolean(r2, r1)
            java.util.ArrayList<java.lang.String> r2 = r14.deepLinkList
            if (r2 != 0) goto L_0x01cc
            r2 = r7
            goto L_0x01d2
        L_0x01cc:
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
        L_0x01d2:
            r0.putString(r8, r2)
            java.util.ArrayList<java.lang.String> r2 = r14.deepLinkList
            if (r2 != 0) goto L_0x01db
            r2 = r7
            goto L_0x01e1
        L_0x01db:
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
        L_0x01e1:
            java.lang.String r9 = "5cta_3_"
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r2)
            r0.putString(r6, r2)
            android.widget.RemoteViews r2 = r12.remoteView
            int r9 = com.clevertap.android.pushtemplates.R$id.cta3
            android.app.PendingIntent r0 = co.hyperverge.hypersnapsdk.c.k.getLaunchPendingIntent(r0, r13)
            r2.setOnClickPendingIntent(r9, r0)
            java.util.ArrayList<java.lang.String> r0 = r14.deepLinkList
            if (r0 == 0) goto L_0x023c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.size()
            if (r0 <= r4) goto L_0x023c
            java.lang.Object r0 = r15.clone()
            android.os.Bundle r0 = (android.os.Bundle) r0
            java.lang.String r2 = "cta4"
            r0.putBoolean(r2, r1)
            java.util.ArrayList<java.lang.String> r2 = r14.deepLinkList
            if (r2 != 0) goto L_0x0213
            r2 = r7
            goto L_0x0219
        L_0x0213:
            java.lang.Object r2 = r2.get(r4)
            java.lang.String r2 = (java.lang.String) r2
        L_0x0219:
            r0.putString(r8, r2)
            java.util.ArrayList<java.lang.String> r2 = r14.deepLinkList
            if (r2 != 0) goto L_0x0222
            r2 = r7
            goto L_0x0228
        L_0x0222:
            java.lang.Object r2 = r2.get(r4)
            java.lang.String r2 = (java.lang.String) r2
        L_0x0228:
            java.lang.String r4 = "5cta_4_"
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r2)
            r0.putString(r6, r2)
            android.widget.RemoteViews r2 = r12.remoteView
            int r4 = com.clevertap.android.pushtemplates.R$id.cta4
            android.app.PendingIntent r0 = co.hyperverge.hypersnapsdk.c.k.getLaunchPendingIntent(r0, r13)
            r2.setOnClickPendingIntent(r4, r0)
        L_0x023c:
            java.util.ArrayList<java.lang.String> r0 = r14.deepLinkList
            if (r0 == 0) goto L_0x0283
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.size()
            if (r0 <= r3) goto L_0x0283
            java.lang.Object r0 = r15.clone()
            android.os.Bundle r0 = (android.os.Bundle) r0
            java.lang.String r2 = "cta5"
            r0.putBoolean(r2, r1)
            java.util.ArrayList<java.lang.String> r1 = r14.deepLinkList
            if (r1 != 0) goto L_0x025a
            r1 = r7
            goto L_0x0260
        L_0x025a:
            java.lang.Object r1 = r1.get(r3)
            java.lang.String r1 = (java.lang.String) r1
        L_0x0260:
            r0.putString(r8, r1)
            java.util.ArrayList<java.lang.String> r1 = r14.deepLinkList
            if (r1 != 0) goto L_0x0268
            goto L_0x026f
        L_0x0268:
            java.lang.Object r1 = r1.get(r3)
            r7 = r1
            java.lang.String r7 = (java.lang.String) r7
        L_0x026f:
            java.lang.String r1 = "5cta_5_"
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r7)
            r0.putString(r6, r1)
            android.widget.RemoteViews r1 = r12.remoteView
            int r2 = com.clevertap.android.pushtemplates.R$id.cta5
            android.app.PendingIntent r0 = co.hyperverge.hypersnapsdk.c.k.getLaunchPendingIntent(r0, r13)
            r1.setOnClickPendingIntent(r2, r0)
        L_0x0283:
            android.widget.RemoteViews r0 = r12.remoteView
            int r1 = com.clevertap.android.pushtemplates.R$id.close
            int r7 = r14.notificationId
            r9 = 0
            r10 = 19
            r6 = r13
            r8 = r15
            r11 = r14
            android.app.PendingIntent r13 = com.clevertap.android.pushtemplates.content.PendingIntentFactory.getPendingIntent(r6, r7, r8, r9, r10, r11)
            r0.setOnClickPendingIntent(r1, r13)
            int r13 = r12.imageCounter
            if (r13 <= r5) goto L_0x029f
            java.lang.String r13 = "More than 2 images were not retrieved in 5CTA Notification, not displaying Notification."
            co.hyperverge.hypersnapsdk.c.k.debug(r13)
        L_0x029f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.pushtemplates.content.FiveIconBigContentView.<init>(android.content.Context, com.clevertap.android.pushtemplates.TemplateRenderer, android.os.Bundle):void");
    }
}
