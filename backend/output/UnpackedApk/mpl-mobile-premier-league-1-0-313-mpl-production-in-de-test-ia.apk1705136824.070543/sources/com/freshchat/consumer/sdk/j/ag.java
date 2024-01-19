package com.freshchat.consumer.sdk.j;

import android.content.Intent;
import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Set;

public class ag {
    public static final String TAG = "com.freshchat.consumer.sdk.j.ag";

    public static void a(String str, Intent intent) {
        if (intent != null && intent.getExtras() != null) {
            if (as.isEmpty(str)) {
                str = TAG;
            }
            Bundle extras = intent.getExtras();
            Set<String> keySet = extras.keySet();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("************* Printing Intent (has ");
            outline73.append(keySet.size());
            outline73.append("extras) **********");
            ai.d(str, outline73.toString());
            String action = intent.getAction();
            ai.d(str, "Action : " + action);
            StringBuilder sb = new StringBuilder();
            for (String str2 : keySet) {
                Object obj = extras.get(str2);
                sb.setLength(0);
                sb.append("Name: ");
                sb.append(str2);
                sb.append(", Value: ");
                String str3 = null;
                sb.append(obj != null ? obj.toString() : null);
                sb.append(" (Type: ");
                if (obj != null) {
                    str3 = obj.getClass().getSimpleName();
                }
                sb.append(str3);
                sb.append(" )");
                ai.d(str, sb.toString());
            }
            ai.d(str, "************* Done with intent **************");
        }
    }

    public static String b(Intent intent, String str) {
        return intent.getStringExtra(str);
    }

    public static boolean c(Intent intent, String str) {
        return intent.getBooleanExtra(str, false);
    }

    public static long d(Intent intent, String str) {
        if (intent == null || as.isEmpty(str)) {
            return 0;
        }
        try {
            String stringExtra = intent.getStringExtra(str);
            if (!as.isEmpty(stringExtra)) {
                return Long.valueOf(stringExtra).longValue();
            }
            return 0;
        } catch (Exception e2) {
            ai.e("FRESHCHAT", "Found invalid value for " + str, e2);
            return 0;
        }
    }

    public static int e(Intent intent, String str) {
        if (intent == null || as.isEmpty(str)) {
            return 0;
        }
        try {
            String stringExtra = intent.getStringExtra(str);
            if (!as.isEmpty(stringExtra)) {
                return Integer.valueOf(stringExtra).intValue();
            }
            return 0;
        } catch (Exception e2) {
            ai.e("FRESHCHAT", "Found invalid value for " + str, e2);
            return 0;
        }
    }
}
