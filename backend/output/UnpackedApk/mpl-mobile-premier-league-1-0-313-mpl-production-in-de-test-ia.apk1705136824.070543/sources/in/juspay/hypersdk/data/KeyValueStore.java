package in.juspay.hypersdk.data;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import in.juspay.hypersdk.core.JuspayCoreLib;
import in.juspay.hypersdk.core.JuspayServices;
import java.util.Map;

public final class KeyValueStore {
    public static boolean contains(Context context, String str, String str2) {
        if (context != null) {
            return context.getSharedPreferences(str, 0).contains(str2);
        }
        return false;
    }

    public static boolean contains(JuspayServices juspayServices, String str) {
        return contains(juspayServices.getContext(), juspayServices.getSdkInfo().getSdkName(), str);
    }

    public static Map<String, ?> getAll(Context context, String str) {
        if (context != null) {
            return context.getSharedPreferences(str, 0).getAll();
        }
        return null;
    }

    public static Map<String, ?> getAll(JuspayServices juspayServices) {
        return getAll(juspayServices.getContext(), juspayServices.getSdkInfo().getSdkName());
    }

    public static String read(Context context, String str, String str2, String str3) {
        return context != null ? context.getSharedPreferences(str, 0).getString(str2, str3) : str3;
    }

    public static String read(JuspayServices juspayServices, String str, String str2) {
        return read(juspayServices.getContext(), juspayServices.getSdkInfo().getSdkName(), str, str2);
    }

    public static void remove(Context context, String str, String str2) {
        remove(context, str, str2, false);
    }

    public static void remove(Context context, String str, String str2, boolean z) {
        if (contains(context, str, str2)) {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.remove(str2);
            if (z) {
                edit.commit();
            } else {
                edit.apply();
            }
        }
    }

    public static void remove(JuspayServices juspayServices, String str) {
        remove(juspayServices.getContext(), juspayServices.getSdkInfo().getSdkName(), str);
    }

    public static void remove(String str, String str2) {
        remove(str, str2, false);
    }

    public static void remove(String str, String str2, boolean z) {
        JuspayCoreLib.getApplicationContext();
    }

    public static void write(Context context, String str, String str2, String str3) {
        write(context, str, str2, str3, false);
    }

    public static void write(Context context, String str, String str2, String str3, boolean z) {
        if (context != null) {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            if (z) {
                edit.commit();
            } else {
                edit.apply();
            }
        }
    }

    public static void write(JuspayServices juspayServices, String str, String str2) {
        write(juspayServices.getContext(), juspayServices.getSdkInfo().getSdkName(), str, str2);
    }
}
