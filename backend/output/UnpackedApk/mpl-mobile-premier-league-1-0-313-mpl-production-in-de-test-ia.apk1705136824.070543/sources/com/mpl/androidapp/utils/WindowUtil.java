package com.mpl.androidapp.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Window;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.badlogic.gdx.graphics.GL20;
import com.google.gson.Gson;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;

public class WindowUtil {
    public static final String TAG = "WindowUtil";

    public static float convertDpToPixel(float f2, Context context) {
        return (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * f2;
    }

    public static float convertPixelsToDp(float f2, Context context) {
        return f2 / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public static int dpToPx(float f2, Context context) {
        return (int) TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    public static int dpToSp(float f2, Context context) {
        return (int) (((float) dpToPx(f2, context)) / context.getResources().getDisplayMetrics().scaledDensity);
    }

    public static String getDeviceDensity(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        if (i == 120) {
            return "0.75 ldpi";
        }
        if (i == 160) {
            return "1.0 mdpi";
        }
        if (i == 240) {
            return "1.5 hdpi";
        }
        if (i == 320) {
            return "2.0 xhdpi";
        }
        if (i != 480) {
            return i != 640 ? "Not found" : "4.0 xxxhdpi";
        }
        return "3.0 xxhdpi";
    }

    public static int getHeightOfDevice(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static String getScreeDisplayMetrics(Activity activity) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return new Gson().toJson((Object) displayMetrics);
        } catch (Exception e2) {
            MLogger.e(TAG, "getScreeDisplayMetrics: ", e2);
            return "";
        }
    }

    public static String getScreenDensity(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        if (i == 120) {
            return "LDPI";
        }
        if (i == 160) {
            return "MDPI";
        }
        if (i == 240) {
            return "HDPI";
        }
        if (i == 320) {
            return "XHDPI";
        }
        if (i != 480) {
            return i != 640 ? String.valueOf(i) : "XXXHDPI";
        }
        return "XXHDPI";
    }

    public static int getSystemStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : identifier;
    }

    public static int getWidthOfDevice(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static void hideWindowStatusBar(Window window) {
        window.clearFlags(PDChoice.FLAG_COMMIT_ON_SEL_CHANGE);
        window.getDecorView().setSystemUiVisibility(GL20.GL_INVALID_ENUM);
        window.addFlags(LinearLayoutManager.INVALID_OFFSET);
        window.setStatusBarColor(0);
    }

    public static void printDeviceHeightWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        MLogger.d(TAG, "printDeviceHeightWidth: ", displayMetrics.toString());
        MLogger.d(TAG, "printDeviceHeightWidth: ", new Gson().toJson((Object) displayMetrics));
        MLogger.d(TAG, "printDeviceHeightWidth:densityDpi ", Integer.valueOf(displayMetrics.densityDpi));
        MLogger.d(TAG, "printDeviceHeightWidth:scaledDensity ", Float.valueOf(displayMetrics.scaledDensity));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
        if (r0.equals("IN") != false) goto L_0x0061;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setCustomTheme(android.app.Activity r9) {
        /*
            java.lang.String r0 = com.mpl.androidapp.utils.MBuildConfigUtils.getCountryCode()
            java.lang.String r1 = com.mpl.androidapp.utils.CountryUtils.getSplashImage()
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "setCustomTheme:countryCode "
            r4 = 0
            r2[r4] = r3
            r3 = 1
            r2[r3] = r0
            java.lang.String r5 = "splashImage: "
            r6 = 2
            r2[r6] = r5
            r5 = 3
            r2[r5] = r1
            java.lang.String r5 = "WindowUtil"
            com.mpl.androidapp.utils.MLogger.d(r5, r2)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            r5 = 2132017168(0x7f140010, float:1.9672607E38)
            if (r2 == 0) goto L_0x002d
            r9.setTheme(r5)
            goto L_0x0079
        L_0x002d:
            java.lang.String r0 = r0.toUpperCase()
            r2 = -1
            int r7 = r0.hashCode()
            r8 = 2341(0x925, float:3.28E-42)
            if (r7 == r8) goto L_0x0057
            r4 = 2718(0xa9e, float:3.809E-42)
            if (r7 == r4) goto L_0x004d
            r4 = 2816(0xb00, float:3.946E-42)
            if (r7 == r4) goto L_0x0043
            goto L_0x0060
        L_0x0043:
            java.lang.String r4 = "XX"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0060
            r4 = 1
            goto L_0x0061
        L_0x004d:
            java.lang.String r4 = "US"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0060
            r4 = 2
            goto L_0x0061
        L_0x0057:
            java.lang.String r7 = "IN"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            r4 = -1
        L_0x0061:
            if (r4 == 0) goto L_0x0076
            if (r4 == r3) goto L_0x006f
            if (r4 == r6) goto L_0x006b
            r9.setTheme(r5)
            goto L_0x0079
        L_0x006b:
            setUsaTheme(r9, r1)
            goto L_0x0079
        L_0x006f:
            r0 = 2132017177(0x7f140019, float:1.9672625E38)
            r9.setTheme(r0)
            goto L_0x0079
        L_0x0076:
            setIndiaTheme(r9, r1)
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.WindowUtil.setCustomTheme(android.app.Activity):void");
    }

    public static void setDefaultLanguage(String str) {
        MLogger.d(TAG, "setDefaultLanguage: ", str);
    }

    public static void setIndiaTheme(Activity activity, String str) {
    }

    public static void setUsaTheme(Activity activity, String str) {
    }

    public static int spToPx(float f2, Context context) {
        return (int) TypedValue.applyDimension(2, f2, context.getResources().getDisplayMetrics());
    }
}
