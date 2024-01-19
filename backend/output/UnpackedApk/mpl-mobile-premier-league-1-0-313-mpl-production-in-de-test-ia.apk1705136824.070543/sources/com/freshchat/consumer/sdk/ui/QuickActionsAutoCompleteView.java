package com.freshchat.consumer.sdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

public class QuickActionsAutoCompleteView extends AppCompatAutoCompleteTextView {
    public QuickActionsAutoCompleteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QuickActionsAutoCompleteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0083, code lost:
        if (r0 > r6) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0086, code lost:
        setDropDownHeight(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0096, code lost:
        if (r0 > r6) goto L_0x007f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showDropDown() {
        /*
            r10 = this;
            android.view.View r0 = r10.getRootView()
            int r1 = com.freshchat.consumer.sdk.R.id.freshchat_message_container
            android.view.View r0 = r0.findViewById(r1)
            android.view.View r1 = r10.getRootView()
            int r2 = com.freshchat.consumer.sdk.R.id.freshchat_quick_actions_button_layout
            android.view.View r1 = r1.findViewById(r2)
            android.view.View r2 = r10.getRootView()
            int r3 = com.freshchat.consumer.sdk.R.id.freshchat_conv_detail_text_reply_layout
            android.view.View r2 = r2.findViewById(r3)
            r3 = 0
            if (r0 == 0) goto L_0x0026
            int r0 = r0.getHeight()
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            int r4 = com.freshchat.consumer.sdk.R.id.freshchat_conv_detail_attach_image
            r10.setDropDownAnchor(r4)
            r10.setDropDownVerticalOffset(r3)
            android.content.Context r4 = r10.getContext()
            int r4 = com.freshchat.consumer.sdk.b.i.cb(r4)
            android.widget.ListAdapter r5 = r10.getAdapter()
            com.freshchat.consumer.sdk.a.y r5 = (com.freshchat.consumer.sdk.a.y) r5
            java.util.List<java.lang.String> r5 = r5.su
            int r5 = r5.size()
            android.content.Context r6 = r10.getContext()
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.freshchat.consumer.sdk.R.dimen.freshchat_min_size_for_slash_command_item
            int r6 = r6.getDimensionPixelSize(r7)
            r7 = 2
            r8 = 1
            if (r1 == 0) goto L_0x00b6
            boolean r9 = com.freshchat.consumer.sdk.b.i.f(r1)
            if (r9 == 0) goto L_0x00b6
            int r1 = r1.getHeight()
            if (r2 == 0) goto L_0x0066
            int r2 = r2.getHeight()
            goto L_0x0067
        L_0x0066:
            r2 = 0
        L_0x0067:
            int r1 = r1 + r2
            r9 = -2
            if (r0 >= r1) goto L_0x008a
            int r3 = com.freshchat.consumer.sdk.R.id.freshchat_quick_actions_button_layout
            r10.setDropDownAnchor(r3)
            int r2 = -r2
            r10.setDropDownVerticalOffset(r2)
            android.content.Context r2 = r10.getContext()
            int r2 = com.freshchat.consumer.sdk.j.p.cr(r2)
            if (r2 != r7) goto L_0x0083
            int r0 = r0 + r4
        L_0x007f:
            r10.setDropDownHeight(r0)
            goto L_0x00a1
        L_0x0083:
            if (r0 <= r6) goto L_0x0086
        L_0x0085:
            goto L_0x007f
        L_0x0086:
            r10.setDropDownHeight(r6)
            goto L_0x00a1
        L_0x008a:
            int r2 = r10.getDropDownHeight()
            if (r2 == r9) goto L_0x0099
            int r2 = r10.getDropDownHeight()
            if (r2 <= r0) goto L_0x0099
            if (r0 <= r6) goto L_0x0086
            goto L_0x0085
        L_0x0099:
            int r0 = com.freshchat.consumer.sdk.R.id.freshchat_conv_detail_attach_image
            r10.setDropDownAnchor(r0)
            r10.setDropDownVerticalOffset(r3)
        L_0x00a1:
            if (r5 > r8) goto L_0x00cc
            r10.setDropDownHeight(r9)
            int r0 = com.freshchat.consumer.sdk.R.id.freshchat_quick_actions_button_layout
            r10.setDropDownAnchor(r0)
            double r0 = (double) r1
            r2 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            double r0 = r0 * r2
            double r0 = -r0
            int r0 = (int) r0
            r10.setDropDownVerticalOffset(r0)
            goto L_0x00cc
        L_0x00b6:
            if (r5 <= r8) goto L_0x00cc
            if (r0 < r6) goto L_0x00c8
            android.content.Context r1 = r10.getContext()
            int r1 = com.freshchat.consumer.sdk.j.p.cr(r1)
            if (r1 != r7) goto L_0x00cc
            int r6 = r6 * r5
            if (r0 >= r6) goto L_0x00cc
        L_0x00c8:
            int r0 = r0 + r4
            r10.setDropDownHeight(r0)
        L_0x00cc:
            super.showDropDown()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.ui.QuickActionsAutoCompleteView.showDropDown():void");
    }
}
