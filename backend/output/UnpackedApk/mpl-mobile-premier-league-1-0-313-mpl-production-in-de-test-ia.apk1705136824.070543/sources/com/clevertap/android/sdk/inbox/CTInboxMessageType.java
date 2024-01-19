package com.clevertap.android.sdk.inbox;

import com.netcore.android.notification.SMTNotificationConstants;

public enum CTInboxMessageType {
    SimpleMessage("simple"),
    IconMessage("message-icon"),
    CarouselMessage(SMTNotificationConstants.NOTIF_CAROUSEL_KEY),
    CarouselImageMessage("carousel-image");
    
    public final String inboxMessageType;

    /* access modifiers changed from: public */
    CTInboxMessageType(String str) {
        this.inboxMessageType = str;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.clevertap.android.sdk.inbox.CTInboxMessageType fromString(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1799711058: goto L_0x0029;
                case -1332589953: goto L_0x001f;
                case -902286926: goto L_0x0015;
                case 2908512: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0033
        L_0x000b:
            java.lang.String r0 = "carousel"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0033
            r4 = 2
            goto L_0x0034
        L_0x0015:
            java.lang.String r0 = "simple"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0033
            r4 = 0
            goto L_0x0034
        L_0x001f:
            java.lang.String r0 = "message-icon"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0033
            r4 = 1
            goto L_0x0034
        L_0x0029:
            java.lang.String r0 = "carousel-image"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0033
            r4 = 3
            goto L_0x0034
        L_0x0033:
            r4 = -1
        L_0x0034:
            if (r4 == 0) goto L_0x0047
            if (r4 == r3) goto L_0x0044
            if (r4 == r2) goto L_0x0041
            if (r4 == r1) goto L_0x003e
            r4 = 0
            return r4
        L_0x003e:
            com.clevertap.android.sdk.inbox.CTInboxMessageType r4 = CarouselImageMessage
            return r4
        L_0x0041:
            com.clevertap.android.sdk.inbox.CTInboxMessageType r4 = CarouselMessage
            return r4
        L_0x0044:
            com.clevertap.android.sdk.inbox.CTInboxMessageType r4 = IconMessage
            return r4
        L_0x0047:
            com.clevertap.android.sdk.inbox.CTInboxMessageType r4 = SimpleMessage
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inbox.CTInboxMessageType.fromString(java.lang.String):com.clevertap.android.sdk.inbox.CTInboxMessageType");
    }

    public String toString() {
        return this.inboxMessageType;
    }
}
