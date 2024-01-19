package com.mpl.androidapp.spacemanagment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.MLogger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpaceUtils {
    public static final String INSTALLED_APP_LIST = "appList";
    public static final String INTENT_ALL_MPL_GAMES = "mplGames";
    public static final String INTENT_IS_SINGLE_MPL_GAME = "isSingleMPLGame";
    public static final String INTENT_MPL_GAME = "mplGame";
    public static final String TAG = "GameSpaceManagement";
    public static final String TOT_APPS_SIZE = "totAppSize";
    public static int UNINSTALL_REQUEST_CODE = 11;
    public static long giga = 0;
    public static long kilo = 1024;
    public static long mega;
    public static long tera;

    static {
        long j = 1024 * 1024;
        mega = j;
        long j2 = j * 1024;
        giga = j2;
        tera = j2 * 1024;
    }

    public static long getApkSizeInLong(String str) {
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return (long) (Integer.parseInt(str.replaceAll("[^0-9]", "")) * 1024 * 1024);
                }
            } catch (Exception e2) {
                MLogger.e("GameSpaceManagement", GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("error in getApkSizeInLong ")));
            }
        }
        return 0;
    }

    public static String getSizeInReadable(long j) {
        long j2 = kilo;
        double d2 = ((double) j) / ((double) j2);
        double d3 = d2 / ((double) j2);
        double d4 = d3 / ((double) j2);
        double d5 = d4 / ((double) j2);
        if (j < j2) {
            return j + " Bytes";
        } else if (j < mega) {
            return String.format("%.2f", new Object[]{Double.valueOf(d2)}) + " KB";
        } else if (j < giga) {
            return String.format("%.2f", new Object[]{Double.valueOf(d3)}) + " MB";
        } else if (j < tera) {
            return String.format("%.2f", new Object[]{Double.valueOf(d4)}) + " GB";
        } else {
            return String.format("%.2f", new Object[]{Double.valueOf(d5)}) + " TB";
        }
    }

    public static String toFirstLetterUprCaseAdd(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String toFirstLtrUprCase(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return "Game Name";
        }
        try {
            Matcher matcher = Pattern.compile("\\s+[a-z]").matcher(str);
            StringBuilder sb = new StringBuilder(str.substring(0, 1).toUpperCase());
            int i = 1;
            while (matcher.find()) {
                sb.append(str.substring(i, matcher.end() - 1));
                sb.append(str.substring(matcher.end() - 1, matcher.end()).toUpperCase());
                i = matcher.end();
            }
            sb.append(str.substring(i, str.length()));
            return sb.toString();
        } catch (Exception unused) {
            return toFirstLetterUprCaseAdd(str);
        }
    }

    public static void uninstallAppWithCallback(Activity activity, String str) {
        Intent intent = new Intent("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + str));
        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
        intent.putExtra("packageName", str);
        activity.startActivityForResult(intent, UNINSTALL_REQUEST_CODE);
    }
}
