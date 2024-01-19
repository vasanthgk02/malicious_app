package com.freshchat.consumer.sdk.j;

import com.android.tools.r8.GeneratedOutlineSupport;

public class cy {
    public static String a(long j, int i) {
        return "bot_" + j + "_" + i;
    }

    public static String aS(String str) {
        return GeneratedOutlineSupport.outline50("toDisplay_", str);
    }

    public static boolean aT(String str) {
        if (as.isEmpty(str)) {
            return false;
        }
        return str.startsWith("toDisplay_");
    }

    public static boolean aU(String str) {
        if (as.isEmpty(str)) {
            return false;
        }
        return str.startsWith("userReplyToBot_");
    }

    public static long aV(String str) {
        if (!as.isEmpty(str) && aU(str)) {
            try {
                return Long.parseLong(str.split("_")[1]);
            } catch (Exception e2) {
                q.a(e2);
            }
        }
        return 0;
    }

    public static int aW(String str) {
        if (!as.isEmpty(str) && aU(str)) {
            try {
                return Integer.parseInt(str.split("_")[2]);
            } catch (Exception e2) {
                q.a(e2);
            }
        }
        return 0;
    }

    public static String b(long j, int i) {
        return "userReplyToBot_" + j + "_" + i;
    }
}
