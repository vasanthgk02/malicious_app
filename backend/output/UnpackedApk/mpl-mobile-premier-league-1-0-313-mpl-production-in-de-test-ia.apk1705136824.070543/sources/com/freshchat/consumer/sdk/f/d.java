package com.freshchat.consumer.sdk.f;

import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

public abstract class d extends OnScrollListener {
    public abstract void iD();

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r3, int r4, int r5) {
        /*
            r2 = this;
            super.onScrolled(r3, r4, r5)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r3.getLayoutManager()
            if (r3 != 0) goto L_0x000a
            return
        L_0x000a:
            int r4 = r3.getChildCount()
            int r5 = r3.getItemCount()
            r0 = 0
            boolean r1 = r3 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r1 == 0) goto L_0x001e
            androidx.recyclerview.widget.GridLayoutManager r3 = (androidx.recyclerview.widget.GridLayoutManager) r3
        L_0x0019:
            int r0 = r3.findFirstVisibleItemPosition()
            goto L_0x0025
        L_0x001e:
            boolean r1 = r3 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r1 == 0) goto L_0x0025
            androidx.recyclerview.widget.LinearLayoutManager r3 = (androidx.recyclerview.widget.LinearLayoutManager) r3
            goto L_0x0019
        L_0x0025:
            int r4 = r4 + r0
            if (r4 < r5) goto L_0x002b
            r2.iD()
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.f.d.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }
}
