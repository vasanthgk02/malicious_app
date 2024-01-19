package io.hansel.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.PaymentConstants.ENVIRONMENT;

public class HSLBuildConfig {
    public static boolean AUTO_MASK_ALL_TEXTFIELDS = true;
    public static final boolean BUILD_T_P = true;
    public static final String DIL_SERVER_URL = "https://dil.hansel.io";
    public static final String EXP_SERVER_URL = "https://experience.hansel.io";
    public static final String LOC_SERVER_URL = "https://experience.hansel.io";
    public static final String SDK_VERSION = "8.7.9";
    public static final String SERVER_BASE_URL = "https://sdk.hansel.io";
    public static final String SERVER_SOCKET_URL = "wss://websocket-visualizer.hansel.io";
    public static final String SP_NAME = "_HANSELC_CONFIG";
    public static final String TG_AUTH_SERVER_URL = "https://sdk.hansel.io";
    public static final String TRACKER_SERVER_URL = "https://dil.hansel.io";
    public static final String UJM_ADD_EVENT = "https://sdk.hansel.io";
    public static final String UJM_GET_DATA_URL = "https://ujm.hansel.io";

    public static String getDILServerUrl(Context context) {
        return (!BUILD_T_P && !ENVIRONMENT.PRODUCTION.equals(getSharedPreferences(context).getString("SNAME", ENVIRONMENT.PRODUCTION))) ? getServerURL(context, "SNAME") : "https://dil.hansel.io";
    }

    public static String getExpServerUrl(Context context) {
        return (!BUILD_T_P && !ENVIRONMENT.PRODUCTION.equals(getSharedPreferences(context).getString("SNAME", ENVIRONMENT.PRODUCTION))) ? getServerURL(context, "SNAME") : "https://experience.hansel.io";
    }

    public static String getLocServerUrl(Context context) {
        return (!BUILD_T_P && !ENVIRONMENT.PRODUCTION.equals(getSharedPreferences(context).getString("SNAME", ENVIRONMENT.PRODUCTION))) ? getServerURL(context, "SNAME") : "https://experience.hansel.io";
    }

    public static String getServerBaseUrl(Context context) {
        return (!BUILD_T_P && !ENVIRONMENT.PRODUCTION.equals(getSharedPreferences(context).getString("SNAME", ENVIRONMENT.PRODUCTION))) ? getServerURL(context, "SNAME") : "https://sdk.hansel.io";
    }

    public static String getServerSocketUrl(Context context) {
        return (!BUILD_T_P && !ENVIRONMENT.PRODUCTION.equals(getSharedPreferences(context).getString("SNAME", ENVIRONMENT.PRODUCTION))) ? "wss://staging-websocket.hansel.io" : SERVER_SOCKET_URL;
    }

    public static String getServerURL(Context context, String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("https://");
        outline73.append(getSharedPreferences(context).getString(str, "diltest"));
        outline73.append(".hansel.io");
        return outline73.toString();
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SP_NAME, 0);
    }

    public static String getTgAuthServerUrl(Context context) {
        return (!BUILD_T_P && !ENVIRONMENT.PRODUCTION.equals(getSharedPreferences(context).getString("SNAME", ENVIRONMENT.PRODUCTION))) ? getServerURL(context, "SNAME") : "https://sdk.hansel.io";
    }

    public static String getTrackerServerUrl(Context context) {
        return (!BUILD_T_P && !ENVIRONMENT.PRODUCTION.equals(getSharedPreferences(context).getString("SNAME", ENVIRONMENT.PRODUCTION))) ? getServerURL(context, "SNAME") : "https://dil.hansel.io";
    }

    public static String getUJMServerUrl(Context context) {
        return (!BUILD_T_P && !ENVIRONMENT.PRODUCTION.equals(getSharedPreferences(context).getString("SNAME", ENVIRONMENT.PRODUCTION))) ? getServerURL(context, "SNAME") : UJM_GET_DATA_URL;
    }

    public static String getUjmAddEvent(Context context) {
        return (!BUILD_T_P && !ENVIRONMENT.PRODUCTION.equals(getSharedPreferences(context).getString("SNAME", ENVIRONMENT.PRODUCTION))) ? getServerURL(context, "SNAME") : "https://sdk.hansel.io";
    }

    public static boolean isProdBuild() {
        return BUILD_T_P;
    }

    public static final boolean shouldMaskThisViewType(View view) {
        return AUTO_MASK_ALL_TEXTFIELDS && (view instanceof EditText);
    }
}
