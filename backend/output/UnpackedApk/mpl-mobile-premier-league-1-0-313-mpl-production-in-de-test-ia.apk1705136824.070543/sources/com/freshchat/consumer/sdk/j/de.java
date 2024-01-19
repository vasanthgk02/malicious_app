package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

public class de {
    public final Context context;
    public final ViewGroup sX;
    public final ListAdapter sY;
    public final int sZ = MeasureSpec.makeMeasureSpec(0, 0);

    public de(Context context2, ListAdapter listAdapter) {
        this.context = context2;
        this.sY = listAdapter;
        this.sX = new LinearLayout(context2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int af(int r6) {
        /*
            r5 = this;
            android.widget.ListAdapter r0 = r5.sY
            if (r0 == 0) goto L_0x004d
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x004d
            android.widget.ListAdapter r0 = r5.sY
            android.view.ViewGroup r1 = r5.sX
            r2 = 0
            r3 = 0
            android.view.View r0 = r0.getView(r2, r3, r1)
            int r1 = r5.sZ
            r0.measure(r1, r1)
            android.widget.ListAdapter r0 = r5.sY
            int r0 = r0.getCount()
            int r0 = r0 * 140
            android.content.Context r1 = r5.context
            int r1 = com.freshchat.consumer.sdk.j.p.cr(r1)
            r3 = 1
            if (r1 != r3) goto L_0x003a
            android.content.Context r1 = r5.context
            int r1 = com.freshchat.consumer.sdk.j.p.as(r1)
            double r1 = (double) r1
            r3 = 4604029899060858061(0x3fe4cccccccccccd, double:0.65)
        L_0x0036:
            double r1 = r1 * r3
            int r2 = (int) r1
            goto L_0x004a
        L_0x003a:
            r3 = 2
            if (r1 != r3) goto L_0x004a
            android.content.Context r1 = r5.context
            int r1 = com.freshchat.consumer.sdk.j.p.as(r1)
            double r1 = (double) r1
            r3 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            goto L_0x0036
        L_0x004a:
            if (r0 <= r2) goto L_0x004d
            return r2
        L_0x004d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.de.af(int):int");
    }

    public int ag(int i) {
        if (p.aD(this.context)) {
            return 20;
        }
        return -(i - 95);
    }

    public int kw() {
        int cr = p.cr(this.context);
        int ar = (int) (((double) p.ar(this.context)) * 0.8d);
        int ar2 = (int) (((double) (cr == 1 ? p.ar(this.context) : p.as(this.context))) * 0.33d);
        if (this.sY != null) {
            View view = null;
            for (int i = 0; i < this.sY.getCount(); i++) {
                view = this.sY.getView(i, view, this.sX);
                int i2 = this.sZ;
                view.measure(i2, i2);
                int measuredWidth = view.getMeasuredWidth();
                if (measuredWidth > ar2) {
                    ar2 = measuredWidth;
                }
            }
        }
        return ar2 < ar ? ar2 : ar;
    }
}
