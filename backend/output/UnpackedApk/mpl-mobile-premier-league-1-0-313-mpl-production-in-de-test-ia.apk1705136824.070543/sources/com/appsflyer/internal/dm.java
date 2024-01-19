package com.appsflyer.internal;

import sfs2x.client.entities.invitation.InvitationReply;

public final class dm {
    public static int AFInAppEventParameterName;
    public static int AFKeystoreWrapper;
    public static final Object valueOf = new Object();
    public static int values;

    public static int AFInAppEventParameterName(int i) {
        dj djVar = dj.valueOf;
        int i2 = i >>> 24;
        int i3 = (i >>> 16) & InvitationReply.EXPIRED;
        int i4 = (i >>> 8) & InvitationReply.EXPIRED;
        int i5 = i & InvitationReply.EXPIRED;
        int[][] iArr = djVar.AFInAppEventType;
        return ((iArr[0][i2] + iArr[1][i3]) ^ iArr[2][i4]) + iArr[3][i5];
    }

    public static void values(int[] iArr) {
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
        }
    }
}
