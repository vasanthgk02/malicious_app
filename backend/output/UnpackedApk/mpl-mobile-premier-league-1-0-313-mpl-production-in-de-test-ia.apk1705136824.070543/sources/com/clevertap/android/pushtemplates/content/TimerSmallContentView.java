package com.clevertap.android.pushtemplates.content;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\b\u000eJ!\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/clevertap/android/pushtemplates/content/TimerSmallContentView;", "Lcom/clevertap/android/pushtemplates/content/ContentView;", "context", "Landroid/content/Context;", "timer_end", "", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "layoutId", "(Landroid/content/Context;Ljava/lang/Integer;Lcom/clevertap/android/pushtemplates/TemplateRenderer;I)V", "setCustomContentViewChronometerBackgroundColour", "", "pt_bg", "", "setCustomContentViewChronometerBackgroundColour$clevertap_pushtemplates_release", "setCustomContentViewChronometerTitleColour", "pt_chrono_title_clr", "pt_title_clr", "setCustomContentViewChronometerTitleColour$clevertap_pushtemplates_release", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TimerSmallContentView.kt */
public class TimerSmallContentView extends ContentView {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TimerSmallContentView(android.content.Context r8, java.lang.Integer r9, com.clevertap.android.pushtemplates.TemplateRenderer r10, int r11) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "renderer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r7.<init>(r8, r11, r10)
            r7.setCustomContentViewBasicKeys()
            java.lang.String r8 = r10.pt_title
            r7.setCustomContentViewTitle(r8)
            java.lang.String r8 = r10.pt_msg
            r7.setCustomContentViewMessage(r8)
            java.lang.String r8 = r10.pt_bg
            r7.setCustomContentViewCollapsedBackgroundColour(r8)
            java.lang.String r8 = r10.pt_bg
            r11 = 0
            r0 = 1
            if (r8 == 0) goto L_0x003f
            int r1 = r8.length()
            if (r1 <= 0) goto L_0x002d
            r1 = 1
            goto L_0x002e
        L_0x002d:
            r1 = 0
        L_0x002e:
            if (r1 == 0) goto L_0x003f
            android.widget.RemoteViews r1 = r7.remoteView
            int r2 = com.clevertap.android.pushtemplates.R$id.chronometer
            java.lang.String r3 = "#FFFFFF"
            int r8 = co.hyperverge.hypersnapsdk.c.k.getColour(r8, r3)
            java.lang.String r3 = "setBackgroundColor"
            r1.setInt(r2, r3, r8)
        L_0x003f:
            java.lang.String r8 = r10.pt_title_clr
            r7.setCustomContentViewTitleColour(r8)
            java.lang.String r8 = r10.pt_chrono_title_clr
            java.lang.String r1 = r10.pt_title_clr
            java.lang.String r2 = "#000000"
            if (r8 == 0) goto L_0x0063
            int r3 = r8.length()
            if (r3 <= 0) goto L_0x0054
            r3 = 1
            goto L_0x0055
        L_0x0054:
            r3 = 0
        L_0x0055:
            if (r3 == 0) goto L_0x0063
            android.widget.RemoteViews r11 = r7.remoteView
            int r1 = com.clevertap.android.pushtemplates.R$id.chronometer
            int r8 = co.hyperverge.hypersnapsdk.c.k.getColour(r8, r2)
            r11.setTextColor(r1, r8)
            goto L_0x0079
        L_0x0063:
            if (r1 == 0) goto L_0x0079
            int r8 = r1.length()
            if (r8 <= 0) goto L_0x006c
            r11 = 1
        L_0x006c:
            if (r11 == 0) goto L_0x0079
            android.widget.RemoteViews r8 = r7.remoteView
            int r11 = com.clevertap.android.pushtemplates.R$id.chronometer
            int r1 = co.hyperverge.hypersnapsdk.c.k.getColour(r1, r2)
            r8.setTextColor(r11, r1)
        L_0x0079:
            java.lang.String r8 = r10.pt_msg_clr
            r7.setCustomContentViewMessageColour(r8)
            android.widget.RemoteViews r1 = r7.remoteView
            int r2 = com.clevertap.android.pushtemplates.R$id.chronometer
            long r10 = android.os.SystemClock.elapsedRealtime()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            int r8 = r9.intValue()
            long r8 = (long) r8
            long r3 = r10 + r8
            r5 = 0
            r6 = 1
            r1.setChronometer(r2, r3, r5, r6)
            int r8 = android.os.Build.VERSION.SDK_INT
            r9 = 24
            if (r8 < r9) goto L_0x00a2
            android.widget.RemoteViews r8 = r7.remoteView
            int r9 = com.clevertap.android.pushtemplates.R$id.chronometer
            r8.setChronometerCountDown(r9, r0)
        L_0x00a2:
            r7.setCustomContentViewSmallIcon()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.pushtemplates.content.TimerSmallContentView.<init>(android.content.Context, java.lang.Integer, com.clevertap.android.pushtemplates.TemplateRenderer, int):void");
    }
}
