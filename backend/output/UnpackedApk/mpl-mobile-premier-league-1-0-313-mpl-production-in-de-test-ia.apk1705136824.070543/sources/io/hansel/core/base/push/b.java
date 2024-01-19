package io.hansel.core.base.push;

import android.content.Context;
import android.os.Bundle;
import io.hansel.core.base.task.HSLTaskHandler;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static c f5111a;

    public static void a(Context context, HSLSDKIdentifiers hSLSDKIdentifiers, HSLTaskHandler hSLTaskHandler) {
        if (hSLSDKIdentifiers != null && hSLTaskHandler != null && HSLInternalUtils.getBooleanFromSharedPreferences(context, HSLInternalUtils.KEY_PUSH_TOKEN_NOT_SYNCED)) {
            if (f5111a == null) {
                f5111a = new c(context, hSLSDKIdentifiers, hSLTaskHandler);
            }
            f5111a.e();
        }
    }

    public static void a(Context context, HSLSDKIdentifiers hSLSDKIdentifiers, HSLTaskHandler hSLTaskHandler, String str) {
        if (str == null) {
            HSLLogger.wMin("Passing null token to Hansel#setToken. Hansel push notifications will not work.");
            return;
        }
        if (!HSLInternalUtils.getStringFromSharedPreferences(context, HSLInternalUtils.KEY_PUSH_TOKEN).equals(str)) {
            HSLInternalUtils.setStringInSharedPreferences(context, HSLInternalUtils.KEY_PUSH_TOKEN, str);
            HSLInternalUtils.setBooleanInSharedPreferences(context, HSLInternalUtils.KEY_PUSH_TOKEN_NOT_SYNCED, true);
            HSLLogger.i("Syncing push token with hansel");
            a(context, hSLSDKIdentifiers, hSLTaskHandler);
        }
    }

    public static void a(Context context, String str, Object obj) {
        HSLLogger.i("Received push from hansel");
        long longFromSharedPreferences = HSLInternalUtils.getLongFromSharedPreferences(context, HSLInternalUtils.KEY_LAST_PUSH_REFERENCE_TIME);
        if (str != null) {
            long j = 0;
            try {
                j = Long.parseLong(str.trim());
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
            if (j > longFromSharedPreferences) {
                HSLInternalUtils.setLongInSharedPreferences(context, HSLInternalUtils.KEY_LAST_PUSH_REFERENCE_TIME, j);
                io.hansel.core.b.e().a(obj);
            }
        }
    }

    public static boolean a(Context context, Bundle bundle) {
        if (!a(bundle)) {
            return false;
        }
        a(context, bundle.getString("e_ts"), (Object) bundle);
        return true;
    }

    public static boolean a(Context context, Map<String, String> map) {
        if (!a(map)) {
            return false;
        }
        a(context, map.get("e_ts"), (Object) map);
        return true;
    }

    public static boolean a(Bundle bundle) {
        String string = bundle.getString(HSLPushConstants.HSL_KEY_MTYPE);
        return string != null && a(string);
    }

    public static boolean a(String str) {
        if (str != null) {
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1439834774:
                    if (str.equals(HSLPushConstants.HSL_KEY_EXPR_DC)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1107820548:
                    if (str.equals(HSLPushConstants.HSL_KEY_INV)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1466475759:
                    if (str.equals(HSLPushConstants.HSL_KEY_EXPR_LOC)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1731640828:
                    if (str.equals(HSLPushConstants.HSL_KEY_EXPR)) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            int i = c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? 0 : 6 : 5 : 1 : 4;
            if (i > 0) {
                HSLLogger.i("Push notification came " + i);
                return true;
            }
        }
        return false;
    }

    public static boolean a(Map<String, String> map) {
        String str = map.get(HSLPushConstants.HSL_KEY_MTYPE);
        return str != null && a(str);
    }
}
