package com.appsflyer.internal;

import android.util.TypedValue;
import android.view.KeyEvent;
import android.widget.ExpandableListView;

public final class bw {
    public static int AFInAppEventParameterName = 1;
    public static char[] AFInAppEventType = {'3', 39097, 12579, 51629, 25115, 64132, 37643, 11248, 50275, 23779, 62803, 36311, 9802, 48950, 22456, 61476, 34962, 8476, 47488, 21003, 60154, 33643, 7144, 46174, 19652, 58698, 32304, 5834, 44846, 18321, 57369, 30855, 4470, 43516, 16993, 56042, 29534, 2995, 42057, 15665, 54694, 28255, 1681, 40815, 14223, 53363, 26879, 354, 39383, 12894, 51911, 25417, 64575, 38053, 11566, 50583, 24071, 63227, 36726, 10235, 49260, 22737, 61790, 35255};
    public static int valueOf;
    public static long values = -3780520048646514550L;

    public static ay AFInAppEventType(ao aoVar, String str, String str2, String str3) {
        String str4;
        boolean z = false;
        if (str == null) {
            if (aoVar.AFKeystoreWrapper == cs.DEFAULT) {
                z = true;
            }
            return new ay(z, cw.NA);
        }
        String intern = values((char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 64, ExpandableListView.getPackedPositionType(0)).intern();
        if (aoVar.AFKeystoreWrapper == cs.CUSTOM) {
            str4 = new StringBuilder(str2).reverse().toString();
        } else {
            str4 = "";
            str3 = intern;
        }
        boolean equals = valueOf(new StringBuilder(str3).reverse().toString(), aoVar.AFInAppEventParameterName, "android", "v1", str4).equals(str);
        return new ay(equals, equals ? cw.SUCCESS : cw.FAILURE);
    }

    public static String valueOf(String str, String str2, String str3, String str4, String str5) {
        int i = AFInAppEventParameterName + 93;
        valueOf = i % 128;
        int i2 = i % 2;
        String valueOf2 = ag.valueOf(ag.AFInAppEventParameterName(str2, str3, str4, str5, ""), str);
        if (valueOf2.length() >= 12) {
            return valueOf2.substring(0, 12);
        }
        int i3 = valueOf + 123;
        AFInAppEventParameterName = i3 % 128;
        int i4 = i3 % 2;
        return valueOf2;
    }

    public static String values(char c2, int i, int i2) {
        String str;
        synchronized (dh.AFInAppEventParameterName) {
            char[] cArr = new char[i];
            dh.values = 0;
            while (dh.values < i) {
                cArr[dh.values] = (char) ((int) ((((long) AFInAppEventType[dh.values + i2]) ^ (((long) dh.values) * values)) ^ ((long) c2)));
                dh.values++;
            }
            str = new String(cArr);
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.ay AFKeystoreWrapper(com.appsflyer.internal.ao r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            int r0 = AFInAppEventParameterName
            int r0 = r0 + 55
            int r1 = r0 % 128
            valueOf = r1
            int r0 = r0 % 2
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L_0x0010
            r2 = 0
            goto L_0x0011
        L_0x0010:
            r2 = 1
        L_0x0011:
            if (r2 == r1) goto L_0x003b
            int r2 = valueOf
            int r2 = r2 + 27
            int r3 = r2 % 128
            AFInAppEventParameterName = r3
            int r2 = r2 % 2
            if (r7 == 0) goto L_0x0021
            r2 = 1
            goto L_0x0022
        L_0x0021:
            r2 = 0
        L_0x0022:
            if (r2 == r1) goto L_0x0025
            goto L_0x003b
        L_0x0025:
            r2 = 89
            if (r8 == 0) goto L_0x002c
            r3 = 89
            goto L_0x002e
        L_0x002c:
            r3 = 37
        L_0x002e:
            if (r3 == r2) goto L_0x0031
            goto L_0x003b
        L_0x0031:
            int r2 = valueOf
            int r2 = r2 + r1
            int r3 = r2 % 128
            AFInAppEventParameterName = r3
            int r2 = r2 % 2
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            if (r1 != 0) goto L_0x0046
            com.appsflyer.internal.ay r5 = new com.appsflyer.internal.ay
            com.appsflyer.internal.cw r6 = com.appsflyer.internal.cw.INTERNAL_ERROR
            r5.<init>(r0, r6)
            return r5
        L_0x0046:
            com.appsflyer.internal.ay r5 = AFInAppEventType(r5, r6, r7, r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.bw.AFKeystoreWrapper(com.appsflyer.internal.ao, java.lang.String, java.lang.String, java.lang.String):com.appsflyer.internal.ay");
    }
}
