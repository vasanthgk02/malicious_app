package com.freshchat.consumer.sdk.service.d;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.BusinessHours;
import com.freshchat.consumer.sdk.c.p;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.cx;
import com.freshchat.consumer.sdk.j.n;

public class i {
    public static String jR = ";";

    public static boolean A(String str, String str2) {
        long aR = n.aR(str2);
        String[] split = str.split(jR);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i2 >= split.length) {
                return false;
            }
            long parseLong = Long.parseLong(split[i]);
            long parseLong2 = Long.parseLong(split[i2]);
            if (parseLong <= aR && aR <= parseLong2) {
                return true;
            }
            i += 2;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.freshchat.consumer.sdk.beans.BHWeekDays r2, java.lang.String r3, java.lang.String r4) {
        /*
            int r0 = r3.hashCode()
            r1 = 0
            switch(r0) {
                case -2049557543: goto L_0x0045;
                case -1984635600: goto L_0x003b;
                case -1807319568: goto L_0x0031;
                case -897468618: goto L_0x0027;
                case 687309357: goto L_0x001d;
                case 1636699642: goto L_0x0013;
                case 2112549247: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x004f
        L_0x0009:
            java.lang.String r0 = "Friday"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 4
            goto L_0x0050
        L_0x0013:
            java.lang.String r0 = "Thursday"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 3
            goto L_0x0050
        L_0x001d:
            java.lang.String r0 = "Tuesday"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 1
            goto L_0x0050
        L_0x0027:
            java.lang.String r0 = "Wednesday"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 2
            goto L_0x0050
        L_0x0031:
            java.lang.String r0 = "Sunday"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 6
            goto L_0x0050
        L_0x003b:
            java.lang.String r0 = "Monday"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 0
            goto L_0x0050
        L_0x0045:
            java.lang.String r0 = "Saturday"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 5
            goto L_0x0050
        L_0x004f:
            r3 = -1
        L_0x0050:
            switch(r3) {
                case 0: goto L_0x0073;
                case 1: goto L_0x006e;
                case 2: goto L_0x0069;
                case 3: goto L_0x0064;
                case 4: goto L_0x005f;
                case 5: goto L_0x005a;
                case 6: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            r2 = 0
            goto L_0x0077
        L_0x0055:
            java.lang.String r2 = r2.getDaySixTimings()
            goto L_0x0077
        L_0x005a:
            java.lang.String r2 = r2.getDayFiveTimings()
            goto L_0x0077
        L_0x005f:
            java.lang.String r2 = r2.getDayFourTimings()
            goto L_0x0077
        L_0x0064:
            java.lang.String r2 = r2.getDayThreeTimings()
            goto L_0x0077
        L_0x0069:
            java.lang.String r2 = r2.getDayTwoTimings()
            goto L_0x0077
        L_0x006e:
            java.lang.String r2 = r2.getDayOneTimings()
            goto L_0x0077
        L_0x0073:
            java.lang.String r2 = r2.getDayZeroTimings()
        L_0x0077:
            boolean r3 = com.freshchat.consumer.sdk.j.as.isEmpty(r2)
            if (r3 == 0) goto L_0x007e
            return r1
        L_0x007e:
            boolean r2 = A(r2, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.service.d.i.a(com.freshchat.consumer.sdk.beans.BHWeekDays, java.lang.String, java.lang.String):boolean");
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.freshchat.consumer.sdk.beans.BHWorkingDays r2, java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 0
            switch(r0) {
                case -2049557543: goto L_0x0045;
                case -1984635600: goto L_0x003b;
                case -1807319568: goto L_0x0031;
                case -897468618: goto L_0x0027;
                case 687309357: goto L_0x001d;
                case 1636699642: goto L_0x0013;
                case 2112549247: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x004f
        L_0x0009:
            java.lang.String r0 = "Friday"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 4
            goto L_0x0050
        L_0x0013:
            java.lang.String r0 = "Thursday"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 3
            goto L_0x0050
        L_0x001d:
            java.lang.String r0 = "Tuesday"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 1
            goto L_0x0050
        L_0x0027:
            java.lang.String r0 = "Wednesday"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 2
            goto L_0x0050
        L_0x0031:
            java.lang.String r0 = "Sunday"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 6
            goto L_0x0050
        L_0x003b:
            java.lang.String r0 = "Monday"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 0
            goto L_0x0050
        L_0x0045:
            java.lang.String r0 = "Saturday"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 5
            goto L_0x0050
        L_0x004f:
            r3 = -1
        L_0x0050:
            switch(r3) {
                case 0: goto L_0x0072;
                case 1: goto L_0x006d;
                case 2: goto L_0x0068;
                case 3: goto L_0x0063;
                case 4: goto L_0x005e;
                case 5: goto L_0x0059;
                case 6: goto L_0x0054;
                default: goto L_0x0053;
            }
        L_0x0053:
            return r1
        L_0x0054:
            boolean r2 = r2.isWorkingOnDaySix()
            return r2
        L_0x0059:
            boolean r2 = r2.isWorkingOnDayFive()
            return r2
        L_0x005e:
            boolean r2 = r2.isWorkingOnDayFour()
            return r2
        L_0x0063:
            boolean r2 = r2.isWorkingOnDayThree()
            return r2
        L_0x0068:
            boolean r2 = r2.isWorkingOnDayTwo()
            return r2
        L_0x006d:
            boolean r2 = r2.isWorkingOnDayOne()
            return r2
        L_0x0072:
            boolean r2 = r2.isWorkingOnDayZero()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.service.d.i.a(com.freshchat.consumer.sdk.beans.BHWorkingDays, java.lang.String):boolean");
    }

    public static boolean aP(String str) {
        if (as.isEmpty(str)) {
            return false;
        }
        return cx.gA().contains(str);
    }

    public static boolean r(Context context, long j) {
        p pVar = new p(context);
        BusinessHours D = j != 0 ? pVar.D(j) : null;
        if (D == null) {
            D = pVar.fm();
        }
        if (D == null) {
            return false;
        }
        String aQ = n.aQ(D.getTimezone());
        if (!aP(aQ)) {
            ai.i("FRESHCHAT", "BusinessHoursHelper: Invalid day fo the week. isOffline false");
            return false;
        } else if (!a(D.getWorkingDays(), aQ)) {
            return true;
        } else {
            return !a(D.getWeekDaysBH(), aQ, D.getTimezone());
        }
    }
}
