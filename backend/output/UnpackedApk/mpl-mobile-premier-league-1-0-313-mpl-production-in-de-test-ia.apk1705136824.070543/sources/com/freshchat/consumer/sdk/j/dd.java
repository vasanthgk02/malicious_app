package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.freshchat.consumer.sdk.a.y;

public class dd {
    public final Context context;
    public y sU;
    public final int sV = MeasureSpec.makeMeasureSpec(0, 0);
    public final int sW = MeasureSpec.makeMeasureSpec(0, 0);
    public final ViewGroup sX;

    public dd(Context context2, y yVar) {
        this.context = context2;
        this.sU = yVar;
        this.sX = new LinearLayout(context2);
    }

    public int ae(int i) {
        if (!p.aD(this.context)) {
            return 25;
        }
        return -(i - 95);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int ku() {
        /*
            r7 = this;
            android.content.Context r0 = r7.context
            int r0 = com.freshchat.consumer.sdk.j.p.cr(r0)
            com.freshchat.consumer.sdk.a.y r1 = r7.sU
            r2 = -2
            if (r1 == 0) goto L_0x005f
            r1 = 1
            r3 = 4603759683083215831(0x3fe3d70a3d70a3d7, double:0.62)
            r5 = 0
            r6 = 2
            if (r0 != r1) goto L_0x0023
            android.content.Context r0 = r7.context     // Catch:{ Exception -> 0x0021 }
            int r0 = com.freshchat.consumer.sdk.j.p.as(r0)     // Catch:{ Exception -> 0x0021 }
        L_0x001b:
            int r0 = r0 / r6
            double r0 = (double) r0     // Catch:{ Exception -> 0x0021 }
            double r0 = r0 * r3
            int r0 = (int) r0     // Catch:{ Exception -> 0x0021 }
            goto L_0x002d
        L_0x0021:
            r0 = move-exception
            goto L_0x004f
        L_0x0023:
            if (r0 != r6) goto L_0x002c
            android.content.Context r0 = r7.context     // Catch:{ Exception -> 0x0021 }
            int r0 = com.freshchat.consumer.sdk.j.p.ar(r0)     // Catch:{ Exception -> 0x0021 }
            goto L_0x001b
        L_0x002c:
            r0 = 0
        L_0x002d:
            r1 = 0
            com.freshchat.consumer.sdk.a.y r3 = r7.sU     // Catch:{ Exception -> 0x0021 }
            android.view.ViewGroup r4 = r7.sX     // Catch:{ Exception -> 0x0021 }
            android.view.View r1 = r3.getView(r5, r1, r4)     // Catch:{ Exception -> 0x0021 }
            int r3 = r7.sV     // Catch:{ Exception -> 0x0021 }
            int r4 = r7.sW     // Catch:{ Exception -> 0x0021 }
            r1.measure(r3, r4)     // Catch:{ Exception -> 0x0021 }
            com.freshchat.consumer.sdk.a.y r3 = r7.sU     // Catch:{ Exception -> 0x0021 }
            java.util.List<java.lang.String> r3 = r3.su     // Catch:{ Exception -> 0x0021 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x0021 }
            int r1 = r1.getMeasuredHeight()     // Catch:{ Exception -> 0x0021 }
            int r1 = r1 * r3
            if (r1 <= r0) goto L_0x004e
            return r0
        L_0x004e:
            return r1
        L_0x004f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Error with calculating quick action slash command window height: "
            r1.append(r3)
            r1.append(r0)
            r1.toString()
        L_0x005f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.dd.ku():int");
    }

    public int kv() {
        return p.cr(this.context) == 1 ? p.ar(this.context) - 66 : (int) (((double) p.ar(this.context)) - (((double) p.ar(this.context)) * 0.2d));
    }
}
