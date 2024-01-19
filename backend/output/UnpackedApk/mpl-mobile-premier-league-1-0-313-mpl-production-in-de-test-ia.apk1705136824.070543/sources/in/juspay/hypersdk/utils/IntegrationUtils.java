package in.juspay.hypersdk.utils;

import android.content.Context;
import com.facebook.react.modules.network.NetworkingModule;
import com.xiaomi.mipush.sdk.Constants;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.data.SdkInfo;

public class IntegrationUtils {
    public static String getAppName(Context context) {
        return context.getString(R.string.godel_app_name);
    }

    public static String getGodelBuildVersion(Context context) {
        return getVersion(context, PaymentConstants.GODEL_BUILD_VERSION);
    }

    public static String getGodelVersion(Context context) {
        return getVersion(context, PaymentConstants.GODEL_VERSION);
    }

    public static SdkInfo getSdkInfo(Context context) {
        return new SdkInfo(getAppName(context), getGodelVersion(context), isSdkDebuggable(context), usesLocalAssets(context));
    }

    public static String getSdkVersion(Context context) {
        StringBuilder sb = new StringBuilder(getGodelVersion(context));
        if (context.getResources().getBoolean(context.getResources().getIdentifier("use_rc", "bool", context.getPackageName()))) {
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(getGodelBuildVersion(context));
        }
        return sb.toString();
    }

    public static String getVersion(Context context, String str) {
        return context.getString(context.getResources().getIdentifier(str, NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName()));
    }

    public static boolean isClassPresent(String... strArr) {
        try {
            for (String cls : strArr) {
                Class.forName(cls);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isSdkDebuggable(Context context) {
        return context.getResources().getBoolean(R.bool.godel_debuggable);
    }

    public static boolean usesLocalAssets(Context context) {
        return context.getResources().getBoolean(R.bool.use_local_assets);
    }
}
