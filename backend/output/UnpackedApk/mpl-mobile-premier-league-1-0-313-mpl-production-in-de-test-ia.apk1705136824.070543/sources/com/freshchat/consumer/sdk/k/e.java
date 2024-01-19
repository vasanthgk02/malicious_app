package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;

public class e extends a {
    public QuickReplyButtonFragment ns;

    public enum a {
        OPTION,
        MESSAGE
    }

    public e(Context context) {
        super(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (com.freshchat.consumer.sdk.j.as.a(r0) != false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (com.freshchat.consumer.sdk.j.as.a(r2) != false) goto L_0x0027;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(com.freshchat.consumer.sdk.k.e.a r5) {
        /*
            r4 = this;
            com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment r0 = r4.ns
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0007
            return r1
        L_0x0007:
            java.lang.String r0 = r0.getCustomReplyText()
            com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment r2 = r4.ns
            java.lang.String r2 = r2.getLabel()
            int[] r3 = com.freshchat.consumer.sdk.k.f.nt
            int r5 = r5.ordinal()
            r5 = r3[r5]
            r3 = 1
            if (r5 == r3) goto L_0x0029
            r3 = 2
            if (r5 == r3) goto L_0x0021
            r0 = r1
            goto L_0x002f
        L_0x0021:
            boolean r5 = com.freshchat.consumer.sdk.j.as.a(r2)
            if (r5 == 0) goto L_0x002f
        L_0x0027:
            r0 = r2
            goto L_0x002f
        L_0x0029:
            boolean r5 = com.freshchat.consumer.sdk.j.as.a(r0)
            if (r5 == 0) goto L_0x0027
        L_0x002f:
            boolean r5 = com.freshchat.consumer.sdk.j.as.isEmpty(r0)
            if (r5 == 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r1 = r0
        L_0x0037:
            java.lang.String r5 = r1.trim()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.k.e.a(com.freshchat.consumer.sdk.k.e$a):java.lang.String");
    }

    public void b(QuickReplyButtonFragment quickReplyButtonFragment) {
        this.ns = quickReplyButtonFragment;
    }

    public String hb() {
        return a(a.MESSAGE);
    }

    public String jL() {
        return a(a.OPTION);
    }
}
